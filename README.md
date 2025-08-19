# springbootmicroservices
This project demonstrates a production-grade microservices architecture for managing bank customers and their accounts. It leverages Spring Boot and Spring Cloud with fault tolerance, resilience, and scalable service communication.

# Features
• Microservices Architecture – Independent services for Customer Management and Account
Management.
• Service Discovery & Load Balancing – Using Spring Cloud Netflix Eureka and Spring Cloud
LoadBalancer.
• Inter-Service Communication – Implemented with OpenFeign Clients for clean and declarative
REST calls.
• Fault Tolerance & Resilience – Achieved with Resilience4j (Circuit Breaker, Retry, Rate Limiter,
Bulkhead).
• Centralized Logging – Structured logs with SLF4J + Logback.
• API Gateway – Unified entry point via Spring Cloud Gateway.
• Config Server – Centralized configuration using Spring Cloud Config.
• Database Integration – JPA/Hibernate with relational database for persistence.
• Dockerized Deployment – Containerized services for easy scaling and deployment.

# Tech Stack
• Backend: Java, Spring Boot, Spring Cloud, JPA/Hibernate
• Resilience & Fault Tolerance: Resilience4j
• Logging: SLF4J, Logback
• Service Discovery: Eureka
• API Gateway: Spring Cloud Gateway
• Configuration: Spring Cloud Config
• Containerization: Docker

# What you’ll learn from this project
• Designing loosely coupled financial microservices.
• Handling service-to-service communication with resilience.
• Applying circuit breakers and retries to improve fault tolerance.
• Managing customers and bank accounts in a scalable, secure way.
• Implementing centralized logging, configuration, and monitoring.
