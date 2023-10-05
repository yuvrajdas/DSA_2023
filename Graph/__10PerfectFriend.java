package Graph;
import java.util.*;
public class __10PerfectFriend {
    
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
    private static void constructComponent(ArrayList<Edge> graph[], boolean visited[], int src, ArrayList<Integer> comp){
        comp.add(src);
        visited[src] = true;

        for(Edge e : graph[src]){
            int nbr = e.dest;
            if(visited[nbr] == false){
                constructComponent(graph, visited, nbr, comp);
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> getConntectedComponent(ArrayList<Edge> graph[]){
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean visited[] = new boolean[graph.length];
        
        for(int i=0; i<graph.length; i++){

            if(visited[i] == false){
                ArrayList<Integer> comp = new ArrayList<>();
                constructComponent(graph, visited, i, comp);
                comps.add(comp);                
            }
        }
        return comps;
    }
    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        constructGraph(graph);

       ArrayList<ArrayList<Integer>> res = getConntectedComponent(graph);
       System.out.println(res);

       int pairs = 0;
       for(int i=0; i<res.size(); i++){
            for(int j=i+1; j<res.size(); j++){
                int count = res.get(i).size() * res.get(j).size();
                pairs+=count;
            }
       }
       System.out.println(pairs);
    }
}