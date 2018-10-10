from typing import Optional
from models import Artist as artist
from repository.artist import ArtistDAO as artistDao
from managers import BaseManager as bm
from managers.BaseManager import DAO, T


class ArtistsManager(bm.BaseManager):

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

    def get_artists(self) -> Optional[T]:
        return self.items

    def add_artist(self, name: str, nick: str, email: str, password: str):
        self.dao.insert(artist.Artist(0, name, nick, email, password))

    def delete_artist(self, artist_id: int):
        self.load()
        ar = self.find_item(artist_id)
        if ar is None:
            return False
        return self.remove_item(ar)

    def modify_artist(self, artist_id: int, name: str, nick: str, email: str, password: str):
        self.dao.update_executor(
            "update %s set("
            "name_artist='%s',"
            "nick_artist='%s',"
            "email_artist='%s',"
            "password_artist='%s') where id_artist='%d'" %
            (self.dao.sql.table_name, name, nick, email, password, artist_id))

    def dao(self) -> DAO:
        return artistDao.ArtistDAO()
