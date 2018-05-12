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

 public class FreeSpots {
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        int w, h, n ;
        int arr[][];
        while((w = sc.nextInt()) != 0){
           h = sc.nextInt();
           n = sc.nextInt();
           arr = new int[502][502];
           int count = w*h;
           int row1, col1, row2, col2;
           for(int i = 0; i < n; i++){
                col1 = sc.nextInt();
                row1 = sc.nextInt();
                col2 = sc.nextInt();
                row2 = sc.nextInt();
                if(row1 > row2){
                    int temp = row1;
                    row1 = row2;
                    row2 = temp;
                }
                if(col1 > col2){
                    int temp = col1;
                    col1 = col2;
                    col2 = temp;
                }
                for(int j = row1-1; j < row2; j++){
                    for(int k = col1-1; k < col2; k++){
                        if(arr[j][k] == 0){
                            arr[j][k] = 1;
                            count--;
                        } 
                    }
                }
           }
           if(count == 0){
               output.append("There is no empty spots.");
           } else if(count  == 1){
                output.append("There is one empty spot.");
           } else{
                output.append("There are "+ count +" empty spots.");
           }
           output.append("\n");
            //sc.nextLine();
        }
        System.out.print(output.toString());
    }
}