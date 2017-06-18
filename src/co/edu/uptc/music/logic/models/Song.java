package co.edu.uptc.music.logic.models;

public class Song {
    private String name;
    private int length;
    private String genre;
    private String artist;
    private String idSong;
    private String filePaht;

    public Song(String idSong, String name, int length, String genre, String artist,String filePaht) {

        this.filePaht=filePaht;
        this.idSong = idSong;
        this.name = name;
        this.length = length;
        this.genre = genre;
        this.artist = artist;
    }

    public String getName() { return name;  }

    public String getFilePaht() { return filePaht;  }

    public String getIdSong() { return idSong;  }

    public int getLength() {
        return length;
    }

    public String getGenre() {
        return genre;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "Song{" + "idSong" + idSong + '\'' +
                "name='" + name + '\'' +
                ", length=" + length +
                ", genre='" + genre + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
