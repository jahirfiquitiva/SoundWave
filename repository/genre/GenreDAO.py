from models import Genre as ge
from repository import BaseDAO as bdao
from repository.genre import GenreSQL as gesql


class GenreDAO(bdao.BaseDAO):
    def __init__(self):
        super().__init__()
        self._sql = gesql.GenreSQL()

    def get_insert_query(self, gen: ge.Genre):
        return gesql.GenreSQL.insert_genre(gen._id, gen._name, gen._img_path_genre)
