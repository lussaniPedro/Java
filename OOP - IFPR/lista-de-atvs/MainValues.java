import java.util.Scanner;

public class MainValues {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Util.clear();
        System.out.print("Enter the first integer value: ");
        int value1 = scanner.nextInt();

        System.out.print("Enter the second integer value: ");
        int value2 = scanner.nextInt();

        scanner.close();

        int start, end;
        if (value1 < value2) {
            start = value1;
            end = value2;
        } else {
            start = value2;
            end = value1;
        }

        Util.clear();
        System.out.println("Numbers divisible by 3 and 4 between " + start + " and " + end + ":");

        for (int i = start; i <= end; i++) {
            if (i % 3 == 0 && i % 4 == 0) {
                System.out.println(i);
            }
        }

        System.out.println();
    }
}