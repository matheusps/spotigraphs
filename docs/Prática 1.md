# Prática 1

## Base de Dados

A base de dados selecionada para o estudo corresponde a um subconjunto de listas de músicas (*playlists*) do *spotify*, que contém informações sobre as músicas nela contidas e os artistas relacionados com cada música seguindo o modelo abaixo:

```bash
class Playlist {
    name: string,
    musics: music[]
}

class Music {
    name: string,
    artists: Artist[]
}

class Artist {
    nome: string,
    relateds: Artist[]
}

```
Esta base de dados pode ser acessada em: http://...

## Contexto

O *spotify* oferece um serviço de músicas onde os usuário podem construir listas de músicas para ouvir. Como serviço adicional, quando as músicas da lista já terminaram de ser executadas, o serviço costuma recomendar músicas com base nas relações existentes entre músicas e artistas.

## Grafo

O grafo gerado pelos dados será construído considerando os artistas como vértices que estão conectados por arestas direcionadas de acordo com a lista de relacionados, construindo assim um dígrafo. Desta forma, se existirem conjuntos de artista que não se relacionam, teremos grafos desconectados.

## Perguntas a serem respondidas

**1.** Dado que uma playlist é formada por um conjunto de artistas, e que estes artistas são representados por vértices com arestas de saída. Qual ou quais os artistas mais indicados a serem adicionados a lista, ou seja, qual o nó não pertencente a *playlist* que tem o maior grau de entrada?

&nbsp;
  R -
  
**2.** O grafo formado pelos artistas quem compõem uma playlist é conectado?

&nbsp;
  R -
  
**3.** Existe um artista que representa um vértice separador no grafo da playlist, caso ela seja conectada?

&nbsp;
  R -
  
**4.** O grafo de duas playlists em que um mesmo artista está presente é conectado?

&nbsp;
  R -
