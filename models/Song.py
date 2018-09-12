""" Class responsible for taking some features
main songs for its management within
of the software"""

"""Attributes of class song
     _id = int type, numeric identifier of the songs
     _name = type string, store the name the song
     _track = int type, indicator of the song within the album
     _length = int type, duration of each cation estimated in seconds
     _path = type string, destination path where the song is found 
    """


class Song(object):
    def __init__(self, id, name, track, length, path):
        """ method that initializes the attributes of the song class"""
        self._id = id
        self._name = name
        self._track = track
        self._length = length
        self._path = path

    def __str__(self):
        return self._name

    def get_id(self):
        return self._id

    def set_id(self, id):
        self._id = id

    def get_name(self):
        return self._name

    def set_name(self, name):
        self._name = name

    def get_track(self):
        return self._track

    def set_track(self, track):
        self._track = track

    def get_length(self):
        return self._length

    def set_length(self, length):
        self._length = length

    def get_path(self):
        return self._path

    def set_path_song(self, path):
        self._path = path
