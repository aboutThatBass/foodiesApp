package edu.utsa.cs3443.calorieapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller class for the main menu of the calorie tracker application.
 * This class handles navigation to various functional screens, such as
 * adding food, viewing goals, meal logs, weekly totals, editing or deleting meals,
 * and user profile management.
 *
 */

public class MainController {

    /**
     * Opens a new modal window based on the specified FXML file and window title.
     * <p>
     * This method blocks interaction with the main window until the modal
     * window is closed.
     * </p>
     *
     * @param fxmlFile the FXML filename to load
     * @param title the title for the modal window
     */

    private void openWindow(String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/edu/utsa/cs3443/calorieapp/layouts/" + fxmlFile));
            System.out.println("Loading " + fxmlFile);
            Scene scene = new Scene(loader.load());

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); // block main window
            stage.setTitle(title);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens the "Add Food" screen as a modal window.
     *
     * @param e the action event triggered by the corresponding UI control
     */


    public void goToAddFood(ActionEvent e) {
        openWindow("add_food.fxml", "Add Food");
    }


    /**
     * Opens the "Goals" screen as a modal window.
     *
     * @param e the action event triggered by the corresponding UI control
     */

    public void goToGoals(ActionEvent e) {
        openWindow("todays_totals.fxml", "Goals");
    }

    /**
     * Opens the "Meal Log" screen as a modal window.
     *
     * @param e the action event triggered by the corresponding UI control
     */
    public void goToMealLog(ActionEvent e) {
        openWindow("meal_list.fxml", "Meal Log");
    }

    /**
     * Logs out the current user and returns to the home screen.
     *
     * @param e the action event triggered by the corresponding UI control
     */

    public void handleLogout(ActionEvent e) {
        SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/home.fxml");
    }

    /**
     * Opens the "Edit Meal" screen as a modal window.
     *
     * @param e the action event triggered by the corresponding UI control
     */
    public void goToEditMeal(ActionEvent e) {   openWindow("edit_meal.fxml", "Edit Meal"); }


    /**
     * Opens the "Delete Meal" screen as a modal window.
     *
     * @param e the action event triggered by the corresponding UI control
     */

    public void goToDeleteMeal(ActionEvent e) { openWindow("delete_meal.fxml", "Delete Meal"); }

    /**
     * Opens the "User Profile" screen as a modal window.
     *
     * @param e the action event triggered by the corresponding UI control
     */

    public void goToUser(ActionEvent e) { openWindow("user_info.fxml", "User");   }
}