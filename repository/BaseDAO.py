from abc import ABC

from repository import BaseSQL as bq, DatabaseConnection as dao


class BaseDAO(ABC):
    _sql: bq.BaseSQL

    def __init__(self):
        self._connection = dao.DatabaseConnection()

    def query(self, id=-1, name=""):
        query = self._sql.query()
        if id >= 0:
            query = self._sql.query_by_id(id)
        elif len(name) > 0:
            query = self._sql.query_by_name(name)
        self.query_executor(query)

    def query_executor(self, query):
        if self._connection.connect_to_db():
            try:
                con = self._connection._connection
                if con is not None:
                    statement = con.connect()
                    if statement is not None:
                        statement.execute(query)
            except Exception as ex:
                print(ex)
        return None

    def update_executor(self, query):
        if self._connection.connect_to_db():
            try:
                statement = self.connection.connection.connect()
                if statement is not None:
                    statement.execute(query)

            except Exception as ex:
                print(ex)

        return None

    def query_boolean_executor(self, query):
        if self.query_executor(query) == None:
            pass

        return True

    def delete(self, id):

        return self.delete_with_id(id)

    def delete(self, name):
        return self.delete_with_name(name)

    def insert(self, query):

        return self.update_executor(query)

    def delete_with_id(self, id):

        return self.update_executor(self._sql.delete_with_id(id))

    def delete_with_name(self, name):

        return self.update_executor(self._sql.delete_with_name(name))
