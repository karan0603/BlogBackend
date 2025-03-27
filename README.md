BlogBackend
A simple Spring Boot backend for managing blogs.

Getting Started
Prerequisites
Java 17+
MySQL
Maven

Setup
Clone the repository
git clone https://github.com/karan0603/BlogBackend.git
cd BlogBackend


Configure the database (update application.properties in src/main/resources/)
spring.datasource.url=jdbc:mysql://localhost:3306/blogdb
spring.datasource.username=root
spring.datasource.password=your-password


Run the application
./mvnw spring-boot:run


API Endpoints

Method	Endpoint	    Description
GET 	 /blogs/greet  Returns "hello"
POST	 /blogs/new	   Create a new blog
GET 	 /blogs/all	   Retrieve all blogs
GET 	 /blogs/{id}	 Retrieve blog by ID
PUT 	 /blogs/{id}	 Update a blog by ID
DELETE /blogs/{id}	 Delete a blog by ID
