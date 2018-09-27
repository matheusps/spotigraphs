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

O grafo gerado pelos dados será construído considerando os artistas, playlist e musica, como vértices, que estão conectados por arestas direcionadas entre si, como podemos visualiar na imagem abaixo:

![alt text](https://github.com/matheusps/spotigraphs/blob/master/imgs/graph.png "Prototipagem Grafo")

Dessa forma obtemos uma um dígrafo. Nesse digrafo temos que, uma playlist que 'possui' um artista assim como 'possui' uma musica. Um artista, por sua vez, 'possui' uma musica. Então, se existirem conjuntos de artistas que não se relacionam, teremos grafos desconectados.

## Perguntas a serem respondidas

**1. Qual ou quais os artistas mais indicados a serem adicionados a lista, ou seja, qual o nó não pertencente a *playlist* que tem o maior grau de entrada?**

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
  
**5. Qual artista seria mais ecletico, ou seja, estaria em o maior numero de playlists com estilos diferenciados?**

&nbsp;
  R -
  
**6. Será que o artista que está em um maior numero de playlists é o artista mais ouvido?**

&nbsp;
  R -
  
**7. Será que a musica que está em um maior numero de playlists é a musica mais ouvida?**

&nbsp;
  R -
