import java.util.Arrays;
import java.util.Scanner;

public class GradeAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter 12 grades ranging from 0 to 100:");
            int[] grades = new int[12];

            for (int i = 0; i < 12; i++) {
                int grade;
                do {
                    System.out.print("Enter grade " + (i + 1) + ": ");
                    grade = scanner.nextInt();
                    if (grade < 0 || grade > 100) {
                        System.out.println("Invalid grade, enter a grade between 0 and 100.");
                    }
                } while (grade < 0 || grade > 100);
                grades[i] = grade;
            }

            // Sort the grades
            Arrays.sort(grades);

            // Display all grades
            System.out.println("\nAll Grades:");
            for (int grade : grades) {
                System.out.println(grade);
            }

            // Calculate and display average
            double average = calculateAverage(grades);
            System.out.println("\nAverage Grade: " + average);

            // Allow up to 3 points of extra credit
            System.out.print("Enter up to 3 points of extra credit: ");
            int extraCredit = scanner.nextInt();
            double finalGrade = Math.min(average + extraCredit, 100.0);
            System.out.println("Final Grade (with extra credit): " + finalGrade);

            // Display grades less than 70
            System.out.println("\nGrades Below 70:");
            for (int grade : grades) {
                if (grade < 70) {
                    System.out.println(grade);
                }
            }

            // Display lowest and highest grades
            System.out.println("\nLowest Grade: " + grades[0]);
            System.out.println("Highest Grade: " + grades[grades.length - 1]);

            System.out.print("Do you want to average another set of grades? (yes/no): ");
            String anotherSet = scanner.next().toLowerCase();
            if (!anotherSet.equals("yes")) {
                break;
            }
        } while (true);

        System.out.println("Program terminated.");
    }

    public static double calculateAverage(int[] grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }
}
