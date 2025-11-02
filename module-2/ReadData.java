//Cameron Mendez
//11/01/2025
//Module-2
//ReadData.java

import java.io.*;

public class ReadData {
    public static void main(String[] args) {
        String filename = "CameronMendez_datafile.dat";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Reading data from " + filename + ":\n");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please run WriteData.java first.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
