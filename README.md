
# Business Management

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-555555?style=for-the-badge&logo=apachemaven&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

## Descrição

O **Business Management** é uma aplicação desenvolvida para gerenciar operações empresariais, incluindo funcionalidades como cadastro de lojas, funcionários e muito mais.

---

## Funcionalidades

- **Gerenciamento de Lojas**: Cadastro, atualização e remoção de lojas.
- **Gerenciamento de Funcionários**: Cadastro, atualização e remoção de funcionários associados às lojas.

---

## Modelo de Dados (ERD)

Visualize o modelo do banco de dados clicando abaixo:

> 📌 Clique [aqui](https://dbdiagram.io/d/business_management-67ed603f4f7afba1841d3f28/) para visualizar o diagrama ER do banco de dados.

---

## Tecnologias Utilizadas

- **Java 21**: Linguagem principal do projeto.
- **Spring Boot**: Framework para criação de aplicações Java.
- **Mysql**: Banco de dados relacional utilizado para armazenar as informações.
- **Docker**: Utilizado para containerização da aplicação.
- **Maven**: Gerenciador de dependências e construção do projeto.

---

## Pré-requisitos

Antes de iniciar, certifique-se de ter instalado:

- [Java 21](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html)
- [Docker](https://www.docker.com/get-started)
- [Maven](https://maven.apache.org/download.cgi)

---

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
   .\mvnw clean install
   ```

5. **Execute a aplicação**:

   ```bash
   .\mvnw spring-boot:run  
   ```

   A aplicação estará disponível em `http://localhost:8081/v1`.

---

## Documentação da API

Acesse a documentação interativa com Swagger:

http://localhost:8081/v1/swagger-ui/index.html

---

## Contribuição

Contribuições são bem-vindas! Para contribuir:

1. Faça um fork do projeto.
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`).
3. Commit suas alterações (`git commit -m 'Adiciona nova feature'`).
4. Faça o push para a branch (`git push origin feature/nova-feature`).
5. Abra um Pull Request.

---

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---

## Autor

Desenvolvido por [Gabriel7576](https://github.com/Gabriel7576)