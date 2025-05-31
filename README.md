# Smart Bike-Sharing Microservices Platform

This project is a demo microservices-based application for a smart bike-sharing system, built with Java 17 and Spring Boot.

## Services
- **config-server**: Centralized configuration server (Spring Cloud Config)
- **eureka-server**: Service discovery (Eureka)
- **api-gateway**: API Gateway (Spring Cloud Gateway)
- **user-service**: User registration & authentication
- **station-service**: Manage bike stations & availability
- **rental-service**: Start & stop rides, calculate costs
- **payment-service**: Simulate payments

## Getting Started
1. **Build & Run**  
   ```bash
   git clone https://github.com/your-org/smart-bike-sharing.git
   cd smart-bike-sharing
   docker-compose up --build
   ```

2. **Test Endpoints**  
   - **Register**: `POST http://localhost:8080/auth/register`
   - **Station CRUD**: `GET/POST http://localhost:8080/stations`
   - **Start Rental**: `POST http://localhost:8080/rentals/start`
   - **Process Payment**: `POST http://localhost:8080/payments`
