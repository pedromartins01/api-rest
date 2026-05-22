# 🚘 API REST - Concessionária

API REST desenvolvida com Java + Spring Boot + PostgreSQL para gerenciamento de clientes e veículos de uma concessionária.

## 🌑 Tecnologias Utilizadas

- ☕ Java
- 🌘 Spring Boot
- 🐘 PostgreSQL
- 🌑 Spring Data JPA
- ⚫ Maven
- 🐈 Git & GitHub

## 🌘 Funcionalidades

### 👤 Clientes
- ➕ Cadastro de clientes
- 🔎 Busca por nome ou CPF
- ❌ Remoção de clientes

### 🚗 Veículos
- ➕ Cadastro de veículos
- 🔎 Busca por placa, marca ou modelo
- ✏️ Atualização de veículos
- ❌ Remoção de veículos

## ⚙️ Estrutura do Projeto
src/main/java
- controller
- service
- repository
- entity
- model
- exception

## 🌑 Regras Implementadas

- ✅ Validação de dados obrigatórios
- ✅ Tratamento global de exceções
- ✅ Exceptions customizadas
- ✅ Retornos HTTP apropriados
- ✅ Integração com PostgreSQL
- ✅ Organização em camadas
- ✅ UUID como identificador

## 🚨 Tratamento de Erros

| Status | Descrição |
|--------|-----------|
| 400 | Dados inválidos |
| 404 | Recurso não encontrado |
| 409 | Conflito de dados (CPF/placa duplicados) |

## 🌘 Endpoints Principais

### 👤 Cliente

| Método | Endpoint |
|--------|----------|
| POST | /api/v1/cliente |
| GET | /api/v1/cliente |
| DELETE | /api/v1/cliente/{id} |

### 🚗 Veículo

| Método | Endpoint |
|--------|----------|
| POST | /api/v1/veiculo |
| GET | /api/v1/veiculo |
| PUT | /api/v1/veiculo/{id} |
| DELETE | /api/v1/veiculo/{id} |

## 🌑 Exemplos de Busca

**Buscar por placa:**

`GET /api/v1/veiculo?placa=ABC1234`

**Buscar por marca:**

`GET /api/v1/veiculo?marca=Toyota`

**Buscar por modelo:**

`GET /api/v1/veiculo?modelo=Corolla`

## ⚫ Banco de Dados

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/concessionaria
spring.datasource.username=postgres
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
```

## 🌘 Executando o Projeto

```bash
git clone <URL_DO_REPOSITORIO>
mvn spring-boot:run
```

## 👨‍💻 Autor

Pedro Pinto Martins de Souza
