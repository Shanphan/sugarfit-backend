# Sugarfit Backend

## Overview
This repository contains the **production-ready Spring Boot backend service** that powers Sugar.fit's core platform.

The goal of this template is not feature richness, but **engineering quality** — clean structure, sensible defaults, and clear intent — so that it can be safely extended and maintained by multiple engineers in a high-traffic production environment.

---

## 1. How to Run

### Prerequisites
- Java 21
- Gradle 8.12.1

### Run Locally
```bash
./gradlew clean build
./gradlew bootRun
```

The application will start on:

```
http://localhost:8080
```

### Available Endpoints

**GET /health**  
Returns the current health status of the application.

**POST /api/v1/examples/example**  
Sample data-processing endpoint.

Example request:

```json
{
  "userId": "123",
  "value": 42
}
```

Example response:

```json
{
  "status": "SUCCESS",
  "requestId": "uuid-string"
}
```

---

## 2. Design Decisions

### Layered Architecture

The project follows a clear layered architecture:

```
controller  →  service  →  domain / DTOs
```

- Controllers handle HTTP concerns only.
- Services encapsulate business logic.
- DTOs define request/response contracts.

This separation improves readability, testability, and long-term maintainability.

### API Versioning

All business APIs are versioned under:

```
/api/v1/...
```

This allows backward-compatible evolution of APIs over time. Infrastructure endpoints (e.g. `/health`) are intentionally kept outside versioned APIs, following common production practices.

### Global Error Handling

A global exception handler (`@ControllerAdvice`) is used to:

- Centralize error handling
- Ensure consistent error responses
- Keep controllers clean and focused

This approach allows error-handling logic to evolve independently from business logic.

### Sensible Defaults

- Spring Boot defaults are preferred over heavy customization
- Logging is implemented using SLF4J
- Configuration is externalized via `application.yml`

The intent is to keep the template simple, predictable, and easy to extend.

---

## 3. Assumptions & Trade-offs

Given the limited scope, the following assumptions were made:

**Persistence is minimal**  
No production database is enforced to avoid prematurely locking into a specific storage choice.

**Security is intentionally excluded**  
Authentication and authorization requirements vary widely across services and are better added once requirements are clear.

**Observability tooling is deferred**  
Metrics and tracing depend on deployment infrastructure and are documented as future enhancements.

**Single-module service**  
The template assumes a simple Spring Boot application structure for clarity and ease of onboarding.

These trade-offs were made to keep the focus on code quality and structure, not feature volume.

---

## 4. Future Roadmap

If this template were to evolve into a long-term production foundation, the following enhancements would be added:

### Security

- Spring Security integration
- Token-based authentication (JWT / OAuth2)
- Role-based access control for APIs

### Observability & Monitoring

- Prometheus metrics
- Grafana dashboards
- Enhanced readiness and liveness probes

### Persistence

- Integration with a persistent database (PostgreSQL / MySQL)
- Schema migrations using Flyway or Liquibase

### CI/CD & Deployment

- Dockerfile for containerization
- GitHub Actions for build, test, and deployment pipelines
- Kubernetes manifests or Helm charts

### Configuration & API Management

- Spring Profiles for environment-specific configuration
- Externalized secrets management
- OpenAPI / Swagger documentation

### Testing

- Unit tests for service layer
- Controller tests

---

## Final Note

This repository is intentionally minimal but production-aware. It is designed to scale in complexity as real-world requirements emerge, without requiring structural refactoring.

The emphasis is on engineering maturity, clarity of intent, and long-term maintainability.