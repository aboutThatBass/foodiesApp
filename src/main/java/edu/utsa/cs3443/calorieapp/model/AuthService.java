package edu.utsa.cs3443.calorieapp.model;

public class AuthService {

    private final UserRepository userRepo;

    public AuthService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    /*public User register(String name, String email, String password,
                         int age, double currentWeight, double goalWeight,
                         int dailyCalories, int proteinGoal) {

        if (userRepo.findByEmail(email) != null) {
            return null;
        }

        User user = new User(name, email, password, age, currentWeight, goalWeight,
                dailyCalories, proteinGoal);
        userRepo.addUser(user);
        return user;
    }*/

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

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    private boolean anyBlank(String... fields) {
        for (String f : fields) {
            if (isBlank(f)) return true;
        }
        return false;
    }

    public User login(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user == null) return null;
        if (!user.getPassword().equals(password)) return null;
        return user;
    }
} 
