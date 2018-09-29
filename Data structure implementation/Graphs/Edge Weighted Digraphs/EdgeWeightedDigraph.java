import java.util.*;

/**
 * EdgeWeightedDigraph
 */
public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private LinkedList<DirectedEdge>[] adj;
    private int[] indegree;
    /**
     * Initializes an empty DirectedEdge-weighted graph with {@code V} vertices and 0 edges.
     * @param  V the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public EdgeWeightedDigraph(int V){
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        adj = (LinkedList<DirectedEdge>[]) new LinkedList[V];
        for(int i = 0; i < V; i++){
            adj[i] = new LinkedList<DirectedEdge>();
        }
    }
    EdgeWeightedDigraph(String fileName, BufferedReader br1) throws NumberFormatException, IOException{
		this(Integer.parseInt(br1.readLine()));
		try ( BufferedReader br = new BufferedReader(new FileReader(fileName))) {	
			br.readLine();
			this.E = Integer.parseInt(br.readLine());
			String line;
			while ((line = br.readLine()) != null) {
				String values [] = line.split(" ");
				if(values.length < 3)
					throw new IllegalArgumentException("not a valid DirectedEdge");
				int v = Integer.parseInt(values[0]);
				int w = Integer.parseInt(values[1]);
				double weight = Double.parseDouble(values[2]);
				DirectedEdge e =  new DirectedEdge(v, w, weight);
				addEdge(e);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    /*
        Add an DirectedEdge
    */
    public void addEdge(DirectedEdge e){
        int v = e.from();
        int w = e.to();
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        indegree[w]++;
        E++;
    }
    public Iterable<DirectedEdge> adj(int v){
        validateVertex(v);
        return adj[v];
    }
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }
    public Iterable<DirectedEdge> edges() {
        ArrayList<DirectedEdge> list = new ArrayList<DirectedEdge>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj(v)) {
                list.add(e);
            }
        }
        return list;
    }
    public int outdegree(int v) {
        validateVertex(v);
        return adj[v].size();
    }
    public int indegree(int v) {
        validateVertex(v);
        return indegree[v];
    }
    private void validateVertex(int v){
        if(v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
}