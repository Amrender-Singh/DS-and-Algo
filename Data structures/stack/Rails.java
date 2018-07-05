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

 public class Rails {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int n;
        Stack<Integer> A, station;
        while((n = sc.nextInt()) != 0){
            int coach;
            station = new Stack<>();
            int i = 0, j = 0;
            while((coach = sc.nextInt()) != 0){
                while( j < n && j !=  coach){
                    if(!station.isEmpty() && station.peek() == coach)
                        break;
                    station.push(++j);
                }
                if(!station.isEmpty() &&station.peek() == coach)
                    station.pop();
                i++;
                if(i == n){
                    output.append(station.size() == 0 ? "Yes" : "No");
                    output.append("\n");
                    i = 0;
                    j = 0;
                    station = new Stack<>();
                }
            }
            output.append("\n");
        }
        System.out.print(output.toString());
    }
}