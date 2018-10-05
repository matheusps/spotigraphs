## Prática 2

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

## Spotigraphs


#### Grupo: Natan Ribeiro, Raimundo Heitor, Alessandro Fook, Wellington Araújo, Matheus Procópio


### Contextualização

O Vagalume é um portal de música do Brasil criado em 2002, que utiliza a linguagem PHP e possui o banco de dados MySQL para inicialmente criar uma pequena base de letras de músicas. Nele, existe um serviço de recomendação de *playlists* onde, ao final da execução de uma certa *playlist*, o serviço costuma recomendar músicas com base nas relações existentes entre músicas e artistas, ou entre playlists.

Dessa forma, para o estudo proposto, utilizamos a seguinte base de dados:

Corresponde a um subconjunto de listas de músicas (*playlists*) do vagalume, extraída a partir da [base de dados](https://media.githubusercontent.com/media/felipevieira/computacao-e-musica-lsd/master/sbcm-2017/Datasets/MPSD%20v1.0.csv)  que contém informações sobre as músicas nela contidas e os artistas relacionados com cada música.
Com isso se fez necessário uma sequência de filtros que padronizasse o conjunto de dados do nosso estudo, utilizando a linguagem R, de forma que executamos os seguintes comandos:

* Importing library
```{r setup, include=FALSE}
setwd("~/Documents/workspace/spotigraphs/docs")
library(magrittr)
library('rvest')
```

* From a large frame filter and select a few number of artists.
```{r}
#Manipulate dataframe to remove unnecessary information
dataframe <- read.csv("spotigraph-database.csv") 
keeps <- c("artist_name", "playlist_name")
dataframe2 <- dataframe[keeps] %>% unique
dataframe3 <- dataframe2[!grepl(",|&", dataframe2$artist_name),]
dataframe4 <- dataframe3[grep("^[A-Za-z]+$", dataframe3$artist_name),]

#Create a dataframe to use as filter
frame_filter1 <- as.data.frame(table(unlist(dataframe4$playlist_name)))
frame_filter2 <- frame_filter1[!grepl("Playlist|,|\"|[|]", frame_filter1$Var1),]
frame_filter3 <- frame_filter2[grep("^[A-Za-z]+$", frame_filter2$Var1),]
frame_filter4 <- subset(frame_filter3, subset = (Freq > 10 & Freq < 20))
frame_filter5 <- frame_filter4[sample(nrow(frame_filter4), 30),]

#Filter dataframe and save to a csv file
subset1 <- subset(dataframe4, playlist_name %in% frame_filter5$Var1)
subset2 <- aggregate(subset1$playlist_name,subset1['artist_name'],paste,collapse=',')
colnames(subset2) <- c("artist", "playlists")

#Specifying the url for desired website to be scrapped
url_base <- 'https://www.vagalume.com.br/'
url_rest <- '/relacionados/'

#Scraping related artists 
subset2["related"] <- NA

for (i in 1:dim(subset2)[1]) {
  relacionados <- tryCatch({html_nodes(read_html(paste(url_base,gsub(" ", "-",tolower(as.character(subset2$artist[i]))),url_rest, sep = "")),'p.h22.w1.itemTitle') %>% html_text},error=function(cond){message(cond)})
  subset2$related[i] <- paste(unlist(list(relacionados)), collapse = ",")
}

write.csv(subset2, file = "filter-artists.csv", row.names = FALSE)
```
Como resultado desses sucessivos filtros, obtivemos [essa base de dados](../docs/filter-artists.csv) que nos responderá os questionamentos propostos no proximo topico.

### Problemas



### Grafo

