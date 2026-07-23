// Journey configuration for CareerForge
// Each unique (role × framework × startingSemester) combination has a distinct
// compressed timeline with different pacing.

export interface JourneyTrack {
  name: string;
  roadmapId?: string;
  icon: 'code' | 'brain' | 'layout' | 'database' | 'server' | 'terminal' | 'book' | 'chart';
  progressHint?: string;
}

export interface JourneyMilestone {
  semester: number;
  title: string;
  description: string;
  monthsHint: string;
  tracks: JourneyTrack[];
}

export interface JourneyConfig {
  title: string;
  milestones: JourneyMilestone[];
}

const ROADMAP_IDS = {
  DSA: '678147d4-7a2b-4881-aeea-b7b93bbd6620',
  SPRING_BOOT: '26841a73-9c79-4100-8524-9d7db22a0e4d',
  FRONTEND: 'fbd6a424-8f9d-48c5-af3c-00a61026937b',
  MERN: 'b6a9bc46-c137-441b-b3d2-694146302cd3',
  FASTAPI: 'eab547d3-2704-4733-8959-5189537f2152',
  AIML: 'c4b75718-e191-4a66-940b-eeb592a075dd',
  DATA_SCIENTIST: '62f180b5-f911-42f0-a367-a1499e4ac6cb',
  JAVA_BASICS: '60f64d45-7322-4c1e-baf7-6d8c2fae00f7',
  PYTHON_BASICS: 'b6349935-7253-4230-8586-f61b165b330f',
  CPP_BASICS: '783dc68d-121c-433b-9d69-4ad27f3c192e',
  CP_SHEET: '52ffd647-9436-4ae4-95c8-76c233758850',
};

// ═══════════════════════════════════════════════════════
//  SDE → SPRING_BOOT
// ═══════════════════════════════════════════════════════

