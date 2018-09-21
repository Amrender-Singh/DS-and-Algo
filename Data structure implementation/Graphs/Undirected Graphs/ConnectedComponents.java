/**
 * ConnectedComponents
 */
import java.util.*;
public class ConnectedComponents {
    private boolean[] marked;
    private int size[];
    private int id[];
    private int count;
    
    public ConnectedComponents(Graph g){
        marked = new boolean[g.V()];
        id = new int[g.V()];
        size = new int[g.V()];
        for(int v = 0; v < g.V(); v++){
            if(!marked[v]){
                dfs(g, v);
                count++;
            }
        }
    }
    public int id(int v) {
        validateVertex(v);
        return id[v];
    }
    public int size(int v) {
        validateVertex(v);
        return size[id[v]];
    }
    public int count() {
        return count;
    }
    public boolean connected(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }
    private void dfs(Graph g, int v){
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for(int w : g.adj(v)){
            if(!marked[w])
                dfs(g, w);
        }
    }
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
    public static void main(String[] args) {
        Graph g = new Graph(11);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(5, 6);
        g.addEdge(6, 7);
        g.addEdge(7, 10);
        ConnectedComponents cc = new ConnectedComponents(g);
        System.out.println(cc.connected(0, 4));
        System.out.println(cc.connected(2, 5));
        System.out.println(cc.connected(3, 6));
        System.out.println(cc.connected(5, 10));
        System.out.println(cc.size(5));
    }
}