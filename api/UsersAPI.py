from api import BaseAPI as bapi
from managers import UsersManager as uman


# noinspection PyMethodMayBeStatic
class UsersAPI(bapi.BaseAPI):
    @property
    def manager(self) -> uman.UsersManager:
        return uman.UsersManager()

    def get(self):
        try:
            self.manager.load()
            return self.create_response(
                {"success": True, "users": self.manager.get_items_as_json()})
        except Exception as e:
            return self.create_error_response(e)

    def post(self, request):
        try:
            request_json = request.get_json(True)
            new_user_nick = request_json['nick']
            if self.manager.create(request_json['name'], request_json['lastName'],
                                   int(request_json['age']), new_user_nick,
                                   request_json['email'], request_json['password']):
                added_user = self.manager.find_item(new_user_nick)
                if added_user is not None:
                    return self.create_response({"success": True, "user": added_user.as_json()})
                else:
                    return self.create_error_response("Couldn't find the new user")
            else:
                return self.create_error_response("Couldn't create user")
        except Exception as e:
            return self.create_error_response(e)

    def update(self, request):
        try:
            request_json = request.get_json(True)
            user_id = request_json['id']
            # TODO
            return self.create_error_response("Couldn't update user with id \"%s\"" % user_id)
        except Exception as e:
            return self.create_error_response(e)

    def delete(self, request):
        try:
            request_json = request.get_json(True)
            user_nick = request_json['nick']
            del_user = self.manager.find_item(user_nick)
            if del_user is not None:
                self.manager.delete(int(del_user))
                return self.create_response("User deleted")
            else:
                return self.create_error_response("Couldn't delete the user")
        except Exception as e:
            return self.create_error_response(e)
