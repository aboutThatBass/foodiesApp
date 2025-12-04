package edu.utsa.cs3443.calorieapp.controller;

import edu.utsa.cs3443.calorieapp.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

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


    public void goToAddFood(ActionEvent e) {
        openWindow("add_food.fxml", "Add Food");
    }

    public void goToGoals(ActionEvent e) {
        openWindow("goals.fxml", "Goals");
    }

    public void goToMealLog(ActionEvent e) {
        openWindow("meal_list.fxml", "Meal Log");
    }

    public void goToWeeklyTotals(ActionEvent e) {
        SceneController.switchScene("/layouts/weekly_total.fxml");
    }

    public void handleLogout(ActionEvent e) {
        SceneController.switchScene("/edu/utsa/cs3443/calorieapp/layouts/home.fxml");
    }

    public void goToEditMeal(ActionEvent e) {   openWindow("edit_meal.fxml", "Edit Meal"); }

    public void goToDeleteMeal(ActionEvent e) { openWindow("delete_meal.fxml", "Delete Meal"); }

    public void goToUser(ActionEvent e) { openWindow("user_info.fxml", "User");   }
}