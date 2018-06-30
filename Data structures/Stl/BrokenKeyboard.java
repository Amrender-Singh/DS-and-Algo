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

 public class BrokenKeyboard {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        String s;
        LinkedList<Character> list;
        while((s = sc.nextLine()) != null && s != ""){
            list = new LinkedList<>();
            int pointerLocation = 0;
            for(int i = 0 ; i < s.length(); i++){
                if(s.charAt(i) == '[') {
                    pointerLocation = 0;
                }
                else if(s.charAt(i) ==  ']'){
                    pointerLocation = list.size();
                }
                else    
                    list.add(pointerLocation++,s.charAt(i));
            }
            StringBuilder sb = new StringBuilder();
            for(Character c  : list){
                sb.append(c);
            }
            output.append(sb.toString()+"\n");
        }
        System.out.print(output.toString());
    }
}