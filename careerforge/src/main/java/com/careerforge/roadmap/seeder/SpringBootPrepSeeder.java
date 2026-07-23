package com.careerforge.roadmap.seeder;

import java.util.ArrayList;
import java.util.List;

public class SpringBootPrepSeeder {

    // ─── Spring Boot Video Links ─────────────────────────────────────────────────
// Channels: Telusko (Navin Reddy), Amigoscode, Bouali Ali, Daily Code Buffer, Java Guides

// CORE SPRING BOOT
static final String sb_intro           = "https://www.youtube.com/watch?v=35EQXmHKZYs";
// ▲ Telusko – Spring Boot Tutorials | Full Course

static final String sb_ioc_di          = "https://www.youtube.com/watch?v=5cRaQqQb14Q";
// ▲ Telusko – #4 IoC and DI in Spring (Spring 6 series)

static final String sb_autowired       = "https://www.youtube.com/watch?v=9EoAXpjnsxM";
// ▲ Telusko – #6 Dependency Injection using Spring Boot

static final String sb_web_rest        = "https://www.youtube.com/watch?v=vlz9ina4Usk";
// ▲ Telusko – Spring Boot Project for Beginners (REST API, 2023)

static final String sb_jpa_h2          = "https://www.youtube.com/watch?v=YywLS8XdxLQ";
// ▲ Telusko – Spring Boot | JPA | MVC | H2 Example

// DATA / QUERIES
static final String sb_jpa_queries     = "https://www.youtube.com/watch?v=zL33FwIyZW0";
// ▲ Java Guides – Spring Data JPA @Query | JPQL | Native SQL | Named & Index Parameters

// SECURITY
static final String sb_security_intro  = "https://www.youtube.com/watch?v=IqW6NVxPaTc";
// ▲ Amigoscode – Spring Security 7 Crash Course [2026]

static final String sb_security_jwt    = "https://www.youtube.com/watch?v=KxqlJblhzfI";
// ▲ Bouali Ali – Spring Boot 3 + Spring Security 6 – JWT Auth & Authorisation [2023]

// ADVANCED TOPICS
static final String sb_aop_logging     = "https://www.youtube.com/watch?v=xdl1b97GANk";
// ▲ Java Guides – Aspect Oriented Programming (AOP) with Spring Tutorial

static final String sb_caching_redis   = "https://www.youtube.com/watch?v=j65P_-yOX8g";
// ▲ Daily Code Buffer – Spring Boot Caching Tutorial using Redis (2025)

static final String sb_actuator        = "https://www.youtube.com/watch?v=CCMAhpVvpyk";
// ▲ Spring Boot Actuator Full Tutorial (2024)

static final String sb_testing_unit    = "https://www.youtube.com/watch?v=id_esCeLZBo";
// ▲ Master Unit Testing in Spring Boot | JUnit, Mockito | Step-by-Step (2024)

// MESSAGING / MICROSERVICES
static final String sb_kafka_messaging = "https://www.youtube.com/watch?v=leTEw4KOBjw";
// ▲ Kafka with Spring Boot 3: Producer & Consumer (2023)

static final String sb_eureka_discovery= "https://www.youtube.com/watch?v=Sw8c7Baqn5Q";
// ▲ Spring Boot Microservice – Eureka Server | Service Discovery (2024)

static final String sb_gateway_cloud   = "https://www.youtube.com/watch?v=EKoq98KqvrI";
// ▲ Building an API Gateway with Spring Cloud Gateway (2023)

static final String sb_docker_deploy   = "https://www.youtube.com/watch?v=1aWhYEynZQw";
// ▲ Amigoscode – Java & Spring Boot Microservices | Docker + Kubernetes | 10 Hour Course

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
        addQ(t, "Java 8 Streams API", "EASY", 
            "ARTICLE", "https://www.baeldung.com/java-8-streams", 
            "VIDEO", sb_intro);
        addQ(t, "Lambda Expressions and Functional Interfaces", "EASY", 
            "ARTICLE", "https://www.baeldung.com/java-8-functional-interfaces", 
            "VIDEO", sb_intro);
        addQ(t, "Optional Class in Java", "EASY", 
            "ARTICLE", "https://www.baeldung.com/java-optional", 
            "VIDEO", sb_intro);
        addQ(t, "Java Records for DTOs", "EASY", 
            "ARTICLE", "https://www.baeldung.com/java-record-keyword", 
            "VIDEO", sb_intro);

