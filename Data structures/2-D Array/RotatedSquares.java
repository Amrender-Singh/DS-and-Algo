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

 public class RotatedSquares {
   static boolean isEqual(char a[][],int startRow, int startCol, int N, char b[][], int n){
        if((startRow + (n-1) >= N) || (startCol + (n-1) >= N)){
            return false;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(a[startRow + i][startCol + j] != b[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    static int  subMatrixCount(char a[][],int N, char b[][], int n){
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(a[i][j] == b[0][0]){
                    if(isEqual(a, i, j, N, b, n)){
                        count++;
                    }    
                }
            }
        }
        return count;
    } 
  
    static void rotateMatrixBy90(char arr[][], int n){
        int length = n - 1;
        for(int i = 0; i <= length/2; i++){
            for(int j = i; j < length - i; j++){
                char p1 = arr[i][j];
                char p2 = arr[j][length - i];
                char p3 = arr[length - i][length -j];
                char p4 = arr[length - j][i];
                arr[i][j] = p4;
                arr[j][length - i] = p1;
                arr[length - i][length - j] = p2;
                arr[length - j][i] = p3;
            }
        }
    }
    public static void main(String[] args) {
            Reader sc =  new Reader();
            StringBuilder output = new StringBuilder();
            int N;
            char a[][], b[][];
            while((N = sc.nextInt())!= 0){
                int n = sc.nextInt();
                a = new char[N][N];
                b = new char[n][n];
                for(int i = 0; i < N; i++){
                    a[i] = sc.nextLine().toCharArray();
                }
                for(int i = 0; i < n; i++){
                    b[i] = sc.nextLine().toCharArray();
                }
                int count = 0;
                for(int i = 0; i < 4; i++){
                    count = subMatrixCount(a, N, b, n);
                    output.append(count);
                    if(i < 3){
                        output.append(" ");
                        rotateMatrixBy90(b, n);   
                    }
                }
                output.append("\n");
            }
            System.out.print(output.toString());
        }
}