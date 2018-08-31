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

public class AndysFirstDictionary{
    public static void readInput(Reader sc, PriorityQueue<String> dictionary){
        String s;
        StringBuilder word = new StringBuilder();
        HashSet<String> set = new HashSet<>();
        while((s = sc.nextLine())!=null){
            for(int i = 0; i < s.length(); i++){
                while(i < s.length() && Character.isLetter(s.charAt(i))){
                    word.append(Character.toLowerCase(s.charAt(i)));
                    i++;
                }
                if(word.length() > 0 && !set.contains(word.toString())){
                    dictionary.add(word.toString());
                    set.add(word.toString());
                }
                word.dictionaryLength(0);
            }
        }
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        PriorityQueue<String> dictionary = new PriorityQueue<>();
        readInput(sc, dictionary);
        while(!dictionary.isEmpty()){
            output.append(dictionary.poll() + "\n");
        }
        System.out.print(output.toString());
    }
}