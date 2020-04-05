# JAVA-Bank-Transactions

Simule as principais transações financeiras de uma instituição bancária.

## Pré-requisitos

Java 11.

Maven.

### Montando ambiente:

Baixar o projeto usando o comando git clone.

Executando pela linha de comando na pasta da raiz do projeto, crie o jar do projeto: 
```
./mvnw clean install
```

Para executar os testes unitários, use o comando: 
```
./mvnw test
```
### Acesso a documentação com Swagger:

Para acessar a documentação gerada automaticamente pelo swagger no navegador, o projeto deverá estar sendo executado, depois acesse o link:
```
http://localhost:4200/swagger-ui.html
```
Para acessar a documentação usando o link http://editor.swagger.io/, utilize o arquivo da pasta resources :
```
swagger-api-bank.yaml
```
### Acesso as collections usando o Postman:

Faça o download do arquivo na pasta resources :
```
postman_collection.json
```
Import o arquivo no postman para acessar as collections.

