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

public class DocumentAnalyzer{
    public static int readInputAndCreateMap(Reader sc, ArrayList<Integer> words){
        String s;
        HashMap<String, Integer> map = new HashMap<>();
        int label = 0;
        while(!(s = sc.nextLine()).equals("END")){
            StringBuilder word = new StringBuilder();
            for(int i =0; i < s.length(); i++){
                while(i < s.length() && s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                    word.append(s.charAt(i));
                    i++;
                }
                if(word.length() > 0){
                    String wrd = word.toString();
                    Integer u = map.get(wrd);
                    if(u == null){
                        map.put(wrd, label);
                        words.add(label);
                        label++;
                    } else{
                        words.add(u);
                    }
                }
                word.setLength(0);
            }
        }
        return label;
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases = sc.nextInt();
        int i = 1;
        while(i <= noOfTestCases){
            ArrayList<Integer> words = new ArrayList<Integer>();
            int uniqueWords  = readInputAndCreateMap(sc, words);
            int t[] = new int[uniqueWords+1];
            int p = words.size(), q = 0;
            for(int j = 0, k= 0; j < words.size(); j++){
                if(++t[words.get(j)] == 1)
                    uniqueWords --;
                while(k < words.size() && t[words.get(k)] - 1 > 0){
                    t[words.get(k)] --;
                    k++;
                }
                if(uniqueWords == 0 && (p-q) > (j - k)){
                    p = j;
                    q = k;
                }
            }
             
           output.append("Document " + i +": "+ (q+1) +" "+ (p+1) +"\n");
           i++;
        } 
        System.out.print(output.toString());
    }
}