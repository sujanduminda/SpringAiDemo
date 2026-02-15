SpringAiDemo - Weather REST API

This project provides a simple Spring Boot REST API to get the current weather status for a given city.

Features
- GET /api/weather?city={cityName}
- Returns JSON with city, temperature (Celsius), description, timestamp and data source.
- If an OpenWeatherMap API key is provided the service will fetch real data. Otherwise it returns a deterministic mock response for testing.

How to run
1. Build:
   mvn -U -DskipTests package
2. Run:
   java -jar target/SpringAiDemo-0.0.1-SNAPSHOT.jar

Configuration
- To enable real data from OpenWeatherMap set the environment variable OPENWEATHERMAP_API_KEY or configure application.yml with the key.
  Example (Linux/macOS):
    export OPENWEATHERMAP_API_KEY=your_api_key_here

Examples
- Mock mode (no API key):
  curl "http://localhost:8080/api/weather?city=London"

- Real data (with API key):
  curl "http://localhost:8080/api/weather?city=London"

Notes
- The OpenWeatherMap API may return errors for unknown city names; the service will return 404 in such cases.
- This is a minimal example intended as a starting point. Feel free to extend error handling, add caching, tests and DTOs as needed.
