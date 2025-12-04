package edu.utsa.cs3443.calorieapp.model;

public class AuthService {

    private final UserRepository userRepo;

    public AuthService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

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

    public User login(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user == null) return null;
        if (!user.getPassword().equals(password)) return null;
        return user;
    }
} 