        t = createTopic(s, "Build Tools - Maven and Gradle");
        addQ(t, "Maven POM and Dependency Management", "EASY", 
            "ARTICLE", "https://www.baeldung.com/maven-dependency-management", 
            "VIDEO", sb_intro);
        addQ(t, "Maven Build Lifecycle", "EASY", 
            "ARTICLE", "https://www.baeldung.com/maven-build-lifecycle", 
            "VIDEO", sb_intro);
        addQ(t, "Gradle Basics for Spring Boot Projects", "EASY", 
            "ARTICLE", "https://www.baeldung.com/gradle", 
            "VIDEO", sb_intro);
        addQ(t, "Maven vs Gradle for Spring Projects", "EASY", 
            "ARTICLE", "https://www.baeldung.com/maven-vs-gradle", 
            "VIDEO", sb_intro);


        // ==========================================
        // Section 2: Introduction to Spring and Spring Boot
        // ==========================================
        s = createSection("Introduction to Spring and Spring Boot");

        t = createTopic(s, "Spring Framework Fundamentals");
        addQ(t, "Spring Framework Introduction", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-intro", 
            "VIDEO", sb_intro);
        addQ(t, "Spring vs Spring Boot", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-vs-spring-boot", 
            "VIDEO", sb_intro);
        addQ(t, "Spring Application Context", "EASY", 
            "ARTICLE", "https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring", 
            "VIDEO", sb_ioc_di);
        addQ(t, "Spring Bean Lifecycle", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-bean-lifecycle", 
            "VIDEO", sb_ioc_di);

        t = createTopic(s, "Getting Started with Spring Boot");
        addQ(t, "Bootstrap a Simple Spring Boot Application", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-boot-start", 
            "VIDEO", sb_intro);
        addQ(t, "Spring Initializr and Starters", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-boot-starters", 
            "VIDEO", sb_intro);
        addQ(t, "Spring Boot Auto-Configuration", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-boot-auto-configuration", 
            "VIDEO", sb_ioc_di);
        addQ(t, "Common Spring Boot Annotations Overview", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-boot-annotations", 
            "VIDEO", sb_web_rest);
        addQ(t, "Building a Simple REST Controller", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-controller-vs-restcontroller", 
            "VIDEO", sb_web_rest);


        // ==========================================
        // Section 3: Dependency Injection and IoC
        // ==========================================
        s = createSection("Dependency Injection and IoC");

        t = createTopic(s, "IoC Container Concepts");
        addQ(t, "Inversion of Control and Dependency Injection", "EASY", 
            "ARTICLE", "https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring", 
            "VIDEO", sb_ioc_di);
        addQ(t, "Spring Bean Scopes", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-bean-scopes", 
            "VIDEO", sb_ioc_di);
        addQ(t, "Component Scanning and Stereotype Annotations", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-component-scanning", 
            "VIDEO", sb_autowired);
        addQ(t, "Java Config vs XML Config", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-xml-injection", 
            "VIDEO", sb_ioc_di);

        t = createTopic(s, "Dependency Injection Techniques");
        addQ(t, "Constructor-Based Dependency Injection", "EASY", 
            "ARTICLE", "https://www.baeldung.com/constructor-injection-in-spring", 
            "VIDEO", sb_autowired);
        addQ(t, "Setter-Based Dependency Injection", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-setter-di", 
            "VIDEO", sb_autowired);
        addQ(t, "Field Injection with @Autowired", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-autowire", 
            "VIDEO", sb_autowired);
        addQ(t, "@Qualifier and Primary Beans", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-qualifier-annotation", 
            "VIDEO", sb_autowired);
        addQ(t, "Injecting Java Collections in Spring", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-injecting-collections", 
            "VIDEO", sb_autowired);


