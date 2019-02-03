from repository import BaseSQL as bq


class ArtistSQL(bq.BaseSQL):
    @property
    def table_name(self):
        return "artist"

    def insert_artist(self, name: str, nick: str, email: str, password: str) -> str:
        return "insert into %s (name_%s, nick_%s, email_%s, password_%s) values ('%s', '%s', " \
               "'%s', md5('%s');" % (
                   self.table_name, self.table_name, self.table_name, self.table_name,
                   self.table_name, name, nick, email, password)
