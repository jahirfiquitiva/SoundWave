from typing import Optional
from models import Artist as ar
from repository.artist import ArtistDAO as ardao
from managers import BaseManager as bm


class ArtistsManager(bm.BaseManager):
    def __init__(self):
        super().__init__()

    def create(self, name: str, nick: str, email: str, password: str) -> bool:
        created = self.dao.insert(
            self.dao.get_insert_query(ar.Artist(0, name, nick, email, password)))
        if created:
            self.load()
            return True
        return False

    def update(self, artist_id: int, name: str, nick: str, email: str, password: str) -> bool:
        updated = self.dao.update_executor(
            "update %s set name_%s='%s', nick_%s='%s', email_%s='%s', password_%s=md5('%s') where "
            "id_%s='%d'" % (
                self.dao.sql.table_name,
                self.dao.sql.table_name, name, self.dao.sql.table_name, nick,
                self.dao.sql.table_name, email, self.dao.sql.table_name, password,
                self.dao.sql.table_name, artist_id))
        if updated:
            self.load()
            return True
        return False

    def delete(self, artist_id: int) -> bool:
        if self.dao.delete(artist_id):
            self.load()
            return True
        return False

    # noinspection PyBroadException
    def tuple_to_item(self, tuple_ref: tuple) -> Optional[ar.Artist]:
        try:
            return ar.Artist(tuple_ref[0], tuple_ref[1], tuple_ref[2], tuple_ref[4], tuple_ref[3])
        except Exception:
            pass
        return None

    def find_item_by_id(self, artist_id: int) -> Optional[ar.Artist]:
        for item in self.get_items():
            if item.id == artist_id:
                return item
        return None

    def find_item(self, s: str) -> Optional[ar.Artist]:
        for item in self.get_items():
            if s.strip().lower() in item.nick.strip().lower():
                return item
        return None

    @property
    def dao(self) -> ardao.ArtistDAO:
        return ardao.ArtistDAO()
