# Email Service

A Java-based email service that illustrates the use of **Thymeleaf templates** and **Java Mail Sender** for sending dynamic, templated emails.

## Overview

This project demonstrates a robust email service implementation in Java, leveraging modern template engines and mail sending capabilities to create and deliver dynamic email content.

## Features

- 📧 **Email Sending** - Send emails using Java Mail Sender
- 🎨 **Thymeleaf Templates** - Dynamic email template generation
- 🔄 **Template Engine Integration** - Process dynamic content in emails
- 💼 **Production-Ready** - Enterprise-grade email handling

## Technologies

- **Language**: Java
- **Template Engine**: Thymeleaf
- **Mail Service**: Java Mail Sender (Spring Mail)
- **Build Tool**: Maven (recommended)

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven 3.6+
- SMTP server configuration

### Installation

1. Clone the repository:
```bash
git clone https://github.com/umamage/EmailService.git
cd EmailService

2. Configure applicaiton.properties
spring.mail.host=your-smtp-host
spring.mail.port=587
spring.mail.username=your-email
spring.mail.password=your-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

3. Build the project:
mvn clean install

4. Create and send email using the service:
// Example usage
emailService.sendTemplatedEmail(
    "recipient@example.com",
    "Welcome to Email Service",
    "welcome-email",
    model
);

5. Project structure
EmailService/
├── src/main/java/
│   └── email/              # Email service components
├── src/main/resources/
│   └── templates/          # Thymeleaf email templates
├── pom.xml                 # Maven configuration
└── README.md
