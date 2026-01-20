import java.util.List;
import java.util.Map;
import java.util.Set;

import models.Person;
import models.Maquina;
import controllers.MaquinasController;

import structures.node.Node;
import structures.graphts.Grapht;
import structures.maps.Maps;
import structures.trees.IntTree;
import structures.trees.Tree;
import structures.sets.Sets;

public class App {

    public static void main(String[] args) {
        runGraph();
        printTree();
        printIntTree();
        runMaps();
        runSets();
        runMaquinas();
        runGraphts();
    }

    // ===================== GRAPH =====================
    public static void runGraph() {
        System.out.println("\n=== GRAFOS ===");

        Grapht<String> grapht = new Grapht<>();

        Node<String> nA = new Node<>("A");
        Node<String> nB = new Node<>("B");
        Node<String> nC = new Node<>("C");
        Node<String> nD = new Node<>("D");

        grapht.addNode(nA);
        grapht.addEdge(nA, nB);
        grapht.addEdge(nA, nC);
        grapht.addEdge(nB, nD);
        grapht.addEdge(nC, nD);

        grapht.printGraphts();

        List<Node<String>> neighbors = grapht.getNeighbors(nA);
        System.out.print("Conectados de A: ");
        for (Node<String> neighbor : neighbors) {
            System.out.print(neighbor.getValue() + " ");
        }
        System.out.println();
    }

    // ===================== TREE PERSON =====================
    public static void printTree() {
        System.out.println("\n=== ÁRBOL DE PERSONAS ===");

        Tree<Person> tree = new Tree<>();
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

    // ===================== TREE INT =====================
    public static void printIntTree() {
        System.out.println("\n=== ÁRBOL DE ENTEROS ===");

        IntTree tree = new IntTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(3);
        tree.insert(15);

        System.out.println("Pre Order");
        tree.preOrder();

        System.out.println("Post Order");
        tree.posOrder();

        System.out.println("In Order");
        tree.inOrder();

        System.out.println("Size: " + tree.size());
    }

    // ===================== MAPS =====================
    private static void runMaps() {
        System.out.println("\n=== MAPAS ===");

        Maps maps = new Maps();

        Map<String, Integer> hashMap = maps.construirHashMap();
        System.out.println("HashMap: " + hashMap);

        Map<String, Integer> linkedMap = maps.construirLinkedHashMap();
        System.out.println("LinkedHashMap: " + linkedMap);

        Map<String, Integer> treeMap = maps.construirTreeMap();
        System.out.println("TreeMap: " + treeMap);

        Map<Person, Integer> mapaPersonas = maps.construirTreeMapPersons();
        System.out.println("Map Personas: " + mapaPersonas);

        maps.printFilter(mapaPersonas);
    }

    // ===================== SETS =====================
    public static void runSets() {
        System.out.println("\n=== SETS ===");

        Sets sets = new Sets();

        Set<String> hashSet = sets.cosntruirHashSet();
        System.out.println(hashSet);
        System.out.println("Size: " + hashSet.size());
        System.out.println("Contains A: " + hashSet.contains("A"));

        String a1 = "A";
        String a2 = "A";

        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());
        System.out.println(a1.equals(a2));
        System.out.println(a1 == a2);

        Node<String> n1 = new Node<>("A");
        Node<String> n2 = new Node<>("A");

        System.out.println(n1.hashCode());
        System.out.println(n2.hashCode());
        System.out.println(n1.equals(n2));

        Set<String> linkedSet = sets.cosntruirLinkedHashSet();
        System.out.println("LinkedHashSet: " + linkedSet);

        Set<String> treeSet = sets.cosntruirTreeSet();
        System.out.println("TreeSet: " + treeSet);

        Set<String> treeSetComparator = sets.cosntruirTreeSetConComparador();
        System.out.println("TreeSet Comparator: " + treeSetComparator);

        Set<Person> treeSetPersonas = sets.construirTreeSetPersonasConComparador();
        System.out.println("TreeSet Personas: " + treeSetPersonas);
    }

    // ===================== MAQUINAS =====================
    private static void runMaquinas() {
        System.out.println("\n=== ANÁLISIS DE MÁQUINAS ===");

        List<Maquina> maquinas = MaquinasController.crearMaquinas();
        for (Maquina m : maquinas) {
            System.out.println(m);
        }
    }

    public static void runGraphts() {
    Grapht<Person> grapht = new Grapht<>();

    Person pc23 = new Person("Carlos", 23);
    Person pL18 = new Person("Luis", 18);
    Person pA28 = new Person("Ana", 28);
    Person pA30 = new Person("Ana", 30);
    Person pJ25 = new Person("Jose", 25);
    Person pAn20 = new Person("Andres", 20);

    Node<Person> nCarlos = new Node<>(pc23);
    Node<Person> nLuis = new Node<>(pL18);
    Node<Person> nAna28 = new Node<>(pA28);
    Node<Person> nAna30 = new Node<>(pA30);
    Node<Person> nJose = new Node<>(pJ25);
    Node<Person> nAndres = new Node<>(pAn20);

    grapht.addEdge(nCarlos, nLuis);
    grapht.addEdge(nCarlos, nAna28);
    grapht.addEdge(nLuis, nJose);
    grapht.addEdge(nAna28, nAndres);
    grapht.addEdge(nJose, nAna30);
    System.out.println("=== GRAFO ===");
    grapht.printGraphts();
    System.out.println("\n=== BFS desde Carlos ===");
    grapht.bfs(nCarlos);
    System.out.println("\n\n=== DFS desde Carlos ===");
    grapht.dfs(nCarlos);
}
}
