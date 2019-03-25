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

    def get(self, request):
        try:
            self.manager.load()
            req_id = None
            try:
                req_id = request.args.get('id')
            except Exception:
                req_id = None

            req_key = None
            try:
                req_key = request.args.get('key')
            except Exception:
                req_key = None

            res_key = self.response_key
            if req_id is not None:
                print("Getting by id: %s" % req_id)
                return self.create_response(
                    {"success": True, res_key: self.manager.find_item_by_id(int(req_id)).as_json()})
            elif req_key is not None:
                print("Getting by key: %s" % req_key)
                return self.create_response(
                    {"success": True, res_key: self.manager.find_item(req_key).as_json()})
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
