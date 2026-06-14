# 🚀 Stellaris API - Turismo Espacial

<div align="center">

![Java](https://img.shields.io/badge/Java-21-orange)
![Quarkus](https://img.shields.io/badge/Quarkus-3.x-blue)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![REST API](https://img.shields.io/badge/API-REST-green)
![FIAP](https://img.shields.io/badge/FIAP-Global%20Solution-red)

### 🌌 Explorando o futuro do turismo espacial através da tecnologia.

🔗 **Deploy Online:** https://project-stellaris-ten.vercel.app/

</div>

---

## 📖 Sobre o Projeto

O **Stellaris** é uma plataforma de turismo espacial desenvolvida para a **Global Solution FIAP 2026**, integrando um front-end moderno com uma API REST em Java.

O sistema permite que usuários visualizem pacotes de viagens espaciais, realizem reservas e gerenciem informações relacionadas ao turismo além da Terra.

A aplicação está totalmente integrada, com:

* 🎨 **Front-end** hospedado na **Vercel**
* ☕ **Back-end** desenvolvido em **Java + Quarkus**
* 🗄️ **Banco de Dados PostgreSQL**
* 🔄 Comunicação via **API REST**

---

## 🌐 Deploy

A aplicação pode ser acessada pelo link:

**🔗 https://project-stellaris-ten.vercel.app/**

O deploy integra:

* Front-end React hospedado na Vercel;
* API REST em Java (Quarkus);
* Banco de dados PostgreSQL para persistência das informações.

---

## 🏗️ Arquitetura da Aplicação

A aplicação segue uma arquitetura em camadas:

```text
Usuário
   ↓
Front-end (React + TypeScript)
   ↓ HTTP/JSON
API REST (Quarkus)
   ↓
Business Object (BO)
   ↓
Data Access Object (DAO)
   ↓
PostgreSQL
```

### 📌 Responsabilidade das Camadas

| Camada                   | Responsabilidade                     |
| ------------------------ | ------------------------------------ |
| Front-end                | Interface e experiência do usuário   |
| Resource                 | Recebe requisições HTTP              |
| BO (Business Object)     | Regras de negócio                    |
| DAO (Data Access Object) | Acesso ao banco de dados             |
| Entity                   | Representação dos objetos do sistema |
| PostgreSQL               | Persistência dos dados               |

---

## ⚙️ Tecnologias Utilizadas

### Back-end

* Java 21
* Quarkus 3.x
* REST API (JAX-RS)
* JDBC
* Jackson (JSON)
* Maven

### Banco de Dados

* PostgreSQL

### Front-end

* React
* TypeScript
* Vite
* Tailwind CSS

### Deploy

* Vercel

---

## 📂 Estrutura do Projeto

```text
src/main/java/br/com/fiap
│
├── bo
│   ├── PacoteBO.java
│   └── ReservaBO.java
│
├── conexoes
│   └── ConexaoFactory.java
│
├── dao
│   ├── PacoteDAO.java
│   └── ReservaDAO.java
│
├── entities
│   ├── Pacote.java
│   └── Reserva.java
│
├── resource
│   ├── PacoteResource.java
│   ├── ReservaResource.java
│   └── CorsFilter.java
│
└── excecoes
    └── ExcecoesConexao.java
```

---

## 🔄 Operações CRUD

A API implementa operações CRUD completas:

| Operação  | Método HTTP |
| --------- | ----------- |
| Criar     | POST        |
| Consultar | GET         |
| Atualizar | PUT         |
| Excluir   | DELETE      |

---

## 🌎 Endpoints

### Pacotes

```http
GET    /pacote
GET    /pacote/{id}
POST   /pacote
PUT    /pacote
DELETE /pacote/{id}
```

### Reservas

```http
GET    /reserva
GET    /reserva/{id}
POST   /reserva
PUT    /reserva
DELETE /reserva/{id}
```

---

## 🗄️ Banco de Dados

O sistema utiliza **PostgreSQL** para persistência das informações.

A conexão com o banco é centralizada na classe:

```java
ConexaoFactory.java
```

Responsável por:

* Abrir conexões com o banco;
* Gerenciar acesso aos dados;
* Centralizar configurações de persistência.

---

## 🔒 CORS e Integração

A API possui suporte a **CORS**, permitindo a comunicação segura entre o front-end hospedado na Vercel e o back-end Java.

Exemplo de configuração:

```properties
quarkus.http.cors=true
quarkus.http.cors.origins=*
quarkus.http.cors.methods=GET,POST,PUT,DELETE,OPTIONS
```

---

## 🧩 Funcionalidades

### 🚀 Gerenciamento de Pacotes

* Cadastro de pacotes espaciais;
* Consulta de destinos;
* Atualização de informações;
* Exclusão de pacotes.

### 👨‍🚀 Gerenciamento de Reservas

* Criação de reservas;
* Consulta de reservas;
* Alteração de dados;
* Cancelamento de reservas.

---

## 📚 Conceitos Aplicados

* Programação Orientada a Objetos (POO)
* API REST
* Arquitetura em Camadas
* Padrão DAO
* Business Object (BO)
* Persistência de Dados
* Integração Front-end e Back-end
* PostgreSQL
* Serialização JSON

---

## ▶️ Como Executar Localmente

### Pré-requisitos

* Java 21+
* Maven
* PostgreSQL

### Executando o projeto

```bash
# Clonar o repositório
git clone <url-do-repositorio>

# Entrar na pasta
cd stellaris-quarkus

# Executar aplicação
mvn quarkus:dev
```

A API ficará disponível em:

```text
http://localhost:8080
```

---

## 👨‍💻 Integrantes

* **Guilherme Barca**
* **Juliana Marques**
* **Lucas Kosio**

---

## 🎓 Instituição

**FIAP – Faculdade de Informática e Administração Paulista**

**Global Solution – 2026**

---

<div align="center">

# 🌌 STELLARIS

*"Levando a tecnologia além das fronteiras da Terra."* 🚀✨

</div>
