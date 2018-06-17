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

 public class TheMostPotentCorner {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        String s;
        while((s = sc.nextLine()) != null && !s.equals("")){
            int N = Integer.parseInt(s);
            int noOfEdges =(int) Math.pow(2,N);
            int edges[] = new int[noOfEdges];
            for(int i = 0; i < edges.length; i++){
                edges[i] = sc.nextInt();
            }
            int sum[] = new int[noOfEdges];
            for(int i = 0; i < noOfEdges; i++){
                int edge_sum = 0;
                for(int j = 0; j < N; j++){
                    int b = i ^ (1 << j);
                    edge_sum += edges[b];
                }
                sum[i] += edge_sum;
            }
            int maxSum = 0;
            for(int i = 0; i < noOfEdges; i++){
                for(int j = 0; j < N; j++){
                    int b = i ^ (1 << j);
                    maxSum = Math.max(maxSum, sum[i]+sum[b]);
                }
            }
            output.append(maxSum+"\n");
        }
        System.out.print(output.toString());
    }
}