from typing import Optional
from models import User as u
from repository.user import UserDAO as udao
from managers import BaseManager as bm
from managers.BaseManager import DAO, T


class UsersManager(bm.BaseManager):
    def __init__(self):
        super().__init__()

    def add_new_user(self, name: str, last_name: str, age: int, nick: str,
                     email: str, password: str) -> bool:
        return self.dao.insert(
            self.dao.get_insert_query(
                u.User(0, name, last_name, age, nick, email, password)))

    def find_item(self, user_id: int) -> Optional[T]:
        for item in self.items:
            if item.id == user_id:
                return item
        return None

    def find_item(self, s: str) -> Optional[T]:
        for item in self.items:
            if item.nick.lower() == s.lower():
                return item
        return None

    def get_users(self) -> []:
        return self.items

    def load(self):
        self.clear_list()
        for item in self.dao.query():
            self.add_item(item)

    def modify_user(self, user_id: int, name: str, last_name: str, age: int,
                    nick: str, email: str, password: str):
        self.dao.update_executor(
            "update %s set(name_%s='%s', last_%s='%s', "
            "age_%s='%d', nick_%s='%s', email_%s='%s', "
            "password_%s='%s' ) where id_%s= '%d';" %
            (self.dao.sql.table_name,
             self.dao.sql.table_name, name,
             self.dao.sql.table_name, last_name,
             self.dao.sql.table_name, age,
             self.dao.sql.table_name, nick,
             self.dao.sql.table_name, email,
             self.dao.sql.table_name, password,
             self.dao.sql.table_name, user_id))

    def delete_user(self, user_id: int) -> bool:
        user = self.find_item(user_id)
        if user is None:
            return False
        return self.remove_item(user)

    @property
    def dao(self) -> DAO:
        return udao.UserDAO()
