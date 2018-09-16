from abc import ABC, abstractmethod


class BaseSQL(ABC):
    @property
    @abstractmethod
    def table_name(self) -> str:
        raise Exception("You have not implemented this method")

    def query(self) -> str:
        return "select * from %s" % self.table_name

    def query_by_id(self, id: int) -> str:
        return "select * from %s where id_%s='%s';" % (self.table_name, self.table_name, id)

    def query_by_name(self, name: str) -> str:
        return "select * from %s where name_%s='%s';" % (self.table_name, self.table_name, name)

    def delete_with_id(self, id: int) -> str:
        return "delete from %s where id_%s='%s';" % (self.table_name, self.table_name, id)

    def delete_with_name(self, name: str) -> str:
        return "delete from %s where name_%s='%s';" % (self.table_name, self.table_name, name)
