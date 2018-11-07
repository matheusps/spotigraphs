package org.spotigraph;

import java.util.Arrays;
import java.util.List;

public class Artist {

    private String name;
    private List<String> playlists;
    private List<String> related;

    public Artist(String name, String[] playlists, String[] related) {
        this.name = name;
        this.playlists = Arrays.asList(playlists);
        this.related = Arrays.asList(related);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRelated() {
        return related;
    }

    public void setRelated(List<String> related) {
        this.related = related;
    }

    public List<String> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<String> playlists) {
        this.playlists = playlists;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name= " + name + '\n' +
                "playlists= " + playlists + '\n' +
                "related= " + related + + '\n' +
                '}';
    }
}
