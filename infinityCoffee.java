public class infinityCoffee {

    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.setFull(true);

        toUse.clear();
        while(true){
            if(coffee.getFull()){
                coffee.setFull(coffee.drink());
            } else{
                coffee.setFull(coffee.refill());
            }
        }
    }
}

class Coffee {
    private boolean full;

    public boolean getFull(){
        return full;
    }

    public void setFull(boolean full){
        this.full = full;
    }

    public boolean drink(){
        System.out.print("Drinking");

        for(int i = 0; i < 3; i++){
            System.out.print(".");
            toUse.sleep(500);            
        }
        
        System.out.println("\nEmpty");
        toUse.sleep(500);            
        return false;
    }
    
    public boolean refill(){
        System.out.print("Refilling");
        
        for(int i = 0; i < 3; i++){
            System.out.print(".");
            toUse.sleep(500);            
        }
        
        System.out.println("\nFull");
        toUse.sleep(500);            
        return true;
    }
}