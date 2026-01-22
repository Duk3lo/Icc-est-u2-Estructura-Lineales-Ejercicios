package structures.graphts.implementations;

import java.util.*;

import structures.graphts.Grapht;
import structures.graphts.PathFinder;
import structures.graphts.PathResult;
import structures.node.Node;

public class DFSPathFinder<T> implements PathFinder<T> {

    @Override
    public PathResult<T> findPath(Grapht<T> grapht, Node<T> start, Node<T> end) {

        Set<Node<T>> visited = new HashSet<>();
        Map<Node<T>, Node<T>> parent = new HashMap<>();
        List<Node<T>> visitados = new ArrayList<>();

        boolean found = dfs(grapht, start, end, visited, parent, visitados);

        if (!found) {
            return new PathResult<>(visitados, List.of());
        }

        return new PathResult<>(visitados, buildPath(parent, end));
    }

    private boolean dfs(
            Grapht<T> grapht,
            Node<T> current,
            Node<T> end,
            Set<Node<T>> visited,
            Map<Node<T>, Node<T>> parent,
            List<Node<T>> visitados
    ) {
        visited.add(current);
        visitados.add(current);

        if (current.equals(end)) {
            return true;
        }

        for (Node<T> neighbor : grapht.getNeighbors(current)) {
            if (!visited.contains(neighbor)) {
                parent.put(neighbor, current);
                if (dfs(grapht, neighbor, end, visited, parent, visitados)) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<Node<T>> buildPath(Map<Node<T>, Node<T>> parent, Node<T> end) {
        List<Node<T>> path = new ArrayList<>();
        for (Node<T> at = end; at != null; at = parent.get(at)) {
            path.add(0, at);
        }
        return path;
    }
}
