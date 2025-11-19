package edu.utsa.cs3443.calorieapp.manager;

import edu.utsa.cs3443.calorieapp.model.CSVManager;
import edu.utsa.cs3443.calorieapp.model.Meal;

import java.util.ArrayList;
import java.util.List;

public class MealManager {

    private static final String FILE = "data/meals.csv";

    public List<Meal> loadMeals() {
        List<Meal> meals = new ArrayList<>();

        for (String line : CSVManager.readAll(FILE)) {
            Meal m = Meal.fromCSV(line);
            if (m != null)
                meals.add(m);
        }
        return meals;
    }

    public void addMeal(Meal meal) {
        CSVManager.append(FILE, meal.toCSV());
    }

    public int getNextId() {
        List<Meal> meals = loadMeals();
        if (meals.isEmpty()) return 1;
        return meals.get(meals.size() - 1).getId() + 1;
    }

    public int getDailyTotal(String date) {
        int total = 0;
        for (Meal m : loadMeals()) {
            if (m.getDate().equals(date))
                total += m.getCalories();
        }
        return total;
    }

    public int getWeeklyTotal() {
        return loadMeals().stream()
                .mapToInt(Meal::getCalories)
                .sum();
    }
}


