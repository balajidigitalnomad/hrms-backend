# HRMS Backend - Spring Boot - Spring Security - JWT - Hibernate - MySql 
---
### 👨‍💻 Author: **Balaji V. S.**

**Senior Java Solutions Architect & Full-Stack Engineering Lead**
---

## Enterprise Human Resource Management System (HRMS)

HRMS Backend is a secure, scalable, and enterprise-grade Human Resource Management System developed using **Spring Boot**. The application exposes RESTful APIs for managing core Human Resource operations such as Employees, Departments, Designations, Users, and Roles.

The project follows enterprise software development best practices, including Layered Architecture, DTO Pattern, JWT Authentication, Role-Based Authorization (RBAC), Bean Validation, Global Exception Handling, and RESTful API design.

Interactive API documentation is provided using Swagger OpenAPI, allowing developers to explore and test secured REST endpoints.

---

# Features

* JWT Authentication
* Role-Based Authorization (RBAC)
* Spring Security 6 Integration
* Employee Management
* Department Management
* Designation Management
* User Management
* Role Management
* BCrypt Password Encryption
* RESTful API Design
* DTO Pattern
* Entity-DTO Mapping using MapStruct
* Bean Validation (Jakarta Validation)
* Global Exception Handling
* Swagger OpenAPI Documentation
* Layered Architecture
* MySQL Database Integration

---

# Technology Stack

| Technology         | Version           |
| ------------------ | ----------------- |
| Java               | 21                |
| Spring Boot        | 3.5.16            |
| Spring Security    | 3.5.16            |
| Spring Data JPA    | 3.5.16            |
| Hibernate          | 6.5.53            |
| MySQL              | 9.7               |
| Maven              | Latest            |
| JWT (JJWT)         | 0.12.7            |
| Swagger OpenAPI    | springdoc-openapi 2.8.9 |
| MapStruct          | 1.6.3             |
| Lombok             | 1.18.38           |
| Jakarta Validation | 3.0.2             |

---

# Project Architecture

The application follows a layered architecture to maintain separation of concerns and improve maintainability.

```text
Client
   │
   ▼
Controller Layer
   │
   ▼
Service Layer
   │
   ▼
Repository Layer
   │
   ▼
MySQL Database
```

---

# Project Structure

```text
src/main/java
│
├── config
├── controller
├── dto
│   ├── request
│   └── response
├── entity
├── enums
├── exception
├── mapper
├── repository
├── security
├── service
└── util
```

---

# Security

The application uses **JWT (JSON Web Token)** based authentication.

## Authentication Flow

```text
User Login
     │
     ▼
Authentication API
     │
     ▼
JWT Token Generated
     │
     ▼
Swagger / Client
     │
Authorization: Bearer <JWT_TOKEN>
     │
     ▼
Protected APIs
```

### Role-Based Authorization

| Role     | Access                                 |
| -------- | -------------------------------------- |
| ADMIN    | Full System Access                     |
| HR       | Employee & Master Data Management      |
| MANAGER  | Employee Operations & Leave Management |
| EMPLOYEE | Self-Service APIs                      |

---

# Available Modules

* Authentication
* User Management
* Role Management
* Employee Management
* Department Management
* Designation Management

Additional HR modules such as Leave Management, Attendance, Payroll, and Recruitment can be integrated in future releases.

---

# Screen Shots
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/f05e3ce7-77c4-447d-b990-0eb13d2c3d16" />

<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/e3b99c10-3f6f-4fc5-9868-1edbdf195541" />

<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/f5ea4db9-d0c7-4b80-b053-e8d94a1ceabf" />

<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/6f8b9bea-b50a-451e-ac4d-a8c78daba17e" />

# API Documentation

Swagger UI is available after starting the application.

```
http://localhost:8080/swagger-ui/index.html
```

---

# Getting Started

## Clone Repository

```bash
git clone https://github.com/balajidigitalnomad/hrms-backend.git
```

## Navigate to Project

```bash
cd hrms-backend
```

## Configure Database

Update the following properties inside:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hrms
spring.datasource.username=your_username
spring.datasource.password=your_password
```

Configure your JWT properties:

```properties
jwt.secret=your-secret-key
jwt.expiration=86400000
```

---

## Run Application

Using Maven

```bash
mvn spring-boot:run
```

or

Run the `HrmsBackendApplication` class directly from your IDE.

---

# Future Enhancements

* Leave Management
* Attendance Management
* Payroll Management
* Recruitment Module
* Employee Document Management
* Email Notifications
* File Upload
* Audit Logging
* Docker Support
* CI/CD Pipeline
* Unit Testing
* Integration Testing
* AWS Deployment
* Microservices Migration

---

# Learning Objectives

This project demonstrates practical implementation of:

* Enterprise Spring Boot Development
* Spring Security
* JWT Authentication & Authorization
* REST API Design
* DTO Pattern
* Repository Pattern
* Layered Architecture
* Validation
* Exception Handling
* Git & GitHub Workflow
* API Documentation

---

# Author

**Balaji V. S.**

Senior Java Solutions Architect & Full-Stack Engineering Lead

**Experience:** 19+ Years

### Expertise

* Java
* Spring Boot
* Microservices
* Spring Security
* React
* AWS
* REST APIs
* System Design
* Enterprise Application Development

---

# License

This project is intended for learning, demonstration, and portfolio purposes.
