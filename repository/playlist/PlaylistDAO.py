from models import Playlist as pl
from repository import BaseDAO as bdao
from repository.playlist import PlaylistSQL as plsql


class PlaylistDAO(bdao.BaseDAO):
    def __init__(self):
        super().__init__()
        self.sql = plsql.PlaylistSQL()

    def get_insert_query(self, pla: pl.Playlist, user_id: int) -> str:
        return self.sql.insert_playlist(pla.name, user_id)

    def query_by_user_id(self, user_id: int) -> []:
        return self.query_executor(self.sql.query_by_user_id(user_id))

    def add_song_to_playlist(self, playlist_id: int, song_id: int) -> bool:
        return self.insert("insert into playlist_has_song values(%s, %s);" % (playlist_id, song_id))
