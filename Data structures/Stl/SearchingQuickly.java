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
                e.printStackTrace();;
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
            e.printStackTrace();
        }
        return str;
    }
}

 public class SearchingQuickly{
    public static void main(String[] args) {
        Reader sc =  new Reader();
        String s;
        HashSet<String> wordsToIgnore = new HashSet<>();
        while((s = sc.nextLine())!= null && !s.equals("::")){
            wordsToIgnore.add(s.toLowerCase());
        }
        TreeMap<String, ArrayList<String>> titles = new TreeMap<>();
        ArrayList<String> keywords = new ArrayList<>();
        while((s = sc.nextLine())!= null){
            s = s.toLowerCase();
            String str[] =  s.split(" ");
            for(int i = 0; i < str.length; i++){
                if(!wordsToIgnore.contains(str[i])){
                    str[i] = str[i].toUpperCase();
                    if(!titles.containsKey(str[i]))
                        titles.put(str[i], new ArrayList<String>());
                    titles.get(str[i]).add(String.join(" ",str));
                    str[i] = str[i].toLowerCase();
                } 
            }
        }
        for(Map.Entry<String, ArrayList<String>> entry : titles.entrySet()){
            ArrayList<String> keys = entry.getValue();
            for(String title : keys){
                System.out.println(title);
            }
        }
    }
}