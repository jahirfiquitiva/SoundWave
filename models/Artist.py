class Artist(object):
    def __init__(self, id, name, nick, password, email):
        self._id = id
        self._name = name
        self._nick = nick
        self._password = password
        self._email = email

    def get_id(self):
        return self._id

    def set_id(self, id):
        self._id = id

    def get_name(self):
        return self._name

    def set_name(self, name):
        self._name = name

    def get_nick(self):
        return self._nick

    def set_nick(self, nick):
        self._nick = nick

    def get_password(self):
        return self._password

    def set_password(self, password):
        self._password = password

    def get_email(self):
        return self._email

    def set_email(self, email):
        self._email = email
