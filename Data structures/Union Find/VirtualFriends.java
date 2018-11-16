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

public class VirtualFriends {
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
        int noOfTestCases = sc.nextInt();
        while(noOfTestCases-->0){
            int n = sc.nextInt();
            makeSet(n*2);
            HashMap<String, Integer> wordToInt = new HashMap<>();
            int wordNo = 0;
            for(int i = 0; i < n; i++){
                String f1 = sc.next().trim();
                String f2 = sc.next().trim();
                if(!wordToInt.containsKey(f1)){
                    wordToInt.put(f1, wordNo);
                    wordNo++;
                }
                if(!wordToInt.containsKey(f2)){
                    wordToInt.put(f2, wordNo);
                    wordNo++;
                }
                union(wordToInt.get(f1),wordToInt.get(f2));
                int parent = find(wordToInt.get(f1));
                output.append(rank[parent]+"\n");
            }
        
        }
        System.out.print(output.toString());
    }
}
