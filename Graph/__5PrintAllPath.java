package Graph;
import java.util.*;
public class __5PrintAllPath {
    
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
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[4].add(new Edge(4, 6));

        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
        graph[6].add(new Edge(6, 4));

        return graph;
    }
    public static void printAllPath(ArrayList<Edge> graph[], boolean visited[], int src, int dest, String psf){
        if(src == dest){
            System.out.println(psf);
            return;
        }
        visited[src] = true;

        for(Edge edge : graph[src]){
            int nbr = edge.dest;
            if(visited[nbr] == false){
                printAllPath(graph, visited, nbr, dest, src+" "+psf);
            }
        }
        
        visited[src] = false;
    }
    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        constructGraph(graph);
        boolean visited[] = new boolean[v];
        printAllPath(graph,visited, 0, 6, "");
    }
}
