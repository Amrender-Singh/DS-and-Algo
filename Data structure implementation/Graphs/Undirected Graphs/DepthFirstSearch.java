/**
 * DepthFirstSearch
 */
public class DepthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private int count;           // number of vertices connected to s
    private int s;
    public DepthFirstSearch(Graph g, int s){
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
        dfs(g, s);
    }
    private void dfs(Graph g, int v){
        marked[v] = true;
        count++;
        for(int w: g.adj(v)){
            if(!marked[w]){
                dfs(g, w);
                edgeTo[w] = v;
            }
        }
    }
    public int count() {
        return count;
    }
    public boolean hasPathTo(int v){
         return marked[v]; 
    }
    public Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
        path.push(x);
        path.push(s);
        return path;
    }
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        DepthFirstSearch df = new DepthFirstSearch(g, 0);
        System.out.println(df.pathTo(3));
    }
}