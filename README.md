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

cd uek295-1-floew-returns
```

## Step 2: Set Up the Database

Start the PostgreSQL database using Docker Compose:
    
    ```bash
    docker-compose up -d
    ```

## Step 3: Run the Application

Navigate to the project directory and run the Spring Boot application using Gradle.
If you have gradle installed on your machine, you can run the application using the following command:
    ```bash
    gradle bootRun
    ```

The endpoints should now be running on http://localhost:8080.

## Step 4: Test the Endpoints

You can test the application endpoints using a tool like Postman. You can use the Postman collection provided in the project to test the endpoints. The collection can be imported with the file `Returns-API-Testing.postman_collection.json` in the root directory of the project.

If all the endpoints return the expected results, then the application is set up correctly.

# Shut Down the Application

To shut down the application, press `Ctrl + C` in the terminal where the application is running. Then, stop the PostgreSQL database using Docker Compose:
    ```bash
    docker-compose down
    ```

# Development Data

The application is preloaded with some development data to help you test the endpoints. The data is loaded into the database when the application starts. You can view the data in the `data.sql` file in the `src/main/resources` directory.

Testing users exist in the database with the following credentials:

- Admin User
    - Username: adminer
    - Password: 12345678
- Regular User
    - Username: usererer
    - Password: 12345678

You can use these credentials to test the endpoints.

# Endpoint Documentation

To view your API documentation, navigate to http://localhost:8080/swagger-ui/index.html#/ in your web browser.

