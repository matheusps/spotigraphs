package org.spotigraph;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IOUtils {

    private static final String DEFAULT_SEPARATOR = ",";
    public static final String EMPTY_STRING = "";
    public static final String DOUBLE_QUOTES = "\"";
    public static final String ARTIST_SEPARATOR = "\",\"";

    public static void getPlaylists(Map<String, Artist> artistMap, Map<String, Playlist> playlistMap) {

        String csvfile = "artist-playlist.csv";

        try {

            Scanner scanner = new Scanner(new File(csvfile));
            scanner.nextLine();
            String playlistName = EMPTY_STRING;

            while(scanner.hasNext()) {

                List<Artist> artistList = new ArrayList<>();

                String[] line = scanner.nextLine().split(DEFAULT_SEPARATOR);

                for (int i = 0; i < line.length; i++) {
                    line[i] = line[i].replaceAll(DOUBLE_QUOTES, EMPTY_STRING);
                }

                if (playlistName.equals(line[1])) {

                    Playlist playlist = playlistMap.get(playlistName);
                    playlist.getArtists().add(artistMap.get(line[0]));

                } else {
                    artistList.add(artistMap.get(line[0]));
                    Playlist playlist = new Playlist(line[1], artistList);
                    playlistMap.put(line[1], playlist);
                    playlistName = line[1];
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getArtists(Map<String, Artist> artistMap) {

        String csvfile = "filter-artists.csv";

        try {
            Scanner scanner = new Scanner(new File(csvfile));
            scanner.nextLine();

            while(scanner.hasNext()) {
                String [] line = scanner.nextLine().split(ARTIST_SEPARATOR);

                for (int i = 0; i < line.length; i++) {
                    line[i] = line[i].replaceAll(DOUBLE_QUOTES, EMPTY_STRING);
                }

                Artist artist = new Artist(line[0], line[1].split(","), line[2].split(","));
                artistMap.put(line[0], artist);
            }
            scanner.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
