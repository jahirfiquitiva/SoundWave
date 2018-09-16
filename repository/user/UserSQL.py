from repository import BaseSQL as bq


class UserSQL(bq.BaseSQL):
    @property
    def table_name(self) -> str:
        return "user"

    def insert_user(self, name: str, last_name: str, age: int, nick: str, email: str, password: str) -> str:
        return "insert into %s (name_%s, last_name_%s, age_%s, nick_%s, email_%s, password_%s) " \
               "values(%s, %s, %s, %s, %s, md5('%s'));" % (
                   self.table_name, self.table_name, self.table_name, self.table_name,
                   self.table_name, self.table_name, self.table_name,
                   name, last_name, age, nick, email, password)
