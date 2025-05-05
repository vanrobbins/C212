package vanar.lab8gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        App.stage = stage;
        scene = new Scene(loader("gui").load());
        stage.setTitle("Compare Sorting Algorithms");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    static void setRoot(Parent root) {
        scene.setRoot(root);
    }
    static void setTitle( String title) {
        stage.setTitle(title);
    }
    static FXMLLoader loader(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml+".fxml"));
        return fxmlLoader;
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}