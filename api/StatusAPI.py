from api import BaseAPI as bapi


class StatusAPI(bapi.BaseAPI):

    @property
    def manager(self):
        return None

    def get_status(self):
        return self.create_response({"api": "ok", "status": "ok", "alive": True})
