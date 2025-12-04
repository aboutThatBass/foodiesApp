package edu.utsa.cs3443.calorieapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for the "Edit Meal" screen. This class manages
 * user interactions related to editing existing meals, including
 * updating meal information and navigating the UI.
 *
 * <p>The controller provides handlers for submitting changes, searching
 * for meals by criteria, and returning to the previous screen.</p>
 */

public class EditMealController {
    /** Text field for entering the meal's name. */
    @FXML private TextField foodNameField;
    /** Text field for entering the meal's calorie amount. */
    @FXML private TextField calField;
    /** Text field for entering the meal's date. */
    @FXML private TextField dateField;
    /** Text field for entering the meal's time. */
    @FXML private TextField timeField;
    /** Button to trigger searching or loading a meal to edit. */
    @FXML private Button goButton;

    /**
     * Handles the "Submit" button action to save edits made to a meal.
     * <p>
     * Currently, this method prints a placeholder message to the console.
     * Implementation should update the corresponding meal in the
     * {@link edu.utsa.cs3443.calorieapp.model.MealManager}.
     * </p>
     *
     * @param e the action event triggered by clicking the Submit button
     */
    @FXML
    public void handleSubmit(ActionEvent e) {
        // "Success" placeholder
        System.out.println("Test");
    }

    /**
     * Handles the "Go" button action to find or load a meal for editing.
     * <p>
     * Currently, this method prints a placeholder message to the console.
     * Implementation should retrieve the selected meal and populate
     * the form fields with its data.
     * </p>
     *
     * @param e the action event triggered by clicking the Go button
     */
    @FXML
    public void handleGo(ActionEvent e) {
        System.out.println("Test");
    }

    /**
     * Handles the "Back" button action to close the current window
     * and return to the previous screen.
     *
     * @param e the action event triggered by clicking the Back button
     */
    @FXML
    public void handleBack(ActionEvent e) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }
}
