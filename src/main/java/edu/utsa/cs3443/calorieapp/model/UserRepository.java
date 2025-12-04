package edu.utsa.cs3443.calorieapp.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code UserRepository} class manages persistent storage and retrieval
 * of {@link User} objects using a CSV file. It acts as a simple database layer
 * for creating, loading, saving, and searching users in the application.
 *
 * <p>The repository automatically loads existing users from
 * {@code data/users.csv} when instantiated, and writes all changes back to the
 * file when users are added.</p>
 */


public class UserRepository {

    /**
     * The path to the CSV file where user information is stored.
     */

    private static final String USER_FILE = "data/users.csv";

    /**
     * An in-memory list of all registered users.
     */


    private List<User> users = new ArrayList<>();

    /**
     * Constructs a new {@code UserRepository} and immediately loads all
     * existing users from the CSV file into memory.
     */

    public UserRepository() {
        load();
    }


    /**
     * Returns the list of all users currently stored in memory.
     *
     * @return a {@code List<User>} containing all loaded users
     */

    public List<User> getUsers() {
        return users;
    }

    /**
     * Adds a new user to the repository and immediately saves the updated
     * user list to the application
     *
     * @param user the {@code User} object to add
     */

    public void addUser(User user) {
        users.add(user);
        save();
    }

    /**
     * Searches for a user by email (case-insensitive).
     *
     * @param email the email address to search for
     * @return the matching {@code User}, or {@code null} if no match is found
     */

    public User findByEmail(String email) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null;
    }
    /**
     * Loads user data from the CSV file into memory. If the file does not
     * exist, the method initializes an empty user list and ensures that the
     * directory structure exists.
     *
     * <p>This method reads and parses each CSV line into a {@code User} object.
     * Lines with insufficient fields within the file are skipped.</p>
     */

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

    /**
     * Saves all users currently stored in memory to the CSV file. If the file
     * or its parent directory does not exist, they are created automatically.
     *
     * <p> Keep in mind that all user data is written in CSV format, including a header row.</p>
     */

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