        // ==========================================
        // Section 4: Spring Boot Configuration
        // ==========================================
        s = createSection("Spring Boot Configuration");

        t = createTopic(s, "Externalized Configuration");
        addQ(t, "application.properties vs application.yml", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-boot-yaml-vs-properties", 
            "VIDEO", sb_intro);
        addQ(t, "@ConfigurationProperties Deep Dive", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/configuration-properties-in-spring-boot", 
            "VIDEO", sb_intro);
        addQ(t, "Spring Profiles for Environments", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-profiles", 
            "VIDEO", sb_intro);
        addQ(t, "Property Placeholders and @Value", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-value-annotation", 
            "VIDEO", sb_autowired);
        addQ(t, "Conditional Beans (@ConditionalOnProperty)", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-conditional-annotations", 
            "VIDEO", sb_ioc_di);


        // ==========================================
        // Section 5: Building REST APIs
        // ==========================================
        s = createSection("Building REST APIs");

        t = createTopic(s, "Controllers and Request Mapping");
        addQ(t, "@RestController and @RequestMapping", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-requestmapping", 
            "VIDEO", sb_web_rest);
        addQ(t, "Path Variables and Request Parameters", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-requestparam-vs-pathvariable", 
            "VIDEO", sb_web_rest);
        addQ(t, "Request Body and ResponseEntity", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-response-entity", 
            "VIDEO", sb_web_rest);
        addQ(t, "HTTP Methods in Spring MVC (@GetMapping, @PostMapping, @PutMapping, @DeleteMapping)", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-new-request-mappings", 
            "VIDEO", sb_web_rest);
        addQ(t, "Content Negotiation in Spring MVC", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-mvc-content-negotiation-json-xml", 
            "VIDEO", sb_web_rest);

        t = createTopic(s, "REST API Design Best Practices");
        addQ(t, "REST API Error Handling Best Practices", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/rest-api-error-handling-best-practices", 
            "VIDEO", sb_web_rest);
        addQ(t, "Pagination in REST APIs", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/rest-api-pagination-in-spring", 
            "VIDEO", sb_jpa_queries);
        addQ(t, "Versioning REST APIs", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/rest-versioning", 
            "VIDEO", sb_web_rest);
        addQ(t, "Documenting REST APIs with OpenAPI 3.0 (Swagger)", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-rest-openapi-documentation", 
            "VIDEO", sb_web_rest);


        // ==========================================
        // Section 6: Validation and Exception Handling
        // ==========================================
        s = createSection("Validation and Exception Handling");

        t = createTopic(s, "Bean Validation");
        addQ(t, "Validation in Spring Boot", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-boot-bean-validation", 
            "VIDEO", sb_web_rest);
        addQ(t, "Bean Validation Annotations (@NotNull, @Size, @Pattern)", "EASY", 
            "ARTICLE", "https://www.baeldung.com/javax-validation", 
            "VIDEO", sb_web_rest);
        addQ(t, "Custom Validation Annotations", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-mvc-custom-validator", 
            "VIDEO", sb_web_rest);
        addQ(t, "Validating Path Variables and Request Params", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-validate-requestparam-pathvariable", 
            "VIDEO", sb_web_rest);

        t = createTopic(s, "Exception Handling");
        addQ(t, "Error Handling for REST with Spring", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/exception-handling-for-rest-with-spring", 
            "VIDEO", sb_web_rest);
        addQ(t, "Global Exception Handler with @ControllerAdvice", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/global-error-handler-in-a-spring-rest-api", 
            "VIDEO", sb_web_rest);
        addQ(t, "Custom Error Response Structures", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/global-error-handler-in-a-spring-rest-api", 
            "VIDEO", sb_web_rest);
        addQ(t, "@ResponseStatus and ProblemDetail (Spring 6)", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-6-problemdetail", 
            "VIDEO", sb_web_rest);


