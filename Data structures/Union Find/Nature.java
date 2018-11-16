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

public class Nature {
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
    public static void main(String args[]){
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        String s;
        while(true){
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x == 0 && y == 0)

                break;
            makeSet(x);
            HashMap<String, Integer> wordToInt = new HashMap<>();
            for(int i = 0; i < x; i++)
                wordToInt.put(sc.next().trim(), i);
    
            for(int i = 0; i < y; i++)
                union(wordToInt.get(sc.next().trim()),wordToInt.get(sc.next().trim()));
            int max = -1;
            for(int i = 0; i < x; i++)
                max = Math.max(max, rank[i]);
            output.append(max+"\n");
            sc.nextLine();
        }
        System.out.print(output.toString());
    }
}
