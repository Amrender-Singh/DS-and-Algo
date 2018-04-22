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
 * MotherBear
 */
public class MotherBear {
    public static boolean isPalindrome(String s){
        int len = s.length();
        for(int i = 0; i < len/2; i++){
            if(s.charAt(i) != s.charAt(len-i-1))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Reader sc =  new Reader();
        String s;
        while((s = sc.nextLine()) != null && !s.equals("DONE")){
            s = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
            System.out.println(isPalindrome(s) ? "You won't be eaten!" : "Uh oh..");
        }
    }
    
}