        // ==========================================
        // Section 7: Spring Data JPA and Persistence
        // ==========================================
        s = createSection("Spring Data JPA and Persistence");

        t = createTopic(s, "JPA Fundamentals");
        addQ(t, "Introduction to Spring Data JPA", "EASY", 
            "ARTICLE", "https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa", 
            "VIDEO", sb_jpa_h2);
        addQ(t, "JPA Entity Mapping Basics (@Entity, @Table, @Id, @GeneratedValue)", "EASY", 
            "ARTICLE", "https://www.baeldung.com/jpa-entities", 
            "VIDEO", sb_jpa_h2);
        addQ(t, "CrudRepository vs JpaRepository", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-data-repositories", 
            "VIDEO", sb_jpa_h2);
        addQ(t, "Spring Data Repository Hierarchy", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-data-repositories", 
            "VIDEO", sb_jpa_queries);

        t = createTopic(s, "Query Methods");
        addQ(t, "Derived Query Methods in Spring Data JPA", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-data-derived-queries", 
            "VIDEO", sb_jpa_queries);
        addQ(t, "@Query Annotation with JPQL and Native SQL", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-data-jpa-query", 
            "VIDEO", sb_jpa_queries);
        addQ(t, "LIKE Queries in Spring JPA Repositories", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-jpa-like-queries", 
            "VIDEO", sb_jpa_queries);
        addQ(t, "Query by Example", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-data-query-by-example", 
            "VIDEO", sb_jpa_queries);
        addQ(t, "Dynamic Queries with Specifications", "HARD", 
            "ARTICLE", "https://www.baeldung.com/spring-data-jpa-query-arbitrary-and-clauses", 
            "VIDEO", sb_jpa_queries);

        t = createTopic(s, "Advanced JPA");
        addQ(t, "Entity Relationships (@OneToMany, @ManyToOne, @ManyToMany)", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/jpa-one-to-many", 
            "VIDEO", sb_jpa_queries);
        addQ(t, "Pagination and Sorting with Spring Data", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-data-jpa-pagination-sorting", 
            "VIDEO", sb_jpa_queries);
        addQ(t, "Spring Data JPA Repository for Database Views", "HARD", 
            "ARTICLE", "https://www.baeldung.com/spring-data-jpa-repository-view", 
            "VIDEO", sb_jpa_queries);
        addQ(t, "Criteria API Queries", "HARD", 
            "ARTICLE", "https://www.baeldung.com/spring-data-criteria-queries", 
            "VIDEO", sb_jpa_queries);


        // ==========================================
        // Section 8: Transactions and Database Management
        // ==========================================
        s = createSection("Transactions and Database Management");

        t = createTopic(s, "Transaction Management");
        addQ(t, "Transactions with Spring and JPA (@Transactional)", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/transaction-configuration-with-jpa-and-spring", 
            "VIDEO", sb_jpa_h2);
        addQ(t, "Programmatic Transaction Management", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-programmatic-transaction-management", 
            "VIDEO", sb_jpa_h2);
        addQ(t, "Transaction Propagation and Isolation Levels", "HARD", 
            "ARTICLE", "https://www.baeldung.com/spring-transactional-propagation-isolation", 
            "VIDEO", sb_jpa_h2);

        t = createTopic(s, "Database Migration and Test Data");
        addQ(t, "Flyway with Spring Boot", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/database-migrations-with-flyway", 
            "VIDEO", sb_jpa_h2);
        addQ(t, "Liquibase with Spring Boot", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/liquibase-refactor-schema-of-java-app", 
            "VIDEO", sb_jpa_h2);
        addQ(t, "H2 In-Memory Database for Testing", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-boot-h2-database", 
            "VIDEO", sb_jpa_h2);


