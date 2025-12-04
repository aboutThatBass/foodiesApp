package edu.utsa.cs3443.calorieapp.controller;

import javafx.event.ActionEvent;

public class CreateProfileController {

    public void handleSubmit(ActionEvent e) {
        System.out.println("Profile submitted!");
        SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/login.fxml");
    }
}
