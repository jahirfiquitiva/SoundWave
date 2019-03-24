from api import BaseAPI as bapi
from managers import PlaylistsManager as play


# noinspection PyMethodMayBeStatic
class PlaylistsAPI(bapi.BaseAPI):
    @property
    def manager(self) -> play.PlaylistsManager:
        return play.PlaylistsManager()

    def get(self):
        try:
            self.manager.load()
            return self.create_response(
                {"success": True, "playlist": self.manager.get_items_as_json()})
        except Exception as e:
            return self.create_error_response(e)

    def post(self, request):
        try:
            request_json = request.get_json(True)
            new_playlist_name = request_json['name']
            if self.manager.create(new_playlist_name, int(request_json['user_id'])):
                added_playlist = self.manager.find_item(new_playlist_name)
                if added_playlist is not None:
                    return self.create_response({"success": True, "playlist": added_playlist.as_json()})
                else:
                    return self.create_error_response("Couldn't find the new playlist")
            else:
                return self.create_error_response("Couldn't create playlist")
        except Exception as e:
            return self.create_error_response(e)
"""
    def update(self, request):
        try:
            request_json = request.get_json(True)
            playlist_name = request_json['name']
            # TODO
            return self.create_error_response("Couldn't update playlist with name \"%s\"" % playlist_name)
        except Exception as e:
            return self.create_error_response(e)
"""