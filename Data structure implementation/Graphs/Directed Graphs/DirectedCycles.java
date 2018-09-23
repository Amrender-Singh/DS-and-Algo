/**
 * DirectedCycles - determining whether a digraph has a directed cycle.
 */
import java.util.*;
public class DirectedCycles {
    private boolean[] marked;        // marked[v] = has vertex v been marked
    private int[] edgeTo;            // edgeTo[v] = previous vertex on path to v
    private boolean[] onStack;       // onStack[v] = is vertex on the stack?
    private Stack<Integer> cycle;    // directed cycle (or null if no such cycle)
    
    public DirectedCycles(Digraph G){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        onStack = new  boolean[G.V()];
        for (int v = 0; v < G.V(); v++){
            if (!marked[v] && cycle == null) 
                dfs(G, v);
        }
    }
    private void dfs(Digraph G, int v){
        marked[v] = true;
        onStack[v] = true;
        for(int w : G.adj(v)){
            if(cycle != null) return;
            else if(!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
            else if(onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }
    public boolean hasCycle() {
        return cycle != null;
    }
    public Iterable<Integer> cycle() {
        return cycle;
    }
}