# Spring AI Demo

This repository contains a demo Spring Boot application that showcases integrating AI capabilities into a Spring application. The demo provides examples for calling AI services, handling prompts, and integrating AI responses into business logic.

> NOTE: This README is a general template. Update configuration values and instructions to match your specific implementation and AI provider.

## Features

- Spring Boot application (Java)
- Example service that sends prompts to an AI provider and receives responses
- Simple REST API endpoints to demonstrate AI interactions
- Configuration for environment-based settings (API keys, endpoints)

## Requirements

- Java 17+ (or the Java version configured in the project)
- Maven or Gradle (depending on project build tool)
- An account and API key for the AI provider used by the application

## Getting started

1. Clone the repository:

   git clone https://github.com/sujanduminda/SpringAiDemo.git
   cd SpringAiDemo

2. Configure environment variables (example):

   export AI_API_KEY=your_api_key_here
   export AI_API_URL=https://api.example.com/v1

   Alternatively, set these in application.properties or application.yml as appropriate for your environment.

3. Build the project:

   If using Maven:
   mvn clean package

   If using Gradle:
   ./gradlew build

4. Run the application:

   java -jar target/spring-aidemo-0.0.1-SNAPSHOT.jar

   Or using Maven:
   mvn spring-boot:run

## API

The demo exposes a few simple REST endpoints to interact with the AI service. Example endpoints (adjust paths based on your controller code):

- POST /api/ai/prompt
  - Request body: { "prompt": "Write a short product description for a coffee maker." }
  - Response: { "response": "AI-generated text..." }

- GET /health
  - Simple health check

Refer to the controllers in the `src/main/java` directory for exact endpoint paths and request/response formats.

## Configuration

Common configuration points (update according to your code):

- application.properties / application.yml
  - ai.api.key
  - ai.api.url
  - ai.model (if applicable)

Environment variables are preferred for sensitive values like API keys.

## Development notes

- Add unit tests for service classes that encapsulate AI calls. Mock external HTTP calls to the AI provider.
- Keep prompt construction and parsing in separate classes to make testing and iteration easier.
- Implement rate limiting and retries where appropriate when calling external AI APIs.

## Contributing

Contributions are welcome. Open an issue to discuss changes before submitting a pull request.

1. Fork the repository
2. Create a feature branch
3. Commit your changes and open a PR

## License

Specify a license for your project (e.g., MIT, Apache-2.0) or keep it private as needed.

---

If you want, I can customize this README with specific build tool (Maven/Gradle) details, the exact endpoints from the code, or include sample curl requests. Tell me what you'd like added.