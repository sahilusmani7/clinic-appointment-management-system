🏥 Clinic Appointment Management System

A full-stack clinic management web application that allows users to:

Register & login securely (JWT authentication)

Book doctor appointments

Browse doctors and medicines

Add medicines to cart and place orders

Track order status (Created → Paid → Dispatched → Delivered)

Manage profile and logout safely

The system is built using Spring Boot (backend) and vanilla HTML/CSS/JS (frontend), deployed on Render (free tier).

🔗 Live Demo

👉 Backend + Frontend (Render)
https://clinic-appointment-management-system.onrender.com

⚠️ Free-tier note:
Render spins down inactive services. First request may take ~30–60 seconds.

🧱 Tech Stack
Backend

Java 17

Spring Boot 3

Spring Security (JWT)

Spring Data JPA

Hibernate

H2 In-Memory Database (demo / free hosting)

Maven

Frontend

HTML5

CSS3

Vanilla JavaScript

LocalStorage (JWT + cart)

Deployment

Docker

Render (Free Web Service)

🧠 System Architecture
Browser (HTML / JS)
        |
        |  REST APIs (JSON)
        |
Spring Boot Application
        |
        |  JPA / Hibernate
        |
     H2 Database (in-memory)


Frontend pages are served as static resources from Spring Boot

Authentication is stateless using JWT

Orders, appointments, doctors, medicines handled via REST APIs

🔐 Authentication & Security

JWT-based authentication

Token stored in localStorage

Authorization: Bearer <token> header for protected APIs

Public routes:

/auth/login

/users (registration)

Static pages & assets

Protected routes:

/appointments

/orders

/profile

Logout clears token and cart from browser storage.

📂 Project Structure (Simplified)
src/main/java/com/clinic/appointment
├── config        → Security configuration
├── controller    → REST controllers
├── dto           → Request/Response DTOs
├── entity        → JPA entities
├── repository    → JPA repositories
├── security      → JWT filter & utility
├── service       → Business logic

src/main/resources
├── static        → Frontend (HTML/CSS/JS)
├── application.properties

🚀 Features
👤 User

Register & login

View profile

Logout

🩺 Appointments

View available doctors

Book appointments

View booked appointments

💊 Medicines & Orders

Browse medicines

Add to cart

Checkout & place order

Auto-payment simulation

Track order lifecycle

🧪 Local Setup (Development)
1️⃣ Clone the repository
git clone https://github.com/sahilusmani7/clinic-appointment-management-system.git
cd clinic-appointment-management-system

2️⃣ Run the backend
./mvnw spring-boot:run


Backend runs on:

http://localhost:8080

3️⃣ Open frontend

Use VS Code Live Server or open directly:

index.html

🗄 Database Strategy
Current (Demo / Free Hosting)

H2 In-Memory Database

Auto-created on startup

Demo data (doctors, medicines, demo user) seeded at runtime

Data resets on restart (expected behavior)

Production-Ready Option

Can be upgraded to:

MySQL (PlanetScale / Railway)

PostgreSQL (Supabase / Neon)

No code changes required — only config.

🐳 Docker Support

Project includes a Dockerfile for deployment.

Render uses Docker to:

Build the app

Expose port 8080

Inject environment variables securely

⚙️ Environment Variables (Render)
Variable	Description
jwt.secret	JWT signing secret
jwt.expiration	Token expiration (ms)
📌 Known Limitations (Free Tier)

In-memory database resets on restart

Cold start delay on Render

No persistent storage (by design)

These are intentional tradeoffs for a free deployment.

🔮 Future Enhancements

Persistent cloud database

Admin panel (manage doctors & medicines)

Appointment cancellation & rescheduling

Payment gateway integration

Email notifications

Role-based access (ADMIN / USER)

API documentation (Swagger)

👨‍💻 Author

Sahil Usmani