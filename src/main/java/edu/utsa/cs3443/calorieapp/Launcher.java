package edu.utsa.cs3443.calorieapp;

import edu.utsa.cs3443.calorieapp.model.AuthService;
import edu.utsa.cs3443.calorieapp.model.MealManager;
import edu.utsa.cs3443.calorieapp.model.UserRepository;
import edu.utsa.cs3443.calorieapp.controller.SceneController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The {@code Launcher} class serves as the entry point for the Foodies
 * JavaFX application. It initializes core services such as the
 * {@link UserRepository}, {@link AuthService}, and {@link MealManager}, and
 * registers them with the {@link SceneController} for global access throughout
 * the application.
 *
 * <p>Once initialization is complete, this class loads the application's
 * primary window and displays the home screen UI.</p>
 */

public class Launcher extends Application {

    /**
     * Starts the JavaFX application by initializing the user repository,
     * authentication service, and meal manager, then registering them with the
     * {@link SceneController}. Finally, it loads and displays the home screen.
     *
     * @param stage the primary {@code Stage} provided by the JavaFX runtime
     * @throws Exception if a scene fails to load or initialization fails
     */

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

    /**
     * The application's main entry point. This method delegates to
     * {@link Application#launch(String...)} to start the application.
     *
     * @param args command-line arguments passed to the application
     */

    public static void main(String[] args) {
        launch();
    }
}

