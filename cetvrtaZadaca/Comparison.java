package cetvrtaZadaca;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Comparison {

    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        List<Integer> javaList = new ArrayList<>();

        // Generiranje i dodavanje slučajnih podataka u obje liste
        Random rand = new Random();
        RandomDataGenerator.addRandomData(myList, 1_000_0, 1);
        RandomDataGenerator.addRandomData(javaList, 1_000_0, 1);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Pritisnite razmak za pretragu novog broja (ili 'exit' za izlaz): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            if (input.equals(" ")) {

                int randomNumber = javaList.get(rand.nextInt(javaList.size()));


                long startTimeMyList = System.nanoTime();
                myList.search(randomNumber);
                long endTimeMyList = System.nanoTime();
                double durationMyList = (endTimeMyList - startTimeMyList) / 1_000_000.0;

                long startTimeJavaList = System.nanoTime();
                boolean found = javaList.contains(randomNumber);
                long endTimeJavaList = System.nanoTime();
                double durationJavaList = (endTimeJavaList - startTimeJavaList) / 1_000_000.0;



                System.out.printf("Pretraga broja %d u SearchListi: %.9f ms\n", randomNumber, durationMyList);
                System.out.printf("Pretraga broja %d u obicnoj Listi: %.9f ms\n", randomNumber, durationJavaList);
            }
        }
        scanner.close();
    }
}



