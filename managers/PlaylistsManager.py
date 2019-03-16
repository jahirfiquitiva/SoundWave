from typing import Optional

from managers import BaseManager as bm
from models import Playlist as pl
from models import Song as so
from repository.playlist import PlaylistDAO as pldao


# noinspection PyBroadException
class PlaylistsManager(bm.BaseManager):
    def __init__(self):
        super().__init__()

    def create(self, name: str, user_id: int) -> bool:
        created = self.dao.insert(
            self.dao.get_insert_query(pl.Playlist(0, name, user_id), user_id))
        if created:
            self.load()
            return True
        return False

    def update(self, playlist_id: int, name: str, user_id: int) -> bool:
        updated = self.dao.update_executor(
            "update %s set name_%s='%s', user_id_user='%d' where id_%s='%d'" % (
                self.dao.sql.table_name,
                self.dao.sql.table_name, name, user_id,
                self.dao.sql.table_name, playlist_id
            ))
        if updated:
            self.load()
            return True
        return False

    def delete(self, playlist_id: int) -> bool:
        if self.dao.delete(playlist_id):
            self.load()
            return True
        return False

    def get_user_playlists(self, user_id: int) -> [pl.Playlist]:
        result = self.dao.query_executor(
            "select * from %s where user_id_user=%d" % (self.dao.sql.table_name, user_id))
        user_playlists = []
        if result is not None and len(result) > 0:
            for q_tuple in result:
                item = self.tuple_to_item(q_tuple)
                if item is not None:
                    user_playlists.append(item)
        return user_playlists

    def get_playlist_songs(self, playlist_id: int) -> [so.Song]:
        results = self.dao.query_executor(
            "select * from song so "
            "inner join %s_has_song pl "
            "on pl.song_id_song = so.id_song "
            "where pl.%s_id_%s = %d;" % (
                self.dao.sql.table_name,
                self.dao.sql.table_name, self.dao.sql.table_name, playlist_id)
        )
        playlist_songs = []
        if results is not None:
            try:
                for tuple_ref in results:
                    playlist_songs.append(so.Song(tuple_ref[0], tuple_ref[1], tuple_ref[2],
                                                  tuple_ref[3], tuple_ref[4], tuple_ref[5],
                                                  tuple_ref[6]))
            except Exception:
                pass
        return playlist_songs

    def get_song_playlists(self, song_id: int) -> [pl.Playlist]:
        results = self.dao.query_executor(
            "select * from %s pl "
            "inner join %s_has_song pls "
            "on pls.%s_id_%s = pl.id_%s "
            "where pls.song_id_song = %d;" %
            (self.dao.sql.table_name, self.dao.sql.table_name,
             self.dao.sql.table_name, self.dao.sql.table_name,
             self.dao.sql.table_name, song_id)
        )
        playlists = []
        if results is not None:
            try:
                for tuple_ref in results:
                    item = self.tuple_to_item(tuple_ref)
                    if item is not None:
                        playlists.append(item)
            except Exception:
                pass
        return playlists

    def add_song_to_playlist(self, playlist_id: int, song_id: int) -> bool:
        return self.dao.update_executor(
            "insert into %s_has_song values (%d, %d)" % (
                self.dao.sql.table_name, playlist_id, song_id))

    def add_song_to_new_playlist(self, name: str, user_id: int, song_id: int) -> bool:
        playlist = self.find_item(name)
        if playlist is not None:
            return self.add_song_to_playlist(playlist.id, song_id)
        else:
            self.create(name, user_id)
            return self.add_song_to_new_playlist(name, user_id, song_id)

    def remove_song_from_playlist(self, playlist_id: int, song_id: int) -> bool:
        return self.dao.update_executor(
            "delete from %s_has_song where %s_id_%s=%d and song_id_song=%d" %
            (self.dao.sql.table_name, self.dao.sql.table_name, self.dao.sql.table_name,
             playlist_id, song_id))

    def tuple_to_item(self, tuple_ref: tuple) -> Optional[pl.Playlist]:
        try:
            return pl.Playlist(tuple_ref[0], tuple_ref[1], tuple_ref[2])
        except Exception:
            pass
        return None

    def find_item_by_id(self, playlist_id: int) -> Optional[pl.Playlist]:
        for item in self.get_items():
            if item.id == playlist_id:
                return item
        return None

    def find_item(self, s: str) -> Optional[pl.Playlist]:
        for item in self.get_items():
            if item.name.lower() == s.lower():
                return item
        return None

    @property
    def dao(self) -> pldao.PlaylistDAO:
        return pldao.PlaylistDAO()
