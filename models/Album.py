class Album(object):
    def __init__(self, id, name, img_path, release_year):
        self._id: int = id
        self._name: str = name
        self._img_path: str = img_path
        self._release_year: int = release_year

    @property
    def id(self) -> int:
        return self._id

    @property
    def name(self) -> str:
        return self._name

    @property
    def img_path(self) -> str:
        return self._img_path

    @property
    def release_year(self) -> int:
        return self._release_year
