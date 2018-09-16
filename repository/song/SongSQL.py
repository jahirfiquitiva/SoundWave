from repository import BaseSQL as bq


class SongSQL(bq.BaseSQL):

    def insert_song(self, _id, _name, _track, _length, _path, _genre_id, _album_id):
        return "insert into %s values( %s,%s,%s,%s,%s,%s,%s);" % (
            self.table_name(), _id, _name, _track, _length, _path, _genre_id, _album_id)

    def table_name(self):
        return "song"

    def abc(self):
        pass
