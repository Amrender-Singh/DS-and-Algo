/**
 * The execution time of this program on Uva was 0.110. Which is the top subsmission of this problem in java.
 */
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

public class SQFProblems{
    private static boolean isLetter(Character ch){
        return ch>='a' && ch <='z' || ch>='A' && ch <='Z';
    }
    public static void readInputAndCreateMap(Reader sc, LinkedHashMap<String,Integer> categorMap, HashMap<String, HashSet<String>> wordMap){
        int noOfCategories = sc.nextInt();
        while(noOfCategories --> 0){
            String word, categoryName;
            categoryName = sc.next();
            int words = sc.nextInt();
            int minWords = sc.nextInt();
            categorMap.put(categoryName, minWords);
            while (words --> 0) {
                word = sc.nextLine().trim();
                HashSet<String> list = wordMap.get(word);
                if(list == null)
                    list = new HashSet<>();
                list.add(categoryName);
                wordMap.put(word, list);
            }
        }
        HashSet<String> appearedWords = new HashSet<>();
        String s;
        StringBuilder word = new StringBuilder();
        while((s = sc.nextLine()) != null && !s.isEmpty()){
            for(int i = 0; i < s.length(); i++){
                while(i < s.length() && isLetter(s.charAt(i))){
                    word.append(s.charAt(i++));
                }
                if(word.length() > 0){
                    HashSet<String> list = wordMap.get(word.toString());
                    if(list != null && !appearedWords.contains(word.toString())){
                        for(String category : list){
                            
                            categorMap.put(category, categorMap.get(category)-1);
                        }
                    }
                    appearedWords.add(word.toString());
                    word.setLength(0);
                }
            }       
        }

    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases = sc.nextInt();          
        while(noOfTestCases --> 0){
            LinkedHashMap<String, Integer> categoryMap = new LinkedHashMap<>();
            HashMap<String, HashSet<String>> wordMap = new HashMap<>();
            readInputAndCreateMap(sc, categoryMap, wordMap);
            StringBuilder result = new StringBuilder();
            for(Map.Entry<String, Integer> entry : categoryMap.entrySet()){
                if(entry.getValue() <= 0){
                    if(result.length() > 0){
                        result.append(","+entry.getKey());
                    } else{
                        result.append(entry.getKey());
                    }
                }
            }
            if(result.length() == 0){
                output.append("SQF Problem.\n");
            }else
                output.append(result+"\n");
        }
        System.out.print(output.toString());
    }
}