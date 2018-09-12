class User(object):
    def __init__(self, id, name, last_name, age, nick, password, email):
        self._id = id
        self._name = name
        self._last_name = last_name
        self._age = age
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

    def get_last_name(self):
        return self._last_name

    def set_last_name(self, last_name):
        self._last_name = last_name

    def get_age(self):
        return self._age

    def set_age(self, age):
        self._age = age

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
