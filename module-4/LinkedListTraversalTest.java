//Cameron Mendez
//11/08/2025
//Module-4



import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTraversalTest {

    public static void main(String[] args) {

        // Test with 50,000 integers
        runTest(50000);

        // Test with 500,000 integers
        runTest(500000);
    }

    public static void runTest(int size) {
        LinkedList<Integer> list = new LinkedList<>();

        // Fill the LinkedList
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        System.out.println("\n--- Testing list size: " + size + " ---");

        // Traverse using iterator
        long startIterator = System.nanoTime();
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endIterator = System.nanoTime();
        System.out.println("Iterator traversal time: " + (endIterator - startIterator) + " ns");

        // Traverse using get(index)
        long startGet = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long endGet = System.nanoTime();
        System.out.println("get(index) traversal time: " + (endGet - startGet) + " ns");
    }
}
