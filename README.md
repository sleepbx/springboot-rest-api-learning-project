# Spring Boot Backend Learning Project

This project is a practice backend application built using **Spring Boot** to understand core backend development concepts.

The goal of this project is to learn how real-world backend systems are structured using Spring Boot, REST APIs, and layered architecture.

---

## Technologies Used

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* Maven
* H2 / MySQL (depending on your configuration)

---

## Concepts Implemented

### 1. Spring Core

* Dependency Injection (DI)
* Inversion of Control (IoC)
* Bean Lifecycle
* Bean Scopes
* Component Scanning

### 2. Spring Boot

* Auto Configuration
* Starter Dependencies
* Embedded Server
* Bootstrapping Process
* Convention over Configuration

### 3. REST API Development

* REST Controllers
* HTTP Methods (GET, POST, PUT, DELETE)
* Request Handling
* ResponseEntity
* Status Codes

### 4. DTO Design

* DTO vs Entity
* Request DTO
* Response DTO
* Mapping Layer

### 5. Validation

* @Valid
* @NotNull
* @NotBlank
* @Email
* @Size

### 6. Exception Handling

* Global Exception Handler
* Custom Exceptions
* Standard API Error Response

### 7. Spring Data JPA

* Entity Mapping
* Relationships
* Lazy vs Eager Loading
* Cascading

### 8. Repository Layer

* JpaRepository
* Derived Query Methods
* Pagination and Sorting
* Custom Queries

### 9. Transactions

* @Transactional
* ACID Properties
* Transaction Management

### 10. Configuration Management

* application.properties
* Profiles (dev/test/prod)
* @Value
* @ConfigurationProperties

### 11. Caching

* Spring Cache
* @Cacheable
* @CachePut
* @CacheEvict

### 12. Asynchronous Processing

* @Async
* Task Executors
* Background Processing

### 13. Scheduling

* @EnableScheduling
* @Scheduled
* Cron Jobs

---

## Project Structure

src/main/java/com/example/demo

config → Configuration classes
controller → REST Controllers
dto → Request/Response DTOs
exception → Global exception handling
mapper → DTO ↔ Entity mapping
model → JPA entities
repository → Spring Data repositories
service → Business logic layer

---

## Features Implemented

* User Management API
* Product API
* Cart API
* Book API
* Account API
* Notification API
* Global Exception Handling
* DTO based API design
* Caching
* Scheduled Jobs

---

## How to Run the Project

1. Clone the repository

git clone https://github.com/sleepbx/springboot-rest-api-learning-project.git

2. Navigate to project folder

cd springboot-rest-api-learning-project

3. Run the application

./mvnw spring-boot:run

Application will start on:

http://localhost:8080

---

## Purpose

This project was built as part of learning **Spring Boot backend development**, covering most essential backend topics needed for real-world applications.
