class Genre(object):
    def __init__(self, id: int, name: str, img_path: str):
        self._id: int = id
        self._name: str = name
        self._img_path: str = img_path

    @property
    def id(self) -> int:
        return self._id

    @property
    def name(self) -> str:
        return self._name

    @property
    def img_path(self) -> str:
        return self._img_path
