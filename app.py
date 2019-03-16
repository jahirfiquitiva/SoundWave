import socket
from flask import Flask, render_template
from api import UsersAPI as uapi

app = Flask("SoundWave")

users_api = uapi.UsersAPI()


@app.route("/")
def main():
    return render_template('index.html')


@app.route("/login")
@app.route("/login.html")
def login():
    return render_template('login.html')


@app.route("/api/users", methods=['GET'])
def get_sers():
    users_api.get()
    return "ok"


if __name__ == '__main__':
    # Flask WebApp
    app.config['TEMPLATES_AUTO_RELOAD'] = True
    app.run(host=socket.gethostbyname(socket.gethostname()))
    # app.run()
