package edu.utsa.cs3443.calorieapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {

    private static Stage primaryStage;

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    public static void switchScene(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    SceneController.class.getResource(fxmlFile)
            );

            Scene scene = new Scene(loader.load());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Calorie Tracker");
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: Could not load FXML → " + fxmlFile);
        }
    }
}
