# SPRING BOOT HTTP REST SERVICE

Basic core HTTP Rest Service using spring boot, JPA, Hibernate. This project use [Maven](https://maven.apache.org/) as project management.

## ENVIRONMENT VARIABLES

### Http server port
```
SERVER_PORT=8080
```

### Database dialect ex: PostgreSQL, MySQL, Oracle etc
```
DATABASE_DIALECT=org.hibernate.dialect.PostgreSQLDialect
```

### Database configuration in url form
```
DATABASE_URL=jdbc:postgresql://localhost:5432/postgres
```

### Database user name
```
DATABASE_USER=
```

### Database user password
```
DATABASE_PASSWORD=
```

## HOW TO RUN

### Setting Up Environment Variables

#### Manual Export
```console
$ export SERVER_PORT=8080
$ export DATABASE_DIALECT=org.hibernate.dialect.PostgreSQLDialect
$ export DATABASE_URL=jdbc:postgresql://localhost:5432/java
$ export DATABASE_USER=your_user_name
$ export DATABASE_PASSWORD=your_password
```

#### Using dotenv file
File ```.env.template``` can be used as template. Create ```.env``` file which content:
```console
SERVER_PORT=8080
DATABASE_DIALECT=org.hibernate.dialect.PostgreSQLDialect
DATABASE_URL=jdbc:postgresql://localhost:5432/java
DATABASE_USER=your_user_name
DATABASE_PASSWORD=your_password
```

Export environment variables:
```console
$ export $(cat .env)
```

### Run The Application

#### Using spring boot runner
```console
$ ./mvnw spring-boot:run
```

#### Using Makefile
```console
$ make run
```

### Run Test
Make sure you have set the environment variables.

```console
$ mvn test
or
$ make test
```

## Project Structure
```console
├── Makefile
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
├── scripts
│   └── test.restclient
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── service
│   │   │           └── core
│   │   │               ├── controller
│   │   │               │   └── UserController.java
│   │   │               ├── CoreApplication.java
│   │   │               ├── http
│   │   │               │   ├── HttpResponse.java
│   │   │               │   └── HttpResponseMeta.java
│   │   │               ├── model
│   │   │               │   └── User.java
│   │   │               ├── repository
│   │   │               │   └── UserRepository.java
│   │   │               └── utils
│   │   │                   └── Pagination.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── static
│   │       └── templates
│   └── test
│       └── java
│           └── com
│               └── service
│                   ├── core
│                   │   └── CoreApplicationTests.java
│                   ├── http
│                   │   └── TestHttp.java
│                   └── utils
│                       └── TestUtils.java
```

## References
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Spring Initializr](https://start.spring.io/)
* [Lsp-Java](https://github.com/emacs-lsp/lsp-java)
