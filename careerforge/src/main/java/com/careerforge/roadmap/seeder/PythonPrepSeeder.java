package com.careerforge.roadmap.seeder;

import java.util.ArrayList;
import java.util.List;

public class PythonPrepSeeder {

    public static void seed(
        com.careerforge.roadmap.entity.Roadmap dbRoadmap,
        com.careerforge.roadmap.repository.RoadmapSectionRepository roadmapSectionRepository,
        com.careerforge.roadmap.repository.QuestionRepository questionRepository,
        com.careerforge.roadmap.repository.QuestionLinkRepository questionLinkRepository,
        com.careerforge.roadmap.repository.RoadmapSectionQuestionRepository roadmapSectionQuestionRepository
    ) {
        System.out.println("Seeding Roadmap: Python Programming Master Preparation Sheet");
        Roadmap.sections.clear();

        RoadmapSection s;
        Topic t;

        // CampusX & Krish Naik Playlist / Video Links
        String campusXPlaylist = "https://www.youtube.com/playlist?list=PLKnIA16_Rmvb152q76G20sA26Q6wX2t4x";
        String krishNaikPlaylist = "https://www.youtube.com/playlist?list=PLZoTAELRMXVPBTrPiURs42M58D03G66vB";
        String krishNaikPythonCrash = "https://www.youtube.com/watch?v=pubVed9UrB0";

        // ==========================================
        // Section 1: Introduction to Python
        // ==========================================
        s = createSection("Introduction to Python");

        t = createTopic(s, "What is Python?");
        addQ(t, "History and Design Philosophy of Python (The Zen of Python)", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/appetite.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Features of Python (Interpreted, Dynamically Typed, High-Level)", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/index.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Python 2 vs Python 3 Key Differences", "EASY",
            "ARTICLE", "https://docs.python.org/3/whatsnew/3.0.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "CPython vs PyPy vs Jython Implementations", "MEDIUM",
            "ARTICLE", "https://realpython.com/cpython-source-code-guide/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);

        t = createTopic(s, "Running Python Code");
        addQ(t, "Installing Python and Verifying Environment", "EASY",
            "ARTICLE", "https://docs.python.org/3/using/index.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Python Interactive REPL vs Script Execution", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/interpreter.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Writing & Executing First Python Program", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/introduction.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "IDEs and Code Editors (PyCharm, VSCode, Jupyter)", "EASY",
            "ARTICLE", "https://realpython.com/python-ides-code-editors-guide/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);


        // ==========================================
        // Section 2: Variables, Data Types & Memory Model
        // ==========================================
        s = createSection("Variables, Data Types & Memory Model");

        t = createTopic(s, "Variables & Dynamic Typing");
        addQ(t, "Variables, Identifiers, and Naming Rules (PEP 8)", "EASY",
            "ARTICLE", "https://peps.python.org/pep-0008/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Dynamic Typing and Type Inference", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/introduction.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "type() and isinstance() Functions", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/functions.html#type",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);

        t = createTopic(s, "Primitive Data Types");
        addQ(t, "Numeric Types (int, float, complex) & Arbitrary Precision Integers", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/stdtypes.html#numeric-types-int-float-complex",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Booleans & Truth Value Testing", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/stdtypes.html#truth-value-testing",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "NoneType and None Singleton", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/constants.html#None",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);

        t = createTopic(s, "Memory Model & Object References");
        addQ(t, "Pass-by-Object-Reference / Pass-by-Assignment", "MEDIUM",
            "ARTICLE", "https://realpython.com/pass-by-reference-python/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Mutable vs Immutable Data Types", "EASY",
            "ARTICLE", "https://docs.python.org/3/reference/datamodel.html#objects-values-and-types",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "id() Function, Object Identity, and is vs ==", "MEDIUM",
            "ARTICLE", "https://realpython.com/python-is-operator/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Small Integer Caching (-5 to 256) & String Interning", "MEDIUM",
            "ARTICLE", "https://realpython.com/pointers-in-python/#interning-optimizing-memory",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);


        // ==========================================
        // Section 3: Control Flow & Operators
        // ==========================================
        s = createSection("Control Flow & Operators");

        t = createTopic(s, "Operators");
        addQ(t, "Arithmetic, Assignment & Floor Division (//) vs True Division (/)", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/stdtypes.html#numeric-types-int-float-complex",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Comparison and Logical Operators (and, or, not) & Short-Circuit Evaluation", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/stdtypes.html#boolean-operations-and-or-not",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Bitwise Operators (&, |, ^, ~, <<, >>)", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/stdtypes.html#bitwise-operations-on-integer-types",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Membership (in, not in) and Identity (is, is not) Operators", "EASY",
            "ARTICLE", "https://docs.python.org/3/reference/expressions.html#comparisons",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Walrus Operator (:=) Assignment Expressions (Python 3.8+)", "MEDIUM",
            "ARTICLE", "https://realpython.com/python-walrus-operator/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);

        t = createTopic(s, "Conditionals & Loops");
        addQ(t, "if, elif, else Conditional Statements", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/controlflow.html#if-statements",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "while and for Loops with range() and enumerate()", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/controlflow.html#for-statements",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "break, continue, and pass Statements", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/controlflow.html#break-and-continue-statements-and-else-clauses-on-loops",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "else Clause on for and while Loops", "MEDIUM",
            "ARTICLE", "https://realpython.com/python-for-loop/#the-else-clause",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Structural Pattern Matching (match-case) in Python 3.10+", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/tutorial/controlflow.html#match-statements",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);


        // ==========================================
        // Section 4: Functions & Functional Programming
        // ==========================================
        s = createSection("Functions & Functional Programming");

        t = createTopic(s, "Function Basics");
        addQ(t, "Defining and Calling Functions (def statement)", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/controlflow.html#defining-functions",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Positional Arguments, Keyword Arguments, and Default Parameter Values", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/controlflow.html#more-on-defining-functions",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Mutable Default Arguments Gotcha & Best Practices", "MEDIUM",
            "ARTICLE", "https://docs.python-guide.org/writing/gotchas/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Positional-Only (/) and Keyword-Only (*) Parameters", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/tutorial/controlflow.html#special-parameters",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);

        t = createTopic(s, "Advanced Parameters & Scope");
        addQ(t, "*args (Variable Positional Arguments) and **kwargs (Variable Keyword Arguments)", "EASY",
            "ARTICLE", "https://realpython.com/python-kwargs-and-args/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Unpacking Arguments with * and **", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/controlflow.html#unpacking-argument-lists",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Scope and LEGB Rule (Local, Enclosing, Global, Built-in)", "MEDIUM",
            "ARTICLE", "https://realpython.com/python-scope-legb-rule/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "global and nonlocal Keywords", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/reference/simple_stmts.html#the-global-statement",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);

        t = createTopic(s, "Functional Programming Tools");
        addQ(t, "Lambda (Anonymous) Functions", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/controlflow.html#lambda-expressions",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "map(), filter(), and zip() Built-in Functions", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/functions.html#map",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "functools.reduce() for Aggregation", "MEDIUM",
            "ARTICLE", "https://realpython.com/python-reduce-function/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Recursion & Recursion Limit (sys.getrecursionlimit)", "MEDIUM",
            "ARTICLE", "https://realpython.com/python-thinking-recursively/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);


        // ==========================================
        // Section 5: Built-in Data Structures In-Depth
        // ==========================================
        s = createSection("Built-in Data Structures In-Depth");

        t = createTopic(s, "Lists and Tuples");
        addQ(t, "Lists: Creation, Indexing, Slicing, and Modifying", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/introduction.html#lists",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Essential List Methods (append, extend, insert, pop, remove, sort)", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/datastructures.html#more-on-lists",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Tuples: Immutability, Creation, Indexing, and Single-element Tuples", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/datastructures.html#tuples-and-sequences",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Tuple Unpacking & Extended Unpacking (*rest)", "EASY",
            "ARTICLE", "https://realpython.com/python-tuple/#packing-and-unpacking-tuples",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);

        t = createTopic(s, "Dictionaries and Sets");
        addQ(t, "Dictionaries: Key-Value Pairs, Hashability Rules for Keys", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/datastructures.html#dictionaries",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Dictionary Methods (keys, values, items, get, setdefault, update, pop)", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/stdtypes.html#dict",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Sets: Uniqueness, Mathematical Set Operations (union, intersection, difference)", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/datastructures.html#sets",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "frozenset (Immutable Sets)", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/stdtypes.html#frozenset",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Time Complexities (Big O) of Python Data Structures Operations", "MEDIUM",
            "ARTICLE", "https://wiki.python.org/moin/TimeComplexity",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);


        // ==========================================
        // Section 6: Comprehensions & Slicing
        // ==========================================
        s = createSection("Comprehensions & Slicing");

        t = createTopic(s, "Comprehensions");
        addQ(t, "List Comprehensions with Conditionals", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/datastructures.html#list-comprehensions",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Dictionary Comprehensions and Set Comprehensions", "EASY",
            "ARTICLE", "https://realpython.com/list-comprehension-python/#using-set-and-dictionary-comprehensions",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Nested List Comprehensions & Readability Best Practices", "MEDIUM",
            "ARTICLE", "https://realpython.com/list-comprehension-python/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);

        t = createTopic(s, "Advanced Slicing");
        addQ(t, "Slice Notation Syntax [start:stop:step]", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/stdtypes.html#common-sequence-operations",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Reversing Sequences with [::-1]", "EASY",
            "ARTICLE", "https://realpython.com/python-reverse-string/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "slice() Object and Slice Assignment", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/library/functions.html#slice",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);


        // ==========================================
        // Section 7: Strings and Text Processing
        // ==========================================
        s = createSection("Strings and Text Processing");

        t = createTopic(s, "String Manipulation");
        addQ(t, "String Immutability and Memory Behavior", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/stdtypes.html#text-sequence-type-str",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "String Formatting (f-strings, str.format(), % formatting)", "EASY",
            "ARTICLE", "https://realpython.com/python-f-strings/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Essential Methods (strip, split, join, replace, find, count, upper, lower)", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/stdtypes.html#string-methods",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Raw Strings (r'...') and Escape Sequences", "EASY",
            "ARTICLE", "https://docs.python.org/3/reference/lexical_analysis.html#string-and-bytes-literals",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);

        t = createTopic(s, "Regular Expressions (re Module)");
        addQ(t, "re.match(), re.search(), and re.findall()", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/library/re.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Regex Patterns, Character Classes, and Quantifiers", "MEDIUM",
            "ARTICLE", "https://realpython.com/regex-python/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Capturing Groups, Non-capturing Groups, and re.sub()", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/howto/regex.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);


        // ==========================================
        // Section 8: Object-Oriented Programming (OOP)
        // ==========================================
        s = createSection("Object-Oriented Programming (OOP)");

        t = createTopic(s, "Classes and Objects");
        addQ(t, "Creating Classes, Instantiating Objects, and __init__() Constructor", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/classes.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "The self Parameter and Instance Attributes", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/classes.html#class-and-instance-variables",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Class Attributes vs Instance Attributes", "EASY",
            "ARTICLE", "https://realpython.com/instance-class-variables-python/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Encapsulation, Public, Private (_single vs __double underscore), and Name Mangling", "MEDIUM",
            "ARTICLE", "https://realpython.com/python-double-underscore/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);

        t = createTopic(s, "Inheritance & Polymorphism");
        addQ(t, "Single Inheritance, Method Overriding, and super()", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/classes.html#inheritance",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Multiple Inheritance and Diamond Problem", "MEDIUM",
            "ARTICLE", "https://realpython.com/python-super/#super-in-multiple-inheritance-an-overview",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Method Resolution Order (MRO) & C3 Linearization Algorithm", "HARD",
            "ARTICLE", "https://docs.python.org/3/howto/mro.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Polymorphism and Duck Typing ('If it walks like a duck...')", "MEDIUM",
            "ARTICLE", "https://realpython.com/duck-typing-python/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);

        t = createTopic(s, "Special Decorators & Properties");
        addQ(t, "@classmethod vs @staticmethod vs Instance Methods", "MEDIUM",
            "ARTICLE", "https://realpython.com/instance-class-and-static-methods-demystified/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Property Decorator (@property, @name.setter, @name.deleter)", "MEDIUM",
            "ARTICLE", "https://realpython.com/python-property/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);


        // ==========================================
        // Section 9: Magic / Dunder Methods & Operator Overloading
        // ==========================================
        s = createSection("Magic / Dunder Methods & Operator Overloading");

        t = createTopic(s, "String & Representation Dunders");
        addQ(t, "__str__() vs __repr__() Dunder Methods", "EASY",
            "ARTICLE", "https://realpython.com/python-repr-vs-str/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "__format__ and String Conversions", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/reference/datamodel.html#basic-customization",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);

        t = createTopic(s, "Container & Comparison Dunders");
        addQ(t, "__len__(), __getitem__(), __setitem__(), and __delitem__()", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/reference/datamodel.html#emulating-container-types",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Operator Overloading (__add__, __sub__, __mul__, __eq__, __lt__)", "MEDIUM",
            "ARTICLE", "https://realpython.com/operator-function-overloading/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "__hash__() and Making Custom Objects Hashable for Dicts/Sets", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/reference/datamodel.html#object.__hash__",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "__call__() for Making Objects Callable", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/reference/datamodel.html#object.__call__",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);


        // ==========================================
        // Section 10: Decorators & Closures
        // ==========================================
        s = createSection("Decorators & Closures");

        t = createTopic(s, "Closures");
        addQ(t, "First-Class Functions & Higher-Order Functions", "EASY",
            "ARTICLE", "https://realpython.com/primer-on-python-decorators/#first-class-objects",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Closures and Inner Functions", "MEDIUM",
            "ARTICLE", "https://realpython.com/inner-functions-what-are-they-good-for/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);

        t = createTopic(s, "Decorators");
        addQ(t, "Function Decorators Syntax (@decorator)", "EASY",
            "ARTICLE", "https://realpython.com/primer-on-python-decorators/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Preserving Function Metadata with functools.wraps", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/library/functools.html#functools.wraps",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Decorators Accepting Arguments (3-level Nested Decorators)", "HARD",
            "ARTICLE", "https://realpython.com/primer-on-python-decorators/#decorators-with-arguments",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Class-based Decorators and Stacking Multiple Decorators", "MEDIUM",
            "ARTICLE", "https://realpython.com/primer-on-python-decorators/#classes-as-decorators",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);


        // ==========================================
        // Section 11: Generators & Iterators
        // ==========================================
        s = createSection("Generators & Iterators");

        t = createTopic(s, "Iterator Protocol");
        addQ(t, "Iterables vs Iterators (iter() and next() built-ins)", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/classes.html#iterators",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Building Custom Iterators (__iter__ and __next__ methods)", "MEDIUM",
            "ARTICLE", "https://realpython.com/python-iterators-iterables/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);

        t = createTopic(s, "Generators");
        addQ(t, "Generator Functions & yield Keyword", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/classes.html#generators",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Generator Expressions vs List Comprehensions (Memory Benchmarking)", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/tutorial/classes.html#generator-expressions",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Advanced Generator Methods: send(), throw(), and close()", "HARD",
            "ARTICLE", "https://docs.python.org/3/reference/expressions.html#generator-methods",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "yield from Expression for Sub-generator Delegation", "HARD",
            "ARTICLE", "https://docs.python.org/3/whatsnew/3.3.html#pep-380-syntax-for-delegating-to-a-subgenerator",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);


        // ==========================================
        // Section 12: Context Managers & Exception Handling
        // ==========================================
        s = createSection("Context Managers & Exception Handling");

        t = createTopic(s, "Exception Handling");
        addQ(t, "try, except, else, and finally Block Flow", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/errors.html#handling-exceptions",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Built-in Exceptions Hierarchy (BaseException, Exception, ValueError, TypeError)", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/exceptions.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Creating Custom Exception Classes", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/errors.html#user-defined-exceptions",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Exception Chaining (raise ... from ...) and Exception Groups (Python 3.11+)", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/tutorial/errors.html#enriching-exceptions-with-notes",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);

        t = createTopic(s, "Context Managers");
        addQ(t, "The with Statement & Context Manager Protocol (__enter__ and __exit__)", "EASY",
            "ARTICLE", "https://docs.python.org/3/reference/datamodel.html#context-managers",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Handling Exceptions inside __exit__()", "MEDIUM",
            "ARTICLE", "https://realpython.com/python-with-statement/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "contextlib.contextmanager Decorator", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/library/contextlib.html#contextlib.contextmanager",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);


        // ==========================================
        // Section 13: Modules, Packages & Tooling
        // ==========================================
        s = createSection("Modules, Packages & Tooling");

        t = createTopic(s, "Modules and Packages");
        addQ(t, "Import System (import module vs from module import name)", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/modules.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "if __name__ == '__main__' Idiom", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/__main__.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Creating Packages with __init__.py and Relative Imports", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/tutorial/modules.html#packages",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "sys.path and Python Module Search Order", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/library/sys.html#sys.path",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);

        t = createTopic(s, "Virtual Environments & Package Managers");
        addQ(t, "Creating & Activating Virtual Environments (venv module)", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/venv.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "pip Package Manager & requirements.txt", "EASY",
            "ARTICLE", "https://pip.pypa.io/en/stable/user_guide/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Modern Python Packaging: pyproject.toml, Poetry, and uv", "MEDIUM",
            "ARTICLE", "https://python-poetry.org/docs/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);


        // ==========================================
        // Section 14: File I/O & Serialization
        // ==========================================
        s = createSection("File I/O & Serialization");

        t = createTopic(s, "File Handling");
        addQ(t, "Reading and Writing Text Files (open(), modes r, w, a)", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/inputoutput.html#reading-and-writing-files",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Reading Large Files Line-by-Line Lazily", "EASY",
            "ARTICLE", "https://realpython.com/read-write-files-python/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Binary File I/O (mode rb, wb) and pathlib Module", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/library/pathlib.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);

        t = createTopic(s, "Serialization");
        addQ(t, "JSON Parsing & Serialization (json.dumps, json.loads, json.dump, json.load)", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/json.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);
        addQ(t, "Object Serialization with pickle Module & Security Risks", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/library/pickle.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "CSV File Processing with csv module and pandas", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/csv.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);


        // ==========================================
        // Section 15: Type Hints & Static Typing
        // ==========================================
        s = createSection("Type Hints & Static Typing");

        t = createTopic(s, "Type Annotations");
        addQ(t, "Function Annotations & Variable Type Hints", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/typing.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "typing Module: List, Dict, Tuple, Set, Optional, Union, Any", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/typing.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Callable, TypeVar, and Generic Functions", "MEDIUM",
            "ARTICLE", "https://realpython.com/python-type-checking/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);

        t = createTopic(s, "Static Type Checkers & Dataclasses");
        addQ(t, "Static Code Analysis with mypy and pyright", "MEDIUM",
            "ARTICLE", "https://mypy.readthedocs.io/en/stable/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Python @dataclass Decorator & Field Customizations", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/library/dataclasses.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "TypedDict and Protocol (Structural Subtyping)", "MEDIUM",
            "ARTICLE", "https://typing.readthedocs.io/en/latest/source/protocols.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);


        // ==========================================
        // Section 16: Concurrency & Multithreading
        // ==========================================
        s = createSection("Concurrency & Multithreading");

        t = createTopic(s, "GIL & Threading");
        addQ(t, "Global Interpreter Lock (GIL) and Its Impact on Concurrency", "MEDIUM",
            "ARTICLE", "https://realpython.com/python-gil/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "threading Module: Thread Creation, start(), join(), Locks & Race Conditions", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/library/threading.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);

        t = createTopic(s, "Multiprocessing & Asyncio");
        addQ(t, "multiprocessing Module: Bypassing the GIL for CPU-Bound Tasks", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/library/multiprocessing.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "concurrent.futures Module (ThreadPoolExecutor & ProcessPoolExecutor)", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/library/concurrent.futures.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "asyncio Event Loop, async / await, and Task Management", "HARD",
            "ARTICLE", "https://docs.python.org/3/library/asyncio.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);


        // ==========================================
        // Section 17: Standard Library Power Utilities
        // ==========================================
        s = createSection("Standard Library Power Utilities");

        t = createTopic(s, "collections Module");
        addQ(t, "Counter, defaultdict, OrderedDict, deque, namedtuple", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/collections.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);

        t = createTopic(s, "itertools & functools Modules");
        addQ(t, "itertools: count, cycle, repeat, chain, combinations, permutations, product", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/library/itertools.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "functools: lru_cache, partial, cmp_to_key, reduce", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/library/functools.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "datetime, date, time, and timedelta Handling", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/datetime.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPythonCrash);


        // ==========================================
        // Section 18: Memory Management & Garbage Collection
        // ==========================================
        s = createSection("Memory Management & Garbage Collection");

        t = createTopic(s, "CPython Memory Internals");
        addQ(t, "Reference Counting Mechanism and sys.getrefcount()", "MEDIUM",
            "ARTICLE", "https://realpython.com/python-memory-management/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Cyclic Reference Garbage Collector (Generational GC & gc module)", "HARD",
            "ARTICLE", "https://docs.python.org/3/library/gc.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Memory Optimization using __slots__ in Classes", "MEDIUM",
            "ARTICLE", "https://docs.python.org/3/reference/datamodel.html#slots",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Weak References (weakref module) to Avoid Circular References", "HARD",
            "ARTICLE", "https://docs.python.org/3/library/weakref.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);


        // ==========================================
        // Section 19: Metaprogramming & Introspection
        // ==========================================
        s = createSection("Metaprogramming & Introspection");

        t = createTopic(s, "Introspection & Descriptors");
        addQ(t, "Object Introspection (dir(), type(), hasattr(), getattr(), setattr())", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/functions.html#getattr",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "__getattr__() vs __getattribute__()", "HARD",
            "ARTICLE", "https://docs.python.org/3/reference/datamodel.html#customizing-attribute-access",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Descriptors Protocol (__get__, __set__, __delete__)", "HARD",
            "ARTICLE", "https://docs.python.org/3/howto/descriptor.html",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);

        t = createTopic(s, "Metaclasses");
        addQ(t, "Understanding type as the Metaclass of All Classes", "HARD",
            "ARTICLE", "https://realpython.com/python-metaclasses/",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Creating Custom Metaclasses (__new__ and __init__ in Metaclasses)", "HARD",
            "ARTICLE", "https://docs.python.org/3/reference/datamodel.html#metaclasses",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);


        // ==========================================
        // Section 20: Design Patterns in Python
        // ==========================================
        s = createSection("Design Patterns in Python");

        t = createTopic(s, "Creational & Behavioral Patterns");
        addQ(t, "Singleton Pattern in Python (using Metaclass / Module level)", "MEDIUM",
            "ARTICLE", "https://refactoring.guru/design-patterns/singleton/python/example",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Factory Method and Abstract Factory Patterns", "MEDIUM",
            "ARTICLE", "https://refactoring.guru/design-patterns/factory-method/python/example",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Observer Pattern & Event Handling", "MEDIUM",
            "ARTICLE", "https://refactoring.guru/design-patterns/observer/python/example",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);
        addQ(t, "Strategy Pattern using First-class Functions", "MEDIUM",
            "ARTICLE", "https://refactoring.guru/design-patterns/strategy/python/example",
            "VIDEO", campusXPlaylist,
            "VIDEO", krishNaikPlaylist);


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
