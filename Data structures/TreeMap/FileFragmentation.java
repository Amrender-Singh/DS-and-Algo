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

 public class FileFragmentation {
    public static void  readInputAndCreateMap(Reader sc, HashMap<String, Integer> fragments){
        ArrayList<String> list = new ArrayList<>();
        String s;
        while((s = sc.nextLine()) != null && !s.isEmpty()){
            list.add(s);
        }
        for(int i = 0; i < list.size(); i++){
            for (int j = i+1; j < list.size(); j++) {
                Integer count = fragments.get(list.get(i)+list.get(j));
                fragments.put(list.get(i)+list.get(j),  count != null ? count + 1: 1);
                count = fragments.get(list.get(j)+list.get(i));
                fragments.put(list.get(j)+list.get(i),  count != null ? count + 1: 1);
            }
        }
    }
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases = sc.nextInt();
        while(noOfTestCases --> 0){
            HashMap<String, Integer> fragments = new HashMap<>();
            readInputAndCreateMap(sc, fragments);
            String result = "";
            int max = Integer.MIN_VALUE;
            for(Map.Entry<String, Integer> entry : fragments.entrySet()){
                if(entry.getValue() > max)
                    result = entry.getKey();
            }
            output.append(result);
            if(n != 0)
                output.append("\n");
        }
        System.out.print(output.toString());
    }
}