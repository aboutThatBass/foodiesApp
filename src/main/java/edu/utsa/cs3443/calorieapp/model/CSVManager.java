package edu.utsa.cs3443.calorieapp.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for managing simple CSV (or plain text) file operations.
 * <p>
 * The {@code CSVManager} provides helper methods to:
 * <ul>
 *     <li>Create a file if it does not already exist</li>
 *     <li>Read all lines from a file</li>
 *     <li>Write a list of lines to a file (overwriting existing content)</li>
 *     <li>Append a single line to a file</li>
 * </ul>
 * <p>
 * All methods operate on file paths provided as strings and automatically
 * ensure that the file and its parent directories exist before performing I/O.
 */

public class CSVManager {


    /**
     * Returns a {@link File} object for the given filename, creating the file
     * and any necessary parent directories if they do not already exist.
     *
     * @param filename the path of the file to retrieve or create
     * @return the existing or newly created {@code File} object
     * @throws RuntimeException if the file cannot be created
     */

    public static File getOrCreate(String filename) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            return file;
        } catch (IOException e) {
            throw new RuntimeException("Could not create file: " + filename, e);
        }
    }

    /**
     * Reads all lines from the specified file.
     * <p>
     * If the file does not exist, it will be created before reading.
     *
     * @param filename the path of the file to read
     * @return a list containing all lines from the file (empty if the file is empty)
     */

    public static List<String> readAll(String filename) {
        File file = getOrCreate(filename);
        List<String> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null)
                list.add(line);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Writes all provided lines to the specified file, overwriting any existing content.
     * <p>
     * If the file does not exist, it will be created.
     *
     * @param filename the path of the file to write to
     * @param lines the lines within the file, which is used to write into the created/ existing file
     */

    public static void writeAll(String filename, List<String> lines) {
        File file = getOrCreate(filename);
        try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
            for (String s : lines)
                out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Appends a single line to the end of the specified file.
     * <p>
     * If the file does not exist, it will be created.
     *
     * @param filename the file to append to
     * @param line the line within the file that is being appended
     */

    public static void append(String filename, String line) {
        File file = getOrCreate(filename);
        try (PrintWriter out = new PrintWriter(new FileWriter(file, true))) {
            out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

