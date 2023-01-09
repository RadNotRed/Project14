import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // initialize arrays for student names and grades
        String[] studentNames = new String[10];
        String[] assignment1Grades = new String[10];
        int[] assignment2Grades = new int[10];

        // initialize student names to default value
        Arrays.fill(studentNames, "");

        // get student names and grades from user input
        for (int i = 0; i < 1; i++) {
            System.out.println("Enter student name: ");
            studentNames[i] = sc.nextLine();
            System.out.println("Enter the letter grade for assignment 1: ");
            assignment1Grades[i] = sc.nextLine();
            System.out.println("Enter the numerical grade for assignment 2: ");
            assignment2Grades[i] = sc.nextInt();
            sc.nextLine(); // clear scanner buffer
        }

        // create Server object and pass student names, grades to it
        Server server = new Server(studentNames, assignment1Grades, assignment2Grades);

        // ask user for student name to look up
        String studentToLookUp;
        do {
            System.out.println("Enter student name to look up grades (type 'exit' to quit): ");
            studentToLookUp = sc.nextLine();
            if (!studentToLookUp.equals("exit")) {
                // call getStudentGrades method on Server object to get student grades
                String[] studentGrades = server.getStudentGrades(studentToLookUp);
                System.out.println("Assignment 1 grade: " + studentGrades[0]);
                System.out.println("Assignment 2 grade: " + studentGrades[1]);
                System.out.println("Current average: " + studentGrades[2]);
            }
        } while (!studentToLookUp.equals("exit"));

        sc.close();
    }
}
