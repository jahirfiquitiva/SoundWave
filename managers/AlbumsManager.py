from typing import Optional
from models import Album as album
from repository.album import AlbumDAO as albumDao
from managers import BaseManager as bm
from managers.BaseManager import DAO, T


class AlbumsManager(bm.BaseManager):

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

    def get_albums(self) -> Optional[T]:
        return self.items

    def add_album(self,
                  name: str, img_path: str, release_year: int,
                  artist_id: int):
        self.dao.insert(album.Album(0, name, img_path, release_year))

    def delete_album(self, album_id: int):
        self.load()
        al = self.find_item(album_id)
        if al is None:
            return False
        return self.remove_item(al)

    def modify_album(self, album_id: int, name: str, img_path: str, release_year: int,
                     artist_id: int):
        self.dao.update_executor(
            "update %s set("
            "name_album='%s',"
            "img_path_album='%s',"
            "release_year_album='%d',"
            "artist_id_artist='%d') where id_album='%d'" %
            (self.dao.sql.table_name, name, img_path, release_year, album_id, artist_id))

    def dao(self) -> DAO:
        return albumDao.AlbumDAO()
