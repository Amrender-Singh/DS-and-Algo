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

 public class Brothers{
     public static void conquer(int arr[][], int b[][], int R, int C, int hier, int N, boolean  taken[][]) {
        int target = hier == N-1 ? 0 : hier + 1;
         for(int i = 0; i < R; i++){
             for(int j = 0; j < C; j++){
                 if(arr[i][j] == hier){
                     if(!taken[i][j])
                        b[i][j] = hier;
                    if(i < R -1 && arr[i+1][j] == target){
                        b[i+1][j] = hier;
                        taken [i+1][j] = true;
                    }
                    if(i > 0 && arr[i-1][j] == target ){
                        b[i-1][j] = hier;
                        taken[i-1][j]  = true;
                    }
                    if(j < C-1 && arr[i][j+1] == target){
                        b[i][j+1] = hier;
                        taken[i][j+1] = true;
                    } 
                    if( j > 0 && arr[i][j-1] == target){
                        b[i][j-1] = hier;
                        taken[i][j-1] = true;
                    }
                 }
             }
         }
     }
    public static void main(String[] args) {
            Reader sc =  new Reader();
            StringBuilder output = new StringBuilder();
            int N;
            while((N = sc.nextInt())!= 0){
                int R = sc.nextInt();
                int C = sc.nextInt();
                int K = sc.nextInt();
                int a[][] = new int[R][C];
                int b[][] = new int[R][C];
                boolean taken[][] = new boolean[R][C];
                for(int i = 0; i < R; i++){
                    for(int j =0; j < C; j++){
                        a[i][j] = sc.nextInt();
                    }
                }
                for(int i = 0 ; i < K; i++){
                    for(int j = 0; j < N; j++){
                        conquer(a, b, R, C, j, N, taken);
                    }
                    a = b;
                    b = new int[R][C];
                    taken = new boolean[R][C];
                }
                for(int i = 0; i < R; i++){
                    for(int j = 0; j < C; j++){
                        output.append((j > 0 ? " " : "") + a[i][j]);
                    }
                    output.append("\n");
                }
            }
            System.out.print(output.toString());
        }
}