# Roteiro de entrega do desafio

## Descrição

O **OrderFlow** é uma API REST criada em Java e Spring Boot para demonstrar a
aplicação prática de padrões de projeto em um fluxo de pedidos.

## Problema

Um sistema de pedidos pode possuir diversas formas de pagamento e regras de
validação. Se toda a lógica for colocada diretamente no controller ou em uma
única classe de serviço, o código tende a ficar fortemente acoplado e difícil
de evoluir.

## Solução

Foram aplicados quatro padrões:

**Strategy:** encapsula algoritmos de pagamento diferentes.

**Facade:** fornece uma interface simplificada para o processo completo de
criação do pedido.

**Chain of Responsibility:** organiza validações como etapas independentes.

**Singleton:** demonstrado pelo ciclo de vida padrão dos beans gerenciados
pelo Spring.

## Diferencial em relação ao laboratório

Em vez de apenas reproduzir os exemplos, o projeto aplica os padrões em um
novo domínio e adiciona Chain of Responsibility, testes automatizados,
validação de entrada, tratamento global de erros e persistência em banco H2.

## Conclusão

O projeto mostra que Design Patterns não são apenas estruturas teóricas:
eles ajudam a manter o código extensível, organizado e com responsabilidades
bem definidas.
