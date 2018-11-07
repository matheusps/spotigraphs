package org.spotigraph;

import java.util.List;

public class Playlist {

    private String name;
    private List<Artist> artists;

    public Playlist(String name, List<Artist> artists) {
        this.name = name;
        this.artists = artists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {
        return "Playlist {" + "\n" +
                "name= " + name + '\n' +
                "artists= " + artists + "\n" +
                "}";
    }
}
