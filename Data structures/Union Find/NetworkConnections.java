/**
 * NetworkConnections
 */
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
class UF{
   int[] rank;
   int[] parent;
   int n;
   public UF(int n){
       rank = new int[n+1];
       parent = new int[n+1];
       this.n = n;
       for(int i = 0; i <= n; i++){
           parent[i] = i;
       }
   }
   public boolean isConnected(int p, int q){
       if(p == q)
           return true;
       if(p > n || q > n)
           return false;
       return find(p) == find(q);
   }
   private int find(int p){
       return (parent[p] == p) ? p :(parent[p] = find(parent[p]));
   }
   public void union(int p, int q){
       if(p == q ||(p > n || q > n))
           return;
       int parentOfP = find(p);
       int parentOfQ = find(q);
       if(parentOfP == parentOfQ)
           return;
       if(rank[parentOfP] > rank[parentOfQ]){
           parent[parentOfQ] = parentOfP;
       }else{
           parent[parentOfP] = parentOfQ;
           if(rank[parentOfP] == rank[parentOfQ])
               rank[parentOfQ]++;
       }
   }

}
public class NetworkConnections {

   public static void main(String[] args) {
       Reader sc = new Reader();
       int noOfTestCases = sc.nextInt();
       StringBuilder output = new StringBuilder();
       sc.nextLine();
       while(noOfTestCases --> 0){
           int n = sc.nextInt();
           UF uf = new UF(n);
           String[] line;
           int[] result = new int[2];
           String s ;
           while((s = sc.nextLine())!= null && !s.equals("")){
               line = s.split(" ");
               int p = Integer.parseInt(line[1]);
               int q = Integer.parseInt(line[2]);
               if(line[0].equals("q")){
                   if(uf.isConnected(p, q))
                       result[0]++;
                   else    
                       result[1]++;
               } else{
                   uf.union(p, q);
               }
           }
           output.append(result[0] + "," + result[1] + "\n");
           if(noOfTestCases != 0)
            output.append("\n");
       }
       System.out.print(output.toString());
   }
}