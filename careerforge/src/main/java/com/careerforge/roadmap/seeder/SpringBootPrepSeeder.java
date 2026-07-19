package com.careerforge.roadmap.seeder;

import java.util.ArrayList;
import java.util.List;

public class SpringBootPrepSeeder {

    static final String JB_DI = "https://www.youtube.com/watch?v=GB8k2-Egfv0&list=PLC97BDEFDCDD169D7";
    static final String JB_BOOT = "https://www.youtube.com/watch?v=YXlSkWq04jk&list=PLqq-6Pq4lTTbx8p2oCgcAQGQyqN8XeA1x";
    static final String AC_MICRO = "https://www.youtube.com/watch?v=1aWhYEynZQw";
    static final String SPRING_IO_BOOT = "https://spring.io/guides/gs/spring-boot/";
    static final String SPRING_IO_QS = "https://spring.io/quickstart";

    public static void seed(
        com.careerforge.roadmap.entity.Roadmap dbRoadmap,
        com.careerforge.roadmap.repository.RoadmapSectionRepository roadmapSectionRepository,
        com.careerforge.roadmap.repository.QuestionRepository questionRepository,
        com.careerforge.roadmap.repository.QuestionLinkRepository questionLinkRepository,
        com.careerforge.roadmap.repository.RoadmapSectionQuestionRepository roadmapSectionQuestionRepository
    ) {
        System.out.println("Seeding Roadmap: Spring Boot Complete Preparation Sheet");
        Roadmap.sections.clear();

        RoadmapSection s;
        Topic t;

        // ==========================================
        // Section 1: Java & Build Tool Foundations
        // ==========================================
        s = createSection("Java & Build Tool Foundations");

        t = createTopic(s, "Modern Java Essentials for Spring");
        addQ(t, "Java 8 Streams API", "EASY", "ARTICLE", "https://www.baeldung.com/spring-tutorial");
        addQ(t, "Lambda Expressions and Functional Interfaces", "EASY", "ARTICLE", "https://www.baeldung.com/spring-tutorial");
        addQ(t, "Optional Class in Java", "EASY", "ARTICLE", "https://www.baeldung.com/spring-tutorial");
        addQ(t, "Java Records for DTOs", "EASY");

        t = createTopic(s, "Build Tools - Maven and Gradle");
        addQ(t, "Maven POM and Dependency Management", "EASY", "ARTICLE", "https://www.baeldung.com/spring-boot-start");
        addQ(t, "Maven Build Lifecycle", "EASY");
        addQ(t, "Gradle Basics for Spring Boot Projects", "EASY");
        addQ(t, "Maven vs Gradle for Spring Projects", "EASY");

        // ==========================================
        // Section 2: Introduction to Spring and Spring Boot
        // ==========================================
        s = createSection("Introduction to Spring and Spring Boot");

        t = createTopic(s, "Spring Framework Fundamentals");
        addQ(t, "Spring Framework Introduction", "EASY", "ARTICLE", "https://www.baeldung.com/spring-intro");
        addQ(t, "Spring vs Spring Boot", "EASY", "ARTICLE", "https://www.baeldung.com/spring-tutorial");
        addQ(t, "Spring Application Context", "EASY", "ARTICLE", "https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring");
        addQ(t, "Spring Bean Lifecycle", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-tutorial");

        t = createTopic(s, "Getting Started with Spring Boot");
        addQ(t, "Bootstrap a Simple Spring Boot Application", "EASY", "ARTICLE", "https://www.baeldung.com/spring-boot-start", "VIDEO", JB_BOOT);
        addQ(t, "Spring Initializr and Starters", "EASY", "ARTICLE", "https://www.baeldung.com/spring-boot-start", "VIDEO", SPRING_IO_QS);
        addQ(t, "Spring Boot Auto-Configuration", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-boot-start");
        addQ(t, "Common Spring Boot Annotations Overview", "EASY", "ARTICLE", "https://www.baeldung.com/spring-boot-start");
        addQ(t, "Building a Simple REST Controller", "EASY", "ARTICLE", "https://www.baeldung.com/spring-boot-start", "VIDEO", SPRING_IO_BOOT);

        // ==========================================
        // Section 3: Dependency Injection and IoC
        // ==========================================
        s = createSection("Dependency Injection and IoC");

        t = createTopic(s, "IoC Container Concepts");
        addQ(t, "Inversion of Control and Dependency Injection", "EASY", "ARTICLE", "https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring", "VIDEO", JB_DI);
        addQ(t, "Spring Bean Scopes", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-dependency-injection");
        addQ(t, "Component Scanning and Stereotype Annotations", "EASY", "ARTICLE", "https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring");
        addQ(t, "Java Config vs XML Config", "EASY", "ARTICLE", "https://www.baeldung.com/spring-xml-injection");

        t = createTopic(s, "Dependency Injection Techniques");
        addQ(t, "Constructor-Based Dependency Injection", "EASY", "ARTICLE", "https://www.baeldung.com/constructor-injection-in-spring");
        addQ(t, "Setter-Based Dependency Injection", "EASY", "ARTICLE", "https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring");
        addQ(t, "Field Injection with @Autowired", "EASY", "ARTICLE", "https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring");
        addQ(t, "@Qualifier and Primary Beans", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-dependency-injection");
        addQ(t, "Injecting Java Collections in Spring", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-injecting-collections");

        // ==========================================
        // Section 4: Spring Boot Configuration
        // ==========================================
        s = createSection("Spring Boot Configuration");

        t = createTopic(s, "Externalized Configuration");
        addQ(t, "application.properties vs application.yml", "EASY", "ARTICLE", "https://www.baeldung.com/spring-boot-yaml-vs-properties");
        addQ(t, "@ConfigurationProperties Deep Dive", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-boot-yaml-vs-properties");
        addQ(t, "Spring Profiles for Environments", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-boot-yaml-vs-properties");
        addQ(t, "Property Placeholders and @Value", "EASY", "ARTICLE", "https://www.baeldung.com/spring-dependency-injection");
        addQ(t, "Conditional Beans and Feature Toggles", "MEDIUM", "ARTICLE", "https://www.baeldung.com/swagger-ui-turn-off-in-production");

        // ==========================================
        // Section 5: Building REST APIs
        // ==========================================
        s = createSection("Building REST APIs");

        t = createTopic(s, "Controllers and Request Mapping");
        addQ(t, "@RestController and @RequestMapping", "EASY", "ARTICLE", "https://www.baeldung.com/spring-boot-start");
        addQ(t, "Path Variables and Request Parameters", "EASY", "ARTICLE", "https://www.baeldung.com/spring-boot-start");
        addQ(t, "Request Body and ResponseEntity", "EASY", "ARTICLE", "https://www.baeldung.com/spring-boot-bean-validation");
        addQ(t, "HTTP Methods in Spring MVC", "EASY");
        addQ(t, "Content Negotiation in Spring MVC", "MEDIUM", "ARTICLE", "https://www.baeldung.com/exception-handling-for-rest-with-spring");

        t = createTopic(s, "REST API Design Best Practices");
        addQ(t, "REST API Error Handling Best Practices", "MEDIUM", "ARTICLE", "https://www.baeldung.com/rest-api-error-handling-best-practices");
        addQ(t, "Pagination in REST APIs", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-data-jpa-query");
        addQ(t, "Versioning REST APIs", "MEDIUM");
        addQ(t, "Documenting REST APIs with OpenAPI 3.0", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-rest-openapi-documentation");

        // ==========================================
        // Section 6: Validation and Exception Handling
        // ==========================================
        s = createSection("Validation and Exception Handling");

        t = createTopic(s, "Bean Validation");
        addQ(t, "Validation in Spring Boot", "EASY", "ARTICLE", "https://www.baeldung.com/spring-boot-bean-validation");
        addQ(t, "Bean Validation Annotations (@NotNull, @Size, @Pattern)", "EASY", "ARTICLE", "https://www.baeldung.com/spring-boot-bean-validation");
        addQ(t, "Custom Validation Annotations", "MEDIUM", "ARTICLE", "https://www.baeldung.com/exception-handling-for-rest-with-spring");
        addQ(t, "Validating Path Variables and Request Params", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-boot-bean-validation");

        t = createTopic(s, "Exception Handling");
        addQ(t, "Error Handling for REST with Spring", "MEDIUM", "ARTICLE", "https://www.baeldung.com/exception-handling-for-rest-with-spring");
        addQ(t, "Global Exception Handler with @ControllerAdvice", "MEDIUM", "ARTICLE", "https://www.baeldung.com/global-error-handler-in-a-spring-rest-api");
        addQ(t, "Custom Error Response Structures", "MEDIUM", "ARTICLE", "https://www.baeldung.com/global-error-handler-in-a-spring-rest-api");
        addQ(t, "@ResponseStatus and ProblemDetail", "MEDIUM", "ARTICLE", "https://www.baeldung.com/exception-handling-for-rest-with-spring");

        // ==========================================
        // Section 7: Spring Data JPA and Persistence
        // ==========================================
        s = createSection("Spring Data JPA and Persistence");

        t = createTopic(s, "JPA Fundamentals");
        addQ(t, "Introduction to Spring Data JPA", "EASY", "ARTICLE", "https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa");
        addQ(t, "JPA Entity Mapping Basics", "EASY", "ARTICLE", "https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa");
        addQ(t, "CrudRepository vs JpaRepository", "EASY", "ARTICLE", "https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa");
        addQ(t, "Spring Data Repository Hierarchy", "EASY", "ARTICLE", "https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa");

        t = createTopic(s, "Query Methods");
        addQ(t, "Derived Query Methods in Spring Data JPA", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-data-derived-queries");
        addQ(t, "@Query Annotation with JPQL and Native SQL", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-data-jpa-query");
        addQ(t, "LIKE Queries in Spring JPA Repositories", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-jpa-like-queries");
        addQ(t, "Query by Example", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-data-query-by-example");
        addQ(t, "Dynamic Queries with Specifications", "HARD", "ARTICLE", "https://www.baeldung.com/spring-data-jpa-query-arbitrary-and-clauses");

        t = createTopic(s, "Advanced JPA");
        addQ(t, "Entity Relationships (OneToMany, ManyToMany)", "MEDIUM", "ARTICLE", "https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa");
        addQ(t, "Pagination and Sorting with Spring Data", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-data-jpa-query");
        addQ(t, "Spring Data JPA Repository for Database Views", "HARD", "ARTICLE", "https://www.baeldung.com/spring-data-jpa-repository-view");
        addQ(t, "Criteria API Queries", "HARD", "ARTICLE", "https://www.baeldung.com/spring-data-criteria-queries");

        // ==========================================
        // Section 8: Transactions and Database Management
        // ==========================================
        s = createSection("Transactions and Database Management");

        t = createTopic(s, "Transaction Management");
        addQ(t, "Transactions with Spring and JPA", "MEDIUM", "ARTICLE", "https://www.baeldung.com/transaction-configuration-with-jpa-and-spring");
        addQ(t, "Programmatic Transaction Management", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-programmatic-transaction-management");
        addQ(t, "Transaction Propagation and Isolation Levels", "HARD", "ARTICLE", "https://www.baeldung.com/transaction-configuration-with-jpa-and-spring");

        t = createTopic(s, "Database Migration and Test Data");
        addQ(t, "Flyway with Spring Boot", "MEDIUM");
        addQ(t, "Liquibase with Spring Boot", "MEDIUM");
        addQ(t, "H2 In-Memory Database for Testing", "EASY", "ARTICLE", "https://www.baeldung.com/spring-boot-testing");

        // ==========================================
        // Section 9: Spring Security Fundamentals
        // ==========================================
        s = createSection("Spring Security Fundamentals");

        t = createTopic(s, "Authentication and Authorization");
        addQ(t, "Spring Security Introduction", "EASY", "ARTICLE", "https://www.baeldung.com/spring-security-integration-tests");
        addQ(t, "SecurityFilterChain Configuration", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-security-integration-tests");
        addQ(t, "In-Memory and JDBC Authentication", "MEDIUM");
        addQ(t, "Password Encoding with BCrypt", "EASY");
        addQ(t, "Method-Level Security (@PreAuthorize)", "MEDIUM");

        t = createTopic(s, "Securing REST APIs");
        addQ(t, "Spring Security for Spring Boot Integration Tests", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-security-integration-tests");
        addQ(t, "Configuring Security to Allow Swagger UI", "MEDIUM", "ARTICLE", "https://www.baeldung.com/java-spring-security-permit-swagger-ui");
        addQ(t, "CORS Configuration in Spring Security", "MEDIUM");

        // ==========================================
        // Section 10: Spring Security with JWT and OAuth2
        // ==========================================
        s = createSection("Spring Security with JWT and OAuth2");

        t = createTopic(s, "JWT Authentication");
        addQ(t, "Creating a Signing Key for a JWT Token", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-security-sign-jwt-token");
        addQ(t, "Mapping Authorities from JWT Claims", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-security-map-authorities-jwt");
        addQ(t, "Building a JWT Authentication Filter", "HARD", "ARTICLE", "https://www.baeldung.com/spring-security-sign-jwt-token");
        addQ(t, "Access Tokens and Refresh Tokens", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-security-oauth-jwt");

        t = createTopic(s, "OAuth2");
        addQ(t, "Using JWT with Spring Security OAuth2", "HARD", "ARTICLE", "https://www.baeldung.com/spring-security-oauth-jwt");
        addQ(t, "Tokens, OAuth2 and JWT", "MEDIUM");
        addQ(t, "Setting up an OAuth2 Authorization Server", "HARD", "ARTICLE", "https://www.baeldung.com/spring-security-oauth-jwt");
        addQ(t, "Resource Server Configuration", "HARD", "ARTICLE", "https://www.baeldung.com/spring-security-oauth-jwt");

        // ==========================================
        // Section 11: Caching, AOP and Cross-Cutting Concerns
        // ==========================================
        s = createSection("Caching, AOP and Cross-Cutting Concerns");

        t = createTopic(s, "Aspect-Oriented Programming");
        addQ(t, "Introduction to AOP in Spring", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-aop-advice-tutorial");
        addQ(t, "Advice Types in Spring (Before, After, Around)", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-aop-advice-tutorial");
        addQ(t, "Logging with AOP in Spring", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-aspect-oriented-programming-logging");

        t = createTopic(s, "Caching");
        addQ(t, "A Guide to Caching in Spring", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-cache-tutorial");
        addQ(t, "@Cacheable, @CachePut and @CacheEvict", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-cache-tutorial");
        addQ(t, "Configuring Cache Providers", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-cache-tutorial");

        t = createTopic(s, "Scheduling and Async Processing");
        addQ(t, "Spring Scheduling Annotations Overview", "EASY", "ARTICLE", "https://www.baeldung.com/spring-scheduling-annotations");
        addQ(t, "The @Scheduled Annotation Deep Dive", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-scheduled-tasks");
        addQ(t, "A Guide to the Spring Task Scheduler", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-task-scheduler");
        addQ(t, "How To Do @Async in Spring", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-async");
        addQ(t, "Conditionally Enable Scheduled Jobs", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-scheduled-enabled-conditionally");

        // ==========================================
        // Section 12: Testing in Spring Boot
        // ==========================================
        s = createSection("Testing in Spring Boot");

        t = createTopic(s, "Unit Testing");
        addQ(t, "Testing in Spring Boot Overview", "EASY", "ARTICLE", "https://www.baeldung.com/spring-boot-testing");
        addQ(t, "Mockito for Unit Testing Services", "EASY", "ARTICLE", "https://www.baeldung.com/spring-boot-testing");
        addQ(t, "Testing the Service Layer with @MockBean", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-boot-testing");

        t = createTopic(s, "Integration Testing");
        addQ(t, "MockMvc With @SpringBootTest vs @WebMvcTest", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-mockmvc-vs-webmvctest");
        addQ(t, "Integration Testing in Spring", "MEDIUM", "ARTICLE", "https://www.baeldung.com/integration-testing-in-spring");
        addQ(t, "Spring Security in Integration Tests", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-security-integration-tests");
        addQ(t, "Disabling @EnableScheduling in Tests", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-test-disable-enablescheduling");
        addQ(t, "@DataJpaTest for Repository Testing", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-boot-testing");

        t = createTopic(s, "Testcontainers");
        addQ(t, "Testing Kafka and Spring Boot with Testcontainers", "HARD", "ARTICLE", "https://www.baeldung.com/spring-boot-kafka-testing");
        addQ(t, "Testcontainers for Database Integration Tests", "HARD", "ARTICLE", "https://www.baeldung.com/spring-boot-testing");

        // ==========================================
        // Section 13: Observability and Production Readiness
        // ==========================================
        s = createSection("Observability and Production Readiness");

        t = createTopic(s, "Spring Boot Actuator");
        addQ(t, "Spring Boot Actuator Overview", "EASY", "ARTICLE", "https://www.baeldung.com/spring-boot-actuators");
        addQ(t, "Custom Actuator Endpoints", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-boot-actuators");
        addQ(t, "Health Indicators and Metrics", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-boot-actuators");

        t = createTopic(s, "Logging");
        addQ(t, "Logging in Spring Boot", "EASY", "ARTICLE", "https://www.baeldung.com/spring-aspect-oriented-programming-logging");
        addQ(t, "Logback Configuration in Spring Boot", "MEDIUM");
        addQ(t, "Structured Logging Best Practices", "MEDIUM");

        t = createTopic(s, "API Documentation");
        addQ(t, "Documenting a Spring REST API with OpenAPI 3.0", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-rest-openapi-documentation");
        addQ(t, "Turning Off Swagger UI in Production", "MEDIUM", "ARTICLE", "https://www.baeldung.com/swagger-ui-turn-off-in-production");
        addQ(t, "Securing Swagger UI with Spring Security", "MEDIUM", "ARTICLE", "https://www.baeldung.com/java-spring-security-permit-swagger-ui");

        // ==========================================
        // Section 14: Messaging with Kafka and RabbitMQ
        // ==========================================
        s = createSection("Messaging with Kafka and RabbitMQ");

        t = createTopic(s, "Apache Kafka Fundamentals");
        addQ(t, "Introduction to Apache Kafka", "EASY", "ARTICLE", "https://www.baeldung.com/apache-kafka");
        addQ(t, "Intro to Apache Kafka with Spring", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-kafka");
        addQ(t, "Kafka Producers and Consumers with KafkaTemplate", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-kafka");
        addQ(t, "Consuming Messages in Batch with @KafkaListener", "MEDIUM", "ARTICLE", "https://www.baeldung.com/kafka-kafkalistener-annotation-handle-messages-batch");

        t = createTopic(s, "Kafka Advanced");
        addQ(t, "Kafka Streams with Spring Boot", "HARD", "ARTICLE", "https://www.baeldung.com/spring-boot-kafka-streams");
        addQ(t, "Testing Kafka and Spring Boot", "HARD", "ARTICLE", "https://www.baeldung.com/spring-boot-kafka-testing");
        addQ(t, "Spring Cloud Stream with Kafka and Avro", "HARD", "ARTICLE", "https://www.baeldung.com/spring-cloud-stream-kafka-avro-confluent");

        t = createTopic(s, "RabbitMQ Messaging");
        addQ(t, "RabbitMQ with Spring Boot Basics", "MEDIUM");
        addQ(t, "Spring AMQP Producers and Consumers", "MEDIUM");

        // ==========================================
        // Section 15: Microservices with Spring Cloud
        // ==========================================
        s = createSection("Microservices with Spring Cloud");

        t = createTopic(s, "Service Discovery");
        addQ(t, "Introduction to Spring Cloud Netflix Eureka", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-cloud-netflix-eureka");
        addQ(t, "Spring Cloud Netflix Ribbon Load Balancing", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-cloud-rest-client-with-netflix-ribbon");
        addQ(t, "Service Registration and Discovery Patterns", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-cloud-netflix-eureka", "VIDEO", AC_MICRO);

        t = createTopic(s, "API Gateway and Configuration");
        addQ(t, "Spring Cloud Gateway Basics", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-cloud-bootstrapping");
        addQ(t, "Building Microservices with Spring Cloud (Bootstrapping)", "HARD", "ARTICLE", "https://www.baeldung.com/spring-cloud-bootstrapping", "VIDEO", AC_MICRO);
        addQ(t, "Quick Intro to Spring Cloud Configuration", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-cloud-configuration");
        addQ(t, "Spring Cloud Config Without Git", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-cloud-config-without-git");
        addQ(t, "Spring Cloud Bus for Config Refresh", "HARD", "ARTICLE", "https://www.baeldung.com/spring-cloud-bus");

        t = createTopic(s, "Resilience Patterns");
        addQ(t, "Quick Guide to Spring Cloud Circuit Breaker", "HARD", "ARTICLE", "https://www.baeldung.com/spring-cloud-circuit-breaker");
        addQ(t, "Resilience4j Circuit Breaker with Spring Cloud Gateway", "HARD", "ARTICLE", "https://docs.spring.io/spring-cloud-gateway/reference/spring-cloud-gateway-server-webflux/gatewayfilter-factories/circuitbreaker-filter-factory.html");
        addQ(t, "Retry, Rate Limiter and Bulkhead Patterns", "HARD", "ARTICLE", "https://docs.spring.io/spring-cloud-circuitbreaker/docs/current/reference/html/");

        // ==========================================
        // Section 16: Containerization and Deployment
        // ==========================================
        s = createSection("Containerization and Deployment");

        t = createTopic(s, "Docker with Spring Boot");
        addQ(t, "Dockerizing a Spring Boot Application", "MEDIUM", "ARTICLE", "https://www.baeldung.com/dockerizing-spring-boot-application");
        addQ(t, "Spring Boot Docker Layered Images", "MEDIUM", "ARTICLE", "https://www.baeldung.com/dockerizing-spring-boot-application");
        addQ(t, "Starting Spring Boot in Docker with a Profile", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-boot-docker-start-with-profile");
        addQ(t, "Docker Compose Support in Spring Boot", "MEDIUM", "ARTICLE", "https://www.baeldung.com/docker-compose-support-spring-boot");

        t = createTopic(s, "Deployment Practices");
        addQ(t, "Building Executable JARs with Spring Boot", "EASY", "ARTICLE", "https://www.baeldung.com/spring-boot-start");
        addQ(t, "Externalized Configuration for Production", "MEDIUM", "ARTICLE", "https://www.baeldung.com/spring-boot-yaml-vs-properties");
        addQ(t, "CI/CD Basics for Spring Boot Applications", "MEDIUM");

        // ==========================================
        // Execute Database Save Operations
        // ==========================================

        // 1. Prepare and save top-level Parent Sections
        List<com.careerforge.roadmap.entity.RoadmapSection> dbParentSectionsToSave = new ArrayList<>();
        int sectionPos = 0;
        for (RoadmapSection sec : Roadmap.sections) {
            com.careerforge.roadmap.entity.RoadmapSection dbSec = com.careerforge.roadmap.entity.RoadmapSection.builder()
                .roadmap(dbRoadmap)
                .title(sec.title)
                .position(sectionPos++)
                .build();
            dbParentSectionsToSave.add(dbSec);
        }
        List<com.careerforge.roadmap.entity.RoadmapSection> savedParents = roadmapSectionRepository.saveAll(dbParentSectionsToSave);
        roadmapSectionRepository.flush();

        // 2. Prepare and save Sub-sections (Topics) referencing saved parent sections
        List<com.careerforge.roadmap.entity.RoadmapSection> dbTopicsToSave = new ArrayList<>();
        for (int i = 0; i < Roadmap.sections.size(); i++) {
            RoadmapSection sec = Roadmap.sections.get(i);
            com.careerforge.roadmap.entity.RoadmapSection dbSec = savedParents.get(i);
            int topicPos = 0;
            for (Topic topic : sec.topics) {
                com.careerforge.roadmap.entity.RoadmapSection dbTopic = com.careerforge.roadmap.entity.RoadmapSection.builder()
                    .roadmap(dbRoadmap)
                    .parentSection(dbSec)
                    .parentId(dbSec.getId())
                    .title(topic.title)
                    .position(topicPos++)
                    .build();
                dbTopicsToSave.add(dbTopic);
            }
        }
        List<com.careerforge.roadmap.entity.RoadmapSection> savedTopics = roadmapSectionRepository.saveAll(dbTopicsToSave);
        roadmapSectionRepository.flush();

        // 3. Prepare Questions list
        List<com.careerforge.roadmap.entity.Question> dbQuestionsToSave = new ArrayList<>();
        List<Question> originalQuestions = new ArrayList<>();
        List<com.careerforge.roadmap.entity.RoadmapSection> dbTopicForQuestions = new ArrayList<>();
        int topicIdx = 0;
        
        for (int i = 0; i < Roadmap.sections.size(); i++) {
            RoadmapSection sec = Roadmap.sections.get(i);
            for (Topic topic : sec.topics) {
                com.careerforge.roadmap.entity.RoadmapSection dbTopic = savedTopics.get(topicIdx++);
                for (Question q : topic.questions) {
                    com.careerforge.common.entity.Difficulty diffEnum;
                    try {
                        diffEnum = com.careerforge.common.entity.Difficulty.valueOf(q.difficulty.toUpperCase());
                    } catch (Exception e) {
                        diffEnum = com.careerforge.common.entity.Difficulty.EASY;
                    }
                    com.careerforge.roadmap.entity.Question dbQ = com.careerforge.roadmap.entity.Question.builder()
                        .title(q.title)
                        .description(q.title)
                        .difficulty(diffEnum)
                        .build();
                    dbQuestionsToSave.add(dbQ);
                    originalQuestions.add(q);
                    dbTopicForQuestions.add(dbTopic);
                }
            }
        }
                
        List<com.careerforge.roadmap.entity.Question> savedQuestions = questionRepository.saveAll(dbQuestionsToSave);
        questionRepository.flush();

        // 4. Prepare and save QuestionLinks and RoadmapSectionQuestion mappings
        List<com.careerforge.roadmap.entity.QuestionLink> dbLinksToSave = new ArrayList<>();
        List<com.careerforge.roadmap.entity.RoadmapSectionQuestion> dbRSQsToSave = new ArrayList<>();
        int questionPos = 0;
        
        for (int i = 0; i < savedQuestions.size(); i++) {
            com.careerforge.roadmap.entity.Question dbQ = savedQuestions.get(i);
            Question q = originalQuestions.get(i);
            com.careerforge.roadmap.entity.RoadmapSection dbTopic = dbTopicForQuestions.get(i);

            // Reset question position counter if we transition to a new topic section
            if (i > 0 && !dbTopicForQuestions.get(i - 1).getId().equals(dbTopic.getId())) {
                questionPos = 0;
            }

            int linkPos = 0;
            if (q.solveLink != null && !q.solveLink.isEmpty()) {
                dbLinksToSave.add(com.careerforge.roadmap.entity.QuestionLink.builder()
                    .question(dbQ)
                    .linkType(com.careerforge.roadmap.entity.LinkType.SOLVE)
                    .label("Solve")
                    .url(q.solveLink)
                    .position(linkPos++)
                    .build());
            }

            if (q.editorialLink != null && !q.editorialLink.isEmpty()) {
                dbLinksToSave.add(com.careerforge.roadmap.entity.QuestionLink.builder()
                    .question(dbQ)
                    .linkType(com.careerforge.roadmap.entity.LinkType.ARTICLE)
                    .label("Editorial")
                    .url(q.editorialLink)
                    .position(linkPos++)
                    .build());
            }

            for (QuestionLink link : q.links) {
                com.careerforge.roadmap.entity.LinkType lt;
                try {
                    lt = com.careerforge.roadmap.entity.LinkType.valueOf(link.linkType.toUpperCase());
                } catch (Exception e) {
                    lt = com.careerforge.roadmap.entity.LinkType.ARTICLE;
                }
                dbLinksToSave.add(com.careerforge.roadmap.entity.QuestionLink.builder()
                    .question(dbQ)
                    .linkType(lt)
                    .label(lt == com.careerforge.roadmap.entity.LinkType.VIDEO ? "Video Solution" : "Article Tutorial")
                    .url(link.url)
                    .position(linkPos++)
                    .build());
            }

            dbRSQsToSave.add(com.careerforge.roadmap.entity.RoadmapSectionQuestion.builder()
                .roadmapSection(dbTopic)
                .question(dbQ)
                .position(questionPos++)
                .build());
        }

        questionLinkRepository.saveAll(dbLinksToSave);
        roadmapSectionQuestionRepository.saveAll(dbRSQsToSave);
                
        System.out.println("Seeding completed successfully.");
    }

    // ==========================================
    // Inner Generation Helpers
    // ==========================================

    private static String slugify(String s) {
        if (s == null) return "";
        return s.toLowerCase().replaceAll("[^a-z0-9]+", "_").replaceAll("_+", "_").replaceAll("^_+|_+$", "");
    }

    private static RoadmapSection createSection(String title) {
        RoadmapSection s = new RoadmapSection(slugify(title), title);
        Roadmap.addSection(s);
        return s;
    }

    private static Topic createTopic(RoadmapSection section, String title) {
        Topic t = new Topic(section.slug + "_" + slugify(title), title);
        section.addTopic(t);
        return t;
    }

    private static void addQ(Topic topic, String title, String difficulty, String... links) {
        Question q = new Question(topic.slug + "_" + slugify(title), title, difficulty);
        q.setSolveLink("");

        String editorial = "";
        for (int i = 0; i < links.length; i += 2) {
            if ("ARTICLE".equals(links[i])) {
                editorial = links[i+1];
                break;
            }
        }
        q.setEditorialLink(editorial);

        for (int i = 0; i < links.length; i += 2) {
            q.addLink(new QuestionLink(links[i], links[i+1]));
        }
        topic.addQuestion(q);
    }

    // ==========================================
    // Boilerplate In-Memory Graph Classes
    // ==========================================

    public static class Roadmap {
        public static List<RoadmapSection> sections = new ArrayList<>();
        public static void addSection(RoadmapSection section) {
            sections.add(section);
        }
    }

    public static class RoadmapSection {
        public String slug;
        public String title;
        public List<Topic> topics = new ArrayList<>();

        public RoadmapSection(String slug, String title) {
            this.slug = slug;
            this.title = title;
        }

        public void addTopic(Topic topic) {
            this.topics.add(topic);
        }
    }

    public static class Topic {
        public String slug;
        public String title;
        public List<Question> questions = new ArrayList<>();

        public Topic(String slug, String title) {
            this.slug = slug;
            this.title = title;
        }

        public void addQuestion(Question question) {
            this.questions.add(question);
        }
    }

    public static class Question {
        public String slug;
        public String title;
        public String difficulty;
        public String solveLink;
        public String editorialLink;
        public List<QuestionLink> links = new ArrayList<>();

        public Question(String slug, String title, String difficulty) {
            this.slug = slug;
            this.title = title;
            this.difficulty = difficulty;
        }

        public void setSolveLink(String solveLink) {
            this.solveLink = solveLink;
        }

        public void setEditorialLink(String editorialLink) {
            this.editorialLink = editorialLink;
        }

        public void addLink(QuestionLink link) {
            this.links.add(link);
        }
    }

    public static class QuestionLink {
        public String linkType;
        public String url;

        public QuestionLink(String linkType, String url) {
            this.linkType = linkType;
            this.url = url;
        }
    }
}