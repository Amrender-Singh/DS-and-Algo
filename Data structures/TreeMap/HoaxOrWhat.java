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

public class HoaxOrWhat{
    public static int readInputAndSolve(Reader sc, int n){
        int amount = 0;
        int k, a;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        while(n --> 0){
            k = sc.nextInt();
            while(k --> 0){
                a = sc.nextInt();
                map.put(a, map.getOrDefault(a,0)+1);
            }
            int highest = map.lastKey();
            if (map.get(highest) == 1)  map.remove(highest);
            else map.put(highest, map.get(highest)-1);
            
            int lowest = map.firstKey();
            if (map.get(lowest) == 1)  map.remove(lowest);
            else map.put(lowest, map.get(lowest)-1);
            amount += (highest - lowest);
        }
        return amount;
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        int n;
        while((n = Integer.parseInt(sc.nextLine())) != 0){
            output.append(readInputAndSolve(sc, n)+"\n");
        }
        System.out.print(output.toString());
    }
}