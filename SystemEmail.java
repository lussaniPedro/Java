import java.util.ArrayList;
import java.util.Scanner;

public class SystemEmail {
    public static int numContas = 0, conta = 0;
    public static ArrayList<Email> emails = new ArrayList<>();
    public static Email systemEmail = new Email();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int op = 0;

        systemEmail.setEndereco("system.email@syem.com.br");
        while(op != 8){
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
        System.out.println("6. Emails enviados");
        System.out.println("7. Recuperar senha");
        System.out.println("8. Sair\n");

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
                exibirEmailsEnviados();
                break;
            case 7:
                opRecuperarSenha();
                break;
            case 8:
                System.out.print("Saindo");
                for(int i = 0; i < 3; i++){
                    System.out.print(".");
                    toUse.sleep(500);
                }
                break;
            default:
                System.out.println("Opção invalida!!!");
                toUse.sleep(700);
                break;
        }
    }

    private static void criarConta(){
        String emailString, senha, telefone, emailDeRecuperacao;
        Email email = new Email();
        char opSn = 'x';
        int indice = -1;

        do{
            toUse.clear();
            System.out.print("Crie seu email: ");
            emailString = scanner.nextLine();
            emailString = toUse.isLowerCase(emailString);
        } while(!verificarEmail(emailString));

        do{
            toUse.clear();
            System.out.print("Crie uma senha (min 6 caracteres): ");
            senha = scanner.nextLine();
        } while(!verificarSenha(senha));

        do{
            toUse.clear();
            System.out.print("Adicione telefone de recuperacao: ");
            telefone = scanner.nextLine();
        } while(!verificarTelefone(telefone));
        
        
        if(numContas > 0){
            while(opSn != 's' && opSn != 'n'){
                System.out.print("Deseja adicionar um email de recuperacao (s/n)?: ");
                opSn = scanner.next().charAt(0);
                scanner.nextLine();
                opSn = Character.toLowerCase(opSn);
            }
            
            if(opSn == 's'){
                do{
                    toUse.clear();
                    System.out.print("Digite o email que deseja adicionar: ");
                    emailDeRecuperacao = scanner.nextLine();
                    
                    for(int i = 0; i < emails.size(); i++){
                        Email e = emails.get(i);
                        
                        if(emailDeRecuperacao.equals(e.getEndereco())){
                            indice = i;
                        }
                    }
                    
                    if(indice < 0){
                        System.out.print("ERRO: Email nao encontrado!");
                        toUse.sleep(2000);
                        continue;
                    }
                } while(indice < 0);
                
                email.setEmailRecuperacao(emailDeRecuperacao);
                email.setRecuperacao(true);
            }
        }
        
        email.setEndereco(emailString);
        email.setSenha(senha);
        email.setTelefone(telefone);
        
        emails.add(email);
        
        conta = numContas;
        numContas++;

        toUse.clear();
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
            System.out.print("Digite sua senha (ou sair para sair): ");
            String senha = scanner.nextLine();

            if(senha.equals("sair")) return;

            if(!senha.equals(emails.get(indice).getSenha())){
                System.out.println("ERRO: Senha incorreta!");
                toUse.sleep(1000);
                continue;
            } else{
                break;
            }
        }

        conta = indice;

        toUse.clear();
        System.out.print("Conta alterada com sucesso!");
        toUse.sleep(700);
    }

    private static void opRecuperarSenha(){
        int op = 0;

        while(op != 3){
            toUse.clear();
            System.out.println("1. Recuperar por e-mail");      
            System.out.println("2. Recuperar por telefone");            
            System.out.println("3. Voltar\n");
            System.out.print("Digite a opcao: ");
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    recuperarSenha(op);
                    break;
                case 2:
                    recuperarSenha(op);
                    break;
                case 3:
                    break;
                default:
                System.out.println("ERRO: Opcao invalida!");
                toUse.sleep(2000);
                break;
            }
        }
    }
    
    private static void recuperarSenha(int metodoRecuperacao){
        String conta;
        int indice = -1, i;
        systemEmail.setAssunto("Recuperacao de senha");

        while (true) {
            System.out.print("Qual conta deseja recuperar (digite sair para voltar)?: ");
            conta = scanner.nextLine();

            if(conta.equals("voltar")) return;

            for(i = 0; i < emails.size(); i++){
                Email email = emails.get(i);

                if(conta.equals(email.getEndereco())){
                    indice = i;
                    break;
                }
            }

            if(indice >= 0){
                break;
            } else{
                System.out.print("ERRO: Conta nao encontrada!");
                toUse.sleep(2000);
                continue;
            }
        }

        if(metodoRecuperacao == 1){
            toUse.clear();
            systemEmail.setConteudo("A senha de " + emails.get(indice).getEndereco() + " eh: " + emails.get(indice).getSenha());
            systemEmail.enviarEmail(systemEmail, emails.get(indice), systemEmail);
            
            System.out.println("\nUm email de recuperacao foi enviado para " + emails.get(indice).getEndereco());
            toUse.sleep(2500);
            
            if(emails.get(indice).getRecuperacao()){
                toUse.clear();
                for (i = 0; i < emails.size(); i++) {
                    if (emails.get(i).getEndereco().equals(emails.get(indice).getEmailRecuperacao())) {
                        break;
                    }
                }

                systemEmail.enviarEmail(systemEmail, emails.get(i), systemEmail);

                System.out.println("\nUm email de recuperacao foi enviado para " + emails.get(indice).getEmailRecuperacao());
                toUse.sleep(2500);
            }

            return;
        } else{
            System.out.print("Digite seu telefone: ");
            String telefone = scanner.nextLine();

            if(telefone.equals(emails.get(indice).getTelefone())){
                System.out.println("Sua senha eh: " + emails.get(indice).getSenha());
                toUse.sleep(2500);
            }
        }

        systemEmail.setConteudo("Sua senha foi recuperada com sucesso!");
        systemEmail.enviarEmail(systemEmail, emails.get(indice), systemEmail);
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

        emailEnviar.enviarEmail(emailEnviar, emails.get(indice), emails.get(conta));
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
            toUse.sleep(1000);
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

    private static void exibirEmailsEnviados(){
        if(numContas == 0){
            System.out.print("Nenhuma conta cadastrada!");
            toUse.sleep(700);
            return;
        }

        Email email = emails.get(conta);

        if(email.getEmailsEnviados().size() == 0){
            System.out.print("Nenhum email enviado!");
            toUse.sleep(1000);
            return;
        }

        System.out.printf("Emails enviados - [%d]\n\n", email.getEmailsEnviados().size());
        for(int i = 0; i < email.getEmailsEnviados().size(); i++){
            Email emailEnviado = email.getEmailsEnviados().get(i);
            System.out.printf("%-4d| Assunto: %s\n", i + 1, emailEnviado.getAssunto());
            System.out.printf("    | Conteudo: %s\n", emailEnviado.getConteudo());
            System.out.printf("    |\n");
            System.out.printf("    | Enviado para: %s\n", emailEnviado.getEndereco());
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

        for(int j = 0; j < emails.size(); j++){
            Email e = emails.get(j);

            if(email.equals(e.getEndereco())){
                System.out.print("ERRO: E-mail ja existente!");
                toUse.sleep(2000);
                return false;
            }
        }

        if(email.contains("@syem")){
            System.out.print("ERRO: Endereco nao permitido!!!");
            toUse.sleep(2000);
            return false;
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

    private static boolean verificarTelefone(String telefone){
        if(telefone.length() < 4){
            System.out.print("ERRO: O telefone deve conter no minimo 4 digitos!");
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
    private String emailRecuperacao;
    private boolean recuperacao = false;
    private String senha;
    private String telefone;
    private String assunto;
    private String conteudo;
    private ArrayList<Email> caixaDeEntrada = new ArrayList<>();
    private ArrayList<Email> emailsEnviados = new ArrayList<>();

    /* Getters */
    public String getEndereco() {
        return endereco;
    }

    public String getEmailRecuperacao() {
        return emailRecuperacao;
    }

    public boolean getRecuperacao() {
        return recuperacao;
    }

    public String getSenha() {
        return senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public ArrayList<Email> getCaixaDeEntrada() {
        return caixaDeEntrada;
    }

    public ArrayList<Email> getEmailsEnviados() {
        return emailsEnviados;
    }

    /* Setters */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEmailRecuperacao(String emailRecuperacao) {
        this.emailRecuperacao = emailRecuperacao;
    }

    public void setRecuperacao(boolean recuperacao) {
        this.recuperacao = recuperacao;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
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

    public void setEmailsEnviados(Email email) {
        this.emailsEnviados.add(email);
    }

    /* Metodos */
    public void enviarEmail(Email mensagem, Email destinatario, Email remetente) {
        destinatario.receberEmail(mensagem);

        Email enviar = mensagem;
        enviar.endereco = destinatario.endereco;
        remetente.emailsEnviados.add(enviar);

        System.out.println("Email enviado para " + destinatario.endereco + " - " + mensagem.assunto);
    }

    public void receberEmail(Email emailEnviado){
        this.caixaDeEntrada.add(emailEnviado);
    }
}