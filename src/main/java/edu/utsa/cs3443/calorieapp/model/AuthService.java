package edu.utsa.cs3443.calorieapp.model;


/**
 * Provides authenication like user registration and login. This class interacts
 * with {@link UserRepository} to store and retrieve user information.
 */

public class AuthService {

    private final UserRepository userRepo;

    public AuthService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    /**
     * Registers a new user in the system.
     * <p>
     * This method checks if an account with the provided email already exists.
     * If it does, the method prints an error message and returns {@code null}.
     * Otherwise, it creates a new {@link User} with the provided details and
     * stores it in the user repository.
     *
     * @param name          the user's full name
     * @param email         the user's email address
     * @param password      the user's account password
     * @param age           the user's age
     * @param currentWeight the user's current weight
     * @param goalWeight    the weight the user aims to reach
     * @param dailyCalories the user's daily calorie goal
     * @param proteinGoal   the user's daily protein goal
     * @return the newly registered {@code User}, or {@code null} if the email is already in use
     */

    public User register(String name, String email, String password,
                         int age, double currentWeight, double goalWeight,
                         int dailyCalories, int proteinGoal) {

        // String validation
        if (anyBlank(name, email, password)) {
            throw new IllegalArgumentException("Name, email, and password must not be empty.");
        }

        // Numeric validation
        if (age <= 0 || currentWeight <= 0 || goalWeight <= 0 || dailyCalories <= 0 ||  proteinGoal <= 0) {
            throw new IllegalArgumentException("All numeric fields must be positive.");
        }

        // Email uniqueness
        if (userRepo.findByEmail(email) != null) {
            return null;  // maintains your app's logic for duplicates
        }

        User user = new User(name, email, password, age, currentWeight, goalWeight,
                dailyCalories, proteinGoal);

        userRepo.addUser(user);
        return user;
    }

    public User update(String name, String email, String password,
                       int age, double currentWeight, double goalWeight,
                       int dailyCalories, int proteinGoal) {

        // String validation
        if (anyBlank(name, password)) {
            throw new IllegalArgumentException("Name and password must not be empty.");
        }

        // Numeric validation
        if (age <= 0 || currentWeight <= 0 || goalWeight <= 0 || dailyCalories <= 0 ||  proteinGoal <= 0) {
            throw new IllegalArgumentException("All numeric fields must be positive.");
        }

        User user = userRepo.findByEmail(email);
        user.setName(name);
        user.setPassword(password);
        user.setAge(age);
        user.setCurrentWeight(currentWeight);
        user.setGoalWeight(goalWeight);
        user.setDailyCalorieGoal(dailyCalories);
        user.setProteinGoal(proteinGoal);

        userRepo.save();

        return user;
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    private boolean anyBlank(String... fields) {
        for (String f : fields) {
            if (isBlank(f)) return true;
        }
        return false;
    }

    /**
     * Attempts to authenticate a user with the given email and password.
     * <p>
     * This method looks up the user by email. If no such user exists or the
     * password does not match, it returns {@code null}. Otherwise, it returns
     * the authenticated {@link User}.
     *
     * @param email    the user's email address
     * @param password the password associated with the account
     * @return the authenticated {@code User}, or {@code null} if authentication fails
     */

    public User login(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user == null) return null;
        if (!user.getPassword().equals(password)) return null;
        return user;
    }
} 
