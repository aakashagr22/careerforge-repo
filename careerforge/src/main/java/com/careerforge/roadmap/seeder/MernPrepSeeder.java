package com.careerforge.roadmap.seeder;

import java.util.ArrayList;
import java.util.List;

public class MernPrepSeeder {

    public static void seed(
        com.careerforge.roadmap.entity.Roadmap dbRoadmap,
        com.careerforge.roadmap.repository.RoadmapSectionRepository roadmapSectionRepository,
        com.careerforge.roadmap.repository.QuestionRepository questionRepository,
        com.careerforge.roadmap.repository.QuestionLinkRepository questionLinkRepository,
        com.careerforge.roadmap.repository.RoadmapSectionQuestionRepository roadmapSectionQuestionRepository
    ) {
        System.out.println("Seeding Roadmap: MERN Stack Complete Preparation Sheet");
        Roadmap.sections.clear();

        RoadmapSection s;
        Topic t;

        // ==========================================
        // Section 1: Fundamentals
        // ==========================================
        s = createSection("Fundamentals");

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
        addQ(t, "Recursive DNS Resolver", "EASY",
            "ARTICLE", "https://www.cloudflare.com/en-gb/learning/dns/dns-server-types/",
            "VIDEO", "https://www.youtube.com/watch?v=vrxQBbVcs80");

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
        addQ(t, "Web Servers and Web Hosting", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn/Common_questions/Web_mechanics/What_is_a_web_server",
            "VIDEO", "https://www.youtube.com/watch?v=9J1nJOivdyw");

        t = createTopic(s, "Internet Protocols");
        addQ(t, "What are Internet Protocols, and why are they needed..?", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/HTTP",
            "VIDEO", "https://www.youtube.com/watch?v=AEaKrq3SpW8");
        addQ(t, "TCP/IP", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/HTTP",
            "VIDEO", "https://www.youtube.com/watch?v=PpsEaqJV_A0");
        addQ(t, "SYN, SYN-ACK, and ACK", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Glossary/TCP_handshake",
            "VIDEO", "https://www.youtube.com/watch?v=xMtP5ZB3wSk");
        addQ(t, "Data segmentation, Error checking and Retransmission", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/HTTP",
            "VIDEO", "https://www.youtube.com/watch?v=PpsEaqJV_A0");
        addQ(t, "UDP - Datagram-based transmission", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Glossary/UDP",
            "VIDEO", "https://www.youtube.com/watch?v=yjyivqMkH0E");
        addQ(t, "Reliability vs Speed", "EASY",
            "ARTICLE", "https://www.cloudflare.com/en-gb/learning/ddos/glossary/user-datagram-protocol-udp/",
            "VIDEO", "https://www.youtube.com/watch?v=yjyivqMkH0E");
        addQ(t, "HTTP, HTTPS", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/HTTP",
            "VIDEO", "https://www.youtube.com/watch?v=eesqK59rhGA");
        addQ(t, "TLS/SSL", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Glossary/TLS",
            "VIDEO", "https://www.youtube.com/watch?v=0TLDTodL7Lc");
        addQ(t, "WebSocket", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API",
            "VIDEO", "https://www.youtube.com/watch?v=8ARodQ4Wlf4");
        addQ(t, "WebRTC", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/API/WebRTC_API",
            "VIDEO", "https://www.youtube.com/watch?v=2Z2PDsqgJP8");


        // ==========================================
        // Section 2: Tools
        // ==========================================
        s = createSection("Tools");

        t = createTopic(s, "IDEs");
        addQ(t, "Need for IDEs", "EASY",
            "ARTICLE", "https://code.visualstudio.com/docs",
            "VIDEO", "https://www.youtube.com/watch?v=VqCgcpAypFQ");
        addQ(t, "Types of IDEs", "EASY",
            "ARTICLE", "https://code.visualstudio.com/docs",
            "VIDEO", "https://www.youtube.com/watch?v=VqCgcpAypFQ");
        addQ(t, "VSCode", "EASY",
            "ARTICLE", "https://code.visualstudio.com/docs/getstarted/getting-started",
            "VIDEO", "https://www.youtube.com/watch?v=WPqXP_kLzpo");
        addQ(t, "AI in IDEs", "EASY",
            "ARTICLE", "https://code.visualstudio.com/docs/copilot/overview",
            "VIDEO", "https://www.youtube.com/watch?v=VqCgcpAypFQ");

        t = createTopic(s, "Terminal");
        addQ(t, "Role of Terminal", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development",
            "VIDEO", "https://www.youtube.com/watch?v=s3ii48qYBxA");
        addQ(t, "Basic Commands", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development",
            "VIDEO", "https://www.youtube.com/watch?v=uwAqEzhyjtw");

        t = createTopic(s, "Version Control");
        addQ(t, "Need for Version Control", "EASY",
            "ARTICLE", "https://git-scm.com/book/en/v2/Getting-Started-About-Version-Control",
            "VIDEO", "https://www.youtube.com/watch?v=8JJ101D3knE");
        addQ(t, "Git", "EASY",
            "ARTICLE", "https://git-scm.com/doc",
            "VIDEO", "https://www.youtube.com/watch?v=8JJ101D3knE");
        addQ(t, "Github", "EASY",
            "ARTICLE", "https://docs.github.com/en/get-started",
            "VIDEO", "https://www.youtube.com/watch?v=RGOj5yH7evk");

        t = createTopic(s, "AI Assistance");
        addQ(t, "Don'ts", "EASY",
            "ARTICLE", "https://platform.openai.com/docs",
            "VIDEO", "https://www.youtube.com/watch?v=jHv63Uvk5VA");
        addQ(t, "Do's", "EASY",
            "ARTICLE", "https://platform.openai.com/docs",
            "VIDEO", "https://www.youtube.com/watch?v=jHv63Uvk5VA");
        addQ(t, "Available Options", "EASY",
            "ARTICLE", "https://platform.openai.com/docs",
            "VIDEO", "https://www.youtube.com/watch?v=jHv63Uvk5VA");


        // ==========================================
        // Section 3: Building Blocks
        // ==========================================
        s = createSection("Building Blocks");

        t = createTopic(s, "Introduction to HTML");
        addQ(t, "Skeleton for Web", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/Structuring_content",
            "VIDEO", "https://www.youtube.com/watch?v=HGTJBPNC-Gw");
        addQ(t, "HTML Tags and Elements", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/Structuring_content",
            "VIDEO", "https://www.youtube.com/watch?v=HGTJBPNC-Gw");
        addQ(t, "Building Webpage using HTML", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Getting_started/Your_first_website",
            "VIDEO", "https://www.youtube.com/watch?v=916GWv2Qs08");
        addQ(t, "Working with Texts", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/Structuring_content/Headings_and_paragraphs",
            "VIDEO", "https://www.youtube.com/watch?v=HGTJBPNC-Gw");
        addQ(t, "Semantic HTML", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Glossary/Semantics#semantics_in_html",
            "VIDEO", "https://www.youtube.com/watch?v=kGW8Al_cga4");

        t = createTopic(s, "Forms and Inputs");
        addQ(t, "Creating Forms", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Extensions/Forms",
            "VIDEO", "https://www.youtube.com/watch?v=fNcJuPIZ2WE");
        addQ(t, "Form Submissions", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Extensions/Forms/Sending_and_retrieving_form_data",
            "VIDEO", "https://www.youtube.com/watch?v=fNcJuPIZ2WE");
        addQ(t, "Handling different types of input", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/HTML/Reference/Elements/input",
            "VIDEO", "https://www.youtube.com/watch?v=frAGrGN00OA");
        addQ(t, "HTML5 Inputs - Date, Email, Tel, Range, Color", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/HTML/Reference/Elements/input",
            "VIDEO", "https://www.youtube.com/watch?v=frAGrGN00OA");
        addQ(t, "Data Validation", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Extensions/Forms/Form_validation",
            "VIDEO", "https://www.youtube.com/watch?v=fNcJuPIZ2WE");

        t = createTopic(s, "CSS for Styling");
        addQ(t, "Cascading Style Sheets", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/Styling_basics",
            "VIDEO", "https://www.youtube.com/watch?v=OXGznpKZ_sA");
        addQ(t, "CSS Box Model", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/Styling_basics/Box_model",
            "VIDEO", "https://www.youtube.com/watch?v=M6coJNLFBWI");
        addQ(t, "Styling Texts", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/Text_styling",
            "VIDEO", "https://www.youtube.com/watch?v=OXGznpKZ_sA");
        addQ(t, "Specificity & CSS Selectors", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/CSS/Specificity",
            "VIDEO", "https://www.youtube.com/watch?v=l1mER1bV0N0");

        t = createTopic(s, "Building Responsive Pages [Layouts]");
        addQ(t, "Layout Techniques in CSS", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/CSS_layout",
            "VIDEO", "https://www.youtube.com/watch?v=phWxA89Dy94");
        addQ(t, "Building layouts with Flexbox", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/CSS_layout/Flexbox",
            "VIDEO", "https://www.youtube.com/watch?v=phWxA89Dy94");
        addQ(t, "Complex layouts with Grids", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/CSS_layout/Grids",
            "VIDEO", "https://www.youtube.com/watch?v=EiNiSFIPIQE");
        addQ(t, "CSS Media Queries", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_media_queries/Using_media_queries",
            "VIDEO", "https://www.youtube.com/watch?v=yU7jJ3NbPdA");

        t = createTopic(s, "Advanced CSS");
        addQ(t, "Pseudo Classes and Pseudo Elements", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/CSS/Pseudo-classes",
            "VIDEO", "https://www.youtube.com/watch?v=OXGznpKZ_sA");
        addQ(t, "Styling Links, Buttons and Forms for Better UX", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/CSS",
            "VIDEO", "https://www.youtube.com/watch?v=OXGznpKZ_sA");
        addQ(t, "CSS Frameworks - Bootstrap, Tailwind CSS", "EASY",
            "ARTICLE", "https://tailwindcss.com/docs/installation",
            "VIDEO", "https://www.youtube.com/watch?v=ft30zcMlFao");
        addQ(t, "Animations and Transitions", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_animations/Using_CSS_animations",
            "VIDEO", "https://www.youtube.com/watch?v=YszONjKpgg4");
        addQ(t, "Shadows & Gradients", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/CSS/box-shadow",
            "VIDEO", "https://www.youtube.com/watch?v=OXGznpKZ_sA");
        addQ(t, "Popular Libraries", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/CSS",
            "VIDEO", "https://www.youtube.com/watch?v=OXGznpKZ_sA");


        // ==========================================
        // Section 4: Interacting With Browser
        // ==========================================
        s = createSection("Interacting With Browser");

        t = createTopic(s, "Introduction to JavaScript");
        addQ(t, "Role in Web Development", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Getting_started/Your_first_website/Adding_interactivity",
            "VIDEO", "https://www.youtube.com/watch?v=lfmg-EJ8gm4");
        addQ(t, "State of JavaScript in 2026", "EASY",
            "ARTICLE", "https://javascript.info/intro",
            "VIDEO", "https://www.youtube.com/watch?v=lfmg-EJ8gm4");
        addQ(t, "Future Scope", "EASY",
            "ARTICLE", "https://javascript.info/intro",
            "VIDEO", "https://www.youtube.com/watch?v=lfmg-EJ8gm4");

        t = createTopic(s, "JavaScript Fundamentals");
        addQ(t, "Hello, world!", "EASY",
            "ARTICLE", "https://javascript.info/hello-world",
            "VIDEO", "https://www.youtube.com/watch?v=pN6jk0uUrD8",
            "VIDEO", "https://www.youtube.com/watch?v=PkZNo7MFNFg");
        addQ(t, "Comments in JavaScript", "EASY",
            "ARTICLE", "https://javascript.info/structure",
            "VIDEO", "https://www.youtube.com/watch?v=pN6jk0uUrD8");
        addQ(t, "Variables and Primitive Data Types", "EASY",
            "ARTICLE", "https://javascript.info/variables",
            "VIDEO", "https://www.youtube.com/watch?v=pN6jk0uUrD8",
            "VIDEO", "https://www.youtube.com/watch?v=PkZNo7MFNFg");
        addQ(t, "Types of Operators", "EASY",
            "ARTICLE", "https://javascript.info/operators",
            "VIDEO", "https://www.youtube.com/watch?v=pN6jk0uUrD8");
        addQ(t, "Conditionals [if-else, switch, ternary operator]", "EASY",
            "ARTICLE", "https://javascript.info/ifelse",
            "VIDEO", "https://www.youtube.com/watch?v=pN6jk0uUrD8");
        addQ(t, "Loops [while, for]", "EASY",
            "ARTICLE", "https://javascript.info/while-for",
            "VIDEO", "https://www.youtube.com/watch?v=pN6jk0uUrD8");

        t = createTopic(s, "Functions in JavaScript");
        addQ(t, "What is Function..?", "EASY",
            "ARTICLE", "https://javascript.info/function-basics",
            "VIDEO", "https://www.youtube.com/watch?v=pN6jk0uUrD8");
        addQ(t, "Functional Programming Paradigm", "EASY",
            "ARTICLE", "https://javascript.info/function-expressions",
            "VIDEO", "https://www.youtube.com/watch?v=e-5obm1G_FY");
        addQ(t, "Three Types of Functions [Declaration, Expression, Arrow]", "EASY",
            "ARTICLE", "https://javascript.info/arrow-functions-basics",
            "VIDEO", "https://www.youtube.com/watch?v=pN6jk0uUrD8");
        addQ(t, "Parameters and Arguments", "EASY",
            "ARTICLE", "https://javascript.info/function-basics",
            "VIDEO", "https://www.youtube.com/watch?v=pN6jk0uUrD8");
        addQ(t, "Returning from Function", "EASY",
            "ARTICLE", "https://javascript.info/function-basics",
            "VIDEO", "https://www.youtube.com/watch?v=pN6jk0uUrD8");
        addQ(t, "Hoisting in JavaScript", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Glossary/Hoisting",
            "VIDEO", "https://www.youtube.com/watch?v=ER9SspLe4Hg");
        addQ(t, "Variable Scope and Closures", "EASY",
            "ARTICLE", "https://javascript.info/closure",
            "VIDEO", "https://www.youtube.com/watch?v=qikxEIxsXco");

        t = createTopic(s, "JavaScript Objects");
        addQ(t, "Object in JavaScript", "EASY",
            "ARTICLE", "https://javascript.info/object",
            "VIDEO", "https://www.youtube.com/watch?v=pN6jk0uUrD8");
        addQ(t, "Object References and Copying", "EASY",
            "ARTICLE", "https://javascript.info/object-copy",
            "VIDEO", "https://www.youtube.com/watch?v=pN6jk0uUrD8");
        addQ(t, "Object Methods", "EASY",
            "ARTICLE", "https://javascript.info/object-methods",
            "VIDEO", "https://www.youtube.com/watch?v=pN6jk0uUrD8");
        addQ(t, "Optional Chaining", "EASY",
            "ARTICLE", "https://javascript.info/optional-chaining",
            "VIDEO", "https://www.youtube.com/watch?v=pN6jk0uUrD8");
        addQ(t, "JavaScript Object Notation [JSON]", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/Scripting/JSON",
            "VIDEO", "https://www.youtube.com/watch?v=iiADhChRriM");
        addQ(t, "Symbol Type", "EASY",
            "ARTICLE", "https://javascript.info/symbol",
            "VIDEO", "https://www.youtube.com/watch?v=pN6jk0uUrD8");

        t = createTopic(s, "Data Types in JavaScript");
        addQ(t, "Strings", "EASY",
            "ARTICLE", "https://javascript.info/string",
            "VIDEO", "https://www.youtube.com/watch?v=09BwruU4kiY");
        addQ(t, "Array Data Structure", "EASY",
            "ARTICLE", "https://javascript.info/array",
            "VIDEO", "https://www.youtube.com/watch?v=0SyTDl4pb4w");
        addQ(t, "Array Methods", "EASY",
            "ARTICLE", "https://javascript.info/array-methods",
            "VIDEO", "https://www.youtube.com/watch?v=R8rmfD9Y5-c");
        addQ(t, "Iterating Over Arrays", "EASY",
            "ARTICLE", "https://javascript.info/array-methods",
            "VIDEO", "https://www.youtube.com/watch?v=R8rmfD9Y5-c");
        addQ(t, "Date and Time", "EASY",
            "ARTICLE", "https://javascript.info/date",
            "VIDEO", "https://www.youtube.com/watch?v=pN6jk0uUrD8");

        t = createTopic(s, "Modern JavaScript ES6+ Features");
        addQ(t, "Destructuring Arrays and Objects", "EASY",
            "ARTICLE", "https://javascript.info/destructuring-assignment",
            "VIDEO", "https://www.youtube.com/watch?v=NIq3qLaHCIs");
        addQ(t, "Template Literals & String Interpolation", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Template_literals",
            "VIDEO", "https://www.youtube.com/watch?v=NIq3qLaHCIs");
        addQ(t, "Default Parameters", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/Default_parameters",
            "VIDEO", "https://www.youtube.com/watch?v=NIq3qLaHCIs");
        addQ(t, "Rest and Spread Operator", "EASY",
            "ARTICLE", "https://javascript.info/rest-parameters-spread",
            "VIDEO", "https://www.youtube.com/watch?v=iLx4ma8ZqvQ");
        addQ(t, "Maps and Sets in JavaScript", "EASY",
            "ARTICLE", "https://javascript.info/map-set",
            "VIDEO", "https://www.youtube.com/watch?v=hLgUTM3FOII");
        addQ(t, "WeakMap and WeakSet in JavaScript", "EASY",
            "ARTICLE", "https://javascript.info/weakmap-weakset",
            "VIDEO", "https://www.youtube.com/watch?v=hLgUTM3FOII");
        addQ(t, "ES6 Modules (import / export)", "EASY",
            "ARTICLE", "https://javascript.info/modules-intro",
            "VIDEO", "https://www.youtube.com/watch?v=cRHQNNkYi1A");

        t = createTopic(s, "Object Oriented JavaScript");
        addQ(t, "Introduction to OOPs", "EASY",
            "ARTICLE", "https://javascript.info/classes",
            "VIDEO", "https://www.youtube.com/watch?v=PFmuCDHHpwk");
        addQ(t, "Classes and Objects in JavaScript", "EASY",
            "ARTICLE", "https://javascript.info/class",
            "VIDEO", "https://www.youtube.com/watch?v=PFmuCDHHpwk");
        addQ(t, "Constructors and this Keyword", "EASY",
            "ARTICLE", "https://javascript.info/constructor-new",
            "VIDEO", "https://www.youtube.com/watch?v=gvicrj31JOM");
        addQ(t, "Prototypal Inheritance", "EASY",
            "ARTICLE", "https://javascript.info/prototype-inheritance",
            "VIDEO", "https://www.youtube.com/watch?v=1UTqFAjYx1k");
        addQ(t, "Polymorphism", "EASY",
            "ARTICLE", "https://javascript.info/class-inheritance",
            "VIDEO", "https://www.youtube.com/watch?v=PFmuCDHHpwk");
        addQ(t, "Encapsulation - Private and Protected Properties", "EASY",
            "ARTICLE", "https://javascript.info/private-protected-properties-methods",
            "VIDEO", "https://www.youtube.com/watch?v=PFmuCDHHpwk");

        t = createTopic(s, "Asynchronous JavaScript");
        addQ(t, "Introduction to Asynchronous Programming", "EASY",
            "ARTICLE", "https://javascript.info/async",
            "VIDEO", "https://www.youtube.com/watch?v=PoRJizFvM7s");
        addQ(t, "setTimeout and setInterval", "EASY",
            "ARTICLE", "https://javascript.info/settimeout-setinterval",
            "VIDEO", "https://www.youtube.com/watch?v=exBgWAIeIeg");
        addQ(t, "Callbacks and Callback Hell", "EASY",
            "ARTICLE", "https://javascript.info/callbacks",
            "VIDEO", "https://www.youtube.com/watch?v=QSqc6MMS6Fk");
        addQ(t, "JavaScript Promise", "EASY",
            "ARTICLE", "https://javascript.info/promise-basics",
            "VIDEO", "https://www.youtube.com/watch?v=DHvZLI7Db8E");
        addQ(t, "Promises Chaining", "EASY",
            "ARTICLE", "https://javascript.info/promise-chaining",
            "VIDEO", "https://www.youtube.com/watch?v=DHvZLI7Db8E");
        addQ(t, "async and await", "EASY",
            "ARTICLE", "https://javascript.info/async-await",
            "VIDEO", "https://www.youtube.com/watch?v=V_Kr9OSfDeU");

        t = createTopic(s, "JavaScript and DOM");
        addQ(t, "DOM Tree", "EASY",
            "ARTICLE", "https://javascript.info/dom-nodes",
            "VIDEO", "https://www.youtube.com/watch?v=0ik6X4DJKCc");
        addQ(t, "Methods for Accessing DOM", "EASY",
            "ARTICLE", "https://javascript.info/searching-elements-dom",
            "VIDEO", "https://www.youtube.com/watch?v=0ik6X4DJKCc");
        addQ(t, "Updating DOM Content", "EASY",
            "ARTICLE", "https://javascript.info/modifying-document",
            "VIDEO", "https://www.youtube.com/watch?v=0ik6X4DJKCc");
        addQ(t, "Adding and Removing Element", "EASY",
            "ARTICLE", "https://javascript.info/modifying-document",
            "VIDEO", "https://www.youtube.com/watch?v=0ik6X4DJKCc");

        t = createTopic(s, "Event Handling");
        addQ(t, "Introduction to browser events", "EASY",
            "ARTICLE", "https://javascript.info/introduction-browser-events",
            "VIDEO", "https://www.youtube.com/watch?v=XF1_MlZ5l6M");
        addQ(t, "Event Listeners", "EASY",
            "ARTICLE", "https://javascript.info/introduction-browser-events",
            "VIDEO", "https://www.youtube.com/watch?v=XF1_MlZ5l6M");
        addQ(t, "Event Bubbling and Capturing", "EASY",
            "ARTICLE", "https://javascript.info/bubbling-and-capturing",
            "VIDEO", "https://www.youtube.com/watch?v=aKShnpOXqn0");
        addQ(t, "Event Delegation", "EASY",
            "ARTICLE", "https://javascript.info/event-delegation",
            "VIDEO", "https://www.youtube.com/watch?v=aKShnpOXqn0");
        addQ(t, "Prevent Default Behaviours and Stopping Propagation", "EASY",
            "ARTICLE", "https://javascript.info/default-browser-action",
            "VIDEO", "https://www.youtube.com/watch?v=aKShnpOXqn0");

        t = createTopic(s, "Network Requests");
        addQ(t, "Fetch", "EASY",
            "ARTICLE", "https://javascript.info/fetch",
            "VIDEO", "https://www.youtube.com/watch?v=drK3hPsXX_Y");
        addQ(t, "Cross Origin Requests", "EASY",
            "ARTICLE", "https://javascript.info/fetch-crossorigin",
            "VIDEO", "https://www.youtube.com/watch?v=PNtFSVU-YTI");
        addQ(t, "Fetch API", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch",
            "VIDEO", "https://www.youtube.com/watch?v=drK3hPsXX_Y");

        t = createTopic(s, "Advance JavaScript");
        addQ(t, "Closures and Lexical Scoping", "EASY",
            "ARTICLE", "https://javascript.info/closure",
            "VIDEO", "https://www.youtube.com/watch?v=qikxEIxsXco");
        addQ(t, "Understanding this keyword in different context", "EASY",
            "ARTICLE", "https://javascript.info/object-methods",
            "VIDEO", "https://www.youtube.com/watch?v=gvicrj31JOM");
        addQ(t, "Call, Apply and Bind Methods", "EASY",
            "ARTICLE", "https://javascript.info/call-apply-decorators",
            "VIDEO", "https://www.youtube.com/watch?v=75W8UPQ5l7k");
        addQ(t, "Error Handling using try-catch", "EASY",
            "ARTICLE", "https://javascript.info/try-catch",
            "VIDEO", "https://www.youtube.com/watch?v=cFTFtuEQ-10");
        addQ(t, "Custom Errors", "EASY",
            "ARTICLE", "https://javascript.info/custom-errors",
            "VIDEO", "https://www.youtube.com/watch?v=cFTFtuEQ-10");


        // ==========================================
        // Section 5: TypeScript Essentials
        // ==========================================
        s = createSection("TypeScript Essentials");

        t = createTopic(s, "JavaScript with Types");
        addQ(t, "What is TypeScript and Why It Exists", "EASY",
            "ARTICLE", "https://www.typescriptlang.org/docs/handbook/typescript-from-scratch.html",
            "VIDEO", "https://www.youtube.com/watch?v=BCg4U1FzODs",
            "VIDEO", "https://www.youtube.com/watch?v=30LWjhZzg50");
        addQ(t, "Thinking in TypeScript", "EASY",
            "ARTICLE", "https://www.typescriptlang.org/docs/handbook/intro.html",
            "VIDEO", "https://www.youtube.com/watch?v=BCg4U1FzODs");
        addQ(t, "Installing and Setting Up TypeScript", "EASY",
            "ARTICLE", "https://www.typescriptlang.org/docs/handbook/typescript-tooling-in-5-minutes.html",
            "VIDEO", "https://www.youtube.com/watch?v=BCg4U1FzODs");

        t = createTopic(s, "Type System");
        addQ(t, "Basic Types (string, number, boolean, any, unknown)", "EASY",
            "ARTICLE", "https://www.typescriptlang.org/docs/handbook/2/everyday-types.html",
            "VIDEO", "https://www.youtube.com/watch?v=BCg4U1FzODs",
            "VIDEO", "https://www.youtube.com/watch?v=30LWjhZzg50");
        addQ(t, "Interfaces vs Type Aliases", "EASY",
            "ARTICLE", "https://www.typescriptlang.org/docs/handbook/2/everyday-types.html#differences-between-type-aliases-and-interfaces",
            "VIDEO", "https://www.youtube.com/watch?v=BCg4U1FzODs");
        addQ(t, "Union and Intersection Types", "EASY",
            "ARTICLE", "https://www.typescriptlang.org/docs/handbook/2/types-from-types.html",
            "VIDEO", "https://www.youtube.com/watch?v=BCg4U1FzODs");

        t = createTopic(s, "Generics");
        addQ(t, "Generic Functions", "EASY",
            "ARTICLE", "https://www.typescriptlang.org/docs/handbook/2/generics.html",
            "VIDEO", "https://www.youtube.com/watch?v=BCg4U1FzODs");
        addQ(t, "Generic Interfaces and Constraints", "EASY",
            "ARTICLE", "https://www.typescriptlang.org/docs/handbook/2/generics.html#generic-constraints",
            "VIDEO", "https://www.youtube.com/watch?v=BCg4U1FzODs");

        t = createTopic(s, "TypeScript Tooling");
        addQ(t, "tsconfig.json Explained", "EASY",
            "ARTICLE", "https://www.typescriptlang.org/tsconfig",
            "VIDEO", "https://www.youtube.com/watch?v=BCg4U1FzODs");
        addQ(t, "TypeScript Compiler", "EASY",
            "ARTICLE", "https://www.typescriptlang.org/docs/handbook/2/basic-types.html#tsc-the-typescript-compiler",
            "VIDEO", "https://www.youtube.com/watch?v=BCg4U1FzODs");
        addQ(t, "Linting and Formatting with TypeScript", "EASY",
            "ARTICLE", "https://typescript-eslint.io/getting-started",
            "VIDEO", "https://www.youtube.com/watch?v=BCg4U1FzODs");


        // ==========================================
        // Section 6: Backend Engineering
        // ==========================================
        s = createSection("Backend Engineering");

        t = createTopic(s, "Introduction to Runtime Environments");
        addQ(t, "Need for JavaScript on Server", "EASY",
            "ARTICLE", "https://nodejs.org/en/learn/getting-started/introduction-to-nodejs",
            "VIDEO", "https://www.youtube.com/watch?v=EH3vGeqeIAo",
            "VIDEO", "https://www.youtube.com/watch?v=f2EqECiTBL8");
        addQ(t, "Node.js History", "EASY",
            "ARTICLE", "https://nodejs.org/en/learn/getting-started/a-brief-history-of-nodejs",
            "VIDEO", "https://www.youtube.com/watch?v=EH3vGeqeIAo");
        addQ(t, "State of Runtimes in 2026", "EASY",
            "ARTICLE", "https://nodejs.org/en/learn/getting-started/introduction-to-nodejs",
            "VIDEO", "https://www.youtube.com/watch?v=EH3vGeqeIAo");

        t = createTopic(s, "Node.js Architecture");
        addQ(t, "How Node.js differs from Traditional Server-side languages", "EASY",
            "ARTICLE", "https://nodejs.org/en/docs/guides/event-loop-timers-and-nexttick",
            "VIDEO", "https://www.youtube.com/watch?v=jOupHNvDIq8");
        addQ(t, "Event-driven, Non-Blocking I/O model in Node.js", "EASY",
            "ARTICLE", "https://nodejs.org/en/docs/guides/event-loop-timers-and-nexttick",
            "VIDEO", "https://www.youtube.com/watch?v=jOupHNvDIq8");
        addQ(t, "Event loop: Microtasks and Macrotasks", "EASY",
            "ARTICLE", "https://nodejs.org/en/docs/guides/event-loop-timers-and-nexttick",
            "VIDEO", "https://www.youtube.com/watch?v=eiC58R16hb8");
        addQ(t, "Importance of callbacks and promises in managing asynchronous code", "EASY",
            "ARTICLE", "https://nodejs.org/en/learn/asynchronous-work/javascript-asynchronous-programming-and-callbacks",
            "VIDEO", "https://www.youtube.com/watch?v=jOupHNvDIq8");

        t = createTopic(s, "Your First HTTP Server");
        addQ(t, "Setting up a simple Node.js App", "EASY",
            "ARTICLE", "https://nodejs.org/api/http.html",
            "VIDEO", "https://www.youtube.com/watch?v=Oe421EPjeBE");
        addQ(t, "HTTP Module", "EASY",
            "ARTICLE", "https://nodejs.org/api/http.html",
            "VIDEO", "https://www.youtube.com/watch?v=Oe421EPjeBE");
        addQ(t, "HTTP Methods [Get, Post, Put, Delete]", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Methods",
            "VIDEO", "https://www.youtube.com/watch?v=Oe421EPjeBE");
        addQ(t, "Sending and Receiving Data", "EASY",
            "ARTICLE", "https://nodejs.org/api/http.html",
            "VIDEO", "https://www.youtube.com/watch?v=Oe421EPjeBE");
        addQ(t, "Working with Request and Response Objects", "EASY",
            "ARTICLE", "https://nodejs.org/api/http.html",
            "VIDEO", "https://www.youtube.com/watch?v=Oe421EPjeBE");

        t = createTopic(s, "Express.js for Building Backends");
        addQ(t, "Simplifying Backend Development with Express", "EASY",
            "ARTICLE", "https://expressjs.com/en/guide/routing.html",
            "VIDEO", "https://www.youtube.com/playlist?list=PLva6eWAdzarBdK31FuU8mVktSzhfdOX3n",
            "VIDEO", "https://www.youtube.com/watch?v=qwfE7fSVaZM");
        addQ(t, "Setting up an Express App", "EASY",
            "ARTICLE", "https://expressjs.com/en/starter/hello-world.html",
            "VIDEO", "https://www.youtube.com/watch?v=Oe421EPjeBE");
        addQ(t, "Defining Routes", "EASY",
            "ARTICLE", "https://expressjs.com/en/guide/routing.html",
            "VIDEO", "https://www.youtube.com/watch?v=qwfE7fSVaZM");
        addQ(t, "Dynamic Data [URL Params & Query Strings]", "EASY",
            "ARTICLE", "https://expressjs.com/en/guide/routing.html",
            "VIDEO", "https://www.youtube.com/watch?v=qwfE7fSVaZM");
        addQ(t, "Middleware in Express", "EASY",
            "ARTICLE", "https://expressjs.com/en/guide/using-middleware.html",
            "VIDEO", "https://www.youtube.com/watch?v=lY6icfhap2o");

        t = createTopic(s, "RESTful API Designs");
        addQ(t, "RESTful API Paradigm", "EASY",
            "ARTICLE", "https://restfulapi.net/",
            "VIDEO", "https://www.youtube.com/watch?v=-MTSQjw5DrM");
        addQ(t, "Designing Endpoints and Handling HTTP Methods", "EASY",
            "ARTICLE", "https://restfulapi.net/rest-api-design-tutorial-with-example/",
            "VIDEO", "https://www.youtube.com/watch?v=-MTSQjw5DrM");
        addQ(t, "Using query params and request body for passing data", "EASY",
            "ARTICLE", "https://expressjs.com/en/api.html#req.query",
            "VIDEO", "https://www.youtube.com/watch?v=-MTSQjw5DrM");
        addQ(t, "Returning JSON data", "EASY",
            "ARTICLE", "https://expressjs.com/en/api.html#res.json",
            "VIDEO", "https://www.youtube.com/watch?v=-MTSQjw5DrM");
        addQ(t, "Handling Status Codes in Response", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Status",
            "VIDEO", "https://www.youtube.com/watch?v=-MTSQjw5DrM");

        t = createTopic(s, "Reading and Writing Files");
        addQ(t, "fs module for file system operations", "EASY",
            "ARTICLE", "https://nodejs.org/api/fs.html",
            "VIDEO", "https://www.youtube.com/watch?v=EFEpnlMTMWc");
        addQ(t, "Asynchronous vs Synchronous Reading", "EASY",
            "ARTICLE", "https://nodejs.org/api/fs.html#fsreadfilepath-options-callback",
            "VIDEO", "https://www.youtube.com/watch?v=EFEpnlMTMWc");
        addQ(t, "Writing files to servers", "EASY",
            "ARTICLE", "https://nodejs.org/api/fs.html#fswritefilefile-data-options-callback",
            "VIDEO", "https://www.youtube.com/watch?v=EFEpnlMTMWc");
        addQ(t, "Handling file uploads [multer]", "EASY",
            "ARTICLE", "https://github.com/expressjs/multer",
            "VIDEO", "https://www.youtube.com/watch?v=EVOFt8Its6I");

        t = createTopic(s, "Databases");
        addQ(t, "Persisting the Data", "EASY",
            "ARTICLE", "https://mongoosejs.com/docs/guide.html",
            "VIDEO", "https://www.youtube.com/watch?v=_7UQPve99r4");
        addQ(t, "SQL vs NoSQL", "EASY",
            "ARTICLE", "https://www.mongodb.com/resources/compare/relational-vs-non-relational-databases",
            "VIDEO", "https://www.youtube.com/watch?v=t0GlGbtMTio");
        addQ(t, "MongoDB with Node.js using Mongoose", "EASY",
            "ARTICLE", "https://mongoosejs.com/docs/guide.html",
            "VIDEO", "https://www.youtube.com/watch?v=_7UQPve99r4",
            "VIDEO", "https://www.youtube.com/watch?v=4yqu8YF29cU");
        addQ(t, "PostgreSQL with Node.js", "EASY",
            "ARTICLE", "https://node-postgres.com/",
            "VIDEO", "https://www.youtube.com/watch?v=3rlhneBMDGc");
        addQ(t, "Using ORMs [Drizzle] for security and DX", "EASY",
            "ARTICLE", "https://orm.drizzle.team/docs/overview",
            "VIDEO", "https://www.youtube.com/watch?v=ePRBDRaoP2E");

        t = createTopic(s, "Authentication and Authorization");
        addQ(t, "What is Authentication and Authorization?", "EASY",
            "ARTICLE", "https://auth0.com/docs/get-started/identity-fundamentals/authentication-and-authorization",
            "VIDEO", "https://www.youtube.com/watch?v=UBUNrFtufWo");
        addQ(t, "Stateless Authentication using JWTs", "EASY",
            "ARTICLE", "https://jwt.io/introduction",
            "VIDEO", "https://www.youtube.com/watch?v=7Q17ubqLfaM");
        addQ(t, "User Registration and Login Flow", "EASY",
            "ARTICLE", "https://jwt.io/introduction",
            "VIDEO", "https://www.youtube.com/watch?v=enopDSs3DRw");
        addQ(t, "Password Hashing and Verification (bcryptjs)", "EASY",
            "ARTICLE", "https://github.com/dcodeIO/bcrypt.js",
            "VIDEO", "https://www.youtube.com/watch?v=AzA_LTDoFqY");
        addQ(t, "Role Based Access Control (RBAC)", "EASY",
            "ARTICLE", "https://auth0.com/docs/manage-users/access-control/rbac",
            "VIDEO", "https://www.youtube.com/watch?v=jI4K7L-LI58");
        addQ(t, "Securing Routes using Authentication Middleware", "EASY",
            "ARTICLE", "https://expressjs.com/en/guide/using-middleware.html",
            "VIDEO", "https://www.youtube.com/watch?v=enopDSs3DRw");
        addQ(t, "JSON Web Key Set (JWKS)", "EASY",
            "ARTICLE", "https://auth0.com/docs/secure/tokens/json-web-tokens/json-web-key-sets",
            "VIDEO", "https://www.youtube.com/watch?v=7Q17ubqLfaM");
        addQ(t, "OAuth 2.0 and OpenID Connect (OIDC)", "EASY",
            "ARTICLE", "https://auth0.com/docs/authenticate/protocols/oauth",
            "VIDEO", "https://www.youtube.com/watch?v=996OiexHze0");
        addQ(t, "Google Zanzibar Authorization Model (White Paper)", "EASY",
            "ARTICLE", "https://research.google/pubs/zanzibar-googles-consistent-global-authorization-system/",
            "VIDEO", "https://www.youtube.com/watch?v=jI4K7L-LI58");

        t = createTopic(s, "Real-Time Applications with WebSockets");
        addQ(t, "How WebSockets Enable Real-Time Communication", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API",
            "VIDEO", "https://www.youtube.com/watch?v=8ARodQ4Wlf4");
        addQ(t, "Polling vs WebSockets vs Server-Sent Events (SSE)", "EASY",
            "ARTICLE", "https://ably.com/blog/websockets-vs-long-polling",
            "VIDEO", "https://www.youtube.com/watch?v=ZBM28ZPlin8");
        addQ(t, "Upgrading HTTP Requests to Full-Duplex Connections", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Headers/Upgrade",
            "VIDEO", "https://www.youtube.com/watch?v=8ARodQ4Wlf4");
        addQ(t, "Setting Up a WebSocket Server (socket.io)", "EASY",
            "ARTICLE", "https://socket.io/docs/v4/",
            "VIDEO", "https://www.youtube.com/watch?v=ZKEqqIO7n-k");
        addQ(t, "Sending and Receiving Real-Time Data Between Client and Server", "EASY",
            "ARTICLE", "https://socket.io/docs/v4/emitting-events/",
            "VIDEO", "https://www.youtube.com/watch?v=ZKEqqIO7n-k");
        addQ(t, "Use Cases for Real-Time Applications", "EASY",
            "ARTICLE", "https://socket.io/docs/v4/",
            "VIDEO", "https://www.youtube.com/watch?v=ZKEqqIO7n-k");

        t = createTopic(s, "API Rate Limiting");
        addQ(t, "Why rate limiting is important..?", "EASY",
            "ARTICLE", "https://www.cloudflare.com/en-gb/learning/bots/what-is-rate-limiting/",
            "VIDEO", "https://www.youtube.com/watch?v=mhUQe4BKZXs");
        addQ(t, "Implement Rate Limiting [express-rate-limit]", "EASY",
            "ARTICLE", "https://www.npmjs.com/package/express-rate-limit",
            "VIDEO", "https://www.youtube.com/watch?v=mhUQe4BKZXs");
        addQ(t, "Configuring custom rate limiters for different endpoints", "EASY",
            "ARTICLE", "https://www.npmjs.com/package/express-rate-limit",
            "VIDEO", "https://www.youtube.com/watch?v=mhUQe4BKZXs");
        addQ(t, "Handling Rate Limit Exceeded Errors and Responses", "EASY",
            "ARTICLE", "https://www.npmjs.com/package/express-rate-limit",
            "VIDEO", "https://www.youtube.com/watch?v=mhUQe4BKZXs");

        t = createTopic(s, "High Throughput Systems");
        addQ(t, "Introduction to Redis", "EASY",
            "ARTICLE", "https://redis.io/docs/latest/get-started/",
            "VIDEO", "https://www.youtube.com/watch?v=jgpVdJB2sKQ",
            "VIDEO", "https://www.youtube.com/watch?v=brw3uVmQgZ8");
        addQ(t, "Working with Redis Streams", "EASY",
            "ARTICLE", "https://redis.io/docs/latest/develop/data-types/streams/",
            "VIDEO", "https://www.youtube.com/watch?v=jgpVdJB2sKQ");
        addQ(t, "Building a Rate Limiter from Scratch using Redis and Distributed Locks", "EASY",
            "ARTICLE", "https://redis.io/docs/latest/develop/use/patterns/distributed-locks/",
            "VIDEO", "https://www.youtube.com/watch?v=jgpVdJB2sKQ");
        addQ(t, "Kafka - Append-Only Log System", "EASY",
            "ARTICLE", "https://kafka.apache.org/documentation/#introduction",
            "VIDEO", "https://www.youtube.com/watch?v=ZJJHm_bd9Zo",
            "VIDEO", "https://www.youtube.com/watch?v=QkdkLdMBuL0");
        addQ(t, "Kafka and Zookeeper Setup using Docker", "EASY",
            "ARTICLE", "https://kafka.apache.org/documentation/#quickstart",
            "VIDEO", "https://www.youtube.com/watch?v=ZJJHm_bd9Zo");
        addQ(t, "Kafka Consumers and Consumer Groups", "EASY",
            "ARTICLE", "https://kafka.apache.org/documentation/#intro_consumers",
            "VIDEO", "https://www.youtube.com/watch?v=ZJJHm_bd9Zo");
        addQ(t, "Building Pub/Sub, Queue, and CQRS Patterns", "EASY",
            "ARTICLE", "https://kafka.apache.org/documentation/",
            "VIDEO", "https://www.youtube.com/watch?v=ZJJHm_bd9Zo");

        t = createTopic(s, "Logging & Monitoring");
        addQ(t, "Need for Logging", "EASY",
            "ARTICLE", "https://github.com/winstonjs/winston",
            "VIDEO", "https://www.youtube.com/watch?v=log-monitoring");
        addQ(t, "Structured Logging with Winston and Morgan", "EASY",
            "ARTICLE", "https://github.com/winstonjs/winston",
            "VIDEO", "https://www.youtube.com/watch?v=log-monitoring");
        addQ(t, "Logging Levels (info, warn, error, debug)", "EASY",
            "ARTICLE", "https://github.com/winstonjs/winston#logging",
            "VIDEO", "https://www.youtube.com/watch?v=log-monitoring");
        addQ(t, "Storing Logs in Files and External Log Services", "EASY",
            "ARTICLE", "https://github.com/winstonjs/winston#transports",
            "VIDEO", "https://www.youtube.com/watch?v=log-monitoring");
        addQ(t, "Importance of Monitoring and Observability", "EASY",
            "ARTICLE", "https://opentelemetry.io/docs/concepts/observability-primer/",
            "VIDEO", "https://www.youtube.com/watch?v=log-monitoring");
        addQ(t, "PM2 for Process Management and Performance Monitoring", "EASY",
            "ARTICLE", "https://pm2.keymetrics.io/docs/usage/quick-start/",
            "VIDEO", "https://www.youtube.com/watch?v=oykl1Ih9pMg");
        addQ(t, "Setting Up OpenTelemetry (OTEL) with Axiom and SigNoz", "EASY",
            "ARTICLE", "https://opentelemetry.io/docs/languages/js/getting-started/nodejs/",
            "VIDEO", "https://www.youtube.com/watch?v=log-monitoring");

        t = createTopic(s, "Deployment");
        addQ(t, "Deploying Node.js apps on Cloud [Heroku, AWS, DigitalOcean, etc]", "EASY",
            "ARTICLE", "https://docs.digitalocean.com/tutorials/app-deploy-nodejs-app/",
            "VIDEO", "https://www.youtube.com/watch?v=nQdyiK7-VlQ");
        addQ(t, "Setting up env variables for production, development and testing", "EASY",
            "ARTICLE", "https://nodejs.org/en/learn/command-line/how-to-read-environment-variables-from-nodejs",
            "VIDEO", "https://www.youtube.com/watch?v=nQdyiK7-VlQ");
        addQ(t, "Configuring reverse proxies with Nginx or Caddy", "EASY",
            "ARTICLE", "https://nginx.org/en/docs/beginners_guide.html",
            "VIDEO", "https://www.youtube.com/watch?v=7VAI73roXaY");


        // ==========================================
        // Section 7: Building Modern Frontends
        // ==========================================
        s = createSection("Building Modern Frontends");

        t = createTopic(s, "Introduction to React");
        addQ(t, "What is React", "EASY",
            "ARTICLE", "https://react.dev/learn",
            "VIDEO", "https://www.youtube.com/playlist?list=PLu71SKxNbfoDqgPchmvIsL4hTnJIrtige",
            "VIDEO", "https://www.youtube.com/watch?v=CgkZ7MvWUAA");
        addQ(t, "State of React in 2026", "EASY",
            "ARTICLE", "https://react.dev/blog",
            "VIDEO", "https://www.youtube.com/playlist?list=PLu71SKxNbfoDqgPchmvIsL4hTnJIrtige");
        addQ(t, "Virtual DOM and React", "EASY",
            "ARTICLE", "https://react.dev/learn/preserving-and-resetting-state",
            "VIDEO", "https://www.youtube.com/watch?v=BYbgopx44vo");
        addQ(t, "Setting up React App using Vite", "EASY",
            "ARTICLE", "https://vitejs.dev/guide/",
            "VIDEO", "https://www.youtube.com/watch?v=CgkZ7MvWUAA");
        addQ(t, "JSX or TSX Syntax", "EASY",
            "ARTICLE", "https://react.dev/learn/writing-markup-with-jsx",
            "VIDEO", "https://www.youtube.com/playlist?list=PLu71SKxNbfoDqgPchmvIsL4hTnJIrtige");
        addQ(t, "Rendering", "EASY",
            "ARTICLE", "https://react.dev/learn/render-and-commit",
            "VIDEO", "https://www.youtube.com/playlist?list=PLu71SKxNbfoDqgPchmvIsL4hTnJIrtige");

        t = createTopic(s, "Components and Props");
        addQ(t, "Class vs Functional Components", "EASY",
            "ARTICLE", "https://react.dev/learn/passing-props-to-a-component",
            "VIDEO", "https://www.youtube.com/watch?v=u6gSSpfsoOQ");
        addQ(t, "Passing data using Props", "EASY",
            "ARTICLE", "https://react.dev/learn/passing-props-to-a-component",
            "VIDEO", "https://www.youtube.com/playlist?list=PLu71SKxNbfoDqgPchmvIsL4hTnJIrtige");
        addQ(t, "Children and Default Props", "EASY",
            "ARTICLE", "https://react.dev/learn/passing-props-to-a-component#passing-jsx-as-children",
            "VIDEO", "https://www.youtube.com/playlist?list=PLu71SKxNbfoDqgPchmvIsL4hTnJIrtige");
        addQ(t, "Prop Drilling", "EASY",
            "ARTICLE", "https://react.dev/learn/passing-data-deeply-with-context",
            "VIDEO", "https://www.youtube.com/watch?v=3XaXKiXtNjw");
        addQ(t, "Building Reusable Components", "EASY",
            "ARTICLE", "https://react.dev/learn/your-first-component",
            "VIDEO", "https://www.youtube.com/playlist?list=PLu71SKxNbfoDqgPchmvIsL4hTnJIrtige");

        t = createTopic(s, "States in React");
        addQ(t, "State and Re-rendering", "EASY",
            "ARTICLE", "https://react.dev/learn/state-a-components-memory",
            "VIDEO", "https://www.youtube.com/watch?v=CgkZ7MvWUAA");
        addQ(t, "Managing state using useState", "EASY",
            "ARTICLE", "https://react.dev/reference/react/useState",
            "VIDEO", "https://www.youtube.com/watch?v=CgkZ7MvWUAA");
        addQ(t, "Lifting up state to parent", "EASY",
            "ARTICLE", "https://react.dev/learn/sharing-state-between-components",
            "VIDEO", "https://www.youtube.com/watch?v=CgkZ7MvWUAA");
        addQ(t, "Conditional Rendering", "EASY",
            "ARTICLE", "https://react.dev/learn/conditional-rendering",
            "VIDEO", "https://www.youtube.com/watch?v=CgkZ7MvWUAA");

        t = createTopic(s, "React Lifecycle Methods");
        addQ(t, "Component lifecycles in class components", "EASY",
            "ARTICLE", "https://react.dev/reference/react/Component",
            "VIDEO", "https://www.youtube.com/watch?v=0ZJgIjIuY7U");
        addQ(t, "React's lifecycle methods", "EASY",
            "ARTICLE", "https://react.dev/reference/react/Component#adding-lifecycle-methods-to-a-class-component",
            "VIDEO", "https://www.youtube.com/watch?v=0ZJgIjIuY7U");
        addQ(t, "useEffect hook for side effects", "EASY",
            "ARTICLE", "https://react.dev/reference/react/useEffect",
            "VIDEO", "https://www.youtube.com/watch?v=gv9ugDJ1ynU");
        addQ(t, "Data Fetching, Cleanup and DOM Manipulation", "EASY",
            "ARTICLE", "https://react.dev/learn/synchronizing-with-effects",
            "VIDEO", "https://www.youtube.com/watch?v=gv9ugDJ1ynU");

        t = createTopic(s, "Interactivity in React");
        addQ(t, "Event Handling (clicks, form submissions and user input)", "EASY",
            "ARTICLE", "https://react.dev/learn/responding-to-events",
            "VIDEO", "https://www.youtube.com/watch?v=CgkZ7MvWUAA");
        addQ(t, "Binding Event Handlers in components", "EASY",
            "ARTICLE", "https://react.dev/learn/responding-to-events",
            "VIDEO", "https://www.youtube.com/watch?v=CgkZ7MvWUAA");
        addQ(t, "Event Flow Control", "EASY",
            "ARTICLE", "https://react.dev/learn/responding-to-events#stopping-propagation",
            "VIDEO", "https://www.youtube.com/watch?v=CgkZ7MvWUAA");

        t = createTopic(s, "React Hooks");
        addQ(t, "Need of Hooks in Functional Components", "EASY",
            "ARTICLE", "https://react.dev/reference/react",
            "VIDEO", "https://www.youtube.com/playlist?list=PLinedj3B30sCHqHtgbjg1lSYgWebm1dyI",
            "VIDEO", "https://www.youtube.com/playlist?list=PL0Zuz27SZ-6PSdiQpSxO9zxvB0ns6m3ta");
        addQ(t, "useContext, useReducer", "EASY",
            "ARTICLE", "https://react.dev/reference/react/useContext",
            "VIDEO", "https://www.youtube.com/playlist?list=PLinedj3B30sCHqHtgbjg1lSYgWebm1dyI");
        addQ(t, "useCallback, useMemo", "EASY",
            "ARTICLE", "https://react.dev/reference/react/useCallback",
            "VIDEO", "https://www.youtube.com/watch?v=_AyFP5s69N4");
        addQ(t, "useRef", "EASY",
            "ARTICLE", "https://react.dev/reference/react/useRef",
            "VIDEO", "https://www.youtube.com/watch?v=t2ypzz6gzmg");
        addQ(t, "Best practices for working with hooks", "EASY",
            "ARTICLE", "https://react.dev/learn/reusing-logic-with-custom-hooks",
            "VIDEO", "https://www.youtube.com/playlist?list=PLinedj3B30sCHqHtgbjg1lSYgWebm1dyI");

        t = createTopic(s, "Routing in React Apps");
        addQ(t, "SPAs", "EASY",
            "ARTICLE", "https://developer.mozilla.org/en-US/docs/Glossary/SPA",
            "VIDEO", "https://www.youtube.com/watch?v=Ul3y1LXxzdU");
        addQ(t, "Client Side Routings", "EASY",
            "ARTICLE", "https://reactrouter.com/en/main/start/concepts",
            "VIDEO", "https://www.youtube.com/watch?v=Ul3y1LXxzdU");
        addQ(t, "Routing Libraries [React-Router, Tanstack Router]", "EASY",
            "ARTICLE", "https://reactrouter.com/en/main",
            "VIDEO", "https://www.youtube.com/watch?v=Ul3y1LXxzdU");
        addQ(t, "Navigating between components", "EASY",
            "ARTICLE", "https://reactrouter.com/en/main/components/link",
            "VIDEO", "https://www.youtube.com/watch?v=Ul3y1LXxzdU");
        addQ(t, "Dynamic Routing [URL Params, Query Strings]", "EASY",
            "ARTICLE", "https://reactrouter.com/en/main/route/route#dynamic-segments",
            "VIDEO", "https://www.youtube.com/watch?v=Ul3y1LXxzdU");

        t = createTopic(s, "State Management");
        addQ(t, "Context API for Global State Management", "EASY",
            "ARTICLE", "https://react.dev/learn/passing-data-deeply-with-context",
            "VIDEO", "https://www.youtube.com/watch?v=5LrDIWkK_Bc");
        addQ(t, "Creating Context, Providing It and Consuming it in components", "EASY",
            "ARTICLE", "https://react.dev/reference/react/createContext",
            "VIDEO", "https://www.youtube.com/watch?v=5LrDIWkK_Bc");
        addQ(t, "Access and Update Global State", "EASY",
            "ARTICLE", "https://react.dev/learn/scaling-up-with-reducer-and-context",
            "VIDEO", "https://www.youtube.com/watch?v=5LrDIWkK_Bc");
        addQ(t, "Avoiding Prop Drilling with Context API", "EASY",
            "ARTICLE", "https://react.dev/learn/passing-data-deeply-with-context",
            "VIDEO", "https://www.youtube.com/watch?v=5LrDIWkK_Bc");

        t = createTopic(s, "Forms in React");
        addQ(t, "Controlled and Uncontrolled Forms in React", "EASY",
            "ARTICLE", "https://react.dev/learn/sharing-state-between-components#controlled-and-uncontrolled-components",
            "VIDEO", "https://www.youtube.com/watch?v=SdzMBWT2CDQ");
        addQ(t, "Handling Form Submissions", "EASY",
            "ARTICLE", "https://react.dev/reference/react-dom/components/input",
            "VIDEO", "https://www.youtube.com/watch?v=SdzMBWT2CDQ");
        addQ(t, "Form Validation", "EASY",
            "ARTICLE", "https://react.dev/reference/react-dom/components/input",
            "VIDEO", "https://www.youtube.com/watch?v=SdzMBWT2CDQ");
        addQ(t, "Building Complex forms with Multiple Input fields", "EASY",
            "ARTICLE", "https://react.dev/reference/react-dom/components/input",
            "VIDEO", "https://www.youtube.com/watch?v=SdzMBWT2CDQ");
        addQ(t, "Popular Libraries [React Hook Form, Tanstack Form]", "EASY",
            "ARTICLE", "https://react-hook-form.com/get-started",
            "VIDEO", "https://www.youtube.com/watch?v=bU_eq8qyjic");

        t = createTopic(s, "Performance Optimization");
        addQ(t, "React rendering behaviour", "EASY",
            "ARTICLE", "https://react.dev/learn/render-and-commit",
            "VIDEO", "https://www.youtube.com/watch?v=dtmqev36_Sg");
        addQ(t, "Performance Bottlenecks", "EASY",
            "ARTICLE", "https://react.dev/learn/render-and-commit",
            "VIDEO", "https://www.youtube.com/watch?v=dtmqev36_Sg");
        addQ(t, "Memoization and Lazy Loading", "EASY",
            "ARTICLE", "https://react.dev/reference/react/lazy",
            "VIDEO", "https://www.youtube.com/watch?v=_AyFP5s69N4");
        addQ(t, "React.memo, useMemo and useCallback", "EASY",
            "ARTICLE", "https://react.dev/reference/react/memo",
            "VIDEO", "https://www.youtube.com/watch?v=_AyFP5s69N4");
        addQ(t, "React Suspense", "EASY",
            "ARTICLE", "https://react.dev/reference/react/Suspense",
            "VIDEO", "https://www.youtube.com/watch?v=dtmqev36_Sg");

        t = createTopic(s, "Deployment (React)");
        addQ(t, "Available Platforms - Vercel, Netlify, Heroku, Hostinger, AWS, etc.", "EASY",
            "ARTICLE", "https://vitejs.dev/guide/static-deploy.html",
            "VIDEO", "https://www.youtube.com/watch?v=2HBIzEx6IZA");
        addQ(t, "Configure environment variables", "EASY",
            "ARTICLE", "https://vitejs.dev/guide/env-and-mode.html",
            "VIDEO", "https://www.youtube.com/watch?v=2HBIzEx6IZA");
        addQ(t, "Building react apps for production", "EASY",
            "ARTICLE", "https://vitejs.dev/guide/build.html",
            "VIDEO", "https://www.youtube.com/watch?v=2HBIzEx6IZA");
        addQ(t, "Setting up Continuous Deployment", "EASY",
            "ARTICLE", "https://vercel.com/docs/deployments/git",
            "VIDEO", "https://www.youtube.com/watch?v=2HBIzEx6IZA");

        t = createTopic(s, "React Advance Patterns");
        addQ(t, "Higher Order Components and Render Props", "EASY",
            "ARTICLE", "https://react.dev/learn/reusing-logic-with-custom-hooks",
            "VIDEO", "https://www.youtube.com/watch?v=B6aNv8nkUSw");
        addQ(t, "Compound Components for Reusable logic", "EASY",
            "ARTICLE", "https://react.dev/learn/reusing-logic-with-custom-hooks",
            "VIDEO", "https://www.youtube.com/watch?v=B6aNv8nkUSw");
        addQ(t, "Custom Hooks", "EASY",
            "ARTICLE", "https://react.dev/learn/reusing-logic-with-custom-hooks",
            "VIDEO", "https://www.youtube.com/watch?v=6ThXsUwLWvc");
        addQ(t, "Context Providers and Consumers for State Management", "EASY",
            "ARTICLE", "https://react.dev/reference/react/createContext",
            "VIDEO", "https://www.youtube.com/watch?v=5LrDIWkK_Bc");

        t = createTopic(s, "Scaling React Apps");
        addQ(t, "Structuring Large-scale React Apps", "EASY",
            "ARTICLE", "https://react.dev/learn",
            "VIDEO", "https://www.youtube.com/watch?v=UHclE5uGqEQ");
        addQ(t, "Organizing components, hooks, and utilities for maintainability", "EASY",
            "ARTICLE", "https://react.dev/learn",
            "VIDEO", "https://www.youtube.com/watch?v=UHclE5uGqEQ");
        addQ(t, "Breaking the app into features for better scalability", "EASY",
            "ARTICLE", "https://react.dev/learn",
            "VIDEO", "https://www.youtube.com/watch?v=UHclE5uGqEQ");
        addQ(t, "Using Client Side state management libraries", "EASY",
            "ARTICLE", "https://zustand.docs.pmnd.rs/getting-started/introduction",
            "VIDEO", "https://www.youtube.com/watch?v=_ngCLZ5Iz-0");


        // ==========================================
        // Section 8: Full Stack Development
        // ==========================================
        s = createSection("Full Stack Development");

        t = createTopic(s, "Introduction to Full Stack Frameworks");
        addQ(t, "What are full stack frameworks..?", "EASY",
            "ARTICLE", "https://nextjs.org/docs",
            "VIDEO", "https://www.youtube.com/watch?v=Sklc_fQBmcs");
        addQ(t, "State of Frameworks in 2026", "EASY",
            "ARTICLE", "https://nextjs.org/docs",
            "VIDEO", "https://www.youtube.com/watch?v=Sklc_fQBmcs");

        t = createTopic(s, "Next.js Basics");
        addQ(t, "Why Next.js is so popular..", "EASY",
            "ARTICLE", "https://nextjs.org/docs",
            "VIDEO", "https://www.youtube.com/watch?v=Sklc_fQBmcs");
        addQ(t, "Next.js vs React.js", "EASY",
            "ARTICLE", "https://nextjs.org/docs/app/getting-started/installation",
            "VIDEO", "https://www.youtube.com/watch?v=Sklc_fQBmcs");
        addQ(t, "Setting up Next.js Project", "EASY",
            "ARTICLE", "https://nextjs.org/docs/app/getting-started/installation",
            "VIDEO", "https://www.youtube.com/watch?v=Sklc_fQBmcs");
        addQ(t, "File Based Routing", "EASY",
            "ARTICLE", "https://nextjs.org/docs/app/building-your-application/routing",
            "VIDEO", "https://www.youtube.com/watch?v=Sklc_fQBmcs");
        addQ(t, "Layouts in Next.js", "EASY",
            "ARTICLE", "https://nextjs.org/docs/app/building-your-application/routing/layouts-and-templates",
            "VIDEO", "https://www.youtube.com/watch?v=Sklc_fQBmcs");

        t = createTopic(s, "SSG, SSR, ISR");
        addQ(t, "Server Side Rendering", "EASY",
            "ARTICLE", "https://nextjs.org/docs/app/building-your-application/rendering/server-components",
            "VIDEO", "https://www.youtube.com/watch?v=Sklc_fQBmcs");
        addQ(t, "Static Site Generation", "EASY",
            "ARTICLE", "https://nextjs.org/docs/app/building-your-application/rendering/server-components",
            "VIDEO", "https://www.youtube.com/watch?v=Sklc_fQBmcs");
        addQ(t, "Incremental Static Regeneration", "EASY",
            "ARTICLE", "https://nextjs.org/docs/app/building-your-application/data-fetching/incremental-static-regeneration",
            "VIDEO", "https://www.youtube.com/watch?v=Sklc_fQBmcs");

        t = createTopic(s, "Building APIs in Next.js");
        addQ(t, "API Routes", "EASY",
            "ARTICLE", "https://nextjs.org/docs/app/building-your-application/routing/route-handlers",
            "VIDEO", "https://www.youtube.com/watch?v=Sklc_fQBmcs");
        addQ(t, "Get, Post, Put, Patch and Delete Operations", "EASY",
            "ARTICLE", "https://nextjs.org/docs/app/building-your-application/routing/route-handlers",
            "VIDEO", "https://www.youtube.com/watch?v=Sklc_fQBmcs");
        addQ(t, "Connecting with DB", "EASY",
            "ARTICLE", "https://nextjs.org/docs/app/building-your-application/data-fetching",
            "VIDEO", "https://www.youtube.com/watch?v=Sklc_fQBmcs");
        addQ(t, "Structured Responses and Error Handling", "EASY",
            "ARTICLE", "https://nextjs.org/docs/app/building-your-application/routing/error-handling",
            "VIDEO", "https://www.youtube.com/watch?v=Sklc_fQBmcs");

        t = createTopic(s, "Server Actions");
        addQ(t, "Server Actions vs API Routes", "EASY",
            "ARTICLE", "https://nextjs.org/docs/app/building-your-application/data-fetching/server-actions-and-mutations",
            "VIDEO", "https://www.youtube.com/watch?v=RadgkoJrhu0");
        addQ(t, "use server directive", "EASY",
            "ARTICLE", "https://nextjs.org/docs/app/building-your-application/data-fetching/server-actions-and-mutations",
            "VIDEO", "https://www.youtube.com/watch?v=RadgkoJrhu0");
        addQ(t, "Implementing Server Actions", "EASY",
            "ARTICLE", "https://nextjs.org/docs/app/building-your-application/data-fetching/server-actions-and-mutations",
            "VIDEO", "https://www.youtube.com/watch?v=RadgkoJrhu0");


        // ==========================================
        // Section 9: AI Integrations
        // ==========================================
        s = createSection("AI Integrations");

        t = createTopic(s, "State of AI in 2026");
        addQ(t, "What is GenAI..?", "EASY",
            "ARTICLE", "https://sdk.vercel.ai/docs/introduction",
            "VIDEO", "https://www.youtube.com/watch?v=sTeoEFzVNSc");
        addQ(t, "LLMs", "EASY",
            "ARTICLE", "https://sdk.vercel.ai/docs/foundations/models",
            "VIDEO", "https://www.youtube.com/watch?v=sTeoEFzVNSc");
        addQ(t, "Use cases", "EASY",
            "ARTICLE", "https://platform.openai.com/docs/use-cases",
            "VIDEO", "https://www.youtube.com/watch?v=sTeoEFzVNSc");

        t = createTopic(s, "Introduction to Workflows and Agents");
        addQ(t, "Understanding Workflows", "EASY",
            "ARTICLE", "https://www.inngest.com/docs/learn/inngest-functions",
            "VIDEO", "https://www.youtube.com/watch?v=jHv63Uvk5VA");
        addQ(t, "What are Agents..?", "EASY",
            "ARTICLE", "https://sdk.vercel.ai/docs/ai-sdk-core/agents",
            "VIDEO", "https://www.youtube.com/watch?v=jHv63Uvk5VA");
        addQ(t, "How they are different from traditional ways", "EASY",
            "ARTICLE", "https://sdk.vercel.ai/docs/foundations/overview",
            "VIDEO", "https://www.youtube.com/watch?v=jHv63Uvk5VA");

        t = createTopic(s, "Inngest");
        addQ(t, "Orchestration Engine", "EASY",
            "ARTICLE", "https://www.inngest.com/docs",
            "VIDEO", "https://www.youtube.com/watch?v=jHv63Uvk5VA");
        addQ(t, "Building Workflows using Inngest", "EASY",
            "ARTICLE", "https://www.inngest.com/docs/quick-start",
            "VIDEO", "https://www.youtube.com/watch?v=jHv63Uvk5VA");

        t = createTopic(s, "Vercel AI Workflows");
        addQ(t, "Step", "EASY",
            "ARTICLE", "https://sdk.vercel.ai/docs/ai-sdk-core/agents#using-multi-step-agent",
            "VIDEO", "https://www.youtube.com/watch?v=jHv63Uvk5VA");
        addQ(t, "Sleep", "EASY",
            "ARTICLE", "https://www.inngest.com/docs/reference/functions/step-sleep",
            "VIDEO", "https://www.youtube.com/watch?v=jHv63Uvk5VA");
        addQ(t, "Hook", "EASY",
            "ARTICLE", "https://sdk.vercel.ai/docs/reference/ai-sdk-ui/use-chat",
            "VIDEO", "https://www.youtube.com/watch?v=jHv63Uvk5VA");
        addQ(t, "Observability", "EASY",
            "ARTICLE", "https://sdk.vercel.ai/docs/ai-sdk-core/telemetry",
            "VIDEO", "https://www.youtube.com/watch?v=jHv63Uvk5VA");

        t = createTopic(s, "AI Agentic Workflows");
        addQ(t, "Patterns in Agentic Workflows", "EASY",
            "ARTICLE", "https://sdk.vercel.ai/docs/foundations/overview",
            "VIDEO", "https://www.youtube.com/watch?v=jHv63Uvk5VA");
        addQ(t, "Use Cases", "EASY",
            "ARTICLE", "https://sdk.vercel.ai/docs/foundations/overview",
            "VIDEO", "https://www.youtube.com/watch?v=jHv63Uvk5VA");
        addQ(t, "Examples", "EASY",
            "ARTICLE", "https://sdk.vercel.ai/docs/examples",
            "VIDEO", "https://www.youtube.com/watch?v=jHv63Uvk5VA");


        // ==========================================
        // Section 10: DevOps for Developers
        // ==========================================
        s = createSection("DevOps for Developers");

        t = createTopic(s, "Docker");
        addQ(t, "Docker and it's need", "EASY",
            "ARTICLE", "https://docs.docker.com/get-started/docker-overview/",
            "VIDEO", "https://www.youtube.com/watch?v=31k6AtW-b3Y",
            "VIDEO", "https://www.youtube.com/watch?v=pg19Z8LL06w");
        addQ(t, "Creating images and running containers", "EASY",
            "ARTICLE", "https://docs.docker.com/get-started/",
            "VIDEO", "https://www.youtube.com/watch?v=31k6AtW-b3Y");
        addQ(t, "Writing Dockerfiles", "EASY",
            "ARTICLE", "https://docs.docker.com/build/concepts/dockerfile/",
            "VIDEO", "https://www.youtube.com/watch?v=31k6AtW-b3Y");
        addQ(t, "Multi-container apps using Docker Compose", "EASY",
            "ARTICLE", "https://docs.docker.com/compose/",
            "VIDEO", "https://www.youtube.com/watch?v=DM65_JyGxCo");

        t = createTopic(s, "Cloud Deployments");
        addQ(t, "What is Cloud Computing..?", "EASY",
            "ARTICLE", "https://aws.amazon.com/what-is-cloud-computing/",
            "VIDEO", "https://www.youtube.com/watch?v=M988_fsOSWo");
        addQ(t, "Overview of Cloud Providers", "EASY",
            "ARTICLE", "https://aws.amazon.com/what-is-cloud-computing/",
            "VIDEO", "https://www.youtube.com/watch?v=M988_fsOSWo");
        addQ(t, "High Availability, Scalability, Fault Tolerance in Cloud", "EASY",
            "ARTICLE", "https://aws.amazon.com/what-is-cloud-computing/",
            "VIDEO", "https://www.youtube.com/watch?v=M988_fsOSWo");
        addQ(t, "Cost and Performance", "EASY",
            "ARTICLE", "https://aws.amazon.com/pricing/",
            "VIDEO", "https://www.youtube.com/watch?v=M988_fsOSWo");

        t = createTopic(s, "AWS - EC2");
        addQ(t, "What is Elastic Compute Cloud", "EASY",
            "ARTICLE", "https://docs.aws.amazon.com/ec2/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=a9__D53WsUs");
        addQ(t, "Setting up an EC2 instance", "EASY",
            "ARTICLE", "https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EC2_GetStarted.html",
            "VIDEO", "https://www.youtube.com/watch?v=a9__D53WsUs");
        addQ(t, "EC2 instance types, regions and availability zones", "EASY",
            "ARTICLE", "https://aws.amazon.com/ec2/instance-types/",
            "VIDEO", "https://www.youtube.com/watch?v=a9__D53WsUs");
        addQ(t, "Connecting using SSH", "EASY",
            "ARTICLE", "https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/connect-linux-inst-ssh.html",
            "VIDEO", "https://www.youtube.com/watch?v=a9__D53WsUs");
        addQ(t, "Setting up Security Credentials", "EASY",
            "ARTICLE", "https://docs.aws.amazon.com/IAM/latest/UserGuide/introduction.html",
            "VIDEO", "https://www.youtube.com/watch?v=a9__D53WsUs");

        t = createTopic(s, "Security Groups");
        addQ(t, "What is Security Groups..?", "EASY",
            "ARTICLE", "https://docs.aws.amazon.com/vpc/latest/userguide/vpc-security-groups.html",
            "VIDEO", "https://www.youtube.com/watch?v=0Gz-PUnEUF0");
        addQ(t, "Need for Security Groups", "EASY",
            "ARTICLE", "https://docs.aws.amazon.com/vpc/latest/userguide/vpc-security-groups.html",
            "VIDEO", "https://www.youtube.com/watch?v=0Gz-PUnEUF0");
        addQ(t, "Setting inbound and outbound rules", "EASY",
            "ARTICLE", "https://docs.aws.amazon.com/vpc/latest/userguide/security-group-rules.html",
            "VIDEO", "https://www.youtube.com/watch?v=0Gz-PUnEUF0");
        addQ(t, "Restricting access to your EC2 instance", "EASY",
            "ARTICLE", "https://docs.aws.amazon.com/vpc/latest/userguide/vpc-security-groups.html",
            "VIDEO", "https://www.youtube.com/watch?v=0Gz-PUnEUF0");
        addQ(t, "Best practices", "EASY",
            "ARTICLE", "https://docs.aws.amazon.com/vpc/latest/userguide/vpc-security-best-practices.html",
            "VIDEO", "https://www.youtube.com/watch?v=0Gz-PUnEUF0");

        t = createTopic(s, "Load Balancers");
        addQ(t, "What is Load Balancers..?", "EASY",
            "ARTICLE", "https://docs.aws.amazon.com/elasticloadbalancing/latest/userguide/what-is-load-balancing.html",
            "VIDEO", "https://www.youtube.com/watch?v=sCR3SAVdyCc");
        addQ(t, "Need for Load Balancers", "EASY",
            "ARTICLE", "https://docs.aws.amazon.com/elasticloadbalancing/latest/userguide/what-is-load-balancing.html",
            "VIDEO", "https://www.youtube.com/watch?v=sCR3SAVdyCc");
        addQ(t, "Elastic Load Balancer in AWS", "EASY",
            "ARTICLE", "https://docs.aws.amazon.com/elasticloadbalancing/",
            "VIDEO", "https://www.youtube.com/watch?v=sCR3SAVdyCc");
        addQ(t, "Configuring Application Load Balancer (ALB)", "EASY",
            "ARTICLE", "https://docs.aws.amazon.com/elasticloadbalancing/latest/application/introduction.html",
            "VIDEO", "https://www.youtube.com/watch?v=sCR3SAVdyCc");
        addQ(t, "Setting up health checks to monitor", "EASY",
            "ARTICLE", "https://docs.aws.amazon.com/elasticloadbalancing/latest/application/target-group-health-checks.html",
            "VIDEO", "https://www.youtube.com/watch?v=sCR3SAVdyCc");

        t = createTopic(s, "AWS Cloudfront");
        addQ(t, "Introduction to AWS Cloudfront", "EASY",
            "ARTICLE", "https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/Introduction.html",
            "VIDEO", "https://www.youtube.com/watch?v=AT-nHW3_SVI");
        addQ(t, "Need for performance optimization", "EASY",
            "ARTICLE", "https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/Introduction.html",
            "VIDEO", "https://www.youtube.com/watch?v=AT-nHW3_SVI");
        addQ(t, "Configuring Cloudfront distributions to serve static assets", "EASY",
            "ARTICLE", "https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/GettingStarted.html",
            "VIDEO", "https://www.youtube.com/watch?v=AT-nHW3_SVI");
        addQ(t, "Caching, Edge Locations, Fast Content Delivery", "EASY",
            "ARTICLE", "https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/HowCloudFrontWorks.html",
            "VIDEO", "https://www.youtube.com/watch?v=AT-nHW3_SVI");


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