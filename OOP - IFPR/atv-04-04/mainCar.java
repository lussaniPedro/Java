public class mainCar {
    public static void main(String[] args) {
        Car car = new Car();

        car.setLicensePlate("ABC-1234");
        car.setModel("Honda Civic");
        car.setYear(2022);
        car.setSpeed(0);
        car.setMaxFuel(100);
        car.setFuel(100);

        System.out.println(car.toString());
    }
}

class Car {
    private String licensePlate;
    private String model;
    private int year;
    private double speed;
    private double fuel;
    private double maxFuel;

    /* Getters */
    public String getLicensePlate(){
        return licensePlate;
    }

    public String getModel(){
        return model;
    }

    public int getYear(){
        return year;
    }

    public double getSpeed(){
        return speed;
    }

    public double getFuel(){
        return fuel;
    }

    public double getMaxFuel(){
        return maxFuel;
    }

    /* Setters */
    public void setLicensePlate(String licensePlate){
        this.licensePlate = licensePlate;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setYear(int year){
        if(year < 1886){
            System.out.println("Cars were not made before 1886.");
            System.exit(1);
        }

        this.year = year;
    }

    public void setSpeed(double speed){
        if(speed < 0){
            System.out.println("The speed cannot be negative.");
            System.exit(1);
        } else if(speed > 150){
            System.out.println("The maximum speed is 150.");
            System.exit(1);
        }

        this.speed = speed;
    }

    public void setFuel(double fuel){
        if(fuel > maxFuel){
            System.out.println("The amount of fuel is greater than the maximum amount of fuel.");
            System.exit(1);
        }

        this.fuel = fuel;
    }

    public void setMaxFuel(double maxFuel){
        this.maxFuel = maxFuel;
    }

    /* Methods */
    public void accelerate(double acceleration){
        if(fuel > 0){
            setSpeed(speed + (acceleration * 0.10));
            setFuel(fuel - (acceleration * 0.01));
        } else{
            System.out.println("The car has no fuel.");
            System.exit(1);
        }
    }

    public void brake(double deceleration){
        if(speed > 0){
            setSpeed(speed - (deceleration * 0.10));
        } else{
            System.out.println("The car is not moving.");
        }
    }

    public void refuel(double amount){
        if(amount > 0 && (fuel + amount) <= maxFuel){
            setFuel(fuel + amount);
        } else if(amount < 0){
            System.out.println("The amount of fuel cannot be negative.");
            System.exit(1);
        } else{
            System.out.println("The amount of fuel is greater than the maximum amount of fuel.");
            System.exit(1);
        }
    }

    @Override
    public String toString(){
        return "Car[" +
                "licensePlate='" + licensePlate + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", speed=" + speed +
                ", fuel=" + fuel +
                ", maxFuel=" + maxFuel +
                ']';
    }
}