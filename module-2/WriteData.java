//Cameron Mendez
//11/01/2025
//Module-2
//WriteData.java

import java.io.*;
import java.util.Random;

public class WriteData {
    public static void main(String[] args) {
        String filename = "CameronMendez_datafile.dat"; //file name
        Random random = new Random();

        try (FileWriter fw = new FileWriter(filename, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            //Create and write 5 random integers
            int[] intArray = new int[5];
            out.print("Integers: ");
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = random.nextInt(100); //0–99
                out.print(intArray[i] + " ");
            }
            out.println();

            //Create and write 5 random doubles
            double[] doubleArray = new double[5];
            out.print("Doubles: ");
            for (int i = 0; i < doubleArray.length; i++) {
                doubleArray[i] = random.nextDouble() * 100; //0.0–99.9
                out.printf("%.2f ", doubleArray[i]);
            }
            out.println();
            out.println("------------------------------------");

            System.out.println("Data successfully written to " + filename);

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
