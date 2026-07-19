// Journey configuration for CareerForge
// Each unique (role × framework × startingSemester) combination has a distinct
// compressed timeline with different pacing.
//
// IMPORTANT: Replace roadmapId values with actual UUIDs from your database.
// You can find them via Admin → Manage Roadmaps, or:
//   SELECT id, title FROM roadmaps;

export interface JourneyTrack {
  name: string;
  roadmapId?: string; // UUID from the roadmaps table — optional until configured
  icon: 'code' | 'brain' | 'layout' | 'database' | 'server' | 'terminal' | 'book' | 'chart';
}

export interface JourneyMilestone {
  semester: number;
  title: string;
  description: string;
  monthsHint: string; // e.g. "Months 1-6"
  tracks: JourneyTrack[];
}

export interface JourneyConfig {
  title: string;
  milestones: JourneyMilestone[];
}

// ─────────────────────────────────────────────────────────────────
//  Known roadmap UUIDs  (update whenever new roadmaps are seeded)
// ─────────────────────────────────────────────────────────────────
const ROADMAP_IDS = {
  DSA:            '678147d4-7a2b-4881-aeea-b7b93bbd6620',
  SPRING_BOOT:    'bb65912f-f26c-4435-a34f-3245665896b9',
  FRONTEND:       'fbd6a424-8f9d-48c5-af3c-00a61026937b',
  MERN:           'b6a9bc46-c137-441b-b3d2-694146302cd3',
  FASTAPI:        'eab547d3-2704-4733-8959-5189537f2152',
  AIML:           'c4b75718-e191-4a66-940b-eeb592a075dd',
  DATA_SCIENTIST: '62f180b5-f911-42f0-a367-a1499e4ac6cb',
};

// ═══════════════════════════════════════════════════════
//  SDE → SPRING_BOOT
// ═══════════════════════════════════════════════════════

