package edu.utsa.cs3443.calorieapp;

import edu.utsa.cs3443.calorieapp.model.AuthService;
import edu.utsa.cs3443.calorieapp.model.MealManager;
import edu.utsa.cs3443.calorieapp.model.UserRepository;
import edu.utsa.cs3443.calorieapp.SceneController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        UserRepository userRepo = new UserRepository();
        AuthService authService = new AuthService(userRepo);
        MealManager mealManager = new MealManager();

        SceneController.setUserRepository(userRepo);
        SceneController.setAuthService(authService);
        SceneController.setMealManager(mealManager);
        SceneController.setPrimaryStage(stage);
        // Load the home screen first
        SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/home.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}

