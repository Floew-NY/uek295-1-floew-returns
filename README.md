# Development Setup Guide

This guide will walk you through the steps to set up a development environment for a Spring Boot project with a PostgreSQL backend database using Docker Compose.

## Prerequisites

Before you begin, make sure you have the following installed on your machine:

- Java Development Kit (17)
- Gradle
- Docker
- Docker Compose

## Step 1: Clone the Project

Clone the project repository to your local machine:
```bash
git clone git@github.com:Floew-NY/uek295-1-floew-returns.git
```

## Step 2: Set Up the Database

Start the PostgreSQL database using Docker Compose:
    
    ```bash
    docker-compose up -d
    ```

## Step 3: Run the Application

Navigate to the project directory and run the Spring Boot application using Gradle:

    ```bash
    cd your-project
    ./gradlew bootRun
    ```

The endpoints should now be running on http://localhost:8080.

## Step 4: Test the Endpoints

You can test the application endpoints using a tool like Postman or cURL. For example:

    ```bash
    curl http://localhost:8080/
    ```

## Conclusion

You have successfully set up a development environment for a Spring Boot project with a PostgreSQL backend database using Docker Compose. You can now start developing your application and testing it locally.