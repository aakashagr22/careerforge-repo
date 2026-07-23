package com.careerforge.roadmap.seeder;

import java.util.ArrayList;
import java.util.List;

public class CpSheetSeeder {

    // Common YouTube Playlists / Tutorials for TLE CP-31 Sheet
    static final String yt_cp31_800  = "https://www.youtube.com/watch?v=35EQXmHKZYs&list=PLgUwDviBIf0rGlzBo5Nsr4AfGDIa1V06L";
    static final String yt_cp31_900  = "https://www.youtube.com/watch?v=1904A&list=PLgUwDviBIf0rGlzBo5Nsr4AfGDIa1V06L";
    static final String yt_cp31_1000 = "https://www.youtube.com/watch?v=1913B&list=PLgUwDviBIf0rGlzBo5Nsr4AfGDIa1V06L";
    static final String yt_cp31_1100 = "https://www.youtube.com/watch?v=1914C&list=PLgUwDviBIf0rGlzBo5Nsr4AfGDIa1V06L";

    public static void seed(
        com.careerforge.roadmap.entity.Roadmap dbRoadmap,
        com.careerforge.roadmap.repository.RoadmapSectionRepository roadmapSectionRepository,
        com.careerforge.roadmap.repository.QuestionRepository questionRepository,
        com.careerforge.roadmap.repository.QuestionLinkRepository questionLinkRepository,
        com.careerforge.roadmap.repository.RoadmapSectionQuestionRepository roadmapSectionQuestionRepository
    ) {
        System.out.println("Seeding Roadmap: TLE Eliminators CP-31 Sheet");
        Roadmap.sections.clear();

        RoadmapSection s;
        Topic t;

        // ==========================================
        // Section 1: Rating 800 (Beginner Foundations)
        // ==========================================
        s = createSection("Rating 800 - Beginner Foundations");

        t = createTopic(s, "Rating 800 - Part 1");
        addQ(t, "1. Halloumi Boxes", "EASY", "https://codeforces.com/problemset/problem/1903/A",
            "ARTICLE", "https://codeforces.com/blog/entry/122934",
            "VIDEO", "https://www.youtube.com/watch?v=f1cW6c68Gq8");
        addQ(t, "2. Line Trip", "EASY", "https://codeforces.com/problemset/problem/1901/A",
            "ARTICLE", "https://codeforces.com/blog/entry/122675",
            "VIDEO", "https://www.youtube.com/watch?v=833x1bB7hFk");
        addQ(t, "3. Cover in Water", "EASY", "https://codeforces.com/problemset/problem/1900/A",
            "ARTICLE", "https://codeforces.com/blog/entry/122616",
            "VIDEO", "https://www.youtube.com/watch?v=3Kk7sVw_N9Q");
        addQ(t, "4. Game with Integers", "EASY", "https://codeforces.com/problemset/problem/1899/A",
            "ARTICLE", "https://codeforces.com/blog/entry/122394",
            "VIDEO", "https://www.youtube.com/watch?v=28JkR4dE_2g");
        addQ(t, "5. Jagged Swaps", "EASY", "https://codeforces.com/problemset/problem/1896/A",
            "ARTICLE", "https://codeforces.com/blog/entry/122675",
            "VIDEO", "https://www.youtube.com/watch?v=aG3i8JgC2Y8");
        addQ(t, "6. Doremy's Paint 3", "EASY", "https://codeforces.com/problemset/problem/1890/A",
            "ARTICLE", "https://codeforces.com/blog/entry/121852",
            "VIDEO", "https://www.youtube.com/watch?v=wX2gY7tB8hA");
        addQ(t, "7. Don't Try to Count", "EASY", "https://codeforces.com/problemset/problem/1881/A",
            "ARTICLE", "https://codeforces.com/blog/entry/121287",
            "VIDEO", "https://www.youtube.com/watch?v=x-4z_GupYgA");
        addQ(t, "8. How Much Does Daytona Cost?", "EASY", "https://codeforces.com/problemset/problem/1878/A",
            "ARTICLE", "https://codeforces.com/blog/entry/120786",
            "VIDEO", "https://www.youtube.com/watch?v=c5wI2nIn2gU");

        t = createTopic(s, "Rating 800 - Part 2");
        addQ(t, "9. Ambitious Kid", "EASY", "https://codeforces.com/problemset/problem/1872/A",
            "ARTICLE", "https://codeforces.com/blog/entry/120150",
            "VIDEO", "https://www.youtube.com/watch?v=K8r6jbgXk-A");
        addQ(t, "10. Target Practice", "EASY", "https://codeforces.com/problemset/problem/1873/C",
            "ARTICLE", "https://codeforces.com/blog/entry/120612",
            "VIDEO", "https://www.youtube.com/watch?v=R76n0brv5iU");
        addQ(t, "11. Sequence Game", "EASY", "https://codeforces.com/problemset/problem/1862/B",
            "ARTICLE", "https://codeforces.com/blog/entry/119642",
            "VIDEO", "https://www.youtube.com/watch?v=b9O9NI-Fi3U");
        addQ(t, "12. United We Stand", "EASY", "https://codeforces.com/problemset/problem/1859/A",
            "ARTICLE", "https://codeforces.com/blog/entry/119280",
            "VIDEO", "https://www.youtube.com/watch?v=n-WzX1mNnQk");
        addQ(t, "13. Array Coloring", "EASY", "https://codeforces.com/problemset/problem/1857/A",
            "ARTICLE", "https://codeforces.com/blog/entry/119102",
            "VIDEO", "https://www.youtube.com/watch?v=zJg1RkG3F78");
        addQ(t, "14. Buttons", "EASY", "https://codeforces.com/problemset/problem/1858/A",
            "ARTICLE", "https://codeforces.com/blog/entry/119335",
            "VIDEO", "https://www.youtube.com/watch?v=o0u9w7M7v6Y");
        addQ(t, "15. Desorting", "EASY", "https://codeforces.com/problemset/problem/1853/A",
            "ARTICLE", "https://codeforces.com/blog/entry/118503",
            "VIDEO", "https://www.youtube.com/watch?v=Geq60OVywsg");
        addQ(t, "16. One and Two", "EASY", "https://codeforces.com/problemset/problem/1788/A",
            "ARTICLE", "https://codeforces.com/blog/entry/112674",
            "VIDEO", "https://www.youtube.com/watch?v=SqVfCyfCJqy");

        // ==========================================
        // Section 2: Rating 900 (Elementary Logic)
        // ==========================================
        s = createSection("Rating 900 - Elementary Logic");

        t = createTopic(s, "Rating 900 - Part 1");
        addQ(t, "1. Forked!", "EASY", "https://codeforces.com/problemset/problem/1904/A",
            "ARTICLE", "https://codeforces.com/blog/entry/123164",
            "VIDEO", "https://www.youtube.com/watch?v=1aWhYEynZQw");
        addQ(t, "2. Chemistry", "EASY", "https://codeforces.com/problemset/problem/1883/B",
            "ARTICLE", "https://codeforces.com/blog/entry/121664",
            "VIDEO", "https://www.youtube.com/watch?v=lhW6eD00yX0");
        addQ(t, "3. Vika and Her Friends", "EASY", "https://codeforces.com/problemset/problem/1848/A",
            "ARTICLE", "https://codeforces.com/blog/entry/118228",
            "VIDEO", "https://www.youtube.com/watch?v=fl8Y4e3fT4A");
        addQ(t, "4. Jellyfish and Undertale", "EASY", "https://codeforces.com/problemset/problem/1875/A",
            "ARTICLE", "https://codeforces.com/blog/entry/120894",
            "VIDEO", "https://www.youtube.com/watch?v=35EQXmHKZYs");
        addQ(t, "5. Make It Zero", "EASY", "https://codeforces.com/problemset/problem/1869/A",
            "ARTICLE", "https://codeforces.com/blog/entry/120150",
            "VIDEO", "https://www.youtube.com/watch?v=x-4z_GupYgA");
        addQ(t, "6. Balanced Round", "EASY", "https://codeforces.com/problemset/problem/1850/D",
            "ARTICLE", "https://codeforces.com/blog/entry/118002",
            "VIDEO", "https://www.youtube.com/watch?v=c5wI2nIn2gU");
        addQ(t, "7. Comparison String", "EASY", "https://codeforces.com/problemset/problem/1837/B",
            "ARTICLE", "https://codeforces.com/blog/entry/116492",
            "VIDEO", "https://www.youtube.com/watch?v=K8r6jbgXk-A");

        t = createTopic(s, "Rating 900 - Part 2");
        addQ(t, "8. Permutation Swap", "EASY", "https://codeforces.com/problemset/problem/1828/B",
            "ARTICLE", "https://codeforces.com/blog/entry/116212",
            "VIDEO", "https://www.youtube.com/watch?v=8SGI_XS5OPw");
        addQ(t, "9. Odd Queries", "EASY", "https://codeforces.com/problemset/problem/1807/D",
            "ARTICLE", "https://codeforces.com/blog/entry/114002",
            "VIDEO", "https://www.youtube.com/watch?v=R76n0brv5iU");
        addQ(t, "10. Longest Divisors Interval", "EASY", "https://codeforces.com/problemset/problem/1855/B",
            "ARTICLE", "https://codeforces.com/blog/entry/118742",
            "VIDEO", "https://www.youtube.com/watch?v=b9O9NI-Fi3U");
        addQ(t, "11. Mainak and Array", "EASY", "https://codeforces.com/problemset/problem/1726/A",
            "ARTICLE", "https://codeforces.com/blog/entry/106684",
            "VIDEO", "https://www.youtube.com/watch?v=n-WzX1mNnQk");
        addQ(t, "12. Make It Increasing", "EASY", "https://codeforces.com/problemset/problem/1675/B",
            "ARTICLE", "https://codeforces.com/blog/entry/102552",
            "VIDEO", "https://www.youtube.com/watch?v=zJg1RkG3F78");
        addQ(t, "13. Deletive Editing", "EASY", "https://codeforces.com/problemset/problem/1666/D",
            "ARTICLE", "https://codeforces.com/blog/entry/102148",
            "VIDEO", "https://www.youtube.com/watch?v=o0u9w7M7v6Y");
        addQ(t, "14. AvtoBus", "EASY", "https://codeforces.com/problemset/problem/1679/A",
            "ARTICLE", "https://codeforces.com/blog/entry/102834",
            "VIDEO", "https://www.youtube.com/watch?v=Geq60OVywsg");

        // ==========================================
        // Section 3: Rating 1000 (Intermediate Problem Solving)
        // ==========================================
        s = createSection("Rating 1000 - Intermediate Problem Solving");

        t = createTopic(s, "Rating 1000 - Core Problems");
        addQ(t, "1. Swap and Delete", "MEDIUM", "https://codeforces.com/problemset/problem/1913/B",
            "ARTICLE", "https://codeforces.com/blog/entry/123490",
            "VIDEO", "https://www.youtube.com/watch?v=SqVfCyfCJqy");
        addQ(t, "2. Raspberries", "MEDIUM", "https://codeforces.com/problemset/problem/1883/C",
            "ARTICLE", "https://codeforces.com/blog/entry/121664",
            "VIDEO", "https://www.youtube.com/watch?v=1aWhYEynZQw");
        addQ(t, "3. Helmets in Night Light", "MEDIUM", "https://codeforces.com/problemset/problem/1876/A",
            "ARTICLE", "https://codeforces.com/blog/entry/121002",
            "VIDEO", "https://www.youtube.com/watch?v=lhW6eD00yX0");
        addQ(t, "4. Olya and Game with Arrays", "MEDIUM", "https://codeforces.com/problemset/problem/1859/B",
            "ARTICLE", "https://codeforces.com/blog/entry/119280",
            "VIDEO", "https://www.youtube.com/watch?v=fl8Y4e3fT4A");
        addQ(t, "5. Array Merging", "MEDIUM", "https://codeforces.com/problemset/problem/1831/B",
            "ARTICLE", "https://codeforces.com/blog/entry/116742",
            "VIDEO", "https://www.youtube.com/watch?v=35EQXmHKZYs");
        addQ(t, "6. Ski Resort", "MEDIUM", "https://codeforces.com/problemset/problem/1840/C",
            "ARTICLE", "https://codeforces.com/blog/entry/117102",
            "VIDEO", "https://www.youtube.com/watch?v=x-4z_GupYgA");
        addQ(t, "7. Monsters", "MEDIUM", "https://codeforces.com/problemset/problem/1849/B",
            "ARTICLE", "https://codeforces.com/blog/entry/118802",
            "VIDEO", "https://www.youtube.com/watch?v=c5wI2nIn2gU");
        addQ(t, "8. Minimum LCM", "MEDIUM", "https://codeforces.com/problemset/problem/1765/M",
            "ARTICLE", "https://codeforces.com/blog/entry/110150",
            "VIDEO", "https://www.youtube.com/watch?v=K8r6jbgXk-A");
        addQ(t, "9. Traffic Light", "MEDIUM", "https://codeforces.com/problemset/problem/1744/C",
            "ARTICLE", "https://codeforces.com/blog/entry/108502",
            "VIDEO", "https://www.youtube.com/watch?v=R76n0brv5iU");
        addQ(t, "10. Distinct Split", "MEDIUM", "https://codeforces.com/problemset/problem/1791/D",
            "ARTICLE", "https://codeforces.com/blog/entry/112390",
            "VIDEO", "https://www.youtube.com/watch?v=b9O9NI-Fi3U");

        // ==========================================
        // Section 4: Rating 1100 - 1200 (Upper Intermediate)
        // ==========================================
        s = createSection("Rating 1100 - 1200 - Upper Intermediate");

        t = createTopic(s, "Rating 1100 Problems");
        addQ(t, "1. Erase First or Second Letter", "MEDIUM", "https://codeforces.com/problemset/problem/1914/D",
            "ARTICLE", "https://codeforces.com/blog/entry/123612",
            "VIDEO", "https://www.youtube.com/watch?v=n-WzX1mNnQk");
        addQ(t, "2. Quests", "MEDIUM", "https://codeforces.com/problemset/problem/1914/C",
            "ARTICLE", "https://codeforces.com/blog/entry/123612",
            "VIDEO", "https://www.youtube.com/watch?v=zJg1RkG3F78");
        addQ(t, "3. Collecting Game", "MEDIUM", "https://codeforces.com/problemset/problem/1904/B",
            "ARTICLE", "https://codeforces.com/blog/entry/123164",
            "VIDEO", "https://www.youtube.com/watch?v=o0u9w7M7v6Y");
        addQ(t, "4. Building an Aquarium", "MEDIUM", "https://codeforces.com/problemset/problem/1873/E",
            "ARTICLE", "https://codeforces.com/blog/entry/120612",
            "VIDEO", "https://www.youtube.com/watch?v=Geq60OVywsg");
        addQ(t, "5. 250 Thousand Tons of TNT", "MEDIUM", "https://codeforces.com/problemset/problem/1899/B",
            "ARTICLE", "https://codeforces.com/blog/entry/122394",
            "VIDEO", "https://www.youtube.com/watch?v=SqVfCyfCJqy");

        t = createTopic(s, "Rating 1200 Problems");
        addQ(t, "6. Three Activities", "MEDIUM", "https://codeforces.com/problemset/problem/1914/D",
            "ARTICLE", "https://codeforces.com/blog/entry/123612",
            "VIDEO", "https://www.youtube.com/watch?v=1aWhYEynZQw");
        addQ(t, "7. Assembly via Minimums", "MEDIUM", "https://codeforces.com/problemset/problem/1857/C",
            "ARTICLE", "https://codeforces.com/blog/entry/119102",
            "VIDEO", "https://www.youtube.com/watch?v=lhW6eD00yX0");
        addQ(t, "8. Make Almost Equal With Mod", "MEDIUM", "https://codeforces.com/problemset/problem/1909/B",
            "ARTICLE", "https://codeforces.com/blog/entry/123802",
            "VIDEO", "https://www.youtube.com/watch?v=fl8Y4e3fT4A");
        addQ(t, "9. Contrast Value", "MEDIUM", "https://codeforces.com/problemset/problem/1832/C",
            "ARTICLE", "https://codeforces.com/blog/entry/116390",
            "VIDEO", "https://www.youtube.com/watch?v=35EQXmHKZYs");
        addQ(t, "10. Matryoshkas", "MEDIUM", "https://codeforces.com/problemset/problem/1790/D",
            "ARTICLE", "https://codeforces.com/blog/entry/112102",
            "VIDEO", "https://www.youtube.com/watch?v=x-4z_GupYgA");

        // ==========================================
        // Section 5: Rating 1300 - 1600 (Advanced & Expert)
        // ==========================================
        s = createSection("Rating 1300 - 1600 - Advanced & Expert");

        t = createTopic(s, "Rating 1300 - 1400");
        addQ(t, "1. Divisible Pairs", "HARD", "https://codeforces.com/problemset/problem/1931/D",
            "ARTICLE", "https://codeforces.com/blog/entry/125802",
            "VIDEO", "https://www.youtube.com/watch?v=c5wI2nIn2gU");
        addQ(t, "2. Find the Different One!", "HARD", "https://codeforces.com/problemset/problem/1927/D",
            "ARTICLE", "https://codeforces.com/blog/entry/125402",
            "VIDEO", "https://www.youtube.com/watch?v=K8r6jbgXk-A");
        addQ(t, "3. Make it Alternating", "HARD", "https://codeforces.com/problemset/problem/1879/C",
            "ARTICLE", "https://codeforces.com/blog/entry/120786",
            "VIDEO", "https://www.youtube.com/watch?v=R76n0brv5iU");
        addQ(t, "4. Product of Three Numbers", "HARD", "https://codeforces.com/problemset/problem/1294/C",
            "ARTICLE", "https://codeforces.com/blog/entry/73390",
            "VIDEO", "https://www.youtube.com/watch?v=b9O9NI-Fi3U");

        t = createTopic(s, "Rating 1500 - 1600");
        addQ(t, "5. Greetings", "HARD", "https://codeforces.com/problemset/problem/1915/F",
            "ARTICLE", "https://codeforces.com/blog/entry/123890",
            "VIDEO", "https://www.youtube.com/watch?v=n-WzX1mNnQk");
        addQ(t, "6. Data Structures Fan", "HARD", "https://codeforces.com/problemset/problem/1872/E",
            "ARTICLE", "https://codeforces.com/blog/entry/120150",
            "VIDEO", "https://www.youtube.com/watch?v=zJg1RkG3F78");
        addQ(t, "7. Block Sequence", "HARD", "https://codeforces.com/problemset/problem/1881/E",
            "ARTICLE", "https://codeforces.com/blog/entry/121287",
            "VIDEO", "https://www.youtube.com/watch?v=o0u9w7M7v6Y");
        addQ(t, "8. Smilo and Monsters", "HARD", "https://codeforces.com/problemset/problem/1891/C",
            "ARTICLE", "https://codeforces.com/blog/entry/121852",
            "VIDEO", "https://www.youtube.com/watch?v=Geq60OVywsg");


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
                    .label("Solve Problem")
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
                
        System.out.println("TLE Eliminators CP-31 Sheet Seeding completed successfully.");
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

    private static void addQ(Topic topic, String title, String difficulty, String solveLink, String... links) {
        Question q = new Question(topic.slug + "_" + slugify(title), title, difficulty);
        q.setSolveLink(solveLink);

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
