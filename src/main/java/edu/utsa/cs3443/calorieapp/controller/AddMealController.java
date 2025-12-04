package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.model.MealManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AddMealController {

   private MealManager mealManager;

    @FXML
    private TextField foodNameField;
    @FXML
    private TextField calField;
    @FXML
    private TextField dateField;
    @FXML
    private TextField timeField;
    @FXML
    private Label output;


    public void initialize(){
        mealManager = SceneController.getMealManager();
    }

    @FXML
    public void handleSubmit(ActionEvent e) throws IOException {
        String name = foodNameField.getText();
        String date = dateField.getText();
        String time = timeField.getText();

        //TODO: INPUT VALIDATION
        int calories = Integer.parseInt(calField.getText());

        //mealManager.addMealGUI(name,date,time,calories);
        output.setText(mealManager.addMealGUI(name,date,time,calories));
        timeField.clear();
        dateField.clear();
        foodNameField.clear();
        calField.clear();
    }

    @FXML
    public void handleBack(ActionEvent e) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }


}
