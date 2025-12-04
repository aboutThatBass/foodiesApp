package edu.utsa.cs3443.calorieapp.controller;

import javafx.event.ActionEvent;

/**
 * Controller class for the "Create Profile" screen. This controller handles
 * user actions related to submitting a newly created profile and navigating
 * to the next screen.
 *
 * <p>Currently, this controller serves primarily as a navigation handler,
 * redirecting the user to the login screen after profile creation.</p>
 */

public class CreateProfileController {

    /**
     * Handles the "Submit" button action when creating a new profile.
     * <p>
     * This method currently prints a confirmation message to the console
     * and navigates the user to the login screen by invoking
     * {@link SceneController#switchScene(String)}.
     * </p>
     *
     * @param e the action event triggered by the submit button
     */

    public void handleSubmit(ActionEvent e) {
        System.out.println("Profile submitted!");
        SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/login.fxml");
    }
}
