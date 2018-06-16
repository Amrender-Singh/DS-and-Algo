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

 public class JollybeeTournament {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases = sc.nextInt();
        int cases = 1;
        while(noOfTestCases -- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(m == 0)
                sc.nextLine();
            boolean arr[] = new boolean[(int)Math.pow(2,n)];
            for(int i = 0; i < arr.length; i++){
                arr[i] = true;
            }
            for(int i = 0; i < m; i++){
                arr[sc.nextInt()-1] = false;
            }
            int walkoverCount = 0;
            while(arr.length > 1){
                boolean temp[] = new boolean[arr.length/2];
                int j = 0;
                for(int i = 0; i < arr.length; i += 2){
                    if((arr[i] && !arr[i+1]) || (!arr[i] && arr[i+1]))
                        walkoverCount++;
                    temp[j++] = arr[i] || arr[i+1];
                }
                arr = temp;
            }
            output.append(walkoverCount+"\n");
        }
        System.out.print(output.toString());
    }
}