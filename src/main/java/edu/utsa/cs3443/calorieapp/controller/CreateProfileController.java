package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.SceneController;
import edu.utsa.cs3443.calorieapp.model.AuthService;
import edu.utsa.cs3443.calorieapp.model.User;
import edu.utsa.cs3443.calorieapp.model.UserRepository;
import javafx.event.ActionEvent;

public class CreateProfileController {

    public void handleSubmit(ActionEvent e) {
        System.out.println("Profile submitted!");
        SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/login.fxml");
    }
}
