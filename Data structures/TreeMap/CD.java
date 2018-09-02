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
            
        }
        return str;
    }
}

public class CD{
    public static int readInputAndSolve(Reader sc, int n, int m){
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        while(n --> 0){
            set.add(sc.nextInt());
        }
        while(m --> 0){
            if(set.contains(sc.nextInt()))
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        int n,m;
        while(true){
            n = sc.nextInt();
            m = sc.nextInt();
            if(n == 0 && m == 0)
                break;
            output.append(readInputAndSolve(sc, n, m)+"\n");
        }
        System.out.print(output.toString());
    }
}