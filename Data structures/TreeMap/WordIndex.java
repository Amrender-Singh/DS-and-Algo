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

 public class WordIndex {
     public static void generateStrings(TreeMap<String, Integer> map){
        LinkedList<String> list = new LinkedList<>();
        for(char c = 'a'; c <= 'z'; c++)
            list.add(Character.toString(c));
        int count = 1;
        while(!list.isEmpty()){
            String s =list.pollFirst();
            map.put(s, count);
            count++;
            if(s.length() == 5)
                continue;
            for(char c = (char)(s.charAt(s.length()-1)+1); c <= 'z'; c++){
                list.add(s + Character.toString(c));   
            }
        }
     }
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        String s;
        TreeMap<String, Integer> map = new TreeMap<>();
        generateStrings(map);
        while((s = sc.nextLine()) != null && !s.equals("")){
            Integer idx = map.get(s);
            output.append((idx != null? idx : 0 )+"\n");
        }
        System.out.print(output.toString());
    }
}