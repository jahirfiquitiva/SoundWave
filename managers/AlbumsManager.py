from typing import Optional

from managers import BaseManager as bm
from models import Album as al
from repository.album import AlbumDAO as aldao


class AlbumsManager(bm.BaseManager):
    def __init__(self):
        super().__init__()

    def create(self, name: str, img_path: str, release_year: int, artist_id: int) -> bool:
        created = self.dao.insert(
            self.dao.get_insert_query(al.Album(0, name, img_path, release_year, artist_id),
                                      artist_id))
        if created:
            self.load()
            return True
        return False

    def update(self, album_id: int, name: str, img_path: str, release_year: int,
               artist_id: int) -> bool:
        updated = self.dao.update_executor(
            "update %s set name_%s='%s', img_path_%s='%s', release_year_%s='%d', "
            "artist_id_artist='%d' where id_%s='%d'" %
            (self.dao.sql.table_name,
             self.dao.sql.table_name, name, self.dao.sql.table_name, img_path,
             self.dao.sql.table_name, release_year, album_id,
             self.dao.sql.table_name, artist_id))
        if updated:
            self.load()
            return True
        return False

    def delete(self, album_id: int) -> bool:
        if self.dao.delete(album_id):
            self.load()
            return True
        return False

    # noinspection PyBroadException
    def tuple_to_item(self, tuple_ref: tuple) -> Optional[al.Album]:
        try:
            return al.Album(tuple_ref[0], tuple_ref[1], tuple_ref[2], tuple_ref[3], tuple_ref[4])
        except Exception:
            pass
        return None

    def find_item_by_id(self, album_id: int) -> Optional[al.Album]:
        for item in self.get_items():
            if item.id == album_id:
                return item
        return None

    def find_item(self, s: str) -> Optional[al.Album]:
        for item in self.get_items():
            if s.strip().lower() in item.name.strip().lower():
                return item
        return None

    def find_all_items(self, s: str) -> [Optional[al.Album]]:
        found = []
        for item in self.get_items():
            if s.strip().lower() in item.name.strip().lower():
                found.append(item)
        return found

    @property
    def dao(self) -> aldao.AlbumDAO:
        return aldao.AlbumDAO()
