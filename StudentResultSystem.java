import java.util.Scanner;

public class StudentResultSystem {

    // Method to validate marks
    public static boolean isValidMark(int mark) {
        return mark >= 0 && mark <= 100;
    }

    // Method to calculate percentage
    public static double calculatePercentage(int totalMarks, int subjects) {
        return (double) totalMarks / subjects;
    }

    // Method to assign grade using switch
    public static String assignGrade(double percentage) {
        int gradeCategory = (int) percentage / 10;

        switch (gradeCategory) {
            case 10:
            case 9:
                return "A";
            case 8:
                return "B";
            case 7:
                return "C";
            case 6:
                return "D";
            case 5:
                return "E";
            default:
                return "F";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;

        do {
            System.out.print("Enter number of subjects: ");
            int subjects = sc.nextInt();

            int totalMarks = 0;

            for (int i = 1; i <= subjects; i++) {
                System.out.print("Enter marks for subject " + i + ": ");
                int marks = sc.nextInt();

                if (!isValidMark(marks)) {
                    System.out.println("Invalid marks! Please enter between 0 and 100.");
                    i--; // repeat same subject
                    continue;
                }

                totalMarks += marks;
            }

            double percentage = calculatePercentage(totalMarks, subjects);
            String grade = assignGrade(percentage);

            System.out.println("\n--- Result Summary ---");
            System.out.println("Total Marks   : " + totalMarks);
            System.out.println("Percentage    : " + percentage + "%");
            System.out.println("Grade         : " + grade);
            System.out.println("Result        : " + (grade.equals("F") ? "FAIL" : "PASS"));

            System.out.print("\nDo you want to enter another student? (yes/no): ");
            choice = sc.next();

        } while (choice.equalsIgnoreCase("yes"));

        sc.close();
        System.out.println("\nProgram Ended.");
    }
}