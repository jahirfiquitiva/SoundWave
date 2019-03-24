from models import User as us
from repository import BaseDAO as bdao
from repository.user import UserSQL as usql


class UserDAO(bdao.BaseDAO):
    def __init__(self):
        super().__init__()
        self.sql = usql.UserSQL()

    def get_insert_query(self, user: us.User):
        return self.sql.insert_user(user.name, user.last_name, user.age, user.nick, user.photo,
                                    user.email, user.password)
