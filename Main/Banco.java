import java.util.Scanner;

public class Banco {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        login();
    }

    private static void login(){
        System.out.println("-- BankSystem --");
        System.out.println("1 - Nova conta");
        System.out.println("2 - Conta existente\n");
        System.out.print("Escolha a opção: ");
        int op = scan.nextInt();
        scan.nextLine();

        dispararOpcao(op);
    }

    private static void dispararOpcao(int op){
        switch(op){
            // case 1: criarConta(); break;
            // case 2: escolherConta(); break;
            default: System.out.println("ERRO: Opcao inexistente"); login();
        }
    }
}

/* abstract class Conta {
    private static String nome;
    private static String senha;
    private static String numero;
}

class SistemaBancario extends Conta {
    private static double saldo;
} */