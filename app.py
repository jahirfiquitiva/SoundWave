from flask import Flask, request, render_template, session

from api import AlbumsAPI as albapi
from api import ArtistsAPI as artapi
from api import GenreAPI as genapi
from api import PlaylistsAPI as playapi
from api import SongsAPI as songapi
from api import StatusAPI as sapi
from api import UsersAPI as uapi

app = Flask("SoundWave")

status_api = sapi.StatusAPI()
users_api = uapi.UsersAPI()
artists_api = artapi.ArtistsAPI()
songs_api = songapi.SongsAPI()
albums_api = albapi.AlbumAPI()
genres_api = genapi.GenresAPI()
playList_api = playapi.PlaylistsAPI()


@app.route("/")
def main():
    return render_template('index.html')


@app.route("/login")
@app.route("/login/")
@app.route("/login.html")
def login():
    return render_template('login.html')


@app.route("/artists")
@app.route("/artists/")
@app.route("/artists.html")
def artists():
    return render_template('artists.html')


@app.route("/songs")
@app.route("/songs/")
@app.route("/songs.html")
def songs():
    return render_template('songs.html')


@app.route("/albums")
@app.route("/albums/")
@app.route("/albums.html")
def albums():
    return render_template('albums.html')


@app.route("/genres")
@app.route("/genres/")
@app.route("/genres.html")
def genres():
    return render_template('genres.html')


@app.route("/api", methods=['GET'])
def get_api_status():
    return status_api.get_status()


@app.route("/api/users", methods=['GET'])
def get_users():
    return users_api.get(request)


@app.route("/api/users/current", methods=['GET'])
def get_current_user():
    try:
        if 'uid' in session:
            return users_api.create_response({"success": True, "userId": session['uid']})
        return users_api.create_response({"success": False, "userId": None})
    except Exception as e:
        return users_api.create_error_response(e)


@app.route("/api/users/validate", methods=['POST'])
def validate_user():
    response, valid, uid = users_api.validate_user(request)
    if valid:
        session['uid'] = uid
    return response


@app.route("/api/artists", methods=['GET'])
def get_artists():
    return artists_api.get(request)


@app.route("/api/songs", methods=['GET'])
def get_songs():
    return songs_api.get(request)


@app.route("/api/albums", methods=['GET'])
def get_albums():
    return albums_api.get(request)


@app.route("/api/genres", methods=['GET'])
def get_genres():
    return genres_api.get(request)


@app.route("/api/playLists", methods=['GET'])
def get_playlist():
    return playList_api.get(request)


@app.route("/api/users", methods=['POST', 'OPTIONS'])
def post_user():
    return users_api.post(request)


@app.route("/api/songs", methods=['POST', 'OPTIONS'])
def post_song():
    return songs_api.post(request)


@app.route("/api/genres", methods=['POST', 'OPTIONS'])
def post_genre():
    return genres_api.post(request)


@app.route("/api/artists", methods=['POST', 'OPTIONS'])
def post_artist():
    return artists_api.post(request)


@app.route("/api/albums", methods=['POST', 'OPTIONS'])
def post_album():
    return albums_api.post(request)


@app.route("/api/playLists", methods=['POST', 'OPTIONS'])
def post_playlist():
    return playList_api.post(request)


@app.route("/api/users", methods=['PUT'])
def put_user():
    return users_api.update(request)


if __name__ == '__main__':
    # Flask WebApp
    app.config['TEMPLATES_AUTO_RELOAD'] = True
    # app.run(host=socket.gethostbyname(socket.gethostname()), port=8080)
    app.run()
