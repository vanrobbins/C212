package vanar.lab8gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVRead {
     public static List<String[]> readCSV(File file) throws IOException {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip the header
                    continue;
                }

                String[] row = line.trim().split(",");
                for (int i = 0; i < row.length; i++) {
                    row[i] = row[i].replace("\"", "").trim();
                }
                data.add(row);
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
            throw e;
        }
        return data;
    }

}
