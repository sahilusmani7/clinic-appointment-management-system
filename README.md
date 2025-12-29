# Clinic Appointment Management System

This project is a full-stack clinic appointment management system designed to simulate how a real healthcare booking platform works. It focuses on secure authentication, clean backend architecture, and a simple but functional frontend that demonstrates end-to-end flow.

The goal of this project was not just to build features, but to follow production-style backend practices such as JWT authentication, proper API security, DTO usage, and clear separation of concerns.

---

## Overview

The system allows users to register, log in, and book appointments with doctors. All sensitive operations are protected using JWT-based authentication. Each user can only view and manage their own appointments.

The frontend is intentionally kept framework-free using plain HTML, CSS, and JavaScript to clearly demonstrate core web fundamentals and how they interact with a secure backend.

---

## Key Features

### Authentication and Security
- User registration and login
- JWT-based stateless authentication
- Password hashing using BCrypt
- Spring Security 6 with Lambda DSL configuration
- Proper CORS handling for frontend and backend communication
- Protected endpoints with role-ready design

### Appointment Management
- Fetch available doctors
- Book appointments as an authenticated user
- Prevent double booking for the same doctor and time slot
- View appointments specific to the logged-in user

### Backend Design
- RESTful API design
- Layered architecture (Controller, Service, Repository)
- DTOs used to prevent sensitive data exposure
- Clean separation between entities and API responses

### Frontend
- Modular UI with separate Login, Register, and Dashboard pages
- Dashboard-style layout for booking and viewing appointments
- JWT stored in browser local storage and attached to API requests
- Simple, readable UI focused on usability rather than heavy styling

---

## Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- Spring Data JPA
- MySQL
- Maven

### Frontend
- HTML
- CSS
- Vanilla JavaScript

---

## Architecture Explanation

The backend follows a standard layered architecture:

- **Controller Layer**  
  Handles HTTP requests and responses. Controllers are kept thin and delegate business logic to services.

- **Service Layer**  
  Contains core business logic such as authentication handling, appointment booking, and validation. Security context is used here to identify the logged-in user via JWT.

- **Repository Layer**  
  Manages database access using Spring Data JPA. All database operations are abstracted behind repositories.

DTOs are used when returning responses to the frontend to ensure that internal entities and sensitive fields like passwords are never exposed.

---

## API Endpoints (Sample)

| Method | Endpoint | Description |
|------|---------|------------|
| POST | /users | Register a new user |
| POST | /auth/login | Authenticate user and receive JWT |
| GET | /doctors | Fetch list of doctors |
| POST | /appointments | Book an appointment |
| GET | /appointments | View appointments for logged-in user |

---

## Security Considerations

- Passwords are never stored in plain text and are hashed using BCrypt.
- JWT is used for stateless authentication.
- Protected endpoints require a valid JWT token.
- Sensitive fields are excluded from API responses using DTOs.
- CORS is configured at the Spring Security layer to safely allow frontend access.

---

## Frontend Pages

- Login Page  
- Register Page  
- Dashboard with appointment booking and appointment list

The frontend demonstrates how a lightweight UI can securely interact with a modern backend without relying on heavy frameworks.

---

## Deployment

- TBD
---

## What This Project Demonstrates

- Practical understanding of Spring Boot and Spring Security
- Real-world JWT authentication flow
- Secure API design
- Clean backend architecture
- Full-stack integration without shortcuts
- Ability to document and explain technical decisions clearly

---

## Author

**Sahil Usmani**
