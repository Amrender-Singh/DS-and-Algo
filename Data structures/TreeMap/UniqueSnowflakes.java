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

 public class UniqueSnowflakes {
    public static int  readInputAndGetMax(Reader sc){
        int max = 0;
        HashMap<Integer, Integer> set = new HashMap<>();
        int noOfFlakes = sc.nextInt();
        int currCount = 0, offset = 0;
        int previous = -1;
        int pos = 1;
        while(noOfFlakes --> 0){
            int num = sc.nextInt();
            Integer position = set.get(num);
            if(position != null){
                previous = Math.max(position, previous);
                currCount = pos - previous - 1;
            }
            set.put(num, pos);
            currCount++;
            max = Math.max(currCount, max);
            pos++;
        }
        return max;
    }
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases = sc.nextInt();
        while(noOfTestCases --> 0){
            output.append(readInputAndGetMax(sc)+"\n");
        }
        System.out.print(output.toString());
    }
}