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

 public class Formula1{
    public static void main(String[] args) {
            Reader sc =  new Reader();
            StringBuilder output = new StringBuilder();
            int g;
            while((g = sc.nextInt())!= 0){
                int p = sc.nextInt();
                int grandPrixResult [][] = new int[g][p];
                for(int i = 0 ; i < g; i++){
                    for(int j = 0; j < p; j++){
                        int pos = sc.nextInt();
                        grandPrixResult[i][pos -1] = j + 1;
                    }
                }
                int result[] = new int[p];
                int s = sc.nextInt();
                int score [][] = new int[s][p];
                for(int i = 0; i < s; i++){
                    int k = sc.nextInt();
                    for(int j = 0; j < k; j++ ){
                        score[i][j] = sc.nextInt();
                    }
                }
                int sum = 0;
                int max = Integer.MIN_VALUE;
                for(int i = 0; i < s; i++){
                    max = Integer.MIN_VALUE;
                    result = new int[p];
                    for(int j = 0; j < g; j++){
                        for(int h = 0; h < p; h++){
                            result[grandPrixResult[j][h]-1] += score[i][h];
                            max = Math.max(max, result[grandPrixResult[j][h]-1]);
                        }
                    } boolean found = false;
                    for(int h  = 0; h < p; h++){
                        if(result[h] == max){
                            output.append((found? " ": "")+(h+1));
                            found = true;
                        }
                    }
                    output.append("\n");
                }
                
            }
            System.out.print(output.toString());
        }
}