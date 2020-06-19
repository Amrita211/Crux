package Graphs;



import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphLinkedList<T> {

    LinkedList<Vertex> vertices = new LinkedList<>();
    public class Vertex{
        T value;
         LinkedList<Vertex> neighbours;
         public Vertex(T value){
             this.value = value;
             this.neighbours= new LinkedList<>();
         }
    }

    // inserting all vertex to the outer LInkedList , vertices
    public void insert(T value){
        vertices.add(new Vertex(value));
    }

    // insert an edge between two vertex
    public void addEdge(T first, T sec){
        Vertex f=getVertex(first);
        Vertex s = getVertex(sec);
        if(f!=null && s!=null){
            s.neighbours.add(f);
            f.neighbours.add(s);
        }
    }
    public Vertex getVertex(T value){
        for(Vertex vert:vertices){
            if(vert.value.equals(value)){
                return vert;
            }
        }
        return null;
    }

    // breadth first search[BFS]

    public void BFS(){
        Queue<Vertex> que = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        Vertex first = vertices.get(0);
        que.add(first);
        visited.add(first);

        while(!que.isEmpty()){
            Vertex temp = que.remove();
            System.out.print(temp.value +" ");
            for(Vertex padosi: temp.neighbours){
                if(!visited.contains(padosi)){
                    que.add(padosi);
                    visited.add(padosi);
                }
            }
        }
    }

    // Count the connected components
    public void connectedComponents(){
        Queue<Vertex> que = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        int count=0;
        for(Vertex vert:vertices){
            if(visited.contains(vert)){
                continue;
            }
            que.add(vert);
            visited.add(vert);

            while(!que.isEmpty()){
                Vertex temp = que.remove();
                System.out.print(temp.value +" ");
                for(Vertex padosi: temp.neighbours){
                    if(!visited.contains(padosi)){
                        que.add(padosi);
                        visited.add(padosi);
                    }
                }
            }
            count++;
        }
        System.out.println("No.of components is :- " + count);
    }

    // Bipartie [if color alternate vertices of a vertex is not same then it is said bipartie otherwise not]
    public boolean isBipartie(){
        Queue<Vertex> que = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        Set<Vertex> red = new HashSet<>();
        Set<Vertex> green = new HashSet<>();

        Vertex first = vertices.get(0);
        que.add(first);
        visited.add(first);
        red.add(first);
        while(!que.isEmpty()){
            Vertex temp = que.remove();
            if(red.contains(temp)){
                for(Vertex padosi: temp.neighbours){
                    if(!visited.contains(padosi)){
                        que.add(padosi);
                        green.add(padosi);
                        visited.add(padosi);
                    }
                    else if(red.contains(padosi)){
                        return false;
                    }
                }
            }

            if(green.contains(temp)){
                for(Vertex padosi: temp.neighbours){
                    if(!visited.contains(padosi)){
                        que.add(padosi);
                        red.add(padosi);
                        visited.add(padosi);
                    }
                    else if(green.contains(padosi)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // display

    public void display(){
        for(Vertex vert:vertices){
            System.out.print(vert.value+"=>");
            for(Vertex padosi:vert.neighbours){
                System.out.print(padosi.value+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphLinkedList<String> graph = new GraphLinkedList<>();
        graph.insert("A");
        graph.insert("B");
        graph.insert("C");
        graph.insert("D");
//        graph.insert("E");
//        graph.insert("F");



        graph.addEdge("A","B");
        graph.addEdge("A","C");
        graph.addEdge("C", "D");
        graph.addEdge("A","D");


        graph.display();

        System.out.println();
        graph.BFS();

        System.out.println();
        graph.connectedComponents();

        System.out.println();
        System.out.println(graph.isBipartie());
    }
}