        // ==========================================
        // Section 9: Spring Security Fundamentals
        // ==========================================
        s = createSection("Spring Security Fundamentals");

        t = createTopic(s, "Authentication and Authorization");
        addQ(t, "Spring Security 6 Introduction", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-security-5-default-password-encoder", 
            "VIDEO", sb_security_intro);
        addQ(t, "SecurityFilterChain Configuration", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-security-custom-filter", 
            "VIDEO", sb_security_intro);
        addQ(t, "In-Memory and JDBC Authentication", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-security-authentication-with-a-database", 
            "VIDEO", sb_security_intro);
        addQ(t, "Password Encoding with BCrypt", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-security-registration-password-encoding-bcrypt", 
            "VIDEO", sb_security_intro);
        addQ(t, "Method-Level Security (@PreAuthorize, @PostAuthorize)", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-security-method-security", 
            "VIDEO", sb_security_intro);

        t = createTopic(s, "Securing REST APIs");
        addQ(t, "Spring Security for Spring Boot Integration Tests", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-security-integration-tests", 
            "VIDEO", sb_security_intro);
        addQ(t, "Configuring Security to Allow Swagger UI", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/java-spring-security-permit-swagger-ui", 
            "VIDEO", sb_security_intro);
        addQ(t, "CORS Configuration in Spring Security", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-cors", 
            "VIDEO", sb_security_intro);


        // ==========================================
        // Section 10: Spring Security with JWT and OAuth2
        // ==========================================
        s = createSection("Spring Security with JWT and OAuth2");

        t = createTopic(s, "JWT Authentication");
        addQ(t, "Creating a Signing Key for a JWT Token", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-security-sign-jwt-token", 
            "VIDEO", sb_security_jwt);
        addQ(t, "Mapping Authorities from JWT Claims", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-security-map-authorities-jwt", 
            "VIDEO", sb_security_jwt);
        addQ(t, "Building a JWT Authentication Filter", "HARD", 
            "ARTICLE", "https://www.baeldung.com/spring-security-sign-jwt-token", 
            "VIDEO", sb_security_jwt);
        addQ(t, "Access Tokens and Refresh Tokens", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-security-oauth-jwt", 
            "VIDEO", sb_security_jwt);

        t = createTopic(s, "OAuth2");
        addQ(t, "Using JWT with Spring Security OAuth2", "HARD", 
            "ARTICLE", "https://www.baeldung.com/spring-security-oauth-jwt", 
            "VIDEO", sb_security_jwt);
        addQ(t, "Tokens, OAuth2 and JWT Overview", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-security-oauth-jwt", 
            "VIDEO", sb_security_jwt);
        addQ(t, "Setting up an OAuth2 Authorization Server", "HARD", 
            "ARTICLE", "https://www.baeldung.com/spring-security-oauth-auth-server", 
            "VIDEO", sb_security_jwt);
        addQ(t, "Resource Server Configuration", "HARD", 
            "ARTICLE", "https://www.baeldung.com/spring-security-oauth-resource-server", 
            "VIDEO", sb_security_jwt);


        // ==========================================
        // Section 11: Caching, AOP and Cross-Cutting Concerns
        // ==========================================
        s = createSection("Caching, AOP and Cross-Cutting Concerns");

        t = createTopic(s, "Aspect-Oriented Programming");
        addQ(t, "Introduction to AOP in Spring", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-aop", 
            "VIDEO", sb_aop_logging);
        addQ(t, "Advice Types in Spring (@Before, @After, @Around)", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-aop-advice-tutorial", 
            "VIDEO", sb_aop_logging);
        addQ(t, "Logging with AOP in Spring", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-aspect-oriented-programming-logging", 
            "VIDEO", sb_aop_logging);

