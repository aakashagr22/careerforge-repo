import os
from pptx import Presentation
from pptx.util import Inches, Pt
from pptx.dml.color import RGBColor
from pptx.enum.text import PP_ALIGN, MSO_ANCHOR
from pptx.enum.shapes import MSO_SHAPE

def create_presentation():
    prs = Presentation()
    # 16:9 widescreen layout
    prs.slide_width = Inches(13.333)
    prs.slide_height = Inches(7.5)
    blank_slide_layout = prs.slide_layouts[6]

    # Theme Color Palette
    DARK_BG = RGBColor(15, 23, 42)        # Slate 900 #0F172A
    CARD_BG = RGBColor(30, 41, 59)        # Slate 800 #1E293B
    CARD_BORDER = RGBColor(51, 65, 85)    # Slate 700 #334155
    PRIMARY_BLUE = RGBColor(56, 189, 248) # Sky 400 #38BDF8
    INDIGO_ACCENT = RGBColor(129, 140, 248) # Indigo 400 #818CF8
    EMERALD_ACCENT = RGBColor(52, 211, 153) # Emerald 400 #34D399
    AMBER_ACCENT = RGBColor(251, 191, 36) # Amber 400 #FBBF24
    TEXT_WHITE = RGBColor(248, 250, 252)  # Slate 50 #F8FAFC
    TEXT_MUTED = RGBColor(148, 163, 184)  # Slate 400 #94A3B8
    TEXT_BODY = RGBColor(226, 232, 240)   # Slate 200 #E2E8F0

    def add_header(slide, title_text, category_text="CAREERFORGE — AKASH KUMAR'S MODULE CONTRIBUTIONS"):
        # Category / Subheader
        cat_box = slide.shapes.add_textbox(Inches(0.8), Inches(0.4), Inches(11.7), Inches(0.35))
        tf_cat = cat_box.text_frame
        tf_cat.word_wrap = True
        tf_cat.margin_left = tf_cat.margin_top = tf_cat.margin_right = tf_cat.margin_bottom = 0
        p_cat = tf_cat.paragraphs[0]
        p_cat.text = category_text.upper()
        p_cat.font.name = 'Calibri'
        p_cat.font.size = Pt(11)
        p_cat.font.bold = True
        p_cat.font.color.rgb = PRIMARY_BLUE

        # Main Title
        title_box = slide.shapes.add_textbox(Inches(0.8), Inches(0.75), Inches(11.7), Inches(0.65))
        tf_title = title_box.text_frame
        tf_title.word_wrap = True
        tf_title.margin_left = tf_title.margin_top = tf_title.margin_right = tf_title.margin_bottom = 0
        p_title = tf_title.paragraphs[0]
        p_title.text = title_text
        p_title.font.name = 'Calibri'
        p_title.font.size = Pt(24)
        p_title.font.bold = True
        p_title.font.color.rgb = TEXT_WHITE

    def add_card(slide, left, top, width, height, title=None, title_color=PRIMARY_BLUE, bg_color=CARD_BG, border_color=CARD_BORDER):
        shape = slide.shapes.add_shape(MSO_SHAPE.ROUNDED_RECTANGLE, left, top, width, height)
        shape.fill.solid()
        shape.fill.fore_color.rgb = bg_color
        if border_color:
            shape.line.color.rgb = border_color
            shape.line.width = Pt(1.5)
        else:
            shape.line.fill.background()

        if title:
            # Add title box inside card
            t_box = slide.shapes.add_textbox(left + Inches(0.25), top + Inches(0.2), width - Inches(0.5), Inches(0.45))
            tf = t_box.text_frame
            tf.word_wrap = True
            tf.margin_left = tf.margin_top = tf.margin_right = tf.margin_bottom = 0
            p = tf.paragraphs[0]
            p.text = title
            p.font.name = 'Calibri'
            p.font.size = Pt(16)
            p.font.bold = True
            p.font.color.rgb = title_color
        return shape

    def fill_background(slide):
        bg = slide.shapes.add_shape(MSO_SHAPE.RECTANGLE, 0, 0, Inches(13.333), Inches(7.5))
        bg.fill.solid()
        bg.fill.fore_color.rgb = DARK_BG
        bg.line.fill.background()
        return bg

    # ==========================================
    # SLIDE 1: Title Slide
    # ==========================================
    s1 = prs.slides.add_slide(blank_slide_layout)
    fill_background(s1)

    # Decorative hero card
    add_card(s1, Inches(1.2), Inches(1.2), Inches(10.933), Inches(5.1), bg_color=CARD_BG, border_color=INDIGO_ACCENT)

    # Project badge
    badge_box = s1.shapes.add_textbox(Inches(1.6), Inches(1.6), Inches(10.0), Inches(0.4))
    tf_b = badge_box.text_frame
    p_b = tf_b.paragraphs[0]
    p_b.text = "PLACEMENT PREPARATION & COLLABORATION PLATFORM"
    p_b.font.name = 'Calibri'
    p_b.font.size = Pt(13)
    p_b.font.bold = True
    p_b.font.color.rgb = PRIMARY_BLUE

    # Title
    t_box = s1.shapes.add_textbox(Inches(1.6), Inches(2.1), Inches(10.0), Inches(1.1))
    tf = t_box.text_frame
    p = tf.paragraphs[0]
    p.text = "CareerForge: Backend Architecture, Real-Time Chat,\nLearning Sheets & Security Engine"
    p.font.name = 'Calibri'
    p.font.size = Pt(28)
    p.font.bold = True
    p.font.color.rgb = TEXT_WHITE

    # Subtitle
    sub_box = s1.shapes.add_textbox(Inches(1.6), Inches(3.4), Inches(10.0), Inches(0.7))
    tf_sub = sub_box.text_frame
    p_sub = tf_sub.paragraphs[0]
    p_sub.text = "Comprehensive Technical Presentation on Individual Engineering Contributions"
    p_sub.font.name = 'Calibri'
    p_sub.font.size = Pt(15)
    p_sub.font.color.rgb = TEXT_MUTED

    # Author Card / Details Box
    dt_box = s1.shapes.add_textbox(Inches(1.6), Inches(4.3), Inches(10.0), Inches(1.6))
    tf_dt = dt_box.text_frame
    
    p1 = tf_dt.paragraphs[0]
    p1.text = "Presented by: Akash Kumar"
    p1.font.name = 'Calibri'
    p1.font.size = Pt(18)
    p1.font.bold = True
    p1.font.color.rgb = EMERALD_ACCENT

    p2 = tf_dt.add_paragraph()
    p2.text = "Core Responsibilities: Complete REST API Backend | Spring Security 6 & JWT Auth | Discord-like WebSocket Chat | Learning Sheets Module"
    p2.font.name = 'Calibri'
    p2.font.size = Pt(13)
    p2.font.color.rgb = TEXT_BODY

    p3 = tf_dt.add_paragraph()
    p3.text = "Tech Stack: Java 21, Spring Boot 3, Spring Security, WebSocket/STOMP, PostgreSQL, Flyway, Docker, Render"
    p3.font.name = 'Calibri'
    p3.font.size = Pt(12)
    p3.font.color.rgb = TEXT_MUTED

    # ==========================================
    # SLIDE 2: Executive Summary & Individual Scope
    # ==========================================
    s2 = prs.slides.add_slide(blank_slide_layout)
    fill_background(s2)
    add_header(s2, "Executive Summary: Akash Kumar's Engineering Responsibilities")

    # 4 Cards for 4 pillars
    col_w = Inches(2.78)
    h = Inches(5.2)
    top_pos = Inches(1.6)

    # Card 1: REST API
    add_card(s2, Inches(0.8), top_pos, col_w, h, "1. Complete REST API", PRIMARY_BLUE)
    box = s2.shapes.add_textbox(Inches(0.95), top_pos + Inches(0.8), col_w - Inches(0.3), h - Inches(1.0))
    tf = box.text_frame
    tf.word_wrap = True
    bullets = [
        "Architected complete backend with Java 21 & Spring Boot 3.",
        "Engineered 45+ robust RESTful endpoints covering Auth, Users, Sheets, Chat, Resources & Admin.",
        "Implemented clean layered architecture (Controller, Service, Repository, DTO, Mappers).",
        "Configured Global Exception Handling with custom error responses & OpenAPI docs."
    ]
    for i, b in enumerate(bullets):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = "• " + b
        p.font.name = 'Calibri'
        p.font.size = Pt(12)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(10)

    # Card 2: Security
    add_card(s2, Inches(3.78), top_pos, col_w, h, "2. Security & Auth", INDIGO_ACCENT)
    box = s2.shapes.add_textbox(Inches(3.93), top_pos + Inches(0.8), col_w - Inches(0.3), h - Inches(1.0))
    tf = box.text_frame
    tf.word_wrap = True
    bullets = [
        "Implemented Spring Security 6 stateless filter chain.",
        "Built Dual-Token JWT flow (24h Access + 7d Refresh token).",
        "Role-Based Access Control (RBAC) separating STUDENT and ADMIN operations.",
        "Engineered non-blocking 6-digit email OTP verification with automated fallback."
    ]
    for i, b in enumerate(bullets):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = "• " + b
        p.font.name = 'Calibri'
        p.font.size = Pt(12)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(10)

    # Card 3: Sheets
    add_card(s2, Inches(6.76), top_pos, col_w, h, "3. Learning Sheets", EMERALD_ACCENT)
    box = s2.shapes.add_textbox(Inches(6.91), top_pos + Inches(0.8), col_w - Inches(0.3), h - Inches(1.0))
    tf = box.text_frame
    tf.word_wrap = True
    bullets = [
        "Built multi-domain curated sheets: DSA, Web Dev, AI/ML & System Design.",
        "Hierarchical topic-to-question data structure with difficulty tags & links.",
        "Optimized filtering by topic, company tags, and practice status.",
        "Created student progress tracking APIs with database persistence."
    ]
    for i, b in enumerate(bullets):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = "• " + b
        p.font.name = 'Calibri'
        p.font.size = Pt(12)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(10)

    # Card 4: Chat
    add_card(s2, Inches(9.74), top_pos, col_w, h, "4. Real-Time Chat", AMBER_ACCENT)
    box = s2.shapes.add_textbox(Inches(9.89), top_pos + Inches(0.8), col_w - Inches(0.3), h - Inches(1.0))
    tf = box.text_frame
    tf.word_wrap = True
    bullets = [
        "Discord-like real-time messaging using WebSocket & STOMP protocol.",
        "Year-wise communication channels (1st, 2nd, 3rd, 4th yr & General).",
        "Low-latency (<50ms) message broadcasting via in-memory broker.",
        "PostgreSQL chat persistence with paginated message history APIs."
    ]
    for i, b in enumerate(bullets):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = "• " + b
        p.font.name = 'Calibri'
        p.font.size = Pt(12)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(10)

    # ==========================================
    # SLIDE 3: System Architecture & Technology Stack
    # ==========================================
    s3 = prs.slides.add_slide(blank_slide_layout)
    fill_background(s3)
    add_header(s3, "Full System Architecture & Backend Technology Stack")

    # Left: Architecture Flow Card
    add_card(s3, Inches(0.8), Inches(1.6), Inches(5.7), Inches(5.2), "Layered Backend Architecture", PRIMARY_BLUE)
    box = s3.shapes.add_textbox(Inches(1.05), Inches(2.35), Inches(5.2), Inches(4.2))
    tf = box.text_frame
    tf.word_wrap = True
    arch_items = [
        ("Client Layer", "React 18 + Vite SPA, Axios API Client, SockJS/STOMP WebSocket Client"),
        ("Security Interception", "Spring Security 6, JwtAuthenticationFilter, CORS Filter"),
        ("Controller Layer", "REST Controllers handling HTTP requests, DTO validation (@Valid)"),
        ("Service Layer", "Transactional business logic (@Service, @Transactional), Event Publishers"),
        ("Persistence Layer", "Spring Data JPA, Hibernate ORM, Repositories with custom queries"),
        ("Database & Broker", "PostgreSQL (Neon Cloud) + In-memory STOMP Message Broker")
    ]
    for i, (title, desc) in enumerate(arch_items):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = f"▶ {title}: {desc}"
        p.font.name = 'Calibri'
        p.font.size = Pt(12.5)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(8)

    # Right: Technology Stack Details
    add_card(s3, Inches(6.8), Inches(1.6), Inches(5.7), Inches(5.2), "Backend Technology Selection", INDIGO_ACCENT)
    box = s3.shapes.add_textbox(Inches(7.05), Inches(2.35), Inches(5.2), Inches(4.2))
    tf = box.text_frame
    tf.word_wrap = True
    tech_items = [
        ("Java 21 LTS", "Modern language features: records, pattern matching, virtual threads readiness"),
        ("Spring Boot 3.3", "High-performance framework for microservices, DI, and auto-configuration"),
        ("Spring Security 6", "Stateless authentication, BCrypt hashing, fine-grained method security"),
        ("Spring WebSocket", "STOMP protocol over WebSocket with SockJS fallback support"),
        ("PostgreSQL & Flyway", "Serverless cloud DB on Neon, versioned schema migrations without downtime"),
        ("OpenAPI / Swagger 3", "Self-documenting API contracts with interactive testing UI"),
        ("Docker & Render", "Containerized deployment with zero downtime and multi-stage builds")
    ]
    for i, (tech, desc) in enumerate(tech_items):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = f"✔ {tech}: {desc}"
        p.font.name = 'Calibri'
        p.font.size = Pt(12.5)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(7)

    # ==========================================
    # SLIDE 4: Complete REST API Architecture
    # ==========================================
    s4 = prs.slides.add_slide(blank_slide_layout)
    fill_background(s4)
    add_header(s4, "Core Responsibility 1: Complete REST API Backend Architecture")

    # 3 Horizontal-ish split cards
    add_card(s4, Inches(0.8), Inches(1.6), Inches(3.7), Inches(5.2), "Modular API Design", PRIMARY_BLUE)
    box = s4.shapes.add_textbox(Inches(1.0), Inches(2.35), Inches(3.3), Inches(4.2))
    tf = box.text_frame
    tf.word_wrap = True
    modules = [
        "Auth Module: Register, Login, Token Refresh, OTP Verify & Resend, Password Reset.",
        "User Module: Student profiles, streak tracking, college details, target role preferences.",
        "Learning Sheets: Practice sheets, question categorization, completion states.",
        "Resources Module: Curated study material links, categories, ratings & admin reviews.",
        "Chat Module: Channel directory, persistent message history, channel memberships."
    ]
    for i, m in enumerate(modules):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = "• " + m
        p.font.name = 'Calibri'
        p.font.size = Pt(12)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(8)

    add_card(s4, Inches(4.8), Inches(1.6), Inches(3.7), Inches(5.2), "Clean Code & Layering", INDIGO_ACCENT)
    box = s4.shapes.add_textbox(Inches(5.0), Inches(2.35), Inches(3.3), Inches(4.2))
    tf = box.text_frame
    tf.word_wrap = True
    patterns = [
        "DTO Pattern: Strict separation between database entities and HTTP request/response payloads.",
        "Bean Validation: Applied @Valid, @NotBlank, @Email, and @Size annotations across all inputs.",
        "MapStruct / Mappers: Clean conversion between entity models and client-facing DTOs.",
        "Decoupled Services: Interface-driven service design (e.g., AuthService, SheetService, ChatService).",
        "Transaction Boundaries: Managed with @Transactional(readOnly = true) for optimized query execution."
    ]
    for i, m in enumerate(patterns):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = "• " + m
        p.font.name = 'Calibri'
        p.font.size = Pt(12)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(8)

    add_card(s4, Inches(8.8), Inches(1.6), Inches(3.7), Inches(5.2), "Error & Async Handling", EMERALD_ACCENT)
    box = s4.shapes.add_textbox(Inches(9.0), Inches(2.35), Inches(3.3), Inches(4.2))
    tf = box.text_frame
    tf.word_wrap = True
    resilience = [
        "Global Exception Handler: @RestControllerAdvice intercepts all exceptions with standardized ApiResponse JSON.",
        "Client Disconnect Resilience: Specifically catches Broken Pipe / Connection Reset exceptions gracefully.",
        "Validation Error Reporting: Returns field-level errors to the client for immediate user feedback.",
        "CORS Security Configuration: Configured allowed origins, headers, and credentials for production deployment.",
        "Pagination & Sorting: Implemented Spring Data Pageable across all list endpoints."
    ]
    for i, m in enumerate(resilience):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = "• " + m
        p.font.name = 'Calibri'
        p.font.size = Pt(12)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(8)

    # ==========================================
    # SLIDE 5: Security & Authentication Engine
    # ==========================================
    s5 = prs.slides.add_slide(blank_slide_layout)
    fill_background(s5)
    add_header(s5, "Core Responsibility 2: Robust Security & Dual-Token JWT Architecture")

    # Left: Security Workflow
    add_card(s5, Inches(0.8), Inches(1.6), Inches(5.7), Inches(5.2), "Spring Security 6 Architecture", INDIGO_ACCENT)
    box = s5.shapes.add_textbox(Inches(1.05), Inches(2.35), Inches(5.2), Inches(4.2))
    tf = box.text_frame
    tf.word_wrap = True
    sec_points = [
        ("Stateless Security Filter Chain", "Zero HTTP session storage; every request is authenticated independently using JWT headers."),
        ("Custom JwtAuthenticationFilter", "Extracts Bearer token, validates HMAC-SHA256 signature, parses claims, and establishes Spring SecurityContext."),
        ("Dual Token Mechanism", "Access Token (24 hours) for fast authorized API calls + Refresh Token (7 days) for secure silent renewal."),
        ("Password Encryption", "BCryptPasswordEncoder with salt generation protects passwords against brute force and rainbow table attacks."),
        ("Strict Endpoint Security", "/auth/** and /v3/api-docs/** are publicly accessible; all resource, sheet, and chat APIs require authenticated JWT.")
    ]
    for i, (title, desc) in enumerate(sec_points):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = f"🔒 {title}: {desc}"
        p.font.name = 'Calibri'
        p.font.size = Pt(12)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(7)

    # Right: Role-Based Access Control (RBAC)
    add_card(s5, Inches(6.8), Inches(1.6), Inches(5.7), Inches(5.2), "Role-Based Access Control (RBAC)", PRIMARY_BLUE)
    box = s5.shapes.add_textbox(Inches(7.05), Inches(2.35), Inches(5.2), Inches(4.2))
    tf = box.text_frame
    tf.word_wrap = True
    rbac_points = [
        ("Student Role (ROLE_STUDENT)", "Access curated sheets, submit question progress, join year channels, ask Q&A questions, participate in contests."),
        ("Admin Role (ROLE_ADMIN)", "Privileged access to create/update sheets, delete inappropriate chat messages, post broadcasts, manage resources."),
        ("Method-Level Authorization", "@PreAuthorize('hasRole(\"ADMIN\")') guarantees that privilege escalation cannot occur via URL spoofing."),
        ("Token Validation Pipeline", "TokenProvider verifies token expiration, malformed structures, signature tampering, and unsupported claims."),
        ("User Principal Mapping", "Maps database User entity directly to Spring Security UserPrincipal for clean controller-level @AuthenticationPrincipal injection.")
    ]
    for i, (title, desc) in enumerate(rbac_points):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = f"🛡 {title}: {desc}"
        p.font.name = 'Calibri'
        p.font.size = Pt(12)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(7)

    # ==========================================
    # SLIDE 6: Multi-Factor OTP Verification Engine
    # ==========================================
    s6 = prs.slides.add_slide(blank_slide_layout)
    fill_background(s6)
    add_header(s6, "Security Deep-Dive: Asynchronous OTP Verification & Cloud Resilience")

    # Top: Problem & Cloud Constraint
    add_card(s6, Inches(0.8), Inches(1.6), Inches(11.733), Inches(1.8), "The Cloud Egress Challenge & Architectural Problem", AMBER_ACCENT)
    box = s6.shapes.add_textbox(Inches(1.05), Inches(2.2), Inches(11.2), Inches(1.05))
    tf = box.text_frame
    tf.word_wrap = True
    p = tf.paragraphs[0]
    p.text = "• Traditional Problem: Synchronous SMTP email sending blocked HTTP request threads for 3+ minutes when connecting to external mail servers (Gmail:587) due to cloud egress firewall restrictions on free-tier platforms (e.g. Render blocks ports 25, 465, 587).\n• Impact: Client browsers disconnected with 'Broken pipe' and 'Connection reset by peer' errors, preventing student signups."
    p.font.name = 'Calibri'
    p.font.size = Pt(12.5)
    p.font.color.rgb = TEXT_BODY

    # Bottom Left: Asynchronous Implementation
    add_card(s6, Inches(0.8), Inches(3.6), Inches(5.7), Inches(3.2), "Non-Blocking Asynchronous Dispatch", PRIMARY_BLUE)
    box = s6.shapes.add_textbox(Inches(1.05), Inches(4.2), Inches(5.2), Inches(2.4))
    tf = box.text_frame
    tf.word_wrap = True
    async_bullets = [
        "Decoupled email dispatch from HTTP registration thread via CompletableFuture.runAsync().",
        "Immediate HTTP Response: /auth/register responds in <1.2 seconds instead of timing out at 3 minutes.",
        "Zero Thread Exhaustion: Tomcat worker threads are immediately freed to handle concurrent student requests.",
        "Robust Error Boundary: SMTP connection failures are logged without crashing the registration process."
    ]
    for i, b in enumerate(async_bullets):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = "✔ " + b
        p.font.name = 'Calibri'
        p.font.size = Pt(11.5)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(4)

    # Bottom Right: Resilient Verification Engine
    add_card(s6, Inches(6.8), Inches(3.6), Inches(5.7), Inches(3.2), "Smart Fallback & Instant Verification", EMERALD_ACCENT)
    box = s6.shapes.add_textbox(Inches(7.05), Inches(4.2), Inches(5.2), Inches(2.4))
    tf = box.text_frame
    tf.word_wrap = True
    verif_bullets = [
        "Cryptographic 6-Digit Code: Generated via SecureRandom and saved in PostgreSQL with a 10-minute TTL.",
        "Auto-Detected Preview OTP: Returns previewOtp in demo environments, enabling instant 1-click verification.",
        "Rate Limiting Protection: Enforces 60-second cooldown on /auth/resend-otp to prevent spam and abuse.",
        "Instant Account Activation: /auth/verify-otp marks emailVerified=true and returns JWT credentials immediately."
    ]
    for i, b in enumerate(verif_bullets):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = "✔ " + b
        p.font.name = 'Calibri'
        p.font.size = Pt(11.5)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(4)

    # ==========================================
    # SLIDE 7: Learning Sheets Module Architecture
    # ==========================================
    s7 = prs.slides.add_slide(blank_slide_layout)
    fill_background(s7)
    add_header(s7, "Core Responsibility 3: Structured Learning Sheets Module")

    # Left: Concept & 4 Sheets
    add_card(s7, Inches(0.8), Inches(1.6), Inches(5.7), Inches(5.2), "Structured Placement Preparation Sheets", PRIMARY_BLUE)
    box = s7.shapes.add_textbox(Inches(1.05), Inches(2.35), Inches(5.2), Inches(4.2))
    tf = box.text_frame
    tf.word_wrap = True
    sheets_info = [
        ("Data Structures & Algorithms (DSA) Sheet", "Comprehensive problem set covering Arrays, Trees, Dynamic Programming, Graphs, and Backtracking (Striver/Love Babbar aligned)."),
        ("Web Development Sheet", "Frontend (React, DOM, State) and Backend (REST APIs, Microservices, Node/Java, SQL) placement challenges."),
        ("AI / Machine Learning Sheet", "Core ML algorithms, Data Preprocessing, Deep Learning fundamentals, and applied model building exercises."),
        ("System Design Sheet", "High-Level Architecture, Low-Level Design (LLD), Scalability patterns, Caching, Sharding, and Load Balancing.")
    ]
    for i, (title, desc) in enumerate(sheets_info):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = f"📚 {title}\n   {desc}"
        p.font.name = 'Calibri'
        p.font.size = Pt(12)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(8)

    # Right: Technical Schema & Organization
    add_card(s7, Inches(6.8), Inches(1.6), Inches(5.7), Inches(5.2), "Hierarchical Data Hierarchy & API Design", INDIGO_ACCENT)
    box = s7.shapes.add_textbox(Inches(7.05), Inches(2.35), Inches(5.2), Inches(4.2))
    tf = box.text_frame
    tf.word_wrap = True
    hier_info = [
        ("3-Tier Hierarchical Structure", "Sheet ➔ Topics (e.g. Binary Search) ➔ Questions (e.g. Search in Rotated Sorted Array)."),
        ("Multi-Dimensional Attributes", "Every question includes: Title, Difficulty (EASY, MEDIUM, HARD), Platform (LeetCode, GFG, HackerRank), Article URL, Video URL."),
        ("Student Progress Persistence", "student_question_status table tracks question completion, bookmarking, and personal notes for each student."),
        ("Dynamic Filtering Engine", "Single API endpoint allows students to filter by completion status, difficulty tier, topic, and keyword search."),
        ("Admin Management APIs", "Full CRUD capabilities for administrators to dynamically introduce new placement questions and update links.")
    ]
    for i, (title, desc) in enumerate(hier_info):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = f"⚡ {title}:\n   {desc}"
        p.font.name = 'Calibri'
        p.font.size = Pt(12)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(7)

    # ==========================================
    # SLIDE 8: Learning Sheets Data Model & APIs
    # ==========================================
    s8 = prs.slides.add_slide(blank_slide_layout)
    fill_background(s8)
    add_header(s8, "Learning Sheets: Relational Schema & REST Endpoints")

    # Left: Database Relational Entities
    add_card(s8, Inches(0.8), Inches(1.6), Inches(5.7), Inches(5.2), "PostgreSQL Database Schema", EMERALD_ACCENT)
    box = s8.shapes.add_textbox(Inches(1.05), Inches(2.35), Inches(5.2), Inches(4.2))
    tf = box.text_frame
    tf.word_wrap = True
    entities = [
        ("sheets", "id (UUID), title, slug, description, category (DSA/WEB/AI/SYSTEM_DESIGN), total_questions, is_active, created_at"),
        ("sheet_topics", "id, sheet_id (FK), title, display_order, description"),
        ("sheet_questions", "id, topic_id (FK), title, problem_url, article_url, video_url, difficulty (ENUM), company_tags, display_order"),
        ("student_question_progress", "id, user_id (FK), question_id (FK), is_completed, is_bookmarked, notes, completed_at"),
        ("Foreign Key Constraints & Indexes", "Composite index on (user_id, question_id) and index on topic_id ensure sub-10ms query execution across 500+ questions.")
    ]
    for i, (tbl, desc) in enumerate(entities):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = f"🗄 {tbl}:\n   {desc}"
        p.font.name = 'Calibri'
        p.font.size = Pt(11.5)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(6)

    # Right: Core Sheet REST Endpoints
    add_card(s8, Inches(6.8), Inches(1.6), Inches(5.7), Inches(5.2), "Key RESTful API Endpoints", PRIMARY_BLUE)
    box = s8.shapes.add_textbox(Inches(7.05), Inches(2.35), Inches(5.2), Inches(4.2))
    tf = box.text_frame
    tf.word_wrap = True
    endpoints = [
        ("GET /api/sheets", "Retrieves all available practice sheets with aggregate question counts and student completion metrics."),
        ("GET /api/sheets/{slug}", "Fetches a full hierarchical sheet tree including all topics, questions, and current student progress status."),
        ("POST /api/sheets/{slug}/questions/{qId}/toggle", "Toggles question completion state (solved/unsolved) and updates student streak."),
        ("POST /api/sheets/{slug}/questions/{qId}/bookmark", "Bookmarks high-priority interview questions for quick revision prior to interviews."),
        ("POST /api/admin/sheets & PUT /api/admin/questions", "Admin-only endpoints to curate, adjust, and maintain sheet contents without redeploying code.")
    ]
    for i, (ep, desc) in enumerate(endpoints):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = f"🌐 {ep}:\n   {desc}"
        p.font.name = 'Calibri'
        p.font.size = Pt(11.5)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(6)

    # ==========================================
    # SLIDE 9: Real-Time Chat System Architecture
    # ==========================================
    s9 = prs.slides.add_slide(blank_slide_layout)
    fill_background(s9)
    add_header(s9, "Core Responsibility 4: Discord-Like Real-Time Chat System")

    # Left: Protocol & WebSocket Flow
    add_card(s9, Inches(0.8), Inches(1.6), Inches(5.7), Inches(5.2), "WebSocket & STOMP Architecture", AMBER_ACCENT)
    box = s9.shapes.add_textbox(Inches(1.05), Inches(2.35), Inches(5.2), Inches(4.2))
    tf = box.text_frame
    tf.word_wrap = True
    chat_arch = [
        ("Full-Duplex Communication", "Eliminated HTTP polling overhead with persistent bi-directional WebSocket TCP connections."),
        ("STOMP Protocol over WebSocket", "Structured sub-protocol providing standard frame formats: CONNECT, SUBSCRIBE, SEND, and MESSAGE."),
        ("In-Memory Message Broker", "Routes broadcast messages to /topic/channel.{channelId} and private notifications to /queue/user.{userId}."),
        ("SockJS Fallback Engine", "Ensures seamless communication even when strict university firewalls or proxies disallow raw WebSockets."),
        ("Authentication over STOMP", "Injected JWT verification during the STOMP CONNECT handshake, securing every socket session.")
    ]
    for i, (title, desc) in enumerate(chat_arch):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = f"💬 {title}:\n   {desc}"
        p.font.name = 'Calibri'
        p.font.size = Pt(12)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(7)

    # Right: Channel Segmentation
    add_card(s9, Inches(6.8), Inches(1.6), Inches(5.7), Inches(5.2), "Discord-Style Channel Ecosystem", PRIMARY_BLUE)
    box = s9.shapes.add_textbox(Inches(7.05), Inches(2.35), Inches(5.2), Inches(4.2))
    tf = box.text_frame
    tf.word_wrap = True
    channels = [
        ("1st Year Channel", "Focused on fundamental programming, college orientation, and foundational language doubts."),
        ("2nd Year Channel", "Discussions centered on Core DSA, OOP concepts, DBMS, and competitive coding kickstart."),
        ("3rd Year Channel", "Internship preparation, hackathons, full-stack project reviews, and resume polishing."),
        ("4th Year Channel", "Live placement drives, on-campus interview experiences, company-specific test discussions."),
        ("General & Senior Rooms", "Cross-batch mentorship channel enabling graduating seniors to share referrals and interview insights.")
    ]
    for i, (ch, desc) in enumerate(channels):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = f"🚀 {ch}:\n   {desc}"
        p.font.name = 'Calibri'
        p.font.size = Pt(12)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(7)

    # ==========================================
    # SLIDE 10: Chat Persistence & Performance
    # ==========================================
    s10 = prs.slides.add_slide(blank_slide_layout)
    fill_background(s10)
    add_header(s10, "Chat Persistence, Latency & Reliability Engineering")

    # 3 Split Cards
    add_card(s10, Inches(0.8), Inches(1.6), Inches(3.7), Inches(5.2), "Message Lifecycle", PRIMARY_BLUE)
    box = s10.shapes.add_textbox(Inches(1.0), Inches(2.35), Inches(3.3), Inches(4.2))
    tf = box.text_frame
    tf.word_wrap = True
    lifecycle = [
        "1. Client Dispatches: Student types message; STOMP client publishes to /app/chat.send.",
        "2. Interceptor Validation: Server verifies sender JWT token and active channel membership.",
        "3. Database Save: Spring Data JPA saves chat record into PostgreSQL with UTC timestamp.",
        "4. Real-Time Broadcast: Broker instantly fans out payload to all subscribed clients on /topic/channel.{id}.",
        "5. UI Render: Subscribed peers receive JSON and update message lists in <50ms."
    ]
    for i, m in enumerate(lifecycle):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = m
        p.font.name = 'Calibri'
        p.font.size = Pt(12)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(7)

    add_card(s10, Inches(4.8), Inches(1.6), Inches(3.7), Inches(5.2), "History & Pagination", INDIGO_ACCENT)
    box = s10.shapes.add_textbox(Inches(5.0), Inches(2.35), Inches(3.3), Inches(4.2))
    tf = box.text_frame
    tf.word_wrap = True
    history = [
        "REST History Endpoint: GET /api/chat/channels/{id}/messages provides instant historical context.",
        "Cursor & Pageable: Supports paginated message loading (e.g. 50 messages per batch) to minimize memory overhead.",
        "Rich User Metadata: Messages include sender name, avatar URL, graduation year, and role badge (STUDENT / ADMIN).",
        "Sender Verification: Students can only delete their own messages; admins hold platform-wide moderation rights.",
        "Unread Indicators: Tracks channel read-receipts to display unread message badges on student dashboards."
    ]
    for i, m in enumerate(history):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = "• " + m
        p.font.name = 'Calibri'
        p.font.size = Pt(12)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(7)

    add_card(s10, Inches(8.8), Inches(1.6), Inches(3.7), Inches(5.2), "Scalability & Resilience", EMERALD_ACCENT)
    box = s10.shapes.add_textbox(Inches(9.0), Inches(2.35), Inches(3.3), Inches(4.2))
    tf = box.text_frame
    tf.word_wrap = True
    scale = [
        "Sub-50ms Message Latency: Optimized broker thread pool handles high concurrency across all college batches.",
        "Graceful Disconnects: Configured heartbeats (10s incoming / 10s outgoing) to detect dead socket connections.",
        "Reconnection Handler: Frontend automatically attempts exponential backoff reconnection on network drops.",
        "Clean Resource Cleanup: Channel session listeners automatically release inactive subscriptions.",
        "XSS Protection: All message content sanitized and escaped prior to broadcasting to avoid script injection."
    ]
    for i, m in enumerate(scale):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = "• " + m
        p.font.name = 'Calibri'
        p.font.size = Pt(12)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(7)

    # ==========================================
    # SLIDE 11: Database & Cloud Infrastructure
    # ==========================================
    s11 = prs.slides.add_slide(blank_slide_layout)
    fill_background(s11)
    add_header(s11, "Database Architecture, Migrations & Cloud Resilience")

    # Left: Database Design & Flyway
    add_card(s11, Inches(0.8), Inches(1.6), Inches(5.7), Inches(5.2), "Database Design & Versioned Migrations", PRIMARY_BLUE)
    box = s11.shapes.add_textbox(Inches(1.05), Inches(2.35), Inches(5.2), Inches(4.2))
    tf = box.text_frame
    tf.word_wrap = True
    db_points = [
        ("Serverless PostgreSQL (Neon Cloud)", "Multi-zone cloud-hosted relational DB with SSL encryption, automated backups, and autoscaling."),
        ("Flyway Database Migrations", "Strict version-controlled schema evolution (V1__init.sql, V2__sheets.sql, etc.) ensuring identical schema across dev, staging, and production."),
        ("HikariCP Pool Configuration", "Tuned pool size (max 10, min 2) with idle-timeout (5m), max-lifetime (10m), and connection-timeout (30s)."),
        ("Serverless Keepalive Engine", "Custom 60-second keepalive ping prevents cloud database endpoints from entering cold-sleep during user inactivity."),
        ("ACID Transaction Management", "@Transactional boundaries protect complex multi-table operations (e.g. user creation + profile init + notification trigger).")
    ]
    for i, (title, desc) in enumerate(db_points):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = f"⚙ {title}:\n   {desc}"
        p.font.name = 'Calibri'
        p.font.size = Pt(12)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(7)

    # Right: Containerization & Cloud Deployment
    add_card(s11, Inches(6.8), Inches(1.6), Inches(5.7), Inches(5.2), "Containerization & Cloud Production Deployment", INDIGO_ACCENT)
    box = s11.shapes.add_textbox(Inches(7.05), Inches(2.35), Inches(5.2), Inches(4.2))
    tf = box.text_frame
    tf.word_wrap = True
    ops_points = [
        ("Multi-Stage Dockerfile", "Optimized Maven build stage followed by lightweight Eclipse Temurin Java 21 JRE runtime image, minimizing container footprint."),
        ("Production Host on Render", "Cloud container deployment with automatic Git CI/CD triggers upon pushing to origin/master."),
        ("OpenAPI / Swagger Documentation", "Live interactive API documentation hosted at /swagger-ui.html for seamless frontend integration and evaluator testing."),
        ("Healthcheck & Actuator", "Dedicated health monitoring path (/v3/api-docs) for cloud load balancer liveness probes."),
        ("Environment Configuration", "Strict separation of secrets via environment variables: DB credentials, JWT secret keys, and mail configurations.")
    ]
    for i, (title, desc) in enumerate(ops_points):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = f"🚀 {title}:\n   {desc}"
        p.font.name = 'Calibri'
        p.font.size = Pt(12)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(7)

    # ==========================================
    # SLIDE 12: Individual Summary of Deliverables
    # ==========================================
    s12 = prs.slides.add_slide(blank_slide_layout)
    fill_background(s12)
    add_header(s12, "Summary of Deliverables by Akash Kumar")

    # Table of Deliverables
    rows = 6
    cols = 4
    left = Inches(0.8)
    top = Inches(1.6)
    width = Inches(11.733)
    height = Inches(5.2)

    table_shape = s12.shapes.add_table(rows, cols, left, top, width, height)
    table = table_shape.table

    # Column widths
    table.columns[0].width = Inches(2.5) # Module
    table.columns[1].width = Inches(3.2) # Responsibility
    table.columns[2].width = Inches(3.4) # Technologies Implemented
    table.columns[3].width = Inches(2.633) # Impact / Result

    headers = ["Module", "Akash Kumar's Responsibility", "Technologies & Design Patterns", "Deliverables & Impact"]
    for j, h_text in enumerate(headers):
        cell = table.cell(0, j)
        cell.text = h_text
        cell.fill.solid()
        cell.fill.fore_color.rgb = CARD_BG
        for p in cell.text_frame.paragraphs:
            p.font.name = 'Calibri'
            p.font.size = Pt(13)
            p.font.bold = True
            p.font.color.rgb = PRIMARY_BLUE

    data = [
        ("REST API Backend", "Designed & built complete backend service layer, DTOs, controllers, and error handlers.", "Java 21, Spring Boot 3, REST, MapStruct, GlobalExceptionHandler", "45+ production endpoints; sub-100ms response time; clean architecture."),
        ("Security & Auth", "Architected end-to-end authentication, JWT token lifecycle, and role permissions.", "Spring Security 6, JJWT (24h/7d), BCrypt, RBAC (STUDENT/ADMIN)", "Zero-vulnerability stateless auth; protected student & admin endpoints."),
        ("Email OTP Engine", "Engineered OTP verification for signup & password reset with non-blocking resilience.", "CompletableFuture, JavaMailSender, SecureRandom, PostgreSQL TTL", "Solved cloud SMTP port blocking; reduced signup wait from 3m to 1.2s."),
        ("Learning Sheets", "Curated 4 placement sheets (DSA, Web, AI, SysDesign) with topic-question trees.", "Spring Data JPA, PostgreSQL, Hierarchical Relational Schema", "Structured placement path; bookmarking & topic completion tracking."),
        ("Real-Time Chat", "Engineered Discord-like multi-channel messaging system with history persistence.", "Spring WebSocket, STOMP, SockJS, In-memory Broker, PostgreSQL", "Full-duplex real-time chat (<50ms); 1st-4th year & general batch channels.")
    ]

    for i, row in enumerate(data):
        for j, val in enumerate(row):
            cell = table.cell(i + 1, j)
            cell.text = val
            cell.fill.solid()
            cell.fill.fore_color.rgb = DARK_BG
            for p in cell.text_frame.paragraphs:
                p.font.name = 'Calibri'
                p.font.size = Pt(11)
                p.font.color.rgb = TEXT_BODY

    # ==========================================
    # SLIDE 13: Technical Challenges & Key Learnings
    # ==========================================
    s13 = prs.slides.add_slide(blank_slide_layout)
    fill_background(s13)
    add_header(s13, "Key Engineering Challenges Overcome & Technical Learnings")

    # 3 Cards
    add_card(s13, Inches(0.8), Inches(1.6), Inches(3.7), Inches(5.2), "1. Cloud SMTP Port Egress", AMBER_ACCENT)
    box = s13.shapes.add_textbox(Inches(1.0), Inches(2.35), Inches(3.3), Inches(4.2))
    tf = box.text_frame
    tf.word_wrap = True
    c1 = [
        "Challenge: Render free tier blocks outbound SMTP ports (25, 465, 587), causing synchronous email attempts to hang for 3 minutes before timing out.",
        "Solution: Wrapped dispatch in CompletableFuture.runAsync() and introduced automatic previewOtp response fallback.",
        "Learning: Never perform third-party network I/O synchronously on critical user onboarding HTTP threads."
    ]
    for i, m in enumerate(c1):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = m
        p.font.name = 'Calibri'
        p.font.size = Pt(12)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(10)

    add_card(s13, Inches(4.8), Inches(1.6), Inches(3.7), Inches(5.2), "2. WebSocket Handshake Security", INDIGO_ACCENT)
    box = s13.shapes.add_textbox(Inches(5.0), Inches(2.35), Inches(3.3), Inches(4.2))
    tf = box.text_frame
    tf.word_wrap = True
    c2 = [
        "Challenge: Standard HTTP Authorization headers are not natively supported by browser WebSocket API constructors.",
        "Solution: Implemented custom STOMP ChannelInterceptor extracting Bearer tokens from STOMP CONNECT frame headers.",
        "Learning: Designing custom security interceptors to bridge protocol differences between HTTP and WebSocket frames."
    ]
    for i, m in enumerate(c2):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = m
        p.font.name = 'Calibri'
        p.font.size = Pt(12)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(10)

    add_card(s13, Inches(8.8), Inches(1.6), Inches(3.7), Inches(5.2), "3. Serverless DB Cold Connections", PRIMARY_BLUE)
    box = s13.shapes.add_textbox(Inches(9.0), Inches(2.35), Inches(3.3), Inches(4.2))
    tf = box.text_frame
    tf.word_wrap = True
    c3 = [
        "Challenge: Neon PostgreSQL serverless compute endpoints sleep after periods of inactivity, causing initial query timeouts.",
        "Solution: Configured HikariCP keepalive pings (60s) and tuned minimum-idle connection pools to keep connections warm.",
        "Learning: Proactive connection pooling strategies for cloud-native serverless relational databases."
    ]
    for i, m in enumerate(c3):
        p = tf.paragraphs[0] if i == 0 else tf.add_paragraph()
        p.text = m
        p.font.name = 'Calibri'
        p.font.size = Pt(12)
        p.font.color.rgb = TEXT_BODY
        p.space_after = Pt(10)

    # ==========================================
    # SLIDE 14: Conclusion & Q&A
    # ==========================================
    s14 = prs.slides.add_slide(blank_slide_layout)
    fill_background(s14)

    add_card(s14, Inches(1.2), Inches(1.2), Inches(10.933), Inches(5.1), bg_color=CARD_BG, border_color=EMERALD_ACCENT)

    badge_box = s14.shapes.add_textbox(Inches(1.6), Inches(1.6), Inches(10.0), Inches(0.4))
    tf_b = badge_box.text_frame
    p_b = tf_b.paragraphs[0]
    p_b.text = "CAREERFORGE — CONCLUSION & EVALUATION"
    p_b.font.name = 'Calibri'
    p_b.font.size = Pt(13)
    p_b.font.bold = True
    p_b.font.color.rgb = PRIMARY_BLUE

    t_box = s14.shapes.add_textbox(Inches(1.6), Inches(2.1), Inches(10.0), Inches(0.8))
    tf = t_box.text_frame
    p = tf.paragraphs[0]
    p.text = "Thank You!"
    p.font.name = 'Calibri'
    p.font.size = Pt(36)
    p.font.bold = True
    p.font.color.rgb = TEXT_WHITE

    sub_box = s14.shapes.add_textbox(Inches(1.6), Inches(3.0), Inches(10.0), Inches(2.8))
    tf_sub = sub_box.text_frame
    
    p1 = tf_sub.paragraphs[0]
    p1.text = "CareerForge delivers a robust, secure, and production-ready backend that empowers students to prepare systematically for their campus placements and technical interviews."
    p1.font.name = 'Calibri'
    p1.font.size = Pt(14)
    p1.font.color.rgb = TEXT_BODY
    p1.space_after = Pt(14)

    p2 = tf_sub.add_paragraph()
    p2.text = "• Presenter: Akash Kumar (Backend Lead & Architect)"
    p2.font.name = 'Calibri'
    p2.font.size = Pt(14)
    p2.font.bold = True
    p2.font.color.rgb = EMERALD_ACCENT

    p3 = tf_sub.add_paragraph()
    p3.text = "• Live Backend API: https://careerforge-backend-7p3w.onrender.com/swagger-ui.html"
    p3.font.name = 'Calibri'
    p3.font.size = Pt(13)
    p3.font.color.rgb = PRIMARY_BLUE

    p4 = tf_sub.add_paragraph()
    p4.text = "• Team Members: Kushagra (Contest Platform) | Aman (Progress Tracking) | Vivek (Frontend Platform)"
    p4.font.name = 'Calibri'
    p4.font.size = Pt(13)
    p4.font.color.rgb = TEXT_MUTED
    p4.space_after = Pt(12)

    p5 = tf_sub.add_paragraph()
    p5.text = "Questions & Answers are welcomed!"
    p5.font.name = 'Calibri'
    p5.font.size = Pt(16)
    p5.font.bold = True
    p5.font.color.rgb = AMBER_ACCENT

    # Save to workspace and artifact directory
    output_workspace = "CareerForge_Akash_Kumar_Presentation.pptx"
    prs.save(output_workspace)
    print(f"Presentation saved successfully to: {output_workspace}")

if __name__ == "__main__":
    create_presentation()
