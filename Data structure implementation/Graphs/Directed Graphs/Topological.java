/**
 * Topological
 */
public class Topological {
    private Iterable<Integer> order;  // topological order
    private int[] rank;               // rank[v] = rank of vertex v in order
    /**
     * Determines whether the digraph {@code G} has a topological order and, if so,
     * finds such a topological order.
     */
    public Topological(Digraph G) {
        DirectedCycle finder = new DirectedCycle(G);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
            rank = new int[G.V()];
            int i = 0;
            for (int v : order)
                rank[v] = i++;
        }
    }
    public Iterable<Integer> order() {
        return order;
    }
    public boolean hasOrder() {
        return order != null;
    }
    public int rank(int v) {
        validateVertex(v);
        if (hasOrder()) return rank[v];
        else            return -1;
    }
    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = rank.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

}