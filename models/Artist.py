from models import BaseModel as bm


class Artist(bm.BaseModel):
    def __init__(self, item_id: int, name: str, nick: str, photo: str, email: str, password: str):
        self._id: int = item_id
        self._name: str = name
        self._nick: str = nick
        self._photo: str = photo
        self._email: str = email
        self._password: str = password

    @property
    def id(self) -> int:
        return self._id

    @property
    def name(self) -> str:
        return self._name

    @property
    def nick(self) -> str:
        return self._nick

    @property
    def photo(self) -> str:
        return self._photo

    @property
    def email(self) -> str:
        return self._email

    @property
    def password(self) -> str:
        return self._password

    def as_json(self) -> {}:
        return {"id": self.id, "name": self.name, "nick": self.nick, "photo": self.photo,
                "email": self.email}

    def validate(self, other_password: str) -> bool:
        return self._password.lower() == other_password.lower()

    def __str__(self):
        return "Id: %d - Name: %s - Nick: %s - Foto: %s" % (
            self.id, self.name, self.nick, self.photo)
