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

 public class Forests {
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
        sc.nextLine();
        while(noOfTestCases --> 0){
            int p = sc.nextInt();
            int t = sc.nextInt();
            make_set(p);
            String s, line[];
            HashSet<Integer> list[] = (HashSet<Integer>[]) new HashSet[p];
            for (int i = 0; i < p; i++) {
                list[i] = new HashSet<>();
            }
            while((s = sc.nextLine())!= null && !s.equals("")){
                line =  s.split("\\s+");
                int x = Integer.parseInt(line[0]);
                int y = Integer.parseInt(line[1]);
                list[x-1].add(y);
            }
            for(int i = 0; i < p; i++){
                for(int j = i+1; j < p; j++){
                    if(list[i].equals(list[j]))
                        union(parent[i], parent[j]);
                }
            }
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < p; i++)
                set.add(parent[i]);
            output.append(set.size()+"\n");
            if(noOfTestCases != 0)
                output.append("\n");
        }
        System.out.print(output.toString());
    }
}