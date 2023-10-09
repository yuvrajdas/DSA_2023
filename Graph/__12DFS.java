package Graph;

import java.util.*;

public class __12DFS {
    public static class Edge{
        int src;
        int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static ArrayList<Edge>[] constructGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));

        return graph;
    }
    public static void dfs(ArrayList<Edge> graph[], boolean visited[], int src){
        System.out.print(src+" ");
        visited[src] = true;
        for(Edge e : graph[src]){
            int nbr = e.dest;
            if(!visited[nbr]){
                dfs(graph, visited, nbr);
            }
        }
    }
    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        constructGraph(graph);
        boolean visited[] = new boolean[v];
        dfs(graph, visited, 0);
    }
}
