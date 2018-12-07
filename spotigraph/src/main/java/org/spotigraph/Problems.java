package org.spotigraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.spotigraph.util.OrderObject;
import sun.security.provider.certpath.Vertex;


public class Problems {
	
	/**
	 * Qual ou quais os artistas mais indicados a ser(em) executado(s) após o término da playlist,
	 * ou seja, qual vértice que não está presente na playlist,
	 * mas encontra-se conectado ao vértice de um, ou mais,
	 * artista(s) já relacionado(s) a playlist e que tem o maior grau de proximidade(playlists em comum)?
	 */
	public static List<String> problem1Solver(Playlist currentPlayList) {
		
		//Artistas da playlsit
		List<Artist> playListArtists = currentPlayList.getArtists();
		
		// Lista com Apenas os nomes dos artistas contidos nas playlist, será útil mais abaixo
		List<String> playListArtistsName = new ArrayList<String>();
		
		// Preenchendo a lista
		for (int i = 0; i < playListArtists.size(); i++) {
			playListArtistsName.add(playListArtists.get(i).getName());
		}
		
		// criar o grafo de artistas e seus relacionados
		Graph<String,DefaultEdge> artistsGraph = new WeightedMultigraph<>(DefaultEdge.class);
		
		//------------------------- Adicionar Artistas e Inicializar o grafo------
		
		// Para cada artista na playlist 
		for (int i = 0; i < playListArtists.size(); i++) {
			
			// Artista
			String artist = playListArtists.get(i).getName(); 
			
			// Adiciona um vértice para o artista
			artistsGraph.addVertex(artist);
			
			// E para cada artista relacionado
			for (int j = 0; j < playListArtists.get(i).getRelated().size(); j++) {
				
				// Artista relacionado
				String related = playListArtists.get(i).getRelated().get(j);
				
				// Adiciona um vértice para o artista relacionado
				artistsGraph.addVertex(related);
				
				// Adiciona uma aresta entre os o artista da playList e o relacionado
				if(!artist.equals(related)) {
					artistsGraph.addEdge(artist, related);
				}
				
			}
			
		}
		
		
		List<OrderObject<String>> rankedArtist = new ArrayList<OrderObject<String>>();
		
		Iterator<String> artists = artistsGraph.vertexSet().iterator();
				
		// Para todos os artistas relacionados 
		while (artists.hasNext()) {
						
			// Artista
			String artist = artists.next();
			
			if(!playListArtistsName.contains(artist)) {
				Integer numberOfEdgs = artistsGraph.edgesOf(artist).size();
				OrderObject<String> order = new OrderObject<String>(numberOfEdgs, artist);
				rankedArtist.add(order);
			}
		
		}
		
		// Sorting
		Collections.sort(rankedArtist, new Comparator<OrderObject>() {
		       
				@Override
				public int compare(OrderObject order2, OrderObject order1)
		        {

		            return  order1.getValue().compareTo(order2.getValue());
		        }
				
		    });
		
		List<String> sortArtistList = new ArrayList<String>();
		for (int j = 0; j < rankedArtist.size(); j++) {
			sortArtistList.add(rankedArtist.get(j).getObj());
		}
		
		return sortArtistList;
		
	}
	
	/**
     * Dados dois artistas, que não estão na lista de relacionados entre si,
	 * é possível caminhar de um até o outro usando o grafo?
	 */
	public static boolean problem2Solver(List<Playlist> playlists, Artist a1, Artist a2) {

        Graph<String,DefaultEdge> artistsGraph = new WeightedMultigraph<>(DefaultEdge.class);

        for(Playlist currentPlaylist : playlists ) {

            List<Artist> playListArtists = currentPlaylist.getArtists();

            List<String> playListArtistsName = new ArrayList<String>();
            for (int i = 0; i < playListArtists.size(); i++) {
                playListArtistsName.add(playListArtists.get(i).getName());
            }

            for (Artist currentArtist : playListArtists) {
                artistsGraph.addVertex(currentArtist.getName());
                for (String currentRelated : currentArtist.getRelated()) {
                    artistsGraph.addVertex(currentRelated);
                    if (!currentArtist.getName().equals(currentRelated))
                        artistsGraph.addEdge(currentArtist.getName(), currentRelated);
                }
            }
        }

        return !artistsGraph.getAllEdges(a1.getName(), a2.getName()).isEmpty();
	}

	/**
	 * Considerando os artistas que compõem um playlist, e suas listas de relacionados,
	 * quais playlists já encontram-se relacionadas,
	 * e quais podem ser interligadas ao se adicionar um novo artista presente na lista de relacionados
	 * dos já pertencentes a playlist?
	 */
	public static void problem3Solver() {
		
	}

	/**
	 * Qual(ais) o(s) artista(s) mais popular(es),
	 * aquele presente em mais playlists e aquele mais presente na lista de relacionados?
	 */
	public static void problem4Solver() {
		
	}
	
}
