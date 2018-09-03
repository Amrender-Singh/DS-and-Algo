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
public class AddAll{
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        PriorityQueue<Integer> pq;
        int id, p;
        int n, cost = 0;
        while((n = sc.nextInt()) != 0){
            cost = 0;
            pq = new PriorityQueue<Integer>();
            while(n --> 0){
                pq.add(sc.nextInt());
            }
            int num1, num2;
            while(!(pq.size() ==1)){
                num1 = pq.poll();
                num2 = pq.poll();
                int sum = num1 + num2;
                cost += sum;
                pq.add(sum);
            }
            output.append(cost+"\n");
        }
        
        System.out.print(output.toString());
    }
}