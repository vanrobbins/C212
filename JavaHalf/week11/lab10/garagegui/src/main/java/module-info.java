module lab6.vanar {
    requires javafx.controls;
    requires javafx.fxml;

    opens lab6.vanar to javafx.fxml;
    exports lab6.vanar;
}
