package com.careerforge.config;

import com.careerforge.community.entity.CommunityQuestion;
import com.careerforge.community.repository.CommunityQuestionRepository;
import com.careerforge.notification.entity.Notification;
import com.careerforge.notification.repository.NotificationRepository;
import com.careerforge.progress.entity.Progress;
import com.careerforge.progress.repository.ProgressRepository;
import com.careerforge.roadmap.entity.StudentRoadmapQuestionProgress;
import com.careerforge.roadmap.entity.StudentRoadmapQuestionProgressId;
import com.careerforge.roadmap.repository.RoadmapRepository;
import com.careerforge.roadmap.repository.RoadmapSectionQuestionRepository;
import com.careerforge.roadmap.repository.StudentRoadmapQuestionProgressRepository;
import com.careerforge.sheet.entity.StudentSheetProgress;
import com.careerforge.sheet.repository.SheetTopicRepository;
import com.careerforge.sheet.repository.StudentSheetProgressRepository;
import com.careerforge.student.entity.Language;
import com.careerforge.student.entity.StudentProfile;
import com.careerforge.student.entity.TargetRole;
import com.careerforge.student.repository.StudentProfileRepository;
import com.careerforge.user.entity.Role;
import com.careerforge.user.entity.User;
import com.careerforge.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Optional, idempotent showcase data. It is disabled by default and creates
 * only the dedicated demo account; it never changes ordinary student records.
 */
