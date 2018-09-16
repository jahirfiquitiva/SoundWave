class Artist(object):
    def __init__(self, id: int, name: str, nick: str, email: str, password: str):
        self._id: int = id
        self._name: str = name
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