        t = createTopic(s, "Caching");
        addQ(t, "A Guide to Caching in Spring", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-cache-tutorial", 
            "VIDEO", sb_caching_redis);
        addQ(t, "@Cacheable, @CachePut and @CacheEvict", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-cache-tutorial", 
            "VIDEO", sb_caching_redis);
        addQ(t, "Configuring Cache Providers (Redis, Ehcache)", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-boot-redis-cache", 
            "VIDEO", sb_caching_redis);

        t = createTopic(s, "Scheduling and Async Processing");
        addQ(t, "Spring Scheduling Annotations Overview", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-scheduling-annotations", 
            "VIDEO", sb_aop_logging);
        addQ(t, "The @Scheduled Annotation Deep Dive", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-scheduled-tasks", 
            "VIDEO", sb_aop_logging);
        addQ(t, "A Guide to the Spring Task Scheduler", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-task-scheduler", 
            "VIDEO", sb_aop_logging);
        addQ(t, "How To Do @Async in Spring", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-async", 
            "VIDEO", sb_aop_logging);
        addQ(t, "Conditionally Enable Scheduled Jobs", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-scheduled-enabled-conditionally", 
            "VIDEO", sb_aop_logging);


        // ==========================================
        // Section 12: Testing in Spring Boot
        // ==========================================
        s = createSection("Testing in Spring Boot");

        t = createTopic(s, "Unit Testing");
        addQ(t, "Testing in Spring Boot Overview", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-boot-testing", 
            "VIDEO", sb_testing_unit);
        addQ(t, "Mockito for Unit Testing Services", "EASY", 
            "ARTICLE", "https://www.baeldung.com/mockito-series", 
            "VIDEO", sb_testing_unit);
        addQ(t, "Testing the Service Layer with @MockBean", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/java-spring-mockito-mock-mockbean", 
            "VIDEO", sb_testing_unit);

        t = createTopic(s, "Integration Testing");
        addQ(t, "MockMvc With @SpringBootTest vs @WebMvcTest", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-mockmvc-vs-webmvctest", 
            "VIDEO", sb_testing_unit);
        addQ(t, "Integration Testing in Spring", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/integration-testing-in-spring", 
            "VIDEO", sb_testing_unit);
        addQ(t, "Spring Security in Integration Tests", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-security-integration-tests", 
            "VIDEO", sb_testing_unit);
        addQ(t, "Disabling @EnableScheduling in Tests", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-test-disable-enablescheduling", 
            "VIDEO", sb_testing_unit);
        addQ(t, "@DataJpaTest for Repository Testing", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-boot-testing", 
            "VIDEO", sb_testing_unit);

        t = createTopic(s, "Testcontainers");
        addQ(t, "Testing Kafka and Spring Boot with Testcontainers", "HARD", 
            "ARTICLE", "https://www.baeldung.com/spring-boot-kafka-testing", 
            "VIDEO", sb_testing_unit);
        addQ(t, "Testcontainers for Database Integration Tests", "HARD", 
            "ARTICLE", "https://www.baeldung.com/docker-test-containers", 
            "VIDEO", sb_testing_unit);


        // ==========================================
        // Section 13: Observability and Production Readiness
        // ==========================================
        s = createSection("Observability and Production Readiness");

        t = createTopic(s, "Spring Boot Actuator");
        addQ(t, "Spring Boot Actuator Overview", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-boot-actuators", 
            "VIDEO", sb_actuator);
        addQ(t, "Custom Actuator Endpoints", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-boot-actuators", 
            "VIDEO", sb_actuator);
        addQ(t, "Health Indicators and Metrics", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-boot-actuators", 
            "VIDEO", sb_actuator);

        t = createTopic(s, "Logging");
        addQ(t, "Logging in Spring Boot", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-boot-logging", 
            "VIDEO", sb_aop_logging);
        addQ(t, "Logback Configuration in Spring Boot", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/logback", 
            "VIDEO", sb_aop_logging);
        addQ(t, "Structured Logging Best Practices", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-boot-logging", 
            "VIDEO", sb_aop_logging);

