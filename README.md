# 🚀 OrderFlow - API de Gerenciamento de Pedidos

API REST desenvolvida com **Spring Boot 3** para demonstrar a aplicação de **Design Patterns (Padrões de Projeto)** em Java, como parte do desafio da Digital Innovation One (DIO).

## 📋 Objetivo

O projeto simula um sistema de gerenciamento de pedidos com diferentes formas de pagamento, aplicando padrões de projeto para tornar o código desacoplado, extensível e de fácil manutenção.

---

# 🛠 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.3.5
- Spring Data JPA
- H2 Database
- Maven
- Swagger / OpenAPI
- JUnit 5
- Hibernate

---

# 📐 Padrões de Projeto Aplicados

## ✅ Strategy

Utilizado para definir diferentes estratégias de pagamento.

Exemplos:

- PIX
- Cartão de Crédito
- Boleto

Cada forma de pagamento possui sua própria implementação.

---

## ✅ Facade

Centraliza todo o fluxo de criação do pedido, simplificando a comunicação entre Controller, validações, estratégias de pagamento e persistência.

---

## ✅ Chain of Responsibility

Responsável pelas validações antes da criação do pedido.

Exemplos:

- Nome obrigatório
- Email obrigatório
- Valor maior que zero

---

## ✅ Singleton

Utilizado através do gerenciamento de Beans realizado pelo Spring Framework.

---

# 📂 Estrutura do Projeto

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

# ▶ Como Executar

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

# 📖 Documentação da API

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

# 🗄 Banco de Dados H2

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

# ✅ Testes

O projeto possui testes unitários para:

- Strategy Pattern
- Chain of Responsibility

Executar:

```bash
mvn test
```

---

# 📷 Demonstração

- Swagger/OpenAPI funcionando
- Cadastro de pedidos
- Consulta de pedidos
- Persistência em banco H2
- Aplicação do desconto via Strategy (PIX)

---

# 👨‍💻 Autor

**Leandro Martins Paes**

Projeto desenvolvido como desafio de conclusão do módulo **Design Patterns com Java** da **Digital Innovation One (DIO)**.