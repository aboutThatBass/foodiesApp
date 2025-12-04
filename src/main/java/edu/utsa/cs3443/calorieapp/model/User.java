package edu.utsa.cs3443.calorieapp.model;

public class User {
    private String name;
    private String email;
    private String password;
    private int age;
    private double currentWeight;
    private double goalWeight;

    private int dailyCalorieGoal;
    private int proteinGoal;
    private int carbGoal;
    private int fatGoal;

    public User(String name, String email, String password,
                int age, double currentWeight, double goalWeight,
                int dailyCalorieGoal, int proteinGoal, int carbGoal, int fatGoal) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
        this.dailyCalorieGoal = dailyCalorieGoal;
        this.proteinGoal = proteinGoal;
        this.carbGoal = carbGoal;
        this.fatGoal = fatGoal;
    }

    public User(String name, String email, String password, int age, double currentWeight, double goalWeight, int dailyCalorieGoal, int proteinGoal) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
        this.dailyCalorieGoal = dailyCalorieGoal;
        this.proteinGoal = proteinGoal;
    }
    // Basic getters/setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public double getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(double goalWeight) {
        this.goalWeight = goalWeight;
    }

    public int getDailyCalorieGoal() {
        return dailyCalorieGoal;
    }

    public void setDailyCalorieGoal(int dailyCalorieGoal) {
        this.dailyCalorieGoal = dailyCalorieGoal;
    }

    public int getProteinGoal() {
        return proteinGoal;
    }

    public void setProteinGoal(int proteinGoal) {
        this.proteinGoal = proteinGoal;
    }

    public int getCarbGoal() {
        return carbGoal;
    }

    public void setCarbGoal(int carbGoal) {
        this.carbGoal = carbGoal;
    }

    public int getFatGoal() {
        return fatGoal;
    }

    public void setFatGoal(int fatGoal) {
        this.fatGoal = fatGoal;
    }

    @Override
    public String toString() {
        return name + " (" + email + ")";
    }
}

