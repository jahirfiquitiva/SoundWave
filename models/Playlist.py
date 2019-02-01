class Playlist(object):
    def __init__(self, item_id: int, name: str):
        self._id: int = item_id
        self._name: str = name

    @property
    def id(self) -> int:
        return self._id

    @property
    def name(self) -> str:
        return self._name
