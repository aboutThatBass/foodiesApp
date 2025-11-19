package edu.utsa.cs3443.calorieapp.manager;

import edu.utsa.cs3443.calorieapp.model.CSVManager;
import edu.utsa.cs3443.calorieapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private static final String FILE = "data/users.csv";

    public void addUser(User user) {
        CSVManager.append(FILE, user.toCSV());
    }

    public List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        for (String line : CSVManager.readAll(FILE)) {
            User u = User.fromCSV(line);
            if (u != null)
                users.add(u);
        }
        return users;
    }

    public User findUserByEmail(String email) {
        return loadUsers().stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    public boolean validateLogin(String email, String password) {
        User u = findUserByEmail(email);
        return u != null && u.getPassword().equals(password);
    }
}

