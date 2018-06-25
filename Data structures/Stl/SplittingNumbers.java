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

 public class SplittingNumbers {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int n;
        while((n = sc.nextInt()) != 0){
            int a = 0, b = 0;
            boolean flip = false;
            for(int i = 0; i < 32; i++){
                if((n & (1<<i)) != 0){
                    if(!flip)
                        a |= (1<<i);
                    else 
                        b |= (1<<i);
                    flip = !flip;
                }
            }
            output.append(a+" "+b+"\n");
        }
        System.out.print(output.toString());
    }
}