class Album(object):
    def __init__(self, item_id: int, name: str, img_path: str, release_year: int, artist_id: int):
        self._id: int = item_id
        self._name: str = name
        self._img_path: str = img_path
        self._release_year: int = release_year
        self._artist_id: int = artist_id

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

    @property
    def artist_id(self) -> int:
        return self._artist_id

    def __str__(self):
        return "Id: %d - Name: %s - Year: %d - Artist id: %d" % (
            self.id, self.name, self.release_year, self.artist_id)
