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

 public class ChildrensGame {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        ArrayList<String> list;
        int n;
        while((n = sc.nextInt()) != 0 ){
            list = new ArrayList<>();
            while(n-- > 0){
                list.add(sc.next());
            }
            Collections.sort(list, (s1,s2) ->{
               return (s2 + s1).compareTo(s1 + s2); 
                
            });
            StringBuilder res = new StringBuilder();
            for(int i = 0 ; i < list.size(); i++){
                res.append(list.get(i));
            }
            output.append(res+"\n");
        }
        System.out.print(output.toString());
    }
}