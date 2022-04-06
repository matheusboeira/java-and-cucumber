# Projeto de Testes - Silver Bullet

Antes de prosseguir para a execução dos testes, será necessário o uso de alguma IDE disponível no mercado. Desta forma, aconselha-se a utilizar uma das seguintes IDE's: 

- [Intellij IDEA](https://www.jetbrains.com/pt-br/idea/download); ou
- [Eclipse](https://www.eclipse.org/downloads).
  
Além disso, possuir o **Java JDK 11 ou superior** instalado na máquina. 

### Intellij IDEA

No Intellij IDEA, serão necessários dois plugins para conseguir realizar a execução dos testes, os quais são: _**Gherkin**_ e _**Cucumber for Java**_ que poderão ser instalados no _marketplace_ da ferramenta. Salvo para àqueles que possuem a versão Ultimate do Intellij, cujos plugins já vêm na própria instalação. 

- Gherkin: para melhorar o suporte na criação dos cenários.
- Cucumber for Java: para melhorar a assistência de código/suporte total e para habilitar um _**Run/Debug**_ exclusivo para a execução dos testes (_RunCucumberTest_, neste cenário).

Para uma melhor visualização:

![Plugins para o Intellij IDEA](https://user-images.githubusercontent.com/76896958/161881128-8099b90d-6c92-4c75-af16-3d4d86dd6fef.png)

O plugin _**Cucumber for Groovy**_ é opcional, visto que não afeta diretamente ou indiretamente este cenário.

### Eclipse 

No Eclipse, o único plugin necessário será o _**Cucumber Eclipse Plugin**_ que poderá ser instalado no _marketplace_ da ferramenta.
  
# Estrutura do Projeto

O projeto consiste em basicamente três passos: 

1. Mapear os elementos da página;
1. Criar os cenários para os Casos de Uso; e
1. Executar os testes através da classe _RunCucumberTest_. 

Ressaltando que estes poderão, em algum momento, possuir mais um passo: a criação de novos métodos vinculadas às novas frases da linguagem _Gherkin_.

## Arquivo de Propriedades

Neste arquivo, é onde está localizado as principais informações para a realização dos testes. Aqui, é configurado o navegador a ser utilizado, as credenciais do usuário e a *URL* de origem. Por enquanto, esta se mantém em texto puro. Nada criptografado.

Segue a imagem abaixo:

![Arquivo project.properties](https://user-images.githubusercontent.com/76896958/161885351-70bd34b7-e9b0-4b55-a2c3-c1c29c8cc9bb.png)

## Arquivo de Repositório

Neste arquivo, é onde está localizado o mapeamento de todos os elementos de uma determinada página. Cada página possui um nível superior e as partes indentadas (para dentro) fazem parte desta página. Além disso, todos os elementos são mapeados via _xpath_, visando uma padronização consistente para o projeto. Além disso, optou-se por realizar este método uma vez que o mesmo facilita na manutenibilidade destes elementos.

Para exemplificar, segue a imagem abaixo:

![Repositório dos Elementos](https://user-images.githubusercontent.com/76896958/161885904-4aff0b69-e438-4f4d-be14-35a29014f57c.png)

Onde "LoginPage" é a página, "txtEmail" é um text-field desta página e o que está entre aspas duplas (") é o elemento em _xpath_. Assim se dá nas restantes, onde "ProjectPage" é uma página, "btnOpen" é um botão desta página e a referência para esse botão (para o Selenium) está mapeado entre as aspas duplas ("), que neste caso está vazio.

## Features/Cenários

Os cenários serão desenvolvidos utilizando a linguagem _Gherkin_ e utilizando a extensão _.feature_. Desta forma, os cenários serão feitos através de uma linguagem natural vinculada a um método. Para uma melhor exemplificação, segue a imagem abaixo seguida de sua explicação:

![Cenário Exemplo](https://user-images.githubusercontent.com/76896958/161890299-0c1faafd-04c5-47e9-ab25-433b4bac1998.png)

Neste cenário, nós temos as definições das tags _@All_, _@UC01_ e _@LoginUser_. Estas tags servem para referenciar qual "arquivo" será executado na classe _RunCucumberTest_ (mais a frente a exemplificação). Onde _@All_ estará contida em TODOS os testes, uma vez que chamando esta tag, é possível realizar todos os testes em sequência, sem ficar alternando-as. 

Além disso, nota-se que os campos de cor ROXA são palavras reservadas pela linguagem. A definição em aspas duplas entre o sinal de menor e maior é uma variável, utilizada para exemplificar ('examples') e o destacado em laranja são 'strings' que serão enviadas para os métodos. Em resumo:

- Feature: o nome a ser dado para o arquivo/funcionalidade (neste caso, o nome do UC foi utilizado)
- Scenario/Scenario Outline: o nome do cenário (outline só será utilizado se houver 'examples')
- Given, When, And, Then: apenas conectivos para o contexto atual + frase personalizada
- Examples: os exemplos que serão testados (username deve ser 'test' na asserção do método)

### Métodos Vinculados

Nota-se então, que a linguagem natural deve ser referenciada de alguma forma. Com isso, os métodos devem estar "amarrados" com as tags do Cucumber seguido da linguagem natural. De tal forma, um exemplo simples:

![Método 'closes the browser'](https://user-images.githubusercontent.com/76896958/161893639-98ecd9b6-6956-4f91-8b70-b622cb2ed0cb.png)

Desta forma, a tag '@And' seguida do mesmo texto que há na feature, determinará qual método será executado. Com isso, se o criador do cenário escrever "the user closes the browser", este método será chamado. E assim se dá nas outras frases. Uma observação: não necessariamente a tag vinculada deve ser exatamente a mesma do cenário. Já o texto, ele deve ser exato.

Neste caso, foi mostrado apenas um exemplo simples e com apenas um cenário. Para o arquivo completo: [clique aqui.](/src/test/resources/features/UC01.feature)


