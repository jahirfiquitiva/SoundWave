from typing import Optional
from models import Song as so
from repository.song import SongDAO as sodao
from managers import BaseManager as bm


class SongsManager(bm.BaseManager):
    def __init__(self):
        super().__init__()

    def create(self, name: str, track: int, length: int, path: str, genre_id: int,
               album_id: int) -> bool:
        created = self.dao.insert(
            self.dao.get_insert_query(so.Song(0, name, track, length, path, genre_id, album_id),
                                      genre_id, album_id))
        if created:
            self.load()
            return True
        return False

    def update(self, song_id: int, name: str, track: int, length: int, path: str, genre_id: int,
               album_id: int) -> bool:
        updated = self.dao.update_executor(
            "update %s set name_%s='%s', track_%s='%d', length_%s='%d', path_%s='%s', "
            "genre_id_genre='%d', album_id_album='%d' where id_%s='%d'" % (
                self.dao.sql.table_name,
                self.dao.sql.table_name, name,
                self.dao.sql.table_name, track,
                self.dao.sql.table_name, length,
                self.dao.sql.table_name, path,
                genre_id, album_id,
                self.dao.sql.table_name, song_id
            ))
        if updated:
            self.load()
            return True
        return False

    def delete(self, song_id: int) -> bool:
        if self.dao.delete(song_id):
            self.load()
            return True
        return False

    # noinspection PyBroadException
    def tuple_to_item(self, tuple_ref: tuple) -> Optional[so.Song]:
        try:
            return so.Song(tuple_ref[0], tuple_ref[1], tuple_ref[2], tuple_ref[3], tuple_ref[4],
                           tuple_ref[5], tuple_ref[6])
        except Exception:
            pass
        return None

    def find_item_by_id(self, song_id: int) -> Optional[so.Song]:
        for item in self.get_items():
            if item.id == song_id:
                return item
        return None

    def find_item(self, s: str) -> Optional[so.Song]:
        for item in self.get_items():
            if s.strip().lower() in item.name.strip().lower():
                return item
        return None

    @property
    def dao(self) -> sodao.SongDAO:
        return sodao.SongDAO()
