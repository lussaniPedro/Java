import java.util.Scanner;

public class MainGrades {
    public static void main(String[] args) {
        int numberOfGrades = 4;
        double[] grades = new double[numberOfGrades];
        double sum = 0;
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i < numberOfGrades; i++){
            Util.clear();
            System.out.println("Enter four grades from 0 to 10:\n");

            System.out.printf("Grade [%d]: ", i + 1);
            grades[i] = scan.nextDouble();

            if(grades[i] < 0 || grades[i] > 10){
                System.out.println("Invalid grade, please enter again!!!");
                Util.pause(false);
                i--;
                continue;
            }

            sum += grades[i];
        }

        Util.clear();
        for (double grade : grades) {
            System.out.printf("Grade: %.2f -> %s\n", grade, transformGradeToLetterGrade(grade));
        }

        double average = sum / numberOfGrades;

        System.out.println();
        System.out.printf("Final grade: %.2f -> %s", average, transformGradeToLetterGrade(average));

        scan.close();
    }

    public static String transformGradeToLetterGrade(double grade) {
        String letterGrade = "x";

        switch((grade < 5.9 && grade >= 0) ? 1 : (grade >= 6.0 && grade <= 7.4) ? 2 : (grade > 7.4 && grade <= 8.9) ? 3 : (grade > 8.9 && grade <= 10) ? 4 : 0) {
            case 1:
                letterGrade = "D - failed";
                break;
            case 2:
                letterGrade = "C - passed";
                break;
            case 3:
                letterGrade = "B - passed";
                break;
            case 4:
                letterGrade = "A - excellent";
                break;
            default:
                break;
        }

        return letterGrade;
    }
}
