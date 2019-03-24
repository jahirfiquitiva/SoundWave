from api import BaseAPI as bapi
from managers import GenresManager as gen


# noinspection PyMethodMayBeStatic
class GenresAPI(bapi.BaseAPI):
    @property
    def manager(self) -> gen.GenresManager:
        return gen.GenresManager()

    def get(self):
        try:
            self.manager.load()
            return self.create_response(
                {"success": True, "genres": self.manager.get_items_as_json()})
        except Exception as e:
            return self.create_error_response(e)

    def post(self, request):
        try:
            request_json = request.get_json(True)
            new_genre_name = request_json['name']
            if self.manager.create(new_genre_name, request_json['img_path']):
                added_genre = self.manager.find_item(new_genre_name)
                if added_genre is not None:
                    return self.create_response({"success": True, "genre": added_genre.as_json()})
                else:
                    return self.create_error_response("Couldn't find the new genre")
            else:
                return self.create_error_response("Couldn't create genre")
        except Exception as e:
            return self.create_error_response(e)
"""
    def update(self, request):
        try:
            request_json = request.get_json(True)
            genre_name = request_json['name']
            # TODO
            return self.create_error_response("Couldn't update genre with name \"%s\"" % genre_name)
        except Exception as e:
            return self.create_error_response(e)
"""