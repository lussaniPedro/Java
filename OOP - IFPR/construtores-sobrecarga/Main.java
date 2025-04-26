import java.util.Scanner;

public class Main {
    public static Carro carro;

    public static void main(String[] args){
        int op = 0;
        Scanner scan = new Scanner(System.in);

        while(op != 4){
            menu();
            op = scan.nextInt();
            scan.nextLine();

            dispararOpcao(op, scan);
        }
        
        scan.close();
    }

    public static void menu(){
        Util.clear();
        System.out.println("=== CARRO ===\n");
        System.out.println("1 - Criar carro");
        System.out.println("2 - Alterar carro");
        System.out.println("3 - Exibir carro");
        System.out.println("4 - Sair\n");
        System.out.print("Escolha uma opcao: ");
    }

    public static void dispararOpcao(int op, Scanner scan){
        Util.clear();
        switch(op){
            case 1:
                criarCarro(scan);
                break;
            case 2:
                alterarCarro(scan);
                break;
            case 3:
                exibirCarro();
                break;
            case 4:
                System.out.print("Saindo");
                for(int i = 0; i < 3; i++){
                    System.out.print(".");
                    Util.sleep(600);
                }
                break;
            default:
                break;
        }
    }

    public static void criarCarro(Scanner scan){
        System.out.print("Marca: ");
        String marca = scan.nextLine();
        System.out.print("Modelo: ");
        String modelo = scan.nextLine();
        System.out.print("Placa: ");
        String placa = scan.nextLine();

        System.out.print("\nDeseja adicionar motor? (s/n): ");
        String resp = scan.nextLine();
        Motor motor = null;
        if(resp.equalsIgnoreCase("s")){
            System.out.print("\nTipo do motor: ");
            String tipo = scan.nextLine();
            System.out.print("Potência do motor (cv): ");
            int potencia = scan.nextInt();
            scan.nextLine();
            motor = new Motor(tipo, potencia);
        }

        System.out.print("\nDeseja adicionar condutor? (s/n): ");
        resp = scan.nextLine();
        Condutor condutor = null;
        if(resp.equalsIgnoreCase("s")){
            System.out.print("\nNome do condutor: ");
            String nome = scan.nextLine();
            System.out.print("CNH do condutor: ");
            String cnh = scan.nextLine();
            condutor = new Condutor(nome, cnh);
        }

        carro = new Carro(marca, modelo, placa, motor, condutor);
        System.out.println("\nCarro criado com sucesso!");
        Util.pause(true);
    }

    public static void alterarCarro(Scanner scan){
        if(carro == null){
            System.out.println("\nNao ha carros criados!");
            Util.pause(true);
            return;
        }

        Util.clear();
        System.out.println("=== ALTERAR CARRO ===\n");

        System.out.println(carro.toString() + '\n');

        System.out.println("1 - Adicionar motor");
        System.out.println("2 - Adicionar condutor");
        System.out.println("3 - Alterar motor");
        System.out.println("4 - Alterar condutor");
        System.out.println("5 - Voltar ao menu anterior");
        System.out.print("\nEscolha uma opcao: ");
        int op = scan.nextInt();
        scan.nextLine();

        if(op == 3){
            if(carro.getMotor() == null){
                System.out.println("\nNao ha motores nesse carro!");
                Util.pause(true);
                return;
            }
        } else if(op == 4){
            if(carro.getCondutor() == null){
                System.out.println("\nNao ha condutores nesse carro!");
                Util.pause(true);
                return;
            }
        }

        Util.clear();
        switch((op == 1 || op == 3) ? 1 : (op == 2 || op == 4) ? 2 : op){
            case 1:
                System.out.print("\nTipo do motor: ");
                String tipo = scan.nextLine();
                
                System.out.print("Potencia do motor (cv): ");
                int pot = scan.nextInt();
                scan.nextLine();
                
                carro.setMotor(new Motor(tipo, pot));
                System.out.println("\nMotor atualizado!");
                break;
            case 2:
                System.out.print("\nNome do condutor: ");
                String nome = scan.nextLine();

                System.out.print("CNH do condutor: ");
                String cnh = scan.nextLine();

                carro.setCondutor(new Condutor(nome, cnh));
                System.out.println("\nCondutor atualizado!");
                break;
            case 5:
                return;
            default:
                System.out.println("\nOpcao invalida!");
                break;
        }

        Util.pause(true);
    }

    public static void exibirCarro(){
        Util.clear();
        if(carro == null){
            System.out.println("\nNao ha carros criados!");
        }else{
            System.out.println("=== DADOS DO CARRO ===");
            System.out.println(carro.toString());
            System.out.println("======================\n");
        }
        Util.pause(true);
    }
}

class Carro {
    private String marca;
    private String modelo;
    private String placa;
    private Motor motor;
    private Condutor condutor;

    public Carro(String marca, String modelo, String placa, Motor motor, Condutor condutor){
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.motor = motor;
        this.condutor = condutor;
    }

    public Carro(String marca, String modelo, String placa, Motor motor){
        this(marca, modelo, placa, motor, null);
    }

    public Carro(String marca, String modelo, String placa){
        this(marca, modelo, placa, null, null);
    }

    public void setMotor(Motor motor){
        this.motor = motor;
    }

    public void setCondutor(Condutor condutor){
        this.condutor = condutor;
    }

    public String getMarca(){
        return marca;
    }

    public String getModelo(){
        return modelo;
    }

    public String getPlaca(){
        return placa;
    }

    public Motor getMotor(){
        return motor;
    }

    public Condutor getCondutor(){
        return condutor;
    }

    @Override
    public String toString() {
    return "Marca: " + marca + "\nModelo: " + modelo + "\nPlaca: " + placa +
           "\nMotor: " + (motor != null ? motor : "Sem motor") +
           "\nCondutor: " + (condutor != null ? condutor : "Sem condutor");
}

}

class Motor {
    private String tipo;
    private int potencia;

    public Motor(String tipo, int potencia){
        this.tipo = tipo;
        this.potencia = potencia;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public int getPotencia(){
        return potencia;
    }

    public void setPotencia(int potencia){
        this.potencia = potencia;
    }

    @Override
    public String toString(){
        return tipo + " - " + potencia + "cv";
    }
}

class Condutor {
    private String nome;
    private String cnh;

    public Condutor(String nome, String cnh){
        this.nome = nome;
        this.cnh = cnh;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCnh(){
        return cnh;
    }

    public void setCnh(String cnh){
        this.cnh = cnh;
    }

    @Override
    public String toString(){
        return nome + " (CNH: " + cnh + ")";
    }
}