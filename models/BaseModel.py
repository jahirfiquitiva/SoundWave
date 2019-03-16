from abc import ABC, abstractmethod


class BaseModel(ABC):
    @abstractmethod
    def as_json(self) -> {}:
        return None
