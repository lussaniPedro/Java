import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = s.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = s.nextInt();

        mostrarMeuNome(nome, idade);

        s.close();
    }

    private static void mostrarMeuNome(String nome, int idade){
        System.out.println("Meu nome eh " + nome + " e possuo " + idade + " anos");
    }
}