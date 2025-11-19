package edu.utsa.cs3443.calorieapp.model;

import java.util.List;

public class CalorieLog {

    public int getDailyTotal(List<Meal> meals, String date) {
        return meals.stream()
                .filter(m -> m.getDate().equals(date))
                .mapToInt(Meal::getCalories)
                .sum();
    }

    public int getWeeklyTotal(List<Meal> meals) {
        return meals.stream()
                .mapToInt(Meal::getCalories)
                .sum();
    }
}

