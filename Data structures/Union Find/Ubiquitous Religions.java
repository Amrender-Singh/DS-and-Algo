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

 public class UbiquitousReligions {
    static int parent[];
    static int rank[];
    public static void makeSet(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }
    public static void union(int p, int q){
        int xp = find(p), yq = find(q);
        if(xp == yq)
            return;
        if(rank[xp] < rank[yq]){
            rank[yq] += rank[xp];
            parent[xp] = yq;
        } else {
            rank[xp] += rank[yq];
            parent[yq] = xp;
        }
    }
    public static int find(int p){
        if(p != parent[p])
            parent[p] = find(parent[p]);
        return parent[p];
    }
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        String s;
        int caseNo = 1;
        while(true){
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(m == 0 && n == 0)
                break;
            makeSet(n);
            for(int i = 0; i < m; i++){
                int p = sc.nextInt();
                int q = sc.nextInt();
                union(p-1, q-1);
            }
            for(int i = 0; i < n; i++)
                parent[i] = find(i);
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < n; i++)
                set.add(parent[i]);
            output.append("Case "+caseNo+": "+set.size());
            output.append("\n");
            caseNo++;
        }
        System.out.print(output.toString());
    }
}