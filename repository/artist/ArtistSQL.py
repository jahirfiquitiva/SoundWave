from repository import BaseSQL as bq


class ArtistSQL(bq.BaseSQL):
    def table_name(self):
        return "artist"

    def insert_artist(self, name: str, nick: str, password: str, email: str)->str:
        return "insert into %s (name_%s,nick_%s,password_%s, email_%s) " \
               "values (%s,%s,%s,%s);" % (
                   self.table_name, self.table_name, self.table_name, self.table_name, self.table_name,
                   name, nick, password, email)
