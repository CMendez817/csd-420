//Cameron Mendez
//11/08/2025
//Module-3


import java.util.ArrayList;
import java.util.Random;

public class RemoveDuplicatesTest {
    
    public static void main(String[] args) {
        // Create original list with 50 random integers from 1–20
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(20) + 1); // 1 to 20
        }

        System.out.println("Original List (with duplicates):");
        System.out.println(originalList);

        // Call the removeDuplicates method
        ArrayList<Integer> newList = removeDuplicates(originalList);

        System.out.println("\nNew List (no duplicates):");
        System.out.println(newList);
    }

    // Generic method to remove duplicates and return a new ArrayList
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> result = new ArrayList<>();

        for (E element : list) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }

        return result;
    }
}
