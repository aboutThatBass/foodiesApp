package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.model.AuthService;
import edu.utsa.cs3443.calorieapp.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller responsible for handling user input and actions
 * related to creating a new user profile in the application.
 * <p>
 * This class collects data from the profile creation form, validates it,
 * and submits the information to the {@link AuthService} to register
 * a new {@link User}. If registration is successful, the user is redirected
 * to the login screen. If validation fails, appropriate error messages
 * are displayed in the {@code output} label.
 * </p>
 *
 * <p>
 * The controller also handles navigation back to the home screen.
 * </p>
 */

public class CreateProfileController {

    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private TextField passField;
    @FXML private TextField ageField;
    @FXML private TextField currentWeightField;
    @FXML private TextField goalWeightField;
    @FXML private TextField calorieGoalField;
    @FXML private TextField proteinGoalField;
    @FXML private Label output;


    /**
     * Handles the "Submit" action when the user attempts to create a new profile.
     * <p>
     * This method retrieves and validates all input fields. If any field is empty,
     * or if numeric values fail to parse, an error message is displayed.
     * </p>
     * <p>
     * Upon successful validation, the method attempts to register the user using
     * {@link AuthService#register(String, String, String, int, double, double, int, int)}.
     * If registration succeeds, the scene switches to the login screen. If the email
     * already exists or an exception occurs, an appropriate message is shown to the user.
     * </p>
     *
     * @param event the {@link ActionEvent} triggered by clicking the submit button
     */

    @FXML
    public void handleSubmit(ActionEvent event) {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String password = passField.getText().trim();
        String ageText = ageField.getText().trim();
        String currentWeightText = currentWeightField.getText().trim();
        String goalWeightText = goalWeightField.getText().trim();
        String dailyCalorieText = calorieGoalField.getText().trim();
        String dailyProteinText = proteinGoalField.getText().trim();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() ||
                ageText.isEmpty() || currentWeightText.isEmpty() ||
                goalWeightText.isEmpty() || dailyCalorieText.isEmpty() ||
                dailyProteinText.isEmpty())
        {
            output.setText("All fields must be filled.");
            return;
        }

        try{
            int age = Integer.parseInt(ageText);
            double currentWeight = Double.parseDouble(currentWeightText);
            double goalWeight = Double.parseDouble(goalWeightText);
            int dailyCalories = Integer.parseInt(dailyCalorieText);
            int dailyProtein = Integer.parseInt(dailyProteinText);
            AuthService auth = SceneController.getAuthService();
            User user = auth.register(name,email, password, age, currentWeight, goalWeight, dailyCalories, dailyProtein);
            if (user == null) {
                output.setText("An account with that email already exists");
                return;
            }
            SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/login.fxml");
        } catch (NumberFormatException e) {
            output.setText(e.getMessage());
        } catch(IllegalArgumentException e){
            output.setText(e.getMessage());
        } catch(NullPointerException e){
            output.setText(e.getMessage());
        }
    }
    /**
     * Handles the action of returning to the home screen.
     * <p>
     * This method switches the application's scene to the home layout,
     * allowing the user to navigate away from the profile creation page.
     * </p>
     *
     * @param event the {@link ActionEvent} triggered by clicking the back button
     */



    @FXML
    public void handleBack(ActionEvent event) {
        SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/home.fxml");
    }
}
