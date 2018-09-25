/**
 * LazyPrimMST- Algorithm to find minimum spanning tree
 */
import java.util.*;
public class LazyPrimMST {
    private boolean[] marked;
    private PriorityQueue<Edge> minPQ;
    private LinkedList<Edge> mst;
    private double weight;
    public LazyPrimMST(EdgeWeightedGraph G){
        marked = new boolean[G.V()];
        minPQ = new PriorityQueue<Edge>();
        mst = new LinkedList<>();
        for (int v = 0; v < G.V(); v++)     // run Prim from all vertices to
            if (!marked[v]) prim(G, v);     // get a minimum spanning forest
    }
    private void prim(EdgeWeightedGraph G, int s){
        visit(G, s);
        while(!minPQ.isEmpty() && mst.size() < G.V()-1){
            Edge e = minPQ.poll();
            int v = e.either(), w = e.other(v);
            if(marked[v] && marked[w]) continue;
            mst.add(e);
            weight += e.weight();
            if(!marked[v]) visit(G, v);
            if(!marked[w]) visit(G, w);
        }
    }
    private void visit(EdgeWeightedGraph G, int v){
        assert !marked[v];
        marked[v] = true;
        for (Edge e : G.adj(v))
            if (!marked[e.other(v)]) minPQ.add(e);
        
    }
    public double weight(){
        return weight;
    }
    public Iterable<Edge> edges(){
        return mst;
    }
}