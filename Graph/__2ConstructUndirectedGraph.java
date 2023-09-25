package Graph;

import java.util.*;

public class __2ConstructUndirectedGraph {
    
    static class Edege{
        int src;
        int dest;

        Edege(int src, int dest){
            this.src = src;
            this.dest =dest;
        }
    }

    public static void constructGraph(ArrayList<Edege> graph[]) {
       
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        System.out.println(Arrays.toString(graph));
    }
    public static void main(String[] args) {
        int vertices = 4;
        ArrayList<Edege> graph[] = new ArrayList[vertices];
        constructGraph(graph);
    }
}
