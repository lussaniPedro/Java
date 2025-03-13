public class infinityCoffee {

    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.setFull(true);

        Util.clear();
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
    private boolean full = true;

    public boolean getFull(){
        return full;
    }

    public void setFull(boolean full){
        this.full = full;
    }

    public boolean drink(){
        if(!this.full){
            System.out.println("Empty");
            Util.sleep(500);
            return refill();
        }

        System.out.print("Drinking");

        for(int i = 0; i < 3; i++){
            System.out.print(".");
            Util.sleep(500);
        }

        System.out.println("\nEmpty");
        Util.sleep(500);
        return false;
    }

    public boolean refill(){
        if(this.full){
            System.out.println("Full");
            Util.sleep(500);
            return drink();
        }

        System.out.print("Refilling");

        for(int i = 0; i < 3; i++){
            System.out.print(".");
            Util.sleep(500);
        }

        System.out.println("\nFull");
        Util.sleep(500);
        return true;
    }
}