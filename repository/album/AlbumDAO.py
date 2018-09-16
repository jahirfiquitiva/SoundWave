from models import Album as alb
from repository import BaseDAO as bdao
from repository.album import AlbumSQL as alsql


class AlbumDAO(bdao.BaseDAO):
    def __init__(self):
        super().__init__()
        self._sql = alsql.AlbumSQL()

    def get_insert_query(self, album: alb.Album) -> str:
        return self._sql.insert_album(album.name, album.img_path,
                                      album.release_year, album.artist_id)
