// Vehicle class represents a generic vehicle with common properties and behaviors
public class Vehicle {
    private String make; // The manufacturer of the vehicle
    private String model; // The model of the vehicle
    private int year; // The year the vehicle was manufactured
    private double fuelCapacity; // The maximum fuel capacity of the vehicle
    private double currentFuel; // The current fuel level of the vehicle
    private Engine engine; // Composition: Engine object representing the vehicle's engine

    // Constructor initializes Vehicle properties
    public Vehicle(String make, String model, int year, double fuelCapacity, double currentFuel, Engine engine) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelCapacity = fuelCapacity;
        this.currentFuel = currentFuel;
        this.engine = engine; // Composition: Engine object is part of Vehicle
    }

    // Getter method for engine
    public Engine getEngine() {
        return engine;
    }

    // Setter method for make
    public void setMake(String make) {
        this.make = make;
    }

    // Getter method for make
    public String getMake() {
        return make;
    }

    // Setter method for model
    public void setModel(String model) {
        this.model = model;
    }

    // Getter method for model
    public String getModel() {
        return model;
    }

    // Setter method for year
    public void setYear(int year) {
        this.year = year;
    }

    // Getter method for year
    public int getYear() {
        return year;
    }

    // Setter method for fuel capacity
    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    // Getter method for fuel capacity
    public double getFuelCapacity() {
        return fuelCapacity;
    }

    // Setter method for current fuel level
    public void setCurrentFuel(double currentFuel) {
        this.currentFuel = currentFuel;
    }

    // Getter method for current fuel level
    public double getCurrentFuel() {
        return currentFuel;
    }

    // Start method provides default behavior for starting a vehicle
    public String start() {
        return "Vehicle is Starting\n"; // Polymorphism: Can be overridden by subclasses
    }

    // Stop method provides default behavior for stopping a vehicle
    public String stop() {
        return "Vehicle is Stopping\n"; // Polymorphism: Can be overridden by subclasses
    }

    // Refuel to full capacity
    public String refuel() {
        if (currentFuel < fuelCapacity) {
            double temp = fuelCapacity - currentFuel; // Calculate the amount of fuel needed to fill the tank
            this.currentFuel = fuelCapacity; // Set current fuel to full capacity
            return "The " + make + " " + model + " was refueled " + String.format("%.1f", temp) + " gallons!" + "\n It is fully fueled to " + fuelCapacity + " gallons.";
        } else {
            return "The " + make + " " + model + " is already fully fueled";
        }
    }

    // Refuel by a specific amount
    public String refuel(double amount) {
        if (currentFuel + amount <= fuelCapacity) {
            this.currentFuel += amount; // Add the specified amount to the current fuel level
            return "The " + make + " " + model + " was refueled " + String.format("%.1f", amount) + " gallons!" + "\n It is fueled to " + currentFuel + " out of " + fuelCapacity + " gallons.";
        } else if (currentFuel + amount > fuelCapacity) {
            double temp = fuelCapacity - currentFuel; // Calculate the amount of fuel needed to fill the tank
            this.currentFuel = fuelCapacity; // Set current fuel to full capacity
            return "The " + make + " " + model + " was refueled " + String.format("%.1f", temp) + " gallons!" + "\n It is fully fueled to " + fuelCapacity;
        } else {
            return "Vehicle is already at full capacity+\n";
        }
    }
}
