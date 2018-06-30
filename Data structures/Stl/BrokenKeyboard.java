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
        LinkedList<Character> first;
        LinkedList<Character> last;
        while((s = sc.nextLine()) != null && s != ""){
            first = new LinkedList<>();
            last = new LinkedList<>();
            boolean addLast = true;
            for(int i = 0 ; i < s.length(); i++){
                if(s.charAt(i) == '[') {
                    last.addAll(0, first);
                    first.clear();
                    addLast = false;
                    continue;
                }
                if(s.charAt(i) ==  ']'){
                    addLast = true;
                    continue;
                }
                if(addLast)
                    last.add(s.charAt(i));
                else    
                    first.add(s.charAt(i));
            }
            StringBuilder sb = new StringBuilder();
            first.addAll(last);
            for(Character c  : first){
                sb.append(c);
            }
            output.append(sb.toString()+"\n");
        }
        System.out.print(output.toString());
    }
}