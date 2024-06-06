package cetvrtaZadaca;

public class Node {
    int data;
    Node next;
    int searchCount;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.searchCount = 0;
    }
}
