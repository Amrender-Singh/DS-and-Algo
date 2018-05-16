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

 public class SymmetricMatrix {
    public static boolean isSymmetric(long arr[][], int n){
        for(int i = 0; i <= (n/2); i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] < 0 || arr[i][j] != arr[n-1-i][n-1-j])
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
            Reader sc =  new Reader();
            StringBuilder output = new StringBuilder();
            int noOfTestCases = sc.nextInt();
            int test = 0;
            long arr[][];
            while(test ++ < noOfTestCases){
                sc.next();
                sc.next();
                int n = sc.nextInt();
                arr = new long[n][n];
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        arr[i][j] = sc.nextLong();
                    }
                }
                output.append("Test #"+test+": "+ (isSymmetric(arr, n) ? "Symmetric." : "Non-symmetric."));
                output.append("\n");
            }
            System.out.print(output.toString());
        }
}