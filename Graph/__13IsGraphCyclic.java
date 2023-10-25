package Graph;
import java.util.*;
public class __13IsGraphCyclic {
    
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

        graph[6].add(new Edge(6, 4));
        graph[6].add(new Edge(6, 5));

        return graph;
        
    }
    private static boolean isGraphCyclicHelper(ArrayList<Edge> graph[], int src, boolean visisted[]){

        Queue<Integer> que = new ArrayDeque<>();
        que.add(src);
        
        while(que.size()>0){
            int curr =  que.remove();
            if(visisted[curr]){
                return true;
            }
            visisted[curr] = true;
            for(Edge e : graph[curr]){
                if(visisted[e.dest]== false){
                    que.add(e.dest);
                }
            }
        }

        return false;
    }
    public static boolean isGraphCyclic(ArrayList<Edge> graph[], int v){
       
        boolean visisted[] = new boolean[v];
        for(int i=0; i<v; i++){

            if(!visisted[i]){
                boolean res = isGraphCyclicHelper(graph, i, visisted);
                if(res) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        constructGraph(graph);

        boolean res = isGraphCyclic(graph, v);
        System.out.println(res);
    }
}
