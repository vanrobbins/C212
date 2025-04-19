// Bike class extends Vehicle and represents a bike with specific behavior
public class Bike extends Vehicle { // Subclass: Bike is a subclass of Vehicle, Inheritance: Bike inherits from Vehicle
    // Constructor initializes Bike properties and sets engine cylinders based on fuel capacity
    public Bike(String make, String model, int year, int miles) {
        super(make, model, year, miles);
    }

    @Override
    public String toString() {
        return "Bike-   Make: " + getMake() + "  Model: " + getModel() + "  Year: " + getYear() + "  Miles: " + getMiles();
    }
}
