package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.model.MealManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for the "Delete Meal" screen. This class manages
 * user interactions related to finding and deleting meals by their ID.
 * It communicates with the {@link MealManager} to perform meal operations
 * and updates the UI accordingly.
 *
 * <p>The controller handles input validation, displays feedback messages,
 * and allows the user to navigate back to the previous screen.</p>
 */

public class DeleteMealController {

    /** Text field for entering the ID of the meal to find or delete. */
    @FXML
    private TextField idField;
    /** Text area for displaying output messages or meal information. */
    @FXML
    private TextArea outputArea;
    /** Button to trigger searching for a meal by ID. */
    @FXML
    private Button goButton;
    /** Button to trigger deletion of a meal by ID. */
    @FXML
    private Button deleteButton;
    /** Button to navigate back and close the current window. */
    @FXML
    private Button backButton;

    /** Reference to the application's shared meal manager. */
    private MealManager mealManager;

    /**
     * Initializes the controller by retrieving the shared
     * {@link MealManager} instance from {@link SceneController}.
     * This method is automatically called after loading
     * the FXML file.
     */

    public void initialize() {
        mealManager = SceneController.getMealManager();
    }
    /**
     * Handles the "Go" button action. Attempts to parse the meal ID
     * entered by the user, and displays information about the meal
     * in the output area. Invalid input is handled with an error message.
     *
     * @param event the action event triggered by clicking the Go button
     */

    @FXML
    private void handleGo(ActionEvent event) {
        try {
            int id = Integer.parseInt(idField.getText());
            //need to find meal by ID and return it
            outputArea.setText("Test");
        } catch (NumberFormatException e) {
            outputArea.setText("Invalid ID. Please enter a number.");
        }
    }

    /**
     * Handles the "Delete" button action. Attempts to parse the meal ID
     * entered by the user, deletes the corresponding meal from
     * {@link MealManager}, and displays a result message in the output area.
     * Invalid input is handled with an error message.
     *
     * @param event the action event triggered by clicking the Delete button
     */

    @FXML
    private void handleDelete(ActionEvent event) {
        try {
            int id = Integer.parseInt(idField.getText());
            String result = "Test";
            outputArea.setText(result);
        } catch (NumberFormatException e) {
            outputArea.setText("Invalid ID. Please enter a number.");
        }
    }

    /**
     * Handles the "Back" button action. Closes the current window and
     * returns to the previous screen.
     *
     * @param event the action event triggered by clicking the Back button
     */

    @FXML
    private void handleBack(ActionEvent event) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
}