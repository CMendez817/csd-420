//Cameron Mendez
//11/16/2025
//Module-5
//WordSorter


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;
import java.util.ArrayList;

public class WordSorter {

    public static void main(String[] args) {

        //Name of input file
        String filename = "collection_of_words.txt";

        //TreeSet automatically stores unique words AND keeps them sorted
        Set<String> uniqueWords = new TreeSet<>();

        // ------------------------------
        // READ WORDS FROM THE TEXT FILE
        // ------------------------------
        try (Scanner input = new Scanner(new File(filename))) {
            while (input.hasNext()) {
                //Clean up each word by removing punctuation/trimming
                String word = input.next().toLowerCase().replaceAll("[^a-zA-Z]", "");

                if (!word.isEmpty()) {
                    uniqueWords.add(word);  //TreeSet removes duplicates automatically
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not find " + filename);
            return;
        }

        // ----------------------------
        // DISPLAY ASCENDING ORDER
        // ----------------------------
        System.out.println("Non-duplicate words (Ascending Order):");
        for (String w : uniqueWords) {
            System.out.println(w);
        }

        // ----------------------------
        // DISPLAY DESCENDING ORDER
        // ----------------------------
        System.out.println("\nNon-duplicate words (Descending Order):");

        // Convert to a list so we can reverse the order
        ArrayList<String> descendingList = new ArrayList<>(uniqueWords);
        Collections.reverse(descendingList);

        for (String w : descendingList) {
            System.out.println(w);
        }

        // --------------------
        // RUN TEST
        // --------------------
        runTests(uniqueWords);
    }

    /**
     * Basic test code to ensure the program works correctly.
     */
    public static void runTests(Set<String> words) {
        System.out.println("\n--- Running Test Code ---");

        //Test #1: Ensure the set is not empty
        if (!words.isEmpty()) {
            System.out.println("PASS: Words were successfully loaded from file.");
        } else {
            System.out.println("FAIL: No words were loaded.");
        }

        //Test 32: Ensure words are unique by comparing size before and after adding duplicates
        int sizeBefore = words.size();
        words.add("test");
        words.add("test");
        int sizeAfter = words.size();

        if (sizeBefore + 1 == sizeAfter) {
            System.out.println("PASS: Duplicate entries are not allowed (TreeSet working correctly).");
        } else {
            System.out.println("FAIL: Duplicates were added incorrectly.");
        }

        System.out.println("--- Testing Complete ---");
    }
}
