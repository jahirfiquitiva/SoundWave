from models import Artist as art
from repository import BaseDAO as bdao
from repository.artist import ArtistSQL as artsql


class ArtistDAO(bdao.BaseDAO):

    def __init__(self):
        super().__init__()
        self._sql = artsql.ArtistSQL()

    def get_insert_query(self, artist: art.Artist) -> str:
        return artsql.ArtistSQL.insert_artist(artist.name, artist.nick, artist.password,
                                              artist.email)
