# Professional-Job-Application-using-Java-Spring-Boot
# Professional Job Portal Application using Java Spring Boot

This project is a microservice-based job portal application developed using Java Spring Boot. It includes separate microservices for managing jobs, companies, and reviews. The application is initially set up with an H2 database and later migrated to PostgreSQL with PgAdmin for dashboard management. The entire system is containerized using Docker, ensuring seamless deployment and scalability.

## Features
- **Microservices Architecture**: Independent services for Jobs, Companies, and Reviews.
- **Database Integration**: Started with H2, migrated to PostgreSQL.
- **PgAdmin**: Utilized for database management and dashboard.
- **Dockerized**: All microservices are containerized for easy deployment.
- **REST API**: Communication between microservices is handled using RESTful services.

## Technologies Used
- **Java Spring Boot**: Backend framework.
- **H2 Database**: In-memory database for initial development.
- **PostgreSQL**: Relational database for production.
- **PgAdmin**: Database management tool.
- **Docker**: Containerization platform.
- **REST API**: For inter-service communication.

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/varun6465/Professional-Job-Application-using-Java-Spring-Boot.git
2.Navigate to each microservice directory and build the Docker image:
    - **cd <microservice-name>
    - **docker build -t <image-name> .
  
## Architecture Overview
The application is built following a microservices architecture, where each service is responsible for a specific domain within the job portal. The microservices are as follows:

1. **Job Service**: Manages job postings, including creation, updating, and deletion.
2. **Company Service**: Handles company-related data, such as company profiles and job listings.
3. **Review Service**: Allows users to leave reviews and ratings for companies.

### Database Configuration
- **H2 Database**: Used for initial development and testing. It's an in-memory database that allows quick prototyping without external dependencies.
- **PostgreSQL**: Used in the production environment. Data is persisted in a PostgreSQL database, and PgAdmin is used for managing and visualizing the data.

### Docker Configuration
Each microservice is containerized using Docker, allowing for easy deployment and scaling. The `docker-compose.yml` file orchestrates the deployment of all microservices, along with the PostgreSQL database and PgAdmin.

### RESTful APIs
Each microservice exposes RESTful APIs, allowing them to communicate with each other. The APIs follow best practices for REST, ensuring easy integration and interaction between services.

## Running the Application
To run the application locally:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/varun6465/Professional-Job-Application-using-Java-Spring-Boot.git


