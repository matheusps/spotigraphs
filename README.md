# Spotigraphs

Problem: Define how heterogenic a playlist is.

Questions:
*TODO*

### Data Model

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

### Modeling into a Digraph

1. Extract all artists from the playlist
2. Each artist will be a vertice in the digraph
3. Given the artists Dubdogz and Sevenn, an directed edge will exist from Dubdogz to Sevenn if Dubdogz's related's-list contains Sevenn.
4. A playlist will be completly heterogenic if the digraph is disconected