package structures.graphts.implementations;

import java.util.*;

import structures.graphts.Grapht;
import structures.graphts.PathFinder;
import structures.graphts.PathResult;
import structures.node.Node;

public class BFSPathFinder<T> implements PathFinder<T> {

    @Override
    public PathResult<T> findPath(Grapht<T> grapht, Node<T> start, Node<T> end) {

        Queue<Node<T>> queue = new LinkedList<>();
        Set<Node<T>> visited = new HashSet<>();
        Map<Node<T>, Node<T>> parent = new HashMap<>();
        List<Node<T>> visitados = new ArrayList<>();

        queue.add(start);
        visited.add(start);
        parent.put(start, null);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            visitados.add(current);

            if (current.equals(end)) {
                return new PathResult<>(visitados, buildPath(parent, end));
            }

            for (Node<T> neighbor : grapht.getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        // No se encontró camino
        return new PathResult<>(visitados, List.of());
    }

    private List<Node<T>> buildPath(Map<Node<T>, Node<T>> parent, Node<T> end) {
        List<Node<T>> path = new ArrayList<>();
        for (Node<T> at = end; at != null; at = parent.get(at)) {
            path.add(0, at);
        }
        return path;
    }
}