        t = createTopic(s, "API Documentation");
        addQ(t, "Documenting a Spring REST API with OpenAPI 3.0", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-rest-openapi-documentation", 
            "VIDEO", sb_web_rest);
        addQ(t, "Turning Off Swagger UI in Production", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/swagger-ui-turn-off-in-production", 
            "VIDEO", sb_web_rest);
        addQ(t, "Securing Swagger UI with Spring Security", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/java-spring-security-permit-swagger-ui", 
            "VIDEO", sb_security_intro);


        // ==========================================
        // Section 14: Messaging with Kafka and RabbitMQ
        // ==========================================
        s = createSection("Messaging with Kafka and RabbitMQ");

        t = createTopic(s, "Apache Kafka Fundamentals");
        addQ(t, "Introduction to Apache Kafka", "EASY", 
            "ARTICLE", "https://www.baeldung.com/apache-kafka", 
            "VIDEO", sb_kafka_messaging);
        addQ(t, "Intro to Apache Kafka with Spring", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-kafka", 
            "VIDEO", sb_kafka_messaging);
        addQ(t, "Kafka Producers and Consumers with KafkaTemplate", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-kafka", 
            "VIDEO", sb_kafka_messaging);
        addQ(t, "Consuming Messages in Batch with @KafkaListener", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/kafka-kafkalistener-annotation-handle-messages-batch", 
            "VIDEO", sb_kafka_messaging);

        t = createTopic(s, "Kafka Advanced");
        addQ(t, "Kafka Streams with Spring Boot", "HARD", 
            "ARTICLE", "https://www.baeldung.com/spring-boot-kafka-streams", 
            "VIDEO", sb_kafka_messaging);
        addQ(t, "Testing Kafka and Spring Boot", "HARD", 
            "ARTICLE", "https://www.baeldung.com/spring-boot-kafka-testing", 
            "VIDEO", sb_kafka_messaging);
        addQ(t, "Spring Cloud Stream with Kafka and Avro", "HARD", 
            "ARTICLE", "https://www.baeldung.com/spring-cloud-stream-kafka-avro-confluent", 
            "VIDEO", sb_kafka_messaging);

        t = createTopic(s, "RabbitMQ Messaging");
        addQ(t, "RabbitMQ with Spring Boot Basics", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-amqp-with-rabbitmq", 
            "VIDEO", sb_kafka_messaging);
        addQ(t, "Spring AMQP Producers and Consumers", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-amqp-with-rabbitmq", 
            "VIDEO", sb_kafka_messaging);


        // ==========================================
        // Section 15: Microservices with Spring Cloud
        // ==========================================
        s = createSection("Microservices with Spring Cloud");

        t = createTopic(s, "Service Discovery");
        addQ(t, "Introduction to Spring Cloud Netflix Eureka", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-cloud-netflix-eureka", 
            "VIDEO", sb_eureka_discovery);
        addQ(t, "Spring Cloud Netflix Ribbon Load Balancing", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-cloud-rest-client-with-netflix-ribbon", 
            "VIDEO", sb_eureka_discovery);
        addQ(t, "Service Registration and Discovery Patterns", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-cloud-netflix-eureka", 
            "VIDEO", sb_eureka_discovery);

        t = createTopic(s, "API Gateway and Configuration");
        addQ(t, "Spring Cloud Gateway Basics", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-cloud-gateway", 
            "VIDEO", sb_gateway_cloud);
        addQ(t, "Building Microservices with Spring Cloud (Bootstrapping)", "HARD", 
            "ARTICLE", "https://www.baeldung.com/spring-cloud-bootstrapping", 
            "VIDEO", sb_gateway_cloud);
        addQ(t, "Quick Intro to Spring Cloud Configuration", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-cloud-configuration", 
            "VIDEO", sb_gateway_cloud);
        addQ(t, "Spring Cloud Config Without Git", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-cloud-config-without-git", 
            "VIDEO", sb_gateway_cloud);
        addQ(t, "Spring Cloud Bus for Config Refresh", "HARD", 
            "ARTICLE", "https://www.baeldung.com/spring-cloud-bus", 
            "VIDEO", sb_gateway_cloud);

