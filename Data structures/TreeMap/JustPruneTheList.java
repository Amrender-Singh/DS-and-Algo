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

public class JustPruneTheList{
    public static void readInputAndCreateMap(Reader sc, int n, HashMap<Integer,Integer> map, boolean inc){
        int a;
        int add = inc ? 1 : -1;
        while(n --> 0){
            a = sc.nextInt();
            map.put(a, map.getOrDefault(a,0)+add);
        }
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases = sc.nextInt();
        int count, m, n;
        HashMap<Integer,Integer> list1;
        while(noOfTestCases --> 0){
            count = 0;
            m = sc.nextInt();
            n = sc.nextInt();
            list1 = new HashMap<Integer,Integer>();
            readInputAndCreateMap(sc, m, list1, true);
            readInputAndCreateMap(sc, n, list1, false);
            for(Map.Entry<Integer, Integer> entry : list1.entrySet()){
                    count += Math.abs(entry.getValue());
            }
            output.append(count+"\n");
        }
        System.out.print(output.toString());
    }
}