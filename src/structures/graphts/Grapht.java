package structures.graphts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import structures.node.Node;

public class Grapht<T> {

    // 1 forma
    // TRABAJA CON LISTADO DE ADYACENCIA
    // List<Node<T>> nodes;

    // 2Da forma
    private Map<Node<T>, List<Node<T>>> mapa;

    public Grapht() {
        this.mapa = new HashMap<>();
    }

    public void addNode(Node<T> node) {
        this.mapa.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(Node<T> n1, Node<T> n2) {
        addNode(n1);
        addNode(n2);
        mapa.get(n1).add(n2);
        mapa.get(n2).add(n1);
    }

    public List<Node<T>> getNeighbors(Node<T> node) {
        return mapa.getOrDefault(node, new ArrayList<>());
    }

    public void printGraphts() {
        for (Map.Entry<Node<T>, List<Node<T>>> entry : mapa.entrySet()) {
            System.out.print("Nodo: " + entry.getKey().getValue() + " -> ");
            for (Node<T> neighbor : entry.getValue()) {
                System.out.print(neighbor.getValue() + " ");
            }
            System.out.println();
        }
    }

    public void bfs(Node<T> start) {
        Set<Node<T>> visited = new HashSet<>();
        Queue<Node<T>> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            System.out.print(current.getValue() + " ");

            for (Node<T> neighbor : getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public void dfs(Node<T> start) {
        List<Node<T>> visited = new ArrayList<>();
        dfsRecursive(start, visited);
    }

    private void dfsRecursive(Node<T> node, List<Node<T>> visited) {
        visited.add(node);
        System.out.print(node.getValue() + " ");

        for (Node<T> neighbor : getNeighbors(node)) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public void addEdgeDirected(Node<T> from, Node<T> to) {
        addNode(from);
        addNode(to);
        mapa.get(from).add(to);
    }
}
