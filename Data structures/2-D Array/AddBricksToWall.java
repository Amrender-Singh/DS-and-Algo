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

 public class AddBricksToWall {
    public static void fillOddRows(int arr[][]){
        for(int i = 2; i < 9; i += 2){
            for(int j = 1; j < i; j +=2){
        	    arr[i][j] = (arr[i-2][j-1] -(arr[i][j-1] + arr[i][j+1]))/2;
            }
        }
    }
    public static void main(String[] args) {
            Reader sc =  new Reader();
            StringBuilder output = new StringBuilder();
            int noOfTestCases = sc.nextInt();
            int arr[][];
            while(noOfTestCases --> 0){
                arr = new int[9][9];
                for(int i = 0; i < 9; i += 2){
            		for(int j = 0; j <= i; j+= 2){
            			arr[i][j] = sc.nextInt();
            		}
                }
                fillOddRows(arr);
                boolean oddRow = false;
                for(int i = 0; i < 9; i++){
                    if(i != 0)
                        output.append("\n");
                    oddRow = i % 2 !=0;
                    for(int j = 0; j <= i; j++){
                        if(oddRow){
                            output.append((arr[i+1][j] + arr[i+1][j+1]) + ((j != i) ? " " : ""));    
                        } else{
                            output.append(arr[i][j] + ((j != i) ? " " : ""));   
                        }
                    }
                }
                output.append("\n");
            }
            System.out.print(output.toString());
        }
}