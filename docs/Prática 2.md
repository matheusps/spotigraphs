# Prática 2

#### Grupo: Natan Ribeiro, Raimundo Heitor, Alessandro Fook, Wellington Araújo, Matheus Procópio

### O que deve ser entregue?
• Um relatório que será incrementado nas próximas etapas. Por hora, o relatório deve ter
a seguinte estrutura:
* 1. Título
* 2. Contextualização
Aqui o grupo deve discutir a base de dados escolhida, em qual contexto ela está
inserida, etc.
* 3. Problemas
Discutir os problemas serão investigados usando a base de dados escolhida e
elementos da Teoria dos Grafos. Por que esse problema é interessante? Quais
hipótese serão confirmadas/refutadas?
* 4. Grafo
    * a. Apresentação da representação do grafo (imagem).
    * b. Layout
      Qual layout de apresentação foi escolhido? Justifique a escolha.
---------------------------------------------------------------------------------------------------

## Spotigraphs (Titulo sugerido!)

### Contextualização

O Vagalume é um portal de música do Brasil criado em 2002, que utiliza a linguagem PHP e possui o banco de dados MySQL para inicialmente criar uma pequena base de letras de músicas. Nele, existe um serviço de recomendação de *playlists* onde, ao final da execução de uma certa *playlist*, o serviço costuma recomendar músicas com base nas relações existentes entre músicas e artistas, ou entre playlists.

Dessa forma, para o estudo prosposto, foram selecionadas duas bases de dados:

- A primeira base de dados selecionada para o estudo corresponde a um subconjunto de listas de músicas (*playlists*) do *vagalume*, extraída a partir da [base de dados](https://media.githubusercontent.com/media/felipevieira/computacao-e-musica-lsd/master/sbcm-2017/Datasets/MPSD%20v1.0.csv)  que contém informações sobre as músicas nela contidas e os artistas relacionados com cada música seguindo o modelo abaixo:

```bash
class Playlist {
    name: string,
    musics: music[]
}

class Music {
    name: string,
    artists: Artist[]
}
```

- A segunda base de dados, contém os artistas com sua lista de artistas relacionados, seguindo o modelo abaixo:

```bash
class Artist {
    nome: string,
    relacionados: Artist[]
}
```
### Problemas



## Grafo
