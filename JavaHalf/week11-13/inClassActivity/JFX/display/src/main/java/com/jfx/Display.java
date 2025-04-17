package com.jfx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Display extends Application {
   private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
      Scene scene = new Scene(loadFXML()); // attach scene graph to scene
      stage.setTitle("Display"); // displayed in window's title bar
      stage.setScene(scene); // attach scene to stage
      stage.show(); // display the stage
   }
   static void setRoot(String fxml) throws IOException {
      scene.setRoot(loadFXML());
   }
   private static Parent loadFXML() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Display.class.getResource("Display.fxml"));
        return fxmlLoader.load();
    }
   
   public static void main(String[] args) {
      // create a TipCalculator object and call its start method
      launch(args); 
   }
}
