## 📌 Sobre o projeto

Este projeto foi desenvolvido com o objetivo de aprender, praticar e evoluir minhas habilidades em Java e Spring Boot.  
Trata-se de um CRUD completo de usuários, inspirado e guiado pela série gratuita do canal Javanauta no YouTube.

A construção desse sistema não foi apenas um exercício técnico, mas também uma forma de colocar em prática o que venho estudando — com muito interesse e prazer em aprender cada etapa do processo.

Durante o desenvolvimento, aprendi conceitos importantes como:
- Estrutura de um projeto Spring Boot;
- Criação de Controllers, Services e Repository;
- Uso de JPA/Hibernate para persistência de dados;
- Padrão DTO e boas práticas de organização;
- Testes dos endpoints com Postman/Insomnia;
- Como documentar e versionar o projeto no GitHub.

Este repositório representa mais um passo na minha evolução como desenvolvedor.

## 🛠 Tecnologias Utilizadas

- Linguagem: Java
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- Lombok  
- Banco de Dados H2 / MySQL  

---

## 📁 Estrutura do Projeto

- src/main/java/com/javanauta/cadastro_usuario
- ├── controller → Endpoints da API REST
- ├── business → Regras de negócio (Service)
- └── infrastructure
- ├── entitys → Classe de entidade (Usuario)
- └── repository → Interface de acesso ao banco


---

---

## ⚙ Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git

````

2. Configure o banco no arquivo application.properties ou application.yml

Exemplo com H2:

- spring.datasource.url=jdbc:h2:mem:testdb
- spring.datasource.driverClassName=org.h2.Driver
- spring.datasource.username=sa
- spring.datasource.password=
- spring.jpa.hibernate.ddl-auto=update
- spring.jpa.show-sql=true

3. Execute o projeto
   ```bash
   - mvn spring-boot:run
   ````

## 📮 Endpoints da API

| Método | Rota            | Descrição                  |
| ------ | --------------- | -------------------------- |
| POST   | /usuario        | Criar novo usuário         |
| GET    | /usuario?email= | Buscar usuário por e-mail  |
| PUT    | /usuario?id=    | Atualizar usuário por ID   |
| DELETE | /usuario?email= | Deletar usuário por e-mail |

## ➕ Exemplo de Body (POST / PUT)

```bash
{
  "email": "usuario@exemplo.com",
  "nome": "João da Silva"
}
````

## 👨‍💻 Autor

Bruno Rodrigues
- 🎓 Formado em Análise e Desenvolvimento de Sistemas
- 📚 Pós-graduação em Ciência de Dados e Big Data
- 💡 Este projeto foi desenvolvido com base no conteúdo gratuito da Javanauta no YouTube, como forma de estudo, prática e portfólio profissional.



