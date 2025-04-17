import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class AddVehicles extends JPanel {
    // Labels for form fields
    private JLabel type = new JLabel("Type:"); // Label for vehicle type
    private JLabel make = new JLabel("Make:"); // Label for vehicle make
    private JLabel model = new JLabel("Model:"); // Label for vehicle model
    private JLabel year = new JLabel("Year:"); // Label for vehicle year
    private JLabel mileage = new JLabel("Mileage:"); // Label for vehicle mileage

    // Error labels for validation feedback
    private JLabel makeError = new JLabel(""); // Error label for make input
    private JLabel modelError = new JLabel(""); // Error label for model input
    private JLabel yearError = new JLabel(""); // Error label for year input
    private JLabel mileageError = new JLabel(""); // Error label for mileage input

    // Input fields
    private String[] typesVehicles = {"Car", "Truck", "Bike"}; // Dropdown options for vehicle type
    private JComboBox<String> typeSelect = new JComboBox<>(typesVehicles); // Dropdown for vehicle type
    private JTextField makeInput = new JTextField(); // Input field for vehicle make
    private JTextField modelInput = new JTextField(); // Input field for vehicle model
    private JTextField yearInput = new JTextField(); // Input field for vehicle year
    private JTextField mileageInput = new JTextField(); // Input field for vehicle mileage

    // Buttons for actions
    private JButton addVehicleButton = new JButton("Add Vehicle"); // Button to submit the form
    private JButton clearFieldButton = new JButton("Clear Fields"); // Button to clear all fields

    public AddVehicles(DefaultListModel<String> listModel) {
        // Setting up the panel
        TitledBorder addVBorder = BorderFactory.createTitledBorder("Add Vehicle"); // Add a titled border
        setLayout(new BorderLayout(5, 3)); // Use BorderLayout with spacing
        setBackground(Color.lightGray); // Set background color
        setBorder(addVBorder); // Apply the border

        // Styling input fields
        JTextField[] textFields = {makeInput, modelInput, yearInput, mileageInput}; // Array of input fields
        JButton[] fieldButtons = {addVehicleButton, clearFieldButton}; // Array of buttons
        JLabel[] labelErrors = {makeError, modelError, yearError, mileageError}; // Array of error labels
        LineBorder line = new LineBorder(Color.BLACK, 1); // Black border for components
        EmptyBorder padding = new EmptyBorder(5, 15, 5, 15); // Padding for buttons
        CompoundBorder buttonBorder = new CompoundBorder(line, padding); // Combined border for buttons

        // Apply styles to input fields
        for (JTextField textField : textFields) {
            textField.setBackground(new Color(225, 225, 225)); // Light gray background
            textField.setBorder(new LineBorder(Color.BLACK, 1)); // Black border
            textField.setFont(new Font("Roboto", Font.PLAIN, 12)); // Font style
            textField.setColumns(16); // Set column width
        }

        // Apply styles to buttons
        for (JButton button : fieldButtons) {
            button.setBackground(new Color(225, 225, 225)); // Light gray background
            button.setBorder(buttonBorder); // Black border
        }

        // Apply styles to error labels
        for (int i = 0; i < textFields.length; i++) {
            labelErrors[i].setLabelFor(textFields[i]); // Associate error label with input field
            labelErrors[i].setForeground(Color.red); // Set error label color
        }

        // Style the dropdown
        typeSelect.setBackground(new Color(225, 225, 225)); // Dropdown background color
        typeSelect.setBorder(new LineBorder(Color.black, 1)); // Dropdown border
        typeSelect.setFocusable(false); // Disable focus outline

        // Content Panel
        JPanel contentPanel = new JPanel(); // Panel to hold form fields
        contentPanel.setLayout(new GridLayout(5, 3, 3, 3)); // Use GridLayout with spacing
        contentPanel.setBackground(Color.lightGray); // Set background color

        // Add components to the content panel
        contentPanel.add(type); // Add type label
        contentPanel.add(new JLabel()); // Empty cell for alignment
        contentPanel.add(typeSelect); // Add dropdown for type

        contentPanel.add(make); // Add make label
        contentPanel.add(makeError); // Add error label for make
        contentPanel.add(makeInput); // Add input field for make

        contentPanel.add(model); // Add model label
        contentPanel.add(modelError); // Add error label for model
        contentPanel.add(modelInput); // Add input field for model

        contentPanel.add(year); // Add year label
        contentPanel.add(yearError); // Add error label for year
        contentPanel.add(yearInput); // Add input field for year

        contentPanel.add(mileage); // Add mileage label
        contentPanel.add(mileageError); // Add error label for mileage
        contentPanel.add(mileageInput); // Add input field for mileage

        // Button Panel
        JPanel buttonPanel = new JPanel(); // Panel to hold buttons
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5)); // Use FlowLayout with spacing
        buttonPanel.setBackground(Color.lightGray); // Set background color
        buttonPanel.add(addVehicleButton); // Add "Add Vehicle" button
        buttonPanel.add(clearFieldButton); // Add "Clear Fields" button

        // Event Listeners
        // Clear Form event
        ActionListener clearField = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                for (JTextField textField : textFields) {
                    textField.setText(""); // Clear all text fields
                }
                typeSelect.setSelectedIndex(0); // Reset dropdown to the first option
            }
        };

        // Submit Form event
        ActionListener submit = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Boolean add = true;

                // Validate error labels
                for (JLabel label : labelErrors) {
                    if (!(label.getText().isEmpty())) {
                        JOptionPane.showMessageDialog(contentPanel, label.getToolTipText(), "Tom's Garage", JOptionPane.ERROR_MESSAGE);
                        add = false;
                        break;
                    }
                }

                // Validate empty fields
                for (JTextField textField : textFields) {
                    if (textField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(contentPanel, "Error: A text field is empty", "Tom's Garage", JOptionPane.ERROR_MESSAGE);
                        add = false;
                        break;
                    }
                }

                // Add vehicle if validation passes
                if (add) {
                    String selectedType = (String) typeSelect.getSelectedItem();
                    String makeTxt = makeInput.getText();
                    String modelTxt = modelInput.getText();
                    int yearInt = Integer.valueOf(yearInput.getText());
                    int mileageInt = Integer.valueOf(mileageInput.getText());
                    Vehicle newVehicle = new Vehicle(selectedType, makeTxt, modelTxt, yearInt, mileageInt);
                    listModel.addElement(listModel.getSize() + "." + " " + newVehicle.toString());
                    for (JTextField textField : textFields) {
                        textField.setText(""); // Clear all text fields
                    }
                    typeSelect.setSelectedIndex(0);
                }
            }
        };

        // Attach DocumentListeners to input fields
        makeInput.getDocument().addDocumentListener(new TextFieldDocumentListener(makeInput, makeError, "String", 16));
        modelInput.getDocument().addDocumentListener(new TextFieldDocumentListener(modelInput, modelError, "String", 16));
        yearInput.getDocument().addDocumentListener(new TextFieldDocumentListener(yearInput, yearError, "Int", 4));
        mileageInput.getDocument().addDocumentListener(new TextFieldDocumentListener(mileageInput, mileageError, "Int", 7));
        // Attach action listeners to buttons
        clearFieldButton.addActionListener(clearField);
        addVehicleButton.addActionListener(submit);

        // Add components to the panel
        add(contentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
