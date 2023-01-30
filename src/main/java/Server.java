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

/*     method to convert letter grade to numeric grade
     grades are now based upon A+ (97–100), A (93–96), A- (90–92), B+ (87–89), B (83–86), B- (80–82), C+ (77–79), C (73–76), C- (70–72), D+ (67–69), D (65–66), D- (below 65).
     source: collegeboard grading, all letters use the top value*/

    private int convertLetterGradeToNumeric(String letterGrade) {
        switch (letterGrade.toUpperCase()) {
            case "A+" -> {
                return 100;
            }
            case "A" -> {
                return 96;
            }
            case "A-" -> {
                return 92;
            }
            case "B+" -> {
                return 89;
            }
            case "B" -> {
                return 86;
            }
            case "B-" -> {
                return 82;
            }
            case "C+" -> {
                return 79;
            }
            case "C" -> {
                return 76;
            }
            case "C-" -> {
                return 72;
            }
            case "D+" -> {
                return 69;
            }
            case "D" -> {
                return 66;
            }
            case "D-" -> {
                return 65;
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
            studentGrades[0] = assignment1Grades[studentIndex] + " (" + convertLetterGradeToNumeric(assignment1Grades[studentIndex]) + ")";
            studentGrades[1] = String.valueOf(assignment2Grades[studentIndex]);

            // calculate current average
            double currentAverage = (convertLetterGradeToNumeric(assignment1Grades[studentIndex]) + assignment2Grades[studentIndex]) / 2.0;
            studentGrades[2] = String.valueOf(currentAverage);
        } else {
            // student not found
            studentGrades[0] = "Error: Student not found.";
            studentGrades[1] = "Error: Student not found.";
            studentGrades[2] = "Error: Student not found.";
        }

        return studentGrades;
    }
}
