Currency - Spring Boot demo project

This is a simple Spring Boot application that provides a small currency exchange REST endpoint.

Endpoints:
- GET /api/currency/exchange?from=USD&to=EUR
  - returns JSON: { "from":"USD", "to":"EUR", "rate":0.92 }

Run:
- mvn -f Currency/ spring-boot:run
- or build with: mvn -f Currency/ package && java -jar Currency/target/currency-0.0.1-SNAPSHOT.jar

Notes:
- Rates are hard-coded for demo purposes. Replace with a real service or DB for production use.
