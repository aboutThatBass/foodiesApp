package edu.utsa.cs3443.calorieapp.model;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



/**
 * Represents user put information such as the meal name,
 * date and time it was consumed, calorie count, and an optional ID.
 * <p>
 * This class is  used for logging or tracking user meals within Foodies
 */

public class Meal {
    private String name;
    private int id;
    private String date;
    private String time;
    private int calories;

    /**
     * Constructs a new {@code Meal} without specifying an ID.
     *
     * @param name     the name or meal description
     * @param date     the date the meal was consumed
     * @param time     the time the meal was consumed
     * @param calories the number of calories contained in the meal
     */

    public Meal(String name, String date, String time, int calories) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.calories = calories;
    }

    public Meal(String name, int id, String date, String time, int calories) {
        this.name = name;
        this.id = id;
        this.date = date;
        this.time = time;
        this.calories = calories;
    }
    /**
     * Returns the unique identifier of the meal.
     *
     * @return the meal ID
     */

    public int getId() {
        return id;
    }
    /**
     * Sets the unique identifier of the meal.
     *
     * @param id the new ID for this meal
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name or description of the meal.
     *
     * @return the meal name
     */

    public String getName() {
        return name;
    }
    /**
     * Sets the name or description of the meal.
     *
     * @param name the new meal name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the date the meal was consumed.
     *
     * @return the meal date
     */

    public String getDate() {
        return date;
    }

    /**
     * Sets the date the meal was consumed.
     *
     * @param date the new date for this meal
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Returns the time the meal was consumed.
     *
     * @return the meal time
     */

    public String getTime() {
        return time;
    }

    /**
     * Sets the time the meal was consumed.
     *
     * @param time the new time for this meal
     */

    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Returns the number of calories contained in the meal.
     *
     * @return the calorie value
     */

    public int getCalories() {
        return calories;
    }

    /**
     * Sets the calorie count for the meal.
     *
     * @param calories the new calorie value
     */

    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     * Returns a formatted string representation of the meal containing its
     * ID, name, date, time, and calorie count.
     *
     * @return a string representation of the meal
     */

    @Override
    public String toString() {
        return id + " " + name + " " + date + " " + time + " " + calories + "\n";
    }
}

