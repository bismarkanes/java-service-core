.PHONY = run test

run:
	./mvnw spring-boot:run

test:
	mvn test
