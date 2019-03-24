from api import BaseAPI as bapi
from managers import AlbumsManager as alb


class AlbumAPI(bapi.BaseAPI):
    @property
    def manager(self) -> alb.AlbumsManager:
        return alb.AlbumsManager()

    def get(self):
        try:
            self.manager.load()
            return self.create_response(
                {"success": True, "albums": self.manager.get_items_as_json()})
        except Exception as e:
            return self.create_error_response(e)

    def post(self, request):
        try:
            request_json = request.get_json(True)
            new_album_name = request_json['name']
            if self.manager.create(new_album_name, request_json['img_path'], int(request_json['release_year']),
                                   int(request_json['artist_id'])):
                added_albums = self.manager.find_item(new_album_name)
                if added_albums is not None:
                    return self.create_response({"success": True, "album": added_albums.as_json()})
                else:
                    return self.create_error_response("Couldn't find the new album")
            else:
                return self.create_error_response("Couldn't create album")
        except Exception as e:
            return self.create_error_response(e)
"""
    def update(self, request):
        try:
            request_json = request.get_json(True)
            album_id = request_json['id']
            return self.create_error_response("Couldn't update album with id \"%s\"" % album_id)
        except Exception as e:
            return self.create_error_response(e)
"""