package edu.utsa.cs3443.calorieapp.model;

import java.util.List;

/**
 * Provides utility methods for calculating calorie totals from a list of meals.
 * <p>
 * CaloireLog.java does not store data itself; instead, it operates on provided
 * {@link Meal} objects to compute daily and weekly calorie totals based on
 * the meals' recorded calorie values and dates.
 */


public class CalorieLog {

    /**
     * Calculates the total number of calories consumed on a specific date.
     * <p>
     * This method filters all meals that match the provided date and sums
     * their calorie values.
     *
     * @param meals the list of meals to search through
     * @param date  the target date (formatted as stored in {@link Meal})
     * @return the total calories consumed on the given date; returns 0 if no meals match
     */


    //whole class should be looked at
    public int getDailyTotal(List<Meal> meals, String date) {
        return meals.stream()
                .filter(m -> m.getDate().equals(date))
                .mapToInt(Meal::getCalories)
                .sum();
    }

    /**
     * Calculates the total number of calories consumed across all meals in the list.
     * <p>
     * This method represents a weekly total only if the provided list contains
     * exactly one week's worth of meals. It simply sums the calories in all meals.
     *
     * @param meals the list of meals which will be summed.
     * @return the total calories for all meals the user puts into the list
     */

    public int getWeeklyTotal(List<Meal> meals) {
        return meals.stream()
                .mapToInt(Meal::getCalories)
                .sum();
    }
}

