package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.model.AuthService;
import edu.utsa.cs3443.calorieapp.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateProfileController {

    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private TextField passField;
    @FXML private TextField ageField;
    @FXML private TextField currentWeightField;
    @FXML private TextField goalWeightField;
    @FXML private TextField calorieGoalField;
    @FXML private TextField proteinGoalField;
    @FXML private Label output;

    @FXML
    public void handleSubmit(ActionEvent event) {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String password = passField.getText().trim();
        String ageText = ageField.getText().trim();
        String currentWeightText = currentWeightField.getText().trim();
        String goalWeightText = goalWeightField.getText().trim();
        String dailyCalorieText = calorieGoalField.getText().trim();
        String dailyProteinText = proteinGoalField.getText().trim();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() ||
                ageText.isEmpty() || currentWeightText.isEmpty() ||
                goalWeightText.isEmpty() || dailyCalorieText.isEmpty() ||
                dailyProteinText.isEmpty())
        {
            output.setText("All fields must be filled.");
            return;
        }

        try{
            int age = Integer.parseInt(ageText);
            double currentWeight = Double.parseDouble(currentWeightText);
            double goalWeight = Double.parseDouble(goalWeightText);
            int dailyCalories = Integer.parseInt(dailyCalorieText);
            int dailyProtein = Integer.parseInt(dailyProteinText);
            AuthService auth = SceneController.getAuthService();
            User user = auth.register(name,email, password, age, currentWeight, goalWeight, dailyCalories, dailyProtein);
            if (user == null) {
                output.setText("An account with that email already exists");
                return;
            }
            SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/login.fxml");
        } catch (NumberFormatException e) {
            output.setText(e.getMessage());
        } catch(IllegalArgumentException e){
            output.setText(e.getMessage());
        } catch(NullPointerException e){
            output.setText(e.getMessage());
        }
    }

    @FXML
    public void handleBack(ActionEvent event) {
        SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/home.fxml");
    }
}
