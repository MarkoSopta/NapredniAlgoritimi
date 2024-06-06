package cetvrtaZadaca;
import java.util.List;
import java.util.Random;

public class RandomDataGenerator {

    // Dodavanje n jedinstvenih slučajnih podataka u listu
    public static void addRandomData(List<Integer> list, int n, int seed) {
        Random rand = new Random(seed);
            int min = 1;
            int max = Integer.MAX_VALUE - 1;

            for (int i = 0; i < n; i++) {
                int data = generateRandomData(rand, min, max);
                list.add(data);
                max--;
        }
    }

    // Dodavanje n jedinstvenih slučajnih podataka u linked list
    public static void addRandomData(LinkedList list, int n, int seed) {
        Random rand = new Random(seed);
        int min = 1;
        int max = Integer.MAX_VALUE - 1;

        for (int i = 0; i < n; i++) {
            int data = generateRandomData(rand, min, max);
            list.append(data);
            max--;
        }
    }

    // Metoda za generiranje jedinstvenog slučajnog podatka
    private static int generateRandomData(Random rand, int min, int max) {
        int range = max - min + 1;
        return rand.nextInt(range) + min;
    }
}
