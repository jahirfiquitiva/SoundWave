from abc import ABC, abstractmethod
from typing import Generic, TypeVar

from flask import jsonify, make_response

from managers import BaseManager as man

T = TypeVar('T')
MANAGER = TypeVar('MANAGER', bound=man.BaseManager)


# noinspection PyMethodMayBeStatic,PyBroadException
class BaseAPI(ABC, Generic[MANAGER, T]):
    def __init__(self):
        pass

    def create_response(self, response):
        actual_response = make_response(jsonify(response))
        actual_response.headers['Access-Control-Allow-Origin'] = '*'
        actual_response.headers['Access-Control-Allow-Credentials'] = True
        return actual_response

    def create_error_response(self, error):
        return jsonify({"success": False, "error": str(repr(error))})

    def get_request_param(self, req, param: str):
        try:
            return req.args.get(param)
        except Exception:
            return None

    def get_body_param(self, req, param: str):
        try:
            request_json = req.get_json(True)
            return request_json[param]
        except Exception:
            return None

    def get_form_field(self, req, param: str):
        try:
            return req.form[param]
        except Exception:
            return None

    def get(self, request):
        try:
            self.manager.load()
            req_id = self.get_request_param(request, 'id')
            req_key = self.get_request_param(request, 'key')

            res_key = self.response_key
            if req_id is not None and len(req_id) > 0:
                return self.create_response(
                    {"success": True, "reqId": req_id,
                     res_key: self.manager.find_item_by_id(int(req_id)).as_json()})
            elif req_key is not None and len(req_key) > 0:
                res_key_pl = "%ss" % res_key
                return self.create_response(
                    {"success": True, "reqKey": req_key,
                     res_key_pl: self.manager.find_all_items_as_json(req_key)})
            else:
                res_key_pl = "%ss" % res_key
                return self.create_response(
                    {"success": True, res_key_pl: self.manager.get_items_as_json()})
        except Exception as e:
            return self.create_error_response(e)

    @property
    @abstractmethod
    def response_key(self) -> str:
        return "nn"

    @property
    @abstractmethod
    def manager(self) -> MANAGER:
        raise Exception("You have not implemented this method")
