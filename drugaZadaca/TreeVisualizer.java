package drugaZadaca;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import drugaZadaca.treeImpl.Tree;
import drugaZadaca.treeImpl.Node;

public class TreeVisualizer extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a Tree representing the hierarchy
        Tree tree = createTree();

        // Convert Tree.Node to TreeView.TreeItem
        TreeItem<String> rootItem = new TreeItem<>(tree.getRoot().getValue());
        convertNodeToTreeItem(tree.getRoot(), rootItem);

        // Create a TreeView
        TreeView<String> treeView = new TreeView<>(rootItem);

        // Set the root node and display the tree
        StackPane rootPane = new StackPane();
        rootPane.getChildren().add(treeView);

        Scene scene = new Scene(rootPane, 400, 300);
        primaryStage.setTitle("Tree Visualization");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Tree createTree() {

        Tree tree1 = new Tree("Root");

        Node node1 = new Node("Node 1");
        Node node2 = new Node("Node 2");
        Node node3 = new Node("Node 3");
        Node node4 = new Node("Node 4");
        Node node5 = new Node("Node 5");

        tree1.addChild(tree1.getRoot(), node1);
        tree1.addChild(tree1.getRoot(), node2);
        tree1.addChild(tree1.getRoot(), node4);
        tree1.addChild(tree1.getRoot(), node5);
        tree1.addChild(node1, node3);

        return tree1;


    }

        private void convertNodeToTreeItem(Node node, TreeItem<String> treeItem) {
            for (Node child : node.getChildren()) {
                TreeItem<String> childItem = new TreeItem<>(child.getValue());
                treeItem.getChildren().add(childItem);
                convertNodeToTreeItem(child, childItem);
            }
        }

    public static void main(String[] args) {
        launch(args);

    }

}