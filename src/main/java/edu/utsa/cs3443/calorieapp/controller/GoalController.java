package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.SceneController;
import javafx.event.ActionEvent;

public class GoalController {

    public void handleBack(ActionEvent e) {
        SceneController.switchScene("main.fxml");
    }
}
