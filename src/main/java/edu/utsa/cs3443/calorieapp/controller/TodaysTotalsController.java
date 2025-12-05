package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.model.Meal;
import edu.utsa.cs3443.calorieapp.model.MealManager;
import edu.utsa.cs3443.calorieapp.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

/**
 * Controller class for the "Goal" screen. This class handles user
 * interactions related to tracking daily calorie intake and remaining
 * calories, as well as navigating to other screens such as the meal log.
 *
 */

public class TodaysTotalsController {

    /** Label for displaying the calories already eaten. */
    @FXML
    private Label calsEatenOutput;
    /** Label for displaying the remaining calories for the day. */
    @FXML
    private Label calsLeftOutput;
    @FXML
    private Label proteinEatenOutput;


    /**
     * Initializes the controller. This method is automatically called
     *  after loading the FXML file.
     */

    @FXML
    public void initialize() {
        MealManager mm = SceneController.getMealManager();
        User user = SceneController.getCurrentUser();
        LocalDate today = LocalDate.now();

        int todaysCals = 0;
        int todaysProtein = 0;

        for (Meal m: mm.getMeals()){
            if (m.getDate().equals(today)){
                todaysCals += m.getCalories();
                todaysProtein += m.getProtein();
            }
        }

        calsEatenOutput.setText(String.valueOf(todaysCals));
        calsLeftOutput.setText(String.valueOf(user.getDailyCalorieGoal() - todaysCals));
        proteinEatenOutput.setText(String.valueOf(todaysProtein));
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
