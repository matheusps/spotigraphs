package org.spotigraph;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App
{


    public static void main( String[] args ) {

        Map<String, Artist> artistMap = new HashMap<>();
        IOUtils.getArtists(artistMap);

        Map<String, Playlist> playlistMap = new HashMap<>();
        IOUtils.getPlaylists(artistMap, playlistMap);
        Graph<String, DefaultEdge> stringGraph = GraphUtils.createStringGraph(artistMap);

        // note undirected edges are printed as: {<v1>,<v2>}
        System.out.println("-- toString output");
        //@example:toString:begin
        System.out.println(playlistMap.containsKey("Tops"));
        System.out.println(Problems.problem1Solver(playlistMap.get("Tops")));
        //@example:toString:end
        System.out.println();
        
        // note undirected edges are printed as: {<v1>,<v2>}
        System.out.println("-- toString output");
        //@example:toString:begin
        System.out.println(playlistMap.containsKey("Tops"));
        System.out.println(Problems.problem4Solver(playlistMap.get("Tops")));
        //@example:toString:end
        System.out.println();
    }
}
