from api import BaseAPI as bapi
from managers import SongsManager as son


class SongsAPI(bapi.BaseAPI):

    @property
    def manager(self) -> son.SongsManager:
        return son.SongsManager()

    @property
    def response_key(self):
        return "song"

    def post(self, request):
        try:
            request_json = request.get_json(True)
            new_song_name = request_json['name']
            if self.manager.create(new_song_name, int(request_json['track']),
                                   int(request_json['length']), request_json['path'],
                                   int(request_json['genre_id']), int(request_json['album_id'])):
                added_song = self.manager.find_item(new_song_name)
                if added_song is not None:
                    return self.create_response({"success": True, "song": added_song.as_json()})
                else:
                    return self.create_error_response("Couldn't find the new song")
            else:
                return self.create_error_response("Couldn't create song")
        except Exception as e:
            return self.create_error_response(e)


"""
def update(self, request):
    try:
        request_json = request.get_json(True)
        song_id = request_json['id']
        return self.create_error_response("Couldn't update song with if \"%s\"" % song_id)
    except Exception as e:
        return self.create_error_response(e)
"""
