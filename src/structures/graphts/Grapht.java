package structures.graphts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import structures.node.Node;

public class Grapht<T>{

    //1 forma
    // TRABAJA CON LISTADO DE ADYACENCIA
    //List<Node<T>> nodes;

    // 2Da forma
    private Map<Node<T>, List<Node<T>>> mapa;

    public Grapht() {
        this.mapa = new HashMap<>();
    }

    public void addNode(Node<T> node){
        this.mapa.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(Node<T> n1, Node<T> n2){
        addNode(n1);
        addNode(n2);
        mapa.get(n1).add(n2);
        mapa.get(n2).add(n1);
    }

    public List<Node<T>> getNeighbors(Node<T> node) {
        return mapa.getOrDefault(node, new ArrayList<>());
    }

    public void printGraphts(){
        for(Map.Entry<Node<T>, List<Node<T>>> entry : mapa.entrySet()){
            System.out.print("Nodo: " + entry.getKey().getValue() + " -> ");
            for(Node<T> neighbor : entry.getValue()){
                System.out.print(neighbor.getValue() + " ");
            }
            System.out.println();
        }
    }
    
}
