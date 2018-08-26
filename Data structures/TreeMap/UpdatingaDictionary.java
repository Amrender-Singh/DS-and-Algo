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

public class UpdatingaDictionary{
    public static void processInput(String input, HashMap<String, String> map){
        String dictionary[] = input.substring(1, input.length()-1).split(",");
        if(dictionary[0].trim().equals(""))
            return;
        for (int i = 0; i < dictionary.length; i++) {
            String pair[] = dictionary[i].split(":");
            map.put(pair[0].trim(), pair[1].trim());
        }
    }
    public static void readInputAndCreateMap(Reader sc, HashMap<String, String> oldDictionary, HashMap<String, String>  newDictionary){
        String input = sc.nextLine();
        processInput(input, oldDictionary);
        input = sc.nextLine();
        processInput(input, newDictionary);
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases = sc.nextInt();
        HashMap<String, String> oldDictionary, newDictionary;
        while(noOfTestCases --> 0){
            oldDictionary = new HashMap<>();
            newDictionary = new HashMap<>();
            TreeSet list[] = new TreeSet[3];
            list[0] = new TreeSet<String>();
            list[1] = new TreeSet<String>();
            list[2] = new TreeSet<String>();
            readInputAndCreateMap(sc, oldDictionary, newDictionary);
            for(Map.Entry<String, String> entry : oldDictionary.entrySet()){
                String val = newDictionary.get(entry.getKey());
                if(val == null)
                    list[1].add(entry.getKey());
                else if(val.compareTo(entry.getValue()) != 0)
                    list[2].add(entry.getKey());
            }
            for(Map.Entry<String, String> entry : newDictionary.entrySet()){
                String val = oldDictionary.get(entry.getKey());
                if(val == null)
                    list[0].add(entry.getKey());
            }
            boolean changed = false;
            String operator [] = {"+","-","*"};
            for(int i = 0; i < list.length; i++){
                if(list[i].size() > 0){
                    output.append(operator[i]+list[i].pollFirst());
                    while(!list[i].isEmpty()){
                        output.append(","+list[i].pollFirst());
                    }
                    output.append("\n");
                    changed = true;
                }
            }
            if(!changed)
                output.append("No changes\n");

            output.append("\n");
        } 
        System.out.print(output.toString());
    }
}