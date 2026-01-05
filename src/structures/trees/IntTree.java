package structures.trees;

import structures.node.Node;

public class IntTree {

    private Node<Integer> root;

    public IntTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node<Integer> insertRecursive(Node<Integer> current, int value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }

    /* ================= PRE ORDER ================= */
    public void preOrder() {
        preOrderRecursive(root);
        System.out.println();
    }

    private void preOrderRecursive(Node<Integer> current) {
        if (current == null)
            return;

        System.out.print(current.value + " ");
        preOrderRecursive(current.left);
        preOrderRecursive(current.right);
    }

    /* ================= IN ORDER ================= */
    public void inOrder() {
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(Node<Integer> current) {
        if (current == null)
            return;

        inOrderRecursive(current.left);
        System.out.print(current.value + " ");
        inOrderRecursive(current.right);
    }

    /* ================= POST ORDER ================= */
    public void posOrder() {
        posOrderRecursive(root);
        System.out.println();
    }

    private void posOrderRecursive(Node<Integer> current) {
        if (current == null)
            return;

        posOrderRecursive(current.left);
        posOrderRecursive(current.right);
        System.out.print(current.value + " ");
    }

    /* ================= SIZE ================= */
    public int size() {
        return sizeRecursive(root);
    }

    private int sizeRecursive(Node<Integer> current) {
        if (current == null) {
            return 0;
        }

        return 1 + sizeRecursive(current.left) + sizeRecursive(current.right);
    }

}
