import java.util.*;
import java.lang.*;
import java.io.*;
class Reader{
        BufferedReader br;
        StringTokenizer st;
 
        public Reader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
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
                e.printStackTrace();
            }
            return str;
        }
    }

public class Suspects {
   static  int parent[];
    static int rank[];
    public static void make_set(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i = 0; i <= n; i++){
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
    public static int getSize(int p){
        return rank[parent[p]];
    }
    public static void main(String args[]){
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        while(true){
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(m == 0 && n == 0)
                break;
            make_set(n);
            while(m --> 0){
                int k = sc.nextInt();
                int e1 = sc.nextInt();
                int e2;
                for(int i = 1; i < k; i++){
                    e2 = sc.nextInt();
                    union(e1, e2);
                }
            }
            int count = 0;
            int p = find(0);
            for(int i = 0; i <= n; i++){
                if(find(i) == p)
                    count++;
            }
            output.append(count+"\n");
        }
        System.out.print(output.toString());
    }
} 