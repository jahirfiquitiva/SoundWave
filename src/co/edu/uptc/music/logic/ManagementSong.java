package co.edu.uptc.music.logic;

import java.util.ArrayList;

import co.edu.uptc.music.logic.Song;

public class ManagementSong {

    ArrayList<Song> songs;

    public ManagementSong() {
        songs= new ArrayList<>();
    }
    public Song findSong(String name){
        if (songs == null || songs.isEmpty()) return null;
        for(Song song : songs)
            if(song.getNameSong().equals(name)){
                return song;
            }
        return null;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
