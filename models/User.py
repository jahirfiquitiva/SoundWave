class User(object):
    def __init__(self, id: int, name: str, last_name: str, age: int, nick: str, password: str, email: str):
        self._id: int = id
        self._name: str = name
        self._last_name: str = last_name
        self._age: int = age
        self._nick: str = nick
        self._password: str = password
        self._email: str = email

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

    def validate(self, other_password: str) -> bool:
        return self._password.lower() == other_password.lower()
