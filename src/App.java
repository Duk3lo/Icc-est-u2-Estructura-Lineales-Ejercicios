import models.Person;
import structures.trees.IntTree;
import structures.trees.Tree;

public class App {
    public static void main(String[] args) {

        printTree();
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
