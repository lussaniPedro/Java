import java.util.Random;
import java.util.Scanner;

public class MainSorting {
    public static void main(String[] args) {
        int[] arr = new int[30];
        Random generator = new Random();
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i < arr.length; i++){
            arr[i] = generator.nextInt(300);
        }
        
        String option;
        do{
            
            Util.clear();
            System.out.print("Array: [ ");
            displayArray(arr);

            System.out.print("How would you like to sort the array (Ascending or Descending)?: ");
            option = scan.nextLine();

            if(!option.equalsIgnoreCase("ascending") && !option.equalsIgnoreCase("descending")){
                System.out.println("Invalid option! Please enter again!!!\n");
                Util.pause(false);
            }
        } while(!option.equalsIgnoreCase("ascending") && !option.equalsIgnoreCase("descending"));

        if(option.equalsIgnoreCase("ascending")){
            ascendingSort(arr);
        } else{
            descendingSort(arr);
        }

        System.out.println();
        System.out.print("Sorted array: [ ");
        displayArray(arr);

        scan.close();
    }

    public static void displayArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println("]\n");
    }

    public static void ascendingSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void descendingSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}