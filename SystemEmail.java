import java.util.ArrayList;
import java.util.Scanner;

public class SystemEmail {
    public static int numContas = 0, conta = 0;
    public static ArrayList<Email> emails = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int op = 0;

        while(op != 6){
            toUse.clear();
            menu();
            op = scanner.nextInt();
            scanner.nextLine();

            dispararOpcao(op);
        }

        scanner.close();
    }

    private static void menu(){
        if(numContas == 0){
            System.out.println("-- E-mail System --\n");
        } else{
            System.out.println("E-mail System -- " + emails.get(conta).getEndereco() + '\n');
        }
        System.out.println("1. Criar nova conta");
        System.out.println("2. Alterar conta");
        System.out.println("3. Exibir todas as contas");
        System.out.println("4. Enviar email");
        System.out.println("5. Caixa de entrada");
        System.out.println("6. Sair\n");

        System.out.print("Escolha a opção: ");
    }

    private static void dispararOpcao(int op){
        toUse.clear();
        switch (op) {
            case 1:
                criarConta();
                break;
            case 2:
                alterarConta();
                break;
            case 3:
                listarContas(true);
                break;
            case 4:
                OpEnviarEmail();
                break;
            case 5:
                exibirCaixaDeEntrada();
                break;
            case 6:
                System.out.print("Saindo");
                for(int i = 0; i < 3; i++){
                    System.out.print(".");
                    toUse.sleep(500);
                }
                System.exit(0);
            default:
                System.out.println("Opção invalida!!!");
                toUse.sleep(700);
                break;
        }
    }

    private static void criarConta(){
        String emailString, senha;

        do{
            toUse.clear();
            System.out.print("Crie seu email: ");
            emailString = scanner.nextLine();
        } while(!verificarEmail(emailString));

        do{
            toUse.clear();
            System.out.print("Crie uma senha: ");
            senha = scanner.nextLine();
        } while(!verificarSenha(senha));

        Email email = new Email();
        email.setEndereco(emailString);
        email.setSenha(senha);

        emails.add(email);

        conta = numContas;
        numContas++;

        System.out.print("Conta criada com sucesso!!!");
        toUse.sleep(700);
    }

    private static void alterarConta(){
        int indice = -1;

        if(numContas == 0){
            System.out.print("Nenhuma conta cadastrada!");
            toUse.sleep(700);
            return;
        }

        while(true){
            listarContas(false);
            System.out.println("Para qual conta quer alterar?");
            System.out.print("Digite o endereco ou indice (ou sair para voltar): ");
            String str = scanner.nextLine();

            if(str.equals("sair")) return;

            if(isDigitString(str)){
                indice = Integer.parseInt(str);
                indice--;
            } else{
                for(int i = 0; i < emails.size(); i++){
                    if(str.equals(emails.get(i).getEndereco())){
                        indice = i;
                    }
                }
            }

            if(indice < 0 || indice >= numContas){
                System.out.println("ERRO: Indice invalido");
                toUse.sleep(1000);
                continue;
            } else{
                break;
            }
        }

        while(true){
            System.out.print("Digite sua senha (ou voltar para voltar): ");
            String senha = scanner.nextLine();

            if(senha.equals("voltar")) alterarConta();

            if(!senha.equals(emails.get(indice).getSenha())){
                System.out.println("ERRO: Senha incorreta!");
                toUse.sleep(1000);
                continue;
            } else{
                break;
            }
        }

        conta = indice;

        System.out.print("Conta alterada com sucesso!");
        toUse.sleep(700);
    }

    private static void listarContas(boolean pausar){
        if(numContas == 0){
            System.out.print("Nenhuma conta cadastrada!");
            toUse.sleep(700);
            return;
        }

        toUse.clear();
        System.out.printf("Todas as contas - [%d]\n\n", numContas);
        for(int i = 0; i < numContas; i++){
            exibirConta(i);
        }
        System.out.println();

        if (pausar) {
            toUse.pause();
        }
    }

    private static void exibirConta(int i){
        System.out.printf("| [%d] - %s\n", i + 1, emails.get(i).getEndereco());
    }

    private static void OpEnviarEmail(){
        int indice = -1;

        if(numContas == 0){
            System.out.print("Nenhuma conta cadastrada!");
            toUse.sleep(700);
            return;
        }

        while (true) {
            toUse.clear();
            System.out.print("Para quem deseja enviar o email?: ");
            String destinatario = scanner.nextLine();

            for(int i = 0; i < emails.size(); i++){
                Email email = emails.get(i);

                if(destinatario.equals(email.getEndereco())){
                    indice = i;
                    break;
                }
            }

            if(indice > -1){
                break;
            } else{
                System.out.print("Usuario não encontrado, digite novamente!");
                toUse.sleep(1000);
            }
        }

        Email emailEnviar = new Email();
        emailEnviar.setEndereco(emails.get(conta).getEndereco());

        System.out.print("Digite o assunto do email: ");
        emailEnviar.setAssunto(scanner.nextLine());

        System.out.print("Digite o conteudo do email: ");
        emailEnviar.setConteudo(scanner.nextLine());

        emailEnviar.enviarEmail(emailEnviar, emails.get(indice));
    }

    private static void exibirCaixaDeEntrada(){
        if(numContas == 0){
            System.out.print("Nenhuma conta cadastrada!");
            toUse.sleep(700);
            return;
        }
        
        Email email = emails.get(conta);
        
        if(email.getCaixaDeEntrada().size() == 0){
            System.out.print("Caixa de entrada vazia!");
            toUse.sleep(700);
            return;
        }

        System.out.printf("Caixa de entrada - [%d]\n\n", email.getCaixaDeEntrada().size());
        for(int i = 0; i < email.getCaixaDeEntrada().size(); i++){
            Email emailRecebido = email.getCaixaDeEntrada().get(i);
            System.out.printf("%-4d| Assunto: %s\n", i + 1, emailRecebido.getAssunto());
            System.out.printf("    | Conteudo: %s\n", emailRecebido.getConteudo());
            System.out.printf("    |\n");
            System.out.printf("    | Enviado por: %s\n", emailRecebido.getEndereco());
            System.out.println();
        }
        toUse.pause();
    }

    private static boolean verificarEmail(String email){
        int contA = 0, contP = 0; 

        for(int i = 0; i < email.length(); i++){
            if(email.charAt(i) == '@'){
                contA++;
            }

            if(email.charAt(i) == '.'){
                contP++;
            }
        }

        if(contA != 1 || contP < 1){
            System.out.print("ERRO: O e-mail deve conter um unico '@' e ao menos um '.'!");
            toUse.sleep(2500);
            return false;
        }

        return true;
    }

    private static boolean verificarSenha(String senha){
        int contEsp = 0, contMin = 0, contMai = 0, contNum = 0;

        for(int i = 0; i < senha.length(); i++){
            char c = senha.charAt(i);

            if(Character.isLetter(c)){
                if(Character.isUpperCase(c)){
                    contMai++;
                } else{
                    contMin++;
                }
            } else if(Character.isDigit(c)){
                contNum++;
            } else{
                contEsp++;
            }
        }

        if(senha.length() < 6 || contEsp == 0 || contMin == 0 || contMai == 0 || contNum == 0){
            System.out.print("ERRO: A senha deve ter no minimo 6 digitos,\ne conter ao menos: 1 caracter especial, uma letra maiuscula, uma letra minuscula e um numero!");
            toUse.sleep(2500);
            return false;
        }
        
        return true;
    }

    private static boolean isDigitString(String str){
        for(int i = 0; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }

        return true;
    }
}

class Email {
    private String endereco;
    private String senha;
    private String assunto;
    private String conteudo;
    private int emailsEnviados = 0;
    private ArrayList<Email> caixaDeEntrada = new ArrayList<>();

    /* Getters */
    public String getEndereco() {
        return endereco;
    }

    public String getSenha() {
        return senha;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public int getEmailEnviados() {
        return emailsEnviados;
    }

    public ArrayList<Email> getCaixaDeEntrada() {
        return caixaDeEntrada;
    }

    /* Setters */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setCaixaDeEntrada(Email email) {
        this.caixaDeEntrada.add(email);
    }

    /* Metodos */
    public void enviarEmail(Email mensagem, Email destinatario) {
        destinatario.receberEmail(mensagem);

        System.out.println("Email enviado para " + destinatario.endereco + " - " + mensagem.assunto);
        this.emailsEnviados++;
    }

    public void receberEmail(Email emailEnviado){
        this.caixaDeEntrada.add(emailEnviado);
    }
}