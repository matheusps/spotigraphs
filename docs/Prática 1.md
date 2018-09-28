# Prática 1

#### Grupo: Natan Ribeiro, Raimundo Heitor, Alessandro Fook, Wellington Araújo, Matheus Procópio


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

O grafo gerado pelos dados será construído considerando os artistas, playlist e música, como vértices, que estão conectados por arestas direcionadas entre si, como podemos visualizar na imagem abaixo:

![alt text](https://github.com/matheusps/spotigraphs/blob/master/imgs/graph.png "Prototipagem Grafo")

Dessa forma obtemos uma um dígrafo. Nesse digrafo temos que, uma playlist que 'possui' um artista assim como 'possui' uma música. Um artista, por sua vez, 'possui' uma música. Então, se existirem conjuntos de artistas que não se relacionam, teremos grafos desconectados.

## Perguntas a serem respondidas

**1. Qual ou quais os artistas mais indicados a serem adicionados a uma determinada *playlist*, ou seja, qual vértice de artista que não está conectado ao vértice da *playlist* e que tem o maior grau de proximidade?**

&nbsp;
  R - Ao escolher uma playlist de sertanejo universitário, caso um novo artista faça sucesso e não esteja na playlist selecionada ele será indicado, visto que provavelmente estará em outras playlist fortemente relacionada com a escolhida. Isso pode ser útil para a sugestões de tendências há playlist.
 
**2. Existem artistas exclusivos,aqueles que estão contidos em apenas uma playlist?**

&nbsp;
  R - Há hipótese é de que isso possa acontecer, visto que em playlist muitos específicas há artistas igualmente específicos. Portanto surge a necessidade de sanar a curiosidade:Qual/Quais artista(s) só eu gosto?

**3. Existem músicas exclusivas,aquelas que estão contidas em apenas uma playlist?**

&nbsp;
  R - Há hipótese é de que isso possa acontecer, visto que em playlist muitos específicas há músicas igualmente específicas.Portanto surge a necessidade de sanar a curiosidade:Qual/Quais musica(s) só eu gosto?


**4. Qual a música mais popular, aquela presente em mais *playlists*?**

&nbsp;
  R - Saber Qual é a música do momento é sempre uma informação bem vinda para o público do aplicativo e sugestões de hits.
