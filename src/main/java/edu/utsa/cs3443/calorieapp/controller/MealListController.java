package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.SceneController;
import edu.utsa.cs3443.calorieapp.manager.MealManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class MealListController {

    private MealManager mealManager;

    @FXML
    private RadioButton showAllButton;
    @FXML
    private RadioButton byDateButton;
    private ToggleGroup viewGroup;
    @FXML
    private TextField dateBox;
    @FXML
    private Button goButton;
    @FXML
    private TextArea outputBox;
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;

    public void initialize(){
        mealManager = SceneController.getMealManager();
        viewGroup = new ToggleGroup();
        byDateButton.setToggleGroup(viewGroup);
        showAllButton.setToggleGroup(viewGroup);
    }

    @FXML
    public void displayLog(ActionEvent e) {
        if(showAllButton.isSelected()){
            outputBox.setText(mealManager.viewAllMealsGUI());
        }
        else if(byDateButton.isSelected()){
            outputBox.setText(mealManager.viewMealsByDateGUI(dateBox.getText()));
        }
        else{
            outputBox.setText("Please select an option");
        }
    }

    @FXML
    public void handleBack(ActionEvent e) {
        SceneController.switchScene("main.fxml");
    }
}
