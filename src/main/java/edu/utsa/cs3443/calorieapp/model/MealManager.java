package edu.utsa.cs3443.calorieapp.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import edu.utsa.cs3443.calorieapp.controller.SceneController;

/**
 * Manages a collection of {@link Meal} objects for a user, providing functionality
 * to load meals from a file, save meals, add new meals, and retrieve meal
 * information in both console and GUI-friendly formats.
 * <p>
 * The {@code MealManager} stores meals in memory using an {@code ArrayList}
 * and persists them in a CSV-style text file where each line represents a meal
 * in the format:
 * <pre>
 *     id,name,date,time,calories
 * </pre>
 * The file path used for loading and saving is stored internally and must be
 * set before performing any file-based operations.
 */

public class MealManager {
    private ArrayList<Meal> meals =  new ArrayList<>();
    private String filePath;
    User user = SceneController.getCurrentUser();

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    /**
     * Returns the file path currently used for storing meal data.
     *
     * @return the file path of the meal log
     */

    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets the file path to be used for loading and saving meal data.
     *
     * @param filePath the path to the meal log file
     */

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads all meals from the specified file into memory.
     * <p>
     * If the file does not exist, it is created automatically. Each line
     * in the file is expected to contain comma-separated meal fields.
     * Invalid or incomplete lines are skipped.
     *
     * @param filePath the path of the file to load meals from
     */

    public void loadMealsFromFile(String filePath) {
        meals.clear();

        File file = new File(filePath);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            return;
        }

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length >= 5) {
                    String name = parts[1];
                    int id = Integer.parseInt(parts[0]);
                    LocalDate date = LocalDate.parse(parts[2]);
                    String time = parts[3];
                    int calories = Integer.parseInt(parts[4]);
                    int protein = Integer.parseInt(parts[5]);
                    Meal meal = new Meal(name, id, date, time, calories, protein);
                    meals.add(meal);
                }
            }
        } catch (IOException e) {
            System.out.println("No meal log found yet. A new one will be created when you add meals.");
        }
    }

    /**
     * Determines the next available meal ID based on the last stored meal.
     *
     * @return a new unique ID for a meal
     */

    private int getNextId(){
        if(meals.isEmpty()) {
            return 1;
        }
        else {
            Meal lastMeal = meals.get(meals.size() - 1);
            return lastMeal.getId() + 1;
        }
    }

    /**
     * Adds a new meal using GUI inputs and saves it to the file.
     * <p>
     * The method reloads the meals from file, assigns a new ID, appends the meal,
     * and then persists the updated list.
     *
     * @param name     the meal name
     * @param date     the date the meal was consumed
     * @param time     the time the meal was consumed
     * @param calories the calorie count of the meal
     * @return a success or error message for GUI display
     * @throws IOException if saving the meal fails
     */

    public String addMealGUI(String name, LocalDate date, String time, int calories, int protein) throws IOException {
        loadMealsFromFile(filePath);
        Meal meal = new Meal(name.toUpperCase(), date, time, calories, protein);
        meal.setId(getNextId());
        meals.add(meal);
        saveDataToFile();

        try {
            saveDataToFile();
        } catch (IOException e) {
            return "Error saving meal.";
        }

        return "Meal added successfully!";
    }

    /**
     * Displays all stored meals to the console in a readable format.
     * Loads meals from the file before printing.
     */

    public void viewAllMeals(){
        loadMealsFromFile(filePath);
        System.out.println("Meal Name: Meal ID: Date: Time: Calories:\n");
        for (Meal meal : meals){
            System.out.print(meal.toString());
        }
    }


    /**
     * Returns a formatted string containing all meals, for GUI display.
     * Loads meals from the file before formatting.
     *
     * @return a string representing all stored meals
     */


    public String viewAllMealsGUI() {
        loadMealsFromFile(filePath);
        StringBuilder sb = new StringBuilder();
        for (Meal meal : meals){
            sb.append(meal.toString());
        }
        if(meals.isEmpty()) {
            sb.append("No meals found.");
        }
        return sb.toString();
    }


    /**
     * Returns all meals matching a given date in formatted form for GUI display.
     *
     * @param date the target date to filter meals by
     * @return a string containing all meals on that date, or a message if none exist
     */

    public String viewMealsByDateGUI(LocalDate date) {
        StringBuilder sb = new StringBuilder();
        boolean validDate = false;
        for (Meal meal : meals){
            if(meal.getDate().equals(date)){
                validDate = true;
                sb.append(meal.toString());
            }
        }
        if(!validDate){
            sb.append("No meals found for this date");
        }
        return sb.toString();
    }

    /**
     * Saves all stored meals to the file in CSV format.
     * <p>
     * If the file does not exist, it is created. Existing content is overwritten.
     *
     * @throws IOException if an error occurs while writing to the file
     */

    public void saveDataToFile() throws IOException {
        File file = new File(filePath);
        if(!file.exists()) {
            file.createNewFile();
        }

        FileWriter out = new FileWriter(file);
        for(Meal meal : meals) {
            out.write(meal.getId()+","
                    +meal.getName().toUpperCase()+","
                    +meal.getDate()+","
                    +meal.getTime()+","
                    +meal.getCalories()+","
                    +meal.getProtein()+"\n");
        }
        out.close();
    }
}
