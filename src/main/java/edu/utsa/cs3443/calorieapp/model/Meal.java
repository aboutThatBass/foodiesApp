package edu.utsa.cs3443.calorieapp.model;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Meal {
    private String name;
    private int id;
    private String date;
    private String time;
    private int calories;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return name + " " + id + " " + date + " " + time + " " + calories + "\n";
    }
}

