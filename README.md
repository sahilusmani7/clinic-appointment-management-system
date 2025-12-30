🏥 Clinic Appointment Management System

A full-stack Clinic Appointment & Medicine Ordering System built using Spring Boot, JWT authentication, and a clean vanilla HTML/CSS/JavaScript frontend.

This project demonstrates real-world backend design, secure authentication, REST APIs, and a production-style UI without overusing frameworks.

🚀 Features
🔐 Authentication & Security

JWT-based login system

Secure API access using Spring Security

Password encryption with BCrypt

Token stored client-side and attached to protected requests

👨‍⚕️ Appointments

View available doctors

Book appointments with date & time

View all your booked appointments

Appointments are user-specific and secure

💊 Medicines & Orders

Browse available medicines

Add medicines to cart

Checkout and place orders

Order lifecycle:

CREATED → PAID → DISPATCHED → DELIVERED

Order status updates reflected in UI

📊 Dashboard

Central navigation hub

Quick access to appointments, booking, medicines, orders, and profile

Clean card-based layout

👤 User Profile

View logged-in user details

Secure logout from anywhere

🧱 Tech Stack
Backend

Java 17

Spring Boot

Spring Security

JWT (JSON Web Tokens)

Spring Data JPA

H2 / MySQL (configurable)

Maven

Frontend

HTML5

CSS3 (custom, no frameworks)

Vanilla JavaScript (Fetch API)

Responsive layout

📁 Project Structure (Simplified)
src/main/java/com/clinic/appointment
 ├── config        → Security configuration
 ├── controller    → REST controllers
 ├── dto           → Data Transfer Objects
 ├── entity        → JPA entities
 ├── repository    → Database repositories
 ├── security      → JWT filter & utilities
 └── service       → Business logic

src/main/resources/static
 ├── *.html        → UI pages
 ├── css/style.css
 └── js/*.js

🔑 Authentication Flow

User logs in via /auth/login

Backend issues JWT token

Token is stored in localStorage

All protected requests send:

Authorization: Bearer <token>


JWT filter validates token and sets authentication context

▶️ How to Run
Backend
./mvnw spring-boot:run


Backend runs at:

http://localhost:8080

Frontend

Open any HTML file directly or use a local static server (recommended):

npx serve src/main/resources/static


Then visit:

http://localhost:5500/index.html

🧪 Default Flow to Test

Register a new user

Login to receive JWT

Browse doctors

Book an appointment

Browse medicines

Add to cart → checkout → place order

Track order status

🛠️ UI Improvements Done

Consistent navigation across all pages

Centralized logout handling

Clean card-based UI

Status badges for clarity

Responsive layout for smaller screens

🎯 Learning Outcomes

Secure REST API design

JWT authentication flow

Spring Security customization

Frontend ↔ Backend integration

State management using localStorage

Clean UI without heavy frameworks

📌 Future Enhancements (Optional)

Appointment cancellation

Admin dashboard

Medicine stock auto-update

Payment gateway integration

Dashboard analytics

👤 Author

Sahil Usmani