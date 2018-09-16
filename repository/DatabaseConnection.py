from typing import Optional
import mysql.connector as sqlcon
import mysql.connector.cursor as sqlcursor


class DatabaseConnection:
    def __init__(self):
        self._connection: sqlcon.MySQLConnection = None

    @property
    def cursor(self) -> Optional[sqlcursor.MySQLCursor]:
        return None if self._connection is None else self._connection.cursor()

    def connect_to_db(self) -> bool:
        try:
            if self._connection is None or not self._connection.is_connected():
                self._connection = sqlcon.connect(
                    user='root',
                    password='',
                    host='127.0.0.1', port='3306',
                    database='soundwaveco')
            return self._connection is not None
        except Exception as ex:
            print(ex)
            return False

    def close(self):
        self._connection.close()


"""
test connection BD
 cusor = connection.cursor()
 cusor.execute('select * from  user')
 all = cusor.fetchall()
 for i in all:
     print(str(i))

 cusor.close()
 connection.close()
"""
