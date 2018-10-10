from typing import Optional

from models import Playlist as playlist
from repository.playlist import PlaylistDAO as playlistDao
from repository.user import UserDAO as uDao
from managers import BaseManager as bm
from managers.BaseManager import DAO, T


# noinspection PyBroadException
class PlaylistsManager(bm.BaseManager):

    def find_item(self, user_id: int) -> Optional[T]:
        for item in self.items:
            if item.id == user_id:
                return item
        return None

    def __init__(self):
        super().__init__()
        self.user_dao = uDao.UserDAO()

    def load(self):
        self.internal_load(-1)

    def get_playlists(self) -> []:
        return self.items

    def internal_load(self, user_id: int):
        real_id = self.get_user_id(user_id)
        user = self.dao.query_by_user_id(real_id)
        if user_id is not None:
            self.clear_list()
            for item in user:
                self.add_item(item)

    def add_playlist(self, name: str, user_id: int):
        return self.dao.insert(
            self.dao.get_insert_query(playlist.Playlist(0, name), user_id))

    def add_favorite_playlist(self, user_id: int):
        result = self.dao.insert(
            self.dao.get_insert_query(playlist.Playlist(0, "Favorites"), user_id))
        self.load()
        return result

    def add_song_to_playlist(self, playlist_id: int, song_id: int) -> bool:
        result = self.dao.add_song_to_playlist(playlist_id, song_id)
        self.load()
        return result

    def add_song_to_favorites(self, song_id: int):
        self.add_song_to_playlist(self.get_favorites_playlist_id(), song_id)

    def get_favorites_playlist_id(self) -> int:
        result = self.dao.query(name="Favorites")
        if result is not None and len(result) > 0:
            return result[0].id
        return -1

    def modify_playlist(self, playlist_id: int, name: str):
        self.dao.update_executor("update %s set(name_%s='%s') where id_playlist_%s = '%d';" %
                                 (self.dao.sql.table_name, self.dao.sql.table_name, name, self.dao.sql.table_name, playlist_id))

    def delete_playlist(self, playlist_id: int):
        self.dao.update_executor("delete from playlist_has_song "
                                 "where playlist_id_playlist = '%d';", playlist_id)

    def get_user_id(self, idx: int) -> int:
        user_rs = self.user_dao.query(idx)
        if user_rs is not None and len(user_rs) > 0:
            return user_rs[0].id
        return -1

    @property
    def dao(self) -> DAO:
        return playlistDao.PlaylistDAO()
