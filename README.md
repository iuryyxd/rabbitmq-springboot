# rabbitmq-springboot

Projeto de estudo de mensageria com RabbitMQ e Spring Boot. Uma aplicação publica mensagens (texto e JSON) em filas do RabbitMQ e um consumer as recebe.

## Tecnologias

- Java 21
- Spring Boot 4.1.2 (AMQP e Web MVC)
- RabbitMQ
- Maven
- Lombok

## Estrutura

Os pacotes ficam em `src/main/java/dev/tech/rabbitmq_springboot`:

- `config`: declaração de filas, exchange e bindings
- `publisher`: envio de mensagens
- `consumer`: recebimento de mensagens
- `controller`: endpoints REST para disparar as mensagens
- `dto`: objetos usados nas mensagens JSON

## Pré-requisitos

- JDK 21
- RabbitMQ rodando em `localhost:5672` (usuário e senha `guest`)

Exemplo de RabbitMQ com Docker:

```bash
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```

O painel de administração fica em http://localhost:15672.

## Configuração

As filas, a exchange e as routing keys são definidas em `src/main/resources/application.properties`.

## Como executar

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
mvnw.cmd spring-boot:run
```

## Testes

```bash
./mvnw test
```
