from models import Album as alb
from repository import BaseDAO as bdao
from repository.album import AlbumSQL as alsql


class AlbumDAO(bdao.BaseDAO):
    def __init__(self):
        super().__init__()
        self._sql = alsql.AlbumSQL()

    def get_insert_query(self, album: alb.Album):
        return alsql.AlbumSQL.insert_album(self, album._id, album._name, album._img_path_album,
                                           album._release_year_album, album._artist_id_artist)
