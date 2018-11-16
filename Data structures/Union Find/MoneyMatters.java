import java.io.*;
import java.util.*;

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

 public class MoneyMatters {
    static  int parent[];
    static int rank[];
    public static void make_set(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            rank[i] = 1;
            parent[i] = i;
        }
    }

    public static int find(int p){
        if(parent[p] != p)
            parent[p] = find(parent[p]);
        return parent[p];
    }
    public static void union(int p, int q){
        int xp = find(p), yq = find(q);
        if(xp == yq)
            return;
        if(rank[xp] > rank[yq]){
            parent[yq] = xp; 
            rank[xp] += rank[yq];
        } else {
            parent[xp] = yq; 
            rank[yq] += rank[xp];
        }
        
    }
  
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases = sc.nextInt();
        while(noOfTestCases --> 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            make_set(n);
            int money[] = new int[n];
            for(int i = 0; i < n; i++)
                money[i] = sc.nextInt();
            for(int i = 0; i < m; i++){
                union(sc.nextInt(), sc.nextInt());
            }
            int amt = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++){
                if(!map.containsKey(find(i)))
                    map.put(find(i), money[i]);
                else    
                    map.put(find(i), map.get(find(i))+money[i]);
            }
            boolean settled = true;
            for(int i : map.values()){
                if(i != 0) {
                    settled = false; 
                    break;
                }
            }
            output.append(settled ? "POSSIBLE" : "IMPOSSIBLE");
            output.append("\n");
        }
        System.out.print(output.toString());
    }
}