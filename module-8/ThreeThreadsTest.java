//Cameron Mendez
//11/30/2025
//Module-8
//ThreeThreadsTest.java


public class ThreeThreadsTest {

    public static void main(String[] args) {

        //test letters
        for (int i = 0; i < 100; i++) {
            char c = (char) ('a' + Math.random() * 26);
            assert (c >= 'a' && c <= 'z') : "Letter thread produced invalid char";
        }

        //test numbers
        for (int i = 0; i < 100; i++) {
            char c = (char) ('0' + (int)(Math.random() * 10));
            assert (c >= '0' && c <= '9') : "Number thread produced invalid char";
        }

        //test special characters
        char[] specials = {'!', '@', '#', '$', '%', '&', '*'};
        for (int i = 0; i < 100; i++) {
            char c = specials[(int)(Math.random() * specials.length)];
            boolean match = false;

            for (char s : specials) {
                if (c == s) match = true;
            }

            assert match : "Special character thread produced invalid char";
        }

        System.out.println("All thread generator tests passed.");
    }
}
