import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

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

public class SloganLearningofPrincess{
    public static void readInputAndCreateMap(Reader sc, HashMap<String, String> map){
        int n = sc.nextInt();
        while(n --> 0){
            map.put(sc.nextLine().trim(), sc.nextLine().trim());
        }
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();;
        readInputAndCreateMap(sc, map);
        int slogan = sc.nextInt();
        while(slogan --> 0){
            output.append(map.get(sc.nextLine().trim())+"\n");
        }
            
        System.out.print(output.toString());
    }
}