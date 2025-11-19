package edu.utsa.cs3443.calorieapp.model;

public class Meal {

    private int id;
    private String name;
    private String date;
    private String time;
    private int calories;

    public Meal(int id, String name, String date, String time, int calories) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.calories = calories;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public int getCalories() { return calories; }

    public void setName(String name) { this.name = name; }
    public void setDate(String date) { this.date = date; }
    public void setTime(String time) { this.time = time; }
    public void setCalories(int calories) { this.calories = calories; }

    public String toCSV() {
        return id + "," + name + "," + date + "," + time + "," + calories;
    }

    public static Meal fromCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length != 5) return null;

        return new Meal(
                Integer.parseInt(parts[0]),
                parts[1],
                parts[2],
                parts[3],
                Integer.parseInt(parts[4])
        );
    }
}

