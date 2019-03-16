import socket

from flask import Flask, request, render_template

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


# Get endpoint arguments:
# request.args.get('param')
@app.route("/api/users", methods=['GET'])
def get_users():
    return users_api.get()


@app.route("/api/users", methods=['POST', 'OPTIONS'])
def post_user():
    return users_api.post(request)


@app.route("/api/users", methods=['PUT'])
def put_user():
    return users_api.update(request)


if __name__ == '__main__':
    # Flask WebApp
    app.config['TEMPLATES_AUTO_RELOAD'] = True
    app.run(host=socket.gethostbyname(socket.gethostname()))
    # app.run()
