from models import BaseModel as bm


class Genre(bm.BaseModel):
    def __init__(self, item_id: int, name: str, img_path: str):
        self._id: int = item_id
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

    def as_json(self) -> {}:
        return {"id": self.id, "name": self.name, "imgPath": self.img_path}

    def __str__(self):
        return "Id: %d - Nombre: %s - Path: %s" % (self.id, self.name, self.img_path)
