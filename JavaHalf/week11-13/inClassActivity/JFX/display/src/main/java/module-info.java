module com.jfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.jfx to javafx.fxml;
    exports com.jfx;
}
