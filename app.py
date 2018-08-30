from flask import Flask, render_template, request, jsonify
import socket

app = Flask("SoundWave")


@app.route("/")
def main():
    return render_template('index.html')


if __name__ == "__main__":
    app.config['TEMPLATES_AUTO_RELOAD'] = True
    # hoster = socket.gethostbyname(socket.gethostname())
    # app.run(host=hoster)
    app.run()
