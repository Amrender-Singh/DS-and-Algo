import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

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

public class Exhibition{
    
    public static int readInputAndCreateMap(Reader sc, LinkedHashMap<Integer, Integer> list){
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        int noOfFriends = sc.nextInt();
        int i = 1;
        while(i <= noOfFriends){
            int m = sc.nextInt();
            while(m --> 0){
                int stamp = sc.nextInt();
                HashSet<Integer> set = map.get(stamp);
                if(set == null)
                    set = new HashSet<>();
                set.add(i);
                map.put(stamp, set);
            }
            list.put(i, 0);
            i++;
        }
        int noOfUniqueStamps = 0;
        for(Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()){
            if(entry.getValue().size() == 1){
                for(Integer j : entry.getValue()){
                    Integer count = list.get(j);
                    list.put(j, count+1);
                }
                noOfUniqueStamps++;
            }
        }
        return noOfUniqueStamps;
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        int nofOfTestCases = sc.nextInt();
        int i = 1;
        while(i <= nofOfTestCases){
            LinkedHashMap<Integer, Integer> list = new LinkedHashMap<>();
            int noOfUniqueStamps = readInputAndCreateMap(sc, list);
            output.append("Case "+ i + ":");
            for(Map.Entry<Integer,Integer> entry : list.entrySet()){
                double percentage = (double)(entry.getValue()*100)/noOfUniqueStamps;
				output.append(" "+String.format("%.6f%%",percentage));
            }
            output.append("\n");
            i++;
        }
        System.out.print(output.toString());
    }
}