package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GoalController {

    @FXML
    private TextField calsEaten;
    @FXML
    private TextField calsLeft;

    //fix after demo, currently hard coded to 1800 calorie daily goal
    @FXML
    public void initialize() {

    }

    @FXML
    public void goToMealLog(ActionEvent e) {
        SceneController.switchScene("meal_list.fxml");
    }

    @FXML
    public void handleBack(ActionEvent e) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }
}
