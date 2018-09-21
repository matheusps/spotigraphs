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

**1.**

&nbsp;
  R -
  

**2.**

&nbsp;
  R -
  

**3.**

&nbsp;
  R -
  

**4.**

&nbsp;
  R -
