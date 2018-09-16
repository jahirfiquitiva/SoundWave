from models import Song as sog
from repository import BaseDAO as bdao
from repository.song import SongSQL as soql


class UserDAO(bdao.BaseDAO):
    def __init__(self):
        super().__init__()
        self._sql = soql.SongSQL()

    def get_insert_query(self, song: sog.Song):
        return soql.SongSQL.insert_song(song.name, song.track, song.length, song.path)