package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.SceneController;
import javafx.event.ActionEvent;

public class MainController {

    public void goToAddFood(ActionEvent e) {
        SceneController.switchScene("add_food.fxml");
    }

    public void goToGoals(ActionEvent e) {
        SceneController.switchScene("goals.fxml");
    }

    public void goToMealLog(ActionEvent e) {  SceneController.switchScene("meal_list.fxml"); }

    public void goToWeeklyTotals(ActionEvent e) {
        SceneController.switchScene("weekly_total.fxml");
    }

    public void handleLogout(ActionEvent e) {
        SceneController.switchScene("home.fxml");
    }

}