from abc import ABC
from typing import TypeVar, Generic
from repository import BaseSQL as bq, DatabaseConnection as dao

T = TypeVar('T', bound=bq.BaseSQL)


# noinspection PyBroadException
class BaseDAO(ABC, Generic[T]):
    def __init__(self):
        self.sql: T = None
        self.connection = dao.DatabaseConnection()

    def query(self, id=-1, name=""):
        query = self.sql.query()
        if id >= 0:
            query = self.sql.query_by_id(id)
        elif len(name) > 0:
            query = self.sql.query_by_name(name)
        return self.query_executor(query)

    def query_executor(self, query):
        if self.connection.connect_to_db():
            try:
                cursor = self.connection.cursor
                if cursor is not None:
                    cursor.execute(query)
                    return cursor.fetchall()
                else:
                    return None
            except Exception:
                return None
        return None

    def update_executor(self, query) -> bool:
        return self.query_executor(query) is not None

    def query_boolean_executor(self, query) -> bool:
        return self.query_executor(query) is not None

    def delete(self, id: int):
        return self._delete_with_id(id)

    def delete(self, name: str):
        return self._delete_with_name(name)

    def insert(self, query) -> bool:
        return self.update_executor(query)

    def _delete_with_id(self, id) -> bool:
        return self.update_executor(self.sql.delete_with_id(id))

    def _delete_with_name(self, name) -> bool:
        return self.update_executor(self.sql.delete_with_name(name))