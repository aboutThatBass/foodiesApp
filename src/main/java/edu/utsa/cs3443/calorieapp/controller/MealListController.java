package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.model.MealManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Controller class for the "Meal List" screen. This class manages
 * the display and interaction with the user's meal log, allowing
 * the user to view all meals or filter meals by a specific date.
 *
 * <p>The controller communicates with {@link MealManager} to retrieve
 * meal data and updates the UI elements such as text areas and radio buttons.</p>
 */

public class MealListController {

    /** Reference to the application's shared meal manager. */
    private MealManager mealManager;

    /** Radio button to select the option to show all meals. */
    @FXML
    private RadioButton showAllButton;
    /** Radio button to select the option to filter meals by date. */
    /** Toggle group for the radio buttons controlling meal view options. */
    @FXML
    private RadioButton byDateButton;
    private ToggleGroup viewGroup;
    /** Text field for entering a specific date to filter meals. */
    @FXML
    private DatePicker datePicker;
    /** Button to trigger displaying the meal log. */
    @FXML
    private Button goButton;
    /** Text area to display the meal log or filtered results. */
    @FXML
    private TextArea outputBox;
    /** Button to save any changes. */
    @FXML
    private Button saveButton;
    /** Button to cancel and close the meal list screen. */
    @FXML
    private Button cancelButton;
    /**
     * Initializes the controller. Sets up the reference to the shared
     * {@link MealManager} and configures the toggle group for radio buttons.
     * This method is automatically called after loading the FXML file.
     */
    public void initialize(){
        mealManager = SceneController.getMealManager();
        viewGroup = new ToggleGroup();
        byDateButton.setToggleGroup(viewGroup);
        showAllButton.setToggleGroup(viewGroup);
    }

    /**
     * Handles the "Go" button action to display the meal log based on
     * the selected radio button option. If "All" is selected, all meals
     * are displayed. If "By Date" is selected, meals for the specified
     * date are shown. If no option is selected, an error message is displayed.
     *
     * @param e the action event triggered by clicking the Go button
     */

    @FXML
    public void displayLog(ActionEvent e) {
        if(showAllButton.isSelected()){
            outputBox.setText(mealManager.viewAllMealsGUI());
        }
        else if(byDateButton.isSelected()){
            outputBox.setText(mealManager.viewMealsByDateGUI(datePicker.getValue()));
        }
        else{
            outputBox.setText("Please select an option");
        }
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
