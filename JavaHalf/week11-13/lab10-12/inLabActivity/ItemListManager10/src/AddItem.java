import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class AddItem extends JPanel {
    // Labels for form fields
    private JLabel name = new JLabel("name:"); // Label for Item name
    private JLabel description = new JLabel("description:"); // Label for Item description
    // Error labels for validation feedback
    private JLabel nameError = new JLabel(""); // Error label for name input
    private JLabel descriptionError = new JLabel(""); // Error label for description input
    // Input fields
    private JTextField nameInput = new JTextField(); // Input field for Item name
    private JTextField descriptionInput = new JTextField(); // Input field for Item description

    // Buttons for actions
    private JButton addItemButton = new JButton("Add Item"); // Button to submit the form
    private JButton clearFieldButton = new JButton("Clear Fields"); // Button to clear all fields

    public AddItem(DefaultListModel<String> listdescription) {
        // Setting up the panel
        TitledBorder addVBorder = BorderFactory.createTitledBorder("Add Item"); // Add a titled border
        setLayout(new BorderLayout(5, 3)); // Use BorderLayout with spacing
        setBackground(Color.lightGray); // Set background color
        setBorder(addVBorder); // Apply the border

        // Styling input fields
        JTextField[] textFields = {nameInput, descriptionInput}; // Array of input fields
        JButton[] fieldButtons = {addItemButton, clearFieldButton}; // Array of buttons
        JLabel[] labelErrors = {nameError, descriptionError}; // Array of error labels
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


        // Content Panel
        JPanel contentPanel = new JPanel(); // Panel to hold form fields
        contentPanel.setLayout(new GridLayout(2, 3, 3, 3)); // Use GridLayout with spacing
        contentPanel.setBackground(Color.lightGray); // Set background color

        // Add components to the content panel

        contentPanel.add(name); // Add name label
        contentPanel.add(nameError); // Add error label for name
        contentPanel.add(nameInput); // Add input field for name

        contentPanel.add(description); // Add description label
        contentPanel.add(descriptionError); // Add error label for description
        contentPanel.add(descriptionInput); // Add input field for description


        // Button Panel
        JPanel buttonPanel = new JPanel(); // Panel to hold buttons
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5)); // Use FlowLayout with spacing
        buttonPanel.setBackground(Color.lightGray); // Set background color
        buttonPanel.add(addItemButton); // Add "Add Item" button
        buttonPanel.add(clearFieldButton); // Add "Clear Fields" button

        // Event Listeners
        // Clear Form event
        ActionListener clearField = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                for (JTextField textField : textFields) {
                    textField.setText(""); // Clear all text fields
                } // Reset dropdown to the first option
            }
        };
        clearFieldButton.addActionListener(clearField); // Attach the ActionListener to the button

        // Submit Form event
        ActionListener submit = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Boolean add = true;

                // Validate error labels
                for (JLabel label : labelErrors) {
                    if (!(label.getText().isEmpty())) {
                        JOptionPane.showMessageDialog(contentPanel, label.getToolTipText(), "Item List Manager", JOptionPane.ERROR_MESSAGE);
                        add = false;
                        break;
                    }
                }

                // Validate empty fields
                for (JTextField textField : textFields) {
                    if (textField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(contentPanel, "Error: A text field is empty", "Item List Manager", JOptionPane.ERROR_MESSAGE);
                        add = false;
                        break;
                    }
                }

                // Add Item if validation passes
                if (add) {
                    String nameTxt = nameInput.getText();
                    String descriptionTxt = descriptionInput.getText();
                    Item newItem = new Item(nameTxt, descriptionTxt);
                    listdescription.addElement(listdescription.getSize() + "." + " " + newItem.toString());
                    for (JTextField textField : textFields) {
                        textField.setText(""); // Clear all text fields
                    }
                }
            }
        };
        addItemButton.addActionListener(submit); // Attach the ActionListener to the button
        // Attach DocumentListeners to input fields
        nameInput.getDocument().addDocumentListener(new TextFieldDocumentListener(nameInput, nameError, "String", 16));
        descriptionInput.getDocument().addDocumentListener(new TextFieldDocumentListener(descriptionInput, descriptionError, "String", 25));

        // Add components to the panel
        add(contentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
