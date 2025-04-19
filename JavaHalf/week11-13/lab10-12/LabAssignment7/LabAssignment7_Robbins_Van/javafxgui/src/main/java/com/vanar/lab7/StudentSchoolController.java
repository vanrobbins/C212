package com.vanar.lab7;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.collections.FXCollections;
public class StudentSchoolController {
    private TextField[] textFields;
    private static Student tempStudent;
    private FileChooser fileSave;
    public  static void setStudent(Student personalInfoStudent){
        tempStudent=personalInfoStudent;
    };
    @FXML
    private Button saveBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Label gpaError;

    @FXML
    private Tooltip gpaErrorTooltip;

    @FXML
    private TextField gpaField;
    
    @FXML
    private ComboBox<String> gradeDrop;

    @FXML
    private TextField majorField;
    @FXML
    private void initialize() {
        // Initialize the genderDropDown with values
        gradeDrop.setItems(FXCollections.observableArrayList("Freshman","Sophomore","Junior","Senior","Graduate"));
        gradeDrop.getSelectionModel().selectFirst(); // Optionally select the first item by default
        gpaError.setOpacity(0);
        gpaField.textProperty().addListener(new TextChangeListener(gpaField,gpaError,gpaErrorTooltip,"Double",5,0,5));
        textFields = new TextField[]{gpaField, majorField};
    }
    @FXML
    void backAction(ActionEvent event) throws IOException {
        FXMLLoader loader = App.loader("studentPersonal");
        Parent root = loader.load(); // Ensure the FXML file is loaded
        App.setRoot(root); // Set the loaded root
        App.setTitle("Student Information - Personal Details");
        StudentPersonalController personalController = loader.getController();
        personalController.setName(tempStudent.getName());
        personalController.setAge(tempStudent.getAge());
        personalController.setGender(tempStudent.getGender());
    }

    @FXML
    private void saveAction(ActionEvent event) throws IOException {
        Boolean add = true;
        if (!(gpaError.getOpacity()==0)) {
            Alert a = new Alert(AlertType.ERROR,gpaError.getText());
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
            tempStudent.setGpa(Double.valueOf(gpaField.getText()));
            tempStudent.setGrade(gradeDrop.getValue());
            tempStudent.setMajor(majorField.getText());
            //File Stuff
            fileSave = new FileChooser();
            fileSave.setInitialFileName("Student_"+tempStudent.getName()+".txt");
            fileSave.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt*"));
            Stage stage = (Stage) backBtn.getScene().getWindow();
            File file = fileSave.showSaveDialog(stage);
                if (file != null) {
                    try{
                        file.createNewFile();
                        WriteStuToFile.writeStudent(file, tempStudent);
                        System.out.println("File Saved");
                        Alert a = new Alert(AlertType.CONFIRMATION,"File Successfully Saved");
                        a.show();
                    }
                    catch(IOException e){
                        System.out.println("An error occurred.");
                    }
                }
            System.out.println(tempStudent.toString());
        }
    }

}
