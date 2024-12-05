# Microservice with RabbitMQ: User Registration Flow

This project demonstrates asynchronous communication between microservices using RabbitMQ as the message broker. It was developed to practice and solidify concepts related to microservices and messaging.

## 🛠 Technologies Used
- **Java** (Primary programming language)
- **Spring Boot** (Framework for building microservices)
- **RabbitMQ** (Message broker)
- **CloudAMQP** (Cloud-based RabbitMQ instance)

## 📚 Project Overview

This system consists of **three microservices**:

1. **UserService**: Acts as the producer of messages.
2. **EmailService**: A consumer that sends an email notification when a user is registered.
3. **LogService**: A consumer that logs a success message in the console, including the user's `UUID` and email.

### How It Works
1. When a user registers via the `UserService`, a message containing the user's information (e.g., `UUID` and email) is published to RabbitMQ.
2. The `EmailService` listens for messages and sends an email notification to confirm the user's registration.
3. The `LogService` also listens for messages and logs a success message in the console, such as:
    User successfully created: UUID={UUID}, Email={Email}

## 🧰 Prerequisites

- **Java 17** or higher
- **RabbitMQ** instance (configured locally or via CloudAMQP)
- **Maven** for dependency management


## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/micro-cadastro-user.git
cd micro-cadastro-user
``` 
### 2. Set Up RabbitMQ
    If using CloudAMQP, create an instance and retrieve the connection URL.
    Update the connection details in each service's application.yml file.

### 3. Test the flow
- Use a Rest client (e.g Postman) to register a new User
- `POST/user`
```json
{
  "name": "Name example",
  "email": "name@example.com"
}
```
- Observe:
  - `EmailService` sends an email
  - `LogsService` logs the success message at the console
  

 ## 📁 Project Structure

- `micro-cadastro-user/`
    - `userService`
    - `emailService`
    - `logService`
    
## 📝 Lessons Learned
- How to configure RabbitMQ with Spring Boot.
- Setting up producer and consumer services for asynchronous communication.
- Designing simple yet effective microservices architectures.
