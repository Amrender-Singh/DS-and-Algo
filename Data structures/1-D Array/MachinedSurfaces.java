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
                e.printStackTrace();;
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
            e.printStackTrace();
        }
        return str;
    }
}
/**
 * MachinedSurfaces
 */
public class MachinedSurfaces {
    public static void main(String args[]){
        Reader sc = new Reader();
        int N;
        PriorityQueue<Integer> pq =  new PriorityQueue<>();
        String str = "";
        int spaces;
        StringBuilder out = new StringBuilder();
        while((N = sc.nextInt()) != 0){
            for(int i = 0; i < N; i++){
                spaces = 0;
                str = sc.nextLine();
                for(int j = 0; j < str.length(); j++){
                    if((int)str.charAt(j)== 32)
                        spaces++;
                }
                pq.add(spaces);
            }
            int minSpace = pq.poll();
            int result = 0;
            while(!pq.isEmpty()){
                result += (pq.poll() - minSpace);
            }
            out.append(result + "\n");
        }
        System.out.print(out.toString());
    }
    
}