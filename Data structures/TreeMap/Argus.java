import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

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
               return null;
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
class Query{
    int id, p, v;
    public Query(int id, int p, int v){
        this.id = id;
        this.p = p;
        this.v = v;
    }
}
public class Argus{
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        PriorityQueue<Query> pq = new PriorityQueue<>((a, b)->{
            if(a.v != b.v)
                return a.v - b.v;
            return a.id - b.id;
        });
        int id, p;
        while(!(sc.next()).equals("#")){
            id = sc.nextInt();
            p = sc.nextInt();
            pq.add(new Query(id, p, p));
        }
        int k = sc.nextInt();
        while(k --> 0){
            Query q = pq.poll();
            output.append(q.id+"\n");
            q.v += q.p;
            pq.add(q);
        }
        
        System.out.print(output.toString());
    }
}