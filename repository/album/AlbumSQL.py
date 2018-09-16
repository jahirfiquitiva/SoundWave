from repository import BaseSQL as bq


class AlbumSQL(bq.BaseSQL):

    def insert_album(self,_id,_name,_img_path_album ,_release_year_album,_artist_id_artist):

        return "insert into %s values(%s,%s,%s,%s,%s);" % (
            self.table_name(), _id, _name, _img_path_album, _release_year_album, _artist_id_artist)

    def table_name(self):
        return "album"

    def abc(self):
        pass
