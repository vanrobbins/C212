import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class App extends JFrame {
    public App() {
        super("Tom's Garage"); // Set the title of the application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application on exit
        setResizable(false); // Disable resizing
        setSize(500, 500); // Set the size of the window
        setLocationRelativeTo(null); // Center the window on the screen

        // Content Pane
        JPanel contentPanel = new JPanel(); // Main content panel
        contentPanel.setLayout(new GridLayout(2, 1, 10, 4)); // Use GridLayout with 2 rows and 1 column
        contentPanel.setBackground(Color.gray); // Set the background color of the window
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); // Add padding around the content panel
        setContentPane(contentPanel); // Set the content panel as the main container

        // Create and add panels
        ViewVehicles viewVPanel = new ViewVehicles(); // Panel for viewing vehicles
        AddVehicles addVPanel = new AddVehicles(viewVPanel.getListModel()); // Panel for adding vehicles
        contentPanel.add(addVPanel); // Add the "Add Vehicles" panel to the first row
        contentPanel.add(viewVPanel); // Add the "View Vehicles" panel to the second row

        setVisible(true); // Make the window visible
    }

    public static void main(String[] args) {
        new App();
    }
}
