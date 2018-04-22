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
class LoveCalculator{
    static int getNum(String s){
         int num = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = Character.toLowerCase(s.charAt(i));
            if(ch >= 'a' && ch <= 'z'){
                num += (ch - 'a') + 1;
            }
        }
        return num%9 ==0 ? 9 : num%9;
    }
    public static void main(String args[]){
        Reader sc = new Reader();
        String str;
        while((str = sc.nextLine())!= null && str.length() > 0){
            int num1 = getNum(str);
            String str1 = sc.nextLine();
            int num2 = getNum(str1);
            int min= Math.min(num1, num2);
            int max = Math.max(num1, num2);
            float result = ((float)(min*100.00)/(float)max);
            System.out.printf("%.2f",result);
            System.out.print(" %\n");
        }    
    }
    
}