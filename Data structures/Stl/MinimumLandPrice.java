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

 public class MinimumLandPrice {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int testCases = sc.nextInt();
        PriorityQueue<Integer> pq;
        while(testCases -- >0){
            pq = new PriorityQueue<>(Collections.reverseOrder());
            String s ;
            while(!(s = sc.nextLine()).equals("0")){
                pq.add(Integer.parseInt(s));
            }
            int totPrice = 0;
            int i  = 1;
            while(!pq.isEmpty()){
                totPrice += 2 * ((int)Math.pow(pq.poll(), i));
                if(totPrice > 5000000)
                    break;
                i++;
            }
            output.append(totPrice <= 5000000 ? totPrice : "Too expensive");
            output.append("\n");
        }
        System.out.print(output.toString());
    }
}