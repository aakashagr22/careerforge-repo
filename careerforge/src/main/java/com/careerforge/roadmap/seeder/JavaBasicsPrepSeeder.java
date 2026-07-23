package com.careerforge.roadmap.seeder;

import java.util.ArrayList;
import java.util.List;

public class JavaBasicsPrepSeeder {

    public static void seed(
        com.careerforge.roadmap.entity.Roadmap dbRoadmap,
        com.careerforge.roadmap.repository.RoadmapSectionRepository roadmapSectionRepository,
        com.careerforge.roadmap.repository.QuestionRepository questionRepository,
        com.careerforge.roadmap.repository.QuestionLinkRepository questionLinkRepository,
        com.careerforge.roadmap.repository.RoadmapSectionQuestionRepository roadmapSectionQuestionRepository
    ) {
        System.out.println("Seeding Roadmap: Java Language Basics for 1st Semester Students");
        Roadmap.sections.clear();

        RoadmapSection s;
        Topic t;

        // ==========================================
        // Section 1: Introduction to Java
        // ==========================================
        s = createSection("Introduction to Java");

        t = createTopic(s, "What is Java?");
        addQ(t, "History and Evolution of Java", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/getStarted/intro/definition.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Features of Java (Platform Independent, Secure, Robust)", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/getStarted/intro/definition.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Java vs Other Programming Languages (C++, Python)", "EASY",
            "ARTICLE", "https://www.baeldung.com/c-plus-plus-vs-java",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Applications of Java (Web, Mobile, Enterprise)", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/getStarted/intro/definition.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");

        t = createTopic(s, "Java Architecture");
        addQ(t, "JDK, JRE and JVM Deep Dive", "EASY",
            "ARTICLE", "https://www.baeldung.com/jvm-vs-jre-vs-jdk",
            "VIDEO", "https://www.youtube.com/watch?v=bm0OyhwFDuY");
        addQ(t, "How Java Code Gets Compiled and Executed (JIT Compiler)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/jit-compiler-java",
            "VIDEO", "https://www.youtube.com/watch?v=bm0OyhwFDuY");
        addQ(t, "Bytecode and Platform Independence", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/getStarted/intro/definition.html",
            "VIDEO", "https://www.youtube.com/watch?v=bm0OyhwFDuY");
        addQ(t, "ClassLoader Hierarchy and Memory Areas in JVM", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-classloaders",
            "VIDEO", "https://www.youtube.com/watch?v=bm0OyhwFDuY");

        t = createTopic(s, "Setting Up Java Environment");
        addQ(t, "Installing JDK and Verifying Java Version", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/getStarted/cupojava/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Setting up PATH and JAVA_HOME Environment Variables", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/getStarted/cupojava/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "IDEs - IntelliJ IDEA and Eclipse Setup", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/getStarted/cupojava/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Writing, Compiling, and Running First Java Program via CLI", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/getStarted/application/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");

        t = createTopic(s, "Hello World Program");
        addQ(t, "Structure of a Java Program", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/getStarted/application/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");
        addQ(t, "public static void main(String[] args) Explained", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/getStarted/application/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");
        addQ(t, "System.out.println() vs System.out.print() vs System.err", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/getStarted/application/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");
        addQ(t, "Comments in Java (Single line, Multi-line, Javadoc)", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");


        // ==========================================
        // Section 2: Variables and Data Types
        // ==========================================
        s = createSection("Variables and Data Types");

        t = createTopic(s, "Variables in Java");
        addQ(t, "What is a Variable?", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Declaring and Initializing Variables", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Types of Variables - Local, Instance, Static", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Variable Scope, Lifetime, and Memory Allocation (Stack vs Heap)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-stack-heap",
            "VIDEO", "https://www.youtube.com/watch?v=7uRtdHa7sEU");
        addQ(t, "Naming Conventions and Identifier Rules", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");

        t = createTopic(s, "Primitive Data Types");
        addQ(t, "Integer Types (byte, short, int, long) & Bit Sizes", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Floating-Point Types (float, double) & IEEE 754 Precision", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-floating-point-arithmetic",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "char and boolean Data Types", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Default Values of Primitive Types", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Literals in Java (Binary, Hexadecimal, Underscores in Numeric Literals)", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");

        t = createTopic(s, "Type Conversion");
        addQ(t, "Implicit Type Casting (Widening)", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Explicit Type Casting (Narrowing) and Overflow/Underflow", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-type-casting",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Type Promotion in Arithmetic Expressions", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");

        t = createTopic(s, "Wrapper Classes");
        addQ(t, "What are Wrapper Classes?", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/data/numberclasses.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Autoboxing, Unboxing, and Performance Overhead", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Integer Caching (-128 to 127) in Wrapper Classes", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-integer-cache",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Useful Methods in Wrapper Classes (parseInt, valueOf, toString)", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/data/numberclasses.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");


        // ==========================================
        // Section 3: Operators
        // ==========================================
        s = createSection("Operators");

        t = createTopic(s, "Arithmetic and Assignment Operators");
        addQ(t, "Arithmetic Operators (+, -, *, /, %)", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Assignment Operators (=, +=, -=, *=, /=) & Implicit Casting", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Prefix vs Postfix Increment and Decrement (++i vs i++)", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");

        t = createTopic(s, "Relational and Logical Operators");
        addQ(t, "Relational Operators (==, !=, >, <, >=, <=)", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Logical Operators (&&, ||, !)", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Short-Circuit Evaluation (&& vs & and || vs |)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-operators",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");

        t = createTopic(s, "Bitwise and Shift Operators");
        addQ(t, "Bitwise Operators (&, |, ^, ~)", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Left Shift (<<) and Right Shift (>>) Operators", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Unsigned Right Shift Operator (>>>)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-unsigned-right-shift-operator",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Ternary Operator (?:) & Nested Ternary", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "instanceof Operator & Operator Precedence Table", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");


        // ==========================================
        // Section 4: Control Flow Statements
        // ==========================================
        s = createSection("Control Flow Statements");

        t = createTopic(s, "Conditional Statements");
        addQ(t, "if Statement", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "if-else Statement and else-if Ladder", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Nested if-else Statements", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");

        t = createTopic(s, "Switch Statement");
        addQ(t, "Traditional switch-case Syntax & break", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Fall-through Behavior and default Case", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Enhanced Switch Expressions with Arrow Syntax & yield (Java 14+)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-switch",
            "VIDEO", "https://www.youtube.com/watch?v=aKaw9W789wU");

        t = createTopic(s, "Loops");
        addQ(t, "while Loop vs do-while Loop", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Standard for Loop and Loop Counters", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Enhanced for-each Loop", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Nested Loops & Infinite Loop Prevention", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");

        t = createTopic(s, "Jump Statements");
        addQ(t, "break and continue Statements", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/branch.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "return Statement in Methods", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/branch.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Labeled break and continue in Nested Loops", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-labeled-statements",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");


        // ==========================================
        // Section 5: Methods in Java
        // ==========================================
        s = createSection("Methods in Java");

        t = createTopic(s, "Defining and Calling Methods");
        addQ(t, "What is a Method & Method Signature", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Return Types, Parameters, and Void Methods", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");

        t = createTopic(s, "Method Parameters and Arguments");
        addQ(t, "Pass by Value in Java (Primitives vs Object References)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-pass-by-value-or-pass-by-reference",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Varargs (Variable-Length Arguments)", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");

        t = createTopic(s, "Method Overloading");
        addQ(t, "Method Overloading Rules and Ambiguity", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");
        addQ(t, "Overloading with Type Promotion Quirks", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-method-overloading-type-promotion",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");

        t = createTopic(s, "Recursion");
        addQ(t, "Base Case and Recursive Case Breakdown", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Tail Recursion vs Head Recursion", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-tail-recursion",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");
        addQ(t, "Call Stack Visualization & StackOverflowError", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-stack-overflow-error",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");


        // ==========================================
        // Section 6: Arrays
        // ==========================================
        s = createSection("Arrays");

        t = createTopic(s, "Introduction to Arrays");
        addQ(t, "Declaring, Instantiating, and Accessing Arrays", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");
        addQ(t, "Memory Representation of Arrays in Heap", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-array-memory-layout",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");
        addQ(t, "ArrayIndexOutOfBoundsException and Bounds Checking", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");

        t = createTopic(s, "Working with Arrays");
        addQ(t, "Sorting Arrays (Arrays.sort) & Binary Search (Arrays.binarySearch)", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");
        addQ(t, "Shallow Copy vs Deep Copy of Arrays (System.arraycopy vs Arrays.copyOf)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-array-copy",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");
        addQ(t, "Arrays.equals() vs Arrays.deepEquals()", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-array-compare",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");

        t = createTopic(s, "Multidimensional Arrays");
        addQ(t, "2D Arrays Declaration and Matrix Representation", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");
        addQ(t, "Jagged (Ragged) Arrays in Java", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-jagged-arrays",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");


        // ==========================================
        // Section 7: Strings
        // ==========================================
        s = createSection("Strings");

        t = createTopic(s, "Introduction to Strings");
        addQ(t, "String Class & String Literal vs new Keyword", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/data/strings.html",
            "VIDEO", "https://www.youtube.com/watch?v=Bj9Mx_Lx3q4");
        addQ(t, "String Immutability Design Pattern", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-string-immutable",
            "VIDEO", "https://www.youtube.com/watch?v=Bj9Mx_Lx3q4");
        addQ(t, "String Constant Pool (SCP) & intern() Method", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-string-pool",
            "VIDEO", "https://www.youtube.com/watch?v=Bj9Mx_Lx3q4");

        t = createTopic(s, "String Methods & Manipulation");
        addQ(t, "Essential String Methods (length, charAt, substring, indexOf)", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/data/manipstrings.html",
            "VIDEO", "https://www.youtube.com/watch?v=Bj9Mx_Lx3q4");
        addQ(t, "equals() vs == for String Comparison", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-compare-strings",
            "VIDEO", "https://www.youtube.com/watch?v=Bj9Mx_Lx3q4");
        addQ(t, "split(), join(), and String.format()", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/data/manipstrings.html",
            "VIDEO", "https://www.youtube.com/watch?v=Bj9Mx_Lx3q4");

        t = createTopic(s, "StringBuilder and StringBuffer");
        addQ(t, "Why StringBuilder over String for Mutations", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/data/buffers.html",
            "VIDEO", "https://www.youtube.com/watch?v=Bj9Mx_Lx3q4");
        addQ(t, "StringBuilder Internal Capacity and Resizing", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-string-builder-capacity",
            "VIDEO", "https://www.youtube.com/watch?v=Bj9Mx_Lx3q4");
        addQ(t, "StringBuilder vs StringBuffer (Thread Safety & Synchronization)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-string-builder-string-buffer",
            "VIDEO", "https://www.youtube.com/watch?v=Bj9Mx_Lx3q4");


        // ==========================================
        // Section 8: Object Oriented Programming
        // ==========================================
        s = createSection("Object Oriented Programming");

        t = createTopic(s, "Classes and Objects");
        addQ(t, "Class Definition, Fields, and Instantiation", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/classdecl.html",
            "VIDEO", "https://www.youtube.com/watch?v=BSVKUk58K6U");
        addQ(t, "Memory Representation of Objects in Heap", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-stack-heap",
            "VIDEO", "https://www.youtube.com/watch?v=BSVKUk58K6U");
        addQ(t, "null Reference and NullPointerException", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html",
            "VIDEO", "https://www.youtube.com/watch?v=BSVKUk58K6U");

        t = createTopic(s, "Constructors & Initialization");
        addQ(t, "Default, Parameterized Constructors & Constructor Overloading", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html",
            "VIDEO", "https://www.youtube.com/watch?v=BSVKUk58K6U");
        addQ(t, "Constructor Chaining using this() and super()", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html",
            "VIDEO", "https://www.youtube.com/watch?v=BSVKUk58K6U");
        addQ(t, "Instance Initialization Blocks (IIB) vs Static Initialization Blocks (SIB)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-initialization-blocks",
            "VIDEO", "https://www.youtube.com/watch?v=BSVKUk58K6U");

        t = createTopic(s, "this and static Keywords");
        addQ(t, "this Keyword - Shadowing and Returning Instance", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html",
            "VIDEO", "https://www.youtube.com/watch?v=BSVKUk58K6U");
        addQ(t, "static Variables, Methods, and Static Import", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html",
            "VIDEO", "https://www.youtube.com/watch?v=BSVKUk58K6U");


        // ==========================================
        // Section 9: OOP Principles
        // ==========================================
        s = createSection("OOP Principles");

        t = createTopic(s, "Encapsulation");
        addQ(t, "Data Hiding, Access Modifiers, and Getters/Setters", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html",
            "VIDEO", "https://www.youtube.com/watch?v=BSVKUk58K6U");

        t = createTopic(s, "Inheritance");
        addQ(t, "extends Keyword, super Keyword, and Class Hierarchy", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html",
            "VIDEO", "https://www.youtube.com/watch?v=BSVKUk58K6U");
        addQ(t, "Why Java Does Not Support Multiple Inheritance for Classes", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/multipleinheritance.html",
            "VIDEO", "https://www.youtube.com/watch?v=BSVKUk58K6U");
        addQ(t, "Method Overriding, @Override, & Covariant Return Types", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-covariant-return-type",
            "VIDEO", "https://www.youtube.com/watch?v=BSVKUk58K6U");
        addQ(t, "Composition vs Inheritance (HAS-A vs IS-A)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-composition-vs-inheritance",
            "VIDEO", "https://www.youtube.com/watch?v=BSVKUk58K6U");

        t = createTopic(s, "Polymorphism");
        addQ(t, "Compile-time vs Runtime Polymorphism", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html",
            "VIDEO", "https://www.youtube.com/watch?v=BSVKUk58K6U");
        addQ(t, "Upcasting, Downcasting, and ClassCastException", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-type-casting",
            "VIDEO", "https://www.youtube.com/watch?v=BSVKUk58K6U");
        addQ(t, "Dynamic Method Dispatch Internals (Virtual Method Table)", "HARD",
            "ARTICLE", "https://www.baeldung.com/java-dynamic-method-dispatch",
            "VIDEO", "https://www.youtube.com/watch?v=BSVKUk58K6U");

        t = createTopic(s, "Abstraction");
        addQ(t, "Abstract Classes vs Interfaces", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html",
            "VIDEO", "https://www.youtube.com/watch?v=BSVKUk58K6U");
        addQ(t, "Default and Static Methods in Interfaces (Java 8+)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-static-default-methods",
            "VIDEO", "https://www.youtube.com/watch?v=BSVKUk58K6U");


        // ==========================================
        // Section 10: Exception Handling
        // ==========================================
        s = createSection("Exception Handling");

        t = createTopic(s, "Introduction to Exceptions");
        addQ(t, "Exception Hierarchy (Throwable, Error, Exception, RuntimeException)", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/exceptions/catchOrDeclare.html",
            "VIDEO", "https://www.youtube.com/watch?v=1XAfapkBQjk");
        addQ(t, "Checked vs Unchecked Exceptions", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html",
            "VIDEO", "https://www.youtube.com/watch?v=1XAfapkBQjk");

        t = createTopic(s, "Handling Exceptions");
        addQ(t, "try-catch, Multi-catch, and finally Block Quirks", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/exceptions/finally.html",
            "VIDEO", "https://www.youtube.com/watch?v=1XAfapkBQjk");
        addQ(t, "try-with-resources Statement & AutoCloseable Interface", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-try-with-resources",
            "VIDEO", "https://www.youtube.com/watch?v=1XAfapkBQjk");

        t = createTopic(s, "Throwing and Declaring Exceptions");
        addQ(t, "throw vs throws Keyword & Custom Exceptions", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/exceptions/creating.html",
            "VIDEO", "https://www.youtube.com/watch?v=1XAfapkBQjk");
        addQ(t, "Exception Chaining & Suppressed Exceptions", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-suppressed-exceptions",
            "VIDEO", "https://www.youtube.com/watch?v=1XAfapkBQjk");


        // ==========================================
        // Section 11: Packages and Access Modifiers
        // ==========================================
        s = createSection("Packages and Access Modifiers");

        t = createTopic(s, "Packages in Java");
        addQ(t, "Creating, Using Packages, and import / static import", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/package/usepkgs.html",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");

        t = createTopic(s, "Access Modifiers");
        addQ(t, "Access Level Matrix (public, protected, default, private)", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");


        // ==========================================
        // Section 12: File Handling & NIO.2
        // ==========================================
        s = createSection("File Handling and NIO.2");

        t = createTopic(s, "Legacy File I/O");
        addQ(t, "File Class, FileReader, FileWriter, BufferedReader, BufferedWriter", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/io/charstreams.html",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");
        addQ(t, "FileInputStream, FileOutputStream, and Byte Streams", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/io/bytestreams.html",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");
        addQ(t, "Scanner Class for Console & File Input", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/io/scanning.html",
            "VIDEO", "https://www.youtube.com/watch?v=BGTx91t8q50");

        t = createTopic(s, "Modern Java NIO.2");
        addQ(t, "Path, Paths, and Files API (NIO.2 Introduced in Java 7)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-nio-2-file-api",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");
        addQ(t, "Reading/Writing Files with Files.readAllLines & Files.write", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-read-file",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");

        t = createTopic(s, "Serialization & Object Streams");
        addQ(t, "ObjectInputStream, ObjectOutputStream, & Serializable Interface", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-serialization",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");
        addQ(t, "transient Keyword and serialVersionUID", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-transient-keyword",
            "VIDEO", "https://www.youtube.com/watch?v=eIrMbAQSU34");


        // ==========================================
        // Section 13: Multithreading & Concurrency
        // ==========================================
        s = createSection("Multithreading and Concurrency");

        t = createTopic(s, "Introduction to Threads");
        addQ(t, "Process vs Thread & Thread Lifecycle", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/procthread.html",
            "VIDEO", "https://www.youtube.com/watch?v=WldMTtUWqTg");
        addQ(t, "Extending Thread vs Implementing Runnable vs Callable", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-runnable-callable",
            "VIDEO", "https://www.youtube.com/watch?v=WldMTtUWqTg");

        t = createTopic(s, "Synchronization & Thread Safety");
        addQ(t, "Race Conditions, synchronized Keyword, & Deadlock Avoidance", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/deadlock.html",
            "VIDEO", "https://www.youtube.com/watch?v=WldMTtUWqTg");
        addQ(t, "volatile Keyword & Memory Visibility", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-volatile",
            "VIDEO", "https://www.youtube.com/watch?v=WldMTtUWqTg");
        addQ(t, "wait(), notify(), and notifyAll() Communication", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-wait-notify",
            "VIDEO", "https://www.youtube.com/watch?v=WldMTtUWqTg");

        t = createTopic(s, "Executor Framework & Atomics");
        addQ(t, "ExecutorService, ThreadPools, & Future Interface", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-executor-service-tutorial",
            "VIDEO", "https://www.youtube.com/watch?v=WldMTtUWqTg");
        addQ(t, "Atomic Variables (AtomicInteger, AtomicLong) & CAS Operation", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-atomic-variables",
            "VIDEO", "https://www.youtube.com/watch?v=WldMTtUWqTg");


        // ==========================================
        // Section 14: Generics
        // ==========================================
        s = createSection("Generics");

        t = createTopic(s, "Introduction to Generics");
        addQ(t, "What are Generics and Why Use Them?", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/generics/why.html",
            "VIDEO", "https://www.youtube.com/watch?v=K1iu1kXkVoA");
        addQ(t, "Generic Classes", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/generics/types.html",
            "VIDEO", "https://www.youtube.com/watch?v=K1iu1kXkVoA");
        addQ(t, "Generic Methods", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/generics/methods.html",
            "VIDEO", "https://www.youtube.com/watch?v=K1iu1kXkVoA");
        addQ(t, "Generic Interfaces", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/generics/types.html",
            "VIDEO", "https://www.youtube.com/watch?v=K1iu1kXkVoA");
        addQ(t, "Type Parameters and Naming Conventions (T, E, K, V)", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/generics/types.html",
            "VIDEO", "https://www.youtube.com/watch?v=K1iu1kXkVoA");

        t = createTopic(s, "Bounded Type Parameters and Wildcards");
        addQ(t, "Upper Bounded Type Parameters (extends)", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/generics/bounded.html",
            "VIDEO", "https://www.youtube.com/watch?v=K1iu1kXkVoA");
        addQ(t, "Lower Bounded Wildcards (? super T)", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/generics/lowerBounded.html",
            "VIDEO", "https://www.youtube.com/watch?v=K1iu1kXkVoA");
        addQ(t, "Upper Bounded Wildcards (? extends T)", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/generics/upperBounded.html",
            "VIDEO", "https://www.youtube.com/watch?v=K1iu1kXkVoA");
        addQ(t, "Unbounded Wildcards (?)", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/generics/unboundedWildcards.html",
            "VIDEO", "https://www.youtube.com/watch?v=K1iu1kXkVoA");
        addQ(t, "PECS Principle (Producer Extends, Consumer Super)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-generics-pecs",
            "VIDEO", "https://www.youtube.com/watch?v=K1iu1kXkVoA");

        t = createTopic(s, "Type Erasure and Restrictions");
        addQ(t, "What is Type Erasure?", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/generics/erasure.html",
            "VIDEO", "https://www.youtube.com/watch?v=K1iu1kXkVoA");
        addQ(t, "Erasure of Generic Types", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/generics/genTypes.html",
            "VIDEO", "https://www.youtube.com/watch?v=K1iu1kXkVoA");
        addQ(t, "Restrictions on Generics", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html",
            "VIDEO", "https://www.youtube.com/watch?v=K1iu1kXkVoA");
        addQ(t, "Heap Pollution and Reifiable Types", "HARD",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/generics/nonReifiableVarargsType.html",
            "VIDEO", "https://www.youtube.com/watch?v=K1iu1kXkVoA");


        // ==========================================
        // Section 15: Collections Framework
        // ==========================================
        s = createSection("Collections Framework");

        t = createTopic(s, "Collections Overview");
        addQ(t, "Collections Framework Hierarchy and Core Interfaces", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "Collection vs Collections Utility Class", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/algorithms/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "Iterable and Iterator Interface", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "Comparable vs Comparator", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");

        t = createTopic(s, "List Interface");
        addQ(t, "ArrayList - Internal Working and Resizing", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/implementations/list.html",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "LinkedList - Doubly Linked List Implementation", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/implementations/list.html",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "ArrayList vs LinkedList - When to Use Which", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-arraylist-linkedlist",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "Vector and Stack (Legacy)", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/implementations/list.html",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "CopyOnWriteArrayList", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/implementations/list.html",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");

        t = createTopic(s, "Set Interface");
        addQ(t, "HashSet - Hash Table Backed Set", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/implementations/set.html",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "LinkedHashSet - Insertion Order Preservation", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/implementations/set.html",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "TreeSet - Sorted Set using Red-Black Tree", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/implementations/set.html",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "EnumSet", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-enumset",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "equals() and hashCode() Contract in Sets", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-equals-hashcode-contracts",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");

        t = createTopic(s, "Map Interface");
        addQ(t, "HashMap - Hashing Internals and Collision Handling", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/implementations/map.html",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "LinkedHashMap - Insertion and Access Order", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/implementations/map.html",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "TreeMap - Sorted Map using Red-Black Tree", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/implementations/map.html",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "Hashtable vs HashMap (Legacy)", "EASY",
            "ARTICLE", "https://www.baeldung.com/hashmap-hashtable-differences",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "EnumMap", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-enum-map",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "WeakHashMap and IdentityHashMap", "HARD",
            "ARTICLE", "https://www.baeldung.com/java-weakhashmap",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "Map.Entry and Iterating Over a Map", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/interfaces/map.html",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "Map.computeIfAbsent, merge, getOrDefault", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-map-computeifabsent",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");

        t = createTopic(s, "Queue and Deque Interface");
        addQ(t, "Queue Interface and PriorityQueue", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/interfaces/queue.html",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "Deque Interface - ArrayDeque", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/interfaces/deque.html",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "ArrayDeque as Stack Replacement", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-array-deque",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");

        t = createTopic(s, "Concurrent Collections");
        addQ(t, "ConcurrentHashMap", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/collections.html",
            "VIDEO", "https://www.youtube.com/watch?v=VE_AAUxTUCY");
        addQ(t, "CopyOnWriteArrayList and CopyOnWriteArraySet", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-copy-on-write-arraylist",
            "VIDEO", "https://www.youtube.com/watch?v=VE_AAUxTUCY");
        addQ(t, "BlockingQueue - ArrayBlockingQueue and LinkedBlockingQueue", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/collections.html",
            "VIDEO", "https://www.youtube.com/watch?v=VE_AAUxTUCY");
        addQ(t, "ConcurrentLinkedQueue and ConcurrentLinkedDeque", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-concurrent-queues",
            "VIDEO", "https://www.youtube.com/watch?v=VE_AAUxTUCY");

        t = createTopic(s, "Collections Utility Methods");
        addQ(t, "sort(), binarySearch(), reverse(), shuffle()", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/algorithms/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "unmodifiableList/Set/Map - Immutable Views", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/implementations/wrapper.html",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "frequency(), disjoint(), nCopies()", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/algorithms/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");
        addQ(t, "List.of(), Set.of(), Map.of() - Immutable Factory Methods (Java 9+)", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-9-collections-factory-methods",
            "VIDEO", "https://www.youtube.com/watch?v=OQvOx5q0D2A");


        // ==========================================
        // Section 16: Functional Programming and Streams
        // ==========================================
        s = createSection("Functional Programming and Streams");

        t = createTopic(s, "Lambda Expressions");
        addQ(t, "Lambda Expression Syntax and Rules", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html",
            "VIDEO", "https://www.youtube.com/watch?v=kEEoKqdVc_4");
        addQ(t, "Effectively Final Variables in Lambdas", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-lambda-effectively-final-local-variables",
            "VIDEO", "https://www.youtube.com/watch?v=kEEoKqdVc_4");
        addQ(t, "Method References (Static, Instance, Constructor)", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html",
            "VIDEO", "https://www.youtube.com/watch?v=kEEoKqdVc_4");

        t = createTopic(s, "Functional Interfaces");
        addQ(t, "What is a Functional Interface?", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html",
            "VIDEO", "https://www.youtube.com/watch?v=kEEoKqdVc_4");
        addQ(t, "Predicate<T> - test(), and(), or(), negate()", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-predicate-chain",
            "VIDEO", "https://www.youtube.com/watch?v=kEEoKqdVc_4");
        addQ(t, "Function<T,R> - apply(), andThen(), compose()", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-8-functional-interfaces",
            "VIDEO", "https://www.youtube.com/watch?v=kEEoKqdVc_4");
        addQ(t, "Consumer<T> and BiConsumer<T,U>", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-8-functional-interfaces",
            "VIDEO", "https://www.youtube.com/watch?v=kEEoKqdVc_4");
        addQ(t, "Supplier<T>", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-8-functional-interfaces",
            "VIDEO", "https://www.youtube.com/watch?v=kEEoKqdVc_4");
        addQ(t, "UnaryOperator<T> and BinaryOperator<T>", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-8-functional-interfaces",
            "VIDEO", "https://www.youtube.com/watch?v=kEEoKqdVc_4");
        addQ(t, "Creating Custom Functional Interfaces with @FunctionalInterface", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-8-functional-interfaces",
            "VIDEO", "https://www.youtube.com/watch?v=kEEoKqdVc_4");

        t = createTopic(s, "Stream API");
        addQ(t, "What is a Stream? Stream vs Collection", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html",
            "VIDEO", "https://www.youtube.com/watch?v=t1-YZ6bF-g0");
        addQ(t, "Creating Streams - of(), generate(), iterate(), from Collections", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-8-streams",
            "VIDEO", "https://www.youtube.com/watch?v=t1-YZ6bF-g0");
        addQ(t, "Intermediate Operations - filter(), map(), flatMap(), sorted(), distinct(), peek()", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-8-streams",
            "VIDEO", "https://www.youtube.com/watch?v=t1-YZ6bF-g0");
        addQ(t, "Terminal Operations - collect(), forEach(), reduce(), count(), findFirst(), anyMatch()", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-8-streams",
            "VIDEO", "https://www.youtube.com/watch?v=t1-YZ6bF-g0");
        addQ(t, "Collectors - toList(), toSet(), toMap(), groupingBy(), partitioningBy(), joining()", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-8-collectors",
            "VIDEO", "https://www.youtube.com/watch?v=t1-YZ6bF-g0");
        addQ(t, "Lazy Evaluation in Streams", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-stream-lazy-evaluation",
            "VIDEO", "https://www.youtube.com/watch?v=t1-YZ6bF-g0");
        addQ(t, "Parallel Streams and ForkJoinPool", "HARD",
            "ARTICLE", "https://www.baeldung.com/java-when-to-use-parallel-stream",
            "VIDEO", "https://www.youtube.com/watch?v=t1-YZ6bF-g0");
        addQ(t, "Primitive Streams - IntStream, LongStream, DoubleStream", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-8-primitive-streams",
            "VIDEO", "https://www.youtube.com/watch?v=t1-YZ6bF-g0");
        addQ(t, "Stream.of() vs Arrays.stream() vs Collection.stream()", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-stream-of-vs-collection-stream",
            "VIDEO", "https://www.youtube.com/watch?v=t1-YZ6bF-g0");

        t = createTopic(s, "Optional Class");
        addQ(t, "What is Optional and Why Use It?", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html",
            "VIDEO", "https://www.youtube.com/watch?v=kEEoKqdVc_4");
        addQ(t, "Creating Optional - of(), ofNullable(), empty()", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-optional",
            "VIDEO", "https://www.youtube.com/watch?v=kEEoKqdVc_4");
        addQ(t, "isPresent(), ifPresent(), get(), orElse(), orElseGet(), orElseThrow()", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-optional",
            "VIDEO", "https://www.youtube.com/watch?v=kEEoKqdVc_4");
        addQ(t, "map(), flatMap(), filter() on Optional", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-optional",
            "VIDEO", "https://www.youtube.com/watch?v=kEEoKqdVc_4");
        addQ(t, "Optional Anti-Patterns and Best Practices", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-optional-uses",
            "VIDEO", "https://www.youtube.com/watch?v=kEEoKqdVc_4");


        // ==========================================
        // Section 17: Enums and Annotations
        // ==========================================
        s = createSection("Enums and Annotations");

        t = createTopic(s, "Enums in Depth");
        addQ(t, "What is an Enum?", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html",
            "VIDEO", "https://www.youtube.com/watch?v=wHSRDCLQtgY");
        addQ(t, "Enums with Fields, Constructors and Methods", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/a-guide-to-java-enums",
            "VIDEO", "https://www.youtube.com/watch?v=wHSRDCLQtgY");
        addQ(t, "Abstract Methods in Enums", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-enum-abstract-method",
            "VIDEO", "https://www.youtube.com/watch?v=wHSRDCLQtgY");
        addQ(t, "Enum Implementing an Interface", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-enum-implementing-interface",
            "VIDEO", "https://www.youtube.com/watch?v=wHSRDCLQtgY");
        addQ(t, "EnumSet and EnumMap", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-enumset",
            "VIDEO", "https://www.youtube.com/watch?v=wHSRDCLQtgY");
        addQ(t, "Enum in switch Expressions", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-enum-switch",
            "VIDEO", "https://www.youtube.com/watch?v=wHSRDCLQtgY");
        addQ(t, "values(), valueOf(), ordinal(), name()", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html",
            "VIDEO", "https://www.youtube.com/watch?v=wHSRDCLQtgY");

        t = createTopic(s, "Annotations");
        addQ(t, "What are Annotations?", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/annotations/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=DkZr7_c9ry8");
        addQ(t, "Built-in Annotations (@Override, @Deprecated, @SuppressWarnings, @FunctionalInterface)", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/annotations/predefined.html",
            "VIDEO", "https://www.youtube.com/watch?v=DkZr7_c9ry8");
        addQ(t, "Creating Custom Annotations", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/annotations/declaring.html",
            "VIDEO", "https://www.youtube.com/watch?v=DkZr7_c9ry8");
        addQ(t, "Meta-Annotations (@Retention, @Target, @Documented, @Inherited)", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/annotations/predefined.html",
            "VIDEO", "https://www.youtube.com/watch?v=DkZr7_c9ry8");
        addQ(t, "Processing Annotations at Runtime using Reflection", "HARD",
            "ARTICLE", "https://www.baeldung.com/java-custom-annotation",
            "VIDEO", "https://www.youtube.com/watch?v=DkZr7_c9ry8");
        addQ(t, "Repeatable Annotations (@Repeatable)", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/annotations/repeating.html",
            "VIDEO", "https://www.youtube.com/watch?v=DkZr7_c9ry8");


        // ==========================================
        // Section 18: Reflection and Inner Classes
        // ==========================================
        s = createSection("Reflection and Inner Classes");

        t = createTopic(s, "Inner and Nested Classes");
        addQ(t, "Static Nested Classes", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html",
            "VIDEO", "https://www.youtube.com/watch?v=9nOSQFDFYCU");
        addQ(t, "Non-Static Inner Classes", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/innerclasses.html",
            "VIDEO", "https://www.youtube.com/watch?v=9nOSQFDFYCU");
        addQ(t, "Local Classes", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/localclasses.html",
            "VIDEO", "https://www.youtube.com/watch?v=9nOSQFDFYCU");
        addQ(t, "Anonymous Classes", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html",
            "VIDEO", "https://www.youtube.com/watch?v=9nOSQFDFYCU");
        addQ(t, "When to Use Inner vs Static Nested Classes", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-nested-classes",
            "VIDEO", "https://www.youtube.com/watch?v=9nOSQFDFYCU");

        t = createTopic(s, "Reflection API");
        addQ(t, "What is Reflection?", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/reflect/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=bhhMJSKNCQY");
        addQ(t, "Getting Class Object - getClass(), .class, Class.forName()", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/reflect/class/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=bhhMJSKNCQY");
        addQ(t, "Inspecting Fields, Methods and Constructors at Runtime", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/reflect/member/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=bhhMJSKNCQY");
        addQ(t, "Invoking Methods Dynamically using invoke()", "HARD",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/reflect/member/methodInvocation.html",
            "VIDEO", "https://www.youtube.com/watch?v=bhhMJSKNCQY");
        addQ(t, "Accessing Private Members with setAccessible()", "HARD",
            "ARTICLE", "https://www.baeldung.com/java-reflection",
            "VIDEO", "https://www.youtube.com/watch?v=bhhMJSKNCQY");
        addQ(t, "Performance Costs and Use Cases of Reflection", "HARD",
            "ARTICLE", "https://www.baeldung.com/java-reflection",
            "VIDEO", "https://www.youtube.com/watch?v=bhhMJSKNCQY");


        // ==========================================
        // Section 19: String Handling In-Depth
        // ==========================================
        s = createSection("String Handling In-Depth");

        t = createTopic(s, "String Internals");
        addQ(t, "String Immutability and String Pool", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-string-pool",
            "VIDEO", "https://www.youtube.com/watch?v=Bj9Mx_Lx3q4");
        addQ(t, "String vs StringBuilder vs StringBuffer", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-string-builder-string-buffer",
            "VIDEO", "https://www.youtube.com/watch?v=Bj9Mx_Lx3q4");
        addQ(t, "String Comparison - == vs equals() vs compareTo()", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-compare-strings",
            "VIDEO", "https://www.youtube.com/watch?v=Bj9Mx_Lx3q4");
        addQ(t, "intern() Method", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/string-pool-java-vs-c",
            "VIDEO", "https://www.youtube.com/watch?v=Bj9Mx_Lx3q4");

        t = createTopic(s, "String Methods");
        addQ(t, "charAt(), indexOf(), substring(), length()", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/data/strings.html",
            "VIDEO", "https://www.youtube.com/watch?v=Bj9Mx_Lx3q4");
        addQ(t, "split(), join(), replace(), replaceAll()", "EASY",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/data/manipstrings.html",
            "VIDEO", "https://www.youtube.com/watch?v=Bj9Mx_Lx3q4");
        addQ(t, "trim(), strip(), isBlank(), isEmpty() (Java 11+)", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-strip-vs-trim",
            "VIDEO", "https://www.youtube.com/watch?v=Bj9Mx_Lx3q4");
        addQ(t, "String.format() and Formatted Strings", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-string-format",
            "VIDEO", "https://www.youtube.com/watch?v=Bj9Mx_Lx3q4");
        addQ(t, "toCharArray(), chars() Stream", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-string-to-char-array",
            "VIDEO", "https://www.youtube.com/watch?v=Bj9Mx_Lx3q4");
        addQ(t, "Text Blocks (Java 13+)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-text-blocks",
            "VIDEO", "https://www.youtube.com/watch?v=Bj9Mx_Lx3q4");

        t = createTopic(s, "Regular Expressions in Java");
        addQ(t, "Pattern and Matcher Classes", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/regex/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=s_3Ob4sJeBk");
        addQ(t, "Common Regex Patterns and Quantifiers", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/regex/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=s_3Ob4sJeBk");
        addQ(t, "matches(), find(), group(), replaceAll() with Regex", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/regular-expressions-java",
            "VIDEO", "https://www.youtube.com/watch?v=s_3Ob4sJeBk");


        // ==========================================
        // Section 20: Design Patterns
        // ==========================================
        s = createSection("Design Patterns");

        t = createTopic(s, "Creational Patterns");
        addQ(t, "Singleton Pattern (Eager, Lazy, Thread-Safe, Enum Singleton)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-singleton",
            "VIDEO", "https://www.youtube.com/watch?v=tDxnyop48mY");
        addQ(t, "Factory Method Pattern", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-factory-pattern",
            "VIDEO", "https://www.youtube.com/watch?v=tDxnyop48mY");
        addQ(t, "Abstract Factory Pattern", "HARD",
            "ARTICLE", "https://www.baeldung.com/java-abstract-factory-pattern",
            "VIDEO", "https://www.youtube.com/watch?v=tDxnyop48mY");
        addQ(t, "Builder Pattern", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-builder-pattern",
            "VIDEO", "https://www.youtube.com/watch?v=tDxnyop48mY");
        addQ(t, "Prototype Pattern", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-pattern-prototype",
            "VIDEO", "https://www.youtube.com/watch?v=tDxnyop48mY");

        t = createTopic(s, "Structural Patterns");
        addQ(t, "Adapter Pattern", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-adapter-pattern",
            "VIDEO", "https://www.youtube.com/watch?v=tDxnyop48mY");
        addQ(t, "Decorator Pattern", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-decorator-pattern",
            "VIDEO", "https://www.youtube.com/watch?v=tDxnyop48mY");
        addQ(t, "Facade Pattern", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-facade-pattern",
            "VIDEO", "https://www.youtube.com/watch?v=tDxnyop48mY");
        addQ(t, "Proxy Pattern", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-proxy-pattern",
            "VIDEO", "https://www.youtube.com/watch?v=tDxnyop48mY");
        addQ(t, "Composite Pattern", "HARD",
            "ARTICLE", "https://www.baeldung.com/java-composite-pattern",
            "VIDEO", "https://www.youtube.com/watch?v=tDxnyop48mY");

        t = createTopic(s, "Behavioral Patterns");
        addQ(t, "Observer Pattern (also used in Event Systems)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-observer-pattern",
            "VIDEO", "https://www.youtube.com/watch?v=tDxnyop48mY");
        addQ(t, "Strategy Pattern", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-strategy-pattern",
            "VIDEO", "https://www.youtube.com/watch?v=tDxnyop48mY");
        addQ(t, "Iterator Pattern", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-iterator",
            "VIDEO", "https://www.youtube.com/watch?v=tDxnyop48mY");
        addQ(t, "Template Method Pattern", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-template-method-pattern",
            "VIDEO", "https://www.youtube.com/watch?v=tDxnyop48mY");
        addQ(t, "Command Pattern", "HARD",
            "ARTICLE", "https://www.baeldung.com/java-command-pattern",
            "VIDEO", "https://www.youtube.com/watch?v=tDxnyop48mY");


        // ==========================================
        // Section 21: Modern Java Features (Java 8–21)
        // ==========================================
        s = createSection("Modern Java Features");

        t = createTopic(s, "Java 8 Features");
        addQ(t, "Default and Static Methods in Interfaces", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-static-default-methods",
            "VIDEO", "https://www.youtube.com/watch?v=kEEoKqdVc_4");
        addQ(t, "Date and Time API (LocalDate, LocalTime, LocalDateTime, ZonedDateTime)", "MEDIUM",
            "ARTICLE", "https://docs.oracle.com/javase/tutorial/datetime/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=kEEoKqdVc_4");
        addQ(t, "DateTimeFormatter", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-datetimeformatter",
            "VIDEO", "https://www.youtube.com/watch?v=kEEoKqdVc_4");
        addQ(t, "Duration and Period", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-period-duration",
            "VIDEO", "https://www.youtube.com/watch?v=kEEoKqdVc_4");

        t = createTopic(s, "Java 9–11 Features");
        addQ(t, "Module System (Project Jigsaw) Basics", "HARD",
            "ARTICLE", "https://www.baeldung.com/java-9-modularity",
            "VIDEO", "https://www.youtube.com/watch?v=73mn9iQCGpU");
        addQ(t, "var - Local Variable Type Inference (Java 10)", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-10-local-variable-type-inference",
            "VIDEO", "https://www.youtube.com/watch?v=73mn9iQCGpU");
        addQ(t, "String API Additions - strip(), repeat(), lines(), isBlank() (Java 11)", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-11-string-api",
            "VIDEO", "https://www.youtube.com/watch?v=73mn9iQCGpU");
        addQ(t, "Collection Factory Methods - List.of(), Map.of(), Set.of() (Java 9)", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-9-collections-factory-methods",
            "VIDEO", "https://www.youtube.com/watch?v=73mn9iQCGpU");
        addQ(t, "try-with-resources on Effectively Final Variables (Java 9)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-9-try-with-resources",
            "VIDEO", "https://www.youtube.com/watch?v=73mn9iQCGpU");

        t = createTopic(s, "Java 14–17 Features");
        addQ(t, "Records (Java 16) - Immutable Data Classes", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-record-keyword",
            "VIDEO", "https://www.youtube.com/watch?v=V_mzFdFTk6I");
        addQ(t, "Sealed Classes and Interfaces (Java 17)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-sealed-classes-interfaces",
            "VIDEO", "https://www.youtube.com/watch?v=V_mzFdFTk6I");
        addQ(t, "Pattern Matching for instanceof (Java 16)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-pattern-matching-instanceof",
            "VIDEO", "https://www.youtube.com/watch?v=aKaw9W789wU");
        addQ(t, "Switch Expressions (Java 14) - Arrow Syntax and yield", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-switch",
            "VIDEO", "https://www.youtube.com/watch?v=aKaw9W789wU");
        addQ(t, "Text Blocks (Java 15)", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-text-blocks",
            "VIDEO", "https://www.youtube.com/watch?v=V_mzFdFTk6I");
        addQ(t, "Helpful NullPointerExceptions (Java 14)", "EASY",
            "ARTICLE", "https://www.baeldung.com/java-14-nullpointerexception",
            "VIDEO", "https://www.youtube.com/watch?v=V_mzFdFTk6I");

        t = createTopic(s, "Java 21 Features");
        addQ(t, "Virtual Threads (Project Loom)", "HARD",
            "ARTICLE", "https://www.baeldung.com/java-virtual-thread-vs-thread",
            "VIDEO", "https://www.youtube.com/watch?v=MOPeVNUTKBQ");
        addQ(t, "Pattern Matching for switch (Java 21)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-switch-pattern-matching",
            "VIDEO", "https://www.youtube.com/watch?v=aKaw9W789wU");
        addQ(t, "Record Patterns for Deconstruction", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-21-record-patterns",
            "VIDEO", "https://www.youtube.com/watch?v=b5tq4hU2WS8");
        addQ(t, "Sequenced Collections (SequencedCollection, SequencedMap)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-21-sequenced-collections",
            "VIDEO", "https://www.youtube.com/watch?v=b5tq4hU2WS8");


        // ==========================================
        // Section 22: Memory Management and JVM Internals
        // ==========================================
        s = createSection("Memory Management and JVM Internals");

        t = createTopic(s, "JVM Memory Model");
        addQ(t, "JVM Memory Areas - Heap, Stack, Method Area, PC Register, Native Stack", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-stack-heap",
            "VIDEO", "https://www.youtube.com/watch?v=7uRtdHa7sEU");
        addQ(t, "Heap Memory - Young Generation, Old Generation, Metaspace", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-memory-management-interview-questions",
            "VIDEO", "https://www.youtube.com/watch?v=7uRtdHa7sEU");
        addQ(t, "Stack Memory and Stack Frames", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-stack-heap",
            "VIDEO", "https://www.youtube.com/watch?v=7uRtdHa7sEU");
        addQ(t, "Method Area and Runtime Constant Pool", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/jvm-method-area-vs-metaspace",
            "VIDEO", "https://www.youtube.com/watch?v=7uRtdHa7sEU");

        t = createTopic(s, "Garbage Collection");
        addQ(t, "What is Garbage Collection?", "EASY",
            "ARTICLE", "https://www.baeldung.com/jvm-garbage-collectors",
            "VIDEO", "https://www.youtube.com/watch?v=UnaNQgzw4zY");
        addQ(t, "GC Roots and Reachability", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-gc-roots",
            "VIDEO", "https://www.youtube.com/watch?v=UnaNQgzw4zY");
        addQ(t, "Minor GC vs Major GC vs Full GC", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-minor-major-gc",
            "VIDEO", "https://www.youtube.com/watch?v=UnaNQgzw4zY");
        addQ(t, "GC Algorithms - Serial, Parallel, G1, ZGC, Shenandoah", "HARD",
            "ARTICLE", "https://www.baeldung.com/jvm-garbage-collectors",
            "VIDEO", "https://www.youtube.com/watch?v=UnaNQgzw4zY");
        addQ(t, "finalize() Method and Cleaner API", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-finalize",
            "VIDEO", "https://www.youtube.com/watch?v=UnaNQgzw4zY");
        addQ(t, "Memory Leaks - Common Causes and How to Detect", "HARD",
            "ARTICLE", "https://www.baeldung.com/java-memory-leaks",
            "VIDEO", "https://www.youtube.com/watch?v=UnaNQgzw4zY");

        t = createTopic(s, "Object Lifecycle and References");
        addQ(t, "Object Creation Internals (new Keyword Deep Dive)", "MEDIUM",
            "ARTICLE", "https://www.baeldung.com/java-object-creation",
            "VIDEO", "https://www.youtube.com/watch?v=7uRtdHa7sEU");
        addQ(t, "Strong, Weak, Soft and Phantom References", "HARD",
            "ARTICLE", "https://www.baeldung.com/java-weak-reference",
            "VIDEO", "https://www.youtube.com/watch?v=7uRtdHa7sEU");
        addQ(t, "WeakReference and WeakHashMap Use Cases", "HARD",
            "ARTICLE", "https://www.baeldung.com/java-weakhashmap",
            "VIDEO", "https://www.youtube.com/watch?v=7uRtdHa7sEU");


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