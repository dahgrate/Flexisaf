# Flexisaf Tasks

This repository contains completed deliverables for the Flexisaf program.
Each task is organized and labeled for clarity and easy navigation.

# Table of Contents

Project Structure

Tasks Overview

How to Navigate

Running the Application

# Project Structure
redaer-backend/
├─ src/
│  ├─ main/
│  │  ├─ java/com/flexisaf/redaer/redaer_backend/
│  │  │  ├─ config/
│  │  │  ├─ controller/
│  │  │  ├─ model/
│  │  │  ├─ repository/
│  │  │  └─ service/
│  │  └─ resources/
│  │     ├─ db/
│  │     ├─ static/
│  │     └─ templates/
├─ target/
├─ ERD Diagram/
│  └─ REDAER_ERD_Diagram.pdf
└─ pom.xml

# Tasks Overview
# Task 1: Spring Boot Application

Description: Create a Spring Boot application with at least 4 endpoints.

Folder/Files: src/main/java/.../controller/ contains controllers for the endpoints.

Example Endpoints:

GET /api/library – List all library entries

GET /api/library/user/{userId} – List entries for a specific user

POST /api/library – Add book to library

PUT /api/library/favorite – Update favorite status

DELETE /api/library – Remove a book from library

# Task 2: Database Schema & ERD

Description: Design a database schema for any domain and produce an ERD.

File: ERD Diagram/REDAER_ERD_Diagram.pdf

Domain: Library system with entities like User, Book, Library, etc.

# Task 3: Hibernate Entity Design

Description: Use important Hibernate annotations to design a database table/entity with at least 10 fields.

Files: src/main/java/.../model/

User.java
Book.java
Genre.java
Library.java

# Task 4: Database Migration with Flyway



Files: src/main/resources/db/migrate

V1__initial_schema.sql (creates a table for the demo library)

V2__data_data_schema.sql (adds sample data)


# Task 5: Dependency Injection

Description: Practice dependency injection using constructors, setters, and field injection.

Files: LibraryService.java

Constructor-based injection used for repositories (LibraryRepository, UserRepository, BookRepository).

How to Navigate

Open redaer-backend in VSCode.

Navigate through folders:

model → JPA entities

repository → Spring Data JPA repositories

service → Business logic and dependency injection

controller → REST API endpoints

ERD Diagram → View database ERD

resources/db → Flyway migration scripts

Each folder corresponds to a task in the list above.

Running the Application

Ensure MySQL 8.x is running and credentials in application.properties are correct.

Flyway migration can be enabled if DB is compatible:

spring.flyway.enabled=true


Compile and run using Maven:

mvn clean spring-boot:run


Server runs at http://localhost:8080
.

Use Postman or curl to test API endpoints.