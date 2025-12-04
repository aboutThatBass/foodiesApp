package edu.utsa.cs3443.calorieapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserController {
    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private TextField passField;
    @FXML private TextField ageField;
    @FXML private TextField currentWeightField;
    @FXML private TextField goalWeightField;
    @FXML private TextField activityLevelField;

    @FXML
    public void handleSubmit(ActionEvent event) {
        System.out.println("Test");
        // later you can add real logic here
    }

    @FXML
    public void handleBack(ActionEvent event) {
        // closes the popup window — returns to main screen automatically
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
