package edu.utsa.cs3443.calorieapp.model;

public class User {

    private String name;
    private String email;
    private String password;

    private int age;
    private double currentWeight;
    private double goalWeight;
    private String activityLevel;

    public User(String name, String email, String password,
                int age, double currentWeight,
                double goalWeight, String activityLevel) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
        this.activityLevel = activityLevel;
    }

    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public int getAge() { return age; }
    public double getCurrentWeight() { return currentWeight; }
    public double getGoalWeight() { return goalWeight; }
    public String getActivityLevel() { return activityLevel; }

    // Setters
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setAge(int age) { this.age = age; }
    public void setCurrentWeight(double currentWeight) { this.currentWeight = currentWeight; }
    public void setGoalWeight(double goalWeight) { this.goalWeight = goalWeight; }
    public void setActivityLevel(String activityLevel) { this.activityLevel = activityLevel; }

    // CSV output
    public String toCSV() {
        return String.join(",",
                name, email, password,
                String.valueOf(age),
                String.valueOf(currentWeight),
                String.valueOf(goalWeight),
                activityLevel
        );
    }

    // CSV import
    public static User fromCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length != 7) return null;

        return new User(
                parts[0], parts[1], parts[2],
                Integer.parseInt(parts[3]),
                Double.parseDouble(parts[4]),
                Double.parseDouble(parts[5]),
                parts[6]
        );
    }
}

