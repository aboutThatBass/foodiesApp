package edu.utsa.cs3443.calorieapp.model;

/**
 * Represents a user of the calorie-tracking application, storing personal
 * information such as age, weight, and nutritional goals.
 * <p>
 * Each {@code User} contains:
 * <ul>
 *     <li>Identity details (name, email, password)</li>
 *     <li>Physical information (age, current weight, goal weight)</li>
 *     <li>Daily nutrition goals (calories, protein, carbs, fats)</li>
 * </ul>
 * This class serves as the core data model for authentication, calorie
 * tracking, progress monitoring, and user-specific meal logging.
 */

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

    /**
     * Constructs a new {@code User} with the provided user's personal information
     * and nutritional goals.
     *
     * @param name              the user’s name
     * @param email             the user’s email (used as a unique identifier)
     * @param password          the user’s password
     * @param age               the user’s age
     * @param currentWeight     the user’s current weight
     * @param goalWeight        the user’s target weight
     * @param dailyCalorieGoal  the user’s daily calorie intake goal
     * @param proteinGoal       the user’s daily protein goal
     * @param carbGoal          the user’s daily carbohydrate goal
     * @param fatGoal           the user’s daily fat goal
     */

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

    /**
     * Returns the user's name.
     *
     * @return the user's name
     */

    public String getName() {
        return name;
    }

    /**
     * Updates the user's name.
     *
     * @param name the new name value
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the user's email address.
     *
     * @return the user's email
     */

    public String getEmail() {
        return email;
    }

    /**
     * Returns the user's password.
     *
     * @return the user's password
     */

    public String getPassword() {
        return password;
    }


    /**
     * Updates the user's password.
     *
     * @param password the new password value
     */



    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the user's age.
     *
     * @return the user's age
     */

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the user's current weight.
     *
     * @return the current weight
     */

    public double getCurrentWeight() {
        return currentWeight;
    }

    /**
     * Updates the user's current weight.
     *
     * @param currentWeight the new current weight
     */

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    /**
     * Returns the user's goal weight.
     *
     * @return the target weight
     */
    public double getGoalWeight() {
        return goalWeight;
    }

    /**
     * Updates the user's goal weight.
     *
     * @param goalWeight the new target weight
     */

    public void setGoalWeight(double goalWeight) {
        this.goalWeight = goalWeight;
    }


    /**
     * Returns the user's daily calorie goal.
     *
     * @return the calorie goal
     */

    public int getDailyCalorieGoal() {
        return dailyCalorieGoal;
    }

    /**
     * Updates the user's daily calorie goal.
     *
     * @param dailyCalorieGoal the new calorie goal
     */

    public void setDailyCalorieGoal(int dailyCalorieGoal) {
        this.dailyCalorieGoal = dailyCalorieGoal;
    }

    /**
     * Returns the user's daily protein goal (in grams).
     *
     * @return the protein goal
     */

    public int getProteinGoal() {
        return proteinGoal;
    }

    /**
     * Updates the user's daily protein goal.
     *
     * @param proteinGoal the new protein goal
     */
    public void setProteinGoal(int proteinGoal) {
        this.proteinGoal = proteinGoal;
    }

    /**
     * Returns the user's daily carbohydrate goal (in grams).
     *
     * @return the carbohydrate goal
     */

    public int getCarbGoal() {
        return carbGoal;
    }

    /**
     * Updates the user's daily carbohydrate goal.
     *
     * @param carbGoal the new carbohydrate goal
     */

    public void setCarbGoal(int carbGoal) {
        this.carbGoal = carbGoal;
    }

    /**
     * Returns the user's daily fat goal .
     *
     * @return the fat goal
     */
    public int getFatGoal() {
        return fatGoal;
    }

    /**
     * Updates the user's daily fat goal.
     *
     * @param fatGoal the new fat goal
     */


    public void setFatGoal(int fatGoal) {
        this.fatGoal = fatGoal;
    }

    /**
     * Returns a short, readable identifier for the user.
     *
     * @return a string containing the user's name and email
     */
    @Override
    public String toString() {
        return name + " (" + email + ")";
    }
}

