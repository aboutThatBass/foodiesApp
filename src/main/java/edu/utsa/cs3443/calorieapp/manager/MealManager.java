package edu.utsa.cs3443.calorieapp.manager;

import edu.utsa.cs3443.calorieapp.model.Meal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MealManager {
    private ArrayList<Meal> meals =  new ArrayList<>();

    public void mealMenuScreen() throws IOException {
        loadMealsFromFile();
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========= MEAL LOGGING =========");
            System.out.println("1. Add new meal to log");
            System.out.println("2. View meal log");
            System.out.println("3. Edit meal entry");
            System.out.println("4. Delete meal from log");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            while (!input.hasNextInt()) {
                System.out.print("Please enter a number (1, 2, 3, or 9): ");
                input.next();
            }

            choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addMeal(input);
                case 2 -> viewMealsMenu(input);
                case 3 -> editMeal(input);
                case 4 -> removeMeal(input);
                case 9 -> System.out.println("Exiting program. Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 9);

        input.close();
    }

    public void loadMealsFromFile() {
        meals.clear();

        try (Scanner fileScanner = new Scanner(new File("MealTracker.csv"))) {
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


    public void addMeal(Scanner input) throws IOException {
        System.out.print("Please enter meal name: ");
        String name = input.nextLine();
        name = name.toUpperCase();
        System.out.print("Please enter meal date: ");
        String date = input.nextLine();
        System.out.print("Please enter meal time: ");
        String time = input.nextLine();
        System.out.print("Please enter total calories for this meal: ");
        int calories = input.nextInt();
        Meal meal = new Meal(name, date, time, calories);
        meal.setId(getNextId());
        meals.add(meal);
        saveDataToFile();
        System.out.println("Meal added successfully.");

    }

    public String addMealGUI(String name, String date, String time, int calories) throws IOException {
        loadMealsFromFile();
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

    public void viewMealsMenu(Scanner input) {
        System.out.println("\n========= PLEASE SELECT =========");
        System.out.println("1. View meals by date");
        System.out.println("2. View all meals");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice) {
            case 1 -> viewMealsByDate(input);
            case 2 -> viewAllMeals();
        }
    }

    public void viewAllMeals(){
        loadMealsFromFile();
        System.out.println("Meal Name: Meal ID: Date: Time: Calories:\n");
        for (Meal meal : meals){
            System.out.print(meal.toString());
        }
    }

    public String viewAllMealsGUI() {
        loadMealsFromFile();
        StringBuilder sb = new StringBuilder();
        for (Meal meal : meals){
            sb.append(meal.toString());
        }
        return sb.toString();
    }

    public void viewMealsByDate(Scanner input){
        boolean validDate = false;
        System.out.print("Please enter the date you wish to view: ");
        String date = input.nextLine();
        for (Meal meal : meals){
            if(meal.getDate().equals(date)){
                System.out.print(meal.toString());
                validDate = true;
            }
        }
        if(!validDate){
            System.out.println("\nNo meals found for this date");
        }
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

    public void editMeal(Scanner input) throws IOException {
        loadMealsFromFile();
        if (meals.isEmpty()) {
            System.out.println("No entries available to update.");
            return;
        }

        System.out.println("\n--- Meal List ---");
        viewAllMeals();

        System.out.print("\nEnter the ID of the meal to update: ");
        int target = input.nextInt();

        Meal meal = null;
        for (Meal m : meals) {
            if (m.getId() == target) {
                meal = m;
                break;
            }
        }

        if (meal == null) {
            System.out.println("Invalid ID.");
            return;
        }

        int option;
        do {
            System.out.println("\n--- UPDATE MENU ---");
            System.out.println("1. Update name");
            System.out.println("2. Update date");
            System.out.println("3. Update time");
            System.out.println("4. Update meal calories");
            System.out.println("9. Finish updating");
            System.out.print("Choose an option: ");

            while (!input.hasNextInt()) {
                System.out.print("Enter a number: ");
                input.next();
            }

            option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("New name: ");
                    meal.setName(input.nextLine().toUpperCase());
                }
                case 2 -> {
                    System.out.print("New date: ");
                    meal.setDate(input.nextLine());
                }
                case 3 -> {
                    System.out.print("New time: ");
                    meal.setTime(input.nextLine());
                }
                case 4 -> {
                    System.out.print("New calories: ");
                    meal.setCalories(input.nextInt());
                }
                case 9 -> System.out.println("Finished updating.");
                default -> System.out.println("Invalid choice.");
            }

        } while (option != 9);
        saveDataToFile();
        System.out.println("Meal updated successfully!");
    }

    public void saveDataToFile() throws IOException {
        File file = new File("MealTracker.csv");
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


    public void removeMeal(Scanner input) throws IOException {
        loadMealsFromFile();
        if (meals.isEmpty()) {
            System.out.println("No entries available to update.");
            return;
        }

        System.out.println("\n--- Meal List ---");
        viewAllMeals();

        System.out.print("\nEnter the ID of the meal to delete: ");
        int target = input.nextInt();
        input.nextLine(); //clears new line to avoid oob exception

        Meal meal = null;
        for (Meal m : meals) {
            if (m.getId() == target) {
                meal = m;
                break;
            }
        }

        if (meal == null) {
            System.out.println("Invalid ID.");
            return;
        }

        System.out.println(meal.toString());
        System.out.print("Are you sure you want to delete? [Y/N]");
        String line =  input.nextLine().trim();
        char choice =  Character.toUpperCase(line.charAt(0));
        if (choice == 'Y') {
            meals.remove(meal);
            saveDataToFile();
            System.out.println("Meal deleted successfully!");
        }
        else if (choice == 'N') {
            System.out.println("Cancelled");
        }
        else{
            System.out.println("Invalid choice.");
        }
    }
}
