package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.model.AuthService;
import edu.utsa.cs3443.calorieapp.model.MealManager;
import edu.utsa.cs3443.calorieapp.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Controller class for the login screen of the calorie tracker application.
 * This class handles user interactions for logging in, navigating to
 * registration, and initializing user-specific data such as meal tracking.
 *
 * <p>It communicates with the {@link AuthService} for authentication
 * and the {@link MealManager} for loading the current user's meals.</p>
 */

public class LoginController {



    /** Button used to submit login credentials. */
    @FXML private Button submitButton;
    /** Text field for entering the user's email address. */
    @FXML private TextField usernameField;
    /** Password field for entering the user's password. */
    @FXML private PasswordField passwordField;

    /**
     * Handles the "Submit" button action to log in the user.
     * <p>
     * This method retrieves the email and password from the input fields,
     * validates the credentials using {@link AuthService#login(String, String)},
     * sets the current user in {@link SceneController}, and loads
     * the user's meal data via {@link MealManager}.
     * </p>
     *
     * @param event the action event triggered by clicking the Submit button
     * @throws IOException if an error occurs while loading the next scene
     */

    @FXML
    public void handleSubmit(ActionEvent event) throws IOException {
        String email = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        AuthService auth = SceneController.getAuthService();
        User user = auth.login(email, password);

        if (user == null) {
            System.out.println("Invalid login.");
            return;
        }

        SceneController.setCurrentUser(user);

        MealManager mm = SceneController.getMealManager();
        mm.setFilePath("data/" + email + "_MealTracker.csv");
        mm.loadMealsFromFile(mm.getFilePath());

        SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/main-screen-view.fxml");
    }

    /**
     * Handles navigation to the login screen.
     * <p>
     * Currently prints a debug message and switches the scene to the login view.
     * </p>
     *
     * @param e the action event triggered by user action
     */

    @FXML
    public void handleLogin(ActionEvent e) {
        System.out.println("Login → Main Menu");
        SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/login.fxml");
    }


    /**
     * Handles navigation to the registration (create profile) screen.
     * <p>
     * Currently prints a debug message and switches the scene to the registration view.
     * </p>
     *
     * @param e the action event triggered by user action
     */

    @FXML
    public void handleRegister(ActionEvent e) {
        System.out.println("Home → Create Profile");
        SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/create_profile.fxml");
    }
}
