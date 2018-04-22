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
 * ReverseAndAdd
 */
public class ReverseAndAdd {
    public static long reverse(long num){
        long rev = 0;
        while(num > 0){
            rev = rev*10 + num%10;
            num /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        Reader sc =  new Reader();
        int noOfTestCases  = sc.nextInt();     
        while(noOfTestCases -- > 0){
            long num = sc.nextLong();
            long rev = 0;
            int count  = 0;
            while(num != rev){
                count++;
                num += rev;
                rev = reverse(num);
            }
            System.out.println(count+" "+num);
        }
    }
}