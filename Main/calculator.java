import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float number1, number2;
        char operator;

        do{
            clear();
            System.out.println("-- Simple calculator --\n");

            System.out.print("Type the first number: ");
            number1 = scanner.nextFloat();

            System.out.print("Type the operator (+, -, *, /): ");
            operator = scanner.next().charAt(0);

            System.out.print("Type the second number: ");
            number2 = scanner.nextFloat();

            if(operator != '+' && operator != '-' && operator != '*'&& operator != '/'){
                System.out.println("ERROR: Invalid operator!!!");
            }
        } while(operator != '+' && operator != '-' && operator != '*' && operator != '/');

        float result = 0;
        switch(operator){
            case '+': result = addition(number1, number2); break;
            case '-': result = subtraction(number1, number2); break;
            case '*': result = multiplication(number1, number2); break;
            case '/':
                if(number2 == 0) {
                    scanner.close();
                    System.out.print("ERROR: Invalid division!!!");
                    System.exit(1);
                }
 
                result = division(number1, number2); break;
        }

        System.out.println();
        System.out.println(number1 + " " + operator + " " + number2 + " = " + result + '\n');

        scanner.close();
    }

    private static float addition(float num1, float num2){
        return num1 + num2;
    }

    private static float subtraction(float num1, float num2){
        return num1 - num2;
    }

    private static float multiplication(float num1, float num2){
        return num1 * num2;
    }

    private static float division(float num1, float num2){
        return num1 / num2;
    }

    private static void clear(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
}