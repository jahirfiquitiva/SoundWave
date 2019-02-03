class Song(object):
    def __init__(self, item_id: int, name: str, track: int, length: int, path: str, genre_id: int,
                 album_id: int):
        self._id: int = item_id
        self._name: str = name
        self._track: int = track
        self._length: int = length
        self._path: str = path
        self._genre_id: int = genre_id
        self._album_id: int = album_id

    @property
    def id(self) -> int:
        return self._id

    @property
    def name(self) -> str:
        return self._name

    @property
    def track(self) -> int:
        return self._track

    @property
    def length(self) -> int:
        return self._length

    @property
    def path(self) -> str:
        return self._path

    @property
    def genre_id(self) -> int:
        return self._genre_id

    @property
    def album_id(self) -> int:
        return self._album_id

    def __str__(self):
        return "Id: %d - Name: %s - Album Id: %d" % (self.id, self.name, self.album_id)
