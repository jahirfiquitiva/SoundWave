from models import User as us
from repository import BaseDAO as bdao
from repository.user import UserSQL as usql


class UserDAO(bdao.BaseDAO):
    def __init__(self):
        super().__init__()
        self._sql = usql.UserSQL()

    def get_insert_query(self, use: us.User):
        return usql.UserSQL.insert_user(use._id, use._name, use._last_name, use._age, use._nick, use._password,
                                        use._email)
