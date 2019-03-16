from models import BaseModel as bm


class User(bm.BaseModel):

    def __init__(self, item_id: int, name: str, last_name: str, age: int, nick: str, email: str,
                 password: str):
        self._id: int = item_id
        self._name: str = name
        self._last_name: str = last_name
        self._age: int = age
        self._nick: str = nick
        self._email: str = email
        self._password: str = password

    @property
    def id(self) -> int:
        return self._id

    @property
    def name(self) -> str:
        return self._name

    @property
    def last_name(self) -> str:
        return self._last_name

    @property
    def age(self) -> int:
        return self._age

    @property
    def nick(self) -> str:
        return self._nick

    @property
    def email(self) -> str:
        return self._email

    @property
    def password(self) -> str:
        return self._password

    def as_json(self) -> {}:
        return {"id": self.id, "name": self.name, "lastName": self.last_name, "age": self.age,
                "nick": self.nick, "email": self.email}

    def validate(self, other_password: str) -> bool:
        return self._password.lower() == other_password.lower()

    def __str__(self):
        return "Id: %d - Nombre: %s - Apellido: %s - Edad: %d - Nick: %s - Email: %s - Pass: %s" % (
            self.id, self.name, self.last_name, self.age, self.nick, self.email, self.password)
