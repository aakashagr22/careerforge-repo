package com.careerforge.roadmap.seeder;

import java.util.ArrayList;
import java.util.List;

public class FrontendPrepSeeder {

    public static void seed(
        com.careerforge.roadmap.entity.Roadmap dbRoadmap,
        com.careerforge.roadmap.repository.RoadmapSectionRepository roadmapSectionRepository,
        com.careerforge.roadmap.repository.QuestionRepository questionRepository,
        com.careerforge.roadmap.repository.QuestionLinkRepository questionLinkRepository,
        com.careerforge.roadmap.repository.RoadmapSectionQuestionRepository roadmapSectionQuestionRepository
    ) {
        System.out.println("Seeding Roadmap: Frontend (React) Complete Preparation Sheet");
        Roadmap.sections.clear();

        RoadmapSection s;
        Topic t;

        // ==========================================
        // Section 1: Web Fundamentals
        // ==========================================
        s = createSection("Web Fundamentals");

        t = createTopic(s, "Introduction to Computer Networks");
        addQ(t, "What is Internet..?", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development",
            "VIDEO", "https://www.youtube.com/watch?v=x3c1ih2NJEg");
        addQ(t, "World Wide Web (WWW) Overview", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development",
            "VIDEO", "https://www.youtube.com/watch?v=J8hzJxb0rpc");
        addQ(t, "Data Transferring", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development",
            "VIDEO", "https://www.youtube.com/watch?v=AEaKrq3SpW8");
        addQ(t, "IP Address, Ports", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development",
            "VIDEO", "https://www.youtube.com/watch?v=ahlEcs3z7sE");
        addQ(t, "Internet Service Providers (ISPs)", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development",
            "VIDEO", "https://www.youtube.com/watch?v=ZxKM3DCV2kY");
        addQ(t, "Routers", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development",
            "VIDEO", "https://www.youtube.com/watch?v=UIp_oFJnJf0");

        t = createTopic(s, "Domain Name Systems");
        addQ(t, "What is DNS..?", "EASY",
            "ARTICLE", "https://www.cloudflare.com/en-gb/learning/dns/what-is-dns/",
            "VIDEO", "https://www.youtube.com/watch?v=mpQzAQooRII");
        addQ(t, "How DNS resolves domain names..?", "EASY",
            "ARTICLE", "https://www.cloudflare.com/en-gb/learning/dns/what-is-dns/",
            "VIDEO", "https://www.youtube.com/watch?v=vrxQBbVcs80");
        addQ(t, "Types - A, CNAME, MX Records", "EASY",
            "ARTICLE", "https://www.cloudflare.com/en-gb/learning/dns/dns-records/",
            "VIDEO", "https://www.youtube.com/watch?v=HnUDtycmTLU");
        addQ(t, "DNS Hierarchy - Root, TLDs, Authoritative DNS Servers", "EASY",
            "ARTICLE", "https://www.cloudflare.com/en-gb/learning/dns/dns-server-types/",
            "VIDEO", "https://www.youtube.com/watch?v=s5QlMkUL-Ww");
        addQ(t, "Browser queries to DNS servers for loading websites", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development",
            "VIDEO", "https://www.youtube.com/watch?v=mpQzAQooRII");

        t = createTopic(s, "Client Server Architecture");
        addQ(t, "Earlier System Architectures", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/HTTP",
            "VIDEO", "https://www.youtube.com/watch?v=jKT7-4ZXntI");
        addQ(t, "Need for Client-Server Architecture", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/HTTP",
            "VIDEO", "https://www.youtube.com/watch?v=jKT7-4ZXntI");
        addQ(t, "What is a Client Server Model..?", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Glossary/Client",
            "VIDEO", "https://www.youtube.com/watch?v=7S_tz1Z5bDk");
        addQ(t, "HTTP Request-Response Cycle", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/HTTP/Overview",
            "VIDEO", "https://www.youtube.com/watch?v=iYM2zFP3P6o");

        t = createTopic(s, "Internet Protocols");
        addQ(t, "What are Internet Protocols, and why are they needed..?", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/HTTP",
            "VIDEO", "https://www.youtube.com/watch?v=AEaKrq3SpW8");
        addQ(t, "TCP/IP", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/HTTP",
            "VIDEO", "https://www.youtube.com/watch?v=PpsEaqJV_A0");
        addQ(t, "HTTP, HTTPS", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/HTTP",
            "VIDEO", "https://www.youtube.com/watch?v=eesqK59rhGA");
        addQ(t, "WebSocket", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API",
            "VIDEO", "https://www.youtube.com/watch?v=8ARodQ4Wlf4");

        // ==========================================
        // Section 2: Developer Tools
        // ==========================================
        s = createSection("Developer Tools");

        t = createTopic(s, "IDEs");
        addQ(t, "VSCode Setup & Extensions for Frontend", "EASY",
            "ARTICLE", "https://code.visualstudio.com/docs/getstarted/getting-started",
            "VIDEO", "https://www.youtube.com/watch?v=WPqXP_kLzpo");

        t = createTopic(s, "Terminal");
        addQ(t, "Role of Terminal", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development",
            "VIDEO", "https://www.youtube.com/watch?v=s3ii48qYBxA");
        addQ(t, "Basic Commands (cd, ls, mkdir, rm)", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development",
            "VIDEO", "https://www.youtube.com/watch?v=uwAqEzhyjtw");

        t = createTopic(s, "Version Control");
        addQ(t, "Need for Version Control & Git", "EASY",
            "ARTICLE", "https://git-scm.com/book/en/v2/Getting-Started-About-Version-Control",
            "VIDEO", "https://www.youtube.com/watch?v=8JJ101D3knE");
        addQ(t, "Github Basics", "EASY",
            "ARTICLE", "https://docs.github.com/en/get-started",
            "VIDEO", "https://www.youtube.com/watch?v=RGOj5yH7evk");

        // ==========================================
        // Section 3: Building Blocks (HTML & CSS)
        // ==========================================
        s = createSection("Building Blocks (HTML & CSS)");

        t = createTopic(s, "Introduction to HTML");
        addQ(t, "HTML Tags and Elements", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/Structuring_content",
            "VIDEO", "https://www.youtube.com/watch?v=HGTJBPNC-Gw");
        addQ(t, "Semantic HTML", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Glossary/Semantics#semantics_in_html",
            "VIDEO", "https://www.youtube.com/watch?v=kGW8Al_cga4");

        t = createTopic(s, "Forms and Inputs");
        addQ(t, "Creating Forms & Handling different types of input", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/HTML/Reference/Elements/input",
            "VIDEO", "https://www.youtube.com/watch?v=fNcJuPIZ2WE");
        addQ(t, "Data Validation", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Extensions/Forms/Form_validation",
            "VIDEO", "https://www.youtube.com/watch?v=fNcJuPIZ2WE");

        t = createTopic(s, "CSS for Styling");
        addQ(t, "Cascading Style Sheets & Specificity", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/Styling_basics",
            "VIDEO", "https://www.youtube.com/watch?v=OXGznpKZ_sA");
        addQ(t, "CSS Box Model", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/Styling_basics/Box_model",
            "VIDEO", "https://www.youtube.com/watch?v=M6coJNLFBWI");

        t = createTopic(s, "Building Responsive Pages [Layouts]");
        addQ(t, "Building layouts with Flexbox", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/CSS_layout/Flexbox",
            "VIDEO", "https://www.youtube.com/watch?v=phWxA89Dy94");
        addQ(t, "Complex layouts with Grids", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/CSS_layout/Grids",
            "VIDEO", "https://www.youtube.com/watch?v=EiNiSFIPIQE");
        addQ(t, "CSS Media Queries", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_media_queries/Using_media_queries",
            "VIDEO", "https://www.youtube.com/watch?v=yU7jJ3NbPdA");

        t = createTopic(s, "Advanced CSS Tools");
        addQ(t, "Tailwind CSS Integration", "EASY",
            "ARTICLE", "https://tailwindcss.com/docs/installation",
            "VIDEO", "https://www.youtube.com/watch?v=ft30zcMlFao");

        // ==========================================
        // Section 4: JavaScript & Browser APIs
        // ==========================================
        s = createSection("JavaScript & Browser APIs");

        t = createTopic(s, "JavaScript Fundamentals");
        addQ(t, "Variables, Data Types, and Operators", "EASY",
            "ARTICLE", "https://javascript.info/variables",
            "VIDEO", "https://www.youtube.com/watch?v=PkZNo7MFNFg");
        addQ(t, "Conditionals and Loops", "EASY",
            "ARTICLE", "https://javascript.info/ifelse",
            "VIDEO", "https://www.youtube.com/watch?v=pN6jk0uUrD8");

        t = createTopic(s, "Functions & Scope");
        addQ(t, "Declaration, Expression, Arrow Functions", "EASY",
            "ARTICLE", "https://javascript.info/arrow-functions-basics",
            "VIDEO", "https://www.youtube.com/watch?v=pN6jk0uUrD8");
        addQ(t, "Variable Scope and Closures", "EASY",
            "ARTICLE", "https://javascript.info/closure",
            "VIDEO", "https://www.youtube.com/watch?v=qikxEIxsXco");

        t = createTopic(s, "Objects & Arrays");
        addQ(t, "Object Methods and Properties", "EASY",
            "ARTICLE", "https://javascript.info/object-methods",
            "VIDEO", "https://www.youtube.com/watch?v=pN6jk0uUrD8");
        addQ(t, "Array Methods (map, filter, reduce)", "EASY",
            "ARTICLE", "https://javascript.info/array-methods",
            "VIDEO", "https://www.youtube.com/watch?v=R8rmfD9Y5-c");
        addQ(t, "Destructuring & Spread Operator", "EASY",
            "ARTICLE", "https://javascript.info/destructuring-assignment",
            "VIDEO", "https://www.youtube.com/watch?v=NIq3qLaHCIs");

        t = createTopic(s, "Asynchronous JavaScript");
        addQ(t, "Callbacks and Event Loop", "EASY",
            "ARTICLE", "https://javascript.info/callbacks",
            "VIDEO", "https://www.youtube.com/watch?v=8aGhZQkoFbQ");
        addQ(t, "Promises and Chaining", "EASY",
            "ARTICLE", "https://javascript.info/promise-basics",
            "VIDEO", "https://www.youtube.com/watch?v=DHvZLI7Db8E");
        addQ(t, "Async / Await", "EASY",
            "ARTICLE", "https://javascript.info/async-await",
            "VIDEO", "https://www.youtube.com/watch?v=V_Kr9OSfDeU");

        t = createTopic(s, "JavaScript and DOM");
        addQ(t, "DOM Tree & Accessing Elements", "EASY",
            "ARTICLE", "https://javascript.info/dom-nodes",
            "VIDEO", "https://www.youtube.com/watch?v=0ik6X4DJKCc");
        addQ(t, "Event Listeners & Event Delegation", "EASY",
            "ARTICLE", "https://javascript.info/event-delegation",
            "VIDEO", "https://www.youtube.com/watch?v=XF1_MlZ5l6M");

        t = createTopic(s, "Network Requests");
        addQ(t, "Fetch API", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch",
            "VIDEO", "https://www.youtube.com/watch?v=drK3hPsXX_Y");
        addQ(t, "JSON Parsing", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/Scripting/JSON",
            "VIDEO", "https://www.youtube.com/watch?v=iiADhChRriM");

        // ==========================================
        // Section 5: TypeScript Essentials
        // ==========================================
        s = createSection("TypeScript Essentials");

        t = createTopic(s, "Type System");
        addQ(t, "Basic Types (string, number, boolean, any)", "EASY",
            "ARTICLE", "https://www.typescriptlang.org/docs/handbook/2/everyday-types.html",
            "VIDEO", "https://www.youtube.com/watch?v=BCg4U1FzODs");
        addQ(t, "Interfaces vs Type Aliases", "EASY",
            "ARTICLE", "https://www.typescriptlang.org/docs/handbook/2/everyday-types.html#differences-between-type-aliases-and-interfaces",
            "VIDEO", "https://www.youtube.com/watch?v=BCg4U1FzODs");
        addQ(t, "Union and Intersection Types", "EASY",
            "ARTICLE", "https://www.typescriptlang.org/docs/handbook/2/types-from-types.html",
            "VIDEO", "https://www.youtube.com/watch?v=BCg4U1FzODs");

        t = createTopic(s, "Advanced Types");
        addQ(t, "Generics", "MEDIUM",
            "ARTICLE", "https://www.typescriptlang.org/docs/handbook/2/generics.html",
            "VIDEO", "https://www.youtube.com/watch?v=BCg4U1FzODs");
        addQ(t, "Utility Types (Partial, Omit, Pick)", "MEDIUM",
            "ARTICLE", "https://www.typescriptlang.org/docs/handbook/utility-types.html",
            "VIDEO", "https://www.youtube.com/watch?v=BCg4U1FzODs");

        // ==========================================
        // Section 6: Building Modern Frontends (React)
        // ==========================================
        s = createSection("Building Modern Frontends (React)");

        t = createTopic(s, "Introduction to React");
        addQ(t, "What is React & Virtual DOM", "EASY",
            "ARTICLE", "https://react.dev/learn",
            "VIDEO", "https://www.youtube.com/watch?v=CgkZ7MvWUAA");
        addQ(t, "Setting up React App using Vite", "EASY",
            "ARTICLE", "https://vitejs.dev/guide/",
            "VIDEO", "https://www.youtube.com/watch?v=CgkZ7MvWUAA");
        addQ(t, "JSX / TSX Syntax", "EASY",
            "ARTICLE", "https://react.dev/learn/writing-markup-with-jsx",
            "VIDEO", "https://www.youtube.com/playlist?list=PLu71SKxNbfoDqgPchmvIsL4hTnJIrtige");

        t = createTopic(s, "Components and Props");
        addQ(t, "Building Reusable Components", "EASY",
            "ARTICLE", "https://react.dev/learn/your-first-component",
            "VIDEO", "https://www.youtube.com/playlist?list=PLu71SKxNbfoDqgPchmvIsL4hTnJIrtige");
        addQ(t, "Passing data using Props & Prop Drilling", "EASY",
            "ARTICLE", "https://react.dev/learn/passing-props-to-a-component",
            "VIDEO", "https://www.youtube.com/playlist?list=PLu71SKxNbfoDqgPchmvIsL4hTnJIrtige");

        t = createTopic(s, "States in React");
        addQ(t, "Managing state using useState", "EASY",
            "ARTICLE", "https://react.dev/reference/react/useState",
            "VIDEO", "https://www.youtube.com/watch?v=CgkZ7MvWUAA");
        addQ(t, "Lifting up state to parent", "EASY",
            "ARTICLE", "https://react.dev/learn/sharing-state-between-components",
            "VIDEO", "https://www.youtube.com/watch?v=CgkZ7MvWUAA");
        addQ(t, "Conditional Rendering", "EASY",
            "ARTICLE", "https://react.dev/learn/conditional-rendering",
            "VIDEO", "https://www.youtube.com/watch?v=CgkZ7MvWUAA");

        t = createTopic(s, "React Effects and Lifecycle");
        addQ(t, "useEffect hook for side effects", "EASY",
            "ARTICLE", "https://react.dev/reference/react/useEffect",
            "VIDEO", "https://www.youtube.com/watch?v=gv9ugDJ1ynU");
        addQ(t, "Cleanup and DOM Manipulation", "MEDIUM",
            "ARTICLE", "https://react.dev/learn/synchronizing-with-effects",
            "VIDEO", "https://www.youtube.com/watch?v=gv9ugDJ1ynU");

        t = createTopic(s, "Interactivity & Forms");
        addQ(t, "Event Handling", "EASY",
            "ARTICLE", "https://react.dev/learn/responding-to-events",
            "VIDEO", "https://www.youtube.com/watch?v=CgkZ7MvWUAA");
        addQ(t, "Controlled and Uncontrolled Forms", "EASY",
            "ARTICLE", "https://react.dev/learn/sharing-state-between-components#controlled-and-uncontrolled-components",
            "VIDEO", "https://www.youtube.com/watch?v=SdzMBWT2CDQ");
        addQ(t, "Form Validation with React Hook Form", "MEDIUM",
            "ARTICLE", "https://react-hook-form.com/get-started",
            "VIDEO", "https://www.youtube.com/watch?v=bU_eq8qyjic");

        // ==========================================
        // Section 7: Frontend Ecosystem & API Integration
        // ==========================================
        s = createSection("Frontend Ecosystem & API Integration");

        t = createTopic(s, "Connecting to Backend APIs");
        addQ(t, "Understanding CORS (Cross-Origin Resource Sharing)", "MEDIUM",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS",
            "VIDEO", "https://www.youtube.com/watch?v=4KHiSt0eqy0");
        addQ(t, "Fetching Data with Axios", "EASY",
            "ARTICLE", "https://axios-http.com/docs/intro",
            "VIDEO", "https://www.youtube.com/watch?v=6LyagUHKRYY");
        addQ(t, "Data Fetching & Caching with TanStack (React) Query", "MEDIUM",
            "ARTICLE", "https://tanstack.com/query/latest/docs/framework/react/overview",
            "VIDEO", "https://www.youtube.com/watch?v=lVLz_ASqAio");

        t = createTopic(s, "Routing in React Apps");
        addQ(t, "Client Side Routing Overview", "EASY",
            "ARTICLE", "https://reactrouter.com/en/main/start/concepts",
            "VIDEO", "https://www.youtube.com/watch?v=Ul3y1LXxzdU");
        addQ(t, "Navigating and Dynamic Routing (React-Router)", "EASY",
            "ARTICLE", "https://reactrouter.com/en/main",
            "VIDEO", "https://www.youtube.com/watch?v=Ul3y1LXxzdU");

        t = createTopic(s, "Global State Management");
        addQ(t, "Context API for Global State", "EASY",
            "ARTICLE", "https://react.dev/learn/passing-data-deeply-with-context",
            "VIDEO", "https://www.youtube.com/watch?v=5LrDIWkK_Bc");
        addQ(t, "Using Zustand for Scalable State", "MEDIUM",
            "ARTICLE", "https://zustand.docs.pmnd.rs/getting-started/introduction",
            "VIDEO", "https://www.youtube.com/watch?v=_ngCLZ5Iz-0");

        t = createTopic(s, "Performance Optimization & Patterns");
        addQ(t, "useCallback, useMemo, and React.memo", "MEDIUM",
            "ARTICLE", "https://react.dev/reference/react/memo",
            "VIDEO", "https://www.youtube.com/watch?v=_AyFP5s69N4");
        addQ(t, "Building Custom Hooks", "MEDIUM",
            "ARTICLE", "https://react.dev/learn/reusing-logic-with-custom-hooks",
            "VIDEO", "https://www.youtube.com/watch?v=6ThXsUwLWvc");
            
        t = createTopic(s, "Deployment (React)");
        addQ(t, "Available Platforms - Vercel, Netlify", "EASY",
            "ARTICLE", "https://vitejs.dev/guide/static-deploy.html",
            "VIDEO", "https://www.youtube.com/watch?v=2HBIzEx6IZA");
        addQ(t, "Configure Environment Variables (.env)", "EASY",
            "ARTICLE", "https://vitejs.dev/guide/env-and-mode.html",
            "VIDEO", "https://www.youtube.com/watch?v=2HBIzEx6IZA");

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