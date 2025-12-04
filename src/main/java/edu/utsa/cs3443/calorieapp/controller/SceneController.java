package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.model.AuthService;
import edu.utsa.cs3443.calorieapp.model.MealManager;
import edu.utsa.cs3443.calorieapp.model.User;
import edu.utsa.cs3443.calorieapp.model.UserRepository;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Central controller class for managing scene navigation and shared
 * application state in the calorie tracker application.
 *
 * <p>This class provides static access to key objects such as the current
 * user, the meal manager, the user repository, and the authentication
 * service. It also allows switching between different FXML scenes.</p>
 */

public class SceneController {

    /** Reference to the shared MealManager instance. */
    private static MealManager mealManager;
    /** Reference to the shared UserRepository instance. */
    private static UserRepository userRepository;
    /** The currently logged-in user. */
    private static User currentUser;
    /** Reference to the shared AuthService instance. */
    private static AuthService authService;

    /**
     * Gets the shared UserRepository instance.
     *
     * @return the UserRepository
     */
    public static UserRepository getUserRepository() {
        return userRepository;
    }

    /**
     * Sets the shared UserRepository instance.
     *
     * @param userRepository the UserRepository to set
     */
    public static void setUserRepository(UserRepository userRepository) {
        SceneController.userRepository = userRepository;
    }

    /**
     * Gets the shared AuthService instance.
     *
     * @return the AuthService
     */
    public static AuthService getAuthService() {
        return authService;
    }

    /**
     * Sets the shared AuthService instance.
     *
     * @param authService the AuthService to set
     */
    public static void setAuthService(AuthService authService) {
        SceneController.authService = authService;
    }

    /**
     * Sets the currently logged-in user.
     *
     * @param u the current User
     */
    public static void setCurrentUser(User u) {
        currentUser = u;
    }

    /**
     * Gets the currently logged-in user.
     *
     * @return the current User
     */

    public static User getCurrentUser() {
        return currentUser;
    }

    /**
     * Sets the shared MealManager instance.
     *
     * @param mm the MealManager to set
     */

    public static void setMealManager(MealManager mm) {
        mealManager = mm;
    }


    /**
     * Gets the shared MealManager instance.
     *
     * @return the MealManager
     */
    public static MealManager getMealManager() {
        return mealManager;
    }


    private static Stage primaryStage;

    /**
     * Sets the primary JavaFX stage used for scene switching.
     *
     * @param stage the primary Stage
     */

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    /**
     * Switches the current scene to the specified FXML file.
     *
     * <p>This method loads the FXML resource, sets it as the scene
     * of the primary stage, sets the window title to "Calorie Tracker",
     * and displays it. Any errors during loading are printed to the console.</p>
     *
     * @param fxmlFile the path to the FXML file to load
     */
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
