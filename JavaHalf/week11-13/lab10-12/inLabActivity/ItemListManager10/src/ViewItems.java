import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class ViewItems extends JPanel {
    private JList<String> garageList; // JList to display vehicles
    private DefaultListModel<String> listModel; // Model to manage the list data

    public ViewItems() {
        // Set up the panel
        TitledBorder viewVBorder = BorderFactory.createTitledBorder("Items"); // Add a titled border
        setLayout(new BorderLayout()); // Use BorderLayout for layout
        setBackground(Color.lightGray); // Set background color
        setBorder(viewVBorder); // Apply the border

        // Initialize the list model and JList
        listModel = new DefaultListModel<>(); // Create a DefaultListModel to store vehicle data
        garageList = new JList<>(listModel); // Create a JList to display the data

        // Create a button to delete selected vehicles
        JButton deleteVehicleButton = new JButton("Delete Selected Item");

        // Styling
        Color element = new Color(225, 225, 225); // Light gray color for elements
        garageList.setPreferredSize(new Dimension(448, 500)); // Set size of the list
        deleteVehicleButton.setBackground(element); // Button background color
        LineBorder line = new LineBorder(Color.BLACK, 1); // Black border
        EmptyBorder padding = new EmptyBorder(5, 15, 5, 15); // Padding for the button
        deleteVehicleButton.setBorder(new CompoundBorder(line, padding)); // Combine borders
        garageList.setBackground(element); // List background color
        garageList.setBorder(line); // List border

        // Add components to the panel
        add(new JScrollPane(garageList), BorderLayout.CENTER); // Add the list with a scroll pane
        add(deleteVehicleButton, BorderLayout.SOUTH); // Add the delete button at the bottom

        // Action listener for deleting selected vehicles
        ActionListener delete = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int selectedIndex = garageList.getSelectedIndex(); // Get the selected index
                if (selectedIndex != -1) { // Ensure an item is selected
                    listModel.remove(selectedIndex); // Remove the selected item from the list
                }
            }
        };

        // Attach the action listener to the delete button
        deleteVehicleButton.addActionListener(delete);
    }

    // Getter for the DefaultListModel
    public DefaultListModel<String> getListModel() {
        return listModel;
    }
}
