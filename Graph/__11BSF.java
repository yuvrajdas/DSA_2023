package Graph;

import java.util.*;

public class __11BSF {
    
    public static class Edge{
        int src;
        int dest;

        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public static ArrayList<Edge>[] costructGraph(ArrayList<Edge> graph[]){
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

    public static void bfs(ArrayList<Edge> graph[], boolean visited[], int src){
        Queue<Integer> que = new ArrayDeque<>();
        que.add(src);

        while(que.size()>0){
             
            int curr = que.remove();
            if(visited[curr] == false){
                System.out.print(curr+" ");
                visited[curr] = true;
                for(Edge e : graph[curr]){
                    que.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        costructGraph(graph);   
        boolean visited[] = new boolean[v];
        System.out.println(Arrays.toString(visited));

        bfs(graph, visited, 0);
    }
}
