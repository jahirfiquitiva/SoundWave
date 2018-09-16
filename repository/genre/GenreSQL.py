from repository import BaseSQL as bq


class GenreSQL(bq.BaseSQL):

    def insert_genre(self,_id,_name,_img_path_genre):
        return "insert into %s values (%s,%s,%s);" % (self.table_name(), _id, _name, _name)

    def table_name(self):
        return "genre"

    def abc(self):
        pass
