package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.SceneController;
import edu.utsa.cs3443.calorieapp.model.MealManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteMealController {

    @FXML
    private TextField idField;
    @FXML
    private TextArea outputArea;
    @FXML
    private Button goButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button backButton;

    private MealManager mealManager;

    public void initialize() {
        mealManager = SceneController.getMealManager();
    }

    @FXML
    private void handleGo(ActionEvent event) {
        try {
            int id = Integer.parseInt(idField.getText());
            //need to find meal by ID and return it
            outputArea.setText("Test");
        } catch (NumberFormatException e) {
            outputArea.setText("Invalid ID. Please enter a number.");
        }
    }

    @FXML
    private void handleDelete(ActionEvent event) {
        try {
            int id = Integer.parseInt(idField.getText());
            String result = "Test";
            outputArea.setText(result);
        } catch (NumberFormatException e) {
            outputArea.setText("Invalid ID. Please enter a number.");
        }
    }

    @FXML
    private void handleBack(ActionEvent event) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
}