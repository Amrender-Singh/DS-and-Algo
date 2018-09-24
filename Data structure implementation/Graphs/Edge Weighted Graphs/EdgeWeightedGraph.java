import java.util.*;

/**
 * EdgeWeightedGraph
 */
public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private LinkedList<Edge>[] adj;
    /**
     * Initializes an empty Edge-weighted graph with {@code V} vertices and 0 edges.
     * @param  V the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public EdgeWeightedGraph(int V){
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Edge>[]) new LinkedList[V];
        for(int i = 0; i < V; i++){
            adj[i] = new LinkedList<Edge>();
        }
    }
    EdgeWeightedGraph(String fileName, BufferedReader br1) throws NumberFormatException, IOException{
		this(Integer.parseInt(br1.readLine()));
		try ( BufferedReader br = new BufferedReader(new FileReader(fileName))) {	
			br.readLine();
			this.E = Integer.parseInt(br.readLine());
			String line;
			while ((line = br.readLine()) != null) {
				String values [] = line.split(" ");
				if(values.length < 3)
					throw new IllegalArgumentException("not a valid Edge");
				int v = Integer.parseInt(values[0]);
				int w = Integer.parseInt(values[1]);
				double weight = Double.parseDouble(values[2]);
				Edge e =  new Edge(v, w, weight);
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
        Add an Edge
    */
    public void addEdge(Edge e){
        int v = e.either(); 
        int w = e.other(v);
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }
    public Iterable<Edge> adj(int v){
        validateVertex(v);
        return adj[v];
    }
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }
    public Iterable<Edge> edges() {
        ArrayList<Edge> list = new ArrayList<Edge>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                // add only one copy of each self loop (self loops will be consecutive)
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
    }
    private void validateVertex(int v){
        if(v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
}