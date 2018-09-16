from repository import BaseSQL as bq


class GenreSQL(bq.BaseSQL):

    def table_name(self) -> str:
        return "genre"

    def insert_genre(self, name: str, img_path_genre: str) -> str:
        return "insert into %s (name_%s, img_path_genre_%s)" \
               "values (%s, %s);" % (self.table_name, self.table_name, self.table_name, name, img_path_genre)
