class Song(object):
    def __init__(self, id, name, track, length, path):
        self._id: int = id
        self._name: str = name
        self._track: int = track
        self._length: int = length
        self._path: str = path

    def __str__(self):
        return self._name

    @property
    def id(self)->int:
        return self._id

    @property
    def name(self)->str:
        return self._name

    @property
    def track(self)->int:
        return self._track

    @property
    def length(self)->int:
        return self._length

    @property
    def path(self)->strs:
        return self._path
