package org.spotigraph;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{

    private static final String DEFAULT_SEPARATOR = ",";

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Graph<String, DefaultEdge> stringGraph = createStringGraph();

        // note undirected edges are printed as: {<v1>,<v2>}
        System.out.println("-- toString output");
        //@example:toString:begin
        System.out.println(stringGraph.toString());
        //@example:toString:end
        System.out.println();

        String artistFile = "../../Documents/workspace/spotigraphs/docs/filter-artists.csv";
        Map<String, Artist> artistMap = new HashMap<>();
        getArtists(artistFile, artistMap);

        Map<String, Playlist> playlistMap = new HashMap<>();

        String csvfile = "../../Documents/workspace/spotigraphs/docs/artist-playlist.csv";

        try {

            Scanner scanner = new Scanner(new File(csvfile));
            String[] line = scanner.nextLine().split(DEFAULT_SEPARATOR);
            System.out.println(line[0] + " " + line[1]);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    private static void getArtists(String csvfile, Map<String, Artist> artistMap) {
        try {

            Scanner scanner = new Scanner(new File(csvfile));
            String[] line = scanner.nextLine().split(DEFAULT_SEPARATOR);

            while(scanner.hasNext()) {
                line = scanner.nextLine().split("\",\"");

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
    private static Graph<String, DefaultEdge> createStringGraph()
    {
        Graph<String, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);

        String v1 = "v1";
        String v2 = "v2";
        String v3 = "v3";
        String v4 = "v4";

        // add the vertices
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);

        // add edges to create a circuit
        g.addEdge(v1, v2);
        g.addEdge(v2, v3);
        g.addEdge(v3, v4);
        g.addEdge(v4, v1);

        return g;
    }
}
