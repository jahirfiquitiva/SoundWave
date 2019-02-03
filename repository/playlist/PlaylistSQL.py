from repository import BaseSQL as bq


class PlaylistSQL(bq.BaseSQL):
    @property
    def table_name(self) -> str:
        return "playlist"

    def insert_playlist(self, name: str, user_id: int) -> str:
        return "insert into %s (name_%s,user_id_%s) values ('%s', '%s');" % (
            self.table_name, self.table_name, self.table_name, name, user_id)

    def query_by_user_id(self, user_id: int) -> str:
        return "select * from %s (user_id_%s) where user_id_user='%s';" % (
            self.table_name, self.table_name, user_id)
