package edu.utsa.cs3443.calorieapp.controller;
import edu.utsa.cs3443.calorieapp.model.User;
import edu.utsa.cs3443.calorieapp.model.UserRepository;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for the "User Profile" screen. This class manages
 * user interactions related to creating or editing a user profile.
 *
 * <p>The controller provides form fields for user data such as name, email,
 * password, age, current weight, goal weight, and activity level. It also
 * handles form submission and navigation back to the main screen.</p>
 */

public class UserController {
    /** Text field for entering the user's name. */
    @FXML private TextField nameField;
    /** Text field for entering the user's email address. */
    @FXML private TextField emailField;
    /** Text field for entering the user's password. */
    @FXML private TextField passField;
    /** Text field for entering the user's age. */
    @FXML private TextField ageField;
    /** Text field for entering the user's current weight. */
    @FXML private TextField currentWeightField;
    /** Text field for entering the user's goal weight. */
    @FXML private TextField goalWeightField;
    /** Text field for entering the user's activity level. */
    @FXML private TextField activityLevelField;

    /**
     * Handles the "Submit" button action for creating or updating a user profile.
     * <p>
     * Current implementation is a placeholder that prints "Test" to the console.
     * Real logic to save or validate user input can be added later.
     * </p>
     *
     * @param event the action event triggered by clicking the Submit button
     */
    @FXML
    public void handleSubmit(ActionEvent event) {
        System.out.println("Test");
        // later you can add real logic here
    }

    /**
     * Handles the "Back" button action by closing the current window
     * and returning to the main screen.
     *
     * @param event the action event triggered by clicking the Back button
     */

    @FXML
    public void handleBack(ActionEvent event) {
        // closes the popup window — returns to main screen automatically
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