@Component
@Order(2)
@ConditionalOnProperty(name = "app.demo-data.enabled", havingValue = "true")
public class DemoDataSeeder implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DemoDataSeeder.class);
    public static final String DEMO_EMAIL = "demo.student@careerforge.local";
    public static final String DEMO_PASSWORD = "Demo@123";

    private final UserRepository userRepository;
    private final StudentProfileRepository studentProfileRepository;
    private final ProgressRepository progressRepository;
    private final SheetTopicRepository sheetTopicRepository;
    private final StudentSheetProgressRepository studentSheetProgressRepository;
    private final RoadmapRepository roadmapRepository;
    private final RoadmapSectionQuestionRepository roadmapSectionQuestionRepository;
    private final StudentRoadmapQuestionProgressRepository roadmapProgressRepository;
    private final NotificationRepository notificationRepository;
    private final CommunityQuestionRepository communityQuestionRepository;
    private final PasswordEncoder passwordEncoder;
    private final int studentCount;
    private final int communityQuestionCount;

    public DemoDataSeeder(UserRepository userRepository,
                          StudentProfileRepository studentProfileRepository,
                          ProgressRepository progressRepository,
                          SheetTopicRepository sheetTopicRepository,
                          StudentSheetProgressRepository studentSheetProgressRepository,
                          RoadmapRepository roadmapRepository,
                          RoadmapSectionQuestionRepository roadmapSectionQuestionRepository,
                          StudentRoadmapQuestionProgressRepository roadmapProgressRepository,
                          NotificationRepository notificationRepository,
                          CommunityQuestionRepository communityQuestionRepository,
                          PasswordEncoder passwordEncoder,
                          @Value("${app.demo-data.student-count:500}") int studentCount,
                          @Value("${app.demo-data.community-question-count:24}") int communityQuestionCount) {
        this.userRepository = userRepository;
        this.studentProfileRepository = studentProfileRepository;
        this.progressRepository = progressRepository;
        this.sheetTopicRepository = sheetTopicRepository;
        this.studentSheetProgressRepository = studentSheetProgressRepository;
        this.roadmapRepository = roadmapRepository;
        this.roadmapSectionQuestionRepository = roadmapSectionQuestionRepository;
        this.roadmapProgressRepository = roadmapProgressRepository;
        this.notificationRepository = notificationRepository;
        this.communityQuestionRepository = communityQuestionRepository;
        this.passwordEncoder = passwordEncoder;
        this.studentCount = Math.max(1, studentCount);
        this.communityQuestionCount = Math.max(0, communityQuestionCount);
    }

    @Override
    @Transactional
    public void run(String... args) {
        User demoUser = userRepository.findByEmail(DEMO_EMAIL).orElseGet(() -> userRepository.save(User.builder()
                .firstName("Priya")
                .lastName("Sharma")
                .email(DEMO_EMAIL)
                .password(passwordEncoder.encode(DEMO_PASSWORD))
                .role(Role.STUDENT)
                .active(true)
                .emailVerified(true)
                .build()));

        StudentProfile demoStudent = studentProfileRepository.findByUserId(demoUser.getId()).orElseGet(() ->
                studentProfileRepository.save(StudentProfile.builder()
                        .user(demoUser)
                        .semester(1)
                        .startingSemester(1)
                        .branch("CSE")
                        .section("A")
                        .enrollmentNo("DEMO-CF-2026")
                        .preferredLanguage(Language.JAVA)
                        .targetRole(TargetRole.SDE)
                        .framework("SPRING_BOOT")
                        .streak(12)
                        .build()));

        seedDemoStudents();

        progressRepository.findByStudentId(demoStudent.getId()).orElseGet(() -> progressRepository.save(Progress.builder()
                .student(demoStudent)
                .currentStreak(12)
                .lastActive(LocalDateTime.now())
                .completedTopics(0)
                .completedSheets(0)
                .roadmapProgress(0.0)
                .build()));

        seedSheetProgress(demoStudent);
        seedRoadmapProgress(demoStudent);
        seedNotifications(demoStudent);
        seedCommunityQuestions(demoUser);

        log.info("Demo data is ready. Sign in with {} / {}", DEMO_EMAIL, DEMO_PASSWORD);
    }

    /** Creates a predictable, varied student directory for admin/dashboard presentation. */
    private void seedDemoStudents() {
        String demoPrefix = "demo.student";
        String enrollmentPrefix = "DEMO-CF-";
        String[] firstNames = {"Aarav", "Ananya", "Rohan", "Meera", "Vivaan", "Isha", "Arjun", "Kavya", "Aditya", "Diya"};
        String[] lastNames = {"Sharma", "Verma", "Reddy", "Nair", "Gupta", "Iyer", "Singh", "Patel", "Das", "Khan"};
        String[] branches = {"CSE", "IT", "ECE", "EEE"};
        Language[] languages = {Language.JAVA, Language.CPP, Language.PYTHON};
        TargetRole[] roles = {TargetRole.SDE, TargetRole.FULL_STACK, TargetRole.AI_ML, TargetRole.DATA_SCIENTIST};
        String[] frameworks = {"SPRING_BOOT", "NODE_JS", "PYTHON_FASTAPI", "CP"};

        Map<String, User> usersByEmail = new HashMap<>();
        userRepository.findByEmailStartingWith(demoPrefix).forEach(user -> usersByEmail.put(user.getEmail(), user));
        Map<String, StudentProfile> profilesByEnrollment = new HashMap<>();
        studentProfileRepository.findByEnrollmentNoStartingWith(enrollmentPrefix)
                .forEach(profile -> profilesByEnrollment.put(profile.getEnrollmentNo(), profile));

        String encodedPassword = passwordEncoder.encode(DEMO_PASSWORD);
        List<User> usersToCreate = new ArrayList<>();
        for (int index = 1; index < studentCount; index++) {
            String email = String.format("demo.student%03d@careerforge.local", index);
            if (!usersByEmail.containsKey(email)) {
                User user = User.builder()
                        .firstName(firstNames[index % firstNames.length])
                        .lastName(lastNames[(index / firstNames.length) % lastNames.length])
                        .email(email)
                        .password(encodedPassword)
                        .role(Role.STUDENT)
                        .active(true)
                        .emailVerified(true)
                        .build();
                usersToCreate.add(user);
                usersByEmail.put(email, user);
            }
        }
        if (!usersToCreate.isEmpty()) {
            userRepository.saveAll(usersToCreate);
        }

        List<StudentProfile> profilesToCreate = new ArrayList<>();
        for (int index = 1; index < studentCount; index++) {
            String enrollmentNo = String.format("DEMO-CF-%04d", index);
            if (!profilesByEnrollment.containsKey(enrollmentNo)) {
                String email = String.format("demo.student%03d@careerforge.local", index);
                StudentProfile profile = StudentProfile.builder()
                        .user(usersByEmail.get(email))
                        .semester((index % 8) + 1)
                        // The database constraint permits starting semesters 1 through 5.
                        .startingSemester(((index - 1) % 5) + 1)
                        .branch(branches[index % branches.length])
                        .section(String.valueOf((char) ('A' + (index % 3))))
                        .enrollmentNo(enrollmentNo)
                        .preferredLanguage(languages[index % languages.length])
                        .targetRole(roles[index % roles.length])
                        .framework(frameworks[index % frameworks.length])
                        .streak(index % 22)
                        .build();
                profilesToCreate.add(profile);
            }
        }
        if (!profilesToCreate.isEmpty()) {
            studentProfileRepository.saveAll(profilesToCreate);
        }

        log.info("Demo student directory ready: {} total demo students across CSE, IT, ECE, and EEE.", studentCount);
    }

    private void seedSheetProgress(StudentProfile student) {
        sheetTopicRepository.findAll().stream().limit(8).forEach(topic -> {
            if (studentSheetProgressRepository.findByStudentIdAndSheetTopicId(student.getId(), topic.getId()).isEmpty()) {
                studentSheetProgressRepository.save(StudentSheetProgress.builder()
                        .student(student)
                        .sheetTopic(topic)
                        .completed(true)
                        .completedAt(LocalDateTime.now().minusDays(topic.getOrderIndex() % 6L))
                        .build());
            }
        });
    }

    private void seedRoadmapProgress(StudentProfile student) {
        roadmapRepository.findBySemesterAndTargetRole(student.getSemester(), student.getTargetRole().name())
                .ifPresent(roadmap -> roadmapSectionQuestionRepository.findByRoadmapSectionRoadmapId(roadmap.getId())
                        .stream()
                        .limit(14)
                        .forEach(question -> {
                            StudentRoadmapQuestionProgressId id = StudentRoadmapQuestionProgressId.builder()
                                    .studentId(student.getId())
                                    .roadmapSectionQuestionId(question.getId())
                                    .build();
                            if (!roadmapProgressRepository.existsById(id)) {
                                roadmapProgressRepository.save(StudentRoadmapQuestionProgress.builder()
                                        .id(id)
                                        .student(student)
                                        .roadmapSectionQuestion(question)
                                        .completed(true)
                                        .revisionMarked(question.getPosition() % 3 == 0)
                                        .completedAt(LocalDateTime.now().minusDays(question.getPosition() % 7L))
                                        .build());
                            }
                        }));
    }

    private void seedNotifications(StudentProfile student) {
        if (notificationRepository.findByStudentUserIdOrderByCreatedAtDesc(student.getUser().getId()).isEmpty()) {
            notificationRepository.save(Notification.builder().student(student)
                    .message("Great momentum! You have maintained a 12-day learning streak.").build());
            notificationRepository.save(Notification.builder().student(student)
                    .message("Your Spring Boot journey is ready for the next topic.").build());
            notificationRepository.save(Notification.builder().student(student)
                    .message("New placement resources were added to your study library.").build());
        }
    }

    private void seedCommunityQuestions(User demoUser) {
        long existingCount = communityQuestionRepository.countByAuthorId(demoUser.getId());
        if (existingCount >= communityQuestionCount) {
            return;
        }

        String[] subjects = {"Spring Boot", "Java", "DSA", "React", "SQL", "System Design", "Git", "Docker"};
        String[] contexts = {
                "for a placement-ready project", "while preparing for technical interviews",
                "in a clean production-style codebase", "without getting lost in tutorials",
                "during my first semester", "when building a portfolio project"
        };
        String[] tags = {
                "spring-boot,java,placement", "java,oops,interview", "dsa,problem-solving,placement",
                "react,frontend,portfolio", "sql,database,backend", "system-design,interview,architecture",
                "git,collaboration,tools", "docker,devops,backend"
        };

        List<CommunityQuestion> questions = new ArrayList<>();
        for (long index = existingCount; index < communityQuestionCount; index++) {
            int subjectIndex = (int) (index % subjects.length);
            String subject = subjects[subjectIndex];
            String context = contexts[(int) (index % contexts.length)];
            questions.add(CommunityQuestion.builder()
                    .author(demoUser)
                    .title("Demo #" + (index + 1) + ": How should I learn " + subject + " " + context + "?")
                    .content("I am following the CareerForge learning path and would like practical advice on "
                            + subject + ". Which concepts should I prioritise, and what small project or practice routine would help me improve?")
                    .tags(tags[subjectIndex])
                    .build());
        }
        communityQuestionRepository.saveAll(questions);
        log.info("Seeded {} demo community questions ({} total for demo student).", questions.size(), communityQuestionCount);
    }
}
