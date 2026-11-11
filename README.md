# <%= projectName %>

<%= description %>
<% if (author) { %>
> Author: <%= author %>
<% } %>
## Overview

A Spring Boot 3.3.x microservice project with a standard layered architecture (controller / service / repository / model / common). It ships with a unified response body `ApiResponse`, a global exception handler `GlobalExceptionHandler`, a health check endpoint, an example CRUD API and unit tests.

## Tech Stack

- Java <%= javaVersion %>
- Spring Boot 3.3.x (spring-boot-starter-web, spring-boot-starter-validation)
- Maven build
- JUnit 5 + MockMvc unit tests

## Project Structure

```
src/main/java/<%= packageName %>/                       # Package root (directory rendered from packageName)
├── Application.java                               # Bootstrap class
├── controller/                                      # Controller layer: REST endpoints
│   ├── HealthController.java                        # /api/health health check
│   └── ItemController.java                          # /api/items example CRUD
├── service/                                         # Business logic layer
│   └── ItemService.java
├── repository/                                      # Data access layer (in-memory example)
│   └── ItemRepository.java
├── model/                                           # Domain models
│   └── Item.java
└── common/                                          # Shared components
    ├── ApiResponse.java                             # Unified response body
    ├── GlobalExceptionHandler.java                  # Global exception handling
    └── ResourceNotFoundException.java               # Resource-not-found exception
src/main/resources/application.yml                   # App config (port <%= port %>)
src/test/java/<%= packageName %>/controller/  # MockMvc test examples
```

## Quick Start

This project was generated from an AgileBuilder template. To regenerate a similar project:

```bash
ag create --git-url <template-repo-url> --target <directory>
```

Run locally:

```bash
mvn spring-boot:run
# visit http://localhost:<%= port %>/api/health
```

## Template Variables

| Variable | Type | Description | Default |
| ------ | ---- | ---- | ------ |
| projectName | input | Project name (required; artifactId takes its kebab-case form) | demo-service |
| description | input | Project description | A Spring Boot microservice |
| author | input | Author | (empty) |
| packageName | input | Java package name | com.example.demo |
| javaVersion | list | Java version (17 / 21) | 17 |
| port | number | Server port | 8080 |

Template content is rendered with EJS (delimiter `%`); variable placeholders in files are replaced with actual values.

## Common Commands

```bash
mvn compile                # compile
mvn test                   # run unit tests
mvn package                # build an executable jar (under target/)
mvn spring-boot:run        # run locally
```

## API Examples

- `GET /api/health`: health check
- `GET /api/items`: list all items
- `GET /api/items/{id}`: get by ID
- `POST /api/items`: create an item (JSON body: `{"name": "sample"}`)
- `PUT /api/items/{id}`: update an item
- `DELETE /api/items/{id}`: delete an item

All endpoints return the unified structure: `{"code": 0, "message": "success", "data": ...}`.

## License

MIT
