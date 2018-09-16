from repository import BaseSQL as bq


class ArtistSQL(bq.BaseSQL):

    def insert_artist(self, _id, _name, _nick, _password, _email):
        return "insert into %s values (%s,%s,%s,%s,%s);" % (self.table_name(), _id, _name, _nick, _password, _email)

    def table_name(self):
        return "artist"
