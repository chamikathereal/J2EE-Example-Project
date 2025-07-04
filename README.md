# 🚀 J2EE-Example-Project

## 📝 Project Overview

**J2EE-Example-Project** is a modular Java EE application designed to demonstrate best practices in enterprise application development. This project covers user authentication, product management, email verification, and secure role-based access control using EJBs, servlets, JSP, Jakarta EE Security API, and Hibernate ORM. The architecture is layered and scalable, making it ideal for learning and extending real-world enterprise Java solutions.

## 🗂️ Project Structure

```
J2EE-Example-Project/
├── auth/
│   └── src/main/java/lk.jiat.app.ejb.bean/
│       └── UserSessionBean.java
├── core/
│   └── src/main/java/lk.jiat.app.core/
│       ├── exception/
│       │   ├── InvalidParameterException.java
│       │   └── LoginFailedException.java
│       ├── mail/
│       │   ├── Mailable.java
│       │   └── VerificationMail.java
│       ├── model/
│       │   ├── Product.java
│       │   ├── Status.java
│       │   ├── User.java
│       │   └── UserType.java
│       ├── provider/
│       │   └── MailServiceProvider.java
│       ├── service/
│       │   ├── ProductService.java
│       │   └── UserService.java
│       └── util/
│           ├── Encryption.java
│           └── Env.java
│       └── resources/
│           ├── META-INF/persistence.xml
│           └── application.properties
├── product/
│   └── src/main/java/lk.jiat.app.ejb.bean/
│       └── ProductSessionBean.java
├── web/
│   └── src/main/java/lk.jiat.app.web/
│       ├── listener/
│       │   └── ContextListener.java
│       ├── security/
│       │   ├── AppIdentityStore.java
│       │   └── AuthMechanism.java
│       └── servlet/
│           ├── AddProduct.java
│           ├── deleteProduct.java
│           ├── Login.java
│           ├── Logout.java
│           ├── Register.java
│           ├── Test.java
│           └── VerifyEmail.java
│   └── src/main/webapp/
│       ├── admin/
│       │   ├── add_product.jsp
│       │   └── index.jsp
│       ├── user/
│       │   └── index.jsp
│       ├── WEB-INF/
│       │   └── web.xml
│       ├── 500.jsp
│       ├── index.jsp
│       ├── login.jsp
│       ├── login_error.jsp
│       ├── register.jsp
│       └── unauthorized.jsp
├── ear/
│   └── src/main/
│       ├── java/
│       └── resources/
├── pom.xml
```

## 📦 Module Details

### 🟦 **auth (EJB Module)**
- **UserSessionBean.java**  
  Stateless EJB for user management: registration, authentication, update, and deletion. Integrates with the core model and service interfaces.

  ##

### 🟦 **core (Core Business Logic)**
- **exception/**  
  Custom exceptions for parameter validation and login failures.
  
- **mail/**  
  Email sending logic, including verification emails for user registration.
  
- **model/**  
  JPA entities for `User`, `Product`, and supporting enums for status and user type.
  
- **provider/**  
  Singleton mail service provider for asynchronous email delivery.
  
- **service/**  
  Remote interfaces for user and product business logic.
  
- **util/**  
  Utility classes for password encryption and environment variable management.
  
- **resources/**  
  JPA persistence configuration and application properties.

  ##

### 🟦 **product (EJB Module)**
- **ProductSessionBean.java**  
  Stateless EJB for product CRUD operations, category filtering, and business logic.

  ##

### 🟦 **web (Web Layer)**
- **listener/ContextListener.java**  
  Initializes and shuts down the mail service provider.
  
- **security/**  
  Implements Jakarta EE Security API for authentication and identity management.
  
- **servlet/**  
  Servlets for login, logout, registration, product management, email verification, and testing.
  
- **webapp/**  
  JSP pages for admin and user dashboards, login, registration, error handling, and unauthorized access.
  
- **WEB-INF/web.xml**  
  Security constraints, role mappings, and error page configuration.

  ##

### 🟦 **ear (Enterprise Archive)**
- Assembles all modules (`auth`, `product`, `core`, `web`) into a deployable EAR for enterprise servers.

## ⚙️ Key Features

- ✅ Modular Maven multi-module structure (EJB, web, core, EAR)
- ✅ User registration with email verification
- ✅ Secure login/logout and session management
- ✅ Role-based access control (SUPER_ADMIN, ADMIN, USER)
- ✅ Product management (CRUD, category filtering)
- ✅ Custom exception handling and error pages
- ✅ Asynchronous email sending for verification
- ✅ Password encryption for secure storage
- ✅ Clean separation of concerns and layered architecture

## 💡 How It Works

- **User Registration:**  
  Users register via a form; their data is persisted and a verification email is sent. Upon clicking the verification link, their account is activated.

- **Authentication & Authorization:**  
  Login is handled via a servlet and Jakarta EE Security API. Roles are assigned and enforced at both servlet and EJB levels.

- **Product Management:**  
  Admins can add, view, and delete products via JSP pages and servlets. Products are managed using EJBs and JPA.

- **Session & Error Handling:**  
  Secure session management ensures users can log out safely. Custom error pages handle login failures, unauthorized access, and server errors.

- **Email Service:**  
  The mail provider uses a thread pool for efficient, non-blocking email delivery, supporting verification and notification workflows.

## 🛠️ Technologies Used

- Java 11
- Jakarta EE 10 (EJB, Servlet, JPA, Security)
- Hibernate ORM
- JSP & JSTL
- Maven
- MySQL (for persistence)
- Jakarta Mail

## 📚 Learning Outcomes

- ✅ Build modular, maintainable Java EE applications
- ✅ Implement secure authentication and role-based authorization
- ✅ Integrate EJBs, servlets, and JSP in a real-world project
- ✅ Use JPA/Hibernate for ORM and database management
- ✅ Apply best practices for error handling and email verification

## 🧑‍💻 Author

Chamika Gayashan  
Undergraduate Software Engineer | Sri Lanka  
Linkedin: @chamikathereal  
Current date: Saturday, July 05, 2025, 12:48 AM +0530
