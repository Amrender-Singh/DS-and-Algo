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

 public class AnagramsByStack {
     static void dfs(String a, String b, String stack, String path, int n, String target){
        if(n == 2 *target.length()){
            if(b.equals(target)){
                System.out.print("\n"+path);
                return;
            }
        }
        if(a.length() > 0){
            dfs(a.substring(1), b, stack + a.charAt(0) ,path + (n == 0 ? ("i") : (" i")), n+1, target);
        }
        if(stack.length() > 0 && stack.charAt(stack.length()-1) == target.charAt(b.length())){
            dfs(a, b + stack.charAt(stack.length()-1), stack.substring(0,stack.length()-1),path + (" o"), n+1, target);   
        }
     }
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        String source;
        while((source = sc.nextLine()) != null && !source.equals("")){
            String target = sc.nextLine();
            System.out.print("[");
            if(source.length() == target.length())
                dfs(source,"","","",0,target);
            System.out.print("\n]\n");
        }
    }
}