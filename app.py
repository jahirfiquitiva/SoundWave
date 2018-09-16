from flask import Flask, render_template
import socket
from repository.DatabaseConnection import DatabaseConnection as dabacon
from repository.user import UserDAO as udao

app = Flask("SoundWave")


@app.route("/")
def main():
    return render_template('index.html')


if __name__ == '__main__':
    print("Hello")
    dao = udao.UserDAO()
    for i in dao.query():
        print(str(i))
    # app.config['TEMPLATES_AUTO_RELOAD'] = True
    # hoster = socket.gethostbyname(socket.gethostname())
    # app.run(host=hoster)
    # app.run()
