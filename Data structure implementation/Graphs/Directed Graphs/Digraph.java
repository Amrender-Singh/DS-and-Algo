
/**
 * Digraph
 */
import  java.util.NoSuchElementException;
public class Digraph {
    private final int V;
    private int E;
    private LinkedList<Integer>[] adj;
    private int indegree[];
    public Digraph(int V){
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        indegree = new int[V];
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
        indegree[w]++;
    }
    public Iterable<Integer> adj(int v){
        validateVertex(v);
        return adj[v];
    }
    public int outdegree(int v){
        validateVertex(v);
        return adj[v].size();
    }
    public int indegree(int v){
        validateVertex(v);
        return indegree(v);
    }
    public Digraph reverse(){
        Digraph reverse = new Digraph(V);
        for(int v = 0; v < V; v++){
            for(int w : adj(v)){
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
}