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
}/**
 * Jollo
 */
public class Jollo {
    public static void main(String[] args) {
        Reader sc = new Reader();
        int n;
        while((n = sc.nextInt()) != 0){
            int[] prince = new int[2];
            int[] princess = new int[3];
            boolean cards[] = new boolean[53];
            princess[0] = n;
            cards[princess[0]] = true;
            for(int i = 1; i <= 2; i++){
                princess[i] = sc.nextInt();
                cards[princess[i]] = true;
            }
            for(int i = 0; i < 2; i++){
                prince[i] = sc.nextInt();
                cards[prince[i]] = true;
            }
            Arrays.sort(prince);
            Arrays.sort(princess);
            int card = 53;
            if(prince[0] > princess[2]){
                for(int i = 1; i <=52 && i < card; i++){
                    if(!cards[i]){
                        card = i;
                        break;
                    }
                }
            }
            if(prince[1] > princess[2]){
                for(int i = princess[2]+1; i <=52 && i < card; i++){
                    if(!cards[i]){
                        card = i; 
                        break;
                    }
                }
            }
             if(prince[0] > princess[1]){
                for(int i = princess[1]+1; i <=52 && i < card; i++){
                    if(!cards[i]){
                        card = i;
                        break;
                    }
                }
            }
            System.out.println(card == 53? "-1" : card);
        }
    }
}