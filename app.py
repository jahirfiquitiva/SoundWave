from flask import Flask, render_template
import socket

app = Flask("SoundWave")


@app.route("/")
def main():
    return render_template('index.html')


if __name__ == '__main__':
    app.config['TEMPLATES_AUTO_RELOAD'] = True
    # app.run(host=socket.gethostbyname(socket.gethostname()))
    app.run()
