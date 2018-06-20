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

 public class BrotherArif {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int caseNo = 0;
        while(true){
            int r = sc.nextInt();
            int c = sc.nextInt();
            int n = sc.nextInt();
            if(r == 0 && n == 0)
                break;
            boolean colMask[] = new boolean[c];
            boolean rowMask[] = new boolean[r];
            int i = 0;
            while(i < n){
                int row = sc.nextInt();
                int col = sc.nextInt();
                colMask[col] = true;
                rowMask[row] = true;
                i++;
            }
            int arifRow = sc.nextInt();
            int arifCol = sc.nextInt();
            caseNo++;
            output.append("Case "+caseNo+": ");
            if((!rowMask[arifRow] && !colMask[arifCol]) || (arifRow > 0 && !rowMask[arifRow-1] && !colMask[arifCol]) || (arifRow < r-1 && !rowMask[arifRow+1] && !colMask[arifCol]) || (arifCol > 0 && !rowMask[arifRow] && !colMask[arifCol-1]) || (arifCol < c-1 && !rowMask[arifRow] && !colMask[arifCol+1])){
                output.append("Escaped again! More 2D grid problems!\n");
            }else{
                output.append("Party time! Let's find a restaurant!\n");
            }
        }
        System.out.print(output.toString());
    }
}