# AGENTS.md — Navigation Guide for AI Coding Agents

## Project Overview

`<%= projectName %>`: <%= description %>. A layered-architecture microservice on Spring Boot 3.3.x + Java <%= javaVersion %> + Maven.

## Directory Structure and Responsibilities

- `src/main/java/<%= packageName %>/`
  - `controller/`: REST controllers — parameter validation and response assembly only; no business logic
  - `service/`: business logic layer; controllers access data through services
  - `repository/`: data access layer; `ItemRepository` is currently an in-memory implementation (ConcurrentHashMap) — replace it with Spring Data JPA/MyBatis when connecting a real database
  - `model/`: domain models (POJOs)
  - `common/`: `ApiResponse` (unified response body), `GlobalExceptionHandler` (global exceptions), business exception classes
- `src/main/resources/application.yml`: application config; server port <%= port %>
- `src/test/java/<%= packageName %>/`: tests mirroring the main structure

## Coding Conventions

- All REST endpoints return `ApiResponse<T>`, built via `ApiResponse.success(data)` / `ApiResponse.error(...)`; never return raw objects
- Throw `ResourceNotFoundException` for missing resources; `GlobalExceptionHandler` turns it into a 404 response uniformly — no try-catch in controllers
- Validate parameters with Bean Validation annotations (`@NotBlank`, etc.) + `@Valid`; validation failures are returned as 400 by the global exception handler
- The package root is `<%= packageName %>`; new code must live in this package or its subpackages, or component scanning will miss it
- New endpoints follow the `/api/<resource>` prefix convention
- 4-space indentation, UTF-8 files, LF line endings (see `.editorconfig`)

## Common Commands

```bash
mvn compile          # compile
mvn test             # run all unit tests
mvn package          # build executable jar
mvn spring-boot:run  # run locally (port <%= port %>)
```

## Change Checklist

- When modifying the common response structure (`ApiResponse`), update the API section of the README accordingly
- When adding a controller, add the corresponding MockMvc tests (see `ItemControllerTest`)
- When changing `application.yml` settings, check whether tests rely on the defaults
