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

 public class MirrorMirror2 {
    static boolean isPreserved(char a[][], char b[][], int max){
        for (int i = 0; i < max; i++) {

            for (int j = 0; j < max; j++) {
                if(a[i][j] != b[i][j])
                    return false;    
            }
        }
        return true;
    }
    
    static boolean isRotatedBy90(char a[][], char b[][], int max){
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                    if(b[i][j] != a[max-1-j][i])
                        return false;    
            }
        }
        return true;
    }

    static boolean isRotatedBy180(char a[][], char b[][], int max){
        for (int i = 0; i < max ; i++) {
            for (int j = 0; j < max; j++) {
                    if(b[i][j] != a[max-1-i][max-1-j])
                        return false;    
            }
        }
        return true;
    }

    static boolean isRotatedBy270(char a[][], char b[][], int max){
        for (int i = 0; i < max ; i++) {
            for (int j = 0; j < max; j++) {
                    if(b[i][j] != a[j][max-1-i])
                        return false;    
            }
        }
        return true;
    }
    static boolean isVerticallyReflected(char a[][], char b[][], int max){
        for (int i = 0; i < max ; i++) {
            for (int j = 0; j < max; j++) {
                    if(b[i][j] != a[max-1-i][j])
                        return false;    
            }
        }
        return true;
    }
      
    static void verticallyTranformORiginalArray(char a[][], int n){
        char temp;
        for(int i = 0; i <(n/2); i++){
            for (int j = 0; j < n; j++) {
                temp = a[i][j];
                a[i][j] = a[n-1-i][j];
                a[n-1-i][j] = temp;
            }
        }
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        char originalArray[][];
        char tranformedArray[][];
        int n;
        int test = 0;
        while(true){
            try {
              test++;
              n = sc.nextInt();
              originalArray = new char[n][n];
              tranformedArray = new char[n][n];
              
              for (int i = 0; i < n; i++) {
                  originalArray[i] = sc.next().toCharArray();
                  tranformedArray[i] = sc.next().toCharArray();
              }
              output.append("Pattern "+ test + " was ");
              if(isPreserved(originalArray, tranformedArray, n)){
                  output.append("preserved.");
              }
              else if(isRotatedBy90(originalArray, tranformedArray, n)){
                  output.append("rotated 90 degrees.");
              }
              else if(isRotatedBy180(originalArray, tranformedArray, n)){
                  output.append("rotated 180 degrees.");
              }
              else if(isRotatedBy270(originalArray, tranformedArray, n)){
                  output.append("rotated 270 degrees.");
              }
              else if(isVerticallyReflected(originalArray, tranformedArray, n)){
                  output.append("reflected vertically.");
              } else{
                    verticallyTranformORiginalArray(originalArray, n);
                    
                    if(isRotatedBy90(originalArray, tranformedArray, n)){
                        output.append("reflected vertically and rotated 90 degrees.");
                    }
                    else if(isRotatedBy180(originalArray, tranformedArray, n)){
                        output.append("reflected vertically and rotated 180 degrees.");
                    }
                    else if(isRotatedBy270(originalArray, tranformedArray, n)){
                        output.append("reflected vertically and rotated 270 degrees.");
                    }
                    else{
                        output.append("improperly transformed.");
                    }
              }
              output.append("\n");
            } catch (Exception e) {
                break;
            }
        }
        System.out.print(output.toString());
    }
}