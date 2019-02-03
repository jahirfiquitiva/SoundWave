from flask import Flask, render_template
import socket
from managers import SongsManager as sm

app = Flask("SoundWave")


@app.route("/")
def main():
    return render_template('index.html')


if __name__ == '__main__':
    manager = sm.SongsManager()
    manager.create("Nombre", 9, 123, "la/ruta", 0, 1)
    manager.create("Otro nombre", 2, 454, "otra/ruta/si", 0, 1)
    # manager.update(6, 'actualizado', 'otra_cosa', 34, 'lizado', 'freger@gmail.co', '4321')
    # manager.delete(6)
    items = manager.get_items()
    if items is not None and len(items) > 0:
        for i in items:
            print(str(i))
    else:
        print("No items found")
    # app.config['TEMPLATES_AUTO_RELOAD'] = True
    # hoster = socket.gethostbyname(socket.gethostname())
    # app.run(host=hoster)
    # app.run()
