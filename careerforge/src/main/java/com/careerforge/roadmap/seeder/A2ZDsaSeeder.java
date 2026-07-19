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
        
        
        // ==========================================
        // Section: Learn the basics
        // ==========================================
        RoadmapSection section_1 = new RoadmapSection("learn_the_basics", "Learn the basics");
        
        
        
        // Topic: Things to Know in C++/Java/Python or any language
        Topic topic_1_1 = new Topic("learn_the_basics_things_to_know_in_cjavapython_or_any_language", "Things to Know in C++/Java/Python or any language");
        
        
        
        Question q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_input_output = new Question("learn_the_basics_things_to_know_in_cjavapython_or_any_language_input_output", "Input Output", "EASY");
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_input_output.setSolveLink("https://takeuforward.org/plus/dsa/problems/input-output");
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_input_output.setEditorialLink("https://takeuforward.org/plus/dsa/problems/input-output?tab=editorial");
        
        
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_input_output.addLink(new QuestionLink("VIDEO", "https://youtu.be/EAR7De6Goz4?t=250"));
        
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_input_output.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/c/c-basic-input-output/"));
        
        
        topic_1_1.addQuestion(q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_input_output);
        
        Question q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_cpp_basics = new Question("learn_the_basics_things_to_know_in_cjavapython_or_any_language_cpp_basics", "Cpp Basics", "EASY");
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_cpp_basics.setSolveLink("https://takeuforward.org/plus/dsa/problems/cpp");
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_cpp_basics.setEditorialLink("https://takeuforward.org/plus/dsa/problems/cpp");
        
        
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_cpp_basics.addLink(new QuestionLink("VIDEO", "https://youtu.be/EAR7De6Goz4?t=2415"));
        
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_cpp_basics.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/what-are-arrays-strings"));
        
        
        topic_1_1.addQuestion(q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_cpp_basics);
        
        Question q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_if_elseif = new Question("learn_the_basics_things_to_know_in_cjavapython_or_any_language_if_elseif", "If ElseIf", "EASY");
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_if_elseif.setSolveLink("https://takeuforward.org/plus/dsa/problems/if-elseif");
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_if_elseif.setEditorialLink("https://takeuforward.org/plus/dsa/problems/if-elseif?tab=editorial");
        
        
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_if_elseif.addLink(new QuestionLink("VIDEO", "https://youtu.be/EAR7De6Goz4?t=1259"));
        
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_if_elseif.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/if-else/if-else-statements/"));
        
        
        topic_1_1.addQuestion(q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_if_elseif);
        
        Question q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_switch_case = new Question("learn_the_basics_things_to_know_in_cjavapython_or_any_language_switch_case", "Switch Case", "EASY");
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_switch_case.setSolveLink("https://takeuforward.org/plus/dsa/problems/switch-case");
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_switch_case.setEditorialLink("https://takeuforward.org/plus/dsa/problems/switch-case?tab=editorial");
        
        
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_switch_case.addLink(new QuestionLink("VIDEO", "https://youtu.be/EAR7De6Goz4"));
        
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_switch_case.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/switch-case/switch-case-statements/"));
        
        
        topic_1_1.addQuestion(q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_switch_case);
        
        Question q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_what_are_arrays_strings = new Question("learn_the_basics_things_to_know_in_cjavapython_or_any_language_what_are_arrays_strings", "What are arrays, strings?", "EASY");
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_what_are_arrays_strings.setSolveLink("https://takeuforward.org/plus/dsa/problems/cpp");
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_what_are_arrays_strings.setEditorialLink("https://takeuforward.org/plus/dsa/problems/cpp");
        
        
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_what_are_arrays_strings.addLink(new QuestionLink("VIDEO", "https://youtu.be/EAR7De6Goz4?t=2415"));
        
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_what_are_arrays_strings.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/what-are-arrays-strings"));
        
        
        topic_1_1.addQuestion(q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_what_are_arrays_strings);
        
        Question q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_for_loops = new Question("learn_the_basics_things_to_know_in_cjavapython_or_any_language_for_loops", "For loops", "EASY");
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_for_loops.setSolveLink("https://takeuforward.org/plus/dsa/problems/for-loop");
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_for_loops.setEditorialLink("https://takeuforward.org/plus/dsa/problems/for-loop");
        
        
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_for_loops.addLink(new QuestionLink("VIDEO", "https://youtu.be/EAR7De6Goz4?t=3096"));
        
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_for_loops.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/for-loop/understanding-for-loop/"));
        
        
        topic_1_1.addQuestion(q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_for_loops);
        
        Question q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_while_loops = new Question("learn_the_basics_things_to_know_in_cjavapython_or_any_language_while_loops", "While loops", "EASY");
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_while_loops.setSolveLink("https://takeuforward.org/plus/dsa/problems/while-loop");
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_while_loops.setEditorialLink("https://takeuforward.org/plus/dsa/problems/while-loop");
        
        
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_while_loops.addLink(new QuestionLink("VIDEO", "https://youtu.be/EAR7De6Goz4?t=3459"));
        
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_while_loops.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/while-loop/while-loops-in-programming/"));
        
        
        topic_1_1.addQuestion(q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_while_loops);
        
        Question q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_functions_pass_by_reference_and_value = new Question("learn_the_basics_things_to_know_in_cjavapython_or_any_language_functions_pass_by_reference_and_value", "Functions (Pass by Reference and Value)", "EASY");
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_functions_pass_by_reference_and_value.setSolveLink("https://takeuforward.org/plus/dsa/problems/pass-by-ref");
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_functions_pass_by_reference_and_value.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pass-by-ref");
        
        
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_functions_pass_by_reference_and_value.addLink(new QuestionLink("VIDEO", "https://youtu.be/EAR7De6Goz4?t=3677"));
        
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_functions_pass_by_reference_and_value.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/functions-pass-by-reference-and-value"));
        
        
        topic_1_1.addQuestion(q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_functions_pass_by_reference_and_value);
        
        Question q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_theory_with_examples = new Question("learn_the_basics_things_to_know_in_cjavapython_or_any_language_theory_with_examples", "Theory with examples", "EASY");
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_theory_with_examples.setSolveLink("https://takeuforward.org/plus/dsa/problems/theory-with-examples");
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_theory_with_examples.setEditorialLink("https://takeuforward.org/plus/dsa/problems/theory-with-examples");
        
        
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_theory_with_examples.addLink(new QuestionLink("VIDEO", "https://youtu.be/FPu9Uld7W-E"));
        
        q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_theory_with_examples.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/time-complexity/time-and-space-complexity-strivers-a2z-dsa-course/"));
        
        
        topic_1_1.addQuestion(q_learn_the_basics_things_to_know_in_cjavapython_or_any_language_theory_with_examples);
        
        
        section_1.addTopic(topic_1_1);
        
        // Topic: Build-up Logical Thinking
        Topic topic_1_2 = new Topic("learn_the_basics_build_up_logical_thinking", "Build-up Logical Thinking");
        
        
        
        Question q_learn_the_basics_build_up_logical_thinking_easy_and_medium = new Question("learn_the_basics_build_up_logical_thinking_easy_and_medium", "Easy and Medium", "EASY");
        q_learn_the_basics_build_up_logical_thinking_easy_and_medium.setSolveLink("https://takeuforward.org/plus/dsa/problems/easy-and-medium");
        q_learn_the_basics_build_up_logical_thinking_easy_and_medium.setEditorialLink("https://takeuforward.org/plus/dsa/problems/easy-and-medium?tab=editorial");
        
        
        q_learn_the_basics_build_up_logical_thinking_easy_and_medium.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_build_up_logical_thinking_easy_and_medium.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_2.addQuestion(q_learn_the_basics_build_up_logical_thinking_easy_and_medium);
        
        Question q_learn_the_basics_build_up_logical_thinking_hard = new Question("learn_the_basics_build_up_logical_thinking_hard", "Hard", "EASY");
        q_learn_the_basics_build_up_logical_thinking_hard.setSolveLink("https://takeuforward.org/plus/dsa/problems/hard");
        q_learn_the_basics_build_up_logical_thinking_hard.setEditorialLink("https://takeuforward.org/plus/dsa/problems/hard?tab=editorial");
        
        
        q_learn_the_basics_build_up_logical_thinking_hard.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_build_up_logical_thinking_hard.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_2.addQuestion(q_learn_the_basics_build_up_logical_thinking_hard);
        
        
        section_1.addTopic(topic_1_2);
        
        // Topic: Patterns
        Topic topic_1_3 = new Topic("learn_the_basics_patterns", "Patterns");
        
        
        
        Question q_learn_the_basics_patterns_pattern_1 = new Question("learn_the_basics_patterns_pattern_1", "Pattern 1", "EASY");
        q_learn_the_basics_patterns_pattern_1.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-1");
        q_learn_the_basics_patterns_pattern_1.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-1?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_1.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_1.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_1);
        
        Question q_learn_the_basics_patterns_pattern_2 = new Question("learn_the_basics_patterns_pattern_2", "Pattern 2", "EASY");
        q_learn_the_basics_patterns_pattern_2.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-2");
        q_learn_the_basics_patterns_pattern_2.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-2?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_2.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_2.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_2);
        
        Question q_learn_the_basics_patterns_pattern_3 = new Question("learn_the_basics_patterns_pattern_3", "Pattern 3", "EASY");
        q_learn_the_basics_patterns_pattern_3.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-3");
        q_learn_the_basics_patterns_pattern_3.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-3?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_3.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_3.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_3);
        
        Question q_learn_the_basics_patterns_pattern_4 = new Question("learn_the_basics_patterns_pattern_4", "Pattern 4", "EASY");
        q_learn_the_basics_patterns_pattern_4.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-4");
        q_learn_the_basics_patterns_pattern_4.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-4?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_4.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_4.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_4);
        
        Question q_learn_the_basics_patterns_pattern_5 = new Question("learn_the_basics_patterns_pattern_5", "Pattern 5", "EASY");
        q_learn_the_basics_patterns_pattern_5.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-5");
        q_learn_the_basics_patterns_pattern_5.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-5?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_5.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_5.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_5);
        
        Question q_learn_the_basics_patterns_pattern_6 = new Question("learn_the_basics_patterns_pattern_6", "Pattern 6", "EASY");
        q_learn_the_basics_patterns_pattern_6.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-6");
        q_learn_the_basics_patterns_pattern_6.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-6?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_6.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_6.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_6);
        
        Question q_learn_the_basics_patterns_pattern_7 = new Question("learn_the_basics_patterns_pattern_7", "Pattern 7", "EASY");
        q_learn_the_basics_patterns_pattern_7.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-7");
        q_learn_the_basics_patterns_pattern_7.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-7?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_7.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_7.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_7);
        
        Question q_learn_the_basics_patterns_pattern_8 = new Question("learn_the_basics_patterns_pattern_8", "Pattern 8", "EASY");
        q_learn_the_basics_patterns_pattern_8.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-8");
        q_learn_the_basics_patterns_pattern_8.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-8?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_8.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_8.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_8);
        
        Question q_learn_the_basics_patterns_pattern_9 = new Question("learn_the_basics_patterns_pattern_9", "Pattern 9", "EASY");
        q_learn_the_basics_patterns_pattern_9.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-9");
        q_learn_the_basics_patterns_pattern_9.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-9?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_9.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_9.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_9);
        
        Question q_learn_the_basics_patterns_pattern_10 = new Question("learn_the_basics_patterns_pattern_10", "Pattern 10", "EASY");
        q_learn_the_basics_patterns_pattern_10.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-10");
        q_learn_the_basics_patterns_pattern_10.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-10?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_10.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_10.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_10);
        
        Question q_learn_the_basics_patterns_pattern_11 = new Question("learn_the_basics_patterns_pattern_11", "Pattern 11", "EASY");
        q_learn_the_basics_patterns_pattern_11.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-11");
        q_learn_the_basics_patterns_pattern_11.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-11?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_11.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_11.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_11);
        
        Question q_learn_the_basics_patterns_pattern_12 = new Question("learn_the_basics_patterns_pattern_12", "Pattern 12", "EASY");
        q_learn_the_basics_patterns_pattern_12.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-12");
        q_learn_the_basics_patterns_pattern_12.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-12?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_12.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_12.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_12);
        
        Question q_learn_the_basics_patterns_pattern_13 = new Question("learn_the_basics_patterns_pattern_13", "Pattern 13", "EASY");
        q_learn_the_basics_patterns_pattern_13.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-13");
        q_learn_the_basics_patterns_pattern_13.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-13?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_13.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_13.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_13);
        
        Question q_learn_the_basics_patterns_pattern_14 = new Question("learn_the_basics_patterns_pattern_14", "Pattern 14", "EASY");
        q_learn_the_basics_patterns_pattern_14.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-14");
        q_learn_the_basics_patterns_pattern_14.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-14?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_14.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_14.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_14);
        
        Question q_learn_the_basics_patterns_pattern_15 = new Question("learn_the_basics_patterns_pattern_15", "Pattern 15", "EASY");
        q_learn_the_basics_patterns_pattern_15.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-15");
        q_learn_the_basics_patterns_pattern_15.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-15?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_15.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_15.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_15);
        
        Question q_learn_the_basics_patterns_pattern_16 = new Question("learn_the_basics_patterns_pattern_16", "Pattern 16", "EASY");
        q_learn_the_basics_patterns_pattern_16.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-16");
        q_learn_the_basics_patterns_pattern_16.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-16?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_16.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_16.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_16);
        
        Question q_learn_the_basics_patterns_pattern_17 = new Question("learn_the_basics_patterns_pattern_17", "Pattern 17", "EASY");
        q_learn_the_basics_patterns_pattern_17.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-17");
        q_learn_the_basics_patterns_pattern_17.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-17?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_17.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_17.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_17);
        
        Question q_learn_the_basics_patterns_pattern_18 = new Question("learn_the_basics_patterns_pattern_18", "Pattern 18", "EASY");
        q_learn_the_basics_patterns_pattern_18.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-18");
        q_learn_the_basics_patterns_pattern_18.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-18?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_18.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_18.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_18);
        
        Question q_learn_the_basics_patterns_pattern_19 = new Question("learn_the_basics_patterns_pattern_19", "Pattern 19", "EASY");
        q_learn_the_basics_patterns_pattern_19.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-19");
        q_learn_the_basics_patterns_pattern_19.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-19?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_19.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_19.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_19);
        
        Question q_learn_the_basics_patterns_pattern_20 = new Question("learn_the_basics_patterns_pattern_20", "Pattern 20", "MEDIUM");
        q_learn_the_basics_patterns_pattern_20.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-20");
        q_learn_the_basics_patterns_pattern_20.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-20?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_20.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_20.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_20);
        
        Question q_learn_the_basics_patterns_pattern_21 = new Question("learn_the_basics_patterns_pattern_21", "Pattern 21", "MEDIUM");
        q_learn_the_basics_patterns_pattern_21.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-21");
        q_learn_the_basics_patterns_pattern_21.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-21?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_21.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_21.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_21);
        
        Question q_learn_the_basics_patterns_pattern_22 = new Question("learn_the_basics_patterns_pattern_22", "Pattern 22", "MEDIUM");
        q_learn_the_basics_patterns_pattern_22.setSolveLink("https://takeuforward.org/plus/dsa/problems/pattern-22");
        q_learn_the_basics_patterns_pattern_22.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pattern-22?tab=editorial");
        
        
        q_learn_the_basics_patterns_pattern_22.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=tNm_NNSB3_w&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=3"));
        
        q_learn_the_basics_patterns_pattern_22.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/"));
        
        
        topic_1_3.addQuestion(q_learn_the_basics_patterns_pattern_22);
        
        
        section_1.addTopic(topic_1_3);
        
        // Topic: Learn STL/Java-Collections or similar thing in your language
        Topic topic_1_4 = new Topic("learn_the_basics_learn_stljava_collections_or_similar_thing_in_your_language", "Learn STL/Java-Collections or similar thing in your language");
        
        
        
        Question q_learn_the_basics_learn_stljava_collections_or_similar_thing_in_your_language_stl = new Question("learn_the_basics_learn_stljava_collections_or_similar_thing_in_your_language_stl", "STL", "EASY");
        q_learn_the_basics_learn_stljava_collections_or_similar_thing_in_your_language_stl.setSolveLink("https://takeuforward.org/plus/dsa/problems/stl");
        q_learn_the_basics_learn_stljava_collections_or_similar_thing_in_your_language_stl.setEditorialLink("https://takeuforward.org/plus/dsa/problems/stl");
        
        
        q_learn_the_basics_learn_stljava_collections_or_similar_thing_in_your_language_stl.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=RRVYpIET_RU"));
        
        q_learn_the_basics_learn_stljava_collections_or_similar_thing_in_your_language_stl.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/c/c-stl-tutorial-most-frequent-used-stl-containers/"));
        
        
        topic_1_4.addQuestion(q_learn_the_basics_learn_stljava_collections_or_similar_thing_in_your_language_stl);
        
        Question q_learn_the_basics_learn_stljava_collections_or_similar_thing_in_your_language_java_collections = new Question("learn_the_basics_learn_stljava_collections_or_similar_thing_in_your_language_java_collections", "Java Collections", "EASY");
        q_learn_the_basics_learn_stljava_collections_or_similar_thing_in_your_language_java_collections.setSolveLink("https://takeuforward.org/plus/dsa/problems/java-collections");
        q_learn_the_basics_learn_stljava_collections_or_similar_thing_in_your_language_java_collections.setEditorialLink("https://takeuforward.org/plus/dsa/problems/java-collections");
        
        
        q_learn_the_basics_learn_stljava_collections_or_similar_thing_in_your_language_java_collections.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/java-collections"));
        
        
        topic_1_4.addQuestion(q_learn_the_basics_learn_stljava_collections_or_similar_thing_in_your_language_java_collections);
        
        
        section_1.addTopic(topic_1_4);
        
        // Topic: Know Basic Maths
        Topic topic_1_5 = new Topic("learn_the_basics_know_basic_maths", "Know Basic Maths");
        
        
        
        Question q_learn_the_basics_know_basic_maths_count_all_digits_of_a_number = new Question("learn_the_basics_know_basic_maths_count_all_digits_of_a_number", "Count all Digits of a Number", "EASY");
        q_learn_the_basics_know_basic_maths_count_all_digits_of_a_number.setSolveLink("https://takeuforward.org/plus/dsa/problems/count-all-digits-of-a-number");
        q_learn_the_basics_know_basic_maths_count_all_digits_of_a_number.setEditorialLink("https://takeuforward.org/plus/dsa/problems/count-all-digits-of-a-number?tab=editorial");
        
        
        q_learn_the_basics_know_basic_maths_count_all_digits_of_a_number.addLink(new QuestionLink("VIDEO", "https://youtu.be/1xNbjMdbjug"));
        
        q_learn_the_basics_know_basic_maths_count_all_digits_of_a_number.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/count-digits-in-a-number/"));
        
        
        topic_1_5.addQuestion(q_learn_the_basics_know_basic_maths_count_all_digits_of_a_number);
        
        Question q_learn_the_basics_know_basic_maths_reverse_a_number = new Question("learn_the_basics_know_basic_maths_reverse_a_number", "Reverse a number", "EASY");
        q_learn_the_basics_know_basic_maths_reverse_a_number.setSolveLink("https://leetcode.com/problems/reverse-integer/");
        q_learn_the_basics_know_basic_maths_reverse_a_number.setEditorialLink("https://takeuforward.org/plus/dsa/problems/reverse-a-number?tab=editorial");
        
        
        q_learn_the_basics_know_basic_maths_reverse_a_number.addLink(new QuestionLink("VIDEO", "https://youtu.be/1xNbjMdbjug?t=930"));
        
        q_learn_the_basics_know_basic_maths_reverse_a_number.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/maths/reverse-digits-of-a-number"));
        
        
        topic_1_5.addQuestion(q_learn_the_basics_know_basic_maths_reverse_a_number);
        
        Question q_learn_the_basics_know_basic_maths_palindrome_number = new Question("learn_the_basics_know_basic_maths_palindrome_number", "Palindrome Number", "EASY");
        q_learn_the_basics_know_basic_maths_palindrome_number.setSolveLink("https://leetcode.com/problems/palindrome-number/");
        q_learn_the_basics_know_basic_maths_palindrome_number.setEditorialLink("https://takeuforward.org/plus/dsa/problems/palindrome-number?tab=editorial");
        
        
        q_learn_the_basics_know_basic_maths_palindrome_number.addLink(new QuestionLink("VIDEO", "https://youtu.be/1xNbjMdbjug?t=1230"));
        
        q_learn_the_basics_know_basic_maths_palindrome_number.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/check-if-a-number-is-palindrome-or-not/"));
        
        
        topic_1_5.addQuestion(q_learn_the_basics_know_basic_maths_palindrome_number);
        
        Question q_learn_the_basics_know_basic_maths_gcd_of_two_numbers = new Question("learn_the_basics_know_basic_maths_gcd_of_two_numbers", "GCD of Two Numbers", "EASY");
        q_learn_the_basics_know_basic_maths_gcd_of_two_numbers.setSolveLink("https://takeuforward.org/plus/dsa/problems/gcd-of-two-numbers");
        q_learn_the_basics_know_basic_maths_gcd_of_two_numbers.setEditorialLink("https://takeuforward.org/plus/dsa/problems/gcd-of-two-numbers?tab=editorial");
        
        
        q_learn_the_basics_know_basic_maths_gcd_of_two_numbers.addLink(new QuestionLink("VIDEO", "https://youtu.be/1xNbjMdbjug?t=2684"));
        
        q_learn_the_basics_know_basic_maths_gcd_of_two_numbers.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/find-gcd-of-two-numbers/"));
        
        
        topic_1_5.addQuestion(q_learn_the_basics_know_basic_maths_gcd_of_two_numbers);
        
        Question q_learn_the_basics_know_basic_maths_check_if_the_number_is_armstrong = new Question("learn_the_basics_know_basic_maths_check_if_the_number_is_armstrong", "Check if the Number is Armstrong", "EASY");
        q_learn_the_basics_know_basic_maths_check_if_the_number_is_armstrong.setSolveLink("https://leetcode.com/problems/armstrong-number/");
        q_learn_the_basics_know_basic_maths_check_if_the_number_is_armstrong.setEditorialLink("https://takeuforward.org/plus/dsa/problems/check-if-the-number-if-armstrong?tab=editorial");
        
        
        q_learn_the_basics_know_basic_maths_check_if_the_number_is_armstrong.addLink(new QuestionLink("VIDEO", "https://youtu.be/1xNbjMdbjug?t=1418"));
        
        q_learn_the_basics_know_basic_maths_check_if_the_number_is_armstrong.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/maths/check-if-a-number-is-armstrong-number-or-not/"));
        
        
        topic_1_5.addQuestion(q_learn_the_basics_know_basic_maths_check_if_the_number_is_armstrong);
        
        Question q_learn_the_basics_know_basic_maths_print_all_divisors = new Question("learn_the_basics_know_basic_maths_print_all_divisors", "Print all Divisors", "EASY");
        q_learn_the_basics_know_basic_maths_print_all_divisors.setSolveLink("https://takeuforward.org/plus/dsa/problems/divisors-of-a-number");
        q_learn_the_basics_know_basic_maths_print_all_divisors.setEditorialLink("https://takeuforward.org/plus/dsa/problems/divisors-of-a-number?tab=editorial");
        
        
        q_learn_the_basics_know_basic_maths_print_all_divisors.addLink(new QuestionLink("VIDEO", "https://youtu.be/1xNbjMdbjug?t=1580"));
        
        q_learn_the_basics_know_basic_maths_print_all_divisors.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/print-all-divisors-of-a-given-number/"));
        
        
        topic_1_5.addQuestion(q_learn_the_basics_know_basic_maths_print_all_divisors);
        
        Question q_learn_the_basics_know_basic_maths_check_for_prime_number = new Question("learn_the_basics_know_basic_maths_check_for_prime_number", "Check for Prime Number", "EASY");
        q_learn_the_basics_know_basic_maths_check_for_prime_number.setSolveLink("https://takeuforward.org/plus/dsa/problems/check-for-prime-number");
        q_learn_the_basics_know_basic_maths_check_for_prime_number.setEditorialLink("https://takeuforward.org/plus/dsa/problems/check-for-prime-number?tab=editorial");
        
        
        q_learn_the_basics_know_basic_maths_check_for_prime_number.addLink(new QuestionLink("VIDEO", "https://youtu.be/1xNbjMdbjug?t=2381"));
        
        q_learn_the_basics_know_basic_maths_check_for_prime_number.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/check-if-a-number-is-prime-or-not/"));
        
        
        topic_1_5.addQuestion(q_learn_the_basics_know_basic_maths_check_for_prime_number);
        
        
        section_1.addTopic(topic_1_5);
        
        // Topic: Learn Basic Recursion
        Topic topic_1_6 = new Topic("learn_the_basics_learn_basic_recursion", "Learn Basic Recursion");
        
        
        
        Question q_learn_the_basics_learn_basic_recursion_understand_recursion_by_print_something_n_times = new Question("learn_the_basics_learn_basic_recursion_understand_recursion_by_print_something_n_times", "Understand recursion by print something N times", "EASY");
        q_learn_the_basics_learn_basic_recursion_understand_recursion_by_print_something_n_times.setSolveLink("https://takeuforward.org/recursion/introduction-to-recursion-understand-recursion-by-printing-something-n-times/");
        q_learn_the_basics_learn_basic_recursion_understand_recursion_by_print_something_n_times.setEditorialLink("https://takeuforward.org/plus/dsa/problems/recursion-theory");
        
        
        q_learn_the_basics_learn_basic_recursion_understand_recursion_by_print_something_n_times.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=yVdKa8dnKiE&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9"));
        
        q_learn_the_basics_learn_basic_recursion_understand_recursion_by_print_something_n_times.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/recursion/introduction-to-recursion-understand-recursion-by-printing-something-n-times/"));
        
        
        topic_1_6.addQuestion(q_learn_the_basics_learn_basic_recursion_understand_recursion_by_print_something_n_times);
        
        Question q_learn_the_basics_learn_basic_recursion_print_name_n_times_using_recursion = new Question("learn_the_basics_learn_basic_recursion_print_name_n_times_using_recursion", "Print name N times using recursion", "EASY");
        q_learn_the_basics_learn_basic_recursion_print_name_n_times_using_recursion.setSolveLink("https://takeuforward.org/recursion/print-name-n-times-using-recursion/");
        q_learn_the_basics_learn_basic_recursion_print_name_n_times_using_recursion.setEditorialLink("https://takeuforward.org/plus/dsa/problems/recursion-theory");
        
        
        q_learn_the_basics_learn_basic_recursion_print_name_n_times_using_recursion.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=un6PLygfXrA&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=2"));
        
        q_learn_the_basics_learn_basic_recursion_print_name_n_times_using_recursion.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/recursion/print-name-n-times-using-recursion/"));
        
        
        topic_1_6.addQuestion(q_learn_the_basics_learn_basic_recursion_print_name_n_times_using_recursion);
        
        Question q_learn_the_basics_learn_basic_recursion_print_1_to_n_using_recursion = new Question("learn_the_basics_learn_basic_recursion_print_1_to_n_using_recursion", "Print 1 to N using Recursion", "EASY");
        q_learn_the_basics_learn_basic_recursion_print_1_to_n_using_recursion.setSolveLink("https://takeuforward.org/plus/dsa/problems/print-1-to-n-using-recursion");
        q_learn_the_basics_learn_basic_recursion_print_1_to_n_using_recursion.setEditorialLink("https://takeuforward.org/plus/dsa/problems/print-1-to-n-using-recursion?tab=editorial");
        
        
        q_learn_the_basics_learn_basic_recursion_print_1_to_n_using_recursion.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=un6PLygfXrA&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=2"));
        
        q_learn_the_basics_learn_basic_recursion_print_1_to_n_using_recursion.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/recursion/print-1-to-n-using-recursion/"));
        
        
        topic_1_6.addQuestion(q_learn_the_basics_learn_basic_recursion_print_1_to_n_using_recursion);
        
        Question q_learn_the_basics_learn_basic_recursion_print_n_to_1_using_recursion = new Question("learn_the_basics_learn_basic_recursion_print_n_to_1_using_recursion", "Print N to 1 using Recursion", "EASY");
        q_learn_the_basics_learn_basic_recursion_print_n_to_1_using_recursion.setSolveLink("https://takeuforward.org/plus/dsa/problems/print-n-to-1-using-recursion");
        q_learn_the_basics_learn_basic_recursion_print_n_to_1_using_recursion.setEditorialLink("https://takeuforward.org/plus/dsa/problems/print-n-to-1-using-recursion?tab=editorial");
        
        
        q_learn_the_basics_learn_basic_recursion_print_n_to_1_using_recursion.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=un6PLygfXrA&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=2"));
        
        q_learn_the_basics_learn_basic_recursion_print_n_to_1_using_recursion.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/recursion/print-n-to-1-using-recursion/"));
        
        
        topic_1_6.addQuestion(q_learn_the_basics_learn_basic_recursion_print_n_to_1_using_recursion);
        
        Question q_learn_the_basics_learn_basic_recursion_sum_of_first_n_numbers = new Question("learn_the_basics_learn_basic_recursion_sum_of_first_n_numbers", "Sum of First N Numbers", "EASY");
        q_learn_the_basics_learn_basic_recursion_sum_of_first_n_numbers.setSolveLink("https://takeuforward.org/plus/dsa/problems/sum-of-first-n-numbers");
        q_learn_the_basics_learn_basic_recursion_sum_of_first_n_numbers.setEditorialLink("https://takeuforward.org/plus/dsa/problems/sum-of-first-n-numbers?tab=editorial");
        
        
        q_learn_the_basics_learn_basic_recursion_sum_of_first_n_numbers.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=69ZCDFy-OUo&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=3"));
        
        q_learn_the_basics_learn_basic_recursion_sum_of_first_n_numbers.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/sum-of-first-n-natural-numbers/"));
        
        
        topic_1_6.addQuestion(q_learn_the_basics_learn_basic_recursion_sum_of_first_n_numbers);
        
        Question q_learn_the_basics_learn_basic_recursion_factorial_of_a_given_number = new Question("learn_the_basics_learn_basic_recursion_factorial_of_a_given_number", "Factorial of a given number", "EASY");
        q_learn_the_basics_learn_basic_recursion_factorial_of_a_given_number.setSolveLink("https://takeuforward.org/plus/dsa/problems/factorial-of-a-given-number-i");
        q_learn_the_basics_learn_basic_recursion_factorial_of_a_given_number.setEditorialLink("https://takeuforward.org/plus/dsa/problems/factorial-of-a-given-number?tab=editorial");
        
        
        q_learn_the_basics_learn_basic_recursion_factorial_of_a_given_number.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=69ZCDFy-OUo&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=3"));
        
        q_learn_the_basics_learn_basic_recursion_factorial_of_a_given_number.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/factorial-of-a-number-iterative-and-recursive"));
        
        
        topic_1_6.addQuestion(q_learn_the_basics_learn_basic_recursion_factorial_of_a_given_number);
        
        Question q_learn_the_basics_learn_basic_recursion_reverse_an_array = new Question("learn_the_basics_learn_basic_recursion_reverse_an_array", "Reverse an array", "EASY");
        q_learn_the_basics_learn_basic_recursion_reverse_an_array.setSolveLink("https://takeuforward.org/plus/dsa/problems/reverse-an-array");
        q_learn_the_basics_learn_basic_recursion_reverse_an_array.setEditorialLink("https://takeuforward.org/plus/dsa/problems/reverse-an-array?tab=editorial");
        
        
        q_learn_the_basics_learn_basic_recursion_reverse_an_array.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=twuC1F6gLI8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=4"));
        
        q_learn_the_basics_learn_basic_recursion_reverse_an_array.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/reverse-a-given-array/"));
        
        
        topic_1_6.addQuestion(q_learn_the_basics_learn_basic_recursion_reverse_an_array);
        
        Question q_learn_the_basics_learn_basic_recursion_check_if_string_is_palindrome_or_not = new Question("learn_the_basics_learn_basic_recursion_check_if_string_is_palindrome_or_not", "Check if String is Palindrome or Not ", "EASY");
        q_learn_the_basics_learn_basic_recursion_check_if_string_is_palindrome_or_not.setSolveLink("https://leetcode.com/problems/valid-palindrome/");
        q_learn_the_basics_learn_basic_recursion_check_if_string_is_palindrome_or_not.setEditorialLink("https://takeuforward.org/plus/dsa/problems/check-if-string-is-palindrome-or-not-?tab=editorial");
        
        
        q_learn_the_basics_learn_basic_recursion_check_if_string_is_palindrome_or_not.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=twuC1F6gLI8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=4"));
        
        q_learn_the_basics_learn_basic_recursion_check_if_string_is_palindrome_or_not.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/check-if-the-given-string-is-palindrome-or-not/"));
        
        
        topic_1_6.addQuestion(q_learn_the_basics_learn_basic_recursion_check_if_string_is_palindrome_or_not);
        
        Question q_learn_the_basics_learn_basic_recursion_fibonacci_number = new Question("learn_the_basics_learn_basic_recursion_fibonacci_number", "Fibonacci Number", "EASY");
        q_learn_the_basics_learn_basic_recursion_fibonacci_number.setSolveLink("https://leetcode.com/problems/fibonacci-number/");
        q_learn_the_basics_learn_basic_recursion_fibonacci_number.setEditorialLink("https://takeuforward.org/plus/dsa/problems/fibonacci-number?tab=editorial");
        
        
        q_learn_the_basics_learn_basic_recursion_fibonacci_number.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=kvRjNm4rVBE&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=5"));
        
        q_learn_the_basics_learn_basic_recursion_fibonacci_number.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/print-fibonacci-series-up-to-nth-term/"));
        
        
        topic_1_6.addQuestion(q_learn_the_basics_learn_basic_recursion_fibonacci_number);
        
        
        section_1.addTopic(topic_1_6);
        
        // Topic: Learn Basic Hashing
        Topic topic_1_7 = new Topic("learn_the_basics_learn_basic_hashing", "Learn Basic Hashing");
        
        
        
        Question q_learn_the_basics_learn_basic_hashing_basic_hashing = new Question("learn_the_basics_learn_basic_hashing_basic_hashing", "Basic Hashing", "EASY");
        q_learn_the_basics_learn_basic_hashing_basic_hashing.setSolveLink("https://takeuforward.org/plus/dsa/problems/basic-hashing");
        q_learn_the_basics_learn_basic_hashing_basic_hashing.setEditorialLink("https://takeuforward.org/plus/dsa/problems/basic-hashing");
        
        
        q_learn_the_basics_learn_basic_hashing_basic_hashing.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=KEs5UyBJ39g"));
        
        q_learn_the_basics_learn_basic_hashing_basic_hashing.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/hashing/hashing-maps-time-complexity-collisions-division-rule-of-hashing-strivers-a2z-dsa-course/"));
        
        
        topic_1_7.addQuestion(q_learn_the_basics_learn_basic_hashing_basic_hashing);
        
        Question q_learn_the_basics_learn_basic_hashing_counting_frequencies_of_array_elements = new Question("learn_the_basics_learn_basic_hashing_counting_frequencies_of_array_elements", "Counting Frequencies of Array Elements", "EASY");
        q_learn_the_basics_learn_basic_hashing_counting_frequencies_of_array_elements.setSolveLink("https://takeuforward.org/plus/dsa/problems/counting-frequencies-of-array-elements");
        q_learn_the_basics_learn_basic_hashing_counting_frequencies_of_array_elements.setEditorialLink("https://takeuforward.org/plus/dsa/problems/counting-frequencies-of-array-elements?tab=editorial");
        
        
        q_learn_the_basics_learn_basic_hashing_counting_frequencies_of_array_elements.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/count-frequency-of-each-element-in-the-array/"));
        
        
        topic_1_7.addQuestion(q_learn_the_basics_learn_basic_hashing_counting_frequencies_of_array_elements);
        
        Question q_learn_the_basics_learn_basic_hashing_highest_occurring_element_in_an_array = new Question("learn_the_basics_learn_basic_hashing_highest_occurring_element_in_an_array", "Highest Occurring Element in an Array", "EASY");
        q_learn_the_basics_learn_basic_hashing_highest_occurring_element_in_an_array.setSolveLink("https://leetcode.com/problems/frequency-of-the-most-frequent-element/");
        q_learn_the_basics_learn_basic_hashing_highest_occurring_element_in_an_array.setEditorialLink("https://takeuforward.org/plus/dsa/problems/highest-occurring-element-in-an-array?tab=editorial");
        
        
        q_learn_the_basics_learn_basic_hashing_highest_occurring_element_in_an_array.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/find-the-highest-lowest-frequency-element/"));
        
        
        topic_1_7.addQuestion(q_learn_the_basics_learn_basic_hashing_highest_occurring_element_in_an_array);
        
        
        section_1.addTopic(topic_1_7);
        
        
        Roadmap.addSection(section_1);
        
        // ==========================================
        // Section: Learn Important Sorting Techniques
        // ==========================================
        RoadmapSection section_2 = new RoadmapSection("learn_important_sorting_techniques", "Learn Important Sorting Techniques");
        
        
        
        // Topic: Sorting-I
        Topic topic_2_1 = new Topic("learn_important_sorting_techniques_sorting_i", "Sorting-I");
        
        
        
        Question q_learn_important_sorting_techniques_sorting_i_selection_sort = new Question("learn_important_sorting_techniques_sorting_i_selection_sort", "Selection Sort", "EASY");
        q_learn_important_sorting_techniques_sorting_i_selection_sort.setSolveLink("https://takeuforward.org/plus/dsa/problems/selection-sort");
        q_learn_important_sorting_techniques_sorting_i_selection_sort.setEditorialLink("https://takeuforward.org/plus/dsa/problems/selection-sort?tab=editorial");
        
        
        q_learn_important_sorting_techniques_sorting_i_selection_sort.addLink(new QuestionLink("VIDEO", "https://youtu.be/HGk_ypEuS24?t=167"));
        
        q_learn_important_sorting_techniques_sorting_i_selection_sort.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/sorting/selection-sort-algorithm/"));
        
        
        topic_2_1.addQuestion(q_learn_important_sorting_techniques_sorting_i_selection_sort);
        
        Question q_learn_important_sorting_techniques_sorting_i_bubble_sort = new Question("learn_important_sorting_techniques_sorting_i_bubble_sort", "Bubble Sort", "EASY");
        q_learn_important_sorting_techniques_sorting_i_bubble_sort.setSolveLink("https://takeuforward.org/plus/dsa/problems/bubble-sort");
        q_learn_important_sorting_techniques_sorting_i_bubble_sort.setEditorialLink("https://takeuforward.org/plus/dsa/problems/bubble-sort?tab=editorial");
        
        
        q_learn_important_sorting_techniques_sorting_i_bubble_sort.addLink(new QuestionLink("VIDEO", "https://youtu.be/HGk_ypEuS24?t=1061"));
        
        q_learn_important_sorting_techniques_sorting_i_bubble_sort.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/bubble-sort-algorithm/"));
        
        
        topic_2_1.addQuestion(q_learn_important_sorting_techniques_sorting_i_bubble_sort);
        
        Question q_learn_important_sorting_techniques_sorting_i_insertion_sorting = new Question("learn_important_sorting_techniques_sorting_i_insertion_sorting", "Insertion Sorting", "EASY");
        q_learn_important_sorting_techniques_sorting_i_insertion_sorting.setSolveLink("https://takeuforward.org/plus/dsa/problems/insertion-sorting");
        q_learn_important_sorting_techniques_sorting_i_insertion_sorting.setEditorialLink("https://takeuforward.org/plus/dsa/problems/insertion-sorting?tab=editorial");
        
        
        q_learn_important_sorting_techniques_sorting_i_insertion_sorting.addLink(new QuestionLink("VIDEO", "https://youtu.be/HGk_ypEuS24?t=1900"));
        
        q_learn_important_sorting_techniques_sorting_i_insertion_sorting.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/insertion-sort-algorithm/"));
        
        
        topic_2_1.addQuestion(q_learn_important_sorting_techniques_sorting_i_insertion_sorting);
        
        
        section_2.addTopic(topic_2_1);
        
        // Topic: Sorting-II
        Topic topic_2_2 = new Topic("learn_important_sorting_techniques_sorting_ii", "Sorting-II");
        
        
        
        Question q_learn_important_sorting_techniques_sorting_ii_merge_sorting = new Question("learn_important_sorting_techniques_sorting_ii_merge_sorting", "Merge Sorting", "MEDIUM");
        q_learn_important_sorting_techniques_sorting_ii_merge_sorting.setSolveLink("https://takeuforward.org/plus/dsa/problems/merge-sorting");
        q_learn_important_sorting_techniques_sorting_ii_merge_sorting.setEditorialLink("https://takeuforward.org/plus/dsa/problems/merge-sorting?tab=editorial");
        
        
        q_learn_important_sorting_techniques_sorting_ii_merge_sorting.addLink(new QuestionLink("VIDEO", "https://youtu.be/ogjf7ORKfd8"));
        
        q_learn_important_sorting_techniques_sorting_ii_merge_sorting.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/merge-sort-algorithm/"));
        
        
        topic_2_2.addQuestion(q_learn_important_sorting_techniques_sorting_ii_merge_sorting);
        
        Question q_learn_important_sorting_techniques_sorting_ii_recursive_bubble_sort = new Question("learn_important_sorting_techniques_sorting_ii_recursive_bubble_sort", "Recursive Bubble Sort", "EASY");
        q_learn_important_sorting_techniques_sorting_ii_recursive_bubble_sort.setSolveLink("https://takeuforward.org/plus/dsa/problems/recursive-bubble-sort");
        q_learn_important_sorting_techniques_sorting_ii_recursive_bubble_sort.setEditorialLink("https://takeuforward.org/plus/dsa/problems/recursive-bubble-sort?tab=editorial");
        
        
        q_learn_important_sorting_techniques_sorting_ii_recursive_bubble_sort.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/recursive-bubble-sort-algorithm/"));
        
        
        topic_2_2.addQuestion(q_learn_important_sorting_techniques_sorting_ii_recursive_bubble_sort);
        
        Question q_learn_important_sorting_techniques_sorting_ii_recursive_insertion_sort = new Question("learn_important_sorting_techniques_sorting_ii_recursive_insertion_sort", "Recursive Insertion Sort", "EASY");
        q_learn_important_sorting_techniques_sorting_ii_recursive_insertion_sort.setSolveLink("https://takeuforward.org/plus/dsa/problems/recursive-insertion-sort");
        q_learn_important_sorting_techniques_sorting_ii_recursive_insertion_sort.setEditorialLink("https://takeuforward.org/plus/dsa/problems/recursive-insertion-sort?tab=editorial");
        
        
        q_learn_important_sorting_techniques_sorting_ii_recursive_insertion_sort.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/recursive-insertion-sort-algorithm/"));
        
        
        topic_2_2.addQuestion(q_learn_important_sorting_techniques_sorting_ii_recursive_insertion_sort);
        
        Question q_learn_important_sorting_techniques_sorting_ii_quick_sorting = new Question("learn_important_sorting_techniques_sorting_ii_quick_sorting", "Quick Sorting", "EASY");
        q_learn_important_sorting_techniques_sorting_ii_quick_sorting.setSolveLink("https://takeuforward.org/plus/dsa/problems/quick-sorting");
        q_learn_important_sorting_techniques_sorting_ii_quick_sorting.setEditorialLink("https://takeuforward.org/plus/dsa/problems/quick-sorting?tab=editorial");
        
        
        q_learn_important_sorting_techniques_sorting_ii_quick_sorting.addLink(new QuestionLink("VIDEO", "https://youtu.be/WIrA4YexLRQ"));
        
        q_learn_important_sorting_techniques_sorting_ii_quick_sorting.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/quick-sort-algorithm/"));
        
        
        topic_2_2.addQuestion(q_learn_important_sorting_techniques_sorting_ii_quick_sorting);
        
        
        section_2.addTopic(topic_2_2);
        
        
        Roadmap.addSection(section_2);
        
        // ==========================================
        // Section: Solve Problems on Arrays [Easy -> Medium -> Hard]
        // ==========================================
        RoadmapSection section_3 = new RoadmapSection("solve_problems_on_arrays_easy_medium_hard", "Solve Problems on Arrays [Easy -> Medium -> Hard]");
        
        
        
        // Topic: Easy
        Topic topic_3_1 = new Topic("solve_problems_on_arrays_easy_medium_hard_easy", "Easy");
        
        
        
        Question q_solve_problems_on_arrays_easy_medium_hard_easy_largest_element = new Question("solve_problems_on_arrays_easy_medium_hard_easy_largest_element", "Largest Element ", "EASY");
        q_solve_problems_on_arrays_easy_medium_hard_easy_largest_element.setSolveLink("https://takeuforward.org/plus/dsa/problems/largest-element");
        q_solve_problems_on_arrays_easy_medium_hard_easy_largest_element.setEditorialLink("https://takeuforward.org/plus/dsa/problems/largest-element?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_largest_element.addLink(new QuestionLink("VIDEO", "https://youtu.be/37E9ckMDdTk?t=526"));
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_largest_element.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/find-the-largest-element-in-an-array/"));
        
        
        topic_3_1.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_easy_largest_element);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_easy_second_largest_element = new Question("solve_problems_on_arrays_easy_medium_hard_easy_second_largest_element", "Second Largest Element", "EASY");
        q_solve_problems_on_arrays_easy_medium_hard_easy_second_largest_element.setSolveLink("https://takeuforward.org/plus/dsa/problems/second-largest-element");
        q_solve_problems_on_arrays_easy_medium_hard_easy_second_largest_element.setEditorialLink("https://takeuforward.org/plus/dsa/problems/second-largest-element?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_second_largest_element.addLink(new QuestionLink("VIDEO", "https://youtu.be/37E9ckMDdTk?t=810"));
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_second_largest_element.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/find-second-smallest-and-second-largest-element-in-an-array/"));
        
        
        topic_3_1.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_easy_second_largest_element);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_easy_check_if_the_array_is_sorted_ii = new Question("solve_problems_on_arrays_easy_medium_hard_easy_check_if_the_array_is_sorted_ii", "Check if the Array is Sorted II", "EASY");
        q_solve_problems_on_arrays_easy_medium_hard_easy_check_if_the_array_is_sorted_ii.setSolveLink("https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/#:~:text=Input%3A%20nums%20%3D%20%5B2%2C,no%20rotation)%20to%20make%20nums.");
        q_solve_problems_on_arrays_easy_medium_hard_easy_check_if_the_array_is_sorted_ii.setEditorialLink("https://takeuforward.org/plus/dsa/problems/check-if-the-array-is-sorted-ii?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_check_if_the_array_is_sorted_ii.addLink(new QuestionLink("VIDEO", "https://youtu.be/37E9ckMDdTk?t=17224"));
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_check_if_the_array_is_sorted_ii.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/check-if-an-array-is-sorted/"));
        
        
        topic_3_1.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_easy_check_if_the_array_is_sorted_ii);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_easy_remove_duplicates_from_sorted_array = new Question("solve_problems_on_arrays_easy_medium_hard_easy_remove_duplicates_from_sorted_array", "Remove duplicates from Sorted array", "EASY");
        q_solve_problems_on_arrays_easy_medium_hard_easy_remove_duplicates_from_sorted_array.setSolveLink("https://leetcode.com/problems/remove-duplicates-from-sorted-array/#:~:text=Input%3A%20nums%20%3D%20%5B0%2C,%2C%203%2C%20and%204%20respectively.");
        q_solve_problems_on_arrays_easy_medium_hard_easy_remove_duplicates_from_sorted_array.setEditorialLink("https://takeuforward.org/plus/dsa/problems/remove-duplicates-from-sorted-array?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_remove_duplicates_from_sorted_array.addLink(new QuestionLink("VIDEO", "https://youtu.be/37E9ckMDdTk?t=1887"));
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_remove_duplicates_from_sorted_array.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/remove-duplicates-in-place-from-sorted-array/"));
        
        
        topic_3_1.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_easy_remove_duplicates_from_sorted_array);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_easy_left_rotate_array_by_one = new Question("solve_problems_on_arrays_easy_medium_hard_easy_left_rotate_array_by_one", "Left Rotate Array by One", "EASY");
        q_solve_problems_on_arrays_easy_medium_hard_easy_left_rotate_array_by_one.setSolveLink("https://leetcode.com/problems/rotate-array/");
        q_solve_problems_on_arrays_easy_medium_hard_easy_left_rotate_array_by_one.setEditorialLink("https://takeuforward.org/plus/dsa/problems/left-rotate-array-by-one?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_left_rotate_array_by_one.addLink(new QuestionLink("VIDEO", "https://youtu.be/wvcQg43_V8U?t=61"));
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_left_rotate_array_by_one.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/left-rotate-the-array-by-one/"));
        
        
        topic_3_1.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_easy_left_rotate_array_by_one);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_easy_left_rotate_array_by_k_places = new Question("solve_problems_on_arrays_easy_medium_hard_easy_left_rotate_array_by_k_places", "Left Rotate Array by K Places", "EASY");
        q_solve_problems_on_arrays_easy_medium_hard_easy_left_rotate_array_by_k_places.setSolveLink("https://leetcode.com/problems/rotate-array/");
        q_solve_problems_on_arrays_easy_medium_hard_easy_left_rotate_array_by_k_places.setEditorialLink("https://takeuforward.org/plus/dsa/problems/left-rotate-array?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_left_rotate_array_by_k_places.addLink(new QuestionLink("VIDEO", "https://youtu.be/wvcQg43_V8U?t=485"));
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_left_rotate_array_by_k_places.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/rotate-array-by-k-elements/"));
        
        
        topic_3_1.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_easy_left_rotate_array_by_k_places);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_easy_move_zeros_to_end = new Question("solve_problems_on_arrays_easy_medium_hard_easy_move_zeros_to_end", "Move Zeros to End", "EASY");
        q_solve_problems_on_arrays_easy_medium_hard_easy_move_zeros_to_end.setSolveLink("https://leetcode.com/problems/move-zeroes/");
        q_solve_problems_on_arrays_easy_medium_hard_easy_move_zeros_to_end.setEditorialLink("https://takeuforward.org/plus/dsa/problems/move-zeros-to-end?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_move_zeros_to_end.addLink(new QuestionLink("VIDEO", "https://youtu.be/wvcQg43_V8U?t=1633"));
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_move_zeros_to_end.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/move-all-zeros-to-the-end-of-the-array/"));
        
        
        topic_3_1.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_easy_move_zeros_to_end);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_easy_linear_search = new Question("solve_problems_on_arrays_easy_medium_hard_easy_linear_search", "Linear Search", "EASY");
        q_solve_problems_on_arrays_easy_medium_hard_easy_linear_search.setSolveLink("https://takeuforward.org/plus/dsa/problems/linear-search");
        q_solve_problems_on_arrays_easy_medium_hard_easy_linear_search.setEditorialLink("https://takeuforward.org/plus/dsa/problems/linear-search?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_linear_search.addLink(new QuestionLink("VIDEO", "https://youtu.be/wvcQg43_V8U?t=2465"));
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_linear_search.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/linear-search-in-c/"));
        
        
        topic_3_1.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_easy_linear_search);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_easy_union_of_two_sorted_arrays = new Question("solve_problems_on_arrays_easy_medium_hard_easy_union_of_two_sorted_arrays", "Union of two sorted arrays", "EASY");
        q_solve_problems_on_arrays_easy_medium_hard_easy_union_of_two_sorted_arrays.setSolveLink("https://takeuforward.org/plus/dsa/problems/union-of-two-sorted-arrays");
        q_solve_problems_on_arrays_easy_medium_hard_easy_union_of_two_sorted_arrays.setEditorialLink("https://takeuforward.org/plus/dsa/problems/union-of-two-sorted-arrays?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_union_of_two_sorted_arrays.addLink(new QuestionLink("VIDEO", "https://youtu.be/wvcQg43_V8U?t=2584"));
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_union_of_two_sorted_arrays.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/union-of-two-sorted-arrays/"));
        
        
        topic_3_1.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_easy_union_of_two_sorted_arrays);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_easy_find_missing_number = new Question("solve_problems_on_arrays_easy_medium_hard_easy_find_missing_number", "Find missing number", "EASY");
        q_solve_problems_on_arrays_easy_medium_hard_easy_find_missing_number.setSolveLink("https://takeuforward.org/plus/dsa/problems/find-missing-number");
        q_solve_problems_on_arrays_easy_medium_hard_easy_find_missing_number.setEditorialLink("");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_find_missing_number.addLink(new QuestionLink("ARTICLE", "https://www.geeksforgeeks.org/find-the-missing-number/"));
        
        
        topic_3_1.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_easy_find_missing_number);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_easy_maximum_consecutive_ones = new Question("solve_problems_on_arrays_easy_medium_hard_easy_maximum_consecutive_ones", "Maximum Consecutive Ones", "EASY");
        q_solve_problems_on_arrays_easy_medium_hard_easy_maximum_consecutive_ones.setSolveLink("https://leetcode.com/problems/max-consecutive-ones/");
        q_solve_problems_on_arrays_easy_medium_hard_easy_maximum_consecutive_ones.setEditorialLink("https://takeuforward.org/plus/dsa/problems/maximum-consecutive-ones?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_maximum_consecutive_ones.addLink(new QuestionLink("VIDEO", "https://youtu.be/bYWLJb3vCWY?t=1124"));
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_maximum_consecutive_ones.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/count-maximum-consecutive-ones-in-the-array/"));
        
        
        topic_3_1.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_easy_maximum_consecutive_ones);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_easy_find_the_number_that_appears_once_and_other_numbers_twice = new Question("solve_problems_on_arrays_easy_medium_hard_easy_find_the_number_that_appears_once_and_other_numbers_twice", "Find the number that appears once, and other numbers twice.", "MEDIUM");
        q_solve_problems_on_arrays_easy_medium_hard_easy_find_the_number_that_appears_once_and_other_numbers_twice.setSolveLink("https://leetcode.com/problems/single-number/");
        q_solve_problems_on_arrays_easy_medium_hard_easy_find_the_number_that_appears_once_and_other_numbers_twice.setEditorialLink("https://takeuforward.org/plus/dsa/problems/single-number---i?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_find_the_number_that_appears_once_and_other_numbers_twice.addLink(new QuestionLink("VIDEO", "https://youtu.be/bYWLJb3vCWY?t=1369"));
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_find_the_number_that_appears_once_and_other_numbers_twice.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/find-the-number-that-appears-once-and-the-other-numbers-twice/"));
        
        
        topic_3_1.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_easy_find_the_number_that_appears_once_and_other_numbers_twice);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_easy_longest_subarray_with_given_sum_kpositives = new Question("solve_problems_on_arrays_easy_medium_hard_easy_longest_subarray_with_given_sum_kpositives", "Longest subarray with given sum K(positives)", "MEDIUM");
        q_solve_problems_on_arrays_easy_medium_hard_easy_longest_subarray_with_given_sum_kpositives.setSolveLink("https://takeuforward.org/plus/dsa/problems/longest-subarray-with-sum-k");
        q_solve_problems_on_arrays_easy_medium_hard_easy_longest_subarray_with_given_sum_kpositives.setEditorialLink("https://takeuforward.org/plus/dsa/problems/longest-subarray-with-sum-k?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_longest_subarray_with_given_sum_kpositives.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=frf7qxiN2qU&feature=youtu.be"));
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_longest_subarray_with_given_sum_kpositives.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k/"));
        
        
        topic_3_1.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_easy_longest_subarray_with_given_sum_kpositives);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_easy_longest_subarray_with_sum_k = new Question("solve_problems_on_arrays_easy_medium_hard_easy_longest_subarray_with_sum_k", "Longest subarray with sum K", "MEDIUM");
        q_solve_problems_on_arrays_easy_medium_hard_easy_longest_subarray_with_sum_k.setSolveLink("https://takeuforward.org/plus/dsa/problems/longest-subarray-with-sum-k");
        q_solve_problems_on_arrays_easy_medium_hard_easy_longest_subarray_with_sum_k.setEditorialLink("https://takeuforward.org/plus/dsa/problems/longest-subarray-with-sum-k?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_longest_subarray_with_sum_k.addLink(new QuestionLink("VIDEO", "https://youtu.be/frf7qxiN2qU"));
        
        q_solve_problems_on_arrays_easy_medium_hard_easy_longest_subarray_with_sum_k.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/length-of-the-longest-subarray-with-zero-sum/"));
        
        
        topic_3_1.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_easy_longest_subarray_with_sum_k);
        
        
        section_3.addTopic(topic_3_1);
        
        // Topic: Medium
        Topic topic_3_2 = new Topic("solve_problems_on_arrays_easy_medium_hard_medium", "Medium");
        
        
        
        Question q_solve_problems_on_arrays_easy_medium_hard_medium_two_sum = new Question("solve_problems_on_arrays_easy_medium_hard_medium_two_sum", "Two Sum", "EASY");
        q_solve_problems_on_arrays_easy_medium_hard_medium_two_sum.setSolveLink("https://leetcode.com/problems/two-sum/");
        q_solve_problems_on_arrays_easy_medium_hard_medium_two_sum.setEditorialLink("https://takeuforward.org/plus/dsa/problems/two-sum?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_two_sum.addLink(new QuestionLink("VIDEO", "https://youtu.be/UXDSeD9mN-k"));
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_two_sum.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-sum-exists-in-array/"));
        
        
        topic_3_2.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_medium_two_sum);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_medium_sort_an_array_of_0s_1s_and_2s = new Question("solve_problems_on_arrays_easy_medium_hard_medium_sort_an_array_of_0s_1s_and_2s", "Sort an array of 0's 1's and 2's", "MEDIUM");
        q_solve_problems_on_arrays_easy_medium_hard_medium_sort_an_array_of_0s_1s_and_2s.setSolveLink("https://leetcode.com/problems/sort-colors/");
        q_solve_problems_on_arrays_easy_medium_hard_medium_sort_an_array_of_0s_1s_and_2s.setEditorialLink("https://takeuforward.org/plus/dsa/problems/sort-an-array-of-0's-1's-and-2's?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_sort_an_array_of_0s_1s_and_2s.addLink(new QuestionLink("VIDEO", "https://youtu.be/tp8JIuCXBaU"));
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_sort_an_array_of_0s_1s_and_2s.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/sort-an-array-of-0s-1s-and-2s/"));
        
        
        topic_3_2.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_medium_sort_an_array_of_0s_1s_and_2s);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_medium_majority_element_i = new Question("solve_problems_on_arrays_easy_medium_hard_medium_majority_element_i", "Majority Element-I", "EASY");
        q_solve_problems_on_arrays_easy_medium_hard_medium_majority_element_i.setSolveLink("https://leetcode.com/problems/majority-element/");
        q_solve_problems_on_arrays_easy_medium_hard_medium_majority_element_i.setEditorialLink("https://takeuforward.org/plus/dsa/problems/majority-element-i?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_majority_element_i.addLink(new QuestionLink("VIDEO", "https://youtu.be/nP_ns3uSh80"));
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_majority_element_i.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times/"));
        
        
        topic_3_2.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_medium_majority_element_i);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_medium_kadanes_algorithm = new Question("solve_problems_on_arrays_easy_medium_hard_medium_kadanes_algorithm", "Kadane's Algorithm", "MEDIUM");
        q_solve_problems_on_arrays_easy_medium_hard_medium_kadanes_algorithm.setSolveLink("https://leetcode.com/problems/maximum-subarray/");
        q_solve_problems_on_arrays_easy_medium_hard_medium_kadanes_algorithm.setEditorialLink("https://takeuforward.org/plus/dsa/problems/kadane's-algorithm?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_kadanes_algorithm.addLink(new QuestionLink("VIDEO", "https://youtu.be/AHZpyENo7k4?si=QJpof4R1hHokm1hw"));
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_kadanes_algorithm.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array/"));
        
        
        topic_3_2.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_medium_kadanes_algorithm);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_medium_print_subarray_with_maximum_subarray_sum_extended_version_of_above_problem = new Question("solve_problems_on_arrays_easy_medium_hard_medium_print_subarray_with_maximum_subarray_sum_extended_version_of_above_problem", "Print subarray with maximum subarray sum (extended version of above problem)", "MEDIUM");
        q_solve_problems_on_arrays_easy_medium_hard_medium_print_subarray_with_maximum_subarray_sum_extended_version_of_above_problem.setSolveLink("https://takeuforward.org/plus/dsa/problems/kadane's-algorithm");
        q_solve_problems_on_arrays_easy_medium_hard_medium_print_subarray_with_maximum_subarray_sum_extended_version_of_above_problem.setEditorialLink("https://takeuforward.org/plus/dsa/problems/kadane's-algorithm?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_print_subarray_with_maximum_subarray_sum_extended_version_of_above_problem.addLink(new QuestionLink("VIDEO", "https://youtu.be/AHZpyENo7k4"));
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_print_subarray_with_maximum_subarray_sum_extended_version_of_above_problem.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array/"));
        
        
        topic_3_2.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_medium_print_subarray_with_maximum_subarray_sum_extended_version_of_above_problem);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_medium_stock_buy_and_sell = new Question("solve_problems_on_arrays_easy_medium_hard_medium_stock_buy_and_sell", "Stock Buy and Sell", "MEDIUM");
        q_solve_problems_on_arrays_easy_medium_hard_medium_stock_buy_and_sell.setSolveLink("https://leetcode.com/problems/best-time-to-buy-and-sell-stock/");
        q_solve_problems_on_arrays_easy_medium_hard_medium_stock_buy_and_sell.setEditorialLink("https://takeuforward.org/plus/dsa/problems/best-time-to-buy-and-sell-stock?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_stock_buy_and_sell.addLink(new QuestionLink("VIDEO", "https://youtu.be/excAOvwF_Wk"));
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_stock_buy_and_sell.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/stock-buy-and-sell/"));
        
        
        topic_3_2.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_medium_stock_buy_and_sell);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_medium_rearrange_array_elements_by_sign = new Question("solve_problems_on_arrays_easy_medium_hard_medium_rearrange_array_elements_by_sign", "Rearrange array elements by sign", "MEDIUM");
        q_solve_problems_on_arrays_easy_medium_hard_medium_rearrange_array_elements_by_sign.setSolveLink("https://leetcode.com/problems/rearrange-array-elements-by-sign/");
        q_solve_problems_on_arrays_easy_medium_hard_medium_rearrange_array_elements_by_sign.setEditorialLink("https://takeuforward.org/plus/dsa/problems/rearrange-array-elements-by-sign?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_rearrange_array_elements_by_sign.addLink(new QuestionLink("VIDEO", "https://youtu.be/h4aBagy4Uok"));
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_rearrange_array_elements_by_sign.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/rearrange-array-elements-by-sign/"));
        
        
        topic_3_2.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_medium_rearrange_array_elements_by_sign);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_medium_next_permutation = new Question("solve_problems_on_arrays_easy_medium_hard_medium_next_permutation", "Next Permutation", "MEDIUM");
        q_solve_problems_on_arrays_easy_medium_hard_medium_next_permutation.setSolveLink("https://leetcode.com/problems/next-permutation/");
        q_solve_problems_on_arrays_easy_medium_hard_medium_next_permutation.setEditorialLink("https://takeuforward.org/plus/dsa/problems/next-permutation?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_next_permutation.addLink(new QuestionLink("VIDEO", "https://youtu.be/JDOXKqF60RQ"));
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_next_permutation.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/"));
        
        
        topic_3_2.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_medium_next_permutation);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_medium_leaders_in_an_array = new Question("solve_problems_on_arrays_easy_medium_hard_medium_leaders_in_an_array", "Leaders in an Array", "MEDIUM");
        q_solve_problems_on_arrays_easy_medium_hard_medium_leaders_in_an_array.setSolveLink("https://takeuforward.org/plus/dsa/problems/leaders-in-an-array");
        q_solve_problems_on_arrays_easy_medium_hard_medium_leaders_in_an_array.setEditorialLink("https://takeuforward.org/plus/dsa/problems/leaders-in-an-array?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_leaders_in_an_array.addLink(new QuestionLink("VIDEO", "https://youtu.be/cHrH9CQ8pmY"));
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_leaders_in_an_array.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/leaders-in-an-array/"));
        
        
        topic_3_2.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_medium_leaders_in_an_array);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_medium_longest_consecutive_sequence_in_an_array = new Question("solve_problems_on_arrays_easy_medium_hard_medium_longest_consecutive_sequence_in_an_array", "Longest Consecutive Sequence in an Array", "MEDIUM");
        q_solve_problems_on_arrays_easy_medium_hard_medium_longest_consecutive_sequence_in_an_array.setSolveLink("https://leetcode.com/problems/longest-consecutive-sequence/solution/");
        q_solve_problems_on_arrays_easy_medium_hard_medium_longest_consecutive_sequence_in_an_array.setEditorialLink("https://takeuforward.org/plus/dsa/problems/longest-consecutive-sequence-in-an-array?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_longest_consecutive_sequence_in_an_array.addLink(new QuestionLink("VIDEO", "https://youtu.be/oO5uLE7EUlM"));
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_longest_consecutive_sequence_in_an_array.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/longest-consecutive-sequence-in-an-array/"));
        
        
        topic_3_2.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_medium_longest_consecutive_sequence_in_an_array);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_medium_set_matrix_zeroes = new Question("solve_problems_on_arrays_easy_medium_hard_medium_set_matrix_zeroes", "Set Matrix Zeroes", "MEDIUM");
        q_solve_problems_on_arrays_easy_medium_hard_medium_set_matrix_zeroes.setSolveLink("https://leetcode.com/problems/set-matrix-zeroes/");
        q_solve_problems_on_arrays_easy_medium_hard_medium_set_matrix_zeroes.setEditorialLink("https://takeuforward.org/plus/dsa/problems/set-matrix-zeroes?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_set_matrix_zeroes.addLink(new QuestionLink("VIDEO", "https://youtu.be/N0MgLvceX7M"));
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_set_matrix_zeroes.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/set-matrix-zero/"));
        
        
        topic_3_2.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_medium_set_matrix_zeroes);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_medium_rotate_matrix_by_90_degrees = new Question("solve_problems_on_arrays_easy_medium_hard_medium_rotate_matrix_by_90_degrees", "Rotate matrix by 90 degrees", "MEDIUM");
        q_solve_problems_on_arrays_easy_medium_hard_medium_rotate_matrix_by_90_degrees.setSolveLink("https://leetcode.com/problems/rotate-image/");
        q_solve_problems_on_arrays_easy_medium_hard_medium_rotate_matrix_by_90_degrees.setEditorialLink("https://takeuforward.org/plus/dsa/problems/rotate-matrix-by-90-degrees?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_rotate_matrix_by_90_degrees.addLink(new QuestionLink("VIDEO", "https://youtu.be/Z0R2u6gd3GU"));
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_rotate_matrix_by_90_degrees.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/rotate-image-by-90-degree/"));
        
        
        topic_3_2.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_medium_rotate_matrix_by_90_degrees);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_medium_print_the_matrix_in_spiral_manner = new Question("solve_problems_on_arrays_easy_medium_hard_medium_print_the_matrix_in_spiral_manner", "Print the matrix in spiral manner", "MEDIUM");
        q_solve_problems_on_arrays_easy_medium_hard_medium_print_the_matrix_in_spiral_manner.setSolveLink("https://leetcode.com/problems/spiral-matrix/");
        q_solve_problems_on_arrays_easy_medium_hard_medium_print_the_matrix_in_spiral_manner.setEditorialLink("https://takeuforward.org/plus/dsa/problems/print-the-matrix-in-spiral-manner?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_print_the_matrix_in_spiral_manner.addLink(new QuestionLink("VIDEO", "https://youtu.be/3Zv-s9UUrFM"));
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_print_the_matrix_in_spiral_manner.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/spiral-traversal-of-matrix/"));
        
        
        topic_3_2.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_medium_print_the_matrix_in_spiral_manner);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_medium_count_subarrays_with_given_sum = new Question("solve_problems_on_arrays_easy_medium_hard_medium_count_subarrays_with_given_sum", "Count subarrays with given sum", "MEDIUM");
        q_solve_problems_on_arrays_easy_medium_hard_medium_count_subarrays_with_given_sum.setSolveLink("https://leetcode.com/problems/subarray-sum-equals-k/");
        q_solve_problems_on_arrays_easy_medium_hard_medium_count_subarrays_with_given_sum.setEditorialLink("https://takeuforward.org/plus/dsa/problems/count-subarrays-with-given-sum?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_count_subarrays_with_given_sum.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=xvNwoz-ufXA&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=32"));
        
        q_solve_problems_on_arrays_easy_medium_hard_medium_count_subarrays_with_given_sum.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/count-subarray-sum-equals-k/"));
        
        
        topic_3_2.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_medium_count_subarrays_with_given_sum);
        
        
        section_3.addTopic(topic_3_2);
        
        // Topic: Hard
        Topic topic_3_3 = new Topic("solve_problems_on_arrays_easy_medium_hard_hard", "Hard");
        
        
        
        Question q_solve_problems_on_arrays_easy_medium_hard_hard_pascals_triangle_i = new Question("solve_problems_on_arrays_easy_medium_hard_hard_pascals_triangle_i", "Pascal's Triangle I", "EASY");
        q_solve_problems_on_arrays_easy_medium_hard_hard_pascals_triangle_i.setSolveLink("https://leetcode.com/problems/pascals-triangle/");
        q_solve_problems_on_arrays_easy_medium_hard_hard_pascals_triangle_i.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pascals-triangle-i?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_pascals_triangle_i.addLink(new QuestionLink("VIDEO", "https://youtu.be/bR7mQgwQ_o8"));
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_pascals_triangle_i.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/program-to-generate-pascals-triangle"));
        
        
        topic_3_3.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_hard_pascals_triangle_i);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_hard_majority_element_ii = new Question("solve_problems_on_arrays_easy_medium_hard_hard_majority_element_ii", "Majority Element-II", "HARD");
        q_solve_problems_on_arrays_easy_medium_hard_hard_majority_element_ii.setSolveLink("https://leetcode.com/problems/majority-element-ii/");
        q_solve_problems_on_arrays_easy_medium_hard_hard_majority_element_ii.setEditorialLink("https://takeuforward.org/plus/dsa/problems/majority-element-ii?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_majority_element_ii.addLink(new QuestionLink("VIDEO", "https://youtu.be/vwZj1K0e9U8"));
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_majority_element_ii.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/majority-elementsn-3-times-find-the-elements-that-appears-more-than-n-3-times-in-the-array/"));
        
        
        topic_3_3.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_hard_majority_element_ii);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_hard_3_sum = new Question("solve_problems_on_arrays_easy_medium_hard_hard_3_sum", "3 Sum", "MEDIUM");
        q_solve_problems_on_arrays_easy_medium_hard_hard_3_sum.setSolveLink("https://leetcode.com/problems/3sum/");
        q_solve_problems_on_arrays_easy_medium_hard_hard_3_sum.setEditorialLink("https://takeuforward.org/plus/dsa/problems/3-sum?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_3_sum.addLink(new QuestionLink("VIDEO", "https://youtu.be/DhFh8Kw7ymk"));
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_3_sum.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/3-sum-find-triplets-that-add-up-to-a-zero/"));
        
        
        topic_3_3.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_hard_3_sum);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_hard_4_sum = new Question("solve_problems_on_arrays_easy_medium_hard_hard_4_sum", "4 Sum", "MEDIUM");
        q_solve_problems_on_arrays_easy_medium_hard_hard_4_sum.setSolveLink("https://leetcode.com/problems/4sum/");
        q_solve_problems_on_arrays_easy_medium_hard_hard_4_sum.setEditorialLink("https://takeuforward.org/plus/dsa/problems/4-sum?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_4_sum.addLink(new QuestionLink("VIDEO", "https://youtu.be/eD95WRfh81c"));
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_4_sum.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/4-sum-find-quads-that-add-up-to-a-target-value/"));
        
        
        topic_3_3.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_hard_4_sum);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_hard_largest_subarray_with_sum_0 = new Question("solve_problems_on_arrays_easy_medium_hard_hard_largest_subarray_with_sum_0", "Largest Subarray with Sum 0", "MEDIUM");
        q_solve_problems_on_arrays_easy_medium_hard_hard_largest_subarray_with_sum_0.setSolveLink("https://takeuforward.org/plus/dsa/problems/largest-subarray-with-sum-0");
        q_solve_problems_on_arrays_easy_medium_hard_hard_largest_subarray_with_sum_0.setEditorialLink("https://takeuforward.org/plus/dsa/problems/largest-subarray-with-sum-0?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_largest_subarray_with_sum_0.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=xmguZ6GbatA&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=23"));
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_largest_subarray_with_sum_0.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/length-of-the-longest-subarray-with-zero-sum/"));
        
        
        topic_3_3.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_hard_largest_subarray_with_sum_0);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_hard_count_subarrays_with_given_xor_k = new Question("solve_problems_on_arrays_easy_medium_hard_hard_count_subarrays_with_given_xor_k", "Count subarrays with given xor K", "HARD");
        q_solve_problems_on_arrays_easy_medium_hard_hard_count_subarrays_with_given_xor_k.setSolveLink("https://takeuforward.org/plus/dsa/problems/count-subarrays-with-given-xor-k");
        q_solve_problems_on_arrays_easy_medium_hard_hard_count_subarrays_with_given_xor_k.setEditorialLink("https://takeuforward.org/plus/dsa/problems/count-subarrays-with-given-xor-k?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_count_subarrays_with_given_xor_k.addLink(new QuestionLink("VIDEO", "https://youtu.be/eZr-6p0B7ME"));
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_count_subarrays_with_given_xor_k.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/count-the-number-of-subarrays-with-given-xor-k/"));
        
        
        topic_3_3.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_hard_count_subarrays_with_given_xor_k);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_hard_merge_overlapping_subintervals = new Question("solve_problems_on_arrays_easy_medium_hard_hard_merge_overlapping_subintervals", "Merge Overlapping Subintervals", "MEDIUM");
        q_solve_problems_on_arrays_easy_medium_hard_hard_merge_overlapping_subintervals.setSolveLink("https://leetcode.com/problems/merge-intervals/");
        q_solve_problems_on_arrays_easy_medium_hard_hard_merge_overlapping_subintervals.setEditorialLink("https://takeuforward.org/plus/dsa/problems/merge-overlapping-subintervals?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_merge_overlapping_subintervals.addLink(new QuestionLink("VIDEO", "https://youtu.be/IexN60k62jo"));
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_merge_overlapping_subintervals.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/merge-overlapping-sub-intervals/"));
        
        
        topic_3_3.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_hard_merge_overlapping_subintervals);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_hard_merge_two_sorted_arrays_without_extra_space = new Question("solve_problems_on_arrays_easy_medium_hard_hard_merge_two_sorted_arrays_without_extra_space", "Merge two sorted arrays without extra space", "MEDIUM");
        q_solve_problems_on_arrays_easy_medium_hard_hard_merge_two_sorted_arrays_without_extra_space.setSolveLink("https://leetcode.com/problems/merge-sorted-array/");
        q_solve_problems_on_arrays_easy_medium_hard_hard_merge_two_sorted_arrays_without_extra_space.setEditorialLink("https://takeuforward.org/plus/dsa/problems/merge-two-sorted-arrays-without-extra-space?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_merge_two_sorted_arrays_without_extra_space.addLink(new QuestionLink("VIDEO", "https://youtu.be/n7uwj04E0I4"));
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_merge_two_sorted_arrays_without_extra_space.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/"));
        
        
        topic_3_3.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_hard_merge_two_sorted_arrays_without_extra_space);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_hard_find_the_repeating_and_missing_number = new Question("solve_problems_on_arrays_easy_medium_hard_hard_find_the_repeating_and_missing_number", "Find the repeating and missing number", "HARD");
        q_solve_problems_on_arrays_easy_medium_hard_hard_find_the_repeating_and_missing_number.setSolveLink("https://takeuforward.org/plus/dsa/problems/find-the-repeating-and-missing-number");
        q_solve_problems_on_arrays_easy_medium_hard_hard_find_the_repeating_and_missing_number.setEditorialLink("https://takeuforward.org/plus/dsa/problems/find-the-repeating-and-missing-number?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_find_the_repeating_and_missing_number.addLink(new QuestionLink("VIDEO", "https://youtu.be/2D0D8HE6uak"));
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_find_the_repeating_and_missing_number.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/"));
        
        
        topic_3_3.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_hard_find_the_repeating_and_missing_number);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_hard_count_inversions = new Question("solve_problems_on_arrays_easy_medium_hard_hard_count_inversions", "Count Inversions", "HARD");
        q_solve_problems_on_arrays_easy_medium_hard_hard_count_inversions.setSolveLink("https://takeuforward.org/plus/dsa/problems/count-inversions");
        q_solve_problems_on_arrays_easy_medium_hard_hard_count_inversions.setEditorialLink("https://takeuforward.org/plus/dsa/problems/count-inversions?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_count_inversions.addLink(new QuestionLink("VIDEO", "https://youtu.be/AseUmwVNaoY"));
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_count_inversions.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/count-inversions-in-an-array"));
        
        
        topic_3_3.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_hard_count_inversions);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_hard_reverse_pairs = new Question("solve_problems_on_arrays_easy_medium_hard_hard_reverse_pairs", "Reverse Pairs", "HARD");
        q_solve_problems_on_arrays_easy_medium_hard_hard_reverse_pairs.setSolveLink("https://leetcode.com/problems/reverse-pairs/");
        q_solve_problems_on_arrays_easy_medium_hard_hard_reverse_pairs.setEditorialLink("https://takeuforward.org/plus/dsa/problems/reverse-pairs?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_reverse_pairs.addLink(new QuestionLink("VIDEO", "https://youtu.be/0e4bZaP3MDI"));
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_reverse_pairs.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/count-reverse-pairs/"));
        
        
        topic_3_3.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_hard_reverse_pairs);
        
        Question q_solve_problems_on_arrays_easy_medium_hard_hard_maximum_product_subarray_in_an_array = new Question("solve_problems_on_arrays_easy_medium_hard_hard_maximum_product_subarray_in_an_array", "Maximum Product Subarray in an Array", "HARD");
        q_solve_problems_on_arrays_easy_medium_hard_hard_maximum_product_subarray_in_an_array.setSolveLink("https://leetcode.com/problems/maximum-product-subarray/");
        q_solve_problems_on_arrays_easy_medium_hard_hard_maximum_product_subarray_in_an_array.setEditorialLink("https://takeuforward.org/plus/dsa/problems/maximum-product-subarray-in-an-array?tab=editorial");
        
        
        q_solve_problems_on_arrays_easy_medium_hard_hard_maximum_product_subarray_in_an_array.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/maximum-product-subarray-in-an-array/"));
        
        
        topic_3_3.addQuestion(q_solve_problems_on_arrays_easy_medium_hard_hard_maximum_product_subarray_in_an_array);
        
        
        section_3.addTopic(topic_3_3);
        
        
        Roadmap.addSection(section_3);
        
        // ==========================================
        // Section: Binary Search [1D, 2D Arrays, Search Space]
        // ==========================================
        RoadmapSection section_4 = new RoadmapSection("binary_search_1d_2d_arrays_search_space", "Binary Search [1D, 2D Arrays, Search Space]");
        
        
        
        // Topic: BS on 1D Arrays
        Topic topic_4_1 = new Topic("binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays", "BS on 1D Arrays");
        
        
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_x_in_sorted_array = new Question("binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_x_in_sorted_array", "Search X in sorted array", "EASY");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_x_in_sorted_array.setSolveLink("https://leetcode.com/problems/binary-search/");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_x_in_sorted_array.setEditorialLink("https://takeuforward.org/plus/dsa/problems/search-x-in-sorted-array?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_x_in_sorted_array.addLink(new QuestionLink("VIDEO", "https://youtu.be/MHf6awe89xw"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_x_in_sorted_array.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/binary-search-explained/"));
        
        
        topic_4_1.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_x_in_sorted_array);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_lower_bound = new Question("binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_lower_bound", "Lower Bound ", "EASY");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_lower_bound.setSolveLink("https://takeuforward.org/plus/dsa/problems/lower-bound-");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_lower_bound.setEditorialLink("https://takeuforward.org/plus/dsa/problems/lower-bound-?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_lower_bound.addLink(new QuestionLink("VIDEO", "https://youtu.be/6zhGS79oQ4k"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_lower_bound.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/implement-lower-bound-bs-2/"));
        
        
        topic_4_1.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_lower_bound);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_upper_bound = new Question("binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_upper_bound", "Upper Bound", "EASY");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_upper_bound.setSolveLink("https://takeuforward.org/plus/dsa/problems/upper-bound");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_upper_bound.setEditorialLink("https://takeuforward.org/plus/dsa/problems/upper-bound?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_upper_bound.addLink(new QuestionLink("VIDEO", "https://youtu.be/6zhGS79oQ4k"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_upper_bound.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/implement-upper-bound/"));
        
        
        topic_4_1.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_upper_bound);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_insert_position = new Question("binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_insert_position", "Search insert position", "EASY");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_insert_position.setSolveLink("https://leetcode.com/problems/search-insert-position/#:~:text=Search%20Insert%20Position%20%2D%20LeetCode&text=Given%20a%20sorted%20array%20of,(log%20n)%20runtime%20complexity.");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_insert_position.setEditorialLink("https://takeuforward.org/plus/dsa/problems/search-insert-position?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_insert_position.addLink(new QuestionLink("VIDEO", "https://youtu.be/6zhGS79oQ4k"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_insert_position.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/search-insert-position/"));
        
        
        topic_4_1.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_insert_position);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_floor_and_ceil_in_sorted_array = new Question("binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_floor_and_ceil_in_sorted_array", "Floor and Ceil in Sorted Array", "EASY");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_floor_and_ceil_in_sorted_array.setSolveLink("https://takeuforward.org/plus/dsa/problems/floor-and-ceil-in-sorted-array");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_floor_and_ceil_in_sorted_array.setEditorialLink("https://takeuforward.org/plus/dsa/problems/floor-and-ceil-in-sorted-array?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_floor_and_ceil_in_sorted_array.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=6zhGS79oQ4k&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=3"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_floor_and_ceil_in_sorted_array.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/floor-and-ceil-in-sorted-array/"));
        
        
        topic_4_1.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_floor_and_ceil_in_sorted_array);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_first_and_last_occurrence = new Question("binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_first_and_last_occurrence", "First and last occurrence", "EASY");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_first_and_last_occurrence.setSolveLink("https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_first_and_last_occurrence.setEditorialLink("https://takeuforward.org/plus/dsa/problems/first-and-last-occurrence?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_first_and_last_occurrence.addLink(new QuestionLink("VIDEO", "https://youtu.be/hjR1IYVx9lY"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_first_and_last_occurrence.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/last-occurrence-in-a-sorted-array/"));
        
        
        topic_4_1.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_first_and_last_occurrence);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_count_occurrences_in_a_sorted_array = new Question("binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_count_occurrences_in_a_sorted_array", "Count Occurrences in a Sorted Array", "EASY");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_count_occurrences_in_a_sorted_array.setSolveLink("https://takeuforward.org/plus/dsa/problems/count-occurrences-in-a-sorted-array");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_count_occurrences_in_a_sorted_array.setEditorialLink("https://takeuforward.org/plus/dsa/problems/count-occurrences-in-a-sorted-array?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_count_occurrences_in_a_sorted_array.addLink(new QuestionLink("VIDEO", "https://youtu.be/hjR1IYVx9lY"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_count_occurrences_in_a_sorted_array.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/count-occurrences-in-sorted-array/"));
        
        
        topic_4_1.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_count_occurrences_in_a_sorted_array);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_in_rotated_sorted_array_i = new Question("binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_in_rotated_sorted_array_i", "Search in rotated sorted array-I", "MEDIUM");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_in_rotated_sorted_array_i.setSolveLink("https://leetcode.com/problems/search-in-rotated-sorted-array/");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_in_rotated_sorted_array_i.setEditorialLink("https://takeuforward.org/plus/dsa/problems/search-in-rotated-sorted-array-i?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_in_rotated_sorted_array_i.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=r3pMQ8-Ad5s&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=64"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_in_rotated_sorted_array_i.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/search-element-in-a-rotated-sorted-array/"));
        
        
        topic_4_1.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_in_rotated_sorted_array_i);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_in_rotated_sorted_array_ii = new Question("binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_in_rotated_sorted_array_ii", "Search in rotated sorted array-II", "MEDIUM");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_in_rotated_sorted_array_ii.setSolveLink("https://leetcode.com/problems/search-in-rotated-sorted-array-ii/");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_in_rotated_sorted_array_ii.setEditorialLink("https://takeuforward.org/plus/dsa/problems/search-in-rotated-sorted-array-2?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_in_rotated_sorted_array_ii.addLink(new QuestionLink("VIDEO", "https://youtu.be/w2G2W8l__pc"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_in_rotated_sorted_array_ii.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/search-element-in-rotated-sorted-array-ii"));
        
        
        topic_4_1.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_search_in_rotated_sorted_array_ii);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_find_minimum_in_rotated_sorted_array = new Question("binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_find_minimum_in_rotated_sorted_array", "Find minimum in Rotated Sorted Array", "EASY");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_find_minimum_in_rotated_sorted_array.setSolveLink("https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_find_minimum_in_rotated_sorted_array.setEditorialLink("https://takeuforward.org/plus/dsa/problems/find-minimum-in-rotated-sorted-array?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_find_minimum_in_rotated_sorted_array.addLink(new QuestionLink("VIDEO", "https://youtu.be/nhEMDKMB44g"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_find_minimum_in_rotated_sorted_array.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/minimum-in-rotated-sorted-array/"));
        
        
        topic_4_1.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_find_minimum_in_rotated_sorted_array);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_find_out_how_many_times_the_array_is_rotated = new Question("binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_find_out_how_many_times_the_array_is_rotated", "Find out how many times the array is rotated", "EASY");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_find_out_how_many_times_the_array_is_rotated.setSolveLink("https://takeuforward.org/plus/dsa/problems/find-out-how-many-times-the-array-is-rotated");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_find_out_how_many_times_the_array_is_rotated.setEditorialLink("https://takeuforward.org/plus/dsa/problems/find-out-how-many-times-the-array-is-rotated?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_find_out_how_many_times_the_array_is_rotated.addLink(new QuestionLink("VIDEO", "https://youtu.be/jtSiWTPLwd0"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_find_out_how_many_times_the_array_is_rotated.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/find-out-how-many-times-the-array-has-been-rotated/"));
        
        
        topic_4_1.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_find_out_how_many_times_the_array_is_rotated);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_single_element_in_a_sorted_array = new Question("binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_single_element_in_a_sorted_array", "Single element in a Sorted Array", "MEDIUM");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_single_element_in_a_sorted_array.setSolveLink("https://leetcode.com/problems/single-element-in-a-sorted-array/");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_single_element_in_a_sorted_array.setEditorialLink("https://takeuforward.org/plus/dsa/problems/single-element-in-sorted-array?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_single_element_in_a_sorted_array.addLink(new QuestionLink("VIDEO", "https://youtu.be/AZOmHuHadxQ"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_single_element_in_a_sorted_array.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/search-single-element-in-a-sorted-array/"));
        
        
        topic_4_1.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_single_element_in_a_sorted_array);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_find_peak_element = new Question("binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_find_peak_element", "Find peak element", "MEDIUM");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_find_peak_element.setSolveLink("https://leetcode.com/problems/find-peak-element/#:~:text=Find%20Peak%20Element%20%2D%20LeetCode&text=A%20peak%20element%20is%20an,to%20any%20of%20the%20peaks.");
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_find_peak_element.setEditorialLink("https://takeuforward.org/plus/dsa/problems/find-peak-element?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_find_peak_element.addLink(new QuestionLink("VIDEO", "https://youtu.be/cXxmbemS6XM"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_find_peak_element.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/peak-element-in-array/"));
        
        
        topic_4_1.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_1d_arrays_find_peak_element);
        
        
        section_4.addTopic(topic_4_1);
        
        // Topic: BS on Answers
        Topic topic_4_2 = new Topic("binary_search_1d_2d_arrays_search_space_bs_on_answers", "BS on Answers");
        
        
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_answers_find_square_root_of_a_number = new Question("binary_search_1d_2d_arrays_search_space_bs_on_answers_find_square_root_of_a_number", "Find square root of a number", "MEDIUM");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_find_square_root_of_a_number.setSolveLink("https://takeuforward.org/plus/dsa/problems/find-square-root-of-a-number");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_find_square_root_of_a_number.setEditorialLink("https://takeuforward.org/plus/dsa/problems/find-square-root-of-a-number?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_find_square_root_of_a_number.addLink(new QuestionLink("VIDEO", "https://youtu.be/Bsv3FPUX_BA"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_find_square_root_of_a_number.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/binary-search/finding-sqrt-of-a-number-using-binary-search/"));
        
        
        topic_4_2.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_answers_find_square_root_of_a_number);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_answers_find_nth_root_of_a_number = new Question("binary_search_1d_2d_arrays_search_space_bs_on_answers_find_nth_root_of_a_number", "Find Nth root of a number", "MEDIUM");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_find_nth_root_of_a_number.setSolveLink("https://takeuforward.org/plus/dsa/problems/find-nth-root-of-a-number");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_find_nth_root_of_a_number.setEditorialLink("https://takeuforward.org/plus/dsa/problems/find-nth-root-of-a-number?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_find_nth_root_of_a_number.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=WjpswYrS2nY&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=62"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_find_nth_root_of_a_number.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/nth-root-of-a-number-using-binary-search/"));
        
        
        topic_4_2.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_answers_find_nth_root_of_a_number);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_answers_koko_eating_bananas = new Question("binary_search_1d_2d_arrays_search_space_bs_on_answers_koko_eating_bananas", "Koko eating bananas", "MEDIUM");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_koko_eating_bananas.setSolveLink("https://leetcode.com/problems/koko-eating-bananas/");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_koko_eating_bananas.setEditorialLink("https://takeuforward.org/plus/dsa/problems/koko-eating-bananas?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_koko_eating_bananas.addLink(new QuestionLink("VIDEO", "https://youtu.be/qyfekrNni90"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_koko_eating_bananas.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/binary-search/koko-eating-bananas/"));
        
        
        topic_4_2.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_answers_koko_eating_bananas);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_answers_minimum_days_to_make_m_bouquets = new Question("binary_search_1d_2d_arrays_search_space_bs_on_answers_minimum_days_to_make_m_bouquets", "Minimum days to make M bouquets", "MEDIUM");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_minimum_days_to_make_m_bouquets.setSolveLink("https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_minimum_days_to_make_m_bouquets.setEditorialLink("https://takeuforward.org/plus/dsa/problems/minimum-days-to-make-m-bouquets?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_minimum_days_to_make_m_bouquets.addLink(new QuestionLink("VIDEO", "https://youtu.be/TXAuxeYBTdg"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_minimum_days_to_make_m_bouquets.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/minimum-days-to-make-m-bouquets/"));
        
        
        topic_4_2.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_answers_minimum_days_to_make_m_bouquets);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_answers_find_the_smallest_divisor = new Question("binary_search_1d_2d_arrays_search_space_bs_on_answers_find_the_smallest_divisor", "Find the smallest divisor", "MEDIUM");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_find_the_smallest_divisor.setSolveLink("https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_find_the_smallest_divisor.setEditorialLink("https://takeuforward.org/plus/dsa/problems/find-the-smallest-divisor?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_find_the_smallest_divisor.addLink(new QuestionLink("VIDEO", "https://youtu.be/UvBKTVaG6U8"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_find_the_smallest_divisor.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/find-the-smallest-divisor-given-a-threshold/"));
        
        
        topic_4_2.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_answers_find_the_smallest_divisor);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_answers_capacity_to_ship_packages_within_d_days = new Question("binary_search_1d_2d_arrays_search_space_bs_on_answers_capacity_to_ship_packages_within_d_days", "Capacity to Ship Packages Within D Days", "MEDIUM");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_capacity_to_ship_packages_within_d_days.setSolveLink("https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_capacity_to_ship_packages_within_d_days.setEditorialLink("https://takeuforward.org/plus/dsa/problems/capacity-to-ship-packages-within-d-days?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_capacity_to_ship_packages_within_d_days.addLink(new QuestionLink("VIDEO", "https://youtu.be/MG-Ac4TAvTY"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_capacity_to_ship_packages_within_d_days.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/capacity-to-ship-packages-within-d-days/"));
        
        
        topic_4_2.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_answers_capacity_to_ship_packages_within_d_days);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_answers_kth_missing_positive_number = new Question("binary_search_1d_2d_arrays_search_space_bs_on_answers_kth_missing_positive_number", "Kth Missing Positive Number", "MEDIUM");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_kth_missing_positive_number.setSolveLink("https://leetcode.com/problems/kth-missing-positive-number/#:~:text=Given%20an%20array%20arr%20of,13%2C...%5D.");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_kth_missing_positive_number.setEditorialLink("https://takeuforward.org/plus/dsa/problems/kth-missing-positive-number?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_kth_missing_positive_number.addLink(new QuestionLink("VIDEO", "https://youtu.be/uZ0N_hZpyps"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_kth_missing_positive_number.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/kth-missing-positive-number/"));
        
        
        topic_4_2.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_answers_kth_missing_positive_number);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_answers_aggressive_cows = new Question("binary_search_1d_2d_arrays_search_space_bs_on_answers_aggressive_cows", "Aggressive Cows", "HARD");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_aggressive_cows.setSolveLink("https://takeuforward.org/plus/dsa/problems/aggressive-cows");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_aggressive_cows.setEditorialLink("https://takeuforward.org/plus/dsa/problems/aggressive-cows?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_aggressive_cows.addLink(new QuestionLink("VIDEO", "https://youtu.be/R_Mfw4ew-Vo"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_aggressive_cows.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/aggressive-cows-detailed-solution/"));
        
        
        topic_4_2.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_answers_aggressive_cows);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_answers_book_allocation_problem = new Question("binary_search_1d_2d_arrays_search_space_bs_on_answers_book_allocation_problem", "Book Allocation Problem", "HARD");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_book_allocation_problem.setSolveLink("https://takeuforward.org/plus/dsa/problems/book-allocation-problem");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_book_allocation_problem.setEditorialLink("https://takeuforward.org/plus/dsa/problems/book-allocation-problem?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_book_allocation_problem.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=gYmWHvRHu-s&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=69"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_book_allocation_problem.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/allocate-minimum-number-of-pages/"));
        
        
        topic_4_2.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_answers_book_allocation_problem);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_answers_split_array_largest_sum = new Question("binary_search_1d_2d_arrays_search_space_bs_on_answers_split_array_largest_sum", "Split array - largest sum", "HARD");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_split_array_largest_sum.setSolveLink("https://leetcode.com/problems/split-array-largest-sum/");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_split_array_largest_sum.setEditorialLink("https://takeuforward.org/plus/dsa/problems/split-array---largest-sum?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_split_array_largest_sum.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=thUd_WJn6wk&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=20"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_split_array_largest_sum.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/split-array-largest-sum/"));
        
        
        topic_4_2.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_answers_split_array_largest_sum);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_answers_painters_partition = new Question("binary_search_1d_2d_arrays_search_space_bs_on_answers_painters_partition", "Painter's Partition", "MEDIUM");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_painters_partition.setSolveLink("https://takeuforward.org/plus/dsa/problems/painters-partition");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_painters_partition.setEditorialLink("https://takeuforward.org/plus/dsa/problems/painters-partition?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_painters_partition.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=thUd_WJn6wk&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=20"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_painters_partition.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/painters-partition-problem/"));
        
        
        topic_4_2.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_answers_painters_partition);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_answers_minimize_max_distance_to_gas_station = new Question("binary_search_1d_2d_arrays_search_space_bs_on_answers_minimize_max_distance_to_gas_station", "Minimize Max Distance to Gas Station", "HARD");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_minimize_max_distance_to_gas_station.setSolveLink("https://leetcode.com/problems/minimize-max-distance-to-gas-station/");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_minimize_max_distance_to_gas_station.setEditorialLink("https://takeuforward.org/plus/dsa/problems/minimise-max-distance-to-gas-stations?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_minimize_max_distance_to_gas_station.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=kMSBvlZ-_HA&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=21"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_minimize_max_distance_to_gas_station.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/minimise-maximum-distance-between-gas-stations/"));
        
        
        topic_4_2.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_answers_minimize_max_distance_to_gas_station);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_answers_median_of_2_sorted_arrays = new Question("binary_search_1d_2d_arrays_search_space_bs_on_answers_median_of_2_sorted_arrays", "Median of 2 sorted arrays", "HARD");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_median_of_2_sorted_arrays.setSolveLink("https://leetcode.com/problems/median-of-two-sorted-arrays/");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_median_of_2_sorted_arrays.setEditorialLink("");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_median_of_2_sorted_arrays.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=NTop3VTjmxk&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=65"));
        
        
        topic_4_2.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_answers_median_of_2_sorted_arrays);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_answers_kth_element_of_2_sorted_arrays = new Question("binary_search_1d_2d_arrays_search_space_bs_on_answers_kth_element_of_2_sorted_arrays", "Kth element of 2 sorted arrays", "MEDIUM");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_kth_element_of_2_sorted_arrays.setSolveLink("https://takeuforward.org/plus/dsa/problems/kth-element-of-2-sorted-arrays");
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_kth_element_of_2_sorted_arrays.setEditorialLink("https://takeuforward.org/plus/dsa/problems/kth-element-of-2-sorted-arrays?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_kth_element_of_2_sorted_arrays.addLink(new QuestionLink("VIDEO", "https://youtu.be/D1oDwWCq50g"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_answers_kth_element_of_2_sorted_arrays.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/k-th-element-of-two-sorted-arrays/"));
        
        
        topic_4_2.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_answers_kth_element_of_2_sorted_arrays);
        
        
        section_4.addTopic(topic_4_2);
        
        // Topic: BS on 2D Arrays
        Topic topic_4_3 = new Topic("binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays", "BS on 2D Arrays");
        
        
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_find_row_with_maximum_1s = new Question("binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_find_row_with_maximum_1s", "Find row with maximum 1's", "EASY");
        q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_find_row_with_maximum_1s.setSolveLink("https://takeuforward.org/plus/dsa/problems/find-row-with-maximum-1's");
        q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_find_row_with_maximum_1s.setEditorialLink("https://takeuforward.org/plus/dsa/problems/find-row-with-maximum-1's?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_find_row_with_maximum_1s.addLink(new QuestionLink("VIDEO", "https://youtu.be/SCz-1TtYxDI"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_find_row_with_maximum_1s.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/find-the-row-with-maximum-number-of-1s/"));
        
        
        topic_4_3.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_find_row_with_maximum_1s);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_search_in_a_2d_matrix = new Question("binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_search_in_a_2d_matrix", "Search in a 2D matrix", "HARD");
        q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_search_in_a_2d_matrix.setSolveLink("https://leetcode.com/problems/search-a-2d-matrix/");
        q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_search_in_a_2d_matrix.setEditorialLink("");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_search_in_a_2d_matrix.addLink(new QuestionLink("VIDEO", "https://youtu.be/ZYpYur0znng"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_search_in_a_2d_matrix.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/search-in-a-sorted-2d-matrix/"));
        
        
        topic_4_3.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_search_in_a_2d_matrix);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_search_in_2d_matrix_ii = new Question("binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_search_in_2d_matrix_ii", "Search in 2D matrix - II", "HARD");
        q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_search_in_2d_matrix_ii.setSolveLink("https://leetcode.com/problems/search-a-2d-matrix-ii/");
        q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_search_in_2d_matrix_ii.setEditorialLink("https://takeuforward.org/plus/dsa/problems/search-in-2d-matrix-ii?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_search_in_2d_matrix_ii.addLink(new QuestionLink("VIDEO", "https://youtu.be/9ZbB397jU4k"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_search_in_2d_matrix_ii.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/search-in-a-row-and-column-wise-sorted-matrix/"));
        
        
        topic_4_3.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_search_in_2d_matrix_ii);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_find_peak_element_ii = new Question("binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_find_peak_element_ii", "Find Peak Element - II", "MEDIUM");
        q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_find_peak_element_ii.setSolveLink("https://leetcode.com/problems/find-a-peak-element-ii/");
        q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_find_peak_element_ii.setEditorialLink("https://takeuforward.org/plus/dsa/problems/find-peak-element-ii?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_find_peak_element_ii.addLink(new QuestionLink("VIDEO", "https://youtu.be/nGGp5XBzC4g?si=WCop5C6Azj5gAELH"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_find_peak_element_ii.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/find-peak-element-2d-matrix"));
        
        
        topic_4_3.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_find_peak_element_ii);
        
        Question q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_matrix_median = new Question("binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_matrix_median", "Matrix Median", "HARD");
        q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_matrix_median.setSolveLink("https://takeuforward.org/plus/dsa/problems/matrix-median");
        q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_matrix_median.setEditorialLink("https://takeuforward.org/plus/dsa/problems/matrix-median?tab=editorial");
        
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_matrix_median.addLink(new QuestionLink("VIDEO", "https://youtu.be/Q9wXgdxJq48?si=ScI_0uzJh7yg8nrX"));
        
        q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_matrix_median.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/median-of-row-wise-sorted-matrix/"));
        
        
        topic_4_3.addQuestion(q_binary_search_1d_2d_arrays_search_space_bs_on_2d_arrays_matrix_median);
        
        
        section_4.addTopic(topic_4_3);
        
        
        Roadmap.addSection(section_4);
        
        // ==========================================
        // Section: Strings [Basic and Medium]
        // ==========================================
        RoadmapSection section_5 = new RoadmapSection("strings_basic_and_medium", "Strings [Basic and Medium]");
        
        
        
        // Topic: Basic and Easy String Problems
        Topic topic_5_1 = new Topic("strings_basic_and_medium_basic_and_easy_string_problems", "Basic and Easy String Problems");
        
        
        
        Question q_strings_basic_and_medium_basic_and_easy_string_problems_remove_outermost_parentheses = new Question("strings_basic_and_medium_basic_and_easy_string_problems_remove_outermost_parentheses", "Remove Outermost Parentheses", "MEDIUM");
        q_strings_basic_and_medium_basic_and_easy_string_problems_remove_outermost_parentheses.setSolveLink("https://leetcode.com/problems/remove-outermost-parentheses/");
        q_strings_basic_and_medium_basic_and_easy_string_problems_remove_outermost_parentheses.setEditorialLink("");
        
        
        q_strings_basic_and_medium_basic_and_easy_string_problems_remove_outermost_parentheses.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/remove-outermost-parentheses"));
        
        
        topic_5_1.addQuestion(q_strings_basic_and_medium_basic_and_easy_string_problems_remove_outermost_parentheses);
        
        Question q_strings_basic_and_medium_basic_and_easy_string_problems_reverse_words_in_a_given_string_palindrome_check = new Question("strings_basic_and_medium_basic_and_easy_string_problems_reverse_words_in_a_given_string_palindrome_check", "Reverse words in a given string / Palindrome Check", "MEDIUM");
        q_strings_basic_and_medium_basic_and_easy_string_problems_reverse_words_in_a_given_string_palindrome_check.setSolveLink("https://leetcode.com/problems/reverse-words-in-a-string/");
        q_strings_basic_and_medium_basic_and_easy_string_problems_reverse_words_in_a_given_string_palindrome_check.setEditorialLink("https://takeuforward.org/plus/dsa/problems/reverse-every-word-in-a-string?tab=editorial");
        
        
        q_strings_basic_and_medium_basic_and_easy_string_problems_reverse_words_in_a_given_string_palindrome_check.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/reverse-words-in-a-string/"));
        
        
        topic_5_1.addQuestion(q_strings_basic_and_medium_basic_and_easy_string_problems_reverse_words_in_a_given_string_palindrome_check);
        
        Question q_strings_basic_and_medium_basic_and_easy_string_problems_largest_odd_number_in_a_string = new Question("strings_basic_and_medium_basic_and_easy_string_problems_largest_odd_number_in_a_string", "Largest Odd Number in a String", "EASY");
        q_strings_basic_and_medium_basic_and_easy_string_problems_largest_odd_number_in_a_string.setSolveLink("https://leetcode.com/problems/largest-odd-number-in-string/");
        q_strings_basic_and_medium_basic_and_easy_string_problems_largest_odd_number_in_a_string.setEditorialLink("https://takeuforward.org/plus/dsa/problems/largest-odd-number-in-a-string?tab=editorial");
        
        
        q_strings_basic_and_medium_basic_and_easy_string_problems_largest_odd_number_in_a_string.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/largest-odd-number-in-a-string"));
        
        
        topic_5_1.addQuestion(q_strings_basic_and_medium_basic_and_easy_string_problems_largest_odd_number_in_a_string);
        
        Question q_strings_basic_and_medium_basic_and_easy_string_problems_longest_common_prefix = new Question("strings_basic_and_medium_basic_and_easy_string_problems_longest_common_prefix", "Longest Common Prefix", "EASY");
        q_strings_basic_and_medium_basic_and_easy_string_problems_longest_common_prefix.setSolveLink("https://leetcode.com/problems/longest-common-prefix/");
        q_strings_basic_and_medium_basic_and_easy_string_problems_longest_common_prefix.setEditorialLink("https://takeuforward.org/plus/dsa/problems/longest-happy-prefix?tab=editorialhttps://takeuforward.org/plus/dsa/problems/longest-common-prefix?tab=editorial");
        
        
        q_strings_basic_and_medium_basic_and_easy_string_problems_longest_common_prefix.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/longest-common-prefix"));
        
        
        topic_5_1.addQuestion(q_strings_basic_and_medium_basic_and_easy_string_problems_longest_common_prefix);
        
        Question q_strings_basic_and_medium_basic_and_easy_string_problems_isomorphic_string = new Question("strings_basic_and_medium_basic_and_easy_string_problems_isomorphic_string", "Isomorphic String", "EASY");
        q_strings_basic_and_medium_basic_and_easy_string_problems_isomorphic_string.setSolveLink("https://leetcode.com/problems/isomorphic-strings/");
        q_strings_basic_and_medium_basic_and_easy_string_problems_isomorphic_string.setEditorialLink("https://takeuforward.org/plus/dsa/problems/isomorphic-string?tab=editorial");
        
        
        q_strings_basic_and_medium_basic_and_easy_string_problems_isomorphic_string.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/isomorphic-string"));
        
        
        topic_5_1.addQuestion(q_strings_basic_and_medium_basic_and_easy_string_problems_isomorphic_string);
        
        Question q_strings_basic_and_medium_basic_and_easy_string_problems_rotate_string = new Question("strings_basic_and_medium_basic_and_easy_string_problems_rotate_string", "Rotate String", "EASY");
        q_strings_basic_and_medium_basic_and_easy_string_problems_rotate_string.setSolveLink("https://leetcode.com/problems/rotate-string/");
        q_strings_basic_and_medium_basic_and_easy_string_problems_rotate_string.setEditorialLink("https://takeuforward.org/plus/dsa/problems/rotate-string?tab=editorial");
        
        
        q_strings_basic_and_medium_basic_and_easy_string_problems_rotate_string.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/check-if-one-string-is-rotation-of-another"));
        
        
        topic_5_1.addQuestion(q_strings_basic_and_medium_basic_and_easy_string_problems_rotate_string);
        
        Question q_strings_basic_and_medium_basic_and_easy_string_problems_check_if_two_strings_are_anagram_of_each_other = new Question("strings_basic_and_medium_basic_and_easy_string_problems_check_if_two_strings_are_anagram_of_each_other", "Check if two strings are anagram of each other", "EASY");
        q_strings_basic_and_medium_basic_and_easy_string_problems_check_if_two_strings_are_anagram_of_each_other.setSolveLink("https://leetcode.com/problems/valid-anagram/#:~:text=Given%20two%20strings%20s%20and,the%20original%20letters%20exactly%20once.&text=Constraints%3A,.length%20%3C%3D%205%20*%2010");
        q_strings_basic_and_medium_basic_and_easy_string_problems_check_if_two_strings_are_anagram_of_each_other.setEditorialLink("https://takeuforward.org/plus/dsa/problems/valid-anagram?tab=editorial");
        
        
        q_strings_basic_and_medium_basic_and_easy_string_problems_check_if_two_strings_are_anagram_of_each_other.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/check-if-two-strings-are-anagrams-of-each-other/"));
        
        
        topic_5_1.addQuestion(q_strings_basic_and_medium_basic_and_easy_string_problems_check_if_two_strings_are_anagram_of_each_other);
        
        
        section_5.addTopic(topic_5_1);
        
        // Topic: Medium String Problems
        Topic topic_5_2 = new Topic("strings_basic_and_medium_medium_string_problems", "Medium String Problems");
        
        
        
        Question q_strings_basic_and_medium_medium_string_problems_sort_characters_by_frequency = new Question("strings_basic_and_medium_medium_string_problems_sort_characters_by_frequency", "Sort Characters by Frequency", "EASY");
        q_strings_basic_and_medium_medium_string_problems_sort_characters_by_frequency.setSolveLink("https://leetcode.com/problems/sort-characters-by-frequency/");
        q_strings_basic_and_medium_medium_string_problems_sort_characters_by_frequency.setEditorialLink("https://takeuforward.org/plus/dsa/problems/sort-characters-by-frequency?tab=editorial");
        
        
        q_strings_basic_and_medium_medium_string_problems_sort_characters_by_frequency.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/sort-characters-by-frequency"));
        
        
        topic_5_2.addQuestion(q_strings_basic_and_medium_medium_string_problems_sort_characters_by_frequency);
        
        Question q_strings_basic_and_medium_medium_string_problems_maximum_nesting_depth_of_the_parentheses = new Question("strings_basic_and_medium_medium_string_problems_maximum_nesting_depth_of_the_parentheses", "Maximum Nesting Depth of the Parentheses", "MEDIUM");
        q_strings_basic_and_medium_medium_string_problems_maximum_nesting_depth_of_the_parentheses.setSolveLink("https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/");
        q_strings_basic_and_medium_medium_string_problems_maximum_nesting_depth_of_the_parentheses.setEditorialLink("");
        
        
        q_strings_basic_and_medium_medium_string_problems_maximum_nesting_depth_of_the_parentheses.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/maximum-nesting-depth-of-parenthesis"));
        
        
        topic_5_2.addQuestion(q_strings_basic_and_medium_medium_string_problems_maximum_nesting_depth_of_the_parentheses);
        
        Question q_strings_basic_and_medium_medium_string_problems_roman_to_integer = new Question("strings_basic_and_medium_medium_string_problems_roman_to_integer", "Roman to Integer", "MEDIUM");
        q_strings_basic_and_medium_medium_string_problems_roman_to_integer.setSolveLink("https://leetcode.com/problems/roman-to-integer/");
        q_strings_basic_and_medium_medium_string_problems_roman_to_integer.setEditorialLink("");
        
        
        q_strings_basic_and_medium_medium_string_problems_roman_to_integer.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/roman-numerals-to-integer"));
        
        
        topic_5_2.addQuestion(q_strings_basic_and_medium_medium_string_problems_roman_to_integer);
        
        Question q_strings_basic_and_medium_medium_string_problems_string_to_integer_atoi = new Question("strings_basic_and_medium_medium_string_problems_string_to_integer_atoi", "String to Integer (atoi)", "MEDIUM");
        q_strings_basic_and_medium_medium_string_problems_string_to_integer_atoi.setSolveLink("https://leetcode.com/problems/string-to-integer-atoi/");
        q_strings_basic_and_medium_medium_string_problems_string_to_integer_atoi.setEditorialLink("https://takeuforward.org/plus/dsa/problems/string-to-integer-atoi?tab=editorial");
        
        
        q_strings_basic_and_medium_medium_string_problems_string_to_integer_atoi.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/recursive-implementation-of-atoi"));
        
        
        topic_5_2.addQuestion(q_strings_basic_and_medium_medium_string_problems_string_to_integer_atoi);
        
        Question q_strings_basic_and_medium_medium_string_problems_count_number_of_substrings = new Question("strings_basic_and_medium_medium_string_problems_count_number_of_substrings", "Count Number of Substrings", "EASY");
        q_strings_basic_and_medium_medium_string_problems_count_number_of_substrings.setSolveLink("https://takeuforward.org/data-structure/count-number-of-substrings");
        q_strings_basic_and_medium_medium_string_problems_count_number_of_substrings.setEditorialLink("");
        
        
        q_strings_basic_and_medium_medium_string_problems_count_number_of_substrings.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/count-number-of-substrings"));
        
        
        topic_5_2.addQuestion(q_strings_basic_and_medium_medium_string_problems_count_number_of_substrings);
        
        Question q_strings_basic_and_medium_medium_string_problems_longest_palindromic_substring = new Question("strings_basic_and_medium_medium_string_problems_longest_palindromic_substring", "Longest Palindromic Substring", "MEDIUM");
        q_strings_basic_and_medium_medium_string_problems_longest_palindromic_substring.setSolveLink("https://leetcode.com/problems/longest-palindromic-substring/");
        q_strings_basic_and_medium_medium_string_problems_longest_palindromic_substring.setEditorialLink("https://takeuforward.org/plus/dsa/problems/longest-palindromic-substring?tab=editorial");
        
        
        
        topic_5_2.addQuestion(q_strings_basic_and_medium_medium_string_problems_longest_palindromic_substring);
        
        Question q_strings_basic_and_medium_medium_string_problems_sum_of_beauty_of_all_substrings = new Question("strings_basic_and_medium_medium_string_problems_sum_of_beauty_of_all_substrings", "Sum of Beauty of All Substrings", "MEDIUM");
        q_strings_basic_and_medium_medium_string_problems_sum_of_beauty_of_all_substrings.setSolveLink("https://leetcode.com/problems/sum-of-beauty-of-all-substrings/");
        q_strings_basic_and_medium_medium_string_problems_sum_of_beauty_of_all_substrings.setEditorialLink("");
        
        
        q_strings_basic_and_medium_medium_string_problems_sum_of_beauty_of_all_substrings.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/sum-of-beauty-of-all-substring"));
        
        
        topic_5_2.addQuestion(q_strings_basic_and_medium_medium_string_problems_sum_of_beauty_of_all_substrings);
        
        Question q_strings_basic_and_medium_medium_string_problems_reverse_every_word_in_a_string = new Question("strings_basic_and_medium_medium_string_problems_reverse_every_word_in_a_string", "Reverse every word in a string", "MEDIUM");
        q_strings_basic_and_medium_medium_string_problems_reverse_every_word_in_a_string.setSolveLink("https://leetcode.com/problems/reverse-words-in-a-string/");
        q_strings_basic_and_medium_medium_string_problems_reverse_every_word_in_a_string.setEditorialLink("https://takeuforward.org/plus/dsa/problems/reverse-every-word-in-a-string?tab=editorial");
        
        
        q_strings_basic_and_medium_medium_string_problems_reverse_every_word_in_a_string.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/reverse-words-in-a-string/"));
        
        
        topic_5_2.addQuestion(q_strings_basic_and_medium_medium_string_problems_reverse_every_word_in_a_string);
        
        
        section_5.addTopic(topic_5_2);
        
        
        Roadmap.addSection(section_5);
        
        // ==========================================
        // Section: Learn LinkedList [Single LL, Double LL, Medium, Hard Problems]
        // ==========================================
        RoadmapSection section_6 = new RoadmapSection("learn_linkedlist_single_ll_double_ll_medium_hard_problems", "Learn LinkedList [Single LL, Double LL, Medium, Hard Problems]");
        
        
        
        // Topic: Learn 1D LinkedList
        Topic topic_6_1 = new Topic("learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist", "Learn 1D LinkedList");
        
        
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_introduction_to_singly_linkedlist = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_introduction_to_singly_linkedlist", "Introduction to Singly LinkedList", "EASY");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_introduction_to_singly_linkedlist.setSolveLink("https://takeuforward.org/plus/dsa/problems/introduction-to-singly-linkedlist");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_introduction_to_singly_linkedlist.setEditorialLink("https://takeuforward.org/plus/dsa/problems/introduction-to-singly-linkedlist");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_introduction_to_singly_linkedlist.addLink(new QuestionLink("VIDEO", "https://youtu.be/Nq7ok-OyEpg?si=9PR1o8OPRWil7fRA"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_introduction_to_singly_linkedlist.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/linked-list/linked-list-introduction"));
        
        
        topic_6_1.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_introduction_to_singly_linkedlist);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_insertion_at_the_head_of_linked_list = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_insertion_at_the_head_of_linked_list", "Insertion at the head of Linked List", "EASY");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_insertion_at_the_head_of_linked_list.setSolveLink("https://takeuforward.org/plus/dsa/problems/insertion-at-the-head-of-ll");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_insertion_at_the_head_of_linked_list.setEditorialLink("https://takeuforward.org/plus/dsa/problems/insertion-at-the-head-of-ll?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_insertion_at_the_head_of_linked_list.addLink(new QuestionLink("VIDEO", "https://youtu.be/VaECK03Dz-g?si=vHSwdf9jhE05adKM&t=1934"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_insertion_at_the_head_of_linked_list.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/linked-list/insert-at-the-head-of-a-linked-list"));
        
        
        topic_6_1.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_insertion_at_the_head_of_linked_list);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_deletion_of_the_head_of_ll = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_deletion_of_the_head_of_ll", "Deletion of the head of LL", "EASY");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_deletion_of_the_head_of_ll.setSolveLink("https://leetcode.com/problems/delete-node-in-a-linked-list/");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_deletion_of_the_head_of_ll.setEditorialLink("https://takeuforward.org/plus/dsa/problems/deletion-of-the-head-of-ll?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_deletion_of_the_head_of_ll.addLink(new QuestionLink("VIDEO", "https://youtu.be/VaECK03Dz-g?si=CRaBHbOo2bHFbOT5"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_deletion_of_the_head_of_ll.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/delete-last-node-of-linked-list/"));
        
        
        topic_6_1.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_deletion_of_the_head_of_ll);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_find_the_length_of_the_linked_list = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_find_the_length_of_the_linked_list", "Find the length of the Linked List", "EASY");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_find_the_length_of_the_linked_list.setSolveLink("https://takeuforward.org/plus/dsa/problems/find-the-length-of-the-linked-list");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_find_the_length_of_the_linked_list.setEditorialLink("");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_find_the_length_of_the_linked_list.addLink(new QuestionLink("VIDEO", "https://youtu.be/Nq7ok-OyEpg?si=xqQbukLfo2oZ6C6s&t=2240"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_find_the_length_of_the_linked_list.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/linked-list/find-the-length-of-a-linked-list"));
        
        
        topic_6_1.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_find_the_length_of_the_linked_list);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_search_in_linked_list = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_search_in_linked_list", "Search in Linked List", "MEDIUM");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_search_in_linked_list.setSolveLink("https://takeuforward.org/plus/dsa/problems/search-in-linked-list");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_search_in_linked_list.setEditorialLink("");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_search_in_linked_list.addLink(new QuestionLink("VIDEO", "https://youtu.be/Nq7ok-OyEpg?si=WNXcIaXZ_B6cNq0s&t=2524"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_search_in_linked_list.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/linked-list/search-an-element-in-a-linked-list"));
        
        
        topic_6_1.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_1d_linkedlist_search_in_linked_list);
        
        
        section_6.addTopic(topic_6_1);
        
        // Topic: Learn Doubly LinkedList
        Topic topic_6_2 = new Topic("learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist", "Learn Doubly LinkedList");
        
        
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_introduction_to_doubly_ll = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_introduction_to_doubly_ll", "Introduction to Doubly LL", "EASY");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_introduction_to_doubly_ll.setSolveLink("https://takeuforward.org/plus/dsa/problems/introduction-to-doubly-ll");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_introduction_to_doubly_ll.setEditorialLink("https://takeuforward.org/plus/dsa/problems/introduction-to-doubly-ll?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_introduction_to_doubly_ll.addLink(new QuestionLink("VIDEO", "https://youtu.be/0eKMU10uEDI?si=uDnoj_C5ghEpNLvP"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_introduction_to_doubly_ll.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/linked-list/introduction-to-doubly-linked-list"));
        
        
        topic_6_2.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_introduction_to_doubly_ll);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_insert_node_before_head_in_doubly_linked_list = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_insert_node_before_head_in_doubly_linked_list", "Insert node before head in Doubly Linked List", "EASY");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_insert_node_before_head_in_doubly_linked_list.setSolveLink("https://takeuforward.org/plus/dsa/problems/insert-node-before-head-in-dll");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_insert_node_before_head_in_doubly_linked_list.setEditorialLink("https://takeuforward.org/plus/dsa/problems/insert-node-before-head-in-dll?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_insert_node_before_head_in_doubly_linked_list.addLink(new QuestionLink("VIDEO", "https://youtu.be/0eKMU10uEDI?si=J5a0pQTosimcO_aA&t=2684"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_insert_node_before_head_in_doubly_linked_list.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/insert-at-end-of-doubly-linked-list/"));
        
        
        topic_6_2.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_insert_node_before_head_in_doubly_linked_list);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_delete_head_of_doubly_linked_list = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_delete_head_of_doubly_linked_list", "Delete head of Doubly Linked List", "EASY");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_delete_head_of_doubly_linked_list.setSolveLink("https://takeuforward.org/plus/dsa/problems/delete-head-of-dll");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_delete_head_of_doubly_linked_list.setEditorialLink("https://takeuforward.org/plus/dsa/problems/delete-head-of-dll?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_delete_head_of_doubly_linked_list.addLink(new QuestionLink("VIDEO", "https://youtu.be/0eKMU10uEDI?si=sE7jqrW46lfRHVLd&t=853"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_delete_head_of_doubly_linked_list.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/delete-last-node-of-a-doubly-linked-list/"));
        
        
        topic_6_2.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_delete_head_of_doubly_linked_list);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_reverse_a_doubly_linked_list = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_reverse_a_doubly_linked_list", "Reverse a Doubly Linked List", "MEDIUM");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_reverse_a_doubly_linked_list.setSolveLink("https://takeuforward.org/plus/dsa/problems/reverse-a-doubly-linked-list");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_reverse_a_doubly_linked_list.setEditorialLink("");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_reverse_a_doubly_linked_list.addLink(new QuestionLink("VIDEO", "https://youtu.be/u3WUW2qe6ww?si=96Wwlju72IvmzkxE"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_reverse_a_doubly_linked_list.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/reverse-a-doubly-linked-list/"));
        
        
        topic_6_2.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_learn_doubly_linkedlist_reverse_a_doubly_linked_list);
        
        
        section_6.addTopic(topic_6_2);
        
        // Topic: Medium Problems of LL
        Topic topic_6_3 = new Topic("learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll", "Medium Problems of LL");
        
        
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_middle_of_a_linkedlist_tortoisehare_method = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_middle_of_a_linkedlist_tortoisehare_method", "Middle of a LinkedList [TortoiseHare Method]", "EASY");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_middle_of_a_linkedlist_tortoisehare_method.setSolveLink("https://leetcode.com/problems/middle-of-the-linked-list/");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_middle_of_a_linkedlist_tortoisehare_method.setEditorialLink("https://takeuforward.org/plus/dsa/problems/find-middle-of-linked-list?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_middle_of_a_linkedlist_tortoisehare_method.addLink(new QuestionLink("VIDEO", "https://youtu.be/7LjQ57RqgEc?si=ir_rRDio38rhamU_"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_middle_of_a_linkedlist_tortoisehare_method.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/find-middle-element-in-a-linked-list/"));
        
        
        topic_6_3.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_middle_of_a_linkedlist_tortoisehare_method);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_reverse_a_linkedlist_iterative = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_reverse_a_linkedlist_iterative", "Reverse a LinkedList [Iterative]", "MEDIUM");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_reverse_a_linkedlist_iterative.setSolveLink("https://leetcode.com/problems/reverse-linked-list/");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_reverse_a_linkedlist_iterative.setEditorialLink("https://takeuforward.org/plus/dsa/problems/reverse-a-ll?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_reverse_a_linkedlist_iterative.addLink(new QuestionLink("VIDEO", "https://youtu.be/D2vI2DNJGd8?si=RCaLSx01qR21IBdh"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_reverse_a_linkedlist_iterative.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/reverse-a-linked-list/"));
        
        
        topic_6_3.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_reverse_a_linkedlist_iterative);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_reverse_a_ll = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_reverse_a_ll", "Reverse a LL", "MEDIUM");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_reverse_a_ll.setSolveLink("https://leetcode.com/problems/reverse-linked-list/");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_reverse_a_ll.setEditorialLink("https://takeuforward.org/plus/dsa/problems/reverse-a-ll?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_reverse_a_ll.addLink(new QuestionLink("VIDEO", "https://youtu.be/D2vI2DNJGd8?si=RCaLSx01qR21IBdh"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_reverse_a_ll.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/reverse-a-linked-list/"));
        
        
        topic_6_3.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_reverse_a_ll);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_detect_a_loop_in_ll = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_detect_a_loop_in_ll", "Detect a loop in LL", "MEDIUM");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_detect_a_loop_in_ll.setSolveLink("https://leetcode.com/problems/linked-list-cycle/");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_detect_a_loop_in_ll.setEditorialLink("https://takeuforward.org/plus/dsa/problems/detect-a-loop-in-ll?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_detect_a_loop_in_ll.addLink(new QuestionLink("VIDEO", "https://youtu.be/wiOo4DC5GGA?si=zagt6O6tFXc4_3cx"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_detect_a_loop_in_ll.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/detect-a-cycle-in-a-linked-list/"));
        
        
        topic_6_3.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_detect_a_loop_in_ll);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_find_the_starting_point_in_ll = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_find_the_starting_point_in_ll", "Find the starting point in LL", "MEDIUM");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_find_the_starting_point_in_ll.setSolveLink("https://leetcode.com/problems/linked-list-cycle-ii/");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_find_the_starting_point_in_ll.setEditorialLink("https://takeuforward.org/plus/dsa/problems/find-the-starting-point-in-ll?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_find_the_starting_point_in_ll.addLink(new QuestionLink("VIDEO", "https://youtu.be/2Kd0KKmmHFc?si=7UreDPRjRvapeVB0"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_find_the_starting_point_in_ll.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/starting-point-of-loop-in-a-linked-list/"));
        
        
        topic_6_3.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_find_the_starting_point_in_ll);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_length_of_loop_in_ll = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_length_of_loop_in_ll", "Length of loop in LL", "MEDIUM");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_length_of_loop_in_ll.setSolveLink("https://takeuforward.org/plus/dsa/problems/length-of-loop-in-ll");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_length_of_loop_in_ll.setEditorialLink("https://takeuforward.org/plus/dsa/problems/length-of-loop-in-ll?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_length_of_loop_in_ll.addLink(new QuestionLink("VIDEO", "https://youtu.be/I4g1qbkTPus?si=ONktpqewvx57T8pF"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_length_of_loop_in_ll.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/linked-list/length-of-loop-in-linked-list"));
        
        
        topic_6_3.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_length_of_loop_in_ll);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_check_if_ll_is_palindrome_or_not = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_check_if_ll_is_palindrome_or_not", "Check if LL is palindrome or not", "MEDIUM");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_check_if_ll_is_palindrome_or_not.setSolveLink("https://leetcode.com/problems/palindrome-linked-list/");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_check_if_ll_is_palindrome_or_not.setEditorialLink("https://takeuforward.org/plus/dsa/problems/check-if-ll-is-palindrome-or-not?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_check_if_ll_is_palindrome_or_not.addLink(new QuestionLink("VIDEO", "https://youtu.be/lRY_G-u_8jk?si=BpM8hRYvXSYyjl-G"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_check_if_ll_is_palindrome_or_not.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/check-if-given-linked-list-is-plaindrome/"));
        
        
        topic_6_3.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_check_if_ll_is_palindrome_or_not);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_segregate_odd_and_even_nodes_in_linked_list = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_segregate_odd_and_even_nodes_in_linked_list", "Segregate odd and even nodes in Linked List", "MEDIUM");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_segregate_odd_and_even_nodes_in_linked_list.setSolveLink("https://leetcode.com/problems/odd-even-linked-list/");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_segregate_odd_and_even_nodes_in_linked_list.setEditorialLink("https://takeuforward.org/plus/dsa/problems/segregate-odd-and-even-nodes-in-ll?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_segregate_odd_and_even_nodes_in_linked_list.addLink(new QuestionLink("VIDEO", "https://youtu.be/qf6qp7GzD5Q?si=JozAyXUdT8EJMSCQ"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_segregate_odd_and_even_nodes_in_linked_list.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/segregate-even-and-odd-nodes-in-linkedlist"));
        
        
        topic_6_3.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_segregate_odd_and_even_nodes_in_linked_list);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_remove_nth_node_from_the_back_of_the_ll = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_remove_nth_node_from_the_back_of_the_ll", "Remove Nth node from the back of the LL", "MEDIUM");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_remove_nth_node_from_the_back_of_the_ll.setSolveLink("https://leetcode.com/problems/remove-nth-node-from-end-of-list/");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_remove_nth_node_from_the_back_of_the_ll.setEditorialLink("https://takeuforward.org/plus/dsa/problems/remove-nth-node-from-the-back-of-the-ll?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_remove_nth_node_from_the_back_of_the_ll.addLink(new QuestionLink("VIDEO", "https://youtu.be/3kMKYQ2wNIU?si=DtFDnPU7z9HMz_GM"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_remove_nth_node_from_the_back_of_the_ll.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/remove-n-th-node-from-the-end-of-a-linked-list/"));
        
        
        topic_6_3.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_remove_nth_node_from_the_back_of_the_ll);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_delete_the_middle_node_in_ll = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_delete_the_middle_node_in_ll", "Delete the middle node in LL", "MEDIUM");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_delete_the_middle_node_in_ll.setSolveLink("https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/#:~:text=You%20are%20given%20the%20head,than%20or%20equal%20to%20x%20.");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_delete_the_middle_node_in_ll.setEditorialLink("https://takeuforward.org/plus/dsa/problems/delete-the-middle-node-in-ll?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_delete_the_middle_node_in_ll.addLink(new QuestionLink("VIDEO", "https://youtu.be/ePpV-_pfOeI?si=Au9GsZkVO57j6SiN"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_delete_the_middle_node_in_ll.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/linked-list/delete-the-middle-node-of-the-linked-list"));
        
        
        topic_6_3.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_delete_the_middle_node_in_ll);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_sort_ll = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_sort_ll", "Sort LL", "HARD");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_sort_ll.setSolveLink("https://leetcode.com/problems/sort-list/");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_sort_ll.setEditorialLink("https://takeuforward.org/plus/dsa/problems/sort-ll?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_sort_ll.addLink(new QuestionLink("VIDEO", "https://youtu.be/8ocB7a_c-Cc?si=Gv-Y8q8-WyARoV35"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_sort_ll.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/linked-list/sort-a-linked-list"));
        
        
        topic_6_3.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_sort_ll);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_sort_a_linked_list_of_0s_1s_and_2s = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_sort_a_linked_list_of_0s_1s_and_2s", "Sort a Linked List of 0's 1's and 2's", "MEDIUM");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_sort_a_linked_list_of_0s_1s_and_2s.setSolveLink("https://takeuforward.org/plus/dsa/problems/sort-a-ll-of-0's-1's-and-2's");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_sort_a_linked_list_of_0s_1s_and_2s.setEditorialLink("https://takeuforward.org/plus/dsa/problems/sort-a-ll-of-0's-1's-and-2's?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_sort_a_linked_list_of_0s_1s_and_2s.addLink(new QuestionLink("VIDEO", "https://youtu.be/gRII7LhdJWc?si=l3qRC7w3NhY7OAqw"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_sort_a_linked_list_of_0s_1s_and_2s.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/sort-a-linked-list-of-0s-1s-and-2s-by-changing-links"));
        
        
        topic_6_3.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_sort_a_linked_list_of_0s_1s_and_2s);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_find_the_intersection_point_of_y_ll = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_find_the_intersection_point_of_y_ll", "Find the intersection point of Y LL", "MEDIUM");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_find_the_intersection_point_of_y_ll.setSolveLink("https://leetcode.com/problems/intersection-of-two-linked-lists/");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_find_the_intersection_point_of_y_ll.setEditorialLink("https://takeuforward.org/plus/dsa/problems/find-the-intersection-point-of-y-ll?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_find_the_intersection_point_of_y_ll.addLink(new QuestionLink("VIDEO", "https://youtu.be/0DYoPz2Tpt4?si=L-uJs5yXUxj4VJM2"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_find_the_intersection_point_of_y_ll.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/find-intersection-of-two-linked-lists/"));
        
        
        topic_6_3.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_find_the_intersection_point_of_y_ll);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_add_one_to_a_number_represented_by_ll = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_add_one_to_a_number_represented_by_ll", "Add one to a number represented by LL", "MEDIUM");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_add_one_to_a_number_represented_by_ll.setSolveLink("https://takeuforward.org/plus/dsa/problems/add-one-to-a-number-represented-by-ll");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_add_one_to_a_number_represented_by_ll.setEditorialLink("https://takeuforward.org/plus/dsa/problems/add-one-to-a-number-represented-by-ll?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_add_one_to_a_number_represented_by_ll.addLink(new QuestionLink("VIDEO", "https://youtu.be/aXQWhbvT3w0?si=uRgU9S4r5cVmnUy7"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_add_one_to_a_number_represented_by_ll.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/add-1-to-a-number-represented-by-ll"));
        
        
        topic_6_3.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_add_one_to_a_number_represented_by_ll);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_add_two_numbers_in_linked_list = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_add_two_numbers_in_linked_list", "Add two numbers in Linked List", "MEDIUM");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_add_two_numbers_in_linked_list.setSolveLink("https://leetcode.com/problems/add-two-numbers/");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_add_two_numbers_in_linked_list.setEditorialLink("https://takeuforward.org/plus/dsa/problems/add-two-numbers-in-ll?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_add_two_numbers_in_linked_list.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=LBVsXSMOIk4&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=32"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_add_two_numbers_in_linked_list.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/add-two-numbers-represented-as-linked-lists/"));
        
        
        topic_6_3.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_ll_add_two_numbers_in_linked_list);
        
        
        section_6.addTopic(topic_6_3);
        
        // Topic: Medium Problems of DLL
        Topic topic_6_4 = new Topic("learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll", "Medium Problems of DLL");
        
        
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll_delete_all_occurrences_of_a_key_in_dll = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll_delete_all_occurrences_of_a_key_in_dll", "Delete all occurrences of a key in DLL", "HARD");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll_delete_all_occurrences_of_a_key_in_dll.setSolveLink("https://takeuforward.org/plus/dsa/problems/delete-all-occurrences-of-a-key-in-dll");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll_delete_all_occurrences_of_a_key_in_dll.setEditorialLink("https://takeuforward.org/plus/dsa/problems/delete-all-occurrences-of-a-key-in-dll?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll_delete_all_occurrences_of_a_key_in_dll.addLink(new QuestionLink("VIDEO", "https://youtu.be/Mh0NH_SD92k?si=tCYshBRi1upMqSVz"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll_delete_all_occurrences_of_a_key_in_dll.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/delete-all-occurrences-of-a-key-in-dll"));
        
        
        topic_6_4.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll_delete_all_occurrences_of_a_key_in_dll);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll_find_pairs_with_given_sum_in_doubly_linked_list = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll_find_pairs_with_given_sum_in_doubly_linked_list", "Find Pairs with Given Sum in Doubly Linked List", "MEDIUM");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll_find_pairs_with_given_sum_in_doubly_linked_list.setSolveLink("https://takeuforward.org/plus/dsa/problems/find-pairs-with-given-sum-in-doubly-linked-list");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll_find_pairs_with_given_sum_in_doubly_linked_list.setEditorialLink("");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll_find_pairs_with_given_sum_in_doubly_linked_list.addLink(new QuestionLink("VIDEO", "https://youtu.be/YitR4dQsddE?si=iZAC259hdngV_OxC"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll_find_pairs_with_given_sum_in_doubly_linked_list.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/find-pairs-with-given-sum-in-doubly-linked-list"));
        
        
        topic_6_4.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll_find_pairs_with_given_sum_in_doubly_linked_list);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll_remove_duplicates_from_sorted_dll = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll_remove_duplicates_from_sorted_dll", "Remove duplicates from sorted DLL", "HARD");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll_remove_duplicates_from_sorted_dll.setSolveLink("https://takeuforward.org/plus/dsa/problems/remove-duplicated-from-sorted-dll");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll_remove_duplicates_from_sorted_dll.setEditorialLink("https://takeuforward.org/plus/dsa/problems/remove-duplicated-from-sorted-dll?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll_remove_duplicates_from_sorted_dll.addLink(new QuestionLink("VIDEO", "https://youtu.be/YJKVTnOJXSY?si=AsZoNUoewetsBjr0"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll_remove_duplicates_from_sorted_dll.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/remove-duplicates-from-sorted-dll"));
        
        
        topic_6_4.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_medium_problems_of_dll_remove_duplicates_from_sorted_dll);
        
        
        section_6.addTopic(topic_6_4);
        
        // Topic: Hard Problems of LL
        Topic topic_6_5 = new Topic("learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll", "Hard Problems of LL");
        
        
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_reverse_ll_in_group_of_given_size_k = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_reverse_ll_in_group_of_given_size_k", "Reverse LL in group of given size K", "HARD");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_reverse_ll_in_group_of_given_size_k.setSolveLink("https://leetcode.com/problems/reverse-nodes-in-k-group/");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_reverse_ll_in_group_of_given_size_k.setEditorialLink("https://takeuforward.org/plus/dsa/problems/reverse-ll-in-group-of-given-size-k?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_reverse_ll_in_group_of_given_size_k.addLink(new QuestionLink("VIDEO", "https://youtu.be/lIar1skcQYI?si=_jFghHKX4eaK36a1"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_reverse_ll_in_group_of_given_size_k.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/reverse-linked-list-in-groups-of-size-k/"));
        
        
        topic_6_5.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_reverse_ll_in_group_of_given_size_k);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_rotate_a_ll = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_rotate_a_ll", "Rotate a LL", "HARD");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_rotate_a_ll.setSolveLink("https://leetcode.com/problems/rotate-list/description/");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_rotate_a_ll.setEditorialLink("https://takeuforward.org/plus/dsa/problems/rotate-a-ll?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_rotate_a_ll.addLink(new QuestionLink("VIDEO", "https://youtu.be/uT7YI7XbTY8?si=ZaChW3a68c_v54Is"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_rotate_a_ll.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/rotate-a-linked-list/"));
        
        
        topic_6_5.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_rotate_a_ll);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_flattening_of_ll = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_flattening_of_ll", "Flattening of LL", "HARD");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_flattening_of_ll.setSolveLink("https://takeuforward.org/plus/dsa/problems/flattening-of-ll");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_flattening_of_ll.setEditorialLink("https://takeuforward.org/plus/dsa/problems/flattening-of-ll?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_flattening_of_ll.addLink(new QuestionLink("VIDEO", "https://youtu.be/ykelywHJWLg?si=InMg9MmTHzY22NSR"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_flattening_of_ll.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/flattening-a-linked-list/"));
        
        
        topic_6_5.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_flattening_of_ll);
        
        Question q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_clone_a_ll_with_random_and_next_pointer = new Question("learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_clone_a_ll_with_random_and_next_pointer", "Clone a LL with random and next pointer", "HARD");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_clone_a_ll_with_random_and_next_pointer.setSolveLink("https://leetcode.com/problems/copy-list-with-random-pointer/");
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_clone_a_ll_with_random_and_next_pointer.setEditorialLink("https://takeuforward.org/plus/dsa/problems/clone-a-ll-with-random-and-next-pointer?tab=editorial");
        
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_clone_a_ll_with_random_and_next_pointer.addLink(new QuestionLink("VIDEO", "https://youtu.be/q570bKdrnlw?si=epZtpWvtNwuTf23o"));
        
        q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_clone_a_ll_with_random_and_next_pointer.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/clone-linked-list-with-random-and-next-pointer/"));
        
        
        topic_6_5.addQuestion(q_learn_linkedlist_single_ll_double_ll_medium_hard_problems_hard_problems_of_ll_clone_a_ll_with_random_and_next_pointer);
        
        
        section_6.addTopic(topic_6_5);
        
        
        Roadmap.addSection(section_6);
        
        // ==========================================
        // Section: Recursion [PatternWise]
        // ==========================================
        RoadmapSection section_7 = new RoadmapSection("recursion_patternwise", "Recursion [PatternWise]");
        
        
        
        // Topic: Get a Strong Hold
        Topic topic_7_1 = new Topic("recursion_patternwise_get_a_strong_hold", "Get a Strong Hold");
        
        
        
        Question q_recursion_patternwise_get_a_strong_hold_recursive_implementation_of_atoi = new Question("recursion_patternwise_get_a_strong_hold_recursive_implementation_of_atoi", "Recursive Implementation of atoi()", "MEDIUM");
        q_recursion_patternwise_get_a_strong_hold_recursive_implementation_of_atoi.setSolveLink("https://leetcode.com/problems/string-to-integer-atoi/");
        q_recursion_patternwise_get_a_strong_hold_recursive_implementation_of_atoi.setEditorialLink("https://takeuforward.org/plus/dsa/problems/string-to-integer-atoi?tab=editorial");
        
        
        q_recursion_patternwise_get_a_strong_hold_recursive_implementation_of_atoi.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/recursive-implementation-of-atoi"));
        
        
        topic_7_1.addQuestion(q_recursion_patternwise_get_a_strong_hold_recursive_implementation_of_atoi);
        
        Question q_recursion_patternwise_get_a_strong_hold_powx_n = new Question("recursion_patternwise_get_a_strong_hold_powx_n", "Pow(x, n)", "EASY");
        q_recursion_patternwise_get_a_strong_hold_powx_n.setSolveLink("https://leetcode.com/problems/powx-n/");
        q_recursion_patternwise_get_a_strong_hold_powx_n.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pow(x,n)?tab=editorial");
        
        
        q_recursion_patternwise_get_a_strong_hold_powx_n.addLink(new QuestionLink("VIDEO", "https://youtu.be/l0YC3876qxg"));
        
        q_recursion_patternwise_get_a_strong_hold_powx_n.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/implement-powxn-x-raised-to-the-power-n/"));
        
        
        topic_7_1.addQuestion(q_recursion_patternwise_get_a_strong_hold_powx_n);
        
        Question q_recursion_patternwise_get_a_strong_hold_count_good_numbers = new Question("recursion_patternwise_get_a_strong_hold_count_good_numbers", "Count Good Numbers", "MEDIUM");
        q_recursion_patternwise_get_a_strong_hold_count_good_numbers.setSolveLink("https://leetcode.com/problems/count-good-numbers/");
        q_recursion_patternwise_get_a_strong_hold_count_good_numbers.setEditorialLink("");
        
        
        q_recursion_patternwise_get_a_strong_hold_count_good_numbers.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/count-good-numbers"));
        
        
        topic_7_1.addQuestion(q_recursion_patternwise_get_a_strong_hold_count_good_numbers);
        
        Question q_recursion_patternwise_get_a_strong_hold_sort_a_stack_using_recursion = new Question("recursion_patternwise_get_a_strong_hold_sort_a_stack_using_recursion", "Sort a stack using recursion", "MEDIUM");
        q_recursion_patternwise_get_a_strong_hold_sort_a_stack_using_recursion.setSolveLink("https://takeuforward.org/plus/dsa/problems/sort-a-stack");
        q_recursion_patternwise_get_a_strong_hold_sort_a_stack_using_recursion.setEditorialLink("");
        
        
        q_recursion_patternwise_get_a_strong_hold_sort_a_stack_using_recursion.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/sort-a-stack"));
        
        
        topic_7_1.addQuestion(q_recursion_patternwise_get_a_strong_hold_sort_a_stack_using_recursion);
        
        Question q_recursion_patternwise_get_a_strong_hold_reverse_a_stack = new Question("recursion_patternwise_get_a_strong_hold_reverse_a_stack", "Reverse a Stack", "MEDIUM");
        q_recursion_patternwise_get_a_strong_hold_reverse_a_stack.setSolveLink("https://takeuforward.org/plus/dsa/problems/reverse-a-stack");
        q_recursion_patternwise_get_a_strong_hold_reverse_a_stack.setEditorialLink("");
        
        
        q_recursion_patternwise_get_a_strong_hold_reverse_a_stack.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/reverse-a-stack-using-recursion"));
        
        
        topic_7_1.addQuestion(q_recursion_patternwise_get_a_strong_hold_reverse_a_stack);
        
        
        section_7.addTopic(topic_7_1);
        
        // Topic: Subsequences Pattern
        Topic topic_7_2 = new Topic("recursion_patternwise_subsequences_pattern", "Subsequences Pattern");
        
        
        
        Question q_recursion_patternwise_subsequences_pattern_generate_binary_strings_without_consecutive_1s = new Question("recursion_patternwise_subsequences_pattern_generate_binary_strings_without_consecutive_1s", "Generate Binary Strings Without Consecutive 1s", "MEDIUM");
        q_recursion_patternwise_subsequences_pattern_generate_binary_strings_without_consecutive_1s.setSolveLink("https://takeuforward.org/plus/dsa/problems/generate-binary-strings-without-consecutive-1s");
        q_recursion_patternwise_subsequences_pattern_generate_binary_strings_without_consecutive_1s.setEditorialLink("");
        
        
        q_recursion_patternwise_subsequences_pattern_generate_binary_strings_without_consecutive_1s.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/generate-all-binary-strings"));
        
        
        topic_7_2.addQuestion(q_recursion_patternwise_subsequences_pattern_generate_binary_strings_without_consecutive_1s);
        
        Question q_recursion_patternwise_subsequences_pattern_generate_parentheses = new Question("recursion_patternwise_subsequences_pattern_generate_parentheses", "Generate Parentheses", "MEDIUM");
        q_recursion_patternwise_subsequences_pattern_generate_parentheses.setSolveLink("https://leetcode.com/problems/generate-parentheses/");
        q_recursion_patternwise_subsequences_pattern_generate_parentheses.setEditorialLink("https://takeuforward.org/plus/dsa/problems/generate-parentheses?tab=editorial");
        
        
        q_recursion_patternwise_subsequences_pattern_generate_parentheses.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/generate-parenthesis"));
        
        
        topic_7_2.addQuestion(q_recursion_patternwise_subsequences_pattern_generate_parentheses);
        
        Question q_recursion_patternwise_subsequences_pattern_power_set = new Question("recursion_patternwise_subsequences_pattern_power_set", "Power Set", "MEDIUM");
        q_recursion_patternwise_subsequences_pattern_power_set.setSolveLink("https://takeuforward.org/plus/dsa/problems/power-set");
        q_recursion_patternwise_subsequences_pattern_power_set.setEditorialLink("https://takeuforward.org/plus/dsa/problems/power-set?tab=editorial");
        
        
        q_recursion_patternwise_subsequences_pattern_power_set.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=b7AYbpM5YrE&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=67"));
        
        q_recursion_patternwise_subsequences_pattern_power_set.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/power-set-print-all-the-possible-subsequences-of-the-string/"));
        
        
        topic_7_2.addQuestion(q_recursion_patternwise_subsequences_pattern_power_set);
        
        Question q_recursion_patternwise_subsequences_pattern_learn_all_patterns_of_subsequences_theory = new Question("recursion_patternwise_subsequences_pattern_learn_all_patterns_of_subsequences_theory", "Learn All Patterns of Subsequences (Theory)", "EASY");
        q_recursion_patternwise_subsequences_pattern_learn_all_patterns_of_subsequences_theory.setSolveLink("https://takeuforward.org/data-structure/learn-all-patterns-of-subsequences-theory");
        q_recursion_patternwise_subsequences_pattern_learn_all_patterns_of_subsequences_theory.setEditorialLink("");
        
        
        q_recursion_patternwise_subsequences_pattern_learn_all_patterns_of_subsequences_theory.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=eQCS_v3bw0Q&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=7"));
        
        q_recursion_patternwise_subsequences_pattern_learn_all_patterns_of_subsequences_theory.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/learn-all-patterns-of-subsequences-theory"));
        
        
        topic_7_2.addQuestion(q_recursion_patternwise_subsequences_pattern_learn_all_patterns_of_subsequences_theory);
        
        Question q_recursion_patternwise_subsequences_pattern_count_all_subsequences_with_sum_k = new Question("recursion_patternwise_subsequences_pattern_count_all_subsequences_with_sum_k", "Count all subsequences with sum K", "EASY");
        q_recursion_patternwise_subsequences_pattern_count_all_subsequences_with_sum_k.setSolveLink("https://takeuforward.org/plus/dsa/problems/count-all-subsequences-with-sum-k");
        q_recursion_patternwise_subsequences_pattern_count_all_subsequences_with_sum_k.setEditorialLink("https://takeuforward.org/plus/dsa/problems/count-all-subsequences-with-sum-k?tab=editorial");
        
        
        q_recursion_patternwise_subsequences_pattern_count_all_subsequences_with_sum_k.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/count-all-subsequences-with-sum-k"));
        
        
        topic_7_2.addQuestion(q_recursion_patternwise_subsequences_pattern_count_all_subsequences_with_sum_k);
        
        Question q_recursion_patternwise_subsequences_pattern_check_if_there_exists_a_subsequence_with_sum_k = new Question("recursion_patternwise_subsequences_pattern_check_if_there_exists_a_subsequence_with_sum_k", "Check if there exists a subsequence with sum K", "EASY");
        q_recursion_patternwise_subsequences_pattern_check_if_there_exists_a_subsequence_with_sum_k.setSolveLink("https://takeuforward.org/plus/dsa/problems/check-if-there-exists-a-subsequence-with-sum-k");
        q_recursion_patternwise_subsequences_pattern_check_if_there_exists_a_subsequence_with_sum_k.setEditorialLink("https://takeuforward.org/plus/dsa/problems/check-if-there-exists-a-subsequence-with-sum-k?tab=editorial");
        
        
        q_recursion_patternwise_subsequences_pattern_check_if_there_exists_a_subsequence_with_sum_k.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/check-if-there-exists-a-subsequence-with-sum-k"));
        
        
        topic_7_2.addQuestion(q_recursion_patternwise_subsequences_pattern_check_if_there_exists_a_subsequence_with_sum_k);
        
        Question q_recursion_patternwise_subsequences_pattern_combination_sum = new Question("recursion_patternwise_subsequences_pattern_combination_sum", "Combination Sum", "MEDIUM");
        q_recursion_patternwise_subsequences_pattern_combination_sum.setSolveLink("https://leetcode.com/problems/combination-sum/");
        q_recursion_patternwise_subsequences_pattern_combination_sum.setEditorialLink("https://takeuforward.org/plus/dsa/problems/combination-sum?tab=editorial");
        
        
        q_recursion_patternwise_subsequences_pattern_combination_sum.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=OyZFFqQtu98&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=49"));
        
        q_recursion_patternwise_subsequences_pattern_combination_sum.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/combination-sum-1/"));
        
        
        topic_7_2.addQuestion(q_recursion_patternwise_subsequences_pattern_combination_sum);
        
        Question q_recursion_patternwise_subsequences_pattern_combination_sum_ii = new Question("recursion_patternwise_subsequences_pattern_combination_sum_ii", "Combination Sum II", "MEDIUM");
        q_recursion_patternwise_subsequences_pattern_combination_sum_ii.setSolveLink("https://leetcode.com/problems/combination-sum-ii/");
        q_recursion_patternwise_subsequences_pattern_combination_sum_ii.setEditorialLink("https://takeuforward.org/plus/dsa/problems/combination-sum-ii?tab=editorial");
        
        
        q_recursion_patternwise_subsequences_pattern_combination_sum_ii.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=G1fRTGRxXU8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=50"));
        
        q_recursion_patternwise_subsequences_pattern_combination_sum_ii.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/combination-sum-ii-find-all-unique-combinations/"));
        
        
        topic_7_2.addQuestion(q_recursion_patternwise_subsequences_pattern_combination_sum_ii);
        
        Question q_recursion_patternwise_subsequences_pattern_subsets_i = new Question("recursion_patternwise_subsequences_pattern_subsets_i", "Subsets I", "MEDIUM");
        q_recursion_patternwise_subsequences_pattern_subsets_i.setSolveLink("https://takeuforward.org/plus/dsa/problems/subsets-i");
        q_recursion_patternwise_subsequences_pattern_subsets_i.setEditorialLink("https://takeuforward.org/plus/dsa/problems/subsets-i?tab=editorial");
        
        
        q_recursion_patternwise_subsequences_pattern_subsets_i.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=rYkfBRtMJr8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=52"));
        
        q_recursion_patternwise_subsequences_pattern_subsets_i.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/subset-sum-sum-of-all-subsets/"));
        
        
        topic_7_2.addQuestion(q_recursion_patternwise_subsequences_pattern_subsets_i);
        
        Question q_recursion_patternwise_subsequences_pattern_subsets_ii = new Question("recursion_patternwise_subsequences_pattern_subsets_ii", "Subsets II", "MEDIUM");
        q_recursion_patternwise_subsequences_pattern_subsets_ii.setSolveLink("https://leetcode.com/problems/subsets-ii/");
        q_recursion_patternwise_subsequences_pattern_subsets_ii.setEditorialLink("https://takeuforward.org/plus/dsa/problems/subsets-ii?tab=editorial");
        
        
        q_recursion_patternwise_subsequences_pattern_subsets_ii.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=RIn3gOkbhQE&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=53"));
        
        q_recursion_patternwise_subsequences_pattern_subsets_ii.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/subset-ii-print-all-the-unique-subsets/"));
        
        
        topic_7_2.addQuestion(q_recursion_patternwise_subsequences_pattern_subsets_ii);
        
        Question q_recursion_patternwise_subsequences_pattern_combination_sum_iii = new Question("recursion_patternwise_subsequences_pattern_combination_sum_iii", "Combination Sum III", "MEDIUM");
        q_recursion_patternwise_subsequences_pattern_combination_sum_iii.setSolveLink("https://leetcode.com/problems/combination-sum-iii/");
        q_recursion_patternwise_subsequences_pattern_combination_sum_iii.setEditorialLink("https://takeuforward.org/plus/dsa/problems/combination-sum-iii?tab=editorial");
        
        
        q_recursion_patternwise_subsequences_pattern_combination_sum_iii.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/combination-sum-iii"));
        
        
        topic_7_2.addQuestion(q_recursion_patternwise_subsequences_pattern_combination_sum_iii);
        
        Question q_recursion_patternwise_subsequences_pattern_letter_combinations_of_a_phone_number = new Question("recursion_patternwise_subsequences_pattern_letter_combinations_of_a_phone_number", "Letter Combinations of a Phone Number", "HARD");
        q_recursion_patternwise_subsequences_pattern_letter_combinations_of_a_phone_number.setSolveLink("https://leetcode.com/problems/letter-combinations-of-a-phone-number/");
        q_recursion_patternwise_subsequences_pattern_letter_combinations_of_a_phone_number.setEditorialLink("https://takeuforward.org/plus/dsa/problems/letter-combinations-of-a-phone-number?tab=editorial");
        
        
        q_recursion_patternwise_subsequences_pattern_letter_combinations_of_a_phone_number.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/letter-combinations-of-a-phone-number"));
        
        
        topic_7_2.addQuestion(q_recursion_patternwise_subsequences_pattern_letter_combinations_of_a_phone_number);
        
        
        section_7.addTopic(topic_7_2);
        
        // Topic: Trying out all Combos / Hard
        Topic topic_7_3 = new Topic("recursion_patternwise_trying_out_all_combos_hard", "Trying out all Combos / Hard");
        
        
        
        Question q_recursion_patternwise_trying_out_all_combos_hard_palindrome_partitioning = new Question("recursion_patternwise_trying_out_all_combos_hard_palindrome_partitioning", "Palindrome partitioning", "HARD");
        q_recursion_patternwise_trying_out_all_combos_hard_palindrome_partitioning.setSolveLink("https://takeuforward.org/plus/dsa/problems/palindrome-partitioning");
        q_recursion_patternwise_trying_out_all_combos_hard_palindrome_partitioning.setEditorialLink("https://takeuforward.org/plus/dsa/problems/palindrome-partitioning?tab=editorial");
        
        
        q_recursion_patternwise_trying_out_all_combos_hard_palindrome_partitioning.addLink(new QuestionLink("VIDEO", "https://youtu.be/_H8V5hJUGd0"));
        
        
        topic_7_3.addQuestion(q_recursion_patternwise_trying_out_all_combos_hard_palindrome_partitioning);
        
        Question q_recursion_patternwise_trying_out_all_combos_hard_word_search = new Question("recursion_patternwise_trying_out_all_combos_hard_word_search", "Word Search", "HARD");
        q_recursion_patternwise_trying_out_all_combos_hard_word_search.setSolveLink("https://leetcode.com/problems/word-search/");
        q_recursion_patternwise_trying_out_all_combos_hard_word_search.setEditorialLink("https://takeuforward.org/plus/dsa/problems/word-search?tab=editorial");
        
        
        q_recursion_patternwise_trying_out_all_combos_hard_word_search.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/word-search-leetcode/"));
        
        
        topic_7_3.addQuestion(q_recursion_patternwise_trying_out_all_combos_hard_word_search);
        
        Question q_recursion_patternwise_trying_out_all_combos_hard_n_queen = new Question("recursion_patternwise_trying_out_all_combos_hard_n_queen", "N Queen", "HARD");
        q_recursion_patternwise_trying_out_all_combos_hard_n_queen.setSolveLink("https://leetcode.com/problems/n-queens/");
        q_recursion_patternwise_trying_out_all_combos_hard_n_queen.setEditorialLink("https://takeuforward.org/plus/dsa/problems/n-queen?tab=editorial");
        
        
        q_recursion_patternwise_trying_out_all_combos_hard_n_queen.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=i05Ju7AftcM&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=57"));
        
        q_recursion_patternwise_trying_out_all_combos_hard_n_queen.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/n-queen-problem-return-all-distinct-solutions-to-the-n-queens-puzzle/"));
        
        
        topic_7_3.addQuestion(q_recursion_patternwise_trying_out_all_combos_hard_n_queen);
        
        Question q_recursion_patternwise_trying_out_all_combos_hard_rat_in_a_maze = new Question("recursion_patternwise_trying_out_all_combos_hard_rat_in_a_maze", "Rat in a Maze", "HARD");
        q_recursion_patternwise_trying_out_all_combos_hard_rat_in_a_maze.setSolveLink("https://takeuforward.org/plus/dsa/problems/rat-in-a-maze");
        q_recursion_patternwise_trying_out_all_combos_hard_rat_in_a_maze.setEditorialLink("https://takeuforward.org/plus/dsa/problems/rat-in-a-maze?tab=editorial");
        
        
        q_recursion_patternwise_trying_out_all_combos_hard_rat_in_a_maze.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=bLGZhJlt4y0&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=60"));
        
        q_recursion_patternwise_trying_out_all_combos_hard_rat_in_a_maze.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/rat-in-a-maze/"));
        
        
        topic_7_3.addQuestion(q_recursion_patternwise_trying_out_all_combos_hard_rat_in_a_maze);
        
        Question q_recursion_patternwise_trying_out_all_combos_hard_word_break = new Question("recursion_patternwise_trying_out_all_combos_hard_word_break", "Word Break", "MEDIUM");
        q_recursion_patternwise_trying_out_all_combos_hard_word_break.setSolveLink("https://takeuforward.org/plus/dsa/problems/word-break");
        q_recursion_patternwise_trying_out_all_combos_hard_word_break.setEditorialLink("https://takeuforward.org/plus/dsa/problems/word-break?tab=editorial");
        
        
        
        topic_7_3.addQuestion(q_recursion_patternwise_trying_out_all_combos_hard_word_break);
        
        Question q_recursion_patternwise_trying_out_all_combos_hard_m_coloring_problem = new Question("recursion_patternwise_trying_out_all_combos_hard_m_coloring_problem", "M Coloring Problem", "HARD");
        q_recursion_patternwise_trying_out_all_combos_hard_m_coloring_problem.setSolveLink("https://takeuforward.org/plus/dsa/problems/m-coloring-problem");
        q_recursion_patternwise_trying_out_all_combos_hard_m_coloring_problem.setEditorialLink("https://takeuforward.org/plus/dsa/problems/m-coloring-problem?tab=editorial");
        
        
        q_recursion_patternwise_trying_out_all_combos_hard_m_coloring_problem.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=wuVwUK25Rfc&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=59"));
        
        q_recursion_patternwise_trying_out_all_combos_hard_m_coloring_problem.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/m-coloring-problem/"));
        
        
        topic_7_3.addQuestion(q_recursion_patternwise_trying_out_all_combos_hard_m_coloring_problem);
        
        Question q_recursion_patternwise_trying_out_all_combos_hard_sudoku_solver = new Question("recursion_patternwise_trying_out_all_combos_hard_sudoku_solver", "Sudoku Solver", "HARD");
        q_recursion_patternwise_trying_out_all_combos_hard_sudoku_solver.setSolveLink("https://leetcode.com/problems/sudoku-solver/");
        q_recursion_patternwise_trying_out_all_combos_hard_sudoku_solver.setEditorialLink("https://takeuforward.org/plus/dsa/problems/sudoko-solver?tab=editorial");
        
        
        q_recursion_patternwise_trying_out_all_combos_hard_sudoku_solver.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=FWAIf_EVUKE&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=58"));
        
        q_recursion_patternwise_trying_out_all_combos_hard_sudoku_solver.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/sudoku-solver/"));
        
        
        topic_7_3.addQuestion(q_recursion_patternwise_trying_out_all_combos_hard_sudoku_solver);
        
        Question q_recursion_patternwise_trying_out_all_combos_hard_expression_add_operators = new Question("recursion_patternwise_trying_out_all_combos_hard_expression_add_operators", "Expression Add Operators", "HARD");
        q_recursion_patternwise_trying_out_all_combos_hard_expression_add_operators.setSolveLink("https://leetcode.com/problems/expression-add-operators/");
        q_recursion_patternwise_trying_out_all_combos_hard_expression_add_operators.setEditorialLink("");
        
        
        q_recursion_patternwise_trying_out_all_combos_hard_expression_add_operators.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/expression-add-operators"));
        
        
        topic_7_3.addQuestion(q_recursion_patternwise_trying_out_all_combos_hard_expression_add_operators);
        
        
        section_7.addTopic(topic_7_3);
        
        
        Roadmap.addSection(section_7);
        
        // ==========================================
        // Section: Bit Manipulation [Concepts & Problems]
        // ==========================================
        RoadmapSection section_8 = new RoadmapSection("bit_manipulation_concepts_problems", "Bit Manipulation [Concepts & Problems]");
        
        
        
        // Topic: Learn Bit Manipulation
        Topic topic_8_1 = new Topic("bit_manipulation_concepts_problems_learn_bit_manipulation", "Learn Bit Manipulation");
        
        
        
        Question q_bit_manipulation_concepts_problems_learn_bit_manipulation_introduction_to_bits_and_tricks = new Question("bit_manipulation_concepts_problems_learn_bit_manipulation_introduction_to_bits_and_tricks", "Introduction to Bits and Tricks", "EASY");
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_introduction_to_bits_and_tricks.setSolveLink("https://takeuforward.org/plus/dsa/problems/introduction-to-bits-and-tricks");
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_introduction_to_bits_and_tricks.setEditorialLink("https://takeuforward.org/plus/dsa/problems/introduction-to-bits-and-tricks?tab=editorial");
        
        
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_introduction_to_bits_and_tricks.addLink(new QuestionLink("VIDEO", "https://youtu.be/qQd-ViW7bfk?si=QtdNaRhHmZb08Mr8"));
        
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_introduction_to_bits_and_tricks.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/introduction-to-bit-manipulation-theory"));
        
        
        topic_8_1.addQuestion(q_bit_manipulation_concepts_problems_learn_bit_manipulation_introduction_to_bits_and_tricks);
        
        Question q_bit_manipulation_concepts_problems_learn_bit_manipulation_check_if_the_i_th_bit_is_set_or_not = new Question("bit_manipulation_concepts_problems_learn_bit_manipulation_check_if_the_i_th_bit_is_set_or_not", "Check if the i-th bit is Set or Not", "EASY");
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_check_if_the_i_th_bit_is_set_or_not.setSolveLink("https://takeuforward.org/plus/dsa/problems/check-if-the-i-th-bit-is-set-or-not");
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_check_if_the_i_th_bit_is_set_or_not.setEditorialLink("https://takeuforward.org/plus/dsa/problems/check-if-the-i-th-bit-is-set-or-not?tab=editorial");
        
        
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_check_if_the_i_th_bit_is_set_or_not.addLink(new QuestionLink("VIDEO", "https://youtu.be/nttpF8kwgd4?si=x9o8PsYaA2XVZ9rV"));
        
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_check_if_the_i_th_bit_is_set_or_not.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/check-if-the-i-th-bit-is-set-or-not"));
        
        
        topic_8_1.addQuestion(q_bit_manipulation_concepts_problems_learn_bit_manipulation_check_if_the_i_th_bit_is_set_or_not);
        
        Question q_bit_manipulation_concepts_problems_learn_bit_manipulation_check_if_a_number_is_odd_or_not = new Question("bit_manipulation_concepts_problems_learn_bit_manipulation_check_if_a_number_is_odd_or_not", "Check if a Number is Odd or Not", "EASY");
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_check_if_a_number_is_odd_or_not.setSolveLink("https://takeuforward.org/plus/dsa/problems/check-if-a-number-is-odd-or-not");
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_check_if_a_number_is_odd_or_not.setEditorialLink("https://takeuforward.org/plus/dsa/problems/check-if-a-number-is-odd-or-not?tab=editorial");
        
        
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_check_if_a_number_is_odd_or_not.addLink(new QuestionLink("VIDEO", "https://youtu.be/nttpF8kwgd4?si=x9o8PsYaA2XVZ9rV"));
        
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_check_if_a_number_is_odd_or_not.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/check-if-a-number-is-odd-or-not"));
        
        
        topic_8_1.addQuestion(q_bit_manipulation_concepts_problems_learn_bit_manipulation_check_if_a_number_is_odd_or_not);
        
        Question q_bit_manipulation_concepts_problems_learn_bit_manipulation_check_if_a_number_is_power_of_2_or_not = new Question("bit_manipulation_concepts_problems_learn_bit_manipulation_check_if_a_number_is_power_of_2_or_not", "Check if a Number is Power of 2 or Not", "EASY");
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_check_if_a_number_is_power_of_2_or_not.setSolveLink("https://leetcode.com/problems/power-of-two/");
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_check_if_a_number_is_power_of_2_or_not.setEditorialLink("https://takeuforward.org/plus/dsa/problems/check-if-a-number-is-power-of-2-or-not?tab=editorial");
        
        
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_check_if_a_number_is_power_of_2_or_not.addLink(new QuestionLink("VIDEO", "https://youtu.be/nttpF8kwgd4?si=x9o8PsYaA2XVZ9rV"));
        
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_check_if_a_number_is_power_of_2_or_not.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/check-if-a-number-is-power-of-2-or-not"));
        
        
        topic_8_1.addQuestion(q_bit_manipulation_concepts_problems_learn_bit_manipulation_check_if_a_number_is_power_of_2_or_not);
        
        Question q_bit_manipulation_concepts_problems_learn_bit_manipulation_count_the_number_of_set_bits = new Question("bit_manipulation_concepts_problems_learn_bit_manipulation_count_the_number_of_set_bits", "Count the Number of Set Bits", "EASY");
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_count_the_number_of_set_bits.setSolveLink("https://takeuforward.org/plus/dsa/problems/count-the-number-of-set-bits");
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_count_the_number_of_set_bits.setEditorialLink("https://takeuforward.org/plus/dsa/problems/count-the-number-of-set-bits?tab=editorial");
        
        
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_count_the_number_of_set_bits.addLink(new QuestionLink("VIDEO", "https://youtu.be/nttpF8kwgd4?si=x9o8PsYaA2XVZ9rV"));
        
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_count_the_number_of_set_bits.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/count-the-number-of-set-bits"));
        
        
        topic_8_1.addQuestion(q_bit_manipulation_concepts_problems_learn_bit_manipulation_count_the_number_of_set_bits);
        
        Question q_bit_manipulation_concepts_problems_learn_bit_manipulation_setunset_the_rightmost_unset_bit = new Question("bit_manipulation_concepts_problems_learn_bit_manipulation_setunset_the_rightmost_unset_bit", "Set/Unset the rightmost unset bit", "EASY");
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_setunset_the_rightmost_unset_bit.setSolveLink("https://takeuforward.org/data-structure/set-the-rightmost-bit");
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_setunset_the_rightmost_unset_bit.setEditorialLink("");
        
        
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_setunset_the_rightmost_unset_bit.addLink(new QuestionLink("VIDEO", "https://youtu.be/nttpF8kwgd4?si=x9o8PsYaA2XVZ9rV"));
        
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_setunset_the_rightmost_unset_bit.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/set-the-rightmost-bit"));
        
        
        topic_8_1.addQuestion(q_bit_manipulation_concepts_problems_learn_bit_manipulation_setunset_the_rightmost_unset_bit);
        
        Question q_bit_manipulation_concepts_problems_learn_bit_manipulation_swap_two_numbers = new Question("bit_manipulation_concepts_problems_learn_bit_manipulation_swap_two_numbers", "Swap Two Numbers", "EASY");
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_swap_two_numbers.setSolveLink("https://takeuforward.org/plus/dsa/problems/swap-two-numbers");
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_swap_two_numbers.setEditorialLink("");
        
        
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_swap_two_numbers.addLink(new QuestionLink("VIDEO", "https://youtu.be/nttpF8kwgd4?si=x9o8PsYaA2XVZ9rV"));
        
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_swap_two_numbers.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/swap-two-numbers"));
        
        
        topic_8_1.addQuestion(q_bit_manipulation_concepts_problems_learn_bit_manipulation_swap_two_numbers);
        
        Question q_bit_manipulation_concepts_problems_learn_bit_manipulation_divide_two_numbers_without_multiplication_and_division = new Question("bit_manipulation_concepts_problems_learn_bit_manipulation_divide_two_numbers_without_multiplication_and_division", "Divide two numbers without multiplication and division", "MEDIUM");
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_divide_two_numbers_without_multiplication_and_division.setSolveLink("https://leetcode.com/problems/divide-two-integers/");
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_divide_two_numbers_without_multiplication_and_division.setEditorialLink("https://takeuforward.org/plus/dsa/problems/divide-two-numbers-without-multiplication-and-division?tab=editorial");
        
        
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_divide_two_numbers_without_multiplication_and_division.addLink(new QuestionLink("VIDEO", "https://youtu.be/pBD4B1tzgVc?si=G9c5pEE-RrzeU6sz"));
        
        q_bit_manipulation_concepts_problems_learn_bit_manipulation_divide_two_numbers_without_multiplication_and_division.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/divide-two-integers-without-using-multiplication-division-and-mod-operator"));
        
        
        topic_8_1.addQuestion(q_bit_manipulation_concepts_problems_learn_bit_manipulation_divide_two_numbers_without_multiplication_and_division);
        
        
        section_8.addTopic(topic_8_1);
        
        // Topic: Interview Problems
        Topic topic_8_2 = new Topic("bit_manipulation_concepts_problems_interview_problems", "Interview Problems");
        
        
        
        Question q_bit_manipulation_concepts_problems_interview_problems_minimum_bit_flips_to_convert_number = new Question("bit_manipulation_concepts_problems_interview_problems_minimum_bit_flips_to_convert_number", "Minimum Bit Flips to Convert Number", "MEDIUM");
        q_bit_manipulation_concepts_problems_interview_problems_minimum_bit_flips_to_convert_number.setSolveLink("https://leetcode.com/problems/minimum-bit-flips-to-convert-number/");
        q_bit_manipulation_concepts_problems_interview_problems_minimum_bit_flips_to_convert_number.setEditorialLink("https://takeuforward.org/plus/dsa/problems/minimum-bit-flips-to-convert-number?tab=editorial");
        
        
        q_bit_manipulation_concepts_problems_interview_problems_minimum_bit_flips_to_convert_number.addLink(new QuestionLink("VIDEO", "https://youtu.be/OOdrmcfZXd8?si=rnkRVz1UiVBKWC69"));
        
        q_bit_manipulation_concepts_problems_interview_problems_minimum_bit_flips_to_convert_number.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/count-number-of-bits-to-be-flipped-to-convert-a-to-b"));
        
        
        topic_8_2.addQuestion(q_bit_manipulation_concepts_problems_interview_problems_minimum_bit_flips_to_convert_number);
        
        Question q_bit_manipulation_concepts_problems_interview_problems_single_number_i = new Question("bit_manipulation_concepts_problems_interview_problems_single_number_i", "Single Number - I", "MEDIUM");
        q_bit_manipulation_concepts_problems_interview_problems_single_number_i.setSolveLink("https://leetcode.com/problems/single-number/");
        q_bit_manipulation_concepts_problems_interview_problems_single_number_i.setEditorialLink("https://takeuforward.org/plus/dsa/problems/single-number---i?tab=editorial");
        
        
        q_bit_manipulation_concepts_problems_interview_problems_single_number_i.addLink(new QuestionLink("VIDEO", "https://youtu.be/bYWLJb3vCWY?t=1369"));
        
        q_bit_manipulation_concepts_problems_interview_problems_single_number_i.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/arrays/find-the-number-that-appears-once-and-the-other-numbers-twice/"));
        
        
        topic_8_2.addQuestion(q_bit_manipulation_concepts_problems_interview_problems_single_number_i);
        
        Question q_bit_manipulation_concepts_problems_interview_problems_power_set_bit_manipulation = new Question("bit_manipulation_concepts_problems_interview_problems_power_set_bit_manipulation", "Power Set Bit Manipulation", "MEDIUM");
        q_bit_manipulation_concepts_problems_interview_problems_power_set_bit_manipulation.setSolveLink("https://leetcode.com/problems/subsets/");
        q_bit_manipulation_concepts_problems_interview_problems_power_set_bit_manipulation.setEditorialLink("https://takeuforward.org/plus/dsa/problems/power-set-bit-manipulation?tab=editorial");
        
        
        q_bit_manipulation_concepts_problems_interview_problems_power_set_bit_manipulation.addLink(new QuestionLink("VIDEO", "https://youtu.be/LqKaUv1G3_I?si=UXU_T5OsHiokPRvP"));
        
        q_bit_manipulation_concepts_problems_interview_problems_power_set_bit_manipulation.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/bit-manipulation/power-set-bit-manipulation"));
        
        
        topic_8_2.addQuestion(q_bit_manipulation_concepts_problems_interview_problems_power_set_bit_manipulation);
        
        Question q_bit_manipulation_concepts_problems_interview_problems_xor_of_numbers_in_a_given_range = new Question("bit_manipulation_concepts_problems_interview_problems_xor_of_numbers_in_a_given_range", "XOR of numbers in a given range", "MEDIUM");
        q_bit_manipulation_concepts_problems_interview_problems_xor_of_numbers_in_a_given_range.setSolveLink("https://takeuforward.org/plus/dsa/problems/xor-of-numbers-in-a-given-range");
        q_bit_manipulation_concepts_problems_interview_problems_xor_of_numbers_in_a_given_range.setEditorialLink("https://takeuforward.org/plus/dsa/problems/xor-of-numbers-in-a-given-range?tab=editorial");
        
        
        q_bit_manipulation_concepts_problems_interview_problems_xor_of_numbers_in_a_given_range.addLink(new QuestionLink("VIDEO", "https://youtu.be/WqGb7159h7Q?si=uGUEbNUUaIN_6Vvr"));
        
        q_bit_manipulation_concepts_problems_interview_problems_xor_of_numbers_in_a_given_range.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/find-xor-of-numbers-from-l-to-r"));
        
        
        topic_8_2.addQuestion(q_bit_manipulation_concepts_problems_interview_problems_xor_of_numbers_in_a_given_range);
        
        Question q_bit_manipulation_concepts_problems_interview_problems_single_number_iii = new Question("bit_manipulation_concepts_problems_interview_problems_single_number_iii", "Single Number - III", "MEDIUM");
        q_bit_manipulation_concepts_problems_interview_problems_single_number_iii.setSolveLink("https://takeuforward.org/plus/dsa/problems/single-number---iii");
        q_bit_manipulation_concepts_problems_interview_problems_single_number_iii.setEditorialLink("https://takeuforward.org/plus/dsa/problems/single-number---iii?tab=editorial");
        
        
        q_bit_manipulation_concepts_problems_interview_problems_single_number_iii.addLink(new QuestionLink("VIDEO", "https://youtu.be/UA5JnV1J2sI?si=VFBRJyb3boZvx_r1"));
        
        q_bit_manipulation_concepts_problems_interview_problems_single_number_iii.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/find-the-two-numbers-appearing-odd-number-of-times"));
        
        
        topic_8_2.addQuestion(q_bit_manipulation_concepts_problems_interview_problems_single_number_iii);
        
        
        section_8.addTopic(topic_8_2);
        
        // Topic: Advanced Maths
        Topic topic_8_3 = new Topic("bit_manipulation_concepts_problems_advanced_maths", "Advanced Maths");
        
        
        
        Question q_bit_manipulation_concepts_problems_advanced_maths_print_prime_factors_of_a_number = new Question("bit_manipulation_concepts_problems_advanced_maths_print_prime_factors_of_a_number", "Print Prime Factors of a Number", "HARD");
        q_bit_manipulation_concepts_problems_advanced_maths_print_prime_factors_of_a_number.setSolveLink("https://takeuforward.org/plus/dsa/problems/prime-factorisation-of-a-number");
        q_bit_manipulation_concepts_problems_advanced_maths_print_prime_factors_of_a_number.setEditorialLink("https://takeuforward.org/plus/dsa/problems/prime-factorisation-of-a-number?tab=editorial");
        
        
        q_bit_manipulation_concepts_problems_advanced_maths_print_prime_factors_of_a_number.addLink(new QuestionLink("VIDEO", "https://youtu.be/LT7XhVdeRyg?si=6HkjQokJRPTFai21"));
        
        q_bit_manipulation_concepts_problems_advanced_maths_print_prime_factors_of_a_number.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/find-the-two-numbers-appearing-odd-number-of-times"));
        
        
        topic_8_3.addQuestion(q_bit_manipulation_concepts_problems_advanced_maths_print_prime_factors_of_a_number);
        
        Question q_bit_manipulation_concepts_problems_advanced_maths_divisors_of_a_number = new Question("bit_manipulation_concepts_problems_advanced_maths_divisors_of_a_number", "Divisors of a Number", "EASY");
        q_bit_manipulation_concepts_problems_advanced_maths_divisors_of_a_number.setSolveLink("https://takeuforward.org/plus/dsa/problems/divisors-of-a-number");
        q_bit_manipulation_concepts_problems_advanced_maths_divisors_of_a_number.setEditorialLink("https://takeuforward.org/plus/dsa/problems/divisors-of-a-number?tab=editorial");
        
        
        q_bit_manipulation_concepts_problems_advanced_maths_divisors_of_a_number.addLink(new QuestionLink("VIDEO", "https://youtu.be/1xNbjMdbjug?t=1580"));
        
        q_bit_manipulation_concepts_problems_advanced_maths_divisors_of_a_number.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/print-all-divisors-of-a-given-number/"));
        
        
        topic_8_3.addQuestion(q_bit_manipulation_concepts_problems_advanced_maths_divisors_of_a_number);
        
        Question q_bit_manipulation_concepts_problems_advanced_maths_count_primes_in_range_l_to_r = new Question("bit_manipulation_concepts_problems_advanced_maths_count_primes_in_range_l_to_r", "Count primes in range L to R", "HARD");
        q_bit_manipulation_concepts_problems_advanced_maths_count_primes_in_range_l_to_r.setSolveLink("https://leetcode.com/problems/count-primes/");
        q_bit_manipulation_concepts_problems_advanced_maths_count_primes_in_range_l_to_r.setEditorialLink("https://takeuforward.org/plus/dsa/problems/count-primes-in-range-l-to-r?tab=editorial");
        
        
        q_bit_manipulation_concepts_problems_advanced_maths_count_primes_in_range_l_to_r.addLink(new QuestionLink("VIDEO", "https://youtu.be/g5Fuxn_AvSk?si=fv6Q-Po7wrMW0a5n"));
        
        q_bit_manipulation_concepts_problems_advanced_maths_count_primes_in_range_l_to_r.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/sieve-of-eratosthenes"));
        
        
        topic_8_3.addQuestion(q_bit_manipulation_concepts_problems_advanced_maths_count_primes_in_range_l_to_r);
        
        Question q_bit_manipulation_concepts_problems_advanced_maths_prime_factorisation_of_a_number = new Question("bit_manipulation_concepts_problems_advanced_maths_prime_factorisation_of_a_number", "Prime factorisation of a Number", "HARD");
        q_bit_manipulation_concepts_problems_advanced_maths_prime_factorisation_of_a_number.setSolveLink("https://takeuforward.org/plus/dsa/problems/prime-factorisation-of-a-number");
        q_bit_manipulation_concepts_problems_advanced_maths_prime_factorisation_of_a_number.setEditorialLink("https://takeuforward.org/plus/dsa/problems/prime-factorisation-of-a-number?tab=editorial");
        
        
        q_bit_manipulation_concepts_problems_advanced_maths_prime_factorisation_of_a_number.addLink(new QuestionLink("VIDEO", "https://youtu.be/LT7XhVdeRyg?si=6HkjQokJRPTFai21"));
        
        q_bit_manipulation_concepts_problems_advanced_maths_prime_factorisation_of_a_number.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/find-the-two-numbers-appearing-odd-number-of-times"));
        
        
        topic_8_3.addQuestion(q_bit_manipulation_concepts_problems_advanced_maths_prime_factorisation_of_a_number);
        
        Question q_bit_manipulation_concepts_problems_advanced_maths_powxn = new Question("bit_manipulation_concepts_problems_advanced_maths_powxn", "Pow(x,n)", "EASY");
        q_bit_manipulation_concepts_problems_advanced_maths_powxn.setSolveLink("https://leetcode.com/problems/powx-n/");
        q_bit_manipulation_concepts_problems_advanced_maths_powxn.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pow(x,n)?tab=editorial");
        
        
        q_bit_manipulation_concepts_problems_advanced_maths_powxn.addLink(new QuestionLink("VIDEO", "https://youtu.be/l0YC3876qxg"));
        
        q_bit_manipulation_concepts_problems_advanced_maths_powxn.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/implement-powxn-x-raised-to-the-power-n/"));
        
        
        topic_8_3.addQuestion(q_bit_manipulation_concepts_problems_advanced_maths_powxn);
        
        
        section_8.addTopic(topic_8_3);
        
        
        Roadmap.addSection(section_8);
        
        // ==========================================
        // Section: Stack and Queues [Learning, Pre-In-Post-fix, Monotonic Stack, Implementation]
        // ==========================================
        RoadmapSection section_9 = new RoadmapSection("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation", "Stack and Queues [Learning, Pre-In-Post-fix, Monotonic Stack, Implementation]");
        
        
        
        // Topic: Learning
        Topic topic_9_1 = new Topic("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning", "Learning");
        
        
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_stack_using_arrays = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_stack_using_arrays", "Implement Stack using Arrays", "EASY");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_stack_using_arrays.setSolveLink("https://takeuforward.org/plus/dsa/problems/implement-stack-using-arrays");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_stack_using_arrays.setEditorialLink("https://takeuforward.org/plus/dsa/problems/implement-stack-using-arrays?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_stack_using_arrays.addLink(new QuestionLink("VIDEO", "https://youtu.be/tqQ5fTamIN4?si=ofLt8Zt1ZvhikZ6w"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_stack_using_arrays.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/implement-stack-using-array/"));
        
        
        topic_9_1.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_stack_using_arrays);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_queue_using_arrays = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_queue_using_arrays", "Implement Queue using Arrays", "EASY");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_queue_using_arrays.setSolveLink("https://takeuforward.org/plus/dsa/problems/implement-queue-using-arrays");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_queue_using_arrays.setEditorialLink("https://takeuforward.org/plus/dsa/problems/implement-queue-using-arrays?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_queue_using_arrays.addLink(new QuestionLink("VIDEO", "https://youtu.be/tqQ5fTamIN4?si=ofLt8Zt1ZvhikZ6w"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_queue_using_arrays.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/implement-queue-using-array/"));
        
        
        topic_9_1.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_queue_using_arrays);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_stack_using_queue = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_stack_using_queue", "Implement Stack using Queue", "EASY");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_stack_using_queue.setSolveLink("https://leetcode.com/problems/implement-stack-using-queues/");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_stack_using_queue.setEditorialLink("https://takeuforward.org/plus/dsa/problems/implement-stack-using-queue?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_stack_using_queue.addLink(new QuestionLink("VIDEO", "https://youtu.be/tqQ5fTamIN4?si=ofLt8Zt1ZvhikZ6w"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_stack_using_queue.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/implement-stack-using-single-queue"));
        
        
        topic_9_1.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_stack_using_queue);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_queue_using_stack = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_queue_using_stack", "Implement Queue using Stack", "EASY");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_queue_using_stack.setSolveLink("https://leetcode.com/problems/implement-queue-using-stacks/");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_queue_using_stack.setEditorialLink("https://takeuforward.org/plus/dsa/problems/implement-queue-using-stack?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_queue_using_stack.addLink(new QuestionLink("VIDEO", "https://youtu.be/tqQ5fTamIN4?si=ofLt8Zt1ZvhikZ6w"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_queue_using_stack.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/implement-queue-using-stack/"));
        
        
        topic_9_1.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_queue_using_stack);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_stack_using_linkedlist = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_stack_using_linkedlist", "Implement stack using Linkedlist", "EASY");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_stack_using_linkedlist.setSolveLink("https://takeuforward.org/plus/dsa/problems/implement-stack-using-linkedlist");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_stack_using_linkedlist.setEditorialLink("https://takeuforward.org/plus/dsa/problems/implement-stack-using-linkedlist?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_stack_using_linkedlist.addLink(new QuestionLink("VIDEO", "https://youtu.be/tqQ5fTamIN4?si=ofLt8Zt1ZvhikZ6w"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_stack_using_linkedlist.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/implement-stack-using-linked-list/"));
        
        
        topic_9_1.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_stack_using_linkedlist);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_queue_using_linkedlist = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_queue_using_linkedlist", "Implement queue using Linkedlist", "EASY");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_queue_using_linkedlist.setSolveLink("https://takeuforward.org/plus/dsa/problems/implement-queue-using-linkedlist");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_queue_using_linkedlist.setEditorialLink("https://takeuforward.org/plus/dsa/problems/implement-queue-using-linkedlist?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_queue_using_linkedlist.addLink(new QuestionLink("VIDEO", "https://youtu.be/tqQ5fTamIN4?si=ofLt8Zt1ZvhikZ6w"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_queue_using_linkedlist.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/implement-queue-using-linked-list/"));
        
        
        topic_9_1.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_queue_using_linkedlist);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_balanced_paranthesis = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_balanced_paranthesis", "Balanced Paranthesis", "EASY");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_balanced_paranthesis.setSolveLink("https://leetcode.com/problems/valid-parentheses/");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_balanced_paranthesis.setEditorialLink("https://takeuforward.org/plus/dsa/problems/balanced-paranthesis?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_balanced_paranthesis.addLink(new QuestionLink("VIDEO", "https://youtu.be/xwjS0iZhw4I?si=UoyKpFn4Q3nf5h2R"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_balanced_paranthesis.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/check-for-balanced-parentheses/"));
        
        
        topic_9_1.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_balanced_paranthesis);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_min_stack = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_min_stack", "Implement Min Stack", "HARD");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_min_stack.setSolveLink("https://leetcode.com/problems/min-stack/");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_min_stack.setEditorialLink("https://takeuforward.org/plus/dsa/problems/implement-min-stack?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_min_stack.addLink(new QuestionLink("VIDEO", "https://youtu.be/NdDIaH91P0g?si=4_Jbsq5trFvfSdUY"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_min_stack.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/implement-min-stack-o2n-and-on-space-complexity/"));
        
        
        topic_9_1.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_learning_implement_min_stack);
        
        
        section_9.addTopic(topic_9_1);
        
        // Topic: Prefix, Infix, PostFix Conversion Problems
        Topic topic_9_2 = new Topic("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems", "Prefix, Infix, PostFix Conversion Problems");
        
        
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_infix_to_postfix_conversion = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_infix_to_postfix_conversion", "Infix to Postfix Conversion", "MEDIUM");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_infix_to_postfix_conversion.setSolveLink("https://takeuforward.org/plus/dsa/problems/infix-to-postfix-conversion");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_infix_to_postfix_conversion.setEditorialLink("");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_infix_to_postfix_conversion.addLink(new QuestionLink("VIDEO", "https://youtu.be/4pIc9UBHJtk?si=ryeVvQWpCgwbTQrh"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_infix_to_postfix_conversion.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/infix-to-postfix/"));
        
        
        topic_9_2.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_infix_to_postfix_conversion);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_prefix_to_infix_conversion = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_prefix_to_infix_conversion", "Prefix to Infix Conversion", "MEDIUM");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_prefix_to_infix_conversion.setSolveLink("https://takeuforward.org/plus/dsa/problems/prefix-to-infix-conversion");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_prefix_to_infix_conversion.setEditorialLink("");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_prefix_to_infix_conversion.addLink(new QuestionLink("VIDEO", "https://youtu.be/4pIc9UBHJtk?si=ryeVvQWpCgwbTQrh"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_prefix_to_infix_conversion.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/prefix-to-infix-conversion"));
        
        
        topic_9_2.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_prefix_to_infix_conversion);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_prefix_to_postfix_conversion = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_prefix_to_postfix_conversion", "Prefix to Postfix Conversion", "MEDIUM");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_prefix_to_postfix_conversion.setSolveLink("https://takeuforward.org/plus/dsa/problems/prefix-to-postfix-conversion");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_prefix_to_postfix_conversion.setEditorialLink("");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_prefix_to_postfix_conversion.addLink(new QuestionLink("VIDEO", "https://youtu.be/4pIc9UBHJtk?si=0pWtyDC1GhbiYP3P"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_prefix_to_postfix_conversion.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/prefix-to-postfix-conversion"));
        
        
        topic_9_2.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_prefix_to_postfix_conversion);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_postfix_to_prefix_conversion = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_postfix_to_prefix_conversion", "Postfix to Prefix Conversion", "MEDIUM");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_postfix_to_prefix_conversion.setSolveLink("https://takeuforward.org/plus/dsa/problems/postfix-to-prefix-conversion");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_postfix_to_prefix_conversion.setEditorialLink("");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_postfix_to_prefix_conversion.addLink(new QuestionLink("VIDEO", "https://youtu.be/4pIc9UBHJtk?si=0pWtyDC1GhbiYP3P"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_postfix_to_prefix_conversion.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/postfix-to-prefix-conversion"));
        
        
        topic_9_2.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_postfix_to_prefix_conversion);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_postfix_to_infix_conversion = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_postfix_to_infix_conversion", "Postfix to Infix Conversion", "EASY");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_postfix_to_infix_conversion.setSolveLink("https://takeuforward.org/plus/dsa/problems/postfix-to-infix-conversion");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_postfix_to_infix_conversion.setEditorialLink("");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_postfix_to_infix_conversion.addLink(new QuestionLink("VIDEO", "https://youtu.be/4pIc9UBHJtk?si=0pWtyDC1GhbiYP3P"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_postfix_to_infix_conversion.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/postfix-to-infix"));
        
        
        topic_9_2.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_postfix_to_infix_conversion);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_infix_to_prefix_conversion = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_infix_to_prefix_conversion", "Infix to Prefix Conversion", "MEDIUM");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_infix_to_prefix_conversion.setSolveLink("https://takeuforward.org/plus/dsa/problems/infix-to-prefix-conversion");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_infix_to_prefix_conversion.setEditorialLink("");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_infix_to_prefix_conversion.addLink(new QuestionLink("VIDEO", "https://youtu.be/4pIc9UBHJtk?si=0pWtyDC1GhbiYP3P"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_infix_to_prefix_conversion.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/infix-to-prefix/"));
        
        
        topic_9_2.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_prefix_infix_postfix_conversion_problems_infix_to_prefix_conversion);
        
        
        section_9.addTopic(topic_9_2);
        
        // Topic: Monotonic Stack/Queue Problems [VVV. Imp]
        Topic topic_9_3 = new Topic("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp", "Monotonic Stack/Queue Problems [VVV. Imp]");
        
        
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_next_greater_element = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_next_greater_element", "Next Greater Element", "MEDIUM");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_next_greater_element.setSolveLink("https://leetcode.com/problems/next-greater-element-i/");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_next_greater_element.setEditorialLink("https://takeuforward.org/plus/dsa/problems/next-greater-element?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_next_greater_element.addLink(new QuestionLink("VIDEO", "https://youtu.be/e7XQLtOQM3I?si=QdcHpTtx6gAHsext"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_next_greater_element.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/next-greater-element-using-stack/"));
        
        
        topic_9_3.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_next_greater_element);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_next_greater_element_2 = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_next_greater_element_2", "Next Greater Element - 2", "MEDIUM");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_next_greater_element_2.setSolveLink("https://leetcode.com/problems/next-greater-element-ii/");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_next_greater_element_2.setEditorialLink("https://takeuforward.org/plus/dsa/problems/next-greater-element---2?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_next_greater_element_2.addLink(new QuestionLink("VIDEO", "https://youtu.be/7PrncD7v9YQ?si=UkBc7eVy9HGlBpeW"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_next_greater_element_2.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/next-greater-element-2"));
        
        
        topic_9_3.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_next_greater_element_2);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_next_smaller_element = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_next_smaller_element", "Next Smaller Element", "MEDIUM");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_next_smaller_element.setSolveLink("https://takeuforward.org/plus/dsa/problems/next-smaller-element");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_next_smaller_element.setEditorialLink("");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_next_smaller_element.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/next-smaller-element"));
        
        
        topic_9_3.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_next_smaller_element);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_number_of_greater_elements_to_the_right = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_number_of_greater_elements_to_the_right", "Number of Greater Elements to the Right", "EASY");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_number_of_greater_elements_to_the_right.setSolveLink("https://takeuforward.org/plus/dsa/problems/number-of-greater-elements-to-the-right");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_number_of_greater_elements_to_the_right.setEditorialLink("");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_number_of_greater_elements_to_the_right.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/number-of-nges-to-the-right"));
        
        
        topic_9_3.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_number_of_greater_elements_to_the_right);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_trapping_rainwater = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_trapping_rainwater", "Trapping Rainwater", "HARD");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_trapping_rainwater.setSolveLink("https://leetcode.com/problems/trapping-rain-water/");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_trapping_rainwater.setEditorialLink("https://takeuforward.org/plus/dsa/problems/trapping-rainwater?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_trapping_rainwater.addLink(new QuestionLink("VIDEO", "https://youtu.be/1_5VuquLbXg?si=NFG6df318_6OtGvg"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_trapping_rainwater.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/trapping-rainwater/"));
        
        
        topic_9_3.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_trapping_rainwater);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_sum_of_subarray_minimums = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_sum_of_subarray_minimums", "Sum of Subarray Minimums", "MEDIUM");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_sum_of_subarray_minimums.setSolveLink("https://leetcode.com/problems/sum-of-subarray-minimums/");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_sum_of_subarray_minimums.setEditorialLink("https://takeuforward.org/plus/dsa/problems/sum-of-subarray-minimums?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_sum_of_subarray_minimums.addLink(new QuestionLink("VIDEO", "https://youtu.be/v0e8p9JCgRc?si=XAU7ekECgS5nboRw"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_sum_of_subarray_minimums.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/sum-of-subarray-minimums"));
        
        
        topic_9_3.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_sum_of_subarray_minimums);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_asteroid_collision = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_asteroid_collision", "Asteroid Collision", "MEDIUM");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_asteroid_collision.setSolveLink("https://leetcode.com/problems/asteroid-collision/");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_asteroid_collision.setEditorialLink("https://takeuforward.org/plus/dsa/problems/asteroid-collision?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_asteroid_collision.addLink(new QuestionLink("VIDEO", "https://youtu.be/_eYGqw_VDR4?si=YyxibcHq800RqgIQ"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_asteroid_collision.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/asteroid-collision"));
        
        
        topic_9_3.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_asteroid_collision);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_sum_of_subarray_ranges = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_sum_of_subarray_ranges", "Sum of Subarray Ranges", "MEDIUM");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_sum_of_subarray_ranges.setSolveLink("https://leetcode.com/problems/sum-of-subarray-ranges/");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_sum_of_subarray_ranges.setEditorialLink("https://takeuforward.org/plus/dsa/problems/sum-of-subarray-ranges?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_sum_of_subarray_ranges.addLink(new QuestionLink("VIDEO", "https://youtu.be/gIrMptNPf5M?si=Q_GHuBvzZVs27X_U"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_sum_of_subarray_ranges.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/sum-of-subarray-ranges"));
        
        
        topic_9_3.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_sum_of_subarray_ranges);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_remove_k_digits = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_remove_k_digits", "Remove K Digits", "MEDIUM");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_remove_k_digits.setSolveLink("https://leetcode.com/problems/remove-k-digits/");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_remove_k_digits.setEditorialLink("https://takeuforward.org/plus/dsa/problems/remove-k-digits?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_remove_k_digits.addLink(new QuestionLink("VIDEO", "https://youtu.be/jmbuRzYPGrg?si=WN387gwQ7aXWkUao"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_remove_k_digits.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/remove-k-digits"));
        
        
        topic_9_3.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_remove_k_digits);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_largest_rectangle_in_a_histogram = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_largest_rectangle_in_a_histogram", "Largest rectangle in a histogram", "HARD");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_largest_rectangle_in_a_histogram.setSolveLink("https://leetcode.com/problems/largest-rectangle-in-histogram/");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_largest_rectangle_in_a_histogram.setEditorialLink("https://takeuforward.org/plus/dsa/problems/largest-rectangle-in-a-histogram?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_largest_rectangle_in_a_histogram.addLink(new QuestionLink("VIDEO", "https://youtu.be/Bzat9vgD0fs?si=DiBlLejXcr6EJoyB"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_largest_rectangle_in_a_histogram.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/area-of-largest-rectangle-in-histogram/"));
        
        
        topic_9_3.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_largest_rectangle_in_a_histogram);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_maximum_rectangles = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_maximum_rectangles", "Maximum Rectangles", "HARD");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_maximum_rectangles.setSolveLink("https://leetcode.com/problems/maximal-rectangle/");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_maximum_rectangles.setEditorialLink("https://takeuforward.org/plus/dsa/problems/maximum-rectangles?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_maximum_rectangles.addLink(new QuestionLink("VIDEO", "https://youtu.be/tOylVCugy9k"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_maximum_rectangles.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/maximum-rectangle-area-with-all-1s-dp-on-rectangles-dp-55/"));
        
        
        topic_9_3.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_monotonic_stackqueue_problems_vvv_imp_maximum_rectangles);
        
        
        section_9.addTopic(topic_9_3);
        
        // Topic: Implementation Problems
        Topic topic_9_4 = new Topic("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems", "Implementation Problems");
        
        
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_sliding_window_maximum = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_sliding_window_maximum", "Sliding Window Maximum", "HARD");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_sliding_window_maximum.setSolveLink("https://leetcode.com/problems/sliding-window-maximum/");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_sliding_window_maximum.setEditorialLink("https://takeuforward.org/plus/dsa/problems/sliding-window-maximum?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_sliding_window_maximum.addLink(new QuestionLink("VIDEO", "https://youtu.be/NwBvene4Imo?si=eU1PY-bcQfk5wdog"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_sliding_window_maximum.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/sliding-window-maximum/"));
        
        
        topic_9_4.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_sliding_window_maximum);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_stock_span_problem = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_stock_span_problem", "Stock span problem", "HARD");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_stock_span_problem.setSolveLink("https://leetcode.com/problems/online-stock-span/");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_stock_span_problem.setEditorialLink("https://takeuforward.org/plus/dsa/problems/stock-span-problem?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_stock_span_problem.addLink(new QuestionLink("VIDEO", "https://youtu.be/eay-zoSRkVc?si=deNNe5i38BOAntha"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_stock_span_problem.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/stock-span-problem"));
        
        
        topic_9_4.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_stock_span_problem);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_celebrity_problem = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_celebrity_problem", "Celebrity Problem", "HARD");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_celebrity_problem.setSolveLink("https://leetcode.com/accounts/login/?next=/problems/find-the-celebrity/");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_celebrity_problem.setEditorialLink("https://takeuforward.org/plus/dsa/problems/celebrity-problem?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_celebrity_problem.addLink(new QuestionLink("VIDEO", "https://youtu.be/cEadsbTeze4?si=olXYfOs7l-SEn2zl"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_celebrity_problem.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/celebrity-problem"));
        
        
        topic_9_4.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_celebrity_problem);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_lru_cache = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_lru_cache", "LRU Cache", "MEDIUM");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_lru_cache.setSolveLink("https://takeuforward.org/plus/dsa/problems/lru-cache");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_lru_cache.setEditorialLink("https://takeuforward.org/plus/dsa/problems/lru-cache?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_lru_cache.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/program-for-least-recently-used-lru-page-replacement-algorithm"));
        
        
        topic_9_4.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_lru_cache);
        
        Question q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_lfu_cache = new Question("stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_lfu_cache", "LFU Cache", "HARD");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_lfu_cache.setSolveLink("https://leetcode.com/problems/lfu-cache/");
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_lfu_cache.setEditorialLink("https://takeuforward.org/plus/dsa/problems/lfu-cache?tab=editorial");
        
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_lfu_cache.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=0PSB9y8ehbk&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=79"));
        
        q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_lfu_cache.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/lfu-cache"));
        
        
        topic_9_4.addQuestion(q_stack_and_queues_learning_pre_in_post_fix_monotonic_stack_implementation_implementation_problems_lfu_cache);
        
        
        section_9.addTopic(topic_9_4);
        
        
        Roadmap.addSection(section_9);
        
        // ==========================================
        // Section: Sliding Window & Two Pointer Combined Problems
        // ==========================================
        RoadmapSection section_10 = new RoadmapSection("sliding_window_two_pointer_combined_problems", "Sliding Window & Two Pointer Combined Problems");
        
        
        
        // Topic: Medium Problems
        Topic topic_10_1 = new Topic("sliding_window_two_pointer_combined_problems_medium_problems", "Medium Problems");
        
        
        
        Question q_sliding_window_two_pointer_combined_problems_medium_problems_longest_substring_without_repeating_characters = new Question("sliding_window_two_pointer_combined_problems_medium_problems_longest_substring_without_repeating_characters", "Longest Substring Without Repeating Characters", "MEDIUM");
        q_sliding_window_two_pointer_combined_problems_medium_problems_longest_substring_without_repeating_characters.setSolveLink("https://leetcode.com/problems/longest-substring-without-repeating-characters/");
        q_sliding_window_two_pointer_combined_problems_medium_problems_longest_substring_without_repeating_characters.setEditorialLink("https://takeuforward.org/plus/dsa/problems/longest-substring-without-repeating-characters?tab=editorial");
        
        
        q_sliding_window_two_pointer_combined_problems_medium_problems_longest_substring_without_repeating_characters.addLink(new QuestionLink("VIDEO", "https://youtu.be/-zSxTJkcdAo?si=I2zfR-vlDMg0zU9z"));
        
        q_sliding_window_two_pointer_combined_problems_medium_problems_longest_substring_without_repeating_characters.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/length-of-longest-substring-without-any-repeating-character/"));
        
        
        topic_10_1.addQuestion(q_sliding_window_two_pointer_combined_problems_medium_problems_longest_substring_without_repeating_characters);
        
        Question q_sliding_window_two_pointer_combined_problems_medium_problems_max_consecutive_ones_iii = new Question("sliding_window_two_pointer_combined_problems_medium_problems_max_consecutive_ones_iii", " Max Consecutive Ones III", "MEDIUM");
        q_sliding_window_two_pointer_combined_problems_medium_problems_max_consecutive_ones_iii.setSolveLink("https://leetcode.com/problems/max-consecutive-ones-iii/");
        q_sliding_window_two_pointer_combined_problems_medium_problems_max_consecutive_ones_iii.setEditorialLink("https://takeuforward.org/plus/dsa/problems/max-consecutive-ones-iii?tab=editorial");
        
        
        q_sliding_window_two_pointer_combined_problems_medium_problems_max_consecutive_ones_iii.addLink(new QuestionLink("VIDEO", "https://youtu.be/3E4JBHSLpYk?si=SoOW64pP6otEKxBw"));
        
        q_sliding_window_two_pointer_combined_problems_medium_problems_max_consecutive_ones_iii.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/max-consecutive-ones-iii"));
        
        
        topic_10_1.addQuestion(q_sliding_window_two_pointer_combined_problems_medium_problems_max_consecutive_ones_iii);
        
        Question q_sliding_window_two_pointer_combined_problems_medium_problems_fruit_into_baskets = new Question("sliding_window_two_pointer_combined_problems_medium_problems_fruit_into_baskets", " Fruit Into Baskets", "MEDIUM");
        q_sliding_window_two_pointer_combined_problems_medium_problems_fruit_into_baskets.setSolveLink("https://takeuforward.org/plus/dsa/problems/fruit-into-baskets");
        q_sliding_window_two_pointer_combined_problems_medium_problems_fruit_into_baskets.setEditorialLink("https://takeuforward.org/plus/dsa/problems/fruit-into-baskets?tab=editorial");
        
        
        q_sliding_window_two_pointer_combined_problems_medium_problems_fruit_into_baskets.addLink(new QuestionLink("VIDEO", "https://youtu.be/e3bs0uA1NhQ?si=gR8pO62u-nJeFAXk"));
        
        q_sliding_window_two_pointer_combined_problems_medium_problems_fruit_into_baskets.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/fruit-into-baskets"));
        
        
        topic_10_1.addQuestion(q_sliding_window_two_pointer_combined_problems_medium_problems_fruit_into_baskets);
        
        Question q_sliding_window_two_pointer_combined_problems_medium_problems_longest_repeating_character_replacement = new Question("sliding_window_two_pointer_combined_problems_medium_problems_longest_repeating_character_replacement", "Longest Repeating Character Replacement", "HARD");
        q_sliding_window_two_pointer_combined_problems_medium_problems_longest_repeating_character_replacement.setSolveLink("https://leetcode.com/problems/longest-repeating-character-replacement/");
        q_sliding_window_two_pointer_combined_problems_medium_problems_longest_repeating_character_replacement.setEditorialLink("https://takeuforward.org/plus/dsa/problems/longest-repeating-character-replacement?tab=editorial");
        
        
        q_sliding_window_two_pointer_combined_problems_medium_problems_longest_repeating_character_replacement.addLink(new QuestionLink("VIDEO", "https://youtu.be/_eNhaDCr6P0?si=pBWcEjozF5poom0p"));
        
        q_sliding_window_two_pointer_combined_problems_medium_problems_longest_repeating_character_replacement.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/longest-repeating-character-replacement"));
        
        
        topic_10_1.addQuestion(q_sliding_window_two_pointer_combined_problems_medium_problems_longest_repeating_character_replacement);
        
        Question q_sliding_window_two_pointer_combined_problems_medium_problems_binary_subarrays_with_sum = new Question("sliding_window_two_pointer_combined_problems_medium_problems_binary_subarrays_with_sum", "Binary Subarrays With Sum", "HARD");
        q_sliding_window_two_pointer_combined_problems_medium_problems_binary_subarrays_with_sum.setSolveLink("https://leetcode.com/problems/binary-subarrays-with-sum/");
        q_sliding_window_two_pointer_combined_problems_medium_problems_binary_subarrays_with_sum.setEditorialLink("https://takeuforward.org/plus/dsa/problems/binary-subarrays-with-sum?tab=editorial");
        
        
        q_sliding_window_two_pointer_combined_problems_medium_problems_binary_subarrays_with_sum.addLink(new QuestionLink("VIDEO", "https://youtu.be/XnMdNUkX6VM?si=Nyt8EveeLUg8lmty"));
        
        q_sliding_window_two_pointer_combined_problems_medium_problems_binary_subarrays_with_sum.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/binary-subarray-with-sum"));
        
        
        topic_10_1.addQuestion(q_sliding_window_two_pointer_combined_problems_medium_problems_binary_subarrays_with_sum);
        
        Question q_sliding_window_two_pointer_combined_problems_medium_problems_count_number_of_nice_subarrays = new Question("sliding_window_two_pointer_combined_problems_medium_problems_count_number_of_nice_subarrays", "Count number of Nice subarrays", "HARD");
        q_sliding_window_two_pointer_combined_problems_medium_problems_count_number_of_nice_subarrays.setSolveLink("https://leetcode.com/problems/count-number-of-nice-subarrays/");
        q_sliding_window_two_pointer_combined_problems_medium_problems_count_number_of_nice_subarrays.setEditorialLink("https://takeuforward.org/plus/dsa/problems/count-number-of-nice-subarrays?tab=editorial");
        
        
        q_sliding_window_two_pointer_combined_problems_medium_problems_count_number_of_nice_subarrays.addLink(new QuestionLink("VIDEO", "https://youtu.be/j_QOv9OT9Og?si=Oq5-5hyFkzVSOZpP"));
        
        q_sliding_window_two_pointer_combined_problems_medium_problems_count_number_of_nice_subarrays.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/count-number-of-nice-subarrays"));
        
        
        topic_10_1.addQuestion(q_sliding_window_two_pointer_combined_problems_medium_problems_count_number_of_nice_subarrays);
        
        Question q_sliding_window_two_pointer_combined_problems_medium_problems_number_of_substrings_containing_all_three_characters = new Question("sliding_window_two_pointer_combined_problems_medium_problems_number_of_substrings_containing_all_three_characters", "Number of Substrings Containing All Three Characters", "HARD");
        q_sliding_window_two_pointer_combined_problems_medium_problems_number_of_substrings_containing_all_three_characters.setSolveLink("https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/");
        q_sliding_window_two_pointer_combined_problems_medium_problems_number_of_substrings_containing_all_three_characters.setEditorialLink("https://takeuforward.org/plus/dsa/problems/number-of-substrings-containing-all-three-characters?tab=editorial");
        
        
        q_sliding_window_two_pointer_combined_problems_medium_problems_number_of_substrings_containing_all_three_characters.addLink(new QuestionLink("VIDEO", "https://youtu.be/xtqN4qlgr8s?si=kuaLHVOLXhh5Z2tW"));
        
        q_sliding_window_two_pointer_combined_problems_medium_problems_number_of_substrings_containing_all_three_characters.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/number-of-substring-containing-all-three-characters"));
        
        
        topic_10_1.addQuestion(q_sliding_window_two_pointer_combined_problems_medium_problems_number_of_substrings_containing_all_three_characters);
        
        Question q_sliding_window_two_pointer_combined_problems_medium_problems_maximum_points_you_can_obtain_from_cards = new Question("sliding_window_two_pointer_combined_problems_medium_problems_maximum_points_you_can_obtain_from_cards", "Maximum Points You Can Obtain from Cards ", "MEDIUM");
        q_sliding_window_two_pointer_combined_problems_medium_problems_maximum_points_you_can_obtain_from_cards.setSolveLink("https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/");
        q_sliding_window_two_pointer_combined_problems_medium_problems_maximum_points_you_can_obtain_from_cards.setEditorialLink("https://takeuforward.org/plus/dsa/problems/maximum-points-you-can-obtain-from-cards-?tab=editorial");
        
        
        q_sliding_window_two_pointer_combined_problems_medium_problems_maximum_points_you_can_obtain_from_cards.addLink(new QuestionLink("VIDEO", "https://youtu.be/pBWCOCS636U?si=-X64rY67noxvOwrG"));
        
        q_sliding_window_two_pointer_combined_problems_medium_problems_maximum_points_you_can_obtain_from_cards.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/maximum-point-you-can-obtain-from-cards"));
        
        
        topic_10_1.addQuestion(q_sliding_window_two_pointer_combined_problems_medium_problems_maximum_points_you_can_obtain_from_cards);
        
        
        section_10.addTopic(topic_10_1);
        
        // Topic: Hard Problems
        Topic topic_10_2 = new Topic("sliding_window_two_pointer_combined_problems_hard_problems", "Hard Problems");
        
        
        
        Question q_sliding_window_two_pointer_combined_problems_hard_problems_longest_substring_with_at_most_k_distinct_characters = new Question("sliding_window_two_pointer_combined_problems_hard_problems_longest_substring_with_at_most_k_distinct_characters", "Longest Substring With At Most K Distinct Characters", "HARD");
        q_sliding_window_two_pointer_combined_problems_hard_problems_longest_substring_with_at_most_k_distinct_characters.setSolveLink("https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/");
        q_sliding_window_two_pointer_combined_problems_hard_problems_longest_substring_with_at_most_k_distinct_characters.setEditorialLink("https://takeuforward.org/plus/dsa/problems/longest-substring-with-at-most-k-distinct-characters?tab=editorial");
        
        
        q_sliding_window_two_pointer_combined_problems_hard_problems_longest_substring_with_at_most_k_distinct_characters.addLink(new QuestionLink("VIDEO", "https://youtu.be/teM9ZsVRQyc?si=Kh0_u6aCkkBU3Q33"));
        
        q_sliding_window_two_pointer_combined_problems_hard_problems_longest_substring_with_at_most_k_distinct_characters.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/longest-substring-with-at-most-k-distinct-characters"));
        
        
        topic_10_2.addQuestion(q_sliding_window_two_pointer_combined_problems_hard_problems_longest_substring_with_at_most_k_distinct_characters);
        
        Question q_sliding_window_two_pointer_combined_problems_hard_problems_subarrays_with_k_different_integers = new Question("sliding_window_two_pointer_combined_problems_hard_problems_subarrays_with_k_different_integers", "Subarrays with K Different Integers", "MEDIUM");
        q_sliding_window_two_pointer_combined_problems_hard_problems_subarrays_with_k_different_integers.setSolveLink("https://leetcode.com/problems/subarrays-with-k-different-integers/");
        q_sliding_window_two_pointer_combined_problems_hard_problems_subarrays_with_k_different_integers.setEditorialLink("");
        
        
        q_sliding_window_two_pointer_combined_problems_hard_problems_subarrays_with_k_different_integers.addLink(new QuestionLink("VIDEO", "https://youtu.be/7wYGbV_LsX4?si=KWa48RgLDCvdNqRb"));
        
        q_sliding_window_two_pointer_combined_problems_hard_problems_subarrays_with_k_different_integers.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/subarray-with-k-different-integers"));
        
        
        topic_10_2.addQuestion(q_sliding_window_two_pointer_combined_problems_hard_problems_subarrays_with_k_different_integers);
        
        Question q_sliding_window_two_pointer_combined_problems_hard_problems_minimum_window_substring = new Question("sliding_window_two_pointer_combined_problems_hard_problems_minimum_window_substring", "Minimum Window Substring ", "HARD");
        q_sliding_window_two_pointer_combined_problems_hard_problems_minimum_window_substring.setSolveLink("https://leetcode.com/problems/minimum-window-substring/");
        q_sliding_window_two_pointer_combined_problems_hard_problems_minimum_window_substring.setEditorialLink("https://takeuforward.org/plus/dsa/problems/minimum-window-substring-?tab=editorial");
        
        
        q_sliding_window_two_pointer_combined_problems_hard_problems_minimum_window_substring.addLink(new QuestionLink("VIDEO", "https://youtu.be/WJaij9ffOIY?si=-xnsWIH84zWU0ICd"));
        
        
        topic_10_2.addQuestion(q_sliding_window_two_pointer_combined_problems_hard_problems_minimum_window_substring);
        
        Question q_sliding_window_two_pointer_combined_problems_hard_problems_minimum_window_subsequence = new Question("sliding_window_two_pointer_combined_problems_hard_problems_minimum_window_subsequence", "Minimum Window Subsequence", "HARD");
        q_sliding_window_two_pointer_combined_problems_hard_problems_minimum_window_subsequence.setSolveLink("https://leetcode.com/problems/minimum-window-subsequence/");
        q_sliding_window_two_pointer_combined_problems_hard_problems_minimum_window_subsequence.setEditorialLink("https://takeuforward.org/plus/dsa/problems/minimum-window-subsequence?tab=editorial");
        
        
        
        topic_10_2.addQuestion(q_sliding_window_two_pointer_combined_problems_hard_problems_minimum_window_subsequence);
        
        
        section_10.addTopic(topic_10_2);
        
        
        Roadmap.addSection(section_10);
        
        // ==========================================
        // Section: Heaps [Learning, Medium, Hard Problems]
        // ==========================================
        RoadmapSection section_11 = new RoadmapSection("heaps_learning_medium_hard_problems", "Heaps [Learning, Medium, Hard Problems]");
        
        
        
        // Topic: Learning
        Topic topic_11_1 = new Topic("heaps_learning_medium_hard_problems_learning", "Learning");
        
        
        
        Question q_heaps_learning_medium_hard_problems_learning_heaps_theory_video = new Question("heaps_learning_medium_hard_problems_learning_heaps_theory_video", "Heaps (Theory Video)", "EASY");
        q_heaps_learning_medium_hard_problems_learning_heaps_theory_video.setSolveLink("https://takeuforward.org/plus/dsa/problems/heaps-theory");
        q_heaps_learning_medium_hard_problems_learning_heaps_theory_video.setEditorialLink("https://takeuforward.org/plus/dsa/problems/heaps-theory");
        
        
        q_heaps_learning_medium_hard_problems_learning_heaps_theory_video.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/introduction-to-priority-queues-using-binary-heaps"));
        
        
        topic_11_1.addQuestion(q_heaps_learning_medium_hard_problems_learning_heaps_theory_video);
        
        Question q_heaps_learning_medium_hard_problems_learning_implement_min_heap = new Question("heaps_learning_medium_hard_problems_learning_implement_min_heap", "Implement Min Heap", "MEDIUM");
        q_heaps_learning_medium_hard_problems_learning_implement_min_heap.setSolveLink("https://takeuforward.org/plus/dsa/problems/implement-min-heap");
        q_heaps_learning_medium_hard_problems_learning_implement_min_heap.setEditorialLink("https://takeuforward.org/plus/dsa/problems/implement-min-heap?tab=editorial");
        
        
        
        topic_11_1.addQuestion(q_heaps_learning_medium_hard_problems_learning_implement_min_heap);
        
        Question q_heaps_learning_medium_hard_problems_learning_check_if_an_array_represents_a_min_heap = new Question("heaps_learning_medium_hard_problems_learning_check_if_an_array_represents_a_min_heap", "Check if an array represents a min heap ", "MEDIUM");
        q_heaps_learning_medium_hard_problems_learning_check_if_an_array_represents_a_min_heap.setSolveLink("https://takeuforward.org/plus/dsa/problems/check-if-an-array-represents-a-min-heap-");
        q_heaps_learning_medium_hard_problems_learning_check_if_an_array_represents_a_min_heap.setEditorialLink("https://takeuforward.org/plus/dsa/problems/check-if-an-array-represents-a-min-heap-?tab=editorial");
        
        
        q_heaps_learning_medium_hard_problems_learning_check_if_an_array_represents_a_min_heap.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/check-if-an-array-represents-a-min-heap"));
        
        
        topic_11_1.addQuestion(q_heaps_learning_medium_hard_problems_learning_check_if_an_array_represents_a_min_heap);
        
        Question q_heaps_learning_medium_hard_problems_learning_convert_min_heap_to_max_heap = new Question("heaps_learning_medium_hard_problems_learning_convert_min_heap_to_max_heap", "Convert Min Heap to Max Heap", "MEDIUM");
        q_heaps_learning_medium_hard_problems_learning_convert_min_heap_to_max_heap.setSolveLink("https://takeuforward.org/plus/dsa/problems/convert-min-heap-to-max-heap");
        q_heaps_learning_medium_hard_problems_learning_convert_min_heap_to_max_heap.setEditorialLink("https://takeuforward.org/plus/dsa/problems/convert-min-heap-to-max-heap?tab=editorial");
        
        
        
        topic_11_1.addQuestion(q_heaps_learning_medium_hard_problems_learning_convert_min_heap_to_max_heap);
        
        
        section_11.addTopic(topic_11_1);
        
        // Topic: Medium Problems
        Topic topic_11_2 = new Topic("heaps_learning_medium_hard_problems_medium_problems", "Medium Problems");
        
        
        
        Question q_heaps_learning_medium_hard_problems_medium_problems_k_th_largest_element_in_an_array = new Question("heaps_learning_medium_hard_problems_medium_problems_k_th_largest_element_in_an_array", "K-th Largest element in an array", "MEDIUM");
        q_heaps_learning_medium_hard_problems_medium_problems_k_th_largest_element_in_an_array.setSolveLink("https://takeuforward.org/plus/dsa/problems/k-th-largest-element-in-an-array");
        q_heaps_learning_medium_hard_problems_medium_problems_k_th_largest_element_in_an_array.setEditorialLink("");
        
        
        q_heaps_learning_medium_hard_problems_medium_problems_k_th_largest_element_in_an_array.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/kth-largest-smallest-element-in-an-array/"));
        
        
        topic_11_2.addQuestion(q_heaps_learning_medium_hard_problems_medium_problems_k_th_largest_element_in_an_array);
        
        Question q_heaps_learning_medium_hard_problems_medium_problems_kth_smallest_element_in_an_array_use_priority_queue = new Question("heaps_learning_medium_hard_problems_medium_problems_kth_smallest_element_in_an_array_use_priority_queue", "Kth smallest element in an array [use priority queue]", "MEDIUM");
        q_heaps_learning_medium_hard_problems_medium_problems_kth_smallest_element_in_an_array_use_priority_queue.setSolveLink("https://takeuforward.org/plus/dsa/problems/kth-smallest-element-in-an-array");
        q_heaps_learning_medium_hard_problems_medium_problems_kth_smallest_element_in_an_array_use_priority_queue.setEditorialLink("https://takeuforward.org/plus/dsa/problems/kth-smallest-element-in-an-array?tab=editorial");
        
        
        q_heaps_learning_medium_hard_problems_medium_problems_kth_smallest_element_in_an_array_use_priority_queue.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/kth-largest-smallest-element-in-an-array/"));
        
        
        topic_11_2.addQuestion(q_heaps_learning_medium_hard_problems_medium_problems_kth_smallest_element_in_an_array_use_priority_queue);
        
        Question q_heaps_learning_medium_hard_problems_medium_problems_sort_k_sorted_array = new Question("heaps_learning_medium_hard_problems_medium_problems_sort_k_sorted_array", "Sort K sorted array", "EASY");
        q_heaps_learning_medium_hard_problems_medium_problems_sort_k_sorted_array.setSolveLink("https://takeuforward.org/data-structure/sort-k-sorted-array");
        q_heaps_learning_medium_hard_problems_medium_problems_sort_k_sorted_array.setEditorialLink("");
        
        
        q_heaps_learning_medium_hard_problems_medium_problems_sort_k_sorted_array.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/sort-k-sorted-array"));
        
        
        topic_11_2.addQuestion(q_heaps_learning_medium_hard_problems_medium_problems_sort_k_sorted_array);
        
        Question q_heaps_learning_medium_hard_problems_medium_problems_merge_k_sorted_lists = new Question("heaps_learning_medium_hard_problems_medium_problems_merge_k_sorted_lists", "Merge K sorted Lists", "HARD");
        q_heaps_learning_medium_hard_problems_medium_problems_merge_k_sorted_lists.setSolveLink("https://leetcode.com/problems/merge-k-sorted-lists/");
        q_heaps_learning_medium_hard_problems_medium_problems_merge_k_sorted_lists.setEditorialLink("");
        
        
        q_heaps_learning_medium_hard_problems_medium_problems_merge_k_sorted_lists.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/merge-m-sorted-lists"));
        
        
        topic_11_2.addQuestion(q_heaps_learning_medium_hard_problems_medium_problems_merge_k_sorted_lists);
        
        Question q_heaps_learning_medium_hard_problems_medium_problems_replace_elements_by_their_rank = new Question("heaps_learning_medium_hard_problems_medium_problems_replace_elements_by_their_rank", "Replace Elements by Their Rank", "EASY");
        q_heaps_learning_medium_hard_problems_medium_problems_replace_elements_by_their_rank.setSolveLink("https://takeuforward.org/plus/dsa/problems/replace-elements-by-their-rank");
        q_heaps_learning_medium_hard_problems_medium_problems_replace_elements_by_their_rank.setEditorialLink("");
        
        
        q_heaps_learning_medium_hard_problems_medium_problems_replace_elements_by_their_rank.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/replace-elements-by-its-rank-in-the-array/"));
        
        
        topic_11_2.addQuestion(q_heaps_learning_medium_hard_problems_medium_problems_replace_elements_by_their_rank);
        
        Question q_heaps_learning_medium_hard_problems_medium_problems_task_scheduler = new Question("heaps_learning_medium_hard_problems_medium_problems_task_scheduler", "Task Scheduler", "MEDIUM");
        q_heaps_learning_medium_hard_problems_medium_problems_task_scheduler.setSolveLink("https://leetcode.com/problems/task-scheduler/");
        q_heaps_learning_medium_hard_problems_medium_problems_task_scheduler.setEditorialLink("");
        
        
        q_heaps_learning_medium_hard_problems_medium_problems_task_scheduler.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/task-scheduler"));
        
        
        topic_11_2.addQuestion(q_heaps_learning_medium_hard_problems_medium_problems_task_scheduler);
        
        Question q_heaps_learning_medium_hard_problems_medium_problems_hand_of_straights = new Question("heaps_learning_medium_hard_problems_medium_problems_hand_of_straights", "Hand of Straights", "MEDIUM");
        q_heaps_learning_medium_hard_problems_medium_problems_hand_of_straights.setSolveLink("https://leetcode.com/problems/hand-of-straights/");
        q_heaps_learning_medium_hard_problems_medium_problems_hand_of_straights.setEditorialLink("");
        
        
        q_heaps_learning_medium_hard_problems_medium_problems_hand_of_straights.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/hands-of-straights"));
        
        
        topic_11_2.addQuestion(q_heaps_learning_medium_hard_problems_medium_problems_hand_of_straights);
        
        
        section_11.addTopic(topic_11_2);
        
        // Topic: Hard Problems
        Topic topic_11_3 = new Topic("heaps_learning_medium_hard_problems_hard_problems", "Hard Problems");
        
        
        
        Question q_heaps_learning_medium_hard_problems_hard_problems_design_twitter = new Question("heaps_learning_medium_hard_problems_hard_problems_design_twitter", "Design Twitter", "MEDIUM");
        q_heaps_learning_medium_hard_problems_hard_problems_design_twitter.setSolveLink("https://leetcode.com/problems/design-twitter/");
        q_heaps_learning_medium_hard_problems_hard_problems_design_twitter.setEditorialLink("");
        
        
        q_heaps_learning_medium_hard_problems_hard_problems_design_twitter.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/design-twitter"));
        
        
        topic_11_3.addQuestion(q_heaps_learning_medium_hard_problems_hard_problems_design_twitter);
        
        Question q_heaps_learning_medium_hard_problems_hard_problems_minimum_cost_to_connect_sticks = new Question("heaps_learning_medium_hard_problems_hard_problems_minimum_cost_to_connect_sticks", "Minimum Cost to Connect Sticks", "MEDIUM");
        q_heaps_learning_medium_hard_problems_hard_problems_minimum_cost_to_connect_sticks.setSolveLink("https://takeuforward.org/plus/dsa/problems/minimum-cost-to-connect-sticks");
        q_heaps_learning_medium_hard_problems_hard_problems_minimum_cost_to_connect_sticks.setEditorialLink("https://takeuforward.org/plus/dsa/problems/minimum-cost-to-connect-sticks?tab=editorial");
        
        
        q_heaps_learning_medium_hard_problems_hard_problems_minimum_cost_to_connect_sticks.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/minimum-cost-to-connect-sticks"));
        
        
        topic_11_3.addQuestion(q_heaps_learning_medium_hard_problems_hard_problems_minimum_cost_to_connect_sticks);
        
        Question q_heaps_learning_medium_hard_problems_hard_problems_kth_largest_element_in_a_stream_of_running_integers = new Question("heaps_learning_medium_hard_problems_hard_problems_kth_largest_element_in_a_stream_of_running_integers", "Kth largest element in a stream of running integers", "HARD");
        q_heaps_learning_medium_hard_problems_hard_problems_kth_largest_element_in_a_stream_of_running_integers.setSolveLink("https://leetcode.com/problems/kth-largest-element-in-a-stream/#:~:text=Implement%20KthLargest%20class%3A,largest%20element%20in%20the%20stream.");
        q_heaps_learning_medium_hard_problems_hard_problems_kth_largest_element_in_a_stream_of_running_integers.setEditorialLink("https://takeuforward.org/plus/dsa/problems/kth-largest-element-in-a-stream-of-running-integers?tab=editorial");
        
        
        q_heaps_learning_medium_hard_problems_hard_problems_kth_largest_element_in_a_stream_of_running_integers.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/kth-largest-element-in-a-stream-of-running-integers"));
        
        
        topic_11_3.addQuestion(q_heaps_learning_medium_hard_problems_hard_problems_kth_largest_element_in_a_stream_of_running_integers);
        
        Question q_heaps_learning_medium_hard_problems_hard_problems_maximum_sum_combination = new Question("heaps_learning_medium_hard_problems_hard_problems_maximum_sum_combination", "Maximum Sum Combination", "HARD");
        q_heaps_learning_medium_hard_problems_hard_problems_maximum_sum_combination.setSolveLink("https://takeuforward.org/plus/dsa/problems/maximum-sum-combination");
        q_heaps_learning_medium_hard_problems_hard_problems_maximum_sum_combination.setEditorialLink("");
        
        
        q_heaps_learning_medium_hard_problems_hard_problems_maximum_sum_combination.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/maximum-sum-combination"));
        
        
        topic_11_3.addQuestion(q_heaps_learning_medium_hard_problems_hard_problems_maximum_sum_combination);
        
        Question q_heaps_learning_medium_hard_problems_hard_problems_find_median_from_data_stream = new Question("heaps_learning_medium_hard_problems_hard_problems_find_median_from_data_stream", "Find Median from Data Stream", "HARD");
        q_heaps_learning_medium_hard_problems_hard_problems_find_median_from_data_stream.setSolveLink("https://leetcode.com/problems/find-median-from-data-stream/");
        q_heaps_learning_medium_hard_problems_hard_problems_find_median_from_data_stream.setEditorialLink("");
        
        
        q_heaps_learning_medium_hard_problems_hard_problems_find_median_from_data_stream.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/find-median-from-data-stream"));
        
        
        topic_11_3.addQuestion(q_heaps_learning_medium_hard_problems_hard_problems_find_median_from_data_stream);
        
        Question q_heaps_learning_medium_hard_problems_hard_problems_top_k_frequent_elements = new Question("heaps_learning_medium_hard_problems_hard_problems_top_k_frequent_elements", "Top K Frequent Elements", "MEDIUM");
        q_heaps_learning_medium_hard_problems_hard_problems_top_k_frequent_elements.setSolveLink("https://leetcode.com/problems/top-k-frequent-elements/");
        q_heaps_learning_medium_hard_problems_hard_problems_top_k_frequent_elements.setEditorialLink("");
        
        
        q_heaps_learning_medium_hard_problems_hard_problems_top_k_frequent_elements.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/top-k-frequent-elements"));
        
        
        topic_11_3.addQuestion(q_heaps_learning_medium_hard_problems_hard_problems_top_k_frequent_elements);
        
        
        section_11.addTopic(topic_11_3);
        
        
        Roadmap.addSection(section_11);
        
        // ==========================================
        // Section: Greedy Algorithms [Easy, Medium/Hard]
        // ==========================================
        RoadmapSection section_12 = new RoadmapSection("greedy_algorithms_easy_mediumhard", "Greedy Algorithms [Easy, Medium/Hard]");
        
        
        
        // Topic: Easy Problems
        Topic topic_12_1 = new Topic("greedy_algorithms_easy_mediumhard_easy_problems", "Easy Problems");
        
        
        
        Question q_greedy_algorithms_easy_mediumhard_easy_problems_assign_cookies = new Question("greedy_algorithms_easy_mediumhard_easy_problems_assign_cookies", "Assign Cookies", "EASY");
        q_greedy_algorithms_easy_mediumhard_easy_problems_assign_cookies.setSolveLink("https://leetcode.com/problems/assign-cookies/");
        q_greedy_algorithms_easy_mediumhard_easy_problems_assign_cookies.setEditorialLink("https://takeuforward.org/plus/dsa/problems/assign-cookies?tab=editorial");
        
        
        q_greedy_algorithms_easy_mediumhard_easy_problems_assign_cookies.addLink(new QuestionLink("VIDEO", "https://youtu.be/DIX2p7vb9co?si=GofAIDimue-Av0Fi"));
        
        q_greedy_algorithms_easy_mediumhard_easy_problems_assign_cookies.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/assign-cookies"));
        
        
        topic_12_1.addQuestion(q_greedy_algorithms_easy_mediumhard_easy_problems_assign_cookies);
        
        Question q_greedy_algorithms_easy_mediumhard_easy_problems_fractional_knapsack = new Question("greedy_algorithms_easy_mediumhard_easy_problems_fractional_knapsack", "Fractional Knapsack", "MEDIUM");
        q_greedy_algorithms_easy_mediumhard_easy_problems_fractional_knapsack.setSolveLink("https://takeuforward.org/plus/dsa/problems/fractional-knapsack");
        q_greedy_algorithms_easy_mediumhard_easy_problems_fractional_knapsack.setEditorialLink("");
        
        
        q_greedy_algorithms_easy_mediumhard_easy_problems_fractional_knapsack.addLink(new QuestionLink("VIDEO", "https://youtu.be/1ibsQrnuEEg?si=8R2By3wpHo0zZVHE"));
        
        q_greedy_algorithms_easy_mediumhard_easy_problems_fractional_knapsack.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/fractional-knapsack-problem-greedy-approach/"));
        
        
        topic_12_1.addQuestion(q_greedy_algorithms_easy_mediumhard_easy_problems_fractional_knapsack);
        
        Question q_greedy_algorithms_easy_mediumhard_easy_problems_lemonade_change = new Question("greedy_algorithms_easy_mediumhard_easy_problems_lemonade_change", "Lemonade Change", "EASY");
        q_greedy_algorithms_easy_mediumhard_easy_problems_lemonade_change.setSolveLink("https://leetcode.com/problems/lemonade-change/");
        q_greedy_algorithms_easy_mediumhard_easy_problems_lemonade_change.setEditorialLink("https://takeuforward.org/plus/dsa/problems/lemonade-change?tab=editorial");
        
        
        q_greedy_algorithms_easy_mediumhard_easy_problems_lemonade_change.addLink(new QuestionLink("VIDEO", "https://youtu.be/n_tmibEhO6Q?si=q1NW8MfPy0QU6fIl"));
        
        q_greedy_algorithms_easy_mediumhard_easy_problems_lemonade_change.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/Greedy/lemonade-change"));
        
        
        topic_12_1.addQuestion(q_greedy_algorithms_easy_mediumhard_easy_problems_lemonade_change);
        
        Question q_greedy_algorithms_easy_mediumhard_easy_problems_valid_paranthesis_checker = new Question("greedy_algorithms_easy_mediumhard_easy_problems_valid_paranthesis_checker", "Valid Paranthesis Checker", "HARD");
        q_greedy_algorithms_easy_mediumhard_easy_problems_valid_paranthesis_checker.setSolveLink("https://leetcode.com/problems/valid-parenthesis-string/");
        q_greedy_algorithms_easy_mediumhard_easy_problems_valid_paranthesis_checker.setEditorialLink("https://takeuforward.org/plus/dsa/problems/valid-paranthesis-checker?tab=editorial");
        
        
        q_greedy_algorithms_easy_mediumhard_easy_problems_valid_paranthesis_checker.addLink(new QuestionLink("VIDEO", "https://youtu.be/cHT6sG_hUZI?si=XRHeyh7jOaLaTy3g"));
        
        q_greedy_algorithms_easy_mediumhard_easy_problems_valid_paranthesis_checker.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/valid-paranthesis-checker"));
        
        
        topic_12_1.addQuestion(q_greedy_algorithms_easy_mediumhard_easy_problems_valid_paranthesis_checker);
        
        
        section_12.addTopic(topic_12_1);
        
        // Topic: Medium/Hard
        Topic topic_12_2 = new Topic("greedy_algorithms_easy_mediumhard_mediumhard", "Medium/Hard");
        
        
        
        Question q_greedy_algorithms_easy_mediumhard_mediumhard_n_meetings_in_one_room = new Question("greedy_algorithms_easy_mediumhard_mediumhard_n_meetings_in_one_room", "N meetings in one room", "MEDIUM");
        q_greedy_algorithms_easy_mediumhard_mediumhard_n_meetings_in_one_room.setSolveLink("https://takeuforward.org/plus/dsa/problems/n-meetings-in-one-room");
        q_greedy_algorithms_easy_mediumhard_mediumhard_n_meetings_in_one_room.setEditorialLink("https://takeuforward.org/plus/dsa/problems/n-meetings-in-one-room?tab=editorial");
        
        
        q_greedy_algorithms_easy_mediumhard_mediumhard_n_meetings_in_one_room.addLink(new QuestionLink("VIDEO", "https://youtu.be/mKfhTotEguk?si=2RELeq18mpmIIN3Q"));
        
        q_greedy_algorithms_easy_mediumhard_mediumhard_n_meetings_in_one_room.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/n-meetings-in-one-room/"));
        
        
        topic_12_2.addQuestion(q_greedy_algorithms_easy_mediumhard_mediumhard_n_meetings_in_one_room);
        
        Question q_greedy_algorithms_easy_mediumhard_mediumhard_jump_game_i = new Question("greedy_algorithms_easy_mediumhard_mediumhard_jump_game_i", "Jump Game - I", "EASY");
        q_greedy_algorithms_easy_mediumhard_mediumhard_jump_game_i.setSolveLink("https://leetcode.com/problems/jump-game/");
        q_greedy_algorithms_easy_mediumhard_mediumhard_jump_game_i.setEditorialLink("https://takeuforward.org/plus/dsa/problems/jump-game---i?tab=editorial");
        
        
        q_greedy_algorithms_easy_mediumhard_mediumhard_jump_game_i.addLink(new QuestionLink("VIDEO", "https://youtu.be/tZAa_jJ3SwQ?si=voKd7n9VTLDRRNzJ"));
        
        q_greedy_algorithms_easy_mediumhard_mediumhard_jump_game_i.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/Greedy/jump-game-i"));
        
        
        topic_12_2.addQuestion(q_greedy_algorithms_easy_mediumhard_mediumhard_jump_game_i);
        
        Question q_greedy_algorithms_easy_mediumhard_mediumhard_jump_game_ii = new Question("greedy_algorithms_easy_mediumhard_mediumhard_jump_game_ii", "Jump Game II", "MEDIUM");
        q_greedy_algorithms_easy_mediumhard_mediumhard_jump_game_ii.setSolveLink("https://leetcode.com/problems/jump-game-ii/");
        q_greedy_algorithms_easy_mediumhard_mediumhard_jump_game_ii.setEditorialLink("");
        
        
        q_greedy_algorithms_easy_mediumhard_mediumhard_jump_game_ii.addLink(new QuestionLink("VIDEO", "https://youtu.be/7SBVnw7GSTk?si=9uUouBELh9K3m2jZ"));
        
        q_greedy_algorithms_easy_mediumhard_mediumhard_jump_game_ii.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/jump-game-2"));
        
        
        topic_12_2.addQuestion(q_greedy_algorithms_easy_mediumhard_mediumhard_jump_game_ii);
        
        Question q_greedy_algorithms_easy_mediumhard_mediumhard_minimum_number_of_platforms_required_for_a_railway = new Question("greedy_algorithms_easy_mediumhard_mediumhard_minimum_number_of_platforms_required_for_a_railway", "Minimum number of platforms required for a railway", "MEDIUM");
        q_greedy_algorithms_easy_mediumhard_mediumhard_minimum_number_of_platforms_required_for_a_railway.setSolveLink("https://takeuforward.org/plus/dsa/problems/minimum-number-of-platforms-required-for-a-railway");
        q_greedy_algorithms_easy_mediumhard_mediumhard_minimum_number_of_platforms_required_for_a_railway.setEditorialLink("https://takeuforward.org/plus/dsa/problems/minimum-number-of-platforms-required-for-a-railway?tab=editorial");
        
        
        q_greedy_algorithms_easy_mediumhard_mediumhard_minimum_number_of_platforms_required_for_a_railway.addLink(new QuestionLink("VIDEO", "https://youtu.be/AsGzwR_FWok?si=165acXU_dtqOHuo9"));
        
        q_greedy_algorithms_easy_mediumhard_mediumhard_minimum_number_of_platforms_required_for_a_railway.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/minimum-number-of-platforms-required-for-a-railway/"));
        
        
        topic_12_2.addQuestion(q_greedy_algorithms_easy_mediumhard_mediumhard_minimum_number_of_platforms_required_for_a_railway);
        
        Question q_greedy_algorithms_easy_mediumhard_mediumhard_job_sequencing_problem = new Question("greedy_algorithms_easy_mediumhard_mediumhard_job_sequencing_problem", "Job sequencing Problem", "MEDIUM");
        q_greedy_algorithms_easy_mediumhard_mediumhard_job_sequencing_problem.setSolveLink("https://takeuforward.org/plus/dsa/problems/job-sequencing-problem");
        q_greedy_algorithms_easy_mediumhard_mediumhard_job_sequencing_problem.setEditorialLink("https://takeuforward.org/plus/dsa/problems/job-sequencing-problem?tab=editorial");
        
        
        q_greedy_algorithms_easy_mediumhard_mediumhard_job_sequencing_problem.addLink(new QuestionLink("VIDEO", "https://youtu.be/QbwltemZbRg?si=wvcemJ5BLPlTRmkG"));
        
        q_greedy_algorithms_easy_mediumhard_mediumhard_job_sequencing_problem.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/job-sequencing-problem/"));
        
        
        topic_12_2.addQuestion(q_greedy_algorithms_easy_mediumhard_mediumhard_job_sequencing_problem);
        
        Question q_greedy_algorithms_easy_mediumhard_mediumhard_candy = new Question("greedy_algorithms_easy_mediumhard_mediumhard_candy", "Candy", "HARD");
        q_greedy_algorithms_easy_mediumhard_mediumhard_candy.setSolveLink("https://leetcode.com/problems/candy/");
        q_greedy_algorithms_easy_mediumhard_mediumhard_candy.setEditorialLink("https://takeuforward.org/plus/dsa/problems/candy?tab=editorial");
        
        
        q_greedy_algorithms_easy_mediumhard_mediumhard_candy.addLink(new QuestionLink("VIDEO", "https://youtu.be/IIqVFvKE6RY?si=EjmuXZJNLQLUkEd7"));
        
        q_greedy_algorithms_easy_mediumhard_mediumhard_candy.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/candy"));
        
        
        topic_12_2.addQuestion(q_greedy_algorithms_easy_mediumhard_mediumhard_candy);
        
        Question q_greedy_algorithms_easy_mediumhard_mediumhard_shortest_job_first = new Question("greedy_algorithms_easy_mediumhard_mediumhard_shortest_job_first", "Shortest Job First", "MEDIUM");
        q_greedy_algorithms_easy_mediumhard_mediumhard_shortest_job_first.setSolveLink("https://takeuforward.org/plus/dsa/problems/shortest-job-first");
        q_greedy_algorithms_easy_mediumhard_mediumhard_shortest_job_first.setEditorialLink("https://takeuforward.org/plus/dsa/problems/shortest-job-first?tab=editorial");
        
        
        q_greedy_algorithms_easy_mediumhard_mediumhard_shortest_job_first.addLink(new QuestionLink("VIDEO", "https://youtu.be/3-QbX1iDbXs?si=IH8QZUblr01F7UoQ"));
        
        q_greedy_algorithms_easy_mediumhard_mediumhard_shortest_job_first.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/Greedy/shortest-job-first-or-sjf-cpu-scheduling"));
        
        
        topic_12_2.addQuestion(q_greedy_algorithms_easy_mediumhard_mediumhard_shortest_job_first);
        
        Question q_greedy_algorithms_easy_mediumhard_mediumhard_program_for_least_recently_used_lru_page_replacement_algorithm = new Question("greedy_algorithms_easy_mediumhard_mediumhard_program_for_least_recently_used_lru_page_replacement_algorithm", "Program for Least Recently Used (LRU) Page Replacement Algorithm", "MEDIUM");
        q_greedy_algorithms_easy_mediumhard_mediumhard_program_for_least_recently_used_lru_page_replacement_algorithm.setSolveLink("https://takeuforward.org/plus/dsa/problems/lru-cache");
        q_greedy_algorithms_easy_mediumhard_mediumhard_program_for_least_recently_used_lru_page_replacement_algorithm.setEditorialLink("https://takeuforward.org/plus/dsa/problems/lru-cache?tab=editorial");
        
        
        q_greedy_algorithms_easy_mediumhard_mediumhard_program_for_least_recently_used_lru_page_replacement_algorithm.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/program-for-least-recently-used-lru-page-replacement-algorithm"));
        
        
        topic_12_2.addQuestion(q_greedy_algorithms_easy_mediumhard_mediumhard_program_for_least_recently_used_lru_page_replacement_algorithm);
        
        Question q_greedy_algorithms_easy_mediumhard_mediumhard_insert_interval = new Question("greedy_algorithms_easy_mediumhard_mediumhard_insert_interval", "Insert Interval", "MEDIUM");
        q_greedy_algorithms_easy_mediumhard_mediumhard_insert_interval.setSolveLink("https://leetcode.com/problems/insert-interval/");
        q_greedy_algorithms_easy_mediumhard_mediumhard_insert_interval.setEditorialLink("https://takeuforward.org/plus/dsa/problems/insert-interval?tab=editorial");
        
        
        q_greedy_algorithms_easy_mediumhard_mediumhard_insert_interval.addLink(new QuestionLink("VIDEO", "https://youtu.be/xxRE-46OCC8?si=a7aPuIw16zDx2lAa"));
        
        q_greedy_algorithms_easy_mediumhard_mediumhard_insert_interval.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/?s=Insert+Interval"));
        
        
        topic_12_2.addQuestion(q_greedy_algorithms_easy_mediumhard_mediumhard_insert_interval);
        
        Question q_greedy_algorithms_easy_mediumhard_mediumhard_merge_intervals = new Question("greedy_algorithms_easy_mediumhard_mediumhard_merge_intervals", "Merge Intervals", "MEDIUM");
        q_greedy_algorithms_easy_mediumhard_mediumhard_merge_intervals.setSolveLink("https://leetcode.com/problems/merge-intervals/");
        q_greedy_algorithms_easy_mediumhard_mediumhard_merge_intervals.setEditorialLink("");
        
        
        q_greedy_algorithms_easy_mediumhard_mediumhard_merge_intervals.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=2JzRBPFYbKE&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=6"));
        
        q_greedy_algorithms_easy_mediumhard_mediumhard_merge_intervals.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/merge-overlapping-sub-intervals/"));
        
        
        topic_12_2.addQuestion(q_greedy_algorithms_easy_mediumhard_mediumhard_merge_intervals);
        
        Question q_greedy_algorithms_easy_mediumhard_mediumhard_non_overlapping_intervals = new Question("greedy_algorithms_easy_mediumhard_mediumhard_non_overlapping_intervals", "Non-overlapping Intervals", "MEDIUM");
        q_greedy_algorithms_easy_mediumhard_mediumhard_non_overlapping_intervals.setSolveLink("https://leetcode.com/problems/non-overlapping-intervals/");
        q_greedy_algorithms_easy_mediumhard_mediumhard_non_overlapping_intervals.setEditorialLink("https://takeuforward.org/plus/dsa/problems/non-overlapping-intervals?tab=editorial");
        
        
        q_greedy_algorithms_easy_mediumhard_mediumhard_non_overlapping_intervals.addLink(new QuestionLink("VIDEO", "https://youtu.be/HDHQ8lAWakY?si=JVtLqboGdpUTOVjf"));
        
        q_greedy_algorithms_easy_mediumhard_mediumhard_non_overlapping_intervals.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/non-overlapping-intervals"));
        
        
        topic_12_2.addQuestion(q_greedy_algorithms_easy_mediumhard_mediumhard_non_overlapping_intervals);
        
        
        section_12.addTopic(topic_12_2);
        
        
        Roadmap.addSection(section_12);
        
        // ==========================================
        // Section: Binary Trees [Traversals, Medium and Hard Problems]
        // ==========================================
        RoadmapSection section_13 = new RoadmapSection("binary_trees_traversals_medium_and_hard_problems", "Binary Trees [Traversals, Medium and Hard Problems]");
        
        
        
        // Topic: Traversals
        Topic topic_13_1 = new Topic("binary_trees_traversals_medium_and_hard_problems_traversals", "Traversals");
        
        
        
        Question q_binary_trees_traversals_medium_and_hard_problems_traversals_introduction_to_trees = new Question("binary_trees_traversals_medium_and_hard_problems_traversals_introduction_to_trees", "Introduction to Trees", "EASY");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_introduction_to_trees.setSolveLink("https://takeuforward.org/plus/dsa/problems/introduction-");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_introduction_to_trees.setEditorialLink("https://takeuforward.org/plus/dsa/problems/introduction-");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_introduction_to_trees.addLink(new QuestionLink("VIDEO", "https://youtu.be/_ANrF3FJm7I"));
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_introduction_to_trees.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/binary-tree/introduction-to-trees/"));
        
        
        topic_13_1.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_traversals_introduction_to_trees);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_traversals_binary_tree_representation_in_java = new Question("binary_trees_traversals_medium_and_hard_problems_traversals_binary_tree_representation_in_java", "Binary Tree Representation in Java", "EASY");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_binary_tree_representation_in_java.setSolveLink("https://takeuforward.org/plus/dsa/problems/introduction-");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_binary_tree_representation_in_java.setEditorialLink("https://takeuforward.org/plus/dsa/problems/introduction-");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_binary_tree_representation_in_java.addLink(new QuestionLink("VIDEO", "https://youtu.be/hyLyW7rP24I"));
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_binary_tree_representation_in_java.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/binary-tree/binary-tree-representation-in-java/"));
        
        
        topic_13_1.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_traversals_binary_tree_representation_in_java);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_traversals_pre_post_inorder_in_one_traversal = new Question("binary_trees_traversals_medium_and_hard_problems_traversals_pre_post_inorder_in_one_traversal", "Pre, Post, Inorder in one traversal", "EASY");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_pre_post_inorder_in_one_traversal.setSolveLink("https://takeuforward.org/plus/dsa/problems/pre,-post,-inorder-in-one-traversal");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_pre_post_inorder_in_one_traversal.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pre,-post,-inorder-in-one-traversal?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_pre_post_inorder_in_one_traversal.addLink(new QuestionLink("VIDEO", "https://youtu.be/ySp2epYvgTE"));
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_pre_post_inorder_in_one_traversal.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/preorder-inorder-postorder-traversals-in-one-traversal/"));
        
        
        topic_13_1.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_traversals_pre_post_inorder_in_one_traversal);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_traversals_preorder_traversal = new Question("binary_trees_traversals_medium_and_hard_problems_traversals_preorder_traversal", "Preorder Traversal", "EASY");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_preorder_traversal.setSolveLink("https://leetcode.com/problems/binary-tree-preorder-traversal/");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_preorder_traversal.setEditorialLink("https://takeuforward.org/plus/dsa/problems/preorder-traversal?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_preorder_traversal.addLink(new QuestionLink("VIDEO", "https://youtu.be/RlUu72JrOCQ"));
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_preorder_traversal.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/preorder-traversal-of-binary-tree/"));
        
        
        topic_13_1.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_traversals_preorder_traversal);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_traversals_inorder_traversal_of_binary_tree = new Question("binary_trees_traversals_medium_and_hard_problems_traversals_inorder_traversal_of_binary_tree", "Inorder Traversal of Binary Tree", "EASY");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_inorder_traversal_of_binary_tree.setSolveLink("https://leetcode.com/problems/binary-tree-inorder-traversal/");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_inorder_traversal_of_binary_tree.setEditorialLink("https://takeuforward.org/plus/dsa/problems/inorder-traversal?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_inorder_traversal_of_binary_tree.addLink(new QuestionLink("VIDEO", "https://youtu.be/Z_NEgBgbRVI"));
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_inorder_traversal_of_binary_tree.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/inorder-traversal-of-binary-tree/"));
        
        
        topic_13_1.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_traversals_inorder_traversal_of_binary_tree);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_traversals_postorder_traversal = new Question("binary_trees_traversals_medium_and_hard_problems_traversals_postorder_traversal", "Postorder Traversal", "EASY");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_postorder_traversal.setSolveLink("https://leetcode.com/problems/binary-tree-postorder-traversal/");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_postorder_traversal.setEditorialLink("https://takeuforward.org/plus/dsa/problems/postorder-traversal?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_postorder_traversal.addLink(new QuestionLink("VIDEO", "https://youtu.be/2YBhNLodD8Q"));
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_postorder_traversal.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/iterative-postorder-traversal-of-binary-tree-using-2-stack"));
        
        
        topic_13_1.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_traversals_postorder_traversal);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_traversals_level_order_traversal = new Question("binary_trees_traversals_medium_and_hard_problems_traversals_level_order_traversal", "Level Order Traversal", "EASY");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_level_order_traversal.setSolveLink("https://leetcode.com/problems/binary-tree-level-order-traversal/");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_level_order_traversal.setEditorialLink("https://takeuforward.org/plus/dsa/problems/level-order-traversal?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_level_order_traversal.addLink(new QuestionLink("VIDEO", "https://youtu.be/EoAsWbO7sqg"));
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_level_order_traversal.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/level-order-traversal-of-a-binary-tree/"));
        
        
        topic_13_1.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_traversals_level_order_traversal);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_traversals_iterative_preorder_traversal_of_binary_tree = new Question("binary_trees_traversals_medium_and_hard_problems_traversals_iterative_preorder_traversal_of_binary_tree", "Iterative Preorder Traversal of Binary Tree", "EASY");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_iterative_preorder_traversal_of_binary_tree.setSolveLink("https://leetcode.com/problems/binary-tree-preorder-traversal/");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_iterative_preorder_traversal_of_binary_tree.setEditorialLink("https://takeuforward.org/plus/dsa/problems/preorder-traversal?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_iterative_preorder_traversal_of_binary_tree.addLink(new QuestionLink("VIDEO", "https://youtu.be/Bfqd8BsPVuw"));
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_iterative_preorder_traversal_of_binary_tree.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/iterative-preorder-traversal-of-binary-tree"));
        
        
        topic_13_1.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_traversals_iterative_preorder_traversal_of_binary_tree);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_traversals_iterative_inorder_traversal_of_binary_tree = new Question("binary_trees_traversals_medium_and_hard_problems_traversals_iterative_inorder_traversal_of_binary_tree", "Iterative Inorder Traversal of Binary Tree", "EASY");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_iterative_inorder_traversal_of_binary_tree.setSolveLink("https://leetcode.com/problems/binary-tree-inorder-traversal/");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_iterative_inorder_traversal_of_binary_tree.setEditorialLink("https://takeuforward.org/plus/dsa/problems/inorder-traversal?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_iterative_inorder_traversal_of_binary_tree.addLink(new QuestionLink("VIDEO", "https://youtu.be/lxTGsVXjwvM"));
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_iterative_inorder_traversal_of_binary_tree.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/inorder-traversal-of-binary-tree/"));
        
        
        topic_13_1.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_traversals_iterative_inorder_traversal_of_binary_tree);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_traversals_post_order_traversal_of_binary_tree_using_2_stack = new Question("binary_trees_traversals_medium_and_hard_problems_traversals_post_order_traversal_of_binary_tree_using_2_stack", "Post-order Traversal of Binary Tree using 2 stack", "EASY");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_post_order_traversal_of_binary_tree_using_2_stack.setSolveLink("https://leetcode.com/problems/binary-tree-postorder-traversal/");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_post_order_traversal_of_binary_tree_using_2_stack.setEditorialLink("https://takeuforward.org/plus/dsa/problems/postorder-traversal?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_post_order_traversal_of_binary_tree_using_2_stack.addLink(new QuestionLink("VIDEO", "https://youtu.be/2YBhNLodD8Q"));
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_post_order_traversal_of_binary_tree_using_2_stack.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/iterative-postorder-traversal-of-binary-tree-using-2-stack"));
        
        
        topic_13_1.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_traversals_post_order_traversal_of_binary_tree_using_2_stack);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_traversals_post_order_traversal_of_binary_tree_using_1_stack = new Question("binary_trees_traversals_medium_and_hard_problems_traversals_post_order_traversal_of_binary_tree_using_1_stack", "Post-order Traversal of Binary Tree using 1 stack", "EASY");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_post_order_traversal_of_binary_tree_using_1_stack.setSolveLink("https://leetcode.com/problems/binary-tree-postorder-traversal/");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_post_order_traversal_of_binary_tree_using_1_stack.setEditorialLink("https://takeuforward.org/plus/dsa/problems/postorder-traversal?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_post_order_traversal_of_binary_tree_using_1_stack.addLink(new QuestionLink("VIDEO", "https://youtu.be/NzIGLLwZBS8"));
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_post_order_traversal_of_binary_tree_using_1_stack.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/post-order-traversal-of-binary-tree/"));
        
        
        topic_13_1.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_traversals_post_order_traversal_of_binary_tree_using_1_stack);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_traversals_preorder_inorder_and_postorder_traversal_in_one_traversal = new Question("binary_trees_traversals_medium_and_hard_problems_traversals_preorder_inorder_and_postorder_traversal_in_one_traversal", "Preorder, Inorder, and Postorder Traversal in one Traversal", "EASY");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_preorder_inorder_and_postorder_traversal_in_one_traversal.setSolveLink("https://takeuforward.org/plus/dsa/problems/pre,-post,-inorder-in-one-traversal");
        q_binary_trees_traversals_medium_and_hard_problems_traversals_preorder_inorder_and_postorder_traversal_in_one_traversal.setEditorialLink("https://takeuforward.org/plus/dsa/problems/pre,-post,-inorder-in-one-traversal?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_preorder_inorder_and_postorder_traversal_in_one_traversal.addLink(new QuestionLink("VIDEO", "https://youtu.be/ySp2epYvgTE"));
        
        q_binary_trees_traversals_medium_and_hard_problems_traversals_preorder_inorder_and_postorder_traversal_in_one_traversal.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/preorder-inorder-postorder-traversals-in-one-traversal/"));
        
        
        topic_13_1.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_traversals_preorder_inorder_and_postorder_traversal_in_one_traversal);
        
        
        section_13.addTopic(topic_13_1);
        
        // Topic: Medium Problems
        Topic topic_13_2 = new Topic("binary_trees_traversals_medium_and_hard_problems_medium_problems", "Medium Problems");
        
        
        
        Question q_binary_trees_traversals_medium_and_hard_problems_medium_problems_maximum_depth_in_bt = new Question("binary_trees_traversals_medium_and_hard_problems_medium_problems_maximum_depth_in_bt", "Maximum Depth in BT", "MEDIUM");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_maximum_depth_in_bt.setSolveLink("https://leetcode.com/problems/maximum-depth-of-binary-tree/");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_maximum_depth_in_bt.setEditorialLink("https://takeuforward.org/plus/dsa/problems/maximum-depth-in-bt?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_maximum_depth_in_bt.addLink(new QuestionLink("VIDEO", "https://youtu.be/eD3tmO66aBA"));
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_maximum_depth_in_bt.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/maximum-depth-of-a-binary-tree/"));
        
        
        topic_13_2.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_medium_problems_maximum_depth_in_bt);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_medium_problems_check_for_balanced_binary_tree = new Question("binary_trees_traversals_medium_and_hard_problems_medium_problems_check_for_balanced_binary_tree", "Check for balanced binary tree", "MEDIUM");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_check_for_balanced_binary_tree.setSolveLink("https://leetcode.com/problems/balanced-binary-tree/");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_check_for_balanced_binary_tree.setEditorialLink("https://takeuforward.org/plus/dsa/problems/check-for-balanced-binary-tree?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_check_for_balanced_binary_tree.addLink(new QuestionLink("VIDEO", "https://youtu.be/Yt50Jfbd8Po"));
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_check_for_balanced_binary_tree.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/check-if-the-binary-tree-is-balanced-binary-tree/"));
        
        
        topic_13_2.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_medium_problems_check_for_balanced_binary_tree);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_medium_problems_diameter_of_binary_tree = new Question("binary_trees_traversals_medium_and_hard_problems_medium_problems_diameter_of_binary_tree", "Diameter of Binary Tree", "EASY");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_diameter_of_binary_tree.setSolveLink("https://leetcode.com/problems/diameter-of-binary-tree/");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_diameter_of_binary_tree.setEditorialLink("https://takeuforward.org/plus/dsa/problems/diameter-of-binary-tree?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_diameter_of_binary_tree.addLink(new QuestionLink("VIDEO", "https://youtu.be/Rezetez59Nk"));
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_diameter_of_binary_tree.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/calculate-the-diameter-of-a-binary-tree/"));
        
        
        topic_13_2.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_medium_problems_diameter_of_binary_tree);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_medium_problems_maximum_path_sum = new Question("binary_trees_traversals_medium_and_hard_problems_medium_problems_maximum_path_sum", "Maximum path sum ", "MEDIUM");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_maximum_path_sum.setSolveLink("https://leetcode.com/problems/binary-tree-maximum-path-sum/");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_maximum_path_sum.setEditorialLink("https://takeuforward.org/plus/dsa/problems/maximum-path-sum-?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_maximum_path_sum.addLink(new QuestionLink("VIDEO", "https://youtu.be/WszrfSwMz58"));
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_maximum_path_sum.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/maximum-sum-path-in-binary-tree/"));
        
        
        topic_13_2.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_medium_problems_maximum_path_sum);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_medium_problems_check_if_two_trees_are_identical_or_not = new Question("binary_trees_traversals_medium_and_hard_problems_medium_problems_check_if_two_trees_are_identical_or_not", "Check if two trees are identical or not", "MEDIUM");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_check_if_two_trees_are_identical_or_not.setSolveLink("https://leetcode.com/problems/same-tree/");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_check_if_two_trees_are_identical_or_not.setEditorialLink("https://takeuforward.org/plus/dsa/problems/check-if-two-trees-are-identical-or-not?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_check_if_two_trees_are_identical_or_not.addLink(new QuestionLink("VIDEO", "https://youtu.be/BhuvF_-PWS0"));
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_check_if_two_trees_are_identical_or_not.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/check-if-two-trees-are-identical/"));
        
        
        topic_13_2.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_medium_problems_check_if_two_trees_are_identical_or_not);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_medium_problems_zig_zag_or_spiral_traversal = new Question("binary_trees_traversals_medium_and_hard_problems_medium_problems_zig_zag_or_spiral_traversal", "Zig Zag or Spiral Traversal", "MEDIUM");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_zig_zag_or_spiral_traversal.setSolveLink("https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_zig_zag_or_spiral_traversal.setEditorialLink("https://takeuforward.org/plus/dsa/problems/zig-zag-or-spiral-traversal?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_zig_zag_or_spiral_traversal.addLink(new QuestionLink("VIDEO", "https://youtu.be/3OXWEdlIGl4"));
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_zig_zag_or_spiral_traversal.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/zig-zag-traversal-of-binary-tree/"));
        
        
        topic_13_2.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_medium_problems_zig_zag_or_spiral_traversal);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_medium_problems_boundary_traversal = new Question("binary_trees_traversals_medium_and_hard_problems_medium_problems_boundary_traversal", "Boundary Traversal", "MEDIUM");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_boundary_traversal.setSolveLink("https://leetcode.com/problems/boundary-of-binary-tree/");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_boundary_traversal.setEditorialLink("https://takeuforward.org/plus/dsa/problems/boundary-traversal?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_boundary_traversal.addLink(new QuestionLink("VIDEO", "https://youtu.be/0ca1nvR0be4"));
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_boundary_traversal.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/boundary-traversal-of-a-binary-tree/"));
        
        
        topic_13_2.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_medium_problems_boundary_traversal);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_medium_problems_vertical_order_traversal = new Question("binary_trees_traversals_medium_and_hard_problems_medium_problems_vertical_order_traversal", "Vertical Order Traversal", "MEDIUM");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_vertical_order_traversal.setSolveLink("https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_vertical_order_traversal.setEditorialLink("https://takeuforward.org/plus/dsa/problems/vertical-order-traversal?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_vertical_order_traversal.addLink(new QuestionLink("VIDEO", "https://youtu.be/q_a6lpbKJdw"));
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_vertical_order_traversal.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/vertical-order-traversal-of-binary-tree/"));
        
        
        topic_13_2.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_medium_problems_vertical_order_traversal);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_medium_problems_top_view_of_bt = new Question("binary_trees_traversals_medium_and_hard_problems_medium_problems_top_view_of_bt", "Top View of BT", "MEDIUM");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_top_view_of_bt.setSolveLink("https://takeuforward.org/plus/dsa/problems/top-view-of-bt");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_top_view_of_bt.setEditorialLink("https://takeuforward.org/plus/dsa/problems/top-view-of-bt?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_top_view_of_bt.addLink(new QuestionLink("VIDEO", "https://youtu.be/Et9OCDNvJ78"));
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_top_view_of_bt.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/top-view-of-a-binary-tree/"));
        
        
        topic_13_2.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_medium_problems_top_view_of_bt);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_medium_problems_bottom_view_of_bt = new Question("binary_trees_traversals_medium_and_hard_problems_medium_problems_bottom_view_of_bt", "Bottom view of BT", "MEDIUM");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_bottom_view_of_bt.setSolveLink("https://takeuforward.org/plus/dsa/problems/bottom-view-of-bt");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_bottom_view_of_bt.setEditorialLink("https://takeuforward.org/plus/dsa/problems/bottom-view-of-bt?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_bottom_view_of_bt.addLink(new QuestionLink("VIDEO", "https://youtu.be/0FtVY6I4pB8"));
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_bottom_view_of_bt.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/bottom-view-of-a-binary-tree/"));
        
        
        topic_13_2.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_medium_problems_bottom_view_of_bt);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_medium_problems_rightleft_view_of_binary_tree = new Question("binary_trees_traversals_medium_and_hard_problems_medium_problems_rightleft_view_of_binary_tree", "Right/Left View of Binary Tree", "MEDIUM");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_rightleft_view_of_binary_tree.setSolveLink("https://leetcode.com/problems/binary-tree-right-side-view/");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_rightleft_view_of_binary_tree.setEditorialLink("https://takeuforward.org/plus/dsa/problems/right-left-view-of-bt?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_rightleft_view_of_binary_tree.addLink(new QuestionLink("VIDEO", "https://youtu.be/KV4mRzTjlAk"));
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_rightleft_view_of_binary_tree.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/right-left-view-of-binary-tree/"));
        
        
        topic_13_2.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_medium_problems_rightleft_view_of_binary_tree);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_medium_problems_symmetric_binary_tree = new Question("binary_trees_traversals_medium_and_hard_problems_medium_problems_symmetric_binary_tree", "Symmetric Binary Tree", "MEDIUM");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_symmetric_binary_tree.setSolveLink("https://leetcode.com/problems/symmetric-tree/");
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_symmetric_binary_tree.setEditorialLink("https://takeuforward.org/plus/dsa/problems/check-for-symmetrical-bts?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_symmetric_binary_tree.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=nKggNAiEpBE"));
        
        q_binary_trees_traversals_medium_and_hard_problems_medium_problems_symmetric_binary_tree.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/check-for-symmetrical-binary-tree/"));
        
        
        topic_13_2.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_medium_problems_symmetric_binary_tree);
        
        
        section_13.addTopic(topic_13_2);
        
        // Topic: Hard Problems
        Topic topic_13_3 = new Topic("binary_trees_traversals_medium_and_hard_problems_hard_problems", "Hard Problems");
        
        
        
        Question q_binary_trees_traversals_medium_and_hard_problems_hard_problems_print_root_to_leaf_path_in_bt = new Question("binary_trees_traversals_medium_and_hard_problems_hard_problems_print_root_to_leaf_path_in_bt", "Print root to leaf path in BT", "MEDIUM");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_print_root_to_leaf_path_in_bt.setSolveLink("https://takeuforward.org/plus/dsa/problems/print-root-to-note-path-in-bt");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_print_root_to_leaf_path_in_bt.setEditorialLink("https://takeuforward.org/plus/dsa/problems/print-root-to-note-path-in-bt?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_print_root_to_leaf_path_in_bt.addLink(new QuestionLink("VIDEO", "https://youtu.be/fmflMqVOC7k"));
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_print_root_to_leaf_path_in_bt.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/print-root-to-node-path-in-a-binary-tree/"));
        
        
        topic_13_3.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_hard_problems_print_root_to_leaf_path_in_bt);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_hard_problems_lca_in_bt = new Question("binary_trees_traversals_medium_and_hard_problems_hard_problems_lca_in_bt", "LCA in BT", "HARD");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_lca_in_bt.setSolveLink("https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_lca_in_bt.setEditorialLink("https://takeuforward.org/plus/dsa/problems/lca-in-bt?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_lca_in_bt.addLink(new QuestionLink("VIDEO", "https://youtu.be/_-QHfMDde90"));
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_lca_in_bt.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/lowest-common-ancestor-for-two-given-nodes/"));
        
        
        topic_13_3.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_hard_problems_lca_in_bt);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_hard_problems_maximum_width_of_bt = new Question("binary_trees_traversals_medium_and_hard_problems_hard_problems_maximum_width_of_bt", "Maximum Width of BT", "MEDIUM");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_maximum_width_of_bt.setSolveLink("https://leetcode.com/problems/maximum-width-of-binary-tree/");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_maximum_width_of_bt.setEditorialLink("https://takeuforward.org/plus/dsa/problems/maximum-width-of-bt?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_maximum_width_of_bt.addLink(new QuestionLink("VIDEO", "https://youtu.be/ZbybYvcVLks"));
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_maximum_width_of_bt.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/maximum-width-of-a-binary-tree/"));
        
        
        topic_13_3.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_hard_problems_maximum_width_of_bt);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_hard_problems_children_sum_property_in_binary_tree = new Question("binary_trees_traversals_medium_and_hard_problems_hard_problems_children_sum_property_in_binary_tree", "Children Sum Property in Binary Tree", "MEDIUM");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_children_sum_property_in_binary_tree.setSolveLink("https://takeuforward.org/plus/dsa/problems/children-sum-property-in-binary-tree");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_children_sum_property_in_binary_tree.setEditorialLink("https://takeuforward.org/plus/dsa/problems/children-sum-property-in-binary-tree?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_children_sum_property_in_binary_tree.addLink(new QuestionLink("VIDEO", "https://youtu.be/fnmisPM6cVo"));
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_children_sum_property_in_binary_tree.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/check-for-children-sum-property-in-a-binary-tree/"));
        
        
        topic_13_3.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_hard_problems_children_sum_property_in_binary_tree);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_hard_problems_print_all_nodes_at_a_distance_of_k_in_bt = new Question("binary_trees_traversals_medium_and_hard_problems_hard_problems_print_all_nodes_at_a_distance_of_k_in_bt", "Print all nodes at a distance of K in BT", "HARD");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_print_all_nodes_at_a_distance_of_k_in_bt.setSolveLink("https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_print_all_nodes_at_a_distance_of_k_in_bt.setEditorialLink("https://takeuforward.org/plus/dsa/problems/print-all-nodes-at-a-distance-of-k-in-bt?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_print_all_nodes_at_a_distance_of_k_in_bt.addLink(new QuestionLink("VIDEO", "https://youtu.be/i9ORlEy6EsI"));
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_print_all_nodes_at_a_distance_of_k_in_bt.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/print-all-the-nodes-at-a-distance-of-k-in-a-binary-tree"));
        
        
        topic_13_3.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_hard_problems_print_all_nodes_at_a_distance_of_k_in_bt);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_hard_problems_minimum_time_taken_to_burn_the_bt_from_a_given_node = new Question("binary_trees_traversals_medium_and_hard_problems_hard_problems_minimum_time_taken_to_burn_the_bt_from_a_given_node", "Minimum time taken to burn the BT from a given Node", "HARD");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_minimum_time_taken_to_burn_the_bt_from_a_given_node.setSolveLink("https://takeuforward.org/plus/dsa/problems/minimum-time-taken-to-burn-the-bt-from-a-given-node");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_minimum_time_taken_to_burn_the_bt_from_a_given_node.setEditorialLink("https://takeuforward.org/plus/dsa/problems/minimum-time-taken-to-burn-the-bt-from-a-given-node?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_minimum_time_taken_to_burn_the_bt_from_a_given_node.addLink(new QuestionLink("VIDEO", "https://youtu.be/2r5wLmQfD6g"));
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_minimum_time_taken_to_burn_the_bt_from_a_given_node.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/minimum-time-taken-to-burn-the-binary-tree-from-a-node"));
        
        
        topic_13_3.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_hard_problems_minimum_time_taken_to_burn_the_bt_from_a_given_node);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_hard_problems_count_total_nodes_in_a_complete_bt = new Question("binary_trees_traversals_medium_and_hard_problems_hard_problems_count_total_nodes_in_a_complete_bt", "Count total nodes in a complete BT", "EASY");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_count_total_nodes_in_a_complete_bt.setSolveLink("https://leetcode.com/problems/count-complete-tree-nodes/");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_count_total_nodes_in_a_complete_bt.setEditorialLink("https://takeuforward.org/plus/dsa/problems/count-total-nodes-in-a-complete-bt?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_count_total_nodes_in_a_complete_bt.addLink(new QuestionLink("VIDEO", "https://youtu.be/u-yWemKGWO0"));
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_count_total_nodes_in_a_complete_bt.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/binary-tree/count-number-of-nodes-in-a-binary-tree/"));
        
        
        topic_13_3.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_hard_problems_count_total_nodes_in_a_complete_bt);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_hard_problems_requirements_needed_to_construct_a_unique_bt = new Question("binary_trees_traversals_medium_and_hard_problems_hard_problems_requirements_needed_to_construct_a_unique_bt", "Requirements needed to construct a unique BT", "MEDIUM");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_requirements_needed_to_construct_a_unique_bt.setSolveLink("https://takeuforward.org/plus/dsa/problems/requirements-needed-to-construct-a-unique-bt");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_requirements_needed_to_construct_a_unique_bt.setEditorialLink("https://takeuforward.org/plus/dsa/problems/requirements-needed-to-construct-a-unique-bt?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_requirements_needed_to_construct_a_unique_bt.addLink(new QuestionLink("VIDEO", "https://youtu.be/9GMECGQgWrQ"));
        
        
        topic_13_3.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_hard_problems_requirements_needed_to_construct_a_unique_bt);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_hard_problems_construct_a_bt_from_preorder_and_inorder = new Question("binary_trees_traversals_medium_and_hard_problems_hard_problems_construct_a_bt_from_preorder_and_inorder", "Construct a BT from Preorder and Inorder", "HARD");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_construct_a_bt_from_preorder_and_inorder.setSolveLink("https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_construct_a_bt_from_preorder_and_inorder.setEditorialLink("https://takeuforward.org/plus/dsa/problems/construct-a-bt-from-preorder-and-inorder?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_construct_a_bt_from_preorder_and_inorder.addLink(new QuestionLink("VIDEO", "https://youtu.be/aZNaLrVebKQ"));
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_construct_a_bt_from_preorder_and_inorder.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/construct-a-binary-tree-from-inorder-and-preorder-traversal/"));
        
        
        topic_13_3.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_hard_problems_construct_a_bt_from_preorder_and_inorder);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_hard_problems_construct_the_binary_tree_from_postorder_and_inorder_traversal = new Question("binary_trees_traversals_medium_and_hard_problems_hard_problems_construct_the_binary_tree_from_postorder_and_inorder_traversal", "Construct the Binary Tree from Postorder and Inorder Traversal", "HARD");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_construct_the_binary_tree_from_postorder_and_inorder_traversal.setSolveLink("https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_construct_the_binary_tree_from_postorder_and_inorder_traversal.setEditorialLink("https://takeuforward.org/plus/dsa/problems/construct-a-bt-from-postorder-and-inorder?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_construct_the_binary_tree_from_postorder_and_inorder_traversal.addLink(new QuestionLink("VIDEO", "https://youtu.be/LgLRTaEMRVc"));
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_construct_the_binary_tree_from_postorder_and_inorder_traversal.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/construct-binary-tree-from-inorder-and-postorder-traversal/"));
        
        
        topic_13_3.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_hard_problems_construct_the_binary_tree_from_postorder_and_inorder_traversal);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_hard_problems_serialize_and_de_serialize_bt = new Question("binary_trees_traversals_medium_and_hard_problems_hard_problems_serialize_and_de_serialize_bt", "Serialize and De-serialize BT", "HARD");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_serialize_and_de_serialize_bt.setSolveLink("https://leetcode.com/problems/serialize-and-deserialize-binary-tree/");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_serialize_and_de_serialize_bt.setEditorialLink("https://takeuforward.org/plus/dsa/problems/serialize-and-de-serialize-bt?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_serialize_and_de_serialize_bt.addLink(new QuestionLink("VIDEO", "https://youtu.be/-YbXySKJsX8"));
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_serialize_and_de_serialize_bt.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/serialize-and-deserialize-a-binary-tree/"));
        
        
        topic_13_3.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_hard_problems_serialize_and_de_serialize_bt);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_hard_problems_morris_preorder_traversal_of_a_binary_tree = new Question("binary_trees_traversals_medium_and_hard_problems_hard_problems_morris_preorder_traversal_of_a_binary_tree", "Morris Preorder Traversal of a Binary Tree", "HARD");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_morris_preorder_traversal_of_a_binary_tree.setSolveLink("https://leetcode.com/problems/binary-tree-inorder-traversal/");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_morris_preorder_traversal_of_a_binary_tree.setEditorialLink("https://takeuforward.org/plus/dsa/problems/morris-preorder-traversal-?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_morris_preorder_traversal_of_a_binary_tree.addLink(new QuestionLink("VIDEO", "https://youtu.be/80Zug6D1_r4"));
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_morris_preorder_traversal_of_a_binary_tree.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/morris-preorder-traversal-of-a-binary-tree/"));
        
        
        topic_13_3.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_hard_problems_morris_preorder_traversal_of_a_binary_tree);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_hard_problems_morris_inorder_traversal_of_a_binary_tree = new Question("binary_trees_traversals_medium_and_hard_problems_hard_problems_morris_inorder_traversal_of_a_binary_tree", "Morris Inorder Traversal of a Binary Tree", "HARD");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_morris_inorder_traversal_of_a_binary_tree.setSolveLink("https://leetcode.com/problems/binary-tree-inorder-traversal/");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_morris_inorder_traversal_of_a_binary_tree.setEditorialLink("https://takeuforward.org/plus/dsa/problems/morris-inorder-traversal-?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_morris_inorder_traversal_of_a_binary_tree.addLink(new QuestionLink("VIDEO", "https://youtu.be/80Zug6D1_r4"));
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_morris_inorder_traversal_of_a_binary_tree.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/morris-inorder-traversal-of-a-binary-tree/"));
        
        
        topic_13_3.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_hard_problems_morris_inorder_traversal_of_a_binary_tree);
        
        Question q_binary_trees_traversals_medium_and_hard_problems_hard_problems_flatten_binary_tree_to_linked_list = new Question("binary_trees_traversals_medium_and_hard_problems_hard_problems_flatten_binary_tree_to_linked_list", "Flatten Binary Tree to Linked List", "MEDIUM");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_flatten_binary_tree_to_linked_list.setSolveLink("https://leetcode.com/problems/flatten-binary-tree-to-linked-list/");
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_flatten_binary_tree_to_linked_list.setEditorialLink("https://takeuforward.org/plus/dsa/problems/flatten-binary-tree-to-linked-list?tab=editorial");
        
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_flatten_binary_tree_to_linked_list.addLink(new QuestionLink("VIDEO", "https://youtu.be/sWf7k1x9XR4"));
        
        q_binary_trees_traversals_medium_and_hard_problems_hard_problems_flatten_binary_tree_to_linked_list.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/flatten-binary-tree-to-linked-list/"));
        
        
        topic_13_3.addQuestion(q_binary_trees_traversals_medium_and_hard_problems_hard_problems_flatten_binary_tree_to_linked_list);
        
        
        section_13.addTopic(topic_13_3);
        
        
        Roadmap.addSection(section_13);
        
        // ==========================================
        // Section: Binary Search Trees [Concept and Problems]
        // ==========================================
        RoadmapSection section_14 = new RoadmapSection("binary_search_trees_concept_and_problems", "Binary Search Trees [Concept and Problems]");
        
        
        
        // Topic: Concepts
        Topic topic_14_1 = new Topic("binary_search_trees_concept_and_problems_concepts", "Concepts");
        
        
        
        Question q_binary_search_trees_concept_and_problems_concepts_introduction_to_bst = new Question("binary_search_trees_concept_and_problems_concepts_introduction_to_bst", "Introduction to BST", "EASY");
        q_binary_search_trees_concept_and_problems_concepts_introduction_to_bst.setSolveLink("https://takeuforward.org/plus/dsa/problems/introduction-to-bst");
        q_binary_search_trees_concept_and_problems_concepts_introduction_to_bst.setEditorialLink("https://takeuforward.org/plus/dsa/problems/introduction-to-bst");
        
        
        q_binary_search_trees_concept_and_problems_concepts_introduction_to_bst.addLink(new QuestionLink("VIDEO", "https://youtu.be/p7-9UvDQZ3w"));
        
        q_binary_search_trees_concept_and_problems_concepts_introduction_to_bst.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/binary-search-tree/introduction-to-binary-search-trees/"));
        
        
        topic_14_1.addQuestion(q_binary_search_trees_concept_and_problems_concepts_introduction_to_bst);
        
        Question q_binary_search_trees_concept_and_problems_concepts_search_in_a_binary_search_tree = new Question("binary_search_trees_concept_and_problems_concepts_search_in_a_binary_search_tree", "Search in a Binary Search Tree", "EASY");
        q_binary_search_trees_concept_and_problems_concepts_search_in_a_binary_search_tree.setSolveLink("https://leetcode.com/problems/search-in-a-binary-search-tree/");
        q_binary_search_trees_concept_and_problems_concepts_search_in_a_binary_search_tree.setEditorialLink("https://takeuforward.org/plus/dsa/problems/search-in-bst?tab=editorial");
        
        
        q_binary_search_trees_concept_and_problems_concepts_search_in_a_binary_search_tree.addLink(new QuestionLink("VIDEO", "https://youtu.be/KcNt6v_56cc"));
        
        q_binary_search_trees_concept_and_problems_concepts_search_in_a_binary_search_tree.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/search-in-a-binary-search-tree-2/"));
        
        
        topic_14_1.addQuestion(q_binary_search_trees_concept_and_problems_concepts_search_in_a_binary_search_tree);
        
        Question q_binary_search_trees_concept_and_problems_concepts_find_minmax_in_bst = new Question("binary_search_trees_concept_and_problems_concepts_find_minmax_in_bst", "Find Min/Max in BST", "EASY");
        q_binary_search_trees_concept_and_problems_concepts_find_minmax_in_bst.setSolveLink("https://takeuforward.org/data-structure/find-minmax-in-a-bst");
        q_binary_search_trees_concept_and_problems_concepts_find_minmax_in_bst.setEditorialLink("");
        
        
        q_binary_search_trees_concept_and_problems_concepts_find_minmax_in_bst.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/find-minmax-in-a-bst"));
        
        
        topic_14_1.addQuestion(q_binary_search_trees_concept_and_problems_concepts_find_minmax_in_bst);
        
        
        section_14.addTopic(topic_14_1);
        
        // Topic: Practice Problems
        Topic topic_14_2 = new Topic("binary_search_trees_concept_and_problems_practice_problems", "Practice Problems");
        
        
        
        Question q_binary_search_trees_concept_and_problems_practice_problems_floor_and_ceil_in_a_bst = new Question("binary_search_trees_concept_and_problems_practice_problems_floor_and_ceil_in_a_bst", "Floor and Ceil in a BST", "EASY");
        q_binary_search_trees_concept_and_problems_practice_problems_floor_and_ceil_in_a_bst.setSolveLink("https://takeuforward.org/plus/dsa/problems/floor-and-ceil-in-a-bst");
        q_binary_search_trees_concept_and_problems_practice_problems_floor_and_ceil_in_a_bst.setEditorialLink("https://takeuforward.org/plus/dsa/problems/floor-and-ceil-in-a-bst?tab=editorial");
        
        
        q_binary_search_trees_concept_and_problems_practice_problems_floor_and_ceil_in_a_bst.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=xm_W1ub-K-w&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=43"));
        
        
        topic_14_2.addQuestion(q_binary_search_trees_concept_and_problems_practice_problems_floor_and_ceil_in_a_bst);
        
        Question q_binary_search_trees_concept_and_problems_practice_problems_floor_in_a_binary_search_tree = new Question("binary_search_trees_concept_and_problems_practice_problems_floor_in_a_binary_search_tree", "Floor in a Binary Search Tree", "EASY");
        q_binary_search_trees_concept_and_problems_practice_problems_floor_in_a_binary_search_tree.setSolveLink("https://takeuforward.org/plus/dsa/problems/floor-and-ceil-in-a-bst");
        q_binary_search_trees_concept_and_problems_practice_problems_floor_in_a_binary_search_tree.setEditorialLink("https://takeuforward.org/plus/dsa/problems/floor-and-ceil-in-a-bst?tab=editorial");
        
        
        q_binary_search_trees_concept_and_problems_practice_problems_floor_in_a_binary_search_tree.addLink(new QuestionLink("VIDEO", "https://youtu.be/xm_W1ub-K-w"));
        
        q_binary_search_trees_concept_and_problems_practice_problems_floor_in_a_binary_search_tree.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/binary-search-tree/floor-in-a-binary-search-tree/"));
        
        
        topic_14_2.addQuestion(q_binary_search_trees_concept_and_problems_practice_problems_floor_in_a_binary_search_tree);
        
        Question q_binary_search_trees_concept_and_problems_practice_problems_insert_a_given_node_in_bst = new Question("binary_search_trees_concept_and_problems_practice_problems_insert_a_given_node_in_bst", "Insert a given node in BST", "MEDIUM");
        q_binary_search_trees_concept_and_problems_practice_problems_insert_a_given_node_in_bst.setSolveLink("https://leetcode.com/problems/insert-into-a-binary-search-tree/");
        q_binary_search_trees_concept_and_problems_practice_problems_insert_a_given_node_in_bst.setEditorialLink("https://takeuforward.org/plus/dsa/problems/insert-a-given-node-in-bst?tab=editorial");
        
        
        q_binary_search_trees_concept_and_problems_practice_problems_insert_a_given_node_in_bst.addLink(new QuestionLink("VIDEO", "https://youtu.be/FiFiNvM29ps"));
        
        
        topic_14_2.addQuestion(q_binary_search_trees_concept_and_problems_practice_problems_insert_a_given_node_in_bst);
        
        Question q_binary_search_trees_concept_and_problems_practice_problems_delete_a_node_in_bst = new Question("binary_search_trees_concept_and_problems_practice_problems_delete_a_node_in_bst", "Delete a node in BST", "MEDIUM");
        q_binary_search_trees_concept_and_problems_practice_problems_delete_a_node_in_bst.setSolveLink("https://leetcode.com/problems/delete-node-in-a-bst/");
        q_binary_search_trees_concept_and_problems_practice_problems_delete_a_node_in_bst.setEditorialLink("https://takeuforward.org/plus/dsa/problems/delete-a-node-in-bst?tab=editorial");
        
        
        q_binary_search_trees_concept_and_problems_practice_problems_delete_a_node_in_bst.addLink(new QuestionLink("VIDEO", "https://youtu.be/kouxiP_H5WE"));
        
        
        topic_14_2.addQuestion(q_binary_search_trees_concept_and_problems_practice_problems_delete_a_node_in_bst);
        
        Question q_binary_search_trees_concept_and_problems_practice_problems_kth_smallest_and_largest_element_in_bst = new Question("binary_search_trees_concept_and_problems_practice_problems_kth_smallest_and_largest_element_in_bst", "Kth Smallest and Largest element in BST", "MEDIUM");
        q_binary_search_trees_concept_and_problems_practice_problems_kth_smallest_and_largest_element_in_bst.setSolveLink("https://leetcode.com/problems/kth-smallest-element-in-a-bst/");
        q_binary_search_trees_concept_and_problems_practice_problems_kth_smallest_and_largest_element_in_bst.setEditorialLink("https://takeuforward.org/plus/dsa/problems/kth-smallest-and-largest-element-in-bst?tab=editorial");
        
        
        q_binary_search_trees_concept_and_problems_practice_problems_kth_smallest_and_largest_element_in_bst.addLink(new QuestionLink("VIDEO", "https://youtu.be/9TJYWh0adfk"));
        
        q_binary_search_trees_concept_and_problems_practice_problems_kth_smallest_and_largest_element_in_bst.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/kth-largest-smallest-element-in-binary-search-tree/"));
        
        
        topic_14_2.addQuestion(q_binary_search_trees_concept_and_problems_practice_problems_kth_smallest_and_largest_element_in_bst);
        
        Question q_binary_search_trees_concept_and_problems_practice_problems_check_if_a_tree_is_a_bst_or_not = new Question("binary_search_trees_concept_and_problems_practice_problems_check_if_a_tree_is_a_bst_or_not", "Check if a tree is a BST or not", "MEDIUM");
        q_binary_search_trees_concept_and_problems_practice_problems_check_if_a_tree_is_a_bst_or_not.setSolveLink("https://leetcode.com/problems/validate-binary-search-tree/");
        q_binary_search_trees_concept_and_problems_practice_problems_check_if_a_tree_is_a_bst_or_not.setEditorialLink("https://takeuforward.org/plus/dsa/problems/check-if-a-tree-is-a-bst-or-not?tab=editorial");
        
        
        q_binary_search_trees_concept_and_problems_practice_problems_check_if_a_tree_is_a_bst_or_not.addLink(new QuestionLink("VIDEO", "https://youtu.be/f-sj7I5oXEI"));
        
        
        topic_14_2.addQuestion(q_binary_search_trees_concept_and_problems_practice_problems_check_if_a_tree_is_a_bst_or_not);
        
        Question q_binary_search_trees_concept_and_problems_practice_problems_lca_in_bst = new Question("binary_search_trees_concept_and_problems_practice_problems_lca_in_bst", "LCA in BST", "MEDIUM");
        q_binary_search_trees_concept_and_problems_practice_problems_lca_in_bst.setSolveLink("https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/");
        q_binary_search_trees_concept_and_problems_practice_problems_lca_in_bst.setEditorialLink("https://takeuforward.org/plus/dsa/problems/lca-in-bst?tab=editorial");
        
        
        q_binary_search_trees_concept_and_problems_practice_problems_lca_in_bst.addLink(new QuestionLink("VIDEO", "https://youtu.be/cX_kPV_foZc"));
        
        
        topic_14_2.addQuestion(q_binary_search_trees_concept_and_problems_practice_problems_lca_in_bst);
        
        Question q_binary_search_trees_concept_and_problems_practice_problems_construct_a_bst_from_a_preorder_traversal = new Question("binary_search_trees_concept_and_problems_practice_problems_construct_a_bst_from_a_preorder_traversal", "Construct a BST from a preorder traversal", "MEDIUM");
        q_binary_search_trees_concept_and_problems_practice_problems_construct_a_bst_from_a_preorder_traversal.setSolveLink("https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/");
        q_binary_search_trees_concept_and_problems_practice_problems_construct_a_bst_from_a_preorder_traversal.setEditorialLink("https://takeuforward.org/plus/dsa/problems/construct-a-bst-from-a-preorder-traversal?tab=editorial");
        
        
        q_binary_search_trees_concept_and_problems_practice_problems_construct_a_bst_from_a_preorder_traversal.addLink(new QuestionLink("VIDEO", "https://youtu.be/UmJT3j26t1I"));
        
        
        topic_14_2.addQuestion(q_binary_search_trees_concept_and_problems_practice_problems_construct_a_bst_from_a_preorder_traversal);
        
        Question q_binary_search_trees_concept_and_problems_practice_problems_inorder_successorpredecessor_in_bst = new Question("binary_search_trees_concept_and_problems_practice_problems_inorder_successorpredecessor_in_bst", "Inorder Successor/Predecessor in BST", "MEDIUM");
        q_binary_search_trees_concept_and_problems_practice_problems_inorder_successorpredecessor_in_bst.setSolveLink("https://leetcode.com/problems/inorder-successor-in-bst/");
        q_binary_search_trees_concept_and_problems_practice_problems_inorder_successorpredecessor_in_bst.setEditorialLink("https://takeuforward.org/plus/dsa/problems/inorder-successor-and-predecessor-in-bst?tab=editorial");
        
        
        q_binary_search_trees_concept_and_problems_practice_problems_inorder_successorpredecessor_in_bst.addLink(new QuestionLink("VIDEO", "https://youtu.be/SXKAD2svfmI"));
        
        q_binary_search_trees_concept_and_problems_practice_problems_inorder_successorpredecessor_in_bst.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/inorder-successorpredecessor-in-bst"));
        
        
        topic_14_2.addQuestion(q_binary_search_trees_concept_and_problems_practice_problems_inorder_successorpredecessor_in_bst);
        
        Question q_binary_search_trees_concept_and_problems_practice_problems_merge_2_bsts = new Question("binary_search_trees_concept_and_problems_practice_problems_merge_2_bsts", "Merge 2 BST's", "HARD");
        q_binary_search_trees_concept_and_problems_practice_problems_merge_2_bsts.setSolveLink("https://leetcode.com/problems/binary-search-tree-iterator/");
        q_binary_search_trees_concept_and_problems_practice_problems_merge_2_bsts.setEditorialLink("https://takeuforward.org/plus/dsa/problems/bst-iterator?tab=editorial");
        
        
        q_binary_search_trees_concept_and_problems_practice_problems_merge_2_bsts.addLink(new QuestionLink("VIDEO", "https://youtu.be/D2jMcmxU4bs"));
        
        q_binary_search_trees_concept_and_problems_practice_problems_merge_2_bsts.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/bst-iterator"));
        
        
        topic_14_2.addQuestion(q_binary_search_trees_concept_and_problems_practice_problems_merge_2_bsts);
        
        Question q_binary_search_trees_concept_and_problems_practice_problems_two_sum_in_bst_check_if_there_exists_a_pair_with_sum_k = new Question("binary_search_trees_concept_and_problems_practice_problems_two_sum_in_bst_check_if_there_exists_a_pair_with_sum_k", "Two Sum In BST | Check if there exists a pair with Sum K", "HARD");
        q_binary_search_trees_concept_and_problems_practice_problems_two_sum_in_bst_check_if_there_exists_a_pair_with_sum_k.setSolveLink("https://leetcode.com/problems/two-sum-iv-input-is-a-bst/");
        q_binary_search_trees_concept_and_problems_practice_problems_two_sum_in_bst_check_if_there_exists_a_pair_with_sum_k.setEditorialLink("https://takeuforward.org/plus/dsa/problems/two-sum-in-bst?tab=editorial");
        
        
        q_binary_search_trees_concept_and_problems_practice_problems_two_sum_in_bst_check_if_there_exists_a_pair_with_sum_k.addLink(new QuestionLink("VIDEO", "https://youtu.be/ssL3sHwPeb4"));
        
        q_binary_search_trees_concept_and_problems_practice_problems_two_sum_in_bst_check_if_there_exists_a_pair_with_sum_k.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/two-sum-in-bst-check-if-there-exists-a-pair-with-sum-k"));
        
        
        topic_14_2.addQuestion(q_binary_search_trees_concept_and_problems_practice_problems_two_sum_in_bst_check_if_there_exists_a_pair_with_sum_k);
        
        Question q_binary_search_trees_concept_and_problems_practice_problems_correct_bst_with_two_nodes_swapped = new Question("binary_search_trees_concept_and_problems_practice_problems_correct_bst_with_two_nodes_swapped", "Correct BST with two nodes swapped", "HARD");
        q_binary_search_trees_concept_and_problems_practice_problems_correct_bst_with_two_nodes_swapped.setSolveLink("https://leetcode.com/problems/recover-binary-search-tree/");
        q_binary_search_trees_concept_and_problems_practice_problems_correct_bst_with_two_nodes_swapped.setEditorialLink("https://takeuforward.org/plus/dsa/problems/correct-bst-with-two-nodes-swapped?tab=editorial");
        
        
        q_binary_search_trees_concept_and_problems_practice_problems_correct_bst_with_two_nodes_swapped.addLink(new QuestionLink("VIDEO", "https://youtu.be/ZWGW7FminDM"));
        
        
        topic_14_2.addQuestion(q_binary_search_trees_concept_and_problems_practice_problems_correct_bst_with_two_nodes_swapped);
        
        Question q_binary_search_trees_concept_and_problems_practice_problems_largest_bst_in_binary_tree = new Question("binary_search_trees_concept_and_problems_practice_problems_largest_bst_in_binary_tree", "Largest BST in Binary Tree", "HARD");
        q_binary_search_trees_concept_and_problems_practice_problems_largest_bst_in_binary_tree.setSolveLink("https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/");
        q_binary_search_trees_concept_and_problems_practice_problems_largest_bst_in_binary_tree.setEditorialLink("https://takeuforward.org/plus/dsa/problems/largest-bst-in-binary-tree?tab=editorial");
        
        
        q_binary_search_trees_concept_and_problems_practice_problems_largest_bst_in_binary_tree.addLink(new QuestionLink("VIDEO", "https://youtu.be/X0oXMdtUDwo"));
        
        
        topic_14_2.addQuestion(q_binary_search_trees_concept_and_problems_practice_problems_largest_bst_in_binary_tree);
        
        
        section_14.addTopic(topic_14_2);
        
        
        Roadmap.addSection(section_14);
        
        // ==========================================
        // Section: Graphs [Concepts & Problems]
        // ==========================================
        RoadmapSection section_15 = new RoadmapSection("graphs_concepts_problems", "Graphs [Concepts & Problems]");
        
        
        
        // Topic: Learning
        Topic topic_15_1 = new Topic("graphs_concepts_problems_learning", "Learning");
        
        
        
        Question q_graphs_concepts_problems_learning_introduction_to_graph = new Question("graphs_concepts_problems_learning_introduction_to_graph", "Introduction to Graph", "EASY");
        q_graphs_concepts_problems_learning_introduction_to_graph.setSolveLink("https://takeuforward.org/plus/dsa/problems/introduction-to-graph");
        q_graphs_concepts_problems_learning_introduction_to_graph.setEditorialLink("https://takeuforward.org/plus/dsa/problems/introduction-to-graph?tab=editorial");
        
        
        q_graphs_concepts_problems_learning_introduction_to_graph.addLink(new QuestionLink("VIDEO", "https://youtu.be/3oI-34aPMWM"));
        
        q_graphs_concepts_problems_learning_introduction_to_graph.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/graph-representation-in-java"));
        
        
        topic_15_1.addQuestion(q_graphs_concepts_problems_learning_introduction_to_graph);
        
        Question q_graphs_concepts_problems_learning_graph_representation_c = new Question("graphs_concepts_problems_learning_graph_representation_c", "Graph Representation | C++", "EASY");
        q_graphs_concepts_problems_learning_graph_representation_c.setSolveLink("https://takeuforward.org/plus/dsa/problems/introduction-to-graph");
        q_graphs_concepts_problems_learning_graph_representation_c.setEditorialLink("https://takeuforward.org/plus/dsa/problems/introduction-to-graph?tab=editorial");
        
        
        q_graphs_concepts_problems_learning_graph_representation_c.addLink(new QuestionLink("VIDEO", "https://youtu.be/3oI-34aPMWM"));
        
        q_graphs_concepts_problems_learning_graph_representation_c.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/graph/graph-representation-in-c/"));
        
        
        topic_15_1.addQuestion(q_graphs_concepts_problems_learning_graph_representation_c);
        
        Question q_graphs_concepts_problems_learning_graph_representation_java = new Question("graphs_concepts_problems_learning_graph_representation_java", "Graph Representation | Java", "EASY");
        q_graphs_concepts_problems_learning_graph_representation_java.setSolveLink("https://takeuforward.org/plus/dsa/problems/introduction-to-graph");
        q_graphs_concepts_problems_learning_graph_representation_java.setEditorialLink("https://takeuforward.org/plus/dsa/problems/introduction-to-graph?tab=editorial");
        
        
        q_graphs_concepts_problems_learning_graph_representation_java.addLink(new QuestionLink("VIDEO", "https://youtu.be/3oI-34aPMWM"));
        
        q_graphs_concepts_problems_learning_graph_representation_java.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/graph-representation-in-java"));
        
        
        topic_15_1.addQuestion(q_graphs_concepts_problems_learning_graph_representation_java);
        
        Question q_graphs_concepts_problems_learning_connected_components = new Question("graphs_concepts_problems_learning_connected_components", "Connected Components", "MEDIUM");
        q_graphs_concepts_problems_learning_connected_components.setSolveLink("https://takeuforward.org/plus/dsa/problems/connected-components");
        q_graphs_concepts_problems_learning_connected_components.setEditorialLink("https://takeuforward.org/plus/dsa/problems/connected-components?tab=editorial");
        
        
        q_graphs_concepts_problems_learning_connected_components.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/connected-components"));
        
        
        topic_15_1.addQuestion(q_graphs_concepts_problems_learning_connected_components);
        
        Question q_graphs_concepts_problems_learning_traversal_techniques = new Question("graphs_concepts_problems_learning_traversal_techniques", "Traversal Techniques", "MEDIUM");
        q_graphs_concepts_problems_learning_traversal_techniques.setSolveLink("https://takeuforward.org/plus/dsa/problems/traversal-techniques");
        q_graphs_concepts_problems_learning_traversal_techniques.setEditorialLink("https://takeuforward.org/plus/dsa/problems/traversal-techniques?tab=editorial");
        
        
        q_graphs_concepts_problems_learning_traversal_techniques.addLink(new QuestionLink("VIDEO", "https://youtu.be/Qzf1a--rhp8"));
        
        q_graphs_concepts_problems_learning_traversal_techniques.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/depth-first-search-dfs/"));
        
        
        topic_15_1.addQuestion(q_graphs_concepts_problems_learning_traversal_techniques);
        
        Question q_graphs_concepts_problems_learning_dfs = new Question("graphs_concepts_problems_learning_dfs", "DFS", "MEDIUM");
        q_graphs_concepts_problems_learning_dfs.setSolveLink("https://takeuforward.org/plus/dsa/problems/traversal-techniques");
        q_graphs_concepts_problems_learning_dfs.setEditorialLink("https://takeuforward.org/plus/dsa/problems/traversal-techniques?tab=editorial");
        
        
        q_graphs_concepts_problems_learning_dfs.addLink(new QuestionLink("VIDEO", "https://youtu.be/Qzf1a--rhp8"));
        
        q_graphs_concepts_problems_learning_dfs.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/depth-first-search-dfs/"));
        
        
        topic_15_1.addQuestion(q_graphs_concepts_problems_learning_dfs);
        
        
        section_15.addTopic(topic_15_1);
        
        // Topic: Problems on BFS/DFS
        Topic topic_15_2 = new Topic("graphs_concepts_problems_problems_on_bfsdfs", "Problems on BFS/DFS");
        
        
        
        Question q_graphs_concepts_problems_problems_on_bfsdfs_number_of_provinces = new Question("graphs_concepts_problems_problems_on_bfsdfs_number_of_provinces", "Number of provinces", "MEDIUM");
        q_graphs_concepts_problems_problems_on_bfsdfs_number_of_provinces.setSolveLink("https://leetcode.com/problems/number-of-provinces/#:~:text=A%20province%20is%20a%20group,the%20total%20number%20of%20provinces.");
        q_graphs_concepts_problems_problems_on_bfsdfs_number_of_provinces.setEditorialLink("https://takeuforward.org/plus/dsa/problems/number-of-provinces?tab=editorial");
        
        
        q_graphs_concepts_problems_problems_on_bfsdfs_number_of_provinces.addLink(new QuestionLink("VIDEO", "https://youtu.be/ACzkVtewUYA"));
        
        q_graphs_concepts_problems_problems_on_bfsdfs_number_of_provinces.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/number-of-provinces/"));
        
        
        topic_15_2.addQuestion(q_graphs_concepts_problems_problems_on_bfsdfs_number_of_provinces);
        
        Question q_graphs_concepts_problems_problems_on_bfsdfs_connected_components_problem_in_matrix = new Question("graphs_concepts_problems_problems_on_bfsdfs_connected_components_problem_in_matrix", "Connected Components Problem in Matrix", "MEDIUM");
        q_graphs_concepts_problems_problems_on_bfsdfs_connected_components_problem_in_matrix.setSolveLink("https://takeuforward.org/plus/dsa/problems/connected-components");
        q_graphs_concepts_problems_problems_on_bfsdfs_connected_components_problem_in_matrix.setEditorialLink("https://takeuforward.org/plus/dsa/problems/connected-components?tab=editorial");
        
        
        q_graphs_concepts_problems_problems_on_bfsdfs_connected_components_problem_in_matrix.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/connected-components"));
        
        
        topic_15_2.addQuestion(q_graphs_concepts_problems_problems_on_bfsdfs_connected_components_problem_in_matrix);
        
        Question q_graphs_concepts_problems_problems_on_bfsdfs_rotten_oranges = new Question("graphs_concepts_problems_problems_on_bfsdfs_rotten_oranges", "Rotten Oranges", "MEDIUM");
        q_graphs_concepts_problems_problems_on_bfsdfs_rotten_oranges.setSolveLink("https://leetcode.com/problems/rotting-oranges/");
        q_graphs_concepts_problems_problems_on_bfsdfs_rotten_oranges.setEditorialLink("https://takeuforward.org/plus/dsa/problems/rotten-oranges?tab=editorial");
        
        
        q_graphs_concepts_problems_problems_on_bfsdfs_rotten_oranges.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=yf3oUhkvqA0"));
        
        q_graphs_concepts_problems_problems_on_bfsdfs_rotten_oranges.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/rotten-oranges-min-time-to-rot-all-oranges-bfs/"));
        
        
        topic_15_2.addQuestion(q_graphs_concepts_problems_problems_on_bfsdfs_rotten_oranges);
        
        Question q_graphs_concepts_problems_problems_on_bfsdfs_flood_fill_algorithm = new Question("graphs_concepts_problems_problems_on_bfsdfs_flood_fill_algorithm", "Flood fill algorithm", "MEDIUM");
        q_graphs_concepts_problems_problems_on_bfsdfs_flood_fill_algorithm.setSolveLink("https://leetcode.com/problems/flood-fill/");
        q_graphs_concepts_problems_problems_on_bfsdfs_flood_fill_algorithm.setEditorialLink("https://takeuforward.org/plus/dsa/problems/flood-fill-algorithm?tab=editorial");
        
        
        
        topic_15_2.addQuestion(q_graphs_concepts_problems_problems_on_bfsdfs_flood_fill_algorithm);
        
        Question q_graphs_concepts_problems_problems_on_bfsdfs_cycle_detection_in_undirected_graph_bfs = new Question("graphs_concepts_problems_problems_on_bfsdfs_cycle_detection_in_undirected_graph_bfs", "Cycle Detection in Undirected Graph (bfs)", "HARD");
        q_graphs_concepts_problems_problems_on_bfsdfs_cycle_detection_in_undirected_graph_bfs.setSolveLink("https://takeuforward.org/plus/dsa/problems/detect-a-cycle-in-an-undirected-graph");
        q_graphs_concepts_problems_problems_on_bfsdfs_cycle_detection_in_undirected_graph_bfs.setEditorialLink("https://takeuforward.org/plus/dsa/problems/detect-a-cycle-in-an-undirected-graph?tab=editorial");
        
        
        q_graphs_concepts_problems_problems_on_bfsdfs_cycle_detection_in_undirected_graph_bfs.addLink(new QuestionLink("VIDEO", "https://youtu.be/BPlrALf1LDU"));
        
        q_graphs_concepts_problems_problems_on_bfsdfs_cycle_detection_in_undirected_graph_bfs.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/detect-cycle-in-an-undirected-graph-using-bfs/"));
        
        
        topic_15_2.addQuestion(q_graphs_concepts_problems_problems_on_bfsdfs_cycle_detection_in_undirected_graph_bfs);
        
        Question q_graphs_concepts_problems_problems_on_bfsdfs_detect_a_cycle_in_an_undirected_graph = new Question("graphs_concepts_problems_problems_on_bfsdfs_detect_a_cycle_in_an_undirected_graph", "Detect a cycle in an undirected graph", "HARD");
        q_graphs_concepts_problems_problems_on_bfsdfs_detect_a_cycle_in_an_undirected_graph.setSolveLink("https://leetcode.com/problems/course-schedule/");
        q_graphs_concepts_problems_problems_on_bfsdfs_detect_a_cycle_in_an_undirected_graph.setEditorialLink("https://takeuforward.org/plus/dsa/problems/detect-a-cycle-in-an-undirected-graph?tab=editorial");
        
        
        q_graphs_concepts_problems_problems_on_bfsdfs_detect_a_cycle_in_an_undirected_graph.addLink(new QuestionLink("VIDEO", "https://youtu.be/zQ3zgFypzX4"));
        
        q_graphs_concepts_problems_problems_on_bfsdfs_detect_a_cycle_in_an_undirected_graph.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/detect-cycle-in-an-undirected-graph-using-dfs/"));
        
        
        topic_15_2.addQuestion(q_graphs_concepts_problems_problems_on_bfsdfs_detect_a_cycle_in_an_undirected_graph);
        
        Question q_graphs_concepts_problems_problems_on_bfsdfs_distance_of_nearest_cell_having_one = new Question("graphs_concepts_problems_problems_on_bfsdfs_distance_of_nearest_cell_having_one", "Distance of nearest cell having one", "MEDIUM");
        q_graphs_concepts_problems_problems_on_bfsdfs_distance_of_nearest_cell_having_one.setSolveLink("https://leetcode.com/problems/01-matrix/");
        q_graphs_concepts_problems_problems_on_bfsdfs_distance_of_nearest_cell_having_one.setEditorialLink("https://takeuforward.org/plus/dsa/problems/distance-of-nearest-cell-having-one?tab=editorial");
        
        
        q_graphs_concepts_problems_problems_on_bfsdfs_distance_of_nearest_cell_having_one.addLink(new QuestionLink("VIDEO", "https://youtu.be/edXdVwkYHF8"));
        
        q_graphs_concepts_problems_problems_on_bfsdfs_distance_of_nearest_cell_having_one.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/graph/distance-of-nearest-cell-having-1/"));
        
        
        topic_15_2.addQuestion(q_graphs_concepts_problems_problems_on_bfsdfs_distance_of_nearest_cell_having_one);
        
        Question q_graphs_concepts_problems_problems_on_bfsdfs_surrounded_regions = new Question("graphs_concepts_problems_problems_on_bfsdfs_surrounded_regions", "Surrounded Regions", "MEDIUM");
        q_graphs_concepts_problems_problems_on_bfsdfs_surrounded_regions.setSolveLink("https://leetcode.com/problems/surrounded-regions/");
        q_graphs_concepts_problems_problems_on_bfsdfs_surrounded_regions.setEditorialLink("https://takeuforward.org/plus/dsa/problems/surrounded-regions?tab=editorial");
        
        
        q_graphs_concepts_problems_problems_on_bfsdfs_surrounded_regions.addLink(new QuestionLink("VIDEO", "https://youtu.be/BtdgAys4yMk"));
        
        q_graphs_concepts_problems_problems_on_bfsdfs_surrounded_regions.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/graph/surrounded-regions-replace-os-with-xs/"));
        
        
        topic_15_2.addQuestion(q_graphs_concepts_problems_problems_on_bfsdfs_surrounded_regions);
        
        Question q_graphs_concepts_problems_problems_on_bfsdfs_number_of_enclaves = new Question("graphs_concepts_problems_problems_on_bfsdfs_number_of_enclaves", "Number of enclaves", "MEDIUM");
        q_graphs_concepts_problems_problems_on_bfsdfs_number_of_enclaves.setSolveLink("https://leetcode.com/problems/number-of-enclaves/");
        q_graphs_concepts_problems_problems_on_bfsdfs_number_of_enclaves.setEditorialLink("https://takeuforward.org/plus/dsa/problems/number-of-enclaves?tab=editorial");
        
        
        q_graphs_concepts_problems_problems_on_bfsdfs_number_of_enclaves.addLink(new QuestionLink("VIDEO", "https://youtu.be/rxKcepXQgU4"));
        
        q_graphs_concepts_problems_problems_on_bfsdfs_number_of_enclaves.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/graph/number-of-enclaves/"));
        
        
        topic_15_2.addQuestion(q_graphs_concepts_problems_problems_on_bfsdfs_number_of_enclaves);
        
        Question q_graphs_concepts_problems_problems_on_bfsdfs_word_ladder_i = new Question("graphs_concepts_problems_problems_on_bfsdfs_word_ladder_i", "Word ladder I", "HARD");
        q_graphs_concepts_problems_problems_on_bfsdfs_word_ladder_i.setSolveLink("https://leetcode.com/problems/word-ladder/");
        q_graphs_concepts_problems_problems_on_bfsdfs_word_ladder_i.setEditorialLink("https://takeuforward.org/plus/dsa/problems/word-ladder-i?tab=editorial");
        
        
        q_graphs_concepts_problems_problems_on_bfsdfs_word_ladder_i.addLink(new QuestionLink("VIDEO", "https://youtu.be/tRPda0rcf8E"));
        
        q_graphs_concepts_problems_problems_on_bfsdfs_word_ladder_i.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/graph/word-ladder-i-g-29/"));
        
        
        topic_15_2.addQuestion(q_graphs_concepts_problems_problems_on_bfsdfs_word_ladder_i);
        
        Question q_graphs_concepts_problems_problems_on_bfsdfs_word_ladder_ii = new Question("graphs_concepts_problems_problems_on_bfsdfs_word_ladder_ii", "Word ladder II", "HARD");
        q_graphs_concepts_problems_problems_on_bfsdfs_word_ladder_ii.setSolveLink("https://leetcode.com/problems/word-ladder-ii/");
        q_graphs_concepts_problems_problems_on_bfsdfs_word_ladder_ii.setEditorialLink("https://takeuforward.org/plus/dsa/problems/word-ladder-ii?tab=editorial");
        
        
        q_graphs_concepts_problems_problems_on_bfsdfs_word_ladder_ii.addLink(new QuestionLink("VIDEO", "https://youtu.be/AD4SFl7tu7I?si=EpcJQTWm2YeURvEG"));
        
        q_graphs_concepts_problems_problems_on_bfsdfs_word_ladder_ii.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/graph/g-30-word-ladder-ii/"));
        
        
        topic_15_2.addQuestion(q_graphs_concepts_problems_problems_on_bfsdfs_word_ladder_ii);
        
        Question q_graphs_concepts_problems_problems_on_bfsdfs_number_of_islands = new Question("graphs_concepts_problems_problems_on_bfsdfs_number_of_islands", "Number of islands", "MEDIUM");
        q_graphs_concepts_problems_problems_on_bfsdfs_number_of_islands.setSolveLink("https://leetcode.com/problems/number-of-islands/");
        q_graphs_concepts_problems_problems_on_bfsdfs_number_of_islands.setEditorialLink("https://takeuforward.org/plus/dsa/problems/number-of-islands?tab=editorial");
        
        
        q_graphs_concepts_problems_problems_on_bfsdfs_number_of_islands.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=muncqlKJrH0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=8"));
        
        q_graphs_concepts_problems_problems_on_bfsdfs_number_of_islands.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/number-of-distinct-islands/"));
        
        
        topic_15_2.addQuestion(q_graphs_concepts_problems_problems_on_bfsdfs_number_of_islands);
        
        Question q_graphs_concepts_problems_problems_on_bfsdfs_bipartite_graph_dfs = new Question("graphs_concepts_problems_problems_on_bfsdfs_bipartite_graph_dfs", "Bipartite Graph (DFS)", "HARD");
        q_graphs_concepts_problems_problems_on_bfsdfs_bipartite_graph_dfs.setSolveLink("https://leetcode.com/problems/is-graph-bipartite/");
        q_graphs_concepts_problems_problems_on_bfsdfs_bipartite_graph_dfs.setEditorialLink("https://takeuforward.org/plus/dsa/problems/bipartite-graph?tab=editorial");
        
        
        q_graphs_concepts_problems_problems_on_bfsdfs_bipartite_graph_dfs.addLink(new QuestionLink("VIDEO", "https://youtu.be/KG5YFfR0j8A"));
        
        q_graphs_concepts_problems_problems_on_bfsdfs_bipartite_graph_dfs.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/graph/bipartite-graph-dfs-implementation/"));
        
        
        topic_15_2.addQuestion(q_graphs_concepts_problems_problems_on_bfsdfs_bipartite_graph_dfs);
        
        Question q_graphs_concepts_problems_problems_on_bfsdfs_cycle_detection_in_directed_graph_dfs = new Question("graphs_concepts_problems_problems_on_bfsdfs_cycle_detection_in_directed_graph_dfs", "Cycle Detection in Directed Graph (DFS)", "HARD");
        q_graphs_concepts_problems_problems_on_bfsdfs_cycle_detection_in_directed_graph_dfs.setSolveLink("https://leetcode.com/problems/course-schedule-ii/discuss/293048/detecting-cycle-in-directed-graph-problem");
        q_graphs_concepts_problems_problems_on_bfsdfs_cycle_detection_in_directed_graph_dfs.setEditorialLink("https://takeuforward.org/plus/dsa/problems/detect-a-cycle-in-a-directed-graph?tab=editorial");
        
        
        q_graphs_concepts_problems_problems_on_bfsdfs_cycle_detection_in_directed_graph_dfs.addLink(new QuestionLink("VIDEO", "https://youtu.be/9twcmtQj4DU"));
        
        q_graphs_concepts_problems_problems_on_bfsdfs_cycle_detection_in_directed_graph_dfs.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/detect-cycle-in-a-directed-graph-using-dfs-g-19/"));
        
        
        topic_15_2.addQuestion(q_graphs_concepts_problems_problems_on_bfsdfs_cycle_detection_in_directed_graph_dfs);
        
        
        section_15.addTopic(topic_15_2);
        
        // Topic: Topo Sort and Problems
        Topic topic_15_3 = new Topic("graphs_concepts_problems_topo_sort_and_problems", "Topo Sort and Problems");
        
        
        
        Question q_graphs_concepts_problems_topo_sort_and_problems_topo_sort = new Question("graphs_concepts_problems_topo_sort_and_problems_topo_sort", "Topo Sort", "HARD");
        q_graphs_concepts_problems_topo_sort_and_problems_topo_sort.setSolveLink("https://takeuforward.org/plus/dsa/problems/topological-sort-or-kahns-algorithm");
        q_graphs_concepts_problems_topo_sort_and_problems_topo_sort.setEditorialLink("https://takeuforward.org/plus/dsa/problems/topological-sort-or-kahns-algorithm?tab=editorial");
        
        
        q_graphs_concepts_problems_topo_sort_and_problems_topo_sort.addLink(new QuestionLink("VIDEO", "https://youtu.be/5lZ0iJMrUMk"));
        
        q_graphs_concepts_problems_topo_sort_and_problems_topo_sort.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/topological-sort-algorithm-dfs-g-21/"));
        
        
        topic_15_3.addQuestion(q_graphs_concepts_problems_topo_sort_and_problems_topo_sort);
        
        Question q_graphs_concepts_problems_topo_sort_and_problems_topological_sort_or_kahns_algorithm = new Question("graphs_concepts_problems_topo_sort_and_problems_topological_sort_or_kahns_algorithm", "Topological sort or Kahn's algorithm", "HARD");
        q_graphs_concepts_problems_topo_sort_and_problems_topological_sort_or_kahns_algorithm.setSolveLink("https://takeuforward.org/plus/dsa/problems/topological-sort-or-kahns-algorithm");
        q_graphs_concepts_problems_topo_sort_and_problems_topological_sort_or_kahns_algorithm.setEditorialLink("https://takeuforward.org/plus/dsa/problems/topological-sort-or-kahns-algorithm?tab=editorial");
        
        
        q_graphs_concepts_problems_topo_sort_and_problems_topological_sort_or_kahns_algorithm.addLink(new QuestionLink("VIDEO", "https://youtu.be/5lZ0iJMrUMk"));
        
        q_graphs_concepts_problems_topo_sort_and_problems_topological_sort_or_kahns_algorithm.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/topological-sort-algorithm-dfs-g-21/"));
        
        
        topic_15_3.addQuestion(q_graphs_concepts_problems_topo_sort_and_problems_topological_sort_or_kahns_algorithm);
        
        Question q_graphs_concepts_problems_topo_sort_and_problems_detect_a_cycle_in_a_directed_graph = new Question("graphs_concepts_problems_topo_sort_and_problems_detect_a_cycle_in_a_directed_graph", "Detect a cycle in a directed graph", "HARD");
        q_graphs_concepts_problems_topo_sort_and_problems_detect_a_cycle_in_a_directed_graph.setSolveLink("https://leetcode.com/problems/course-schedule/");
        q_graphs_concepts_problems_topo_sort_and_problems_detect_a_cycle_in_a_directed_graph.setEditorialLink("https://takeuforward.org/plus/dsa/problems/detect-a-cycle-in-a-directed-graph?tab=editorial");
        
        
        q_graphs_concepts_problems_topo_sort_and_problems_detect_a_cycle_in_a_directed_graph.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=uzVUw90ZFIg&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=12"));
        
        q_graphs_concepts_problems_topo_sort_and_problems_detect_a_cycle_in_a_directed_graph.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/detect-a-cycle-in-directed-graph-topological-sort-kahns-algorithm-g-23/"));
        
        
        topic_15_3.addQuestion(q_graphs_concepts_problems_topo_sort_and_problems_detect_a_cycle_in_a_directed_graph);
        
        Question q_graphs_concepts_problems_topo_sort_and_problems_course_schedule_i = new Question("graphs_concepts_problems_topo_sort_and_problems_course_schedule_i", "Course Schedule I", "HARD");
        q_graphs_concepts_problems_topo_sort_and_problems_course_schedule_i.setSolveLink("https://leetcode.com/problems/course-schedule/");
        q_graphs_concepts_problems_topo_sort_and_problems_course_schedule_i.setEditorialLink("https://takeuforward.org/plus/dsa/problems/course-schedule-i?tab=editorial");
        
        
        q_graphs_concepts_problems_topo_sort_and_problems_course_schedule_i.addLink(new QuestionLink("VIDEO", "https://youtu.be/WAOfKpxYHR8"));
        
        q_graphs_concepts_problems_topo_sort_and_problems_course_schedule_i.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/course-schedule-i-and-ii-pre-requisite-tasks-topological-sort-g-24/"));
        
        
        topic_15_3.addQuestion(q_graphs_concepts_problems_topo_sort_and_problems_course_schedule_i);
        
        Question q_graphs_concepts_problems_topo_sort_and_problems_course_schedule_ii = new Question("graphs_concepts_problems_topo_sort_and_problems_course_schedule_ii", "Course Schedule II", "MEDIUM");
        q_graphs_concepts_problems_topo_sort_and_problems_course_schedule_ii.setSolveLink("https://leetcode.com/problems/course-schedule-ii/");
        q_graphs_concepts_problems_topo_sort_and_problems_course_schedule_ii.setEditorialLink("https://takeuforward.org/plus/dsa/problems/course-schedule-ii?tab=editorial");
        
        
        q_graphs_concepts_problems_topo_sort_and_problems_course_schedule_ii.addLink(new QuestionLink("VIDEO", "https://youtu.be/WAOfKpxYHR8"));
        
        q_graphs_concepts_problems_topo_sort_and_problems_course_schedule_ii.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/course-schedule-i-and-ii-pre-requisite-tasks-topological-sort-g-24/"));
        
        
        topic_15_3.addQuestion(q_graphs_concepts_problems_topo_sort_and_problems_course_schedule_ii);
        
        Question q_graphs_concepts_problems_topo_sort_and_problems_find_eventual_safe_states = new Question("graphs_concepts_problems_topo_sort_and_problems_find_eventual_safe_states", "Find eventual safe states", "HARD");
        q_graphs_concepts_problems_topo_sort_and_problems_find_eventual_safe_states.setSolveLink("https://leetcode.com/problems/find-eventual-safe-states/");
        q_graphs_concepts_problems_topo_sort_and_problems_find_eventual_safe_states.setEditorialLink("https://takeuforward.org/plus/dsa/problems/find-eventual-safe-states?tab=editorial");
        
        
        q_graphs_concepts_problems_topo_sort_and_problems_find_eventual_safe_states.addLink(new QuestionLink("VIDEO", "https://youtu.be/2gtg3VsDGyc"));
        
        q_graphs_concepts_problems_topo_sort_and_problems_find_eventual_safe_states.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/find-eventual-safe-states-bfs-topological-sort-g-25/"));
        
        
        topic_15_3.addQuestion(q_graphs_concepts_problems_topo_sort_and_problems_find_eventual_safe_states);
        
        Question q_graphs_concepts_problems_topo_sort_and_problems_alien_dictionary = new Question("graphs_concepts_problems_topo_sort_and_problems_alien_dictionary", "Alien Dictionary", "HARD");
        q_graphs_concepts_problems_topo_sort_and_problems_alien_dictionary.setSolveLink("https://leetcode.com/problems/alien-dictionary/solution/");
        q_graphs_concepts_problems_topo_sort_and_problems_alien_dictionary.setEditorialLink("https://takeuforward.org/plus/dsa/problems/alient-dictionary?tab=editorial");
        
        
        q_graphs_concepts_problems_topo_sort_and_problems_alien_dictionary.addLink(new QuestionLink("VIDEO", "https://youtu.be/U3N_je7tWAs"));
        
        q_graphs_concepts_problems_topo_sort_and_problems_alien_dictionary.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/alien-dictionary-topological-sort-g-26/"));
        
        
        topic_15_3.addQuestion(q_graphs_concepts_problems_topo_sort_and_problems_alien_dictionary);
        
        
        section_15.addTopic(topic_15_3);
        
        // Topic: Shortest Path Algorithms and Problems
        Topic topic_15_4 = new Topic("graphs_concepts_problems_shortest_path_algorithms_and_problems", "Shortest Path Algorithms and Problems");
        
        
        
        Question q_graphs_concepts_problems_shortest_path_algorithms_and_problems_shortest_path_in_undirected_graph_with_unit_weights = new Question("graphs_concepts_problems_shortest_path_algorithms_and_problems_shortest_path_in_undirected_graph_with_unit_weights", "Shortest path in undirected graph with unit weights", "HARD");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_shortest_path_in_undirected_graph_with_unit_weights.setSolveLink("https://takeuforward.org/plus/dsa/problems/shortest-path-in-undirected-graph-with-unit-weights");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_shortest_path_in_undirected_graph_with_unit_weights.setEditorialLink("https://takeuforward.org/plus/dsa/problems/shortest-path-in-undirected-graph-with-unit-weights?tab=editorial");
        
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_shortest_path_in_undirected_graph_with_unit_weights.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=C4gxoTaI71U&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=28"));
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_shortest_path_in_undirected_graph_with_unit_weights.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/shortest-path-in-undirected-graph-with-unit-distance-g-28/"));
        
        
        topic_15_4.addQuestion(q_graphs_concepts_problems_shortest_path_algorithms_and_problems_shortest_path_in_undirected_graph_with_unit_weights);
        
        Question q_graphs_concepts_problems_shortest_path_algorithms_and_problems_shortest_path_in_dag = new Question("graphs_concepts_problems_shortest_path_algorithms_and_problems_shortest_path_in_dag", "Shortest path in DAG", "HARD");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_shortest_path_in_dag.setSolveLink("https://takeuforward.org/plus/dsa/problems/shortest-path-in-dag");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_shortest_path_in_dag.setEditorialLink("https://takeuforward.org/plus/dsa/problems/shortest-path-in-dag?tab=editorial");
        
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_shortest_path_in_dag.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=ZUFQfFaU-8U&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=27"));
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_shortest_path_in_dag.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/shortest-path-in-directed-acyclic-graph-topological-sort-g-27/"));
        
        
        topic_15_4.addQuestion(q_graphs_concepts_problems_shortest_path_algorithms_and_problems_shortest_path_in_dag);
        
        Question q_graphs_concepts_problems_shortest_path_algorithms_and_problems_djisktras_algorithm = new Question("graphs_concepts_problems_shortest_path_algorithms_and_problems_djisktras_algorithm", "Djisktra's Algorithm", "HARD");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_djisktras_algorithm.setSolveLink("https://takeuforward.org/plus/dsa/problems/dijkstra's-algorithm");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_djisktras_algorithm.setEditorialLink("https://takeuforward.org/plus/dsa/problems/dijkstra's-algorithm?tab=editorial");
        
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_djisktras_algorithm.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=rp1SMw7HSO8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=35"));
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_djisktras_algorithm.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/dijkstras-algorithm-using-set-g-33/"));
        
        
        topic_15_4.addQuestion(q_graphs_concepts_problems_shortest_path_algorithms_and_problems_djisktras_algorithm);
        
        Question q_graphs_concepts_problems_shortest_path_algorithms_and_problems_why_priority_queue_is_used_in_djisktras_algorithm = new Question("graphs_concepts_problems_shortest_path_algorithms_and_problems_why_priority_queue_is_used_in_djisktras_algorithm", "Why priority Queue is used in Djisktra's Algorithm", "HARD");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_why_priority_queue_is_used_in_djisktras_algorithm.setSolveLink("https://takeuforward.org/plus/dsa/problems/dijkstra's-algorithm");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_why_priority_queue_is_used_in_djisktras_algorithm.setEditorialLink("https://takeuforward.org/plus/dsa/problems/dijkstra's-algorithm?tab=editorial");
        
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_why_priority_queue_is_used_in_djisktras_algorithm.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=rp1SMw7HSO8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=35"));
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_why_priority_queue_is_used_in_djisktras_algorithm.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/dijkstras-algorithm-using-priority-queue-g-32/"));
        
        
        topic_15_4.addQuestion(q_graphs_concepts_problems_shortest_path_algorithms_and_problems_why_priority_queue_is_used_in_djisktras_algorithm);
        
        Question q_graphs_concepts_problems_shortest_path_algorithms_and_problems_shortest_distance_in_a_binary_maze = new Question("graphs_concepts_problems_shortest_path_algorithms_and_problems_shortest_distance_in_a_binary_maze", "Shortest Distance in a Binary Maze", "HARD");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_shortest_distance_in_a_binary_maze.setSolveLink("https://leetcode.com/problems/shortest-path-in-binary-matrix/");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_shortest_distance_in_a_binary_maze.setEditorialLink("https://takeuforward.org/plus/dsa/problems/shortest-path-with-minimum-effort?tab=editorial");
        
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_shortest_distance_in_a_binary_maze.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=U5Mw4eyUmw4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=36"));
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_shortest_distance_in_a_binary_maze.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/g-36-shortest-distance-in-a-binary-maze/"));
        
        
        topic_15_4.addQuestion(q_graphs_concepts_problems_shortest_path_algorithms_and_problems_shortest_distance_in_a_binary_maze);
        
        Question q_graphs_concepts_problems_shortest_path_algorithms_and_problems_path_with_minimum_effort = new Question("graphs_concepts_problems_shortest_path_algorithms_and_problems_path_with_minimum_effort", "Path with minimum effort", "HARD");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_path_with_minimum_effort.setSolveLink("https://leetcode.com/problems/path-with-minimum-effort/");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_path_with_minimum_effort.setEditorialLink("https://takeuforward.org/plus/dsa/problems/path-with-minimum-effort?tab=editorial");
        
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_path_with_minimum_effort.addLink(new QuestionLink("VIDEO", "https://youtu.be/0ytpZyiZFhA"));
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_path_with_minimum_effort.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/g-37-path-with-minimum-effort/"));
        
        
        topic_15_4.addQuestion(q_graphs_concepts_problems_shortest_path_algorithms_and_problems_path_with_minimum_effort);
        
        Question q_graphs_concepts_problems_shortest_path_algorithms_and_problems_cheapest_flight_within_k_stops = new Question("graphs_concepts_problems_shortest_path_algorithms_and_problems_cheapest_flight_within_k_stops", "Cheapest flight within K stops", "HARD");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_cheapest_flight_within_k_stops.setSolveLink("https://leetcode.com/problems/cheapest-flights-within-k-stops/");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_cheapest_flight_within_k_stops.setEditorialLink("https://takeuforward.org/plus/dsa/problems/cheapest-flight-within-k-stops?tab=editorial");
        
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_cheapest_flight_within_k_stops.addLink(new QuestionLink("VIDEO", "https://youtu.be/9XybHVqTHcQ"));
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_cheapest_flight_within_k_stops.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/g-38-cheapest-flights-within-k-stops/"));
        
        
        topic_15_4.addQuestion(q_graphs_concepts_problems_shortest_path_algorithms_and_problems_cheapest_flight_within_k_stops);
        
        Question q_graphs_concepts_problems_shortest_path_algorithms_and_problems_network_delay_time = new Question("graphs_concepts_problems_shortest_path_algorithms_and_problems_network_delay_time", "Network Delay Time", "MEDIUM");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_network_delay_time.setSolveLink("https://leetcode.com/problems/network-delay-time/");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_network_delay_time.setEditorialLink("https://takeuforward.org/plus/dsa/problems/network-delay-time?tab=editorial");
        
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_network_delay_time.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/network-delay-time"));
        
        
        topic_15_4.addQuestion(q_graphs_concepts_problems_shortest_path_algorithms_and_problems_network_delay_time);
        
        Question q_graphs_concepts_problems_shortest_path_algorithms_and_problems_number_of_ways_to_arrive_at_destination = new Question("graphs_concepts_problems_shortest_path_algorithms_and_problems_number_of_ways_to_arrive_at_destination", "Number of ways to arrive at destination", "HARD");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_number_of_ways_to_arrive_at_destination.setSolveLink("https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_number_of_ways_to_arrive_at_destination.setEditorialLink("https://takeuforward.org/plus/dsa/problems/number-of-ways-to-arrive-at-destination?tab=editorial");
        
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_number_of_ways_to_arrive_at_destination.addLink(new QuestionLink("VIDEO", "https://youtu.be/_-0mx0SmYxA"));
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_number_of_ways_to_arrive_at_destination.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/g-40-number-of-ways-to-arrive-at-destination/"));
        
        
        topic_15_4.addQuestion(q_graphs_concepts_problems_shortest_path_algorithms_and_problems_number_of_ways_to_arrive_at_destination);
        
        Question q_graphs_concepts_problems_shortest_path_algorithms_and_problems_minimum_multiplications_to_reach_end = new Question("graphs_concepts_problems_shortest_path_algorithms_and_problems_minimum_multiplications_to_reach_end", "Minimum multiplications to reach end", "HARD");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_minimum_multiplications_to_reach_end.setSolveLink("https://takeuforward.org/plus/dsa/problems/minimum-multiplications-to-reach-end");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_minimum_multiplications_to_reach_end.setEditorialLink("https://takeuforward.org/plus/dsa/problems/minimum-multiplications-to-reach-end?tab=editorial");
        
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_minimum_multiplications_to_reach_end.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=_BvEJ3VIDWw&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=39"));
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_minimum_multiplications_to_reach_end.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/graph/g-39-minimum-multiplications-to-reach-end/"));
        
        
        topic_15_4.addQuestion(q_graphs_concepts_problems_shortest_path_algorithms_and_problems_minimum_multiplications_to_reach_end);
        
        Question q_graphs_concepts_problems_shortest_path_algorithms_and_problems_bellman_ford_algorithm = new Question("graphs_concepts_problems_shortest_path_algorithms_and_problems_bellman_ford_algorithm", "Bellman Ford Algorithm", "HARD");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_bellman_ford_algorithm.setSolveLink("https://takeuforward.org/plus/dsa/problems/bellman-ford-algorithm");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_bellman_ford_algorithm.setEditorialLink("https://takeuforward.org/plus/dsa/problems/bellman-ford-algorithm?tab=editorial");
        
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_bellman_ford_algorithm.addLink(new QuestionLink("VIDEO", "https://youtu.be/0vVofAhAYjc"));
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_bellman_ford_algorithm.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/bellman-ford-algorithm-g-41/"));
        
        
        topic_15_4.addQuestion(q_graphs_concepts_problems_shortest_path_algorithms_and_problems_bellman_ford_algorithm);
        
        Question q_graphs_concepts_problems_shortest_path_algorithms_and_problems_floyd_warshall_algorithm = new Question("graphs_concepts_problems_shortest_path_algorithms_and_problems_floyd_warshall_algorithm", "Floyd warshall algorithm", "HARD");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_floyd_warshall_algorithm.setSolveLink("https://takeuforward.org/plus/dsa/problems/floyd-warshall-algorithm");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_floyd_warshall_algorithm.setEditorialLink("https://takeuforward.org/plus/dsa/problems/floyd-warshall-algorithm?tab=editorial");
        
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_floyd_warshall_algorithm.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=YbY8cVwWAvw&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=42"));
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_floyd_warshall_algorithm.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/floyd-warshall-algorithm-g-42/"));
        
        
        topic_15_4.addQuestion(q_graphs_concepts_problems_shortest_path_algorithms_and_problems_floyd_warshall_algorithm);
        
        Question q_graphs_concepts_problems_shortest_path_algorithms_and_problems_find_the_city_with_the_smallest_number_of_neighbors = new Question("graphs_concepts_problems_shortest_path_algorithms_and_problems_find_the_city_with_the_smallest_number_of_neighbors", "Find the city with the smallest number of neighbors", "HARD");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_find_the_city_with_the_smallest_number_of_neighbors.setSolveLink("https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/");
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_find_the_city_with_the_smallest_number_of_neighbors.setEditorialLink("https://takeuforward.org/plus/dsa/problems/find-the-city-with-the-smallest-number-of-neighbors?tab=editorial");
        
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_find_the_city_with_the_smallest_number_of_neighbors.addLink(new QuestionLink("VIDEO", "https://youtu.be/9XybHVqTHcQ"));
        
        q_graphs_concepts_problems_shortest_path_algorithms_and_problems_find_the_city_with_the_smallest_number_of_neighbors.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/find-the-city-with-the-smallest-number-of-neighbours-at-a-threshold-distance-g-43/"));
        
        
        topic_15_4.addQuestion(q_graphs_concepts_problems_shortest_path_algorithms_and_problems_find_the_city_with_the_smallest_number_of_neighbors);
        
        
        section_15.addTopic(topic_15_4);
        
        // Topic: MinimumSpanningTree/Disjoint Set and Problems
        Topic topic_15_5 = new Topic("graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems", "MinimumSpanningTree/Disjoint Set and Problems");
        
        
        
        Question q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_mst_theory = new Question("graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_mst_theory", "MST theory", "EASY");
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_mst_theory.setSolveLink("https://takeuforward.org/plus/dsa/problems/mst-theory");
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_mst_theory.setEditorialLink("https://takeuforward.org/plus/dsa/problems/mst-theory?tab=editorial");
        
        
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_mst_theory.addLink(new QuestionLink("VIDEO", "https://youtu.be/ZSPjZuZWCME"));
        
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_mst_theory.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/minimum-spanning-tree-theory-g-44/"));
        
        
        topic_15_5.addQuestion(q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_mst_theory);
        
        Question q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_prims_algorithm = new Question("graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_prims_algorithm", "Prim's Algorithm", "HARD");
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_prims_algorithm.setSolveLink("https://takeuforward.org/plus/dsa/problems/find-the-mst-weight");
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_prims_algorithm.setEditorialLink("https://takeuforward.org/plus/dsa/problems/find-the-mst-weight?tab=editorial");
        
        
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_prims_algorithm.addLink(new QuestionLink("VIDEO", "https://youtu.be/mJcZjjKzeqk"));
        
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_prims_algorithm.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/prims-algorithm-minimum-spanning-tree-c-and-java-g-45/"));
        
        
        topic_15_5.addQuestion(q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_prims_algorithm);
        
        Question q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_disjoint_set = new Question("graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_disjoint_set", "Disjoint Set ", "HARD");
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_disjoint_set.setSolveLink("https://takeuforward.org/plus/dsa/problems/disjoint-set-");
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_disjoint_set.setEditorialLink("https://takeuforward.org/plus/dsa/problems/disjoint-set-?tab=editorial");
        
        
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_disjoint_set.addLink(new QuestionLink("VIDEO", "https://youtu.be/aBxjDBC4M1U"));
        
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_disjoint_set.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/disjoint-set-union-by-rank-union-by-size-path-compression-g-46/"));
        
        
        topic_15_5.addQuestion(q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_disjoint_set);
        
        Question q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_find_the_mst_weight = new Question("graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_find_the_mst_weight", "Find the MST weight", "HARD");
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_find_the_mst_weight.setSolveLink("https://takeuforward.org/plus/dsa/problems/find-the-mst-weight");
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_find_the_mst_weight.setEditorialLink("https://takeuforward.org/plus/dsa/problems/find-the-mst-weight?tab=editorial");
        
        
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_find_the_mst_weight.addLink(new QuestionLink("VIDEO", "https://youtu.be/mJcZjjKzeqk"));
        
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_find_the_mst_weight.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/prims-algorithm-minimum-spanning-tree-c-and-java-g-45/"));
        
        
        topic_15_5.addQuestion(q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_find_the_mst_weight);
        
        Question q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_number_of_operations_to_make_network_connected = new Question("graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_number_of_operations_to_make_network_connected", "Number of operations to make network connected", "HARD");
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_number_of_operations_to_make_network_connected.setSolveLink("https://leetcode.com/problems/number-of-operations-to-make-network-connected/");
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_number_of_operations_to_make_network_connected.setEditorialLink("https://takeuforward.org/plus/dsa/problems/number-of-operations-to-make-network-connected?tab=editorial");
        
        
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_number_of_operations_to_make_network_connected.addLink(new QuestionLink("VIDEO", "https://youtu.be/FYrl7iz9_ZU"));
        
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_number_of_operations_to_make_network_connected.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/number-of-operations-to-make-network-connected-dsu-g-49/"));
        
        
        topic_15_5.addQuestion(q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_number_of_operations_to_make_network_connected);
        
        Question q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_most_stones_removed_with_same_row_or_column = new Question("graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_most_stones_removed_with_same_row_or_column", "Most stones removed with same row or column", "MEDIUM");
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_most_stones_removed_with_same_row_or_column.setSolveLink("https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/");
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_most_stones_removed_with_same_row_or_column.setEditorialLink("https://takeuforward.org/plus/dsa/problems/most-stones-removed-with-same-row-or-column?tab=editorial");
        
        
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_most_stones_removed_with_same_row_or_column.addLink(new QuestionLink("VIDEO", "https://youtu.be/OwMNX8SPavM"));
        
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_most_stones_removed_with_same_row_or_column.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/most-stones-removed-with-same-row-or-column-dsu-g-53/"));
        
        
        topic_15_5.addQuestion(q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_most_stones_removed_with_same_row_or_column);
        
        Question q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_accounts_merge = new Question("graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_accounts_merge", "Accounts merge", "HARD");
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_accounts_merge.setSolveLink("https://leetcode.com/problems/accounts-merge/");
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_accounts_merge.setEditorialLink("https://takeuforward.org/plus/dsa/problems/accounts-merge?tab=editorial");
        
        
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_accounts_merge.addLink(new QuestionLink("VIDEO", "https://youtu.be/FMwpt_aQOGw"));
        
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_accounts_merge.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/accounts-merge-dsu-g-50/"));
        
        
        topic_15_5.addQuestion(q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_accounts_merge);
        
        Question q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_number_of_islands_ii = new Question("graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_number_of_islands_ii", "Number of islands II", "HARD");
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_number_of_islands_ii.setSolveLink("https://leetcode.com/problems/number-of-islands-ii/");
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_number_of_islands_ii.setEditorialLink("https://takeuforward.org/plus/dsa/problems/number-of-islands-ii?tab=editorial");
        
        
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_number_of_islands_ii.addLink(new QuestionLink("VIDEO", "https://youtu.be/Rn6B-Q4SNyA"));
        
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_number_of_islands_ii.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/graph/number-of-islands-ii-online-queries-dsu-g-51/"));
        
        
        topic_15_5.addQuestion(q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_number_of_islands_ii);
        
        Question q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_making_a_large_island = new Question("graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_making_a_large_island", "Making a large island", "HARD");
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_making_a_large_island.setSolveLink("https://leetcode.com/problems/making-a-large-island/");
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_making_a_large_island.setEditorialLink("https://takeuforward.org/plus/dsa/problems/making-a-large-island?tab=editorial");
        
        
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_making_a_large_island.addLink(new QuestionLink("VIDEO", "https://youtu.be/lgiz0Oup6gM"));
        
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_making_a_large_island.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/making-a-large-island-dsu-g-52/"));
        
        
        topic_15_5.addQuestion(q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_making_a_large_island);
        
        Question q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_swim_in_rising_water = new Question("graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_swim_in_rising_water", "Swim in Rising Water", "MEDIUM");
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_swim_in_rising_water.setSolveLink("https://leetcode.com/problems/swim-in-rising-water/");
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_swim_in_rising_water.setEditorialLink("https://takeuforward.org/plus/dsa/problems/swim-in-rising-water?tab=editorial");
        
        
        q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_swim_in_rising_water.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/swim-in-rising-water"));
        
        
        topic_15_5.addQuestion(q_graphs_concepts_problems_minimumspanningtreedisjoint_set_and_problems_swim_in_rising_water);
        
        
        section_15.addTopic(topic_15_5);
        
        // Topic: Other Algorithms
        Topic topic_15_6 = new Topic("graphs_concepts_problems_other_algorithms", "Other Algorithms");
        
        
        
        Question q_graphs_concepts_problems_other_algorithms_bridges_in_graph = new Question("graphs_concepts_problems_other_algorithms_bridges_in_graph", "Bridges in graph", "HARD");
        q_graphs_concepts_problems_other_algorithms_bridges_in_graph.setSolveLink("https://leetcode.com/problems/critical-connections-in-a-network/discuss/382385/find-bridges-in-a-graph");
        q_graphs_concepts_problems_other_algorithms_bridges_in_graph.setEditorialLink("https://takeuforward.org/plus/dsa/problems/bridges-in-graph?tab=editorial");
        
        
        q_graphs_concepts_problems_other_algorithms_bridges_in_graph.addLink(new QuestionLink("VIDEO", "https://youtu.be/qrAub5z8FeA"));
        
        q_graphs_concepts_problems_other_algorithms_bridges_in_graph.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/graph/bridges-in-graph-using-tarjans-algorithm-of-time-in-and-low-time-g-55/"));
        
        
        topic_15_6.addQuestion(q_graphs_concepts_problems_other_algorithms_bridges_in_graph);
        
        Question q_graphs_concepts_problems_other_algorithms_articulation_point_in_graph = new Question("graphs_concepts_problems_other_algorithms_articulation_point_in_graph", "Articulation point in graph", "HARD");
        q_graphs_concepts_problems_other_algorithms_articulation_point_in_graph.setSolveLink("https://takeuforward.org/plus/dsa/problems/articulation-point-in-graph");
        q_graphs_concepts_problems_other_algorithms_articulation_point_in_graph.setEditorialLink("https://takeuforward.org/plus/dsa/problems/articulation-point-in-graph?tab=editorial");
        
        
        q_graphs_concepts_problems_other_algorithms_articulation_point_in_graph.addLink(new QuestionLink("VIDEO", "https://youtu.be/j1QDfU21iZk"));
        
        q_graphs_concepts_problems_other_algorithms_articulation_point_in_graph.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/articulation-point-in-graph-g-56/"));
        
        
        topic_15_6.addQuestion(q_graphs_concepts_problems_other_algorithms_articulation_point_in_graph);
        
        Question q_graphs_concepts_problems_other_algorithms_kosarajus_algorithm = new Question("graphs_concepts_problems_other_algorithms_kosarajus_algorithm", "Kosaraju's algorithm", "HARD");
        q_graphs_concepts_problems_other_algorithms_kosarajus_algorithm.setSolveLink("https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/discuss/766485/kosaraju-algorithm-on");
        q_graphs_concepts_problems_other_algorithms_kosarajus_algorithm.setEditorialLink("https://takeuforward.org/plus/dsa/problems/kosaraju's-algorithm?tab=editorial");
        
        
        q_graphs_concepts_problems_other_algorithms_kosarajus_algorithm.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=V8qIqJxCioo&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=27"));
        
        q_graphs_concepts_problems_other_algorithms_kosarajus_algorithm.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/graph/strongly-connected-components-kosarajus-algorithm-g-54/"));
        
        
        topic_15_6.addQuestion(q_graphs_concepts_problems_other_algorithms_kosarajus_algorithm);
        
        
        section_15.addTopic(topic_15_6);
        
        
        Roadmap.addSection(section_15);
        
        // ==========================================
        // Section: Dynamic Programming [Patterns and Problems]
        // ==========================================
        RoadmapSection section_16 = new RoadmapSection("dynamic_programming_patterns_and_problems", "Dynamic Programming [Patterns and Problems]");
        
        
        
        // Topic: Introduction to DP
        Topic topic_16_1 = new Topic("dynamic_programming_patterns_and_problems_introduction_to_dp", "Introduction to DP");
        
        
        
        Question q_dynamic_programming_patterns_and_problems_introduction_to_dp_introduction_to_dp = new Question("dynamic_programming_patterns_and_problems_introduction_to_dp_introduction_to_dp", "Introduction to DP", "EASY");
        q_dynamic_programming_patterns_and_problems_introduction_to_dp_introduction_to_dp.setSolveLink("https://takeuforward.org/plus/dsa/problems/introduction-to-dp");
        q_dynamic_programming_patterns_and_problems_introduction_to_dp_introduction_to_dp.setEditorialLink("https://takeuforward.org/plus/dsa/problems/introduction-to-dp");
        
        
        q_dynamic_programming_patterns_and_problems_introduction_to_dp_introduction_to_dp.addLink(new QuestionLink("VIDEO", "https://youtu.be/tyB0ztf0DNY"));
        
        q_dynamic_programming_patterns_and_problems_introduction_to_dp_introduction_to_dp.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/dynamic-programming-introduction/"));
        
        
        topic_16_1.addQuestion(q_dynamic_programming_patterns_and_problems_introduction_to_dp_introduction_to_dp);
        
        
        section_16.addTopic(topic_16_1);
        
        // Topic: 1D DP
        Topic topic_16_2 = new Topic("dynamic_programming_patterns_and_problems_1d_dp", "1D DP");
        
        
        
        Question q_dynamic_programming_patterns_and_problems_1d_dp_climbing_stairs = new Question("dynamic_programming_patterns_and_problems_1d_dp_climbing_stairs", "Climbing stairs", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_1d_dp_climbing_stairs.setSolveLink("https://leetcode.com/problems/climbing-stairs/");
        q_dynamic_programming_patterns_and_problems_1d_dp_climbing_stairs.setEditorialLink("https://takeuforward.org/plus/dsa/problems/climbing-stairs?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_1d_dp_climbing_stairs.addLink(new QuestionLink("VIDEO", "https://youtu.be/mLfjzJsN8us"));
        
        q_dynamic_programming_patterns_and_problems_1d_dp_climbing_stairs.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/dynamic-programming-climbing-stairs/"));
        
        
        topic_16_2.addQuestion(q_dynamic_programming_patterns_and_problems_1d_dp_climbing_stairs);
        
        Question q_dynamic_programming_patterns_and_problems_1d_dp_frog_jump = new Question("dynamic_programming_patterns_and_problems_1d_dp_frog_jump", "Frog Jump", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_1d_dp_frog_jump.setSolveLink("https://takeuforward.org/plus/dsa/problems/frog-jump");
        q_dynamic_programming_patterns_and_problems_1d_dp_frog_jump.setEditorialLink("https://takeuforward.org/plus/dsa/problems/frog-jump?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_1d_dp_frog_jump.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=EgG3jsGoPvQ"));
        
        q_dynamic_programming_patterns_and_problems_1d_dp_frog_jump.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/"));
        
        
        topic_16_2.addQuestion(q_dynamic_programming_patterns_and_problems_1d_dp_frog_jump);
        
        Question q_dynamic_programming_patterns_and_problems_1d_dp_frog_jump_with_k_distances = new Question("dynamic_programming_patterns_and_problems_1d_dp_frog_jump_with_k_distances", "Frog jump with K distances", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_1d_dp_frog_jump_with_k_distances.setSolveLink("https://takeuforward.org/plus/dsa/problems/frog-jump-with-k-distances");
        q_dynamic_programming_patterns_and_problems_1d_dp_frog_jump_with_k_distances.setEditorialLink("https://takeuforward.org/plus/dsa/problems/frog-jump-with-k-distances?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_1d_dp_frog_jump_with_k_distances.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=Kmh3rhyEtB8"));
        
        q_dynamic_programming_patterns_and_problems_1d_dp_frog_jump_with_k_distances.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/dynamic-programming-frog-jump-with-k-distances-dp-4/"));
        
        
        topic_16_2.addQuestion(q_dynamic_programming_patterns_and_problems_1d_dp_frog_jump_with_k_distances);
        
        Question q_dynamic_programming_patterns_and_problems_1d_dp_maximum_sum_of_non_adjacent_elements = new Question("dynamic_programming_patterns_and_problems_1d_dp_maximum_sum_of_non_adjacent_elements", "Maximum sum of non adjacent elements", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_1d_dp_maximum_sum_of_non_adjacent_elements.setSolveLink("https://leetcode.com/problems/house-robber/");
        q_dynamic_programming_patterns_and_problems_1d_dp_maximum_sum_of_non_adjacent_elements.setEditorialLink("https://takeuforward.org/plus/dsa/problems/maximum-sum-of-non-adjacent-elements?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_1d_dp_maximum_sum_of_non_adjacent_elements.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=GrMBfJNk_NY"));
        
        q_dynamic_programming_patterns_and_problems_1d_dp_maximum_sum_of_non_adjacent_elements.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/maximum-sum-of-non-adjacent-elements-dp-5/"));
        
        
        topic_16_2.addQuestion(q_dynamic_programming_patterns_and_problems_1d_dp_maximum_sum_of_non_adjacent_elements);
        
        Question q_dynamic_programming_patterns_and_problems_1d_dp_house_robber = new Question("dynamic_programming_patterns_and_problems_1d_dp_house_robber", "House robber", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_1d_dp_house_robber.setSolveLink("https://leetcode.com/problems/house-robber-ii/");
        q_dynamic_programming_patterns_and_problems_1d_dp_house_robber.setEditorialLink("https://takeuforward.org/plus/dsa/problems/house-robber?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_1d_dp_house_robber.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=3WaxQMELSkw"));
        
        q_dynamic_programming_patterns_and_problems_1d_dp_house_robber.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/dynamic-programming-house-robber-dp-6/"));
        
        
        topic_16_2.addQuestion(q_dynamic_programming_patterns_and_problems_1d_dp_house_robber);
        
        
        section_16.addTopic(topic_16_2);
        
        // Topic: 2D/3D DP and DP on Grids
        Topic topic_16_3 = new Topic("dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids", "2D/3D DP and DP on Grids");
        
        
        
        Question q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_ninjas_training = new Question("dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_ninjas_training", "Ninja's training", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_ninjas_training.setSolveLink("https://takeuforward.org/plus/dsa/problems/ninja's-training");
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_ninjas_training.setEditorialLink("https://takeuforward.org/plus/dsa/problems/ninja's-training?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_ninjas_training.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=AE39gJYuRog"));
        
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_ninjas_training.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/dynamic-programming-ninjas-training-dp-7/"));
        
        
        topic_16_3.addQuestion(q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_ninjas_training);
        
        Question q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_grid_unique_paths_dp_on_grids_dp8 = new Question("dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_grid_unique_paths_dp_on_grids_dp8", "Grid Unique Paths : DP on Grids (DP8)", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_grid_unique_paths_dp_on_grids_dp8.setSolveLink("https://leetcode.com/problems/unique-paths/");
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_grid_unique_paths_dp_on_grids_dp8.setEditorialLink("https://takeuforward.org/plus/dsa/problems/grid-unique-paths?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_grid_unique_paths_dp_on_grids_dp8.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=sdE0A2Oxofw"));
        
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_grid_unique_paths_dp_on_grids_dp8.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/grid-unique-paths-dp-on-grids-dp8/"));
        
        
        topic_16_3.addQuestion(q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_grid_unique_paths_dp_on_grids_dp8);
        
        Question q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_unique_paths_ii = new Question("dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_unique_paths_ii", "Unique paths II", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_unique_paths_ii.setSolveLink("https://leetcode.com/problems/unique-paths-ii/");
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_unique_paths_ii.setEditorialLink("https://takeuforward.org/plus/dsa/problems/unique-paths-ii?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_unique_paths_ii.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=TmhpgXScLyY"));
        
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_unique_paths_ii.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/grid-unique-paths-2-dp-9/"));
        
        
        topic_16_3.addQuestion(q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_unique_paths_ii);
        
        Question q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_minimum_falling_path_sum = new Question("dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_minimum_falling_path_sum", "Minimum Falling Path Sum", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_minimum_falling_path_sum.setSolveLink("https://leetcode.com/problems/minimum-path-sum/");
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_minimum_falling_path_sum.setEditorialLink("https://takeuforward.org/plus/dsa/problems/minimum-falling-path-sum?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_minimum_falling_path_sum.addLink(new QuestionLink("VIDEO", "https://youtu.be/_rgTlyky1uQ"));
        
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_minimum_falling_path_sum.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/minimum-path-sum-in-a-grid-dp-10/"));
        
        
        topic_16_3.addQuestion(q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_minimum_falling_path_sum);
        
        Question q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_triangle = new Question("dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_triangle", "Triangle", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_triangle.setSolveLink("https://leetcode.com/problems/triangle/");
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_triangle.setEditorialLink("https://takeuforward.org/plus/dsa/problems/triangle?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_triangle.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=SrP-PiLSYC0"));
        
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_triangle.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/minimum-path-sum-in-triangular-grid-dp-11/"));
        
        
        topic_16_3.addQuestion(q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_triangle);
        
        Question q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_ninja_and_his_friends = new Question("dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_ninja_and_his_friends", "Ninja and his Friends", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_ninja_and_his_friends.setSolveLink("https://takeuforward.org/plus/dsa/problems/ninja-and-his-friends");
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_ninja_and_his_friends.setEditorialLink("https://takeuforward.org/plus/dsa/problems/ninja-and-his-friends?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_ninja_and_his_friends.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=QGfn7JeXK54"));
        
        q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_ninja_and_his_friends.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/3-d-dp-ninja-and-his-friends-dp-13/"));
        
        
        topic_16_3.addQuestion(q_dynamic_programming_patterns_and_problems_2d3d_dp_and_dp_on_grids_ninja_and_his_friends);
        
        
        section_16.addTopic(topic_16_3);
        
        // Topic: DP on Subsequences
        Topic topic_16_4 = new Topic("dynamic_programming_patterns_and_problems_dp_on_subsequences", "DP on Subsequences");
        
        
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_subsequences_subset_sum_equal_to_target_dp_14 = new Question("dynamic_programming_patterns_and_problems_dp_on_subsequences_subset_sum_equal_to_target_dp_14", "Subset sum equal to target (DP- 14)", "HARD");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_subset_sum_equal_to_target_dp_14.setSolveLink("https://takeuforward.org/plus/dsa/problems/subset-sum-equals-to-target");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_subset_sum_equal_to_target_dp_14.setEditorialLink("https://takeuforward.org/plus/dsa/problems/subset-sum-equals-to-target?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_subset_sum_equal_to_target_dp_14.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=fWX9xDmIzRI"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_subset_sum_equal_to_target_dp_14.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/subset-sum-equal-to-target-dp-14/"));
        
        
        topic_16_4.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_subsequences_subset_sum_equal_to_target_dp_14);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_subsequences_partition_equal_subset_sum = new Question("dynamic_programming_patterns_and_problems_dp_on_subsequences_partition_equal_subset_sum", "Partition equal subset sum", "HARD");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_partition_equal_subset_sum.setSolveLink("https://leetcode.com/problems/partition-equal-subset-sum/");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_partition_equal_subset_sum.setEditorialLink("https://takeuforward.org/plus/dsa/problems/partition-equal-subset-sum?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_partition_equal_subset_sum.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=7win3dcgo3k"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_partition_equal_subset_sum.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/partition-equal-subset-sum-dp-15/"));
        
        
        topic_16_4.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_subsequences_partition_equal_subset_sum);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_subsequences_partition_a_set_into_two_subsets_with_minimum_absolute_sum_difference = new Question("dynamic_programming_patterns_and_problems_dp_on_subsequences_partition_a_set_into_two_subsets_with_minimum_absolute_sum_difference", "Partition a set into two subsets with minimum absolute sum difference", "HARD");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_partition_a_set_into_two_subsets_with_minimum_absolute_sum_difference.setSolveLink("https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_partition_a_set_into_two_subsets_with_minimum_absolute_sum_difference.setEditorialLink("https://takeuforward.org/plus/dsa/problems/partition-a-set-into-two-subsets-with-minimum-absolute-sum-difference?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_partition_a_set_into_two_subsets_with_minimum_absolute_sum_difference.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=GS_OqZb2CWc"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_partition_a_set_into_two_subsets_with_minimum_absolute_sum_difference.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/partition-set-into-2-subsets-with-min-absolute-sum-diff-dp-16/"));
        
        
        topic_16_4.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_subsequences_partition_a_set_into_two_subsets_with_minimum_absolute_sum_difference);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_subsequences_count_subsets_with_sum_k = new Question("dynamic_programming_patterns_and_problems_dp_on_subsequences_count_subsets_with_sum_k", "Count subsets with sum K", "HARD");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_count_subsets_with_sum_k.setSolveLink("https://takeuforward.org/plus/dsa/problems/count-subsets-with-sum-k");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_count_subsets_with_sum_k.setEditorialLink("https://takeuforward.org/plus/dsa/problems/count-subsets-with-sum-k?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_count_subsets_with_sum_k.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=ZHyb-A2Mte4"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_count_subsets_with_sum_k.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/count-subsets-with-sum-k-dp-17/"));
        
        
        topic_16_4.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_subsequences_count_subsets_with_sum_k);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_subsequences_count_partitions_with_given_difference = new Question("dynamic_programming_patterns_and_problems_dp_on_subsequences_count_partitions_with_given_difference", "Count partitions with given difference", "HARD");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_count_partitions_with_given_difference.setSolveLink("https://takeuforward.org/plus/dsa/problems/count-partitions-with-given-difference");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_count_partitions_with_given_difference.setEditorialLink("https://takeuforward.org/plus/dsa/problems/count-partitions-with-given-difference?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_count_partitions_with_given_difference.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=zoilQD1kYSg"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_count_partitions_with_given_difference.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/count-partitions-with-given-difference-dp-18/"));
        
        
        topic_16_4.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_subsequences_count_partitions_with_given_difference);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_subsequences_assign_cookies = new Question("dynamic_programming_patterns_and_problems_dp_on_subsequences_assign_cookies", "Assign Cookies", "EASY");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_assign_cookies.setSolveLink("https://leetcode.com/problems/assign-cookies/");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_assign_cookies.setEditorialLink("https://takeuforward.org/plus/dsa/problems/assign-cookies?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_assign_cookies.addLink(new QuestionLink("VIDEO", "https://youtu.be/DIX2p7vb9co?si=GofAIDimue-Av0Fi"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_assign_cookies.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/assign-cookies"));
        
        
        topic_16_4.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_subsequences_assign_cookies);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_subsequences_minimum_coins_dp_20 = new Question("dynamic_programming_patterns_and_problems_dp_on_subsequences_minimum_coins_dp_20", "Minimum Coins (DP - 20)", "HARD");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_minimum_coins_dp_20.setSolveLink("https://leetcode.com/problems/coin-change/");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_minimum_coins_dp_20.setEditorialLink("https://takeuforward.org/plus/dsa/problems/minimum-coins?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_minimum_coins_dp_20.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=myPeWb3Y68A"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_minimum_coins_dp_20.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/minimum-coins-dp-20/"));
        
        
        topic_16_4.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_subsequences_minimum_coins_dp_20);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_subsequences_target_sum = new Question("dynamic_programming_patterns_and_problems_dp_on_subsequences_target_sum", "Target sum", "HARD");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_target_sum.setSolveLink("https://leetcode.com/problems/target-sum/");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_target_sum.setEditorialLink("https://takeuforward.org/plus/dsa/problems/target-sum?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_target_sum.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=b3GD8263-PQ"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_target_sum.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/target-sum-dp-21/"));
        
        
        topic_16_4.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_subsequences_target_sum);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_subsequences_coin_change_2_dp_22 = new Question("dynamic_programming_patterns_and_problems_dp_on_subsequences_coin_change_2_dp_22", "Coin Change 2 (DP - 22)", "HARD");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_coin_change_2_dp_22.setSolveLink("https://leetcode.com/problems/coin-change-2/");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_coin_change_2_dp_22.setEditorialLink("https://takeuforward.org/plus/dsa/problems/coin-change-ii?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_coin_change_2_dp_22.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=HgyouUi11zk"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_coin_change_2_dp_22.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/coin-change-2-dp-22/"));
        
        
        topic_16_4.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_subsequences_coin_change_2_dp_22);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_subsequences_unbounded_knapsack = new Question("dynamic_programming_patterns_and_problems_dp_on_subsequences_unbounded_knapsack", "Unbounded knapsack", "HARD");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_unbounded_knapsack.setSolveLink("https://takeuforward.org/plus/dsa/problems/unbounded-knapsack");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_unbounded_knapsack.setEditorialLink("https://takeuforward.org/plus/dsa/problems/unbounded-knapsack?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_unbounded_knapsack.addLink(new QuestionLink("VIDEO", "https://youtu.be/OgvOZ6OrJoY"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_unbounded_knapsack.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/unbounded-knapsack-dp-23/"));
        
        
        topic_16_4.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_subsequences_unbounded_knapsack);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_subsequences_rod_cutting_problem_dp_24 = new Question("dynamic_programming_patterns_and_problems_dp_on_subsequences_rod_cutting_problem_dp_24", "Rod Cutting Problem | (DP - 24)", "HARD");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_rod_cutting_problem_dp_24.setSolveLink("https://takeuforward.org/plus/dsa/problems/rod-cutting-problem");
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_rod_cutting_problem_dp_24.setEditorialLink("https://takeuforward.org/plus/dsa/problems/rod-cutting-problem?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_rod_cutting_problem_dp_24.addLink(new QuestionLink("VIDEO", "https://youtu.be/mO8XpGoJwuo"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_subsequences_rod_cutting_problem_dp_24.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/rod-cutting-problem-dp-24/"));
        
        
        topic_16_4.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_subsequences_rod_cutting_problem_dp_24);
        
        
        section_16.addTopic(topic_16_4);
        
        // Topic: DP on Strings
        Topic topic_16_5 = new Topic("dynamic_programming_patterns_and_problems_dp_on_strings", "DP on Strings");
        
        
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_strings_longest_common_subsequence = new Question("dynamic_programming_patterns_and_problems_dp_on_strings_longest_common_subsequence", "Longest common subsequence", "HARD");
        q_dynamic_programming_patterns_and_problems_dp_on_strings_longest_common_subsequence.setSolveLink("https://takeuforward.org/plus/dsa/problems/longest-common-subsequence");
        q_dynamic_programming_patterns_and_problems_dp_on_strings_longest_common_subsequence.setEditorialLink("https://takeuforward.org/plus/dsa/problems/longest-common-subsequence?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_strings_longest_common_subsequence.addLink(new QuestionLink("VIDEO", "https://youtu.be/-zI4mrF2Pb4"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_strings_longest_common_subsequence.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/print-longest-common-subsequence-dp-26/"));
        
        
        topic_16_5.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_strings_longest_common_subsequence);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_strings_print_longest_common_subsequence_dp_26 = new Question("dynamic_programming_patterns_and_problems_dp_on_strings_print_longest_common_subsequence_dp_26", "Print Longest Common Subsequence | (DP - 26)", "HARD");
        q_dynamic_programming_patterns_and_problems_dp_on_strings_print_longest_common_subsequence_dp_26.setSolveLink("https://takeuforward.org/plus/dsa/problems/longest-common-subsequence");
        q_dynamic_programming_patterns_and_problems_dp_on_strings_print_longest_common_subsequence_dp_26.setEditorialLink("https://takeuforward.org/plus/dsa/problems/longest-common-subsequence?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_strings_print_longest_common_subsequence_dp_26.addLink(new QuestionLink("VIDEO", "https://youtu.be/-zI4mrF2Pb4"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_strings_print_longest_common_subsequence_dp_26.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/print-longest-common-subsequence-dp-26/"));
        
        
        topic_16_5.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_strings_print_longest_common_subsequence_dp_26);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_strings_longest_common_substring = new Question("dynamic_programming_patterns_and_problems_dp_on_strings_longest_common_substring", "Longest common substring", "HARD");
        q_dynamic_programming_patterns_and_problems_dp_on_strings_longest_common_substring.setSolveLink("https://takeuforward.org/plus/dsa/problems/longest-common-substring");
        q_dynamic_programming_patterns_and_problems_dp_on_strings_longest_common_substring.setEditorialLink("https://takeuforward.org/plus/dsa/problems/longest-common-substring?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_strings_longest_common_substring.addLink(new QuestionLink("VIDEO", "https://youtu.be/_wP9mWNPL5w"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_strings_longest_common_substring.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/longest-common-substring-dp-27/"));
        
        
        topic_16_5.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_strings_longest_common_substring);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_strings_longest_palindromic_subsequence = new Question("dynamic_programming_patterns_and_problems_dp_on_strings_longest_palindromic_subsequence", "Longest palindromic subsequence", "HARD");
        q_dynamic_programming_patterns_and_problems_dp_on_strings_longest_palindromic_subsequence.setSolveLink("https://leetcode.com/problems/longest-palindromic-subsequence/");
        q_dynamic_programming_patterns_and_problems_dp_on_strings_longest_palindromic_subsequence.setEditorialLink("https://takeuforward.org/plus/dsa/problems/longest-palindromic-subsequence?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_strings_longest_palindromic_subsequence.addLink(new QuestionLink("VIDEO", "https://youtu.be/6i_T5kkfv4A"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_strings_longest_palindromic_subsequence.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/longest-palindromic-subsequence-dp-28/"));
        
        
        topic_16_5.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_strings_longest_palindromic_subsequence);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_strings_minimum_insertions_to_make_string_palindrome_dp_29 = new Question("dynamic_programming_patterns_and_problems_dp_on_strings_minimum_insertions_to_make_string_palindrome_dp_29", "Minimum insertions to make string palindrome | DP-29", "HARD");
        q_dynamic_programming_patterns_and_problems_dp_on_strings_minimum_insertions_to_make_string_palindrome_dp_29.setSolveLink("https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/");
        q_dynamic_programming_patterns_and_problems_dp_on_strings_minimum_insertions_to_make_string_palindrome_dp_29.setEditorialLink("https://takeuforward.org/plus/dsa/problems/minimum-insertions-to-make-string-palindrome?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_strings_minimum_insertions_to_make_string_palindrome_dp_29.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=xPBLEj41rFU"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_strings_minimum_insertions_to_make_string_palindrome_dp_29.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/minimum-insertions-to-make-string-palindrome-dp-29/"));
        
        
        topic_16_5.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_strings_minimum_insertions_to_make_string_palindrome_dp_29);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_strings_minimum_insertions_or_deletions_to_convert_string_a_to_b = new Question("dynamic_programming_patterns_and_problems_dp_on_strings_minimum_insertions_or_deletions_to_convert_string_a_to_b", "Minimum insertions or deletions to convert string A to B", "HARD");
        q_dynamic_programming_patterns_and_problems_dp_on_strings_minimum_insertions_or_deletions_to_convert_string_a_to_b.setSolveLink("https://leetcode.com/problems/delete-operation-for-two-strings/");
        q_dynamic_programming_patterns_and_problems_dp_on_strings_minimum_insertions_or_deletions_to_convert_string_a_to_b.setEditorialLink("https://takeuforward.org/plus/dsa/problems/minimum-insertions-or-deletions-to-convert-string-a-to-b?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_strings_minimum_insertions_or_deletions_to_convert_string_a_to_b.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=yMnH0jrir0Q"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_strings_minimum_insertions_or_deletions_to_convert_string_a_to_b.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/minimum-insertions-deletions-to-convert-string-dp-30/"));
        
        
        topic_16_5.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_strings_minimum_insertions_or_deletions_to_convert_string_a_to_b);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_strings_shortest_common_supersequence = new Question("dynamic_programming_patterns_and_problems_dp_on_strings_shortest_common_supersequence", "Shortest common supersequence", "HARD");
        q_dynamic_programming_patterns_and_problems_dp_on_strings_shortest_common_supersequence.setSolveLink("https://leetcode.com/problems/shortest-common-supersequence/");
        q_dynamic_programming_patterns_and_problems_dp_on_strings_shortest_common_supersequence.setEditorialLink("https://takeuforward.org/plus/dsa/problems/shortest-common-supersequence?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_strings_shortest_common_supersequence.addLink(new QuestionLink("VIDEO", "https://youtu.be/xElxAuBcvsU"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_strings_shortest_common_supersequence.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/shortest-common-supersequence-dp-31/"));
        
        
        topic_16_5.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_strings_shortest_common_supersequence);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_strings_distinct_subsequences = new Question("dynamic_programming_patterns_and_problems_dp_on_strings_distinct_subsequences", "Distinct subsequences", "HARD");
        q_dynamic_programming_patterns_and_problems_dp_on_strings_distinct_subsequences.setSolveLink("https://leetcode.com/problems/distinct-subsequences/");
        q_dynamic_programming_patterns_and_problems_dp_on_strings_distinct_subsequences.setEditorialLink("https://takeuforward.org/plus/dsa/problems/distinct-subsequences?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_strings_distinct_subsequences.addLink(new QuestionLink("VIDEO", "https://youtu.be/nVG7eTiD2bY"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_strings_distinct_subsequences.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/distinct-subsequences-dp-32/"));
        
        
        topic_16_5.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_strings_distinct_subsequences);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_strings_edit_distance = new Question("dynamic_programming_patterns_and_problems_dp_on_strings_edit_distance", "Edit distance", "HARD");
        q_dynamic_programming_patterns_and_problems_dp_on_strings_edit_distance.setSolveLink("https://leetcode.com/problems/edit-distance/");
        q_dynamic_programming_patterns_and_problems_dp_on_strings_edit_distance.setEditorialLink("https://takeuforward.org/plus/dsa/problems/edit-distance?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_strings_edit_distance.addLink(new QuestionLink("VIDEO", "https://youtu.be/fJaKO8FbDdo"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_strings_edit_distance.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/edit-distance-dp-33/"));
        
        
        topic_16_5.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_strings_edit_distance);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_strings_wildcard_matching = new Question("dynamic_programming_patterns_and_problems_dp_on_strings_wildcard_matching", "Wildcard matching", "HARD");
        q_dynamic_programming_patterns_and_problems_dp_on_strings_wildcard_matching.setSolveLink("https://leetcode.com/problems/wildcard-matching/");
        q_dynamic_programming_patterns_and_problems_dp_on_strings_wildcard_matching.setEditorialLink("https://takeuforward.org/plus/dsa/problems/wildcard-matching?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_strings_wildcard_matching.addLink(new QuestionLink("VIDEO", "https://youtu.be/ZmlQ3vgAOMo"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_strings_wildcard_matching.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/wildcard-matching-dp-34/"));
        
        
        topic_16_5.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_strings_wildcard_matching);
        
        
        section_16.addTopic(topic_16_5);
        
        // Topic: DP on Stocks
        Topic topic_16_6 = new Topic("dynamic_programming_patterns_and_problems_dp_on_stocks", "DP on Stocks");
        
        
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock = new Question("dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock", "Best time to buy and sell stock", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock.setSolveLink("https://leetcode.com/problems/best-time-to-buy-and-sell-stock/");
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock.setEditorialLink("https://takeuforward.org/plus/dsa/problems/best-time-to-buy-and-sell-stock?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock.addLink(new QuestionLink("VIDEO", "https://youtu.be/excAOvwF_Wk"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/stock-buy-and-sell/"));
        
        
        topic_16_6.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_ii = new Question("dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_ii", "Best time to buy and sell stock II", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_ii.setSolveLink("https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/");
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_ii.setEditorialLink("https://takeuforward.org/plus/dsa/problems/best-time-to-buy-and-sell-stock-ii?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_ii.addLink(new QuestionLink("VIDEO", "https://youtu.be/nGJmxkUJQGs"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_ii.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/buy-and-sell-stock-ii-dp-36/"));
        
        
        topic_16_6.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_ii);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_iii = new Question("dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_iii", "Best time to buy and sell stock III", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_iii.setSolveLink("https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/");
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_iii.setEditorialLink("https://takeuforward.org/plus/dsa/problems/best-time-to-buy-and-sell-stock-iii?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_iii.addLink(new QuestionLink("VIDEO", "https://youtu.be/-uQGzhYj8BQ"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_iii.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/buy-and-sell-stock-iii-dp-37/"));
        
        
        topic_16_6.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_iii);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_iv = new Question("dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_iv", "Best time to buy and sell stock IV", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_iv.setSolveLink("https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/");
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_iv.setEditorialLink("https://takeuforward.org/plus/dsa/problems/best-time-to-buy-and-sell-stock-iv?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_iv.addLink(new QuestionLink("VIDEO", "https://youtu.be/IV1dHbk5CDc"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_iv.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/buy-and-sell-stock-iv-dp-38/"));
        
        
        topic_16_6.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_iv);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_with_cooldown = new Question("dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_with_cooldown", "Best Time to Buy and Sell Stock with Cooldown", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_with_cooldown.setSolveLink("https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/");
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_with_cooldown.setEditorialLink("");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_with_cooldown.addLink(new QuestionLink("VIDEO", "https://youtu.be/IGIe46xw3YY"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_with_cooldown.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/buy-and-sell-stocks-with-cooldown-dp-39/"));
        
        
        topic_16_6.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_with_cooldown);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_with_transaction_fees = new Question("dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_with_transaction_fees", "Best time to buy and sell stock with transaction fees", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_with_transaction_fees.setSolveLink("https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/");
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_with_transaction_fees.setEditorialLink("https://takeuforward.org/plus/dsa/problems/best-time-to-buy-and-sell-stock-with-cooldown-and-transaction-fees?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_with_transaction_fees.addLink(new QuestionLink("VIDEO", "https://youtu.be/k4eK-vEmnKg"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_with_transaction_fees.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/buy-and-sell-stocks-with-transaction-fees-dp-40/"));
        
        
        topic_16_6.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_stocks_best_time_to_buy_and_sell_stock_with_transaction_fees);
        
        
        section_16.addTopic(topic_16_6);
        
        // Topic: DP on LIS
        Topic topic_16_7 = new Topic("dynamic_programming_patterns_and_problems_dp_on_lis", "DP on LIS");
        
        
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_increasing_subsequence = new Question("dynamic_programming_patterns_and_problems_dp_on_lis_longest_increasing_subsequence", "Longest Increasing Subsequence", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_increasing_subsequence.setSolveLink("https://takeuforward.org/plus/dsa/problems/longest-increasing-subsequence");
        q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_increasing_subsequence.setEditorialLink("https://takeuforward.org/plus/dsa/problems/longest-increasing-subsequence?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_increasing_subsequence.addLink(new QuestionLink("VIDEO", "https://youtu.be/on2hvxBXJH4"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_increasing_subsequence.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/longest-increasing-subsequence-binary-search-dp-43/"));
        
        
        topic_16_7.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_increasing_subsequence);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_lis_print_longest_increasing_subsequence = new Question("dynamic_programming_patterns_and_problems_dp_on_lis_print_longest_increasing_subsequence", "Print Longest Increasing Subsequence", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_dp_on_lis_print_longest_increasing_subsequence.setSolveLink("https://takeuforward.org/plus/dsa/problems/print-longest-increasing-subsequence");
        q_dynamic_programming_patterns_and_problems_dp_on_lis_print_longest_increasing_subsequence.setEditorialLink("https://takeuforward.org/plus/dsa/problems/print-longest-increasing-subsequence?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_lis_print_longest_increasing_subsequence.addLink(new QuestionLink("VIDEO", "https://youtu.be/IFfYfonAFGc"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_lis_print_longest_increasing_subsequence.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/printing-longest-increasing-subsequence-dp-42/"));
        
        
        topic_16_7.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_lis_print_longest_increasing_subsequence);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_increasing_subsequence_dp_43 = new Question("dynamic_programming_patterns_and_problems_dp_on_lis_longest_increasing_subsequence_dp_43", "Longest Increasing Subsequence |(DP-43)", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_increasing_subsequence_dp_43.setSolveLink("https://takeuforward.org/plus/dsa/problems/longest-increasing-subsequence");
        q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_increasing_subsequence_dp_43.setEditorialLink("https://takeuforward.org/plus/dsa/problems/longest-increasing-subsequence?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_increasing_subsequence_dp_43.addLink(new QuestionLink("VIDEO", "https://youtu.be/on2hvxBXJH4"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_increasing_subsequence_dp_43.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/longest-increasing-subsequence-binary-search-dp-43/"));
        
        
        topic_16_7.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_increasing_subsequence_dp_43);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_lis_largest_divisible_subset = new Question("dynamic_programming_patterns_and_problems_dp_on_lis_largest_divisible_subset", "Largest Divisible Subset", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_dp_on_lis_largest_divisible_subset.setSolveLink("https://leetcode.com/problems/largest-divisible-subset/");
        q_dynamic_programming_patterns_and_problems_dp_on_lis_largest_divisible_subset.setEditorialLink("https://takeuforward.org/plus/dsa/problems/largest-divisible-subset?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_lis_largest_divisible_subset.addLink(new QuestionLink("VIDEO", "https://youtu.be/gDuZwBW9VvM"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_lis_largest_divisible_subset.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/longest-divisible-subset-dp-44/"));
        
        
        topic_16_7.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_lis_largest_divisible_subset);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_string_chain = new Question("dynamic_programming_patterns_and_problems_dp_on_lis_longest_string_chain", "Longest String Chain", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_string_chain.setSolveLink("https://leetcode.com/problems/longest-string-chain/");
        q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_string_chain.setEditorialLink("https://takeuforward.org/plus/dsa/problems/longest-string-chain?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_string_chain.addLink(new QuestionLink("VIDEO", "https://youtu.be/YY8iBaYcc4g"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_string_chain.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/longest-string-chain-dp-45/"));
        
        
        topic_16_7.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_string_chain);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_bitonic_subsequence = new Question("dynamic_programming_patterns_and_problems_dp_on_lis_longest_bitonic_subsequence", "Longest Bitonic Subsequence", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_bitonic_subsequence.setSolveLink("https://takeuforward.org/plus/dsa/problems/longest-bitonic-subsequence");
        q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_bitonic_subsequence.setEditorialLink("https://takeuforward.org/plus/dsa/problems/longest-bitonic-subsequence?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_bitonic_subsequence.addLink(new QuestionLink("VIDEO", "https://youtu.be/y4vN0WNdrlg"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_bitonic_subsequence.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/longest-bitonic-subsequence-dp-46/"));
        
        
        topic_16_7.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_lis_longest_bitonic_subsequence);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_lis_number_of_longest_increasing_subsequences = new Question("dynamic_programming_patterns_and_problems_dp_on_lis_number_of_longest_increasing_subsequences", "Number of Longest Increasing Subsequences", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_dp_on_lis_number_of_longest_increasing_subsequences.setSolveLink("https://leetcode.com/problems/number-of-longest-increasing-subsequence/");
        q_dynamic_programming_patterns_and_problems_dp_on_lis_number_of_longest_increasing_subsequences.setEditorialLink("https://takeuforward.org/plus/dsa/problems/number-of-longest-increasing-subsequences?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_lis_number_of_longest_increasing_subsequences.addLink(new QuestionLink("VIDEO", "https://youtu.be/cKVl1TFdNXg"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_lis_number_of_longest_increasing_subsequences.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/number-of-longest-increasing-subsequences-dp-47/"));
        
        
        topic_16_7.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_lis_number_of_longest_increasing_subsequences);
        
        
        section_16.addTopic(topic_16_7);
        
        // Topic: MCM DP | Partition DP
        Topic topic_16_8 = new Topic("dynamic_programming_patterns_and_problems_mcm_dp_partition_dp", "MCM DP | Partition DP");
        
        
        
        Question q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_matrix_chain_multiplication = new Question("dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_matrix_chain_multiplication", "Matrix chain multiplication", "HARD");
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_matrix_chain_multiplication.setSolveLink("https://takeuforward.org/plus/dsa/problems/matrix-chain-multiplication");
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_matrix_chain_multiplication.setEditorialLink("https://takeuforward.org/plus/dsa/problems/matrix-chain-multiplication?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_matrix_chain_multiplication.addLink(new QuestionLink("VIDEO", "https://youtu.be/vRVfmbCFW7Y"));
        
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_matrix_chain_multiplication.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/dynamic-programming/matrix-chain-multiplication-dp-48/"));
        
        
        topic_16_8.addQuestion(q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_matrix_chain_multiplication);
        
        Question q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_matrix_chain_multiplication_bottom_updp_49 = new Question("dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_matrix_chain_multiplication_bottom_updp_49", "Matrix Chain Multiplication | Bottom-Up|(DP-49)", "HARD");
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_matrix_chain_multiplication_bottom_updp_49.setSolveLink("https://takeuforward.org/plus/dsa/problems/matrix-chain-multiplication");
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_matrix_chain_multiplication_bottom_updp_49.setEditorialLink("https://takeuforward.org/plus/dsa/problems/matrix-chain-multiplication?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_matrix_chain_multiplication_bottom_updp_49.addLink(new QuestionLink("VIDEO", "https://youtu.be/pDCXsbAw5Cg"));
        
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_matrix_chain_multiplication_bottom_updp_49.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/matrix-chain-multiplication-tabulation-method-dp-49/"));
        
        
        topic_16_8.addQuestion(q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_matrix_chain_multiplication_bottom_updp_49);
        
        Question q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_minimum_cost_to_cut_the_stick = new Question("dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_minimum_cost_to_cut_the_stick", "Minimum cost to cut the stick", "HARD");
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_minimum_cost_to_cut_the_stick.setSolveLink("https://leetcode.com/problems/minimum-cost-to-cut-a-stick/");
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_minimum_cost_to_cut_the_stick.setEditorialLink("https://takeuforward.org/plus/dsa/problems/minimum-cost-to-cut-the-stick?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_minimum_cost_to_cut_the_stick.addLink(new QuestionLink("VIDEO", "https://youtu.be/xwomavsC86c"));
        
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_minimum_cost_to_cut_the_stick.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/minimum-cost-to-cut-the-stick-dp-50/"));
        
        
        topic_16_8.addQuestion(q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_minimum_cost_to_cut_the_stick);
        
        Question q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_burst_balloons = new Question("dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_burst_balloons", "Burst balloons", "HARD");
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_burst_balloons.setSolveLink("https://leetcode.com/problems/burst-balloons/");
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_burst_balloons.setEditorialLink("https://takeuforward.org/plus/dsa/problems/burst-balloons?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_burst_balloons.addLink(new QuestionLink("VIDEO", "https://youtu.be/Yz4LlDSlkns"));
        
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_burst_balloons.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/burst-balloons-partition-dp-dp-51/"));
        
        
        topic_16_8.addQuestion(q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_burst_balloons);
        
        Question q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_different_ways_to_evaluate_a_boolean_expression = new Question("dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_different_ways_to_evaluate_a_boolean_expression", "Different Ways to Evaluate a Boolean Expression", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_different_ways_to_evaluate_a_boolean_expression.setSolveLink("https://leetcode.com/problems/parsing-a-boolean-expression/");
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_different_ways_to_evaluate_a_boolean_expression.setEditorialLink("https://takeuforward.org/plus/dsa/problems/different-ways-to-evaluate-a-boolean-expression?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_different_ways_to_evaluate_a_boolean_expression.addLink(new QuestionLink("VIDEO", "https://youtu.be/MM7fXopgyjw"));
        
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_different_ways_to_evaluate_a_boolean_expression.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/evaluate-boolean-expression-to-true-partition-dp-dp-52/"));
        
        
        topic_16_8.addQuestion(q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_different_ways_to_evaluate_a_boolean_expression);
        
        Question q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_palindrome_partitioning_ii = new Question("dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_palindrome_partitioning_ii", "Palindrome partitioning II ", "HARD");
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_palindrome_partitioning_ii.setSolveLink("https://leetcode.com/problems/palindrome-partitioning-ii/");
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_palindrome_partitioning_ii.setEditorialLink("https://takeuforward.org/plus/dsa/problems/palindrome-partitioning-ii-?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_palindrome_partitioning_ii.addLink(new QuestionLink("VIDEO", "https://youtu.be/_H8V5hJUGd0"));
        
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_palindrome_partitioning_ii.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/palindrome-partitioning-ii-front-partition-dp-53/"));
        
        
        topic_16_8.addQuestion(q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_palindrome_partitioning_ii);
        
        Question q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_partition_array_for_maximum_sum = new Question("dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_partition_array_for_maximum_sum", "Partition Array for Maximum Sum", "MEDIUM");
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_partition_array_for_maximum_sum.setSolveLink("https://leetcode.com/problems/partition-array-for-maximum-sum/");
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_partition_array_for_maximum_sum.setEditorialLink("");
        
        
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_partition_array_for_maximum_sum.addLink(new QuestionLink("VIDEO", "https://youtu.be/PhWWJmaKfMc"));
        
        q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_partition_array_for_maximum_sum.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/partition-array-for-maximum-sum-front-partition-dp-54/"));
        
        
        topic_16_8.addQuestion(q_dynamic_programming_patterns_and_problems_mcm_dp_partition_dp_partition_array_for_maximum_sum);
        
        
        section_16.addTopic(topic_16_8);
        
        // Topic: DP on Squares
        Topic topic_16_9 = new Topic("dynamic_programming_patterns_and_problems_dp_on_squares", "DP on Squares");
        
        
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_squares_maximum_rectangle_area_with_all_1sdp_55 = new Question("dynamic_programming_patterns_and_problems_dp_on_squares_maximum_rectangle_area_with_all_1sdp_55", "Maximum Rectangle Area with all 1's|(DP-55)", "HARD");
        q_dynamic_programming_patterns_and_problems_dp_on_squares_maximum_rectangle_area_with_all_1sdp_55.setSolveLink("https://leetcode.com/problems/maximal-rectangle/");
        q_dynamic_programming_patterns_and_problems_dp_on_squares_maximum_rectangle_area_with_all_1sdp_55.setEditorialLink("https://takeuforward.org/plus/dsa/problems/maximum-rectangles?tab=editorial");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_squares_maximum_rectangle_area_with_all_1sdp_55.addLink(new QuestionLink("VIDEO", "https://youtu.be/tOylVCugy9k"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_squares_maximum_rectangle_area_with_all_1sdp_55.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/maximum-rectangle-area-with-all-1s-dp-on-rectangles-dp-55/"));
        
        
        topic_16_9.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_squares_maximum_rectangle_area_with_all_1sdp_55);
        
        Question q_dynamic_programming_patterns_and_problems_dp_on_squares_count_square_submatrices_with_all_onesdp_56 = new Question("dynamic_programming_patterns_and_problems_dp_on_squares_count_square_submatrices_with_all_onesdp_56", "Count Square Submatrices with All Ones|(DP-56)", "EASY");
        q_dynamic_programming_patterns_and_problems_dp_on_squares_count_square_submatrices_with_all_onesdp_56.setSolveLink("https://leetcode.com/problems/count-square-submatrices-with-all-ones/");
        q_dynamic_programming_patterns_and_problems_dp_on_squares_count_square_submatrices_with_all_onesdp_56.setEditorialLink("");
        
        
        q_dynamic_programming_patterns_and_problems_dp_on_squares_count_square_submatrices_with_all_onesdp_56.addLink(new QuestionLink("VIDEO", "https://youtu.be/auS1fynpnjo"));
        
        q_dynamic_programming_patterns_and_problems_dp_on_squares_count_square_submatrices_with_all_onesdp_56.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/count-square-submatrices-with-all-1s-dp-on-rectangles-dp-56/"));
        
        
        topic_16_9.addQuestion(q_dynamic_programming_patterns_and_problems_dp_on_squares_count_square_submatrices_with_all_onesdp_56);
        
        
        section_16.addTopic(topic_16_9);
        
        
        Roadmap.addSection(section_16);
        
        // ==========================================
        // Section: Tries
        // ==========================================
        RoadmapSection section_17 = new RoadmapSection("tries", "Tries");
        
        
        
        // Topic: Theory
        Topic topic_17_1 = new Topic("tries_theory", "Theory");
        
        
        
        Question q_tries_theory_trie_implementation_and_operations = new Question("tries_theory_trie_implementation_and_operations", "Trie Implementation and Operations", "HARD");
        q_tries_theory_trie_implementation_and_operations.setSolveLink("https://leetcode.com/problems/implement-trie-prefix-tree/");
        q_tries_theory_trie_implementation_and_operations.setEditorialLink("https://takeuforward.org/plus/dsa/problems/trie-implementation-and-operations?tab=editorial");
        
        
        q_tries_theory_trie_implementation_and_operations.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=dBGUmUQhjaM&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp"));
        
        q_tries_theory_trie_implementation_and_operations.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/implement-trie-1/"));
        
        
        topic_17_1.addQuestion(q_tries_theory_trie_implementation_and_operations);
        
        
        section_17.addTopic(topic_17_1);
        
        // Topic: Problems
        Topic topic_17_2 = new Topic("tries_problems", "Problems");
        
        
        
        Question q_tries_problems_trie_implementation_and_advanced_operations = new Question("tries_problems_trie_implementation_and_advanced_operations", "Trie Implementation and Advanced Operations", "HARD");
        q_tries_problems_trie_implementation_and_advanced_operations.setSolveLink("https://takeuforward.org/plus/dsa/problems/trie-implementation-and-advanced-operations");
        q_tries_problems_trie_implementation_and_advanced_operations.setEditorialLink("https://takeuforward.org/plus/dsa/problems/trie-implementation-and-advanced-operations?tab=editorial");
        
        
        q_tries_problems_trie_implementation_and_advanced_operations.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/implement-trie-ii/"));
        
        
        topic_17_2.addQuestion(q_tries_problems_trie_implementation_and_advanced_operations);
        
        Question q_tries_problems_longest_word_with_all_prefixes = new Question("tries_problems_longest_word_with_all_prefixes", "Longest Word with All Prefixes", "MEDIUM");
        q_tries_problems_longest_word_with_all_prefixes.setSolveLink("https://takeuforward.org/plus/dsa/problems/longest-word-with-all-prefixes");
        q_tries_problems_longest_word_with_all_prefixes.setEditorialLink("https://takeuforward.org/plus/dsa/problems/longest-word-with-all-prefixes?tab=editorial");
        
        
        q_tries_problems_longest_word_with_all_prefixes.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=AWnBa91lThI&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=3"));
        
        
        topic_17_2.addQuestion(q_tries_problems_longest_word_with_all_prefixes);
        
        Question q_tries_problems_number_of_distinct_substrings_in_a_string = new Question("tries_problems_number_of_distinct_substrings_in_a_string", "Number of distinct substrings in a string", "MEDIUM");
        q_tries_problems_number_of_distinct_substrings_in_a_string.setSolveLink("https://takeuforward.org/plus/dsa/problems/number-of-distinct-substrings-in-a-string");
        q_tries_problems_number_of_distinct_substrings_in_a_string.setEditorialLink("https://takeuforward.org/plus/dsa/problems/number-of-distinct-substrings-in-a-string?tab=editorial");
        
        
        q_tries_problems_number_of_distinct_substrings_in_a_string.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=RV0QeTyHZxo&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=4"));
        
        q_tries_problems_number_of_distinct_substrings_in_a_string.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/number-of-distinct-substrings-in-a-string-using-trie/"));
        
        
        topic_17_2.addQuestion(q_tries_problems_number_of_distinct_substrings_in_a_string);
        
        Question q_tries_problems_bit_prerequisites_for_trie_problems = new Question("tries_problems_bit_prerequisites_for_trie_problems", "Bit PreRequisites for TRIE Problems", "EASY");
        q_tries_problems_bit_prerequisites_for_trie_problems.setSolveLink("https://youtu.be/5iyuU4hQFrw");
        q_tries_problems_bit_prerequisites_for_trie_problems.setEditorialLink("");
        
        
        q_tries_problems_bit_prerequisites_for_trie_problems.addLink(new QuestionLink("VIDEO", "https://youtu.be/5iyuU4hQFrw"));
        
        
        topic_17_2.addQuestion(q_tries_problems_bit_prerequisites_for_trie_problems);
        
        Question q_tries_problems_maximum_xor_of_two_numbers_in_an_array = new Question("tries_problems_maximum_xor_of_two_numbers_in_an_array", "Maximum XOR of two numbers in an array", "HARD");
        q_tries_problems_maximum_xor_of_two_numbers_in_an_array.setSolveLink("https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/");
        q_tries_problems_maximum_xor_of_two_numbers_in_an_array.setEditorialLink("https://takeuforward.org/plus/dsa/problems/maximum-xor-of-two-numbers-in-an-array?tab=editorial");
        
        
        q_tries_problems_maximum_xor_of_two_numbers_in_an_array.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=EIhAwfHubE8&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=6"));
        
        q_tries_problems_maximum_xor_of_two_numbers_in_an_array.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/maximum-xor-of-two-numbers-in-an-array/"));
        
        
        topic_17_2.addQuestion(q_tries_problems_maximum_xor_of_two_numbers_in_an_array);
        
        Question q_tries_problems_maximum_xor_with_an_element_from_an_array = new Question("tries_problems_maximum_xor_with_an_element_from_an_array", "Maximum Xor with an element from an array", "HARD");
        q_tries_problems_maximum_xor_with_an_element_from_an_array.setSolveLink("https://leetcode.com/problems/maximum-xor-with-an-element-from-array/");
        q_tries_problems_maximum_xor_with_an_element_from_an_array.setEditorialLink("https://takeuforward.org/plus/dsa/problems/maximum-xor-with-an-element-from-an-array?tab=editorial");
        
        
        q_tries_problems_maximum_xor_with_an_element_from_an_array.addLink(new QuestionLink("VIDEO", "https://www.youtube.com/watch?v=Q8LhG9Pi5KM&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=7"));
        
        q_tries_problems_maximum_xor_with_an_element_from_an_array.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/trie/maximum-xor-queries-trie/"));
        
        
        topic_17_2.addQuestion(q_tries_problems_maximum_xor_with_an_element_from_an_array);
        
        
        section_17.addTopic(topic_17_2);
        
        
        Roadmap.addSection(section_17);
        
        // ==========================================
        // Section: Strings
        // ==========================================
        RoadmapSection section_18 = new RoadmapSection("strings", "Strings");
        
        
        
        // Topic: Hard Problems
        Topic topic_18_1 = new Topic("strings_hard_problems", "Hard Problems");
        
        
        
        Question q_strings_hard_problems_minimum_number_of_bracket_reversals_to_make_an_expression_balanced = new Question("strings_hard_problems_minimum_number_of_bracket_reversals_to_make_an_expression_balanced", "Minimum number of bracket reversals to make an expression balanced", "HARD");
        q_strings_hard_problems_minimum_number_of_bracket_reversals_to_make_an_expression_balanced.setSolveLink("https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/");
        q_strings_hard_problems_minimum_number_of_bracket_reversals_to_make_an_expression_balanced.setEditorialLink("https://takeuforward.org/plus/dsa/problems/minimum-number-of-bracket-reversals-to-make-an-expression-balanced?tab=editorial");
        
        
        q_strings_hard_problems_minimum_number_of_bracket_reversals_to_make_an_expression_balanced.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced"));
        
        
        topic_18_1.addQuestion(q_strings_hard_problems_minimum_number_of_bracket_reversals_to_make_an_expression_balanced);
        
        Question q_strings_hard_problems_count_and_say = new Question("strings_hard_problems_count_and_say", "Count and say", "HARD");
        q_strings_hard_problems_count_and_say.setSolveLink("https://leetcode.com/problems/count-and-say/");
        q_strings_hard_problems_count_and_say.setEditorialLink("https://takeuforward.org/plus/dsa/problems/count-and-say?tab=editorial");
        
        
        q_strings_hard_problems_count_and_say.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/count-and-say"));
        
        
        topic_18_1.addQuestion(q_strings_hard_problems_count_and_say);
        
        Question q_strings_hard_problems_hashing_in_strings_theory = new Question("strings_hard_problems_hashing_in_strings_theory", "Hashing In Strings | Theory", "EASY");
        q_strings_hard_problems_hashing_in_strings_theory.setSolveLink("https://takeuforward.org/data-structure/hashing-in-strings");
        q_strings_hard_problems_hashing_in_strings_theory.setEditorialLink("");
        
        
        q_strings_hard_problems_hashing_in_strings_theory.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/hashing-in-strings"));
        
        
        topic_18_1.addQuestion(q_strings_hard_problems_hashing_in_strings_theory);
        
        Question q_strings_hard_problems_rabin_karp_algorithm = new Question("strings_hard_problems_rabin_karp_algorithm", "Rabin Karp Algorithm", "HARD");
        q_strings_hard_problems_rabin_karp_algorithm.setSolveLink("https://leetcode.com/problems/repeated-string-match/discuss/416144/Rabin-Karp-algorithm-C%2B%2B-implementation");
        q_strings_hard_problems_rabin_karp_algorithm.setEditorialLink("https://takeuforward.org/plus/dsa/problems/rabin-karp-algorithm?tab=editorial");
        
        
        
        topic_18_1.addQuestion(q_strings_hard_problems_rabin_karp_algorithm);
        
        Question q_strings_hard_problems_z_function = new Question("strings_hard_problems_z_function", "Z function", "HARD");
        q_strings_hard_problems_z_function.setSolveLink("https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2/");
        q_strings_hard_problems_z_function.setEditorialLink("");
        
        
        
        topic_18_1.addQuestion(q_strings_hard_problems_z_function);
        
        Question q_strings_hard_problems_kmp_algorithm_or_lps_array = new Question("strings_hard_problems_kmp_algorithm_or_lps_array", "KMP Algorithm or LPS array", "HARD");
        q_strings_hard_problems_kmp_algorithm_or_lps_array.setSolveLink("https://leetcode.com/problems/implement-strstr/");
        q_strings_hard_problems_kmp_algorithm_or_lps_array.setEditorialLink("https://takeuforward.org/plus/dsa/problems/kmp-algorithm-or-lps-array?tab=editorial");
        
        
        q_strings_hard_problems_kmp_algorithm_or_lps_array.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/kmp-algorithm-or-lps-array"));
        
        
        topic_18_1.addQuestion(q_strings_hard_problems_kmp_algorithm_or_lps_array);
        
        Question q_strings_hard_problems_shortest_palindrome = new Question("strings_hard_problems_shortest_palindrome", "Shortest Palindrome", "HARD");
        q_strings_hard_problems_shortest_palindrome.setSolveLink("https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2/");
        q_strings_hard_problems_shortest_palindrome.setEditorialLink("");
        
        
        
        topic_18_1.addQuestion(q_strings_hard_problems_shortest_palindrome);
        
        Question q_strings_hard_problems_longest_happy_prefix = new Question("strings_hard_problems_longest_happy_prefix", "Longest happy prefix", "HARD");
        q_strings_hard_problems_longest_happy_prefix.setSolveLink("https://leetcode.com/problems/longest-happy-prefix/");
        q_strings_hard_problems_longest_happy_prefix.setEditorialLink("https://takeuforward.org/plus/dsa/problems/longest-happy-prefix?tab=editorial");
        
        
        q_strings_hard_problems_longest_happy_prefix.addLink(new QuestionLink("ARTICLE", "https://takeuforward.org/data-structure/longest-happy-prefix"));
        
        
        topic_18_1.addQuestion(q_strings_hard_problems_longest_happy_prefix);
        
        Question q_strings_hard_problems_count_palindromic_subsequences = new Question("strings_hard_problems_count_palindromic_subsequences", "Count Palindromic Subsequences", "MEDIUM");
        q_strings_hard_problems_count_palindromic_subsequences.setSolveLink("https://leetcode.com/problems/count-palindromic-subsequences/");
        q_strings_hard_problems_count_palindromic_subsequences.setEditorialLink("https://takeuforward.org/plus/dsa/problems/count-palindromic-subsequences?tab=editorial");
        
        
        
        topic_18_1.addQuestion(q_strings_hard_problems_count_palindromic_subsequences);
        
        
        section_18.addTopic(topic_18_1);
        
        
        Roadmap.addSection(section_18);
        
        // 1. Prepare and save top-level Parent Sections
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

        // 2. Prepare and save Sub-sections (Topics) referencing saved parent sections
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

        // 3. Prepare Questions list
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
                        .description(q.title)
                        .difficulty(diffEnum)
                        .build();
                    dbQuestionsToSave.add(dbQ);
                    originalQuestions.add(q);
                    dbTopicForQuestions.add(dbTopic);
                }
            }
        }
        
        // Save questions in batch to generate their IDs
        List<com.careerforge.roadmap.entity.Question> savedQuestions = questionRepository.saveAll(dbQuestionsToSave);
        questionRepository.flush();

        // 4. Prepare and save QuestionLinks and RoadmapSectionQuestion mappings
        List<com.careerforge.roadmap.entity.QuestionLink> dbLinksToSave = new ArrayList<>();
        List<com.careerforge.roadmap.entity.RoadmapSectionQuestion> dbRSQsToSave = new ArrayList<>();

        int questionPos = 0;
        for (int i = 0; i < savedQuestions.size(); i++) {
            com.careerforge.roadmap.entity.Question dbQ = savedQuestions.get(i);
            Question q = originalQuestions.get(i);
            com.careerforge.roadmap.entity.RoadmapSection dbTopic = dbTopicForQuestions.get(i);

            // Reset question position counter if we transition to a new topic section
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

    // Helper Static Classes representing the in-memory tree structure
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