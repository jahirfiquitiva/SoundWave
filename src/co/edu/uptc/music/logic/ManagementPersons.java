package co.edu.uptc.music.logic;

import java.util.ArrayList;

import co.edu.uptc.music.logic.Artist;

public class ManagementPersons {
ArrayList<Artist> artists;


    public ManagementPersons() {
        artists= new ArrayList<>();
    }

    public Artist findArtist(String nameArt){
        if (artists == null || artists.isEmpty()) return null;
        for (Artist artis : artists) {
            if (artis.getName().equalsIgnoreCase(nameArt)) {
                return artis;
            }
        }
        return null;
    }
}
