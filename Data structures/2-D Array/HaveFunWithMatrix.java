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
                e.printStackTrace();;
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
            e.printStackTrace();
        }
        return str;
    }
}

 public class TheBlocksProblem {
     public static void swapRow(int arr[][], int n, int a, int b){
        for(int i = 0; i < n; i++){
            int temp = arr[a][i];
            arr[a][i] = arr[b][i];
            arr[b][i] = temp;
        }
    }
    public static void swapCol(int arr[][], int n, int a, int b){
        for(int i = 0; i < n; i++){
            int temp = arr[i][a];
            arr[i][a] = arr[i][b];
            arr[i][b] = temp;
        }
    }
    public static void transpose(int arr[][], int n){
        for(int i = 0; i <n; i++){
            for(int j = i; j < n; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
     public static void incDec(int arr[][], int n, boolean isDec){
         int val = 1;
         if(isDec){
             val = -1;
         }
        for(int i = 0; i <n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = (arr[i][j] + val) % 10;
                if(arr[i][j] < 0)
                    arr[i][j] = 9;
            }
        }
    }
    public static void main(String[] args) {
            Reader sc =  new Reader();
            StringBuilder output = new StringBuilder();
            int noOfTestCases = sc.nextInt();
            int arr[][];
            int test = 1;
            while(noOfTestCases --> 0){
                int n = sc.nextInt();
                arr = new int[n][n];
                for(int i = 0; i < n; i++){
                     String str[] = sc.nextLine().split("");
            		for(int j = 0; j < n; j++){
            			arr[i][j] = Integer.parseInt(str[j]);
            		}
                }
                int operations = sc.nextInt();
                String operation;
                int a, b;
                while(operations -- > 0){
                    operation = sc.next();
                    if(operation.charAt(0) == 'c'){
                        a = sc.nextInt();
                        b = sc.nextInt();
                        swapCol(arr, n, a-1, b-1);
                    } else if(operation.charAt(0) == 'r'){
                        a = sc.nextInt();
                        b = sc.nextInt();
                        swapRow(arr, n, a-1, b-1);
                    } else if(operation.charAt(0) == 't'){
                        transpose(arr,n);
                    }  else if(operation.charAt(0) == 'i'){
                        incDec(arr, n, false);
                    }   else {
                        incDec(arr, n, true);
                    }
                }
                output.append("Case #"+test+"\n");
                for(int i = 0; i < n; i++){
            		for(int j = 0; j < n; j++){
            			output.append(arr[i][j]);
            		}
            		output.append("\n");
                }
                output.append("\n");
                test++;
            }
            System.out.print(output.toString());
        }
}