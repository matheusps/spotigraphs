package org.spotigraph;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.io.File;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{

    private static final String DEFAULT_SEPARATOR = ",";

    public static void main( String[] args )
    {

        Map<String, Artist> artistMap = new HashMap<>();
        getArtists(artistMap);

        Map<String, Playlist> playlistMap = new HashMap<>();
        getPlaylists(artistMap, playlistMap);

        Graph<String, DefaultEdge> stringGraph = createStringGraph(artistMap);

        // note undirected edges are printed as: {<v1>,<v2>}
        System.out.println("-- toString output");
        //@example:toString:begin
        System.out.println(stringGraph.toString());
        //@example:toString:end
        System.out.println();

    }

    private static void getPlaylists(Map<String, Artist> artistMap, Map<String, Playlist> playlistMap) {

        String csvfile = "artist-playlist.csv";

        try {

            Scanner scanner = new Scanner(new File(csvfile));
            scanner.nextLine();
            String playlistName = "";

            while(scanner.hasNext()) {

                List<Artist> artistList = new ArrayList<>();

                String[] line = scanner.nextLine().split(DEFAULT_SEPARATOR);

                for (int i = 0; i < line.length; i++) {
                    line[i] = line[i].replaceAll("\"", "");
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

    private static void getArtists(Map<String, Artist> artistMap) {

        String csvfile = "filter-artists.csv";

        try {
            Scanner scanner = new Scanner(new File(csvfile));
            scanner.nextLine();

            while(scanner.hasNext()) {
                String [] line = scanner.nextLine().split("\",\"");

                for (int i = 0; i < line.length; i++) {
                    line[i] = line[i].replaceAll("\"", "");
                }

                Artist artist = new Artist(line[0], line[1].split(","), line[2].split(","));
                artistMap.put(line[0], artist);
            }
            scanner.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Create a toy graph based on String objects.
     *
     * @return a graph based on String objects.
     */
    private static Graph<String, DefaultEdge> createStringGraph(Map<String, Artist> artistMap) {

        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

        for (Artist artist : artistMap.values()) {

            graph.addVertex(artist.getName());

            for (String related : artist.getRelated()) {

                if (!artist.getName().equals(related)) {
                    graph.addVertex(related);
                    graph.addEdge(artist.getName(), related);
                }
            }
        }
        return graph;
    }
}
