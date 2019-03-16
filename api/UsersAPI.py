from typing import Optional
from api import BaseAPI as bapi
from managers import UsersManager as uman


class UsersAPI(bapi.BaseAPI):
    @property
    def manager(self) -> uman.UsersManager:
        return uman.UsersManager()

    def get(self):
        self.manager.load()
        return self.create_response({"success": True, "users": self.manager.get_items()})
