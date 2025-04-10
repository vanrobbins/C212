// Main class to manage Tom's Garage and demonstrate polymorphism
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Vehicle[] tomVehicles; // Array to store vehicles
        int addToGarage = 1; // Flag to control vehicle addition
        int numVehicles = 0; // Counter for number of vehicles

        System.out.println("Welcome to Tom's Garage");
        tomVehicles = new Vehicle[100]; // Initialize garage with capacity for 100 vehicles

        // Loop to add vehicles to the garage
        while ((addToGarage == 1) && (numVehicles < tomVehicles.length)) {
            System.out.println("\nEnter details for a new vehicle.");
            System.out.print("Enter vehicle type (Car/Truck/Bike): ");
            String type = myScanner.nextLine();
            System.out.print("Enter Make: ");
            String make = myScanner.nextLine();
            System.out.print("Enter Model: ");
            String model = myScanner.nextLine();
            System.out.print("Enter Year: ");
            int year = myScanner.nextInt();
            myScanner.nextLine();
            System.out.print("Enter Fuel Capacity: ");
            int fuelCapacity = myScanner.nextInt();
            myScanner.nextLine();

            // Create vehicle object based on type
            if (type.equalsIgnoreCase("CAR")) {
                tomVehicles[numVehicles] = new Car(make, model, year, fuelCapacity, (Math.round((Math.random() * fuelCapacity) * 100.0) / 100.0), new Engine());
            } else if (type.equalsIgnoreCase("TRUCK")) {
                tomVehicles[numVehicles] = new Truck(make, model, year, fuelCapacity, (Math.round((Math.random() * fuelCapacity) * 100.0) / 100.0), new Engine());
            } else if (type.equalsIgnoreCase("BIKE")) {
                tomVehicles[numVehicles] = new Bike(make, model, year, fuelCapacity, (Math.round((Math.random() * fuelCapacity) * 100.0) / 100.0), new Engine());
            } else {
                tomVehicles[numVehicles] = new Vehicle(make, model, year, fuelCapacity, (Math.round((Math.random() * fuelCapacity) * 100.0) / 100.0), new Engine(fuelCapacity, 2.5));
            }
            numVehicles++;
            System.out.print("Do you want to enter another vehicle? (yes/no): ");
            String again = myScanner.nextLine();
            if (again.equalsIgnoreCase("YES")) {
                continue;
            } else {
                addToGarage = 0;
            }
        }

        // Display information about all vehicles in the garage
        System.out.println("\n--- Vehicle Information in Tom's Garage ---");
        for (int i = 0; i < numVehicles; i++) {
            System.out.println("\n--- Vehicle #" + (i + 1) + "---");
            System.out.printf("Make: %s\nModel: %s\nYear: %d\nEngine Type: %.0f Cylinder Engine\n",
                tomVehicles[i].getMake(),
                tomVehicles[i].getModel(),
                tomVehicles[i].getYear(),
                tomVehicles[i].getEngine().getCylinders());
        }

        // Start all vehicles
        System.out.println("\n---Starting All Vehicles---");
        for (int i = 0; i < numVehicles; i++) {
            System.out.println(tomVehicles[i].start() + ""); // Polymorphism: Calls the overridden start method of the specific subclass
        }

        // Stop all vehicles
        System.out.println("\n---Stopping All Vehicles---");
        for (int i = 0; i < numVehicles; i++) {
            System.out.println(tomVehicles[i].stop() + ""); // Polymorphism: Calls the overridden stop method of the specific subclass
        }

        // Refuel all vehicles
        System.out.println("\n---Refueling All Vehicles---");
        for (int i = 0; i < numVehicles; i++) {
            System.out.println(tomVehicles[i].refuel());
        }

        // Load cargo into all trucks
        System.out.println("\n---Loading Up Trucks---");
        for (int i = 0; i < numVehicles; i++) {
            if (tomVehicles[i] instanceof Truck) {
                System.out.println(((Truck) tomVehicles[i]).loadCargo());
            }
        }

        myScanner.close(); // Close the scanner
    }
}

