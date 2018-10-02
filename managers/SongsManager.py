from abc import ABC
from typing import Optional
from models import Song as song
from repository.song import SongDAO as songDao
from managers import BaseManager as bm
from managers.BaseManager import DAO, T


class SongsManager(bm.BaseManager, ABC):

    def __init__(self):
        super().__init__()

    def get_songs(self) -> []:
        return self.items

    def add_song(self, name: str, track: int, length: int, path: str, gener_id: int, albun_id: int):
        return self.dao.get_insert_query(song.Song(
            0, name, track, length, path), gener_id, albun_id)

    def find_item(self, song_id: int) -> Optional[T]:
        for item in self.items:
            if item.id == song_id:
                return item
        return None

    def delete_song(self, song_id: int) -> bool:
        result = self.find_item(song_id)
        if result is not None:
            return self.remove_item(result)
        return False

    def modify_song(self, song_id: int, name: str, track: int, length: int, path: str,
                    album_id: int):
        return self.dao.update_executor(
            "update song set("
            "name_song='%s'"
            ", track_song='%d'"
            ", length_song='%d'"
            ", path_song='%s',"
            " album_id_album='%d') where id_song='%d'" % (
                name,
                track,
                length,
                path,
                album_id,
                song_id
            ))

    @property
    def dao(self) -> DAO:
        return songDao.SongDAO()
