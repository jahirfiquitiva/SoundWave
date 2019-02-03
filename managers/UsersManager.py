from typing import Optional
from models import User as us
from repository.user import UserDAO as udao
from managers import BaseManager as bm


class UsersManager(bm.BaseManager):
    def __init__(self):
        super().__init__()

    def create(self, name: str, last_name: str, age: int, nick: str,
               email: str, password: str) -> bool:
        created = self.dao.insert(
            self.dao.get_insert_query(
                us.User(0, name, last_name, age, nick, email, password)))
        if created:
            self.load()
            return True
        return False

    def update(self, user_id: int, name: str, last_name: str, age: int,
               nick: str, email: str, password: str) -> bool:
        updated = self.dao.update_executor(
            "update %s set name_%s='%s', last_name_%s='%s', "
            "age_%s=%d, nick_%s='%s', email_%s='%s', "
            "password_%s=md5('%s') where id_%s=%d;" %
            (self.dao.sql.table_name,
             self.dao.sql.table_name, name,
             self.dao.sql.table_name, last_name,
             self.dao.sql.table_name, age,
             self.dao.sql.table_name, nick,
             self.dao.sql.table_name, email,
             self.dao.sql.table_name, password,
             self.dao.sql.table_name, user_id))
        if updated:
            self.load()
            return True
        return False

    def delete(self, user_id: int) -> bool:
        if self.dao.delete(user_id):
            self.load()
            return True
        return False

    # noinspection PyBroadException
    def tuple_to_item(self, tuple_ref: tuple) -> Optional[us.User]:
        try:
            return us.User(tuple_ref[0], tuple_ref[1], tuple_ref[2], tuple_ref[3], tuple_ref[4],
                           tuple_ref[6], tuple_ref[5])
        except Exception:
            pass
        return None

    def find_item_by_id(self, user_id: int) -> Optional[us.User]:
        for item in self.get_items():
            if item.id == user_id:
                return item
        return None

    def find_item(self, s: str) -> Optional[us.User]:
        for item in self.get_items():
            if s.strip().lower() in item.nick.strip().lower():
                return item
        return None

    @property
    def dao(self) -> udao.UserDAO:
        return udao.UserDAO()
