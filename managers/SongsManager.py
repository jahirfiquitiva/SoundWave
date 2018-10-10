from typing import Optional
from models import Song as song
from repository.song import SongDAO as songDao
from managers import BaseManager as bm
from managers.BaseManager import DAO, T


class SongsManager(bm.BaseManager):

    def find_item(self, user_id: int) -> Optional[T]:
        for item in self.items:
            if item.id == user_id:
                return item
        return None

    def load(self):
        self.clear_list()
        for item in self.dao.query():
            self.add_item(item)

    def __init__(self):
        super().__init__()

    def get_songs(self) -> []:
        return self.items

    def add_song(self, name: str, track: int, length: int, path: str, gener_id: int, albun_id: int):
        return self.dao.get_insert_query(song.Song(
            0, name, track, length, path), gener_id, albun_id)

    def delete_song(self, song_id: int) -> bool:
        self.load()
        result = self.find_item(song_id)
        if result is not None:
            return self.remove_item(result)
        return False

    def modify_song(self, song_id: int, name: str, track: int, length: int, path: str,
                    album_id: int):
        return self.dao.update_executor(
            "update %s set("
            "name_song_%s='%s'"
            ", track_song_%s='%d'"
            ", length_song_%s='%d'"
            ", path_song_%s='%s',"
            " album_id_album_%s='%d') where id_song_%s='%d'" % (
                self.dao.sql.table_name,
                self.dao.sql.table_name, name,
                self.dao.sql.table_name, track,
                self.dao.sql.table_name, length,
                self.dao.sql.table_name, path,
                self.dao.sql.table_name, album_id,
                self.dao.sql.table_name, song_id
            ))

    @property
    def dao(self) -> DAO:
        return songDao.SongDAO()
