package Graph;

import java.util.*;

public class __3UndirectedWeightedGraph {
    public static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void constructGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2, 5));

        graph[1].add(new Edge(1, 2, 6));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 0, 5));
        graph[2].add(new Edge(2, 1, 6));
        graph[2].add(new Edge(2, 3, -1));

        graph[3].add(new Edge(3, 2, -1));
        graph[3].add(new Edge(3, 1, 7));
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        constructGraph(graph);

        for (Edge i : graph[2]) {
            System.out.println(i.src + " " + i.weight + " " + i.dest);
        }
    }
}