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

 public class AutomatetheGrades {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases  = sc.nextInt();
        int caseNo = 0;
        PriorityQueue<Integer> pq;
        while(caseNo ++ < noOfTestCases){
            pq = new PriorityQueue<>(Collections.reverseOrder());
            int sum = 0;
            for(int i = 0 ;i < 4; i++){
                sum += sc.nextInt();
            }
            for(int i = 0; i < 3; i++){
                pq.add(sc.nextInt());
            }
            sum = sum + (pq.poll() + pq.poll())/2;
            output.append("Case "+caseNo+": ");
            if(sum >= 90){
                output.append("A");
            } else if(sum >= 80){
                output.append("B");
            }else if(sum >= 70){
                output.append("C");
            }else if(sum >= 60){
                output.append("D");
            } else {
                output.append("F");
            }
            output.append("\n");
        }
        System.out.print(output.toString());
    }
}