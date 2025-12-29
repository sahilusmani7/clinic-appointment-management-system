# Clinic Appointment Management System

A full-stack clinic appointment booking system built with Spring Boot and a lightweight frontend using HTML, CSS, and JavaScript.

---

## 🚀 Features

- User Registration & Login
- JWT-based Authentication & Authorization
- Secure Password Hashing (BCrypt)
- Spring Security 6 (Lambda DSL)
- Doctor Management
- Appointment Booking
- Double Booking Prevention
- View Appointments for Logged-in Users
- Clean API Responses using DTOs
- Modular Frontend UI (Login, Register, Dashboard)

---

## 🛠 Tech Stack

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
- JavaScript

---

## 🏗 Architecture Overview

- Stateless JWT Authentication
- RESTful APIs
- Layered Architecture  
  **Controller → Service → Repository**
- DTO-based API responses to avoid sensitive data exposure
- Proper CORS handling with Spring Security

---

## 📦 API Endpoints (Sample)

| Method | Endpoint | Description |
|------|---------|------------|
| POST | /users | Register new user |
| POST | /auth/login | Login and receive JWT |
| GET | /doctors | Fetch doctors |
| POST | /appointments | Book appointment |
| GET | /appointments | View my appointments |

---

## 🖥 Frontend Screens

- Login Page
- Register Page
- Dashboard
- Appointment Booking UI

---

## 🔐 Security Highlights

- JWT-based stateless authentication
- Password hashing using BCrypt
- Protected endpoints using Spring Security
- No sensitive data exposed in API responses

---

## 🌐 Deployment

- Backend: (Railway – link to be added)
- Frontend: (GitHub Pages – link to be added)

---

## 👤 Author

**Sahil Usmani**
