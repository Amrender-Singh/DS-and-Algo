
/**
 * Graph
 */
import  java.util.NoSuchElementException;
public class Graph {
    private final int V;
    private int E;
    private LinkedList<Integer>[] adj;
    public Graph(int V){
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for(int i = 0; i < V; i++){
            adj[i] = new LinkedList<Integer>();
        }
    }
    // return total Vertex of graph
    public int V() {
        return V;
    }
    // return total edges of graph
    public int E() {
        return E;
    }

    public void addEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }
    public Iterable<Integer> adj(int v){
        validateVertex(v);
        return adj[v];
    }
    public int degree(int v){
        int degree = 0;
        return adj[v].size();
    }
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
}