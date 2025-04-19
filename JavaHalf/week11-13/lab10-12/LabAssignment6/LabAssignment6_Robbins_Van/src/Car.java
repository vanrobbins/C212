// Car class extends Vehicle and represents a car with specific behavior
public class Car extends Vehicle { // Subclass: Car is a subclass of Vehicle, Inheritance: Car inherits from Vehicle
    // Constructor initializes Car properties and sets engine cylinders based on fuel capacity
    public Car(String make, String model, int year, int miles) {
        super(make, model, year, miles);
    }


    @Override
    public String toString() {
        return "Car-   Make: " + getMake() + "  Model: " + getModel() + "  Year: " + getYear() + "  Miles: " + getMiles();
    }
}
