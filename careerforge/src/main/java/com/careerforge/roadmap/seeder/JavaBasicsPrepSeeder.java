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
        System.out.println("Seeding Roadmap: Core Java by Durga Sir (OCJP/SCJP)");
        Roadmap.sections.clear();

        RoadmapSection s;
        Topic t;

        // ==========================================
        // Section 1: Language Fundamentals
        // ==========================================
        s = createSection("Language Fundamentals");

        t = createTopic(s, "Identifiers and Reserved Words");
        addQ(t, "Java Identifiers - Rules and Examples", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html",
                "VIDEO", "https://www.youtube.com/watch?v=eTXd89t8ngI");
        addQ(t, "Reserved Words in Java (53 Keywords)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html",
                "VIDEO", "https://www.youtube.com/watch?v=eTXd89t8ngI");
        addQ(t, "Keywords vs Literals (true, false, null)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html",
                "VIDEO", "https://www.youtube.com/watch?v=eTXd89t8ngI");

        t = createTopic(s, "Data Types");
        addQ(t, "Primitive Data Types - byte, short, int, long", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html",
                "VIDEO", "https://www.youtube.com/watch?v=njy7NGYzsvM");
        addQ(t, "Primitive Data Types - float, double, char, boolean", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html",
                "VIDEO", "https://www.youtube.com/watch?v=HYAosZptldA");
        addQ(t, "Size and Range of Each Data Type", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html",
                "VIDEO", "https://www.youtube.com/watch?v=njy7NGYzsvM");
        addQ(t, "Java is Not Purely Object Oriented - Why?", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html",
                "VIDEO", "https://www.youtube.com/watch?v=HYAosZptldA");

        t = createTopic(s, "Literals");
        addQ(t, "Integral Literals (Decimal, Octal, Hexadecimal, Binary)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkWWJd8flj3echGYm3y5dXo");
        addQ(t, "Floating Point Literals", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkWWJd8flj3echGYm3y5dXo");
        addQ(t, "Char Literals and Unicode Representation", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkWWJd8flj3echGYm3y5dXo");
        addQ(t, "String Literals and Boolean Literals", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkWWJd8flj3echGYm3y5dXo");
        addQ(t, "Underscore in Numeric Literals (Java 7)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkWWJd8flj3echGYm3y5dXo");

        t = createTopic(s, "Arrays");
        addQ(t, "Array Declaration and Creation", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkWWJd8flj3echGYm3y5dXo");
        addQ(t, "Multi-Dimensional Array Creation", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkWWJd8flj3echGYm3y5dXo");
        addQ(t, "Array Initialization and Anonymous Arrays", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkWWJd8flj3echGYm3y5dXo");
        addQ(t, "length vs length() Method", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkWWJd8flj3echGYm3y5dXo");
        addQ(t, "Array Element Assignments and Variable Assignments", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkWWJd8flj3echGYm3y5dXo");

        t = createTopic(s, "Types of Variables");
        addQ(t, "Instance Variables", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkWWJd8flj3echGYm3y5dXo");
        addQ(t, "Static Variables (Class Variables)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkWWJd8flj3echGYm3y5dXo");
        addQ(t, "Local Variables", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkWWJd8flj3echGYm3y5dXo");
        addQ(t, "Uninitialized Variable Behavior (Instance, Static, Local)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkWWJd8flj3echGYm3y5dXo");

        t = createTopic(s, "Var-Arg Methods and Main Method");
        addQ(t, "Var-Arg Methods (Variable Arguments)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkWWJd8flj3echGYm3y5dXo");
        addQ(t, "Single Dimensional Array vs Var-Arg Method", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkWWJd8flj3echGYm3y5dXo");
        addQ(t, "main() Method - All Variations", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/getStarted/application/index.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkWWJd8flj3echGYm3y5dXo");
        addQ(t, "Command Line Arguments", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/environment/cmdLineArgs.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkWWJd8flj3echGYm3y5dXo");
        addQ(t, "Java Coding Standards (Classes, Methods, Variables, Constants)", "EASY",
                "ARTICLE", "https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkWWJd8flj3echGYm3y5dXo");


        // ==========================================
        // Section 2: Operators and Assignments
        // ==========================================
        s = createSection("Operators and Assignments");

        t = createTopic(s, "Increment and Decrement Operators");
        addQ(t, "Pre-Increment and Post-Increment", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl8wA1uxYRjiHPaDcnEuYGF");
        addQ(t, "Increment/Decrement Applied to byte, short", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl8wA1uxYRjiHPaDcnEuYGF");

        t = createTopic(s, "Arithmetic Operators");
        addQ(t, "Arithmetic Operators and Infinity", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl8wA1uxYRjiHPaDcnEuYGF");
        addQ(t, "NaN (Not a Number)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl8wA1uxYRjiHPaDcnEuYGF");
        addQ(t, "String Concatenation using + Operator", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl8wA1uxYRjiHPaDcnEuYGF");

        t = createTopic(s, "Relational and Equality Operators");
        addQ(t, "Relational Operators (<, >, <=, >=)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl8wA1uxYRjiHPaDcnEuYGF");
        addQ(t, "Equality Operators (== and !=) for Primitives and Objects", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl8wA1uxYRjiHPaDcnEuYGF");
        addQ(t, "instanceof Operator", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl8wA1uxYRjiHPaDcnEuYGF");

        t = createTopic(s, "Bitwise Operators");
        addQ(t, "Bitwise AND (&), OR (|), XOR (^)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl8wA1uxYRjiHPaDcnEuYGF");
        addQ(t, "Bitwise Complement (~)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl8wA1uxYRjiHPaDcnEuYGF");
        addQ(t, "Short-Circuit Operators (&& and ||)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl8wA1uxYRjiHPaDcnEuYGF");

        t = createTopic(s, "Shift Operators");
        addQ(t, "Left Shift (<<)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl8wA1uxYRjiHPaDcnEuYGF");
        addQ(t, "Right Shift (>>) and Unsigned Right Shift (>>>)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl8wA1uxYRjiHPaDcnEuYGF");

        t = createTopic(s, "Assignment Operators and Type Casting");
        addQ(t, "Compound Assignment Operators (+=, -=, *=, /=, %=)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl8wA1uxYRjiHPaDcnEuYGF");
        addQ(t, "Implicit Type Casting in Compound Assignments", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl8wA1uxYRjiHPaDcnEuYGF");
        addQ(t, "Ternary Operator (?:)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl8wA1uxYRjiHPaDcnEuYGF");
        addQ(t, "Operator Precedence Table", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl8wA1uxYRjiHPaDcnEuYGF");
        addQ(t, "new Operator", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl8wA1uxYRjiHPaDcnEuYGF");


        // ==========================================
        // Section 3: Flow Control
        // ==========================================
        s = createSection("Flow Control");

        t = createTopic(s, "if-else and switch");
        addQ(t, "if-else Statement", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMrf2NOEA61tXwCXdbvoi4");
        addQ(t, "switch-case Statement", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMrf2NOEA61tXwCXdbvoi4");
        addQ(t, "Allowed Data Types in switch (Including String in Java 7)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMrf2NOEA61tXwCXdbvoi4");
        addQ(t, "Fall-Through in switch and break Statement", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMrf2NOEA61tXwCXdbvoi4");

        t = createTopic(s, "Loops");
        addQ(t, "while Loop", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMrf2NOEA61tXwCXdbvoi4");
        addQ(t, "do-while Loop", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMrf2NOEA61tXwCXdbvoi4");
        addQ(t, "for Loop", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMrf2NOEA61tXwCXdbvoi4");
        addQ(t, "Enhanced for-each Loop (for-each)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMrf2NOEA61tXwCXdbvoi4");
        addQ(t, "Nested Loops", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMrf2NOEA61tXwCXdbvoi4");

        t = createTopic(s, "Transfer Statements");
        addQ(t, "break Statement (Labeled and Unlabeled)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/branch.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMrf2NOEA61tXwCXdbvoi4");
        addQ(t, "continue Statement (Labeled and Unlabeled)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/branch.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMrf2NOEA61tXwCXdbvoi4");
        addQ(t, "return Statement", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/branch.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMrf2NOEA61tXwCXdbvoi4");


        // ==========================================
        // Section 4: Declarations and Access Modifiers
        // ==========================================
        s = createSection("Declarations and Access Modifiers");

        t = createTopic(s, "Java Source File Structure");
        addQ(t, "package Statement", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/package/packages.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMH-BdI3A39-8v7m9xMP2z");
        addQ(t, "import Statement - Explicit vs Wildcard", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/package/usepkgs.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMH-BdI3A39-8v7m9xMP2z");
        addQ(t, "Class Definition Rules in a Source File", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/package/packages.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMH-BdI3A39-8v7m9xMP2z");
        addQ(t, "Static Import", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/package/usepkgs.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMH-BdI3A39-8v7m9xMP2z");

        t = createTopic(s, "Access Modifiers");
        addQ(t, "public Access Modifier", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMH-BdI3A39-8v7m9xMP2z");
        addQ(t, "private Access Modifier", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMH-BdI3A39-8v7m9xMP2z");
        addQ(t, "protected Access Modifier", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMH-BdI3A39-8v7m9xMP2z");
        addQ(t, "Default (Package-Private) Access", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMH-BdI3A39-8v7m9xMP2z");

        t = createTopic(s, "Modifiers");
        addQ(t, "final Modifier (Variables, Methods, Classes)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/final.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMH-BdI3A39-8v7m9xMP2z");
        addQ(t, "abstract Modifier", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMH-BdI3A39-8v7m9xMP2z");
        addQ(t, "static Modifier", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMH-BdI3A39-8v7m9xMP2z");
        addQ(t, "native, synchronized, transient, volatile, strictfp", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMH-BdI3A39-8v7m9xMP2z");
        addQ(t, "Modifier Combinations - What is Legal?", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMH-BdI3A39-8v7m9xMP2z");

        t = createTopic(s, "Interfaces and Abstract Classes - Declarations");
        addQ(t, "Interface Declarations and Implicit Modifiers", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMH-BdI3A39-8v7m9xMP2z");
        addQ(t, "Abstract Class Declarations", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnMH-BdI3A39-8v7m9xMP2z");


        // ==========================================
        // Section 5: OOPs Concepts
        // ==========================================
        s = createSection("OOPs Concepts");

        t = createTopic(s, "Data Hiding and Abstraction");
        addQ(t, "Data Hiding using private", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/concepts/object.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");
        addQ(t, "Abstraction - Abstract Classes and Interfaces", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");

        t = createTopic(s, "Encapsulation");
        addQ(t, "Encapsulation with Getters and Setters", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");
        addQ(t, "Tightly Encapsulated Class", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");

        t = createTopic(s, "Inheritance");
        addQ(t, "IS-A Relationship (extends keyword)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");
        addQ(t, "HAS-A Relationship (Composition)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");
        addQ(t, "Method Overriding Rules", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/override.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");
        addQ(t, "super Keyword in Inheritance", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/super.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");
        addQ(t, "Why Java Does Not Support Multiple Inheritance", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/multipleinheritance.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");

        t = createTopic(s, "Polymorphism");
        addQ(t, "Overloading - Compile-Time Polymorphism", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");
        addQ(t, "Overriding - Runtime Polymorphism", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");
        addQ(t, "Dynamic Method Dispatch", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");
        addQ(t, "Upcasting and Downcasting", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");

        t = createTopic(s, "Constructors");
        addQ(t, "Constructor Rules and Default Constructor", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");
        addQ(t, "Constructor Overloading", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");
        addQ(t, "Constructor Chaining - this() and super()", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");

        t = createTopic(s, "Interfaces");
        addQ(t, "Interface Declaration and Implementation", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");
        addQ(t, "Extending Interfaces", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/nogrow.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");
        addQ(t, "Default and Static Methods in Interfaces (Java 8)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");
        addQ(t, "Abstract Class vs Interface - When to Use Which", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");

        t = createTopic(s, "Object Class Methods");
        addQ(t, "toString() Method", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/objectclass.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");
        addQ(t, "equals() Method", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/objectclass.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");
        addQ(t, "hashCode() Method", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/objectclass.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");
        addQ(t, "finalize() Method", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/objectclass.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");
        addQ(t, "clone() Method", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/objectclass.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn7zNVRm_ZjnWqnf5osnKxq");


        // ==========================================
        // Section 6: Exception Handling
        // ==========================================
        s = createSection("Exception Handling");

        t = createTopic(s, "Introduction to Exceptions");
        addQ(t, "What is an Exception and Exception Handling", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/exceptions/definition.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnSkaum39zWYI6bPb3i7liz");
        addQ(t, "Exception Hierarchy - Throwable, Error, Exception", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/exceptions/catchOrDeclare.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnSkaum39zWYI6bPb3i7liz");
        addQ(t, "Checked vs Unchecked Exceptions", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnSkaum39zWYI6bPb3i7liz");
        addQ(t, "Fully Checked vs Partially Checked Exceptions", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnSkaum39zWYI6bPb3i7liz");

        t = createTopic(s, "try-catch-finally");
        addQ(t, "try-catch Block", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/exceptions/try.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnSkaum39zWYI6bPb3i7liz");
        addQ(t, "Multiple catch Blocks", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/exceptions/catch.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnSkaum39zWYI6bPb3i7liz");
        addQ(t, "finally Block - When Does It Execute?", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/exceptions/finally.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnSkaum39zWYI6bPb3i7liz");
        addQ(t, "try-with-resources (Java 7)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnSkaum39zWYI6bPb3i7liz");
        addQ(t, "Multi-catch Block (Java 7)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/exceptions/catch.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnSkaum39zWYI6bPb3i7liz");

        t = createTopic(s, "throw and throws");
        addQ(t, "throw Keyword", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnSkaum39zWYI6bPb3i7liz");
        addQ(t, "throws Keyword", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/exceptions/declaring.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnSkaum39zWYI6bPb3i7liz");
        addQ(t, "Exception Propagation", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/exceptions/declaring.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnSkaum39zWYI6bPb3i7liz");

        t = createTopic(s, "Custom Exceptions and Overriding Rules");
        addQ(t, "Creating Custom (User-Defined) Exceptions", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/exceptions/creating.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnSkaum39zWYI6bPb3i7liz");
        addQ(t, "Exception Handling in Method Overriding", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/exceptions/declaring.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnSkaum39zWYI6bPb3i7liz");
        addQ(t, "Top 10 Exceptions in Java", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnSkaum39zWYI6bPb3i7liz");


        // ==========================================
        // Section 7: Multithreading
        // ==========================================
        s = createSection("Multithreading");

        t = createTopic(s, "Introduction to Threads");
        addQ(t, "What is Multitasking? Process-Based vs Thread-Based", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/procthread.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlHj_fVVjUIVHjD5uEy2kk4");
        addQ(t, "Thread Lifecycle (New, Runnable, Running, Waiting/Blocked, Dead)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/procthread.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlHj_fVVjUIVHjD5uEy2kk4");

        t = createTopic(s, "Creating Threads");
        addQ(t, "Extending Thread Class", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlHj_fVVjUIVHjD5uEy2kk4");
        addQ(t, "Implementing Runnable Interface", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlHj_fVVjUIVHjD5uEy2kk4");
        addQ(t, "Thread Class vs Runnable Interface", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlHj_fVVjUIVHjD5uEy2kk4");

        t = createTopic(s, "Thread Methods");
        addQ(t, "start(), run(), sleep(), join()", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlHj_fVVjUIVHjD5uEy2kk4");
        addQ(t, "yield(), setPriority(), getPriority()", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/procthread.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlHj_fVVjUIVHjD5uEy2kk4");
        addQ(t, "setDaemon() and isDaemon() - Daemon Threads", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/procthread.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlHj_fVVjUIVHjD5uEy2kk4");
        addQ(t, "interrupt() Method", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/interrupt.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlHj_fVVjUIVHjD5uEy2kk4");

        t = createTopic(s, "Synchronization");
        addQ(t, "Synchronized Methods", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlHj_fVVjUIVHjD5uEy2kk4");
        addQ(t, "Synchronized Block", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlHj_fVVjUIVHjD5uEy2kk4");
        addQ(t, "Class-Level Lock vs Object-Level Lock", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlHj_fVVjUIVHjD5uEy2kk4");

        t = createTopic(s, "Inter-Thread Communication and Deadlock");
        addQ(t, "wait(), notify(), notifyAll()", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlHj_fVVjUIVHjD5uEy2kk4");
        addQ(t, "Producer-Consumer Problem", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlHj_fVVjUIVHjD5uEy2kk4");
        addQ(t, "Deadlock - Definition and Example", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/deadlock.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlHj_fVVjUIVHjD5uEy2kk4");
        addQ(t, "Starvation and Livelock", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/starvelive.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlHj_fVVjUIVHjD5uEy2kk4");


        // ==========================================
        // Section 8: Multithreading Enhancements
        // ==========================================
        s = createSection("Multithreading Enhancements");

        t = createTopic(s, "Thread Pool and Executor Framework");
        addQ(t, "ThreadPool Concept", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/pools.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlSrYBSaCc7KBEXtaLWt_u5");
        addQ(t, "Executor, ExecutorService, Executors", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/exinter.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlSrYBSaCc7KBEXtaLWt_u5");
        addQ(t, "Callable and Future", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/exinter.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlSrYBSaCc7KBEXtaLWt_u5");

        t = createTopic(s, "Locks and Atomic Classes");
        addQ(t, "ReentrantLock - Lock and Unlock", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/newlocks.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlSrYBSaCc7KBEXtaLWt_u5");
        addQ(t, "tryLock() and lockInterruptibly()", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/newlocks.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlSrYBSaCc7KBEXtaLWt_u5");
        addQ(t, "Atomic Classes (AtomicInteger, AtomicLong)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/atomicvars.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlSrYBSaCc7KBEXtaLWt_u5");

        t = createTopic(s, "Thread-Safe Classes");
        addQ(t, "volatile Keyword", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/atomic.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlSrYBSaCc7KBEXtaLWt_u5");
        addQ(t, "ThreadLocal Class", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/8/docs/api/java/lang/ThreadLocal.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlSrYBSaCc7KBEXtaLWt_u5");


        // ==========================================
        // Section 9: Inner Classes
        // ==========================================
        s = createSection("Inner Classes");

        t = createTopic(s, "Types of Inner Classes");
        addQ(t, "Regular (Member) Inner Class", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnubQH6Gt8O8Dg-115U0ftk");
        addQ(t, "Method-Local Inner Class", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/localclasses.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnubQH6Gt8O8Dg-115U0ftk");
        addQ(t, "Anonymous Inner Class", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnubQH6Gt8O8Dg-115U0ftk");
        addQ(t, "Static Nested Class", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnubQH6Gt8O8Dg-115U0ftk");

        t = createTopic(s, "Inner Class Details");
        addQ(t, "Accessing Outer Class Members from Inner Class", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnubQH6Gt8O8Dg-115U0ftk");
        addQ(t, "Anonymous Inner Class with Interface and Abstract Class", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnubQH6Gt8O8Dg-115U0ftk");
        addQ(t, ".class Files Generated for Inner Classes", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnubQH6Gt8O8Dg-115U0ftk");


        // ==========================================
        // Section 10: java.lang Package
        // ==========================================
        s = createSection("java.lang Package");

        t = createTopic(s, "Object Class");
        addQ(t, "Object Class Methods Overview", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/objectclass.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlEa6-58nC6bnpx43VZiTnN");
        addQ(t, "equals() and hashCode() Contract", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/IandI/objectclass.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlEa6-58nC6bnpx43VZiTnN");

        t = createTopic(s, "String Class");
        addQ(t, "String Immutability and String Pool", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/data/strings.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlEa6-58nC6bnpx43VZiTnN");
        addQ(t, "Important String Methods", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/data/manipstrings.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlEa6-58nC6bnpx43VZiTnN");
        addQ(t, "String Comparison (== vs equals() vs compareTo())", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/data/comparestrings.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlEa6-58nC6bnpx43VZiTnN");

        t = createTopic(s, "StringBuffer and StringBuilder");
        addQ(t, "StringBuffer vs String (Mutable vs Immutable)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/data/buffers.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlEa6-58nC6bnpx43VZiTnN");
        addQ(t, "StringBuilder vs StringBuffer (Thread Safety)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/data/buffers.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlEa6-58nC6bnpx43VZiTnN");
        addQ(t, "Important Methods - append(), insert(), delete(), reverse()", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/data/buffers.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlEa6-58nC6bnpx43VZiTnN");

        t = createTopic(s, "Wrapper Classes");
        addQ(t, "Wrapper Classes Overview (Integer, Double, Character, etc.)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/data/numberclasses.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlEa6-58nC6bnpx43VZiTnN");
        addQ(t, "Autoboxing and Unboxing", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlEa6-58nC6bnpx43VZiTnN");
        addQ(t, "parseInt(), valueOf(), toString() in Wrapper Classes", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/data/numberclasses.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlEa6-58nC6bnpx43VZiTnN");

        t = createTopic(s, "Math Class");
        addQ(t, "Math Class Methods (abs, ceil, floor, round, pow, sqrt)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/data/beyondmath.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlEa6-58nC6bnpx43VZiTnN");
        addQ(t, "Math.random()", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/data/beyondmath.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlEa6-58nC6bnpx43VZiTnN");


        // ==========================================
        // Section 11: Collections
        // ==========================================
        s = createSection("Collections");

        t = createTopic(s, "Introduction to Collections");
        addQ(t, "Arrays vs Collections", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/intro/index.html",
                "VIDEO", "https://www.youtube.com/watch?v=Bqv4At5vHVQ");
        addQ(t, "Collection Interface Hierarchy", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html",
                "VIDEO", "https://www.youtube.com/watch?v=Bqv4At5vHVQ");
        addQ(t, "Collection vs Collections (class vs interface)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/intro/index.html",
                "VIDEO", "https://www.youtube.com/watch?v=Bqv4At5vHVQ");

        t = createTopic(s, "List Interface");
        addQ(t, "ArrayList - Internals and Usage", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/implementations/list.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOklywocjGz7Z02rqbLegX22");
        addQ(t, "LinkedList - Doubly Linked List Implementation", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/implementations/list.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOklywocjGz7Z02rqbLegX22");
        addQ(t, "Vector vs ArrayList", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/implementations/list.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOklywocjGz7Z02rqbLegX22");
        addQ(t, "Stack Class", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOklywocjGz7Z02rqbLegX22");

        t = createTopic(s, "Set Interface");
        addQ(t, "HashSet - No Order, No Duplicates", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/implementations/set.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOklywocjGz7Z02rqbLegX22");
        addQ(t, "LinkedHashSet - Insertion Order", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/implementations/set.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOklywocjGz7Z02rqbLegX22");
        addQ(t, "TreeSet - Sorted Order and Comparable", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/interfaces/sortedset.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOklywocjGz7Z02rqbLegX22");

        t = createTopic(s, "Map Interface");
        addQ(t, "HashMap - Key-Value Pairs", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/interfaces/map.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOklywocjGz7Z02rqbLegX22");
        addQ(t, "LinkedHashMap - Insertion Order Map", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/implementations/map.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOklywocjGz7Z02rqbLegX22");
        addQ(t, "TreeMap - Sorted Map", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/interfaces/sortedmap.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOklywocjGz7Z02rqbLegX22");
        addQ(t, "Hashtable vs HashMap", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/implementations/map.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOklywocjGz7Z02rqbLegX22");

        t = createTopic(s, "Queue and Deque");
        addQ(t, "PriorityQueue", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/interfaces/queue.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOklywocjGz7Z02rqbLegX22");
        addQ(t, "ArrayDeque", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/interfaces/deque.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOklywocjGz7Z02rqbLegX22");

        t = createTopic(s, "Comparable and Comparator");
        addQ(t, "Comparable Interface (compareTo())", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOklywocjGz7Z02rqbLegX22");
        addQ(t, "Comparator Interface (compare())", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOklywocjGz7Z02rqbLegX22");
        addQ(t, "Comparable vs Comparator", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOklywocjGz7Z02rqbLegX22");

        t = createTopic(s, "Collections Utility Class");
        addQ(t, "sort(), binarySearch(), reverse(), shuffle()", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/algorithms/index.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOklywocjGz7Z02rqbLegX22");
        addQ(t, "unmodifiableList(), synchronizedList()", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/implementations/wrapper.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOklywocjGz7Z02rqbLegX22");
        addQ(t, "Cursors - Enumeration, Iterator, ListIterator", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOklywocjGz7Z02rqbLegX22");


        // ==========================================
        // Section 12: Generics
        // ==========================================
        s = createSection("Generics");

        t = createTopic(s, "Introduction to Generics");
        addQ(t, "Why Generics? Type Safety at Compile Time", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/extra/generics/index.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn4AAHRh5lmOXhoU0tZwTfU");
        addQ(t, "Generic Classes", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/extra/generics/index.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn4AAHRh5lmOXhoU0tZwTfU");
        addQ(t, "Generic Methods", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/extra/generics/methods.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn4AAHRh5lmOXhoU0tZwTfU");

        t = createTopic(s, "Bounded Type Parameters and Wildcards");
        addQ(t, "Bounded Type Parameters (extends)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/extra/generics/bounded.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn4AAHRh5lmOXhoU0tZwTfU");
        addQ(t, "Wildcard (?) - Upper and Lower Bounded Wildcards", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/extra/generics/wildcards.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn4AAHRh5lmOXhoU0tZwTfU");
        addQ(t, "Generic Interoperability with Collections", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/extra/generics/legacy.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn4AAHRh5lmOXhoU0tZwTfU");
        addQ(t, "Type Erasure", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/extra/generics/erasure.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOn4AAHRh5lmOXhoU0tZwTfU");


        // ==========================================
        // Section 13: Concurrent Collections
        // ==========================================
        s = createSection("Concurrent Collections");

        t = createTopic(s, "Need for Concurrent Collections");
        addQ(t, "Problems with Traditional Collections in Multithreading", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/collections.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlrFicu7spv8Z772MgGbXfQ");
        addQ(t, "ConcurrentModificationException", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/collections.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlrFicu7spv8Z772MgGbXfQ");

        t = createTopic(s, "Concurrent Collection Classes");
        addQ(t, "ConcurrentHashMap", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentHashMap.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlrFicu7spv8Z772MgGbXfQ");
        addQ(t, "CopyOnWriteArrayList", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CopyOnWriteArrayList.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlrFicu7spv8Z772MgGbXfQ");
        addQ(t, "CopyOnWriteArraySet", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CopyOnWriteArraySet.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlrFicu7spv8Z772MgGbXfQ");
        addQ(t, "BlockingQueue (ArrayBlockingQueue, LinkedBlockingQueue)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/concurrency/collections.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOlrFicu7spv8Z772MgGbXfQ");


        // ==========================================
        // Section 14: File I/O
        // ==========================================
        s = createSection("File IO");

        t = createTopic(s, "File Class");
        addQ(t, "Creating, Deleting, Renaming Files using File Class", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/io/file.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkEwNL3uI7PSS-FDAxhtXJ3");
        addQ(t, "Checking File Properties (exists, isFile, isDirectory, length)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/io/fileAttr.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkEwNL3uI7PSS-FDAxhtXJ3");
        addQ(t, "Listing Files in a Directory", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/io/dirs.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkEwNL3uI7PSS-FDAxhtXJ3");

        t = createTopic(s, "Streams - Byte and Character");
        addQ(t, "FileInputStream and FileOutputStream (Byte Streams)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/io/bytestreams.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkEwNL3uI7PSS-FDAxhtXJ3");
        addQ(t, "FileReader and FileWriter (Character Streams)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/io/charstreams.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkEwNL3uI7PSS-FDAxhtXJ3");
        addQ(t, "BufferedReader and BufferedWriter", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/io/buffers.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkEwNL3uI7PSS-FDAxhtXJ3");
        addQ(t, "PrintWriter", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/io/charstreams.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkEwNL3uI7PSS-FDAxhtXJ3");
        addQ(t, "InputStreamReader and OutputStreamWriter (Bridges)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/io/converting.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkEwNL3uI7PSS-FDAxhtXJ3");

        t = createTopic(s, "Scanning and Formatting");
        addQ(t, "Scanner Class for Reading Input", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/io/scanning.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkEwNL3uI7PSS-FDAxhtXJ3");
        addQ(t, "Formatter and printf()", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/io/formatting.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkEwNL3uI7PSS-FDAxhtXJ3");


        // ==========================================
        // Section 15: Serialization
        // ==========================================
        s = createSection("Serialization");

        t = createTopic(s, "Introduction to Serialization");
        addQ(t, "What is Serialization?", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/jndi/objects/serial.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkE3etrqOSPgkUdcxrEc0Y1");
        addQ(t, "Serializable Interface", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/jndi/objects/serial.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkE3etrqOSPgkUdcxrEc0Y1");
        addQ(t, "ObjectOutputStream and ObjectInputStream", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/jndi/objects/serial.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkE3etrqOSPgkUdcxrEc0Y1");

        t = createTopic(s, "Serialization Details");
        addQ(t, "transient Keyword", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/jndi/objects/serial.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkE3etrqOSPgkUdcxrEc0Y1");
        addQ(t, "serialVersionUID", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/jndi/objects/serial.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkE3etrqOSPgkUdcxrEc0Y1");
        addQ(t, "Externalization (Externalizable Interface)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/8/docs/api/java/io/Externalizable.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkE3etrqOSPgkUdcxrEc0Y1");
        addQ(t, "Serialization with Inheritance", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/jndi/objects/serial.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkE3etrqOSPgkUdcxrEc0Y1");


        // ==========================================
        // Section 16: Garbage Collection
        // ==========================================
        s = createSection("Garbage Collection");

        t = createTopic(s, "How Garbage Collection Works");
        addQ(t, "What is Garbage Collection?", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOllQyx0M9BgrqdRno8HMaU0");
        addQ(t, "Eligible Objects for GC", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOllQyx0M9BgrqdRno8HMaU0");
        addQ(t, "Ways to Make an Object Eligible for GC", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOllQyx0M9BgrqdRno8HMaU0");
        addQ(t, "System.gc() and Runtime.gc()", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOllQyx0M9BgrqdRno8HMaU0");
        addQ(t, "finalize() Method in GC", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOllQyx0M9BgrqdRno8HMaU0");
        addQ(t, "Generational Garbage Collection (Young, Old, PermGen)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOllQyx0M9BgrqdRno8HMaU0");


        // ==========================================
        // Section 17: ENUM
        // ==========================================
        s = createSection("ENUM");

        t = createTopic(s, "Introduction to Enums");
        addQ(t, "What is an Enum?", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOmAtH3O4mUyaFlX8paWwye9");
        addQ(t, "Enum Declaration and Usage", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOmAtH3O4mUyaFlX8paWwye9");
        addQ(t, "Enum in switch Statement", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOmAtH3O4mUyaFlX8paWwye9");

        t = createTopic(s, "Enum Advanced Features");
        addQ(t, "Enum with Constructor, Fields, and Methods", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOmAtH3O4mUyaFlX8paWwye9");
        addQ(t, "Enum implements Interface", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOmAtH3O4mUyaFlX8paWwye9");
        addQ(t, "values(), ordinal(), name(), valueOf()", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOmAtH3O4mUyaFlX8paWwye9");
        addQ(t, "EnumSet and EnumMap", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/8/docs/api/java/util/EnumSet.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOmAtH3O4mUyaFlX8paWwye9");


        // ==========================================
        // Section 18: Regular Expressions
        // ==========================================
        s = createSection("Regular Expressions");

        t = createTopic(s, "Regex Basics");
        addQ(t, "Introduction to Regular Expressions", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/regex/intro.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkRBNGYQcanie7yJxnVh7Vy");
        addQ(t, "Character Classes ([abc], [^abc], [a-z])", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/regex/char_classes.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkRBNGYQcanie7yJxnVh7Vy");
        addQ(t, "Predefined Character Classes (\\d, \\w, \\s)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/regex/pre_char_classes.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkRBNGYQcanie7yJxnVh7Vy");
        addQ(t, "Quantifiers (*, +, ?, {n}, {n,m})", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/regex/quant.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkRBNGYQcanie7yJxnVh7Vy");

        t = createTopic(s, "Pattern and Matcher Classes");
        addQ(t, "Pattern.compile() and Matcher", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/regex/pattern.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkRBNGYQcanie7yJxnVh7Vy");
        addQ(t, "matches(), find(), group()", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/regex/matcher.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkRBNGYQcanie7yJxnVh7Vy");
        addQ(t, "String.matches(), String.split(), String.replaceAll() with Regex", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/regex/index.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkRBNGYQcanie7yJxnVh7Vy");


        // ==========================================
        // Section 19: Assertions
        // ==========================================
        s = createSection("Assertions");

        t = createTopic(s, "Introduction to Assertions");
        addQ(t, "What is an Assertion?", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/8/docs/technotes/guides/language/assert.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnaOQ694hLSx-U9KJJ8KMZR");
        addQ(t, "assert Keyword - Simple and Augmented Form", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/8/docs/technotes/guides/language/assert.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnaOQ694hLSx-U9KJJ8KMZR");
        addQ(t, "Enabling and Disabling Assertions (-ea, -da flags)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/8/docs/technotes/guides/language/assert.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnaOQ694hLSx-U9KJJ8KMZR");
        addQ(t, "AssertionError", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/8/docs/technotes/guides/language/assert.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnaOQ694hLSx-U9KJJ8KMZR");
        addQ(t, "Appropriate and Inappropriate Uses of Assertions", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/8/docs/technotes/guides/language/assert.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOnaOQ694hLSx-U9KJJ8KMZR");


        // ==========================================
        // Section 20: JVM Architecture
        // ==========================================
        s = createSection("JVM Architecture");

        t = createTopic(s, "Memory Areas in JVM");
        addQ(t, "Method Area (Class Area)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-2.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl3pHYnuCUoyD_GFKp6SPRA");
        addQ(t, "Heap Area", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-2.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl3pHYnuCUoyD_GFKp6SPRA");
        addQ(t, "Stack Area (JVM Stack and Frames)", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-2.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl3pHYnuCUoyD_GFKp6SPRA");
        addQ(t, "PC Registers and Native Method Stack", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-2.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl3pHYnuCUoyD_GFKp6SPRA");

        t = createTopic(s, "ClassLoader and Execution Engine");
        addQ(t, "ClassLoader Subsystem - Bootstrap, Extension, Application", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-5.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl3pHYnuCUoyD_GFKp6SPRA");
        addQ(t, "Class Loading - Loading, Linking, Initialization", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-5.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl3pHYnuCUoyD_GFKp6SPRA");
        addQ(t, "Execution Engine - Interpreter and JIT Compiler", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-2.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOl3pHYnuCUoyD_GFKp6SPRA");


        // ==========================================
        // Section 21: Internationalization (I18N)
        // ==========================================
        s = createSection("Internationalization");

        t = createTopic(s, "I18N Basics");
        addQ(t, "What is Internationalization (I18N)?", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/i18n/intro/index.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOmT49qQWTgDUNzD8b3_OAJC");
        addQ(t, "Locale Class", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/i18n/locale/index.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOmT49qQWTgDUNzD8b3_OAJC");
        addQ(t, "ResourceBundle and Properties Files", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/i18n/resbundle/index.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOmT49qQWTgDUNzD8b3_OAJC");
        addQ(t, "NumberFormat and DateFormat for Locale-Specific Formatting", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/i18n/format/index.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOmT49qQWTgDUNzD8b3_OAJC");
        addQ(t, "Unicode and Character Encoding", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/i18n/text/index.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOmT49qQWTgDUNzD8b3_OAJC");


        // ==========================================
        // Section 22: Development
        // ==========================================
        s = createSection("Development");

        t = createTopic(s, "Java Development Tools");
        addQ(t, "javac - Java Compiler Options", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/8/docs/technotes/tools/unix/javac.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkYSrI3Ji-cmIWE9_qSh8oq");
        addQ(t, "java - Running Java Programs with Options", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkYSrI3Ji-cmIWE9_qSh8oq");
        addQ(t, "JAR Files - Creating and Using", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/deployment/jar/index.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkYSrI3Ji-cmIWE9_qSh8oq");
        addQ(t, "Classpath and Module Path", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/tutorial/essential/environment/paths.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkYSrI3Ji-cmIWE9_qSh8oq");
        addQ(t, "javadoc - Generating API Documentation", "EASY",
                "ARTICLE", "https://docs.oracle.com/javase/8/docs/technotes/tools/unix/javadoc.html",
                "VIDEO", "https://www.youtube.com/playlist?list=PLd3UqWTnYXOkYSrI3Ji-cmIWE9_qSh8oq");


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
        public static void addSection(RoadmapSection section) { sections.add(section); }
    }

    public static class RoadmapSection {
        public String slug;
        public String title;
        public List<Topic> topics = new ArrayList<>();
        public RoadmapSection(String slug, String title) { this.slug = slug; this.title = title; }
        public void addTopic(Topic topic) { this.topics.add(topic); }
    }

    public static class Topic {
        public String slug;
        public String title;
        public List<Question> questions = new ArrayList<>();
        public Topic(String slug, String title) { this.slug = slug; this.title = title; }
        public void addQuestion(Question question) { this.questions.add(question); }
    }

    public static class Question {
        public String slug;
        public String title;
        public String difficulty;
        public String solveLink;
        public String editorialLink;
        public List<QuestionLink> links = new ArrayList<>();
        public Question(String slug, String title, String difficulty) {
            this.slug = slug; this.title = title; this.difficulty = difficulty;
        }
        public void setSolveLink(String solveLink) { this.solveLink = solveLink; }
        public void setEditorialLink(String editorialLink) { this.editorialLink = editorialLink; }
        public void addLink(QuestionLink link) { this.links.add(link); }
    }

    public static class QuestionLink {
        public String linkType;
        public String url;
        public QuestionLink(String linkType, String url) { this.linkType = linkType; this.url = url; }
    }
}