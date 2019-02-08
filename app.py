from flask import Flask, render_template

app = Flask("SoundWave")


@app.route("/")
def main():
    return render_template('index.html')


@app.route("/login")
@app.route("/login.html")
def login():
    return render_template('login.html')


if __name__ == '__main__':
    # Flask WebApp
    app.config['TEMPLATES_AUTO_RELOAD'] = True
    # app.run(host=socket.gethostbyname(socket.gethostname()))
    app.run()
