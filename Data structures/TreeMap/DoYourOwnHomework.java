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

public class DoYourOwnHomework{
    public static void readInputAndCreateMap(Reader sc, HashMap<String, Integer> map){
        String s;
        int n = sc.nextInt();
        while(n --> 0){
            map.put(sc.next().trim(), sc.nextInt());
        }
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases = sc.nextInt();
        int i = 1, D;
        String subject;
        Integer days;
        HashMap<String, Integer> map;
        while(i <= noOfTestCases){
            map = new HashMap<>();
            readInputAndCreateMap(sc, map);
            D = sc.nextInt();
            subject = sc.nextLine().trim();
            days = map.get(subject);
            if(days == null || days > (D+5)){
                output.append("Case " + i +":"+" Do your own homework!\n");
            } else{
                if(days <= D){
                    output.append("Case " + i +":"+" Yesss\n");
                } else{
                    output.append("Case " + i +":"+" Late\n");
                }
            }
             
           
           i++;
        } 
        System.out.print(output.toString());
    }
}