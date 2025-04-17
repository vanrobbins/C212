import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DisplayController {

    @FXML
    private Label messageLabel;

    @FXML
    private TextField messageText;

    @FXML
    private Button showButton;

    @FXML
    void showButtonPressed() {
        //messageText.setText("Enter your name");
        String inputText = messageText.getText();
        messageLabel.setText(inputText);
    }
    
    public void initialize() {
        messageText.setText("Enter your name");
        messageLabel.setText("Your name will appear here");
    }
    
    

}