const sdeSpringBoot: Record<number, JourneyConfig> = {

  // ── Journey 1: Sem 1→6  (Relaxed, 6 semesters) ──
  1: {
    title: 'SDE + Spring Boot — Full Journey',
    milestones: [
      {
        semester: 1,
        title: 'Programming Foundations',
        description: 'Master programming basics with Java. Learn variables, loops, conditionals, functions, and OOP fundamentals. Set up Git and practice version control workflows.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'DSA Fundamentals', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 2,
        title: 'Core Data Structures & Algorithms',
        description: 'Dive into arrays, strings, linked lists, stacks, and queues. Solve 50+ problems to build pattern recognition. Start learning HTML/CSS/JS basics.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'DSA Intermediate', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 3,
        title: 'Advanced DSA & Backend Intro',
        description: 'Trees, graphs, dynamic programming, and greedy algorithms. Begin Spring Boot fundamentals — REST APIs, dependency injection, and JPA/Hibernate basics.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'DSA Advanced', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'Spring Boot Basics', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'server' },
        ],
      },
      {
        semester: 4,
        title: 'Full Stack Development',
        description: 'Build complete Spring Boot applications with authentication, database integration, and RESTful APIs. Learn React for frontend development. Start building portfolio projects.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'Spring Boot Backend', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'server' },
          { name: 'React Frontend', roadmapId: ROADMAP_IDS.FRONTEND, icon: 'layout' },
        ],
      },
      {
        semester: 5,
        title: 'System Design & Projects',
        description: 'Learn system design — load balancing, caching, database sharding, microservices. Build 2–3 full-stack projects for your portfolio. Start competitive programming.',
        monthsHint: 'Months 25–30',
        tracks: [
          { name: 'System Design', icon: 'brain' },
          { name: 'Portfolio Projects', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'terminal' },
        ],
      },
      {
        semester: 6,
        title: 'Interview Preparation & Placement',
        description: 'Intensive mock interviews, resume building, and final revision of DSA + system design. Apply for internships and placements. Practice behavioral interview skills.',
        monthsHint: 'Months 31–36',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  // ── Journey 2: Sem 2→6  (Normal, 5 semesters) ──
  2: {
    title: 'SDE + Spring Boot — Normal Pace',
    milestones: [
      {
        semester: 2,
        title: 'Programming & DSA Kickstart',
        description: 'Accelerated programming foundations plus core data structures. Cover arrays, strings, linked lists, and basic sorting/searching. Git and version control.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'DSA Fundamentals', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 3,
        title: 'Advanced DSA Deep Dive',
        description: 'Trees, graphs, DP, backtracking, and advanced patterns. Target 100+ problems solved. Begin exploring Spring Boot basics alongside.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'DSA Advanced', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'Spring Boot Intro', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'server' },
        ],
      },
      {
        semester: 4,
        title: 'Backend Development & Projects',
        description: 'Full Spring Boot development — REST APIs, security, JPA, microservices intro. Build 1–2 backend projects. Start React fundamentals.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'Spring Boot Backend', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'server' },
        ],
      },
      {
        semester: 5,
        title: 'Full Stack & System Design',
        description: 'Complete full-stack projects with React + Spring Boot. Learn system design patterns, scalability concepts, and architecture principles.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'System Design', icon: 'brain' },
          { name: 'Full Stack Projects', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'terminal' },
        ],
      },
      {
        semester: 6,
        title: 'Placement Preparation',
        description: 'Mock interviews, resume polishing, company-specific prep. Final DSA revision and system design practice. Apply aggressively.',
        monthsHint: 'Months 25–30',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  // ── Journey 3: Sem 3→6  (Moderate, 4 semesters) ──
  3: {
    title: 'SDE + Spring Boot — Accelerated',
    milestones: [
      {
        semester: 3,
        title: 'Intensive DSA Bootcamp',
        description: 'Compressed DSA covering fundamentals through advanced topics. Arrays, trees, graphs, DP — aim for 80+ problems. Parallel: Java + Spring Boot setup.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'DSA Complete', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 4,
        title: 'Backend + Frontend Sprint',
        description: 'Rapid Spring Boot development — build 2 production-grade APIs. Learn React essentials. Create one full-stack project for your portfolio.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Spring Boot Backend', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'server' },
          { name: 'React Basics', roadmapId: ROADMAP_IDS.FRONTEND, icon: 'layout' },
        ],
      },
      {
        semester: 5,
        title: 'System Design & Advanced Projects',
        description: 'System design fundamentals + one complex capstone project. Continue solving DSA problems daily. Start mock interview practice.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'System Design', icon: 'brain' },
          { name: 'Capstone Project', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'terminal' },
        ],
      },
      {
        semester: 6,
        title: 'Interview Sprint & Placement',
        description: 'Full-time interview preparation. Daily DSA practice, weekly mocks, resume reviews. Target 200+ problems total. Apply for placements.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  // ── Journey 4: Sem 4→6  (Accelerated, 3 semesters) ──
  4: {
    title: 'SDE + Spring Boot — Fast Track',
    milestones: [
      {
        semester: 4,
        title: 'DSA Crash Course + Spring Boot Basics',
        description: 'Accelerated DSA covering all essential topics in one semester. Simultaneously learn Spring Boot fundamentals — REST APIs, JPA, security basics.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'DSA Crash Course', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'Spring Boot Basics', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'server' },
        ],
      },
      {
        semester: 5,
        title: 'Full Stack Project + System Design',
        description: 'Build one impressive full-stack project (React + Spring Boot). Learn core system design concepts. Continue daily DSA — target 150+ problems.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Full Stack Project', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'terminal' },
          { name: 'System Design', icon: 'brain' },
        ],
      },
      {
        semester: 6,
        title: 'Intensive Interview Prep',
        description: 'All-in placement preparation. Mock interviews 2× per week, company-targeted practice, resume + LinkedIn optimization. Apply broadly.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  // ── Journey 5: Sem 5→6  (Crash Course, 2 semesters) ──
  5: {
    title: 'SDE + Spring Boot — Crash Course',
    milestones: [
      {
        semester: 5,
        title: 'Emergency DSA + Development Sprint',
        description: 'Intensive daily DSA grinding — focus on top 100 interview problems. Rapidly build one project using Spring Boot + React for your resume.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'Top 100 DSA Problems', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'Quick Project', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'server' },
        ],
      },
      {
        semester: 6,
        title: 'Interview-Ready Sprint',
        description: 'Pure placement focus. Daily mocks, targeted company prep, behavioral questions, system design basics. Apply to every opportunity.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
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
    title: 'SDE + Node.js — Full Journey',
    milestones: [
      {
        semester: 1,
        title: 'JavaScript & Programming Basics',
        description: 'Master JavaScript fundamentals — variables, closures, async/await, and ES6+. Set up Node.js environment. Git basics and terminal proficiency.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'DSA Fundamentals', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'JavaScript Fundamentals', roadmapId: ROADMAP_IDS.MERN, icon: 'layout' },
        ],
      },
      {
        semester: 2,
        title: 'Core DSA & Node.js Basics',
        description: 'Arrays, strings, linked lists, stacks, queues — 50+ problems. Build your first Node.js + Express REST API. Learn npm ecosystem and basic middleware.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'DSA Intermediate', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'Node.js Basics', roadmapId: ROADMAP_IDS.MERN, icon: 'server' },
        ],
      },
      {
        semester: 3,
        title: 'Advanced DSA & Backend Development',
        description: 'Trees, graphs, DP, and advanced patterns. Build full Express.js APIs with authentication (JWT), MongoDB/PostgreSQL integration, and error handling.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'DSA Advanced', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'Express.js Backend', roadmapId: ROADMAP_IDS.MERN, icon: 'server' },
        ],
      },
      {
        semester: 4,
        title: 'Full Stack & React',
        description: 'Combine Node.js backend with React frontend. Build 2 full-stack projects with user authentication, real-time features (Socket.io), and deployment.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'Full Stack Development', roadmapId: ROADMAP_IDS.MERN, icon: 'terminal' },
        ],
      },
      {
        semester: 5,
        title: 'System Design & DevOps',
        description: 'Learn system design principles with Node.js specifics — event loop, clustering, microservices. Add Docker and CI/CD basics to your skill set.',
        monthsHint: 'Months 25–30',
        tracks: [
          { name: 'System Design', icon: 'brain' },
          { name: 'DevOps Basics', icon: 'database' },
        ],
      },
      {
        semester: 6,
        title: 'Interview Preparation & Placement',
        description: 'Intensive mock interviews, resume polish, and company-specific JavaScript/Node.js prep. Daily DSA practice and system design revisions. Apply broadly.',
        monthsHint: 'Months 31–36',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  2: {
    title: 'SDE + Node.js — Normal Pace',
    milestones: [
      {
        semester: 2,
        title: 'JS Foundations + DSA Kickstart',
        description: 'Master JavaScript ES6+ thoroughly. Core DSA: arrays, strings, linked lists, sorting. Build first simple Express API.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'DSA Fundamentals', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'JavaScript Fundamentals', roadmapId: ROADMAP_IDS.MERN, icon: 'layout' },
        ],
      },
      {
        semester: 3,
        title: 'Advanced DSA + Node.js Backend',
        description: 'Trees, graphs, DP and recursion. Build production-ready Express.js APIs — auth, MongoDB, validation. Target 100+ DSA problems.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'DSA Advanced', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'Node.js Backend', roadmapId: ROADMAP_IDS.MERN, icon: 'server' },
        ],
      },
      {
        semester: 4,
        title: 'Full Stack Development',
        description: 'Learn React and build 2 complete MERN stack projects. Add real-time features (WebSockets), file uploads, and third-party integrations.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'Full Stack Development', roadmapId: ROADMAP_IDS.MERN, icon: 'terminal' },
        ],
      },
      {
        semester: 5,
        title: 'System Design & Optimization',
        description: 'System design for distributed Node.js apps — caching with Redis, message queues, database optimization. Contribute to open source.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'System Design', icon: 'brain' },
          { name: 'Advanced Node.js', roadmapId: ROADMAP_IDS.MERN, icon: 'server' },
        ],
      },
      {
        semester: 6,
        title: 'Placement Preparation',
        description: 'Mock interviews, LeetCode grind, company-specific JavaScript challenges. System design interviews. Resume and LinkedIn optimization. Apply aggressively.',
        monthsHint: 'Months 25–30',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  3: {
    title: 'SDE + Node.js — Accelerated',
    milestones: [
      {
        semester: 3,
        title: 'DSA Bootcamp + JS Mastery',
        description: 'Intensive DSA covering all fundamentals through advanced topics (80+ problems). Master JavaScript async patterns and Node.js event loop deeply.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'DSA Complete', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'JavaScript Fundamentals', roadmapId: ROADMAP_IDS.MERN, icon: 'layout' },
        ],
      },
      {
        semester: 4,
        title: 'Full Backend + MERN Project',
        description: 'Build 2 production APIs with Node.js + Express. Learn React rapidly. Deploy one complete MERN stack application.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'MERN Project', roadmapId: ROADMAP_IDS.MERN, icon: 'terminal' },
        ],
      },
      {
        semester: 5,
        title: 'System Design & Advanced Topics',
        description: 'Microservices with Node.js, Redis caching, message queues. One capstone project. Continue DSA practice and mock interviews.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'System Design', icon: 'brain' },
          { name: 'Capstone Project', roadmapId: ROADMAP_IDS.MERN, icon: 'terminal' },
        ],
      },
      {
        semester: 6,
        title: 'Interview Sprint & Placement',
        description: 'Full-time placement prep. Weekly mock interviews, behavioral practice, system design rounds. Target 200+ LeetCode problems. Apply broadly.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  4: {
    title: 'SDE + Node.js — Fast Track',
    milestones: [
      {
        semester: 4,
        title: 'DSA Crash + Node.js Fundamentals',
        description: 'Rapid DSA covering essential interview patterns. Learn Node.js, Express, and MongoDB simultaneously. Build a simple REST API with auth.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'DSA Crash Course', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'Node.js Basics', roadmapId: ROADMAP_IDS.MERN, icon: 'server' },
        ],
      },
      {
        semester: 5,
        title: 'MERN Stack Project + System Design',
        description: 'Build a complete MERN stack application for your portfolio. Learn core system design — scalability, databases, caching. 150+ DSA problems total.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'MERN Project', roadmapId: ROADMAP_IDS.MERN, icon: 'terminal' },
          { name: 'System Design', icon: 'brain' },
        ],
      },
      {
        semester: 6,
        title: 'Intensive Interview Prep',
        description: 'All-in placement focus. Daily problem solving, mock interviews twice weekly, company-targeted JavaScript prep. Optimize your resume and apply.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  5: {
    title: 'SDE + Node.js — Crash Course',
    milestones: [
      {
        semester: 5,
        title: 'Top 100 DSA + Quick Node.js Project',
        description: 'Focus on the most common 100 interview problems. Rapidly build one MERN stack project to demonstrate full-stack ability on your resume.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'Top 100 DSA', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'MERN Development', roadmapId: ROADMAP_IDS.MERN, icon: 'terminal' },
        ],
      },
      {
        semester: 6,
        title: 'Interview-Ready Sprint',
        description: 'Pure placement focus. Daily JavaScript interview questions, system design basics, behavioral prep. Apply to every suitable opening immediately.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
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
    title: 'SDE + Python FastAPI — Full Journey',
    milestones: [
      {
        semester: 1,
        title: 'Python Foundations & DSA Intro',
        description: 'Master Python deeply — OOP, decorators, generators, async/await, and type hints. Set up virtual environments and tooling. Begin DSA with Python.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'DSA Fundamentals', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 2,
        title: 'Core DSA & Python Ecosystem',
        description: 'Arrays, strings, linked lists, and trees with Python. Explore the Python ecosystem: pytest, type hints, Pydantic. Build CLI tools for practice.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'DSA Intermediate', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 3,
        title: 'Advanced DSA & FastAPI Basics',
        description: 'Graphs, DP, and advanced problem patterns. Learn FastAPI — async routes, dependency injection, Pydantic schemas, and PostgreSQL with SQLAlchemy.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'DSA Advanced', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'FastAPI Basics', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'server' },
        ],
      },
      {
        semester: 4,
        title: 'Backend APIs & Frontend Integration',
        description: 'Build production FastAPI services with JWT auth, background tasks, and Celery. Add a React or Vue frontend. Deploy to cloud (AWS/GCP).',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'FastAPI Production', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'server' },
          { name: 'Frontend Basics', roadmapId: ROADMAP_IDS.FRONTEND, icon: 'layout' },
        ],
      },
      {
        semester: 5,
        title: 'System Design & Microservices',
        description: 'Design distributed systems with Python — FastAPI microservices, Redis, message queues (RabbitMQ/Kafka). Learn Docker and Kubernetes basics.',
        monthsHint: 'Months 25–30',
        tracks: [
          { name: 'System Design', icon: 'brain' },
          { name: 'Cloud & DevOps', icon: 'database' },
        ],
      },
      {
        semester: 6,
        title: 'Interview Preparation & Placement',
        description: 'Final DSA revision, system design mocks, and Python-specific interview prep. Polish portfolio and resume. Apply for SDE roles at product companies.',
        monthsHint: 'Months 31–36',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  2: {
    title: 'SDE + Python FastAPI — Normal Pace',
    milestones: [
      {
        semester: 2,
        title: 'Python Mastery & DSA Kickstart',
        description: 'Deep-dive into Python — async programming, type system, data classes. Core DSA: arrays, strings, linked lists, stacks. Git and collaborative workflows.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'DSA Fundamentals', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 3,
        title: 'Advanced DSA + FastAPI Backend',
        description: 'Trees, graphs, DP and backtracking. Build complete FastAPI apps with auth, database integration (PostgreSQL + Alembic), and API documentation.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'DSA Advanced', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'FastAPI Backend', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'server' },
        ],
      },
      {
        semester: 4,
        title: 'Full Stack & Projects',
        description: 'Build 2 full-stack projects with FastAPI + React/Vue. Containerize with Docker. Learn CI/CD fundamentals and deploy to a cloud provider.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'Portfolio Projects', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'terminal' },
          { name: 'DevOps Basics', icon: 'database' },
        ],
      },
      {
        semester: 5,
        title: 'System Design & Optimization',
        description: 'System design with Python microservices, async task queues, caching strategies, and database optimization. Contribute to open-source Python projects.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'System Design', icon: 'brain' },
          { name: 'Advanced Python', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'server' },
        ],
      },
      {
        semester: 6,
        title: 'Placement Preparation',
        description: 'Mock interviews, Python-focused LeetCode, system design practice. Company research and targeted applications. Resume and online presence optimization.',
        monthsHint: 'Months 25–30',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  3: {
    title: 'SDE + Python FastAPI — Accelerated',
    milestones: [
      {
        semester: 3,
        title: 'DSA Bootcamp + Python Deep Dive',
        description: 'Intensive DSA (80+ problems covering all patterns). Master Python async programming, type hints, and Pydantic. Build small FastAPI microservices.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'DSA Complete', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 4,
        title: 'FastAPI Backend + Frontend Sprint',
        description: 'Build 2 production FastAPI services with auth, background tasks, and PostgreSQL. Learn React basics. Deploy one full-stack application.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'FastAPI Production', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'server' },
        ],
      },
      {
        semester: 5,
        title: 'System Design & Capstone',
        description: 'System design fundamentals, microservices with Python, Redis and Celery integration. Build one impressive capstone project. Weekly mock interviews.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'System Design', icon: 'brain' },
          { name: 'Capstone Project', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'terminal' },
        ],
      },
      {
        semester: 6,
        title: 'Interview Sprint & Placement',
        description: 'Full-time interview preparation. Daily DSA, weekly system design mocks, behavioral rounds. Target 200+ problems. Apply aggressively.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  4: {
    title: 'SDE + Python FastAPI — Fast Track',
    milestones: [
      {
        semester: 4,
        title: 'DSA Crash + FastAPI Fundamentals',
        description: 'Rapid DSA covering essential patterns. Learn FastAPI concurrently — async routes, Pydantic, SQLAlchemy with PostgreSQL. Build a REST API with auth.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'DSA Crash Course', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'FastAPI Basics', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'server' },
        ],
      },
      {
        semester: 5,
        title: 'Full Stack Project + System Design',
        description: 'Build one impressive full-stack project (FastAPI + React). Learn core system design. 150+ DSA problems. Containerize and deploy your project.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Full Stack Project', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'terminal' },
          { name: 'System Design', icon: 'brain' },
        ],
      },
      {
        semester: 6,
        title: 'Intensive Interview Prep',
        description: 'All-in placement focus. Mock interviews 2× weekly, Python interview patterns, system design rounds. Optimize resume and LinkedIn. Apply broadly.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  5: {
    title: 'SDE + Python FastAPI — Crash Course',
    milestones: [
      {
        semester: 5,
        title: 'Top 100 DSA + Quick FastAPI Project',
        description: 'Focus on the 100 most common interview problems in Python. Rapidly build one FastAPI project with a React frontend for your resume.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'Top 100 DSA', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'FastAPI Project', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'server' },
        ],
      },
      {
        semester: 6,
        title: 'Interview-Ready Sprint',
        description: 'Pure placement focus. Python-specific interview prep, system design basics, behavioral questions. Apply to every suitable opening immediately.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
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
    title: 'Full Stack + Spring Boot — Full Journey',
    milestones: [
      {
        semester: 1,
        title: 'HTML, CSS & Java Basics',
        description: 'Build a strong foundation in HTML5, CSS3, and vanilla JavaScript. Learn Java fundamentals and OOP. Set up your development environment.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'Web Fundamentals', roadmapId: ROADMAP_IDS.FRONTEND, icon: 'layout' },
          { name: 'DSA Basics', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 2,
        title: 'React + DSA Intermediate',
        description: 'Master React — components, hooks, state management, routing. Continue DSA: linked lists, trees, sorting algorithms. Build static React projects.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'React Frontend', roadmapId: ROADMAP_IDS.FRONTEND, icon: 'layout' },
          { name: 'DSA Intermediate', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 3,
        title: 'Spring Boot Backend Intro',
        description: 'Learn Spring Boot — REST APIs, dependency injection, JPA with Hibernate, and PostgreSQL. Integrate with your React frontend. Learn Git collaboration.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'Spring Boot Basics', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'server' },
        ],
      },
      {
        semester: 4,
        title: 'Production Full Stack Projects',
        description: 'Build 2 full-stack applications with Spring Boot + React — include auth, file uploads, real-time notifications, and deployment. Contribute to GitHub.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'Spring Boot Backend', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'server' },
        ],
      },
      {
        semester: 5,
        title: 'System Design & DevOps',
        description: 'System design for full-stack apps — microservices, caching, CDN, database replication. Docker, Kubernetes basics, and CI/CD pipelines.',
        monthsHint: 'Months 25–30',
        tracks: [
          { name: 'System Design', icon: 'brain' },
          { name: 'DevOps & Cloud', icon: 'database' },
        ],
      },
      {
        semester: 6,
        title: 'Interview Prep & Placement',
        description: 'Full-stack interview preparation — DSA rounds, system design, frontend/backend specific questions. Portfolio reviews. Apply to product and startup companies.',
        monthsHint: 'Months 31–36',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  2: {
    title: 'Full Stack + Spring Boot — Normal Pace',
    milestones: [
      {
        semester: 2,
        title: 'React + DSA Kickstart',
        description: 'Accelerated React mastery — hooks, context, React Query, routing. Core DSA: arrays, strings, linked lists. Build 2 React projects.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'React Frontend', roadmapId: ROADMAP_IDS.FRONTEND, icon: 'layout' },
          { name: 'DSA Fundamentals', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 3,
        title: 'Spring Boot + DSA Intermediate',
        description: 'Build REST APIs with Spring Boot, Spring Security, JPA. Intermediate DSA: trees, graphs, DP. Connect frontend and backend in a project.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Spring Boot Backend', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'server' },
          { name: 'DSA Advanced', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 4,
        title: 'Production Projects & Portfolio',
        description: 'Build 2 production-grade full-stack apps. Add WebSockets, payment integration, email services. Deploy to AWS/GCP. Build your GitHub portfolio.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'Portfolio Projects', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'terminal' },
        ],
      },
      {
        semester: 5,
        title: 'System Design & Optimization',
        description: 'System design — horizontal scaling, caching, microservices. Performance optimization for React apps. Advanced Spring Boot patterns.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'System Design', icon: 'brain' },
          { name: 'Advanced Full Stack', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'server' },
        ],
      },
      {
        semester: 6,
        title: 'Placement Preparation',
        description: 'Mock interviews targeting full-stack roles. DSA revision, system design practice, behavioral prep. Resume polish and aggressive applications.',
        monthsHint: 'Months 25–30',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  3: {
    title: 'Full Stack + Spring Boot — Accelerated',
    milestones: [
      {
        semester: 3,
        title: 'Rapid React + Spring Boot Fundamentals',
        description: 'Learn React and Spring Boot in parallel. Build one full-stack app while doing DSA (80+ problems). Cover all essential full-stack patterns.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'React + Spring Boot', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'layout' },
            { name: 'React Frontend', roadmapId: ROADMAP_IDS.FRONTEND, icon: 'layout' },
          { name: 'DSA Bootcamp', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 4,
        title: 'Advanced Projects + Spring Security',
        description: 'Build 2 complex full-stack projects with auth, background jobs, file storage, and deployment. Master Spring Security and React advanced patterns.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Advanced Spring Boot', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'server' },
        ],
      },
      {
        semester: 5,
        title: 'System Design & Capstone',
        description: 'System design for scalable full-stack apps. Build one impressive capstone project. Continue DSA practice and start mock interviews.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'System Design', icon: 'brain' },
          { name: 'Capstone Project', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'terminal' },
        ],
      },
      {
        semester: 6,
        title: 'Interview Sprint & Placement',
        description: 'Full-time placement prep. Daily DSA, weekly full-stack system design mocks. Target companies with strong full-stack requirements. Apply aggressively.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  4: {
    title: 'Full Stack + Spring Boot — Fast Track',
    milestones: [
      {
        semester: 4,
        title: 'Full Stack Crash Course',
        description: 'Rapid React + Spring Boot fundamentals in parallel. Solve essential DSA problems. Build one simple full-stack project to establish your foundation.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'DSA Crash Course', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'Full Stack Basics', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'server' },
        ],
      },
      {
        semester: 5,
        title: 'Showcase Project + System Design',
        description: 'Build one impressive full-stack project (Spring Boot + React) for your portfolio. Core system design concepts. 150+ DSA problems total.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Showcase Project', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'terminal' },
          { name: 'System Design', icon: 'brain' },
        ],
      },
      {
        semester: 6,
        title: 'Intensive Interview Prep',
        description: 'All-in placement focus. Mock interviews twice weekly, front-end + back-end specific prep, DSA grinding. Optimize resume and apply broadly.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  5: {
    title: 'Full Stack + Spring Boot — Crash Course',
    milestones: [
      {
        semester: 5,
        title: 'Emergency Full Stack Sprint',
        description: 'Focus on top 100 DSA problems daily. Build one compelling full-stack project (React + Spring Boot) for your resume. Prioritize visible, deployable work.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'Top 100 DSA', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'Quick Full Stack Project', roadmapId: ROADMAP_IDS.SPRING_BOOT, icon: 'terminal' },
        ],
      },
      {
        semester: 6,
        title: 'Interview-Ready Sprint',
        description: 'Pure placement focus. Full-stack interview questions, system design basics, behavioral prep. Apply everywhere immediately.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },
};

// ═══════════════════════════════════════════════════════
//  FULL_STACK → NODE_JS  (MERN Stack)
// ═══════════════════════════════════════════════════════

const fullStackNodeJs: Record<number, JourneyConfig> = {

  1: {
    title: 'Full Stack MERN — Full Journey',
    milestones: [
      {
        semester: 1,
        title: 'HTML, CSS & JavaScript Foundations',
        description: 'Master HTML5, CSS3 (Flexbox, Grid), and JavaScript ES6+. Learn DOM manipulation, event handling, and async patterns. Build static websites.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'Web Fundamentals', roadmapId: ROADMAP_IDS.MERN, icon: 'layout' },
          { name: 'DSA Basics', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 2,
        title: 'React + Node.js Fundamentals',
        description: 'Learn React — hooks, state management, React Query, React Router. Build your first Express.js REST API. Connect React frontend to Node backend.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Node.js Basics', roadmapId: ROADMAP_IDS.MERN, icon: 'server' },
        ],
      },
      {
        semester: 3,
        title: 'MERN Stack Mastery',
        description: 'Full MERN stack — MongoDB/Mongoose, Express, React, Node.js. Add JWT auth, file uploads, email services. Build 1 complete MERN application.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'MERN Stack', roadmapId: ROADMAP_IDS.MERN, icon: 'terminal' },
          { name: 'DSA Intermediate', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 4,
        title: 'Production Projects & Advanced React',
        description: 'Build 2 production-grade MERN apps. Learn Next.js for SSR/SSG. Add real-time features (Socket.io), payment integration, and CI/CD pipelines.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'Advanced MERN', roadmapId: ROADMAP_IDS.MERN, icon: 'server' },
        ],
      },
      {
        semester: 5,
        title: 'System Design & DevOps',
        description: 'System design for MERN apps — horizontal scaling, caching, CDN, microservices. Docker, Kubernetes, AWS deployment, and monitoring.',
        monthsHint: 'Months 25–30',
        tracks: [
          { name: 'System Design', icon: 'brain' },
          { name: 'DevOps & Cloud', icon: 'database' },
        ],
      },
      {
        semester: 6,
        title: 'Interview Prep & Placement',
        description: 'MERN-focused interview prep — JavaScript deep dives, React patterns, Node.js internals. DSA revision, system design mocks. Apply to product companies.',
        monthsHint: 'Months 31–36',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  2: {
    title: 'Full Stack MERN — Normal Pace',
    milestones: [
      {
        semester: 2,
        title: 'React + JavaScript Mastery',
        description: 'Deep-dive into React — advanced hooks, context, performance optimization. Solid JavaScript: closures, prototypes, event loop. Build 2 React apps.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'React Frontend', roadmapId: ROADMAP_IDS.FRONTEND, icon: 'layout' },
          { name: 'DSA Fundamentals', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 3,
        title: 'Node.js + MongoDB Backend',
        description: 'Build full Express.js APIs with MongoDB, JWT auth, middleware, validation (Joi/Zod), and error handling. Integrate with React frontend.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'MERN Stack', roadmapId: ROADMAP_IDS.MERN, icon: 'server' },
          { name: 'DSA Intermediate', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 4,
        title: 'Next.js + Production Deployment',
        description: 'Learn Next.js for full-stack React. Build 2 production MERN apps. Deploy to Vercel/Railway. CI/CD with GitHub Actions. Add monitoring and logging.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'Next.js Projects', roadmapId: ROADMAP_IDS.MERN, icon: 'layout' },
          { name: 'DevOps Basics', icon: 'database' },
        ],
      },
      {
        semester: 5,
        title: 'System Design & Optimization',
        description: 'System design — database indexing, Redis caching, message queues, microservices. Performance optimize your React apps. Learn TypeScript deeply.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'System Design', icon: 'brain' },
          { name: 'TypeScript & Advanced JS', roadmapId: ROADMAP_IDS.FRONTEND, icon: 'code' },
        ],
      },
      {
        semester: 6,
        title: 'Placement Preparation',
        description: 'Mock interviews targeting MERN roles — JavaScript internals, React lifecycle, Node.js event loop, MongoDB aggregations. Resume and portfolio polish.',
        monthsHint: 'Months 25–30',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  3: {
    title: 'Full Stack MERN — Accelerated',
    milestones: [
      {
        semester: 3,
        title: 'React + Node.js Rapid Foundation',
        description: 'Learn React and Node.js/Express concurrently. Build one MERN project. 80+ DSA problems. Master MongoDB basics.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'MERN Stack', roadmapId: ROADMAP_IDS.MERN, icon: 'terminal' },
          { name: 'DSA Bootcamp', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 4,
        title: 'Advanced MERN + Next.js',
        description: 'Build 2 production MERN apps with Next.js, real-time features, and cloud deployment. Advanced React patterns and Node.js performance optimization.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Advanced MERN', roadmapId: ROADMAP_IDS.MERN, icon: 'server' },
        ],
      },
      {
        semester: 5,
        title: 'System Design & Capstone',
        description: 'Core system design concepts for JavaScript apps. Capstone project showcasing full MERN stack. Continue DSA and start weekly mock interviews.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'System Design', icon: 'brain' },
          { name: 'Capstone Project', roadmapId: ROADMAP_IDS.MERN, icon: 'terminal' },
        ],
      },
      {
        semester: 6,
        title: 'Interview Sprint & Placement',
        description: 'Full-time placement prep. Daily JavaScript/React interview questions, system design, behavioral rounds. Target both startups and product companies.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  4: {
    title: 'Full Stack MERN — Fast Track',
    milestones: [
      {
        semester: 4,
        title: 'MERN Crash Course',
        description: 'Rapid MERN stack fundamentals — React, Express, MongoDB, Node.js. Essential DSA patterns for interviews. Build one full-stack app.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'DSA Crash Course', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'MERN Stack', roadmapId: ROADMAP_IDS.MERN, icon: 'server' },
        ],
      },
      {
        semester: 5,
        title: 'Showcase Project + System Design',
        description: 'Build one impressive MERN/Next.js portfolio project. Core system design for JS apps. 150+ DSA problems. TypeScript for both frontend and backend.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Showcase Project', roadmapId: ROADMAP_IDS.MERN, icon: 'terminal' },
          { name: 'System Design', icon: 'brain' },
        ],
      },
      {
        semester: 6,
        title: 'Intensive Interview Prep',
        description: 'All-in placement focus. Daily JavaScript interview prep, mock interviews, system design sessions. Apply to every MERN/full-stack opening.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  5: {
    title: 'Full Stack MERN — Crash Course',
    milestones: [
      {
        semester: 5,
        title: 'Emergency MERN Sprint',
        description: 'Top 100 DSA problems in JavaScript. Build one deployed Next.js/MERN project for your resume. Focus on visible, demonstrable full-stack work.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'Top 100 DSA', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'MERN Project', roadmapId: ROADMAP_IDS.MERN, icon: 'terminal' },
        ],
      },
      {
        semester: 6,
        title: 'Interview-Ready Sprint',
        description: 'Pure placement focus. JavaScript + React interview questions, system design basics, behavioral prep. Apply immediately to every relevant opening.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
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
    title: 'Full Stack + Python FastAPI — Full Journey',
    milestones: [
      {
        semester: 1,
        title: 'HTML, CSS & Python Basics',
        description: 'Build web fundamentals (HTML5, CSS3, JavaScript) and Python mastery simultaneously. OOP in Python, type hints, and async programming basics.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'Web Fundamentals', roadmapId: ROADMAP_IDS.FRONTEND, icon: 'layout' },
          { name: 'Python Basics', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'code' },
        ],
      },
      {
        semester: 2,
        title: 'React + FastAPI Fundamentals',
        description: 'Learn React (hooks, routing, state) and FastAPI basics (async routes, Pydantic, SQLAlchemy). Build your first full-stack Python app.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'React Frontend', roadmapId: ROADMAP_IDS.FRONTEND, icon: 'layout' },
          { name: 'FastAPI Basics', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'server' },
          { name: 'DSA Basics', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 3,
        title: 'Full Stack Python Projects',
        description: 'Build complete FastAPI + React applications with auth, PostgreSQL, background tasks (Celery). Deploy to cloud. DSA intermediate level.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'FastAPI Production', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'server' },
          { name: 'DSA Intermediate', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 4,
        title: 'Advanced Frontend & APIs',
        description: 'Next.js with Python backend. Advanced React patterns, performance optimization. Build 2 production projects with complex features and deployment.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'Next.js Projects', roadmapId: ROADMAP_IDS.FRONTEND, icon: 'layout' },
          { name: 'Full Stack Projects', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'terminal' },
        ],
      },
      {
        semester: 5,
        title: 'System Design & DevOps',
        description: 'System design for Python microservices — Docker, Kubernetes, message queues (Celery + Redis), and cloud deployment. Performance tuning.',
        monthsHint: 'Months 25–30',
        tracks: [
          { name: 'System Design', icon: 'brain' },
          { name: 'DevOps & Cloud', icon: 'database' },
        ],
      },
      {
        semester: 6,
        title: 'Interview Prep & Placement',
        description: 'Full-stack Python interview preparation — FastAPI internals, async Python, React patterns, system design. Portfolio reviews. Apply broadly.',
        monthsHint: 'Months 31–36',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  2: {
    title: 'Full Stack + Python FastAPI — Normal Pace',
    milestones: [
      {
        semester: 2,
        title: 'React + Python Kickstart',
        description: 'Master React concurrently with Python/FastAPI basics. Build your first full-stack Python app. Core DSA: arrays, strings, linked lists.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'React Frontend', roadmapId: ROADMAP_IDS.FRONTEND, icon: 'layout' },
          { name: 'DSA Fundamentals', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 3,
        title: 'FastAPI Backend + DSA',
        description: 'Production FastAPI — auth, PostgreSQL, Alembic migrations, background tasks. Intermediate DSA: trees, graphs, DP. One complete full-stack project.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'FastAPI Production', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'server' },
          { name: 'DSA Intermediate', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 4,
        title: 'Advanced Projects & Deployment',
        description: 'Build 2 production full-stack apps with Next.js + FastAPI. Docker containerization, CI/CD pipelines, and cloud deployment. Open source contributions.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'Portfolio Projects', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'terminal' },
          { name: 'DevOps Basics', icon: 'database' },
        ],
      },
      {
        semester: 5,
        title: 'System Design & Optimization',
        description: 'System design for Python-powered full-stack apps. Redis caching, async task queues, database optimization, and microservices patterns.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'System Design', icon: 'brain' },
          { name: 'Advanced Python', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'server' },
        ],
      },
      {
        semester: 6,
        title: 'Placement Preparation',
        description: 'Mock interviews for Python full-stack roles. DSA revision, system design practice, behavioral prep. Company research and aggressive applications.',
        monthsHint: 'Months 25–30',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  3: {
    title: 'Full Stack + Python FastAPI — Accelerated',
    milestones: [
      {
        semester: 3,
        title: 'Rapid React + FastAPI Foundation',
        description: 'Learn React and FastAPI simultaneously. Build one full-stack Python app. 80+ DSA problems. Master async Python and Pydantic schemas.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'React + FastAPI', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'server' },
          { name: 'DSA Bootcamp', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
        ],
      },
      {
        semester: 4,
        title: 'Production Projects + Advanced Patterns',
        description: 'Build 2 full-stack projects with advanced Python features — Celery, WebSockets, OAuth2. Add Next.js for one project. CI/CD and deployment.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Advanced FastAPI', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'server' },
        ],
      },
      {
        semester: 5,
        title: 'System Design & Capstone',
        description: 'System design for scalable Python apps. Impressive capstone full-stack project. Continue DSA and start mock interviews weekly.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'System Design', icon: 'brain' },
          { name: 'Capstone Project', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'terminal' },
        ],
      },
      {
        semester: 6,
        title: 'Interview Sprint & Placement',
        description: 'Full-time interview preparation. Python interview deep dives, system design mocks, behavioral rounds. Apply aggressively to full-stack roles.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  4: {
    title: 'Full Stack + Python FastAPI — Fast Track',
    milestones: [
      {
        semester: 4,
        title: 'Full Stack Python Crash Course',
        description: 'Rapid React + FastAPI fundamentals. Essential DSA patterns. Build one simple full-stack Python app to establish portfolio presence.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'DSA Crash Course', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'React + FastAPI', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'server' },
        ],
      },
      {
        semester: 5,
        title: 'Showcase Project + System Design',
        description: 'Build one impressive portfolio project (Next.js + FastAPI + PostgreSQL). Core system design. 150+ DSA problems. Docker containerization.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Showcase Project', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'terminal' },
          { name: 'System Design', icon: 'brain' },
        ],
      },
      {
        semester: 6,
        title: 'Intensive Interview Prep',
        description: 'All-in placement focus. Python + React interview patterns, mock interviews twice weekly, system design sessions. Apply everywhere.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  5: {
    title: 'Full Stack + Python FastAPI — Crash Course',
    milestones: [
      {
        semester: 5,
        title: 'Emergency Full Stack Python Sprint',
        description: 'Top 100 DSA problems in Python. Build one deployed full-stack project (FastAPI + React) for your resume. Focus on visible, demonstrable work.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'Top 100 DSA', roadmapId: ROADMAP_IDS.DSA, icon: 'code' },
          { name: 'FastAPI Project', roadmapId: ROADMAP_IDS.FASTAPI, icon: 'server' },
        ],
      },
      {
        semester: 6,
        title: 'Interview-Ready Sprint',
        description: 'Pure placement focus. Python full-stack interview questions, system design basics, behavioral prep. Apply immediately and broadly.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },
};

// ═══════════════════════════════════════════════════════
//  AI_ML → PYTHON
// ═══════════════════════════════════════════════════════

const aiMlPython: Record<number, JourneyConfig> = {

  1: {
    title: 'AI/ML Engineer — Full Journey',
    milestones: [
      {
        semester: 1,
        title: 'Python & Math Foundations',
        description: 'Master Python for data science — NumPy, Pandas, Matplotlib. Refresh linear algebra, calculus, probability, and statistics. Set up Jupyter environments.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'Python for Data Science', roadmapId: ROADMAP_IDS.AIML, icon: 'code' },
          { name: 'Math Foundations', roadmapId: ROADMAP_IDS.AIML, icon: 'brain' },
        ],
      },
      {
        semester: 2,
        title: 'Machine Learning Fundamentals',
        description: 'Supervised & unsupervised learning with scikit-learn. Linear regression, SVM, decision trees, k-means, PCA. Kaggle competitions for practice.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'ML Fundamentals', roadmapId: ROADMAP_IDS.AIML, icon: 'brain' },
          { name: 'Kaggle Practice', roadmapId: ROADMAP_IDS.AIML, icon: 'chart' },
        ],
      },
      {
        semester: 3,
        title: 'Deep Learning & Neural Networks',
        description: 'TensorFlow & PyTorch — CNNs, RNNs, LSTMs, attention mechanism. Computer vision and NLP basics. Train models on real datasets.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'Deep Learning', roadmapId: ROADMAP_IDS.AIML, icon: 'brain' },
          { name: 'NLP & Computer Vision', roadmapId: ROADMAP_IDS.AIML, icon: 'chart' },
        ],
      },
      {
        semester: 4,
        title: 'LLMs & Generative AI',
        description: 'Large Language Models, RAG pipelines, LangChain, fine-tuning. Build AI-powered applications. Learn prompt engineering and vector databases.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'LLMs & RAG', roadmapId: ROADMAP_IDS.AIML, icon: 'brain' },
          { name: 'AI Applications', roadmapId: ROADMAP_IDS.AIML, icon: 'terminal' },
        ],
      },
      {
        semester: 5,
        title: 'MLOps & Production AI',
        description: 'Deploy ML models to production — MLflow, DVC, Airflow. Kubernetes for ML, model monitoring, A/B testing, and feature stores.',
        monthsHint: 'Months 25–30',
        tracks: [
          { name: 'MLOps', roadmapId: ROADMAP_IDS.AIML, icon: 'database' },
        ],
      },
      {
        semester: 6,
        title: 'Interview Prep & Placement',
        description: 'ML interview preparation — statistics, ML theory, coding rounds, system design for ML. Portfolio of Kaggle + research projects. Apply to AI companies.',
        monthsHint: 'Months 31–36',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  2: {
    title: 'AI/ML Engineer — Normal Pace',
    milestones: [
      {
        semester: 2,
        title: 'Python & Math Kickstart',
        description: 'Accelerated Python for ML — NumPy, Pandas, Matplotlib, Seaborn. Math refresh: linear algebra, statistics, probability. First Kaggle competition.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'Python for Data Science', roadmapId: ROADMAP_IDS.AIML, icon: 'code' },
        ],
      },
      {
        semester: 3,
        title: 'Classical ML + Deep Learning Intro',
        description: 'Scikit-learn mastery: classification, regression, clustering, ensemble methods. PyTorch basics — neural networks, backpropagation, CNNs.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'ML Algorithms', roadmapId: ROADMAP_IDS.AIML, icon: 'brain' },
          { name: 'Deep Learning', roadmapId: ROADMAP_IDS.AIML, icon: 'chart' },
        ],
      },
      {
        semester: 4,
        title: 'NLP, CV & Advanced DL',
        description: 'Transformers, BERT, GPT fine-tuning. Object detection, image segmentation. Build and deploy 2 AI projects — NLP chatbot + vision app.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'NLP & Transformers', roadmapId: ROADMAP_IDS.AIML, icon: 'brain' },
          { name: 'AI Projects', roadmapId: ROADMAP_IDS.AIML, icon: 'terminal' },
        ],
      },
      {
        semester: 5,
        title: 'MLOps & Generative AI',
        description: 'Production ML pipelines, model deployment on AWS/GCP, LLMs, RAG applications, LangChain. Contribute to open-source ML projects.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'MLOps', roadmapId: ROADMAP_IDS.AIML, icon: 'database' },
          { name: 'LLMs & RAG', roadmapId: ROADMAP_IDS.AIML, icon: 'brain' },
        ],
      },
      {
        semester: 6,
        title: 'Placement Preparation',
        description: 'ML interview prep — statistics, ML theory, coding challenges, system design for ML. Strong portfolio with Kaggle rankings. Apply to AI/ML companies.',
        monthsHint: 'Months 25–30',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  3: {
    title: 'AI/ML Engineer — Accelerated',
    milestones: [
      {
        semester: 3,
        title: 'ML Foundations Fast-Track',
        description: 'Rapid Python + math foundations. Core classical ML (scikit-learn) and intro to deep learning with PyTorch. First Kaggle bronze medal target.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'Python + ML Basics', roadmapId: ROADMAP_IDS.AIML, icon: 'code' },
          { name: 'Deep Learning Intro', roadmapId: ROADMAP_IDS.AIML, icon: 'brain' },
        ],
      },
      {
        semester: 4,
        title: 'Advanced DL + NLP + Projects',
        description: 'Transformers, fine-tuning LLMs, computer vision projects. Build 2 real AI applications. Start contributing to open-source ML repositories.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Advanced Deep Learning', roadmapId: ROADMAP_IDS.AIML, icon: 'brain' },
          { name: 'AI Projects', roadmapId: ROADMAP_IDS.AIML, icon: 'terminal' },
        ],
      },
      {
        semester: 5,
        title: 'MLOps + Capstone AI Project',
        description: 'Deploy ML models to production, RAG pipelines, and LLM applications. One impressive capstone AI project. Weekly mock interviews start.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'MLOps & Production', roadmapId: ROADMAP_IDS.AIML, icon: 'database' },
          { name: 'Capstone AI Project', roadmapId: ROADMAP_IDS.AIML, icon: 'terminal' },
        ],
      },
      {
        semester: 6,
        title: 'Interview Sprint & Placement',
        description: 'Full-time ML interview preparation — statistics, ML theory, coding, system design. Apply aggressively to AI/ML research and product roles.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  4: {
    title: 'AI/ML Engineer — Fast Track',
    milestones: [
      {
        semester: 4,
        title: 'ML Crash Course',
        description: 'Rapid ML fundamentals — scikit-learn, PyTorch basics, key algorithms. Python for data science. Essential statistics and probability for ML interviews.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'ML Crash Course', roadmapId: ROADMAP_IDS.AIML, icon: 'brain' },
          { name: 'Python for ML', roadmapId: ROADMAP_IDS.AIML, icon: 'code' },
        ],
      },
      {
        semester: 5,
        title: 'Deep Learning + AI Project',
        description: 'CNNs, Transformers, and LLM fine-tuning. Build one impressive AI project (NLP or vision). Start MLOps basics. Kaggle competition entry.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Deep Learning', roadmapId: ROADMAP_IDS.AIML, icon: 'brain' },
          { name: 'AI Showcase Project', roadmapId: ROADMAP_IDS.AIML, icon: 'terminal' },
        ],
      },
      {
        semester: 6,
        title: 'Intensive Interview Prep',
        description: 'ML interview focus — statistics, ML theory, coding challenges, system design for ML. Apply to AI companies and ML engineering roles.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  5: {
    title: 'AI/ML Engineer — Crash Course',
    milestones: [
      {
        semester: 5,
        title: 'Emergency ML Sprint',
        description: 'Core ML algorithms with scikit-learn. PyTorch basics. Build one AI project (LLM-powered or CV app) for your portfolio. Kaggle entry.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'ML Fundamentals', roadmapId: ROADMAP_IDS.AIML, icon: 'brain' },
          { name: 'AI Project', roadmapId: ROADMAP_IDS.AIML, icon: 'terminal' },
        ],
      },
      {
        semester: 6,
        title: 'Interview-Ready Sprint',
        description: 'ML interview prep — statistics, common algorithms, Python coding. Apply to AI/ML roles and data science positions immediately.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },
};

// ═══════════════════════════════════════════════════════
//  DATA_SCIENTIST → PYTHON
// ═══════════════════════════════════════════════════════

const dataScientistPython: Record<number, JourneyConfig> = {

  1: {
    title: 'Data Scientist — Full Journey',
    milestones: [
      {
        semester: 1,
        title: 'Statistics & Python Foundations',
        description: 'Deep statistics foundation — probability distributions, hypothesis testing, Bayesian inference. Python: NumPy, Pandas, Matplotlib, Seaborn. Excel for quick analysis.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'Statistics & Probability', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'chart' },
          { name: 'Python for Data Science', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'code' },
        ],
      },
      {
        semester: 2,
        title: 'Exploratory Data Analysis & SQL',
        description: 'Master EDA — data cleaning, feature engineering, outlier detection, visualization. Advanced SQL: window functions, CTEs, performance tuning. First Kaggle competition.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'EDA & Visualization', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'chart' },
          { name: 'SQL Mastery', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'database' },
        ],
      },
      {
        semester: 3,
        title: 'Machine Learning for Data Science',
        description: 'Supervised and unsupervised learning — regression, classification, clustering, anomaly detection. Model evaluation, cross-validation, and hyperparameter tuning.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'ML for Data Science', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'brain' },
          { name: 'Kaggle Projects', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'chart' },
        ],
      },
      {
        semester: 4,
        title: 'Deep Learning & NLP Basics',
        description: 'PyTorch fundamentals, NLP with Hugging Face, time-series forecasting. Build predictive models for real business problems. A/B testing and causal inference.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'Deep Learning Basics', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'brain' },
          { name: 'NLP for DS', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'chart' },
        ],
      },
      {
        semester: 5,
        title: 'Data Engineering & BI Tools',
        description: 'Data pipelines with Airflow, Spark basics, dbt. Business intelligence — Power BI / Tableau. Dashboard design. Cloud data warehouses (BigQuery, Redshift).',
        monthsHint: 'Months 25–30',
        tracks: [
          { name: 'Data Engineering', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'database' },
          { name: 'BI & Dashboards', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'chart' },
        ],
      },
      {
        semester: 6,
        title: 'Interview Prep & Placement',
        description: 'Data science interview preparation — statistics, SQL challenges, ML theory, case studies, and business problem solving. Portfolio of end-to-end projects. Apply to analytics & DS roles.',
        monthsHint: 'Months 31–36',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  2: {
    title: 'Data Scientist — Normal Pace',
    milestones: [
      {
        semester: 2,
        title: 'Statistics + Python + SQL Kickstart',
        description: 'Accelerated statistics, Python for data science, and SQL fundamentals. EDA on real datasets. First Kaggle competition. Build a data portfolio on GitHub.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'Stats & Python', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'code' },
          { name: 'SQL & EDA', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'database' },
        ],
      },
      {
        semester: 3,
        title: 'ML Algorithms + Feature Engineering',
        description: 'Classical ML with scikit-learn — ensemble methods, gradient boosting. Advanced feature engineering. Model interpretation (SHAP, LIME). Kaggle silver target.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Advanced ML', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'brain' },
          { name: 'Kaggle Competitions', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'chart' },
        ],
      },
      {
        semester: 4,
        title: 'Deep Learning + Business Analytics',
        description: 'PyTorch, NLP, time-series. Business analytics — A/B testing, causal inference, metrics design. Build a full analytics dashboard project.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'Deep Learning', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'brain' },
          { name: 'Business Analytics', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'chart' },
        ],
      },
      {
        semester: 5,
        title: 'Data Engineering & BI',
        description: 'Data pipelines, Spark, dbt, cloud data warehouses. Tableau or Power BI dashboards. Deploy an end-to-end ML pipeline to production.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'Data Engineering', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'database' },
          { name: 'BI Tools', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'chart' },
        ],
      },
      {
        semester: 6,
        title: 'Placement Preparation',
        description: 'Data science interview focus — statistics, SQL, ML theory, case studies. Strong portfolio with 3+ end-to-end projects. Apply to DS, analytics, and quant roles.',
        monthsHint: 'Months 25–30',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  3: {
    title: 'Data Scientist — Accelerated',
    milestones: [
      {
        semester: 3,
        title: 'Stats + ML Fast-Track',
        description: 'Rapid statistics, Python DS stack (NumPy, Pandas, scikit-learn), and SQL. Classical ML algorithms. EDA on 3 real datasets. Kaggle competition entry.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'Stats + ML Basics', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'brain' },
          { name: 'Python + SQL', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'code' },
        ],
      },
      {
        semester: 4,
        title: 'Advanced ML + Deep Learning',
        description: 'Advanced ML — gradient boosting, feature engineering, model stacking. PyTorch basics, NLP, time-series. Build 2 portfolio projects. Kaggle silver target.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Advanced ML', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'brain' },
          { name: 'DS Projects', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'chart' },
        ],
      },
      {
        semester: 5,
        title: 'Data Engineering + Capstone',
        description: 'Data pipelines, BI tools, MLflow for experiment tracking. One impressive capstone DS project — end-to-end from raw data to deployed model + dashboard.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'Data Engineering', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'database' },
          { name: 'Capstone Project', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'chart' },
        ],
      },
      {
        semester: 6,
        title: 'Interview Sprint & Placement',
        description: 'Full-time DS interview preparation — statistics, SQL challenges, ML theory, case studies. Apply aggressively to DS, analytics engineering, and research roles.',
        monthsHint: 'Months 19–24',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  4: {
    title: 'Data Scientist — Fast Track',
    milestones: [
      {
        semester: 4,
        title: 'Data Science Crash Course',
        description: 'Rapid Python + Pandas + SQL + statistics. Core ML algorithms (scikit-learn). EDA on real datasets. Entry-level Kaggle competition.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'DS Fundamentals', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'code' },
          { name: 'ML Basics', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'brain' },
        ],
      },
      {
        semester: 5,
        title: 'Advanced ML + DS Portfolio',
        description: 'Gradient boosting, feature engineering, NLP basics. Build 2 end-to-end DS projects. BI dashboard with Tableau/Power BI. MLflow for experiment tracking.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Advanced ML', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'brain' },
          { name: 'DS Portfolio', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'chart' },
        ],
      },
      {
        semester: 6,
        title: 'Intensive Interview Prep',
        description: 'DS interview focus — statistics, SQL, ML theory, business case studies. Apply to data analyst, data scientist, and analytics engineering roles.',
        monthsHint: 'Months 13–18',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },

  5: {
    title: 'Data Scientist — Crash Course',
    milestones: [
      {
        semester: 5,
        title: 'Emergency Data Science Sprint',
        description: 'Essential statistics, Python DS stack, SQL, and core ML algorithms. Build one end-to-end project from data collection to model deployment + visualization.',
        monthsHint: 'Months 1–6',
        tracks: [
          { name: 'DS Essentials', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'brain' },
          { name: 'DS Project', roadmapId: ROADMAP_IDS.DATA_SCIENTIST, icon: 'chart' },
        ],
      },
      {
        semester: 6,
        title: 'Interview-Ready Sprint',
        description: 'Data science interview preparation — statistics, SQL challenges, ML theory, case studies. Apply immediately to data analyst and junior DS roles.',
        monthsHint: 'Months 7–12',
        tracks: [
          { name: 'Interview Prep', icon: 'book' },
        ],
      },
    ],
  },
};

// ── Main config export ──
// Keyed: journeyConfigs[role][framework][startingSemester]
export const journeyConfigs: Record<string, Record<string, Record<number, JourneyConfig>>> = {
  SDE: {
    SPRING_BOOT:   sdeSpringBoot,
    NODE_JS:       sdeNodeJs,
    PYTHON_FASTAPI: sdePythonFastApi,
  },
  FULL_STACK: {
    SPRING_BOOT:   fullStackSpringBoot,
    NODE_JS:       fullStackNodeJs,
    PYTHON_FASTAPI: fullStackPythonFastApi,
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
