from typing import Optional
from models import User as u
from repository.user import UserDAO as udao
from managers import BaseManager as bm
from managers.BaseManager import DAO, T


class UsersManager(bm.BaseManager):
    def __init__(self):
        super().__init__()

    def add_new_user(self, name: str, last_name: str, age: int, nick: str, email: str,
                     password: str) -> bool:
        return self.dao.insert(
            self.dao.get_insert_query(u.User(0, name, last_name, age, nick, email, password)))

    def find_item(self, id: int) -> Optional[T]:
        for item in self.items:
            if item.id == id:
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

    def delete_user(self, id: int) -> bool:
        user = self.find_item(id)
        if user is None:
            return False
        return self.remove_item(user)

    @property
    def dao(self) -> DAO:
        return udao.UserDAO()
