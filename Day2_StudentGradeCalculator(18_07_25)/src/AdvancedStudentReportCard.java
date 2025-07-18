package Day2_StudentGradeCalculator.src;

import java.util.*;
import java.io.*;

class Student {
    String studentId;
    String name;
    int[] marks;
    int total;
    double average;
    String grade;

    public Student(String studentId, String name, int[] marks) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
        calculateTotal();
        calculateAverage();
        calculateGrade();
    }

    void calculateTotal() {
        total = 0;
        for (int mark : marks) {
            total += mark;
        }
    }

    void calculateAverage() {
        average = total / (double) marks.length;
    }

    void calculateGrade() {
        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else {
            grade = "D";
        }
    }

    void displayReport() {
        System.out.println("\n--- STUDENT REPORT ---");
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Total Marks: " + total);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
    }

    // Convert student report to a string to save to file
    String getReportAsString() {
        return "ID: " + studentId + "\n"
             + "Name: " + name + "\n"
             + "Total: " + total + "\n"
             + "Average: " + average + "\n"
             + "Grade: " + grade + "\n";
    }
}

public class AdvancedStudentReportCard {
    static final int NUM_SUBJECTS = 5;
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("📊 Welcome to the Multi-Student Report Card System 📊");

        while (true) {
            System.out.print("\nEnter Student ID (or type 'exit' to finish): ");
            String studentId = scanner.nextLine();
            if (studentId.equalsIgnoreCase("exit")) break;

            // Ensure unique Student ID
            if (isDuplicateId(studentId)) {
                System.out.println("❗ This Student ID already exists. Try another.");
                continue;
            }

            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            int[] marks = new int[NUM_SUBJECTS];

            // Input marks with validation
            for (int i = 0; i < NUM_SUBJECTS; i++) {
                while (true) {
                    System.out.print("Enter marks for Subject " + (i + 1) + ": ");
                    int mark = scanner.nextInt();
                    if (mark >= 0 && mark <= 100) {
                        marks[i] = mark;
                        break;
                    } else
                        System.out.println("❌ Invalid mark! Please enter between 0 and 100.");
                }
            }
            scanner.nextLine(); // Clear buffer after nextInt

            Student student = new Student(studentId, name, marks);
            studentList.add(student);

            System.out.println("✅ Student added successfully!");
        }

        // Display and save all reports
        displayAndSaveReports();
        System.out.println("🏁 All reports saved to 'Student_reports.txt'. Goodbye.");
    }

    // Check for duplicate student ID
    static boolean isDuplicateId(String id) {
        for (Student s : studentList) {
            if (s.studentId.equalsIgnoreCase(id)) return true;
        }
        return false;
    }

    // Display all student reports and write to output file
    static void displayAndSaveReports() {
        try {
            FileWriter writer = new FileWriter("Student_reports.txt");

            for (Student s : studentList) {
                s.displayReport(); // Console Output
                writer.write("--- STUDENT REPORT ---\n");
                writer.write(s.getReportAsString());
                writer.write("----------------------\n\n");
            }

            writer.close();
        } catch (IOException e){
            System.out.println("⚠️ Error saving to file: " + e.getMessage());
        }
        
    }
}