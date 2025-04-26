import java.util.ArrayList;

public class automovel {
    public static void main(String[] args) {
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        veiculos.add(new Carro());
        veiculos.add(new Moto());

        for (Veiculo v : veiculos) {
            if (v instanceof Automatizavel) {
                ((Automatizavel) v).ligarMotor();
            }
            v.acelerar();
            if (v instanceof Automatizavel) {
                ((Automatizavel) v).desligarMotor();
            }
        }
    }
}

abstract class Veiculo {
    public double velocidade = 1;
    abstract void acelerar();
    void mostrarVelocidade(){
        System.out.println(velocidade + "km/h");
    }
}

interface Automatizavel {
    void ligarMotor();
    void desligarMotor();
}

class Carro extends Veiculo implements Automatizavel {
    private boolean ligado = false;

    @Override
    void acelerar(){
        if(!ligado){
            System.out.println("Impossivel acelerar!");
            return;
        }
        System.out.println("Acelerando...");
        
        mostrarVelocidade();
        
        velocidade *= 1.7;
        mostrarVelocidade();
    }
    
    @Override
    public void ligarMotor(){
        ligado = true;
        System.out.println("Motor do Carro ligado: V8");
    }

    @Override
    public void desligarMotor(){
        ligado = false;
        System.out.println("Carro desligado");
    }
}

class Moto extends Veiculo implements Automatizavel {
    private boolean ligado = false;

    @Override
    void acelerar(){
        if(!ligado){
            System.out.println("Impossivel acelerar!");
            return;
        }
        System.out.println("Acelerando...");

        mostrarVelocidade();

        velocidade *= 2.2;
        mostrarVelocidade();
    }

    @Override
    public void ligarMotor(){
        ligado = true;
        System.out.println("Motor da Moto ligado: Kawasaki Ninja H2");
    }
    
    @Override
    public void desligarMotor(){
        ligado = false;
        System.out.println("Moto desligada");
    }
}