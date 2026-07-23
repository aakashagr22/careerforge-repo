package com.careerforge.roadmap.seeder;

import java.util.ArrayList;
import java.util.List;

public class CppPrepSeeder {

    public static void seed(
        com.careerforge.roadmap.entity.Roadmap dbRoadmap,
        com.careerforge.roadmap.repository.RoadmapSectionRepository roadmapSectionRepository,
        com.careerforge.roadmap.repository.QuestionRepository questionRepository,
        com.careerforge.roadmap.repository.QuestionLinkRepository questionLinkRepository,
        com.careerforge.roadmap.repository.RoadmapSectionQuestionRepository roadmapSectionQuestionRepository
    ) {
        System.out.println("Seeding Roadmap: C++ Programming Master Preparation Sheet");
        Roadmap.sections.clear();

        RoadmapSection s;
        Topic t;

        // Top Indian & Global Curated YouTube Resources
        String loveBabbarPlaylist = "https://www.youtube.com/playlist?list=PLDzeHXRdEMz253xmACfVb9fXIn0gA0HZS"; // CodeHelp - Love Babbar
        String striverCppBasics  = "https://www.youtube.com/watch?v=EAR7De6Goz4";                            // takeUforward - Striver
        String striverStlVideo   = "https://www.youtube.com/watch?v=RRVYpIET_RU";                            // takeUforward STL Masterclass
        String apniKakshaCpp    = "https://www.youtube.com/playlist?list=PLfqMhTWsafeTYWIGLhVxhaVfzlo8Dcspo"; // Apni Kaksha C++ Course
        String codeWithHarryCpp = "https://www.youtube.com/playlist?list=PLu0W_9lII9agpFUAlPFe_VNSlXW5uE0YL"; // CodeWithHarry C++ Playlist
        String jennysLectures   = "https://www.youtube.com/playlist?list=PLdo5W4BvXw8z4UepQ38zpS9d_P4G50s0O"; // Jenny's Lectures CS IT
        String chernoPlaylist   = "https://www.youtube.com/playlist?list=PLlrATfBNZ98dudnM48vW95sZm6gndF58M"; // The Cherno C++

        // ==========================================
        // Section 1: Introduction to C++
        // ==========================================
        s = createSection("Introduction to C++");

        t = createTopic(s, "What is C++?");
        addQ(t, "History and Evolution of C++ (Bjarne Stroustrup)", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/history",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", striverCppBasics,
            "VIDEO", apniKakshaCpp);
        addQ(t, "Features of C++ (Fast, Multi-paradigm, Low-level & High-level)", "EASY",
            "ARTICLE", "https://isocpp.org/get-started",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", codeWithHarryCpp,
            "VIDEO", apniKakshaCpp);
        addQ(t, "C vs C++ Key Differences", "EASY",
            "ARTICLE", "https://www.geeksforgeeks.org/difference-between-c-and-c/",
            "VIDEO", jennysLectures,
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", codeWithHarryCpp);
        addQ(t, "C++ Standards Evolution (C++11, C++14, C++17, C++20, C++23)", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/compiler_support",
            "VIDEO", chernoPlaylist,
            "VIDEO", loveBabbarPlaylist);

        t = createTopic(s, "Setting Up Environment & Execution");
        addQ(t, "Compilers (GCC/G++, Clang, MSVC) & VS Code Setup", "EASY",
            "ARTICLE", "https://code.visualstudio.com/docs/cpp/config-mingw",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", codeWithHarryCpp,
            "VIDEO", apniKakshaCpp);
        addQ(t, "Structure of a C++ Program (main, iostream, std namespace)", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/io/basic_ostream",
            "VIDEO", striverCppBasics,
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp);
        addQ(t, "std::cout, std::cin, std::cerr, and std::endl vs '\\n'", "EASY",
            "ARTICLE", "https://takeuforward.org/c/c-basic-input-output/",
            "VIDEO", striverCppBasics,
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", codeWithHarryCpp);


        // ==========================================
        // Section 2: Variables, Data Types & Memory Model
        // ==========================================
        s = createSection("Variables, Data Types & Memory Model");

        t = createTopic(s, "Primitive Data Types & Type Casting");
        addQ(t, "Integer Types (short, int, long, long long, unsigned)", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/types",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", striverCppBasics,
            "VIDEO", apniKakshaCpp);
        addQ(t, "Floating-Point Types (float, double, long double) & IEEE 754 Precision", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/types",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", jennysLectures);
        addQ(t, "char, bool, and std::size_t", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/types/size_t",
            "VIDEO", striverCppBasics,
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", codeWithHarryCpp);
        addQ(t, "Type Casting: C-Style Casts vs static_cast, const_cast, reinterpret_cast", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/static_cast",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist,
            "VIDEO", jennysLectures);

        t = createTopic(s, "Memory Model Fundamentals");
        addQ(t, "Scope, Lifetime, and Storage Duration (auto, static, extern)", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/storage_duration",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", jennysLectures,
            "VIDEO", chernoPlaylist);
        addQ(t, "Stack vs Heap Memory Layout in C++", "MEDIUM",
            "ARTICLE", "https://www.geeksforgeeks.org/stack-vs-heap-memory-allocation/",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp,
            "VIDEO", chernoPlaylist);


        // ==========================================
        // Section 3: Control Flow & Operators
        // ==========================================
        s = createSection("Control Flow & Operators");

        t = createTopic(s, "Operators");
        addQ(t, "Arithmetic, Assignment, Increment/Decrement (++i vs i++)", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/operator_incdec",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", striverCppBasics,
            "VIDEO", apniKakshaCpp);
        addQ(t, "Relational and Logical Operators & Short-Circuit Evaluation", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/operator_logical",
            "VIDEO", striverCppBasics,
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", codeWithHarryCpp);
        addQ(t, "Bitwise Operators (&, |, ^, ~, <<, >>)", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/operator_bitwise",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp,
            "VIDEO", jennysLectures);
        addQ(t, "Ternary Operator (?:) and Operator Precedence", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/operator_precedence",
            "VIDEO", striverCppBasics,
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", codeWithHarryCpp);

        t = createTopic(s, "Control Flow Statements");
        addQ(t, "if, else if, else Conditionals", "EASY",
            "ARTICLE", "https://takeuforward.org/if-else/if-else-statements/",
            "VIDEO", striverCppBasics,
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp);
        addQ(t, "switch-case Statement and Fall-through Behavior", "EASY",
            "ARTICLE", "https://takeuforward.org/switch-case/switch-case-statements/",
            "VIDEO", striverCppBasics,
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", codeWithHarryCpp);
        addQ(t, "for, while, and do-while Loops", "EASY",
            "ARTICLE", "https://takeuforward.org/for-loop/understanding-for-loop/",
            "VIDEO", striverCppBasics,
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp);
        addQ(t, "Range-based for Loops (C++11)", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/range-for",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);
        addQ(t, "break, continue, and goto Statements", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/break",
            "VIDEO", striverCppBasics,
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", codeWithHarryCpp);


        // ==========================================
        // Section 4: Functions & References
        // ==========================================
        s = createSection("Functions & References");

        t = createTopic(s, "Function Fundamentals");
        addQ(t, "Function Declaration, Definition, and Prototypes", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/functions",
            "VIDEO", striverCppBasics,
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp);
        addQ(t, "Pass by Value vs Pass by Reference (&) vs Pass by Pointer (*)", "EASY",
            "ARTICLE", "https://takeuforward.org/data-structure/functions-pass-by-reference-and-value",
            "VIDEO", striverCppBasics,
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", jennysLectures);
        addQ(t, "Const Parameters & References (const T&)", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/reference",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);
        addQ(t, "Default Arguments and Function Overloading Rules", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/overload_resolution",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", codeWithHarryCpp,
            "VIDEO", apniKakshaCpp);

        t = createTopic(s, "Inline Functions & Recursion");
        addQ(t, "inline Functions and Compiler Inlining", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/inline",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", jennysLectures);
        addQ(t, "Recursion, Call Stack, and Stack Overflow Mechanism", "MEDIUM",
            "ARTICLE", "https://www.geeksforgeeks.org/recursion/",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp,
            "VIDEO", striverCppBasics);


        // ==========================================
        // Section 5: Pointers and Raw Memory
        // ==========================================
        s = createSection("Pointers and Raw Memory");

        t = createTopic(s, "Pointer Basics");
        addQ(t, "Pointer Syntax, Dereferencing (*), and Address-of (&)", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/pointer",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp,
            "VIDEO", jennysLectures);
        addQ(t, "Pointer Arithmetic (Incrementing/Decrementing Pointers)", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/operator_arithmetic#Pointer_arithmetic",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", jennysLectures,
            "VIDEO", codeWithHarryCpp);
        addQ(t, "nullptr vs NULL vs 0", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/types/nullptr",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);
        addQ(t, "Void Pointers (void*) and Type Casting Pointers", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/pointer#Pointers_to_void",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", jennysLectures);

        t = createTopic(s, "Dynamic Memory Management");
        addQ(t, "new and delete Operators for Dynamic Allocation", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/new",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp,
            "VIDEO", jennysLectures);
        addQ(t, "Dynamic Arrays with new[] and delete[]", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/delete",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp);
        addQ(t, "Memory Leaks, Dangling Pointers, and Double Free Errors", "MEDIUM",
            "ARTICLE", "https://www.geeksforgeeks.org/memory-leak-in-c-and-how-to-avoid-it/",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", jennysLectures);


        // ==========================================
        // Section 6: Smart Pointers & Memory Safety
        // ==========================================
        s = createSection("Smart Pointers & Memory Safety");

        t = createTopic(s, "Smart Pointers (C++11)");
        addQ(t, "std::unique_ptr: Exclusive Ownership & std::make_unique (C++14)", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/memory/unique_ptr",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist,
            "VIDEO", jennysLectures);
        addQ(t, "std::shared_ptr: Shared Ownership, Reference Counting & std::make_shared", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/memory/shared_ptr",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);
        addQ(t, "std::weak_ptr: Non-owning References & Resolving Circular Dependencies", "HARD",
            "ARTICLE", "https://en.cppreference.com/w/cpp/memory/weak_ptr",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);


        // ==========================================
        // Section 7: Classes and Objects (OOP Basics)
        // ==========================================
        s = createSection("Classes and Objects (OOP Basics)");

        t = createTopic(s, "Class Structure");
        addQ(t, "Defining Classes & Structs (class vs struct)", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/class",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp,
            "VIDEO", codeWithHarryCpp);
        addQ(t, "Access Specifiers (public, private, protected)", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/access",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp,
            "VIDEO", jennysLectures);
        addQ(t, "The this Pointer and Method Chaining", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/this",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", jennysLectures);
        addQ(t, "const Member Functions & mutable Keyword", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/member_functions#const-_and_volatile-qualified_member_functions",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);
        addQ(t, "static Class Members (Variables & Methods)", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/static",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", codeWithHarryCpp,
            "VIDEO", jennysLectures);


        // ==========================================
        // Section 8: Constructors & Destructors
        // ==========================================
        s = createSection("Constructors & Destructors");

        t = createTopic(s, "Constructors In-Depth");
        addQ(t, "Default and Parameterized Constructors", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/initializer_list",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp,
            "VIDEO", codeWithHarryCpp);
        addQ(t, "Copy Constructor & Deep Copy vs Shallow Copy", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/copy_constructor",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp,
            "VIDEO", jennysLectures);
        addQ(t, "Member Initializer Lists", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/constructor",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);
        addQ(t, "Delegating Constructors and explicit Constructors", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/explicit",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);

        t = createTopic(s, "Destructors");
        addQ(t, "Destructor (~ClassName) & Object Cleanup Order", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/destructor",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp,
            "VIDEO", codeWithHarryCpp);


        // ==========================================
        // Section 9: Inheritance Mechanics
        // ==========================================
        s = createSection("Inheritance Mechanics");

        t = createTopic(s, "Inheritance Types & Control");
        addQ(t, "Public, Private, and Protected Inheritance Modes", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/derived_class",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp,
            "VIDEO", codeWithHarryCpp);
        addQ(t, "Multiple Inheritance and Diamond Problem", "MEDIUM",
            "ARTICLE", "https://www.geeksforgeeks.org/multiple-inheritance-in-c/",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", jennysLectures);
        addQ(t, "Virtual Base Classes (virtual inheritance)", "HARD",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/derived_class#Virtual_base_classes",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", jennysLectures);


        // ==========================================
        // Section 10: Polymorphism & Virtual Functions
        // ==========================================
        s = createSection("Polymorphism & Virtual Functions");

        t = createTopic(s, "Polymorphism");
        addQ(t, "Compile-time vs Runtime Polymorphism", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/virtual",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp,
            "VIDEO", codeWithHarryCpp);
        addQ(t, "virtual Functions and Virtual Destructors", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/virtual",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", jennysLectures,
            "VIDEO", chernoPlaylist);
        addQ(t, "Pure Virtual Functions & Abstract Classes", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/abstract_class",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp,
            "VIDEO", codeWithHarryCpp);
        addQ(t, "Virtual Method Table (vtable) and vptr Internals", "HARD",
            "ARTICLE", "https://preshing.com/20130402/how-compiler-makes-a-vtable/",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);
        addQ(t, "override and final Specifiers (C++11)", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/override",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);


        // ==========================================
        // Section 11: Operator Overloading & Copy-Swap Idiom
        // ==========================================
        s = createSection("Operator Overloading & Copy-Swap Idiom");

        t = createTopic(s, "Operator Overloading");
        addQ(t, "Overloading Arithmetic & Relational Operators (+, -, ==, <)", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/operators",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", codeWithHarryCpp,
            "VIDEO", jennysLectures);
        addQ(t, "Overloading Stream Insertion (<<) and Extraction (>>) Operators", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/operators",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", jennysLectures);
        addQ(t, "Overloading Subscript [] and Function Call () Operators", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/operators",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);
        addQ(t, "Copy-and-Swap Idiom for Exception-Safe Assignment Operator", "HARD",
            "ARTICLE", "https://stackoverflow.com/questions/3279543/what-is-the-copy-and-swap-idiom",
            "VIDEO", chernoPlaylist,
            "VIDEO", loveBabbarPlaylist);


        // ==========================================
        // Section 12: Move Semantics & Rvalue References
        // ==========================================
        s = createSection("Move Semantics & Rvalue References");

        t = createTopic(s, "Move Semantics (C++11)");
        addQ(t, "Lvalues vs Rvalues and Lvalue References (T&) vs Rvalue References (T&&)", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/value_category",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);
        addQ(t, "Move Constructor and Move Assignment Operator", "HARD",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/move_constructor",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);
        addQ(t, "std::move Unconditional Cast", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/utility/move",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);
        addQ(t, "std::forward and Perfect Forwarding (Universal References)", "HARD",
            "ARTICLE", "https://en.cppreference.com/w/cpp/utility/forward",
            "VIDEO", chernoPlaylist,
            "VIDEO", loveBabbarPlaylist);


        // ==========================================
        // Section 13: Templates & Generic Programming
        // ==========================================
        s = createSection("Templates & Generic Programming");

        t = createTopic(s, "Templates");
        addQ(t, "Function Templates and Class Templates", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/templates",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", codeWithHarryCpp,
            "VIDEO", apniKakshaCpp);
        addQ(t, "Full and Partial Template Specialization", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/template_specialization",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);
        addQ(t, "Variadic Templates (typename... Args) & Fold Expressions (C++17)", "HARD",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/parameter_pack",
            "VIDEO", chernoPlaylist,
            "VIDEO", loveBabbarPlaylist);
        addQ(t, "SFINAE (Substitution Failure Is Not An Error) & std::enable_if", "HARD",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/sfinae",
            "VIDEO", chernoPlaylist,
            "VIDEO", loveBabbarPlaylist);
        addQ(t, "C++20 Concepts and requires Clause", "HARD",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/constraints",
            "VIDEO", chernoPlaylist,
            "VIDEO", loveBabbarPlaylist);


        // ==========================================
        // Section 14: STL Containers In-Depth
        // ==========================================
        s = createSection("STL Containers In-Depth");

        t = createTopic(s, "Sequence Containers");
        addQ(t, "std::vector Internal Memory, Capacity, and Resizing", "EASY",
            "ARTICLE", "https://takeuforward.org/c/c-stl-tutorial-most-frequent-used-stl-containers/",
            "VIDEO", striverStlVideo,
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp);
        addQ(t, "std::deque, std::list, std::forward_list, and std::array", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/container",
            "VIDEO", striverStlVideo,
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp);

        t = createTopic(s, "Associative & Unordered Containers");
        addQ(t, "std::set, std::multiset, std::map, std::multimap (Red-Black Trees)", "EASY",
            "ARTICLE", "https://takeuforward.org/c/c-stl-tutorial-most-frequent-used-stl-containers/",
            "VIDEO", striverStlVideo,
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp);
        addQ(t, "std::unordered_set and std::unordered_map (Hash Tables & Custom Hash Functions)", "MEDIUM",
            "ARTICLE", "https://takeuforward.org/c/c-stl-tutorial-most-frequent-used-stl-containers/",
            "VIDEO", striverStlVideo,
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp);


        // ==========================================
        // Section 15: STL Iterators & Algorithms
        // ==========================================
        s = createSection("STL Iterators & Algorithms");

        t = createTopic(s, "Iterators");
        addQ(t, "Iterator Categories (Input, Output, Forward, Bidirectional, Random Access)", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/iterator",
            "VIDEO", striverStlVideo,
            "VIDEO", loveBabbarPlaylist);

        t = createTopic(s, "STL Algorithms");
        addQ(t, "std::sort with Custom Comparators & Lambdas", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/algorithm/sort",
            "VIDEO", striverStlVideo,
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", apniKakshaCpp);
        addQ(t, "Binary Search, std::lower_bound, and std::upper_bound", "EASY",
            "ARTICLE", "https://takeuforward.org/data-structure/lower-bound-implement/",
            "VIDEO", striverCppBasics,
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", striverStlVideo);
        addQ(t, "std::transform, std::accumulate, std::find_if, std::count_if", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/algorithm",
            "VIDEO", striverStlVideo,
            "VIDEO", loveBabbarPlaylist);


        // ==========================================
        // Section 16: Strings and String View
        // ==========================================
        s = createSection("Strings and String View");

        t = createTopic(s, "String Operations");
        addQ(t, "std::string Class, C-Strings (char*), and Conversion", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/string/basic_string",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", striverCppBasics,
            "VIDEO", apniKakshaCpp);
        addQ(t, "std::string_view for Zero-Copy String Parameters (C++17)", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/string/basic_string_view",
            "VIDEO", chernoPlaylist,
            "VIDEO", loveBabbarPlaylist);
        addQ(t, "Regular Expressions with std::regex", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/regex",
            "VIDEO", codeWithHarryCpp,
            "VIDEO", loveBabbarPlaylist);


        // ==========================================
        // Section 17: Modern C++ Essentials (C++11 to C++20)
        // ==========================================
        s = createSection("Modern C++ Essentials");

        t = createTopic(s, "Type Deduction & Expressions");
        addQ(t, "auto Type Deduction and decltype Specifier", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/auto",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);
        addQ(t, "Lambda Expressions (Capture Lists [=, &], Parameters, Return Types)", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/lambda",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);
        addQ(t, "constexpr and consteval Expressions", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/constexpr",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);

        t = createTopic(s, "C++17/C++20 Utilities");
        addQ(t, "Structured Bindings (auto [x, y])", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/structured_binding",
            "VIDEO", chernoPlaylist,
            "VIDEO", loveBabbarPlaylist);
        addQ(t, "std::optional, std::variant, and std::any", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/utility/optional",
            "VIDEO", chernoPlaylist,
            "VIDEO", loveBabbarPlaylist);
        addQ(t, "C++20 Ranges API (std::ranges & Views)", "HARD",
            "ARTICLE", "https://en.cppreference.com/w/cpp/ranges",
            "VIDEO", chernoPlaylist,
            "VIDEO", loveBabbarPlaylist);


        // ==========================================
        // Section 18: RAII & Exception Handling
        // ==========================================
        s = createSection("RAII & Exception Handling");

        t = createTopic(s, "RAII & Exceptions");
        addQ(t, "Resource Acquisition Is Initialization (RAII) Principle", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/raii",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);
        addQ(t, "try, catch, throw, and Exception Safety Guarantees", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/exceptions",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", codeWithHarryCpp,
            "VIDEO", jennysLectures);
        addQ(t, "noexcept Specifier and noexcept Operator", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/language/noexcept_spec",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);


        // ==========================================
        // Section 19: Multithreading & Concurrency
        // ==========================================
        s = createSection("Multithreading & Concurrency");

        t = createTopic(s, "Threading & Synchronization");
        addQ(t, "std::thread and std::jthread (C++20): Creation, join(), detach()", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/thread/thread",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist,
            "VIDEO", jennysLectures);
        addQ(t, "std::mutex, std::lock_guard, std::unique_lock, and Deadlocks", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/thread/mutex",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist,
            "VIDEO", jennysLectures);

        t = createTopic(s, "Atomics & Async");
        addQ(t, "std::atomic Variables and Memory Orders", "HARD",
            "ARTICLE", "https://en.cppreference.com/w/cpp/atomic/atomic",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);
        addQ(t, "std::async, std::future, std::promise for Asynchronous Tasks", "MEDIUM",
            "ARTICLE", "https://en.cppreference.com/w/cpp/thread/async",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", chernoPlaylist);


        // ==========================================
        // Section 20: Compilation, Preprocessor & CMake
        // ==========================================
        s = createSection("Compilation, Preprocessor & CMake");

        t = createTopic(s, "Preprocessor & Build Pipeline");
        addQ(t, "Preprocessor Directives (#define, #include, #ifdef, #pragma once)", "EASY",
            "ARTICLE", "https://en.cppreference.com/w/cpp/preprocessor",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", codeWithHarryCpp,
            "VIDEO", jennysLectures);
        addQ(t, "Compilation Pipeline (Preprocessing -> Compilation -> Assembly -> Linking)", "MEDIUM",
            "ARTICLE", "https://www.geeksforgeeks.org/compilation-process-in-c/",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", jennysLectures,
            "VIDEO", chernoPlaylist);
        addQ(t, "Static Libraries (.a/.lib) vs Dynamic Libraries (.so/.dll)", "MEDIUM",
            "ARTICLE", "https://www.geeksforgeeks.org/static-vs-dynamic-libraries/",
            "VIDEO", loveBabbarPlaylist,
            "VIDEO", jennysLectures,
            "VIDEO", chernoPlaylist);
        addQ(t, "Introduction to CMake and CMakeLists.txt", "MEDIUM",
            "ARTICLE", "https://cmake.org/cmake/help/latest/guide/tutorial/index.html",
            "VIDEO", chernoPlaylist,
            "VIDEO", loveBabbarPlaylist);


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

        System.out.println("Seeding C++ Roadmap completed successfully.");
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
