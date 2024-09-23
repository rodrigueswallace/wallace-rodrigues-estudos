# API de Verificação de Status de Usuário (Nome e Idade)

API que recebe o nome e idade do usuário e retorna uma mensagem indicando se o acesso é permitido ou não com base na idade fornecida.

## Principais Tecnologias Utilizadas:

- Java JDK 21
- Postman

## Como Instalar e Rodar:

- Clone o repositorio do GitHub usando Git bash

### 1. Clonar o repositório

Primeiro, você precisa baixar o código do repositório, abra o Git Bash e execute o comando de clonagem:

```bash
git clone https://github.com/usuario/repositorio.git
```

### 2. Entrar no diretório do projeto

Após clonar o repositório, navegue até o diretório do projeto:

```bash
cd wallace-rodrigues-estudos/sprint-05-semana-07/src/main/java/com/wallace/spring7
```

### 3. Compilar o projeto com Maven

Antes de rodar o projeto, compile-o usando Maven para garantir que todas as dependências sejam baixadas e o projeto esteja pronto para ser executado. No terminal, rode o comando:

```bash
mvn clean install
```

### 4. Rodar o projeto

```bash
mvn spring-boot:run
```

## Como Usar:

### 5. Teste a API com Postman

#### Exemplo de como fazer isso:

##### 1. Abrir o Postman.

##### 2. Criar uma nova requisição.

          - Selecione o método HTTP
          - No campo de URL, coloque o endereço da sua API, como:

          ````bash
          http://localhost:8080/api/v1/pessoas
          ````

##### 3. Definir o corpo da requisição

        - selecione a aba Body no Postman.

        - Escolha a opção raw e selecione o formato JSON no menu suspenso.

        - Insira o JSON que a sua API espera. Exemplo:

        ````json
        {
            "name": "John Travolta",
            "age": 70
        }
        ````

##### 4. Enviar a requisição:

        - Clique no botão Send.

        - O Postman mostrará a resposta JSON que sua API retorna, como:

        ````bash
        {
            "name": "John Travolta",
            "message": "Entry Allowed"
        }
        ````
