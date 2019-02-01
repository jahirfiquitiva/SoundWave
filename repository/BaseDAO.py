from abc import ABC
from typing import Generic, TypeVar

from repository import BaseSQL as bq, DatabaseConnection as dao

T = TypeVar('T', bound=bq.BaseSQL)


# noinspection PyBroadException
class BaseDAO(ABC, Generic[T]):
    def __init__(self):
        self.sql: T = None
        self.connection: dao.DatabaseConnection = dao.DatabaseConnection()

    def query(self, item_id: int = -1, name: str = "") -> []:
        query = self.sql.query()
        if item_id >= 0:
            query = self.sql.query_by_id(item_id)
        elif len(name) > 0:
            query = self.sql.query_by_name(name)
        return self.query_executor(query)

    def query_executor(self, query: str) -> []:
        if self.connection.connect_to_db():
            try:
                cursor = self.connection.cursor
                if cursor is not None:
                    cursor.execute(query)
                    return cursor.fetchall()
                else:
                    return None
            except Exception as e:
                self.connection.rollback()
                print("Error: " + str(e))
                return None
            finally:
                self.connection.cursor.close()
                self.connection.close()
        return None

    def update_executor(self, query: str) -> bool:
        if self.connection.connect_to_db():
            try:
                cursor = self.connection.cursor
                if cursor is not None:
                    cursor.execute(query)
                    self.connection.commit()
                    return cursor.rowcount > 0
                else:
                    return False
            except Exception as e:
                self.connection.rollback()
                print("Error: " + str(e))
                return False
            finally:
                self.connection.cursor.close()
                self.connection.close()
        return False

    def query_boolean_executor(self, query: str) -> bool:
        return self.query_executor(query) is not None

    def delete(self, item_id: int) -> bool:
        return self._delete_with_id(item_id)

    def delete(self, name: str) -> bool:
        return self._delete_with_name(name)

    def insert(self, query: str) -> bool:
        return self.update_executor(query)

    def _delete_with_id(self, item_id: int) -> bool:
        return self.update_executor(self.sql.delete_with_id(item_id))

    def _delete_with_name(self, name: str) -> bool:
        return self.update_executor(self.sql.delete_with_name(name))

    def _is_select(self, query: str):
        return query.lower().startswith('select')
