# Desafio Fullstack - Java

Bem vindo ao desafio *Fullstack - Java do Desenvolvimento Jurídico*.

Neste desafio apresentamos a você um projeto voltado ao perfil Fullstack. Temos o *Backend* em Java e o *Frontend* em [Angular](https://angular.io/).

Optamos pelo Front ser em [Angular](https://angular.io/) pois é o que será utilizado diariamente e o Back em Java por ser a mais conhecida entre os analistas.

Outro detalhe é que utilizamos o [PO-UI](https://po-ui.io/) como *Design System* neste projeto pois é o padrão da empresa. Utilize os demais componentes presentes na biblioteca dele para criar as próximas interfaces. A documentação é bem rica e contem a sessão de exemplos de uso de cada componente para entender como ele funciona.

## Escopo do desafio

O sistema é um cadastro de Pontos turisticos. 

Ele contem três classes: `País`, `Ponto Turístico` e `Comentário`.

O `Ponto turístico` é a classe principal do Projeto. Ela está amarrada à Classe `País` que o agrupa e tem a classe `Comentário` que a referência.

## O que deve ser feito

No projeto atual cuidamos de criar a estrutura principal do projeto e criamos o CRUD do País para que utilize como base para resolver os proximos passos.

Dito isso, solicitamos que desenvolva as seguintes funcionalidades:

- CRUD de Ponto Turistico
- CRUD de Comentário

Dentro dessas funcionalidades temos as seguintes necessidades:

- Ao cadastrar o Ponto turistico desejo informar alem do País, a cidade, o nome do ponto turístico, qual a melhor estação para visita-la e desejo ver um resumo do Ponto turístico.

- Cada ponto turistico poderá ter vários comentários. Cada comentário deverá mostrar o Nome do autor, o comentário e a data em que foi criado.

- Se possível gostaria de visualizar a lista de comentários sempre que entrar em um ponto turístico e se não houver um comentário, que a pagina me convide a ser o primeiro a comentar sobre o lugar.


## Como deverá ser entregue o projeto

A entrega final será o próprio repositório do projeto. Realize uma cópia dele para o seu perfil do GitHub e realize todos os ajustes que entender necessário para resolver os problemas acima.

## Alguns pontos relevantes!

### No Front-end
A parte do Front tem uma estrutura criada mas é uma "sugestão" de estrutura. Visto que há muitas pessoas acostumadas a utilizar `React` resolvemos criar a estrutura base para agilizar o desenvolvimento. Porem essa estrutura pode ser alterada se desejar. 

Somente não altere os componentes iniciais de cada tela `po-page-default` e `po-page-detail`. 

### No Back-end

No projeto Java já definimos algumas pastas:

- Controller
  - Crie nela as classes RestController
- Domain
  - Crie as classes de persistência
- Service
  - Crie as classes de regra de negócio.
- Service.dto
  - Crie as classes de transferência de dados

Pedimos que respeite essa hierarquia de pastas.

### Controle de versão

Para o controle de versão incentivamos que crie quantos commits quiser, crie quando desejar

Outro ponto importante é que somente iremos considerar os commits realizados até o envio do e-mail. Os commits que forem realizados após o horário de envio não serão considerados na avaliação.

Após a realização do ultimo commit não esqueça de fazer o `Push` para o repositório!

### Outros detalhes

Documente as funcionalidades, dê o maximo de detalhe que puder, isso irá nos auxiliar durante a avaliação.

Por fim, boa sorte e até logo.
