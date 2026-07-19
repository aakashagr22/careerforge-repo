package com.careerforge.roadmap.seeder;

import java.util.ArrayList;
import java.util.List;

public class AiMlPrepSeeder {

    public static void seed(
        com.careerforge.roadmap.entity.Roadmap dbRoadmap,
        com.careerforge.roadmap.repository.RoadmapSectionRepository roadmapSectionRepository,
        com.careerforge.roadmap.repository.QuestionRepository questionRepository,
        com.careerforge.roadmap.repository.QuestionLinkRepository questionLinkRepository,
        com.careerforge.roadmap.repository.RoadmapSectionQuestionRepository roadmapSectionQuestionRepository
    ) {
        System.out.println("Seeding Roadmap: AI/ML Complete Preparation Sheet");
        Roadmap.sections.clear();

        RoadmapSection s;
        Topic t;

        // ==========================================
        // Section 1: Math Foundations
        // ==========================================
        s = createSection("Math Foundations");

        t = createTopic(s, "Linear Algebra");
        addQ(t, "Vectors, Matrices and Tensors", "EASY",
            "ARTICLE", "https://www.khanacademy.org/math/linear-algebra",
            "VIDEO", "https://www.youtube.com/playlist?list=PLZHQObOWTQDPD3MizzM2xVFitgF8hE_ab");
        addQ(t, "Matrix Multiplication & Transpose", "EASY",
            "ARTICLE", "https://www.khanacademy.org/math/linear-algebra/matrix-transformations",
            "VIDEO", "https://www.youtube.com/watch?v=XkY2DOUCWMU");
        addQ(t, "Eigenvalues and Eigenvectors", "MEDIUM",
            "ARTICLE", "https://www.khanacademy.org/math/linear-algebra/alternate-bases",
            "VIDEO", "https://www.youtube.com/watch?v=PFDu9oVAE-g");
        addQ(t, "Singular Value Decomposition (SVD)", "MEDIUM",
            "ARTICLE", "https://www.khanacademy.org/math/linear-algebra",
            "VIDEO", "https://www.youtube.com/watch?v=mBcLRGuAFUk");

        t = createTopic(s, "Calculus for ML");
        addQ(t, "Derivatives and Partial Derivatives", "EASY",
            "ARTICLE", "https://www.khanacademy.org/math/multivariable-calculus/multivariable-derivatives",
            "VIDEO", "https://www.youtube.com/watch?v=54_c9uZLtqM");
        addQ(t, "Chain Rule", "EASY",
            "ARTICLE", "https://www.khanacademy.org/math/multivariable-calculus/multivariable-derivatives/multivariable-chain-rule",
            "VIDEO", "https://www.youtube.com/watch?v=YG15m2VwSjA");
        addQ(t, "Gradients & Gradient Descent Intuition", "MEDIUM",
            "ARTICLE", "https://www.khanacademy.org/math/multivariable-calculus/multivariable-derivatives/gradient-and-directional-derivatives",
            "VIDEO", "https://www.youtube.com/watch?v=IHZwWFHWa-w");

        t = createTopic(s, "Probability & Statistics");
        addQ(t, "Random Variables & Distributions", "EASY",
            "ARTICLE", "https://www.khanacademy.org/math/statistics-probability",
            "VIDEO", "https://www.youtube.com/watch?v=Gv9_4yMHFhI");
        addQ(t, "Mean, Variance, Covariance", "EASY",
            "ARTICLE", "https://www.khanacademy.org/math/statistics-probability/summarizing-quantitative-data",
            "VIDEO", "https://www.youtube.com/watch?v=SzZ6GpcfoQY");
        addQ(t, "Bayes' Theorem", "MEDIUM",
            "ARTICLE", "https://www.khanacademy.org/math/statistics-probability/probability-library/conditional-probability-independence",
            "VIDEO", "https://www.youtube.com/watch?v=HZGCoVF3YvM");
        addQ(t, "Hypothesis Testing & p-values", "MEDIUM",
            "ARTICLE", "https://www.khanacademy.org/math/statistics-probability/significance-tests-one-sample",
            "VIDEO", "https://www.youtube.com/watch?v=vemZtEM63GY");
        addQ(t, "Maximum Likelihood Estimation", "MEDIUM",
            "ARTICLE", "https://www.statlect.com/fundamentals-of-statistics/maximum-likelihood",
            "VIDEO", "https://www.youtube.com/watch?v=XepXtl9YKwc");

        t = createTopic(s, "Optimization Basics");
        addQ(t, "Convex vs Non-Convex Functions", "MEDIUM",
            "ARTICLE", "https://web.stanford.edu/~boyd/cvxbook/",
            "VIDEO", "https://www.youtube.com/watch?v=IHZwWFHWa-w");
        addQ(t, "Gradient Descent Variants (Batch, SGD, Mini-batch)", "MEDIUM",
            "ARTICLE", "https://pytorch.org/docs/stable/optim.html",
            "VIDEO", "https://www.youtube.com/watch?v=IHZwWFHWa-w");
        addQ(t, "Momentum, RMSProp, Adam", "MEDIUM",
            "ARTICLE", "https://pytorch.org/docs/stable/optim.html#algorithms",
            "VIDEO", "https://www.youtube.com/watch?v=JXQT_vxqwIs");


        // ==========================================
        // Section 2: Python & Data Tooling
        // ==========================================
        s = createSection("Python & Data Tooling");

        t = createTopic(s, "Python Essentials");
        addQ(t, "Data Types, Control Flow, Functions", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/",
            "VIDEO", "https://www.youtube.com/watch?v=rfscVS0vtbw");
        addQ(t, "OOP in Python", "EASY",
            "ARTICLE", "https://docs.python.org/3/tutorial/classes.html",
            "VIDEO", "https://www.youtube.com/playlist?list=PLKnIA16_Rmvb1RYR-iTA_hzckhdONtSW4");
        addQ(t, "Virtual Environments & Package Management", "EASY",
            "ARTICLE", "https://docs.python.org/3/library/venv.html",
            "VIDEO", "https://www.youtube.com/watch?v=Y21OR1OPC9A");

        t = createTopic(s, "NumPy");
        addQ(t, "ndarray Basics & Broadcasting", "EASY",
            "ARTICLE", "https://numpy.org/doc/stable/user/quickstart.html",
            "VIDEO", "https://www.youtube.com/watch?v=QUT1VHiLmmI");
        addQ(t, "Vectorized Operations", "EASY",
            "ARTICLE", "https://numpy.org/doc/stable/user/basics.broadcasting.html",
            "VIDEO", "https://www.youtube.com/watch?v=QUT1VHiLmmI");
        addQ(t, "Linear Algebra with numpy.linalg", "MEDIUM",
            "ARTICLE", "https://numpy.org/doc/stable/reference/routines.linalg.html",
            "VIDEO", "https://www.youtube.com/watch?v=QUT1VHiLmmI");

        t = createTopic(s, "Pandas");
        addQ(t, "Series and DataFrame Basics", "EASY",
            "ARTICLE", "https://pandas.pydata.org/docs/user_guide/10min.html",
            "VIDEO", "https://www.youtube.com/watch?v=vmEHCJofslg");
        addQ(t, "Data Cleaning & Missing Values", "EASY",
            "ARTICLE", "https://pandas.pydata.org/docs/user_guide/missing_data.html",
            "VIDEO", "https://www.youtube.com/watch?v=vmEHCJofslg");
        addQ(t, "GroupBy, Merge, Pivot Tables", "MEDIUM",
            "ARTICLE", "https://pandas.pydata.org/docs/user_guide/groupby.html",
            "VIDEO", "https://www.youtube.com/watch?v=vmEHCJofslg");

        t = createTopic(s, "Data Visualization & EDA");
        addQ(t, "Matplotlib Basics", "EASY",
            "ARTICLE", "https://matplotlib.org/stable/tutorials/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=3Xc3CA655Y4");
        addQ(t, "Seaborn for Statistical Plots", "EASY",
            "ARTICLE", "https://seaborn.pydata.org/tutorial.html",
            "VIDEO", "https://www.youtube.com/watch?v=6GUZXDef2U0");
        addQ(t, "Univariate & Bivariate EDA", "MEDIUM",
            "ARTICLE", "https://pandas.pydata.org/docs/user_guide/visualization.html",
            "VIDEO", "https://www.youtube.com/watch?v=4prTOtjA1LM");


        // ==========================================
        // Section 3: Machine Learning Fundamentals
        // ==========================================
        s = createSection("Machine Learning Fundamentals");

        t = createTopic(s, "Introduction to ML");
        addQ(t, "What is Machine Learning..?", "EASY",
            "ARTICLE", "https://scikit-learn.org/stable/tutorial/basic/tutorial.html",
            "VIDEO", "https://www.youtube.com/watch?v=ZftI2fEz0Fw");
        addQ(t, "AI vs ML vs DL", "EASY",
            "ARTICLE", "https://scikit-learn.org/stable/tutorial/basic/tutorial.html",
            "VIDEO", "https://www.youtube.com/watch?v=1v3_AQ26jZ0");
        addQ(t, "Types of Machine Learning (Batch, Online, Instance vs Model based)", "EASY",
            "ARTICLE", "https://scikit-learn.org/stable/tutorial/basic/tutorial.html",
            "VIDEO", "https://www.youtube.com/watch?v=81ymPYEtFOw");
        addQ(t, "Machine Learning Development Lifecycle (MLDLC)", "EASY",
            "ARTICLE", "https://ml-ops.org/content/end-to-end-ml-workflow",
            "VIDEO", "https://www.youtube.com/watch?v=9DzXOdChM5w");
        addQ(t, "Bias-Variance Tradeoff", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/learning_curve.html",
            "VIDEO", "https://www.youtube.com/watch?v=EuBBz3bI-aA");
        addQ(t, "Train/Validation/Test Splits & Cross Validation", "EASY",
            "ARTICLE", "https://scikit-learn.org/stable/modules/cross_validation.html",
            "VIDEO", "https://www.youtube.com/watch?v=fSytzGwwBVw");

        t = createTopic(s, "Data Collection & Feature Engineering");
        addQ(t, "Working with CSV, JSON, SQL data sources", "EASY",
            "ARTICLE", "https://pandas.pydata.org/docs/user_guide/io.html",
            "VIDEO", "https://www.youtube.com/watch?v=a_XrmKlaGTs");
        addQ(t, "Fetching Data via APIs & Web Scraping", "EASY",
            "ARTICLE", "https://requests.readthedocs.io/en/latest/",
            "VIDEO", "https://www.youtube.com/watch?v=roTZJaxjnJc");
        addQ(t, "Feature Scaling - Standardization & Normalization", "EASY",
            "ARTICLE", "https://scikit-learn.org/stable/modules/preprocessing.html",
            "VIDEO", "https://www.youtube.com/watch?v=D0D3NGO2fJQ");
        addQ(t, "Encoding Categorical Data", "EASY",
            "ARTICLE", "https://scikit-learn.org/stable/modules/preprocessing.html#encoding-categorical-features",
            "VIDEO", "https://www.youtube.com/watch?v=w2GglmYHfmM");
        addQ(t, "Handling Missing Data & Outliers", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/impute.html",
            "VIDEO", "https://www.youtube.com/watch?v=EaGbS7eWSs0");
        addQ(t, "Feature Selection & Feature Construction", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/feature_selection.html",
            "VIDEO", "https://www.youtube.com/watch?v=hcw1Ath1SGw");
        addQ(t, "Pipelines in scikit-learn", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/compose.html",
            "VIDEO", "https://www.youtube.com/watch?v=xOccYkgRV4Q");

        t = createTopic(s, "Regression Algorithms");
        addQ(t, "Simple & Multiple Linear Regression", "EASY",
            "ARTICLE", "https://scikit-learn.org/stable/modules/linear_model.html#ordinary-least-squares",
            "VIDEO", "https://www.youtube.com/watch?v=nk2CQITm_eo");
        addQ(t, "Gradient Descent for Linear Regression", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/sgd.html",
            "VIDEO", "https://www.youtube.com/watch?v=ORyfPJypKuU");
        addQ(t, "Polynomial Regression", "EASY",
            "ARTICLE", "https://scikit-learn.org/stable/modules/linear_model.html#polynomial-regression",
            "VIDEO", "https://www.youtube.com/watch?v=BNWLf3cKdbQ");
        addQ(t, "Ridge, Lasso, ElasticNet Regularization", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/linear_model.html#ridge-regression-and-classification",
            "VIDEO", "https://www.youtube.com/watch?v=Q81RR3yKn30");

        t = createTopic(s, "Classification Algorithms");
        addQ(t, "Logistic Regression", "EASY",
            "ARTICLE", "https://scikit-learn.org/stable/modules/linear_model.html#logistic-regression",
            "VIDEO", "https://www.youtube.com/watch?v=yIYKR4sgzI8");
        addQ(t, "k-Nearest Neighbors (kNN)", "EASY",
            "ARTICLE", "https://scikit-learn.org/stable/modules/neighbors.html",
            "VIDEO", "https://www.youtube.com/watch?v=HVXime0nQeI");
        addQ(t, "Decision Trees", "EASY",
            "ARTICLE", "https://scikit-learn.org/stable/modules/tree.html",
            "VIDEO", "https://www.youtube.com/watch?v=_L39rN6gz7Y");
        addQ(t, "Support Vector Machines (SVM)", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/svm.html",
            "VIDEO", "https://www.youtube.com/watch?v=efR1C6CvhmE");
        addQ(t, "Naive Bayes Classifiers", "EASY",
            "ARTICLE", "https://scikit-learn.org/stable/modules/naive_bayes.html",
            "VIDEO", "https://www.youtube.com/watch?v=O2L2Uv9pdDA");

        t = createTopic(s, "Ensemble Methods");
        addQ(t, "Bagging & Random Forests", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/ensemble.html#random-forests",
            "VIDEO", "https://www.youtube.com/watch?v=J4Wdy0Wc_xQ");
        addQ(t, "AdaBoost & Gradient Boosting", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/ensemble.html#gradient-boosting",
            "VIDEO", "https://www.youtube.com/watch?v=3CC4N4z3GJc");
        addQ(t, "XGBoost, LightGBM, CatBoost", "MEDIUM",
            "ARTICLE", "https://xgboost.readthedocs.io/en/stable/",
            "VIDEO", "https://www.youtube.com/watch?v=OtD8wVaFm6E");
        addQ(t, "Stacking Ensembles", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/ensemble.html#stacked-generalization",
            "VIDEO", "https://www.youtube.com/watch?v=J4Wdy0Wc_xQ");

        t = createTopic(s, "Unsupervised Learning");
        addQ(t, "K-Means Clustering", "EASY",
            "ARTICLE", "https://scikit-learn.org/stable/modules/clustering.html#k-means",
            "VIDEO", "https://www.youtube.com/watch?v=4b5d3muPQmA");
        addQ(t, "Hierarchical Clustering", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/clustering.html#hierarchical-clustering",
            "VIDEO", "https://www.youtube.com/watch?v=7xHsRkOdVwo");
        addQ(t, "DBSCAN", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/clustering.html#dbscan",
            "VIDEO", "https://www.youtube.com/watch?v=RDZUdRSDOok");
        addQ(t, "Principal Component Analysis (PCA)", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/decomposition.html#pca",
            "VIDEO", "https://www.youtube.com/watch?v=FgakZw6K1QQ");
        addQ(t, "t-SNE and UMAP", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/manifold.html#t-sne",
            "VIDEO", "https://www.youtube.com/watch?v=NEaUSP4YerM");

        t = createTopic(s, "Model Evaluation & Tuning");
        addQ(t, "Confusion Matrix, Precision, Recall, F1", "EASY",
            "ARTICLE", "https://scikit-learn.org/stable/modules/model_evaluation.html",
            "VIDEO", "https://www.youtube.com/watch?v=Kdsp6soqA7o");
        addQ(t, "ROC Curve and AUC", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/model_evaluation.html#roc-metrics",
            "VIDEO", "https://www.youtube.com/watch?v=4jRBRDbJemM");
        addQ(t, "Hyperparameter Tuning (GridSearchCV, RandomizedSearchCV)", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/modules/grid_search.html",
            "VIDEO", "https://www.youtube.com/watch?v=HdlDYng8g9s");
        addQ(t, "Complete Machine Learning Playlist (End to End)", "MEDIUM",
            "ARTICLE", "https://scikit-learn.org/stable/tutorial/basic/tutorial.html",
            "VIDEO", "https://www.youtube.com/playlist?list=PLKnIA16_Rmvbr7zKYQuBfsVkjoLcJgxHH",
            "VIDEO", "https://www.youtube.com/watch?v=JxgmHe2NyeY");


        // ==========================================
        // Section 4: Deep Learning Fundamentals
        // ==========================================
        s = createSection("Deep Learning Fundamentals");

        t = createTopic(s, "Introduction to Neural Networks");
        addQ(t, "What is a Neural Network..?", "EASY",
            "ARTICLE", "https://pytorch.org/tutorials/beginner/basics/intro.html",
            "VIDEO", "https://www.youtube.com/watch?v=aircAruvnKk");
        addQ(t, "Perceptron & Multi-Layer Perceptrons", "EASY",
            "ARTICLE", "https://pytorch.org/tutorials/beginner/basics/buildmodel_tutorial.html",
            "VIDEO", "https://www.youtube.com/watch?v=d2kxUVwWWwU");
        addQ(t, "Activation Functions (ReLU, Sigmoid, Tanh, Softmax)", "EASY",
            "ARTICLE", "https://pytorch.org/docs/stable/nn.html#non-linear-activations-weighted-sum-nonlinearity",
            "VIDEO", "https://www.youtube.com/watch?v=68BZ5f7P94E");
        addQ(t, "Loss Functions", "EASY",
            "ARTICLE", "https://pytorch.org/docs/stable/nn.html#loss-functions",
            "VIDEO", "https://www.youtube.com/watch?v=QBbC3Cjsnjg");

        t = createTopic(s, "Backpropagation & Training");
        addQ(t, "Backpropagation - The Math", "MEDIUM",
            "ARTICLE", "https://pytorch.org/tutorials/beginner/blitz/autograd_tutorial.html",
            "VIDEO", "https://www.youtube.com/watch?v=IHZwWFHWa-w");
        addQ(t, "Building Backprop from Scratch (micrograd)", "MEDIUM",
            "ARTICLE", "https://github.com/karpathy/micrograd",
            "VIDEO", "https://www.youtube.com/watch?v=VMj-3S1tku0");
        addQ(t, "Gradient Descent Variants in Neural Nets", "MEDIUM",
            "ARTICLE", "https://pytorch.org/docs/stable/optim.html",
            "VIDEO", "https://www.youtube.com/watch?v=IHZwWFHWa-w");
        addQ(t, "Vanishing & Exploding Gradients", "MEDIUM",
            "ARTICLE", "https://pytorch.org/docs/stable/nn.init.html",
            "VIDEO", "https://www.youtube.com/watch?v=qO_NLVjD6zE");
        addQ(t, "Weight Initialization & Batch Normalization", "MEDIUM",
            "ARTICLE", "https://pytorch.org/docs/stable/generated/torch.nn.BatchNorm1d.html",
            "VIDEO", "https://www.youtube.com/watch?v=DtEq44FTPM4");
        addQ(t, "Regularization - Dropout & Early Stopping", "MEDIUM",
            "ARTICLE", "https://pytorch.org/docs/stable/generated/torch.nn.Dropout.html",
            "VIDEO", "https://www.youtube.com/watch?v=D8PJAL-MZv8");

        t = createTopic(s, "Deep Learning Frameworks");
        addQ(t, "PyTorch Tensors & Autograd", "EASY",
            "ARTICLE", "https://pytorch.org/tutorials/beginner/blitz/tensor_tutorial.html",
            "VIDEO", "https://www.youtube.com/watch?v=V_xro1bcAuA");
        addQ(t, "Building Models with torch.nn", "EASY",
            "ARTICLE", "https://pytorch.org/tutorials/beginner/basics/buildmodel_tutorial.html",
            "VIDEO", "https://www.youtube.com/watch?v=c36lUUr864M");
        addQ(t, "TensorFlow / Keras Basics", "EASY",
            "ARTICLE", "https://www.tensorflow.org/guide/keras",
            "VIDEO", "https://www.youtube.com/watch?v=tPYj3fFJGjk");
        addQ(t, "Complete Deep Learning Playlist (100 Days of DL)", "MEDIUM",
            "ARTICLE", "https://pytorch.org/tutorials/",
            "VIDEO", "https://www.youtube.com/playlist?list=PLKnIA16_RmvYuZauWaPlRTC54KxSNLtNn",
            "VIDEO", "https://www.youtube.com/watch?v=d2kxUVwWWwU");

        t = createTopic(s, "Convolutional Neural Networks");
        addQ(t, "Convolution & Pooling Operations", "MEDIUM",
            "ARTICLE", "https://pytorch.org/tutorials/beginner/blitz/cifar10_tutorial.html",
            "VIDEO", "https://www.youtube.com/watch?v=KuXjwB4LzSA");
        addQ(t, "CNN Architectures (LeNet, VGG, ResNet)", "MEDIUM",
            "ARTICLE", "https://pytorch.org/vision/stable/models.html",
            "VIDEO", "https://www.youtube.com/watch?v=DAOcjicFr1Y");
        addQ(t, "Transfer Learning with CNNs", "MEDIUM",
            "ARTICLE", "https://pytorch.org/tutorials/beginner/transfer_learning_tutorial.html",
            "VIDEO", "https://www.youtube.com/watch?v=K0lWSB2QoIQ");

        t = createTopic(s, "Sequence Models");
        addQ(t, "Recurrent Neural Networks (RNN)", "MEDIUM",
            "ARTICLE", "https://pytorch.org/docs/stable/generated/torch.nn.RNN.html",
            "VIDEO", "https://www.youtube.com/watch?v=6niqTuYFZLQ");
        addQ(t, "LSTM & GRU", "MEDIUM",
            "ARTICLE", "https://pytorch.org/docs/stable/generated/torch.nn.LSTM.html",
            "VIDEO", "https://www.youtube.com/watch?v=8HyCNIVRbSU");
        addQ(t, "Sequence-to-Sequence Models & Attention", "MEDIUM",
            "ARTICLE", "https://pytorch.org/tutorials/intermediate/seq2seq_translation_tutorial.html",
            "VIDEO", "https://www.youtube.com/watch?v=SysgYptB198");


        // ==========================================
        // Section 5: Natural Language Processing
        // ==========================================
        s = createSection("Natural Language Processing");

        t = createTopic(s, "Text Preprocessing");
        addQ(t, "Tokenization, Stemming, Lemmatization", "EASY",
            "ARTICLE", "https://www.nltk.org/book/ch03.html",
            "VIDEO", "https://www.youtube.com/watch?v=w3coRFpyddQ");
        addQ(t, "Stop Words, POS Tagging, NER", "EASY",
            "ARTICLE", "https://spacy.io/usage/linguistic-features",
            "VIDEO", "https://www.youtube.com/watch?v=w3coRFpyddQ");
        addQ(t, "Bag of Words & TF-IDF", "EASY",
            "ARTICLE", "https://scikit-learn.org/stable/modules/feature_extraction.html#text-feature-extraction",
            "VIDEO", "https://www.youtube.com/watch?v=w3coRFpyddQ");

        t = createTopic(s, "Word Embeddings");
        addQ(t, "Word2Vec (CBOW & Skip-gram)", "MEDIUM",
            "ARTICLE", "https://radimrehurek.com/gensim/models/word2vec.html",
            "VIDEO", "https://www.youtube.com/watch?v=viZrOnJclY0");
        addQ(t, "GloVe Embeddings", "MEDIUM",
            "ARTICLE", "https://nlp.stanford.edu/projects/glove/",
            "VIDEO", "https://www.youtube.com/watch?v=viZrOnJclY0");
        addQ(t, "Contextual Embeddings (ELMo, BERT)", "MEDIUM",
            "ARTICLE", "https://huggingface.co/docs/transformers/model_doc/bert",
            "VIDEO", "https://www.youtube.com/watch?v=xI0HHN5XKDo");

        t = createTopic(s, "Transformers");
        addQ(t, "Attention Is All You Need - Core Idea", "MEDIUM",
            "ARTICLE", "https://arxiv.org/abs/1706.03762",
            "VIDEO", "https://www.youtube.com/watch?v=zxQyTK8quyY");
        addQ(t, "Self-Attention & Multi-Head Attention", "MEDIUM",
            "ARTICLE", "https://huggingface.co/learn/nlp-course/chapter1/4",
            "VIDEO", "https://www.youtube.com/watch?v=zxQyTK8quyY");
        addQ(t, "Positional Encoding", "MEDIUM",
            "ARTICLE", "https://huggingface.co/learn/nlp-course/chapter1/4",
            "VIDEO", "https://www.youtube.com/watch?v=zxQyTK8quyY");
        addQ(t, "Encoder-Decoder Transformer Architecture", "MEDIUM",
            "ARTICLE", "https://huggingface.co/learn/nlp-course/chapter1/4",
            "VIDEO", "https://www.youtube.com/watch?v=4Bdc55j80l8");

        t = createTopic(s, "Hugging Face Ecosystem");
        addQ(t, "Transformers Library & Pipelines", "EASY",
            "ARTICLE", "https://huggingface.co/docs/transformers/quicktour",
            "VIDEO", "https://www.youtube.com/watch?v=YFNKnUhm_-s");
        addQ(t, "Fine-tuning Pretrained Models", "MEDIUM",
            "ARTICLE", "https://huggingface.co/docs/transformers/training",
            "VIDEO", "https://www.youtube.com/watch?v=YFNKnUhm_-s");
        addQ(t, "Datasets & Tokenizers Libraries", "EASY",
            "ARTICLE", "https://huggingface.co/docs/datasets/index",
            "VIDEO", "https://www.youtube.com/watch?v=YFNKnUhm_-s");


        // ==========================================
        // Section 6: Generative AI & LLMs
        // ==========================================
        s = createSection("Generative AI & LLMs");

        t = createTopic(s, "Large Language Models");
        addQ(t, "How GPT-style LLMs Work", "MEDIUM",
            "ARTICLE", "https://platform.openai.com/docs/models",
            "VIDEO", "https://www.youtube.com/watch?v=kCc8FmEb1nY");
        addQ(t, "Building a GPT from Scratch", "MEDIUM",
            "ARTICLE", "https://github.com/karpathy/nanoGPT",
            "VIDEO", "https://www.youtube.com/watch?v=kCc8FmEb1nY");
        addQ(t, "Tokenization in LLMs (BPE)", "MEDIUM",
            "ARTICLE", "https://huggingface.co/docs/transformers/tokenizer_summary",
            "VIDEO", "https://www.youtube.com/watch?v=zduSFxRajkE");
        addQ(t, "Prompt Engineering Basics", "EASY",
            "ARTICLE", "https://platform.openai.com/docs/guides/prompt-engineering",
            "VIDEO", "https://www.youtube.com/watch?v=YFNKnUhm_-s");
        addQ(t, "Fine-tuning vs RAG vs Prompting", "MEDIUM",
            "ARTICLE", "https://platform.openai.com/docs/guides/fine-tuning",
            "VIDEO", "https://www.youtube.com/watch?v=YFNKnUhm_-s");

        t = createTopic(s, "Retrieval Augmented Generation (RAG)");
        addQ(t, "Vector Embeddings & Similarity Search", "MEDIUM",
            "ARTICLE", "https://python.langchain.com/docs/concepts/embedding_models/",
            "VIDEO", "https://www.youtube.com/playlist?list=PLKnIA16_RmvaTbihpo4MtzVm4XOQa0ER0");
        addQ(t, "Vector Databases (FAISS, Pinecone, Chroma)", "MEDIUM",
            "ARTICLE", "https://python.langchain.com/docs/integrations/vectorstores/",
            "VIDEO", "https://www.youtube.com/playlist?list=PLKnIA16_RmvaTbihpo4MtzVm4XOQa0ER0");
        addQ(t, "Building a RAG Pipeline with LangChain", "MEDIUM",
            "ARTICLE", "https://python.langchain.com/docs/tutorials/rag/",
            "VIDEO", "https://www.youtube.com/playlist?list=PLKnIA16_RmvaTbihpo4MtzVm4XOQa0ER0");
        addQ(t, "Chunking Strategies for Documents", "MEDIUM",
            "ARTICLE", "https://python.langchain.com/docs/concepts/text_splitters/",
            "VIDEO", "https://www.youtube.com/playlist?list=PLKnIA16_RmvaTbihpo4MtzVm4XOQa0ER0");

        t = createTopic(s, "Agentic AI");
        addQ(t, "What are AI Agents..?", "MEDIUM",
            "ARTICLE", "https://langchain-ai.github.io/langgraph/concepts/agentic_concepts/",
            "VIDEO", "https://www.youtube.com/playlist?list=PLKnIA16_RmvYsvB8qkUQuJmJNuiCUJFPL");
        addQ(t, "Building Agents with LangGraph", "MEDIUM",
            "ARTICLE", "https://langchain-ai.github.io/langgraph/",
            "VIDEO", "https://www.youtube.com/playlist?list=PLKnIA16_RmvYsvB8qkUQuJmJNuiCUJFPL");
        addQ(t, "Tool Calling & Function Calling", "MEDIUM",
            "ARTICLE", "https://platform.openai.com/docs/guides/function-calling",
            "VIDEO", "https://www.youtube.com/playlist?list=PLKnIA16_RmvYsvB8qkUQuJmJNuiCUJFPL");
        addQ(t, "Model Context Protocol (MCP)", "MEDIUM",
            "ARTICLE", "https://modelcontextprotocol.io/introduction",
            "VIDEO", "https://www.youtube.com/playlist?list=PLKnIA16_Rmva_oZ9F4ayUu9qcWgF7Fyc0");

        t = createTopic(s, "Diffusion & Image Generation");
        addQ(t, "How Diffusion Models Work", "MEDIUM",
            "ARTICLE", "https://huggingface.co/docs/diffusers/conceptual/philosophy",
            "VIDEO", "https://www.youtube.com/watch?v=1CIpzeNxIhU");
        addQ(t, "Stable Diffusion Architecture", "MEDIUM",
            "ARTICLE", "https://huggingface.co/docs/diffusers/using-diffusers/stable_diffusion",
            "VIDEO", "https://www.youtube.com/watch?v=1CIpzeNxIhU");


        // ==========================================
        // Section 7: MLOps & Deployment
        // ==========================================
        s = createSection("MLOps & Deployment");

        t = createTopic(s, "Model Serving");
        addQ(t, "Serving Models with FastAPI", "EASY",
            "ARTICLE", "https://fastapi.tiangolo.com/",
            "VIDEO", "https://www.youtube.com/playlist?list=PLKnIA16_RmvZ41tjbKB2ZnwchfniNsMuQ");
        addQ(t, "Model Serialization (Pickle, ONNX)", "EASY",
            "ARTICLE", "https://scikit-learn.org/stable/model_persistence.html",
            "VIDEO", "https://www.youtube.com/watch?v=halvfODJcpQ");
        addQ(t, "Containerizing ML Apps with Docker", "MEDIUM",
            "ARTICLE", "https://docs.docker.com/get-started/",
            "VIDEO", "https://www.youtube.com/watch?v=0qG_0CPQhpg");

        t = createTopic(s, "Experiment Tracking & Versioning");
        addQ(t, "Experiment Tracking with MLflow", "MEDIUM",
            "ARTICLE", "https://mlflow.org/docs/latest/index.html",
            "VIDEO", "https://www.youtube.com/watch?v=x3cKvfrgnh0");
        addQ(t, "Data & Model Versioning with DVC", "MEDIUM",
            "ARTICLE", "https://dvc.org/doc",
            "VIDEO", "https://www.youtube.com/watch?v=kLKBcPonMYw");

        t = createTopic(s, "Monitoring & CI/CD for ML");
        addQ(t, "Model Drift & Data Drift Monitoring", "MEDIUM",
            "ARTICLE", "https://evidentlyai.com/ml-in-production/data-drift",
            "VIDEO", "https://www.youtube.com/watch?v=xd9jS16zXFA");
        addQ(t, "CI/CD Pipelines for ML Projects", "MEDIUM",
            "ARTICLE", "https://ml-ops.org/content/mlops-principles",
            "VIDEO", "https://www.youtube.com/watch?v=9BgIDqAzfuA");
        addQ(t, "Deploying on Cloud (AWS SageMaker, GCP Vertex AI)", "MEDIUM",
            "ARTICLE", "https://docs.aws.amazon.com/sagemaker/latest/dg/whatis.html",
            "VIDEO", "https://www.youtube.com/watch?v=LkR3GNDB0HI");


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