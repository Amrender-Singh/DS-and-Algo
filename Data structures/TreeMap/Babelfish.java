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

public class Babelfish{
    public static void readInputAndCreateMap(Reader sc, HashMap<String,String> map){
        String s;
        while((s = sc.nextLine())!= null && !s.isEmpty()){
            String str[] = s.split(" ");
            map.put(str[1], str[0]);
        }
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();
        readInputAndCreateMap(sc, map);
        String s;
        while((s = sc.nextLine()) != null){
            String out = map.get(s);
            output.append((out != null ? out : "eh") + "\n");
        }   
        System.out.print(output.toString());
    }
}