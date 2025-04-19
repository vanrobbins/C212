// Truck class extends Vehicle and represents a truck with specific behavior
public class Truck extends Vehicle { // Subclass: Truck is a subclass of Vehicle, Inheritance: Truck inherits from Vehicle

    // Constructor initializes Truck properties with miles
    public Truck(String make, String model, int year, int miles) {
        super(make, model, year, miles);
    }

    // Override toString method to provide truck-specific behavior
    @Override
    public String toString() {
        return "Truck-   Make: " + getMake() + "  Model: " + getModel() + "  Year: " + getYear() + "  Miles: " + getMiles();
    }
}



