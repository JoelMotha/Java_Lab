class Car extends Vehicle {
    int speed;

    public Car(String model, int speed) {
        this.model = model; 
        this.speed = speed;
    }

    public void startEngine() {
        System.out.println("Car engine started");     }

    public void drive() {
        System.out.println("Car is driving at speed: " + speed);
    }
}
public static void main(String[] args) {
    Vehicle vehicle = new Vehicle("Sedan");
    vehicle.startEngine();

    Car car = new Car("Sedan", 60);
    car.startEngine();
    car.drive();
}