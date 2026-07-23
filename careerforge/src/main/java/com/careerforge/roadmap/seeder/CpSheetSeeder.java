package com.careerforge.roadmap.seeder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
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

        if (!seedFromJson()) {
            System.out.println("Seeding from static hardcoded problem set fallback...");
        }

        if (Roadmap.sections.isEmpty()) {
            RoadmapSection s;
            Topic t;

            // ==========================================
            // Section 1: Rating 800
            // ==========================================
        s = createSection("Rating 800 - Beginner Foundations");

        t = createTopic(s, "Rating 800 - Part 1");
        addQ(t, "1. Halloumi Boxes", "EASY", "https://codeforces.com/problemset/problem/1903/A", "ARTICLE", "https://codeforces.com/blog/entry/122934", "VIDEO", "https://www.youtube.com/watch?v=f1cW6c68Gq8");
        addQ(t, "2. Line Trip", "EASY", "https://codeforces.com/problemset/problem/1901/A", "ARTICLE", "https://codeforces.com/blog/entry/122675", "VIDEO", "https://www.youtube.com/watch?v=833x1bB7hFk");
        addQ(t, "3. Cover in Water", "EASY", "https://codeforces.com/problemset/problem/1900/A", "ARTICLE", "https://codeforces.com/blog/entry/122616", "VIDEO", "https://www.youtube.com/watch?v=3Kk7sVw_N9Q");
        addQ(t, "4. Game with Integers", "EASY", "https://codeforces.com/problemset/problem/1899/A", "ARTICLE", "https://codeforces.com/blog/entry/122394", "VIDEO", "https://www.youtube.com/watch?v=28JkR4dE_2g");
        addQ(t, "5. Jagged Swaps", "EASY", "https://codeforces.com/problemset/problem/1896/A", "ARTICLE", "https://codeforces.com/blog/entry/122675", "VIDEO", "https://www.youtube.com/watch?v=aG3i8JgC2Y8");
        addQ(t, "6. Doremy's Paint 3", "EASY", "https://codeforces.com/problemset/problem/1890/A", "ARTICLE", "https://codeforces.com/blog/entry/121852", "VIDEO", "https://www.youtube.com/watch?v=wX2gY7tB8hA");
        addQ(t, "7. Don't Try to Count", "EASY", "https://codeforces.com/problemset/problem/1881/A", "ARTICLE", "https://codeforces.com/blog/entry/121287", "VIDEO", "https://www.youtube.com/watch?v=x-4z_GupYgA");
        addQ(t, "8. How Much Does Daytona Cost?", "EASY", "https://codeforces.com/problemset/problem/1878/A", "ARTICLE", "https://codeforces.com/blog/entry/120786", "VIDEO", "https://www.youtube.com/watch?v=c5wI2nIn2gU");
        addQ(t, "9. Ambitious Kid", "EASY", "https://codeforces.com/problemset/problem/1872/A", "ARTICLE", "https://codeforces.com/blog/entry/120150", "VIDEO", "https://www.youtube.com/watch?v=K8r6jbgXk-A");
        addQ(t, "10. Target Practice", "EASY", "https://codeforces.com/problemset/problem/1873/C", "ARTICLE", "https://codeforces.com/blog/entry/120612", "VIDEO", "https://www.youtube.com/watch?v=R76n0brv5iU");
        addQ(t, "11. Sequence Game", "EASY", "https://codeforces.com/problemset/problem/1862/B", "ARTICLE", "https://codeforces.com/blog/entry/119642", "VIDEO", "https://www.youtube.com/watch?v=b9O9NI-Fi3U");
        addQ(t, "12. United We Stand", "EASY", "https://codeforces.com/problemset/problem/1859/A", "ARTICLE", "https://codeforces.com/blog/entry/119280", "VIDEO", "https://www.youtube.com/watch?v=n-WzX1mNnQk");
        addQ(t, "13. Array Coloring", "EASY", "https://codeforces.com/problemset/problem/1857/A", "ARTICLE", "https://codeforces.com/blog/entry/119102", "VIDEO", "https://www.youtube.com/watch?v=zJg1RkG3F78");
        addQ(t, "14. Buttons", "EASY", "https://codeforces.com/problemset/problem/1858/A", "ARTICLE", "https://codeforces.com/blog/entry/119335", "VIDEO", "https://www.youtube.com/watch?v=o0u9w7M7v6Y");
        addQ(t, "15. Desorting", "EASY", "https://codeforces.com/problemset/problem/1853/A", "ARTICLE", "https://codeforces.com/blog/entry/118503", "VIDEO", "https://www.youtube.com/watch?v=Geq60OVywsg");

        t = createTopic(s, "Rating 800 - Part 2");
        addQ(t, "16. Forbidden Integer", "EASY", "https://codeforces.com/problemset/problem/1845/A", "ARTICLE", "https://codeforces.com/blog/entry/117764", "VIDEO", "https://www.youtube.com/watch?v=SqVfCyfCJqy");
        addQ(t, "17. Grasshopper on a Line", "EASY", "https://codeforces.com/problemset/problem/1837/A", "ARTICLE", "https://codeforces.com/blog/entry/116492", "VIDEO", "https://www.youtube.com/watch?v=1aWhYEynZQw");
        addQ(t, "18. Unit Array", "EASY", "https://codeforces.com/problemset/problem/1834/A", "ARTICLE", "https://codeforces.com/blog/entry/117392", "VIDEO", "https://www.youtube.com/watch?v=lhW6eD00yX0");
        addQ(t, "19. Twin Permutations", "EASY", "https://codeforces.com/problemset/problem/1831/A", "ARTICLE", "https://codeforces.com/blog/entry/116742", "VIDEO", "https://www.youtube.com/watch?v=fl8Y4e3fT4A");
        addQ(t, "20. Blank Space", "EASY", "https://codeforces.com/problemset/problem/1829/B", "ARTICLE", "https://codeforces.com/blog/entry/116102", "VIDEO", "https://www.youtube.com/watch?v=35EQXmHKZYs");
        addQ(t, "21. Coins", "EASY", "https://codeforces.com/problemset/problem/1814/A", "ARTICLE", "https://codeforces.com/blog/entry/114674", "VIDEO", "https://www.youtube.com/watch?v=x-4z_GupYgA");
        addQ(t, "22. Prepend and Append", "EASY", "https://codeforces.com/problemset/problem/1791/C", "ARTICLE", "https://codeforces.com/blog/entry/112390", "VIDEO", "https://www.youtube.com/watch?v=c5wI2nIn2gU");
        addQ(t, "23. One and Two", "EASY", "https://codeforces.com/problemset/problem/1788/A", "ARTICLE", "https://codeforces.com/blog/entry/112674", "VIDEO", "https://www.youtube.com/watch?v=K8r6jbgXk-A");
        addQ(t, "24. Make It Beautiful", "EASY", "https://codeforces.com/problemset/problem/1783/A", "ARTICLE", "https://codeforces.com/blog/entry/111290", "VIDEO", "https://www.youtube.com/watch?v=R76n0brv5iU");
        addQ(t, "25. Extremely Round", "EASY", "https://codeforces.com/problemset/problem/1760/A", "ARTICLE", "https://codeforces.com/blog/entry/109390", "VIDEO", "https://www.youtube.com/watch?v=b9O9NI-Fi3U");
        addQ(t, "26. Two Permutations", "EASY", "https://codeforces.com/problemset/problem/1761/A", "ARTICLE", "https://codeforces.com/blog/entry/109552", "VIDEO", "https://www.youtube.com/watch?v=n-WzX1mNnQk");
        addQ(t, "27. Serval and Mocha's Array", "EASY", "https://codeforces.com/problemset/problem/1789/A", "ARTICLE", "https://codeforces.com/blog/entry/112802", "VIDEO", "https://www.youtube.com/watch?v=zJg1RkG3F78");
        addQ(t, "28. We Need the Zero", "EASY", "https://codeforces.com/problemset/problem/1805/A", "ARTICLE", "https://codeforces.com/blog/entry/114390", "VIDEO", "https://www.youtube.com/watch?v=o0u9w7M7v6Y");
        addQ(t, "29. Walking Master", "EASY", "https://codeforces.com/problemset/problem/1806/A", "ARTICLE", "https://codeforces.com/blog/entry/114102", "VIDEO", "https://www.youtube.com/watch?v=Geq60OVywsg");
        addQ(t, "30. Goals of Victory", "EASY", "https://codeforces.com/problemset/problem/1873/A", "ARTICLE", "https://codeforces.com/blog/entry/120612", "VIDEO", "https://www.youtube.com/watch?v=SqVfCyfCJqy");

        // ==========================================
        // Section 2: Rating 900
        // ==========================================
        s = createSection("Rating 900 - Elementary Logic");

        t = createTopic(s, "Rating 900 - Part 1");
        addQ(t, "1. Forked!", "EASY", "https://codeforces.com/problemset/problem/1904/A", "ARTICLE", "https://codeforces.com/blog/entry/123164", "VIDEO", "https://www.youtube.com/watch?v=1aWhYEynZQw");
        addQ(t, "2. Chemistry", "EASY", "https://codeforces.com/problemset/problem/1883/B", "ARTICLE", "https://codeforces.com/blog/entry/121664", "VIDEO", "https://www.youtube.com/watch?v=lhW6eD00yX0");
        addQ(t, "3. Vika and Her Friends", "EASY", "https://codeforces.com/problemset/problem/1848/A", "ARTICLE", "https://codeforces.com/blog/entry/118228", "VIDEO", "https://www.youtube.com/watch?v=fl8Y4e3fT4A");
        addQ(t, "4. Jellyfish and Undertale", "EASY", "https://codeforces.com/problemset/problem/1875/A", "ARTICLE", "https://codeforces.com/blog/entry/120894", "VIDEO", "https://www.youtube.com/watch?v=35EQXmHKZYs");
        addQ(t, "5. Make It Zero", "EASY", "https://codeforces.com/problemset/problem/1869/A", "ARTICLE", "https://codeforces.com/blog/entry/120150", "VIDEO", "https://www.youtube.com/watch?v=x-4z_GupYgA");
        addQ(t, "6. Balanced Round", "EASY", "https://codeforces.com/problemset/problem/1850/D", "ARTICLE", "https://codeforces.com/blog/entry/118002", "VIDEO", "https://www.youtube.com/watch?v=c5wI2nIn2gU");
        addQ(t, "7. Comparison String", "EASY", "https://codeforces.com/problemset/problem/1837/B", "ARTICLE", "https://codeforces.com/blog/entry/116492", "VIDEO", "https://www.youtube.com/watch?v=K8r6jbgXk-A");
        addQ(t, "8. Permutation Swap", "EASY", "https://codeforces.com/problemset/problem/1828/B", "ARTICLE", "https://codeforces.com/blog/entry/116212", "VIDEO", "https://www.youtube.com/watch?v=8SGI_XS5OPw");
        addQ(t, "9. Odd Queries", "EASY", "https://codeforces.com/problemset/problem/1807/D", "ARTICLE", "https://codeforces.com/blog/entry/114002", "VIDEO", "https://www.youtube.com/watch?v=R76n0brv5iU");
        addQ(t, "10. Longest Divisors Interval", "EASY", "https://codeforces.com/problemset/problem/1855/B", "ARTICLE", "https://codeforces.com/blog/entry/118742", "VIDEO", "https://www.youtube.com/watch?v=b9O9NI-Fi3U");
        addQ(t, "11. Mainak and Array", "EASY", "https://codeforces.com/problemset/problem/1726/A", "ARTICLE", "https://codeforces.com/blog/entry/106684", "VIDEO", "https://www.youtube.com/watch?v=n-WzX1mNnQk");
        addQ(t, "12. Make It Increasing", "EASY", "https://codeforces.com/problemset/problem/1675/B", "ARTICLE", "https://codeforces.com/blog/entry/102552", "VIDEO", "https://www.youtube.com/watch?v=zJg1RkG3F78");
        addQ(t, "13. Deletive Editing", "EASY", "https://codeforces.com/problemset/problem/1666/D", "ARTICLE", "https://codeforces.com/blog/entry/102148", "VIDEO", "https://www.youtube.com/watch?v=o0u9w7M7v6Y");
        addQ(t, "14. AvtoBus", "EASY", "https://codeforces.com/problemset/problem/1679/A", "ARTICLE", "https://codeforces.com/blog/entry/102834", "VIDEO", "https://www.youtube.com/watch?v=Geq60OVywsg");
        addQ(t, "15. Odd Grasshopper", "EASY", "https://codeforces.com/problemset/problem/1607/B", "ARTICLE", "https://codeforces.com/blog/entry/96564", "VIDEO", "https://www.youtube.com/watch?v=SqVfCyfCJqy");

        t = createTopic(s, "Rating 900 - Part 2");
        addQ(t, "16. AB Balance", "EASY", "https://codeforces.com/problemset/problem/1606/A", "ARTICLE", "https://codeforces.com/blog/entry/96402", "VIDEO", "https://www.youtube.com/watch?v=1aWhYEynZQw");
        addQ(t, "17. Exciting Bets", "EASY", "https://codeforces.com/problemset/problem/1543/A", "ARTICLE", "https://codeforces.com/blog/entry/92592", "VIDEO", "https://www.youtube.com/watch?v=lhW6eD00yX0");
        addQ(t, "18. Bad Boy", "EASY", "https://codeforces.com/problemset/problem/1537/B", "ARTICLE", "https://codeforces.com/blog/entry/91992", "VIDEO", "https://www.youtube.com/watch?v=fl8Y4e3fT4A");
        addQ(t, "19. Array Reordering", "EASY", "https://codeforces.com/problemset/problem/1535/B", "ARTICLE", "https://codeforces.com/blog/entry/91564", "VIDEO", "https://www.youtube.com/watch?v=35EQXmHKZYs");
        addQ(t, "20. Mocha and Math", "EASY", "https://codeforces.com/problemset/problem/1559/A", "ARTICLE", "https://codeforces.com/blog/entry/93902", "VIDEO", "https://www.youtube.com/watch?v=x-4z_GupYgA");
        addQ(t, "21. 01 Game", "EASY", "https://codeforces.com/problemset/problem/1373/B", "ARTICLE", "https://codeforces.com/blog/entry/79392", "VIDEO", "https://www.youtube.com/watch?v=c5wI2nIn2gU");
        addQ(t, "22. Multiply by 2, divide by 6", "EASY", "https://codeforces.com/problemset/problem/1374/B", "ARTICLE", "https://codeforces.com/blog/entry/79502", "VIDEO", "https://www.youtube.com/watch?v=K8r6jbgXk-A");
        addQ(t, "23. Make It Good", "EASY", "https://codeforces.com/problemset/problem/1385/C", "ARTICLE", "https://codeforces.com/blog/entry/80290", "VIDEO", "https://www.youtube.com/watch?v=R76n0brv5iU");
        addQ(t, "24. Construct a String", "EASY", "https://codeforces.com/problemset/problem/1335/B", "ARTICLE", "https://codeforces.com/blog/entry/76002", "VIDEO", "https://www.youtube.com/watch?v=b9O9NI-Fi3U");
        addQ(t, "25. Three Indices", "EASY", "https://codeforces.com/problemset/problem/1380/A", "ARTICLE", "https://codeforces.com/blog/entry/79992", "VIDEO", "https://www.youtube.com/watch?v=n-WzX1mNnQk");
        addQ(t, "26. Strange Partition", "EASY", "https://codeforces.com/problemset/problem/1471/A", "ARTICLE", "https://codeforces.com/blog/entry/86402", "VIDEO", "https://www.youtube.com/watch?v=zJg1RkG3F78");
        addQ(t, "27. Sum of Medians", "EASY", "https://codeforces.com/problemset/problem/1440/B", "ARTICLE", "https://codeforces.com/blog/entry/84702", "VIDEO", "https://www.youtube.com/watch?v=o0u9w7M7v6Y");
        addQ(t, "28. Non-Substring Subsequence", "EASY", "https://codeforces.com/problemset/problem/1451/B", "ARTICLE", "https://codeforces.com/blog/entry/85102", "VIDEO", "https://www.youtube.com/watch?v=Geq60OVywsg");
        addQ(t, "29. Unique Number", "EASY", "https://codeforces.com/problemset/problem/1462/C", "ARTICLE", "https://codeforces.com/blog/entry/85602", "VIDEO", "https://www.youtube.com/watch?v=SqVfCyfCJqy");
        addQ(t, "30. Candies and Two Sisters", "EASY", "https://codeforces.com/problemset/problem/1335/A", "ARTICLE", "https://codeforces.com/blog/entry/76002", "VIDEO", "https://www.youtube.com/watch?v=1aWhYEynZQw");

        // ==========================================
        // Section 3: Rating 1000
        // ==========================================
        s = createSection("Rating 1000 - Intermediate Problem Solving");

        t = createTopic(s, "Rating 1000 - Part 1");
        addQ(t, "1. Swap and Delete", "MEDIUM", "https://codeforces.com/problemset/problem/1913/B", "ARTICLE", "https://codeforces.com/blog/entry/123490", "VIDEO", "https://www.youtube.com/watch?v=SqVfCyfCJqy");
        addQ(t, "2. Raspberries", "MEDIUM", "https://codeforces.com/problemset/problem/1883/C", "ARTICLE", "https://codeforces.com/blog/entry/121664", "VIDEO", "https://www.youtube.com/watch?v=1aWhYEynZQw");
        addQ(t, "3. Helmets in Night Light", "MEDIUM", "https://codeforces.com/problemset/problem/1876/A", "ARTICLE", "https://codeforces.com/blog/entry/121002", "VIDEO", "https://www.youtube.com/watch?v=lhW6eD00yX0");
        addQ(t, "4. Olya and Game with Arrays", "MEDIUM", "https://codeforces.com/problemset/problem/1859/B", "ARTICLE", "https://codeforces.com/blog/entry/119280", "VIDEO", "https://www.youtube.com/watch?v=fl8Y4e3fT4A");
        addQ(t, "5. Monsters", "MEDIUM", "https://codeforces.com/problemset/problem/1849/B", "ARTICLE", "https://codeforces.com/blog/entry/118802", "VIDEO", "https://www.youtube.com/watch?v=35EQXmHKZYs");
        addQ(t, "6. Ski Resort", "MEDIUM", "https://codeforces.com/problemset/problem/1840/C", "ARTICLE", "https://codeforces.com/blog/entry/117102", "VIDEO", "https://www.youtube.com/watch?v=x-4z_GupYgA");
        addQ(t, "7. Array Merging", "MEDIUM", "https://codeforces.com/problemset/problem/1831/B", "ARTICLE", "https://codeforces.com/blog/entry/116742", "VIDEO", "https://www.youtube.com/watch?v=c5wI2nIn2gU");
        addQ(t, "8. Distinct Split", "MEDIUM", "https://codeforces.com/problemset/problem/1791/D", "ARTICLE", "https://codeforces.com/blog/entry/112390", "VIDEO", "https://www.youtube.com/watch?v=K8r6jbgXk-A");
        addQ(t, "9. Minimum LCM", "MEDIUM", "https://codeforces.com/problemset/problem/1765/M", "ARTICLE", "https://codeforces.com/blog/entry/110150", "VIDEO", "https://www.youtube.com/watch?v=R76n0brv5iU");
        addQ(t, "10. Traffic Light", "MEDIUM", "https://codeforces.com/problemset/problem/1744/C", "ARTICLE", "https://codeforces.com/blog/entry/108502", "VIDEO", "https://www.youtube.com/watch?v=b9O9NI-Fi3U");
        addQ(t, "11. Basketball Together", "MEDIUM", "https://codeforces.com/problemset/problem/1725/B", "ARTICLE", "https://codeforces.com/blog/entry/106602", "VIDEO", "https://www.youtube.com/watch?v=n-WzX1mNnQk");
        addQ(t, "12. Beautiful Array", "MEDIUM", "https://codeforces.com/problemset/problem/1715/B", "ARTICLE", "https://codeforces.com/blog/entry/106102", "VIDEO", "https://www.youtube.com/watch?v=zJg1RkG3F78");
        addQ(t, "13. Black and White Stripe", "MEDIUM", "https://codeforces.com/problemset/problem/1690/D", "ARTICLE", "https://codeforces.com/blog/entry/103802", "VIDEO", "https://www.youtube.com/watch?v=o0u9w7M7v6Y");
        addQ(t, "14. Red Versus Blue", "MEDIUM", "https://codeforces.com/problemset/problem/1659/A", "ARTICLE", "https://codeforces.com/blog/entry/101902", "VIDEO", "https://www.youtube.com/watch?v=Geq60OVywsg");
        addQ(t, "15. Double Sort", "MEDIUM", "https://codeforces.com/problemset/problem/1681/C", "ARTICLE", "https://codeforces.com/blog/entry/103102", "VIDEO", "https://www.youtube.com/watch?v=SqVfCyfCJqy");

        t = createTopic(s, "Rating 1000 - Part 2");
        addQ(t, "16. Roof Construction", "MEDIUM", "https://codeforces.com/problemset/problem/1632/B", "ARTICLE", "https://codeforces.com/blog/entry/99492", "VIDEO", "https://www.youtube.com/watch?v=1aWhYEynZQw");
        addQ(t, "17. Triangles on a Rectangle", "MEDIUM", "https://codeforces.com/problemset/problem/1620/B", "ARTICLE", "https://codeforces.com/blog/entry/98102", "VIDEO", "https://www.youtube.com/watch?v=lhW6eD00yX0");
        addQ(t, "18. Divan and a New Project", "MEDIUM", "https://codeforces.com/problemset/problem/1614/B", "ARTICLE", "https://codeforces.com/blog/entry/97202", "VIDEO", "https://www.youtube.com/watch?v=fl8Y4e3fT4A");
        addQ(t, "19. Reverse a Substring", "MEDIUM", "https://codeforces.com/problemset/problem/1155/A", "ARTICLE", "https://codeforces.com/blog/entry/66602", "VIDEO", "https://www.youtube.com/watch?v=35EQXmHKZYs");
        addQ(t, "20. Move Brackets", "MEDIUM", "https://codeforces.com/problemset/problem/1374/C", "ARTICLE", "https://codeforces.com/blog/entry/79502", "VIDEO", "https://www.youtube.com/watch?v=x-4z_GupYgA");
        addQ(t, "21. Add and Divide", "MEDIUM", "https://codeforces.com/problemset/problem/1485/A", "ARTICLE", "https://codeforces.com/blog/entry/87702", "VIDEO", "https://www.youtube.com/watch?v=c5wI2nIn2gU");
        addQ(t, "22. Different Divisors", "MEDIUM", "https://codeforces.com/problemset/problem/1474/B", "ARTICLE", "https://codeforces.com/blog/entry/86902", "VIDEO", "https://www.youtube.com/watch?v=K8r6jbgXk-A");
        addQ(t, "23. Card Constructions", "MEDIUM", "https://codeforces.com/problemset/problem/1345/B", "ARTICLE", "https://codeforces.com/blog/entry/77002", "VIDEO", "https://www.youtube.com/watch?v=R76n0brv5iU");
        addQ(t, "24. Buying Torches", "MEDIUM", "https://codeforces.com/problemset/problem/1418/A", "ARTICLE", "https://codeforces.com/blog/entry/82602", "VIDEO", "https://www.youtube.com/watch?v=b9O9NI-Fi3U");
        addQ(t, "25. Fair Numbers", "MEDIUM", "https://codeforces.com/problemset/problem/1411/A", "ARTICLE", "https://codeforces.com/blog/entry/82802", "VIDEO", "https://www.youtube.com/watch?v=n-WzX1mNnQk");
        addQ(t, "26. Valerii Against Everyone", "MEDIUM", "https://codeforces.com/problemset/problem/1438/B", "ARTICLE", "https://codeforces.com/blog/entry/84502", "VIDEO", "https://www.youtube.com/watch?v=zJg1RkG3F78");
        addQ(t, "27. Bogosort", "MEDIUM", "https://codeforces.com/problemset/problem/1312/B", "ARTICLE", "https://codeforces.com/blog/entry/74602", "VIDEO", "https://www.youtube.com/watch?v=o0u9w7M7v6Y");
        addQ(t, "28. Maximize", "MEDIUM", "https://codeforces.com/problemset/problem/1968/A", "ARTICLE", "https://codeforces.com/blog/entry/129102", "VIDEO", "https://www.youtube.com/watch?v=Geq60OVywsg");
        addQ(t, "29. Assembly via Remainders", "MEDIUM", "https://codeforces.com/problemset/problem/1968/C", "ARTICLE", "https://codeforces.com/blog/entry/129102", "VIDEO", "https://www.youtube.com/watch?v=SqVfCyfCJqy");
        addQ(t, "30. Binary Cut", "MEDIUM", "https://codeforces.com/problemset/problem/1971/D", "ARTICLE", "https://codeforces.com/blog/entry/129302", "VIDEO", "https://www.youtube.com/watch?v=1aWhYEynZQw");

        // ==========================================
        // Section 4: Rating 1100
        // ==========================================
        s = createSection("Rating 1100 - Upper Intermediate");

        t = createTopic(s, "Rating 1100 - Part 1");
        addQ(t, "1. Erase First or Second Letter", "MEDIUM", "https://codeforces.com/problemset/problem/1914/D", "ARTICLE", "https://codeforces.com/blog/entry/123612", "VIDEO", "https://www.youtube.com/watch?v=lhW6eD00yX0");
        addQ(t, "2. Quests", "MEDIUM", "https://codeforces.com/problemset/problem/1914/C", "ARTICLE", "https://codeforces.com/blog/entry/123612", "VIDEO", "https://www.youtube.com/watch?v=fl8Y4e3fT4A");
        addQ(t, "3. Collecting Game", "MEDIUM", "https://codeforces.com/problemset/problem/1904/B", "ARTICLE", "https://codeforces.com/blog/entry/123164", "VIDEO", "https://www.youtube.com/watch?v=35EQXmHKZYs");
        addQ(t, "4. Yarik and Array", "MEDIUM", "https://codeforces.com/problemset/problem/1810/B", "ARTICLE", "https://codeforces.com/blog/entry/114402", "VIDEO", "https://www.youtube.com/watch?v=x-4z_GupYgA");
        addQ(t, "5. 250 Thousand Tons of TNT", "MEDIUM", "https://codeforces.com/problemset/problem/1899/B", "ARTICLE", "https://codeforces.com/blog/entry/122394", "VIDEO", "https://www.youtube.com/watch?v=c5wI2nIn2gU");
        addQ(t, "6. Deja Vu", "MEDIUM", "https://codeforces.com/problemset/problem/1891/B", "ARTICLE", "https://codeforces.com/blog/entry/121852", "VIDEO", "https://www.youtube.com/watch?v=K8r6jbgXk-A");
        addQ(t, "7. Building an Aquarium", "MEDIUM", "https://codeforces.com/problemset/problem/1873/E", "ARTICLE", "https://codeforces.com/blog/entry/120612", "VIDEO", "https://www.youtube.com/watch?v=R76n0brv5iU");
        addQ(t, "8. 2D Traveling", "MEDIUM", "https://codeforces.com/problemset/problem/1798/B", "ARTICLE", "https://codeforces.com/blog/entry/113302", "VIDEO", "https://www.youtube.com/watch?v=b9O9NI-Fi3U");
        addQ(t, "9. Cardboard for Pictures", "MEDIUM", "https://codeforces.com/problemset/problem/1803/B", "ARTICLE", "https://codeforces.com/blog/entry/113902", "VIDEO", "https://www.youtube.com/watch?v=n-WzX1mNnQk");
        addQ(t, "10. Tenzing and Books", "MEDIUM", "https://codeforces.com/problemset/problem/1800/B", "ARTICLE", "https://codeforces.com/blog/entry/113702", "VIDEO", "https://www.youtube.com/watch?v=zJg1RkG3F78");
        addQ(t, "11. Maximum Sum", "MEDIUM", "https://codeforces.com/problemset/problem/1832/B", "ARTICLE", "https://codeforces.com/blog/entry/116390", "VIDEO", "https://www.youtube.com/watch?v=o0u9w7M7v6Y");
        addQ(t, "12. Counting Orders", "MEDIUM", "https://codeforces.com/problemset/problem/1828/C", "ARTICLE", "https://codeforces.com/blog/entry/116212", "VIDEO", "https://www.youtube.com/watch?v=Geq60OVywsg");
        addQ(t, "13. Lunatic Never Content", "MEDIUM", "https://codeforces.com/problemset/problem/1798/A", "ARTICLE", "https://codeforces.com/blog/entry/113302", "VIDEO", "https://www.youtube.com/watch?v=SqVfCyfCJqy");
        addQ(t, "14. Sort the Subarray", "MEDIUM", "https://codeforces.com/problemset/problem/1821/C", "ARTICLE", "https://codeforces.com/blog/entry/115302", "VIDEO", "https://www.youtube.com/watch?v=1aWhYEynZQw");
        addQ(t, "15. JoJo's Incredible Adventures", "MEDIUM", "https://codeforces.com/problemset/problem/1821/B", "ARTICLE", "https://codeforces.com/blog/entry/115302", "VIDEO", "https://www.youtube.com/watch?v=lhW6eD00yX0");

        t = createTopic(s, "Rating 1100 - Part 2");
        addQ(t, "16. Subsequence Addition", "MEDIUM", "https://codeforces.com/problemset/problem/1787/C", "ARTICLE", "https://codeforces.com/blog/entry/112502", "VIDEO", "https://www.youtube.com/watch?v=fl8Y4e3fT4A");
        addQ(t, "17. Li Hua and Pattern", "MEDIUM", "https://codeforces.com/problemset/problem/1797/B", "ARTICLE", "https://codeforces.com/blog/entry/113102", "VIDEO", "https://www.youtube.com/watch?v=35EQXmHKZYs");
        addQ(t, "18. Teleporters Easy Version", "MEDIUM", "https://codeforces.com/problemset/problem/1791/C", "ARTICLE", "https://codeforces.com/blog/entry/112390", "VIDEO", "https://www.youtube.com/watch?v=x-4z_GupYgA");
        addQ(t, "19. Negatives and Positives", "MEDIUM", "https://codeforces.com/problemset/problem/1791/E", "ARTICLE", "https://codeforces.com/blog/entry/112390", "VIDEO", "https://www.youtube.com/watch?v=c5wI2nIn2gU");
        addQ(t, "20. GCD Partition", "MEDIUM", "https://codeforces.com/problemset/problem/1804/B", "ARTICLE", "https://codeforces.com/blog/entry/114102", "VIDEO", "https://www.youtube.com/watch?v=K8r6jbgXk-A");
        addQ(t, "21. Coprime", "MEDIUM", "https://codeforces.com/problemset/problem/1811/B", "ARTICLE", "https://codeforces.com/blog/entry/114502", "VIDEO", "https://www.youtube.com/watch?v=R76n0brv5iU");
        addQ(t, "22. Kill Demodogs", "MEDIUM", "https://codeforces.com/problemset/problem/1794/D", "ARTICLE", "https://codeforces.com/blog/entry/113002", "VIDEO", "https://www.youtube.com/watch?v=b9O9NI-Fi3U");
        addQ(t, "23. Difference of GCDs", "MEDIUM", "https://codeforces.com/problemset/problem/1800/C", "ARTICLE", "https://codeforces.com/blog/entry/113702", "VIDEO", "https://www.youtube.com/watch?v=n-WzX1mNnQk");
        addQ(t, "24. AND Sorting", "MEDIUM", "https://codeforces.com/problemset/problem/1799/C", "ARTICLE", "https://codeforces.com/blog/entry/113602", "VIDEO", "https://www.youtube.com/watch?v=zJg1RkG3F78");
        addQ(t, "25. A Perfectly Balanced String", "MEDIUM", "https://codeforces.com/problemset/problem/1805/B", "ARTICLE", "https://codeforces.com/blog/entry/114390", "VIDEO", "https://www.youtube.com/watch?v=o0u9w7M7v6Y");
        addQ(t, "26. Eating Candies", "MEDIUM", "https://codeforces.com/problemset/problem/1795/C", "ARTICLE", "https://codeforces.com/blog/entry/113102", "VIDEO", "https://www.youtube.com/watch?v=Geq60OVywsg");
        addQ(t, "27. Subtract Operation", "MEDIUM", "https://codeforces.com/problemset/problem/1802/B", "ARTICLE", "https://codeforces.com/blog/entry/113802", "VIDEO", "https://www.youtube.com/watch?v=SqVfCyfCJqy");
        addQ(t, "28. Fun with Even Subarrays", "MEDIUM", "https://codeforces.com/problemset/problem/1792/D", "ARTICLE", "https://codeforces.com/blog/entry/112702", "VIDEO", "https://www.youtube.com/watch?v=1aWhYEynZQw");
        addQ(t, "29. Paint the Array", "MEDIUM", "https://codeforces.com/problemset/problem/1814/C", "ARTICLE", "https://codeforces.com/blog/entry/114674", "VIDEO", "https://www.youtube.com/watch?v=lhW6eD00yX0");
        addQ(t, "30. Kalindrome Array", "MEDIUM", "https://codeforces.com/problemset/problem/1826/C", "ARTICLE", "https://codeforces.com/blog/entry/116102", "VIDEO", "https://www.youtube.com/watch?v=fl8Y4e3fT4A");

        // ==========================================
        // Section 5: Rating 1200
        // ==========================================
        s = createSection("Rating 1200 - Advanced");

        t = createTopic(s, "Rating 1200 - Part 1");
        addQ(t, "1. Three Activities", "MEDIUM", "https://codeforces.com/problemset/problem/1914/D", "ARTICLE", "https://codeforces.com/blog/entry/123612", "VIDEO", "https://www.youtube.com/watch?v=35EQXmHKZYs");
        addQ(t, "2. Make Almost Equal With Mod", "MEDIUM", "https://codeforces.com/problemset/problem/1909/B", "ARTICLE", "https://codeforces.com/blog/entry/123802", "VIDEO", "https://www.youtube.com/watch?v=x-4z_GupYgA");
        addQ(t, "3. Plus Minus Permutation", "MEDIUM", "https://codeforces.com/problemset/problem/1872/D", "ARTICLE", "https://codeforces.com/blog/entry/120150", "VIDEO", "https://www.youtube.com/watch?v=c5wI2nIn2gU");
        addQ(t, "4. Assembly via Minimums", "MEDIUM", "https://codeforces.com/problemset/problem/1857/C", "ARTICLE", "https://codeforces.com/blog/entry/119102", "VIDEO", "https://www.youtube.com/watch?v=K8r6jbgXk-A");
        addQ(t, "5. Vika and the Bridge", "MEDIUM", "https://codeforces.com/problemset/problem/1848/B", "ARTICLE", "https://codeforces.com/blog/entry/118228", "VIDEO", "https://www.youtube.com/watch?v=R76n0brv5iU");
        addQ(t, "6. Contrast Value", "MEDIUM", "https://codeforces.com/problemset/problem/1832/C", "ARTICLE", "https://codeforces.com/blog/entry/116390", "VIDEO", "https://www.youtube.com/watch?v=b9O9NI-Fi3U");
        addQ(t, "7. Playing in a Casino", "MEDIUM", "https://codeforces.com/problemset/problem/1823/C", "ARTICLE", "https://codeforces.com/blog/entry/115502", "VIDEO", "https://www.youtube.com/watch?v=n-WzX1mNnQk");
        addQ(t, "8. Dora and Search", "MEDIUM", "https://codeforces.com/problemset/problem/1801/A", "ARTICLE", "https://codeforces.com/blog/entry/113802", "VIDEO", "https://www.youtube.com/watch?v=zJg1RkG3F78");
        addQ(t, "9. Matryoshkas", "MEDIUM", "https://codeforces.com/problemset/problem/1790/D", "ARTICLE", "https://codeforces.com/blog/entry/112102", "VIDEO", "https://www.youtube.com/watch?v=o0u9w7M7v6Y");
        addQ(t, "10. Scuza", "MEDIUM", "https://codeforces.com/problemset/problem/1807/F", "ARTICLE", "https://codeforces.com/blog/entry/114002", "VIDEO", "https://www.youtube.com/watch?v=Geq60OVywsg");
        addQ(t, "11. Removing Smallest Multiples", "MEDIUM", "https://codeforces.com/problemset/problem/1822/C", "ARTICLE", "https://codeforces.com/blog/entry/115402", "VIDEO", "https://www.youtube.com/watch?v=SqVfCyfCJqy");
        addQ(t, "12. Friends and the Restaurant", "MEDIUM", "https://codeforces.com/problemset/problem/1813/C", "ARTICLE", "https://codeforces.com/blog/entry/114602", "VIDEO", "https://www.youtube.com/watch?v=1aWhYEynZQw");
        addQ(t, "13. Virus", "MEDIUM", "https://codeforces.com/problemset/problem/1704/C", "ARTICLE", "https://codeforces.com/blog/entry/105402", "VIDEO", "https://www.youtube.com/watch?v=lhW6eD00yX0");
        addQ(t, "14. Mirror Grid", "MEDIUM", "https://codeforces.com/problemset/problem/1787/B", "ARTICLE", "https://codeforces.com/blog/entry/112502", "VIDEO", "https://www.youtube.com/watch?v=fl8Y4e3fT4A");
        addQ(t, "15. Binary Deque", "MEDIUM", "https://codeforces.com/problemset/problem/1788/B", "ARTICLE", "https://codeforces.com/blog/entry/112674", "VIDEO", "https://www.youtube.com/watch?v=35EQXmHKZYs");

        t = createTopic(s, "Rating 1200 - Part 2");
        addQ(t, "16. Stone Age Problem", "MEDIUM", "https://codeforces.com/problemset/problem/1779/B", "ARTICLE", "https://codeforces.com/blog/entry/111702", "VIDEO", "https://www.youtube.com/watch?v=x-4z_GupYgA");
        addQ(t, "17. Dolce Vita", "MEDIUM", "https://codeforces.com/problemset/problem/1762/C", "ARTICLE", "https://codeforces.com/blog/entry/109702", "VIDEO", "https://www.youtube.com/watch?v=c5wI2nIn2gU");
        addQ(t, "18. Differential Sorting", "MEDIUM", "https://codeforces.com/problemset/problem/1635/C", "ARTICLE", "https://codeforces.com/blog/entry/99902", "VIDEO", "https://www.youtube.com/watch?v=K8r6jbgXk-A");
        addQ(t, "19. Make Them Equal", "MEDIUM", "https://codeforces.com/problemset/problem/1594/C", "ARTICLE", "https://codeforces.com/blog/entry/95802", "VIDEO", "https://www.youtube.com/watch?v=R76n0brv5iU");
        addQ(t, "20. Grandma Capa Knits a Scarf", "MEDIUM", "https://codeforces.com/problemset/problem/1607/D", "ARTICLE", "https://codeforces.com/blog/entry/96564", "VIDEO", "https://www.youtube.com/watch?v=b9O9NI-Fi3U");
        addQ(t, "21. Pleasant Pairs", "MEDIUM", "https://codeforces.com/problemset/problem/1814/B", "ARTICLE", "https://codeforces.com/blog/entry/114674", "VIDEO", "https://www.youtube.com/watch?v=n-WzX1mNnQk");
        addQ(t, "22. Stable Groups", "MEDIUM", "https://codeforces.com/problemset/problem/1575/D", "ARTICLE", "https://codeforces.com/blog/entry/94802", "VIDEO", "https://www.youtube.com/watch?v=zJg1RkG3F78");
        addQ(t, "23. Prinzessin der Verurteilung", "MEDIUM", "https://codeforces.com/problemset/problem/1747/B", "ARTICLE", "https://codeforces.com/blog/entry/108802", "VIDEO", "https://www.youtube.com/watch?v=o0u9w7M7v6Y");
        addQ(t, "24. Palindrome Game easy version", "MEDIUM", "https://codeforces.com/problemset/problem/1755/D", "ARTICLE", "https://codeforces.com/blog/entry/109102", "VIDEO", "https://www.youtube.com/watch?v=Geq60OVywsg");
        addQ(t, "25. Same Differences", "MEDIUM", "https://codeforces.com/problemset/problem/1520/D", "ARTICLE", "https://codeforces.com/blog/entry/91102", "VIDEO", "https://www.youtube.com/watch?v=SqVfCyfCJqy");
        addQ(t, "26. AND 0 Sum Big", "MEDIUM", "https://codeforces.com/problemset/problem/1754/C", "ARTICLE", "https://codeforces.com/blog/entry/109002", "VIDEO", "https://www.youtube.com/watch?v=1aWhYEynZQw");
        addQ(t, "27. Flip the Bits", "MEDIUM", "https://codeforces.com/problemset/problem/1780/B", "ARTICLE", "https://codeforces.com/blog/entry/111802", "VIDEO", "https://www.youtube.com/watch?v=lhW6eD00yX0");
        addQ(t, "28. M-Arrays", "MEDIUM", "https://codeforces.com/problemset/problem/1763/B", "ARTICLE", "https://codeforces.com/blog/entry/109802", "VIDEO", "https://www.youtube.com/watch?v=fl8Y4e3fT4A");
        addQ(t, "29. Cat cycle", "MEDIUM", "https://codeforces.com/problemset/problem/1768/D", "ARTICLE", "https://codeforces.com/blog/entry/110302", "VIDEO", "https://www.youtube.com/watch?v=35EQXmHKZYs");
        addQ(t, "30. Districts Connection", "MEDIUM", "https://codeforces.com/problemset/problem/1359/D", "ARTICLE", "https://codeforces.com/blog/entry/77602", "VIDEO", "https://www.youtube.com/watch?v=x-4z_GupYgA");

        // ==========================================
        // Section 6: Rating 1300-1400
        // ==========================================
        s = createSection("Rating 1300 - 1400 - Expert Problems");

        t = createTopic(s, "Rating 1300 - Part 1");
        addQ(t, "1. Divisible Pairs", "HARD", "https://codeforces.com/problemset/problem/1931/D", "ARTICLE", "https://codeforces.com/blog/entry/125802", "VIDEO", "https://www.youtube.com/watch?v=c5wI2nIn2gU");
        addQ(t, "2. Find the Different Ones!", "HARD", "https://codeforces.com/problemset/problem/1927/D", "ARTICLE", "https://codeforces.com/blog/entry/125402", "VIDEO", "https://www.youtube.com/watch?v=K8r6jbgXk-A");
        addQ(t, "3. Romantic Glasses", "HARD", "https://codeforces.com/problemset/problem/1926/D", "ARTICLE", "https://codeforces.com/blog/entry/125302", "VIDEO", "https://www.youtube.com/watch?v=R76n0brv5iU");
        addQ(t, "4. Divide and Equalize", "HARD", "https://codeforces.com/problemset/problem/1916/C", "ARTICLE", "https://codeforces.com/blog/entry/124002", "VIDEO", "https://www.youtube.com/watch?v=b9O9NI-Fi3U");
        addQ(t, "5. Make it Alternating", "HARD", "https://codeforces.com/problemset/problem/1879/C", "ARTICLE", "https://codeforces.com/blog/entry/120786", "VIDEO", "https://www.youtube.com/watch?v=n-WzX1mNnQk");
        addQ(t, "6. Strong Vertices", "HARD", "https://codeforces.com/problemset/problem/1686/B", "ARTICLE", "https://codeforces.com/blog/entry/103502", "VIDEO", "https://www.youtube.com/watch?v=zJg1RkG3F78");
        addQ(t, "7. Rudolf and Snowflakes simple version", "HARD", "https://codeforces.com/problemset/problem/1878/C", "ARTICLE", "https://codeforces.com/blog/entry/120786", "VIDEO", "https://www.youtube.com/watch?v=o0u9w7M7v6Y");
        addQ(t, "8. Scoring Subsequences", "HARD", "https://codeforces.com/problemset/problem/1903/C", "ARTICLE", "https://codeforces.com/blog/entry/122934", "VIDEO", "https://www.youtube.com/watch?v=Geq60OVywsg");
        addQ(t, "9. Gardener and the Array", "HARD", "https://codeforces.com/problemset/problem/1900/B", "ARTICLE", "https://codeforces.com/blog/entry/122616", "VIDEO", "https://www.youtube.com/watch?v=SqVfCyfCJqy");
        addQ(t, "10. Yet Another Problem About Pairs Satisfying an Inequality", "HARD", "https://codeforces.com/problemset/problem/1892/E", "ARTICLE", "https://codeforces.com/blog/entry/121952", "VIDEO", "https://www.youtube.com/watch?v=1aWhYEynZQw");
        addQ(t, "11. White-Black Balanced Subtrees", "HARD", "https://codeforces.com/problemset/problem/1674/D", "ARTICLE", "https://codeforces.com/blog/entry/102452", "VIDEO", "https://www.youtube.com/watch?v=lhW6eD00yX0");
        addQ(t, "12. Maximal AND", "HARD", "https://codeforces.com/problemset/problem/1669/C", "ARTICLE", "https://codeforces.com/blog/entry/102248", "VIDEO", "https://www.youtube.com/watch?v=fl8Y4e3fT4A");
        addQ(t, "13. Chat Ban", "HARD", "https://codeforces.com/problemset/problem/1612/C", "ARTICLE", "https://codeforces.com/blog/entry/97102", "VIDEO", "https://www.youtube.com/watch?v=35EQXmHKZYs");
        addQ(t, "14. Array Elimination", "HARD", "https://codeforces.com/problemset/problem/1602/C", "ARTICLE", "https://codeforces.com/blog/entry/96302", "VIDEO", "https://www.youtube.com/watch?v=x-4z_GupYgA");
        addQ(t, "15. Deep Down Below", "HARD", "https://codeforces.com/problemset/problem/1561/C", "ARTICLE", "https://codeforces.com/blog/entry/94102", "VIDEO", "https://www.youtube.com/watch?v=c5wI2nIn2gU");

        t = createTopic(s, "Rating 1400 - Part 2");
        addQ(t, "16. Box Fitting", "HARD", "https://codeforces.com/problemset/problem/1512/G", "ARTICLE", "https://codeforces.com/blog/entry/90602", "VIDEO", "https://www.youtube.com/watch?v=K8r6jbgXk-A");
        addQ(t, "17. Strange Birthday Party", "HARD", "https://codeforces.com/problemset/problem/1671/D", "ARTICLE", "https://codeforces.com/blog/entry/102348", "VIDEO", "https://www.youtube.com/watch?v=R76n0brv5iU");
        addQ(t, "18. Move and Turn", "HARD", "https://codeforces.com/problemset/problem/1667/D", "ARTICLE", "https://codeforces.com/blog/entry/102148", "VIDEO", "https://www.youtube.com/watch?v=b9O9NI-Fi3U");
        addQ(t, "19. Omkar and Last Class of Math", "HARD", "https://codeforces.com/problemset/problem/1672/D", "ARTICLE", "https://codeforces.com/blog/entry/102348", "VIDEO", "https://www.youtube.com/watch?v=n-WzX1mNnQk");
        addQ(t, "20. Shuffle", "HARD", "https://codeforces.com/problemset/problem/1673/B", "ARTICLE", "https://codeforces.com/blog/entry/102448", "VIDEO", "https://www.youtube.com/watch?v=zJg1RkG3F78");
        addQ(t, "21. Most socially-distanced subsequence", "HARD", "https://codeforces.com/problemset/problem/1563/B", "ARTICLE", "https://codeforces.com/blog/entry/94202", "VIDEO", "https://www.youtube.com/watch?v=o0u9w7M7v6Y");
        addQ(t, "22. Buying Shovels", "HARD", "https://codeforces.com/problemset/problem/1603/D", "ARTICLE", "https://codeforces.com/blog/entry/96402", "VIDEO", "https://www.youtube.com/watch?v=Geq60OVywsg");
        addQ(t, "23. Product of three numbers", "HARD", "https://codeforces.com/problemset/problem/1294/C", "ARTICLE", "https://codeforces.com/blog/entry/73390", "VIDEO", "https://www.youtube.com/watch?v=SqVfCyfCJqy");
        addQ(t, "24. Just Eat It!", "HARD", "https://codeforces.com/problemset/problem/1615/C", "ARTICLE", "https://codeforces.com/blog/entry/97302", "VIDEO", "https://www.youtube.com/watch?v=1aWhYEynZQw");
        addQ(t, "25. Balanced Tunnel", "HARD", "https://codeforces.com/problemset/problem/1644/B", "ARTICLE", "https://codeforces.com/blog/entry/100302", "VIDEO", "https://www.youtube.com/watch?v=lhW6eD00yX0");
        addQ(t, "26. WOW Factor", "HARD", "https://codeforces.com/problemset/problem/1651/B", "ARTICLE", "https://codeforces.com/blog/entry/100802", "VIDEO", "https://www.youtube.com/watch?v=fl8Y4e3fT4A");
        addQ(t, "27. Alyona and a Narrow Fridge", "HARD", "https://codeforces.com/problemset/problem/1467/B", "ARTICLE", "https://codeforces.com/blog/entry/86102", "VIDEO", "https://www.youtube.com/watch?v=35EQXmHKZYs");
        addQ(t, "28. Good Array", "HARD", "https://codeforces.com/problemset/problem/1534/D", "ARTICLE", "https://codeforces.com/blog/entry/91464", "VIDEO", "https://www.youtube.com/watch?v=x-4z_GupYgA");
        addQ(t, "29. Mahmoud and Ehab and the bipartiteness", "HARD", "https://codeforces.com/problemset/problem/862/B", "ARTICLE", "https://codeforces.com/blog/entry/43719", "VIDEO", "https://www.youtube.com/watch?v=c5wI2nIn2gU");
        addQ(t, "30. Average Sleep Time", "HARD", "https://codeforces.com/problemset/problem/1570/D", "ARTICLE", "https://codeforces.com/blog/entry/94602", "VIDEO", "https://www.youtube.com/watch?v=K8r6jbgXk-A");

        // ==========================================
        // Section 7: Rating 1500-1600
        // ==========================================
        s = createSection("Rating 1500 - 1600 - Master Problems");

        t = createTopic(s, "Rating 1500 - Part 1");
        addQ(t, "1. Greetings", "HARD", "https://codeforces.com/problemset/problem/1915/F", "ARTICLE", "https://codeforces.com/blog/entry/123890", "VIDEO", "https://www.youtube.com/watch?v=R76n0brv5iU");
        addQ(t, "2. Smilo and Monsters", "HARD", "https://codeforces.com/problemset/problem/1891/C", "ARTICLE", "https://codeforces.com/blog/entry/121852", "VIDEO", "https://www.youtube.com/watch?v=b9O9NI-Fi3U");
        addQ(t, "3. Block Sequence", "HARD", "https://codeforces.com/problemset/problem/1881/E", "ARTICLE", "https://codeforces.com/blog/entry/121287", "VIDEO", "https://www.youtube.com/watch?v=n-WzX1mNnQk");
        addQ(t, "4. Data Structures Fan", "HARD", "https://codeforces.com/problemset/problem/1872/E", "ARTICLE", "https://codeforces.com/blog/entry/120150", "VIDEO", "https://www.youtube.com/watch?v=zJg1RkG3F78");
        addQ(t, "5. Tea Tasting", "HARD", "https://codeforces.com/problemset/problem/1845/F", "ARTICLE", "https://codeforces.com/blog/entry/117764", "VIDEO", "https://www.youtube.com/watch?v=o0u9w7M7v6Y");
        addQ(t, "6. Controllers", "HARD", "https://codeforces.com/problemset/problem/1829/D", "ARTICLE", "https://codeforces.com/blog/entry/116102", "VIDEO", "https://www.youtube.com/watch?v=Geq60OVywsg");
        addQ(t, "7. Palindrome Basis", "HARD", "https://codeforces.com/problemset/problem/1526/F", "ARTICLE", "https://codeforces.com/blog/entry/90802", "VIDEO", "https://www.youtube.com/watch?v=SqVfCyfCJqy");
        addQ(t, "8. Line Empire", "HARD", "https://codeforces.com/problemset/problem/1555/D", "ARTICLE", "https://codeforces.com/blog/entry/93702", "VIDEO", "https://www.youtube.com/watch?v=1aWhYEynZQw");
        addQ(t, "9. Factorials and Powers of Two", "HARD", "https://codeforces.com/problemset/problem/1557/E", "ARTICLE", "https://codeforces.com/blog/entry/93902", "VIDEO", "https://www.youtube.com/watch?v=lhW6eD00yX0");
        addQ(t, "10. AGAGA XOOORRR", "HARD", "https://codeforces.com/problemset/problem/1547/E", "ARTICLE", "https://codeforces.com/blog/entry/92992", "VIDEO", "https://www.youtube.com/watch?v=fl8Y4e3fT4A");
        addQ(t, "11. Eastern Exhibition", "HARD", "https://codeforces.com/problemset/problem/1549/F", "ARTICLE", "https://codeforces.com/blog/entry/93202", "VIDEO", "https://www.youtube.com/watch?v=35EQXmHKZYs");
        addQ(t, "12. 13th Labour of Heracles", "HARD", "https://codeforces.com/problemset/problem/1502/D", "ARTICLE", "https://codeforces.com/blog/entry/89602", "VIDEO", "https://www.youtube.com/watch?v=x-4z_GupYgA");
        addQ(t, "13. Mortal Kombat Tower", "HARD", "https://codeforces.com/problemset/problem/1507/D", "ARTICLE", "https://codeforces.com/blog/entry/89902", "VIDEO", "https://www.youtube.com/watch?v=c5wI2nIn2gU");
        addQ(t, "14. k-Amazing Numbers", "HARD", "https://codeforces.com/problemset/problem/1498/E", "ARTICLE", "https://codeforces.com/blog/entry/89502", "VIDEO", "https://www.youtube.com/watch?v=K8r6jbgXk-A");
        addQ(t, "15. Balanced Bitstring", "HARD", "https://codeforces.com/problemset/problem/1553/D", "ARTICLE", "https://codeforces.com/blog/entry/93502", "VIDEO", "https://www.youtube.com/watch?v=R76n0brv5iU");

        t = createTopic(s, "Rating 1600 - Part 2");
        addQ(t, "16. Powered Addition", "HARD", "https://codeforces.com/problemset/problem/1548/C", "ARTICLE", "https://codeforces.com/blog/entry/93102", "VIDEO", "https://www.youtube.com/watch?v=b9O9NI-Fi3U");
        addQ(t, "17. K-Complete Word", "HARD", "https://codeforces.com/problemset/problem/1546/D", "ARTICLE", "https://codeforces.com/blog/entry/92892", "VIDEO", "https://www.youtube.com/watch?v=n-WzX1mNnQk");
        addQ(t, "18. Ehab and Path-etic MEXs", "HARD", "https://codeforces.com/problemset/problem/1474/D", "ARTICLE", "https://codeforces.com/blog/entry/86902", "VIDEO", "https://www.youtube.com/watch?v=zJg1RkG3F78");
        addQ(t, "19. Count Subrectangles", "HARD", "https://codeforces.com/problemset/problem/1535/D", "ARTICLE", "https://codeforces.com/blog/entry/91564", "VIDEO", "https://www.youtube.com/watch?v=o0u9w7M7v6Y");
        addQ(t, "20. Zero Array", "HARD", "https://codeforces.com/problemset/problem/1497/D", "ARTICLE", "https://codeforces.com/blog/entry/89402", "VIDEO", "https://www.youtube.com/watch?v=Geq60OVywsg");
        addQ(t, "21. Edgy Trees", "HARD", "https://codeforces.com/problemset/problem/1496/E", "ARTICLE", "https://codeforces.com/blog/entry/89302", "VIDEO", "https://www.youtube.com/watch?v=SqVfCyfCJqy");
        addQ(t, "22. Zero Quantity Maximization", "HARD", "https://codeforces.com/problemset/problem/1491/D", "ARTICLE", "https://codeforces.com/blog/entry/87902", "VIDEO", "https://www.youtube.com/watch?v=1aWhYEynZQw");
        addQ(t, "23. Lunar New Year and a Wander", "HARD", "https://codeforces.com/problemset/problem/1495/D", "ARTICLE", "https://codeforces.com/blog/entry/89202", "VIDEO", "https://www.youtube.com/watch?v=lhW6eD00yX0");
        addQ(t, "24. Division and Union", "HARD", "https://codeforces.com/problemset/problem/1486/E", "ARTICLE", "https://codeforces.com/blog/entry/87802", "VIDEO", "https://www.youtube.com/watch?v=fl8Y4e3fT4A");
        addQ(t, "25. The Fair Nut and String", "HARD", "https://codeforces.com/problemset/problem/1484/D", "ARTICLE", "https://codeforces.com/blog/entry/87602", "VIDEO", "https://www.youtube.com/watch?v=35EQXmHKZYs");
        addQ(t, "26. Cut em all!", "HARD", "https://codeforces.com/problemset/problem/1480/B", "ARTICLE", "https://codeforces.com/blog/entry/87302", "VIDEO", "https://www.youtube.com/watch?v=x-4z_GupYgA");
        addQ(t, "27. Nested Segments", "HARD", "https://codeforces.com/problemset/problem/1547/F", "ARTICLE", "https://codeforces.com/blog/entry/92992", "VIDEO", "https://www.youtube.com/watch?v=c5wI2nIn2gU");
        addQ(t, "28. Minimize the error", "HARD", "https://codeforces.com/problemset/problem/1537/D", "ARTICLE", "https://codeforces.com/blog/entry/91992", "VIDEO", "https://www.youtube.com/watch?v=K8r6jbgXk-A");
        addQ(t, "29. Pride", "HARD", "https://codeforces.com/problemset/problem/1514/D", "ARTICLE", "https://codeforces.com/blog/entry/90302", "VIDEO", "https://www.youtube.com/watch?v=R76n0brv5iU");
        addQ(t, "30. Two TVs", "HARD", "https://codeforces.com/problemset/problem/1511/E", "ARTICLE", "https://codeforces.com/blog/entry/90502", "VIDEO", "https://www.youtube.com/watch?v=b9O9NI-Fi3U");

        // ==========================================
        // Section 8: Rating 1700+
        // ==========================================
        s = createSection("Rating 1700+ - Elite Problems");

        t = createTopic(s, "Rating 1700");
        addQ(t, "1. Maximum modulo equality", "HARD", "https://codeforces.com/problemset/problem/1465/D", "ARTICLE", "https://codeforces.com/blog/entry/85702", "VIDEO", "https://www.youtube.com/watch?v=n-WzX1mNnQk");
        addQ(t, "2. Drunken Maze", "HARD", "https://codeforces.com/problemset/problem/1458/E", "ARTICLE", "https://codeforces.com/blog/entry/85402", "VIDEO", "https://www.youtube.com/watch?v=zJg1RkG3F78");
        addQ(t, "3. Tree Pruning", "HARD", "https://codeforces.com/problemset/problem/1455/E", "ARTICLE", "https://codeforces.com/blog/entry/85302", "VIDEO", "https://www.youtube.com/watch?v=o0u9w7M7v6Y");
        addQ(t, "4. Iris and Game on the Tree", "HARD", "https://codeforces.com/problemset/problem/1454/F", "ARTICLE", "https://codeforces.com/blog/entry/85202", "VIDEO", "https://www.youtube.com/watch?v=Geq60OVywsg");
        addQ(t, "5. Ruler hard version", "HARD", "https://codeforces.com/problemset/problem/1450/F", "ARTICLE", "https://codeforces.com/blog/entry/85002", "VIDEO", "https://www.youtube.com/watch?v=SqVfCyfCJqy");
        addQ(t, "6. Swap Dilemma", "HARD", "https://codeforces.com/problemset/problem/1445/D", "ARTICLE", "https://codeforces.com/blog/entry/84702", "VIDEO", "https://www.youtube.com/watch?v=1aWhYEynZQw");
        addQ(t, "7. Beauty of the mountains", "HARD", "https://codeforces.com/problemset/problem/1444/D", "ARTICLE", "https://codeforces.com/blog/entry/84602", "VIDEO", "https://www.youtube.com/watch?v=lhW6eD00yX0");
        addQ(t, "8. Tandem Repeats", "HARD", "https://codeforces.com/problemset/problem/1440/D", "ARTICLE", "https://codeforces.com/blog/entry/84702", "VIDEO", "https://www.youtube.com/watch?v=fl8Y4e3fT4A");
        addQ(t, "9. Chat Screenshots", "HARD", "https://codeforces.com/problemset/problem/1438/D", "ARTICLE", "https://codeforces.com/blog/entry/84502", "VIDEO", "https://www.youtube.com/watch?v=35EQXmHKZYs");
        addQ(t, "10. Neutral Tonality", "HARD", "https://codeforces.com/problemset/problem/1436/D", "ARTICLE", "https://codeforces.com/blog/entry/84402", "VIDEO", "https://www.youtube.com/watch?v=x-4z_GupYgA");
        addQ(t, "11. Sum of XOR Functions", "HARD", "https://codeforces.com/problemset/problem/1425/H", "ARTICLE", "https://codeforces.com/blog/entry/83402", "VIDEO", "https://www.youtube.com/watch?v=c5wI2nIn2gU");
        addQ(t, "12. Ira and Flamenco", "HARD", "https://codeforces.com/problemset/problem/1423/J", "ARTICLE", "https://codeforces.com/blog/entry/83202", "VIDEO", "https://www.youtube.com/watch?v=K8r6jbgXk-A");
        addQ(t, "13. Don't Blame Me", "HARD", "https://codeforces.com/problemset/problem/1415/G", "ARTICLE", "https://codeforces.com/blog/entry/82902", "VIDEO", "https://www.youtube.com/watch?v=R76n0brv5iU");
        addQ(t, "14. Running Miles", "HARD", "https://codeforces.com/problemset/problem/1406/E", "ARTICLE", "https://codeforces.com/blog/entry/82202", "VIDEO", "https://www.youtube.com/watch?v=b9O9NI-Fi3U");
        addQ(t, "15. Magic Triples Easy Version", "HARD", "https://codeforces.com/problemset/problem/1401/D", "ARTICLE", "https://codeforces.com/blog/entry/81902", "VIDEO", "https://www.youtube.com/watch?v=n-WzX1mNnQk");

        t = createTopic(s, "Rating 1800+");
        addQ(t, "16. Fixed Prefix Permutations", "HARD", "https://codeforces.com/problemset/problem/1396/E", "ARTICLE", "https://codeforces.com/blog/entry/81702", "VIDEO", "https://www.youtube.com/watch?v=zJg1RkG3F78");
        addQ(t, "17. Quiz Master", "HARD", "https://codeforces.com/problemset/problem/1390/D", "ARTICLE", "https://codeforces.com/blog/entry/81402", "VIDEO", "https://www.youtube.com/watch?v=o0u9w7M7v6Y");
        addQ(t, "18. SlavicG's Favorite Problem", "HARD", "https://codeforces.com/problemset/problem/1379/D", "ARTICLE", "https://codeforces.com/blog/entry/80790", "VIDEO", "https://www.youtube.com/watch?v=Geq60OVywsg");
        addQ(t, "19. Meta-set", "HARD", "https://codeforces.com/problemset/problem/1368/D", "ARTICLE", "https://codeforces.com/blog/entry/80390", "VIDEO", "https://www.youtube.com/watch?v=SqVfCyfCJqy");
        addQ(t, "20. Even Subarrays", "HARD", "https://codeforces.com/problemset/problem/1358/D", "ARTICLE", "https://codeforces.com/blog/entry/77502", "VIDEO", "https://www.youtube.com/watch?v=1aWhYEynZQw");
        addQ(t, "21. Monoblock", "HARD", "https://codeforces.com/problemset/problem/1349/D", "ARTICLE", "https://codeforces.com/blog/entry/77302", "VIDEO", "https://www.youtube.com/watch?v=lhW6eD00yX0");
        addQ(t, "22. Rorororobot", "HARD", "https://codeforces.com/problemset/problem/1342/D", "ARTICLE", "https://codeforces.com/blog/entry/77002", "VIDEO", "https://www.youtube.com/watch?v=fl8Y4e3fT4A");
        addQ(t, "23. Zero Path", "HARD", "https://codeforces.com/problemset/problem/1326/E", "ARTICLE", "https://codeforces.com/blog/entry/76302", "VIDEO", "https://www.youtube.com/watch?v=35EQXmHKZYs");
        addQ(t, "24. Gambling", "HARD", "https://codeforces.com/problemset/problem/1318/D", "ARTICLE", "https://codeforces.com/blog/entry/75902", "VIDEO", "https://www.youtube.com/watch?v=x-4z_GupYgA");
        addQ(t, "25. Shifting String", "HARD", "https://codeforces.com/problemset/problem/1313/E", "ARTICLE", "https://codeforces.com/blog/entry/75602", "VIDEO", "https://www.youtube.com/watch?v=c5wI2nIn2gU");
        addQ(t, "26. Road Optimization", "HARD", "https://codeforces.com/problemset/problem/1303/D", "ARTICLE", "https://codeforces.com/blog/entry/75202", "VIDEO", "https://www.youtube.com/watch?v=K8r6jbgXk-A");
        addQ(t, "27. Training Session", "HARD", "https://codeforces.com/problemset/problem/1298/D", "ARTICLE", "https://codeforces.com/blog/entry/74902", "VIDEO", "https://www.youtube.com/watch?v=R76n0brv5iU");
        addQ(t, "28. The Number of Imposters", "HARD", "https://codeforces.com/problemset/problem/1288/D", "ARTICLE", "https://codeforces.com/blog/entry/74502", "VIDEO", "https://www.youtube.com/watch?v=b9O9NI-Fi3U");
        addQ(t, "29. Moamen and XOR", "HARD", "https://codeforces.com/problemset/problem/1281/D", "ARTICLE", "https://codeforces.com/blog/entry/74102", "VIDEO", "https://www.youtube.com/watch?v=n-WzX1mNnQk");
        addQ(t, "30. Kavi on Pairing Duty", "HARD", "https://codeforces.com/problemset/problem/1272/D", "ARTICLE", "https://codeforces.com/blog/entry/73702", "VIDEO", "https://www.youtube.com/watch?v=zJg1RkG3F78");
        }

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

    private static boolean seedFromJson() {
        try {
            File file = new File("src/main/java/com/careerforge/roadmap/seeder/cpdata.json");
            if (!file.exists()) {
                file = new File("careerforge/src/main/java/com/careerforge/roadmap/seeder/cpdata.json");
            }
            if (!file.exists()) {
                file = new File("src/main/resources/cpdata.json");
            }

            InputStream is = null;
            if (file.exists()) {
                is = new FileInputStream(file);
            } else {
                is = CpSheetSeeder.class.getResourceAsStream("/com/careerforge/roadmap/seeder/cpdata.json");
                if (is == null) {
                    is = CpSheetSeeder.class.getResourceAsStream("/cpdata.json");
                }
            }

            if (is == null) {
                return false;
            }

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(is);
            is.close();

            JsonNode ratingsNode = root.path("problemsListByRating");
            if (!ratingsNode.isObject()) {
                return false;
            }

            List<String> ratings = new ArrayList<>();
            Iterator<String> fieldNames = ratingsNode.fieldNames();
            while (fieldNames.hasNext()) {
                ratings.add(fieldNames.next());
            }

            ratings.sort((a, b) -> {
                try {
                    return Integer.compare(Integer.parseInt(a), Integer.parseInt(b));
                } catch (Exception e) {
                    return a.compareTo(b);
                }
            });

            for (String ratingKey : ratings) {
                JsonNode ratingData = ratingsNode.path(ratingKey);
                JsonNode listNode = ratingData.path("list");
                if (!listNode.isArray() || listNode.isEmpty()) {
                    continue;
                }

                RoadmapSection section = createSection("Rating " + ratingKey);
                Topic topic = createTopic(section, "Rating " + ratingKey + " Problem Set");

                int qIndex = 1;
                for (JsonNode prob : listNode) {
                    String name = prob.path("name").asText("");
                    String link = prob.path("link").asText("");
                    String videoLink = prob.path("videoSolutionLink").asText("");
                    String concept = prob.path("conceptIdea").asText("");

                    String title = qIndex + ". ";
                    if (!concept.isEmpty()) {
                        title += concept;
                    } else if (!name.isEmpty()) {
                        title += name;
                    } else {
                        title += "Problem " + qIndex;
                    }

                    int ratingVal = 800;
                    try {
                        ratingVal = Integer.parseInt(ratingKey);
                    } catch (Exception ignored) {}

                    String difficulty = "EASY";
                    if (ratingVal >= 1200 && ratingVal < 1500) {
                        difficulty = "MEDIUM";
                    } else if (ratingVal >= 1500) {
                        difficulty = "HARD";
                    }

                    List<String> extraLinks = new ArrayList<>();
                    if (!link.isEmpty()) {
                        extraLinks.add("ARTICLE");
                        extraLinks.add(link);
                    }
                    if (!videoLink.isEmpty()) {
                        extraLinks.add("VIDEO");
                        extraLinks.add(videoLink);
                    }

                    addQ(topic, title, difficulty, link, extraLinks.toArray(new String[0]));
                    qIndex++;
                }
            }

            return true;
        } catch (Exception e) {
            System.err.println("Failed to seed from cpdata.json: " + e.getMessage());
            return false;
        }
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