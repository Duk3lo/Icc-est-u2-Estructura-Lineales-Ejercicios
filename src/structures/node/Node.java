package structures.node;

import java.util.List;

public class Node<T> {

    public T value;
    public Node<T> left;
    public Node<T> right;

    // Nodo guarde listado de conocidos
    private List<Node<T>> conocidos;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.conocidos = null;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "N [" + value + "]";
    }

    /// SALIDA
    /// N[A] -> N[B] N[C]
    /// N[B] -> N[A] N[D]
    /// N[C] -> N[A] N[D]
    /// N[D] -> N[B] N[C]
}
