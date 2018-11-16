import java.util.HashMap;
import java.util.LinkedList;

/**
 * UVA- 599
 * TheForrestForTheTrees
 */
class Reader{
    BufferedReader br;
    StringTokenizer st;
    Reader(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next(){
        if(st == null || !st.hasMoreElements()){
            try {
                st = new StringTokenizer(br.readLine());                
            } catch (Exception e) {
               
            }
        }
        return st.nextToken();
    }
    int nextInt(){
        return Integer.parseInt(next());
    }
    double nextDouble(){
        return Double.parseDouble(next());
    }
    long nextLong()
    {
        return Long.parseLong(next());
    }
    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            
        }
        return str;
    }
}
class Graph{
    private int V;
    private LinkedList<Integer> adj[];
    public TheForrestForTheTrees(){
        adj = (LinkedList<Integer>[]) new LinkedList[26];
        for(int i = 0; i < 26; i++){
            adj[i] = new LinkedList<>();
        }
    }
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }
    public Iterator<Integer> adj(int v){
        return adj[v];
    }
}
public class TheForrestForTheTrees {
    public static void connectedComponents(Graph G, int v, int count, HashMap<Integer, Integer> cc, boolean marked[]){
        marked[v] = true;
        cc.put(count, cc.getOrDefault(count, 0)+1);
        for(int i : G.adj(v)){
            if(!marked[i])
                connectedComponents(G, v, count, cc, marked);
        }
    }
    public static void main(String[] args) {
        HashMap<Character, Integer> characterMap = new HashMap<>();
        for(int i = 0; i < 26; i++){
            char ch = 'A'+i;
            characterMap.put(ch ,i);
        }
        Reader sc = new Reader();
        int noOfTestCases = sc.nextInt();
        HashMap<Integer, Integer> cc;
        boolean marked[];
        StringBuilder output = new StringBuilder();
        while(noOfTestCases --> 0){
            Graph G = new Graph();
            String s;
            while((s = sc.nextLine()) !=null && s.charAt(0) != '*'){
                G.addEdge(characterMap.get(s.charAt(1)), characterMap.get(s.charAt(3)));
            }
            char vertices[] = sc.nextLine().split(",");
            cc = new HashMap<>();
            int count = 0;
            marked = new boolean[26];
            for(Character ch : vertices){
                int v = characterMap.get(ch);
                if(!marked[v]){
                    connectedComponents(G, v, count, cc, marked);
                    count++;
                }
            }
            int tree = 0, acorn = 0;

            for(Integer i : cc.values()){
                if(i > 1)
                    tree++;
                else
                    acorn++;
            }
            output.append("There are " + tree + "tree(s) and " +acorn+ " acorn(s).\n");
        }
        System.out.print(output.toString());
    }
}