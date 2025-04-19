package com.vanar.lab7;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

// Custom DocumentListener for real-time validation
class TextChangeListener implements ChangeListener<String> {
    private TextField textField; // The text field being monitored
    private Label errorLabel; // Label to display validation errors
    private Tooltip errorTooltip;
    private String type; // Expected type of input (e.g., String, Int)
    private int limit; // Maximum allowed length of the input
    private int min;
    private int max;

    public TextChangeListener(TextField textField, Label errorLabel, Tooltip errorTooltip, String type, int limit) {
        this.textField = textField;
        this.errorLabel = errorLabel;
        this.errorTooltip = errorTooltip;
        this.type = type;
        this.limit = limit;
        this.min = -1;
        this.max = -1;
    }

    public TextChangeListener(TextField textField, Label errorLabel, Tooltip errorTooltip, String type, int limit, int min, int max) {
        this.textField = textField;
        this.errorLabel = errorLabel;
        this.errorTooltip = errorTooltip;
        this.type = type;
        this.limit = limit;
        this.min = min;
        this.max = max;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        update();
    }

    // Validate the input and update the error label
    private void update() {
        Platform.runLater(() -> {
            String currentText = textField.getText(); // Get the current text
            VerifyTextEntry verifyTextEntry = new VerifyTextEntry(); // Create a verifier
            try {
                if (min == -1 && max == -1) {
                    verifyTextEntry.Verify(currentText, type, currentText.length(), limit); // Validate input
                    errorLabel.setOpacity(0); // Clear error message if valid
                    errorTooltip.setText(""); // Clear tooltip message
                } else {
                    verifyTextEntry.Verify(currentText, type, currentText.length(), limit, min, max); // Validate input
                    errorLabel.setOpacity(0); // Clear error message if valid
                    errorTooltip.setText(""); // Clear tooltip message
                }
            } catch (IllegalArgumentException e) {
                errorLabel.setOpacity(1); // Display error message
                errorLabel.setText("Error: " + e.getMessage());
                errorTooltip.setText(e.getMessage()); // Display tooltip message
            }
            if (currentText.length() == 0) { // Clear error if the field is empty
                errorLabel.setOpacity(0);
                errorTooltip.setText("");
            }
        });
    }
}