const sdeSpringBoot: Record<number, JourneyConfig> = {

  // ── Journey 1: Sem 1→6 (Relaxed, 6 semesters) ──
  1: {
    title: 'SDE + Spring Boot — Full 6-Semester Journey',
    milestones: [
      {
        semester: 1,
        title: 'Semester 1: Java Foundations & Introductory DSA',
        description: 'Start by building a solid Java foundation — understand variables, data types, operators, control flow, and methods (Sections 1–5). Then move into OOP: classes, objects, inheritance, polymorphism, and encapsulation (Sections 8–9). Keep exception handling and arrays alongside. On the DSA side, begin with the basics of complexity analysis and pattern problems, then work through arrays and string manipulation before introducing recursion (Sections 1–7). By the end of this semester you should be able to write clean Java classes and solve easy-to-medium array and recursion problems.',
        monthsHint: 'Months 1–6 (Month 1–2: Java Syntax, Data Types & Control Flow | Month 3–4: OOP, Arrays & Strings | Month 5–6: Recursion Basics & Patterns)',
        tracks: [
          {
            name: 'Java Programming Basics',
            roadmapId: ROADMAP_IDS.JAVA_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Introduction → Variables → Operators → Control Flow → Methods → Arrays → Strings → OOP → OOP Principles',
          },
          {
            name: 'A2Z DSA — Year 1 Phase 1',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–7: Learn the Basics → Sorting Techniques → Arrays (Easy→Hard) → Binary Search → Strings → Linked List intro → Recursion (PatternWise)',
          },
        ],
      },
      {
        semester: 2,
        title: 'Semester 2: Core Data Structures & Java Ecosystem',
        description: 'Complete Year 1 DSA by mastering Stacks and Queues — both the conceptual model and implementation-heavy problems including prefix/postfix/infix conversion and monotonic stacks (Section 9). Also cover Bit Manipulation for interview prep (Section 8). On the Java side, deepen your understanding with Exception Handling, Multithreading basics, Generics, and the Collections Framework (Sections 10–16) — this directly maps to Spring Boot internals you will encounter next semester. Start exploring HTTP fundamentals and how Java handles I/O and packages.',
        monthsHint: 'Months 7–12 (Month 7–8: Stacks, Queues & Bit Manipulation | Month 9–10: Java Exception Handling, Generics & Collections | Month 11–12: Multithreading Basics & HTTP Concepts)',
        tracks: [
          {
            name: 'A2Z DSA — Year 1 Completion',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 8–9: Bit Manipulation → Stack and Queues (Learning, Pre/In/Post-fix, Monotonic Stack, Implementation)',
          },
          {
            name: 'Java Ecosystem Deep Dive',
            roadmapId: ROADMAP_IDS.JAVA_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 10–16: Exception Handling → Packages & Access Modifiers → File Handling → Multithreading → Generics → Collections Framework → Functional Programming & Streams',
          },
        ],
      },
      {
        semester: 3,
        title: 'Semester 3: Advanced DSA & Spring Boot Foundations',
        description: 'This is the most technically dense semester. On the DSA side, cover Trees (Binary Trees and BSTs) and Graphs — these are the highest-frequency topics in SDE interviews at product companies (Sections 13–15). Prioritize tree traversals, BST operations, and graph BFS/DFS before moving to harder problems. In parallel, begin Spring Boot: understand the Spring container, Dependency Injection, and IoC (Sections 1–3), then build your first REST APIs with proper request/response handling, validation, and exception management (Sections 4–6). Finally, integrate Spring Data JPA to connect to a PostgreSQL database (Section 7). By semester end you should have a working CRUD REST API with a database backend.',
        monthsHint: 'Months 13–18 (Month 13–14: Binary Trees & BST | Month 15–16: Graphs BFS/DFS | Month 17–18: Spring Boot DI, REST APIs & JPA)',
        tracks: [
          {
            name: 'A2Z DSA — Year 2 Phase 1',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 13–15: Binary Trees (Traversals, Medium, Hard) → Binary Search Trees → Graphs (Concepts & Problems including BFS, DFS, Topological Sort, MST)',
          },
          {
            name: 'Spring Boot Backend — Foundations',
            roadmapId: ROADMAP_IDS.SPRING_BOOT,
            icon: 'server',
            progressHint: 'Complete Sections 1–7: Java & Build Tool Foundations → Intro to Spring & Spring Boot → Dependency Injection & IoC → Spring Boot Configuration → Building REST APIs → Validation & Exception Handling → Spring Data JPA & Persistence',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: DSA Mastery, Spring Security & Full-Stack Integration',
        description: 'Finish the A2Z DSA sheet by tackling Dynamic Programming (all major patterns: 1D, 2D, DP on strings, DP on trees, DP on graphs) and Tries (Section 16–17). These topics are crucial for FAANG-level interviews. On the Spring Boot side, learn database transactions and management (Section 8), implement authentication and authorization using Spring Security with JWT and OAuth2 (Sections 9–10), and add caching with Redis and AOP patterns (Section 11). For the frontend integration layer, complete React basics and hooks so you can wire a React frontend to your Spring Boot API, building a deployable full-stack project by semester end.',
        monthsHint: 'Months 19–24 (Month 19–20: DP Patterns & Tries | Month 21–22: Spring Security, JWT & OAuth2 | Month 23–24: React Integration & Full-Stack Deployment)',
        tracks: [
          {
            name: 'A2Z DSA — Year 2 Completion',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10–12 & 16–17: Sliding Window & Two Pointers → Heaps → Greedy Algorithms → Dynamic Programming (all patterns) → Tries',
          },
          {
            name: 'Spring Boot — Security & Advanced Features',
            roadmapId: ROADMAP_IDS.SPRING_BOOT,
            icon: 'server',
            progressHint: 'Complete Sections 8–11: Transactions & Database Management → Spring Security Fundamentals → Spring Security with JWT & OAuth2 → Caching, AOP & Cross-Cutting Concerns',
          },
          {
            name: 'React Frontend — Integration Layer',
            roadmapId: ROADMAP_IDS.FRONTEND,
            icon: 'layout',
            progressHint: 'Complete Sections 1–6: Web Fundamentals → Developer Tools → HTML & CSS Building Blocks → JavaScript & Browser APIs → TypeScript Essentials → Building Modern Frontends (React)',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: System Design & Competitive Programming',
        description: 'Shift gears from implementation to architecture. Study Low Level Design (LLD) — design patterns like Singleton, Factory, Observer, Strategy, and practice designing real systems like a Parking Lot, Library Management System, or Chess Engine. Then cover High Level Design (HLD): CAP theorem, consistent hashing, database sharding, load balancing, caching strategies (LRU/LFU), message queues, and microservices communication. Simultaneously grind the CP-31 Sheet from Rating 800 up to 1400 to sharpen speed and problem-solving under time pressure — this directly helps with Online Assessments at top companies.',
        monthsHint: 'Months 25–30 (Month 25–26: LLD Design Patterns & OOP Design | Month 27–28: HLD Distributed Systems, CAP & Sharding | Month 29–30: CP-31 Sheet Ratings 800→1400)',
        tracks: [
          {
            name: 'CP-31 Sheet — Contest Problem Solving',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 1–6: Rating 800 (Beginner Foundations) → 900 (Elementary Logic) → 1000 (Intermediate) → 1100 (Upper Intermediate) → 1200 (Advanced) → 1300–1400 (Expert Problems)',
          },
          {
            name: 'System Design — LLD & HLD',
            icon: 'brain',
            progressHint: 'Study LLD: SOLID Principles, Design Patterns (Creational, Structural, Behavioral), UML Diagrams, Practice Problems (Parking Lot, BookMyShow, Snake & Ladder). Study HLD: Scalability, Load Balancers, CDN, Caching (Redis), Database Sharding & Replication, Microservices & API Gateway, Message Queues (Kafka/RabbitMQ)',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Sprint & Interview Preparation',
        description: 'This is full placement mode. Dedicate the first two months to aggressive mock interview practice — at least 3 mock coding rounds per week, covering DSA problems you have seen before but under timed conditions. Revise all major DSA patterns (sliding window, two pointers, union find, DP) and system design cases. Polish your resume: list Spring Boot projects with tech stack details, your Codeforces/LeetCode rating, and GitHub links. Research company-specific patterns (e.g., Amazon loves DP and Trees, Google loves Graphs and System Design). In the final two months, focus exclusively on campus drives and online applications.',
        monthsHint: 'Months 31–36 (Month 31–32: DSA Pattern Revision & Timed Mock Rounds | Month 33–34: System Design Mock Interviews & Resume Polish | Month 35–36: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Interview & Placement Preparation',
            icon: 'book',
            progressHint: 'Week-by-week: 3 LeetCode/CF problems daily (Easy→Medium→Hard rotation), 2 mock interviews/week, 1 system design discussion/week. Revise: Top 150 Interview Problems, Striver SDE Sheet revision pass, resume review with peer or mentor',
          },
        ],
      },
    ],
  },

  // ── Journey 2: Sem 2→6 (5 semesters) ──
  2: {
    title: 'SDE + Spring Boot — 5-Semester Journey',
    milestones: [
      {
        semester: 2,
        title: 'Semester 2: Accelerated Java & Core DSA',
        description: 'Compress Java fundamentals into the first half — cover variables, control flow, OOP, arrays, strings, and exception handling (Sections 1–10) in 3 months. Move immediately to DSA in parallel: arrays, sorting, binary search, strings, linked lists, and build up to Stacks and Queues (Sections 1–9). The key is not to finish Java perfectly before starting DSA — run both tracks in tandem so each reinforces the other. Aim for 2–3 DSA problems daily by Month 4.',
        monthsHint: 'Months 1–6 (Month 1–2: Java Syntax, OOP & Arrays | Month 3–4: Java Collections & DSA Arrays→Stacks | Month 5–6: Java Streams, Multithreading & Queues)',
        tracks: [
          {
            name: 'Java Programming Basics',
            roadmapId: ROADMAP_IDS.JAVA_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–10: Introduction → Variables → Operators → Control Flow → Methods → Arrays → Strings → OOP → OOP Principles → Exception Handling',
          },
          {
            name: 'A2Z DSA — Year 1 Target',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Learn the Basics → Sorting → Arrays (Easy→Hard) → Binary Search → Strings → Linked List → Recursion → Bit Manipulation → Stack and Queues',
          },
        ],
      },
      {
        semester: 3,
        title: 'Semester 3: Advanced DSA & Spring Boot Backend',
        description: 'Deep dive into Trees, BSTs, and Graphs — the three most commonly tested DSA topics in product company SDE interviews (Sections 13–15). While grinding these, simultaneously build your Spring Boot fundamentals: DI/IoC, REST APIs, validation, and Spring Data JPA (Sections 1–7). The practical approach here is to build a small project (e.g., a Student Management API) while learning Spring Boot, which solidifies concepts much faster than theory alone.',
        monthsHint: 'Months 7–12 (Month 7–8: Binary Trees & BST | Month 9–10: Graphs & Heaps | Month 11–12: Spring Boot REST APIs, JPA & PostgreSQL)',
        tracks: [
          {
            name: 'A2Z DSA — Trees, Graphs & Heaps',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 11–15: Heaps (Learning, Medium, Hard) → Greedy Algorithms → Binary Trees → Binary Search Trees → Graphs (BFS, DFS, Topological Sort, Shortest Paths, MST)',
          },
          {
            name: 'Spring Boot Backend',
            roadmapId: ROADMAP_IDS.SPRING_BOOT,
            icon: 'server',
            progressHint: 'Complete Sections 1–7: Java & Build Tool Foundations → Intro to Spring & Spring Boot → Dependency Injection & IoC → Configuration → Building REST APIs → Validation & Exception Handling → Spring Data JPA & Persistence',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: DSA Completion, Security & Full-Stack',
        description: 'Close out DSA with Sliding Window, DP (all patterns from 1D to Bitmask), and Tries. These are the hardest sections but hugely rewarding for interviews. On Spring Boot, add the enterprise-grade layers: transactions, Spring Security with stateless JWT authentication, OAuth2, caching with Redis, and AOP. Your semester project should be a full-stack application: a React frontend consuming a secured Spring Boot REST API backed by PostgreSQL — deploy it to a free cloud instance (Railway, Render, or Fly.io) so you have a live project link for your resume.',
        monthsHint: 'Months 13–18 (Month 13–14: Sliding Window, DP Patterns 1–3 | Month 15–16: DP Patterns 4–6, Tries & Spring Security | Month 17–18: Full-Stack Project & Deployment)',
        tracks: [
          {
            name: 'A2Z DSA — Completion',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10 & 16–17: Sliding Window & Two Pointers → Dynamic Programming (1D, 2D, DP on Stocks, Strings, LCS, MCM, Partition, Bitmask, Trees) → Tries',
          },
          {
            name: 'Spring Boot — Security & Production',
            roadmapId: ROADMAP_IDS.SPRING_BOOT,
            icon: 'server',
            progressHint: 'Complete Sections 8–12: Transactions & Database Management → Spring Security Fundamentals → JWT & OAuth2 → Caching, AOP & Cross-Cutting Concerns → Testing in Spring Boot',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: System Design & CP Practice',
        description: 'Study HLD and LLD systematically. For LLD, practice implementing design patterns from scratch in Java (Decorator, Strategy, Observer, Factory, Builder) and solve design problems like designing a notification system, ride-sharing model, or rate limiter. For HLD, understand how real systems are built: URL shortener (hashing), Twitter feed (fan-out), YouTube (CDN + chunked uploads), e-commerce checkout (transactions + queues). Simultaneously grind CP-31 problems up to 1400 rating to sharpen your competitive speed.',
        monthsHint: 'Months 19–24 (Month 19–20: LLD Design Patterns & Practice Problems | Month 21–22: HLD — Scalable Systems & Distributed Design | Month 23–24: CP-31 Sheet 800→1400)',
        tracks: [
          {
            name: 'CP-31 Sheet',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 1–6: Rating 800 → 900 → 1000 → 1100 → 1200 → 1300–1400 (Expert Problems)',
          },
          {
            name: 'System Design — LLD & HLD',
            icon: 'brain',
            progressHint: 'LLD: SOLID Principles, GoF Design Patterns in Java, Practice — Parking Lot, Library System, Chess. HLD: Load Balancing, Consistent Hashing, SQL vs NoSQL, Caching (Redis), Database Sharding, Message Queues (Kafka), Microservices & API Gateway, Case Studies — URL Shortener, Twitter Feed, Netflix CDN',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'Execute a structured placement sprint. First month: do a full revision pass of all major DSA topics using a top-150-problems list — focus on problems you have got wrong before. Second month: mock system design interviews (explain a system aloud for 45 minutes, then critique yourself). Third month: company research and application blitz — tailor your resume for each company tier, apply broadly. Fourth month: focus on live drives, OA rounds, and HR prep. Keep one Spring Boot + React project live and demo-ready at all times.',
        monthsHint: 'Months 25–30 (Month 25–26: DSA Revision Pass & Timed Mocks | Month 27–28: System Design Mocks & Resume Polish | Month 29–30: Campus Drives & OA Rounds)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2–3 LeetCode problems (Medium focus). Weekly: 2 mock coding rounds + 1 system design discussion. Targets: Complete Striver SDE Sheet revision, top 50 system design questions, Java internals (JVM, GC, Concurrency), Spring Boot interview Q&A, resume reviewed by senior peer',
          },
        ],
      },
    ],
  },

  // ── Journey 3: Sem 3→6 (4 semesters) ──
  3: {
    title: 'SDE + Spring Boot — Accelerated 4-Semester Journey',
    milestones: [
      {
        semester: 3,
        title: 'Semester 3: Java Basics + DSA Sprint (Year 1)',
        description: 'With only 4 semesters available, you need to move fast but without skipping fundamentals. Cover Java Sections 1–9 in the first 2 months: focus on syntax, OOP, arrays, and strings — skip deep dives into File I/O and Reflection for now. Immediately layer DSA on top: arrays, sorting, binary search, strings, linked lists, recursion, bit manipulation, and stacks/queues (Sections 1–9). The trick is to practice DSA problems in Java so both tracks reinforce each other. Aim for 2 problems per day from Month 2.',
        monthsHint: 'Months 1–6 (Month 1–2: Java Sections 1–9 Core Concepts | Month 3–4: DSA Arrays, Binary Search & Strings | Month 5–6: Linked List, Recursion, Bit Manipulation & Stacks/Queues)',
        tracks: [
          {
            name: 'Java Basics',
            roadmapId: ROADMAP_IDS.JAVA_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Introduction → Variables → Operators → Control Flow → Methods → Arrays → Strings → OOP → OOP Principles (prioritize OOP and Arrays, skim File I/O for now)',
          },
          {
            name: 'A2Z DSA — Year 1 Target',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Learn the Basics → Sorting Techniques → Arrays (Easy→Hard) → Binary Search (1D, 2D, Search Space) → Strings (Basic & Medium) → Linked List → Recursion (PatternWise) → Bit Manipulation → Stack and Queues',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: Advanced DSA & Full Spring Boot Backend',
        description: 'Tackle the hardest DSA sections: Heaps, Greedy, Sliding Window, Trees, BSTs, Graphs, DP, and Tries (Sections 10–17). Run these alongside a rapid Spring Boot ramp-up. You must complete the entire Spring Boot track through JWT security this semester (Sections 1–10) because Semester 5 is for system design and CP, not implementation catch-up. Build a real project: design a secure REST API (e.g., task manager or blog platform) with Spring Boot, PostgreSQL via JPA, and JWT auth — deploy it before the semester ends.',
        monthsHint: 'Months 7–12 (Month 7–8: Heaps, Greedy & Sliding Window | Month 9–10: Trees, Graphs & Spring Boot Sections 1–7 | Month 11–12: DP, Tries & Spring Security Sections 8–10)',
        tracks: [
          {
            name: 'A2Z DSA — Complete',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10–17: Sliding Window & Two Pointers → Heaps → Greedy → Binary Trees → BSTs → Graphs → Dynamic Programming (all patterns) → Tries',
          },
          {
            name: 'Spring Boot Backend — Full Track',
            roadmapId: ROADMAP_IDS.SPRING_BOOT,
            icon: 'server',
            progressHint: 'Complete Sections 1–10: Java & Build Tools → Spring Core → DI & IoC → Configuration → REST APIs → Validation → Spring Data JPA → Transactions → Spring Security Fundamentals → JWT & OAuth2',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: System Design & CP-31 Sheet',
        description: 'No new implementation this semester — shift entirely to design and problem-solving skills. Study LLD patterns (SOLID, GoF Design Patterns in Java, class diagrams) and HLD concepts (consistent hashing, CAP theorem, database replication, event-driven architecture, microservices with Spring Cloud). For CP-31, work from 800 to 1200 rating — the goal is not to become a competitive programmer but to increase your OA speed and accuracy for placement tests. Budget roughly 4 hours/week on CP and 4 hours/week on system design reading + case studies.',
        monthsHint: 'Months 13–18 (Month 13–14: LLD Patterns & Design Problems | Month 15–16: HLD — Distributed Systems & Case Studies | Month 17–18: CP-31 Sheet 800→1200)',
        tracks: [
          {
            name: 'CP-31 Sheet',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 1–5: Rating 800 (Beginner Foundations) → 900 (Elementary Logic) → 1000 (Intermediate) → 1100 (Upper Intermediate) → 1200 (Advanced)',
          },
          {
            name: 'System Design — LLD & HLD',
            icon: 'brain',
            progressHint: 'LLD: SOLID Principles, Design Patterns (Factory, Singleton, Observer, Strategy, Decorator), UML, Practice Problems (Parking Lot, Elevator, ATM). HLD: Scalability Pillars, Load Balancers, CDN, SQL vs NoSQL, Caching (Redis LRU), DB Sharding & Replication, Kafka Queues, Microservices Patterns, Case Studies (URL Shortener, BookMyShow, WhatsApp)',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Intensive Interview Sprint',
        description: 'Four semesters is tight, so your interview prep must be very structured. Week 1–4: Redo your top 100 most important DSA problems — only problems you have previously solved, under 30-minute time limits. Week 5–8: Daily mock interviews (coding + system design). Week 9–12: Application blitz — apply to 10+ companies per week, prioritize companies whose patterns you know. Week 13–18: Active drives, OA rounds, and interview season. Keep a spreadsheet of companies, OA dates, and follow-ups.',
        monthsHint: 'Months 19–24 (Month 19–20: DSA Rapid Revision & Timed Mocks | Month 21–22: System Design Mocks & Applications | Month 23–24: Placements & Campus Drives)',
        tracks: [
          {
            name: 'Interview Sprint',
            icon: 'book',
            progressHint: 'Daily: 2–3 problems (Medium/Hard LeetCode rotation). Weekly: 2 mock coding + 1 mock system design. Milestones: Striver SDE Sheet full revision, Top 50 System Design Q&A, Java & Spring Boot interview Q&A list (100 questions), Resume with 2 live projects & GitHub, CF/LC profile polished',
          },
        ],
      },
    ],
  },

  // ── Journey 4: Sem 4→6 (3 semesters) ──
  4: {
    title: 'SDE + Spring Boot — Fast-Track 3-Semester Journey',
    milestones: [
      {
        semester: 4,
        title: 'Semester 4: Java Essentials + Core DSA + Spring Boot REST',
        description: 'Three semesters demands extreme focus. In Month 1–2, blast through Java essentials: OOP, collections, and generics are the must-haves (Sections 1–10). From Month 2 onwards, layer DSA simultaneously: arrays, binary search, linked lists, and stacks/queues should be done by Month 4 (Sections 1–9). In parallel from Month 3, start Spring Boot — DI, REST API building, and JPA are the core you need (Sections 1–7). By Month 6 you should have a working Spring Boot API deployed. Do not aim for perfection — aim for breadth and working code.',
        monthsHint: 'Months 1–6 (Month 1–2: Java OOP, Collections & Core Concepts | Month 3–4: DSA Arrays→Stacks & Spring Boot REST API | Month 5–6: Spring Boot JPA, Validation & Core DSA Completion)',
        tracks: [
          {
            name: 'Java Basics — Essentials',
            roadmapId: ROADMAP_IDS.JAVA_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–10: Introduction through Exception Handling. Prioritize: OOP (Sections 8–9), Collections (Section 15), Generics (Section 14). Skip: File Handling, Reflection, Enums for now.',
          },
          {
            name: 'A2Z DSA — Core Year 1',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Learn the Basics → Sorting → Arrays → Binary Search → Strings → Linked List → Recursion → Bit Manipulation → Stack and Queues',
          },
          {
            name: 'Spring Boot Basics',
            roadmapId: ROADMAP_IDS.SPRING_BOOT,
            icon: 'server',
            progressHint: 'Complete Sections 1–7: Java & Build Tool Foundations → Intro to Spring → DI & IoC → Spring Boot Configuration → Building REST APIs → Validation & Exception Handling → Spring Data JPA & Persistence',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: Advanced DSA, Spring Security & Full-Stack Capstone',
        description: 'The most important semester of this journey. Finish all remaining DSA topics: Trees, Graphs, Heaps, Greedy, Sliding Window, DP, and Tries (Sections 10–17) — budget 3 months for this, prioritizing Trees and Graphs over DP in terms of interview frequency. Simultaneously, complete Spring Boot Security (JWT/OAuth2, Sections 9–10) and AOP/caching (Section 11). Your capstone project this semester must be a full-stack application: React frontend + secured Spring Boot API + PostgreSQL, deployed live. Add a system design basics layer: cover LLD design patterns and core HLD concepts in the last month.',
        monthsHint: 'Months 7–12 (Month 7–8: Trees, Graphs & Heaps | Month 9–10: DP, Tries & Spring Security | Month 11–12: Full-Stack Capstone Project & System Design Intro)',
        tracks: [
          {
            name: 'A2Z DSA — Advanced & Completion',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10–17: Sliding Window & Two Pointers → Heaps → Greedy → Binary Trees → BSTs → Graphs → Dynamic Programming (1D, 2D, DP on Strings/Trees) → Tries',
          },
          {
            name: 'Spring Boot — Full Production Stack',
            roadmapId: ROADMAP_IDS.SPRING_BOOT,
            icon: 'server',
            progressHint: 'Complete Sections 8–12: Transactions → Spring Security Fundamentals → JWT & OAuth2 → Caching & AOP → Testing in Spring Boot. Project: Build & deploy a secured full-stack app (Spring Boot + React + PostgreSQL)',
          },
          {
            name: 'System Design Foundations',
            icon: 'brain',
            progressHint: 'Cover core LLD (SOLID Principles, 5 key design patterns) and HLD basics (Scalability, Load Balancing, Caching, Database fundamentals). Use Grokking the System Design Interview or Alex Xu\'s System Design Interview Vol. 1 as reference.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Intensive Placement Preparation',
        description: 'With a tight runway, placement prep must be surgical. Identify your 3 target company tiers and research their interview patterns. Do a focused DSA revision: only the most common patterns (sliding window, two pointers, BFS/DFS, DP on arrays/strings, segment trees if targeting product companies). Practice mock coding interviews timed at 45 minutes. Do 2 mock system design sessions per week — focus on explaining clearly rather than knowing everything. Apply broadly in the last 2 months. Keep your Spring Boot project live and rehearse a 10-minute demo.',
        monthsHint: 'Months 13–18 (Month 13–14: DSA Pattern Revision & OA Practice | Month 15–16: System Design Mocks & Company Research | Month 17–18: Campus Drives & Placement Applications)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (Medium). Weekly: 2 timed mock coding rounds (45-min) + 1 system design mock. Targets: Top 100 Interview Problems revision, Java & Spring Boot Q&A (100 questions), 2 live deployed projects on resume, CF/LC profile updated, mock HR interview practice',
          },
        ],
      },
    ],
  },

  // ── Journey 5: Sem 5→6 (2 semesters) ──
  5: {
    title: 'SDE + Spring Boot — Crash Course 2-Semester Journey',
    milestones: [
      {
        semester: 5,
        title: 'Semester 5: High-Yield DSA & Spring Boot Project Sprint',
        description: 'Two semesters is a true crash course — every week matters. Do not attempt the full A2Z DSA sheet. Instead, focus exclusively on the highest-frequency interview patterns: Arrays (Two Pointers, Sliding Window, Prefix Sum), Binary Search, Linked Lists (fast/slow pointer), Trees (all traversals, LCA, diameter), Graphs (BFS, DFS, Topological Sort, Dijkstra), Dynamic Programming (1D, 2D, LCS, 0-1 Knapsack), and Stacks/Monotonic Stacks. For Spring Boot, skip the ramp-up theory — directly build a project with Spring Boot, Spring Data JPA, and Spring Security JWT. Deploy it to Railway or Render. The goal is one live, documented, GitHub-linked Spring Boot + React project by Month 5.',
        monthsHint: 'Months 1–6 (Month 1–2: High-Yield DSA Patterns — Arrays, Trees, Graphs | Month 3–4: DP, Stacks & Binary Search | Month 5–6: Spring Boot REST + JPA + JWT Project & Deployment)',
        tracks: [
          {
            name: 'Java & High-Yield DSA',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'High-priority sections only — Sections 1–5, 9, 13–16: Basics & Sorting → Arrays (all difficulties) → Binary Search → Strings → Stack and Queues → Binary Trees → BSTs → Graphs → Dynamic Programming. Skip: Heaps standalone, Tries (unless time permits). Practice: Striver\'s Top 79 Interview Problems.',
          },
          {
            name: 'Spring Boot Quick Project',
            roadmapId: ROADMAP_IDS.SPRING_BOOT,
            icon: 'server',
            progressHint: 'Fast-track through Sections 1–10: Build Tool Setup → Spring Core & DI → REST APIs → Validation → JPA & PostgreSQL → Spring Security with JWT. Project deliverable: A deployed REST API with authentication (e.g., Job Board API, URL Shortener, or E-commerce Backend) — must have GitHub README, live link, and Postman collection.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: All-In Placement Sprint',
        description: 'This is execution mode only. Month 1: Intensive OA preparation — practice company-specific OA patterns (GeeksForGeeks company-wise problems, LeetCode company tags). Month 2: Mock interview marathon — aim for 15+ mock coding interviews this month using peers or platforms like Pramp/Interviewing.io. Month 3: Resume and application blitz — apply to 15+ companies per week, follow up on every application. Month 4–6: Active drives, interview rounds, offer negotiation. Keep your Spring Boot project live and practiced — be ready to walk through the architecture, code decisions, and security implementation in any interview.',
        monthsHint: 'Months 7–12 (Month 7–8: OA Grinding & Company Pattern Practice | Month 9–10: Mock Interview Marathon & Resume Polish | Month 11–12: Campus Drives & Active Applications)',
        tracks: [
          {
            name: 'Placement Sprint',
            icon: 'book',
            progressHint: 'Daily: 3 LeetCode problems (Medium/Hard). Weekly: 3 mock interviews. Targets: LeetCode 150 completion, Striver SDE Sheet top 50 revision, Spring Boot + Java interview Q&A (100 questions), 1 live deployed project with documentation, HR interview practice, company-specific preparation for top 5 target companies',
          },
        ],
      },
    ],
  },
};

// ═══════════════════════════════════════════════════════
//  SDE → NODE_JS
// ═══════════════════════════════════════════════════════

const sdeNodeJs: Record<number, JourneyConfig> = {
  1: {
    title: 'SDE + Node.js — Full 6-Semester Journey',
    milestones: [
      {
        semester: 1,
        title: 'Semester 1: JavaScript Foundations & Introductory DSA',
        description: 'JavaScript is both your language for DSA practice and your backend runtime — master it deeply. Cover MERN Sections 1 (Fundamentals: variables, scope, closures, prototype chain, event loop model) and 3 (Building Blocks: DOM, events, async/await, Promises, ES6+ features). For DSA, start with the basics and work through arrays, sorting, binary search, strings, and recursion (Sections 1–7). Implement all DSA problems in JavaScript — this saves time and deepens your language fluency. By semester end, you should understand the JS event loop well enough to explain it in an interview.',
        monthsHint: 'Months 1–6 (Month 1–2: JS Fundamentals — Scope, Closures, Async, Event Loop | Month 3–4: DSA Arrays, Sorting, Binary Search | Month 5–6: DSA Strings, Linked Lists, Recursion)',
        tracks: [
          {
            name: 'JavaScript & MERN Foundations',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'code',
            progressHint: 'Complete Sections 1 & 3: Fundamentals (Variables, Scope, Closures, Prototype, Event Loop, Callbacks, Promises, Async/Await, ES6+) → Building Blocks (DOM, Browser APIs, Event Handling, Fetch API)',
          },
          {
            name: 'A2Z DSA — Year 1 Phase 1',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–7: Learn the Basics → Sorting Techniques → Arrays (Easy→Hard) → Binary Search (1D, 2D, Search Space) → Strings (Basic & Medium) → Linked List → Recursion (PatternWise). Solve all problems in JavaScript.',
          },
        ],
      },
      {
        semester: 2,
        title: 'Semester 2: Core DSA Completion & Node.js/Express Backend',
        description: 'Finish Year 1 DSA with Bit Manipulation and Stacks/Queues — including the critical monotonic stack problems (Section 8–9). Simultaneously begin building backend systems with Node.js: start with MERN Section 6 (Backend Engineering) covering Express.js REST APIs, middleware, routing, MongoDB with Mongoose, and basic CRUD operations. Build a simple REST API (e.g., a blog or notes API) as a hands-on project. Understanding Node.js\'s non-blocking I/O model is essential — study the event loop, libuv, and streams beyond just Express syntax.',
        monthsHint: 'Months 7–12 (Month 7–8: Bit Manipulation & Stacks/Queues | Month 9–10: Node.js, Express & MongoDB Basics | Month 11–12: JWT Auth, Middleware & REST API Project)',
        tracks: [
          {
            name: 'A2Z DSA — Year 1 Completion',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 8–9: Bit Manipulation (Concepts & Problems) → Stack and Queues (Learning, Pre/In/Post-fix Conversion, Monotonic Stack, Implementation problems)',
          },
          {
            name: 'Node.js & Express Backend',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'server',
            progressHint: 'Complete Section 6: Backend Engineering (Node.js internals, Express.js REST APIs, Middleware Pipeline, Routing, MongoDB with Mongoose, CRUD operations, JWT Authentication, Input Validation with Zod/Joi, Error Handling patterns)',
          },
        ],
      },
      {
        semester: 3,
        title: 'Semester 3: Advanced DSA & Production Node.js',
        description: 'Cover Trees, BSTs, and Graphs in DSA — the hardest and most important interview topics (Sections 13–15). For Node.js, go beyond basic CRUD: study advanced patterns from MERN Section 6 including caching with Redis, background job queues (Bull/BullMQ), rate limiting, file uploads (Multer + S3 or Cloudinary), WebSockets with Socket.io, and database indexing strategies. By semester end, your Node.js knowledge should extend to building a production-grade API with Redis caching and proper error boundaries.',
        monthsHint: 'Months 13–18 (Month 13–14: Binary Trees & BST | Month 15–16: Graphs BFS/DFS & Shortest Paths | Month 17–18: Redis Caching, WebSockets, File Uploads & Rate Limiting)',
        tracks: [
          {
            name: 'A2Z DSA — Year 2 Phase 1',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 13–15: Binary Trees (all traversals, diameter, LCA, views) → Binary Search Trees (insert/delete, kth smallest, balanced BST) → Graphs (BFS, DFS, Topological Sort, Dijkstra, Bellman-Ford, Floyd-Warshall, MST with Kruskal & Prim)',
          },
          {
            name: 'Advanced Node.js Backend',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'server',
            progressHint: 'Continue Section 6 (advanced) + Section 9: Advanced Express Patterns (middleware chains, global error handler), Redis Caching (ioredis), Background Jobs (Bull/BullMQ), WebSockets (Socket.io), File Uploads (Multer), Rate Limiting, Database Indexing, AI Integrations intro',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: DSA Mastery & Full-Stack MERN',
        description: 'Complete the remaining DSA topics: Sliding Window, Heaps, Greedy, DP (all patterns), and Tries (Sections 10–12, 16–17). DP is the hardest section — allocate extra time for it, especially 2D DP, DP on strings, and MCM. For the full-stack side, cover MERN Section 7 (Building Modern Frontends with React: hooks, context, React Query, React Router) and Section 8 (Full Stack Development: integrating React with Express, monorepo structure, deployment). Build and deploy one complete MERN application — it must have authentication, real-time features (Socket.io or polling), and a proper README.',
        monthsHint: 'Months 19–24 (Month 19–20: Sliding Window, Heaps, Greedy | Month 21–22: DP All Patterns & Tries | Month 23–24: React Integration, MERN Full-Stack & Deployment)',
        tracks: [
          {
            name: 'A2Z DSA — Completion',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10–12 & 16–17: Sliding Window & Two Pointers → Heaps (Learning, Medium, Hard) → Greedy (Easy, Medium/Hard) → Dynamic Programming (1D, 2D, DP on Stocks, Strings, LCS, MCM, Partition, Bitmask, Trees, Graphs) → Tries',
          },
          {
            name: 'Full-Stack MERN Project',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'terminal',
            progressHint: 'Complete Sections 7–8: Building Modern Frontends (React hooks, Context API, React Query, React Router, TypeScript with React) → Full Stack Development (MERN integration, Monorepo setup, REST + WebSocket, Authentication flow, Cloud Deployment on Railway/Render/Fly.io)',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: System Design & CP-31 Practice',
        description: 'Study system design with a focus on Node.js-specific architecture considerations: single-threaded event loop design implications, clustering and worker threads for CPU-bound tasks, horizontal scaling of stateless Node.js services, session management with Redis in distributed systems, and microservices with gRPC or REST between Node.js services. For CP-31, grind 800 to 1400 rating — the focus is on improving your Online Assessment speed for campus placements. MERN Section 10 (DevOps for Developers) also fits here: CI/CD with GitHub Actions, Docker, and cloud deployments.',
        monthsHint: 'Months 25–30 (Month 25–26: LLD & HLD — Distributed Node.js Systems | Month 27–28: CP-31 Grinding 800→1400 | Month 29–30: DevOps, Docker & CI/CD)',
        tracks: [
          {
            name: 'CP-31 Sheet',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 1–6: Rating 800 (Beginner Foundations) → 900 (Elementary Logic) → 1000 (Intermediate Problem Solving) → 1100 (Upper Intermediate) → 1200 (Advanced) → 1300–1400 (Expert Problems)',
          },
          {
            name: 'System Design & DevOps',
            icon: 'brain',
            progressHint: 'System Design: Event Loop Architecture, Node.js Clustering & Worker Threads, Redis for Sessions & Caching, Message Queues (Kafka/RabbitMQ), Microservices, Load Balancing, WebSocket Scaling. DevOps (MERN Section 10): Docker, docker-compose, GitHub Actions CI/CD, Nginx as Reverse Proxy, Cloud Deployment (AWS EC2 or Railway)',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'Structure your placement sprint around JavaScript-specific interview depth. Companies hiring Node.js SDE roles will ask: event loop internals, Promise chaining vs async/await, memory leaks in Node.js, Express middleware architecture, MongoDB aggregation pipelines, and JWT vs session auth trade-offs. Prepare answers to all of these. Also run standard SDE interview prep: DSA mocks, system design discussions, and behavioral rounds. Keep your MERN project live and ready to demo. Apply broadly — Node.js roles exist at startups and mid-size product companies more than FAANG.',
        monthsHint: 'Months 31–36 (Month 31–33: JS Internals Deep Dive, DSA Mocks & System Design | Month 34–36: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2–3 LeetCode problems (Medium). Weekly: 2 mock coding rounds + 1 system design discussion. Focus: JavaScript internals (Event Loop, Closures, Prototype, async), Node.js interview Q&A (100 questions), MongoDB aggregation, Express middleware patterns, top 50 system design questions, Striver SDE Sheet revision, MERN project demo practice',
          },
        ],
      },
    ],
  },

  2: {
    title: 'SDE + Node.js — 5-Semester Journey',
    milestones: [
      {
        semester: 2,
        title: 'Semester 2: JavaScript Essentials & Core DSA',
        description: 'Run JavaScript learning and DSA practice in strict parallel — solve every DSA problem in JavaScript to maximize efficiency. Cover MERN Sections 1 and 3 for JS fundamentals (closures, scope, event loop, async/await, DOM). For DSA, push through Sections 1–9: arrays, binary search, strings, linked lists, recursion, bit manipulation, and stacks/queues. By Month 5, you should be solving medium-level DSA problems comfortably in JavaScript.',
        monthsHint: 'Months 1–6 (Month 1–2: JS Fundamentals — Event Loop, Closures, Async | Month 3–4: DSA Arrays, Binary Search, Linked List | Month 5–6: Recursion, Bit Manipulation, Stacks & Queues)',
        tracks: [
          {
            name: 'JavaScript Basics',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'code',
            progressHint: 'Complete Sections 1 & 3: Fundamentals (var/let/const, scope, closures, prototypes, event loop, Promises, async/await, ES6+) → Building Blocks (DOM manipulation, event listeners, Fetch API, localStorage)',
          },
          {
            name: 'A2Z DSA — Year 1 Target',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Learn the Basics → Sorting → Arrays (Easy→Hard) → Binary Search → Strings → Linked List → Recursion → Bit Manipulation → Stack and Queues. All problems solved in JavaScript.',
          },
        ],
      },
      {
        semester: 3,
        title: 'Semester 3: Advanced DSA & Express REST Backend',
        description: 'Cover Trees, BSTs, and Graphs (Sections 13–15) — allocate more time to Graphs since Node.js backend system design heavily involves graph-like dependencies and event flows. For the backend, complete MERN Section 6: build Express REST APIs with MongoDB, implement JWT authentication, add middleware for validation and error handling, and integrate Redis basics for caching. Build a complete project: an API with CRUD + Auth + Redis caching deployed to a free platform.',
        monthsHint: 'Months 7–12 (Month 7–8: Binary Trees & BSTs | Month 9–10: Graphs & Heaps | Month 11–12: Express REST, JWT Auth & Redis Caching)',
        tracks: [
          {
            name: 'A2Z DSA — Advanced',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 11–15: Heaps → Greedy → Binary Trees (traversals, LCA, diameter, views) → Binary Search Trees → Graphs (BFS, DFS, Topological Sort, Dijkstra, MST)',
          },
          {
            name: 'Node.js Backend',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'server',
            progressHint: 'Complete Section 6: Backend Engineering — Express.js REST APIs, Middleware, MongoDB & Mongoose, CRUD, JWT Auth, Input Validation, Error Handling, Redis caching (ioredis basics), File Uploads with Multer. Project: Deploy a complete Node.js API with authentication.',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: DSA Completion & Full-Stack MERN App',
        description: 'Close out DSA: Sliding Window, DP all patterns, and Tries (Sections 10, 16–17). DP is hard — budget at least 6 weeks here. Simultaneously complete the MERN stack: React hooks, context, React Query (Section 7), and then full-stack integration with auth, WebSockets, and deployment (Section 8). Deliverable: one production-quality MERN application (e.g., a real-time chat app, project management tool, or social platform) deployed live with a clean README.',
        monthsHint: 'Months 13–18 (Month 13–15: Sliding Window, DP & Tries | Month 16–18: React Hooks, MERN Integration & Deployed Project)',
        tracks: [
          {
            name: 'A2Z DSA — Completion',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10 & 16–17: Sliding Window & Two Pointers → Dynamic Programming (1D, 2D, DP on Stocks, Strings, LCS, MCM, Partition, Bitmask DP, DP on Trees & Graphs) → Tries',
          },
          {
            name: 'MERN Full-Stack',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'terminal',
            progressHint: 'Complete Sections 7–8: Building Modern Frontends (React, hooks, context, React Query, TypeScript with React, React Router) → Full Stack Development (MERN architecture, Auth flow, WebSockets with Socket.io, CI/CD basics, Deployment to Railway/Render). Deliverable: 1 live deployed MERN app.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: System Design & CP-31',
        description: 'Study HLD and LLD with a JavaScript/Node.js lens — understand how to scale Node.js (clustering, PM2, load balancers), when to use MongoDB vs PostgreSQL, how Redis pub/sub enables real-time features, and how to design microservices for a MERN-based platform. Grind CP-31 from 800 to 1400 to sharpen OA performance. Also cover MERN Section 10 (DevOps) for Docker and CI/CD skills that are increasingly expected even in frontend-leaning SDE roles.',
        monthsHint: 'Months 19–24 (Month 19–20: System Design LLD & HLD | Month 21–22: CP-31 800→1400 | Month 23–24: DevOps — Docker, CI/CD & Nginx)',
        tracks: [
          {
            name: 'CP-31 Sheet',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 1–6: Rating 800 → 900 → 1000 → 1100 → 1200 → 1300–1400 (Expert Problems)',
          },
          {
            name: 'System Design & HLD',
            icon: 'brain',
            progressHint: 'HLD Topics: Scalability, Load Balancing (Nginx), Redis (Caching + Pub/Sub), MongoDB vs PostgreSQL trade-offs, Message Queues (Kafka/BullMQ), WebSocket Scaling (Socket.io + Redis Adapter), Microservices Communication. LLD Topics: SOLID Principles, Observer/Strategy/Factory patterns in JS. DevOps: Docker, docker-compose, GitHub Actions CI/CD.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'Execute a focused placement campaign. Prepare JavaScript and Node.js internals deeply (event loop, closures, prototype chain, async patterns, memory management). Revise DSA patterns under timed conditions. Practice system design interviews with a focus on Node.js-friendly architectures. Polish your resume to highlight the MERN project, your GitHub, and any CP rating. Apply strategically: startups and product companies are your best bet for Node.js SDE roles.',
        monthsHint: 'Months 25–30 (Month 25–26: JS/Node.js Internals & DSA Revision | Month 27–28: System Design Mocks & Resume Polish | Month 29–30: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (Medium). Weekly: 2 mock coding + 1 system design. Prep list: JavaScript 50 internals questions, Node.js 50 interview questions, Express.js patterns, MongoDB aggregation, top 50 system design Q&A, Striver SDE Sheet revision, behavioral STAR answers, 1 live MERN project demo-ready',
          },
        ],
      },
    ],
  },

  3: {
    title: 'SDE + Node.js — Accelerated 4-Semester Journey',
    milestones: [
      {
        semester: 3,
        title: 'Semester 3: JS Essentials + DSA Sprint',
        description: 'Cover JavaScript fundamentals and core DSA simultaneously from day one. MERN Sections 1 and 3 give you the JS foundation (closures, async, DOM). DSA Sections 1–9 cover everything from basics through stacks and queues. Solve all DSA problems in JavaScript. Target: medium-level DSA comfort and ability to build a basic web page interacting with a simple JS backend by Month 6.',
        monthsHint: 'Months 1–6 (Month 1–2: JS Fundamentals | Month 3–4: DSA Arrays→Strings | Month 5–6: Linked List, Recursion, Bit Manipulation, Stacks & Queues)',
        tracks: [
          {
            name: 'JavaScript Basics',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'code',
            progressHint: 'Complete Sections 1 & 3: Fundamentals → Building Blocks (closures, event loop, async/await, DOM, Fetch API, ES6+ features)',
          },
          {
            name: 'A2Z DSA — Core',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Learn the Basics → Sorting → Arrays → Binary Search → Strings → Linked List → Recursion → Bit Manipulation → Stack and Queues. All in JavaScript.',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: Advanced DSA & Node.js Backend',
        description: 'Complete all remaining DSA sections: Heaps, Greedy, Sliding Window, Trees, Graphs, DP, and Tries (Sections 10–17). Simultaneously build your full Node.js backend: MERN Section 6 (Express, MongoDB, JWT, Redis). Build one complete API project with auth and deploy it. Start on React basics from MERN Section 7 to set up for full-stack integration next semester.',
        monthsHint: 'Months 7–12 (Month 7–8: Heaps, Greedy & Sliding Window | Month 9–10: Trees, Graphs & Node.js Backend | Month 11–12: DP, Tries & React Basics)',
        tracks: [
          {
            name: 'A2Z DSA — Complete',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10–17: Sliding Window & Two Pointers → Heaps → Greedy → Binary Trees → BSTs → Graphs → Dynamic Programming (all patterns) → Tries',
          },
          {
            name: 'Node.js Backend',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'server',
            progressHint: 'Complete Section 6 + start Section 7: Backend Engineering (Express REST, MongoDB/Mongoose, JWT Auth, Redis caching, error handling) → Building Modern Frontends intro (React basics, hooks). Project: deployed Node.js API with auth.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: System Design & CP-31',
        description: 'Study LLD and HLD system design patterns. Complete MERN Section 8 (Full Stack) for the React+Node integration, and Section 10 (DevOps) for Docker and CI/CD. Grind CP-31 Sections 1–5 for OA readiness (800→1200 rating). By end of semester, have a deployed full-stack MERN project live.',
        monthsHint: 'Months 13–18 (Month 13–14: System Design & Full-Stack MERN Integration | Month 15–16: CP-31 800→1200 | Month 17–18: DevOps & Project Polish)',
        tracks: [
          {
            name: 'CP-31 Sheet',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 1–5: Rating 800 → 900 → 1000 → 1100 → 1200 (Advanced)',
          },
          {
            name: 'System Design & HLD',
            icon: 'brain',
            progressHint: 'HLD: Scalability, Load Balancing, Redis, MongoDB vs PostgreSQL, Message Queues, WebSocket Scaling. LLD: SOLID + 5 key design patterns in JS. Full Stack (MERN Section 8): MERN integration, auth, Socket.io, deployment. DevOps (Section 10): Docker, CI/CD with GitHub Actions.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Sprint',
        description: 'Full placement mode. Revise DSA under timed pressure, run mock interviews, prepare JavaScript and Node.js internals, and push applications broadly. Keep one MERN project live and demo-ready.',
        monthsHint: 'Months 19–24 (Month 19–20: DSA Revision & OA Practice | Month 21–22: Mock Interviews & System Design | Month 23–24: Placements & Applications)',
        tracks: [
          {
            name: 'Placement Sprint',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems. Weekly: 2 mock coding rounds + 1 system design. Targets: JS internals (50 Q), Node.js interview Q&A (50 Q), Striver SDE Sheet revision, top 30 system design questions, 1 live deployed MERN project, resume with GitHub links, HR interview practice',
          },
        ],
      },
    ],
  },

  4: {
    title: 'SDE + Node.js — Fast-Track 3-Semester Journey',
    milestones: [
      {
        semester: 4,
        title: 'Semester 4: JS + Core DSA + Node.js Express',
        description: 'Three tracks simultaneously from the start. Cover MERN Sections 1 & 3 (JS fundamentals) in Month 1. Run DSA Sections 1–9 from Month 2–4. Start Node.js Express (MERN Section 6) from Month 3 alongside DSA. The overlap is intentional — your DSA problems will be in JavaScript, your backend practice builds JS depth. By Month 6, have a basic Express API deployed and be comfortable with medium-level DSA in JavaScript.',
        monthsHint: 'Months 1–6 (Month 1–2: JS Fundamentals & Arrays | Month 3–4: DSA Binary Search→Stacks & Express REST | Month 5–6: DSA Completion & Node.js Auth + MongoDB)',
        tracks: [
          {
            name: 'JavaScript & Node.js',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'code',
            progressHint: 'Complete Sections 1, 3 & 6: Fundamentals → Building Blocks → Backend Engineering (Express, MongoDB/Mongoose, JWT Auth, Middleware, CRUD, Error Handling)',
          },
          {
            name: 'A2Z DSA — Core',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Learn the Basics → Sorting → Arrays (Easy→Hard) → Binary Search → Strings → Linked List → Recursion → Bit Manipulation → Stack and Queues. All in JavaScript.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: Advanced DSA & Full-Stack MERN Capstone',
        description: 'Complete the remaining DSA sections: Heaps, Greedy, Trees, Graphs, Sliding Window, DP, and Tries (Sections 10–17) — budget extra time for Trees/Graphs and DP. Finish the MERN full-stack integration: React (Section 7) + full-stack project (Section 8). Add system design basics: core LLD patterns and HLD fundamentals. Capstone deliverable: one complete, deployed MERN application with auth, real-time features, and a public GitHub repository.',
        monthsHint: 'Months 7–12 (Month 7–8: Trees, Graphs & Heaps | Month 9–10: DP, Tries & React Frontend | Month 11–12: Full-Stack MERN Capstone & System Design Intro)',
        tracks: [
          {
            name: 'A2Z DSA — Advanced',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10–17: Sliding Window → Heaps → Greedy → Binary Trees → BSTs → Graphs → Dynamic Programming (1D, 2D, DP on Strings, Trees) → Tries',
          },
          {
            name: 'Full-Stack MERN Project',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'terminal',
            progressHint: 'Complete Sections 7–8: Building Modern Frontends (React hooks, context, React Query, TypeScript) → Full Stack Development (MERN integration, Socket.io, auth flow, deployment). Capstone: deployed MERN app (e.g., real-time chat, task manager, or social platform).',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'Execute placement prep with a tight 6-month window. Month 1–2: DSA revision and OA practice targeting your weak areas. Month 3–4: Mock interviews (coding + system design) and resume polish. Month 5–6: Application blitz and active campus/company drives. Focus JS/Node.js interview Q&A alongside standard SDE prep.',
        monthsHint: 'Months 13–18 (Month 13–14: DSA Revision & OA Grinding | Month 15–16: Mock Interviews, System Design & Resume | Month 17–18: Applications & Campus Drives)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (Medium/Hard). Weekly: 2 mock coding rounds + 1 system design discussion. Targets: Top 100 interview problems revision, JavaScript internals Q&A (50), Node.js Q&A (50), top 30 system design cases, 1 live MERN project with README, resume with LeetCode/CF rating and GitHub links',
          },
        ],
      },
    ],
  },

  5: {
    title: 'SDE + Node.js — Crash Course 2-Semester Journey',
    milestones: [
      {
        semester: 5,
        title: 'Semester 5: High-Yield DSA & MERN Project Sprint',
        description: 'Two semesters means no room for breadth — focus on yield. For DSA, skip the full A2Z sheet and target the highest-frequency interview patterns: Arrays, Binary Search, Two Pointers, Sliding Window, Trees (traversals, LCA, diameter), Graphs (BFS, DFS, Topological Sort, Dijkstra), and 1D/2D DP. Solve all problems in JavaScript. For the project, skip learning Express from scratch — use a boilerplate or starter, customize it, and focus on building features: auth, REST API, a React frontend, and deployment. Goal: one live, documented MERN project by Month 5.',
        monthsHint: 'Months 1–6 (Month 1–2: High-Yield DSA Arrays, Trees, Graphs | Month 3–4: Sliding Window, DP & Binary Search | Month 5–6: MERN Project Build, Polish & Deploy)',
        tracks: [
          {
            name: 'JS & High-Yield DSA',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Priority Sections — 1–5, 9, 13–16: Basics & Sorting → Arrays (all) → Binary Search → Strings → Stack and Queues → Binary Trees → BSTs → Graphs → Dynamic Programming. Skip standalone Heaps, Tries (unless time). Solve in JavaScript. Use Striver\'s Top 79 as a checklist.',
          },
          {
            name: 'MERN Quick Project',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'server',
            progressHint: 'Fast-track Sections 1, 3, 6, 7–8: JS Fundamentals → Building Blocks → Backend Engineering (Express + MongoDB + JWT) → React Frontend → Full Stack Integration. Deliverable: 1 live deployed MERN app (e.g., Job Board, E-commerce, or Social Platform) with GitHub README and live link.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: All-In Placement Sprint',
        description: 'All execution, no learning. Month 1: OA grinding — practice company-specific patterns. Month 2: Mock interview marathon. Month 3: Application blitz. Month 4–6: Active drives and interview rounds. Prepare JavaScript and Node.js Q&A in parallel with DSA revision. Keep your MERN project live.',
        monthsHint: 'Months 7–12 (Month 7–8: OA Practice & Company Patterns | Month 9–10: Mock Interviews & Resume Polish | Month 11–12: Campus Drives & Active Applications)',
        tracks: [
          {
            name: 'Placement Sprint',
            icon: 'book',
            progressHint: 'Daily: 3 LeetCode problems (Medium/Hard). Weekly: 3 mock interviews. Targets: LeetCode 150 completion, JS internals Q&A (50), Node.js Q&A (50), top 30 system design questions, 1 live deployed MERN project, resume with GitHub & LC/CF profiles, company-specific preparation for top 5 targets',
          },
        ],
      },
    ],
  },
};

// ═══════════════════════════════════════════════════════
//  SDE → PYTHON_FASTAPI
// ═══════════════════════════════════════════════════════

const sdePythonFastApi: Record<number, JourneyConfig> = {
  1: {
    title: 'SDE + Python FastAPI — Full 6-Semester Journey',
    milestones: [
      {
        semester: 1,
        title: 'Semester 1: Python Foundations & Introductory DSA',
        description: 'Python is an expressive language that makes DSA practice very clean — use that to your advantage by running both tracks in parallel from Month 1. Cover Python Sections 1–9: syntax, data types, control flow, functions, built-in data structures (lists, dicts, sets, tuples), OOP, and magic/dunder methods. These 9 sections are all you need to solve DSA problems effectively in Python. For DSA, work through Sections 1–7: basics, sorting, arrays, binary search, strings, linked lists, and recursion. Write every DSA solution in Python — list comprehensions and built-in sorting make many problems more elegant.',
        monthsHint: 'Months 1–6 (Month 1–2: Python Syntax, Data Structures & OOP | Month 3–4: DSA Arrays, Sorting & Binary Search | Month 5–6: DSA Strings, Linked Lists & Recursion)',
        tracks: [
          {
            name: 'Python Programming Basics',
            roadmapId: ROADMAP_IDS.PYTHON_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Introduction → Variables & Data Types → Control Flow → Functions & Functional Programming → Built-in Data Structures (lists, dicts, sets, tuples) → Comprehensions & Slicing → Strings & Text Processing → OOP → Magic/Dunder Methods & Operator Overloading',
          },
          {
            name: 'A2Z DSA — Year 1 Phase 1',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–7: Learn the Basics → Sorting Techniques → Arrays (Easy→Hard) → Binary Search (1D, 2D, Search Space) → Strings (Basic & Medium) → Linked List → Recursion (PatternWise). All problems in Python.',
          },
        ],
      },
      {
        semester: 2,
        title: 'Semester 2: Core DSA Completion & FastAPI Introduction',
        description: 'Finish Year 1 DSA: Bit Manipulation and Stacks/Queues (Sections 8–9). For Stacks and Queues, go beyond just implementation — master the monotonic stack pattern which appears repeatedly in interviews. On the Python side, cover Sections 10–12: Decorators & Closures (critical for FastAPI dependency injection), Generators & Iterators (relevant for async FastAPI patterns), and Context Managers (used in FastAPI lifespan events). Then begin FastAPI: cover Sections 1–3 (Python Prerequisites, FastAPI Fundamentals, Routing & Project Structure). Build your first async FastAPI endpoint.',
        monthsHint: 'Months 7–12 (Month 7–8: Bit Manipulation & Stacks/Queues | Month 9–10: Python Advanced — Decorators, Generators, Context Managers | Month 11–12: FastAPI Fundamentals, Routing & First API)',
        tracks: [
          {
            name: 'A2Z DSA — Year 1 Completion',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 8–9: Bit Manipulation (Concepts & Problems) → Stack and Queues (Learning, Pre/In/Post-fix Conversion, Monotonic Stack, Implementation)',
          },
          {
            name: 'Python Advanced + FastAPI Foundations',
            roadmapId: ROADMAP_IDS.FASTAPI,
            icon: 'server',
            progressHint: 'Python (Sections 10–12): Decorators & Closures → Generators & Iterators → Context Managers & Exception Handling. FastAPI (Sections 1–3): Python Prerequisites (type hints, Pydantic intro) → FastAPI Fundamentals (async routes, path/query params, request body) → Routing & Project Structure (routers, dependencies, project layout)',
          },
        ],
      },
      {
        semester: 3,
        title: 'Semester 3: Advanced DSA & FastAPI Production Backend',
        description: 'Work through Trees, BSTs, and Graphs in DSA (Sections 13–15) — the most interview-critical topics. In parallel, build production-grade FastAPI: integrate SQLAlchemy + PostgreSQL with Alembic migrations (Section 4), add authentication with OAuth2 + JWT and role-based access control (Section 5), and cover validation, testing, and background tasks (Section 6). By semester end you should have a FastAPI application with a full auth system, database migrations, and at least one background worker — deploy it to Railway or Fly.io.',
        monthsHint: 'Months 13–18 (Month 13–14: Binary Trees & BSTs | Month 15–16: Graphs — BFS, DFS, Shortest Paths | Month 17–18: FastAPI with SQLAlchemy, Alembic, OAuth2/JWT & Background Tasks)',
        tracks: [
          {
            name: 'A2Z DSA — Year 2 Phase 1',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 13–15: Binary Trees (all traversals, LCA, diameter, boundary traversal) → Binary Search Trees (insertion, deletion, kth smallest, balanced BST) → Graphs (BFS, DFS, Topological Sort, Dijkstra, Bellman-Ford, Floyd-Warshall, MST with Kruskal & Prim, DSU)',
          },
          {
            name: 'FastAPI Production Backend',
            roadmapId: ROADMAP_IDS.FASTAPI,
            icon: 'server',
            progressHint: 'Complete Sections 4–6: Databases & ORMs (SQLAlchemy async, PostgreSQL, Alembic migrations, relationships) → Authentication & Security (OAuth2 Password Flow, JWT tokens, role-based access, password hashing with bcrypt) → Validation, Testing & Background Tasks (Pydantic validators, pytest, BackgroundTasks, Celery intro)',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: DSA Mastery & Full-Stack FastAPI Integration',
        description: 'Complete DSA with Sliding Window, Heaps, Greedy, DP (all patterns), and Tries (Sections 10–12, 16–17). DP is the hardest — budget at least 6 weeks. For FastAPI, cover Section 7 (FastAPI for AI/ML Serving: serving ML models, building inference endpoints, streaming responses) and Section 8 (Deployment: Docker, docker-compose, Gunicorn + Uvicorn, cloud deployment, monitoring with Prometheus). Build a full-stack project: React frontend consuming a FastAPI backend with JWT auth, PostgreSQL, and containerized via Docker. Deploy it live.',
        monthsHint: 'Months 19–24 (Month 19–20: Sliding Window, Heaps, Greedy | Month 21–22: DP All Patterns & Tries | Month 23–24: FastAPI Deployment, Docker & React Integration)',
        tracks: [
          {
            name: 'A2Z DSA — Completion',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10–12 & 16–17: Sliding Window & Two Pointers → Heaps → Greedy → Dynamic Programming (1D, 2D, DP on Stocks, Strings, LCS, MCM, Partition, Bitmask DP, DP on Trees & Graphs) → Tries',
          },
          {
            name: 'FastAPI Full-Stack & Deployment',
            roadmapId: ROADMAP_IDS.FASTAPI,
            icon: 'terminal',
            progressHint: 'Complete Sections 7–8: FastAPI for AI/ML Serving (model inference endpoints, streaming, async inference) → Deployment & Production (Docker + docker-compose, Gunicorn/Uvicorn, reverse proxy with Nginx, cloud deployment, health checks, monitoring). Frontend (FRONTEND Sections 1–6): React basics for consuming FastAPI endpoints.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: System Design & CP-31 Practice',
        description: 'Study system design with a Python async lens: understand how uvicorn and ASGI work, how Celery offloads background tasks, how Redis integrates for caching in async Python applications, and how to horizontally scale FastAPI services behind a load balancer. For HLD, study the standard distributed systems topics: consistent hashing, CAP theorem, database replication, message queues (Kafka vs RabbitMQ vs Celery), and microservices communication. Grind CP-31 from 800 to 1400 to strengthen OA performance.',
        monthsHint: 'Months 25–30 (Month 25–26: LLD Patterns & HLD — Async Python Systems | Month 27–28: HLD Case Studies & Microservices | Month 29–30: CP-31 Sheet 800→1400)',
        tracks: [
          {
            name: 'CP-31 Sheet',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 1–6: Rating 800 (Beginner Foundations) → 900 (Elementary Logic) → 1000 (Intermediate) → 1100 (Upper Intermediate) → 1200 (Advanced) → 1300–1400 (Expert Problems)',
          },
          {
            name: 'System Design — LLD & HLD',
            icon: 'brain',
            progressHint: 'LLD: SOLID Principles, Design Patterns in Python (Factory, Singleton, Observer, Strategy, Decorator), Practice Problems. HLD: ASGI/WSGI architecture, Celery + Redis task queues, PostgreSQL replication & sharding, Kafka message streaming, Microservices with FastAPI, Load Balancing, CDN, Case Studies (URL Shortener, Notification System, API Gateway)',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'Python-specific interview prep matters here: understand CPython internals (GIL, memory management, garbage collection), Python async model (asyncio event loop, coroutines vs threads), and FastAPI-specific questions (Pydantic validation, dependency injection, middleware). Run this alongside standard SDE interview prep: DSA mocks, system design discussions, and behavioral rounds. Polish your resume with the FastAPI project, Python GitHub contributions, and CP/LC ratings.',
        monthsHint: 'Months 31–36 (Month 31–33: Python Internals, DSA Mocks & System Design | Month 34–36: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2–3 LeetCode problems (Medium). Weekly: 2 mock coding rounds + 1 system design. Prep: Python internals Q&A (50 questions), FastAPI interview Q&A (50 questions), asyncio & concurrency concepts, SQLAlchemy ORM patterns, top 50 system design Q&A, Striver SDE Sheet revision, 1 live FastAPI project demo-ready',
          },
        ],
      },
    ],
  },

  2: {
    title: 'SDE + Python FastAPI — 5-Semester Journey',
    milestones: [
      {
        semester: 2,
        title: 'Semester 2: Python Essentials & Core DSA',
        description: 'Run Python and DSA in parallel from day one. Cover Python Sections 1–9 (syntax through OOP and magic methods) in 3 months while simultaneously tackling DSA Sections 1–9 (basics through stacks/queues). Every DSA problem should be written in Python — use list comprehensions, built-in sorting, and collections module to write idiomatic solutions. By Month 5, be comfortable solving medium-difficulty problems in Python under timed conditions.',
        monthsHint: 'Months 1–6 (Month 1–2: Python OOP, Collections & Data Structures | Month 3–4: DSA Arrays, Binary Search & Strings | Month 5–6: Linked List, Recursion, Stacks & Queues)',
        tracks: [
          {
            name: 'Python Basics',
            roadmapId: ROADMAP_IDS.PYTHON_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Introduction → Variables & Data Types → Control Flow → Functions → Built-in Data Structures (list, dict, set, tuple) → Comprehensions & Slicing → Strings → OOP → Magic/Dunder Methods',
          },
          {
            name: 'A2Z DSA — Year 1 Target',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Learn the Basics → Sorting → Arrays (Easy→Hard) → Binary Search → Strings → Linked List → Recursion → Bit Manipulation → Stack and Queues. All problems solved in Python.',
          },
        ],
      },
      {
        semester: 3,
        title: 'Semester 3: Advanced DSA & FastAPI Backend',
        description: 'Tackle Trees, BSTs, and Graphs in DSA (Sections 13–15). For FastAPI, cover the complete foundation through authentication (Sections 1–5): Python type hints and Pydantic, FastAPI routing and project structure, SQLAlchemy + PostgreSQL with Alembic migrations, and OAuth2/JWT auth. Build and deploy a FastAPI project with a real database and authentication. Cover Python Sections 10–12 (Decorators, Generators, Context Managers) as they are directly relevant to FastAPI DI patterns.',
        monthsHint: 'Months 7–12 (Month 7–8: Binary Trees & Graphs | Month 9–10: FastAPI Routing, SQLAlchemy & Alembic | Month 11–12: FastAPI Auth, Background Tasks & Deployed Project)',
        tracks: [
          {
            name: 'A2Z DSA — Advanced',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 11–15: Heaps → Greedy → Binary Trees (all traversals, LCA, diameter) → BSTs → Graphs (BFS, DFS, Topological Sort, Dijkstra, MST)',
          },
          {
            name: 'FastAPI Backend',
            roadmapId: ROADMAP_IDS.FASTAPI,
            icon: 'server',
            progressHint: 'Complete Sections 1–5: Python Prerequisites (type hints, Pydantic) → FastAPI Fundamentals (async routes, path/query params, request body) → Routing & Project Structure → Databases & ORMs (SQLAlchemy, PostgreSQL, Alembic) → Authentication & Security (OAuth2, JWT, bcrypt, RBAC). Project: deployed FastAPI app with auth.',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: DSA Completion & FastAPI Full Stack',
        description: 'Complete DSA: Sliding Window, DP all patterns, and Tries (Sections 10, 16–17). DP requires the most time — budget at least 6 weeks. Complete FastAPI through Sections 6–8: validation, testing, background tasks, Celery workers, Docker deployment, and production monitoring. Build and deploy a full-stack application: React frontend + FastAPI backend + PostgreSQL + Docker.',
        monthsHint: 'Months 13–18 (Month 13–14: Sliding Window, DP Patterns | Month 15–16: DP Advanced & Tries | Month 17–18: FastAPI Testing, Celery, Docker & Full-Stack Project)',
        tracks: [
          {
            name: 'A2Z DSA — Completion',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10 & 16–17: Sliding Window & Two Pointers → Dynamic Programming (1D, 2D, DP on Stocks, Strings, LCS, MCM, Partition, Bitmask, Trees, Graphs) → Tries',
          },
          {
            name: 'FastAPI Full-Stack',
            roadmapId: ROADMAP_IDS.FASTAPI,
            icon: 'terminal',
            progressHint: 'Complete Sections 6–8: Validation, Testing & Background Tasks (pytest, Pydantic validators, Celery) → FastAPI for AI/ML Serving → Deployment & Production (Docker, docker-compose, Nginx, cloud). Project: deployed React + FastAPI + PostgreSQL full-stack app.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: System Design & CP-31',
        description: 'Study LLD and HLD system design. Focus on Python-specific patterns: async Python architecture, Celery task queues, Redis caching in async contexts, and FastAPI microservices. Grind CP-31 from 800 to 1400. Study Python concurrency (asyncio, threading, multiprocessing) which is both an interview topic and a system design consideration.',
        monthsHint: 'Months 19–24 (Month 19–20: System Design LLD & HLD | Month 21–22: CP-31 800→1400 | Month 23–24: Python Concurrency & Async Architecture)',
        tracks: [
          {
            name: 'CP-31 Sheet',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 1–6: Rating 800 → 900 → 1000 → 1100 → 1200 → 1300–1400 (Expert Problems)',
          },
          {
            name: 'System Design',
            icon: 'brain',
            progressHint: 'LLD: SOLID Principles, Design Patterns in Python. HLD: Async Python architecture (ASGI, uvicorn), Celery + Redis queues, PostgreSQL replication, Kafka, Microservices. Case Studies: URL Shortener, Notification System, Rate Limiter. Python Concurrency: asyncio, threading vs multiprocessing, GIL implications.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'Python and FastAPI-focused interview prep combined with standard SDE preparation. Cover Python internals (GIL, asyncio, decorators, memory management), FastAPI patterns (dependency injection, middleware, Pydantic validation), and SQLAlchemy ORM questions. Run DSA revision under timed conditions and practice system design discussions.',
        monthsHint: 'Months 25–30 (Month 25–26: Python Internals & DSA Revision | Month 27–28: System Design Mocks & Resume | Month 29–30: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (Medium). Weekly: 2 mock coding + 1 system design. Targets: Python internals (50 Q), FastAPI Q&A (50 Q), asyncio patterns, top 30 system design questions, Striver SDE Sheet revision, 1 live FastAPI project demo-ready, resume with GitHub & CP ratings',
          },
        ],
      },
    ],
  },

  3: {
    title: 'SDE + Python FastAPI — Accelerated 4-Semester Journey',
    milestones: [
      {
        semester: 3,
        title: 'Semester 3: Python Essentials + DSA Sprint',
        description: 'Python Sections 1–9 in Month 1–2, then DSA Sections 1–9 running from Month 2–6 in parallel. Every DSA problem must be in Python — use Python\'s collections module (deque, Counter, defaultdict, heapq) to write faster, cleaner solutions. Target medium-level problem fluency in Python by Month 6.',
        monthsHint: 'Months 1–6 (Month 1–2: Python OOP & Data Structures | Month 3–4: DSA Arrays, Binary Search & Strings | Month 5–6: Linked List, Recursion, Bit Manipulation, Stacks & Queues)',
        tracks: [
          {
            name: 'Python Basics',
            roadmapId: ROADMAP_IDS.PYTHON_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Introduction → Variables & Types → Control Flow → Functions → Built-in Data Structures → Comprehensions → Strings → OOP → Magic Methods (prioritize OOP, data structures, and comprehensions for DSA efficiency)',
          },
          {
            name: 'A2Z DSA — Core',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Learn the Basics → Sorting → Arrays → Binary Search → Strings → Linked List → Recursion → Bit Manipulation → Stack and Queues. All in Python.',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: Advanced DSA & Full FastAPI Backend',
        description: 'Complete all remaining DSA (Sections 10–17: Heaps, Greedy, Sliding Window, Trees, Graphs, DP, Tries) over 3 months, prioritizing Trees and Graphs. Simultaneously build the full FastAPI stack (Sections 1–8): routing, SQLAlchemy, auth, testing, Celery background tasks, and Docker deployment. Build and deploy a FastAPI project with auth, database, and at least one background task. By semester end you should have a live project and all DSA sections completed.',
        monthsHint: 'Months 7–12 (Month 7–8: Heaps, Greedy & Trees | Month 9–10: Graphs, DP & FastAPI Sections 1–5 | Month 11–12: Tries, FastAPI Deployment & Docker)',
        tracks: [
          {
            name: 'A2Z DSA — Complete',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10–17: Sliding Window → Heaps → Greedy → Binary Trees → BSTs → Graphs → Dynamic Programming (all patterns) → Tries',
          },
          {
            name: 'FastAPI Backend — Full Track',
            roadmapId: ROADMAP_IDS.FASTAPI,
            icon: 'server',
            progressHint: 'Complete Sections 1–8: Python Prerequisites → FastAPI Fundamentals → Routing → Databases & ORMs (SQLAlchemy + Alembic) → Authentication (OAuth2/JWT) → Validation, Testing & Background Tasks (Celery) → FastAPI for AI/ML → Deployment (Docker, Nginx, cloud). Project: deployed FastAPI API with auth + Celery.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: System Design & CP-31',
        description: 'System design (LLD and HLD) and CP-31 practice. Add FRONTEND Sections 1–6 for React basics and build a full-stack FastAPI + React deployed application this semester if not done in Semester 4.',
        monthsHint: 'Months 13–18 (Month 13–14: System Design LLD & HLD | Month 15–16: CP-31 800→1200 | Month 17–18: Full-Stack React + FastAPI Project)',
        tracks: [
          {
            name: 'CP-31 Sheet',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 1–5: Rating 800 → 900 → 1000 → 1100 → 1200 (Advanced)',
          },
          {
            name: 'System Design',
            icon: 'brain',
            progressHint: 'LLD: SOLID Principles, Design Patterns in Python. HLD: ASGI architecture, Celery queues, Redis caching, PostgreSQL scaling, Case Studies. Full Stack: React (FRONTEND Sections 1–6) + FastAPI integration and deployment.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Sprint',
        description: 'Full placement execution: DSA revision, mock interviews, Python/FastAPI Q&A preparation, and application blitz. Keep one live FastAPI + React project ready to demo at any time.',
        monthsHint: 'Months 19–24 (Month 19–20: DSA Revision & OA Practice | Month 21–22: Mock Interviews & System Design | Month 23–24: Placements & Applications)',
        tracks: [
          {
            name: 'Placement Sprint',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems. Weekly: 2 mock coding + 1 system design. Targets: Python internals (50 Q), FastAPI Q&A (50 Q), top 30 system design cases, Striver SDE Sheet revision, 1 live deployed project, resume polished with GitHub & CP profile',
          },
        ],
      },
    ],
  },

  4: {
    title: 'SDE + Python FastAPI — Fast-Track 3-Semester Journey',
    milestones: [
      {
        semester: 4,
        title: 'Semester 4: Python + Core DSA + FastAPI Basics',
        description: 'Three simultaneous tracks from Month 1. Python Sections 1–9 (Month 1–2). DSA Sections 1–9 running from Month 2–4, all in Python. FastAPI Sections 1–5 running from Month 3–6 (fundamentals, routing, SQLAlchemy, auth). By Month 6 have a working deployed FastAPI API with auth.',
        monthsHint: 'Months 1–6 (Month 1–2: Python OOP & Fundamentals | Month 3–4: DSA Core & FastAPI Routing/DB | Month 5–6: DSA Completion & FastAPI Auth + Deployment)',
        tracks: [
          {
            name: 'Python & FastAPI Fundamentals',
            roadmapId: ROADMAP_IDS.FASTAPI,
            icon: 'code',
            progressHint: 'Python (Sections 1–9): Introduction through Magic Methods. FastAPI (Sections 1–5): Python Prerequisites → FastAPI Fundamentals → Routing & Project Structure → Databases & ORMs (SQLAlchemy + Alembic) → Authentication & Security (OAuth2/JWT)',
          },
          {
            name: 'A2Z DSA — Core Year 1',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Learn the Basics → Sorting → Arrays (Easy→Hard) → Binary Search → Strings → Linked List → Recursion → Bit Manipulation → Stack and Queues. All in Python.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: Advanced DSA & FastAPI Full-Stack Capstone',
        description: 'Complete all remaining DSA (Sections 10–17) with priority on Trees, Graphs, and DP. Finish FastAPI through deployment (Sections 6–8: testing, Celery, Docker). Build and deploy a full-stack React + FastAPI project as your capstone. Cover core system design concepts (LLD patterns, HLD fundamentals) in the last month.',
        monthsHint: 'Months 7–12 (Month 7–8: Trees, Graphs & Heaps | Month 9–10: DP, Tries & FastAPI Testing/Docker | Month 11–12: Capstone Project & System Design Intro)',
        tracks: [
          {
            name: 'A2Z DSA — Advanced',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10–17: Sliding Window → Heaps → Greedy → Binary Trees → BSTs → Graphs → Dynamic Programming (all patterns) → Tries',
          },
          {
            name: 'FastAPI Full-Stack Project',
            roadmapId: ROADMAP_IDS.FASTAPI,
            icon: 'terminal',
            progressHint: 'Complete Sections 6–8: Validation & Testing (pytest, Pydantic validators) → Background Tasks (Celery + Redis) → Deployment (Docker, docker-compose, Nginx, cloud). Full-Stack Capstone: React + FastAPI + PostgreSQL deployed app with auth, background tasks, and documentation.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'Surgical placement prep. Identify target companies, research their interview patterns, and focus preparation accordingly. DSA revision under timed pressure. Python/FastAPI Q&A. System design mock discussions. Application blitz in last 2 months.',
        monthsHint: 'Months 13–18 (Month 13–14: DSA Revision & OA Practice | Month 15–16: Mock Interviews & System Design | Month 17–18: Applications & Campus Drives)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (Medium). Weekly: 2 mock coding + 1 system design. Targets: Python internals (50 Q), FastAPI Q&A (50 Q), top 30 system design cases, top 100 interview problems revision, 1 live deployed project, resume with GitHub & CP profiles',
          },
        ],
      },
    ],
  },

  5: {
    title: 'SDE + Python FastAPI — Crash Course 2-Semester Journey',
    milestones: [
      {
        semester: 5,
        title: 'Semester 5: High-Yield DSA & FastAPI Project Sprint',
        description: 'Skip breadth, focus on yield. High-frequency DSA patterns only: Arrays, Binary Search, Two Pointers, Sliding Window, Trees, Graphs, 1D/2D DP, Stacks. All in Python. For FastAPI, go directly to building — skip theory-heavy ramp-up and use FastAPI\'s documentation + a starter template. Build a complete deployed API with SQLAlchemy, Alembic, JWT auth, and basic Celery task. This project must be on GitHub with a proper README by Month 5.',
        monthsHint: 'Months 1–6 (Month 1–2: High-Yield DSA Arrays, Trees, Graphs | Month 3–4: DP, Stacks & Binary Search | Month 5–6: FastAPI Project Build, Polish & Deploy)',
        tracks: [
          {
            name: 'Python & High-Yield DSA',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Priority Sections — 1–5, 9, 13–16: Basics → Arrays (all difficulties) → Binary Search → Strings → Stack and Queues → Binary Trees → BSTs → Graphs → Dynamic Programming. All in Python. Use Striver\'s Top 79 as a checklist. Leverage Python\'s collections (deque, heapq, Counter, defaultdict) for clean solutions.',
          },
          {
            name: 'FastAPI Quick Project',
            roadmapId: ROADMAP_IDS.FASTAPI,
            icon: 'server',
            progressHint: 'Fast-track Sections 1–8: Python type hints & Pydantic → FastAPI async routes → SQLAlchemy + Alembic → OAuth2/JWT auth → Testing → Docker deployment. Project: a deployed FastAPI application (e.g., Task Manager API, URL Shortener, or E-commerce Backend) with auth, database, and a Postman/OpenAPI documentation link.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: All-In Placement Sprint',
        description: 'Execution only. OA grinding, mock interview marathon, and application blitz. Prepare Python internals and FastAPI Q&A alongside DSA revision. Keep your project live and demo-ready.',
        monthsHint: 'Months 7–12 (Month 7–8: OA Grinding & Company Patterns | Month 9–10: Mock Interviews & Resume Polish | Month 11–12: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Placement Sprint',
            icon: 'book',
            progressHint: 'Daily: 3 LeetCode problems (Medium/Hard). Weekly: 3 mock interviews. Targets: LeetCode 150 completion, Python internals Q&A (50), FastAPI Q&A (50), top 30 system design questions, 1 live deployed FastAPI project with docs, resume with GitHub & LC/CF profiles, company-specific preparation for top 5 targets',
          },
        ],
      },
    ],
  },
};

// ═══════════════════════════════════════════════════════
//  SDE → CPP
// ═══════════════════════════════════════════════════════

const sdeCpp: Record<number, JourneyConfig> = {
  1: {
    title: 'SDE + C++ Systems — Full 6-Semester Journey',
    milestones: [
      {
        semester: 1,
        title: 'Semester 1: C++ Language Core & Introductory DSA',
        description: 'C++ is powerful but unforgiving — invest deeply in understanding the language model before DSA. Cover Sections 1–9: C++ syntax, variables, data types, memory model (stack vs heap), control flow, functions with references and const, raw pointers, smart pointers (unique_ptr, shared_ptr, weak_ptr), and basic OOP (classes, constructors, destructors). Understanding pointers and RAII from the start prevents memory bug headaches later. Alongside, begin DSA Sections 1–7: basics, sorting, arrays, binary search, strings, linked lists, and recursion — all implemented in C++ to reinforce pointer semantics and STL usage.',
        monthsHint: 'Months 1–6 (Month 1–2: C++ Syntax, Pointers, Memory Model & Smart Pointers | Month 3–4: OOP — Classes, Constructors, Inheritance | Month 5–6: DSA Arrays, Binary Search, Strings & Recursion)',
        tracks: [
          {
            name: 'C++ Programming Basics',
            roadmapId: ROADMAP_IDS.CPP_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Introduction → Variables & Data Types & Memory Model → Control Flow & Operators → Functions & References → Pointers and Raw Memory → Smart Pointers & Memory Safety → Classes and Objects → Constructors & Destructors → Inheritance Mechanics',
          },
          {
            name: 'A2Z DSA — Year 1 Phase 1',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–7: Learn the Basics → Sorting Techniques → Arrays (Easy→Hard) → Binary Search → Strings → Linked List → Recursion (PatternWise). All problems implemented in C++ using STL.',
          },
        ],
      },
      {
        semester: 2,
        title: 'Semester 2: C++ Advanced OOP & Core Data Structures',
        description: 'Deepen C++ mastery with the most interview-critical language features: polymorphism and virtual functions, operator overloading with the copy-swap idiom, move semantics and rvalue references (understand when copy constructors vs move constructors are called), and templates for generic programming (Sections 10–15). Mastery of move semantics alone is a major differentiator in C++ interviews. On the DSA side, complete Year 1: Bit Manipulation and Stacks/Queues including the complex monotonic stack problems (Sections 8–9). Cover STL Containers and Algorithms (Sections 14–15) in depth — you will use these constantly.',
        monthsHint: 'Months 7–12 (Month 7–8: Polymorphism, Operator Overloading & Move Semantics | Month 9–10: Templates, STL Containers & Algorithms | Month 11–12: DSA Bit Manipulation & Stacks/Queues)',
        tracks: [
          {
            name: 'C++ Advanced OOP & STL',
            roadmapId: ROADMAP_IDS.CPP_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 10–15: Polymorphism & Virtual Functions → Operator Overloading & Copy-Swap Idiom → Move Semantics & Rvalue References → Templates & Generic Programming → STL Containers In-Depth → STL Iterators & Algorithms',
          },
          {
            name: 'A2Z DSA — Year 1 Completion',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 8–9: Bit Manipulation (Concepts & Problems) → Stack and Queues (Learning, Pre/In/Post-fix Conversion, Monotonic Stack, Implementation problems)',
          },
        ],
      },
      {
        semester: 3,
        title: 'Semester 3: Modern C++, Multithreading & Advanced DSA',
        description: 'Cover the remaining C++ sections: Modern C++ essentials (auto, range-for, structured bindings, std::optional, std::variant), RAII and exception safety guarantees, multithreading with std::thread, mutexes, condition variables, std::atomic, and memory ordering (Sections 16–19). C++ concurrency is a key differentiator for systems roles. On DSA, tackle Trees, BSTs, and Graphs (Sections 13–15) — implement graph algorithms from scratch in C++ using adjacency lists and STL queues/priority_queues.',
        monthsHint: 'Months 13–18 (Month 13–14: Modern C++, RAII & Exception Safety | Month 15–16: Multithreading, std::thread, Mutexes & Memory Ordering | Month 17–18: DSA Trees, BSTs & Graphs)',
        tracks: [
          {
            name: 'C++ Modern Features & Concurrency',
            roadmapId: ROADMAP_IDS.CPP_BASICS,
            icon: 'server',
            progressHint: 'Complete Sections 16–19: Strings and String View → Modern C++ Essentials (auto, range-for, std::optional, std::variant, structured bindings) → RAII & Exception Handling (exception safety guarantees, noexcept) → Multithreading & Concurrency (std::thread, std::mutex, condition_variable, std::atomic, memory ordering)',
          },
          {
            name: 'A2Z DSA — Year 2 Phase 1',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 13–15: Binary Trees (all traversals, LCA, diameter, views) → BSTs (insert, delete, kth smallest) → Graphs (BFS, DFS, Topological Sort, Dijkstra, Bellman-Ford, Floyd-Warshall, MST — all implemented in C++ with STL)',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: DSA Mastery & C++ Systems Capstone',
        description: 'Finish DSA with Sliding Window, Heaps, Greedy, DP, and Tries (Sections 10–12, 16–17). DP is critical — budget extra time. For the systems capstone (Section 20: Compilation, Preprocessor & CMake), learn how to structure a multi-file C++ project with CMake, understand header vs implementation files, and build one of: a custom HTTP server (using POSIX sockets), a simple in-memory key-value store (like a mini Redis), or a lock-free data structure. This capstone is what separates systems developers from pure DSA solvers in C++ interviews.',
        monthsHint: 'Months 19–24 (Month 19–20: Heaps, Greedy & Sliding Window | Month 21–22: DP All Patterns & Tries | Month 23–24: CMake, C++ Project Architecture & Systems Capstone)',
        tracks: [
          {
            name: 'A2Z DSA — Completion',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10–12 & 16–17: Sliding Window & Two Pointers → Heaps → Greedy → Dynamic Programming (1D, 2D, DP on Stocks, Strings, LCS, MCM, Bitmask DP, DP on Trees & Graphs) → Tries',
          },
          {
            name: 'C++ Systems Capstone',
            roadmapId: ROADMAP_IDS.CPP_BASICS,
            icon: 'terminal',
            progressHint: 'Complete Section 20: Compilation, Preprocessor & CMake. Build a high-performance C++ project: options include (a) Multithreaded HTTP Server using POSIX sockets & thread pool, (b) In-Memory Key-Value Store with LRU cache, (c) Lock-Free Queue using std::atomic, or (d) Custom Memory Allocator. Must include: CMake build system, unit tests with GoogleTest, README with architecture explanation.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: System Design & CP-31 Practice',
        description: 'Study LLD with a C++ focus: design patterns in C++ (CRTP for static polymorphism, PIMPL idiom, type erasure, policy-based design). For HLD, cover distributed systems topics relevant to systems roles: memory allocators, cache hierarchies, NUMA-aware programming, lock-free data structures, and network programming. Grind CP-31 from 800 to 1400 — C++ is the fastest language for competitive programming and gives you a significant speed advantage.',
        monthsHint: 'Months 25–30 (Month 25–26: LLD Design Patterns in C++ & Low-Level Optimization | Month 27–28: HLD — Distributed Systems & Memory Architecture | Month 29–30: CP-31 800→1400)',
        tracks: [
          {
            name: 'CP-31 Sheet',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 1–6: Rating 800 → 900 → 1000 → 1100 → 1200 → 1300–1400. C++ with fast I/O (ios_base::sync_with_stdio(false), cin.tie(NULL)) and STL mastery (priority_queue, map, set, unordered_map).',
          },
          {
            name: 'System Design & LLD in C++',
            icon: 'brain',
            progressHint: 'LLD: SOLID Principles, C++ Design Patterns (CRTP, PIMPL, Type Erasure, Policy-Based), Memory Optimization techniques. HLD: Memory Hierarchy & Cache Optimization, Lock-Free Programming, POSIX Sockets & Network Programming, Distributed Memory Architectures, Case Studies (Custom Allocator, Thread Pool, In-Memory DB)',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'C++ SDE interviews are deep — prepare OS concepts (process vs thread, scheduling, virtual memory, page faults), DBMS fundamentals, network programming basics, and C++-specific questions (vtable, undefined behavior, copy vs move, ABI, ODR violations). Run alongside standard DSA mocks and system design discussions. Target companies hiring C++ SDE roles: trading firms, game studios, systems software companies, and infrastructure teams.',
        monthsHint: 'Months 31–36 (Month 31–33: C++ Internals, OS/DBMS Revision & DSA Mocks | Month 34–36: Campus Drives & Targeted Applications)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2–3 LeetCode problems (Medium/Hard, solved in C++). Weekly: 2 mock coding + 1 system design. Prep: C++ internals Q&A (100 Q — vtable, memory model, UB, ABI), OS concepts (scheduling, virtual memory, IPC), DBMS fundamentals, top 50 system design Q&A, Striver SDE Sheet revision, C++ systems project demo-ready, CF rating highlighted on resume',
          },
        ],
      },
    ],
  },

  2: {
    title: 'SDE + C++ — 5-Semester Journey',
    milestones: [
      {
        semester: 2,
        title: 'Semester 2: C++ Core & DSA Foundation',
        description: 'C++ Sections 1–12 (syntax, pointers, smart pointers, OOP, move semantics, templates, STL) in 3 months. DSA Sections 1–9 (basics through stacks/queues) in parallel. All DSA in C++ with STL. Target medium-level DSA comfort by Month 6.',
        monthsHint: 'Months 1–6 (Month 1–2: C++ Pointers, OOP & Smart Pointers | Month 3–4: STL, Templates & DSA Arrays→Strings | Month 5–6: Move Semantics, DSA Linked List, Recursion, Stacks & Queues)',
        tracks: [
          {
            name: 'C++ Basics',
            roadmapId: ROADMAP_IDS.CPP_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–12: Introduction → Variables & Memory → Control Flow → Functions & References → Pointers → Smart Pointers → OOP (Classes, Constructors, Inheritance, Polymorphism) → Operator Overloading → Move Semantics → Templates → STL Containers → STL Iterators & Algorithms',
          },
          {
            name: 'A2Z DSA — Core',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Learn the Basics → Sorting → Arrays → Binary Search → Strings → Linked List → Recursion → Bit Manipulation → Stack and Queues. All in C++ with STL.',
          },
        ],
      },
      {
        semester: 3,
        title: 'Semester 3: Modern C++, Concurrency & Advanced DSA',
        description: 'C++ Sections 16–19: Modern C++ features, RAII, and multithreading. DSA Sections 11–15: Heaps, Greedy, Trees, BSTs, and Graphs. Build a small multithreaded C++ utility as a practice project.',
        monthsHint: 'Months 7–12 (Month 7–8: Modern C++ & Multithreading | Month 9–10: DSA Trees & BSTs | Month 11–12: Graphs & BFS/DFS/Shortest Paths)',
        tracks: [
          {
            name: 'C++ Advanced',
            roadmapId: ROADMAP_IDS.CPP_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 16–19: Strings & String View → Modern C++ (auto, std::optional, structured bindings) → RAII & Exception Handling → Multithreading & Concurrency (std::thread, mutex, condition_variable, std::atomic)',
          },
          {
            name: 'A2Z DSA — Advanced Phase 1',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 11–15: Heaps (Learning, Medium, Hard) → Greedy → Binary Trees (all traversals, LCA) → BSTs → Graphs (BFS, DFS, Topological Sort, Dijkstra, MST)',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: DSA Completion & C++ Systems Project',
        description: 'Finish DSA: Sliding Window, DP all patterns, Tries (Sections 10, 16–17). Build a production-quality C++ systems project using CMake (Section 20): choose from a multithreaded HTTP server, in-memory key-value store, or custom memory allocator. Deploy or publish on GitHub with documentation.',
        monthsHint: 'Months 13–18 (Month 13–14: Sliding Window, DP Patterns | Month 15–16: DP Advanced & Tries | Month 17–18: CMake, C++ Project Build & Testing)',
        tracks: [
          {
            name: 'A2Z DSA — Completion',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10 & 16–17: Sliding Window & Two Pointers → Dynamic Programming (all patterns: 1D, 2D, Bitmask, Trees, Graphs) → Tries',
          },
          {
            name: 'C++ Systems Project',
            roadmapId: ROADMAP_IDS.CPP_BASICS,
            icon: 'terminal',
            progressHint: 'Complete Section 20: Compilation, Preprocessor & CMake. Build: Multithreaded C++ application (HTTP Server / KV Store / Lock-Free Queue / Custom Allocator) with CMake build system, GoogleTest unit tests, and GitHub README.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: System Design & CP-31',
        description: 'Study LLD (C++ design patterns) and HLD (distributed systems). Grind CP-31 from 800 to 1400 in C++ — use fast I/O and STL expertise for speed advantage.',
        monthsHint: 'Months 19–24 (Month 19–20: LLD & HLD System Design | Month 21–22: CP-31 800→1400 | Month 23–24: OS/DBMS Concepts for Interviews)',
        tracks: [
          {
            name: 'CP-31 Sheet',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 1–6: Rating 800 → 900 → 1000 → 1100 → 1200 → 1300–1400. Use C++ with fast I/O and STL (priority_queue, set, map, unordered_map).',
          },
          {
            name: 'System Design',
            icon: 'brain',
            progressHint: 'LLD: SOLID Principles, C++ Design Patterns (CRTP, PIMPL, Type Erasure). HLD: Memory Hierarchy, Lock-Free Data Structures, Network Programming, Distributed Systems basics. OS Concepts: Process/Thread, Scheduling, Virtual Memory, IPC. DBMS: Transactions, Indexing, Query Optimization.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'C++ interview prep (vtable, move semantics, UB, ABI, template specialization) plus OS/DBMS fundamentals. DSA mocks in C++. System design discussions. Target systems-focused companies.',
        monthsHint: 'Months 25–30 (Month 25–26: C++ Internals & OS/DBMS Review | Month 27–28: Mock Interviews & System Design | Month 29–30: Placements & Applications)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (C++). Weekly: 2 mock coding + 1 system design. Prep: C++ internals Q&A (100 Q), OS concepts, DBMS fundamentals, top 30 system design questions, C++ project demo-ready, CF rating on resume',
          },
        ],
      },
    ],
  },

  3: {
    title: 'SDE + C++ — Accelerated 4-Semester Journey',
    milestones: [
      {
        semester: 3,
        title: 'Semester 3: C++ Core + DSA Sprint',
        description: 'C++ Sections 1–12 (pointers through STL) in 2 months. DSA Sections 1–9 in parallel, all in C++. Target medium DSA comfort and STL fluency by Month 6.',
        monthsHint: 'Months 1–6 (Month 1–2: C++ Pointers, OOP, Smart Pointers | Month 3–4: STL, Templates & DSA Arrays→Strings | Month 5–6: DSA Linked List, Recursion, Stacks & Queues)',
        tracks: [
          {
            name: 'C++ Core',
            roadmapId: ROADMAP_IDS.CPP_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–12: Introduction through STL Containers & Algorithms (prioritize Sections 5–6 for pointers/smart pointers and Section 14–15 for STL mastery)',
          },
          {
            name: 'A2Z DSA — Core',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Learn the Basics → Sorting → Arrays → Binary Search → Strings → Linked List → Recursion → Bit Manipulation → Stack and Queues. All in C++ with STL.',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: Advanced DSA, C++ Concurrency & Systems',
        description: 'Finish all DSA sections (10–17: Heaps, Greedy, Trees, Graphs, DP, Tries). Cover C++ Sections 16–20 (Modern C++, RAII, Multithreading, CMake). Build a C++ systems project (HTTP server or KV store) with CMake and multithreading.',
        monthsHint: 'Months 7–12 (Month 7–8: Trees, Graphs & Modern C++ | Month 9–10: DP, Tries & Multithreading | Month 11–12: CMake & C++ Systems Project)',
        tracks: [
          {
            name: 'A2Z DSA — Complete',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10–17: Sliding Window → Heaps → Greedy → Binary Trees → BSTs → Graphs → Dynamic Programming (all patterns) → Tries',
          },
          {
            name: 'C++ Modern & Systems',
            roadmapId: ROADMAP_IDS.CPP_BASICS,
            icon: 'server',
            progressHint: 'Complete Sections 16–20: Modern C++ → RAII & Exception Safety → Multithreading & Concurrency → Compilation & CMake. Project: C++ application (multithreaded HTTP server or in-memory KV store) with CMake build and unit tests.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: System Design & CP-31',
        description: 'LLD patterns in C++, HLD distributed systems fundamentals, and CP-31 grinding from 800 to 1200 in C++.',
        monthsHint: 'Months 13–18 (Month 13–14: System Design LLD & HLD | Month 15–16: CP-31 800→1200 | Month 17–18: OS/DBMS Concepts)',
        tracks: [
          {
            name: 'CP-31 Sheet',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 1–5: Rating 800 → 900 → 1000 → 1100 → 1200. All solutions in C++ with fast I/O.',
          },
          {
            name: 'System Design',
            icon: 'brain',
            progressHint: 'LLD: SOLID Principles, C++ Design Patterns. HLD: Memory Hierarchy, Distributed Systems, Network Programming. OS: Process/Thread, Virtual Memory, Scheduling. DBMS: Transactions, Indexing.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Sprint',
        description: 'C++ internals prep, DSA mocks in C++, system design discussions, and application blitz.',
        monthsHint: 'Months 19–24 (Month 19–20: C++ Internals & DSA Revision | Month 21–22: Mock Interviews & System Design | Month 23–24: Placements & Applications)',
        tracks: [
          {
            name: 'Placement Sprint',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (C++). Weekly: 2 mock coding + 1 system design. Targets: C++ internals (100 Q), OS/DBMS concepts, top 30 system design Q&A, C++ project on GitHub, CF rating on resume',
          },
        ],
      },
    ],
  },

  4: {
    title: 'SDE + C++ — Fast-Track 3-Semester Journey',
    milestones: [
      {
        semester: 4,
        title: 'Semester 4: C++ Crash Course + Core DSA',
        description: 'C++ Sections 1–12 (Month 1–2) and DSA Sections 1–9 simultaneously (Month 2–4), all in C++. Cover basic STL for DSA efficiency. By Month 6, have medium DSA comfort and understand pointers, OOP, and STL well.',
        monthsHint: 'Months 1–6 (Month 1–2: C++ Pointers, OOP, Smart Pointers & STL | Month 3–4: DSA Arrays, Binary Search, Strings | Month 5–6: DSA Linked List, Recursion, Bit Manipulation, Stacks & Queues)',
        tracks: [
          {
            name: 'C++ & DSA Core',
            roadmapId: ROADMAP_IDS.CPP_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–12: Introduction → Memory Model → OOP (Classes through Polymorphism) → Move Semantics → Templates → STL Containers & Algorithms. Focus on practical STL usage for DSA.',
          },
          {
            name: 'A2Z DSA — Core',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Learn the Basics → Sorting → Arrays → Binary Search → Strings → Linked List → Recursion → Bit Manipulation → Stack and Queues. All in C++ with STL.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: Advanced DSA + CP-31 & Systems',
        description: 'Complete DSA Sections 10–17 (all advanced topics) and grind CP-31 Sections 1–5 (800→1200). Cover C++ Sections 16–20 (Modern C++, concurrency, CMake) and build a small systems project.',
        monthsHint: 'Months 7–12 (Month 7–8: Trees, Graphs & Modern C++ | Month 9–10: DP, Tries & CP-31 800→1000 | Month 11–12: C++ Concurrency, CMake & Systems Project)',
        tracks: [
          {
            name: 'A2Z DSA + CP-31',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'DSA Sections 10–17: Sliding Window → Heaps → Greedy → Binary Trees → BSTs → Graphs → DP → Tries. CP-31 Sections 1–5: Rating 800→1200.',
          },
          {
            name: 'C++ Advanced & Systems',
            roadmapId: ROADMAP_IDS.CPP_BASICS,
            icon: 'terminal',
            progressHint: 'Complete Sections 16–20: Modern C++ → RAII → Multithreading → CMake. Build: small multithreaded C++ project (e.g., thread pool or lock-free queue) with CMake and GoogleTest.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'C++ interview prep (internals, OS, DBMS), DSA mocks in C++, system design discussions, and campus drives.',
        monthsHint: 'Months 13–18 (Month 13–14: C++ Internals, OS & DBMS Revision | Month 15–16: Mock Interviews & System Design | Month 17–18: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (C++). Weekly: 2 mock coding + 1 system design. Targets: C++ internals (100 Q), OS/DBMS concepts, top 30 system design cases, C++ project on GitHub, CF rating on resume',
          },
        ],
      },
    ],
  },

  5: {
    title: 'SDE + C++ — Crash Course 2-Semester Journey',
    milestones: [
      {
        semester: 5,
        title: 'Semester 5: C++ & DSA High-Yield Sprint',
        description: 'Focus on highest-yield areas only. C++ Sections 1–9 and 14–15 (core language + STL) in Month 1–2. DSA high-frequency patterns (Arrays, Binary Search, Trees, Graphs, DP, Stacks) in Month 2–4. CP-31 Sections 1–4 (800→1100) in Month 5–6. Build no major project this semester — focus entirely on problem-solving speed and accuracy.',
        monthsHint: 'Months 1–6 (Month 1–2: C++ Core & STL Mastery | Month 3–4: High-Yield DSA in C++ | Month 5–6: CP-31 800→1100)',
        tracks: [
          {
            name: 'C++ Core & High-Yield DSA',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'C++ Sections 1–9 & 14–15: Core language + STL mastery. DSA Priority Sections — 1–5, 9, 13–16: Basics → Arrays → Binary Search → Strings → Stack/Queues → Trees → Graphs → DP. All in C++ with STL. CP-31 Sections 1–4: Rating 800→1100.',
          },
          {
            name: 'CP-31 Sheet Sprint',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 1–4: Rating 800 (Beginner Foundations) → 900 (Elementary Logic) → 1000 (Intermediate) → 1100 (Upper Intermediate). Solve in C++ with fast I/O.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Sprint',
        description: 'OA grinding (C++ speed advantage), mock interviews, C++ internals prep, and campus drives.',
        monthsHint: 'Months 7–12 (Month 7–8: OA Grinding & Company Patterns | Month 9–10: Mock Interviews & C++ Internals | Month 11–12: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Placement Sprint',
            icon: 'book',
            progressHint: 'Daily: 3 LeetCode problems (C++). Weekly: 3 mock interviews. Targets: C++ internals Q&A (100 Q), OS concepts, top 30 system design Q&A, LeetCode 150 completion, CF profile on resume, company-specific preparation for target companies',
          },
        ],
      },
    ],
  },
};

// ═══════════════════════════════════════════════════════
//  SDE → CP
// ═══════════════════════════════════════════════════════

const sdeCp: Record<number, JourneyConfig> = {
  1: {
    title: 'SDE + Competitive Programming (CP-31) — Full 6-Semester Journey',
    milestones: [
      {
        semester: 1,
        title: 'Semester 1: C++ for CP & Introductory DSA',
        description: 'Competitive programming in C++ is fundamentally different from general software development — you need to optimize for speed of both coding and execution. Start with CP-specific C++ setup: fast I/O (ios_base::sync_with_stdio(false), cin.tie(NULL)), STL mastery (sort, lower_bound, priority_queue, set, map, unordered_map, bitset), and common templates (pair, tuple, auto). Then begin CP-31 Section 1 (Rating 800 problems) to build pattern recognition on the easiest Codeforces problems. Simultaneously, start DSA Sections 1–7 to build your algorithmic foundation. Register on Codeforces and participate in Div. 3 contests from Month 2 onwards.',
        monthsHint: 'Months 1–6 (Month 1–2: C++ Fast I/O, STL Mastery & CP Templates | Month 3–4: CP-31 Rating 800 & DSA Arrays/Sorting | Month 5–6: DSA Binary Search, Strings, Recursion & CP-31 Rating 800 Completion)',
        tracks: [
          {
            name: 'CP-31 Sheet — 800 Rating',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Section 1: Rating 800 — Beginner Foundations. Solve all problems. Set up: Codeforces account, competitive C++ template (fast I/O, STL macros), local judge setup. Participate in minimum 2 Codeforces Div.3/Div.4 contests per month.',
          },
          {
            name: 'A2Z DSA — Year 1 Phase 1',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–7: Learn the Basics → Sorting Techniques → Arrays (Easy→Hard) → Binary Search (1D, 2D, Search Space) → Strings (Basic & Medium) → Linked List → Recursion (PatternWise). All in C++.',
          },
        ],
      },
      {
        semester: 2,
        title: 'Semester 2: Core DSA Patterns & CP-31 900–1000',
        description: 'Complete Year 1 DSA: Bit Manipulation (master bitmask tricks used in CP: checking bits, setting/unsetting, XOR properties) and Stacks/Queues including monotonic stacks (Sections 8–9). Grind CP-31 Sections 2–3 (900–1000 rating): these problems introduce prefix sums, two pointers, basic greedy, and simple math. Participate in weekly Codeforces contests and track your rating progress. At 1000 rating, you should be solving A and B problems in contests reliably.',
        monthsHint: 'Months 7–12 (Month 7–8: DSA Bit Manipulation & Stacks/Queues | Month 9–10: CP-31 Rating 900 Problems — Prefix Sums & Greedy | Month 11–12: CP-31 Rating 1000 — Two Pointers & Math)',
        tracks: [
          {
            name: 'A2Z DSA — Year 1 Completion',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 8–9: Bit Manipulation (bitmask tricks: XOR properties, checking/setting/unsetting bits, power of 2 checks) → Stack and Queues (including monotonic stack: next greater element, largest rectangle in histogram)',
          },
          {
            name: 'CP-31 Sheet — 900–1000 Rating',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 2–3: Rating 900 (Elementary Logic — conditionals, simple loops, basic math) → Rating 1000 (Intermediate — prefix sums, two pointers, basic greedy, simple observations). Contest goal: solve A+B reliably in Div.3 contests.',
          },
        ],
      },
      {
        semester: 3,
        title: 'Semester 3: Advanced DSA & CP-31 1100–1200',
        description: 'Cover Trees (all traversals, LCA, diameter, segment tree intro), BSTs, Graphs (BFS, DFS, Topological Sort, Dijkstra, Floyd-Warshall, MST, Disjoint Set Union), and the CP-critical Segment Tree and Fenwick Tree (BIT) data structures (Sections 13–15). Grind CP-31 Sections 4–5 (1100–1200 rating): these problems require BFS/DFS graph traversal, binary search on answer, and DSU. At 1200 rating, you should be solving A, B, and occasionally C problems in Div.2 contests.',
        monthsHint: 'Months 13–18 (Month 13–14: Binary Trees, BSTs & Segment Trees/BIT | Month 15–16: Graphs — BFS, DFS, Dijkstra, Floyd-Warshall, DSU | Month 17–18: CP-31 Rating 1100–1200 Grinding)',
        tracks: [
          {
            name: 'A2Z DSA — Trees & Graphs',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 13–15: Binary Trees (traversals, LCA, diameter, views, serialize/deserialize) → BSTs (insert, delete, kth smallest, balanced BST) → Graphs (BFS, DFS, Topological Sort, Dijkstra, Bellman-Ford, Floyd-Warshall, MST — Kruskal & Prim, DSU with path compression & union by rank)',
          },
          {
            name: 'CP-31 Sheet — 1100–1200 Rating',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 4–5: Rating 1100 (Upper Intermediate — BFS/DFS graphs, binary search on answer, sorting + observation, DSU intro) → Rating 1200 (Advanced — graph problems, binary search, basic DP, bitwise tricks). Contest goal: solve A+B+C in Div.2, occasionally D.',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: DP Mastery & CP-31 1300–1400',
        description: 'Master Dynamic Programming: all standard patterns (1D DP, 2D DP, DP on strings, DP on trees, DP on graphs, Bitmask DP, Digit DP) and Tries (Sections 16–17). These are exactly the topics tested in CP-31 Sections 6 and Div.1 C/D level problems. Grind CP-31 Section 6 (1300–1400 rating): these problems require multi-level reasoning — combining DP with binary search, or graph algorithms with DP. At 1400 rating, you should be a Codeforces Expert.',
        monthsHint: 'Months 19–24 (Month 19–20: DP Foundations — 1D, 2D, LCS, Knapsack | Month 21–22: Advanced DP — Bitmask, Digit DP, Tree DP, DP on Graphs | Month 23–24: CP-31 Rating 1300–1400 Grinding)',
        tracks: [
          {
            name: 'A2Z DSA — DP & Tries',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10–12 & 16–17: Sliding Window & Two Pointers → Heaps → Greedy → Dynamic Programming (1D, 2D, DP on Stocks, DP on Strings, LCS patterns, MCM, Partition, Bitmask DP, Digit DP, DP on Trees, DP on Graphs) → Tries',
          },
          {
            name: 'CP-31 Sheet — 1300–1400 Rating',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Section 6: Rating 1300–1400 (Expert Problems — multi-step reasoning, DP + binary search combinations, complex graph + DP, Bitmask DP, constructive algorithms, number theory basics). Contest goal: Expert rating on Codeforces (1400+), solving Div.2 A-C reliably and D occasionally.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: Advanced CP Topics & 1500–1800+ Problems',
        description: 'Now tackle the truly hard CP topics: Number Theory (Sieve of Eratosthenes, modular arithmetic, modular inverse, CRT, Euler\'s totient), Fenwick Trees and Segment Trees with lazy propagation for range queries, Maximum Flow and Minimum Cut algorithms (Dinic\'s, Ford-Fulkerson), Game Theory (Sprague-Grundy theorem), and String algorithms (KMP, Z-algorithm, Suffix Arrays, Aho-Corasick). Grind CP-31 Sections 7–8 (1500–1800+ rating). Also cover system design basics so you are not entirely blind to SDE interview expectations.',
        monthsHint: 'Months 25–30 (Month 25–26: Number Theory, Segment Trees (Lazy), Fenwick Trees | Month 27–28: Max Flow, Game Theory & String Algorithms | Month 29–30: CP-31 Rating 1500–1800+ Grinding)',
        tracks: [
          {
            name: 'CP-31 Sheet — 1500–1800+ Rating',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 7–8: Rating 1500–1600 (Master Problems — Segment Tree with lazy propagation, number theory, advanced graph algorithms, suffix structures) → Rating 1700+ (Elite Problems — Max Flow, Matroid intersection, advanced combinatorics, game theory). Contest goal: Codeforces Master rating (1800+).',
          },
          {
            name: 'System Design — SDE Basics',
            icon: 'brain',
            progressHint: 'Cover core LLD (SOLID principles, 5 key design patterns) and HLD basics (scalability, load balancing, caching with Redis, database fundamentals). This ensures you can handle SDE system design rounds alongside your CP profile. Study: Grokking the System Design Interview (Chapters 1–10).',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement & OA Sprint',
        description: 'CP-focused placement is a different animal — your CF rating is a resume item, OA rounds are your strength, and you should be targeting top-tier product companies and trading firms where CP skills are explicitly valued. Focus on OA speed drills (solve 3 LeetCode hards in 90 minutes), practice explaining your CP solutions clearly in technical interviews, and prepare one software project (anything with a clean GitHub README) to demonstrate software engineering ability beyond CP.',
        monthsHint: 'Months 31–36 (Month 31–32: OA Speed Drills & Hard Problem Accuracy | Month 33–34: Mock Technical Interviews & System Design | Month 35–36: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Interview & OA Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode Hard problems (timed, 45-min each). Weekly: 1 Codeforces contest, 2 mock technical interviews. OA Practice: company-specific OA archives (InterviewBit, LeetCode company tags). Prep: C++ internals Q&A, OS basics, top 20 system design questions, CF profile highlighted on resume, 1 software project with README on GitHub',
          },
        ],
      },
    ],
  },

  2: {
    title: 'SDE + Competitive Programming — 5-Semester Journey',
    milestones: [
      {
        semester: 2,
        title: 'Semester 2: C++ STL Mastery, Core DSA & CP 800–900',
        description: 'Set up your CP environment (fast I/O, STL macros, competitive template). Cover DSA Sections 1–9 and simultaneously grind CP-31 Sections 1–2 (800–900 rating). Participate in Codeforces Div.3/4 contests weekly. Goal: 900 rating on Codeforces.',
        monthsHint: 'Months 1–6 (Month 1–2: C++ CP Setup & STL | Month 3–4: DSA Core & CP-31 Rating 800 | Month 5–6: CP-31 Rating 900 & DSA Stacks/Queues)',
        tracks: [
          {
            name: 'A2Z DSA — Core',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Learn the Basics → Sorting → Arrays → Binary Search → Strings → Linked List → Recursion → Bit Manipulation → Stack and Queues. All in C++ with STL.',
          },
          {
            name: 'CP-31 Sheet — 800–900 Rating',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 1–2: Rating 800 (Beginner Foundations) → Rating 900 (Elementary Logic). Weekly Codeforces Div.3/4 contests. Goal: Codeforces Pupil (900+).',
          },
        ],
      },
      {
        semester: 3,
        title: 'Semester 3: Trees, Graphs, DSU & CP 1000–1200',
        description: 'Cover Trees, BSTs, and Graphs in DSA (Sections 13–15) including DSU with path compression. Grind CP-31 Sections 3–5 (1000–1200). Participate in weekly Div.2 contests. Goal: 1200 Codeforces rating.',
        monthsHint: 'Months 7–12 (Month 7–8: DSA Trees, BSTs & Heaps | Month 9–10: Graphs, DSU & CP-31 Rating 1000 | Month 11–12: CP-31 Rating 1100–1200)',
        tracks: [
          {
            name: 'A2Z DSA — Graphs',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 11–15: Heaps → Greedy → Binary Trees → BSTs → Graphs (BFS, DFS, Topological Sort, Dijkstra, Bellman-Ford, Floyd-Warshall, MST, DSU with path compression & union by rank)',
          },
          {
            name: 'CP-31 Sheet — 1000–1200 Rating',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 3–5: Rating 1000 (Intermediate — prefix sums, two pointers, basic greedy) → 1100 (Upper Intermediate — BFS/DFS, binary search on answer, DSU) → 1200 (Advanced — graph problems, basic DP). Goal: Codeforces Specialist (1400+).',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: DP Mastery & CP 1300–1400',
        description: 'Master all DP patterns (Sections 16–17: DP + Tries). Grind CP-31 Section 6 (1300–1400). Goal: Codeforces Expert (1400+).',
        monthsHint: 'Months 13–18 (Month 13–14: DP Foundations & Bitmask DP | Month 15–16: Digit DP, Tree DP & Tries | Month 17–18: CP-31 Rating 1300–1400)',
        tracks: [
          {
            name: 'A2Z DSA — DP & Tries',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10 & 16–17: Sliding Window → Dynamic Programming (1D, 2D, DP on Stocks/Strings, LCS, MCM, Partition, Bitmask DP, Digit DP, DP on Trees/Graphs) → Tries',
          },
          {
            name: 'CP-31 Sheet — 1300–1400 Rating',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Section 6: Rating 1300–1400 (Expert Problems). Goal: Codeforces Expert (1400+), solving Div.2 A-C reliably.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: Advanced CP 1500+ & System Design',
        description: 'Grind CP-31 Sections 7–8 (1500–1700+ rating). Study advanced CP topics: Segment Trees with lazy propagation, Fenwick Trees, Number Theory, Flow algorithms. Cover core system design for SDE roles.',
        monthsHint: 'Months 19–24 (Month 19–20: Advanced CP Topics — Segment Trees, Number Theory | Month 21–22: CP-31 Rating 1500–1600 | Month 23–24: CP-31 1700+ & System Design Basics)',
        tracks: [
          {
            name: 'CP-31 Advanced',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 7–8: Rating 1500–1600 (Master — Segment Tree lazy propagation, number theory, suffix structures) → Rating 1700+ (Elite — Max Flow, game theory, advanced combinatorics). Goal: Codeforces Master (1800+).',
          },
          {
            name: 'System Design Basics',
            icon: 'brain',
            progressHint: 'Core LLD (SOLID, 5 key patterns) and HLD basics (scalability, load balancing, caching, database fundamentals). Study: Grokking the System Design Interview (Chapters 1–10) for SDE interview coverage.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'OA speed drills, mock technical interviews, CF rating as resume highlight, and campus drives. Build one small software project to show engineering ability beyond CP.',
        monthsHint: 'Months 25–30 (Month 25–26: OA Speed Drills & Hard Problem Practice | Month 27–28: Mock Interviews & System Design | Month 29–30: Placements & Applications)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode Hard problems (timed). Weekly: 1 CF contest + 2 mock interviews. Targets: OA archives for target companies, C++ internals Q&A, top 20 system design questions, CF rating on resume, 1 software project on GitHub',
          },
        ],
      },
    ],
  },

  3: {
    title: 'SDE + Competitive Programming — Accelerated 4-Semester Journey',
    milestones: [
      {
        semester: 3,
        title: 'Semester 3: C++ CP Setup, Core DSA & CP 800–1000',
        description: 'Set up competitive C++ environment. Cover DSA Sections 1–9 all in C++. Grind CP-31 Sections 1–3 (800–1000). Weekly Codeforces contests. Goal: 1000 rating.',
        monthsHint: 'Months 1–6 (Month 1–2: C++ CP Setup & DSA Arrays/Sorting | Month 3–4: DSA Binary Search, Strings, Stacks & CP-31 800 | Month 5–6: CP-31 900–1000 & DSA Completion)',
        tracks: [
          {
            name: 'A2Z DSA — Core',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: all core topics in C++ with STL. Fast I/O setup. Weekly Codeforces participation.',
          },
          {
            name: 'CP-31 Sheet — 800–1000',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 1–3: Rating 800 → 900 → 1000. Weekly Div.3/4 contests. Goal: Codeforces Pupil→Specialist (1000+).',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: Advanced DSA & CP 1100–1300',
        description: 'Cover Trees, Graphs, DSU, DP all patterns, and Tries (Sections 11–17). Grind CP-31 Sections 4–6 (1100–1300). Weekly Div.2 contests. Goal: 1300 Expert rating.',
        monthsHint: 'Months 7–12 (Month 7–8: Trees, Graphs & DSU | Month 9–10: DP All Patterns & Tries | Month 11–12: CP-31 1100–1300)',
        tracks: [
          {
            name: 'A2Z DSA — Complete',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10–17: Sliding Window → Heaps → Greedy → Binary Trees → BSTs → Graphs → Dynamic Programming (all patterns including Bitmask & Digit DP) → Tries',
          },
          {
            name: 'CP-31 Sheet — 1100–1300',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 4–6: Rating 1100 → 1200 → 1300–1400. Weekly Div.2 contests. Goal: Codeforces Expert (1400+).',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: Advanced CP 1400+ & OA Preparation',
        description: 'Grind CP-31 Sections 7 (1500–1600). Study advanced topics: Segment Trees with lazy propagation, Number Theory, basic Network Flow. OA speed drills for placement tests.',
        monthsHint: 'Months 13–18 (Month 13–14: Advanced CP Topics & Segment Trees | Month 15–16: CP-31 1400–1500 | Month 17–18: OA Speed Drills & System Design Basics)',
        tracks: [
          {
            name: 'CP-31 Advanced',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Section 7: Rating 1500–1600 (Master Problems). Advanced topics: Segment Tree lazy propagation, Fenwick Tree, Number Theory (sieve, modular arithmetic), basic Max Flow. Goal: Codeforces Master (1800+).',
          },
          {
            name: 'System Design & OA Prep',
            icon: 'brain',
            progressHint: 'Core system design basics (LLD, HLD fundamentals). OA speed drills: solve 3 problems in 90 minutes targeting company-specific OA archives. Practice explaining solutions verbally.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Sprint',
        description: 'OA-focused placement campaign. CF rating is your key differentiator. Mock interviews and company-targeted applications.',
        monthsHint: 'Months 19–24 (Month 19–20: OA Practice & Hard Problem Speed | Month 21–22: Mock Interviews & Applications | Month 23–24: Campus Drives & Placements)',
        tracks: [
          {
            name: 'Placement Sprint',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode Hard (timed). Weekly: 1 CF contest + 2 mock interviews. Targets: CF rating 1600+ highlighted on resume, OA archives for top 5 companies, C++ internals Q&A (50), top 20 system design questions, 1 software project on GitHub',
          },
        ],
      },
    ],
  },

  4: {
    title: 'SDE + Competitive Programming — Fast-Track 3-Semester Journey',
    milestones: [
      {
        semester: 4,
        title: 'Semester 4: C++ CP Setup + DSA Core + CP 800–1100',
        description: 'Fast-track C++ setup and DSA Sections 1–9. Simultaneously grind CP-31 Sections 1–4 (800–1100). Weekly Codeforces contests. Goal: 1100 rating by semester end.',
        monthsHint: 'Months 1–6 (Month 1–2: C++ STL & DSA Arrays→Stacks | Month 3–4: CP-31 800–900 & DSA Completion | Month 5–6: CP-31 1000–1100)',
        tracks: [
          {
            name: 'DSA Core + CP-31 800–1100',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'DSA Sections 1–9 in C++. CP-31 Sections 1–4: Rating 800 → 900 → 1000 → 1100. Weekly CF contests (Div.3/4). Goal: Codeforces Specialist (1200+).',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: Advanced DSA & CP 1200–1400',
        description: 'Complete DSA Sections 10–17 (all advanced topics). Grind CP-31 Sections 5–6 (1200–1400). Weekly Div.2 contests. Goal: Expert rating (1400+).',
        monthsHint: 'Months 7–12 (Month 7–8: Trees, Graphs & Heaps | Month 9–10: DP, Tries & CP-31 1200 | Month 11–12: CP-31 1300–1400)',
        tracks: [
          {
            name: 'A2Z DSA — Advanced + CP-31',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'DSA Sections 10–17: Sliding Window → Heaps → Greedy → Trees → BSTs → Graphs → DP (all patterns) → Tries. CP-31 Sections 5–6: Rating 1200 → 1300–1400. Goal: Codeforces Expert (1400+).',
          },
          {
            name: 'CP-31 Sheet — 1200–1400',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 5–6: Rating 1200 (Advanced) → 1300–1400 (Expert). Weekly Div.2 contests. Practice solving D-level problems. Goal: Expert rating.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'OA grinding, mock interviews, CF rating on resume, and campus drives. Build one small software project.',
        monthsHint: 'Months 13–18 (Month 13–14: OA Practice & Speed Drills | Month 15–16: Mock Interviews & Applications | Month 17–18: Campus Drives)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (Hard). Weekly: 1 CF contest + 2 mock interviews. Targets: CF Expert (1400+) on resume, OA archives for target companies, C++ internals Q&A (50), system design basics, 1 software project on GitHub',
          },
        ],
      },
    ],
  },

  5: {
    title: 'SDE + Competitive Programming — Crash Course 2-Semester Journey',
    milestones: [
      {
        semester: 5,
        title: 'Semester 5: Emergency CP Grinding Sprint',
        description: 'No time for the full DSA sheet — jump straight to CP-31 with a parallel theory review. Month 1: C++ CP setup + CP-31 Section 1 (800). Month 2: CP-31 Section 2 (900) + binary search theory. Month 3: CP-31 Section 3 (1000) + two pointers, prefix sums. Month 4: CP-31 Section 4 (1100) + BFS/DFS. Month 5: CP-31 Section 5 (1200) + DSU. Month 6: CP-31 Section 6 (1300) + basic DP. Weekly Codeforces contests throughout. Goal: 1300+ Codeforces rating by semester end.',
        monthsHint: 'Months 1–6 (Month 1–2: C++ Setup & CP-31 800–900 | Month 3–4: CP-31 1000–1100 & Algorithmic Theory | Month 5–6: CP-31 1100–1300 & Weekly Contests)',
        tracks: [
          {
            name: 'CP-31 Sheet Sprint',
            roadmapId: ROADMAP_IDS.CP_SHEET,
            icon: 'terminal',
            progressHint: 'Complete Sections 1–6: Rating 800 → 900 → 1000 → 1100 → 1200 → 1300–1400. Weekly CF contests mandatory. Parallel theory: Binary Search → Two Pointers → BFS/DFS → DSU → Basic DP. Goal: Codeforces Expert (1400+).',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Sprint',
        description: 'OA-first placement campaign. CF rating is your primary differentiator. OA grinding, mock interviews, and campus drives.',
        monthsHint: 'Months 7–12 (Month 7–8: OA Practice & Company-Specific Patterns | Month 9–10: Mock Interviews & Hard Problem Speed | Month 11–12: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Placement Sprint',
            icon: 'book',
            progressHint: 'Daily: 2–3 LeetCode Hard (timed, 45-min each). Weekly: 1 CF contest + 2–3 mock interviews. Targets: CF Expert (1400+) highlighted on resume, company OA archives for top 5 targets, C++ internals Q&A (50), basic system design Q&A (20), 1 small software project on GitHub',
          },
        ],
      },
    ],
  },
};

// ═══════════════════════════════════════════════════════
//  FULL_STACK → SPRING_BOOT
// ═══════════════════════════════════════════════════════

const fullStackSpringBoot: Record<number, JourneyConfig> = {
  1: {
    title: 'Full Stack + Spring Boot — Full 6-Semester Journey',
    milestones: [
      {
        semester: 1,
        title: 'Semester 1: Java & Web Foundations',
        description: 'Build parallel foundations: Java on the backend side and HTML/CSS/JS on the frontend side. For Java, cover Sections 1–9: syntax, OOP, arrays, strings — this gives you everything you need to start Spring Boot next year. For frontend, cover Sections 1–4: Web Fundamentals (HTTP, DNS, browsers), Developer Tools, Building Blocks (HTML5 semantics, CSS layouts, Flexbox, Grid), and JavaScript basics (DOM, events, Fetch API). Build two small projects this semester: a Java console app that models a real-world problem, and a static HTML/CSS/JS webpage.',
        monthsHint: 'Months 1–6 (Month 1–2: Java OOP, Arrays & Strings | Month 3–4: HTML5, CSS3 & Layouts | Month 5–6: JavaScript DOM, Events & Fetch API)',
        tracks: [
          {
            name: 'Java Programming Basics',
            roadmapId: ROADMAP_IDS.JAVA_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Introduction → Variables → Operators → Control Flow → Methods → Arrays → Strings → OOP → OOP Principles (encapsulation, inheritance, polymorphism, abstraction)',
          },
          {
            name: 'Frontend Fundamentals',
            roadmapId: ROADMAP_IDS.FRONTEND,
            icon: 'layout',
            progressHint: 'Complete Sections 1–4: Web Fundamentals (HTTP, DNS, how browsers work) → Developer Tools (Chrome DevTools, network tab, console) → Building Blocks (HTML5 semantics, CSS3, Flexbox, Grid, responsive design) → JavaScript & Browser APIs (DOM, events, async/await, Fetch API, localStorage)',
          },
        ],
      },
      {
        semester: 2,
        title: 'Semester 2: React Frontend Mastery & Intro DSA',
        description: 'Focus on React this semester — it is the most in-demand frontend skill. Cover FRONTEND Sections 5–7: TypeScript essentials (types, interfaces, generics — used throughout React codebases), Building Modern Frontends with React (hooks: useState, useEffect, useContext, useReducer; React Router, component composition, state management patterns), and Frontend Ecosystem (REST API integration with Axios/Fetch, React Query for server state). Build a React SPA that fetches and displays data from a public API. For DSA, begin with basics through stacks/queues (Sections 1–9) — implement in Java.',
        monthsHint: 'Months 7–12 (Month 7–8: TypeScript & React Hooks | Month 9–10: React Router, Context & React Query | Month 11–12: Frontend Ecosystem, API Integration & Core DSA)',
        tracks: [
          {
            name: 'React Frontend',
            roadmapId: ROADMAP_IDS.FRONTEND,
            icon: 'layout',
            progressHint: 'Complete Sections 5–7: TypeScript Essentials (types, interfaces, enums, generics, utility types) → Building Modern Frontends with React (hooks, component composition, React Router, Context API, state management) → Frontend Ecosystem & API Integration (React Query, Axios, REST integration, error handling, loading states)',
          },
          {
            name: 'A2Z DSA — Year 1 Target',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Learn the Basics → Sorting → Arrays (Easy→Hard) → Binary Search → Strings → Linked List → Recursion → Bit Manipulation → Stack and Queues. Implement in Java.',
          },
        ],
      },
      {
        semester: 3,
        title: 'Semester 3: Spring Boot REST Backend',
        description: 'This is pure backend semester. Cover Spring Boot Sections 1–7: understand the Spring container and bean lifecycle, master Dependency Injection with constructor injection, configure Spring Boot with application.yml, build REST endpoints with @RestController, add validation with @Valid and Bean Validation, handle exceptions globally with @ControllerAdvice, and integrate Spring Data JPA with PostgreSQL (entity mapping, repositories, JPQL queries, relationships). By semester end, have a fully functional CRUD REST API deployed with a PostgreSQL backend. Also advance DSA to Trees and Graphs (Sections 13–15).',
        monthsHint: 'Months 13–18 (Month 13–14: Spring Container, DI & REST APIs | Month 15–16: Spring Data JPA, PostgreSQL & Relationships | Month 17–18: Validation, Exception Handling & DSA Trees/Graphs)',
        tracks: [
          {
            name: 'Spring Boot Backend',
            roadmapId: ROADMAP_IDS.SPRING_BOOT,
            icon: 'server',
            progressHint: 'Complete Sections 1–7: Java & Build Tool Foundations (Maven, Gradle) → Intro to Spring (IoC container, bean lifecycle, DI) → Dependency Injection & IoC → Spring Boot Configuration (application.yml, profiles, @Value) → Building REST APIs (@RestController, @RequestMapping, HTTP methods, ResponseEntity) → Validation & Exception Handling (@Valid, Bean Validation, @ControllerAdvice) → Spring Data JPA (entities, repositories, JPQL, relationships, pagination)',
          },
          {
            name: 'A2Z DSA — Trees & Graphs',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 13–15: Binary Trees (all traversals, LCA, diameter, boundary traversal) → Binary Search Trees → Graphs (BFS, DFS, Topological Sort, Dijkstra, Floyd-Warshall, MST, DSU)',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: Full-Stack Integration, Security & Deployment',
        description: 'Connect the React frontend and Spring Boot backend into a single deployable full-stack application. Cover Spring Boot Sections 8–12: database transaction management, Spring Security with stateless JWT authentication and OAuth2 (Google/GitHub login), caching with Redis and @Cacheable, AOP for cross-cutting concerns (logging, audit), and testing with JUnit 5 and Mockito. On the React side, integrate auth flows (JWT storage, protected routes, refresh tokens). Deploy the complete application: Spring Boot on Railway/Fly.io, React on Vercel/Netlify, PostgreSQL on Supabase. Also complete DSA Sections 16–17 (DP and Tries).',
        monthsHint: 'Months 19–24 (Month 19–20: Spring Security JWT & OAuth2 | Month 21–22: Redis Caching, AOP & Testing | Month 23–24: React Auth Integration & Full-Stack Deployment)',
        tracks: [
          {
            name: 'Spring Boot — Security & Advanced Features',
            roadmapId: ROADMAP_IDS.SPRING_BOOT,
            icon: 'server',
            progressHint: 'Complete Sections 8–12: Transactions & Database Management (ACID, @Transactional, isolation levels) → Spring Security Fundamentals (security filter chain, UserDetailsService) → Spring Security with JWT & OAuth2 (stateless JWT, refresh tokens, Google/GitHub OAuth2) → Caching, AOP & Cross-Cutting Concerns (Redis @Cacheable, @Aspect, logging) → Testing in Spring Boot (JUnit 5, Mockito, @SpringBootTest, TestContainers)',
          },
          {
            name: 'A2Z DSA — Completion',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10–12 & 16–17: Sliding Window → Heaps → Greedy → Dynamic Programming (all patterns) → Tries',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: Full-Stack System Design & DevOps',
        description: 'Study system design with a full-stack lens: how do large-scale web applications handle millions of concurrent users? Cover CDN for static frontend assets, database read replicas for high-traffic APIs, Redis for session storage and API caching, WebSockets vs Server-Sent Events for real-time features, and microservices decomposition. For Spring Boot, cover Sections 13–15: Observability (Actuator, Prometheus, Grafana), Messaging with Kafka/RabbitMQ, and Microservices with Spring Cloud (service discovery, API gateway, circuit breaker). Add Docker and CI/CD (Section 16).',
        monthsHint: 'Months 25–30 (Month 25–26: Observability, Kafka & Spring Cloud Microservices | Month 27–28: System Design HLD — CDN, Caching, WebSockets | Month 29–30: Docker, CI/CD & Production Deployment)',
        tracks: [
          {
            name: 'Spring Boot — Production & Microservices',
            roadmapId: ROADMAP_IDS.SPRING_BOOT,
            icon: 'server',
            progressHint: 'Complete Sections 13–16: Observability & Production Readiness (Actuator, Prometheus, Grafana, structured logging) → Messaging with Kafka & RabbitMQ (producers, consumers, event-driven patterns) → Microservices with Spring Cloud (Eureka service discovery, Spring Cloud Gateway, Feign client, Resilience4j circuit breaker) → Containerization & Deployment (Docker, docker-compose, CI/CD with GitHub Actions, deployment to cloud)',
          },
          {
            name: 'System Design & DevOps',
            icon: 'brain',
            progressHint: 'HLD: CDN for Frontend Assets, Load Balancing (Nginx), Redis Caching & Sessions, PostgreSQL Read Replicas, WebSockets vs SSE, Microservices decomposition. LLD: SOLID Principles, Design Patterns in Java (Builder, Factory, Observer, Strategy). DevOps: Docker, docker-compose, Nginx reverse proxy, GitHub Actions CI/CD, cloud deployment.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'Full-stack SDE interviews require breadth: DSA (coding rounds), system design (architecture discussions), frontend (React, TypeScript, browser internals), backend (Spring Boot, Java, JVM), and behavioral rounds. Prepare all layers. Polish your portfolio: 2 live projects (one full-stack with auth, one demonstrating a specific technical skill like real-time or microservices), GitHub with clean READMEs, and a resume with bullet points that quantify impact.',
        monthsHint: 'Months 31–36 (Month 31–32: Full-Stack Interview Prep & DSA Revision | Month 33–34: System Design Mocks & Portfolio Polish | Month 35–36: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (Medium). Weekly: 2 mock coding + 1 system design + 1 full-stack technical round. Prep areas: Java & Spring Boot Q&A (100 Q), React & TypeScript Q&A (50 Q), JVM internals, top 50 system design questions, 2 live deployed projects, resume reviewed by senior engineer, STAR behavioral answers prepared',
          },
        ],
      },
    ],
  },

  2: {
    title: 'Full Stack + Spring Boot — 5-Semester Journey',
    milestones: [
      {
        semester: 2,
        title: 'Semester 2: Java, Web Foundations & Intro DSA',
        description: 'Three parallel tracks: Java Sections 1–9 for backend foundation, FRONTEND Sections 1–4 for web and JS basics, and DSA Sections 1–9 for algorithmic skills. Build a simple webpage (HTML/CSS/JS) and a Java console project this semester.',
        monthsHint: 'Months 1–6 (Month 1–2: Java OOP & Web Fundamentals | Month 3–4: JavaScript DOM, React Basics & DSA Arrays | Month 5–6: React Hooks, DSA Stacks/Queues & Java Collections)',
        tracks: [
          {
            name: 'Java Basics',
            roadmapId: ROADMAP_IDS.JAVA_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Introduction → Variables → Operators → Control Flow → Methods → Arrays → Strings → OOP → OOP Principles',
          },
          {
            name: 'A2Z DSA — Core',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Learn the Basics → Sorting → Arrays → Binary Search → Strings → Linked List → Recursion → Bit Manipulation → Stack and Queues',
          },
        ],
      },
      {
        semester: 3,
        title: 'Semester 3: React Frontend & Spring Boot REST APIs',
        description: 'Complete React frontend (FRONTEND Sections 5–7: TypeScript, React hooks, React Query) and build Spring Boot REST APIs with JPA (SPRING_BOOT Sections 1–7). Build a small full-stack project: React consuming a Spring Boot API.',
        monthsHint: 'Months 7–12 (Month 7–8: React TypeScript & Hooks | Month 9–10: React Query, API Integration & Spring Boot REST | Month 11–12: Spring Boot JPA & First Full-Stack Project)',
        tracks: [
          {
            name: 'React Frontend',
            roadmapId: ROADMAP_IDS.FRONTEND,
            icon: 'layout',
            progressHint: 'Complete Sections 5–7: TypeScript Essentials → Building Modern Frontends (React hooks, Router, Context) → Frontend Ecosystem & API Integration (React Query, Axios, REST)',
          },
          {
            name: 'Spring Boot Basics',
            roadmapId: ROADMAP_IDS.SPRING_BOOT,
            icon: 'server',
            progressHint: 'Complete Sections 1–7: Java & Build Tools → Spring Core → DI & IoC → Configuration → REST APIs → Validation & Exception Handling → Spring Data JPA & PostgreSQL',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: Full-Stack Security, Deployment & Advanced DSA',
        description: 'Add Spring Security JWT/OAuth2 (Sections 8–10), Redis caching (Section 11), and testing (Section 12). Complete DSA Sections 13–17 (Trees, Graphs, DP, Tries). Deploy a complete full-stack application live.',
        monthsHint: 'Months 13–18 (Month 13–14: Spring Security JWT, Redis & Testing | Month 15–16: DSA Trees & Graphs | Month 17–18: DP, Tries & Full-Stack Deployment)',
        tracks: [
          {
            name: 'Spring Boot — Security & Production',
            roadmapId: ROADMAP_IDS.SPRING_BOOT,
            icon: 'server',
            progressHint: 'Complete Sections 8–12: Transactions → Spring Security Fundamentals → JWT & OAuth2 → Caching & AOP → Testing. Deliverable: deployed full-stack React + Spring Boot + PostgreSQL application.',
          },
          {
            name: 'A2Z DSA — Advanced + Completion',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10–17: Sliding Window → Heaps → Greedy → Binary Trees → BSTs → Graphs → Dynamic Programming (all patterns) → Tries',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: System Design & Microservices',
        description: 'Cover Spring Boot Sections 13–16 (observability, Kafka, Spring Cloud, Docker/CI-CD). Study HLD and LLD system design. Build a second project demonstrating microservices or real-time features.',
        monthsHint: 'Months 19–24 (Month 19–20: Observability, Kafka & Spring Cloud | Month 21–22: System Design HLD & LLD | Month 23–24: Docker, CI/CD & Production Project)',
        tracks: [
          {
            name: 'Spring Boot — Production & Microservices',
            roadmapId: ROADMAP_IDS.SPRING_BOOT,
            icon: 'server',
            progressHint: 'Complete Sections 13–16: Observability & Production Readiness → Kafka & RabbitMQ Messaging → Microservices with Spring Cloud → Containerization & Deployment (Docker, GitHub Actions CI/CD)',
          },
          {
            name: 'System Design',
            icon: 'brain',
            progressHint: 'HLD: CDN, Load Balancing, Redis, PostgreSQL replication, WebSockets, Microservices. LLD: SOLID Principles, Java Design Patterns. Case Studies: URL Shortener, Twitter Feed, E-commerce Checkout.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'Full-stack interview preparation: DSA mocks, system design discussions, React/Spring Boot Q&A, portfolio polish, and campus drives.',
        monthsHint: 'Months 25–30 (Month 25–26: DSA Revision & Full-Stack Mocks | Month 27–28: System Design & Portfolio Polish | Month 29–30: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (Medium). Weekly: 2 mock coding + 1 system design + 1 full-stack technical round. Prep: Java/Spring Boot Q&A (100 Q), React/TypeScript Q&A (50 Q), top 50 system design Q&A, 2 live projects, resume reviewed',
          },
        ],
      },
    ],
  },

  3: {
    title: 'Full Stack + Spring Boot — Accelerated 4-Semester Journey',
    milestones: [
      {
        semester: 3,
        title: 'Semester 3: Java + React Rapid Foundations',
        description: 'Java Sections 1–9 (OOP, arrays, strings) and FRONTEND Sections 1–6 (web fundamentals through React) in parallel with DSA Sections 1–9. Build one small project per track.',
        monthsHint: 'Months 1–6 (Month 1–2: Java OOP & HTML/CSS/JS | Month 3–4: React Hooks & DSA Arrays→Strings | Month 5–6: React Advanced & DSA Stacks/Queues)',
        tracks: [
          {
            name: 'Java Basics',
            roadmapId: ROADMAP_IDS.JAVA_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Introduction through OOP Principles',
          },
          {
            name: 'React Frontend',
            roadmapId: ROADMAP_IDS.FRONTEND,
            icon: 'layout',
            progressHint: 'Complete Sections 1–6: Web Fundamentals → Developer Tools → HTML/CSS Building Blocks → JavaScript & Browser APIs → TypeScript → React (hooks, Router, Context, API integration)',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: Spring Boot Backend & Full-Stack Integration',
        description: 'Complete Spring Boot through JWT security (Sections 1–10) and integrate with React frontend. Complete DSA Sections 13–17. Deploy a full-stack application live.',
        monthsHint: 'Months 7–12 (Month 7–8: Spring Boot REST & JPA | Month 9–10: Spring Security JWT & DSA Trees/Graphs | Month 11–12: Full-Stack Integration, DP, Tries & Deployment)',
        tracks: [
          {
            name: 'Spring Boot Backend',
            roadmapId: ROADMAP_IDS.SPRING_BOOT,
            icon: 'server',
            progressHint: 'Complete Sections 1–10: Build Tools → Spring Core → DI → Configuration → REST APIs → Validation → JPA → Transactions → Spring Security → JWT & OAuth2. Deliverable: deployed full-stack React + Spring Boot app.',
          },
          {
            name: 'A2Z DSA — Advanced + Completion',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10–17: Sliding Window → Heaps → Greedy → Trees → BSTs → Graphs → DP (all patterns) → Tries',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: System Design, Microservices & Portfolio',
        description: 'Spring Boot Sections 13–16 (observability, Kafka, Spring Cloud, Docker). System design study (LLD + HLD). Build a second portfolio project with microservices or real-time features.',
        monthsHint: 'Months 13–18 (Month 13–14: Kafka, Spring Cloud & Docker | Month 15–16: System Design HLD & LLD | Month 17–18: Portfolio Project Polish)',
        tracks: [
          {
            name: 'Spring Boot Microservices + Deployment',
            roadmapId: ROADMAP_IDS.SPRING_BOOT,
            icon: 'server',
            progressHint: 'Complete Sections 11–16: Caching & AOP → Testing → Observability → Kafka Messaging → Spring Cloud Microservices → Docker & CI/CD',
          },
          {
            name: 'System Design',
            icon: 'brain',
            progressHint: 'HLD: CDN, Load Balancing, Redis, Microservices, WebSockets, Case Studies. LLD: SOLID + Java Design Patterns. Portfolio: 2 live projects with READMEs on GitHub.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Sprint',
        description: 'Full-stack interview marathon: DSA mocks, system design, React/Spring Boot Q&A, application blitz.',
        monthsHint: 'Months 19–24 (Month 19–20: DSA Revision & Mock Rounds | Month 21–22: System Design & Full-Stack Q&A | Month 23–24: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Placement Sprint',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems. Weekly: 2 mock coding + 1 system design + 1 full-stack technical. Targets: Java/Spring Boot Q&A (100 Q), React/TS Q&A (50 Q), top 30 system design Q&A, 2 live projects, resume polished',
          },
        ],
      },
    ],
  },

  4: {
    title: 'Full Stack + Spring Boot — Fast-Track 3-Semester Journey',
    milestones: [
      {
        semester: 4,
        title: 'Semester 4: React + Spring Boot Crash Course',
        description: 'Rapid parallel build: React (FRONTEND Sections 1–7) and Spring Boot REST (SPRING_BOOT Sections 1–7). Build a basic full-stack integration (React consuming Spring Boot API) by Month 4. Add JWT auth by Month 6.',
        monthsHint: 'Months 1–6 (Month 1–2: React Fundamentals & Spring Boot REST | Month 3–4: React Hooks, TypeScript & Spring Boot JPA | Month 5–6: JWT Auth, Full-Stack Integration & Deployed Project)',
        tracks: [
          {
            name: 'Spring Boot Backend',
            roadmapId: ROADMAP_IDS.SPRING_BOOT,
            icon: 'server',
            progressHint: 'Complete Sections 1–7: Java & Build Tools → Spring Core → DI → Configuration → REST APIs → Validation → Spring Data JPA. Then add Sections 9–10: Spring Security + JWT.',
          },
          {
            name: 'React Frontend',
            roadmapId: ROADMAP_IDS.FRONTEND,
            icon: 'layout',
            progressHint: 'Complete Sections 1–7: Web Fundamentals → DevTools → HTML/CSS → JavaScript → TypeScript → React (hooks, Router, Context, React Query) → Frontend Ecosystem. Project: React SPA consuming Spring Boot API with JWT auth.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: Showcase Project & System Design',
        description: 'Build a production showcase project (full Spring Boot backend with Kafka or microservices + React frontend, deployed with Docker). Study system design HLD and LLD. Cover Spring Boot Sections 11–16 (caching, testing, observability, Kafka, Spring Cloud, Docker/CI-CD).',
        monthsHint: 'Months 7–12 (Month 7–8: Spring Boot Caching, Kafka & Docker | Month 9–10: System Design HLD & LLD | Month 11–12: Showcase Project Build & Deploy)',
        tracks: [
          {
            name: 'Full-Stack Showcase Project',
            roadmapId: ROADMAP_IDS.SPRING_BOOT,
            icon: 'terminal',
            progressHint: 'Complete Sections 11–16: Caching & AOP → Testing → Observability → Kafka/RabbitMQ → Spring Cloud Microservices → Docker & CI/CD. Project: deployed full-stack showcase with microservices or real-time features.',
          },
          {
            name: 'System Design',
            icon: 'brain',
            progressHint: 'HLD: Load Balancing, Redis, CDN, Database Replication, WebSockets, Microservices Patterns. LLD: SOLID Principles, Java Design Patterns. Case Studies: URL Shortener, BookMyShow, Twitter Feed.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'Interview preparation across all layers: DSA mocks, system design, React/Spring Boot Q&A, and campus drives.',
        monthsHint: 'Months 13–18 (Month 13–14: DSA Revision & Mock Interviews | Month 15–16: System Design & Full-Stack Q&A | Month 17–18: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems. Weekly: 2 mock coding + 1 system design. Targets: Spring Boot Q&A (100 Q), React/TS Q&A (50 Q), top 30 system design Q&A, 2 live projects, resume reviewed',
          },
        ],
      },
    ],
  },

  5: {
    title: 'Full Stack + Spring Boot — Crash Course 2-Semester Journey',
    milestones: [
      {
        semester: 5,
        title: 'Semester 5: Emergency Full-Stack Sprint',
        description: 'Two semester crash course — build first, learn second. Month 1: Start a Spring Boot + React project immediately using a starter template. Month 2: Add Spring Data JPA and PostgreSQL. Month 3: Add JWT authentication. Month 4: Complete React frontend with auth flow and API integration. Month 5: Add at least one advanced feature (file upload, real-time with WebSockets, or caching with Redis). Month 6: Deploy, write documentation, add to resume. The project must be live before Semester 6 starts. Cover essential Spring Boot Sections 1–10 through building, not through theory-first reading.',
        monthsHint: 'Months 1–6 (Month 1–2: Spring Boot REST + JPA + React Bootstrap | Month 3–4: JWT Auth, React Auth Flow & API Integration | Month 5–6: Advanced Feature + Deployment & Documentation)',
        tracks: [
          {
            name: 'Full-Stack Spring Boot + React Project',
            roadmapId: ROADMAP_IDS.SPRING_BOOT,
            icon: 'terminal',
            progressHint: 'Build-first approach covering Sections 1–10 through project context: Spring Boot REST API → JPA + PostgreSQL → Validation + Error Handling → Spring Security + JWT → React Frontend (FRONTEND Sections 1–6: HTML/CSS → JavaScript → TypeScript → React hooks → API integration). Deliverable: live deployed full-stack app with auth, GitHub README, Postman collection.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Sprint',
        description: 'All-in placement preparation. The project from Semester 5 is your primary resume item. Prepare Spring Boot and React interview Q&A, run DSA revision for coding rounds, and apply broadly.',
        monthsHint: 'Months 7–12 (Month 7–8: DSA Revision & OA Practice | Month 9–10: Mock Interviews, Spring Boot & React Q&A | Month 11–12: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Placement Sprint',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (Medium). Weekly: 2 mock coding + 1 system design. Targets: LeetCode 150 important problems, Spring Boot Q&A (100 Q), React Q&A (50 Q), top 20 system design Q&A, 1 live full-stack project, resume reviewed',
          },
        ],
      },
    ],
  },
};

// ═══════════════════════════════════════════════════════
//  FULL_STACK → NODE_JS (MERN Stack)
// ═══════════════════════════════════════════════════════

const fullStackNodeJs: Record<number, JourneyConfig> = {
  1: {
    title: 'Full Stack MERN — Full 6-Semester Journey',
    milestones: [
      {
        semester: 1,
        title: 'Semester 1: JavaScript & Web Foundations',
        description: 'JavaScript is the single language of the MERN stack — invest deeply in understanding it at a fundamental level. Cover MERN Sections 1 and 3: Fundamentals (variables, scope, closures, prototype chain, event loop, Promises, async/await, ES6+ features) and Building Blocks (DOM manipulation, events, Fetch API, browser storage). Do not rush to frameworks yet — JavaScript mastery here saves significant time later. Build two projects: a DOM-manipulation interactive page and a small vanilla JS app that fetches data from a public API.',
        monthsHint: 'Months 1–6 (Month 1–2: JavaScript Fundamentals — Closures, Scope, Event Loop, Async | Month 3–4: DOM, Browser APIs & ES6+ | Month 5–6: Promises, Fetch API & Vanilla JS Projects)',
        tracks: [
          {
            name: 'MERN JS Fundamentals',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'layout',
            progressHint: 'Complete Sections 1 & 3: Fundamentals (var/let/const, scope, closures, prototype chain, event loop, microtask queue, Promises, async/await, ES6+ features: destructuring, spread/rest, optional chaining, nullish coalescing) → Building Blocks (DOM manipulation, event delegation, Fetch API, localStorage, sessionStorage, Web Workers intro)',
          },
        ],
      },
      {
        semester: 2,
        title: 'Semester 2: React Frontend Mastery & Intro DSA',
        description: 'Master React and TypeScript this semester — they form the core of any MERN frontend. Cover FRONTEND Sections 5–7: TypeScript essentials (used in all modern React projects), Building Modern Frontends with React (hooks deep dive: useState, useEffect, useReducer, useContext, useMemo, useCallback, custom hooks, React Router, component patterns), and Frontend Ecosystem (React Query for server state, Axios, error boundaries, code splitting). Also begin DSA: Sections 1–9 through stacks/queues, implementing in JavaScript.',
        monthsHint: 'Months 7–12 (Month 7–8: TypeScript Essentials & React Hooks Deep Dive | Month 9–10: React Router, Context, React Query & Custom Hooks | Month 11–12: Frontend Ecosystem, Code Splitting & Core DSA)',
        tracks: [
          {
            name: 'React Frontend',
            roadmapId: ROADMAP_IDS.FRONTEND,
            icon: 'layout',
            progressHint: 'Complete Sections 5–7: TypeScript Essentials (types, interfaces, generics, utility types, type narrowing) → Building Modern Frontends with React (hooks deep dive, React Router v6, Context API, performance optimization with useMemo/useCallback, custom hooks) → Frontend Ecosystem (React Query, Axios, error handling, loading states, code splitting, lazy loading)',
          },
          {
            name: 'A2Z DSA — Year 1 Target',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Learn the Basics → Sorting → Arrays → Binary Search → Strings → Linked List → Recursion → Bit Manipulation → Stack and Queues. Solve all in JavaScript.',
          },
        ],
      },
      {
        semester: 3,
        title: 'Semester 3: Node.js, Express & MongoDB Backend',
        description: 'Build a production-quality Express backend this semester. Cover MERN Section 6 completely: Node.js internals (event loop, libuv, streams, child processes), Express.js REST APIs (middleware pipeline, routing, error handling, request validation), MongoDB with Mongoose (schemas, models, indexing, aggregation pipeline), JWT authentication with refresh tokens, file uploads with Multer, rate limiting, and Redis basics for caching. Build and deploy a complete REST API with authentication, serving the React frontend from the previous semester.',
        monthsHint: 'Months 13–18 (Month 13–14: Node.js Internals, Express Middleware & MongoDB | Month 15–16: JWT Auth, Mongoose Advanced & File Uploads | Month 17–18: Redis Caching, Rate Limiting & Deployed Full-Stack App)',
        tracks: [
          {
            name: 'Node.js & Express Backend',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'server',
            progressHint: 'Complete Section 6: Backend Engineering — Node.js internals (event loop, streams, child processes, cluster), Express.js (middleware pipeline, routing, global error handler), MongoDB with Mongoose (schemas, models, indexing, relationships, aggregation pipeline), JWT authentication with refresh tokens, Zod/Joi validation, file uploads with Multer + Cloudinary, rate limiting with express-rate-limit, Redis caching with ioredis',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: Production MERN, Next.js & Advanced DSA',
        description: 'Build a complete production MERN application (MERN Section 8: Full Stack Development — auth flow, real-time with Socket.io, payment integration intro, deployment pipeline). Also explore Next.js for SSR/SSG (MERN Section 7 overlap with modern frontends). Cover DSA Sections 10–17: Sliding Window, Heaps, Greedy, Trees, Graphs, DP (all patterns), and Tries. DP requires the most time — budget 6 weeks. By semester end: one live production MERN app and all DSA sections complete.',
        monthsHint: 'Months 19–24 (Month 19–20: Production MERN App — Real-Time, Auth & Payment Intro | Month 21–22: Next.js SSR/SSG & DSA Trees/Graphs | Month 23–24: DSA DP & Tries + Deployment)',
        tracks: [
          {
            name: 'Production MERN Capstone',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'terminal',
            progressHint: 'Complete Sections 7–8: Building Modern Frontends (Next.js App Router, SSR/SSG, server components, TypeScript with Next.js) → Full Stack Development (complete MERN architecture, real-time with Socket.io, payment integration with Stripe/Razorpay, CI/CD, cloud deployment). Deliverable: 1 live production MERN/Next.js app.',
          },
          {
            name: 'A2Z DSA — Completion',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10–17: Sliding Window → Heaps → Greedy → Binary Trees → BSTs → Graphs → Dynamic Programming (all patterns) → Tries',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: System Design, DevOps & MERN Scaling',
        description: 'Study system design through a MERN/Node.js lens: how do you scale a MongoDB + Express + React + Node.js application to 1M+ users? Cover Node.js clustering and PM2, horizontal scaling with Nginx load balancing, Redis for sessions and pub/sub in Socket.io clusters, MongoDB sharding and replica sets, CDN for React static assets. Cover MERN Section 9 (AI Integrations) and Section 10 (DevOps: Docker, docker-compose, Nginx, GitHub Actions CI/CD). Study LLD patterns and HLD case studies.',
        monthsHint: 'Months 25–30 (Month 25–26: System Design — Node.js Scaling, Redis, MongoDB Sharding | Month 27–28: Docker, DevOps CI/CD & AI Integrations | Month 29–30: HLD Case Studies & LLD Patterns)',
        tracks: [
          {
            name: 'System Design & DevOps',
            icon: 'brain',
            progressHint: 'MERN Sections 9–10: AI Integrations (OpenAI API, LangChain.js, streaming responses) → DevOps for Developers (Docker, docker-compose, Nginx reverse proxy + load balancing, GitHub Actions CI/CD, PM2 process management, cloud deployment). System Design: Node.js Clustering, Redis Pub/Sub for Socket.io scaling, MongoDB Replica Sets & Sharding, CDN for static assets, API Gateway, Microservices with Node.js.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'MERN-focused interview prep: JavaScript internals (event loop, closures, prototype chain, garbage collection), Node.js internals (streams, cluster, child processes), React optimization (memo, useMemo, useCallback, lazy loading, Suspense), MongoDB aggregation and indexing, and standard SDE prep (DSA mocks, system design). Polish portfolio: 2 live MERN projects, GitHub with clean READMEs, and a resume that leads with the full-stack project.',
        monthsHint: 'Months 31–36 (Month 31–32: JS/Node.js Internals, React Optimization & DSA Mocks | Month 33–34: System Design Mocks & Portfolio Polish | Month 35–36: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (Medium, in JavaScript). Weekly: 2 mock coding + 1 system design + 1 MERN technical round. Prep: JavaScript internals Q&A (100 Q), Node.js Q&A (50 Q), React Q&A (50 Q), MongoDB Q&A (30 Q), top 50 system design Q&A, 2 live deployed projects, behavioral STAR answers, resume reviewed',
          },
        ],
      },
    ],
  },

  2: {
    title: 'Full Stack MERN — 5-Semester Journey',
    milestones: [
      {
        semester: 2,
        title: 'Semester 2: JavaScript & React Foundations',
        description: 'JavaScript fundamentals (MERN Sections 1 & 3) and React with TypeScript (FRONTEND Sections 5–7) in parallel. Build a React SPA consuming a public API. Begin DSA Sections 1–9 in JavaScript.',
        monthsHint: 'Months 1–6 (Month 1–2: JS Fundamentals & DOM | Month 3–4: TypeScript, React Hooks & DSA Arrays | Month 5–6: React Router, React Query & DSA Stacks/Queues)',
        tracks: [
          {
            name: 'JS & React Foundations',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'layout',
            progressHint: 'Complete Sections 1 & 3: Fundamentals (closures, event loop, async/await, ES6+) → Building Blocks (DOM, Fetch API). Then FRONTEND Sections 5–7: TypeScript → React (hooks, Router, Context, React Query) → Frontend Ecosystem.',
          },
        ],
      },
      {
        semester: 3,
        title: 'Semester 3: Node.js/Express Backend & MongoDB',
        description: 'Complete MERN Section 6 (Backend Engineering): Express REST APIs, MongoDB + Mongoose, JWT auth, Redis caching, file uploads, rate limiting. Build and deploy a complete API. Advance DSA to Trees and Graphs.',
        monthsHint: 'Months 7–12 (Month 7–8: Express REST & MongoDB | Month 9–10: JWT Auth, Redis & DSA Trees | Month 11–12: Graphs, File Uploads & Deployed API)',
        tracks: [
          {
            name: 'Node.js Backend',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'server',
            progressHint: 'Complete Section 6: Node.js internals, Express REST APIs, MongoDB/Mongoose, JWT auth, Redis caching, rate limiting, file uploads. Deployed API deliverable.',
          },
          {
            name: 'A2Z DSA — Advanced',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 10–15: Sliding Window → Heaps → Greedy → Binary Trees → BSTs → Graphs (BFS, DFS, Dijkstra, MST, DSU)',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: Production MERN App & DSA Completion',
        description: 'Build and deploy a complete production MERN app (MERN Section 8: real-time, auth, CI/CD). Explore Next.js (Section 7). Complete DSA Sections 16–17 (DP all patterns, Tries).',
        monthsHint: 'Months 13–18 (Month 13–14: Next.js & Production MERN App | Month 15–16: DP All Patterns | Month 17–18: Tries, Socket.io & Deployment)',
        tracks: [
          {
            name: 'MERN Capstone',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'terminal',
            progressHint: 'Complete Sections 7–8: Modern Frontends (Next.js App Router, SSR) → Full Stack Development (complete MERN + Socket.io + CI/CD + deployment). Deliverable: 1 live production app.',
          },
          {
            name: 'A2Z DSA — Completion',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 16–17: Dynamic Programming (all patterns: 1D, 2D, Bitmask, Digit, Tree, Graph DP) → Tries',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: System Design & DevOps',
        description: 'MERN Sections 9–10 (AI Integrations + DevOps). System design study (LLD + HLD). Docker, CI/CD, Nginx. Build a second project with a real-time or AI feature.',
        monthsHint: 'Months 19–24 (Month 19–20: AI Integrations & DevOps | Month 21–22: System Design HLD & LLD | Month 23–24: Second Project & Portfolio Polish)',
        tracks: [
          {
            name: 'System Design & DevOps',
            icon: 'brain',
            progressHint: 'MERN Sections 9–10: AI Integrations → DevOps (Docker, CI/CD, Nginx, PM2). System Design: Node.js Scaling, Redis Pub/Sub, MongoDB Sharding, CDN, HLD Case Studies, LLD Patterns.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'MERN interview prep: JS internals, React optimization, Node.js Q&A, MongoDB, DSA mocks, system design. Portfolio polish and campus drives.',
        monthsHint: 'Months 25–30 (Month 25–26: JS/Node.js Internals & DSA Mocks | Month 27–28: System Design & Portfolio | Month 29–30: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (JS). Weekly: 2 mock coding + 1 system design + 1 MERN technical. Prep: JavaScript Q&A (100 Q), Node.js Q&A (50 Q), React Q&A (50 Q), top 30 system design, 2 live projects, resume reviewed',
          },
        ],
      },
    ],
  },

  3: {
    title: 'Full Stack MERN — Accelerated 4-Semester Journey',
    milestones: [
      {
        semester: 3,
        title: 'Semester 3: JS, React & Express Rapid Start',
        description: 'JavaScript fundamentals + React + Express backend, all running simultaneously. MERN Sections 1, 3, 6 and FRONTEND Sections 5–7. Build a basic full-stack MERN app by Month 6.',
        monthsHint: 'Months 1–6 (Month 1–2: JS Fundamentals & React Basics | Month 3–4: TypeScript, React Hooks & Express REST | Month 5–6: MongoDB, JWT Auth & First MERN App)',
        tracks: [
          {
            name: 'MERN Rapid Start',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'terminal',
            progressHint: 'Complete Sections 1, 3 & 6: JS Fundamentals → Building Blocks → Backend Engineering (Express, MongoDB/Mongoose, JWT). Frontend: FRONTEND Sections 5–7 (TypeScript → React hooks → API integration). Deliverable: deployed basic MERN app.',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: Production MERN App & DSA Core',
        description: 'Build a complete production MERN app (Next.js, real-time, CI/CD — MERN Sections 7–8). Complete DSA Sections 1–15 (basics through graphs) in JavaScript. Deploy the project live.',
        monthsHint: 'Months 7–12 (Month 7–8: Next.js, Socket.io & MERN Integration | Month 9–10: DSA Arrays, Trees & Graphs | Month 11–12: Production Deployment & DP Intro)',
        tracks: [
          {
            name: 'MERN Production App',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'server',
            progressHint: 'Complete Sections 7–8: Next.js (App Router, SSR, server components) → Full Stack Development (Socket.io real-time, auth flow, CI/CD, deployment). Deliverable: live production MERN app.',
          },
          {
            name: 'A2Z DSA — Core to Advanced',
            roadmapId: ROADMAP_IDS.DSA,
            icon: 'code',
            progressHint: 'Complete Sections 1–15: Basics through Graphs (prioritize Arrays, Binary Search, Trees, Graphs). All in JavaScript.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: System Design & DSA Completion',
        description: 'MERN Sections 9–10 (AI, DevOps). Complete DSA Sections 16–17 (DP, Tries). System design study. Second project with AI integration or advanced real-time feature.',
        monthsHint: 'Months 13–18 (Month 13–14: AI Integrations & DevOps | Month 15–16: DP All Patterns & Tries | Month 17–18: System Design & Second Project)',
        tracks: [
          {
            name: 'System Design & AI Features',
            icon: 'brain',
            progressHint: 'MERN Sections 9–10: AI Integrations (OpenAI, streaming) → DevOps (Docker, CI/CD, Nginx). DSA Sections 16–17: DP → Tries. System Design: Node.js scaling, Redis, MongoDB sharding, LLD patterns, HLD case studies.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Sprint',
        description: 'MERN interview prep: JS internals, Node.js Q&A, React Q&A, DSA mocks, system design, portfolio polish, and campus drives.',
        monthsHint: 'Months 19–24 (Month 19–20: JS Internals, DSA Mocks & System Design | Month 21–22: Mock Interviews & Portfolio | Month 23–24: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Placement Sprint',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (JS). Weekly: 2 mock coding + 1 system design. Targets: JS Q&A (100 Q), Node.js Q&A (50 Q), React Q&A (50 Q), top 30 system design, 2 live projects, resume polished',
          },
        ],
      },
    ],
  },

  4: {
    title: 'Full Stack MERN — Fast-Track 3-Semester Journey',
    milestones: [
      {
        semester: 4,
        title: 'Semester 4: MERN Crash Course',
        description: 'Simultaneously: MERN Sections 1, 3, 6 (JS + Express + MongoDB) and FRONTEND Sections 5–7 (TypeScript + React + React Query). Build a full-stack MERN app with JWT auth by Month 4. Add real-time or file upload feature by Month 6.',
        monthsHint: 'Months 1–6 (Month 1–2: JS Fundamentals & React Basics | Month 3–4: Express, MongoDB & React Advanced | Month 5–6: JWT Auth, Real-Time & Deployed MERN App)',
        tracks: [
          {
            name: 'MERN Crash Course',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'terminal',
            progressHint: 'Sections 1, 3, 6 & FRONTEND Sections 5–7: JS Fundamentals → Building Blocks → React (TypeScript, hooks, Router, React Query) → Backend Engineering (Express, MongoDB, JWT, Redis). Deliverable: deployed MERN app with auth.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: Showcase App, Next.js & System Design',
        description: 'Build a production showcase with Next.js (MERN Section 7–8), add real-time features or payment integration, deploy with CI/CD (MERN Section 10). Study core system design (LLD + HLD). Complete DSA high-frequency topics (Sections 1–5, 9, 13–16).',
        monthsHint: 'Months 7–12 (Month 7–8: Next.js Showcase App & Real-Time | Month 9–10: CI/CD, DevOps & System Design | Month 11–12: DSA High-Frequency Topics)',
        tracks: [
          {
            name: 'MERN Showcase + DevOps',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'terminal',
            progressHint: 'Sections 7–8 & 10: Next.js App Router → Full Stack (Socket.io, Stripe, CI/CD) → DevOps (Docker, Nginx, GitHub Actions). DSA: Priority Sections 1–5, 9, 13–16 in JavaScript.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'MERN interview marathon: JS internals, Node.js Q&A, React optimization, DSA mocks, system design, portfolio, and applications.',
        monthsHint: 'Months 13–18 (Month 13–14: JS/Node.js Internals & DSA Revision | Month 15–16: Mock Interviews & System Design | Month 17–18: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (JS). Weekly: 2 mock coding + 1 system design. Targets: JS Q&A (100 Q), Node.js Q&A (50 Q), React Q&A (50 Q), top 30 system design Q&A, 2 live projects, resume reviewed',
          },
        ],
      },
    ],
  },

  5: {
    title: 'Full Stack MERN — Crash Course 2-Semester Journey',
    milestones: [
      {
        semester: 5,
        title: 'Semester 5: Emergency MERN Sprint',
        description: 'Build immediately — no prolonged theory phase. Month 1: Set up a Next.js + Express monorepo. Month 2: Add MongoDB, Mongoose, and JWT auth to Express. Month 3: Connect Next.js frontend to Express API with auth flow. Month 4: Add one production feature (real-time with Socket.io, file upload, or payment). Month 5: Deploy (Vercel for Next.js, Railway for Express, MongoDB Atlas). Month 6: Write documentation, add GitHub README, polish and demo. Cover theory through doing — read docs as you build.',
        monthsHint: 'Months 1–6 (Month 1–2: Next.js + Express Setup & MongoDB | Month 3–4: JWT Auth Flow & Advanced Feature | Month 5–6: Deployment, Polish & Documentation)',
        tracks: [
          {
            name: 'MERN Project Sprint',
            roadmapId: ROADMAP_IDS.MERN,
            icon: 'terminal',
            progressHint: 'Build-first covering Sections 1, 3, 6, 7, 8: JS Fundamentals context → Building Blocks → Backend Engineering (Express + MongoDB + JWT) → Modern Frontends (Next.js App Router) → Full Stack (Socket.io or Stripe + CI/CD + deployment). Deliverable: 1 live production MERN/Next.js app with README, GitHub, and live link.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Sprint',
        description: 'All-in placement. The Semester 5 project is your primary asset. JS internals prep, DSA revision, mock interviews, and application blitz.',
        monthsHint: 'Months 7–12 (Month 7–8: DSA Revision, JS Internals & OA Practice | Month 9–10: Mock Interviews & Portfolio Polish | Month 11–12: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Placement Sprint',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (Medium, JS). Weekly: 3 mock interviews. Targets: LeetCode 150 completion, JS internals Q&A (100 Q), Node.js Q&A (50 Q), React Q&A (50 Q), top 20 system design questions, 1 live production MERN project, resume reviewed',
          },
        ],
      },
    ],
  },
};

// ═══════════════════════════════════════════════════════
//  FULL_STACK → PYTHON_FASTAPI
// ═══════════════════════════════════════════════════════

const fullStackPythonFastApi: Record<number, JourneyConfig> = {
  1: {
    title: 'Full Stack + Python FastAPI — Full 6-Semester Journey',
    milestones: [
      {
        semester: 1,
        title: 'Semester 1: Python & Web Foundations',
        description: 'Build Python and frontend foundations simultaneously. Python Sections 1–9 for backend readiness (syntax, OOP, data structures, magic methods). FRONTEND Sections 1–4 for web fundamentals (HTML5, CSS3, JavaScript basics, DOM manipulation). Small projects: a Python CLI tool (data processing or text manipulation) and a static responsive webpage.',
        monthsHint: 'Months 1–6 (Month 1–2: Python OOP & Data Structures | Month 3–4: HTML5, CSS3 & Layouts | Month 5–6: JavaScript DOM, Events & Fetch API)',
        tracks: [
          {
            name: 'Python Basics',
            roadmapId: ROADMAP_IDS.PYTHON_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Introduction → Variables & Data Types → Control Flow → Functions → Built-in Data Structures → Comprehensions → Strings → OOP → Magic/Dunder Methods',
          },
          {
            name: 'Frontend Fundamentals',
            roadmapId: ROADMAP_IDS.FRONTEND,
            icon: 'layout',
            progressHint: 'Complete Sections 1–4: Web Fundamentals (HTTP, browsers) → Developer Tools → HTML/CSS Building Blocks (semantic HTML, Flexbox, Grid, responsive design) → JavaScript & Browser APIs (DOM, events, async/await, Fetch API)',
          },
        ],
      },
      {
        semester: 2,
        title: 'Semester 2: React Frontend & Advanced Python',
        description: 'Master React and TypeScript (FRONTEND Sections 5–7) for the frontend layer. Simultaneously advance Python with the patterns needed for FastAPI: Decorators & Closures, Generators & Iterators, Context Managers, Type Hints (Python Sections 10–15). Build a React SPA with TypeScript that integrates with a public REST API.',
        monthsHint: 'Months 7–12 (Month 7–8: TypeScript & React Hooks | Month 9–10: React Router, React Query & Python Decorators | Month 11–12: Python Type Hints, Async & Context Managers)',
        tracks: [
          {
            name: 'React Frontend',
            roadmapId: ROADMAP_IDS.FRONTEND,
            icon: 'layout',
            progressHint: 'Complete Sections 5–7: TypeScript Essentials → Building Modern Frontends (React hooks, Router, Context, optimization) → Frontend Ecosystem (React Query, Axios, error handling, code splitting)',
          },
          {
            name: 'Python Advanced',
            roadmapId: ROADMAP_IDS.PYTHON_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 10–15: Decorators & Closures → Generators & Iterators → Context Managers & Exception Handling → Modules & Packages → File I/O & Serialization → Type Hints & Static Typing (essential for FastAPI and Pydantic)',
          },
        ],
      },
      {
        semester: 3,
        title: 'Semester 3: FastAPI Backend & PostgreSQL',
        description: 'Build a production FastAPI REST API this semester. Cover FastAPI Sections 1–5: Python type hints and Pydantic v2 (the validation layer), FastAPI async routes and dependency injection, project structure with APIRouter, SQLAlchemy 2.0 async ORM with PostgreSQL and Alembic migrations, and OAuth2 JWT authentication with refresh tokens and role-based access control. Deploy a FastAPI API with database and auth to Railway or Fly.io.',
        monthsHint: 'Months 13–18 (Month 13–14: FastAPI Routing, Pydantic & Dependency Injection | Month 15–16: SQLAlchemy 2.0, PostgreSQL & Alembic Migrations | Month 17–18: OAuth2/JWT Auth, RBAC & Deployed API)',
        tracks: [
          {
            name: 'FastAPI Production Backend',
            roadmapId: ROADMAP_IDS.FASTAPI,
            icon: 'server',
            progressHint: 'Complete Sections 1–5: Python Prerequisites (Pydantic v2, type hints) → FastAPI Fundamentals (async routes, path/query/body params, response models, OpenAPI docs) → Routing & Project Structure (APIRouter, dependency injection, startup/shutdown lifespan events) → Databases & ORMs (SQLAlchemy 2.0 async, PostgreSQL, Alembic migrations, relationships) → Authentication & Security (OAuth2 Password Flow, JWT with refresh tokens, password hashing with bcrypt, RBAC)',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: Full-Stack Integration & Containerization',
        description: 'Connect React frontend to FastAPI backend: implement the auth flow (login, token refresh, protected routes in React consuming FastAPI JWT endpoints), file upload with FastAPI to S3/Cloudinary, and real-time features with WebSockets or Server-Sent Events. Cover FastAPI Sections 6–8: pytest testing, background tasks with Celery + Redis, FastAPI for AI/ML model serving (useful for career differentiation), Docker containerization with docker-compose. Deploy the complete full-stack application.',
        monthsHint: 'Months 19–24 (Month 19–20: Full-Stack Auth Flow, File Uploads & WebSockets | Month 21–22: Celery Background Tasks & Testing | Month 23–24: Docker, docker-compose & Full-Stack Deployment)',
        tracks: [
          {
            name: 'FastAPI Full-Stack Integration',
            roadmapId: ROADMAP_IDS.FASTAPI,
            icon: 'terminal',
            progressHint: 'Complete Sections 6–8: Validation, Testing & Background Tasks (pytest with async support, Celery + Redis workers, BackgroundTasks) → FastAPI for AI/ML Serving (model inference endpoints, streaming responses, vector database integration) → Deployment & Production (Docker, docker-compose, Gunicorn + Uvicorn, Nginx, cloud deployment, health checks, Prometheus monitoring). Full-Stack Deliverable: React + FastAPI + PostgreSQL + Docker, deployed live.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: System Design & Async Python Architecture',
        description: 'Study system design with a Python async focus: how does an ASGI application scale vs a traditional WSGI one, when should you use Celery vs FastAPI BackgroundTasks vs asyncio.gather, how do you design a high-traffic REST API with FastAPI. Cover HLD and LLD patterns. Study Python concurrency deeply (asyncio, threading vs multiprocessing, GIL) as these are both interview topics and architectural considerations.',
        monthsHint: 'Months 25–30 (Month 25–26: System Design LLD & HLD — Async Python Architecture | Month 27–28: HLD Case Studies & Redis/Celery Patterns | Month 29–30: Python Concurrency Deep Dive)',
        tracks: [
          {
            name: 'System Design',
            icon: 'brain',
            progressHint: 'LLD: SOLID Principles, Design Patterns in Python. HLD: ASGI vs WSGI architecture, Celery + Redis queues for background processing, PostgreSQL replication & sharding, Redis caching patterns, FastAPI microservices, CDN for React assets, Load Balancing. Python Concurrency: asyncio event loop, threading vs multiprocessing, GIL implications, concurrent.futures. Case Studies: URL Shortener, Notification System, File Processing Pipeline.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'Full-stack Python interview prep: Python internals (GIL, asyncio, decorators, memory management), FastAPI-specific Q&A (Pydantic, DI, middleware), React interview questions, standard DSA mocks, system design discussions. Portfolio: 2 live projects (one with AI/ML integration is a major differentiator for 2025+ hiring). Polish resume with quantified impact bullet points.',
        monthsHint: 'Months 31–36 (Month 31–32: Python Internals, FastAPI Q&A & DSA Mocks | Month 33–34: System Design & Portfolio Polish | Month 35–36: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (Medium, in Python). Weekly: 2 mock coding + 1 system design + 1 full-stack technical. Prep: Python internals Q&A (100 Q), FastAPI Q&A (50 Q), React/TS Q&A (50 Q), asyncio patterns, top 50 system design Q&A, 2 live projects, resume reviewed',
          },
        ],
      },
    ],
  },

  2: {
    title: 'Full Stack + Python FastAPI — 5-Semester Journey',
    milestones: [
      {
        semester: 2,
        title: 'Semester 2: Python & Web Foundations',
        description: 'Python Sections 1–9 and FRONTEND Sections 1–4 in parallel. Small projects per track.',
        monthsHint: 'Months 1–6 (Month 1–2: Python OOP & Data Structures | Month 3–4: HTML/CSS/JS Basics | Month 5–6: JS DOM, Events & Python Advanced Sections 10–12)',
        tracks: [
          {
            name: 'Python Basics',
            roadmapId: ROADMAP_IDS.PYTHON_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Introduction through Magic/Dunder Methods. Then add Sections 10–12: Decorators → Generators → Context Managers.',
          },
          {
            name: 'Frontend Basics',
            roadmapId: ROADMAP_IDS.FRONTEND,
            icon: 'layout',
            progressHint: 'Complete Sections 1–4: Web Fundamentals → Developer Tools → HTML/CSS → JavaScript & Browser APIs',
          },
        ],
      },
      {
        semester: 3,
        title: 'Semester 3: FastAPI Backend & React Frontend',
        description: 'FastAPI Sections 1–5 (routing, SQLAlchemy, Alembic, OAuth2/JWT) and React FRONTEND Sections 5–7 (TypeScript, React hooks, React Query) in parallel. Build a basic full-stack integration.',
        monthsHint: 'Months 7–12 (Month 7–8: FastAPI Routing & Pydantic | Month 9–10: SQLAlchemy, Alembic & React TypeScript | Month 11–12: JWT Auth, React Query & First Full-Stack App)',
        tracks: [
          {
            name: 'FastAPI Backend',
            roadmapId: ROADMAP_IDS.FASTAPI,
            icon: 'server',
            progressHint: 'Complete Sections 1–5: Python Prerequisites → FastAPI Fundamentals → Routing & Project Structure → Databases & ORMs (SQLAlchemy + Alembic) → Authentication & Security (OAuth2/JWT)',
          },
          {
            name: 'React Frontend',
            roadmapId: ROADMAP_IDS.FRONTEND,
            icon: 'layout',
            progressHint: 'Complete Sections 5–7: TypeScript → React (hooks, Router, Context, React Query) → Frontend Ecosystem (Axios, API integration)',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: Full-Stack Production App',
        description: 'FastAPI Sections 6–8 (testing, Celery, Docker). Complete React + FastAPI full-stack integration with auth, file uploads, and real-time features. Deploy live.',
        monthsHint: 'Months 13–18 (Month 13–14: Celery, Background Tasks & Testing | Month 15–16: Docker, Full-Stack Integration | Month 17–18: Deployed Production App)',
        tracks: [
          {
            name: 'FastAPI Full-Stack Project',
            roadmapId: ROADMAP_IDS.FASTAPI,
            icon: 'terminal',
            progressHint: 'Complete Sections 6–8: Testing & Background Tasks (pytest, Celery + Redis) → AI/ML Serving → Deployment (Docker, docker-compose, Nginx). Deliverable: deployed React + FastAPI + PostgreSQL app with auth, Celery workers, Docker.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: System Design & AI Integrations',
        description: 'System design (LLD + HLD with Python async focus). Add AI feature to your project (OpenAI API or ML model serving via FastAPI Section 7). Study Python concurrency.',
        monthsHint: 'Months 19–24 (Month 19–20: System Design LLD & HLD | Month 21–22: AI Feature Integration & Python Concurrency | Month 23–24: Second Project & Portfolio)',
        tracks: [
          {
            name: 'System Design & AI',
            icon: 'brain',
            progressHint: 'LLD: SOLID + Python Design Patterns. HLD: ASGI, Celery, Redis, PostgreSQL scaling, CDN, Microservices. Python Concurrency: asyncio, threading, GIL. AI: OpenAI API or ML model serving with FastAPI.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'Python/FastAPI/React interview prep, DSA mocks, system design, portfolio polish, campus drives.',
        monthsHint: 'Months 25–30 (Month 25–26: Python Internals & FastAPI Q&A | Month 27–28: System Design & Mock Interviews | Month 29–30: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode (Python). Weekly: 2 mock coding + 1 system design. Targets: Python Q&A (100 Q), FastAPI Q&A (50 Q), React Q&A (50 Q), top 30 system design, 2 live projects, resume reviewed',
          },
        ],
      },
    ],
  },

  3: {
    title: 'Full Stack + Python FastAPI — Accelerated 4-Semester Journey',
    milestones: [
      {
        semester: 3,
        title: 'Semester 3: Python & FastAPI Rapid Start',
        description: 'Python Sections 1–12 (core + decorators, generators, context managers, type hints) and FastAPI Sections 1–4 (fundamentals, routing, SQLAlchemy, Alembic) simultaneously. FRONTEND Sections 1–4 (web basics). Build a basic FastAPI CRUD API deployed.',
        monthsHint: 'Months 1–6 (Month 1–2: Python OOP, Type Hints & Web Basics | Month 3–4: FastAPI Routing, Pydantic & SQLAlchemy | Month 5–6: Alembic Migrations, FastAPI Auth & Deployed API)',
        tracks: [
          {
            name: 'Python Basics',
            roadmapId: ROADMAP_IDS.PYTHON_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–15: OOP through Type Hints (focus on Sections 10–15: Decorators, Generators, Context Managers, Type Hints — all critical for FastAPI)',
          },
          {
            name: 'FastAPI Backend',
            roadmapId: ROADMAP_IDS.FASTAPI,
            icon: 'server',
            progressHint: 'Complete Sections 1–4: Python Prerequisites → FastAPI Fundamentals → Routing & Project Structure → Databases & ORMs (SQLAlchemy + Alembic). Deliverable: deployed CRUD API.',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: Full-Stack React + FastAPI Integration',
        description: 'React (FRONTEND Sections 5–7) + FastAPI Sections 5–8 (auth, testing, Celery, Docker). Build complete full-stack React + FastAPI + PostgreSQL app deployed live.',
        monthsHint: 'Months 7–12 (Month 7–8: FastAPI Auth, Celery & React TypeScript | Month 9–10: React Hooks, React Query & Docker | Month 11–12: Full-Stack Integration & Deployment)',
        tracks: [
          {
            name: 'FastAPI + React Full Stack',
            roadmapId: ROADMAP_IDS.FASTAPI,
            icon: 'terminal',
            progressHint: 'FastAPI Sections 5–8: Auth (OAuth2/JWT) → Testing & Background Tasks (Celery + Redis) → AI/ML Serving → Docker Deployment. React FRONTEND Sections 5–7: TypeScript → React (hooks, Router, React Query) → API Integration. Deliverable: deployed full-stack app.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: System Design & AI Features',
        description: 'System design (LLD + HLD). Add AI feature to project. Python concurrency study. Second portfolio project.',
        monthsHint: 'Months 13–18 (Month 13–14: System Design & AI Integration | Month 15–16: Python Concurrency & Async Patterns | Month 17–18: Second Project & Portfolio)',
        tracks: [
          {
            name: 'System Design & AI',
            icon: 'brain',
            progressHint: 'LLD: SOLID + Python Design Patterns. HLD: ASGI architecture, Celery, Redis, PostgreSQL scaling. AI: OpenAI API or ML model serving. Second project with AI feature deployed.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Sprint',
        description: 'Python/FastAPI/React interview prep, DSA mocks, system design, application blitz.',
        monthsHint: 'Months 19–24 (Month 19–20: Python Internals & DSA Mocks | Month 21–22: Mock Interviews & System Design | Month 23–24: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Placement Sprint',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode (Python). Weekly: 2 mock coding + 1 system design. Targets: Python Q&A (100 Q), FastAPI Q&A (50 Q), React Q&A (50 Q), top 30 system design, 2 live projects, resume reviewed',
          },
        ],
      },
    ],
  },

  4: {
    title: 'Full Stack + Python FastAPI — Fast-Track 3-Semester Journey',
    milestones: [
      {
        semester: 4,
        title: 'Semester 4: FastAPI + React Crash Course',
        description: 'All tracks simultaneously from Month 1. Python Sections 1–12 (core through decorators, generators, context managers, type hints) and FastAPI Sections 1–5 (fundamentals, routing, SQLAlchemy, Alembic, OAuth2/JWT). React FRONTEND Sections 5–7 (TypeScript, hooks, React Query). The integration is intentional — build a FastAPI endpoint and immediately consume it from React so both sides reinforce each other. By Month 4, have a working full-stack app. Add JWT authentication and deploy by Month 6.',
        monthsHint: 'Months 1–6 (Month 1-2: Python OOP, Type Hints & React TypeScript | Month 3-4: FastAPI Routing, SQLAlchemy & React Hooks | Month 5-6: JWT Auth, Full-Stack Integration & Deployed Project)',
        tracks: [
          {
            name: 'Python & FastAPI Fundamentals',
            roadmapId: ROADMAP_IDS.FASTAPI,
            icon: 'code',
            progressHint: 'Python (Sections 1–12): Introduction through Context Managers & Type Hints. FastAPI (Sections 1–5): Python Prerequisites → FastAPI Fundamentals (async routes, path/query/body params) → Routing & Project Structure → Databases & ORMs (SQLAlchemy + Alembic) → Authentication & Security (OAuth2/JWT, bcrypt).',
          },
          {
            name: 'React Frontend',
            roadmapId: ROADMAP_IDS.FRONTEND,
            icon: 'layout',
            progressHint: 'Complete Sections 5–7: TypeScript Essentials (types, interfaces, generics) → Building Modern Frontends (React hooks, Router, Context, optimization) → Frontend Ecosystem (React Query, Axios, error handling, code splitting). Project: React SPA consuming FastAPI with JWT auth.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: Production Showcase, Docker & System Design',
        description: 'Build a production-grade showcase application combining everything from Semester 4. Add advanced FastAPI features from Sections 6–8: pytest testing with async support, Celery + Redis background task workers, Docker and docker-compose containerization, Nginx reverse proxy, and cloud deployment. Simultaneously study core system design: LLD patterns (SOLID, Factory, Observer, Strategy in Python) and HLD fundamentals (scalability, load balancing, caching, ASGI architecture). This project must be live and documented on GitHub before Semester 6 begins.',
        monthsHint: 'Months 7–12 (Month 7-8: FastAPI Testing, Celery & Redis | Month 9-10: Docker, docker-compose & Nginx | Month 11-12: System Design LLD & HLD + Project Polish)',
        tracks: [
          {
            name: 'FastAPI Full-Stack Showcase',
            roadmapId: ROADMAP_IDS.FASTAPI,
            icon: 'terminal',
            progressHint: 'Complete Sections 6–8: Validation, Testing & Background Tasks (pytest, Pydantic validators, Celery + Redis) → FastAPI for AI/ML Serving (model inference endpoints, streaming responses) → Deployment & Production (Docker, docker-compose, Gunicorn + Uvicorn, Nginx, cloud deployment, health checks). Deliverable: deployed React + FastAPI + PostgreSQL app with Celery workers and Docker.',
          },
          {
            name: 'System Design',
            icon: 'brain',
            progressHint: 'LLD: SOLID Principles, Design Patterns in Python (Factory, Singleton, Observer, Strategy, Decorator), Practice Problems (Parking Lot, Notification System, Rate Limiter). HLD: ASGI vs WSGI architecture, Celery + Redis task queues, PostgreSQL replication, CDN for React assets, Load Balancing, Microservices with FastAPI. Case Studies: URL Shortener, Notification System, File Processing Pipeline.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'Surgical placement prep with a tight 6-month window. Prepare Python internals (GIL, asyncio event loop, decorators, memory management, garbage collection) and FastAPI-specific Q&A (Pydantic validation, dependency injection, middleware, background tasks). React interview topics: hooks internals, performance optimization, React Query patterns. Run DSA revision targeting your weak patterns, practice timed mock coding rounds, and run mock system design discussions twice a week. Apply broadly in the last 2 months — keep your FastAPI + React project live and rehearse a 10-minute demo covering architecture, code decisions, and security.',
        monthsHint: 'Months 13–18 (Month 13-14: Python Internals, FastAPI Q&A & DSA Revision | Month 15-16: Mock Interviews & System Design | Month 17-18: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (Medium, in Python). Weekly: 2 mock coding rounds + 1 system design discussion. Targets: Python internals Q&A (50 Q), FastAPI Q&A (50 Q), React/TypeScript Q&A (50 Q), asyncio patterns, top 30 system design cases, top 100 interview problems revision, 2 live deployed projects, resume reviewed by senior peer',
          },
        ],
      },
    ],
  },

  // ── Journey 5: Sem 5→6 (2 semesters) ──
  5: {
    title: 'Full Stack + Python FastAPI — Crash Course 2-Semester Journey',
    milestones: [
      {
        semester: 5,
        title: 'Semester 5: Emergency Full-Stack Sprint',
        description: 'Two semesters is a true crash course — build immediately, learn through doing. Month 1: Set up a FastAPI project with PostgreSQL using SQLAlchemy and Alembic, and scaffold a React + TypeScript frontend. Month 2: Add OAuth2 JWT authentication to FastAPI and wire up the React auth flow (login, protected routes, token refresh). Month 3: Add one production feature — file upload to Cloudinary, real-time with WebSockets, or a Celery background task. Month 4: Integrate React Query for server state, polish UI, and write tests. Month 5: Containerize with Docker + docker-compose, set up Nginx, and deploy to Railway or Fly.io. Month 6: Write documentation, record a demo video, polish the GitHub README, and add to resume. Cover FastAPI Sections 1–8 through building — read docs as you implement, not before.',
        monthsHint: 'Months 1–6 (Month 1-2: FastAPI REST + SQLAlchemy + React Scaffold | Month 3-4: JWT Auth, Advanced Feature & React Query | Month 5-6: Docker, Deployment, Documentation & Polish)',
        tracks: [
          {
            name: 'Full-Stack FastAPI + React Project',
            roadmapId: ROADMAP_IDS.FASTAPI,
            icon: 'terminal',
            progressHint: 'Build-first approach covering FastAPI Sections 1–8: Python type hints & Pydantic → async routes → SQLAlchemy + Alembic → OAuth2/JWT auth → Testing (pytest) → Background Tasks (Celery + Redis) → Docker deployment. Frontend (FRONTEND Sections 5–7): TypeScript → React (hooks, Router, React Query) → API integration. Deliverable: 1 live deployed app with README, GitHub, live link, and Postman/OpenAPI docs.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Sprint',
        description: 'All-in placement mode — no new learning, pure execution. The Semester 5 project is your primary resume asset. Month 1: OA preparation — practice company-specific patterns (LeetCode company tags, GeeksForGeeks company-wise problems). Month 2: Mock interview marathon — aim for 15+ mock coding interviews using peers or platforms like Pramp. Month 3: Application blitz — apply to 15+ companies per week, follow up on every application. Month 4–6: Active drives, interview rounds, and offer evaluation. Prepare Python internals and FastAPI Q&A alongside DSA revision. Keep your project live and practise walking through the architecture, code decisions, and security implementation in any interview.',
        monthsHint: 'Months 7–12 (Month 7-8: OA Grinding & Company Pattern Practice | Month 9-10: Mock Interview Marathon & Resume Polish | Month 11-12: Campus Drives & Active Applications)',
        tracks: [
          {
            name: 'Placement Sprint',
            icon: 'book',
            progressHint: 'Daily: 2–3 LeetCode problems (Medium/Hard, in Python). Weekly: 3 mock interviews. Targets: LeetCode 150 completion, Python internals Q&A (50 Q), FastAPI Q&A (50 Q), React Q&A (50 Q), top 20 system design questions, 1 live deployed full-stack project with docs, resume reviewed, company-specific preparation for top 5 targets',
          },
        ],
      },
    ],
  },
};

// ═══════════════════════════════════════════════════════
//  AI_ML → PYTHON
// ═══════════════════════════════════════════════════════

const aiMlPython: Record<number, JourneyConfig> = {

  // ── Journey 1: Sem 1→6 (Relaxed, 6 semesters) ──
  1: {
    title: 'AI/ML Engineer — Full 6-Semester Journey',
    milestones: [
      {
        semester: 1,
        title: 'Semester 1: Python Foundations & Math Basics',
        description: 'Python is the language of AI/ML — invest deeply in understanding it before touching any ML library. Cover Python Sections 1–9: syntax, data types, control flow, functions, built-in data structures (lists, dicts, sets, tuples), comprehensions, strings, OOP, and magic/dunder methods. These give you everything you need to write clean, idiomatic ML code. Simultaneously start the AI/ML roadmap Section 1 (Math Foundations): linear algebra (vectors, matrices, dot products, eigenvalues), calculus (derivatives, chain rule, gradients), probability (distributions, Bayes theorem), and statistics (mean, variance, covariance). Without this math foundation, ML algorithms are black boxes — with it, you can reason about why models work.',
        monthsHint: 'Months 1–6 (Month 1-2: Python Syntax, Data Structures & OOP | Month 3-4: Linear Algebra & Calculus | Month 5-6: Probability, Statistics & NumPy/Pandas Intro)',
        tracks: [
          {
            name: 'Python Programming Basics',
            roadmapId: ROADMAP_IDS.PYTHON_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Introduction → Variables & Data Types → Control Flow → Functions & Functional Programming → Built-in Data Structures (list, dict, set, tuple) → Comprehensions & Slicing → Strings & Text Processing → OOP → Magic/Dunder Methods & Operator Overloading',
          },
          {
            name: 'AI/ML Math & Python Prep',
            roadmapId: ROADMAP_IDS.AIML,
            icon: 'brain',
            progressHint: 'Complete Section 1: Math Foundations — Linear Algebra (vectors, matrices, matrix multiplication, eigenvalues/eigenvectors), Calculus (derivatives, partial derivatives, chain rule, gradient descent intuition), Probability & Statistics (distributions, Bayes theorem, hypothesis testing, p-values). Also complete Section 2 intro: Python & Data Tooling (NumPy arrays, Pandas DataFrames, Matplotlib/Seaborn basics).',
          },
        ],
      },
      {
        semester: 2,
        title: 'Semester 2: Python Data Tooling & Classical Machine Learning',
        description: 'Master the scientific Python ecosystem and classical ML algorithms. Complete Python Sections 10–15: Decorators & Closures (used in ML training loops and framework internals), Generators & Iterators (critical for efficient data loading), Context Managers, Modules & Packages, File I/O & Serialization (saving/loading models), and Type Hints (used in modern ML codebases). For ML, cover AI/ML Sections 2–3: the full Python & Data Tooling stack (NumPy vectorized operations, Pandas advanced operations, Matplotlib/Seaborn visualization, Scikit-learn pipelines) and Machine Learning Fundamentals (linear regression, logistic regression, decision trees, random forests, SVMs, k-means clustering, PCA, model evaluation metrics, cross-validation, hyperparameter tuning). Enter your first Kaggle competition by Month 11.',
        monthsHint: 'Months 7–12 (Month 7-8: Python Advanced — Decorators, Generators, Serialization | Month 9-10: NumPy, Pandas & Scikit-learn Pipelines | Month 11-12: ML Algorithms — Regression, Classification, Clustering & Kaggle Entry)',
        tracks: [
          {
            name: 'Python Advanced',
            roadmapId: ROADMAP_IDS.PYTHON_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 10–15: Decorators & Closures → Generators & Iterators → Context Managers & Exception Handling → Modules, Packages & Tooling → File I/O & Serialization (pickle, JSON, joblib for model saving) → Type Hints & Static Typing',
          },
          {
            name: 'Classical Machine Learning',
            roadmapId: ROADMAP_IDS.AIML,
            icon: 'brain',
            progressHint: 'Complete Sections 2–3: Python & Data Tooling (NumPy vectorized ops, Pandas groupby/merge/pivot, Matplotlib/Seaborn, Scikit-learn pipelines, preprocessing) → Machine Learning Fundamentals (Linear & Logistic Regression, Decision Trees, Random Forests, Gradient Boosting, SVMs, KNN, K-Means, DBSCAN, PCA, t-SNE, model evaluation: accuracy/precision/recall/F1/ROC-AUC, cross-validation, Grid Search & Random Search). First Kaggle competition entry.',
          },
        ],
      },
      {
        semester: 3,
        title: 'Semester 3: Deep Learning & Computer Vision',
        description: 'Transition from classical ML to deep learning — the foundation of modern AI. Cover AI/ML Section 4 (Deep Learning Fundamentals): understand neural networks from scratch (forward pass, backpropagation, gradient descent variants — SGD, Adam, RMSProp), activation functions (ReLU, sigmoid, tanh, GELU), loss functions, batch normalization, dropout, and regularization. Learn PyTorch as your primary deep learning framework: tensors, autograd, nn.Module, DataLoader, training loops, GPU acceleration. Then build Convolutional Neural Networks (CNNs) for image classification and object detection — implement ResNet, VGG, and understand transfer learning. By semester end, train a CNN on a real dataset (CIFAR-10, ImageNet subset, or a Kaggle computer vision challenge).',
        monthsHint: 'Months 13–18 (Month 13-14: Neural Networks from Scratch & PyTorch Fundamentals | Month 15-16: CNNs — Architectures, Transfer Learning & Image Classification | Month 17-18: Object Detection, Data Augmentation & CV Kaggle Project)',
        tracks: [
          {
            name: 'Deep Learning & PyTorch',
            roadmapId: ROADMAP_IDS.AIML,
            icon: 'brain',
            progressHint: 'Complete Section 4: Deep Learning Fundamentals — Neural Network architecture (layers, activations, loss functions), Backpropagation & gradient descent variants (SGD, Adam, AdamW, RMSProp), Regularization (dropout, batch norm, weight decay), PyTorch (tensors, autograd, nn.Module, DataLoader, training loops, GPU with CUDA), CNNs (conv layers, pooling, LeNet, VGG, ResNet, EfficientNet), Transfer Learning & Fine-tuning, Data Augmentation (torchvision transforms, Albumentations). Project: image classifier trained on a real-world dataset.',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: NLP, Transformers & Large Language Models',
        description: 'Natural Language Processing is the fastest-moving area of AI — transformers underpin virtually every state-of-the-art system. Cover AI/ML Sections 5–6: NLP Fundamentals (tokenization, stemming/lemmatization, TF-IDF, word embeddings — Word2Vec, GloVe, FastText, sequence models — RNNs, LSTMs, GRUs) and then the transformer revolution (attention mechanism, self-attention, multi-head attention, positional encoding, the full Transformer architecture, BERT for classification/NER/QA, GPT for text generation, T5 for seq2seq tasks). Learn Hugging Face Transformers library thoroughly — fine-tune a pre-trained model on a downstream task. Then cover Generative AI & LLMs: prompt engineering, few-shot learning, RAG (Retrieval-Augmented Generation) with vector databases (FAISS, Chroma, Pinecone), LangChain for LLM application development, and LLM API integration (OpenAI, Anthropic, Gemini). Build a working RAG-powered Q&A application as your semester project.',
        monthsHint: 'Months 19–24 (Month 19-20: NLP Fundamentals — Tokenization, Embeddings, RNNs & LSTMs | Month 21-22: Transformers, BERT, GPT & Hugging Face Fine-tuning | Month 23-24: LLMs, RAG Pipelines, LangChain & Generative AI Project)',
        tracks: [
          {
            name: 'NLP & Transformers',
            roadmapId: ROADMAP_IDS.AIML,
            icon: 'brain',
            progressHint: 'Complete Section 5: Natural Language Processing — Text preprocessing (tokenization, stopwords, stemming, lemmatization), Bag of Words & TF-IDF, Word Embeddings (Word2Vec CBOW/Skip-gram, GloVe, FastText), Sequence Models (RNN, LSTM, GRU — vanishing gradient, BPTT), Attention Mechanism (Bahdanau, Luong), Transformer Architecture (self-attention, multi-head attention, positional encoding, encoder-decoder), BERT (masked LM, NSP, fine-tuning for classification/NER/QA), GPT (causal LM, text generation), Hugging Face Transformers (pipeline, AutoModel, Trainer API, fine-tuning on custom datasets).',
          },
          {
            name: 'Generative AI & LLMs',
            roadmapId: ROADMAP_IDS.AIML,
            icon: 'brain',
            progressHint: 'Complete Section 6: Generative AI & LLMs — Prompt Engineering (zero-shot, few-shot, chain-of-thought, ReAct), LLM APIs (OpenAI GPT-4, Anthropic Claude, Google Gemini), LangChain (chains, agents, memory, tools), Vector Databases (FAISS, Chroma, Pinecone — embeddings, similarity search, HNSW index), RAG Architecture (document chunking, embedding, retrieval, reranking, generation), Fine-tuning LLMs (LoRA, QLoRA, PEFT with Hugging Face). Project: RAG-powered Q&A application over a custom document corpus.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: MLOps & Production AI Systems',
        description: 'Building a model that works in a notebook is only half the job — deploying, monitoring, and maintaining it in production is the other half. Cover AI/ML Section 7 (MLOps & Deployment): experiment tracking with MLflow (logging parameters, metrics, artifacts, model registry), data versioning with DVC, model serving with FastAPI (building inference endpoints, async predictions, batching), containerization with Docker and docker-compose, CI/CD for ML pipelines with GitHub Actions, monitoring model performance and data drift (Evidently, Prometheus, Grafana), and vector database management for production RAG systems. Also cover Python Sections 16–17: Concurrency & Multithreading (asyncio for async inference, threading for parallel data loading) and Standard Library Power Utilities (useful for ML data processing pipelines). Build and deploy a complete end-to-end ML system: model trained, tracked with MLflow, served via FastAPI, containerized, and monitored.',
        monthsHint: 'Months 25–30 (Month 25-26: MLflow Experiment Tracking, DVC & Model Registry | Month 27-28: FastAPI Model Serving, Docker & CI/CD for ML | Month 29-30: Monitoring, Data Drift Detection & Production RAG System)',
        tracks: [
          {
            name: 'MLOps & Production AI',
            roadmapId: ROADMAP_IDS.AIML,
            icon: 'database',
            progressHint: 'Complete Section 7: MLOps & Deployment — Experiment Tracking (MLflow: log params/metrics/artifacts, model registry, model versioning), Data Versioning (DVC with Git), Model Serving (FastAPI inference endpoints — sync & async, request batching, GPU inference), Containerization (Docker, docker-compose for ML services), CI/CD for ML (GitHub Actions — automated training, testing, deployment pipelines), Monitoring (Evidently for data drift & model performance, Prometheus + Grafana dashboards), Vector DB Management (Pinecone/Chroma in production — index management, embedding updates). Deliverable: fully deployed, monitored ML application.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'AI/ML interviews are multi-layered — prepare all dimensions. ML theory: understand every algorithm conceptually (why does gradient boosting work better than random forests on tabular data? what is the bias-variance tradeoff? explain backpropagation mathematically). Coding rounds: ML-focused coding (implement k-means from scratch, write a custom PyTorch training loop, build a tokenizer) plus standard DSA (arrays, graphs, DP — ML companies still test general algorithms). System design for ML: design a recommendation system, design a real-time fraud detection pipeline, design a RAG-based customer support bot — practice explaining these end-to-end. Build and polish your Kaggle portfolio (aim for at least one top-20% finish). Prepare your project demos: be ready to walk through your RAG application and your MLOps deployment architecture in full detail.',
        monthsHint: 'Months 31–36 (Month 31-32: ML Theory Revision & Coding Rounds | Month 33-34: ML System Design & Project Demo Practice | Month 35-36: Campus Drives, Applications & Kaggle Portfolio)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (Medium, Python) + 1 ML concept revision. Weekly: 1 ML system design mock + 1 coding mock interview. Prep: ML theory Q&A (100 Q — covering all algorithms, deep learning, NLP, transformers), Python & PyTorch internals (50 Q), MLOps Q&A (30 Q), top 30 ML system design questions (recommendation systems, fraud detection, search ranking, RAG pipelines), Kaggle portfolio (2+ completed competitions), 2 live deployed AI projects on GitHub, resume reviewed',
          },
        ],
      },
    ],
  },

  // ── Journey 2: Sem 2→6 (5 semesters) ──
  2: {
    title: 'AI/ML Engineer — 5-Semester Journey',
    milestones: [
      {
        semester: 2,
        title: 'Semester 2: Python Foundations & Math for ML',
        description: 'Run Python learning and math in strict parallel from day one. Cover Python Sections 1–9 (syntax through OOP and magic methods) over the first 3 months while simultaneously working through AI/ML Section 1 (Math Foundations: linear algebra, calculus, probability, statistics) and Section 2 (Python & Data Tooling: NumPy, Pandas, Matplotlib, Seaborn). Every math concept you study should immediately be implemented in NumPy — implementing matrix multiplication, gradient descent, and PCA from scratch is far more instructive than reading about them. By Month 5, be comfortable with NumPy vectorized operations and have built at least one data visualization project with Pandas and Matplotlib.',
        monthsHint: 'Months 1–6 (Month 1-2: Python OOP & Data Structures | Month 3-4: Linear Algebra, Calculus & NumPy Implementation | Month 5-6: Probability, Statistics, Pandas & Matplotlib)',
        tracks: [
          {
            name: 'Python Basics',
            roadmapId: ROADMAP_IDS.PYTHON_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Introduction → Variables & Data Types → Control Flow → Functions → Built-in Data Structures → Comprehensions & Slicing → Strings → OOP → Magic/Dunder Methods. Focus on data structures (list, dict, set) and OOP — these underpin NumPy and Pandas internals.',
          },
          {
            name: 'AI/ML Math & Python Prep',
            roadmapId: ROADMAP_IDS.AIML,
            icon: 'brain',
            progressHint: 'Complete Sections 1–2: Math Foundations (linear algebra, calculus, probability, statistics — implement each concept in NumPy as you go) → Python & Data Tooling (NumPy vectorized operations, Pandas DataFrames, Matplotlib/Seaborn visualizations, Scikit-learn intro). Mini-project: exploratory data analysis on a public dataset (Titanic, House Prices, or similar).',
          },
        ],
      },
      {
        semester: 3,
        title: 'Semester 3: Classical ML & Deep Learning Foundations',
        description: 'Cover classical ML algorithms with Scikit-learn (AI/ML Section 3) and immediately transition into deep learning with PyTorch (AI/ML Section 4). The key is not to fully master classical ML before starting deep learning — run them in sequence but with overlap. Scikit-learn ML algorithms (regression, classification, clustering, ensemble methods, model evaluation) in the first 3 months, then PyTorch fundamentals and CNNs in the second 3 months. Cover Python Sections 10–12 (Decorators, Generators, Context Managers) as they directly relate to PyTorch training loop patterns. Build one Scikit-learn pipeline project and one CNN image classification project this semester. Enter a Kaggle tabular competition.',
        monthsHint: 'Months 7–12 (Month 7-8: Classical ML — Regression, Classification & Ensemble Methods | Month 9-10: Model Evaluation, Kaggle Entry & Python Advanced | Month 11-12: PyTorch Fundamentals & CNN Image Classification)',
        tracks: [
          {
            name: 'Classical Machine Learning',
            roadmapId: ROADMAP_IDS.AIML,
            icon: 'brain',
            progressHint: 'Complete Section 3: Machine Learning Fundamentals — Linear & Logistic Regression, Decision Trees, Random Forests, Gradient Boosting (XGBoost, LightGBM), SVMs, KNN, K-Means, PCA, model evaluation (cross-validation, precision/recall/F1/ROC-AUC), Scikit-learn pipelines and preprocessors. Kaggle tabular competition entry.',
          },
          {
            name: 'Deep Learning & PyTorch',
            roadmapId: ROADMAP_IDS.AIML,
            icon: 'brain',
            progressHint: 'Begin Section 4: Deep Learning Fundamentals — Neural network architecture, backpropagation, gradient descent variants (Adam, AdamW), PyTorch (tensors, autograd, nn.Module, DataLoader, training loops, CUDA), CNNs (conv layers, pooling, ResNet, transfer learning). Project: CNN image classifier on a real dataset.',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: NLP, Transformers, LLMs & MLOps',
        description: 'Cover NLP and transformers (AI/ML Sections 5–6) in the first 3 months and transition into MLOps (Section 7) in the final 3 months. For NLP: text preprocessing, word embeddings, RNNs/LSTMs, attention mechanism, Transformer architecture, BERT fine-tuning with Hugging Face, GPT text generation. For LLMs: prompt engineering, LangChain, RAG with vector databases, and LLM API integration. Build a working RAG application by Month 15. For MLOps: MLflow experiment tracking, FastAPI model serving, Docker containerization, and basic CI/CD for ML pipelines. By semester end, have a complete deployed ML application tracked with MLflow and served via FastAPI.',
        monthsHint: 'Months 13–18 (Month 13-14: NLP Fundamentals & Transformer Architecture | Month 15-16: Hugging Face Fine-tuning, LLMs & RAG Application | Month 17-18: MLOps — MLflow, FastAPI Serving & Docker)',
        tracks: [
          {
            name: 'NLP, Transformers & LLMs',
            roadmapId: ROADMAP_IDS.AIML,
            icon: 'brain',
            progressHint: 'Complete Sections 5–6: NLP (text preprocessing, TF-IDF, Word2Vec, RNNs/LSTMs, attention, Transformer architecture, BERT, GPT, Hugging Face Trainer API) → Generative AI & LLMs (prompt engineering, LangChain, FAISS/Chroma vector databases, RAG architecture, LoRA fine-tuning). Project: RAG-powered Q&A application.',
          },
          {
            name: 'MLOps & Production AI',
            roadmapId: ROADMAP_IDS.AIML,
            icon: 'database',
            progressHint: 'Complete Section 7: MLOps & Deployment — MLflow experiment tracking, DVC data versioning, FastAPI inference endpoints, Docker + docker-compose, GitHub Actions CI/CD for ML, model monitoring with Evidently. Deliverable: deployed, monitored ML service.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: Advanced AI Topics & Portfolio Polish',
        description: 'Use this semester to go deep on one specialization (computer vision, NLP, or generative AI) and build a second strong portfolio project. Study Python Sections 16–18 (Concurrency, Standard Library, Memory Management) as they directly impact ML system performance. Revisit and extend your RAG application with advanced features: reranking, hybrid search, streaming responses, multi-modal inputs, or agent-based architecture. Alternatively, build an end-to-end MLOps pipeline for a new model. Study ML system design patterns: recommendation systems, fraud detection, search ranking, real-time inference at scale. Prepare Kaggle submissions — aim for a top-20% finish in at least one competition.',
        monthsHint: 'Months 19–24 (Month 19-20: Python Advanced — Concurrency, Memory & Specialization Deep Dive | Month 21-22: Advanced Portfolio Project — RAG Extension or MLOps Pipeline | Month 23-24: ML System Design Study & Kaggle Portfolio)',
        tracks: [
          {
            name: 'Python Advanced & Specialization',
            roadmapId: ROADMAP_IDS.PYTHON_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 16–18: Concurrency & Multithreading (asyncio for async inference, threading for data loading, multiprocessing for CPU-bound ML tasks, GIL implications) → Standard Library Power Utilities (itertools, functools, collections for ML data processing) → Memory Management & Garbage Collection (important for large model loading and batch processing).',
          },
          {
            name: 'Advanced AI Portfolio',
            roadmapId: ROADMAP_IDS.AIML,
            icon: 'terminal',
            progressHint: 'Build a second production-quality AI project: options include (a) Advanced RAG system (hybrid search, reranking, streaming, multi-modal), (b) Real-time ML inference system with FastAPI + Redis + Celery, (c) LLM fine-tuning pipeline with LoRA/QLoRA and deployment, or (d) End-to-end MLOps pipeline for a new domain. Must include: MLflow tracking, Docker deployment, GitHub README with architecture diagram, live demo link.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'Execute a structured AI/ML placement campaign. Prepare ML theory (all algorithms, deep learning math, transformer internals), coding rounds (Python DSA + implement-from-scratch ML questions), and ML system design (recommendation, fraud detection, search ranking, RAG systems). Polish your Kaggle profile and GitHub projects. AI/ML roles at product companies (Google, Meta, Amazon, startups) often have multiple rounds: an ML coding round, an ML theory round, and an ML system design round — prepare specifically for all three.',
        monthsHint: 'Months 25–30 (Month 25-26: ML Theory Revision & Coding Mocks | Month 27-28: ML System Design Mocks & Portfolio Polish | Month 29-30: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (Python) + 1 ML concept revision. Weekly: 1 ML coding mock + 1 ML system design discussion. Targets: ML theory Q&A (100 Q), Python/PyTorch internals (50 Q), MLOps Q&A (30 Q), top 30 ML system design questions, Kaggle portfolio (2+ competitions), 2 live AI projects on GitHub, resume reviewed',
          },
        ],
      },
    ],
  },

  // ── Journey 3: Sem 3→6 (4 semesters) ──
  3: {
    title: 'AI/ML Engineer — Accelerated 4-Semester Journey',
    milestones: [
      {
        semester: 3,
        title: 'Semester 3: Python, Math & Classical ML Sprint',
        description: 'With only 4 semesters, move fast but cover the essentials without gaps. Python Sections 1–9 in Month 1–2 (focus on OOP, data structures, comprehensions — the patterns most used in ML code). AI/ML Sections 1–3 from Month 2–6 in parallel: math foundations (linear algebra, calculus, probability), the Python data science stack (NumPy, Pandas, Matplotlib, Scikit-learn), and all classical ML algorithms (regression, classification, clustering, ensemble methods, model evaluation). Implement every algorithm twice — once with Scikit-learn, once from scratch in NumPy. This dual implementation is the fastest way to build genuine understanding. Target: Kaggle entry and a clean Scikit-learn pipeline project by Month 6.',
        monthsHint: 'Months 1–6 (Month 1-2: Python OOP, Data Structures & Math Foundations | Month 3-4: NumPy, Pandas, Scikit-learn Pipelines & ML Algorithms | Month 5-6: Ensemble Methods, Model Evaluation & Kaggle Entry)',
        tracks: [
          {
            name: 'Python Basics',
            roadmapId: ROADMAP_IDS.PYTHON_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Introduction through Magic/Dunder Methods. Prioritize: data structures (Sections 5–6), OOP (Sections 8–9), and comprehensions — these are the patterns most commonly used in ML codebases.',
          },
          {
            name: 'ML Foundations',
            roadmapId: ROADMAP_IDS.AIML,
            icon: 'brain',
            progressHint: 'Complete Sections 1–3: Math Foundations (linear algebra, calculus, probability, statistics) → Python & Data Tooling (NumPy, Pandas, Matplotlib/Seaborn, Scikit-learn) → Machine Learning Fundamentals (all classical algorithms, Scikit-learn pipelines, cross-validation, hyperparameter tuning, ensemble methods). Kaggle entry. Implement key algorithms from scratch in NumPy alongside Scikit-learn.',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: Deep Learning, NLP & Transformers',
        description: 'Cover AI/ML Sections 4–6 in one semester — this is the densest semester but the most impactful for your resume. Deep Learning (Section 4): PyTorch fundamentals, neural network architecture, backpropagation, CNNs, transfer learning — build an image classifier. NLP (Section 5): text preprocessing, word embeddings, RNNs/LSTMs, attention mechanism, full Transformer architecture — fine-tune BERT on a classification task. Generative AI (Section 6): prompt engineering, LangChain, RAG with FAISS/Chroma, LLM API integration — build a working RAG Q&A application. Cover Python Sections 10–12 (Decorators, Generators, Context Managers) as they are directly relevant to PyTorch training patterns. Budget your time: 2 months for deep learning, 2 months for NLP/transformers, 2 months for LLMs/RAG.',
        monthsHint: 'Months 7–12 (Month 7-8: PyTorch, Neural Networks & CNNs | Month 9-10: NLP, Transformers, BERT & Hugging Face | Month 11-12: LLMs, RAG Application & LangChain)',
        tracks: [
          {
            name: 'Deep Learning & NLP',
            roadmapId: ROADMAP_IDS.AIML,
            icon: 'brain',
            progressHint: 'Complete Sections 4–5: Deep Learning Fundamentals (PyTorch tensors/autograd/nn.Module/DataLoader, neural network architecture, backpropagation, Adam optimizer, CNNs, ResNet, transfer learning) → NLP (text preprocessing, TF-IDF, Word2Vec, RNNs/LSTMs, attention, Transformer architecture, BERT, GPT, Hugging Face Trainer API for fine-tuning).',
          },
          {
            name: 'Generative AI & LLMs',
            roadmapId: ROADMAP_IDS.AIML,
            icon: 'brain',
            progressHint: 'Complete Section 6: Generative AI & LLMs — Prompt Engineering (zero-shot, few-shot, CoT), LangChain (chains, agents, memory), Vector Databases (FAISS, Chroma — embeddings and similarity search), RAG Architecture (chunking, embedding, retrieval, generation), LLM APIs (OpenAI, Anthropic), LoRA fine-tuning basics. Project: deployed RAG Q&A application.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: MLOps, Production AI & Portfolio',
        description: 'Cover AI/ML Section 7 (MLOps & Deployment) fully and build a second strong portfolio project. MLflow experiment tracking, FastAPI model serving (sync and async inference endpoints), Docker containerization, GitHub Actions CI/CD for ML, and model monitoring with Evidently. Extend your RAG application with production features or build a new end-to-end ML system. Study ML system design: recommendation systems, fraud detection at scale, real-time inference pipelines. Cover Python Sections 16–17 (Concurrency, Standard Library) which are directly relevant to production ML systems. The goal: two live, documented AI projects on GitHub before the placement semester.',
        monthsHint: 'Months 13–18 (Month 13-14: MLflow, FastAPI Model Serving & Docker | Month 15-16: CI/CD for ML, Monitoring & Second Portfolio Project | Month 17-18: ML System Design Study & Portfolio Polish)',
        tracks: [
          {
            name: 'MLOps & Production AI',
            roadmapId: ROADMAP_IDS.AIML,
            icon: 'database',
            progressHint: 'Complete Section 7: MLOps & Deployment — MLflow (experiment tracking, model registry), DVC (data versioning), FastAPI inference endpoints (sync/async, batching), Docker + docker-compose, GitHub Actions CI/CD for ML, Evidently (data drift, model performance monitoring). Second Portfolio Project: advanced RAG system or new ML deployment. Python Sections 16–17: Concurrency (asyncio for async inference) + Standard Library utilities.',
          },
          {
            name: 'ML System Design',
            icon: 'brain',
            progressHint: 'Study ML system design patterns: Recommendation Systems (collaborative filtering, content-based, two-tower models, serving infrastructure), Fraud Detection (real-time feature engineering, streaming inference, model versioning), Search Ranking (learning to rank, A/B testing framework), RAG Pipeline at Scale (index management, embedding updates, caching). Use resources: Chip Huyen\'s ML Systems Design, Designing ML Systems book.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Sprint',
        description: 'Four semesters is tight, so placement prep must be highly structured. Week 1–4: ML theory revision — cover all algorithms, deep learning math, transformer internals, and Python/PyTorch internals. Week 5–8: Mock interview marathon — coding rounds (Python DSA + implement-from-scratch ML) and ML system design. Week 9–12: Application blitz and Kaggle portfolio finalization. Week 13–18: Active drives, interview rounds. Prepare demos for both your RAG application and your MLOps pipeline — be ready to explain architecture decisions, scaling considerations, and trade-offs in any interview.',
        monthsHint: 'Months 19–24 (Month 19-20: ML Theory Revision & Coding Mocks | Month 21-22: System Design Mocks & Applications | Month 23-24: Campus Drives & Placements)',
        tracks: [
          {
            name: 'Placement Sprint',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (Python) + 1 ML Q&A. Weekly: 1 ML coding mock + 1 ML system design mock. Targets: ML theory (100 Q), PyTorch internals (50 Q), MLOps (30 Q), top 30 ML system design questions, Kaggle portfolio (2+ competitions with notebooks), 2 live AI projects with READMEs, resume reviewed by senior ML engineer or peer',
          },
        ],
      },
    ],
  },

  // ── Journey 4: Sem 4→6 (3 semesters) ──
  4: {
    title: 'AI/ML Engineer — Fast-Track 3-Semester Journey',
    milestones: [
      {
        semester: 4,
        title: 'Semester 4: Python, Math & ML Crash Course',
        description: 'Three semesters demands extreme prioritization. Month 1–2: Python Sections 1–9 (syntax, OOP, data structures — the essentials for ML coding) and AI/ML Sections 1–2 in parallel (math foundations and NumPy/Pandas data tooling). Month 3–4: AI/ML Section 3 — all classical ML algorithms with Scikit-learn (regression, classification, clustering, ensemble methods, model evaluation). Month 5–6: Begin AI/ML Section 4 — PyTorch fundamentals and CNN basics. The overlap is intentional and necessary given the timeline. Enter a Kaggle tabular competition by Month 4 and have a working CNN project by Month 6.',
        monthsHint: 'Months 1–6 (Month 1-2: Python OOP, Math Foundations & NumPy/Pandas | Month 3-4: Scikit-learn Classical ML & Kaggle Entry | Month 5-6: PyTorch Fundamentals & CNN Basics)',
        tracks: [
          {
            name: 'Python & ML Foundations',
            roadmapId: ROADMAP_IDS.PYTHON_BASICS,
            icon: 'code',
            progressHint: 'Python Sections 1–9: core syntax through OOP and magic methods (prioritize data structures and OOP). Then AI/ML Sections 1–3: Math Foundations → Python Data Tooling (NumPy, Pandas, Matplotlib, Scikit-learn) → Machine Learning Fundamentals (all classical algorithms, model evaluation, ensemble methods). Kaggle entry by Month 4.',
          },
          {
            name: 'Deep Learning Intro',
            roadmapId: ROADMAP_IDS.AIML,
            icon: 'brain',
            progressHint: 'Begin Section 4: Deep Learning Fundamentals — PyTorch basics (tensors, autograd, nn.Module, DataLoader, training loops), neural network architecture, backpropagation, CNNs (conv layers, pooling, ResNet, transfer learning). Project: CNN image classifier trained on a real dataset (CIFAR-10, custom dataset, or Kaggle CV competition).',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: NLP, LLMs & MLOps Capstone',
        description: 'Complete the remaining AI/ML sections: finish Deep Learning (Section 4 completion), cover NLP and Transformers (Section 5), Generative AI and LLMs (Section 6), and MLOps (Section 7). This is a packed semester — prioritize ruthlessly. For NLP: Transformer architecture, BERT fine-tuning with Hugging Face, and GPT text generation are the essentials. For LLMs: prompt engineering, RAG with LangChain and FAISS, and LLM API integration. For MLOps: MLflow, FastAPI model serving, Docker — just enough to deploy your capstone. Build one strong capstone project: a RAG-powered application deployed with Docker and FastAPI, tracked with MLflow. Cover Python Sections 10–12 (Decorators, Generators, Context Managers) alongside as they unlock cleaner ML code patterns.',
        monthsHint: 'Months 7–12 (Month 7-8: NLP, Transformer Architecture & Hugging Face Fine-tuning | Month 9-10: LLMs, RAG Application & LangChain | Month 11-12: MLOps — MLflow, FastAPI Serving, Docker & Capstone Deployment)',
        tracks: [
          {
            name: 'NLP, Transformers & LLMs',
            roadmapId: ROADMAP_IDS.AIML,
            icon: 'brain',
            progressHint: 'Complete Sections 5–6: NLP (text preprocessing, Word2Vec, RNNs/LSTMs, attention mechanism, Transformer architecture, BERT fine-tuning on custom tasks using Hugging Face Trainer API, GPT text generation) → Generative AI & LLMs (prompt engineering, LangChain chains/agents, FAISS/Chroma vector databases, RAG architecture, LoRA fine-tuning basics). Project: RAG Q&A application.',
          },
          {
            name: 'MLOps & Capstone',
            roadmapId: ROADMAP_IDS.AIML,
            icon: 'database',
            progressHint: 'Complete Section 7: MLOps — MLflow experiment tracking and model registry, FastAPI inference endpoints (async, batching), Docker + docker-compose, GitHub Actions CI/CD for ML, Evidently monitoring. Capstone: RAG application fully deployed with Docker, served via FastAPI, tracked with MLflow, documented on GitHub with live demo link.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'Surgical placement prep with only 6 months. Identify target companies and research their ML interview patterns (Google uses ML coding + system design; startups often use take-home projects + technical discussions). Prepare ML theory comprehensively, run mock coding interviews targeting Python DSA and implement-from-scratch ML questions, and practice ML system design explanations. Polish your capstone project and finalize your Kaggle portfolio. Apply broadly — AI/ML roles exist at both product companies and AI-first startups, and the interview formats differ significantly.',
        monthsHint: 'Months 13–18 (Month 13-14: ML Theory, Coding Mocks & Kaggle Portfolio | Month 15-16: ML System Design Mocks & Applications | Month 17-18: Campus Drives & Placements)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (Python) + 1 ML Q&A revision. Weekly: 1 ML coding mock + 1 ML system design discussion. Targets: ML theory Q&A (100 Q), PyTorch internals (50 Q), MLOps Q&A (30 Q), top 20 ML system design questions, Kaggle portfolio (1+ competition with public notebook), 1 live deployed AI project (capstone), resume reviewed',
          },
        ],
      },
    ],
  },

  // ── Journey 5: Sem 5→6 (2 semesters) ──
  5: {
    title: 'AI/ML Engineer — Crash Course 2-Semester Journey',
    milestones: [
      {
        semester: 5,
        title: 'Semester 5: Emergency ML Sprint',
        description: 'Two semesters means no room for a gradual ramp-up — start building immediately and learn through implementation. Month 1: Python essentials (Sections 1–9, focus on OOP and data structures) and NumPy/Pandas/Matplotlib (AI/ML Section 2) simultaneously. Month 2: Classical ML with Scikit-learn (AI/ML Section 3) — implement linear regression, logistic regression, random forests, and gradient boosting; enter a Kaggle tabular competition. Month 3: PyTorch basics and CNNs (AI/ML Section 4 — prioritize CNNs and transfer learning, skip the mathematical deep dives for now). Month 4: Transformers and Hugging Face (AI/ML Section 5 — skip RNNs, go straight to BERT fine-tuning). Month 5: LLMs and RAG (AI/ML Section 6 — build a working RAG application with LangChain and FAISS). Month 6: Basic MLOps (AI/ML Section 7 — deploy your RAG app with FastAPI and Docker, track experiments with MLflow). The goal: one deployed RAG application and one Kaggle competition entry, both on GitHub, before Semester 6.',
        monthsHint: 'Months 1–6 (Month 1-2: Python Basics, NumPy/Pandas & Classical ML Algorithms | Month 3-4: PyTorch CNNs & Transformer/BERT Fine-tuning | Month 5-6: LLMs, RAG Application & FastAPI/Docker Deployment)',
        tracks: [
          {
            name: 'ML Foundation Sprint',
            roadmapId: ROADMAP_IDS.PYTHON_BASICS,
            icon: 'code',
            progressHint: 'Python Sections 1–9 (core essentials — OOP and data structures are priority). Then AI/ML Sections 1–3: Math Foundations (linear algebra and probability basics only) → NumPy/Pandas/Matplotlib → Classical ML (Scikit-learn pipelines, Random Forest, XGBoost, model evaluation). Kaggle tabular competition entry by Month 2.',
          },
          {
            name: 'AI Project Sprint',
            roadmapId: ROADMAP_IDS.AIML,
            icon: 'terminal',
            progressHint: 'Fast-track Sections 4–7: PyTorch basics + CNN with transfer learning → BERT fine-tuning with Hugging Face Trainer API → LangChain + FAISS RAG application → FastAPI model serving + Docker deployment + MLflow tracking. Deliverable: 1 live deployed RAG application with GitHub README, live demo link, and 1 Kaggle competition notebook.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: All-In Placement Sprint',
        description: 'All execution, no new learning. Month 1: ML theory intensive revision — cover all classical ML algorithms, deep learning concepts, transformer internals, and Python/PyTorch internals. Month 2: Mock interview marathon — 15+ mock coding and ML theory interviews. Month 3: Application blitz. Month 4–6: Active drives, interview rounds. Focus on the highest-yield interview preparation: ML theory Q&A, Python DSA coding, and ML system design (recommendation systems, fraud detection, RAG pipelines). Keep your RAG project live and practice a tight 10-minute demo walkthrough covering architecture, implementation choices, and how you would scale it.',
        monthsHint: 'Months 7–12 (Month 7-8: ML Theory Intensive & Coding Mock Sprint | Month 9-10: Mock Interview Marathon, System Design & Applications | Month 11-12: Campus Drives & Active Placements)',
        tracks: [
          {
            name: 'Placement Sprint',
            icon: 'book',
            progressHint: 'Daily: 2 LeetCode problems (Python) + 1 ML concept. Weekly: 3 mock interviews (mix of ML coding and ML theory). Targets: ML theory Q&A (100 Q), PyTorch internals (30 Q), top 20 ML system design questions, Kaggle competition notebook published, 1 live deployed RAG/ML project, resume reviewed, company-specific preparation for top 5 targets',
          },
        ],
      },
    ],
  },
};

// ═══════════════════════════════════════════════════════
//  DATA_SCIENTIST → PYTHON
// ═══════════════════════════════════════════════════════

const dataScientistPython: Record<number, JourneyConfig> = {

  // ── Journey 1: Sem 1→6 (Relaxed, 6 semesters) ──
  1: {
    title: 'Data Scientist — Full 6-Semester Journey',
    milestones: [
      {
        semester: 1,
        title: 'Semester 1: Python Foundations & Statistics',
        description: 'Data science is built on two pillars — Python and statistics. Invest equally in both from the start. Cover Python Sections 1–9: syntax, data types, control flow, functions, built-in data structures (lists, dicts, sets, tuples — these map directly to pandas Series and DataFrames), comprehensions, strings, OOP, and magic methods. Implement statistical concepts directly in Python as you learn them: calculate mean, variance, and covariance manually with lists before touching NumPy. For the data science stack, cover Data Scientist Section 1 (Statistics & Probability): descriptive statistics, probability distributions (normal, binomial, Poisson, exponential), Bayes theorem, hypothesis testing (t-tests, chi-squared, ANOVA), p-values, confidence intervals, and statistical power. Simultaneously begin Section 2 (Python for Data Science): NumPy vectorized operations, Pandas DataFrames, and Matplotlib/Seaborn for visualization.',
        monthsHint: 'Months 1–6 (Month 1-2: Python OOP, Data Structures & Descriptive Statistics | Month 3-4: Probability Distributions, Hypothesis Testing & NumPy | Month 5-6: Pandas DataFrames, Matplotlib/Seaborn & First EDA Project)',
        tracks: [
          {
            name: 'Python Programming Basics',
            roadmapId: ROADMAP_IDS.PYTHON_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Introduction → Variables & Data Types → Control Flow → Functions & Functional Programming → Built-in Data Structures (list, dict, set, tuple — these directly map to Pandas structures) → Comprehensions & Slicing → Strings & Text Processing → OOP → Magic/Dunder Methods. Focus on data structures (Sections 5–6) and functional programming (Section 4) as these patterns dominate data processing code.',
          },
          {
            name: 'Statistics & Data Stack',
            roadmapId: ROADMAP_IDS.DATA_SCIENTIST,
            icon: 'chart',
            progressHint: 'Complete Sections 1–2: Statistics & Probability (descriptive stats — mean/median/mode/variance/std/skewness/kurtosis, probability distributions — normal/binomial/Poisson/exponential, hypothesis testing — t-tests/chi-squared/ANOVA/Mann-Whitney, p-values, confidence intervals, statistical power, A/B testing foundations) → Python for Data Science (NumPy vectorized operations and broadcasting, Pandas — Series/DataFrame/indexing/groupby/merge/pivot, Matplotlib/Seaborn — distribution/correlation/categorical plots). First EDA project on a public dataset.',
          },
        ],
      },
      {
        semester: 2,
        title: 'Semester 2: SQL Mastery & Advanced EDA',
        description: 'SQL is the most-used tool in a data scientist\'s daily work — invest deeply. Cover Data Scientist Section 3 (SQL for Data Science): SELECT/JOIN/GROUP BY/HAVING/ORDER BY, subqueries and CTEs (WITH clauses), window functions (ROW_NUMBER, RANK, DENSE_RANK, LAG, LEAD, NTILE, running totals, moving averages), set operations, query optimization basics, and working with dates and strings in SQL. Practice on real databases (PostgreSQL) and on platforms like LeetCode SQL, StrataScratch, or Mode Analytics. Simultaneously advance EDA skills: Section 4 (Data Wrangling & EDA) covers missing value imputation strategies (mean/median/KNN/MICE), outlier detection (IQR, z-score, isolation forest), feature engineering (encoding categoricals — one-hot, label, target encoding; scaling — StandardScaler, MinMaxScaler, RobustScaler; datetime feature extraction), and correlation analysis. Enter your first Kaggle competition by Month 11 and aim for a public notebook with feature engineering insights.',
        monthsHint: 'Months 7–12 (Month 7-8: SQL — JOINs, Subqueries & CTEs | Month 9-10: SQL Window Functions & StrataScratch Practice | Month 11-12: Advanced EDA — Missing Values, Feature Engineering & Kaggle Entry)',
        tracks: [
          {
            name: 'SQL for Data Science',
            roadmapId: ROADMAP_IDS.DATA_SCIENTIST,
            icon: 'database',
            progressHint: 'Complete Section 3: SQL for Data Science — SELECT with WHERE/ORDER BY/LIMIT, aggregations (GROUP BY, HAVING, COUNT/SUM/AVG/MIN/MAX), JOINs (INNER/LEFT/RIGHT/FULL/CROSS/SELF), subqueries (correlated and non-correlated), CTEs (WITH clauses, recursive CTEs), window functions (ROW_NUMBER/RANK/DENSE_RANK/LAG/LEAD/NTILE, running totals, moving averages, PARTITION BY), set operations (UNION/INTERSECT/EXCEPT), date/string functions, query optimization basics (indexes, EXPLAIN ANALYZE). Practice: 50+ SQL problems on LeetCode/StrataScratch/Mode Analytics.',
          },
          {
            name: 'Data Wrangling & EDA',
            roadmapId: ROADMAP_IDS.DATA_SCIENTIST,
            icon: 'chart',
            progressHint: 'Complete Section 4: Data Wrangling & EDA — Data quality assessment (missing values, duplicates, inconsistencies), missing value imputation (mean/median/mode/KNN/MICE), outlier detection and treatment (IQR fences, z-score, isolation forest, Winsorization), feature engineering (categorical encoding — one-hot/label/target/frequency; numerical scaling — StandardScaler/MinMaxScaler/RobustScaler/PowerTransformer; datetime features — hour/day/week/month/season/lag features; interaction features), correlation analysis (Pearson/Spearman/Cramér\'s V), univariate/bivariate/multivariate analysis. Kaggle competition entry with detailed EDA notebook.',
          },
        ],
      },
      {
        semester: 3,
        title: 'Semester 3: Machine Learning for Data Science',
        description: 'Machine learning is a core tool for data scientists, but the emphasis is different from ML engineering — you care more about model interpretability, feature importance, and business insight than raw accuracy. Cover Data Scientist Section 6 (Machine Learning): supervised learning algorithms (linear regression with regularization — Ridge, Lasso, ElasticNet; logistic regression; decision trees with pruning; random forests with feature importance; gradient boosting — XGBoost, LightGBM, CatBoost; SVMs; KNN), unsupervised learning (k-means clustering, hierarchical clustering, DBSCAN, PCA, t-SNE, UMAP), model evaluation (cross-validation, learning curves, calibration, confusion matrix, ROC-AUC, precision-recall), hyperparameter tuning (Grid Search, Random Search, Bayesian optimization with Optuna), and model interpretability (SHAP values, LIME, partial dependence plots, feature importance). Build a complete prediction pipeline: feature engineering → model training → evaluation → SHAP interpretation → business recommendations.',
        monthsHint: 'Months 13–18 (Month 13-14: Supervised Learning — Regression, Classification & Ensemble Methods | Month 15-16: Unsupervised Learning, Model Evaluation & Hyperparameter Tuning | Month 17-18: XGBoost/LightGBM, SHAP Interpretability & Kaggle Competition)',
        tracks: [
          {
            name: 'Machine Learning for DS',
            roadmapId: ROADMAP_IDS.DATA_SCIENTIST,
            icon: 'brain',
            progressHint: 'Complete Section 6: Machine Learning — Supervised: Linear Regression (Ridge/Lasso/ElasticNet), Logistic Regression, Decision Trees, Random Forests (feature importance, OOB score), Gradient Boosting (XGBoost/LightGBM/CatBoost — early stopping, custom objectives), SVMs. Unsupervised: K-Means (elbow method, silhouette score), Hierarchical Clustering (dendrograms), DBSCAN, PCA (explained variance, scree plot), t-SNE and UMAP for visualization. Evaluation: cross-validation, ROC-AUC, calibration, SHAP values, LIME, PDPs. Optuna hyperparameter optimization. Kaggle structured data competition with full pipeline.',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: Advanced Analytics & Business Intelligence',
        description: 'Data scientists at companies spend a significant portion of their time on analytics, A/B testing, and communicating results to business stakeholders — not just building models. Cover Data Scientist Section 5 (BI Tools & Dashboards): Power BI and Tableau for interactive dashboards, connecting to databases, calculated fields, filters, and storytelling with data. Cover the business analytics portion of Section 6: A/B testing (experiment design, sample size calculation, statistical power, sequential testing, multiple comparisons correction — Bonferroni, Benjamini-Hochberg), causal inference (difference-in-differences, propensity score matching, instrumental variables), time-series analysis and forecasting (ARIMA, SARIMA, Prophet, LSTM for time-series, feature engineering for time-series — lag features, rolling statistics, seasonality decomposition), and business metrics design (defining KPIs, metric trees, guardrail metrics). Also cover Python Sections 10–12 (Decorators, Generators, Context Managers) for cleaner data pipeline code.',
        monthsHint: 'Months 19–24 (Month 19-20: Time-Series Forecasting — ARIMA, Prophet & LSTM | Month 21-22: A/B Testing Design, Statistical Power & Causal Inference | Month 23-24: Power BI/Tableau Dashboards & Business Metrics Design)',
        tracks: [
          {
            name: 'BI Tools & Dashboards',
            roadmapId: ROADMAP_IDS.DATA_SCIENTIST,
            icon: 'chart',
            progressHint: 'Complete Section 5: BI Tools & Dashboards — Tableau (connecting to data sources, calculated fields, LOD expressions, filters, actions, dashboard design principles, storytelling with data) and/or Power BI (Power Query for ETL, DAX measures and calculated columns, relationships, report design, publishing to Power BI Service). Build 2 interactive dashboards: one for business KPI monitoring and one for ML model performance tracking.',
          },
          {
            name: 'Advanced Analytics',
            roadmapId: ROADMAP_IDS.DATA_SCIENTIST,
            icon: 'brain',
            progressHint: 'Advanced topics from Section 6 & 8: Time-Series (ARIMA/SARIMA, seasonal decomposition, Prophet for business forecasting, LSTM for time-series, lag/rolling features), A/B Testing (experiment design, sample size calculator, t-tests/z-tests, sequential testing, Bonferroni/BH correction, Bayesian A/B testing), Causal Inference (DiD, PSM, synthetic control), Business Metrics Design (metric trees, KPI selection, guardrail metrics, north star metrics). Python Sections 10–12: Decorators → Generators → Context Managers.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: Data Engineering & Production Pipelines',
        description: 'Modern data scientists are increasingly expected to build and maintain their own data pipelines. Cover Data Scientist Section 7 (Big Data & Data Engineering Basics): Spark fundamentals (RDDs, DataFrames, Spark SQL, MLlib basics), distributed data processing concepts, cloud data warehouses (BigQuery, Snowflake, or Redshift — query optimization, partitioning, clustering), data pipeline orchestration with Apache Airflow (DAGs, operators, sensors, task dependencies, scheduling, monitoring), data lake architecture vs data warehouse, and ETL vs ELT patterns. Also cover Python Sections 16–17 (Concurrency and Standard Library) which are essential for writing efficient data processing scripts. Build an end-to-end data pipeline: raw data ingestion → Airflow-orchestrated ETL → cloud warehouse → BI dashboard — all automated and monitored.',
        monthsHint: 'Months 25–30 (Month 25-26: Apache Spark — DataFrames, Spark SQL & MLlib | Month 27-28: Airflow DAGs, Pipeline Orchestration & Cloud Warehouse | Month 29-30: End-to-End Pipeline Project & BI Dashboard)',
        tracks: [
          {
            name: 'Data Engineering & BI',
            roadmapId: ROADMAP_IDS.DATA_SCIENTIST,
            icon: 'database',
            progressHint: 'Complete Section 7: Big Data & Data Engineering Basics — Apache Spark (RDDs, DataFrames, Spark SQL, PySpark transformations/actions, MLlib basics, running on Databricks or local), Cloud Data Warehouses (BigQuery or Snowflake — DDL/DML, query optimization, partitioning/clustering, connecting from Python), Apache Airflow (DAG structure, PythonOperator/BashOperator/SQLOperator, task dependencies, XComs, SLAs, monitoring, backfilling), data lake vs warehouse architecture, ETL vs ELT, Delta Lake basics. Project: automated Airflow pipeline feeding a cloud warehouse dashboard.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'Data science interviews are uniquely multi-dimensional — prepare all four pillars. Statistics & Probability: be ready for on-the-spot questions about distributions, hypothesis testing, A/B testing design, and statistical power — these are asked at every company. SQL live coding: practice solving complex window function and aggregation problems in real time — StrataScratch and LeetCode SQL are your best resources. ML theory and case studies: explain model selection, feature engineering decisions, and metric choices clearly; practice business-framed case studies ("how would you build a churn prediction model for a subscription product?"). Python coding: data manipulation with Pandas, clean implementation of ML algorithms from scratch. Polish your Kaggle portfolio and dashboard projects.',
        monthsHint: 'Months 31–36 (Month 31-32: Statistics & SQL Intensive Practice | Month 33-34: ML Case Studies, Dashboard Polish & Kaggle Portfolio | Month 35-36: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 SQL problems (LeetCode/StrataScratch) + 1 stats/ML concept. Weekly: 1 SQL live coding mock + 1 ML case study discussion. Targets: Statistics Q&A (50 Q — distributions, hypothesis testing, A/B testing), SQL interview Q&A (50 Q — window functions, CTEs, aggregations), ML theory Q&A (50 Q), Python/Pandas coding (30 Q), DS case study practice (20 business scenarios), Kaggle portfolio (2+ competitions with public notebooks), 2 live dashboards (Tableau/Power BI), resume reviewed by senior data scientist or peer',
          },
        ],
      },
    ],
  },

  // ── Journey 2: Sem 2→6 (5 semesters) ──
  2: {
    title: 'Data Scientist — 5-Semester Journey',
    milestones: [
      {
        semester: 2,
        title: 'Semester 2: Python, Statistics & Data Tooling',
        description: 'Run Python learning and statistics in strict parallel from day one. Python Sections 1–9 (syntax through OOP and magic methods) in the first 3 months while simultaneously working through Data Scientist Sections 1–2 (Statistics & Probability and Python for Data Science). Every statistical concept should be implemented in NumPy immediately — computing variance manually before using np.var(), building a hypothesis test before using scipy.stats. By Month 5, be comfortable with Pandas for data manipulation and Matplotlib/Seaborn for visualization. Complete a full exploratory data analysis on a public dataset as a portfolio project.',
        monthsHint: 'Months 1–6 (Month 1-2: Python OOP & Data Structures | Month 3-4: Statistics, Probability & NumPy Implementation | Month 5-6: Pandas, Matplotlib/Seaborn & First EDA Project)',
        tracks: [
          {
            name: 'Python Basics',
            roadmapId: ROADMAP_IDS.PYTHON_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Introduction through Magic/Dunder Methods. Focus on data structures (Sections 5–6 — list, dict, set, tuple map directly to Pandas), functional programming (Section 4 — map/filter/reduce/lambda used throughout data processing), and OOP (Sections 8–9 — understanding class-based APIs like Scikit-learn estimators).',
          },
          {
            name: 'Statistics & Data Stack',
            roadmapId: ROADMAP_IDS.DATA_SCIENTIST,
            icon: 'chart',
            progressHint: 'Complete Sections 1–2: Statistics & Probability (descriptive stats, probability distributions, hypothesis testing, p-values, confidence intervals, A/B testing foundations) → Python for Data Science (NumPy vectorized operations, Pandas DataFrames, Matplotlib/Seaborn visualizations). Mini-project: full EDA on a public dataset (Kaggle titanic, house prices, or similar) with documented insights.',
          },
        ],
      },
      {
        semester: 3,
        title: 'Semester 3: SQL, EDA & Machine Learning',
        description: 'SQL is non-negotiable for data science — no amount of Python skill compensates for weak SQL in interviews. Cover Data Scientist Section 3 (SQL for Data Science) completely: JOINs, subqueries, CTEs, and most importantly window functions (ROW_NUMBER, LAG/LEAD, running totals, moving averages) which are tested in almost every DS interview. Simultaneously cover Section 4 (Data Wrangling & EDA): missing value strategies, outlier treatment, feature engineering, and correlation analysis. Then begin Section 6 (Machine Learning): supervised learning algorithms with Scikit-learn. By semester end, have a complete Kaggle competition submission with SQL-based feature engineering and a Scikit-learn model.',
        monthsHint: 'Months 7–12 (Month 7-8: SQL — JOINs, CTEs & Window Functions | Month 9-10: Advanced EDA — Feature Engineering & Data Wrangling | Month 11-12: Scikit-learn ML Algorithms & Kaggle Competition)',
        tracks: [
          {
            name: 'SQL & EDA',
            roadmapId: ROADMAP_IDS.DATA_SCIENTIST,
            icon: 'database',
            progressHint: 'Complete Sections 3–4: SQL for Data Science (SELECT/JOIN/GROUP BY/HAVING, subqueries, CTEs, window functions — ROW_NUMBER/RANK/LAG/LEAD/running totals/moving averages, date and string functions, query optimization basics. 50+ problems on LeetCode/StrataScratch) → Data Wrangling & EDA (missing value imputation, outlier treatment, categorical encoding, numerical scaling, datetime features, correlation analysis, univariate/bivariate plots).',
          },
          {
            name: 'Machine Learning',
            roadmapId: ROADMAP_IDS.DATA_SCIENTIST,
            icon: 'brain',
            progressHint: 'Begin Section 6: Machine Learning Fundamentals — Linear & Logistic Regression, Decision Trees, Random Forests (feature importance), Gradient Boosting (XGBoost/LightGBM), K-Means clustering, PCA, model evaluation (cross-validation, ROC-AUC, precision/recall/F1), SHAP values for interpretability, Scikit-learn pipelines with preprocessors. Kaggle competition with complete ML pipeline.',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: Advanced ML, A/B Testing & BI Dashboards',
        description: 'Deepen ML skills with advanced techniques and add the business analytics layer that separates good data scientists from great ones. Complete Data Scientist Section 6 (advanced ML: XGBoost/LightGBM/CatBoost with Optuna tuning, time-series analysis and forecasting with Prophet and LSTM, unsupervised learning techniques, model interpretability with SHAP). Cover Section 5 (BI Tools & Dashboards): build interactive Tableau or Power BI dashboards that tell a business story. Cover the analytics topics from Section 8 (A/B testing design, sample size calculation, Bayesian A/B testing, causal inference basics, business metrics and KPI design). Build two projects: one time-series forecasting project and one interactive BI dashboard.',
        monthsHint: 'Months 13–18 (Month 13-14: Time-Series Forecasting, SHAP & Advanced ML | Month 15-16: A/B Testing Design, Causal Inference & Business Metrics | Month 17-18: Tableau/Power BI Dashboard & Portfolio Projects)',
        tracks: [
          {
            name: 'Advanced ML & Analytics',
            roadmapId: ROADMAP_IDS.DATA_SCIENTIST,
            icon: 'brain',
            progressHint: 'Complete Section 6 (advanced): XGBoost/LightGBM/CatBoost with Optuna, SHAP interpretability (summary plots, waterfall plots, dependence plots), time-series (ARIMA/SARIMA, Prophet, LSTM for time-series, lag features, rolling statistics, STL decomposition), A/B testing (experiment design, power calculation, t-tests/chi-squared, sequential testing, Bonferroni correction), causal inference (DiD basics, PSM).',
          },
          {
            name: 'BI Tools & Dashboards',
            roadmapId: ROADMAP_IDS.DATA_SCIENTIST,
            icon: 'chart',
            progressHint: 'Complete Section 5: BI Tools & Dashboards — Tableau (data connections, calculated fields, LOD expressions, dashboard design, storytelling) or Power BI (Power Query, DAX measures, report design, publishing). Build 2 dashboards: (1) business KPI monitoring dashboard, (2) ML model performance dashboard. Both should tell a clear data story and be shareable via public Tableau Public or Power BI embed.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: Data Engineering & Production Pipelines',
        description: 'Cover Data Scientist Section 7 (Big Data & Data Engineering Basics): Spark fundamentals (PySpark DataFrames, Spark SQL, MLlib), Apache Airflow for pipeline orchestration (DAGs, operators, scheduling), cloud data warehouses (BigQuery or Snowflake), and data lake architecture. Cover Python Sections 16–17 (Concurrency and Standard Library) for efficient data processing scripts. Build an end-to-end pipeline: raw data → Airflow-orchestrated ETL → cloud warehouse → automated dashboard refresh. Also study Section 8 (Communication, Deployment & Career): presenting findings to non-technical stakeholders, writing data science reports, and deploying models as APIs with FastAPI.',
        monthsHint: 'Months 19–24 (Month 19-20: PySpark, Airflow DAGs & Cloud Warehouse | Month 21-22: End-to-End Pipeline Project | Month 23-24: Model Deployment, Communication Skills & Portfolio Polish)',
        tracks: [
          {
            name: 'Data Engineering & BI',
            roadmapId: ROADMAP_IDS.DATA_SCIENTIST,
            icon: 'database',
            progressHint: 'Complete Sections 7–8: Big Data & Data Engineering (PySpark DataFrames/SQL/MLlib, Apache Airflow DAGs and operators, BigQuery or Snowflake, data lake vs warehouse, ETL vs ELT, Delta Lake basics) → Communication, Deployment & Career (FastAPI for model deployment, stakeholder communication, DS reports and presentations, model cards, portfolio building). Project: automated Airflow pipeline → cloud warehouse → live dashboard.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'DS interview prep across all four pillars: statistics, SQL, ML, and communication. Prepare statistics conceptually and quantitatively — be ready for on-the-spot hypothesis testing questions and A/B testing scenario design. Practice SQL live coding daily with a timer — window function problems are the most commonly failed in DS interviews. Review ML theory and practice business-framed case studies. Polish your Kaggle portfolio and dashboards. Research companies — DS roles vary enormously by company (some are 80% analytics, some are 80% ML, some are 80% data engineering) and you should tailor your preparation accordingly.',
        monthsHint: 'Months 25–30 (Month 25-26: Statistics Intensive & SQL Live Coding Practice | Month 27-28: ML Case Studies, Business Analytics & Portfolio | Month 29-30: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 SQL problems (timed, 30 min each) + 1 stats/ML concept. Weekly: 1 SQL mock + 1 DS case study. Targets: Statistics Q&A (50 Q), SQL interview Q&A (50 Q — window functions essential), ML theory Q&A (50 Q), DS business case studies (20 scenarios), Kaggle portfolio (2+ competitions), 1 BI dashboard (Tableau/Power BI), resume reviewed',
          },
        ],
      },
    ],
  },

  // ── Journey 3: Sem 3→6 (4 semesters) ──
  3: {
    title: 'Data Scientist — Accelerated 4-Semester Journey',
    milestones: [
      {
        semester: 3,
        title: 'Semester 3: Python, Statistics & SQL Sprint',
        description: 'With 4 semesters, compress the foundations into one dense semester. Python Sections 1–9 in Month 1–2 (focus on data structures, OOP, and comprehensions). Data Scientist Sections 1–3 from Month 2–6 in parallel: Statistics & Probability (hypothesis testing and distributions are highest priority), Python for Data Science (NumPy, Pandas, Matplotlib), and SQL for Data Science (JOINs, CTEs, and window functions are the must-haves). Implement statistics in NumPy as you learn each concept. Practice SQL problems daily on StrataScratch or LeetCode. By Month 6, have completed a full EDA project and solved 30+ SQL problems including at least 10 window function problems.',
        monthsHint: 'Months 1–6 (Month 1-2: Python OOP & Data Structures | Month 3-4: Statistics, Pandas & SQL JOINs/CTEs | Month 5-6: SQL Window Functions, StrataScratch Practice & EDA Project)',
        tracks: [
          {
            name: 'Python Basics',
            roadmapId: ROADMAP_IDS.PYTHON_BASICS,
            icon: 'code',
            progressHint: 'Complete Sections 1–9: Introduction through Magic Methods. Prioritize Sections 5–6 (data structures) and Sections 8–9 (OOP) — these are what you use daily in Pandas and Scikit-learn. Skip deep dives into Sections 11–15 for now.',
          },
          {
            name: 'Stats & SQL',
            roadmapId: ROADMAP_IDS.DATA_SCIENTIST,
            icon: 'chart',
            progressHint: 'Complete Sections 1–3: Statistics & Probability (descriptive stats, distributions, hypothesis testing, confidence intervals, p-values, A/B testing basics) → Python for Data Science (NumPy, Pandas, Matplotlib/Seaborn) → SQL for Data Science (JOINs, subqueries, CTEs, window functions — ROW_NUMBER/LAG/LEAD/running totals, date functions). 30+ SQL problems on LeetCode/StrataScratch. Full EDA project on public dataset.',
          },
        ],
      },
      {
        semester: 4,
        title: 'Semester 4: ML, Advanced Analytics & Dashboards',
        description: 'Cover Data Scientist Sections 4–6: Data Wrangling & EDA (missing values, feature engineering, correlation analysis), BI Tools & Dashboards (Tableau or Power BI), and Machine Learning (all classical algorithms, ensemble methods, time-series forecasting, SHAP interpretability, A/B testing, Optuna hyperparameter tuning). This is the most ML-intensive semester. Run EDA/ML in parallel with dashboard building so you are always connecting data insights to visual storytelling. Build two projects: one complete Kaggle ML pipeline and one interactive BI dashboard connected to real data.',
        monthsHint: 'Months 7–12 (Month 7-8: EDA, Feature Engineering & Scikit-learn Pipelines | Month 9-10: XGBoost/LightGBM, SHAP & Time-Series Forecasting | Month 11-12: A/B Testing, Tableau/Power BI Dashboard & Kaggle Competition)',
        tracks: [
          {
            name: 'ML & Advanced Analytics',
            roadmapId: ROADMAP_IDS.DATA_SCIENTIST,
            icon: 'brain',
            progressHint: 'Complete Sections 4 & 6: Data Wrangling & EDA (missing value imputation, outlier treatment, categorical encoding, feature engineering, datetime features) → Machine Learning (Linear/Logistic Regression, Decision Trees, Random Forests, XGBoost/LightGBM/CatBoost with Optuna, K-Means, PCA, t-SNE, cross-validation, SHAP values, time-series — ARIMA/Prophet/LSTM, A/B testing design and analysis). Kaggle competition with complete ML pipeline.',
          },
          {
            name: 'BI Tools & Dashboards',
            roadmapId: ROADMAP_IDS.DATA_SCIENTIST,
            icon: 'chart',
            progressHint: 'Complete Section 5: Tableau or Power BI — data connections, calculated fields, LOD expressions (Tableau) or DAX measures (Power BI), interactive filters, dashboard design principles, storytelling with data. Build 1 interactive public dashboard (Tableau Public or Power BI embed) with a clear business narrative and at least 5 chart types.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: Data Engineering, MLOps & Portfolio',
        description: 'Cover Data Scientist Sections 7–8: Big Data & Data Engineering (PySpark, Airflow, cloud warehouses) and Communication, Deployment & Career (FastAPI model deployment, stakeholder communication, model cards). Build an end-to-end automated data pipeline as a portfolio anchor project: raw data ingestion → Airflow ETL → cloud warehouse → dashboard refresh — all documented and automated. Study Python Sections 16–17 (Concurrency, Standard Library) for efficient pipeline scripting. Polish all portfolio projects: each should have a GitHub README with architecture diagrams, business context, key findings, and reproducible code.',
        monthsHint: 'Months 13–18 (Month 13-14: PySpark, Airflow & Cloud Warehouse | Month 15-16: End-to-End Pipeline Project | Month 17-18: Model Deployment, Portfolio Polish & Section 8)',
        tracks: [
          {
            name: 'Data Engineering & BI',
            roadmapId: ROADMAP_IDS.DATA_SCIENTIST,
            icon: 'database',
            progressHint: 'Complete Sections 7–8: Big Data Basics (PySpark DataFrames, Spark SQL, PySpark MLlib basics, running on Databricks or Colab) → Airflow (DAG design, PythonOperator/SQLOperator, scheduling, monitoring) → Cloud Data Warehouse (BigQuery or Snowflake — partitioning, clustering, dbt basics) → Communication & Deployment (FastAPI model API, stakeholder presentations, model cards, portfolio READMEs). Pipeline project: automated raw data → Airflow → warehouse → dashboard.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Sprint',
        description: 'Four semesters is lean, so placement prep must be precise. Focus your interview preparation on the three highest-weight areas for DS roles: SQL live coding (window functions, CTEs, aggregations — practice until you can solve hard problems in under 20 minutes), statistics and A/B testing (be ready for scenario questions: "design an A/B test for this feature", "interpret these p-values"), and ML case studies (business-framed: "build a churn model for this telecom company, what features would you engineer?"). Apply broadly and research each company\'s DS role type before interviews.',
        monthsHint: 'Months 19–24 (Month 19-20: SQL & Statistics Intensive | Month 21-22: ML Case Studies & Mock Interviews | Month 23-24: Campus Drives & Applications)',
        tracks: [
          {
            name: 'Placement Sprint',
            icon: 'book',
            progressHint: 'Daily: 2 SQL problems (timed) + 1 stats/ML Q&A. Weekly: 1 SQL mock + 1 DS case study. Targets: Statistics Q&A (50 Q), SQL Q&A (50 Q — window functions critical), ML theory Q&A (50 Q), 20 DS business case studies, Kaggle portfolio (2+ competitions), 1 interactive dashboard, 1 data pipeline project on GitHub, resume reviewed',
          },
        ],
      },
    ],
  },

  // ── Journey 4: Sem 4→6 (3 semesters) ──
  4: {
    title: 'Data Scientist — Fast-Track 3-Semester Journey',
    milestones: [
      {
        semester: 4,
        title: 'Semester 4: Python, Statistics, SQL & Classical ML',
        description: 'Three semesters demands maximum efficiency — run all foundational tracks simultaneously from Month 1. Python Sections 1–9 (focus on data structures and OOP) in Month 1–2. Data Scientist Sections 1–3 (statistics, Python data stack, SQL) from Month 2–4. Data Scientist Sections 4 and 6 intro (EDA and classical ML) from Month 4–6. The overlapping timelines are intentional — practice SQL on datasets you are also exploring with Pandas, and implement the same statistics you are learning in NumPy. Target by Month 6: 40+ SQL problems solved (including window functions), one full EDA project, and a working Scikit-learn ML pipeline.',
        monthsHint: 'Months 1–6 (Month 1-2: Python OOP & Statistics Foundations | Month 3-4: NumPy/Pandas, SQL Window Functions & EDA | Month 5-6: Scikit-learn Classical ML Pipeline & Kaggle Entry)',
        tracks: [
          {
            name: 'DS Fundamentals',
            roadmapId: ROADMAP_IDS.DATA_SCIENTIST,
            icon: 'chart',
            progressHint: 'Python Sections 1–9 (prioritize data structures and OOP). Data Scientist Sections 1–4: Statistics & Probability (hypothesis testing, distributions, A/B testing foundations) → Python Data Tooling (NumPy, Pandas, Matplotlib/Seaborn) → SQL (JOINs, CTEs, window functions — 40+ StrataScratch/LeetCode problems) → Data Wrangling & EDA (missing values, feature engineering, correlation analysis). Begin Section 6: Scikit-learn pipelines and classical ML algorithms. Kaggle entry by Month 6.',
          },
        ],
      },
      {
        semester: 5,
        title: 'Semester 5: Advanced ML, BI Dashboards & Data Engineering',
        description: 'Complete the remaining Data Scientist sections in one semester. Section 5 (BI Tools & Dashboards): build at least one published Tableau or Power BI dashboard. Section 6 advanced (XGBoost/LightGBM, SHAP, time-series forecasting with Prophet, A/B testing design and analysis, Optuna tuning). Section 7 (Big Data & Data Engineering: PySpark basics, Airflow DAGs, cloud warehouse). Section 8 (Communication & Deployment: FastAPI model serving, stakeholder communication, model cards). Build two portfolio projects: one complete ML pipeline with SHAP explanations and one automated data pipeline with dashboard.',
        monthsHint: 'Months 7–12 (Month 7-8: XGBoost/LightGBM, SHAP, Time-Series & A/B Testing | Month 9-10: Tableau/Power BI Dashboard & PySpark/Airflow Intro | Month 11-12: FastAPI Model Deployment, Pipeline Project & Portfolio Polish)',
        tracks: [
          {
            name: 'DS Capstone Project',
            roadmapId: ROADMAP_IDS.DATA_SCIENTIST,
            icon: 'terminal',
            progressHint: 'Complete Sections 5–8: BI Dashboards (Tableau or Power BI — 1 published interactive dashboard) → ML Advanced (XGBoost/LightGBM/CatBoost with Optuna, SHAP values, time-series — Prophet/LSTM, A/B testing and causal inference) → Data Engineering Basics (PySpark DataFrames, Airflow DAG basics, BigQuery or Snowflake intro) → Communication & Deployment (FastAPI model endpoint, model card, stakeholder presentation). Projects: ML pipeline with SHAP + automated data pipeline.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: Placement Preparation',
        description: 'Three semesters is a tight runway — placement prep must be surgical. Prioritize the three highest-weight DS interview areas: SQL (window functions and complex aggregations — practice until hard problems take under 20 minutes), statistics and A/B testing (scenario-based questions — "design an experiment for X", "what does this p-value mean?"), and ML case studies (business-framed — "recommend a model for fraud detection, justify your feature choices and evaluation metric"). Research company-specific DS role types before every interview — DS roles vary enormously by company.',
        monthsHint: 'Months 13–18 (Month 13-14: SQL Intensive & Statistics Revision | Month 15-16: Mock Interviews, ML Case Studies & Applications | Month 17-18: Campus Drives & Placements)',
        tracks: [
          {
            name: 'Interview Prep',
            icon: 'book',
            progressHint: 'Daily: 2 SQL problems (timed, 30 min) + 1 stats/ML concept revision. Weekly: 1 SQL mock + 1 ML case study discussion. Targets: Statistics Q&A (50 Q), SQL Q&A (50 Q — window functions mandatory), ML theory Q&A (50 Q), 15 DS business case studies, Kaggle portfolio (1+ competition with public notebook), 1 Tableau/Power BI dashboard, 1 pipeline project on GitHub, resume reviewed',
          },
        ],
      },
    ],
  },

  // ── Journey 5: Sem 5→6 (2 semesters) ──
  5: {
    title: 'Data Scientist — Crash Course 2-Semester Journey',
    milestones: [
      {
        semester: 5,
        title: 'Semester 5: Emergency DS Sprint',
        description: 'Two semesters means ruthless prioritization — focus on the highest-yield skills for DS interviews. Month 1: Python essentials (Sections 1–9, 6 weeks) and Statistics foundations (Data Scientist Section 1 — probability distributions and hypothesis testing are the priority) simultaneously. Month 2: Pandas and Matplotlib (Data Scientist Section 2) and SQL JOINs, CTEs, and window functions (Data Scientist Section 3 — window functions are tested in almost every DS interview; solve 40+ problems on StrataScratch). Month 3: EDA and feature engineering (Data Scientist Section 4) and classical ML with Scikit-learn (Data Scientist Section 6 basics — linear/logistic regression, random forests, XGBoost, cross-validation, ROC-AUC). Month 4: Advanced ML (SHAP values, time-series with Prophet, A/B testing design). Month 5: BI dashboard in Tableau or Power BI (Data Scientist Section 5) and FastAPI model deployment (Data Scientist Section 8). Month 6: Polish everything, enter a Kaggle competition, and publish projects on GitHub.',
        monthsHint: 'Months 1–6 (Month 1-2: Python, Statistics & SQL Window Functions Sprint | Month 3-4: Pandas EDA, Scikit-learn ML Pipeline & XGBoost | Month 5-6: SHAP, A/B Testing, Tableau/Power BI Dashboard & Kaggle Entry)',
        tracks: [
          {
            name: 'DS Foundation Sprint',
            roadmapId: ROADMAP_IDS.PYTHON_BASICS,
            icon: 'code',
            progressHint: 'Python Sections 1–9 (prioritize OOP and data structures — 6 weeks). Data Scientist Sections 1–4: Statistics & Probability (distributions, hypothesis testing, A/B testing) → Python Data Tooling (NumPy, Pandas, Matplotlib/Seaborn) → SQL (JOINs, CTEs, window functions — 40+ StrataScratch/LeetCode problems) → EDA & Feature Engineering (missing values, encoding, scaling, correlation).',
          },
          {
            name: 'DS Project Sprint',
            roadmapId: ROADMAP_IDS.DATA_SCIENTIST,
            icon: 'terminal',
            progressHint: 'Fast-track Sections 5–8: ML (Scikit-learn pipelines, XGBoost/LightGBM with Optuna, SHAP interpretability, time-series with Prophet, A/B testing analysis) → BI Dashboard (Tableau Public or Power BI — 1 published interactive dashboard) → Data Engineering basics (Airflow intro, BigQuery or Snowflake intro) → Deployment (FastAPI model endpoint). Deliverables: 1 Kaggle competition entry with public notebook, 1 published BI dashboard, 1 FastAPI model endpoint on GitHub.',
          },
        ],
      },
      {
        semester: 6,
        title: 'Semester 6: All-In Placement Sprint',
        description: 'All execution — no new learning. The projects from Semester 5 are your primary resume assets. Month 1: SQL intensive — solve 3 hard window function problems daily on StrataScratch until you can solve any SQL interview problem in under 20 minutes. Month 2: Mock interview marathon — statistics scenarios, ML case studies, and SQL live coding. Month 3: Application blitz. Month 4–6: Active drives, interview rounds. A key insight: DS roles vary enormously — some companies test heavily on ML, others on SQL and statistics, others on data engineering. Research each company\'s interview format before every application and tailor your preparation accordingly.',
        monthsHint: 'Months 7–12 (Month 7-8: SQL Hard Problems & Statistics Intensive | Month 9-10: Mock Interviews, ML Case Studies & Applications | Month 11-12: Campus Drives & Active Placements)',
        tracks: [
          {
            name: 'Placement Sprint',
            icon: 'book',
            progressHint: 'Daily: 3 SQL problems (StrataScratch hard — window functions focus) + 1 stats concept. Weekly: 3 mock interviews (mix of SQL live coding, statistics scenarios, ML case studies). Targets: Statistics Q&A (50 Q), SQL Q&A (50 Q — window functions critical), ML theory Q&A (50 Q), 15 DS business case studies, Kaggle competition notebook published, 1 interactive BI dashboard, resume reviewed, company-specific preparation for top 5 target companies',
          },
        ],
      },
    ],
  },
};

// ── Main config export ──
// Keyed: journeyConfigs[role][framework][startingSemester]
export const journeyConfigs: Record<string, Record<string, Record<number, JourneyConfig>>> = {
  SDE: {
    SPRING_BOOT: sdeSpringBoot,
    NODE_JS: sdeNodeJs,
    PYTHON_FASTAPI: sdePythonFastApi,
    CPP: sdeCpp,
    CP: sdeCp,
  },
  FULL_STACK: {
    SPRING_BOOT: fullStackSpringBoot,
    NODE_JS: fullStackNodeJs,
    PYTHON_FASTAPI: fullStackPythonFastApi,
    CPP: sdeCpp,
    CP: sdeCp,
  },
  AI_ML: {
    PYTHON: aiMlPython,
  },
  DATA_SCIENTIST: {
    PYTHON: dataScientistPython,
  },
};

/**
 * Lookup helper.
 * Returns the journey config for the given profile, or null if not found / empty.
 */
export function getJourneyConfig(
  role: string | null | undefined,
  framework: string | null | undefined,
  startingSemester: number | null | undefined,
): JourneyConfig | null {
  if (!role || !framework || !startingSemester) return null;
  const config = journeyConfigs[role]?.[framework]?.[startingSemester] ?? null;
  if (!config || config.milestones.length === 0) return null;
  return config;
}