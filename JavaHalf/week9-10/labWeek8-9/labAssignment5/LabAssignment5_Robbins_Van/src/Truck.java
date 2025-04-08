// Truck class extends Vehicle and represents a truck with specific behavior
public class Truck extends Vehicle { // Subclass: Truck is a subclass of Vehicle, Inheritance: Truck inherits from Vehicle
    private int cargoCapacity; // Maximum cargo capacity
    private int cargo; // Current cargo weight

    // Constructor initializes Truck properties and sets engine cylinders and cargo capacity
    public Truck(String make, String model, int year, double fuelCapacity, double currentFuel, Engine engine) {
        super(make, model, year, fuelCapacity, currentFuel, engine); // Subclass: Calls Vehicle constructor
        if (fuelCapacity / 2.5 > 10) {
            engine.setCylinders(8); // Set engine to 8 cylinders if condition is met
        } else {
            engine.setCylinders(fuelCapacity, 2.5); // Set cylinders based on fuel capacity and ratio
        }
        this.cargoCapacity = (int) (fuelCapacity * 25); // Calculate cargo capacity
        this.cargo = 0; // Initialize cargo to 0
    }

    // Override start method to provide truck-specific behavior
    @Override
    public String start() {
        return ("The " + getMake() + " " + getModel() + " truck starts with a heavy roar\n The " + getEngine().getCylinders() + " Cylinder Engine Starts."); // Polymorphism: Overrides Vehicle's start method
    }

    // Override stop method to provide truck-specific behavior
    @Override
    public String stop() {
        return ("The " + getModel() + " truck stops *gurgleee*"); // Polymorphism: Overrides Vehicle's stop method
    }

    // Getter for current cargo weight
    public int getCargo() {
        return cargo;
    }

    // Setter for current cargo weight
    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    // Getter for maximum cargo capacity
    public int getCargoCapacity() {
        return cargoCapacity;
    }

    // Setter for maximum cargo capacity
    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    // Load cargo with a specific weight
    public String loadCargo(int cargoWeight) {
        if (cargoWeight + cargo <= cargoCapacity) {
            cargo += cargoWeight; // Add cargo weight to current cargo
            if (cargo == cargoCapacity) {
                return "The " + getModel() + " is At Cargo Capacity";
            } else {
                return "Tom thinks you can load up " + (cargoCapacity - cargo) + " more lbs in the " + getModel();
            }
        } else {
            return "Tom thinks the truck will be overloaded.\nHe thinks " + (cargoCapacity - cargo) + " more lbs is the max the " + getModel() + " can carry";
        }
    }

    // Fully load the truck to its cargo capacity
    public String loadCargo() {
        if (cargo == cargoCapacity) {
            return "The " + getModel() + " is already At Cargo Capacity";
        } else {
            cargo = cargoCapacity; // Set cargo to maximum capacity
            return "The " + getModel() + " is fully loaded to " + cargoCapacity + " lbs";
        }
    }
}
