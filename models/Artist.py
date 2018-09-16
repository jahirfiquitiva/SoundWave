class Artist(object):
    def __init__(self, id, name, nick, password, email):
        self._id: int = id
        self._name: str = name
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
    def nick(self) -> str:
        return self._nick

    @property
    def password(self) -> str:
        return self._password

    @property
    def email(self) -> str:
        return self._email

    def validate(self, other_password: str) -> bool:
        return self._password.lower() == other_password.lower()
