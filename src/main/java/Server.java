public class Server {
    // declare arrays for student names, assignment 1 grades, and assignment 2 grades
    private final String[] studentNames;
    private final String[] assignment1Grades;
    private final int[] assignment2Grades;

    public Server(String[] studentNames, String[] assignment1Grades, int[] assignment2Grades) {
        this.studentNames = studentNames;
        this.assignment1Grades = assignment1Grades;
        this.assignment2Grades = assignment2Grades;
    }

    // method to convert letter grade to numeric grade
    private int convertLetterGradeToNumeric(String letterGrade) {
        switch (letterGrade.toUpperCase()) {
            case "A+", "A" -> {
                return 4;
            }
            case "A-" -> {
                return (int) 3.7;
            }
            case "B+" -> {
                return (int) 3.3;
            }
            case "B" -> {
                return 3;
            }
            case "B-" -> {
                return (int) 2.7;
            }
            case "C+" -> {
                return (int) 2.3;
            }
            case "C" -> {
                return 2;
            }
            case "C-" -> {
                return (int) 1.7;
            }
            case "D+" -> {
                return (int) 1.3;
            }
            case "D" -> {
                return 1;
            }
            case "D-" -> {
                return (int) 0.7;
            }
            case "F" -> {
                return 0;
            }
            default -> {
                return -1;
            }
        }
    }

    // method to return an array containing a student's assignment 1 grade, assignment 2 grade, and current average
    public String[] getStudentGrades(String studentName) {
        String[] studentGrades = new String[3];

        // search through studentNames array to find the index of the student
        int studentIndex = -1;
        for (int i = 0; i < studentNames.length; i++) {
            if (studentNames[i] == null) {
                continue; // skip null values
            }
            if (studentNames[i].equals(studentName)) {
                studentIndex = i;
                break;
            }
        }

        if (studentIndex != -1) {
            // student found, retrieve assignment 1 grade, assignment 2 grade
            studentGrades[0] = assignment1Grades[studentIndex];
            studentGrades[1] = String.valueOf(assignment2Grades[studentIndex]);

            // calculate current average
            double currentAverage = (convertLetterGradeToNumeric(assignment1Grades[studentIndex]) + assignment2Grades[studentIndex]) / 2.0;
            studentGrades[2] = String.valueOf(currentAverage);
        } else {
            // student not found
            studentGrades[0] = "Error: Student not found.";
            studentGrades[1] = "";
            studentGrades[2] = "";
        }

        return studentGrades;
    }
}
