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

public class HardwoodSpecies{
    public static int readInputAndCreateMap(Reader sc, TreeMap<String,Integer> map){
        String s;
        int total = 0;
        while((s = sc.nextLine()) != null && !s.isEmpty()){
            Integer count = map.get(s);
            map.put(s, count != null ? count + 1 : 1);
            total++;
        }
        return total;
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        int noOfTestCases = sc.nextInt();
        sc.nextLine();
        while(noOfTestCases --> 0){
            TreeMap<String, Integer> map = new TreeMap<>();
            int total = readInputAndCreateMap(sc, map);
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                double percentage =  entry.getValue() * 100.0 / total;
                System.out.printf("%s %.4f\n",entry.getKey(), percentage);
            }
            if(noOfTestCases != 0)
                System.out.println();
        }
    }
}