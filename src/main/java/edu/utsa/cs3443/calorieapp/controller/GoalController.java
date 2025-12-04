package edu.utsa.cs3443.calorieapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for the "Goal" screen. This class handles user
 * interactions related to tracking daily calorie intake and remaining
 * calories, as well as navigating to other screens such as the meal log.
 *
 * <p>Currently, the calorie goal is hard-coded for demonstration purposes.
 * Future updates should dynamically retrieve and display user-specific goals.</p>
 */

public class GoalController {

    /** Text field for displaying the calories already eaten. */
    @FXML
    private TextField calsEaten;
    /** Text field for displaying the remaining calories for the day. */
    @FXML
    private TextField calsLeft;

    /**
     * Initializes the controller. This method is automatically called
     *  after loading the FXML file.
     * <p>
     * Current implementation is a placeholder; future updates should
     * calculate and display real values based on the user's daily goal
     * and meals consumed.
     * </p>
     */

    //fix after demo, currently hard coded to 1800 calorie daily goal
    @FXML
    public void initialize() {

    }

    /**
     * Navigates to the meal log screen.
     *
     * @param e the action event triggered by a user action (e.g., button click)
     */

    @FXML
    public void goToMealLog(ActionEvent e) {
        SceneController.switchScene("meal_list.fxml");
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
