public class Naruto {
    public static void main(String[] args) {

        // Objeto 1
        uzumaki naruto = new uzumaki();
        naruto.setNome("Naruto Uzumaki");
        naruto.setBiju(true);

        System.out.println("Ninja: " + naruto.getNome() + ", Possui uma biju?: " + naruto.getBiju());
        naruto.chakaraInfitino();
        naruto.ataqueBase();
        naruto.ataqueBase(naruto.getBiju());

        // Objeto 2
        uchiha sasuke = new uchiha();
        sasuke.setNome("Sasuke Uchiha");;
        sasuke.setBiju(false);

        System.out.println("\nNinja: " + sasuke.getNome() + ", Possui uma biju?: " + sasuke.getBiju());
        sasuke.sharinganAtivado();
        sasuke.ataqueBase();
        sasuke.ataqueBase(3);
    }
}

class uzumaki extends ninja {
    public void chakaraInfitino(){
        System.out.println("Voce possui chakara infinito");
    }

    @Override
    public void ataqueBase(){
        System.out.println("Kunai do elemento vento arremessada!");
    }

    public void ataqueBase(boolean biju){
        if(biju){
            System.err.println("Biju invocada");
        } else{
            ataqueBase();
        }
    }
}

class uchiha extends ninja {
    private String sharingan;

    public String getSharingan() {
        return sharingan;
    }

    public void setSharingan(String sharingan) {
        this.sharingan = sharingan;
    }

    public void sharinganAtivado(){
        System.out.println("Sharingan ativado");
    }

    @Override
    public void ataqueBase(){
        System.out.println("Kunai do elemento fogo arremessada!");
    }

    public void ataqueBase(int nivelChakara){
        if(nivelChakara >= 3){
            System.out.println("Susano ativo");
        } else{
            System.out.println("Sem chakara");
        }
    }
}