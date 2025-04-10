// Engine class represents the engine of a vehicle with configurable cylinders
public class Engine {
    private double cylinders; // Number of cylinders in the engine

    // Default constructor initializes engine with 6 cylinders
    public Engine() {
        this.cylinders = 6;
    }

    // Constructor initializes engine cylinders based on fuel capacity and ratio
    public Engine(double fuelCapacity, double ratio) {
        this.cylinders = Math.floor(fuelCapacity / ratio); // Composition: Engine depends on fuel capacity
    }

    // Constructor initializes engine with a specific number of cylinders
    public Engine(double cylinders) {
        this.cylinders = cylinders;
    }

    // Set the number of cylinders
    public void setCylinders(double cylinders) {
        this.cylinders = cylinders;
    }

    // Set cylinders based on fuel capacity and ratio
    public void setCylinders(double fuelCapacity, double ratio) {
        this.cylinders = Math.floor(fuelCapacity / ratio);
    }

    // Get the number of cylinders
    public double getCylinders() {
        return cylinders;
    }
}
