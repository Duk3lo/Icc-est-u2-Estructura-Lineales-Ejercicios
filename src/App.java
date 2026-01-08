import java.util.List;

import models.Person;
import structures.graphts.Grapht;
import structures.node.Node;
import structures.trees.IntTree;
import structures.trees.Tree;

public class App {
    public static void main(String[] args) {

        runGraph();
    }

    public static void runGraph() {
        Grapht<String> grapht = new Grapht<>();

        Node<String> nA = new Node<String>("A");
        Node<String> nB = new Node<String>("B");
        Node<String> nC = new Node<String>("C");
        Node<String> nD = new Node<String>("D");

        grapht.addNode(nA);
        grapht.addEdge(nA, nB);
        grapht.addEdge(nA, nC);
        grapht.addEdge(nB, nD);
        grapht.addEdge(nC, nD);
        grapht.printGraphts();

        // Conectados de A
        List<Node<String>> neighbors = grapht.getNeighbors(nA);

        System.out.print("Conocidos de A: ");
        for (Node<String> neighbor : neighbors) {
            System.out.print(neighbor.getValue() + " ");
        }
    }

    public static void printTree() {
        Tree<Person> tree = new Tree<Person>();
        tree.insert(new Person("Pablo", 21));
        tree.insert(new Person("Maria", 23));
        tree.insert(new Person("Ana", 25));
        tree.insert(new Person("Pedro", 23));
        tree.insert(new Person("Luis", 19));
        tree.inOrder();

        Person findPerson = tree.searchByAge(23);
        if (findPerson != null) {
            System.out.println("Found: " + findPerson);
        } else {
            System.out.println("Person not found");

        }
    }

    public static void printIntTree() {
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
