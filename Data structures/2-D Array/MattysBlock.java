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
/**
 * MattysBlock
 */
public class MattysBlock {
    static int minimumBlockRequired(int front[], int right[], int k){
        boolean visitFront[] = new boolean[k];
        boolean visitRight[] = new boolean[k];
        int min = 0;
        for(int i = 0; i < k; i++){
            for(int j = 0; j < k; j++){
                if(front[i] == right[j] && !visitFront[i] && !visitRight[j]){
                    min += front[i];
                    visitFront[i] = true;
                    visitRight[j] = true;
                }
            }
        }
        for(int i = 0; i < k; i++){
            if(!visitFront[i])
                min += front[i];
            if(!visitRight[i])
                min += right[i];
        }
        return min;
    }
    static int maximumBlocksRequired(int front[], int right[], int k){
        boolean visitFront[] = new boolean[k];
        boolean visitRight[] = new boolean[k];
        int max = 0;
        for(int i = 0; i < k; i++){
            for(int j = 0; j < k; j++){
                max += Math.min(front[i], right[j]);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases  = sc.nextInt();
        while(noOfTestCases -- > 0){
           int n = sc.nextInt();
           int front[] = new int[n];
           int right[] = new int[n];
            for(int i = 0; i < n; i++){
                front[i] = sc.nextInt();
            }
            for(int i = 0; i < n; i++){
                right[i] = sc.nextInt();
            }
            int minimumBlocks = minimumBlockRequired(front, right, n);
            int maximumBlocks = maximumBlocksRequired(front, right, n);
            output.append("Matty needs at least " + minimumBlocks + " blocks, and can add at most " + (maximumBlocks - minimumBlocks) + " extra blocks.\n");
        }
        System.out.print(output.toString());
    }
}