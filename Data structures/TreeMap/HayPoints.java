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

public class HayPoints{
    public static void readInputAndCreateMap(Reader sc, HashMap<String,Integer> map, int n){
        while(n --> 0){
            String str[] = sc.nextLine().split(" ");
            map.put(str[0], Integer.parseInt(str[1]));
        }
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        readInputAndCreateMap(sc, map, n);
        String s;
        Integer out;
        while(m --> 0){
            int total = 0;
            while (!(s=sc.nextLine()).equals(".")) {
				for (String word : s.split(" ")){
                    out = map.get(word);
                    if(out != null)
                        total += out;
                }
            } 
            output.append(total + "\n");
        }   
        System.out.print(output.toString());
    }
}