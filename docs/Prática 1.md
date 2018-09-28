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
  R - Ao escolher uma playlist de sertanejo universitário, caso um novo artista faça sucesso e não esteja na playlist selecionada ele será indicado, visto que provavelmente estára em outras playlist fortemente relacionada com a escolhida. Isso pode ser útil para a sugestões de tendências há playlist.
  
**2. Existem artisas exclusivos,aqueles que estão contidos em apenas uma playlist?**

&nbsp;
  R - Há hipótese é de que isso possa acontecer, visto que em playlist muitos espécificas há artistas igualmente específicos. Portanto surge a necessidade de sanar a curiosidade:Qual/Quais artista(s) só eu gosto?

**3. Existem músicas exclusivas,aquelas que estão contidas em apenas uma playlist?**

&nbsp;
  R - Há hipótese é de que isso possa acontecer, visto que em playlist muitos espécificas há músicas igualmente específicas.Portanto surge a necessidade de sanar a curiosidade:Qual/Quais musica(s) só eu gosto?


**4. Qual a musica mais popular, aquela presente em mais *playlists*?**

&nbsp;
  R - Saber Qual é a música do momento é sempre uma informaão bem vinda para o publico do aplicativo e sugestões de hits.


