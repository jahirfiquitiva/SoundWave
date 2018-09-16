from repository import BaseSQL as bq


class PlayList(bq.BaseSQL):

    def insert_playlist(self, _id, _name, _user_id):
        return "insert into %s values ( %s,%s,%s);" % (self.table_name(), _id, _name, _user_id)

    def table_name(self):
        return "playlist"

    def query_by_user_id(self, user_id):
        return "select * from %s where user_id_user='%s';" % (self.table_name(), user_id)

    def abc(self):
        pass
