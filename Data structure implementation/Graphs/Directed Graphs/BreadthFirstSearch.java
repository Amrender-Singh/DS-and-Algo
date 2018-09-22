/**
 * BreadthFirstSearch
 */
import java.util.*;
public class BreadthFirstSearch {
    private boolean[] marked; 
    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
    private int[] distTo;
    public BreadthFirstSearch(Digraph g, int s){
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        distTo = new int[g.V()];
        for (int v = 0; v < g.V(); v++)
            distTo[v] = Integer.MAX_VALUE;
        validateVertex(s);
        bfs(g, s);
    }
    private void bfs(Digraph g, int s){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        distTo[s] = 0;
        marked[s] = true;
        while(!queue.isEmpty()){
            int v = queue.poll();
            for(int w : g.adj(v)){
                if(!marked[w]){
                    queue.add(w);
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                }
            }
        }

    }
    public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
    }
    public int distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }
    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
    public static void main(String[] args) {
        Digraph g = new Digraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        BreadthFirstSearch bf = new BreadthFirstSearch(g, 0);
        System.out.println(bf.pathTo(3));
    }
}