import java.util.Random;
import java.util.Scanner;

public class MainJokenpo {
    public static int playerRock = 0, playerPaper = 0, playerScissors = 0;
    public static int computerRock = 0, computerPaper = 0, computerScissors = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int N;
        do {
            Util.clear();
            System.out.print("Enter the number of rounds (odd): ");
            N = scanner.nextInt();

            if (N <= 0 || N % 2 == 0) {
                System.out.println("Invalid number, please enter again");
                Util.pause(false);
            }
        } while (N <= 0 || N % 2 == 0);

        int playerWins = 0, computerWins = 0;

        for (int i = 1; i <= N; i++) {
            System.out.println("\nRound " + i);
            String playerChoice = getPlayerChoice(scanner);
            String computerChoice = getComputerChoice(random);

            updateCounters(playerChoice, computerChoice);

            System.out.println();
            System.out.println("You chose: " + playerChoice);
            System.out.println("The computer chose: " + computerChoice);

            String result = determineWinner(playerChoice, computerChoice);
            System.out.println(result);

            if (result.contains("You won")) {
                playerWins++;
            } else if (result.contains("The computer won")) {
                computerWins++;
            }
        }

        showFinalResult(playerWins, computerWins);
        showReport(playerRock, playerPaper, playerScissors, computerRock, computerPaper, computerScissors);

        scanner.close();
    }

    public static String getPlayerChoice(Scanner scanner) {
        System.out.println("Choose your option (Rock, Paper or Scissors): ");
        String playerChoice = scanner.next().toLowerCase();

        while (!playerChoice.equals("rock") && !playerChoice.equals("paper") && !playerChoice.equals("scissors")) {
            System.out.print("Invalid choice. Please enter Rock, Paper or Scissors: ");
            playerChoice = scanner.next().toLowerCase();
        }

        return playerChoice;
    }

    public static String getComputerChoice(Random random) {
        String[] options = {"rock", "paper", "scissors"};
        return options[random.nextInt(3)];
    }

    public static void updateCounters(String playerChoice, String computerChoice) {
        if (playerChoice.equals("rock")) playerRock++;
        else if (playerChoice.equals("paper")) playerPaper++;
        else if (playerChoice.equals("scissors")) playerScissors++;

        if (computerChoice.equals("rock")) computerRock++;
        else if (computerChoice.equals("paper")) computerPaper++;
        else if (computerChoice.equals("scissors")) computerScissors++;
    }

    public static String determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "Tie!";
        }

        if (playerChoice.equals("rock") && computerChoice.equals("scissors")) {
            return "You won because rock crushes scissors";
        } else if (playerChoice.equals("paper") && computerChoice.equals("rock")) {
            return "You won because paper covers rock";
        } else if (playerChoice.equals("scissors") && computerChoice.equals("paper")) {
            return "You won because scissors cut paper";
        } else if (playerChoice.equals("scissors") && computerChoice.equals("rock")) {
            return "The computer won because rock crushes scissors";
        } else if (playerChoice.equals("paper") && computerChoice.equals("scissors")) {
            return "The computer won because scissors cut paper";
        } else {
            return "The computer won because paper covers rock";
        }
    }

    public static void showFinalResult(int playerWins, int computerWins) {
        System.out.println("\nFinal result:");
        if (playerWins > computerWins) {
            System.out.println("You won the game!");
        } else if (playerWins < computerWins) {
            System.out.println("The computer won the game!");
        } else {
            System.out.println("The game ended in a tie!");
        }
    }

    public static void showReport(int playerRock, int playerPaper, int playerScissors, 
                                  int computerRock, int computerPaper, int computerScissors) {
        System.out.println("\nReport:");
        System.out.println("Player Rock: " + playerRock + " Paper: " + playerPaper + " Scissors: " + playerScissors);
        System.out.println("Computer Rock: " + computerRock + " Paper: " + computerPaper + " Scissors: " + computerScissors);
    }
}