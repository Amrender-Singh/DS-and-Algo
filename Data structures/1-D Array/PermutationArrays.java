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
    float nextFloat(){
        return Float.parseFloat(next());
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
 * PermutationArrays
 */
public class PermutationArrays {

    public static void main(String[] args) {
        Reader sc = new Reader();
        TreeMap<Integer, String> map;
        StringBuilder  output = new StringBuilder();
        int noOfTestCases = sc.nextInt();
        sc.nextLine();
        while(noOfTestCases -- > 0){
            map = new TreeMap<>();
            String index[] = sc.nextLine().split("\\s+");
            String num;
            for(String idx : index){
                num = sc.next();
                map.put(Integer.parseInt(idx) , num);
            }
            for(String i : map.values()){
                output.append(i+"\n");
            }
            if(noOfTestCases > 0)
                output.append("\n");
            sc.nextLine();
        }
        System.out.print(output.toString());
    }
}