# 🚀 OrderFlow

O OrderFlow é uma API REST desenvolvida durante o desafio de **Design Patterns com Java** da Digital Innovation One.

Ao invés de apenas reproduzir o projeto apresentado, optei por evoluir a implementação adicionando documentação com Swagger/OpenAPI, testes automatizados e uma organização em camadas para aproximar a aplicação de um cenário real de desenvolvimento.

O objetivo foi aplicar padrões de projeto em um fluxo de criação de pedidos, mantendo o código desacoplado, organizado e de fácil manutenção.

---

# Tecnologias Utilizadas

- Java 17
- Spring Boot 3.3.5
- Spring Data JPA
- H2 Database
- Maven
- Swagger / OpenAPI
- JUnit 5
- Hibernate

---

# Padrões de Projeto Aplicados

### Strategy

Escolhi o padrão Strategy para desacoplar as regras de pagamento.

Cada forma de pagamento possui sua própria implementação, permitindo adicionar novos métodos sem alterar o restante da aplicação.

Implementações:

- PIX
- Cartão de Crédito
- Boleto

---

### Facade

O padrão Facade foi utilizado para centralizar o fluxo de criação dos pedidos.

Dessa forma o Controller permanece simples, delegando toda a lógica de negócio para uma única fachada responsável pela orquestração do processo.

---

### Chain of Responsibility

As validações foram organizadas utilizando Chain of Responsibility.

Cada validação possui uma única responsabilidade, facilitando futuras expansões sem modificar o fluxo existente.

---

## Singleton

Utilizado através do gerenciamento de Beans realizado pelo Spring Framework.

---

# Estrutura do Projeto

```
src
 ├── controller
 ├── dto
 ├── entity
 ├── facade
 ├── patterns
 │    ├── strategy
 │    └── chain
 ├── repository
 ├── service
 └── OrderFlowApplication.java
```

---

# Como Executar

## Clone o projeto

```bash
git clone https://github.com/SEU-USUARIO/orderflow-design-patterns.git
```

Entre na pasta

```bash
cd orderflow-design-patterns
```

Execute

```bash
mvn spring-boot:run
```

A aplicação será iniciada em:

```
http://localhost:8080
```

---

# Documentação da API

Após iniciar a aplicação, acesse:

### Swagger UI

```
http://localhost:8080/swagger-ui/index.html
```

### OpenAPI JSON

```
http://localhost:8080/v3/api-docs
```

---

# Endpoints

## Criar Pedido

```
POST /api/orders
```

Exemplo:

```json
{
  "customerName": "Leandro Martins Paes",
  "customerEmail": "leandro@email.com",
  "amount": 250.00,
  "paymentType": "PIX"
}
```

Resposta:

```json
{
  "id": 1,
  "customerName": "Leandro Martins Paes",
  "customerEmail": "leandro@email.com",
  "amount": 250.0,
  "paymentType": "PIX",
  "status": "PAID",
  "finalAmount": 237.5,
  "paymentMessage": "Pagamento via PIX aprovado com 5% de desconto."
}
```

---

## Listar Pedidos

```
GET /api/orders
```

---

## Buscar Pedido

```
GET /api/orders/{id}
```

---

# Banco de Dados H2

Console do H2:

```
http://localhost:8080/h2-console
```

Configuração:

```
JDBC URL:
jdbc:h2:mem:orderflow

Usuário:
sa

Senha:
(vazia)
```

---

# Testes

O projeto possui testes unitários para:

- Strategy Pattern
- Chain of Responsibility

Executar:

```bash
mvn test
```

---

# Demonstração

- Swagger/OpenAPI funcionando
- Cadastro de pedidos
- Consulta de pedidos
- Persistência em banco H2
- Aplicação do desconto via Strategy (PIX)

---

# Autor

**Leandro Martins Paes**

Projeto desenvolvido como desafio de conclusão do módulo **Design Patterns com Java** da **Digital Innovation One (DIO)**.