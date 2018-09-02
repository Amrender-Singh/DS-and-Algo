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
    public static void readInputAndCreateMap(Reader sc, int n, HashMap<Integer,Integer> map){
        int a;
        while(n --> 0){
            a = sc.nextInt();
            map.put(a, map.getOrDefault(a,0)+1);
        }
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases = sc.nextInt();
        int count, m, n;
        HashMap<Integer,Integer> list1, list2;
        while(noOfTestCases --> 0){
            count = 0;
            m = sc.nextInt();
            n = sc.nextInt();
            list1 = new HashMap<Integer,Integer>();
            list2 = new HashMap<Integer,Integer>();
            readInputAndCreateMap(sc, m, list1);
            readInputAndCreateMap(sc, n, list2);
            Integer list2Val;
            for(Map.Entry<Integer, Integer> entry : list1.entrySet()){
                list2Val = list2.get(entry.getKey());
                if(list2Val == null)
                    count += entry.getValue();
                else{
                    count += (Math.abs(entry.getValue() - list2Val));
                    list2.remove(entry.getKey());
                }
            }
            Integer list1Val;
            for(Map.Entry<Integer, Integer> entry : list2.entrySet()){
                list1Val = list1.get(entry.getKey());
                if(list1Val == null)
                    count += entry.getValue();
            }
            output.append(count+"\n");
        }
        System.out.print(output.toString());
    }
}