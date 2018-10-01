from abc import ABC, abstractmethod
from typing import Generic, TypeVar, Optional
from repository import BaseSQL as bq, BaseDAO as bdao

T = TypeVar('T')
DAO = TypeVar('DAO', bound=bdao.BaseDAO)


class BaseManager(ABC, Generic[DAO, T]):
    def __init__(self):
        self.items: [T] = []

    def add_item(self, item: T) -> bool:
        if item in self.items:
            return False
        self.items.append(item)
        return True

    def remove_item(self, item: T) -> bool:
        if item not in self.items:
            return False
        self.items.remove(item)
        return True

    def remove_item(self, index: int) -> bool:
        return self.remove_item(self.items[index])

    def clear_list(self):
        self.items.clear()

    @abstractmethod
    def find_item(self, id: int) -> Optional[T]:
        raise Exception("You have not implemented this method")

    @abstractmethod
    def find_item(self, s: str) -> Optional[T]:
        raise Exception("You have not implemented this method")

    @abstractmethod
    def load(self):
        raise Exception("You have not implemented this method")

    @property
    @abstractmethod
    def dao(self) -> DAO:
        raise Exception("You have not implemented this method")
