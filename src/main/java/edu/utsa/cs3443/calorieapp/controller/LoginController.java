package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.model.AuthService;
import edu.utsa.cs3443.calorieapp.model.MealManager;
import edu.utsa.cs3443.calorieapp.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;


/**
 * Controller responsible for managing user login interactions within the application.
 * <p>
 * This class handles authentication through the {@link AuthService}, updates the
 * current user in the {@link SceneController}, loads meal data for the authenticated
 * user, and navigates between login-related screens. It also manages transitions
 * to the registration and home screens.
 * </p>
 */
public class LoginController {
    /** Button used to submit the login form. */
    @FXML private Button submitButton;
    /** Button used to navigate back to the home screen. */
    @FXML private Button backButton;
    /** Text field where the user enters their email or username. */
    @FXML private TextField usernameField;
    /** Password field where the user enters their account password. */
    @FXML private PasswordField passwordField;
    /** Label used to display status messages or login errors. */
    @FXML private Label output;



    /**
     * Handles the submission of login credentials entered by the user.
     * <p>
     * The method retrieves the email and password, attempts to authenticate
     * via {@link AuthService#login(String, String)}, and if successful:
     * <ul>
     *   <li>sets the authenticated user in {@link SceneController},</li>
     *   <li>configures the {@link MealManager} for the user,</li>
     *   <li>loads the user's meal data from file, and</li>
     *   <li>switches to the main application screen.</li>
     * </ul>
     * If authentication fails, an error message is displayed in {@code output}.
     * </p>
     *
     * @param event the {@link ActionEvent} triggered when the user clicks the submit button
     * @throws IOException if an error occurs while switching scenes or loading meal data
     */

    @FXML
    public void handleSubmit(ActionEvent event) throws IOException {
        String email = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        AuthService auth = SceneController.getAuthService();
        User user = auth.login(email, password);

        if (user == null) {
            output.setText("Invalid login");
            return;
        }

        SceneController.setCurrentUser(user);

        MealManager mm = SceneController.getMealManager();
        mm.setFilePath("data/" + email + "_MealTracker.csv");
        mm.loadMealsFromFile(mm.getFilePath());

        SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/main-screen-view.fxml");
    }

    /**
     * Switches the scene to the login screen.
     * <p>
     * Typically used when the user navigates from the home screen back
     * to the login form.
     * </p>
     *
     * @param e the event triggered by the login navigation button
     */

    @FXML
    public void handleLogin(ActionEvent e) {
        System.out.println("Login → Main Menu");
        SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/login.fxml");
    }

    /**
     * Navigates the user from the home or login screen to the profile
     * creation screen.
     *
     * @param e the {@link ActionEvent} triggered when clicking the Register button
     */

    @FXML
    public void handleRegister(ActionEvent e) {
        System.out.println("Home → Create Profile");
        SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/create_profile.fxml");
    }

    /**
     * Returns the user to the home screen.
     *
     * @param actionEvent the event triggered by the Back button
     */

    public void handleBack(ActionEvent actionEvent) {
        SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/home.fxml");
    }
}
