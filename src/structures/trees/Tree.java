package structures.trees;
import structures.node.Node;

public class Tree<T extends Comparable<T>> {

    protected Node<T> root;

    public Tree() {
        this.root = null;
    }

    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    protected Node<T> insertRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value.compareTo(current.value) < 0) {
            current.left = insertRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }
}
