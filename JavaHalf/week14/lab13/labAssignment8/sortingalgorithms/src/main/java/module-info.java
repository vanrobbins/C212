module vanar.lab8gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.swing;
    requires java.desktop;
    requires com.opencsv;
    opens vanar.lab8gui to javafx.fxml;
    exports vanar.lab8gui;
}
