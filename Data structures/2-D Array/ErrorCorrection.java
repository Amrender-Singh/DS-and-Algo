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
            return null;
        }
        return str;
    }
}

 public class ErrorCorrection {
    static void getColAndRowSum(int arr[][], int n, int row[], int col[]){
        int colSum, rowSum;
        for(int i = 0; i < n; i++){
            colSum = 0;
            rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += arr[i][j];
                colSum += arr[j][i];
            }
            row[i] = rowSum;
            col[i] = colSum;
        }
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        int n ;
        int arr[][];
        int colSum[] , rowSum[];
        while((n = sc.nextInt()) != 0){
            arr = new int[n][n];
            colSum = new int[n];
            rowSum = new int[n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            getColAndRowSum(arr, n, rowSum, colSum);
            int rowCount = 0, colCount = 0;
            int row = 0, col = 0;
            for(int i = 0; i < n; i++){
                if(colSum[i] % 2 != 0){
                    col = i;
                    colCount++;
                    if(colCount >= 2)
                        break;
                }
                if(rowSum[i] % 2 != 0){
                    row = i;
                    rowCount++;
                    if(rowCount >= 2)
                        break;
                }
            }
            if(rowCount == 0 && colCount == 0){
                output.append("OK");
            } else if(rowCount == 1 && colCount == 1){
                output.append("Change bit ("+ (row+1)+","+(col+1)+")");
            } else {
                output.append("Corrupt");
            }
            output.append("\n");
        }
        System.out.print(output.toString());
    }
}