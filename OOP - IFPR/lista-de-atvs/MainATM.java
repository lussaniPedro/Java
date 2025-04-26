import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainATM {
    public static ATM atm = new ATM();
    public static Scanner scan = new Scanner(System.in);
    public static final String FILE_NAME = "ATM.txt";

    public static void main(String[] args) {
        int op;

        loadBalance();

        do {
            menu();
            op = scan.nextInt();
            scan.nextLine();

            option(op);
        } while (op != 0);

        saveBalance();

        scan.close();
    }

    /* MainATM class methods */
    public static void menu() {
        Util.clear();
        System.out.println("Automated Teller Machine\n");
        System.out.println("1 - View balance");
        System.out.println("2 - Deposit");
        System.out.println("3 - Withdraw");
        System.out.println("0 - Exit\n");
        System.out.print("Choose the desired option: ");
    }

    public static void option(int op) {
        Util.clear();
        switch (op) {
            case 1:
                atm.viewBalance();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 0:
                System.out.print("Exiting");
                for (int i = 0; i < 3; i++) {
                    System.out.print(".");
                    Util.sleep(600);
                }
                break;
            default:
                System.out.print("ERROR: Invalid option!!!");
                Util.sleep(1200);
                break;
        }
    }

    public static void deposit() {
        double deposit;

        do {
            Util.clear();
            System.out.print("How much money would you like to deposit?: ");
            deposit = scan.nextDouble();
            scan.nextLine();

            if (deposit < 0) {
                System.out.print("ERROR: Invalid deposit!!!");
                Util.sleep(1200);
            }
        } while (deposit < 0);

        atm.deposit(deposit);
        if(deposit > 0){
            System.out.print("$" + deposit + " deposited successfully!");
            Util.sleep(1000);
        }
    }

    public static void withdraw() {
        double withdrawal;

        if (atm.getBalance() == 0) {
            System.out.print("There is no money to withdraw!!!");
            Util.sleep(1200);
            return;
        }

        do {
            Util.clear();
            System.out.print("How much money would you like to withdraw?: ");
            withdrawal = scan.nextDouble();
            scan.nextLine();

            if (withdrawal < 0 || withdrawal > atm.getBalance()) {
                System.out.print("ERROR: Invalid withdrawal!!!");
                Util.sleep(1000);
            }
        } while (withdrawal < 0 || withdrawal > atm.getBalance());

        atm.withdraw(withdrawal);

        if(withdrawal > 0){
            System.out.print("$" + withdrawal + " withdrawn successfully!");
            Util.sleep(1200);
        }
    }

    /* File methods */
    public static void loadBalance() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = reader.readLine();
            if (line != null) {
                atm.setBalance(Double.parseDouble(line));
            }
        } catch (IOException e){
            return;
        }
    }

    public static void saveBalance() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(String.valueOf(atm.getBalance()));
        } catch (IOException e) {
            System.out.println("Could not save balance to file.");
        }
    }
}

class ATM {
    private double balance;

    /* Getters */
    public double getBalance() {
        return balance;
    }

    /* Setters */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /* ATM class methods */
    public void viewBalance() {
        System.out.println("Balance: $" + balance);
        Util.pause(false);
    }

    public void deposit(double deposit) {
        balance += deposit;
    }

    public void withdraw(double withdrawal) {
        balance -= withdrawal;
    }
}