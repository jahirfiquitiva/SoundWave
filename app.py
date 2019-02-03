from flask import Flask, render_template
import socket
from managers import PlaylistsManager as man
from managers import SongsManager as soman

app = Flask("SoundWave")


@app.route("/")
def main():
    return render_template('index.html')


if __name__ == '__main__':
    manager = man.PlaylistsManager()
    songman = soman.SongsManager()
    # songman.create("h65hhrhrt", 6, 765, "cwecwec", 2, 3)
    # manager.add_song_to_playlist(3, 6)
    # manager.create("when the party''s over", 4, 234, "song/path/yes", 2, 3)
    # manager.update(4, 'favorites', 11)
    # manager.delete(3)
    # manager.add_song_to_new_playlist("mucik", 1, 5)
    items = manager.get_playlist_songs(5)
    if items is not None and len(items) > 0:
        for i in items:
            print(str(i))
    else:
        print("No items found")

    """
    items = manager.get_items()
    if items is not None and len(items) > 0:
        for i in items:
            print(str(i))
    else:
        print("No items found")
    """
    # app.config['TEMPLATES_AUTO_RELOAD'] = True
    # hoster = socket.gethostbyname(socket.gethostname())
    # app.run(host=hoster)
    # app.run()
