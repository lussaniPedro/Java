import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Random generator = new Random();
        Scanner scanner = new Scanner(System.in);

        int num = generator.nextInt(10);
        while(!attempt(num, scanner));

        scanner.close();
    }

    public static boolean attempt(int randomNum, Scanner scanner){
        System.out.println("Try to guess the number: ");
        int guess = scanner.nextInt();
        scanner.nextLine();

        if(guess == randomNum){
            System.out.println("You win!");
            return true;
        } else if(guess > randomNum){
            System.out.println("High attempt");
        } else {
            System.out.println("Low attempt");
        }

        return false;
    }
}