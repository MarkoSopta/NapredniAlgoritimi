package cetvrtaZadaca;
import java.util.Scanner;

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // Dodavanje novog čvora na kraj liste
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    // Pretraživanje liste i ažuriranje pozicija čvorova
    public void search(int key) {
        Node current = head;
        Node previous = null;
        Node searchNode = null;
        Node searchNodePrevious = null;


        while (current != null) {
            if (current.data == key) {
                current.searchCount++;
                searchNode = current;
                searchNodePrevious = previous;
                break;
            }
            previous = current;
            current = current.next;
        }

        if (searchNode == null) {
            System.out.println("Čvor " + key + " nije pronađen.");
            return;
        }


        if (searchNode == head) {
            return;
        }

        // Ako je čvor pronađen, pomakni ga na odgovarajuću poziciju
        if (searchNodePrevious != null) {
            searchNodePrevious.next = searchNode.next;
        }

        // Ponovno umetni čvor na odgovarajuću poziciju
        if (head.searchCount < searchNode.searchCount) {
            // Stavi čvor na prvo mjesto ako ima više pretraga od trenutnog prvog čvora
            searchNode.next = head;
            head = searchNode;
        } else {
            // Pronađi odgovarajuću poziciju za čvor
            Node temp = head;
            Node tempPrev = null;
            while (temp != null && temp.searchCount >= searchNode.searchCount) {
                tempPrev = temp;
                temp = temp.next;
            }
            if (tempPrev != null) {
                tempPrev.next = searchNode;
            }
            searchNode.next = temp;
        }
    }

    public void displayTop5() {
        Node current = head;
        int count = 0;
        while (current != null && count < 5) {
            System.out.print(current.data + "(" + current.searchCount + ") -> ");
            current = current.next;
            count++;
        }
        System.out.println(count == 5 ? "..." : "null");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        for (int i = 1; i <100 ; i++) {
           ll.append(i);
        }


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Top 5 najtraženijih čvorova: ");
            ll.displayTop5();
            System.out.print("Unesite broj za pretragu (ili 'exit' za izlaz): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                ll.search(number);
            } catch (NumberFormatException e) {
                System.out.println("Unesite valjani broj.");
            }
        }
        scanner.close();
    }
}
