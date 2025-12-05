package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.model.Meal;
import edu.utsa.cs3443.calorieapp.model.MealManager;
import edu.utsa.cs3443.calorieapp.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller class for the "Edit Meal" screen. This class manages
 * user interactions related to editing existing meals, including
 * updating meal information and navigating the UI.
 *
 * <p>The controller provides handlers for submitting changes, searching
 * for meals by criteria, and returning to the previous screen.</p>
 */

public class EditMealController {

    private Meal currentMeal = null;
    private MealManager mealManager;
    /** Text field for entering the meal's name. */
    @FXML private TextField foodNameField;
    /** Text field for entering the meal's calorie amount. */
    @FXML private TextField calField;
    /** Text field for entering the meal's protein amount. */
    @FXML private TextField proteinField;
    /** Text field for entering the meal's time. */
    @FXML private TextField timeField;
    /** Text field for entering the meal's ID */
    @FXML private TextField idField;
    /** Text field for choosing the date */
    @FXML private DatePicker datePicker;
    /** Label used to display error messages or status updates to the user. */
    @FXML private Label output;
    /** Button that navigates the user forward to the next screen or action. */
    @FXML private Button goButton;
    /** Button that submits the user's input from the current form. */
    @FXML private Button submitButton;
    /** Button that returns the user to the previous screen. */
    @FXML private Button backButton;

    /**
     * Initializes the controller after its FXML fields have been loaded.
     * <p>
     * This method retrieves the shared {@link MealManager} instance and the
     * currently logged-in {@link User} from the {@link SceneController}.
     * It prepares the controller for use before the user interacts with the UI.
     * </p>
     */
    @FXML public void initialize(){
        mealManager = SceneController.getMealManager();
        User user = SceneController.getCurrentUser();
    }

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
        if(currentMeal == null){
            output.setText("No meal selected. Please search for an ID first.");
            return;
        }

        // Validate name
        String name = foodNameField.getText().trim();
        if (name.isEmpty()) {
            output.setText("Food name cannot be empty.");
            return;
        }

        // Validate time
        String time = timeField.getText().trim();
        if (time.isEmpty()) {
            output.setText("Time cannot be empty.");
            return;
        }

        // Validate date
        if (datePicker.getValue() == null) {
            output.setText("Please select a valid date.");
            return;
        }

        // Validate protein and calories using helper method
        Integer calories = parsePositiveIntField(calField, "Calories");
        if (calories == null) return;
        Integer protein = parsePositiveIntField(proteinField, "Protein");
        if (protein == null) return;

        try {
            currentMeal.setName(foodNameField.getText());
            currentMeal.setCalories(calories);
            currentMeal.setProtein(protein);
            currentMeal.setTime(timeField.getText());
            currentMeal.setDate(datePicker.getValue());
        } catch (Exception ex) {
            output.setText("Invalid input. Check your fields.");
            return;
        }

        try {
            mealManager.saveDataToFile();
            output.setText("Meal updated successfully!");
        } catch (IOException ex) {
            output.setText("Failed to save changes.");
        }
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
        String raw = idField.getText().trim();

        if(raw.isEmpty()){
            output.setText("Please enter a valid ID");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idField.getText());
        } catch (NumberFormatException ex) {
            output.setText("ID must be a whole number.");
            return;
        }
        Meal found = null;

        for(Meal m : mealManager.getMeals()){
            if(m.getId() == id){
                found = m;
                break;
                }
        }

        if(found == null){
            output.setText("No meal with that ID was found.");
            return;
        }

        currentMeal = found;

        foodNameField.setText(found.getName());
        calField.setText(String.valueOf(found.getCalories()));
        proteinField.setText(String.valueOf(found.getProtein()));
        timeField.setText(String.valueOf(found.getTime()));
        datePicker.setValue(found.getDate());
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

    /**
     * Parses the text from the given {@code TextField} as a non-negative integer.
     * <p>
     * This method trims the input, checks for emptiness, validates that the value
     * is a whole number, and ensures it is not negative. If any validation fails,
     * an appropriate error message is written to the {@code output} label and
     * {@code null} is returned.
     * </p>
     *
     * @param field     the TextField containing the numeric input to validate
     * @param fieldName the human-readable name of the field (used in error messages)
     * @return the parsed integer value if valid; {@code null} if the input is invalid
     */
    private Integer parsePositiveIntField(TextField field, String fieldName) {
        String raw = field.getText().trim();

        if (raw.isEmpty()) {
            output.setText(fieldName + " cannot be empty.");
            return null;
        }

        int value;
        try {
            value = Integer.parseInt(raw);
        } catch (NumberFormatException ex) {
            output.setText(fieldName + " must be a whole number.");
            return null;
        }

        if (value < 0) {
            output.setText(fieldName + " cannot be negative.");
            return null;
        }

        return value;
    }
}
