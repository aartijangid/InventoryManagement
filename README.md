# Bakery Service

## How to install?
1. Make sure you have java 8(or higher version) installed on your systems
2. Ensure Maven package manager wrapper(mvnw) is included in the project root directory
3. Clean and Install
	`./mvnw clean install`

## How to run tests?
1. Ensure to go through "How to install?"
2. Run test with Maven
	`./mvnw clean test` 

## How to start server?
	`java -jar target/bakery-services-rest-api-0.0.1-SNAPSHOT.jar`
	
## Approach
Test Driven Development(TDD)

Use Greedy algorithm for best packaging.
Greedy algorithm an algorithmic strategy that makes the best optimal choice at each small stage with the goal of this eventually leading to a globally optimum solution. This means that the algorithm picks the best solution at the moment without regard for consequences.
	
* Story 1
    - 1.1 Define project structure
    - 1.2 Define pre-requisite models (Beans and DTOs)
* Story 2
    - 2.1 Create API URL and verify integration using mock data  
* Story 3
    - 3.1 Populate given bakery inventory data
* Story 4
    - 4.1 Process Order with the help of Greedy Algorithm to get best order packaging
  
## Tools and framework
1. Eclipse IDE
2. Spring Tool Suit 4 (4.3.0 version) plugin
3. Spring Boot
4. JUnit for testing
5. jackson library for object mapping (used only in test)