        t = createTopic(s, "Resilience Patterns");
        addQ(t, "Quick Guide to Spring Cloud Circuit Breaker", "HARD", 
            "ARTICLE", "https://www.baeldung.com/spring-cloud-circuit-breaker", 
            "VIDEO", sb_gateway_cloud);
        addQ(t, "Resilience4j Circuit Breaker with Spring Cloud Gateway", "HARD", 
            "ARTICLE", "https://www.baeldung.com/resilience4j-backoff-jitter", 
            "VIDEO", sb_gateway_cloud);
        addQ(t, "Retry, Rate Limiter and Bulkhead Patterns", "HARD", 
            "ARTICLE", "https://www.baeldung.com/resilience4j-spring-boot", 
            "VIDEO", sb_gateway_cloud);


        // ==========================================
        // Section 16: Containerization and Deployment
        // ==========================================
        s = createSection("Containerization and Deployment");

        t = createTopic(s, "Docker with Spring Boot");
        addQ(t, "Dockerizing a Spring Boot Application", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/dockerizing-spring-boot-application", 
            "VIDEO", sb_docker_deploy);
        addQ(t, "Spring Boot Docker Layered Images", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/dockerizing-spring-boot-application", 
            "VIDEO", sb_docker_deploy);
        addQ(t, "Starting Spring Boot in Docker with a Profile", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-boot-docker-start-with-profile", 
            "VIDEO", sb_docker_deploy);
        addQ(t, "Docker Compose Support in Spring Boot", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/docker-compose-support-spring-boot", 
            "VIDEO", sb_docker_deploy);

        t = createTopic(s, "Deployment Practices");
        addQ(t, "Building Executable JARs with Spring Boot", "EASY", 
            "ARTICLE", "https://www.baeldung.com/spring-boot-start", 
            "VIDEO", sb_docker_deploy);
        addQ(t, "Externalized Configuration for Production", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/spring-boot-yaml-vs-properties", 
            "VIDEO", sb_docker_deploy);
        addQ(t, "CI/CD Basics for Spring Boot Applications", "MEDIUM", 
            "ARTICLE", "https://www.baeldung.com/ops/github-actions-java", 
            "VIDEO", sb_docker_deploy);


        // ==========================================
        // Execute Database Save Operations
        // ==========================================

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

        List<com.careerforge.roadmap.entity.QuestionLink> dbLinksToSave = new ArrayList<>();
        List<com.careerforge.roadmap.entity.RoadmapSectionQuestion> dbRSQsToSave = new ArrayList<>();
        int questionPos = 0;
        
        for (int i = 0; i < savedQuestions.size(); i++) {
            com.careerforge.roadmap.entity.Question dbQ = savedQuestions.get(i);
            Question q = originalQuestions.get(i);
            com.careerforge.roadmap.entity.RoadmapSection dbTopic = dbTopicForQuestions.get(i);

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
                
        System.out.println("Spring Boot Roadmap Seeding completed successfully.");
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

        boolean hasVideo = false;
        boolean hasArticle = false;

        for (int i = 0; i < links.length; i += 2) {
            String type = links[i];
            String url = links[i + 1];
            if ("VIDEO".equals(type)) {
                if (!hasVideo) {
                    q.addLink(new QuestionLink(type, url));
                    hasVideo = true;
                }
            } else if ("ARTICLE".equals(type)) {
                if (!hasArticle) {
                    q.addLink(new QuestionLink(type, url));
                    hasArticle = true;
                }
            } else {
                q.addLink(new QuestionLink(type, url));
            }
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