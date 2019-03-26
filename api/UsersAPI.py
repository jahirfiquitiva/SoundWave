from api import BaseAPI as bapi
from managers import UsersManager as uman


# noinspection PyMethodMayBeStatic,PyBroadException
class UsersAPI(bapi.BaseAPI):

    @property
    def manager(self) -> uman.UsersManager:
        return uman.UsersManager()

    @property
    def response_key(self):
        return "user"

    def validate_user(self, request):
        try:
            username = self.get_body_param(request, 'nick')
            found_user = self.manager.find_item(username)
            if found_user is None:
                found_user = self.manager.find_item_by_email(username)
            if found_user is not None:
                pwd = self.get_body_param(request, 'pwd')
                return self.create_response({"success": True, "valid": found_user.validate(pwd)})
            return self.create_response({"success": True, "valid": False})
        except Exception as e:
            return self.create_error_response(e)

    def post(self, request):
        try:
            new_user_nick = self.get_body_param(request, 'nick')
            if self.manager.create(self.get_body_param(request, 'name'),
                                   self.get_body_param(request, 'lastName'),
                                   int(self.get_body_param(request, 'age')), new_user_nick,
                                   self.get_body_param(request, 'photo'),
                                   self.get_body_param(request, 'email'),
                                   self.get_body_param(request, 'password')):
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
                self.manager.delete(del_user.id)
                return self.create_response("User deleted")
            else:
                return self.create_error_response("Couldn't delete the user")
        except Exception as e:
            return self.create_error_response(e)
