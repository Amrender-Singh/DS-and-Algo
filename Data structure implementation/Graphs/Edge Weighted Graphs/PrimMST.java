import java.util.LinkedList;

/**
 * PrimMST
 */
class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer>{
    private int pq[];
    private int qp[];
    private key keys[];
    private int maxN;
    private int n;
    public  IndexMinPQ(int maxN){
        this.maxN = maxN;
        pq = new int[maxN+1];
        qp = new int[maxN+1];
        keys = (Key[]) new Comparable[maxN + 1];
        n = 0;
        for (int i = 0; i <= maxN; i++)
            qp[i] = -1;
    }
    public void insert(int i, Key priority){
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = priority;
        swim(n);
    }
    public void deleteMin(){
        int min = pq[1];
        exchange(1, n--);
        sink(1);
        qp[min] = -1;        // delete
        keys[min] = null; 
    }
    public void decreaseKey(int i, Key key){
        keys[i] = key;
        swim(qp[i]);
    }
    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(int i) {
        if (i < 0 || i >= maxN) throw new IllegalArgumentException();
        return qp[i] != -1;
    }
    private void swim(int k){
        while(k > 1 && greater(k/2, k)){
            exchange(k,k/2);
            k = k/2;
        }
    }
    private void sink(int k){
        while(2*k <= n){
            int j = 2*k;
            if(j < n && greater(j, j+1)) j++;
            if(!greater(k, j)) break;
            exchange(k, j);
            k =j;
        }
    }
    private boolean greater(int i, int j){
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }
    private void exchange(int i, int j){
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }
}
public class PrimMST {
    private boolean[] marked;
    private Edge[] edgeTo;        // edgeTo[v] = shortest edge from tree vertex to non-tree vertex
    private double[] distTo;      // distTo[v] = weight of shortest such edge
    private LinkedList<Edge> mst;
    IndexMinPQ<Double> pq;
    public PrimMST(EdgeWeightedGraph G){
        marked = new boolean[G.V()];
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<>(G.V());
        mst = new LinkedList<>();
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;

        for(int v = 0; v < G.V(); v++)
            if(!marked[v]) prim(G, v);
    }
    private void prim(EdgeWeightedGraph G, int V){
        visit(G, V);
        while(!pq.isEmpty() && mst.size() < G.V() - 1){
            int v = pq.delMin();
            visit(G, v);
        }
    }
    private void visit(EdgeWeightedGraph G, int v){
        marked[v] = true;
        for(Edge e : G.adj(v)){
            int w = e.other(v);
            if (marked[w]) continue;
            if(e.weight() < distTo[w]){
                distTo[w] = e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
                else                pq.insert(w, distTo[w]);
            }
        }
    }
    public Iterable<Edge> edges() {
        LinkedList<Edge> mst = new LinkedList<Edge>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.add(e);
            }
        }
        return mst;
    }

    /**
     * Returns the sum of the edge weights in a minimum spanning tree (or forest).
     * @return the sum of the edge weights in a minimum spanning tree (or forest)
     */
    public double weight() {
        double weight = 0.0;
        for (Edge e : edges())
            weight += e.weight();
        return weight;
    }
    
}