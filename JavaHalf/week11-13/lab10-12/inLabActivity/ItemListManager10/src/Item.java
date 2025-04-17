public class Item {
    private String name; // Vehicle type (e.g., Car, Truck, Bike)
    private String description; // Vehicle make

    // Constructor to initialize a vehicle
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters and setters for each field
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // Override toString to display vehicle details
    @Override
    public String toString() {
        return "Name: " + name + "  Description: " + description;
    }
}
