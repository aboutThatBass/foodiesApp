package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.SceneController;
import javafx.event.ActionEvent;

public class LoginController {

    public void handleLogin(ActionEvent e) {
        System.out.println("Login → Main Menu");
        SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/main-screen-view.fxml");
    }

    public void handleRegister(ActionEvent e) {
        System.out.println("Home → Create Profile");
        SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/create_profile.fxml");
    }
}
