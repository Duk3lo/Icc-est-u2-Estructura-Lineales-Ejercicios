package structures.trees;

import models.Person;
import structures.node.Node;

public class Tree<T extends Comparable<T>> {

    protected Node<T> root;

    public Tree() {
        this.root = null;
    }

    // INSERT
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

    public void inOrder() {
        inOrderRecursive(root);
    }

    protected void inOrderRecursive(Node<T> current) {
        if (current != null) {
            inOrderRecursive(current.left);
            System.out.println(current.value + " ");
            inOrderRecursive(current.right);
        }
    }

    public T search(T value) {
        return searchRecursive(root, value);
    }

    private T searchRecursive(Node<T> current, T value) {
        if (current == null) {
            return null;
        }

        int cmp = value.compareTo(current.value);

        if (cmp == 0) {
            return current.value;
        } else if (cmp < 0) {
            return searchRecursive(current.left, value);
        } else {
            return searchRecursive(current.right, value);
        }
    }

    public Person searchByAge(int age) {
        return searchByAgeRecursive(root, age);
    }

    private Person searchByAgeRecursive(Node<T> current, int age) {
        if (current == null) {
            return null;
        }

        Person p = (Person) current.value;

        if (p.getAge() == age) {
            return p;
        }

        Person leftResult = searchByAgeRecursive(current.left, age);
        if (leftResult != null) {
            return leftResult;
        }

        return searchByAgeRecursive(current.right, age);
    }
}
