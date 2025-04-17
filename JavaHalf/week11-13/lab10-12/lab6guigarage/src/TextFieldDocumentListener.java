import javax.swing.*;
import javax.swing.event.*;

// Custom DocumentListener for real-time validation
class TextFieldDocumentListener implements DocumentListener {
    private JTextField textField; // The text field being monitored
    private JLabel errorLabel; // Label to display validation errors
    private String type; // Expected type of input (e.g., String, Int)
    private int limit; // Maximum allowed length of the input

    public TextFieldDocumentListener(JTextField textField, JLabel errorLabel, String type, int limit) {
        this.textField = textField;
        this.errorLabel = errorLabel;
        this.type = type;
        this.limit = limit;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        update(errorLabel, type, limit); // Validate input on text insertion
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        update(errorLabel, type, limit); // Validate input on text removal
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // Not needed for plain text fields
    }

    // Validate the input and update the error label
    private void update(JLabel errorLabel, String validType, int lengthLimit) {
        SwingUtilities.invokeLater(() -> {
            String currentText = textField.getText(); // Get the current text
            VerifyTextEntry verifyTextEntry = new VerifyTextEntry(); // Create a verifier
            try {
                verifyTextEntry.Verify(currentText, validType, currentText.length(), lengthLimit); // Validate input
                errorLabel.setText(""); // Clear error message if valid
                errorLabel.setToolTipText("");
            } catch (IllegalArgumentException e) {
                errorLabel.setText("Hover For Error"); // Display error message
                errorLabel.setToolTipText(e.getMessage());
            }
            if (currentText.length() == 0) { // Clear error if the field is empty
                errorLabel.setText("");
                errorLabel.setToolTipText("");
            }
        });
    }
}
