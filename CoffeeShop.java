import java.util.Scanner;

public class CoffeeShop {
    public static Scanner scanner = new Scanner(System.in);
    public static Coffee coffee = new Coffee();
    public static void main(String[] args) {
        int op = 0;

        enterTheCoffeeShop();
        do{
            menu();
            op = scanner.nextInt();

            option(op);
        } while(op != 4);

        scanner.close();
    }

    private static void menu(){
        Util.clear();
        System.out.println("-- Coffee shop --");
        System.out.println("1. Drink coffee");
        System.out.println("2. Refill coffee");
        System.out.println("3. Change flavor");
        System.out.println("4. Leave\n");
        System.out.print("Choose the option: ");
    }
    
    private static void option(int op){
        Util.clear();
        switch(op){
            case 1: coffee.setFull(coffee.drink()); break;
            case 2: coffee.setFull(coffee.refill()); break;
            // case 3: coffee.setFull(coffee.drink()); break;
            case 4: leaveTheCoffeeShop(); break;
            default:
                System.out.println("ERROR: Option not found!!!");
                Util.sleep(700);
                break;
        }
    }

    private static void enterTheCoffeeShop(){
        Util.clear();
        for(int i = 0; i < 2; i++){
            System.out.print("Ding...");
            Util.sleep(800);
        }
        
        Util.clear();
        System.out.println("You enter in the coffee shop.");
    }

    private static void leaveTheCoffeeShop(){
        System.out.println("Leaving...");
        for(int i = 0; i < 2; i++){
            Util.sleep(800);
            System.out.print("Ding...");
        }
    }
}