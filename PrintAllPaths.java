import java.util.*;

public class PrintAllPaths {
    
    static class Edge {
        int src;
        int nbr;
        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
        public String toString() {
            return src + " " + nbr;
        }
    }

    public static void printAllPaths(ArrayList<ArrayList<Edge>> graph, int src, int dest, boolean[] visited, String pathSoFar) {
        if(src == dest) {
            System.out.println(pathSoFar);
            return;
        }
        visited[src] = true;
        for(Edge edge: graph.get(src)) {
            if(visited[edge.nbr] == false) {
                printAllPaths(graph, edge.nbr, dest, visited, pathSoFar +  "" + edge.nbr);
            }
        }
        visited[src] = false;   //after visiting all the neighbors of a vertex, we make that vertex false while returning thinking that there may be another path through this vertex
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>(V);
        for(int i = 0; i < V; i++) {
            graph.add(new ArrayList<Edge>());
        }
        for(int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph.get(v1).add(new Edge(v1, v2));
            graph.get(v2).add(new Edge(v2, v1));
        }

        boolean[] visited = new boolean[V];

        int src = sc.nextInt();
        int dest = sc.nextInt();
        
//         for(int i = 0; i < V; i++) {
//             System.out.println(graph.get(i));
//         }

        printAllPaths(graph, src, dest, visited, "" + src);

    }

}
