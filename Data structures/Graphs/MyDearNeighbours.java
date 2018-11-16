import java.util.*;
import java.io.*;

/**
 * UVA- 599
 * My Dear neighbours
 */
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
class Neighbour{
    int outdegree, index;
    public Neighbour(int index,int outdegree){
        this.index = index;
        this.outdegree = outdegree;
    }
}
public class MyDearNeighbours {
    
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases = sc.nextInt();
        while(noOfTestCases --> 0){
            int p = sc.nextInt();
            int degree[] = new int[p];
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < p; i++){
                String s[] = sc.nextLine().split(" ");
                degree[i] = s.length;
                if(degree[i] < min)
                    min = degree[i];
            }
            boolean first = true;
            for(int i = 0; i < p; i++){
                if(min == degree[i]){
                    if(!first)
                        output.append(" ");
                    output.append(i+1);
                    first = false;
                }
            }
            output.append("\n");
            sc.nextLine();
        }
        System.out.print(output.toString());
    }
}