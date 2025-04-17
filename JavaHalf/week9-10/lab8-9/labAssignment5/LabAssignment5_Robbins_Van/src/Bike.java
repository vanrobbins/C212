// Bike class extends Vehicle and represents a bike with specific behavior
public class Bike extends Vehicle { // Subclass: Bike is a subclass of Vehicle, Inheritance: Bike inherits from Vehicle
    // Constructor initializes Bike properties and sets engine cylinders based on fuel capacity
    public Bike(String make, String model, int year, double fuelCapacity, double currentFuel, Engine engine) {
        super(make, model, year, fuelCapacity, currentFuel, engine); // Subclass: Calls Vehicle constructor
        if (fuelCapacity / 2 > 4) {
            engine.setCylinders(2); // Set engine to 2 cylinders if condition is met
        } else {
            engine.setCylinders(fuelCapacity, 2); // Set cylinders based on fuel capacity and ratio
        }
    }

    // Override start method to provide bike-specific behavior
    @Override
    public String start() {
        return ("The " + getMake() + " " + getModel() + " bike starts with a vroom.\n The " + getEngine().getCylinders() + " Cylinder Engine Starts."); // Polymorphism: Overrides Vehicle's start method
    }

    // Override stop method to provide bike-specific behavior
    @Override
    public String stop() {
        return ("The " + getModel() + " bike stops *tink tink tink*"); // Polymorphism: Overrides Vehicle's stop method
    }
}
