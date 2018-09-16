from flask import Flask, render_template

from repository.DatabaseConnection import DatabaseConnection as dabacon

app = Flask("SoundWave")


@app.route("/")
def main():
    return render_template('index.html')


if __name__ == '__main__':
    dabacon.connect_to_db
