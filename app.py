from flask import Flask, render_template
import socket
from managers import UsersManager as um

app = Flask("SoundWave")


@app.route("/")
def main():
    return render_template('index.html')


if __name__ == '__main__':
    userManager = um.UsersManager()
    # userManager.create("TestName", "TestSurname", 1, "tester", "tester@soundwave.co", "1234")
    # userManager.update(6, 'actualizado', 'otra_cosa', 34, 'lizado', 'freger@gmail.co', '4321')
    # userManager.delete(6)
    items = userManager.get_items()
    if items is not None and len(items) > 0:
        for i in items:
            print(str(i))
    else:
        print("No users found")
    # app.config['TEMPLATES_AUTO_RELOAD'] = True
    # hoster = socket.gethostbyname(socket.gethostname())
    # app.run(host=hoster)
    # app.run()
