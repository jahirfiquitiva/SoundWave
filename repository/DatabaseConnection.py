import mysql.connector as sqlcon


class DatabaseConnection:
    def __init__(self):
        self._connection = None

    def connect_to_db(self):
        _connect = False
        try:
            _connection = sqlcon.connect(
                    user='root',
                    password='',
                    host='127.0.0.1', port='3306',
                    database='soundwaveco')
            _connect = True
        except Exception as ex:
            print(ex)
        return _connect

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
