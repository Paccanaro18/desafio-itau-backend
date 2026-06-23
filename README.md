# Desafio Itaú Backend - Vaga Júnior

API REST desenvolvida como solução para o desafio técnico do Itaú Unibanco.

## 📋 Sobre o projeto

API que recebe transações financeiras e retorna estatísticas em tempo real,
utilizando armazenamento em memória sem uso de banco de dados.

## 🚀 Tecnologias

- Java 17
- Spring Boot 3
- Maven

## 📌 Endpoints

### POST /transacao
Recebe uma transação com `valor` e `dataHora`.
- Retorna `201 Created` se a transação for válida
- Retorna `422 Unprocessable Entity` se a transação for inválida
- Retorna `400 Bad Request` se o JSON for inválido

### DELETE /transacao
Apaga todas as transações armazenadas em memória.
- Retorna `200 OK`

### GET /estatistica
Retorna estatísticas das transações dos últimos 60 segundos.
- Retorna `count`, `sum`, `avg`, `min` e `max`

## ✅ Regras de negócio

- Transações com valor negativo não são aceitas
- Transações com data futura não são aceitas
- Campos `valor` e `dataHora` são obrigatórios
- Todos os dados são armazenados em memória
