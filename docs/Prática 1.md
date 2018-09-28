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
## Contexto

O *spotify* oferece um serviço de músicas onde os usuário podem construir listas de músicas para ouvir. Como serviço adicional, quando as músicas da lista já terminaram de ser executadas, o serviço costuma recomendar músicas com base nas relações existentes entre músicas e artistas.

## Grafo

O grafo gerado pelos dados será construído considerando os artistas, playlist e musica, como vértices, que estão conectados por arestas direcionadas entre si, como podemos visualiar na imagem abaixo:

![alt text](https://github.com/matheusps/spotigraphs/blob/master/imgs/graph.png "Prototipagem Grafo")

Dessa forma obtemos uma um dígrafo. Nesse digrafo temos que, uma playlist que 'possui' um artista assim como 'possui' uma musica. Um artista, por sua vez, 'possui' uma musica. Então, se existirem conjuntos de artistas que não se relacionam, teremos grafos desconectados.

## Perguntas a serem respondidas

**1. Qual ou quais os artistas mais indicados a serem adicionados a uma determinada *playlist*, ou seja, qual vértice de artista que não está conectado ao vértice da *playlist* e que tem o maior grau de proximidade?**

&nbsp;
  R - Por exemplo, ao escolher uma playlist de sertanejo universitário, caso um novo artista faça sucesso e não esteja na playlist selecionada ele será indicado, visto que provavelmente estára em outras playlist fortemente relacionadas a escolhida.
  
**2. Existem artisas solitários,aqueles que estão contidos em apenas uma playlist?**

&nbsp;
  R - Há hipótese é de que isso possa acontecer, visto que em playlist muitos espécificas há artistas igualmente específicos.
  
**7. Qual a musica presente em mais *playlists*?**

&nbsp;
  R -

**3.** Existem comunidades de playlists no grafos, ou seja, grupos muito próximos de playlists? que estão um pouco afastados dos demais?

&nbsp;
  R - A ideia é de que sim, visto que muitas playlists compartilham artistas.
  
**4.** O grafo de duas playlists em que um mesmo artista está presente é conectado?

&nbsp;
  R -
  
**6. Será que o artista que está em um maior numero de playlists é o artista mais ouvido?**////como evidenciar a a proximidade das playlists?

&nbsp;
  R -
  
