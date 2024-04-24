package drugaZadaca;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.util.ArrayList;
import java.util.List;

public class treeImpl {
   public static class Node {

        private String value;
        private Node parent;
        private final List<Node> children;

        public Node(String value) {
            this.value = value;
            this.children = new ArrayList<>();
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void addChild(Node child) {
            children.add(child);
            child.setParent(this);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", children=" + children +
                    '}';
        }
    }

    public static class Tree {

        private final Node root;

        public Tree(String rootValue) {
            this.root = new Node(rootValue);

        }

        public Node getRoot() {
            return root;
        }

        public void addChild(Node parent, Node child) {
            parent.addChild(child);
        }

        public void printTree(Node node) {
            if (node == null) {
                return;
            }

            System.out.println(node.getValue());
            for (Node child : node.getChildren()) {
                printTree(child);
            }
        }

        public static void main(String[] args){

        }
    }
}
