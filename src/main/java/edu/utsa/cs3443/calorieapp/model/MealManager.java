package edu.utsa.cs3443.calorieapp.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.utsa.cs3443.calorieapp.controller.SceneController;

public class MealManager {
    private ArrayList<Meal> meals =  new ArrayList<>();
    private String filePath;
    User user = SceneController.getCurrentUser();

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

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

                if (parts.length >= 4) {
                    String name = parts[1];
                    int id = Integer.parseInt(parts[0]);
                    String date = parts[2];
                    String time = parts[3];
                    int calories = Integer.parseInt(parts[4]);
                    Meal meal = new Meal(name, id, date, time, calories);
                    meals.add(meal);
                }
            }
        } catch (IOException e) {
            System.out.println("No meal log found yet. A new one will be created when you add meals.");
        }
    }

    private int getNextId(){
        if(meals.isEmpty()) {
            return 1;
        }
        else {
            Meal lastMeal = meals.get(meals.size() - 1);
            return lastMeal.getId() + 1;
        }
    }

    public String addMealGUI(String name, String date, String time, int calories) throws IOException {
        loadMealsFromFile(filePath);
        Meal meal = new Meal(name.toUpperCase(), date, time, calories);
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

    public void viewAllMeals(){
        loadMealsFromFile(filePath);
        System.out.println("Meal Name: Meal ID: Date: Time: Calories:\n");
        for (Meal meal : meals){
            System.out.print(meal.toString());
        }
    }

    public String viewAllMealsGUI() {
        loadMealsFromFile(filePath);
        StringBuilder sb = new StringBuilder();
        for (Meal meal : meals){
            sb.append(meal.toString());
        }
        return sb.toString();
    }

    public String viewMealsByDateGUI(String date) {
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
                    +meal.getCalories()+"\n");
        }
        out.close();
    }
}
