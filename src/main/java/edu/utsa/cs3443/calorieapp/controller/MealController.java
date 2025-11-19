package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.SceneController;
import javafx.event.ActionEvent;

public class MealController {

    public void handleSubmit(ActionEvent e) {
        System.out.println("Meal added!");
        SceneController.switchScene("main.fxml");
    }

    public void handleBack(ActionEvent e) {
        SceneController.switchScene("main.fxml");
    }
}
