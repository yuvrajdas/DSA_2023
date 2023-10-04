package Graph;

import java.util.*;

public class __8IsGraphConnected {
    public static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }   
    public static ArrayList<Edge>[] constructGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[1].add(new Edge(1, 0, 10));

        graph[2].add(new Edge(2, 3, 20));
        graph[3].add(new Edge(3, 2, 20));

        graph[4].add(new Edge(4, 5, 15));
        graph[4].add(new Edge(4, 6, 25));

        graph[5].add(new Edge(5, 4, 15));
        graph[5].add(new Edge(5, 6, 30));

        graph[6].add(new Edge(6, 5, 30));
        graph[6].add(new Edge(6, 4, 25));

        return graph;
    }
    public static void isGraphConnected(ArrayList<Edge> graph[], boolean visited[], int src, ArrayList<Integer> comp){
        visited[src] = true;
        comp.add(src);

        for(Edge i : graph[src]){
            int nbr = i.dest;
            if(visited[nbr] == false){
                isGraphConnected(graph, visited, nbr, comp);
            }
        }
    }
    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        constructGraph(graph);
        boolean visited[] = new boolean[v];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for(int i=0; i<v; i++){
            if(visited[i] == false){
                ArrayList<Integer> comp = new ArrayList<>();
                isGraphConnected(graph, visited, i, comp);
                comps.add(comp);
            }
        }
        System.out.println(comps.size()==1);
    }
}
