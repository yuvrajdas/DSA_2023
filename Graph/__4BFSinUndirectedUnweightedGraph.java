package Graph;
import java.util.*;
public class __4BFSinUndirectedUnweightedGraph {
    
    public static class Edge{
        int src;
        int dest;

        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public static void constructGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        /*
             1 -------3
            /         | \
           10         |  5-----6
            \         | /
             2 -------4
         */

        // graph[0].add(new Edge(10, 1));
        // graph[0].add(new Edge(10, 2));

        // graph[1].add(new Edge(1, 10));
        // graph[1].add(new Edge(1, 3));

        // graph[2].add(new Edge(2, 10));
        // graph[2].add(new Edge(2, 4));

        // graph[3].add(new Edge(3, 1));
        // graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        // graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 2));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));
        // graph[5].add(new Edge(5, 6));

        // graph[5].add(new Edge(6, 5));
        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 10));

        graph[2].add(new Edge(2, 4));
        graph[2].add(new Edge(2, 10));

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


    }
    public static void bfs(ArrayList<Edge> graph[], int v){
        Queue<Integer> que = new ArrayDeque<>();
        boolean visited[] = new boolean[v];
        que.add(0);
        while(que.size()>0){
            int curr =  que.remove();
            if(visited[curr] == false){
                System.out.print(curr+" ");
                visited[curr] = true;
                
                for(Edge j : graph[curr]){
                    que.add(j.dest);
                }
               
            }
        }
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        constructGraph(graph);
        bfs(graph, V);
    }
}
