# Ecommerce Products API
This is a simple Ecommerce Products API that manages the CRUD (Create, Read, Update, Delete) operations for products in an ecommerce system. It provides endpoints for creating, retrieving, updating, and deleting products. Additionally, it supports retrieving all products from the database.

### Features
* Create new products
* Retrieve a product by its ID
* Update an existing product by ID
* Delete a product by ID
* Retrieve all products in the ecommerce database
### Technologies Used
* Spring Boot: For building the backend application.
* Spring Data JPA: For interacting with the database.
* H2 Database: In-memory database for storing product information.
* Swagger UI: For API documentation and testing.
* Springdoc OpenAPI: For automatic generation of OpenAPI 3.0 documentation.

### Setup and Installation
### Prerequisites
Before setting up the project, ensure you have the following installed:
* Java 11 or later
* Maven

### Build and run the application:
mvn spring-boot:run

### Accessing the Application
After starting the application, it will be accessible on http://localhost:8080/.

### H2 Database
The application uses an H2 database in-memory by default. The database will be populated with data during runtime. If you want to access the H2 console (for debugging or querying data directly), you can do so by navigating to:
http://localhost:8080/h2-console
* jdbc:h2:mem:ecommercedb
* user: root
