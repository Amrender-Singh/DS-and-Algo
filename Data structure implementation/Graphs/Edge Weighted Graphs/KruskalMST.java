import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * KruskalMST- Computes minimum spanning tree 
 * Helpers - Union find ds, priority queue
 * time complexity - ElogE
 */
public class KruskalMst {
    private LinkedList<Edge> mst;
    private double weight;
    public KruskalMst(EdgeWeightedGraph G){
        PriorityQueue<Edge> minPq = new PriorityQueue<>();
        mst = new LinkedList<>();
        for(Edge e : G.edges()){
            minPq.add(e);
        }
        UnionFind uf = new UnionFind(G.V());
        while(!minPq.isEmpty() && mst.size() < G.V() -1){
            Edge e = minPq.poll();
            int v = e.either();
            int w = e.other(v);
            if(!uf.connected(v, w)){
                uf.union(v, w);
                mst.add(e);
                weight += e.weight();
            }
        }
    }
    public double weight() {
        return weight;
    }
    public Iterable<Edge> edges(){
        return mst;
    }
    public static void main(String[] args)throws IOException {
		String filename = args[0];
		BufferedReader br =  new BufferedReader(new FileReader(filename));
		EdgeWeightedGraph G = new EdgeWeightedGraph(filename, br);
		KruskalMst mt = new KruskalMst(G);
		for(Edge e : mt.edges()){
			System.out.println(e.either()+" "+ e.other(e.either())+" "+ e.weight());
		}
		System.out.println(mt.weight);
	}
}
