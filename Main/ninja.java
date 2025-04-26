public class ninja {
    private String nome;
    private String aldeia;
    private boolean biju;
    private int idade;

    /* Getter - Criar getter para o usuário */
    public String getNome(){
        return nome;
    }

    public String getAldeia() {
        return aldeia;
    }

    public int getIdade() {
        return idade;
    }

    public boolean getBiju() {
        return biju;
    }

    /* Setter - Settar o valor da variável */
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setAldeia(String aldeia) {
        this.aldeia = aldeia;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setBiju(boolean biju) {
        this.biju = biju;
    }

    public void ataqueBase(){
        System.out.println("Kunai arremessada!");
    }
}
