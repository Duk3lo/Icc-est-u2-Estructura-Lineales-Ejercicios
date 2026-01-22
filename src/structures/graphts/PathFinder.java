package structures.graphts;

import structures.node.Node;

public interface PathFinder <T>{
    PathResult<T> findPath(Grapht<T> grapht, Node<T> start, Node<T> end);
}
