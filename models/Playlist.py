from models import BaseModel as bm


class Playlist(bm.BaseModel):
    def __init__(self, item_id: int, name: str, user_id: int):
        self._id: int = item_id
        self._name: str = name
        self._user_id: int = user_id

    @property
    def id(self) -> int:
        return self._id

    @property
    def name(self) -> str:
        return self._name

    @property
    def user_id(self) -> int:
        return self._user_id

    def as_json(self) -> {}:
        return {"id": self.id, "name": self.name, "userId": self.user_id}

    def __str__(self):
        return "Id: %d - Name: %s - UserId: %d" % (self.id, self.name, self.user_id)
