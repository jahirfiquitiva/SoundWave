from abc import ABC

from models import Genre as genre
from typing import Optional
from repository.genre import GenreDAO as genreDao
from managers import BaseManager as bm
from managers.BaseManager import DAO, T


class GenresManager(bm.BaseManager, ABC):

    def __init__(self):
        super().__init__()

    def get_genres(self) -> Optional[T]:
        return self.items

    def add_genre(self, name: str, img_path: str):
        self.dao().insert(genre.Genre(0, name, img_path))

    def delete_genre(self, genre_id: int):
        al = self.find_item(genre_id)
        if al is None:
            return False
        return self.remove_item(al)

    def modify_genre(self, genre_id: int, name: str, img_path):
        self.dao().update_executor(
            "update genre set("
            "name_genre='%s',"
            "img_path_genre='%s',) where id_genre='%d'" %
            (name, img_path, genre_id))

    def dao(self) -> DAO:
        return genreDao.GenreDAO()
