package com.careerforge.roadmap.seeder;

import java.util.ArrayList;
import java.util.List;

public class FastApiPrepSeeder {

    public static void seed(
        com.careerforge.roadmap.entity.Roadmap dbRoadmap,
        com.careerforge.roadmap.repository.RoadmapSectionRepository roadmapSectionRepository,
        com.careerforge.roadmap.repository.QuestionRepository questionRepository,
        com.careerforge.roadmap.repository.QuestionLinkRepository questionLinkRepository,
        com.careerforge.roadmap.repository.RoadmapSectionQuestionRepository roadmapSectionQuestionRepository
    ) {
        System.out.println("Seeding Roadmap: Python FastAPI Complete Preparation Sheet");
        Roadmap.sections.clear();

        RoadmapSection s;
        Topic t;

        // ==========================================
        // Section 1: Python Prerequisites
        // ==========================================
        s = createSection("Python Prerequisites");

        t = createTopic(s, "Modern Python Essentials");
        addQ(t, "Type Hints & Annotations", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/typing.html",
            "VIDEO", "https://www.youtube.com/watch?v=QORvB-_mbZ0");
        addQ(t, "Decorators", "EASY",
            "ARTICLE", "https://docs.python.org/3/glossary.html#term-decorator",
            "VIDEO", "https://www.youtube.com/watch?v=FsAPt_9Bf3U");
        addQ(t, "Context Managers (with statement)", "EASY",
            "ARTICLE", "https://docs.python.org/3/reference/datamodel.html#context-managers",
            "VIDEO", "https://www.youtube.com/watch?v=-aKFBoZpiqA");
        addQ(t, "Async / Await & Event Loop", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/library/asyncio.html",
            "VIDEO", "https://www.youtube.com/watch?v=t5Bo1Je9EmE");

        t = createTopic(s, "Virtual Environments & Tooling");
        addQ(t, "venv, pip, requirements.txt", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/venv.html",
            "VIDEO", "https://www.youtube.com/watch?v=Y21OR1OPC9A");
        addQ(t, "Dependency Management with Poetry / uv", "EASY",
            "ARTICLE", "https://python-poetry.org/docs/",
            "VIDEO", "https://www.youtube.com/watch?v=0f3moPe_bhk");


        // ==========================================
        // Section 2: FastAPI Fundamentals
        // ==========================================
        s = createSection("FastAPI Fundamentals");

        t = createTopic(s, "Getting Started");
        addQ(t, "What is FastAPI and Why Use It..?", "EASY",
            "ARTICLE", "https://fastapi.tiangolo.com/",
            "VIDEO", "https://www.youtube.com/watch?v=tLKKmouUams");
        addQ(t, "Installation and Your First API", "EASY",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/first-steps/",
            "VIDEO", "https://www.youtube.com/watch?v=tLKKmouUams");
        addQ(t, "Automatic Docs (Swagger UI & ReDoc)", "EASY",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/first-steps/#interactive-api-docs",
            "VIDEO", "https://www.youtube.com/watch?v=VirndPTeRaw");
        addQ(t, "ASGI, Starlette and Uvicorn under the hood", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/async/",
            "VIDEO", "https://www.youtube.com/watch?v=Gda2kqyRdYI");

        t = createTopic(s, "Path & Query Parameters");
        addQ(t, "Path Parameters", "EASY",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/path-params/",
            "VIDEO", "https://www.youtube.com/watch?v=tLKKmouUams");
        addQ(t, "Query Parameters & Optional Params", "EASY",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/query-params/",
            "VIDEO", "https://www.youtube.com/watch?v=tLKKmouUams");
        addQ(t, "Combining Path & Query Parameters", "EASY",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/query-params-str-validations/",
            "VIDEO", "https://www.youtube.com/watch?v=tLKKmouUams");
        addQ(t, "Path & Query Parameter Validation", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/path-params-numeric-validations/",
            "VIDEO", "https://www.youtube.com/watch?v=WU65u9d-97c");

        t = createTopic(s, "Request Body & Pydantic");
        addQ(t, "Request Body with Pydantic Models", "EASY",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/body/",
            "VIDEO", "https://www.youtube.com/watch?v=tLKKmouUams");
        addQ(t, "Pydantic Field Types & Validators", "MEDIUM",
            "ARTICLE", "https://docs.pydantic.dev/latest/concepts/validators/",
            "VIDEO", "https://www.youtube.com/watch?v=Vj-iU-8_xLs");
        addQ(t, "Nested Models & Schemas", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/body-nested-models/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "Request Body + Path + Query Params Together", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/body-multiple-params/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "Pydantic v2 Settings Management", "MEDIUM",
            "ARTICLE", "https://docs.pydantic.dev/latest/concepts/pydantic_settings/",
            "VIDEO", "https://www.youtube.com/watch?v=Vj-iU-8_xLs");

        t = createTopic(s, "HTTP Methods & Status Codes");
        addQ(t, "GET, POST, PUT, PATCH, DELETE", "EASY",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/body/#request-body-path-query-parameters",
            "VIDEO", "https://www.youtube.com/watch?v=tLKKmouUams");
        addQ(t, "Setting Response Status Codes", "EASY",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/response-status-code/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "Handling Errors with HTTPException", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/handling-errors/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "Custom Exception Handlers", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/handling-errors/#install-custom-exception-handlers",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");

        t = createTopic(s, "Response Handling");
        addQ(t, "response_model & Response Filtering", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/response-model/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "JSONResponse, FileResponse, StreamingResponse", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/advanced/custom-response/",
            "VIDEO", "https://www.youtube.com/watch?v=rvFsGRvj9jo");
        addQ(t, "Form Data & File Uploads", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/request-files/",
            "VIDEO", "https://www.youtube.com/watch?v=rvFsGRvj9jo");


        // ==========================================
        // Section 3: Routing & Project Structure
        // ==========================================
        s = createSection("Routing & Project Structure");

        t = createTopic(s, "APIRouter & Modular Apps");
        addQ(t, "Splitting Routes with APIRouter", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/bigger-applications/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "Structuring a Production FastAPI Project", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/bigger-applications/#an-example-file-structure",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "Path Operation Configuration (tags, summary, deprecated)", "EASY",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/path-operation-configuration/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");

        t = createTopic(s, "Dependency Injection");
        addQ(t, "Introduction to Depends()", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/dependencies/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "Class-based Dependencies", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/dependencies/classes-as-dependencies/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "Sub-dependencies & Dependency Overrides", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/dependencies/sub-dependencies/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "Dependencies with yield (Setup/Teardown)", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/dependencies/dependencies-with-yield/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");

        t = createTopic(s, "Middleware & CORS");
        addQ(t, "Writing Custom Middleware", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/middleware/",
            "VIDEO", "https://www.youtube.com/watch?v=rvFsGRvj9jo");
        addQ(t, "CORS Configuration", "EASY",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/cors/",
            "VIDEO", "https://www.youtube.com/watch?v=rvFsGRvj9jo");


        // ==========================================
        // Section 4: Databases & ORMs
        // ==========================================
        s = createSection("Databases & ORMs");

        t = createTopic(s, "SQL Databases with SQLAlchemy");
        addQ(t, "Connecting FastAPI to a SQL Database", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/sql-databases/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "Defining Models with SQLAlchemy ORM", "MEDIUM",
            "ARTICLE", "https://docs.sqlalchemy.org/en/20/orm/quickstart.html",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "Session Management & Dependency Injection for DB", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/sql-databases/#create-a-dependency",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "CRUD Operations", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/sql-databases/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "Relationships (One-to-Many, Many-to-Many)", "MEDIUM",
            "ARTICLE", "https://docs.sqlalchemy.org/en/20/orm/relationship_api.html",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");

        t = createTopic(s, "Migrations");
        addQ(t, "Database Migrations with Alembic", "MEDIUM",
            "ARTICLE", "https://alembic.sqlalchemy.org/en/latest/tutorial.html",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");

        t = createTopic(s, "Async Databases & NoSQL");
        addQ(t, "Async SQLAlchemy / SQLModel", "MEDIUM",
            "ARTICLE", "https://sqlmodel.tiangolo.com/",
            "VIDEO", "https://www.youtube.com/watch?v=rvFsGRvj9jo");
        addQ(t, "Using MongoDB with FastAPI (Motor / Beanie)", "MEDIUM",
            "ARTICLE", "https://www.mongodb.com/developer/languages/python/python-quickstart-fastapi/",
            "VIDEO", "https://www.youtube.com/watch?v=E9zXtxUD-hI");
        addQ(t, "Caching with Redis", "MEDIUM",
            "ARTICLE", "https://redis.io/docs/latest/develop/get-started/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");


        // ==========================================
        // Section 5: Authentication & Security
        // ==========================================
        s = createSection("Authentication & Security");

        t = createTopic(s, "OAuth2 & JWT");
        addQ(t, "OAuth2 with Password Flow", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/security/first-steps/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "Password Hashing with passlib / bcrypt", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/security/oauth2-jwt/#hash-and-verify-the-passwords",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "Issuing & Verifying JWT Tokens", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/security/oauth2-jwt/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "get_current_user Dependency", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/security/oauth2-jwt/#update-the-dependencies",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "Refresh Tokens & Token Expiry", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/security/oauth2-jwt/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");

        t = createTopic(s, "Authorization");
        addQ(t, "Role Based Access Control (RBAC)", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/advanced/security/",
            "VIDEO", "https://www.youtube.com/watch?v=WU65u9d-97c");
        addQ(t, "Scopes with OAuth2", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/advanced/security/oauth2-scopes/",
            "VIDEO", "https://www.youtube.com/watch?v=WU65u9d-97c");

        t = createTopic(s, "General API Security");
        addQ(t, "API Key Authentication", "EASY",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/security/",
            "VIDEO", "https://www.youtube.com/watch?v=WU65u9d-97c");
        addQ(t, "Rate Limiting FastAPI Endpoints (slowapi)", "MEDIUM",
            "ARTICLE", "https://slowapi.readthedocs.io/en/latest/",
            "VIDEO", "https://www.youtube.com/watch?v=rvFsGRvj9jo");
        addQ(t, "HTTPS, Secure Headers & Best Practices", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/deployment/https/",
            "VIDEO", "https://www.youtube.com/watch?v=rvFsGRvj9jo");


        // ==========================================
        // Section 6: Validation, Testing & Background Tasks
        // ==========================================
        s = createSection("Validation, Testing & Background Tasks");

        t = createTopic(s, "Advanced Validation");
        addQ(t, "Custom Validators with Pydantic", "MEDIUM",
            "ARTICLE", "https://docs.pydantic.dev/latest/concepts/validators/",
            "VIDEO", "https://www.youtube.com/watch?v=Vj-iU-8_xLs");
        addQ(t, "Request Validation Error Responses", "EASY",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/handling-errors/#override-request-validation-exceptions",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");

        t = createTopic(s, "Background Tasks & Async Jobs");
        addQ(t, "BackgroundTasks in FastAPI", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/background-tasks/",
            "VIDEO", "https://www.youtube.com/watch?v=TO4aQ3ghFOc");
        addQ(t, "Task Queues with Celery / Redis Streams", "MEDIUM",
            "ARTICLE", "https://docs.celeryq.dev/en/stable/getting-started/introduction.html",
            "VIDEO", "https://www.youtube.com/watch?v=hTMj5C_Mp1U");

        t = createTopic(s, "WebSockets");
        addQ(t, "Real-Time Communication with WebSockets", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/advanced/websockets/",
            "VIDEO", "https://www.youtube.com/watch?v=rvFsGRvj9jo");

        t = createTopic(s, "Testing FastAPI Applications");
        addQ(t, "Testing with TestClient & pytest", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/testing/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "Mocking Dependencies in Tests", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/advanced/testing-dependencies/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "Test Database Setup & Fixtures", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/testing/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");


        // ==========================================
        // Section 7: FastAPI for AI/ML Serving
        // ==========================================
        s = createSection("FastAPI for AI/ML Serving");

        t = createTopic(s, "Serving ML Models");
        addQ(t, "Wrapping a scikit-learn Model as an API", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/first-steps/",
            "VIDEO", "https://www.youtube.com/watch?v=ueVb2dw-kWY");
        addQ(t, "Loading Models at Startup (lifespan events)", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/advanced/events/",
            "VIDEO", "https://www.youtube.com/watch?v=Gda2kqyRdYI");
        addQ(t, "Input Validation for Model Payloads", "MEDIUM",
            "ARTICLE", "https://docs.pydantic.dev/latest/concepts/models/",
            "VIDEO", "https://www.youtube.com/watch?v=ueVb2dw-kWY");
        addQ(t, "Streaming LLM Responses (Server-Sent Events)", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/advanced/custom-response/#streamingresponse",
            "VIDEO", "https://www.youtube.com/watch?v=rvFsGRvj9jo");

        t = createTopic(s, "Deploying ML APIs");
        addQ(t, "Deploying FastAPI ML APIs to Heroku", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/deployment/",
            "VIDEO", "https://www.youtube.com/watch?v=pZ2qzeKsoKs");
        addQ(t, "Complete FastAPI-for-ML Playlist", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/deployment/",
            "VIDEO", "https://www.youtube.com/playlist?list=PLZoTAELRMXVPgsojPOHF9i0u2L83-m9P7",
            "VIDEO", "https://www.youtube.com/playlist?list=PLKnIA16_RmvZ41tjbKB2ZnwchfniNsMuQ");


        // ==========================================
        // Section 8: Deployment & Production
        // ==========================================
        s = createSection("Deployment & Production");

        t = createTopic(s, "Running in Production");
        addQ(t, "Uvicorn vs Gunicorn+Uvicorn Workers", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/deployment/server-workers/",
            "VIDEO", "https://www.youtube.com/watch?v=rvFsGRvj9jo");
        addQ(t, "Environment Variables & Config Management", "EASY",
            "ARTICLE", "https://fastapi.tiangolo.com/advanced/settings/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "Containerizing FastAPI with Docker", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/deployment/docker/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "Reverse Proxy with Nginx/Traefik", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/deployment/concepts/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");

        t = createTopic(s, "CI/CD & Cloud Deployment");
        addQ(t, "CI/CD with GitHub Actions", "MEDIUM",
            "ARTICLE", "https://docs.github.com/en/actions",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "Deploying to AWS / Render / Railway", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/deployment/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");
        addQ(t, "Logging & Monitoring (structlog, Sentry)", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/advanced/",
            "VIDEO", "https://www.youtube.com/watch?v=0sOvCWFmrtA");

        t = createTopic(s, "Microservices with FastAPI");
        addQ(t, "Designing Microservices with FastAPI", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/tutorial/bigger-applications/",
            "VIDEO", "https://www.youtube.com/watch?v=8AqUEHFTM6Y");
        addQ(t, "Inter-service Communication (HTTP, Redis Streams)", "MEDIUM",
            "ARTICLE", "https://redis.io/docs/latest/develop/data-types/streams/",
            "VIDEO", "https://www.youtube.com/watch?v=8AqUEHFTM6Y");
        addQ(t, "Full FARM/Microservices Project Build", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/",
            "VIDEO", "https://www.youtube.com/watch?v=8AqUEHFTM6Y");


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
                    .label(lt == com.careerforge.roadmap.entity.LinkType.VIDEO ? "Video Tutorial" : "Article Tutorial")
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
                editorial = links[i + 1];
                break;
            }
        }
        q.setEditorialLink(editorial);

        for (int i = 0; i < links.length; i += 2) {
            q.addLink(new QuestionLink(links[i], links[i + 1]));
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

        public void setSolveLink(String solveLink) { this.solveLink = solveLink; }
        public void setEditorialLink(String editorialLink) { this.editorialLink = editorialLink; }
        public void addLink(QuestionLink link) { this.links.add(link); }
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