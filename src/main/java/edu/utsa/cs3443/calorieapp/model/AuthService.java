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
     * @param carbGoal      the user's daily carbohydrate goal
     * @param fatGoal       the user's daily fat goal
     * @return the newly registered {@code User}, or {@code null} if the email is already in use
     */

    public User register(String name, String email, String password,
                         int age, double currentWeight, double goalWeight,
                         int dailyCalories, int proteinGoal, int carbGoal, int fatGoal) {

        if (userRepo.findByEmail(email) != null) {
            System.out.println("A user with that email already exists.");
            return null;
        }

        User user = new User(name, email, password, age, currentWeight, goalWeight,
                dailyCalories, proteinGoal, carbGoal, fatGoal);
        userRepo.addUser(user);
        return user;
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
