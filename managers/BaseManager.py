from abc import ABC, abstractmethod
from typing import Generic, TypeVar, Optional
from repository import BaseDAO as bdao
from models import BaseModel as bm

T = TypeVar('T', bound=bm.BaseModel)
DAO = TypeVar('DAO', bound=bdao.BaseDAO)


class BaseManager(ABC, Generic[DAO, T]):
    def __init__(self):
        self._items: [T] = []
        self.load()

    def get_items(self) -> [T]:
        return self._items.copy()

    def get_items_as_json(self) -> {}:
        json_items = []
        for item in self.get_items():
            json_items.append(self.item_to_json_item(item))
        return json_items

    def add_item(self, item: T) -> bool:
        if item in self._items:
            return False
        self._items.append(item)
        return True

    def remove_item(self, item: T) -> bool:
        if item not in self._items:
            return False
        self._items.remove(item)
        return True

    # noinspection PyBroadException
    def remove_item_at(self, index: int) -> bool:
        try:
            return self.remove_item(self._items[index])
        except Exception:
            pass
        return False

    def clear_list(self):
        self._items.clear()

    def load(self):
        self.clear_list()
        query = self.dao.query()
        if query is not None and len(query) > 0:
            for q_tuple in query:
                item = self.tuple_to_item(q_tuple)
                if item is not None:
                    self.add_item(item)

    def item_to_json_item(self, item: bm.BaseModel) -> {}:
        return item.as_json()

    @abstractmethod
    def tuple_to_item(self, tuple_ref: tuple) -> Optional[T]:
        return None

    @abstractmethod
    def find_item_by_id(self, item_id: int) -> Optional[T]:
        raise Exception("You have not implemented this method")

    @abstractmethod
    def find_item(self, s: str) -> Optional[T]:
        raise Exception("You have not implemented this method")

    @property
    @abstractmethod
    def dao(self) -> DAO:
        raise Exception("You have not implemented this method")
