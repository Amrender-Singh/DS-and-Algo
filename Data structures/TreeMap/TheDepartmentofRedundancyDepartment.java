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
                return "0";
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

public class TheDepartmentofRedundancyDepartment {
    
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int  n;
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        while((n = sc.nextInt())!= 0){
            Integer count = map.get(n);
            if(count == null)
                map.put(n, 1);
            else    
                map.put(n, count+1);
        }
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            output.append(m.getKey()+" "+m.getValue() + "\n");
        }
        System.out.print(output.toString());
    }
}