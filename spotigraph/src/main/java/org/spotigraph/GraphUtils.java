package org.spotigraph;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.Map;

public class GraphUtils {

    public static Graph<String, DefaultEdge> createStringGraph(Map<String, Artist> artistMap) {

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
