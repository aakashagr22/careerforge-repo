package com.careerforge.roadmap.seeder;

import java.util.ArrayList;
import java.util.List;

public class DataScientistPrepSeeder {

    public static void seed(
        com.careerforge.roadmap.entity.Roadmap dbRoadmap,
        com.careerforge.roadmap.repository.RoadmapSectionRepository roadmapSectionRepository,
        com.careerforge.roadmap.repository.QuestionRepository questionRepository,
        com.careerforge.roadmap.repository.QuestionLinkRepository questionLinkRepository,
        com.careerforge.roadmap.repository.RoadmapSectionQuestionRepository roadmapSectionQuestionRepository
    ) {
        System.out.println("Seeding Roadmap: Data Scientist Complete Preparation Sheet");
        Roadmap.sections.clear();

        RoadmapSection s;
        Topic t;

        // ==========================================
        // Section 1: Statistics & Probability
        // ==========================================
        s = createSection("Statistics & Probability");

        t = createTopic(s, "Descriptive Statistics");
        addQ(t, "Mean, Median, Mode", "EASY",
            "ARTICLE", "https://www.khanacademy.org/math/statistics-probability/summarizing-quantitative-data",
            "VIDEO", "https://www.youtube.com/watch?v=zRUliXuwJCQ");
        addQ(t, "Variance & Standard Deviation", "EASY",
            "ARTICLE", "https://www.khanacademy.org/math/statistics-probability/summarizing-quantitative-data",
            "VIDEO", "https://www.youtube.com/watch?v=SzZ6GpcfoQY");
        addQ(t, "Skewness & Kurtosis", "MEDIUM",
            "ARTICLE", "https://www.khanacademy.org/math/statistics-probability/summarizing-quantitative-data",
            "VIDEO", "https://www.youtube.com/watch?v=HG1AR5rBBWM");
        addQ(t, "Percentiles, Quartiles & Box Plots", "EASY",
            "ARTICLE", "https://www.khanacademy.org/math/statistics-probability/summarizing-quantitative-data/box-whisker-plots",
            "VIDEO", "https://www.youtube.com/watch?v=zRUliXuwJCQ");

        t = createTopic(s, "Probability Theory");
        addQ(t, "Probability Basics", "EASY",
            "ARTICLE", "https://www.khanacademy.org/math/statistics-probability/probability-library",
            "VIDEO", "https://www.youtube.com/watch?v=Gv9_4yMHFhI");
        addQ(t, "Conditional Probability & Bayes' Theorem", "MEDIUM",
            "ARTICLE", "https://www.khanacademy.org/math/statistics-probability/probability-library/conditional-probability-independence",
            "VIDEO", "https://www.youtube.com/watch?v=HZGCoVF3YvM");
        addQ(t, "Probability Distributions (Normal, Binomial, Poisson)", "MEDIUM",
            "ARTICLE", "https://www.khanacademy.org/math/statistics-probability/random-variables-stats-library",
            "VIDEO", "https://www.youtube.com/watch?v=zRUliXuwJCQ");
        addQ(t, "Central Limit Theorem", "MEDIUM",
            "ARTICLE", "https://www.khanacademy.org/math/statistics-probability/sampling-distributions-library/sample-means/v/central-limit-theorem",
            "VIDEO", "https://www.youtube.com/watch?v=YAlJCEDH2uY");

        t = createTopic(s, "Inferential Statistics");
        addQ(t, "Sampling Techniques", "MEDIUM",
            "ARTICLE", "https://www.khanacademy.org/math/statistics-probability/designing-studies",
            "VIDEO", "https://www.youtube.com/watch?v=zRUliXuwJCQ");
        addQ(t, "Confidence Intervals", "MEDIUM",
            "ARTICLE", "https://www.khanacademy.org/math/statistics-probability/confidence-intervals-one-sample",
            "VIDEO", "https://www.youtube.com/watch?v=TqOeMYtOc1w");
        addQ(t, "Hypothesis Testing & p-values", "MEDIUM",
            "ARTICLE", "https://www.khanacademy.org/math/statistics-probability/significance-tests-one-sample",
            "VIDEO", "https://www.youtube.com/watch?v=vemZtEM63GY");
        addQ(t, "Type I & Type II Errors", "MEDIUM",
            "ARTICLE", "https://www.khanacademy.org/math/statistics-probability/significance-tests-one-sample/error-probabilities-and-power/v/introduction-to-type-i-and-type-ii-errors",
            "VIDEO", "https://www.youtube.com/watch?v=jvBpv1TC-yQ");
        addQ(t, "t-Test, Chi-Square Test, ANOVA", "MEDIUM",
            "ARTICLE", "https://www.khanacademy.org/math/statistics-probability/inference-categorical-data-chi-square-tests",
            "VIDEO", "https://www.youtube.com/watch?v=pTmLQvMM-1M");

        t = createTopic(s, "A/B Testing");
        addQ(t, "Designing an A/B Test", "MEDIUM",
            "ARTICLE", "https://www.khanacademy.org/math/statistics-probability/designing-studies/experiments-observational-studies/a/experiments-and-observational-studies",
            "VIDEO", "https://www.youtube.com/watch?v=zFMgpxG-chM");
        addQ(t, "Statistical Significance in A/B Testing", "MEDIUM",
            "ARTICLE", "https://www.khanacademy.org/math/statistics-probability/significance-tests-one-sample",
            "VIDEO", "https://www.youtube.com/watch?v=zFMgpxG-chM");


        // ==========================================
        // Section 2: Python for Data Science
        // ==========================================
        s = createSection("Python for Data Science");

        t = createTopic(s, "Python Fundamentals");
        addQ(t, "Python Basics (Variables, Loops, Functions)", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/",
            "VIDEO", "https://www.youtube.com/playlist?list=PL-osiE80TeTt2d9bfVyTiXJA-UTHn6WwU");
        addQ(t, "OOP in Python", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/classes.html",
            "VIDEO", "https://www.youtube.com/watch?v=ZDa-Z5JzLYM");

        t = createTopic(s, "NumPy");
        addQ(t, "ndarray Basics & Vectorized Operations", "EASY",
            "ARTICLE", "https://numpy.org/doc/stable/user/quickstart.html",
            "VIDEO", "https://www.youtube.com/watch?v=QUT1VHiLmmI");
        addQ(t, "Broadcasting & Linear Algebra with NumPy", "MEDIUM",
            "ARTICLE", "https://numpy.org/doc/stable/user/basics.broadcasting.html",
            "VIDEO", "https://www.youtube.com/watch?v=QUT1VHiLmmI");

        t = createTopic(s, "Pandas");
        addQ(t, "Getting Started - DataFrame & Series Basics", "EASY",
            "ARTICLE", "https://pandas.pydata.org/docs/user_guide/10min.html",
            "VIDEO", "https://www.youtube.com/watch?v=ZyhVh-qRZPA");
        addQ(t, "Indexing, Filtering & Conditionals", "EASY",
            "ARTICLE", "https://pandas.pydata.org/docs/user_guide/indexing.html",
            "VIDEO", "https://www.youtube.com/playlist?list=PL-osiE80TeTsWmV9i9c58mdDCSskIFdDS");
        addQ(t, "Updating, Adding & Removing Rows/Columns", "EASY",
            "ARTICLE", "https://pandas.pydata.org/docs/user_guide/basics.html",
            "VIDEO", "https://www.youtube.com/playlist?list=PL-osiE80TeTsWmV9i9c58mdDCSskIFdDS");
        addQ(t, "GroupBy, Aggregating & Merging", "MEDIUM",
            "ARTICLE", "https://pandas.pydata.org/docs/user_guide/groupby.html",
            "VIDEO", "https://www.youtube.com/playlist?list=PL-osiE80TeTsWmV9i9c58mdDCSskIFdDS");
        addQ(t, "Cleaning Data - Missing Values & Dtypes", "MEDIUM",
            "ARTICLE", "https://pandas.pydata.org/docs/user_guide/missing_data.html",
            "VIDEO", "https://www.youtube.com/playlist?list=PL-osiE80TeTsWmV9i9c58mdDCSskIFdDS");
        addQ(t, "Working with Dates & Time Series Data", "MEDIUM",
            "ARTICLE", "https://pandas.pydata.org/docs/user_guide/timeseries.html",
            "VIDEO", "https://www.youtube.com/playlist?list=PL-osiE80TeTsWmV9i9c58mdDCSskIFdDS");
        addQ(t, "Reading/Writing Data (CSV, Excel, JSON, SQL)", "EASY",
            "ARTICLE", "https://pandas.pydata.org/docs/user_guide/io.html",
            "VIDEO", "https://www.youtube.com/playlist?list=PL-osiE80TeTsWmV9i9c58mdDCSskIFdDS");

        t = createTopic(s, "Data Visualization in Python");
        addQ(t, "Matplotlib Fundamentals", "EASY",
            "ARTICLE", "https://matplotlib.org/stable/tutorials/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=3Xc3CA655Y4");
        addQ(t, "Seaborn for Statistical Plots", "EASY",
            "ARTICLE", "https://seaborn.pydata.org/tutorial.html",
            "VIDEO", "https://www.youtube.com/watch?v=6GUZXDef2U0");
        addQ(t, "Plotly for Interactive Visualizations", "MEDIUM",
            "ARTICLE", "https://plotly.com/python/",
            "VIDEO", "https://www.youtube.com/watch?v=GGL6U0k8WYA");


        // ==========================================
        // Section 3: SQL for Data Science
        // ==========================================
        s = createSection("SQL for Data Science");

        t = createTopic(s, "SQL Fundamentals");
        addQ(t, "What is a Database & Relational Model", "EASY",
            "ARTICLE", "https://dev.mysql.com/doc/refman/8.4/en/what-is-mysql.html",
            "VIDEO", "https://www.youtube.com/watch?v=HXV3zeQKqGY");
        addQ(t, "SELECT, WHERE, ORDER BY, LIMIT", "EASY",
            "ARTICLE", "https://dev.mysql.com/doc/refman/8.4/en/select.html",
            "VIDEO", "https://www.youtube.com/watch?v=HXV3zeQKqGY");
        addQ(t, "Filtering with AND, OR, IN, BETWEEN, LIKE", "EASY",
            "ARTICLE", "https://dev.mysql.com/doc/refman/8.4/en/expressions.html",
            "VIDEO", "https://www.youtube.com/watch?v=us1XyayQ6fU");
        addQ(t, "Aggregate Functions & GROUP BY / HAVING", "MEDIUM",
            "ARTICLE", "https://dev.mysql.com/doc/refman/8.4/en/aggregate-functions.html",
            "VIDEO", "https://www.youtube.com/watch?v=us1XyayQ6fU");

        t = createTopic(s, "Joins & Subqueries");
        addQ(t, "INNER, LEFT, RIGHT, FULL JOIN", "MEDIUM",
            "ARTICLE", "https://dev.mysql.com/doc/refman/8.4/en/join.html",
            "VIDEO", "https://www.youtube.com/watch?v=HXV3zeQKqGY");
        addQ(t, "Subqueries & Correlated Subqueries", "MEDIUM",
            "ARTICLE", "https://dev.mysql.com/doc/refman/8.4/en/subqueries.html",
            "VIDEO", "https://www.youtube.com/watch?v=us1XyayQ6fU");
        addQ(t, "Common Table Expressions (CTEs)", "MEDIUM",
            "ARTICLE", "https://dev.mysql.com/doc/refman/8.4/en/with.html",
            "VIDEO", "https://www.youtube.com/watch?v=-fW2X7fh7Yg");
        addQ(t, "Window Functions (RANK, ROW_NUMBER, LAG/LEAD)", "MEDIUM",
            "ARTICLE", "https://www.postgresql.org/docs/current/tutorial-window.html",
            "VIDEO", "https://www.youtube.com/watch?v=-fW2X7fh7Yg");

        t = createTopic(s, "Database Design");
        addQ(t, "Keys, Constraints & Normalization", "MEDIUM",
            "ARTICLE", "https://dev.mysql.com/doc/refman/8.4/en/constraints.html",
            "VIDEO", "https://www.youtube.com/watch?v=HXV3zeQKqGY");
        addQ(t, "ER Diagrams & Schema Design", "MEDIUM",
            "ARTICLE", "https://dev.mysql.com/doc/workbench/en/wb-getting-started-tutorial-creating-a-model.html",
            "VIDEO", "https://www.youtube.com/watch?v=HXV3zeQKqGY");


        // ==========================================
        // Section 4: Data Wrangling & EDA
        // ==========================================
        s = createSection("Data Wrangling & EDA");

        t = createTopic(s, "Data Collection & Cleaning");
        addQ(t, "Working with CSV/JSON/APIs", "EASY",
            "ARTICLE", "https://pandas.pydata.org/docs/user_guide/io.html",
            "VIDEO", "https://www.youtube.com/watch?v=roTZJaxjnJc");
        addQ(t, "Handling Missing Data & Duplicates", "MEDIUM",
            "ARTICLE", "https://pandas.pydata.org/docs/user_guide/missing_data.html",
            "VIDEO", "https://www.youtube.com/watch?v=EaGbS7eWSs0");
        addQ(t, "Outlier Detection & Treatment", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/outlier_detection.html",
            "VIDEO", "https://www.youtube.com/watch?v=EaGbS7eWSs0");

        t = createTopic(s, "Exploratory Data Analysis");
        addQ(t, "Univariate & Bivariate Analysis", "MEDIUM",
            "ARTICLE", "https://pandas.pydata.org/docs/user_guide/visualization.html",
            "VIDEO", "https://www.youtube.com/watch?v=4prTOtjA1LM");
        addQ(t, "Correlation Analysis & Heatmaps", "MEDIUM",
            "ARTICLE", "https://seaborn.pydata.org/generated/seaborn.heatmap.html",
            "VIDEO", "https://www.youtube.com/watch?v=4prTOtjA1LM");
        addQ(t, "Feature Engineering & Feature Scaling", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/preprocessing.html",
            "VIDEO", "https://www.youtube.com/watch?v=6WDFfaYtN6s");
        addQ(t, "Feature Selection Techniques", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/feature_selection.html",
            "VIDEO", "https://www.youtube.com/watch?v=uMlU2JaiOd8");


        // ==========================================
        // Section 5: BI Tools & Dashboards
        // ==========================================
        s = createSection("BI Tools & Dashboards");

        t = createTopic(s, "Excel for Data Analysis");
        addQ(t, "Formulas, Pivot Tables & Charts", "EASY",
            "ARTICLE", "https://support.microsoft.com/en-us/excel",
            "VIDEO", "https://www.youtube.com/watch?v=PSNXoAs2FtQ");
        addQ(t, "Data Cleaning in Excel", "EASY",
            "ARTICLE", "https://support.microsoft.com/en-us/excel",
            "VIDEO", "https://www.youtube.com/watch?v=PSNXoAs2FtQ");

        t = createTopic(s, "Tableau");
        addQ(t, "Connecting Data & Building Visualizations", "MEDIUM",
            "ARTICLE", "https://www.tableau.com/learn",
            "VIDEO", "https://www.youtube.com/watch?v=PSNXoAs2FtQ");
        addQ(t, "Building Interactive Dashboards", "MEDIUM",
            "ARTICLE", "https://www.tableau.com/learn",
            "VIDEO", "https://www.youtube.com/watch?v=PSNXoAs2FtQ");

        t = createTopic(s, "Power BI");
        addQ(t, "Power Query & Data Modeling", "MEDIUM",
            "ARTICLE", "https://learn.microsoft.com/en-us/power-bi/fundamentals/power-bi-overview",
            "VIDEO", "https://www.youtube.com/watch?v=UYoMxpVI4Gw");
        addQ(t, "DAX Basics & Calculated Measures", "MEDIUM",
            "ARTICLE", "https://learn.microsoft.com/en-us/dax/dax-overview",
            "VIDEO", "https://www.youtube.com/watch?v=UYoMxpVI4Gw");
        addQ(t, "Building Dashboards & Reports", "MEDIUM",
            "ARTICLE", "https://learn.microsoft.com/en-us/power-bi/create-reports/",
            "VIDEO", "https://www.youtube.com/watch?v=UYoMxpVI4Gw");

        t = createTopic(s, "Full Data Analyst Bootcamp (SQL, Excel, Tableau, Power BI, Python)");
        addQ(t, "End-to-End Data Analyst Bootcamp", "MEDIUM",
            "ARTICLE", "https://www.tableau.com/learn",
            "VIDEO", "https://www.youtube.com/playlist?list=PLUaB-1hjhk8FE_XZ87vPPSfHqb6OcM0cF",
            "VIDEO", "https://www.youtube.com/watch?v=PSNXoAs2FtQ");


        // ==========================================
        // Section 6: Machine Learning
        // ==========================================
        s = createSection("Machine Learning");

        t = createTopic(s, "Supervised Learning");
        addQ(t, "Linear & Logistic Regression", "EASY",
            "ARTICLE", "https://scikit-learn.org/stable/modules/linear_model.html",
            "VIDEO", "https://www.youtube.com/watch?v=nk2CQITm_eo");
        addQ(t, "Decision Trees & Random Forests", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/tree.html",
            "VIDEO", "https://www.youtube.com/watch?v=_L39rN6gz7Y");
        addQ(t, "k-Nearest Neighbors & SVM", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/neighbors.html",
            "VIDEO", "https://www.youtube.com/watch?v=HVXime0nQeI");
        addQ(t, "Gradient Boosting (XGBoost, LightGBM)", "MEDIUM",
            "ARTICLE", "https://xgboost.readthedocs.io/en/stable/",
            "VIDEO", "https://www.youtube.com/watch?v=OtD8wVaFm6E");

        t = createTopic(s, "Unsupervised Learning");
        addQ(t, "K-Means & Hierarchical Clustering", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/clustering.html",
            "VIDEO", "https://www.youtube.com/watch?v=4b5d3muPQmA");
        addQ(t, "Dimensionality Reduction (PCA)", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/decomposition.html#pca",
            "VIDEO", "https://www.youtube.com/watch?v=FgakZw6K1QQ");

        t = createTopic(s, "Model Evaluation");
        addQ(t, "Train/Test Split & Cross-Validation", "EASY",
            "ARTICLE", "https://scikit-learn.org/stable/modules/cross_validation.html",
            "VIDEO", "https://www.youtube.com/watch?v=fSytzGwwBVw");
        addQ(t, "Precision, Recall, F1, ROC-AUC", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/model_evaluation.html",
            "VIDEO", "https://www.youtube.com/watch?v=Kdsp6soqA7o");
        addQ(t, "Hyperparameter Tuning", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/grid_search.html",
            "VIDEO", "https://www.youtube.com/watch?v=HdlDYng8g9s");

        t = createTopic(s, "Time Series Analysis");
        addQ(t, "Trend, Seasonality & Decomposition", "MEDIUM",
            "ARTICLE", "https://www.statsmodels.org/stable/tsa.html",
            "VIDEO", "https://www.youtube.com/watch?v=e8Yw4alG16Q");
        addQ(t, "ARIMA & Forecasting Models", "MEDIUM",
            "ARTICLE", "https://www.statsmodels.org/stable/generated/statsmodels.tsa.arima.model.ARIMA.html",
            "VIDEO", "https://www.youtube.com/watch?v=e8Yw4alG16Q");

        t = createTopic(s, "Complete ML Playlist");
        addQ(t, "100 Days of Machine Learning (End to End)", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/tutorial/basic/tutorial.html",
            "VIDEO", "https://www.youtube.com/playlist?list=PLKnIA16_Rmvbr7zKYQuBfsVkjoLcJgxHH",
            "VIDEO", "https://www.youtube.com/watch?v=JxgmHe2NyeY");


        // ==========================================
        // Section 7: Big Data & Data Engineering Basics
        // ==========================================
        s = createSection("Big Data & Data Engineering Basics");

        t = createTopic(s, "Big Data Fundamentals");
        addQ(t, "What is Big Data & the 5 V's", "EASY",
            "ARTICLE", "https://spark.apache.org/docs/latest/",
            "VIDEO", "https://www.youtube.com/watch?v=zFMgpxG-chM");
        addQ(t, "Hadoop Ecosystem Overview", "MEDIUM",
            "ARTICLE", "https://hadoop.apache.org/docs/stable/",
            "VIDEO", "https://www.youtube.com/watch?v=zFMgpxG-chM");

        t = createTopic(s, "PySpark");
        addQ(t, "Spark DataFrames & Transformations", "MEDIUM",
            "ARTICLE", "https://spark.apache.org/docs/latest/api/python/getting_started/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=WyZmM6K7ubc");
        addQ(t, "Spark SQL", "MEDIUM",
            "ARTICLE", "https://spark.apache.org/docs/latest/sql-programming-guide.html",
            "VIDEO", "https://www.youtube.com/watch?v=WyZmM6K7ubc");

        t = createTopic(s, "Version Control & Collaboration");
        addQ(t, "Git & GitHub for Data Science Projects", "EASY",
            "ARTICLE", "https://docs.github.com/en/get-started",
            "VIDEO", "https://www.youtube.com/watch?v=GW7B6vwktPA");


        // ==========================================
        // Section 8: Communication, Deployment & Career
        // ==========================================
        s = createSection("Communication, Deployment & Career");

        t = createTopic(s, "Data Storytelling");
        addQ(t, "Turning Analysis into a Narrative", "EASY",
            "ARTICLE", "https://www.tableau.com/learn/articles/data-storytelling",
            "VIDEO", "https://www.youtube.com/watch?v=8EExFwaSb64");
        addQ(t, "Building an Effective Dashboard", "MEDIUM",
            "ARTICLE", "https://www.tableau.com/learn",
            "VIDEO", "https://www.youtube.com/watch?v=8EExFwaSb64");

        t = createTopic(s, "Deploying Data Science Projects");
        addQ(t, "Serving Models with FastAPI/Flask", "MEDIUM",
            "ARTICLE", "https://fastapi.tiangolo.com/",
            "VIDEO", "https://www.youtube.com/watch?v=ueVb2dw-kWY");
        addQ(t, "Building Quick Apps with Streamlit", "MEDIUM",
            "ARTICLE", "https://docs.streamlit.io/",
            "VIDEO", "https://www.youtube.com/watch?v=D0D3NGO2fJQ");

        t = createTopic(s, "Portfolio & Career Prep");
        addQ(t, "Building a Data Science Portfolio", "EASY",
            "ARTICLE", "https://www.alextheanalyst.com/",
            "VIDEO", "https://www.youtube.com/watch?v=6bK6ep5C8jc");
        addQ(t, "Kaggle Competitions & Datasets", "MEDIUM",
            "ARTICLE", "https://www.kaggle.com/competitions",
            "VIDEO", "https://www.youtube.com/watch?v=6bK6ep5C8jc");
        addQ(t, "Cracking the Data Science Interview", "MEDIUM",
            "ARTICLE", "https://www.krishnaik.in/",
            "VIDEO", "https://www.youtube.com/watch?v=6bK6ep5C8jc");


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