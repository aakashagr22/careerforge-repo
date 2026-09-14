package com.careerforge.chatbot.service;

import com.careerforge.chatbot.dto.ChatbotResponse;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ChatbotKnowledgeBase {

    public Optional<ChatbotResponse> findAnswer(String question, String targetRole, String framework, Integer semester) {
        if (question == null) return Optional.empty();
        String q = question.toLowerCase().trim();

        // 1. Journey & Pacing Questions
        if (q.contains("journey") || q.contains("how to follow") || q.contains("start my") || q.contains("roadmap") || q.contains("path") || q.contains("semester")) {
            return Optional.of(buildJourneyResponse(targetRole, framework, semester));
        }

        // 2. DSA & Practice Sheets
        if (q.contains("dsa") || q.contains("sheet") || q.contains("striver") || q.contains("algorithm") || q.contains("data structure") || q.contains("leetcode")) {
            return Optional.of(buildDsaResponse());
        }

        // 3. Spring Boot Queries
        if (q.contains("spring boot") || q.contains("bean") || q.contains("component") || q.contains("autowired") || q.contains("rest controller") || q.contains("jpa")) {
            return Optional.of(buildSpringBootResponse(q));
        }

        // 4. React / Frontend Queries
        if (q.contains("react") || q.contains("useeffect") || q.contains("usestate") || q.contains("hooks") || q.contains("redux") || q.contains("tailwind")) {
            return Optional.of(buildReactResponse(q));
        }

        // 5. System Design & Interview Prep
        if (q.contains("system design") || q.contains("interview") || q.contains("placement") || q.contains("resume") || q.contains("mock")) {
            return Optional.of(buildSystemDesignResponse());
        }

        // 6. Study Resources in CareerForge
        if (q.contains("resource") || q.contains("notes") || q.contains("study material") || q.contains("book") || q.contains("download")) {
            return Optional.of(buildResourcesResponse());
        }

        return Optional.empty();
    }

    private ChatbotResponse buildJourneyResponse(String role, String framework, Integer semester) {
        String roleStr = (role != null && !role.isBlank()) ? role : "Software Development Engineer (SDE)";
        String fwStr = (framework != null && !framework.isBlank()) ? framework : "Spring Boot";
        int sem = (semester != null && semester > 0) ? semester : 1;

        String answer = String.format("""
                ### 🚀 Your Personalized %s (%s) Journey Guide
                
                You are currently mapped to **Semester %d**. Here is your optimal step-by-step path:
                
                1. **Foundations (Semester 1–2)**:
                   - Master Core Language (Java or Python/C++) including OOP principles, Collections, and Exception Handling.
                   - Cover Phase 1 DSA: Time & Space Complexity, Arrays, Strings, Two-Pointer patterns, and Recursion basics.
                
                2. **Core Specialization & Framework (Semester 3–4)**:
                   - **%s**: Build RESTful APIs, master Dependency Injection, Spring Data JPA/Hibernate, and PostgreSQL integration.
                   - **Intermediate DSA**: Stacks, Queues, Binary Trees, and Binary Search Trees. Aim for 2–3 problems daily.
                
                3. **Advanced Projects & System Architecture (Semester 5–6)**:
                   - Implement Security (JWT + Spring Security / OAuth2), Caching, and Asynchronous worker pools.
                   - Graphs (BFS, DFS, Dijkstra, TopoSort) and Dynamic Programming.
                   - Deploy your full-stack applications with Docker and CI/CD pipelines.
                
                💡 **Actionable Tip**: Keep your daily streak active in CareerForge's **My Journey** tab!
                """, roleStr, fwStr, sem, fwStr);

        return ChatbotResponse.builder()
                .answer(answer)
                .isOfflineKnowledge(true)
                .suggestedFollowUps(List.of(
                        "What should I study in my current semester?",
                        "How to balance DSA with full-stack projects?",
                        "Recommend practice sheets for SDE interviews"
                ))
                .relevantLinks(List.of(
                        ChatbotResponse.ChatbotResourceLinkDto.builder().title("My Journey").url("/student/journey").type("ROADMAP").build(),
                        ChatbotResponse.ChatbotResourceLinkDto.builder().title("Study Resources").url("/student/resources").type("RESOURCE").build()
                ))
                .build();
    }

    private ChatbotResponse buildDsaResponse() {
        String answer = """
                ### 💻 Structured DSA Preparation Strategy
                
                Follow the 5-stage progressive mastery model:
                
                1. **Phase 1: Basic Patterns (Weeks 1–4)**
                   - Arrays (Two-pointer, Sliding Window, Prefix Sum)
                   - Strings & Frequency Hashing
                   - Binary Search (search on answer pattern)
                
                2. **Phase 2: Linear Data Structures (Weeks 5–8)**
                   - Linked Lists (Reversal, Cycle Detection, Fast & Slow pointers)
                   - Stacks & Queues (Monotonic Stack, Infix/Postfix)
                
                3. **Phase 3: Hierarchical & Non-Linear (Weeks 9–14)**
                   - Binary Trees & BSTs (Traversals, LCA, Diameter, Max Path Sum)
                   - Heaps & Priority Queues (Top K elements)
                
                4. **Phase 4: Graphs & Complex Problem Solving (Weeks 15–20)**
                   - BFS, DFS, Cycle Detection, Topological Sort
                   - Shortest Path: Dijkstra & Bellman-Ford
                   - Disjoint Set Union (DSU) & Minimum Spanning Tree
                
                5. **Phase 5: Dynamic Programming (Weeks 21–26)**
                   - 1D DP $\\rightarrow$ 2D Grid DP $\\rightarrow$ DP on Subsequences $\\rightarrow$ DP on Stocks.
                
                🔥 **Pro-Tip**: Solve problems topic-wise rather than randomly to develop pattern recognition.
                """;

        return ChatbotResponse.builder()
                .answer(answer)
                .isOfflineKnowledge(true)
                .suggestedFollowUps(List.of(
                        "Explain Monotonic Stack with an example",
                        "How to identify Dynamic Programming problems?",
                        "What are top 20 graph interview questions?"
                ))
                .relevantLinks(List.of(
                        ChatbotResponse.ChatbotResourceLinkDto.builder().title("Practice Sheets").url("/student/sheets").type("SHEET").build(),
                        ChatbotResponse.ChatbotResourceLinkDto.builder().title("Coding Contests").url("https://kernel-sable.vercel.app/signin").type("EXTERNAL").build()
                ))
                .build();
    }

    private ChatbotResponse buildSpringBootResponse(String query) {
        String answer = """
                ### 🍃 Spring Boot Architecture & Best Practices
                
                Key Concepts for Enterprise Development:
                
                - **`@Component` vs `@Bean`**:
                  - `@Component` is a class-level annotation for auto-detection via component scanning.
                  - `@Bean` is a method-level annotation used inside `@Configuration` classes when you need explicit instantiation logic or third-party library configuration.
                
                - **Stateless Authentication**:
                  - Always pair **Spring Security 6** filters with **JWT**.
                  - Store tokens with expiration and validate claims in a `OncePerRequestFilter`.
                
                - **Performance & Async Processing**:
                  - Annotate your main class with `@EnableAsync` and service methods with `@Async` for non-blocking tasks like email delivery and report generation.
                  - Enforce connection pooling (HikariCP) and indexed foreign keys in PostgreSQL.
                """;

        return ChatbotResponse.builder()
                .answer(answer)
                .isOfflineKnowledge(true)
                .suggestedFollowUps(List.of(
                        "How does Spring Security filter chain work?",
                        "Difference between JPA, Hibernate, and Spring Data JPA",
                        "How to implement global exception handling with @RestControllerAdvice"
                ))
                .relevantLinks(List.of(
                        ChatbotResponse.ChatbotResourceLinkDto.builder().title("Study Resources").url("/student/resources").type("RESOURCE").build()
                ))
                .build();
    }

    private ChatbotResponse buildReactResponse(String query) {
        String answer = """
                ### ⚛️ Modern React & TypeScript Patterns
                
                - **Hooks Rule of Thumb**:
                  - `useState`: For local component UI state.
                  - `useEffect`: For synchronization with external systems (APIs, subscriptions). Avoid using it to sync derived state!
                  - `useMemo` / `useCallback`: Profile before optimizing; use them when passing callbacks to memoized children.
                
                - **Server State Management**:
                  - Use **TanStack Query (React Query)** instead of manual `useEffect` + `useState` for API calls. It gives automatic caching, deduplication, and background refetching out of the box.
                
                - **Type Safety**:
                  - Always type API request payloads and responses with TypeScript interfaces to eliminate runtime `undefined` errors.
                """;

        return ChatbotResponse.builder()
                .answer(answer)
                .isOfflineKnowledge(true)
                .suggestedFollowUps(List.of(
                        "Why use TanStack Query over Redux for server state?",
                        "How to structure React components cleanly?",
                        "Best practices for Tailwind CSS design systems"
                ))
                .build();
    }

    private ChatbotResponse buildSystemDesignResponse() {
        String answer = """
                ### 🏗️ System Design Interview Primer
                
                Follow the 4-step interview framework:
                
                1. **Scope & Requirements (5 mins)**:
                   - Functional (e.g. post message, read feed) & Non-functional (availability, latency, scale).
                   - Back-of-the-envelope calculations (DAU, QPS, Storage per year).
                
                2. **High-Level Architecture (10–15 mins)**:
                   - API Gateway / Load Balancers $\\rightarrow$ Microservices $\\rightarrow$ Primary/Replica Databases.
                   - Cache layer (Redis) to reduce read load on databases.
                
                3. **Deep Dive into Key Components (15 mins)**:
                   - Real-time pub/sub: WebSockets vs Long Polling vs Server-Sent Events (SSE).
                   - Database selection: SQL (ACID) vs NoSQL (horizontal partition/high write throughput).
                
                4. **Bottlenecks & Resilience (5 mins)**:
                   - Rate limiting, Circuit Breakers (Resilience4j), and database sharding.
                """;

        return ChatbotResponse.builder()
                .answer(answer)
                .isOfflineKnowledge(true)
                .suggestedFollowUps(List.of(
                        "Explain Redis caching strategies (Cache-Aside vs Write-Through)",
                        "SQL vs NoSQL: How to choose for your project?",
                        "How to scale WebSockets across multiple server instances?"
                ))
                .relevantLinks(List.of(
                        ChatbotResponse.ChatbotResourceLinkDto.builder().title("Q&A Community").url("/student/community").type("RESOURCE").build()
                ))
                .build();
    }

    private ChatbotResponse buildResourcesResponse() {
        String answer = """
                ### 📚 CareerForge Study Resources Library
                
                You have access to organized folders in the **Study Resources** section:
                
                - **Data Structures & Algorithms**: Comprehensive notes, cheat sheets, and pattern summaries.
                - **Full-Stack Development**: Spring Boot, React, Node.js, and database interview guides.
                - **Core CS Subjects**: Operating Systems, Computer Networks, DBMS, and Object-Oriented Design.
                - **Aptitude & Interview Experiences**: Placement blogs written by seniors and placed alumni.
                
                Head over to the sidebar and click **Study Resources** to download or read them directly!
                """;

        return ChatbotResponse.builder()
                .answer(answer)
                .isOfflineKnowledge(true)
                .suggestedFollowUps(List.of(
                        "Where can I find placement interview experiences?",
                        "What is the best way to revise Operating Systems for campus drives?"
                ))
                .relevantLinks(List.of(
                        ChatbotResponse.ChatbotResourceLinkDto.builder().title("Browse Resources").url("/student/resources").type("RESOURCE").build(),
                        ChatbotResponse.ChatbotResourceLinkDto.builder().title("Placement Blogs").url("/student/blogs").type("RESOURCE").build()
                ))
                .build();
    }
}
