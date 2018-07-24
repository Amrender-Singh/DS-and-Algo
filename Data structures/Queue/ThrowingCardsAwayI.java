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

 public class ThrowingCardsAwayI {
    public static void simulate(LinkedList<Integer> list, StringBuilder output){
        boolean first = true;
        while(true && list.size() > 1){
            output.append((first ?" " :", ") + list.pollFirst());
            if(list.size() == 1)
                break;
            first = false;
            list.addLast(list.pollFirst());
        }
    }
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int n;
        while((n = sc.nextInt()) != 0){
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = 1; i <= n; i++){
                list.addLast(i);
            }
            output.append("Discarded cards:");
            simulate(list, output);
            output.append("\nRemaining card: "+list.pollFirst()+"\n");
        }
        System.out.print(output.toString());
    }
}