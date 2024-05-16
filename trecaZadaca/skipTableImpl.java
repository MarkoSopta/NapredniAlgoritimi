package trecaZadaca;

import java.util.Random;

class SkipListNode {
    int value;
    SkipListNode[] forward;

    public SkipListNode(int value, int level) {
        this.value = value;
        this.forward = new SkipListNode[level + 1];
    }
}

class SkipList {
    private static final int MAX_LEVEL = 3;
    private final SkipListNode head;
    private int level;
    private final Random random;

    public SkipList() {
        this.level = MAX_LEVEL;
        this.head = new SkipListNode(Integer.MIN_VALUE, MAX_LEVEL);
        this.random = new Random();
    }

    private int randomLevel() {
        int lvl = 0;
        while (lvl < MAX_LEVEL && random.nextInt(4) != 0) {
            lvl++;
        }
        return lvl;
    }

    public void insert(int value, int newLevel) {

        // niz koji prati  sve cvorove koje treba azurirat
        SkipListNode[] update = new SkipListNode[MAX_LEVEL + 1];
        SkipListNode current = head;

        // dodati novi cvor na odgovarajucu lokaciju
        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < value) {
                current = current.forward[i];
            }
            update[i] = current;
        }
        // azurirati levele
        if (newLevel > level) {
            for (int i = level + 1; i <= newLevel; i++) {
                update[i] = head;
            }
            level = newLevel;
        }
        // ubaci novi cvor
        SkipListNode newNode = new SkipListNode(value, newLevel);
        for (int i = 0; i <= newLevel; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    public void printByLevel() {
        for (int i = 0; i<= level; i++) {
            SkipListNode current = head.forward[i];
            System.out.print("Level " + i + ": ");
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.forward[i];
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();

        skipList.insert(2, MAX_LEVEL);
        skipList.insert(4, skipList.randomLevel());
        skipList.insert(6, skipList.randomLevel());
        skipList.insert(8, skipList.randomLevel());
        skipList.insert(10, skipList.randomLevel());


        skipList.insert(7, skipList.randomLevel());


        skipList.printByLevel();
    }
}

