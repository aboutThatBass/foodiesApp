package edu.utsa.cs3443.calorieapp.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVManager {

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

    public static void writeAll(String filename, List<String> lines) {
        File file = getOrCreate(filename);
        try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
            for (String s : lines)
                out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void append(String filename, String line) {
        File file = getOrCreate(filename);
        try (PrintWriter out = new PrintWriter(new FileWriter(file, true))) {
            out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

