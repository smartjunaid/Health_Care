# Health_Care# 🏥 Health Care Management System

A comprehensive Health Care System built using Spring Boot. This application provides secure REST APIs for managing patient registrations, doctor details, appointments, and more. Authentication is managed using **JWT tokens**, and the APIs are documented using **Swagger UI**.

---

## 🚀 Technologies Used

- Java 17
- Spring Boot
- Spring MVC
- Spring Security (JWT)
- Spring Data JPA
- MySQL
- Swagger (OpenAPI)
- Maven
- Lombok

---

## 📁 Project Structure

```
src/
 └── main/
     ├── java/
     │   └── com.healthcare
     │         ├── config
     │         ├── controller
     │         ├── dto
     │         ├── entity
     │         ├── repository
     │         ├── security
     │         └── services
     ├── resources/
     │   └── application.properties
```

---

## ⚙️ Getting Started

### 🔹 1. Clone the Project

```bash
git clone git@github.com:smartjunaid/Health_Care.git
cd Health_Care
```

### 🔹 2. Configure MySQL Database

In `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/healthcare_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# JWT Secret Key (Example)
jwt.secret=your_jwt_secret_key
jwt.expiration=600000
```

### 🔹 3. Run the Application

```bash
mvn spring-boot:run
```

Or, run `HealthCareApplication.java` in your IDE.

---

## 🔐 JWT Authentication Flow

### 🔸 /auth/login

- Send `username` and `password`
- Get back **JWT Token** in response

### 🔸 /auth/register

- Register a new user (patient/doctor/admin)

### 🔸 Use JWT for All Protected Endpoints

In Postman or Swagger:

```
Authorization: Bearer <your-token>
```

---

## 📘 API Documentation (Swagger)

Visit:

```
http://localhost:8080/swagger-ui/index.html
```

Here, you can explore all available endpoints, request/response schemas, and try out APIs live.

---

## ✅ Key Features

- 🔐 Secure login with **JWT Authentication**
- 🧾 Patient registration and management
- 👨‍⚕️ Doctor listing and details
- 📅 Appointment scheduling
- 🗃️ MySQL integration with JPA
- 📄 Live API testing using Swagger
- 📤 Role-based access control (admin/patient/doctor)

---

## 🧪 Sample API Endpoints

| Method | Endpoint            | Description             |
| ------ | ------------------- | ----------------------- |
| POST   | `/auth/register`    | Register a new user     |
| POST   | `/auth/login`       | Login and get JWT token |
| GET    | `/api/patients`     | Get all patients        |
| POST   | `/api/patients`     | Add new patient (JWT)   |
| GET    | `/api/doctors`      | Get all doctors         |
| POST   | `/api/appointments` | Book appointment (JWT)  |

---

## 📬 Developer Info

**Name:** Mohammed Junaid  
**Email:** smartjunaid9823@gmail.com  
**GitHub:** https://github.com/smartjunaid/Health_Care.git  
**LinkedIn:** https://www.linkedin.com/in/mohammed-junaid-08619231b/

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).
