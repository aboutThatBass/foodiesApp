package edu.utsa.cs3443.calorieapp.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static final String USER_FILE = "data/users.csv";

    private List<User> users = new ArrayList<>();

    public UserRepository() {
        load();
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
        save();
    }

    public User findByEmail(String email) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null;
    }

    private void load() {
        users.clear();
        File file = new File(USER_FILE);

        if (!file.exists()) {
            // No users yet, create directory if needed
            file.getParentFile().mkdirs();
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine(); // header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 8) continue;

                String name = parts[0].trim();
                String email = parts[1].trim();
                String password = parts[2].trim();
                int age = Integer.parseInt(parts[3].trim());
                double currentWeight = Double.parseDouble(parts[4].trim());
                double goalWeight = Double.parseDouble(parts[5].trim());
                int dailyGoal = Integer.parseInt(parts[6].trim());
                int proteinGoal = Integer.parseInt(parts[7].trim());

                User user = new User(name, email, password, age, currentWeight,
                        goalWeight, dailyGoal, proteinGoal);
                users.add(user);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading users: " + e.getMessage());
        }
    }

    private void save() {
        File file = new File(USER_FILE);
        file.getParentFile().mkdirs();

        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            pw.println("name,email,password,age,currentWeight,goalWeight,dailyCalorieGoal,proteinGoal");
            for (User u : users) {
                pw.printf("%s,%s,%s,%d,%.1f,%.1f,%d,%d,%s%n",
                        u.getName(),
                        u.getEmail(),
                        u.getPassword(),
                        u.getAge(),
                        u.getCurrentWeight(),
                        u.getGoalWeight(),
                        u.getDailyCalorieGoal(),
                        u.getProteinGoal(),
                        //u.getCarbGoal(),
                        //u.getFatGoal(),
                        ""  // reserved
                );
            }
        } catch (IOException e) {
            System.err.println("Error saving users: " + e.getMessage());
        }
    }
}

