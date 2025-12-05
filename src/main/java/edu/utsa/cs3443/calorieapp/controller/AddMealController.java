package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.model.MealManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Controller class responsible for handling user input and actions
 * on the "Add Meal" screen. This class interacts with the
 * {@link MealManager} to create and store meal entries, and updates
 * the UI accordingly.
 *
 * <p>This controller retrieves the shared {@code MealManager} instance
 * from the {@link SceneController} and uses it to save meals entered
 * by the user in the form fields.</p>
 */

public class AddMealController {


    /** Reference to the application's shared meal manager. */

   private MealManager mealManager;

    /** Text field for entering the meal's name. */

    @FXML
    private TextField foodNameField;
    /** Text field for entering the calorie amount. */
    @FXML
    private TextField calField;
    /** Text field for entering the meal date. */
    @FXML
    private TextField proteinField;
    @FXML
    private DatePicker datePicker;
    /** Text field for entering the meal time. */
    @FXML
    private TextField timeField;
    /** Label used to display success or error messages. */
    @FXML
    private Label output;


    /**
     * Initializes the controller by retrieving the shared
     * {@link MealManager} instance from the {@link SceneController}.
     * This method is automatically called after loading
     * the FXML file.
     */

    public void initialize(){
        mealManager = SceneController.getMealManager();
    }


    /**
     * Handles the "Submit" button action. Collects input from form fields,
     * validates and converts calorie input, and passes the data to
     * {@link MealManager(String, String, String, int)}.
     *
     * <p>After successfully adding the meal, the form fields are cleared and
     * the result message is shown in the output label.</p>
     *
     * @param e the action event triggered by pressing the button
     * @throws IOException if an error occurs while saving the meal to file
     */

    @FXML
    public void handleSubmit(ActionEvent e) throws IOException {
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
        LocalDate date = datePicker.getValue();
        if (datePicker.getValue() == null) {
            output.setText("Please select a valid date.");
            return;
        }

        // Validate protein and calories using helper method
        Integer calories = parsePositiveIntField(calField, "Calories");
        if (calories == null) return;
        Integer protein = parsePositiveIntField(proteinField, "Protein");
        if (protein == null) return;

        //mealManager.addMealGUI(name,date,time,calories,protein);
        output.setText(mealManager.addMealGUI(name,date,time,calories,protein));
        timeField.clear();
        datePicker.setValue(null);
        foodNameField.clear();
        calField.clear();
        proteinField.clear();
    }

    /**
     * Handles the "Back" button action by closing the current window.
     *
     * @param e the action event triggered by the button
     */

    @FXML
    public void handleBack(ActionEvent e) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }

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
