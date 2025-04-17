module com.vanar.lab7 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.vanar.lab7 to javafx.fxml;
    exports com.vanar.lab7;
}
