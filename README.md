# Spring rsocket + r2dbc + mysql
- [rsocket](https://docs.spring.io/spring-integration/docs/current/reference/html/rsocket.html)
- [r2dbc](https://docs.spring.io/spring-data/r2dbc/docs/1.1.0.M2/reference/html/#reference)

# Requirements
1. Java11
1. Yarn
1. Docker Compose

# Run
1. docker-compose up -d
1. mvnw spring-boot:run
1. open http://localhost:8080/index.html

# Note
https://github.com/rsocket/rsocket/blob/master/Extensions/Routing.md#metadata-contents
```
metadata: String.fromCharCode("addresses".length) + "addresses"
```

<!-- 
# Spring WebFlux Load testing

- mvnw gatling:test
-->





