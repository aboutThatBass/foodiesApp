package edu.utsa.cs3443.calorieapp.controller;
import edu.utsa.cs3443.calorieapp.model.AuthService;
import edu.utsa.cs3443.calorieapp.model.User;
import edu.utsa.cs3443.calorieapp.model.UserRepository;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
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
    @FXML private Label emailLabel;
    /** Text field for entering the user's password. */
    @FXML private TextField passField;
    /** Text field for entering the user's age. */
    @FXML private TextField ageField;
    /** Text field for entering the user's current weight. */
    @FXML private TextField currentWeightField;
    /** Text field for entering the user's goal weight. */
    @FXML private TextField goalWeightField;
    /** Text field for entering the user's activity level. */
    @FXML private TextField calorieGoal;
    @FXML private TextField proteinGoal;
    @FXML private Label output;

    @FXML
    public void initialize(){
        User user = SceneController.getCurrentUser();

        nameField.setText(user.getName());
        emailLabel.setText(user.getEmail());
        passField.setText(user.getPassword());
        ageField.setText(String.valueOf(user.getAge()));
        currentWeightField.setText(String.valueOf(user.getCurrentWeight()));
        goalWeightField.setText(String.valueOf(user.getGoalWeight()));
        calorieGoal.setText(String.valueOf(user.getDailyCalorieGoal()));
        proteinGoal.setText(String.valueOf(user.getProteinGoal()));
    }

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
        String name = nameField.getText().trim();
        String password = passField.getText().trim();
        String ageText = ageField.getText().trim();
        String currentWeightText = currentWeightField.getText().trim();
        String goalWeightText = goalWeightField.getText().trim();
        String dailyCalorieText = calorieGoal.getText().trim();
        String dailyProteinText = proteinGoal.getText().trim();

        if (name.isEmpty() || password.isEmpty() ||
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
            User user = SceneController.getCurrentUser();
            user = auth.update(name,user.getEmail(), password, age, currentWeight, goalWeight, dailyCalories, dailyProtein);

            handleBack(event);
        } catch (NumberFormatException e) {
            output.setText("Please enter valid numbers for age, weight, calories, and protein.");
        } catch(IllegalArgumentException e){
            output.setText(e.getMessage());
        } catch(NullPointerException e){
            output.setText(e.getMessage());
        }
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
