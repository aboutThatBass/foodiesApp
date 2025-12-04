package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.SceneController;
import edu.utsa.cs3443.calorieapp.model.AuthService;
import edu.utsa.cs3443.calorieapp.model.MealManager;
import edu.utsa.cs3443.calorieapp.model.User;
import edu.utsa.cs3443.calorieapp.model.UserRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {



    @FXML private Button submitButton;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    @FXML
    public void handleSubmit(ActionEvent event) throws IOException {
        String email = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        AuthService auth = SceneController.getAuthService();
        User user = auth.login(email, password);

        if (user == null) {
            System.out.println("Invalid login.");
            return;
        }

        SceneController.setCurrentUser(user);

        MealManager mm = SceneController.getMealManager();
        mm.setFilePath("data/" + email + "_MealTracker.csv");
        mm.loadMealsFromFile(mm.getFilePath());

        SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/main-screen-view.fxml");
    }

    @FXML
    public void handleLogin(ActionEvent e) {
        System.out.println("Login → Main Menu");
        SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/login.fxml");
    }

    @FXML
    public void handleRegister(ActionEvent e) {
        System.out.println("Home → Create Profile");
        SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/create_profile.fxml");
    }
}
