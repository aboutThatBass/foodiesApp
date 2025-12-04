package edu.utsa.cs3443.calorieapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditMealController {
    @FXML private TextField foodNameField;
    @FXML private TextField calField;
    @FXML private TextField dateField;
    @FXML private TextField timeField;
    @FXML private Button goButton;

    @FXML
    public void handleSubmit(ActionEvent e) {
        // "Success" placeholder
        System.out.println("Test");
    }

    @FXML
    public void handleGo(ActionEvent e) {
        System.out.println("Test");
    }

    @FXML
    public void handleBack(ActionEvent e) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }
}
