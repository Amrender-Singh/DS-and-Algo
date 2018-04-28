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
 * LetsPlayMagic
 */
public class LetsPlayMagic {

    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        String arrangement[];
        int n;
        while((n = sc.nextInt()) != 0){
            arrangement = new String[n];
            String card, spell;
            int idx = 0;
            for(int i = 0; i < n; i++){
                card = sc.next();
                spell = sc.next();
                int len = spell.length();
                while(len > 0){
                    if(arrangement[idx] == null)
                        len--;
                    idx++;
                    if(idx >= n)
                        idx = 0;
                }
                arrangement[(idx-1+n)%n] = card;
            }
            for(int i = 0; i < arrangement.length; i++){
                if(i > 0){
                    output.append(" ");
                }
                output.append(arrangement[i]);
            }
            output.append("\n");
        }
        System.out.print(output.toString());
    }
}