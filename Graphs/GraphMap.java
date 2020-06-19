package Graphs;

import java.util.HashMap;
import java.util.Map;

public class GraphMap<T> {

    Map<T,Vertex> vertexmap = new HashMap<>();

    public class Vertex{
        T value;
        Map<Vertex,Integer> neighbours;
        public Vertex(T value){
            this.value=value;
            this.neighbours = new HashMap<>();
        }
    }

    // add vertex to the  vertexMap
    public void addVertex(T value){
        vertexmap.put(value,new Vertex(value));
    }

    // adding edge between two vertex
    public void addEdgeUnityWeight(T first , T sec){
        vertexmap.get(first).neighbours.put(vertexmap.get(sec),1);
        vertexmap.get(sec).neighbours.put(vertexmap.get(first),1);
    }

    // adding edge between two vertex having weight passed by user
    public void addEdgeWeight(T first, T sec,Integer weight){
        vertexmap.get(first).neighbours.put(vertexmap.get(sec),weight);
        vertexmap.get(sec).neighbours.put(vertexmap.get(first),weight);
    }

    // display the graph using map
    public void display(){
        for(Vertex vert :vertexmap.values()){
            System.out.print(vert.value+"=>");
            for(Vertex padosi: vert.neighbours.keySet()){
                System.out.print(padosi.value+" " + vert.neighbours.get(padosi)+" ,");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        GraphMap<String> graph = new GraphMap<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

//        graph.addEdgeUnityWeight("A","B");
//        graph.addEdgeUnityWeight("B","C");

        graph.addEdgeWeight("A","B",3);
        graph.addEdgeWeight("B","C",6);

        graph.display();
    }
}
