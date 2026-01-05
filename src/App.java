import structures.trees.IntTree;

public class App {
    public static void main(String[] args) {
        IntTree tree = new IntTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(3);
        tree.insert(15);
        System.out.println("Pre Order");
        tree.preOrder();
        System.out.println("Pos Order");
        tree.posOrder();
        System.out.println("In Order");
        tree.inOrder();
        System.out.println("Size: " + tree.size());

    }
}
