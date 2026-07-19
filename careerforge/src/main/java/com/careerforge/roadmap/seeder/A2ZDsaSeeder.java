package com.careerforge.roadmap.seeder;

import java.util.ArrayList;
import java.util.List;

public class A2ZDsaSeeder {

    public static void seed(
        com.careerforge.roadmap.entity.Roadmap dbRoadmap,
        com.careerforge.roadmap.repository.RoadmapSectionRepository roadmapSectionRepository,
        com.careerforge.roadmap.repository.QuestionRepository questionRepository,
        com.careerforge.roadmap.repository.QuestionLinkRepository questionLinkRepository,
        com.careerforge.roadmap.repository.RoadmapSectionQuestionRepository roadmapSectionQuestionRepository
    ) {
        System.out.println("Seeding Roadmap: Striver's A2Z DSA Sheet");
        Roadmap.sections.clear();

        RoadmapSection s;
        Topic t;

        // ==========================================
        // Section 1: Learn the basics
        // ==========================================
        s = createSection("Learn the basics");

        t = createTopic(s, "Things to Know in C++/Java/Python or any language");
        addQ(t, "Input Output", "EASY", 
            "VIDEO", "https://youtu.be/EAR7De6Goz4?t=250", 
            "ARTICLE", "https://takeuforward.org/c/c-basic-input-output/");
        addQ(t, "Cpp Basics", "EASY", 
            "VIDEO", "https://youtu.be/EAR7De6Goz4?t=2415", 
            "ARTICLE", "https://takeuforward.org/data-structure/what-are-arrays-strings");
        addQ(t, "If ElseIf", "EASY", 
            "VIDEO", "https://youtu.be/EAR7De6Goz4?t=1259", 
            "ARTICLE", "https://takeuforward.org/if-else/if-else-statements/");
        addQ(t, "Switch Case", "EASY", 
            "VIDEO", "https://youtu.be/EAR7De6Goz4", 
            "ARTICLE", "https://takeuforward.org/switch-case/switch-case-statements/");
        addQ(t, "What are arrays, strings?", "EASY", 
            "VIDEO", "https://youtu.be/EAR7De6Goz4?t=2415", 
            "ARTICLE", "https://takeuforward.org/data-structure/what-are-arrays-strings");
        addQ(t, "For loops", "EASY", 
            "VIDEO", "https://youtu.be/EAR7De6Goz4?t=3096", 
            "ARTICLE", "https://takeuforward.org/for-loop/understanding-for-loop/");
        addQ(t, "While loops", "EASY", 
            "VIDEO", "https://youtu.be/EAR7De6Goz4?t=3459", 
            "ARTICLE", "https://takeuforward.org/while-loop/while-loops-in-programming/");
        addQ(t, "Functions (Pass by Reference and Value)", "EASY", 
            "VIDEO", "https://youtu.be/EAR7De6Goz4?t=3677", 
            "ARTICLE", "https://takeuforward.org/data-structure/functions-pass-by-reference-and-value");
        addQ(t, "Theory with examples", "EASY", 
            "VIDEO", "https://youtu.be/FPu9Uld7W-E", 
            "ARTICLE", "https://takeuforward.org/time-complexity/time-and-space-complexity-strivers-a2z-dsa-course/");

        t = createTopic(s, "Build-up Logical Thinking");
        addQ(t, "Easy and Medium", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Hard", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");

        t = createTopic(s, "Patterns");
        addQ(t, "Pattern 1", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Pattern 2", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Pattern 3", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Pattern 4", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Pattern 5", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Pattern 6", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Pattern 7", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Pattern 8", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Pattern 9", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Pattern 10", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Pattern 11", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Pattern 12", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Pattern 13", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Pattern 14", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Pattern 15", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Pattern 16", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Pattern 17", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Pattern 18", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Pattern 19", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Pattern 20", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Pattern 21", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");
        addQ(t, "Pattern 22", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3", 
            "ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/");

        t = createTopic(s, "Learn STL/Java-Collections or similar thing in your language");
        addQ(t, "STL", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=RRVYpIET_RU", 
            "ARTICLE", "https://takeuforward.org/c/c-stl-tutorial-most-frequent-used-stl-containers/");
        addQ(t, "Java Collections", "EASY", 
            "ARTICLE", "https://takeuforward.org/data-structure/java-collections");

        t = createTopic(s, "Know Basic Maths");
        addQ(t, "Count all Digits of a Number", "EASY", 
            "VIDEO", "https://youtu.be/1xNbjMdbjug", 
            "ARTICLE", "https://takeuforward.org/data-structure/count-digits-in-a-number/");
        addQ(t, "Reverse a number", "EASY", 
            "VIDEO", "https://youtu.be/1xNbjMdbjug?t=930", 
            "ARTICLE", "https://takeuforward.org/maths/reverse-digits-of-a-number");
        addQ(t, "Palindrome Number", "EASY", 
            "VIDEO", "https://youtu.be/1xNbjMdbjug?t=1230", 
            "ARTICLE", "https://takeuforward.org/data-structure/check-if-a-number-is-palindrome-or-not/");
        addQ(t, "GCD of Two Numbers", "EASY", 
            "VIDEO", "https://youtu.be/1xNbjMdbjug?t=2684", 
            "ARTICLE", "https://takeuforward.org/data-structure/find-gcd-of-two-numbers/");
        addQ(t, "Check if the Number is Armstrong", "EASY", 
            "VIDEO", "https://youtu.be/1xNbjMdbjug?t=1418", 
            "ARTICLE", "https://takeuforward.org/maths/check-if-a-number-is-armstrong-number-or-not/");
        addQ(t, "Print all Divisors", "EASY", 
            "VIDEO", "https://youtu.be/1xNbjMdbjug?t=1580", 
            "ARTICLE", "https://takeuforward.org/data-structure/print-all-divisors-of-a-given-number/");
        addQ(t, "Check for Prime Number", "EASY", 
            "VIDEO", "https://youtu.be/1xNbjMdbjug?t=2381", 
            "ARTICLE", "https://takeuforward.org/data-structure/check-if-a-number-is-prime-or-not/");

        t = createTopic(s, "Learn Basic Recursion");
        addQ(t, "Understand recursion by print something N times", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=yVdKa8dnKiE&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9", 
            "ARTICLE", "https://takeuforward.org/recursion/introduction-to-recursion-understand-recursion-by-printing-something-n-times/");
        addQ(t, "Print name N times using recursion", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=un6PLygfXrA&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=2", 
            "ARTICLE", "https://takeuforward.org/recursion/print-name-n-times-using-recursion/");
        addQ(t, "Print 1 to N using Recursion", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=un6PLygfXrA&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=2", 
            "ARTICLE", "https://takeuforward.org/recursion/print-1-to-n-using-recursion/");
        addQ(t, "Print N to 1 using Recursion", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=un6PLygfXrA&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=2", 
            "ARTICLE", "https://takeuforward.org/recursion/print-n-to-1-using-recursion/");
        addQ(t, "Sum of First N Numbers", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=69ZCDFy-OUo&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=3", 
            "ARTICLE", "https://takeuforward.org/data-structure/sum-of-first-n-natural-numbers/");
        addQ(t, "Factorial of a given number", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=69ZCDFy-OUo&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=3", 
            "ARTICLE", "https://takeuforward.org/data-structure/factorial-of-a-number-iterative-and-recursive");
        addQ(t, "Reverse an array", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=twuC1F6gLI8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=4", 
            "ARTICLE", "https://takeuforward.org/data-structure/reverse-a-given-array/");
        addQ(t, "Check if String is Palindrome or Not ", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=twuC1F6gLI8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=4", 
            "ARTICLE", "https://takeuforward.org/data-structure/check-if-the-given-string-is-palindrome-or-not/");
        addQ(t, "Fibonacci Number", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=kvRjNm4rVBE&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=5", 
            "ARTICLE", "https://takeuforward.org/arrays/print-fibonacci-series-up-to-nth-term/");

        t = createTopic(s, "Learn Basic Hashing");
        addQ(t, "Basic Hashing", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=KEs5UyBJ39g", 
            "ARTICLE", "https://takeuforward.org/hashing/hashing-maps-time-complexity-collisions-division-rule-of-hashing-strivers-a2z-dsa-course/");
        addQ(t, "Counting Frequencies of Array Elements", "EASY", 
            "ARTICLE", "https://takeuforward.org/data-structure/count-frequency-of-each-element-in-the-array/");
        addQ(t, "Highest Occurring Element in an Array", "EASY", 
            "ARTICLE", "https://takeuforward.org/arrays/find-the-highest-lowest-frequency-element/");

        // ==========================================
        // Section 2: Learn Important Sorting Techniques
        // ==========================================
        s = createSection("Learn Important Sorting Techniques");

        t = createTopic(s, "Sorting-I");
        addQ(t, "Selection Sort", "EASY", 
            "VIDEO", "https://youtu.be/HGk_ypEuS24?t=167", 
            "ARTICLE", "https://takeuforward.org/sorting/selection-sort-algorithm/");
        addQ(t, "Bubble Sort", "EASY", 
            "VIDEO", "https://youtu.be/HGk_ypEuS24?t=1061", 
            "ARTICLE", "https://takeuforward.org/data-structure/bubble-sort-algorithm/");
        addQ(t, "Insertion Sorting", "EASY", 
            "VIDEO", "https://youtu.be/HGk_ypEuS24?t=1900", 
            "ARTICLE", "https://takeuforward.org/data-structure/insertion-sort-algorithm/");

        t = createTopic(s, "Sorting-II");
        addQ(t, "Merge Sorting", "MEDIUM", 
            "VIDEO", "https://youtu.be/ogjf7ORKfd8", 
            "ARTICLE", "https://takeuforward.org/data-structure/merge-sort-algorithm/");
        addQ(t, "Recursive Bubble Sort", "EASY", 
            "ARTICLE", "https://takeuforward.org/arrays/recursive-bubble-sort-algorithm/");
        addQ(t, "Recursive Insertion Sort", "EASY", 
            "ARTICLE", "https://takeuforward.org/arrays/recursive-insertion-sort-algorithm/");
        addQ(t, "Quick Sorting", "EASY", 
            "VIDEO", "https://youtu.be/WIrA4YexLRQ", 
            "ARTICLE", "https://takeuforward.org/data-structure/quick-sort-algorithm/");

        // ==========================================
        // Section 3: Solve Problems on Arrays [Easy -> Medium -> Hard]
        // ==========================================
        s = createSection("Solve Problems on Arrays [Easy -> Medium -> Hard]");

        t = createTopic(s, "Easy");
        addQ(t, "Largest Element ", "EASY", 
            "VIDEO", "https://youtu.be/37E9ckMDdTk?t=526", 
            "ARTICLE", "https://takeuforward.org/data-structure/find-the-largest-element-in-an-array/");
        addQ(t, "Second Largest Element", "EASY", 
            "VIDEO", "https://youtu.be/37E9ckMDdTk?t=810", 
            "ARTICLE", "https://takeuforward.org/data-structure/find-second-smallest-and-second-largest-element-in-an-array/");
        addQ(t, "Check if the Array is Sorted II", "EASY", 
            "VIDEO", "https://youtu.be/37E9ckMDdTk?t=17224", 
            "ARTICLE", "https://takeuforward.org/data-structure/check-if-an-array-is-sorted/");
        addQ(t, "Remove duplicates from Sorted array", "EASY", 
            "VIDEO", "https://youtu.be/37E9ckMDdTk?t=1887", 
            "ARTICLE", "https://takeuforward.org/data-structure/remove-duplicates-in-place-from-sorted-array/");
        addQ(t, "Left Rotate Array by One", "EASY", 
            "VIDEO", "https://youtu.be/wvcQg43_V8U?t=61", 
            "ARTICLE", "https://takeuforward.org/data-structure/left-rotate-the-array-by-one/");
        addQ(t, "Left Rotate Array by K Places", "EASY", 
            "VIDEO", "https://youtu.be/wvcQg43_V8U?t=485", 
            "ARTICLE", "https://takeuforward.org/data-structure/rotate-array-by-k-elements/");
        addQ(t, "Move Zeros to End", "EASY", 
            "VIDEO", "https://youtu.be/wvcQg43_V8U?t=1633", 
            "ARTICLE", "https://takeuforward.org/data-structure/move-all-zeros-to-the-end-of-the-array/");
        addQ(t, "Linear Search", "EASY", 
            "VIDEO", "https://youtu.be/wvcQg43_V8U?t=2465", 
            "ARTICLE", "https://takeuforward.org/data-structure/linear-search-in-c/");
        addQ(t, "Union of two sorted arrays", "EASY", 
            "VIDEO", "https://youtu.be/wvcQg43_V8U?t=2584", 
            "ARTICLE", "https://takeuforward.org/data-structure/union-of-two-sorted-arrays/");
        addQ(t, "Find missing number", "EASY", 
            "ARTICLE", "https://www.geeksforgeeks.org/find-the-missing-number/");
        addQ(t, "Maximum Consecutive Ones", "EASY", 
            "VIDEO", "https://youtu.be/bYWLJb3vCWY?t=1124", 
            "ARTICLE", "https://takeuforward.org/data-structure/count-maximum-consecutive-ones-in-the-array/");
        addQ(t, "Find the number that appears once, and other numbers twice.", "MEDIUM", 
            "VIDEO", "https://youtu.be/bYWLJb3vCWY?t=1369", 
            "ARTICLE", "https://takeuforward.org/arrays/find-the-number-that-appears-once-and-the-other-numbers-twice/");
        addQ(t, "Longest subarray with given sum K(positives)", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=frf7qxiN2qU&feature=youtu.be", 
            "ARTICLE", "https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k/");
        addQ(t, "Longest subarray with sum K", "MEDIUM", 
            "VIDEO", "https://youtu.be/frf7qxiN2qU", 
            "ARTICLE", "https://takeuforward.org/data-structure/length-of-the-longest-subarray-with-zero-sum/");

        t = createTopic(s, "Medium");
        addQ(t, "Two Sum", "EASY", 
            "VIDEO", "https://youtu.be/UXDSeD9mN-k", 
            "ARTICLE", "https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-sum-exists-in-array/");
        addQ(t, "Sort an array of 0's 1's and 2's", "MEDIUM", 
            "VIDEO", "https://youtu.be/tp8JIuCXBaU", 
            "ARTICLE", "https://takeuforward.org/data-structure/sort-an-array-of-0s-1s-and-2s/");
        addQ(t, "Majority Element-I", "EASY", 
            "VIDEO", "https://youtu.be/nP_ns3uSh80", 
            "ARTICLE", "https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times/");
        addQ(t, "Kadane's Algorithm", "MEDIUM", 
            "VIDEO", "https://youtu.be/AHZpyENo7k4?si=QJpof4R1hHokm1hw", 
            "ARTICLE", "https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array/");
        addQ(t, "Print subarray with maximum subarray sum (extended version of above problem)", "MEDIUM", 
            "VIDEO", "https://youtu.be/AHZpyENo7k4", 
            "ARTICLE", "https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array/");
        addQ(t, "Stock Buy and Sell", "MEDIUM", 
            "VIDEO", "https://youtu.be/excAOvwF_Wk", 
            "ARTICLE", "https://takeuforward.org/data-structure/stock-buy-and-sell/");
        addQ(t, "Rearrange array elements by sign", "MEDIUM", 
            "VIDEO", "https://youtu.be/h4aBagy4Uok", 
            "ARTICLE", "https://takeuforward.org/arrays/rearrange-array-elements-by-sign/");
        addQ(t, "Next Permutation", "MEDIUM", 
            "VIDEO", "https://youtu.be/JDOXKqF60RQ", 
            "ARTICLE", "https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/");
        addQ(t, "Leaders in an Array", "MEDIUM", 
            "VIDEO", "https://youtu.be/cHrH9CQ8pmY", 
            "ARTICLE", "https://takeuforward.org/data-structure/leaders-in-an-array/");
        addQ(t, "Longest Consecutive Sequence in an Array", "MEDIUM", 
            "VIDEO", "https://youtu.be/oO5uLE7EUlM", 
            "ARTICLE", "https://takeuforward.org/data-structure/longest-consecutive-sequence-in-an-array/");
        addQ(t, "Set Matrix Zeroes", "MEDIUM", 
            "VIDEO", "https://youtu.be/N0MgLvceX7M", 
            "ARTICLE", "https://takeuforward.org/data-structure/set-matrix-zero/");
        addQ(t, "Rotate matrix by 90 degrees", "MEDIUM", 
            "VIDEO", "https://youtu.be/Z0R2u6gd3GU", 
            "ARTICLE", "https://takeuforward.org/data-structure/rotate-image-by-90-degree/");
        addQ(t, "Print the matrix in spiral manner", "MEDIUM", 
            "VIDEO", "https://youtu.be/3Zv-s9UUrFM", 
            "ARTICLE", "https://takeuforward.org/data-structure/spiral-traversal-of-matrix/");
        addQ(t, "Count subarrays with given sum", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=xvNwoz-ufXA&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=32", 
            "ARTICLE", "https://takeuforward.org/arrays/count-subarray-sum-equals-k/");

        t = createTopic(s, "Hard");
        addQ(t, "Pascal's Triangle I", "EASY", 
            "VIDEO", "https://youtu.be/bR7mQgwQ_o8", 
            "ARTICLE", "https://takeuforward.org/data-structure/program-to-generate-pascals-triangle");
        addQ(t, "Majority Element-II", "HARD", 
            "VIDEO", "https://youtu.be/vwZj1K0e9U8", 
            "ARTICLE", "https://takeuforward.org/data-structure/majority-elementsn-3-times-find-the-elements-that-appears-more-than-n-3-times-in-the-array/");
        addQ(t, "3 Sum", "MEDIUM", 
            "VIDEO", "https://youtu.be/DhFh8Kw7ymk", 
            "ARTICLE", "https://takeuforward.org/data-structure/3-sum-find-triplets-that-add-up-to-a-zero/");
        addQ(t, "4 Sum", "MEDIUM", 
            "VIDEO", "https://youtu.be/eD95WRfh81c", 
            "ARTICLE", "https://takeuforward.org/data-structure/4-sum-find-quads-that-add-up-to-a-target-value/");
        addQ(t, "Largest Subarray with Sum 0", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=xmguZ6GbatA&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=23", 
            "ARTICLE", "https://takeuforward.org/data-structure/length-of-the-longest-subarray-with-zero-sum/");
        addQ(t, "Count subarrays with given xor K", "HARD", 
            "VIDEO", "https://youtu.be/eZr-6p0B7ME", 
            "ARTICLE", "https://takeuforward.org/data-structure/count-the-number-of-subarrays-with-given-xor-k/");
        addQ(t, "Merge Overlapping Subintervals", "MEDIUM", 
            "VIDEO", "https://youtu.be/IexN60k62jo", 
            "ARTICLE", "https://takeuforward.org/data-structure/merge-overlapping-sub-intervals/");
        addQ(t, "Merge two sorted arrays without extra space", "MEDIUM", 
            "VIDEO", "https://youtu.be/n7uwj04E0I4", 
            "ARTICLE", "https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/");
        addQ(t, "Find the repeating and missing number", "HARD", 
            "VIDEO", "https://youtu.be/2D0D8HE6uak", 
            "ARTICLE", "https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/");
        addQ(t, "Count Inversions", "HARD", 
            "VIDEO", "https://youtu.be/AseUmwVNaoY", 
            "ARTICLE", "https://takeuforward.org/data-structure/count-inversions-in-an-array");
        addQ(t, "Reverse Pairs", "HARD", 
            "VIDEO", "https://youtu.be/0e4bZaP3MDI", 
            "ARTICLE", "https://takeuforward.org/data-structure/count-reverse-pairs/");
        addQ(t, "Maximum Product Subarray in an Array", "HARD", 
            "ARTICLE", "https://takeuforward.org/data-structure/maximum-product-subarray-in-an-array/");

        // ==========================================
        // Section 4: Binary Search [1D, 2D Arrays, Search Space]
        // ==========================================
        s = createSection("Binary Search [1D, 2D Arrays, Search Space]");

        t = createTopic(s, "BS on 1D Arrays");
        addQ(t, "Search X in sorted array", "EASY", 
            "VIDEO", "https://youtu.be/MHf6awe89xw", 
            "ARTICLE", "https://takeuforward.org/data-structure/binary-search-explained/");
        addQ(t, "Lower Bound ", "EASY", 
            "VIDEO", "https://youtu.be/6zhGS79oQ4k", 
            "ARTICLE", "https://takeuforward.org/arrays/implement-lower-bound-bs-2/");
        addQ(t, "Upper Bound", "EASY", 
            "VIDEO", "https://youtu.be/6zhGS79oQ4k", 
            "ARTICLE", "https://takeuforward.org/arrays/implement-upper-bound/");
        addQ(t, "Search insert position", "EASY", 
            "VIDEO", "https://youtu.be/6zhGS79oQ4k", 
            "ARTICLE", "https://takeuforward.org/arrays/search-insert-position/");
        addQ(t, "Floor and Ceil in Sorted Array", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=6zhGS79oQ4k&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=3", 
            "ARTICLE", "https://takeuforward.org/arrays/floor-and-ceil-in-sorted-array/");
        addQ(t, "First and last occurrence", "EASY", 
            "VIDEO", "https://youtu.be/hjR1IYVx9lY", 
            "ARTICLE", "https://takeuforward.org/data-structure/last-occurrence-in-a-sorted-array/");
        addQ(t, "Count Occurrences in a Sorted Array", "EASY", 
            "VIDEO", "https://youtu.be/hjR1IYVx9lY", 
            "ARTICLE", "https://takeuforward.org/data-structure/count-occurrences-in-sorted-array/");
        addQ(t, "Search in rotated sorted array-I", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=r3pMQ8-Ad5s&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=64", 
            "ARTICLE", "https://takeuforward.org/data-structure/search-element-in-a-rotated-sorted-array/");
        addQ(t, "Search in rotated sorted array-II", "MEDIUM", 
            "VIDEO", "https://youtu.be/w2G2W8l__pc", 
            "ARTICLE", "https://takeuforward.org/arrays/search-element-in-rotated-sorted-array-ii");
        addQ(t, "Find minimum in Rotated Sorted Array", "EASY", 
            "VIDEO", "https://youtu.be/nhEMDKMB44g", 
            "ARTICLE", "https://takeuforward.org/data-structure/minimum-in-rotated-sorted-array/");
        addQ(t, "Find out how many times the array is rotated", "EASY", 
            "VIDEO", "https://youtu.be/jtSiWTPLwd0", 
            "ARTICLE", "https://takeuforward.org/arrays/find-out-how-many-times-the-array-has-been-rotated/");
        addQ(t, "Single element in a Sorted Array", "MEDIUM", 
            "VIDEO", "https://youtu.be/AZOmHuHadxQ", 
            "ARTICLE", "https://takeuforward.org/data-structure/search-single-element-in-a-sorted-array/");
        addQ(t, "Find peak element", "MEDIUM", 
            "VIDEO", "https://youtu.be/cXxmbemS6XM", 
            "ARTICLE", "https://takeuforward.org/data-structure/peak-element-in-array/");

        t = createTopic(s, "BS on Answers");
        addQ(t, "Find square root of a number", "MEDIUM", 
            "VIDEO", "https://youtu.be/Bsv3FPUX_BA", 
            "ARTICLE", "https://takeuforward.org/binary-search/finding-sqrt-of-a-number-using-binary-search/");
        addQ(t, "Find Nth root of a number", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=WjpswYrS2nY&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=62", 
            "ARTICLE", "https://takeuforward.org/data-structure/nth-root-of-a-number-using-binary-search/");
        addQ(t, "Koko eating bananas", "MEDIUM", 
            "VIDEO", "https://youtu.be/qyfekrNni90", 
            "ARTICLE", "https://takeuforward.org/binary-search/koko-eating-bananas/");
        addQ(t, "Minimum days to make M bouquets", "MEDIUM", 
            "VIDEO", "https://youtu.be/TXAuxeYBTdg", 
            "ARTICLE", "https://takeuforward.org/arrays/minimum-days-to-make-m-bouquets/");
        addQ(t, "Find the smallest divisor", "MEDIUM", 
            "VIDEO", "https://youtu.be/UvBKTVaG6U8", 
            "ARTICLE", "https://takeuforward.org/arrays/find-the-smallest-divisor-given-a-threshold/");
        addQ(t, "Capacity to Ship Packages Within D Days", "MEDIUM", 
            "VIDEO", "https://youtu.be/MG-Ac4TAvTY", 
            "ARTICLE", "https://takeuforward.org/arrays/capacity-to-ship-packages-within-d-days/");
        addQ(t, "Kth Missing Positive Number", "MEDIUM", 
            "VIDEO", "https://youtu.be/uZ0N_hZpyps", 
            "ARTICLE", "https://takeuforward.org/arrays/kth-missing-positive-number/");
        addQ(t, "Aggressive Cows", "HARD", 
            "VIDEO", "https://youtu.be/R_Mfw4ew-Vo", 
            "ARTICLE", "https://takeuforward.org/data-structure/aggressive-cows-detailed-solution/");
        addQ(t, "Book Allocation Problem", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=gYmWHvRHu-s&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=69", 
            "ARTICLE", "https://takeuforward.org/data-structure/allocate-minimum-number-of-pages/");
        addQ(t, "Split array - largest sum", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=thUd_WJn6wk&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=20", 
            "ARTICLE", "https://takeuforward.org/arrays/split-array-largest-sum/");
        addQ(t, "Painter's Partition", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=thUd_WJn6wk&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=20", 
            "ARTICLE", "https://takeuforward.org/arrays/painters-partition-problem/");
        addQ(t, "Minimize Max Distance to Gas Station", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=kMSBvlZ-_HA&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=21", 
            "ARTICLE", "https://takeuforward.org/arrays/minimise-maximum-distance-between-gas-stations/");
        addQ(t, "Median of 2 sorted arrays", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=NTop3VTjmxk&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=65");
        addQ(t, "Kth element of 2 sorted arrays", "MEDIUM", 
            "VIDEO", "https://youtu.be/D1oDwWCq50g", 
            "ARTICLE", "https://takeuforward.org/data-structure/k-th-element-of-two-sorted-arrays/");

        t = createTopic(s, "BS on 2D Arrays");
        addQ(t, "Find row with maximum 1's", "EASY", 
            "VIDEO", "https://youtu.be/SCz-1TtYxDI", 
            "ARTICLE", "https://takeuforward.org/arrays/find-the-row-with-maximum-number-of-1s/");
        addQ(t, "Search in a 2D matrix", "HARD", 
            "VIDEO", "https://youtu.be/ZYpYur0znng", 
            "ARTICLE", "https://takeuforward.org/data-structure/search-in-a-sorted-2d-matrix/");
        addQ(t, "Search in 2D matrix - II", "HARD", 
            "VIDEO", "https://youtu.be/9ZbB397jU4k", 
            "ARTICLE", "https://takeuforward.org/arrays/search-in-a-row-and-column-wise-sorted-matrix/");
        addQ(t, "Find Peak Element - II", "MEDIUM", 
            "VIDEO", "https://youtu.be/nGGp5XBzC4g?si=WCop5C6Azj5gAELH", 
            "ARTICLE", "https://takeuforward.org/data-structure/find-peak-element-2d-matrix");
        addQ(t, "Matrix Median", "HARD", 
            "VIDEO", "https://youtu.be/Q9wXgdxJq48?si=ScI_0uzJh7yg8nrX", 
            "ARTICLE", "https://takeuforward.org/data-structure/median-of-row-wise-sorted-matrix/");

        // ==========================================
        // Section 5: Strings [Basic and Medium]
        // ==========================================
        s = createSection("Strings [Basic and Medium]");

        t = createTopic(s, "Basic and Easy String Problems");
        addQ(t, "Remove Outermost Parentheses", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/remove-outermost-parentheses");
        addQ(t, "Reverse words in a given string / Palindrome Check", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/reverse-words-in-a-string/");
        addQ(t, "Largest Odd Number in a String", "EASY", 
            "ARTICLE", "https://takeuforward.org/data-structure/largest-odd-number-in-a-string");
        addQ(t, "Longest Common Prefix", "EASY", 
            "ARTICLE", "https://takeuforward.org/data-structure/longest-common-prefix");
        addQ(t, "Isomorphic String", "EASY", 
            "ARTICLE", "https://takeuforward.org/data-structure/isomorphic-string");
        addQ(t, "Rotate String", "EASY", 
            "ARTICLE", "https://takeuforward.org/data-structure/check-if-one-string-is-rotation-of-another");
        addQ(t, "Check if two strings are anagram of each other", "EASY", 
            "ARTICLE", "https://takeuforward.org/data-structure/check-if-two-strings-are-anagrams-of-each-other/");

        t = createTopic(s, "Medium String Problems");
        addQ(t, "Sort Characters by Frequency", "EASY", 
            "ARTICLE", "https://takeuforward.org/data-structure/sort-characters-by-frequency");
        addQ(t, "Maximum Nesting Depth of the Parentheses", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/maximum-nesting-depth-of-parenthesis");
        addQ(t, "Roman to Integer", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/roman-numerals-to-integer");
        addQ(t, "String to Integer (atoi)", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/recursive-implementation-of-atoi");
        addQ(t, "Count Number of Substrings", "EASY", 
            "ARTICLE", "https://takeuforward.org/data-structure/count-number-of-substrings");
        addQ(t, "Longest Palindromic Substring", "MEDIUM");
        addQ(t, "Sum of Beauty of All Substrings", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/sum-of-beauty-of-all-substring");
        addQ(t, "Reverse every word in a string", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/reverse-words-in-a-string/");

        // ==========================================
        // Section 6: Learn LinkedList [Single LL, Double LL, Medium, Hard Problems]
        // ==========================================
        s = createSection("Learn LinkedList [Single LL, Double LL, Medium, Hard Problems]");

        t = createTopic(s, "Learn 1D LinkedList");
        addQ(t, "Introduction to Singly LinkedList", "EASY", 
            "VIDEO", "https://youtu.be/Nq7ok-OyEpg?si=9PR1o8OPRWil7fRA", 
            "ARTICLE", "https://takeuforward.org/linked-list/linked-list-introduction");
        addQ(t, "Insertion at the head of Linked List", "EASY", 
            "VIDEO", "https://youtu.be/VaECK03Dz-g?si=vHSwdf9jhE05adKM&t=1934", 
            "ARTICLE", "https://takeuforward.org/linked-list/insert-at-the-head-of-a-linked-list");
        addQ(t, "Deletion of the head of LL", "EASY", 
            "VIDEO", "https://youtu.be/VaECK03Dz-g?si=CRaBHbOo2bHFbOT5", 
            "ARTICLE", "https://takeuforward.org/data-structure/delete-last-node-of-linked-list/");
        addQ(t, "Find the length of the Linked List", "EASY", 
            "VIDEO", "https://youtu.be/Nq7ok-OyEpg?si=xqQbukLfo2oZ6C6s&t=2240", 
            "ARTICLE", "https://takeuforward.org/linked-list/find-the-length-of-a-linked-list");
        addQ(t, "Search in Linked List", "MEDIUM", 
            "VIDEO", "https://youtu.be/Nq7ok-OyEpg?si=WNXcIaXZ_B6cNq0s&t=2524", 
            "ARTICLE", "https://takeuforward.org/linked-list/search-an-element-in-a-linked-list");

        t = createTopic(s, "Learn Doubly LinkedList");
        addQ(t, "Introduction to Doubly LL", "EASY", 
            "VIDEO", "https://youtu.be/0eKMU10uEDI?si=uDnoj_C5ghEpNLvP", 
            "ARTICLE", "https://takeuforward.org/linked-list/introduction-to-doubly-linked-list");
        addQ(t, "Insert node before head in Doubly Linked List", "EASY", 
            "VIDEO", "https://youtu.be/0eKMU10uEDI?si=J5a0pQTosimcO_aA&t=2684", 
            "ARTICLE", "https://takeuforward.org/data-structure/insert-at-end-of-doubly-linked-list/");
        addQ(t, "Delete head of Doubly Linked List", "EASY", 
            "VIDEO", "https://youtu.be/0eKMU10uEDI?si=sE7jqrW46lfRHVLd&t=853", 
            "ARTICLE", "https://takeuforward.org/data-structure/delete-last-node-of-a-doubly-linked-list/");
        addQ(t, "Reverse a Doubly Linked List", "MEDIUM", 
            "VIDEO", "https://youtu.be/u3WUW2qe6ww?si=96Wwlju72IvmzkxE", 
            "ARTICLE", "https://takeuforward.org/data-structure/reverse-a-doubly-linked-list/");

        t = createTopic(s, "Medium Problems of LL");
        addQ(t, "Middle of a LinkedList [TortoiseHare Method]", "EASY", 
            "VIDEO", "https://youtu.be/7LjQ57RqgEc?si=ir_rRDio38rhamU_", 
            "ARTICLE", "https://takeuforward.org/data-structure/find-middle-element-in-a-linked-list/");
        addQ(t, "Reverse a LinkedList [Iterative]", "MEDIUM", 
            "VIDEO", "https://youtu.be/D2vI2DNJGd8?si=RCaLSx01qR21IBdh", 
            "ARTICLE", "https://takeuforward.org/data-structure/reverse-a-linked-list/");
        addQ(t, "Reverse a LL", "MEDIUM", 
            "VIDEO", "https://youtu.be/D2vI2DNJGd8?si=RCaLSx01qR21IBdh", 
            "ARTICLE", "https://takeuforward.org/data-structure/reverse-a-linked-list/");
        addQ(t, "Detect a loop in LL", "MEDIUM", 
            "VIDEO", "https://youtu.be/wiOo4DC5GGA?si=zagt6O6tFXc4_3cx", 
            "ARTICLE", "https://takeuforward.org/data-structure/detect-a-cycle-in-a-linked-list/");
        addQ(t, "Find the starting point in LL", "MEDIUM", 
            "VIDEO", "https://youtu.be/2Kd0KKmmHFc?si=7UreDPRjRvapeVB0", 
            "ARTICLE", "https://takeuforward.org/data-structure/starting-point-of-loop-in-a-linked-list/");
        addQ(t, "Length of loop in LL", "MEDIUM", 
            "VIDEO", "https://youtu.be/I4g1qbkTPus?si=ONktpqewvx57T8pF", 
            "ARTICLE", "https://takeuforward.org/linked-list/length-of-loop-in-linked-list");
        addQ(t, "Check if LL is palindrome or not", "MEDIUM", 
            "VIDEO", "https://youtu.be/lRY_G-u_8jk?si=BpM8hRYvXSYyjl-G", 
            "ARTICLE", "https://takeuforward.org/data-structure/check-if-given-linked-list-is-plaindrome/");
        addQ(t, "Segregate odd and even nodes in Linked List", "MEDIUM", 
            "VIDEO", "https://youtu.be/qf6qp7GzD5Q?si=JozAyXUdT8EJMSCQ", 
            "ARTICLE", "https://takeuforward.org/data-structure/segregate-even-and-odd-nodes-in-linkedlist");
        addQ(t, "Remove Nth node from the back of the LL", "MEDIUM", 
            "VIDEO", "https://youtu.be/3kMKYQ2wNIU?si=DtFDnPU7z9HMz_GM", 
            "ARTICLE", "https://takeuforward.org/data-structure/remove-n-th-node-from-the-end-of-a-linked-list/");
        addQ(t, "Delete the middle node in LL", "MEDIUM", 
            "VIDEO", "https://youtu.be/ePpV-_pfOeI?si=Au9GsZkVO57j6SiN", 
            "ARTICLE", "https://takeuforward.org/linked-list/delete-the-middle-node-of-the-linked-list");
        addQ(t, "Sort LL", "HARD", 
            "VIDEO", "https://youtu.be/8ocB7a_c-Cc?si=Gv-Y8q8-WyARoV35", 
            "ARTICLE", "https://takeuforward.org/linked-list/sort-a-linked-list");
        addQ(t, "Sort a Linked List of 0's 1's and 2's", "MEDIUM", 
            "VIDEO", "https://youtu.be/gRII7LhdJWc?si=l3qRC7w3NhY7OAqw", 
            "ARTICLE", "https://takeuforward.org/data-structure/sort-a-linked-list-of-0s-1s-and-2s-by-changing-links");
        addQ(t, "Find the intersection point of Y LL", "MEDIUM", 
            "VIDEO", "https://youtu.be/0DYoPz2Tpt4?si=L-uJs5yXUxj4VJM2", 
            "ARTICLE", "https://takeuforward.org/data-structure/find-intersection-of-two-linked-lists/");
        addQ(t, "Add one to a number represented by LL", "MEDIUM", 
            "VIDEO", "https://youtu.be/aXQWhbvT3w0?si=uRgU9S4r5cVmnUy7", 
            "ARTICLE", "https://takeuforward.org/data-structure/add-1-to-a-number-represented-by-ll");
        addQ(t, "Add two numbers in Linked List", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=LBVsXSMOIk4&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=32", 
            "ARTICLE", "https://takeuforward.org/data-structure/add-two-numbers-represented-as-linked-lists/");

        t = createTopic(s, "Medium Problems of DLL");
        addQ(t, "Delete all occurrences of a key in DLL", "HARD", 
            "VIDEO", "https://youtu.be/Mh0NH_SD92k?si=tCYshBRi1upMqSVz", 
            "ARTICLE", "https://takeuforward.org/data-structure/delete-all-occurrences-of-a-key-in-dll");
        addQ(t, "Find Pairs with Given Sum in Doubly Linked List", "MEDIUM", 
            "VIDEO", "https://youtu.be/YitR4dQsddE?si=iZAC259hdngV_OxC", 
            "ARTICLE", "https://takeuforward.org/data-structure/find-pairs-with-given-sum-in-doubly-linked-list");
        addQ(t, "Remove duplicates from sorted DLL", "HARD", 
            "VIDEO", "https://youtu.be/YJKVTnOJXSY?si=AsZoNUoewetsBjr0", 
            "ARTICLE", "https://takeuforward.org/data-structure/remove-duplicates-from-sorted-dll");

        t = createTopic(s, "Hard Problems of LL");
        addQ(t, "Reverse LL in group of given size K", "HARD", 
            "VIDEO", "https://youtu.be/lIar1skcQYI?si=_jFghHKX4eaK36a1", 
            "ARTICLE", "https://takeuforward.org/data-structure/reverse-linked-list-in-groups-of-size-k/");
        addQ(t, "Rotate a LL", "HARD", 
            "VIDEO", "https://youtu.be/uT7YI7XbTY8?si=ZaChW3a68c_v54Is", 
            "ARTICLE", "https://takeuforward.org/data-structure/rotate-a-linked-list/");
        addQ(t, "Flattening of LL", "HARD", 
            "VIDEO", "https://youtu.be/ykelywHJWLg?si=InMg9MmTHzY22NSR", 
            "ARTICLE", "https://takeuforward.org/data-structure/flattening-a-linked-list/");
        addQ(t, "Clone a LL with random and next pointer", "HARD", 
            "VIDEO", "https://youtu.be/q570bKdrnlw?si=epZtpWvtNwuTf23o", 
            "ARTICLE", "https://takeuforward.org/data-structure/clone-linked-list-with-random-and-next-pointer/");

        // ==========================================
        // Section 7: Recursion [PatternWise]
        // ==========================================
        s = createSection("Recursion [PatternWise]");

        t = createTopic(s, "Get a Strong Hold");
        addQ(t, "Recursive Implementation of atoi()", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/recursive-implementation-of-atoi");
        addQ(t, "Pow(x, n)", "EASY", 
            "VIDEO", "https://youtu.be/l0YC3876qxg", 
            "ARTICLE", "https://takeuforward.org/data-structure/implement-powxn-x-raised-to-the-power-n/");
        addQ(t, "Count Good Numbers", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/count-good-numbers");
        addQ(t, "Sort a stack using recursion", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/sort-a-stack");
        addQ(t, "Reverse a Stack", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/reverse-a-stack-using-recursion");

        t = createTopic(s, "Subsequences Pattern");
        addQ(t, "Generate Binary Strings Without Consecutive 1s", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/generate-all-binary-strings");
        addQ(t, "Generate Parentheses", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/generate-parenthesis");
        addQ(t, "Power Set", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=b7AYbpM5YrE&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=67", 
            "ARTICLE", "https://takeuforward.org/data-structure/power-set-print-all-the-possible-subsequences-of-the-string/");
        addQ(t, "Learn All Patterns of Subsequences (Theory)", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=eQCS_v3bw0Q&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=7", 
            "ARTICLE", "https://takeuforward.org/data-structure/learn-all-patterns-of-subsequences-theory");
        addQ(t, "Count all subsequences with sum K", "EASY", 
            "ARTICLE", "https://takeuforward.org/data-structure/count-all-subsequences-with-sum-k");
        addQ(t, "Check if there exists a subsequence with sum K", "EASY", 
            "ARTICLE", "https://takeuforward.org/data-structure/check-if-there-exists-a-subsequence-with-sum-k");
        addQ(t, "Combination Sum", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=OyZFFqQtu98&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=49", 
            "ARTICLE", "https://takeuforward.org/data-structure/combination-sum-1/");
        addQ(t, "Combination Sum II", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=G1fRTGRxXU8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=50", 
            "ARTICLE", "https://takeuforward.org/data-structure/combination-sum-ii-find-all-unique-combinations/");
        addQ(t, "Subsets I", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=rYkfBRtMJr8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=52", 
            "ARTICLE", "https://takeuforward.org/data-structure/subset-sum-sum-of-all-subsets/");
        addQ(t, "Subsets II", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=RIn3gOkbhQE&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=53", 
            "ARTICLE", "https://takeuforward.org/data-structure/subset-ii-print-all-the-unique-subsets/");
        addQ(t, "Combination Sum III", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/combination-sum-iii");
        addQ(t, "Letter Combinations of a Phone Number", "HARD", 
            "ARTICLE", "https://takeuforward.org/data-structure/letter-combinations-of-a-phone-number");

        t = createTopic(s, "Trying out all Combos / Hard");
        addQ(t, "Palindrome partitioning", "HARD", 
            "VIDEO", "https://youtu.be/_H8V5hJUGd0");
        addQ(t, "Word Search", "HARD", 
            "ARTICLE", "https://takeuforward.org/data-structure/word-search-leetcode/");
        addQ(t, "N Queen", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=i05Ju7AftcM&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=57", 
            "ARTICLE", "https://takeuforward.org/data-structure/n-queen-problem-return-all-distinct-solutions-to-the-n-queens-puzzle/");
        addQ(t, "Rat in a Maze", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=bLGZhJlt4y0&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=60", 
            "ARTICLE", "https://takeuforward.org/data-structure/rat-in-a-maze/");
        addQ(t, "Word Break", "MEDIUM");
        addQ(t, "M Coloring Problem", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=wuVwUK25Rfc&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=59", 
            "ARTICLE", "https://takeuforward.org/data-structure/m-coloring-problem/");
        addQ(t, "Sudoku Solver", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=FWAIf_EVUKE&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=58", 
            "ARTICLE", "https://takeuforward.org/data-structure/sudoku-solver/");
        addQ(t, "Expression Add Operators", "HARD", 
            "ARTICLE", "https://takeuforward.org/data-structure/expression-add-operators");

        // ==========================================
        // Section 8: Bit Manipulation [Concepts & Problems]
        // ==========================================
        s = createSection("Bit Manipulation [Concepts & Problems]");

        t = createTopic(s, "Learn Bit Manipulation");
        addQ(t, "Introduction to Bits and Tricks", "EASY", 
            "VIDEO", "https://youtu.be/qQd-ViW7bfk?si=QtdNaRhHmZb08Mr8", 
            "ARTICLE", "https://takeuforward.org/data-structure/introduction-to-bit-manipulation-theory");
        addQ(t, "Check if the i-th bit is Set or Not", "EASY", 
            "VIDEO", "https://youtu.be/nttpF8kwgd4?si=x9o8PsYaA2XVZ9rV", 
            "ARTICLE", "https://takeuforward.org/data-structure/check-if-the-i-th-bit-is-set-or-not");
        addQ(t, "Check if a Number is Odd or Not", "EASY", 
            "VIDEO", "https://youtu.be/nttpF8kwgd4?si=x9o8PsYaA2XVZ9rV", 
            "ARTICLE", "https://takeuforward.org/data-structure/check-if-a-number-is-odd-or-not");
        addQ(t, "Check if a Number is Power of 2 or Not", "EASY", 
            "VIDEO", "https://youtu.be/nttpF8kwgd4?si=x9o8PsYaA2XVZ9rV", 
            "ARTICLE", "https://takeuforward.org/data-structure/check-if-a-number-is-power-of-2-or-not");
        addQ(t, "Count the Number of Set Bits", "EASY", 
            "VIDEO", "https://youtu.be/nttpF8kwgd4?si=x9o8PsYaA2XVZ9rV", 
            "ARTICLE", "https://takeuforward.org/data-structure/count-the-number-of-set-bits");
        addQ(t, "Set/Unset the rightmost unset bit", "EASY", 
            "VIDEO", "https://youtu.be/nttpF8kwgd4?si=x9o8PsYaA2XVZ9rV", 
            "ARTICLE", "https://takeuforward.org/data-structure/set-the-rightmost-bit");
        addQ(t, "Swap Two Numbers", "EASY", 
            "VIDEO", "https://youtu.be/nttpF8kwgd4?si=x9o8PsYaA2XVZ9rV", 
            "ARTICLE", "https://takeuforward.org/data-structure/swap-two-numbers");
        addQ(t, "Divide two numbers without multiplication and division", "MEDIUM", 
            "VIDEO", "https://youtu.be/pBD4B1tzgVc?si=G9c5pEE-RrzeU6sz", 
            "ARTICLE", "https://takeuforward.org/data-structure/divide-two-integers-without-using-multiplication-division-and-mod-operator");

        t = createTopic(s, "Interview Problems");
        addQ(t, "Minimum Bit Flips to Convert Number", "MEDIUM", 
            "VIDEO", "https://youtu.be/OOdrmcfZXd8?si=rnkRVz1UiVBKWC69", 
            "ARTICLE", "https://takeuforward.org/data-structure/count-number-of-bits-to-be-flipped-to-convert-a-to-b");
        addQ(t, "Single Number - I", "MEDIUM", 
            "VIDEO", "https://youtu.be/bYWLJb3vCWY?t=1369", 
            "ARTICLE", "https://takeuforward.org/arrays/find-the-number-that-appears-once-and-the-other-numbers-twice/");
        addQ(t, "Power Set Bit Manipulation", "MEDIUM", 
            "VIDEO", "https://youtu.be/LqKaUv1G3_I?si=UXU_T5OsHiokPRvP", 
            "ARTICLE", "https://takeuforward.org/bit-manipulation/power-set-bit-manipulation");
        addQ(t, "XOR of numbers in a given range", "MEDIUM", 
            "VIDEO", "https://youtu.be/WqGb7159h7Q?si=uGUEbNUUaIN_6Vvr", 
            "ARTICLE", "https://takeuforward.org/data-structure/find-xor-of-numbers-from-l-to-r");
        addQ(t, "Single Number - III", "MEDIUM", 
            "VIDEO", "https://youtu.be/UA5JnV1J2sI?si=VFBRJyb3boZvx_r1", 
            "ARTICLE", "https://takeuforward.org/data-structure/find-the-two-numbers-appearing-odd-number-of-times");

        t = createTopic(s, "Advanced Maths");
        addQ(t, "Print Prime Factors of a Number", "HARD", 
            "VIDEO", "https://youtu.be/LT7XhVdeRyg?si=6HkjQokJRPTFai21", 
            "ARTICLE", "https://takeuforward.org/data-structure/find-the-two-numbers-appearing-odd-number-of-times");
        addQ(t, "Divisors of a Number", "EASY", 
            "VIDEO", "https://youtu.be/1xNbjMdbjug?t=1580", 
            "ARTICLE", "https://takeuforward.org/data-structure/print-all-divisors-of-a-given-number/");
        addQ(t, "Count primes in range L to R", "HARD", 
            "VIDEO", "https://youtu.be/g5Fuxn_AvSk?si=fv6Q-Po7wrMW0a5n", 
            "ARTICLE", "https://takeuforward.org/data-structure/sieve-of-eratosthenes");
        addQ(t, "Prime factorisation of a Number", "HARD", 
            "VIDEO", "https://youtu.be/LT7XhVdeRyg?si=6HkjQokJRPTFai21", 
            "ARTICLE", "https://takeuforward.org/data-structure/find-the-two-numbers-appearing-odd-number-of-times");
        addQ(t, "Pow(x,n)", "EASY", 
            "VIDEO", "https://youtu.be/l0YC3876qxg", 
            "ARTICLE", "https://takeuforward.org/data-structure/implement-powxn-x-raised-to-the-power-n/");

        // ==========================================
        // Section 9: Stack and Queues [Learning, Pre-In-Post-fix, Monotonic Stack, Implementation]
        // ==========================================
        s = createSection("Stack and Queues [Learning, Pre-In-Post-fix, Monotonic Stack, Implementation]");

        t = createTopic(s, "Learning");
        addQ(t, "Implement Stack using Arrays", "EASY", 
            "VIDEO", "https://youtu.be/tqQ5fTamIN4?si=ofLt8Zt1ZvhikZ6w", 
            "ARTICLE", "https://takeuforward.org/data-structure/implement-stack-using-array/");
        addQ(t, "Implement Queue using Arrays", "EASY", 
            "VIDEO", "https://youtu.be/tqQ5fTamIN4?si=ofLt8Zt1ZvhikZ6w", 
            "ARTICLE", "https://takeuforward.org/data-structure/implement-queue-using-array/");
        addQ(t, "Implement Stack using Queue", "EASY", 
            "VIDEO", "https://youtu.be/tqQ5fTamIN4?si=ofLt8Zt1ZvhikZ6w", 
            "ARTICLE", "https://takeuforward.org/data-structure/implement-stack-using-single-queue");
        addQ(t, "Implement Queue using Stack", "EASY", 
            "VIDEO", "https://youtu.be/tqQ5fTamIN4?si=ofLt8Zt1ZvhikZ6w", 
            "ARTICLE", "https://takeuforward.org/data-structure/implement-queue-using-stack/");
        addQ(t, "Implement stack using Linkedlist", "EASY", 
            "VIDEO", "https://youtu.be/tqQ5fTamIN4?si=ofLt8Zt1ZvhikZ6w", 
            "ARTICLE", "https://takeuforward.org/data-structure/implement-stack-using-linked-list/");
        addQ(t, "Implement queue using Linkedlist", "EASY", 
            "VIDEO", "https://youtu.be/tqQ5fTamIN4?si=ofLt8Zt1ZvhikZ6w", 
            "ARTICLE", "https://takeuforward.org/data-structure/implement-queue-using-linked-list/");
        addQ(t, "Balanced Paranthesis", "EASY", 
            "VIDEO", "https://youtu.be/xwjS0iZhw4I?si=UoyKpFn4Q3nf5h2R", 
            "ARTICLE", "https://takeuforward.org/data-structure/check-for-balanced-parentheses/");
        addQ(t, "Implement Min Stack", "HARD", 
            "VIDEO", "https://youtu.be/NdDIaH91P0g?si=4_Jbsq5trFvfSdUY", 
            "ARTICLE", "https://takeuforward.org/data-structure/implement-min-stack-o2n-and-on-space-complexity/");

        t = createTopic(s, "Prefix, Infix, PostFix Conversion Problems");
        addQ(t, "Infix to Postfix Conversion", "MEDIUM", 
            "VIDEO", "https://youtu.be/4pIc9UBHJtk?si=ryeVvQWpCgwbTQrh", 
            "ARTICLE", "https://takeuforward.org/data-structure/infix-to-postfix/");
        addQ(t, "Prefix to Infix Conversion", "MEDIUM", 
            "VIDEO", "https://youtu.be/4pIc9UBHJtk?si=ryeVvQWpCgwbTQrh", 
            "ARTICLE", "https://takeuforward.org/data-structure/prefix-to-infix-conversion");
        addQ(t, "Prefix to Postfix Conversion", "MEDIUM", 
            "VIDEO", "https://youtu.be/4pIc9UBHJtk?si=0pWtyDC1GhbiYP3P", 
            "ARTICLE", "https://takeuforward.org/data-structure/prefix-to-postfix-conversion");
        addQ(t, "Postfix to Prefix Conversion", "MEDIUM", 
            "VIDEO", "https://youtu.be/4pIc9UBHJtk?si=0pWtyDC1GhbiYP3P", 
            "ARTICLE", "https://takeuforward.org/data-structure/postfix-to-prefix-conversion");
        addQ(t, "Postfix to Infix Conversion", "EASY", 
            "VIDEO", "https://youtu.be/4pIc9UBHJtk?si=0pWtyDC1GhbiYP3P", 
            "ARTICLE", "https://takeuforward.org/data-structure/postfix-to-infix");
        addQ(t, "Infix to Prefix Conversion", "MEDIUM", 
            "VIDEO", "https://youtu.be/4pIc9UBHJtk?si=0pWtyDC1GhbiYP3P", 
            "ARTICLE", "https://takeuforward.org/data-structure/infix-to-prefix/");

        t = createTopic(s, "Monotonic Stack/Queue Problems [VVV. Imp]");
        addQ(t, "Next Greater Element", "MEDIUM", 
            "VIDEO", "https://youtu.be/e7XQLtOQM3I?si=QdcHpTtx6gAHsext", 
            "ARTICLE", "https://takeuforward.org/data-structure/next-greater-element-using-stack/");
        addQ(t, "Next Greater Element - 2", "MEDIUM", 
            "VIDEO", "https://youtu.be/7PrncD7v9YQ?si=UkBc7eVy9HGlBpeW", 
            "ARTICLE", "https://takeuforward.org/data-structure/next-greater-element-2");
        addQ(t, "Next Smaller Element", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/next-smaller-element");
        addQ(t, "Number of Greater Elements to the Right", "EASY", 
            "ARTICLE", "https://takeuforward.org/data-structure/number-of-nges-to-the-right");
        addQ(t, "Trapping Rainwater", "HARD", 
            "VIDEO", "https://youtu.be/1_5VuquLbXg?si=NFG6df318_6OtGvg", 
            "ARTICLE", "https://takeuforward.org/data-structure/trapping-rainwater/");
        addQ(t, "Sum of Subarray Minimums", "MEDIUM", 
            "VIDEO", "https://youtu.be/v0e8p9JCgRc?si=XAU7ekECgS5nboRw", 
            "ARTICLE", "https://takeuforward.org/data-structure/sum-of-subarray-minimums");
        addQ(t, "Asteroid Collision", "MEDIUM", 
            "VIDEO", "https://youtu.be/_eYGqw_VDR4?si=YyxibcHq800RqgIQ", 
            "ARTICLE", "https://takeuforward.org/data-structure/asteroid-collision");
        addQ(t, "Sum of Subarray Ranges", "MEDIUM", 
            "VIDEO", "https://youtu.be/gIrMptNPf5M?si=Q_GHuBvzZVs27X_U", 
            "ARTICLE", "https://takeuforward.org/data-structure/sum-of-subarray-ranges");
        addQ(t, "Remove K Digits", "MEDIUM", 
            "VIDEO", "https://youtu.be/jmbuRzYPGrg?si=WN387gwQ7aXWkUao", 
            "ARTICLE", "https://takeuforward.org/data-structure/remove-k-digits");
        addQ(t, "Largest rectangle in a histogram", "HARD", 
            "VIDEO", "https://youtu.be/Bzat9vgD0fs?si=DiBlLejXcr6EJoyB", 
            "ARTICLE", "https://takeuforward.org/data-structure/area-of-largest-rectangle-in-histogram/");
        addQ(t, "Maximum Rectangles", "HARD", 
            "VIDEO", "https://youtu.be/tOylVCugy9k", 
            "ARTICLE", "https://takeuforward.org/data-structure/maximum-rectangle-area-with-all-1s-dp-on-rectangles-dp-55/");

        t = createTopic(s, "Implementation Problems");
        addQ(t, "Sliding Window Maximum", "HARD", 
            "VIDEO", "https://youtu.be/NwBvene4Imo?si=eU1PY-bcQfk5wdog", 
            "ARTICLE", "https://takeuforward.org/data-structure/sliding-window-maximum/");
        addQ(t, "Stock span problem", "HARD", 
            "VIDEO", "https://youtu.be/eay-zoSRkVc?si=deNNe5i38BOAntha", 
            "ARTICLE", "https://takeuforward.org/data-structure/stock-span-problem");
        addQ(t, "Celebrity Problem", "HARD", 
            "VIDEO", "https://youtu.be/cEadsbTeze4?si=olXYfOs7l-SEn2zl", 
            "ARTICLE", "https://takeuforward.org/data-structure/celebrity-problem");
        addQ(t, "LRU Cache", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/program-for-least-recently-used-lru-page-replacement-algorithm");
        addQ(t, "LFU Cache", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=0PSB9y8ehbk&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=79", 
            "ARTICLE", "https://takeuforward.org/data-structure/lfu-cache");

        // ==========================================
        // Section 10: Sliding Window & Two Pointer Combined Problems
        // ==========================================
        s = createSection("Sliding Window & Two Pointer Combined Problems");

        t = createTopic(s, "Medium Problems");
        addQ(t, "Longest Substring Without Repeating Characters", "MEDIUM", 
            "VIDEO", "https://youtu.be/-zSxTJkcdAo?si=I2zfR-vlDMg0zU9z", 
            "ARTICLE", "https://takeuforward.org/data-structure/length-of-longest-substring-without-any-repeating-character/");
        addQ(t, " Max Consecutive Ones III", "MEDIUM", 
            "VIDEO", "https://youtu.be/3E4JBHSLpYk?si=SoOW64pP6otEKxBw", 
            "ARTICLE", "https://takeuforward.org/data-structure/max-consecutive-ones-iii");
        addQ(t, " Fruit Into Baskets", "MEDIUM", 
            "VIDEO", "https://youtu.be/e3bs0uA1NhQ?si=gR8pO62u-nJeFAXk", 
            "ARTICLE", "https://takeuforward.org/data-structure/fruit-into-baskets");
        addQ(t, "Longest Repeating Character Replacement", "HARD", 
            "VIDEO", "https://youtu.be/_eNhaDCr6P0?si=pBWcEjozF5poom0p", 
            "ARTICLE", "https://takeuforward.org/data-structure/longest-repeating-character-replacement");
        addQ(t, "Binary Subarrays With Sum", "HARD", 
            "VIDEO", "https://youtu.be/XnMdNUkX6VM?si=Nyt8EveeLUg8lmty", 
            "ARTICLE", "https://takeuforward.org/data-structure/binary-subarray-with-sum");
        addQ(t, "Count number of Nice subarrays", "HARD", 
            "VIDEO", "https://youtu.be/j_QOv9OT9Og?si=Oq5-5hyFkzVSOZpP", 
            "ARTICLE", "https://takeuforward.org/data-structure/count-number-of-nice-subarrays");
        addQ(t, "Number of Substrings Containing All Three Characters", "HARD", 
            "VIDEO", "https://youtu.be/xtqN4qlgr8s?si=kuaLHVOLXhh5Z2tW", 
            "ARTICLE", "https://takeuforward.org/data-structure/number-of-substring-containing-all-three-characters");
        addQ(t, "Maximum Points You Can Obtain from Cards ", "MEDIUM", 
            "VIDEO", "https://youtu.be/pBWCOCS636U?si=-X64rY67noxvOwrG", 
            "ARTICLE", "https://takeuforward.org/data-structure/maximum-point-you-can-obtain-from-cards");

        t = createTopic(s, "Hard Problems");
        addQ(t, "Longest Substring With At Most K Distinct Characters", "HARD", 
            "VIDEO", "https://youtu.be/teM9ZsVRQyc?si=Kh0_u6aCkkBU3Q33", 
            "ARTICLE", "https://takeuforward.org/data-structure/longest-substring-with-at-most-k-distinct-characters");
        addQ(t, "Subarrays with K Different Integers", "MEDIUM", 
            "VIDEO", "https://youtu.be/7wYGbV_LsX4?si=KWa48RgLDCvdNqRb", 
            "ARTICLE", "https://takeuforward.org/data-structure/subarray-with-k-different-integers");
        addQ(t, "Minimum Window Substring ", "HARD", 
            "VIDEO", "https://youtu.be/WJaij9ffOIY?si=-xnsWIH84zWU0ICd");
        addQ(t, "Minimum Window Subsequence", "HARD");

        // ==========================================
        // Section 11: Heaps [Learning, Medium, Hard Problems]
        // ==========================================
        s = createSection("Heaps [Learning, Medium, Hard Problems]");

        t = createTopic(s, "Learning");
        addQ(t, "Heaps (Theory Video)", "EASY", 
            "ARTICLE", "https://takeuforward.org/data-structure/introduction-to-priority-queues-using-binary-heaps");
        addQ(t, "Implement Min Heap", "MEDIUM");
        addQ(t, "Check if an array represents a min heap ", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/check-if-an-array-represents-a-min-heap");
        addQ(t, "Convert Min Heap to Max Heap", "MEDIUM");

        t = createTopic(s, "Medium Problems");
        addQ(t, "K-th Largest element in an array", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/kth-largest-smallest-element-in-an-array/");
        addQ(t, "Kth smallest element in an array [use priority queue]", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/kth-largest-smallest-element-in-an-array/");
        addQ(t, "Sort K sorted array", "EASY", 
            "ARTICLE", "https://takeuforward.org/data-structure/sort-k-sorted-array");
        addQ(t, "Merge K sorted Lists", "HARD", 
            "ARTICLE", "https://takeuforward.org/data-structure/merge-m-sorted-lists");
        addQ(t, "Replace Elements by Their Rank", "EASY", 
            "ARTICLE", "https://takeuforward.org/data-structure/replace-elements-by-its-rank-in-the-array/");
        addQ(t, "Task Scheduler", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/task-scheduler");
        addQ(t, "Hand of Straights", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/hands-of-straights");

        t = createTopic(s, "Hard Problems");
        addQ(t, "Design Twitter", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/design-twitter");
        addQ(t, "Minimum Cost to Connect Sticks", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/minimum-cost-to-connect-sticks");
        addQ(t, "Kth largest element in a stream of running integers", "HARD", 
            "ARTICLE", "https://takeuforward.org/data-structure/kth-largest-element-in-a-stream-of-running-integers");
        addQ(t, "Maximum Sum Combination", "HARD", 
            "ARTICLE", "https://takeuforward.org/data-structure/maximum-sum-combination");
        addQ(t, "Find Median from Data Stream", "HARD", 
            "ARTICLE", "https://takeuforward.org/data-structure/find-median-from-data-stream");
        addQ(t, "Top K Frequent Elements", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/top-k-frequent-elements");

        // ==========================================
        // Section 12: Greedy Algorithms [Easy, Medium/Hard]
        // ==========================================
        s = createSection("Greedy Algorithms [Easy, Medium/Hard]");

        t = createTopic(s, "Easy Problems");
        addQ(t, "Assign Cookies", "EASY", 
            "VIDEO", "https://youtu.be/DIX2p7vb9co?si=GofAIDimue-Av0Fi", 
            "ARTICLE", "https://takeuforward.org/data-structure/assign-cookies");
        addQ(t, "Fractional Knapsack", "MEDIUM", 
            "VIDEO", "https://youtu.be/1ibsQrnuEEg?si=8R2By3wpHo0zZVHE", 
            "ARTICLE", "https://takeuforward.org/data-structure/fractional-knapsack-problem-greedy-approach/");
        addQ(t, "Lemonade Change", "EASY", 
            "VIDEO", "https://youtu.be/n_tmibEhO6Q?si=q1NW8MfPy0QU6fIl", 
            "ARTICLE", "https://takeuforward.org/Greedy/lemonade-change");
        addQ(t, "Valid Paranthesis Checker", "HARD", 
            "VIDEO", "https://youtu.be/cHT6sG_hUZI?si=XRHeyh7jOaLaTy3g", 
            "ARTICLE", "https://takeuforward.org/data-structure/valid-paranthesis-checker");

        t = createTopic(s, "Medium/Hard");
        addQ(t, "N meetings in one room", "MEDIUM", 
            "VIDEO", "https://youtu.be/mKfhTotEguk?si=2RELeq18mpmIIN3Q", 
            "ARTICLE", "https://takeuforward.org/data-structure/n-meetings-in-one-room/");
        addQ(t, "Jump Game - I", "EASY", 
            "VIDEO", "https://youtu.be/tZAa_jJ3SwQ?si=voKd7n9VTLDRRNzJ", 
            "ARTICLE", "https://takeuforward.org/Greedy/jump-game-i");
        addQ(t, "Jump Game II", "MEDIUM", 
            "VIDEO", "https://youtu.be/7SBVnw7GSTk?si=9uUouBELh9K3m2jZ", 
            "ARTICLE", "https://takeuforward.org/data-structure/jump-game-2");
        addQ(t, "Minimum number of platforms required for a railway", "MEDIUM", 
            "VIDEO", "https://youtu.be/AsGzwR_FWok?si=165acXU_dtqOHuo9", 
            "ARTICLE", "https://takeuforward.org/data-structure/minimum-number-of-platforms-required-for-a-railway/");
        addQ(t, "Job sequencing Problem", "MEDIUM", 
            "VIDEO", "https://youtu.be/QbwltemZbRg?si=wvcemJ5BLPlTRmkG", 
            "ARTICLE", "https://takeuforward.org/data-structure/job-sequencing-problem/");
        addQ(t, "Candy", "HARD", 
            "VIDEO", "https://youtu.be/IIqVFvKE6RY?si=EjmuXZJNLQLUkEd7", 
            "ARTICLE", "https://takeuforward.org/data-structure/candy");
        addQ(t, "Shortest Job First", "MEDIUM", 
            "VIDEO", "https://youtu.be/3-QbX1iDbXs?si=IH8QZUblr01F7UoQ", 
            "ARTICLE", "https://takeuforward.org/Greedy/shortest-job-first-or-sjf-cpu-scheduling");
        addQ(t, "Program for Least Recently Used (LRU) Page Replacement Algorithm", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/program-for-least-recently-used-lru-page-replacement-algorithm");
        addQ(t, "Insert Interval", "MEDIUM", 
            "VIDEO", "https://youtu.be/xxRE-46OCC8?si=a7aPuIw16zDx2lAa", 
            "ARTICLE", "https://takeuforward.org/?s=Insert+Interval");
        addQ(t, "Merge Intervals", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=2JzRBPFYbKE&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=6", 
            "ARTICLE", "https://takeuforward.org/data-structure/merge-overlapping-sub-intervals/");
        addQ(t, "Non-overlapping Intervals", "MEDIUM", 
            "VIDEO", "https://youtu.be/HDHQ8lAWakY?si=JVtLqboGdpUTOVjf", 
            "ARTICLE", "https://takeuforward.org/data-structure/non-overlapping-intervals");

        // ==========================================
        // Section 13: Binary Trees [Traversals, Medium and Hard Problems]
        // ==========================================
        s = createSection("Binary Trees [Traversals, Medium and Hard Problems]");

        t = createTopic(s, "Traversals");
        addQ(t, "Introduction to Trees", "EASY", 
            "VIDEO", "https://youtu.be/_ANrF3FJm7I", 
            "ARTICLE", "https://takeuforward.org/binary-tree/introduction-to-trees/");
        addQ(t, "Binary Tree Representation in Java", "EASY", 
            "VIDEO", "https://youtu.be/hyLyW7rP24I", 
            "ARTICLE", "https://takeuforward.org/binary-tree/binary-tree-representation-in-java/");
        addQ(t, "Pre, Post, Inorder in one traversal", "EASY", 
            "VIDEO", "https://youtu.be/ySp2epYvgTE", 
            "ARTICLE", "https://takeuforward.org/data-structure/preorder-inorder-postorder-traversals-in-one-traversal/");
        addQ(t, "Preorder Traversal", "EASY", 
            "VIDEO", "https://youtu.be/RlUu72JrOCQ", 
            "ARTICLE", "https://takeuforward.org/data-structure/preorder-traversal-of-binary-tree/");
        addQ(t, "Inorder Traversal of Binary Tree", "EASY", 
            "VIDEO", "https://youtu.be/Z_NEgBgbRVI", 
            "ARTICLE", "https://takeuforward.org/data-structure/inorder-traversal-of-binary-tree/");
        addQ(t, "Postorder Traversal", "EASY", 
            "VIDEO", "https://youtu.be/2YBhNLodD8Q", 
            "ARTICLE", "https://takeuforward.org/data-structure/iterative-postorder-traversal-of-binary-tree-using-2-stack");
        addQ(t, "Level Order Traversal", "EASY", 
            "VIDEO", "https://youtu.be/EoAsWbO7sqg", 
            "ARTICLE", "https://takeuforward.org/data-structure/level-order-traversal-of-a-binary-tree/");
        addQ(t, "Iterative Preorder Traversal of Binary Tree", "EASY", 
            "VIDEO", "https://youtu.be/Bfqd8BsPVuw", 
            "ARTICLE", "https://takeuforward.org/data-structure/iterative-preorder-traversal-of-binary-tree");
        addQ(t, "Iterative Inorder Traversal of Binary Tree", "EASY", 
            "VIDEO", "https://youtu.be/lxTGsVXjwvM", 
            "ARTICLE", "https://takeuforward.org/data-structure/inorder-traversal-of-binary-tree/");
        addQ(t, "Post-order Traversal of Binary Tree using 2 stack", "EASY", 
            "VIDEO", "https://youtu.be/2YBhNLodD8Q", 
            "ARTICLE", "https://takeuforward.org/data-structure/iterative-postorder-traversal-of-binary-tree-using-2-stack");
        addQ(t, "Post-order Traversal of Binary Tree using 1 stack", "EASY", 
            "VIDEO", "https://youtu.be/NzIGLLwZBS8", 
            "ARTICLE", "https://takeuforward.org/data-structure/post-order-traversal-of-binary-tree/");
        addQ(t, "Preorder, Inorder, and Postorder Traversal in one Traversal", "EASY", 
            "VIDEO", "https://youtu.be/ySp2epYvgTE", 
            "ARTICLE", "https://takeuforward.org/data-structure/preorder-inorder-postorder-traversals-in-one-traversal/");

        t = createTopic(s, "Medium Problems");
        addQ(t, "Maximum Depth in BT", "MEDIUM", 
            "VIDEO", "https://youtu.be/eD3tmO66aBA", 
            "ARTICLE", "https://takeuforward.org/data-structure/maximum-depth-of-a-binary-tree/");
        addQ(t, "Check for balanced binary tree", "MEDIUM", 
            "VIDEO", "https://youtu.be/Yt50Jfbd8Po", 
            "ARTICLE", "https://takeuforward.org/data-structure/check-if-the-binary-tree-is-balanced-binary-tree/");
        addQ(t, "Diameter of Binary Tree", "EASY", 
            "VIDEO", "https://youtu.be/Rezetez59Nk", 
            "ARTICLE", "https://takeuforward.org/data-structure/calculate-the-diameter-of-a-binary-tree/");
        addQ(t, "Maximum path sum ", "MEDIUM", 
            "VIDEO", "https://youtu.be/WszrfSwMz58", 
            "ARTICLE", "https://takeuforward.org/data-structure/maximum-sum-path-in-binary-tree/");
        addQ(t, "Check if two trees are identical or not", "MEDIUM", 
            "VIDEO", "https://youtu.be/BhuvF_-PWS0", 
            "ARTICLE", "https://takeuforward.org/data-structure/check-if-two-trees-are-identical/");
        addQ(t, "Zig Zag or Spiral Traversal", "MEDIUM", 
            "VIDEO", "https://youtu.be/3OXWEdlIGl4", 
            "ARTICLE", "https://takeuforward.org/data-structure/zig-zag-traversal-of-binary-tree/");
        addQ(t, "Boundary Traversal", "MEDIUM", 
            "VIDEO", "https://youtu.be/0ca1nvR0be4", 
            "ARTICLE", "https://takeuforward.org/data-structure/boundary-traversal-of-a-binary-tree/");
        addQ(t, "Vertical Order Traversal", "MEDIUM", 
            "VIDEO", "https://youtu.be/q_a6lpbKJdw", 
            "ARTICLE", "https://takeuforward.org/data-structure/vertical-order-traversal-of-binary-tree/");
        addQ(t, "Top View of BT", "MEDIUM", 
            "VIDEO", "https://youtu.be/Et9OCDNvJ78", 
            "ARTICLE", "https://takeuforward.org/data-structure/top-view-of-a-binary-tree/");
        addQ(t, "Bottom view of BT", "MEDIUM", 
            "VIDEO", "https://youtu.be/0FtVY6I4pB8", 
            "ARTICLE", "https://takeuforward.org/data-structure/bottom-view-of-a-binary-tree/");
        addQ(t, "Right/Left View of Binary Tree", "MEDIUM", 
            "VIDEO", "https://youtu.be/KV4mRzTjlAk", 
            "ARTICLE", "https://takeuforward.org/data-structure/right-left-view-of-binary-tree/");
        addQ(t, "Symmetric Binary Tree", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=nKggNAiEpBE", 
            "ARTICLE", "https://takeuforward.org/data-structure/check-for-symmetrical-binary-tree/");

        t = createTopic(s, "Hard Problems");
        addQ(t, "Print root to leaf path in BT", "MEDIUM", 
            "VIDEO", "https://youtu.be/fmflMqVOC7k", 
            "ARTICLE", "https://takeuforward.org/data-structure/print-root-to-node-path-in-a-binary-tree/");
        addQ(t, "LCA in BT", "HARD", 
            "VIDEO", "https://youtu.be/_-QHfMDde90", 
            "ARTICLE", "https://takeuforward.org/data-structure/lowest-common-ancestor-for-two-given-nodes/");
        addQ(t, "Maximum Width of BT", "MEDIUM", 
            "VIDEO", "https://youtu.be/ZbybYvcVLks", 
            "ARTICLE", "https://takeuforward.org/data-structure/maximum-width-of-a-binary-tree/");
        addQ(t, "Children Sum Property in Binary Tree", "MEDIUM", 
            "VIDEO", "https://youtu.be/fnmisPM6cVo", 
            "ARTICLE", "https://takeuforward.org/data-structure/check-for-children-sum-property-in-a-binary-tree/");
        addQ(t, "Print all nodes at a distance of K in BT", "HARD", 
            "VIDEO", "https://youtu.be/i9ORlEy6EsI", 
            "ARTICLE", "https://takeuforward.org/data-structure/print-all-the-nodes-at-a-distance-of-k-in-a-binary-tree");
        addQ(t, "Minimum time taken to burn the BT from a given Node", "HARD", 
            "VIDEO", "https://youtu.be/2r5wLmQfD6g", 
            "ARTICLE", "https://takeuforward.org/data-structure/minimum-time-taken-to-burn-the-binary-tree-from-a-node");
        addQ(t, "Count total nodes in a complete BT", "EASY", 
            "VIDEO", "https://youtu.be/u-yWemKGWO0", 
            "ARTICLE", "https://takeuforward.org/binary-tree/count-number-of-nodes-in-a-binary-tree/");
        addQ(t, "Requirements needed to construct a unique BT", "MEDIUM", 
            "VIDEO", "https://youtu.be/9GMECGQgWrQ");
        addQ(t, "Construct a BT from Preorder and Inorder", "HARD", 
            "VIDEO", "https://youtu.be/aZNaLrVebKQ", 
            "ARTICLE", "https://takeuforward.org/data-structure/construct-a-binary-tree-from-inorder-and-preorder-traversal/");
        addQ(t, "Construct the Binary Tree from Postorder and Inorder Traversal", "HARD", 
            "VIDEO", "https://youtu.be/LgLRTaEMRVc", 
            "ARTICLE", "https://takeuforward.org/data-structure/construct-binary-tree-from-inorder-and-postorder-traversal/");
        addQ(t, "Serialize and De-serialize BT", "HARD", 
            "VIDEO", "https://youtu.be/-YbXySKJsX8", 
            "ARTICLE", "https://takeuforward.org/data-structure/serialize-and-deserialize-a-binary-tree/");
        addQ(t, "Morris Preorder Traversal of a Binary Tree", "HARD", 
            "VIDEO", "https://youtu.be/80Zug6D1_r4", 
            "ARTICLE", "https://takeuforward.org/data-structure/morris-preorder-traversal-of-a-binary-tree/");
        addQ(t, "Morris Inorder Traversal of a Binary Tree", "HARD", 
            "VIDEO", "https://youtu.be/80Zug6D1_r4", 
            "ARTICLE", "https://takeuforward.org/data-structure/morris-inorder-traversal-of-a-binary-tree/");
        addQ(t, "Flatten Binary Tree to Linked List", "MEDIUM", 
            "VIDEO", "https://youtu.be/sWf7k1x9XR4", 
            "ARTICLE", "https://takeuforward.org/data-structure/flatten-binary-tree-to-linked-list/");

        // ==========================================
        // Section 14: Binary Search Trees [Concept and Problems]
        // ==========================================
        s = createSection("Binary Search Trees [Concept and Problems]");

        t = createTopic(s, "Concepts");
        addQ(t, "Introduction to BST", "EASY", 
            "VIDEO", "https://youtu.be/p7-9UvDQZ3w", 
            "ARTICLE", "https://takeuforward.org/binary-search-tree/introduction-to-binary-search-trees/");
        addQ(t, "Search in a Binary Search Tree", "EASY", 
            "VIDEO", "https://youtu.be/KcNt6v_56cc", 
            "ARTICLE", "https://takeuforward.org/data-structure/search-in-a-binary-search-tree-2/");
        addQ(t, "Find Min/Max in BST", "EASY", 
            "ARTICLE", "https://takeuforward.org/data-structure/find-minmax-in-a-bst");

        t = createTopic(s, "Practice Problems");
        addQ(t, "Floor and Ceil in a BST", "EASY", 
            "VIDEO", "https://www.youtube.com/watch?v=xm_W1ub-K-w&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=43");
        addQ(t, "Floor in a Binary Search Tree", "EASY", 
            "VIDEO", "https://youtu.be/xm_W1ub-K-w", 
            "ARTICLE", "https://takeuforward.org/binary-search-tree/floor-in-a-binary-search-tree/");
        addQ(t, "Insert a given node in BST", "MEDIUM", 
            "VIDEO", "https://youtu.be/FiFiNvM29ps");
        addQ(t, "Delete a node in BST", "MEDIUM", 
            "VIDEO", "https://youtu.be/kouxiP_H5WE");
        addQ(t, "Kth Smallest and Largest element in BST", "MEDIUM", 
            "VIDEO", "https://youtu.be/9TJYWh0adfk", 
            "ARTICLE", "https://takeuforward.org/data-structure/kth-largest-smallest-element-in-binary-search-tree/");
        addQ(t, "Check if a tree is a BST or not", "MEDIUM", 
            "VIDEO", "https://youtu.be/f-sj7I5oXEI");
        addQ(t, "LCA in BST", "MEDIUM", 
            "VIDEO", "https://youtu.be/cX_kPV_foZc");
        addQ(t, "Construct a BST from a preorder traversal", "MEDIUM", 
            "VIDEO", "https://youtu.be/UmJT3j26t1I");
        addQ(t, "Inorder Successor/Predecessor in BST", "MEDIUM", 
            "VIDEO", "https://youtu.be/SXKAD2svfmI", 
            "ARTICLE", "https://takeuforward.org/data-structure/inorder-successorpredecessor-in-bst");
        addQ(t, "Merge 2 BST's", "HARD", 
            "VIDEO", "https://youtu.be/D2jMcmxU4bs", 
            "ARTICLE", "https://takeuforward.org/data-structure/bst-iterator");
        addQ(t, "Two Sum In BST | Check if there exists a pair with Sum K", "HARD", 
            "VIDEO", "https://youtu.be/ssL3sHwPeb4", 
            "ARTICLE", "https://takeuforward.org/data-structure/two-sum-in-bst-check-if-there-exists-a-pair-with-sum-k");
        addQ(t, "Correct BST with two nodes swapped", "HARD", 
            "VIDEO", "https://youtu.be/ZWGW7FminDM");
        addQ(t, "Largest BST in Binary Tree", "HARD", 
            "VIDEO", "https://youtu.be/X0oXMdtUDwo");

        // ==========================================
        // Section 15: Graphs [Concepts & Problems]
        // ==========================================
        s = createSection("Graphs [Concepts & Problems]");

        t = createTopic(s, "Learning");
        addQ(t, "Introduction to Graph", "EASY", 
            "VIDEO", "https://youtu.be/3oI-34aPMWM", 
            "ARTICLE", "https://takeuforward.org/data-structure/graph-representation-in-java");
        addQ(t, "Graph Representation | C++", "EASY", 
            "VIDEO", "https://youtu.be/3oI-34aPMWM", 
            "ARTICLE", "https://takeuforward.org/graph/graph-representation-in-c/");
        addQ(t, "Graph Representation | Java", "EASY", 
            "VIDEO", "https://youtu.be/3oI-34aPMWM", 
            "ARTICLE", "https://takeuforward.org/data-structure/graph-representation-in-java");
        addQ(t, "Connected Components", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/connected-components");
        addQ(t, "Traversal Techniques", "MEDIUM", 
            "VIDEO", "https://youtu.be/Qzf1a--rhp8", 
            "ARTICLE", "https://takeuforward.org/data-structure/depth-first-search-dfs/");
        addQ(t, "DFS", "MEDIUM", 
            "VIDEO", "https://youtu.be/Qzf1a--rhp8", 
            "ARTICLE", "https://takeuforward.org/data-structure/depth-first-search-dfs/");

        t = createTopic(s, "Problems on BFS/DFS");
        addQ(t, "Number of provinces", "MEDIUM", 
            "VIDEO", "https://youtu.be/ACzkVtewUYA", 
            "ARTICLE", "https://takeuforward.org/data-structure/number-of-provinces/");
        addQ(t, "Connected Components Problem in Matrix", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/connected-components");
        addQ(t, "Rotten Oranges", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=yf3oUhkvqA0", 
            "ARTICLE", "https://takeuforward.org/data-structure/rotten-oranges-min-time-to-rot-all-oranges-bfs/");
        addQ(t, "Flood fill algorithm", "MEDIUM");
        addQ(t, "Cycle Detection in Undirected Graph (bfs)", "HARD", 
            "VIDEO", "https://youtu.be/BPlrALf1LDU", 
            "ARTICLE", "https://takeuforward.org/data-structure/detect-cycle-in-an-undirected-graph-using-bfs/");
        addQ(t, "Detect a cycle in an undirected graph", "HARD", 
            "VIDEO", "https://youtu.be/zQ3zgFypzX4", 
            "ARTICLE", "https://takeuforward.org/data-structure/detect-cycle-in-an-undirected-graph-using-dfs/");
        addQ(t, "Distance of nearest cell having one", "MEDIUM", 
            "VIDEO", "https://youtu.be/edXdVwkYHF8", 
            "ARTICLE", "https://takeuforward.org/graph/distance-of-nearest-cell-having-1/");
        addQ(t, "Surrounded Regions", "MEDIUM", 
            "VIDEO", "https://youtu.be/BtdgAys4yMk", 
            "ARTICLE", "https://takeuforward.org/graph/surrounded-regions-replace-os-with-xs/");
        addQ(t, "Number of enclaves", "MEDIUM", 
            "VIDEO", "https://youtu.be/rxKcepXQgU4", 
            "ARTICLE", "https://takeuforward.org/graph/number-of-enclaves/");
        addQ(t, "Word ladder I", "HARD", 
            "VIDEO", "https://youtu.be/tRPda0rcf8E", 
            "ARTICLE", "https://takeuforward.org/graph/word-ladder-i-g-29/");
        addQ(t, "Word ladder II", "HARD", 
            "VIDEO", "https://youtu.be/AD4SFl7tu7I?si=EpcJQTWm2YeURvEG", 
            "ARTICLE", "https://takeuforward.org/graph/g-30-word-ladder-ii/");
        addQ(t, "Number of islands", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=muncqlKJrH0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=8", 
            "ARTICLE", "https://takeuforward.org/data-structure/number-of-distinct-islands/");
        addQ(t, "Bipartite Graph (DFS)", "HARD", 
            "VIDEO", "https://youtu.be/KG5YFfR0j8A", 
            "ARTICLE", "https://takeuforward.org/graph/bipartite-graph-dfs-implementation/");
        addQ(t, "Cycle Detection in Directed Graph (DFS)", "HARD", 
            "VIDEO", "https://youtu.be/9twcmtQj4DU", 
            "ARTICLE", "https://takeuforward.org/data-structure/detect-cycle-in-a-directed-graph-using-dfs-g-19/");

        t = createTopic(s, "Topo Sort and Problems");
        addQ(t, "Topo Sort", "HARD", 
            "VIDEO", "https://youtu.be/5lZ0iJMrUMk", 
            "ARTICLE", "https://takeuforward.org/data-structure/topological-sort-algorithm-dfs-g-21/");
        addQ(t, "Topological sort or Kahn's algorithm", "HARD", 
            "VIDEO", "https://youtu.be/5lZ0iJMrUMk", 
            "ARTICLE", "https://takeuforward.org/data-structure/topological-sort-algorithm-dfs-g-21/");
        addQ(t, "Detect a cycle in a directed graph", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=uzVUw90ZFIg&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=12", 
            "ARTICLE", "https://takeuforward.org/data-structure/detect-a-cycle-in-directed-graph-topological-sort-kahns-algorithm-g-23/");
        addQ(t, "Course Schedule I", "HARD", 
            "VIDEO", "https://youtu.be/WAOfKpxYHR8", 
            "ARTICLE", "https://takeuforward.org/data-structure/course-schedule-i-and-ii-pre-requisite-tasks-topological-sort-g-24/");
        addQ(t, "Course Schedule II", "MEDIUM", 
            "VIDEO", "https://youtu.be/WAOfKpxYHR8", 
            "ARTICLE", "https://takeuforward.org/data-structure/course-schedule-i-and-ii-pre-requisite-tasks-topological-sort-g-24/");
        addQ(t, "Find eventual safe states", "HARD", 
            "VIDEO", "https://youtu.be/2gtg3VsDGyc", 
            "ARTICLE", "https://takeuforward.org/data-structure/find-eventual-safe-states-bfs-topological-sort-g-25/");
        addQ(t, "Alien Dictionary", "HARD", 
            "VIDEO", "https://youtu.be/U3N_je7tWAs", 
            "ARTICLE", "https://takeuforward.org/data-structure/alien-dictionary-topological-sort-g-26/");

        t = createTopic(s, "Shortest Path Algorithms and Problems");
        addQ(t, "Shortest path in undirected graph with unit weights", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=C4gxoTaI71U&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=28", 
            "ARTICLE", "https://takeuforward.org/data-structure/shortest-path-in-undirected-graph-with-unit-distance-g-28/");
        addQ(t, "Shortest path in DAG", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=ZUFQfFaU-8U&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=27", 
            "ARTICLE", "https://takeuforward.org/data-structure/shortest-path-in-directed-acyclic-graph-topological-sort-g-27/");
        addQ(t, "Djisktra's Algorithm", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=rp1SMw7HSO8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=35", 
            "ARTICLE", "https://takeuforward.org/data-structure/dijkstras-algorithm-using-set-g-33/");
        addQ(t, "Why priority Queue is used in Djisktra's Algorithm", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=rp1SMw7HSO8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=35", 
            "ARTICLE", "https://takeuforward.org/data-structure/dijkstras-algorithm-using-priority-queue-g-32/");
        addQ(t, "Shortest Distance in a Binary Maze", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=U5Mw4eyUmw4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=36", 
            "ARTICLE", "https://takeuforward.org/data-structure/g-36-shortest-distance-in-a-binary-maze/");
        addQ(t, "Path with minimum effort", "HARD", 
            "VIDEO", "https://youtu.be/0ytpZyiZFhA", 
            "ARTICLE", "https://takeuforward.org/data-structure/g-37-path-with-minimum-effort/");
        addQ(t, "Cheapest flight within K stops", "HARD", 
            "VIDEO", "https://youtu.be/9XybHVqTHcQ", 
            "ARTICLE", "https://takeuforward.org/data-structure/g-38-cheapest-flights-within-k-stops/");
        addQ(t, "Network Delay Time", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/network-delay-time");
        addQ(t, "Number of ways to arrive at destination", "HARD", 
            "VIDEO", "https://youtu.be/_-0mx0SmYxA", 
            "ARTICLE", "https://takeuforward.org/data-structure/g-40-number-of-ways-to-arrive-at-destination/");
        addQ(t, "Minimum multiplications to reach end", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=_BvEJ3VIDWw&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=39", 
            "ARTICLE", "https://takeuforward.org/graph/g-39-minimum-multiplications-to-reach-end/");
        addQ(t, "Bellman Ford Algorithm", "HARD", 
            "VIDEO", "https://youtu.be/0vVofAhAYjc", 
            "ARTICLE", "https://takeuforward.org/data-structure/bellman-ford-algorithm-g-41/");
        addQ(t, "Floyd warshall algorithm", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=YbY8cVwWAvw&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=42", 
            "ARTICLE", "https://takeuforward.org/data-structure/floyd-warshall-algorithm-g-42/");
        addQ(t, "Find the city with the smallest number of neighbors", "HARD", 
            "VIDEO", "https://youtu.be/9XybHVqTHcQ", 
            "ARTICLE", "https://takeuforward.org/data-structure/find-the-city-with-the-smallest-number-of-neighbours-at-a-threshold-distance-g-43/");

        t = createTopic(s, "MinimumSpanningTree/Disjoint Set and Problems");
        addQ(t, "MST theory", "EASY", 
            "VIDEO", "https://youtu.be/ZSPjZuZWCME", 
            "ARTICLE", "https://takeuforward.org/data-structure/minimum-spanning-tree-theory-g-44/");
        addQ(t, "Prim's Algorithm", "HARD", 
            "VIDEO", "https://youtu.be/mJcZjjKzeqk", 
            "ARTICLE", "https://takeuforward.org/data-structure/prims-algorithm-minimum-spanning-tree-c-and-java-g-45/");
        addQ(t, "Disjoint Set ", "HARD", 
            "VIDEO", "https://youtu.be/aBxjDBC4M1U", 
            "ARTICLE", "https://takeuforward.org/data-structure/disjoint-set-union-by-rank-union-by-size-path-compression-g-46/");
        addQ(t, "Find the MST weight", "HARD", 
            "VIDEO", "https://youtu.be/mJcZjjKzeqk", 
            "ARTICLE", "https://takeuforward.org/data-structure/prims-algorithm-minimum-spanning-tree-c-and-java-g-45/");
        addQ(t, "Number of operations to make network connected", "HARD", 
            "VIDEO", "https://youtu.be/FYrl7iz9_ZU", 
            "ARTICLE", "https://takeuforward.org/data-structure/number-of-operations-to-make-network-connected-dsu-g-49/");
        addQ(t, "Most stones removed with same row or column", "MEDIUM", 
            "VIDEO", "https://youtu.be/OwMNX8SPavM", 
            "ARTICLE", "https://takeuforward.org/data-structure/most-stones-removed-with-same-row-or-column-dsu-g-53/");
        addQ(t, "Accounts merge", "HARD", 
            "VIDEO", "https://youtu.be/FMwpt_aQOGw", 
            "ARTICLE", "https://takeuforward.org/data-structure/accounts-merge-dsu-g-50/");
        addQ(t, "Number of islands II", "HARD", 
            "VIDEO", "https://youtu.be/Rn6B-Q4SNyA", 
            "ARTICLE", "https://takeuforward.org/graph/number-of-islands-ii-online-queries-dsu-g-51/");
        addQ(t, "Making a large island", "HARD", 
            "VIDEO", "https://youtu.be/lgiz0Oup6gM", 
            "ARTICLE", "https://takeuforward.org/data-structure/making-a-large-island-dsu-g-52/");
        addQ(t, "Swim in Rising Water", "MEDIUM", 
            "ARTICLE", "https://takeuforward.org/data-structure/swim-in-rising-water");

        t = createTopic(s, "Other Algorithms");
        addQ(t, "Bridges in graph", "HARD", 
            "VIDEO", "https://youtu.be/qrAub5z8FeA", 
            "ARTICLE", "https://takeuforward.org/graph/bridges-in-graph-using-tarjans-algorithm-of-time-in-and-low-time-g-55/");
        addQ(t, "Articulation point in graph", "HARD", 
            "VIDEO", "https://youtu.be/j1QDfU21iZk", 
            "ARTICLE", "https://takeuforward.org/data-structure/articulation-point-in-graph-g-56/");
        addQ(t, "Kosaraju's algorithm", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=V8qIqJxCioo&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=27", 
            "ARTICLE", "https://takeuforward.org/graph/strongly-connected-components-kosarajus-algorithm-g-54/");

        // ==========================================
        // Section 16: Dynamic Programming [Patterns and Problems]
        // ==========================================
        s = createSection("Dynamic Programming [Patterns and Problems]");

        t = createTopic(s, "Introduction to DP");
        addQ(t, "Introduction to DP", "EASY", 
            "VIDEO", "https://youtu.be/tyB0ztf0DNY", 
            "ARTICLE", "https://takeuforward.org/data-structure/dynamic-programming-introduction/");

        t = createTopic(s, "1D DP");
        addQ(t, "Climbing stairs", "MEDIUM", 
            "VIDEO", "https://youtu.be/mLfjzJsN8us", 
            "ARTICLE", "https://takeuforward.org/data-structure/dynamic-programming-climbing-stairs/");
        addQ(t, "Frog Jump", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=EgG3jsGoPvQ", 
            "ARTICLE", "https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/");
        addQ(t, "Frog jump with K distances", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=Kmh3rhyEtB8", 
            "ARTICLE", "https://takeuforward.org/data-structure/dynamic-programming-frog-jump-with-k-distances-dp-4/");
        addQ(t, "Maximum sum of non adjacent elements", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=GrMBfJNk_NY", 
            "ARTICLE", "https://takeuforward.org/data-structure/maximum-sum-of-non-adjacent-elements-dp-5/");
        addQ(t, "House robber", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=3WaxQMELSkw", 
            "ARTICLE", "https://takeuforward.org/data-structure/dynamic-programming-house-robber-dp-6/");

        t = createTopic(s, "2D/3D DP and DP on Grids");
        addQ(t, "Ninja's training", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=AE39gJYuRog", 
            "ARTICLE", "https://takeuforward.org/data-structure/dynamic-programming-ninjas-training-dp-7/");
        addQ(t, "Grid Unique Paths : DP on Grids (DP8)", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=sdE0A2Oxofw", 
            "ARTICLE", "https://takeuforward.org/data-structure/grid-unique-paths-dp-on-grids-dp8/");
        addQ(t, "Unique paths II", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=TmhpgXScLyY", 
            "ARTICLE", "https://takeuforward.org/data-structure/grid-unique-paths-2-dp-9/");
        addQ(t, "Minimum Falling Path Sum", "MEDIUM", 
            "VIDEO", "https://youtu.be/_rgTlyky1uQ", 
            "ARTICLE", "https://takeuforward.org/data-structure/minimum-path-sum-in-a-grid-dp-10/");
        addQ(t, "Triangle", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=SrP-PiLSYC0", 
            "ARTICLE", "https://takeuforward.org/data-structure/minimum-path-sum-in-triangular-grid-dp-11/");
        addQ(t, "Ninja and his Friends", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=QGfn7JeXK54", 
            "ARTICLE", "https://takeuforward.org/data-structure/3-d-dp-ninja-and-his-friends-dp-13/");

        t = createTopic(s, "DP on Subsequences");
        addQ(t, "Subset sum equal to target (DP- 14)", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=fWX9xDmIzRI", 
            "ARTICLE", "https://takeuforward.org/data-structure/subset-sum-equal-to-target-dp-14/");
        addQ(t, "Partition equal subset sum", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=7win3dcgo3k", 
            "ARTICLE", "https://takeuforward.org/data-structure/partition-equal-subset-sum-dp-15/");
        addQ(t, "Partition a set into two subsets with minimum absolute sum difference", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=GS_OqZb2CWc", 
            "ARTICLE", "https://takeuforward.org/data-structure/partition-set-into-2-subsets-with-min-absolute-sum-diff-dp-16/");
        addQ(t, "Count subsets with sum K", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=ZHyb-A2Mte4", 
            "ARTICLE", "https://takeuforward.org/data-structure/count-subsets-with-sum-k-dp-17/");
        addQ(t, "Count partitions with given difference", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=zoilQD1kYSg", 
            "ARTICLE", "https://takeuforward.org/data-structure/count-partitions-with-given-difference-dp-18/");
        addQ(t, "Assign Cookies", "EASY", 
            "VIDEO", "https://youtu.be/DIX2p7vb9co?si=GofAIDimue-Av0Fi", 
            "ARTICLE", "https://takeuforward.org/data-structure/assign-cookies");
        addQ(t, "Minimum Coins (DP - 20)", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=myPeWb3Y68A", 
            "ARTICLE", "https://takeuforward.org/data-structure/minimum-coins-dp-20/");
        addQ(t, "Target sum", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=b3GD8263-PQ", 
            "ARTICLE", "https://takeuforward.org/data-structure/target-sum-dp-21/");
        addQ(t, "Coin Change 2 (DP - 22)", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=HgyouUi11zk", 
            "ARTICLE", "https://takeuforward.org/data-structure/coin-change-2-dp-22/");
        addQ(t, "Unbounded knapsack", "HARD", 
            "VIDEO", "https://youtu.be/OgvOZ6OrJoY", 
            "ARTICLE", "https://takeuforward.org/data-structure/unbounded-knapsack-dp-23/");
        addQ(t, "Rod Cutting Problem | (DP - 24)", "HARD", 
            "VIDEO", "https://youtu.be/mO8XpGoJwuo", 
            "ARTICLE", "https://takeuforward.org/data-structure/rod-cutting-problem-dp-24/");

        t = createTopic(s, "DP on Strings");
        addQ(t, "Longest common subsequence", "HARD", 
            "VIDEO", "https://youtu.be/-zI4mrF2Pb4", 
            "ARTICLE", "https://takeuforward.org/data-structure/print-longest-common-subsequence-dp-26/");
        addQ(t, "Print Longest Common Subsequence | (DP - 26)", "HARD", 
            "VIDEO", "https://youtu.be/-zI4mrF2Pb4", 
            "ARTICLE", "https://takeuforward.org/data-structure/print-longest-common-subsequence-dp-26/");
        addQ(t, "Longest common substring", "HARD", 
            "VIDEO", "https://youtu.be/_wP9mWNPL5w", 
            "ARTICLE", "https://takeuforward.org/data-structure/longest-common-substring-dp-27/");
        addQ(t, "Longest palindromic subsequence", "HARD", 
            "VIDEO", "https://youtu.be/6i_T5kkfv4A", 
            "ARTICLE", "https://takeuforward.org/data-structure/longest-palindromic-subsequence-dp-28/");
        addQ(t, "Minimum insertions to make string palindrome | DP-29", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=xPBLEj41rFU", 
            "ARTICLE", "https://takeuforward.org/data-structure/minimum-insertions-to-make-string-palindrome-dp-29/");
        addQ(t, "Minimum insertions or deletions to convert string A to B", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=yMnH0jrir0Q", 
            "ARTICLE", "https://takeuforward.org/data-structure/minimum-insertions-deletions-to-convert-string-dp-30/");
        addQ(t, "Shortest common supersequence", "HARD", 
            "VIDEO", "https://youtu.be/xElxAuBcvsU", 
            "ARTICLE", "https://takeuforward.org/data-structure/shortest-common-supersequence-dp-31/");
        addQ(t, "Distinct subsequences", "HARD", 
            "VIDEO", "https://youtu.be/nVG7eTiD2bY", 
            "ARTICLE", "https://takeuforward.org/data-structure/distinct-subsequences-dp-32/");
        addQ(t, "Edit distance", "HARD", 
            "VIDEO", "https://youtu.be/fJaKO8FbDdo", 
            "ARTICLE", "https://takeuforward.org/data-structure/edit-distance-dp-33/");
        addQ(t, "Wildcard matching", "HARD", 
            "VIDEO", "https://youtu.be/ZmlQ3vgAOMo", 
            "ARTICLE", "https://takeuforward.org/data-structure/wildcard-matching-dp-34/");

        t = createTopic(s, "DP on Stocks");
        addQ(t, "Best time to buy and sell stock", "MEDIUM", 
            "VIDEO", "https://youtu.be/excAOvwF_Wk", 
            "ARTICLE", "https://takeuforward.org/data-structure/stock-buy-and-sell/");
        addQ(t, "Best time to buy and sell stock II", "MEDIUM", 
            "VIDEO", "https://youtu.be/nGJmxkUJQGs", 
            "ARTICLE", "https://takeuforward.org/data-structure/buy-and-sell-stock-ii-dp-36/");
        addQ(t, "Best time to buy and sell stock III", "MEDIUM", 
            "VIDEO", "https://youtu.be/-uQGzhYj8BQ", 
            "ARTICLE", "https://takeuforward.org/data-structure/buy-and-sell-stock-iii-dp-37/");
        addQ(t, "Best time to buy and sell stock IV", "MEDIUM", 
            "VIDEO", "https://youtu.be/IV1dHbk5CDc", 
            "ARTICLE", "https://takeuforward.org/data-structure/buy-and-sell-stock-iv-dp-38/");
        addQ(t, "Best Time to Buy and Sell Stock with Cooldown", "MEDIUM", 
            "VIDEO", "https://youtu.be/IGIe46xw3YY", 
            "ARTICLE", "https://takeuforward.org/data-structure/buy-and-sell-stocks-with-cooldown-dp-39/");
        addQ(t, "Best time to buy and sell stock with transaction fees", "MEDIUM", 
            "VIDEO", "https://youtu.be/k4eK-vEmnKg", 
            "ARTICLE", "https://takeuforward.org/data-structure/buy-and-sell-stocks-with-transaction-fees-dp-40/");

        t = createTopic(s, "DP on LIS");
        addQ(t, "Longest Increasing Subsequence", "MEDIUM", 
            "VIDEO", "https://youtu.be/on2hvxBXJH4", 
            "ARTICLE", "https://takeuforward.org/data-structure/longest-increasing-subsequence-binary-search-dp-43/");
        addQ(t, "Print Longest Increasing Subsequence", "MEDIUM", 
            "VIDEO", "https://youtu.be/IFfYfonAFGc", 
            "ARTICLE", "https://takeuforward.org/data-structure/printing-longest-increasing-subsequence-dp-42/");
        addQ(t, "Longest Increasing Subsequence |(DP-43)", "MEDIUM", 
            "VIDEO", "https://youtu.be/on2hvxBXJH4", 
            "ARTICLE", "https://takeuforward.org/data-structure/longest-increasing-subsequence-binary-search-dp-43/");
        addQ(t, "Largest Divisible Subset", "MEDIUM", 
            "VIDEO", "https://youtu.be/gDuZwBW9VvM", 
            "ARTICLE", "https://takeuforward.org/data-structure/longest-divisible-subset-dp-44/");
        addQ(t, "Longest String Chain", "MEDIUM", 
            "VIDEO", "https://youtu.be/YY8iBaYcc4g", 
            "ARTICLE", "https://takeuforward.org/data-structure/longest-string-chain-dp-45/");
        addQ(t, "Longest Bitonic Subsequence", "MEDIUM", 
            "VIDEO", "https://youtu.be/y4vN0WNdrlg", 
            "ARTICLE", "https://takeuforward.org/data-structure/longest-bitonic-subsequence-dp-46/");
        addQ(t, "Number of Longest Increasing Subsequences", "MEDIUM", 
            "VIDEO", "https://youtu.be/cKVl1TFdNXg", 
            "ARTICLE", "https://takeuforward.org/data-structure/number-of-longest-increasing-subsequences-dp-47/");

        t = createTopic(s, "MCM DP | Partition DP");
        addQ(t, "Matrix chain multiplication", "HARD", 
            "VIDEO", "https://youtu.be/vRVfmbCFW7Y", 
            "ARTICLE", "https://takeuforward.org/dynamic-programming/matrix-chain-multiplication-dp-48/");
        addQ(t, "Matrix Chain Multiplication | Bottom-Up|(DP-49)", "HARD", 
            "VIDEO", "https://youtu.be/pDCXsbAw5Cg", 
            "ARTICLE", "https://takeuforward.org/data-structure/matrix-chain-multiplication-tabulation-method-dp-49/");
        addQ(t, "Minimum cost to cut the stick", "HARD", 
            "VIDEO", "https://youtu.be/xwomavsC86c", 
            "ARTICLE", "https://takeuforward.org/data-structure/minimum-cost-to-cut-the-stick-dp-50/");
        addQ(t, "Burst balloons", "HARD", 
            "VIDEO", "https://youtu.be/Yz4LlDSlkns", 
            "ARTICLE", "https://takeuforward.org/data-structure/burst-balloons-partition-dp-dp-51/");
        addQ(t, "Different Ways to Evaluate a Boolean Expression", "MEDIUM", 
            "VIDEO", "https://youtu.be/MM7fXopgyjw", 
            "ARTICLE", "https://takeuforward.org/data-structure/evaluate-boolean-expression-to-true-partition-dp-dp-52/");
        addQ(t, "Palindrome partitioning II ", "HARD", 
            "VIDEO", "https://youtu.be/_H8V5hJUGd0", 
            "ARTICLE", "https://takeuforward.org/data-structure/palindrome-partitioning-ii-front-partition-dp-53/");
        addQ(t, "Partition Array for Maximum Sum", "MEDIUM", 
            "VIDEO", "https://youtu.be/PhWWJmaKfMc", 
            "ARTICLE", "https://takeuforward.org/data-structure/partition-array-for-maximum-sum-front-partition-dp-54/");

        t = createTopic(s, "DP on Squares");
        addQ(t, "Maximum Rectangle Area with all 1's|(DP-55)", "HARD", 
            "VIDEO", "https://youtu.be/tOylVCugy9k", 
            "ARTICLE", "https://takeuforward.org/data-structure/maximum-rectangle-area-with-all-1s-dp-on-rectangles-dp-55/");
        addQ(t, "Count Square Submatrices with All Ones|(DP-56)", "EASY", 
            "VIDEO", "https://youtu.be/auS1fynpnjo", 
            "ARTICLE", "https://takeuforward.org/data-structure/count-square-submatrices-with-all-1s-dp-on-rectangles-dp-56/");

        // ==========================================
        // Section 17: Tries
        // ==========================================
        s = createSection("Tries");

        t = createTopic(s, "Theory");
        addQ(t, "Trie Implementation and Operations", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=dBGUmUQhjaM&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp", 
            "ARTICLE", "https://takeuforward.org/data-structure/implement-trie-1/");

        t = createTopic(s, "Problems");
        addQ(t, "Trie Implementation and Advanced Operations", "HARD", 
            "ARTICLE", "https://takeuforward.org/data-structure/implement-trie-ii/");
        addQ(t, "Longest Word with All Prefixes", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=AWnBa91lThI&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=3");
        addQ(t, "Number of distinct substrings in a string", "MEDIUM", 
            "VIDEO", "https://www.youtube.com/watch?v=RV0QeTyHZxo&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=4", 
            "ARTICLE", "https://takeuforward.org/data-structure/number-of-distinct-substrings-in-a-string-using-trie/");
        addQ(t, "Bit PreRequisites for TRIE Problems", "EASY", 
            "VIDEO", "https://youtu.be/5iyuU4hQFrw");
        addQ(t, "Maximum XOR of two numbers in an array", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=EIhAwfHubE8&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=6", 
            "ARTICLE", "https://takeuforward.org/data-structure/maximum-xor-of-two-numbers-in-an-array/");
        addQ(t, "Maximum Xor with an element from an array", "HARD", 
            "VIDEO", "https://www.youtube.com/watch?v=Q8LhG9Pi5KM&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=7", 
            "ARTICLE", "https://takeuforward.org/trie/maximum-xor-queries-trie/");

        // ==========================================
        // Section 18: Strings
        // ==========================================
        s = createSection("Strings");

        t = createTopic(s, "Hard Problems");
        addQ(t, "Minimum number of bracket reversals to make an expression balanced", "HARD", 
            "ARTICLE", "https://takeuforward.org/data-structure/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced");
        addQ(t, "Count and say", "HARD", 
            "ARTICLE", "https://takeuforward.org/data-structure/count-and-say");
        addQ(t, "Hashing In Strings | Theory", "EASY", 
            "ARTICLE", "https://takeuforward.org/data-structure/hashing-in-strings");
        addQ(t, "Rabin Karp Algorithm", "HARD");
        addQ(t, "Z function", "HARD");
        addQ(t, "KMP Algorithm or LPS array", "HARD", 
            "ARTICLE", "https://takeuforward.org/data-structure/kmp-algorithm-or-lps-array");
        addQ(t, "Shortest Palindrome", "HARD");
        addQ(t, "Longest happy prefix", "HARD", 
            "ARTICLE", "https://takeuforward.org/data-structure/longest-happy-prefix");
        addQ(t, "Count Palindromic Subsequences", "MEDIUM");

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