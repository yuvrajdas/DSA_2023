package Graph;

import java.util.ArrayList;

public class __4HasPathInUdirectedWeightedGraph {

    public static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static ArrayList<Edge>[] constructGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 10));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));

        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 10));

        graph[3].add(new Edge(3, 0, 10));
        graph[3].add(new Edge(3, 2, 10));
        // graph[3].add(new Edge(3, 4, 10));

        // graph[4].add(new Edge(4, 3, 10));
        graph[4].add(new Edge(4, 5, 10));
        graph[4].add(new Edge(4, 6, 10));

        graph[5].add(new Edge(5, 4, 10));
        graph[5].add(new Edge(5, 6, 10));

        graph[6].add(new Edge(6, 5, 10));
        graph[6].add(new Edge(6, 4, 10));

        return graph;
    }

    public static boolean hashPath(ArrayList<Edge> graph[], int src, int dest, boolean visited[]) {
        if (src == dest)
            return true;

        visited[src] = true;
        for (Edge edge : graph[src]) {
            int nbr = edge.dest;

            if (!visited[nbr]) {
                boolean hasNbrPath = hashPath(graph, nbr, dest, visited);
                if (hasNbrPath)
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        constructGraph(graph);
        boolean visited[] = new boolean[v];
        boolean res = hashPath(graph, 0, 6, visited);
        System.out.println(res);
    }
}
