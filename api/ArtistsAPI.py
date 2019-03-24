from api import BaseAPI as bapi
from managers import ArtistsManager as art


class ArtistsAPI(bapi.BaseAPI):

    @property
    def manager(self) -> art.ArtistsManager:
        return art.ArtistsManager()

    def get(self):
        try:
            self.manager.load()
            return self.create_response(
                {"success": True, "artists": self.manager.get_items_as_json()})
        except Exception as e:
            return self.create_error_response(e)

    def post(self, request):
        try:
            request_json = request.get_json(True)
            new_artist_nick = request_json['nick']
            if self.manager.create(request_json['name'], new_artist_nick, request_json['photo'],
                                   request_json['email'], request_json['password']):
                added_artist = self.manager.find_item(new_artist_nick)
                if added_artist is not None:
                    return self.create_response({"success": True, "artist": added_artist.as_json()})
                else:
                    return self.create_error_response("Couldn't find the new artist")
            else:
                return self.create_error_response("Couldn't create artist")
        except Exception as e:
            return self.create_error_response(e)
