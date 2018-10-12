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
Para se realizar a análise do grafo definimos como vértices os artistas e como arestas os artistas que possui alguma relação com os mesmos, tal relação é obtida através das playlists dos artistas. Tal estrutura nos permite iterar sobre os vértices e encontrar as repostas para as perguntas a seguir. Abaixo temos as questões propostas e como pretendemos usar da dados e da teoria dos grafos para solucioná-los.

**1. Qual ou quais os artistas mais indicados a ser executado após o término da *playlist*, ou seja, qual vértice que não está presente na *playlist*, mas encontra-se conectado ao vértice de um, ou mais, artista(s) já relacionado(s) a *playlist* e que tem o maior grau de proximidade(*playlists* em comum)?**

Motivo: Esse é um problema recorrente em sistemas de transmissão de mídias e que tem como principal propósito manter o usuário acessando o sistema sem haver uma interrupção da execução de sua playlist. Porém para se evitar um contraste de estilos entre o que está em reprodução e o que o sistema sugere se torna necessário um algoritmo que busque sempre os mais apropriados para serem adicionados/sugeridos a playlist. Tal algoritmo é o que desejamos encontrar para resolver este problema.

Metodologia: Neste problema temos como objetivo encontrar um vértice(que representa um artista) que não esteja presente no conjunto de vértice(que representa a playlist) e que tenha o maior grau de proximidade com a playlist. O grau de proximidade é definido como o número de vezes que um artista,não contido no conjunto da playlist, aparece no conjunto de relacionados dos artistas contidos na playList, Ou seja para cada artista da playlist verifica os seus artistas relacionados e aqueles que não estiverem na playlist são selecionados como possíveis candidatos a indicações, Depois que todos os artistas forem verificados poderá observar aqueles que mais se repetiram dentre os candidatos indicados e com isso realizar uma sugestão mais apropriada.

 
**2. Existem artistas exclusivos, aqueles que estão contidos em apenas uma *playlist*? Dados dois artistas, que não estão na lista de relacionados entre si, é possível caminhar de um até o outro usando o grafo?**

Motivo: A ideia desse problema é encontrar quais os artistas mais isolados, ou seja, aqueles que tem menos proximidade com os outros. A descoberta de tais artistas se torna útil para o cadastro de novos artistas semelhantes ou relacionados no sistema e com isso impedir artistas isolados ao mesmo tempo que expande a oferta de artistas para os clientes, se tornando bastante útil por exemplo em sucessos momentâneos regionais onde novos artistas surgem e com isso o sistema pode cadastrar cada vez mais relacionados de acordo com a tendência.

Metodologia: Neste problema será feita uma varredura entres os artistas e verificando se há um caminho entre eles, os artistas que não possuírem caminhos entre eles significa que não estão relacionados de nenhuma maneira, logo estão em grafos desconexos e com isso isolados.


**3. Quais *playlists* formam grafos conectados e quais são heterogêneos considerando os artistas que as compõem?**

Motivo: Esse problema tem como Objetivo identificar playlists mais coesas, ou seja, as playlists cujo seus artistas tem relações com outros artistas da mesma playlists, identificando assim um conjunto que pode representar um determinado gênero, uma região ou um período temporal de artistas.

Metodologia: Ao percorrer o grafo é possível determinar se há um caminho entre dois artistas e ao fazer isso pode encontrar macrorregiões de artistas conectados entre si ou heterogêneas. 

**4. Qual(ais) o(s) artista(s) mais popular(es), aquele presente em mais *playlists*?**

Motivo: Outro problema bastante comum é sistemas  de mídia é determinar quais as tendências do momento, ou seja, quais os artistas que estão fazendo mais sucesso.

Metodologia: Essa problema pode ser resolvido fazendo uma intersecção entre as playlist e obtendo os artistas mais comum a todas.




### Grafo

Para visualização e manipulação gráfica dos nossos dados utilizamos a ferramenta *Gephi*, um *software* de análise e visualização de redes de código aberto escrito em Java. A partir dessa ferramenta, podemos obter o seguinte grafo para todos os dados em estudo:

![](../img/……….)

Este grafo contém … nós e … arestas, de modo que os artistas são os nós que estão conectados por arestas direcionadas entre si, com peso contabilizando o número de *playlists* em que ambos fazem parte.

Assim, podemos definir diferentes *layouts*, a partir do grafo acima, para respondermos questionamentos que surgirem, como podemos ver abaixo:

![](../img/……….)
