class Album(object):
    def __init__(self, id, name, img_path, release_year):
        self._id = id
        self._name = name
        self._img_path = img_path
        self._release_year = release_year

    def get_id(self):
        return self._id

    def set_id(self, id):
        self._id = id

    def get_name(self):
        return self._name

    def set_name(self, name):
        self._name = name

    def get_img_path(self):
        return self._img_path

    def set_img_path(self, img_path):
        self._img_path = img_path

    def get_release_year(self):
        return self._release_year

    def set_release_year(self, release_year):
        self._release_year = release_year
