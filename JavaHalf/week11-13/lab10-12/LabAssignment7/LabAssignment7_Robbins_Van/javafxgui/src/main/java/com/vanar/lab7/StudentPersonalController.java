package com.vanar.lab7;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
public class StudentPersonalController {
    private TextField[] textFields;
    public void setName(String name){
        nameField.setText(name);
    }
    public void setAge(int age){
        ageField.setText(Integer.toString(age));
    }
    public void setGender(String gender){
        genderDrop.setValue(gender);
    }
    @FXML
    private Label ageError;

    @FXML
    private Tooltip ageErrorTooltip;

    @FXML
    private TextField ageField;

    @FXML
    private ComboBox<String> genderDrop;

    @FXML
    private TextField nameField;

    @FXML
    private Button nextBtn;

    @FXML
    private void initialize() {
        // Initialize the genderDropDown with values
        genderDrop.setItems(FXCollections.observableArrayList("Male", "Female", "Non-Binary", "Prefer not to disclose"));
        genderDrop.getSelectionModel().selectFirst(); // Optionally select the first item by default
        ageError.setOpacity(0);
        ageField.textProperty().addListener(new TextChangeListener(ageField,ageError,ageErrorTooltip,"Int",3,6,120 ));
        textFields = new TextField[]{ageField,nameField};
    }
    @FXML
    private void nextAction(ActionEvent event) throws IOException {
        Boolean add = true;
        if (!(ageError.getOpacity()==0)) {
            Alert a = new Alert(AlertType.ERROR,ageError.getText());
            a.show();
            add = false;
        }
        for (TextField textField : textFields) {
            if (textField.getText().isEmpty()) {
                Alert a = new Alert(AlertType.ERROR,"Error: A text field is empty");
                a.show();
                add = false;
                break;
            }
        }
        if (add) {
            Student newStudent = new Student(nameField.getText(), Integer.valueOf(ageField.getText()), genderDrop.getValue());
            StudentSchoolController.setStudent(newStudent);
            FXMLLoader studentSchoolScene = App.loader("studentSchool");
            App.setRoot(studentSchoolScene.load());
            App.setTitle("Student Information - School Details");
        }
    }
    
}
