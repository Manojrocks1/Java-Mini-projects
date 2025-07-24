                                                             QuizApp 🧠
This is a simple console-based Java Quiz Application that tests a user's knowledge 
 on various topics.
->It presents multiple-choice questions, takes user input, provides immediate feedback,
 and displays a final score with a performance-based remark.

Features ✨
Multiple-Choice Questions: Presents a series of questions with four options each.

Input Validation: Ensures the user enters valid options (A, B, C, or D).

Instant Feedback: Tells the user immediately if their answer is correct or incorrect.

Score Tracking: Keeps a running tally of correct answers.

Final Results: Displays the total score and percentage at the end.

Performance Feedback: Provides a remark (e.g., "Excellent!", "Good.", "Needs Improvement.") based on the user's percentage score.

User-Friendly Interface: Simple and clear console output with engaging emojis.

How to Run 🚀
Prerequisites
Java Development Kit (JDK) installed on your system. You can download it from the Oracle website.

Steps
Save the Code:
Save the provided QuizApp.java code into a file named QuizApp.java on your computer.

Open Terminal/Command Prompt:
Navigate to the directory where you saved QuizApp.java using your terminal or command prompt.

Bash

cd path/to/your/QuizApp/directory
Compile the Java Code:
Compile the Java source file using the javac command.

Bash

javac QuizApp.java
Run the Application:
Execute the compiled Java class file using the java command.

Bash

java QuizApp
Play the Quiz:
Follow the prompts in the console to answer the questions.

Code Structure 🛠️
QuizApp.java: The main Java source file containing all the logic for the quiz application.

QUESTIONS: A static final array of strings holding the quiz questions.

OPTIONS: A static final 2D array of strings holding the answer options for each question.

ANSWERS: A static final array of characters holding the correct answer key for each question (e.g., 'A', 'B').

main(String[] args): The entry point of the application, which calls runQuiz().

runQuiz(Scanner scanner): Orchestrates the main quiz flow, iterating through questions, getting answers, and displaying results.

presentQuestion(int questionIndex): Displays a specific question and its options.

getUserAnswer(Scanner scanner): Handles user input, including validation for correct options.

checkAnswer(char userAnswer, int questionIndex): Compares the user's answer with the correct answer.

displayResults(int score, int totalQuestions): Calculates and displays the final score, percentage, and feedback.

Customization ⚙️
You can easily customize the quiz by modifying the QUESTIONS, OPTIONS, and ANSWERS arrays in the QuizApp.java file.

Example:

Java

// Add a new question
static final String[] QUESTIONS = {
    // ... existing questions
    "6. What is the capital of Japan?"
};

// Add options for the new question
static final String[][] OPTIONS = {
    // ... existing options
    {"A. Beijing", "B. Seoul", "C. Tokyo", "D. Bangkok"}
};

// Add the correct answer for the new question
static final char[] ANSWERS = {
    // ... existing answers
    'C'
};. 
