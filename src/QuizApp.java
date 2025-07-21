import java.util.InputMismatchException;
import java.util.Scanner;

public class QuizApp {

    // Define questions, options, and answers as constants for better readability and immutability
    private static final String[] QUESTIONS = {
            "1. What is the capital of France? 🤔",
            "2. Which language is used for Android app development? 📱",
            "3. Who is the father of Java programming language? 👨‍💻",
            "4. Which data structure uses FIFO (First In First Out)? 📚",
            "5. What does JVM stand for? 💻"
    };

    private static final String[][] OPTIONS = {
            {"A. Berlin", "B. Paris", "C. Rome", "D. Madrid"},
            {"A. Kotlin", "B. Python", "C. Swift", "D. JavaScript"},
            {"A. James Gosling", "B. Dennis Ritchie", "C. Guido van Rossum", "D. Bjarne Stroustrup"},
            {"A. Stack", "B. Queue", "C. Tree", "D. Graph"},
            {"A. Java Variable Machine", "B. Java Visual Machine", "C. Java Virtual Machine", "D. Just Virtual Memory"}
    };

    private static final char[] ANSWERS = {'B', 'A', 'A', 'B', 'C'};

    public static void main(String[] args) {
        // Use try-with-resources for automatic Scanner closing
        try (Scanner scanner = new Scanner(System.in)) {
            runQuiz(scanner);
        }
    }

    /**
     * Orchestrates the quiz flow, including presenting questions, getting answers, and displaying results.
     * @param scanner The Scanner object for user input.
     */
    private static void runQuiz(Scanner scanner) {
        int score = 0;
        int totalQuestions = QUESTIONS.length;

        System.out.println("🌟 Welcome to the Java Quiz! 🌟\n");
        System.out.println("Answer the following " + totalQuestions + " questions.\n");

        for (int i = 0; i < totalQuestions; i++) {
            presentQuestion(i);
            char userAnswer = getUserAnswer(scanner);

            if (checkAnswer(userAnswer, i)) {
                System.out.println("🎉 Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong! The correct answer is " + ANSWERS[i] + ".\n");
            }
        }

        displayResults(score, totalQuestions);
    }

    /**
     * Presents a single question and its options to the user.
     * @param questionIndex The index of the question to present.
     */
    private static void presentQuestion(int questionIndex) {
        System.out.println(QUESTIONS[questionIndex]);
        for (String option : OPTIONS[questionIndex]) {
            System.out.println(option);
        }
        System.out.print("Your answer (A/B/C/D): ");
    }

    /**
     * Gets and validates the user's answer. Handles invalid input.
     * @param scanner The Scanner object for user input.
     * @return The validated user's answer character.
     */
    private static char getUserAnswer(Scanner scanner) {
        char userAnswer;
        while (true) {
            try {
                String input = scanner.next().trim().toUpperCase();
                if (input.length() == 1 && (input.charAt(0) >= 'A' && input.charAt(0) <= 'D')) {
                    userAnswer = input.charAt(0);
                    break; // Valid input, exit loop
                } else {
                    System.out.println("Invalid input. Please enter A, B, C, or D. 🧐");
                    System.out.print("Your answer (A/B/C/D): ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a single character (A, B, C, or D). 🧐");
                scanner.next(); // Consume the invalid input
                System.out.print("Your answer (A/B/C/D): ");
            }
        }
        return userAnswer;
    }

    /**
     * Checks if the user's answer is correct.
     * @param userAnswer The character entered by the user.
     * @param questionIndex The index of the current question.
     * @return true if the answer is correct, false otherwise.
     */
    private static boolean checkAnswer(char userAnswer, int questionIndex) {
        return userAnswer == ANSWERS[questionIndex];
    }

    /**
     * Displays the final quiz results and provides feedback.
     * @param score The user's total correct answers.
     * @param totalQuestions The total number of questions.
     */
    private static void displayResults(int score, int totalQuestions) {
        System.out.println("--- Quiz Results ---");
        System.out.println("Your Score: " + score + "/" + totalQuestions + " ✅");
        int percentage = (int) ((double) score / totalQuestions * 100); // Cast to double for accurate division
        System.out.println("Percentage: " + percentage + "%");

        String feedback;
        if (percentage >= 80) {
            feedback = "Excellent! Keep up the great work! ⭐";
        } else if (percentage >= 50) {
            feedback = "Good! You're on your way to mastery. 👍";
        } else {
            feedback = "Needs Improvement. Review the topics and try again! 💡";
        }
        System.out.println("Feedback: " + feedback);
        System.out.println("\nThank you for playing! 👋");
    }
}