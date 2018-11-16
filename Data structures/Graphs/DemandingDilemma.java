import java.util.*;
import java.io.*;

/**
 * UVA- 599
 * My Dear neighbours
 */
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

public class DemandingDilemma {
    
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases = sc.nextInt();
        while(noOfTestCases --> 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++)
                    mat[i][j] = sc.nextInt();
            }
            boolean isUndirectedGraph = true;
            for (int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++){
                    if(i != j && mat[i][j] == 1 && j < n && i < m && mat[j][i] == 1){
                        isUndirectedGraph = false;
                        break;
                    }
                }
            }
            output.append((isUndirectedGraph ? "Yes" : "No") + "\n");
        }
        System.out.print(output.toString());
    }
}