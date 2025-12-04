package edu.utsa.cs3443.calorieapp;

import edu.utsa.cs3443.calorieapp.manager.MealManager;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class Launcher extends Application {

    private static MealManager mealManager = new MealManager();

    @Override
    public void start(Stage stage) throws Exception {
        mealManager.loadMealsFromFile();
        SceneController.setMealManager(mealManager);
        // Give SceneController access to the primary stage
        SceneController.setPrimaryStage(stage);
        // Load the home screen first
        SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/home.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}

