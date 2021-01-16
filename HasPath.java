import java.util.*;
public class HasPath {

    static class Edge {
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }

        public String toString() {
            return src + " " + nbr + " " + wt;
        }
    }

    public static boolean hasPath(ArrayList<ArrayList<Edge>> graph, int src, int dest, boolean[] visited) {
        if(src == dest) {
            return true;
        }
        visited[src] = true;
        for(Edge edge: graph.get(src)) {     ///for each edge(object) in arraylist of edges(objects)
            if(visited[edge.nbr] == false) {
            	boolean hasPathFromNbr = hasPath(graph, edge.nbr, dest, visited);
                if(hasPathFromNbr) {
                    return true;
                }
            }
        }
        return false;
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
            int wt = sc.nextInt();

            graph.get(v1).add(new Edge(v1, v2, wt));
            graph.get(v2).add(new Edge(v2, v1, wt));
        }

        int src = sc.nextInt();
        int dest = sc.nextInt();

        for(int i = 0; i < V; i++) {
            System.out.println(graph.get(i));
        }

        boolean[] visited = new boolean[V];

        System.out.println(hasPath(graph, src, dest, visited));

        

        sc.close();

    }
}
