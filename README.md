🚘 API REST - Concessionária

API REST desenvolvida com Java + Spring Boot + PostgreSQL para gerenciamento de clientes e veículos de uma concessionária.

O projeto segue arquitetura em camadas, boas práticas de desenvolvimento backend e documentação via Swagger.

🌑 Tecnologias Utilizadas
☕ Java
🌘 Spring Boot
🐘 PostgreSQL
🌑 Spring Data JPA
⚫ Maven
🐈 Git & GitHub
🌑 Swagger / OpenAPI
🌘 Funcionalidades
👤 Clientes
➕ Cadastro de clientes
🔎 Busca por nome ou CPF
❌ Remoção de clientes
🚗 Veículos
➕ Cadastro de veículos
🔎 Busca por placa, marca ou modelo
✏️ Atualização de veículos
❌ Remoção de veículos
⚙️ Estrutura do Projeto
src/main/java
│
├── controller
├── service
├── repository
├── entity
├── model
└── exception
🌑 Regras Implementadas
✅ Validação de dados obrigatórios
✅ Tratamento global de exceções
✅ Exceptions customizadas
✅ Retornos HTTP apropriados
✅ Integração com PostgreSQL
✅ Organização em camadas
✅ UUID como identificador
🚨 Tratamento de Erros

A API possui tratamento personalizado para erros comuns:

Status	Descrição
400	Dados inválidos
404	Recurso não encontrado
409	Conflito de dados (CPF/placa duplicados)

Exemplos implementados:

Cliente não encontrado
Veículo não encontrado
Placa já cadastrada
Valor de venda obrigatório quando veículo vendido
🌘 Endpoints Principais
👤 Cliente
Método	Endpoint
POST	/api/v1/cliente
GET	/api/v1/cliente
DELETE	/api/v1/cliente/{id}
🚗 Veículo
Método	Endpoint
POST	/api/v1/veiculo
GET	/api/v1/veiculo
PUT	/api/v1/veiculo/{id}
DELETE	/api/v1/veiculo/{id}
🌑 Exemplos de Busca
Buscar veículo por placa
GET /api/v1/veiculo?placa=ABC1234
Buscar veículo por marca
GET /api/v1/veiculo?marca=Toyota
Buscar veículo por modelo
GET /api/v1/veiculo?modelo=Corolla
⚫ Banco de Dados

Configure o PostgreSQL no arquivo:

src/main/resources/application.properties

Exemplo:

spring.datasource.url=jdbc:postgresql://localhost:5432/concessionaria
spring.datasource.username=postgres
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
🌘 Executando o Projeto
Clone o repositório
git clone <URL_DO_REPOSITORIO>
Execute o projeto
mvn spring-boot:run
🌑 Documentação Swagger

A documentação da API pode ser acessada após executar o projeto:

http://localhost:8080/swagger-ui/index.html
👨‍💻 Autor

Pedro Pinto Martins de Souza
