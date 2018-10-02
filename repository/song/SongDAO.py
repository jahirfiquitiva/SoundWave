from models import Song as so
from repository import BaseDAO as bdao
from repository.song import SongSQL as sosql


class SongDAO(bdao.BaseDAO):
    def __init__(self):
        super().__init__()
        self.sql = sosql.SongSQL()

    def get_insert_query(self, song: so.Song, genre_id: int, album_id: int):
        return self.sql.insert_song(
            song.name, song.track, song.length, song.path, genre_id, album_id)
