public class Vehicle {
    private String type; // Vehicle type (e.g., Car, Truck, Bike)
    private String make; // Vehicle make
    private String model; // Vehicle model
    private int year; // Vehicle year
    private int miles; // Vehicle mileage

    // Constructor to initialize a vehicle
    public Vehicle(String make, String model, int year, int miles) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.miles = miles;
    }

    // Getters and setters for each field
    public String getMake() {
        return make;
    }

    public int getMiles() {
        return miles;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Override toString to display vehicle details
    @Override
    public String toString() {
        return "Make: " + make + "  Model: " + model + "  Year: " + year + "  Miles: " + miles;
    }
}
