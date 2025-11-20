package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.SceneController;
import edu.utsa.cs3443.calorieapp.manager.MealManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class MealController {

   private MealManager mealManager;

    @FXML
    private TextField foodNameField;
    @FXML
    private TextField calField;
    @FXML
    private TextField dateField;
    @FXML
    private TextField timeField;


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
        //delete after demo
        SceneController.addFakeCalories(calories);

        mealManager.addMealGUI(name,date,time,calories);
        SceneController.switchScene("main.fxml");
    }

    @FXML
    public void handleBack(ActionEvent e) {
        SceneController.switchScene("main.fxml");
    }


}
