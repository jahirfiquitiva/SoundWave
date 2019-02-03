from typing import Optional
from models import Playlist as pl
from repository.playlist import PlaylistDAO as pldao
from managers import BaseManager as bm


class PlaylistsManager(bm.BaseManager):
    def __init__(self):
        super().__init__()

    def create(self, name: str, user_id: int) -> bool:
        created = self.dao.insert(
            self.dao.get_insert_query(pl.Playlist(0, name, user_id), user_id))
        if created:
            self.load()
            return True
        return False

    def update(self, playlist_id: int, name: str, user_id: int) -> bool:
        updated = self.dao.update_executor(
            "update %s set name_%s='%s', user_id_user='%d' where id_%s='%d'" % (
                self.dao.sql.table_name,
                self.dao.sql.table_name, name, user_id,
                self.dao.sql.table_name, playlist_id
            ))
        if updated:
            self.load()
            return True
        return False

    def delete(self, playlist_id: int) -> bool:
        if self.dao.delete(playlist_id):
            self.load()
            return True
        return False

    # noinspection PyBroadException
    def tuple_to_item(self, tuple_ref: tuple) -> Optional[pl.Playlist]:
        try:
            return pl.Playlist(tuple_ref[0], tuple_ref[1], tuple_ref[2])
        except Exception:
            pass
        return None

    def find_item_by_id(self, playlist_id: int) -> Optional[pl.Playlist]:
        for item in self.get_items():
            if item.id == playlist_id:
                return item
        return None

    def find_item(self, s: str) -> Optional[pl.Playlist]:
        for item in self.get_items():
            if item.name.lower() == s.lower():
                return item
        return None

    @property
    def dao(self) -> pldao.PlaylistDAO:
        return pldao.PlaylistDAO()
