
# Business Management

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-555555?style=for-the-badge&logo=apachemaven&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

## Descrição

O **Business Management** é uma aplicação desenvolvida para gerenciar operações empresariais, incluindo funcionalidades como cadastro de lojas, funcionários e muito mais.

## Funcionalidades

- **Gerenciamento de Lojas**: Cadastro, atualização e remoção de lojas.
- **Gerenciamento de Funcionários**: Cadastro, atualização e remoção de funcionários associados às lojas.

## Tecnologias Utilizadas

- **Java 21**: Linguagem principal do projeto.
- **Spring Boot**: Framework para criação de aplicações Java.
- **Mysql**: Banco de dados relacional utilizado para armazenar as informações.
- **Docker**: Utilizado para containerização da aplicação.
- **Maven**: Gerenciador de dependências e construção do projeto.

## Pré-requisitos

Antes de iniciar, certifique-se de ter instalado:

- [Java 21](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html)
- [Docker](https://www.docker.com/get-started)
- [Maven](https://maven.apache.org/download.cgi)

## Instalação e Execução

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/Gabriel7576/business_management.git
   ```

2. **Navegue até o diretório do projeto**:

   ```bash
   cd business_management
   ```

3. **Configure o banco de dados**:

   ```bash
   docker compose -f docker-compose.yml -p business_management up -d
   ```

4. **Construa o projeto**:

   ```bash
   mvn clean install
   ```

5. **Execute a aplicação**:

   ```bash
   .\mvnw spring-boot:run  
   ```

   A aplicação estará disponível em `http://localhost:8081`.

## Uso

A API oferece endpoints para gerenciar lojas e funcionários. Aqui estão alguns exemplos:

- **Criar uma nova loja**:

  ```http
  POST /store
  ```

  Corpo da requisição:

  ```json
  {
    "name": "string",
    "address": "string",
    "phone": "string",
    "email": "string"
  }
  ```

- **Listar todas as lojas**:

  ```http
  GET /store
  ```

- **Atualizar uma loja existente**:

  ```http
  PUT /store/{id}
  ```

  Corpo da requisição:

  ```json
  {
    "name": "string",
    "address": "string",
    "phone": "string",
    "email": "string"
  }
  ```

- **Deletar uma loja**:

  ```http
  DELETE /store/{id}
  ```


Substitua `{id}` pelo ID da loja que deseja atualizar ou deletar.

## Contribuição

Contribuições são bem-vindas! Para contribuir:

1. Faça um fork do projeto.
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`).
3. Commit suas alterações (`git commit -m 'Adiciona nova feature'`).
4. Faça o push para a branch (`git push origin feature/nova-feature`).
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---
