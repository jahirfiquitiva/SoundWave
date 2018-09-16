from repository import BaseSQL as bq


# from Crypto.Hash import MD5 ---> fro passwoord

class UserSQL(bq.BaseSQL):

    def insert_user(self, _id, _name, _last_name, _age, _nick, _password, _email):

        return "insert into %s values( %s,%s,%s,%s,%s,%s,%s);" % (
            self.table_name(), _id, _name, _last_name, _age, _nick, _password, _email)

    def table_name(self):
        return "user"

    def abc(self):
        pass
