# Student Management Application

This is a Student Management Application built using Spring Boot.

## Prerequisites

- Java 21
- Maven
- An IDE of your choice (IntelliJ IDEA, Eclipse, VSCode, etc.)

## Setup

1. **Clone the repository:**

   ```sh
   git clone https://github.com/shaman786/student_management.git
   cd student_management
   ```

2. **Build the project using Maven:**

   ```sh
   mvn clean install
   ```

3. **Run the application:**

   ```sh
   mvn spring-boot:run
   ```

## Application Properties

The application is configured to use an in-memory H2 database. The configuration can be found in the `application.properties` file:

```yaml
spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;INIT=runscript from 'classpath:schema.sql'
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.sql.init.platform=h2
spring.h2.console.enabled=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=none
```

You can access the H2 database console at `http://localhost:8080/h2-console` with the following credentials:

- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: `password`

## REST API Endpoints

### Student Endpoints

1. **Create a Student**

   - **URL**: `/api/students`
   - **Method**: `POST`
   - **Request Body**:
     ```json
     {
       "name": "Fayaj",
       "address": "123 Main St",
       "subjects": [
         {
           "id": 1,
           "name": "Mathematics"
         },
         {
           "id": 2,
           "name": "Science"
         }
       ]
     }
     ```

2. **Get List of All Students**

   - **URL**: `/api/students`
   - **Method**: `GET`

3. **Get Student by ID (including subjects)**

   - **URL**: `/api/students/{id}`
   - **Method**: `GET`

### Subject Endpoints

1. **Get List of All Subjects**

   - **URL**: `/api/subjects`
   - **Method**: `GET`

## Security

The security part involving JWT-based login for students and admins was not completed. The application currently does not include authentication and authorization.

---
