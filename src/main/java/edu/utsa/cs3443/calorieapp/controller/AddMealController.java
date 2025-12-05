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
     * {@link MealManager#addMealGUI(String, String, String, int)}.
     *
     * <p>After successfully adding the meal, the form fields are cleared and
     * the result message is shown in the output label.</p>
     *
     * @param e the action event triggered by pressing the button
     * @throws IOException if an error occurs while saving the meal to file
     */

    @FXML
    public void handleSubmit(ActionEvent e) throws IOException {
        String name = foodNameField.getText();
        LocalDate date = datePicker.getValue();
        String time = timeField.getText();

        //TODO: INPUT VALIDATION
        int calories = Integer.parseInt(calField.getText());
        int protein = Integer.parseInt(proteinField.getText());

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


}
