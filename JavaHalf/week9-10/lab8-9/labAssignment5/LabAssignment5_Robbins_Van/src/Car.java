// Car class extends Vehicle and represents a car with specific behavior
public class Car extends Vehicle { // Subclass: Car is a subclass of Vehicle, Inheritance: Car inherits from Vehicle
    // Constructor initializes Car properties and sets engine cylinders based on fuel capacity
    public Car(String make, String model, int year, double fuelCapacity, double currentFuel, Engine engine) {
        super(make, model, year, fuelCapacity, currentFuel, engine); // Subclass: Calls Vehicle constructor
        engine.setCylinders(fuelCapacity, 2.3); // Set cylinders based on fuel capacity and ratio
    }

    // Override start method to provide car-specific behavior
    @Override
    public String start() {
        return ("The " + getMake() + " " + getModel() + " car starts smoothly.\n The " + getEngine().getCylinders() + " Cylinder Engine Starts."); // Polymorphism: Overrides Vehicle's start method
    }

    // Override stop method to provide car-specific behavior
    @Override
    public String stop() {
        return ("The " + getModel() + " car stops"); // Polymorphism: Overrides Vehicle's stop method
    }
}
