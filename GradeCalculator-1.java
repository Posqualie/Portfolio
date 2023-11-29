import java.util.*;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCourses = 0;
        System.out.print("How many courses do you want to enter? ");
        numCourses = input.nextInt();
        input.nextLine(); // consume newline character
        String[] courseNames = new String[numCourses];
        int[] numStudents = new int[numCourses];
        int[][] studentGrades = new int[numCourses][];
        double[] courseAverages = new double[numCourses];
        String[][] studentNames = new String[numCourses][];

        // Iterate through each course and get information about each student
        for (int i = 0; i < numCourses; i++) {
            System.out.println("Enter course #" + (i + 1) + " name (Including Section Number):");
            courseNames[i] = input.nextLine();
            System.out.println("Enter number of students in " + courseNames[i] + ":");
            numStudents[i] = input.nextInt();
            input.nextLine(); // consume newline character
            studentNames[i] = new String[numStudents[i]];
            studentGrades[i] = new int[numStudents[i]];
            double totalWeightedGrade = 0.0;
            int numStudentsAbove70 = 0;
            //Start iteration on each student and gathering the required information
            for (int j = 0; j < numStudents[i]; j++) {
                System.out.println("Enter student #" + (j + 1) + " name:");
                studentNames[i][j] = input.nextLine();

                System.out.println("Enter student #" + (j + 1) + " grades for the following:");
                System.out.print("Quizzes (out of 100) ");
                int[] QuizGrades = Input_grade_line(input);

                System.out.print("Tests (out of 100) ");
                int[] TestGrades = Input_grade_line(input);
                System.out.print("Programs (out of 100) ");
                int[] ProgramGrades = Input_grade_line(input);
                System.out.print("Major projects (out of 100) ");
                int[] MajorProjectGrades = Input_grade_line(input);
                // Calculate weighted average
                double weightedGrade = calWeightedGrade(QuizGrades, TestGrades, ProgramGrades, MajorProjectGrades);
                weightedGrade += getExtraCredit(input);
                if (weightedGrade > 100) {
                    weightedGrade = 100;
                }
                studentGrades[i][j] = (int) Math.round(weightedGrade);
                totalWeightedGrade += weightedGrade;
                if (weightedGrade >= 70) {
                    numStudentsAbove70++;
                }
            }
            //Class output, shows information about each student and details like lowest/highest grade and total average grade.
            courseAverages[i] = totalWeightedGrade / numStudents[i];
            System.out.println("Course #" + (i + 1) + " " + courseNames[i] + " Summary:");
            System.out.println("Total number of students: " + numStudents[i]);
            System.out.println("Number of students with grades above or equal to 70: " + numStudentsAbove70);
            System.out.println("Class average: " + courseAverages[i]);
            System.out.println("Highest grade: " + Highest(studentGrades[i]));
            System.out.println("Lowest grade: " + Lowest(studentGrades[i]));
            System.out.println("Student grades:");
            for (int j = 0; j < numStudents[i]; j++) {
                System.out.printf(studentNames[i][j] + ": " + studentGrades[i][j] + "| Letter Grade " + LetterGrade(studentGrades[i][j]) + "| Scholarship amount | $%.2f%n", Scholarships(studentGrades[i][j]));
                System.out.println("---");
            }
        }
        //Finished with all the classes, printing out last of the information and ends the program
        System.out.println(" ");
        System.out.println("All information ");
        System.out.println("------------------------------------------------------------");
        System.out.println(" ");
        System.out.println("Grade Summary:");
        double overallClassAverage = 0.0;
        int numStudentsAbove70Total = 0;
        for (int i = 0; i < numCourses; i++) {
            overallClassAverage += courseAverages[i];
            numStudentsAbove70Total += countStudentsAbove70(studentGrades[i]);
        }
        overallClassAverage /= numCourses;
        System.out.println("Overall class average: " + overallClassAverage);
        System.out.println("Number of students with grades above or equal to 70: " + numStudentsAbove70Total);
        input.close();
    }
    //Simple method that counts how many ints in an array are over 70
    public static int countStudentsAbove70(int[] grades) {
        int count = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] >= 70) {
                count++;
            }
        }
        return count;
    }

    //Takes input that allows the user to enter multiple numbers on a single line seperated by a space and saves them to a int[]
    public static int[] Input_grade_line(Scanner input) {
        int[] intArr = null;

        while (intArr == null) {
            System.out.println("Enter grades separated by spaces:");
            String in = input.nextLine();
            String[] strArr = in.split(" ");
            intArr = new int[strArr.length];

            for (int i = 0; i < strArr.length; i++) {
                try {
                    int num = Integer.parseInt(strArr[i]);
                    if (num < 0 || num > 100) {
                        System.out.println("Invalid input: " + num);
                        intArr = null;
                        break;
                    }
                    intArr[i] = num;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: " + strArr[i]);
                    intArr = null;
                    break;
                }
            }
        }

        return intArr;
    }
    //Call this to Prompt the user for extra credit, returns extra credit added
    public static double getExtraCredit(Scanner input) {
        System.out.print("Enter extra credit? (0 to 5, if 0 than extra credit will not be calculated): ");
        double extraCredit = input.nextDouble();
        input.nextLine(); // consume newline character
        if (extraCredit < 0) {
            extraCredit = 0;
        } else if (extraCredit > 5) {
            extraCredit = 5;
        }
        return extraCredit;

    }

    //Calculates the weighted grade of a student using the given grade arrays and their respective weights
    public static double calWeightedGrade(int[] quiz, int[] test, int[] programs, int[] MPs) {
        double weightedgrade = AvgGrade(quiz) * 0.15 + AvgGrade(test) * 0.2 + AvgGrade(programs) * 0.25 + AvgGrade(MPs) * 0.4;
        return weightedgrade;
    }
    //Simple average calculator
    private static double AvgGrade(int[] grades) {
        int sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        double average = (double) sum / grades.length;
        return average;
    }
    //Changes number grade to letter grade
    public static String LetterGrade(double grade) {
        int gradeInt = (int) Math.floor(grade / 10); // Round down to the nearest 10 to simplify the switch statement

        switch (gradeInt) {
            case 10:
            case 9:
                return "A";
            case 8:
                return "B";
            case 7:
                return "C";
            case 6:
                return "D";
            default:
                return "F";
        }
    }

    //Finds and returns the lowest grade in a given array of grades
    public static int Lowest(int[] array) {
        int lowest = 100;
        for (int i = 0; i < array.length; i++) {
            if (i < lowest) {
                lowest = i;
            }
        }
        return lowest;
    }

    //Finds and returns the highest grade in a given array of grades
    public static int Highest(int[] array) {
        int highest = 0;
        for (int i = 0; i < array.length; i++) {
            if (i > highest) {
                highest = i;
            }
        }
        return highest;
    }

    //Calculates the amount of scholarship a student will receive based on their grade
    public static double Scholarships(int Grade) {
        double scholarshipAmount = 0;
        if (Grade >= 85 && Grade <= 89) {
            scholarshipAmount = 250;
        } else if (Grade >= 90 && Grade <= 94) {
            scholarshipAmount = 500;
        } else if (Grade >= 95 && Grade <= 100) {
            scholarshipAmount = 750;
        }
        return scholarshipAmount;
    }

}
