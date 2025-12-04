package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.model.AuthService;
import edu.utsa.cs3443.calorieapp.model.MealManager;
import edu.utsa.cs3443.calorieapp.model.User;
import edu.utsa.cs3443.calorieapp.model.UserRepository;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
    private static MealManager mealManager;
    private static UserRepository userRepository;
    private static User currentUser;
    private static AuthService authService;

    public static UserRepository getUserRepository() {
        return userRepository;
    }

    public static void setUserRepository(UserRepository userRepository) {
        SceneController.userRepository = userRepository;
    }

    public static AuthService getAuthService() {
        return authService;
    }

    public static void setAuthService(AuthService authService) {
        SceneController.authService = authService;
    }

    public static void setCurrentUser(User u) {
        currentUser = u;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setMealManager(MealManager mm) {
        mealManager = mm;
    }

    public static MealManager getMealManager() {
        return mealManager;
    }

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
