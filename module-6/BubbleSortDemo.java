//Cameron Mendez
//11/23/2025
//Module-6


import java.util.Comparator;

//BubbleSort
public class BubbleSortDemo {

    //Bubble sort using Comparable.
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int i = 0; i < list.length - 1; i++) {

            for (int j = 0; j < list.length - 1 - i; j++) {

                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    //Bubble sort using Comparator.
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {

            for (int j = 0; j < list.length - 1 - i; j++) {

                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    //Single minimal test case for both methods
   
    public static void main(String[] args) {

        // Test using Comparable
        Integer[] numbers = { 5, 3, 1, 4, 2 };
        bubbleSort(numbers);
        System.out.println("Sorted with Comparable:");
        for (Integer n : numbers) {
            System.out.print(n + " ");
        }

        System.out.println();

        //Test using Comparator
        String[] words = { "pear", "apple", "orange" };
        Comparator<String> alphabetical = (a, b) -> a.compareTo(b);

        bubbleSort(words, alphabetical);
        System.out.println("Sorted with Comparator:");
        for (String w : words) {
            System.out.print(w + " ");
        }
    }
}
