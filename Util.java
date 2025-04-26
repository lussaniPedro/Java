import java.util.Scanner;

public class Util {
    public static Scanner scan = new Scanner(System.in);

    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e){
            return;
        }
    }

    public static void pause(boolean inPortuguese){
        if(inPortuguese){
            System.out.print("Pressione ENTER para continuar. . .");
        } else{
            System.out.print("Press ENTER to continue. . .");    
        }
    }

    public static String upperCase(String str){
        return str.toUpperCase();
    }

    public static String lowerCase(String str){
        return str.toLowerCase();
    }
}