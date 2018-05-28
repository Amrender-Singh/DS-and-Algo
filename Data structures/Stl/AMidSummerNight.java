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
               return null;
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
            return null;
        }
        return str;
    }
}

 public class AMidSummerNight {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        String s;
        while((s = sc.nextLine()) != null && !s.equals("")){
            int n = Integer.parseInt(s);
            int arr[] = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int median = arr[(arr.length - 1) / 2];
            int count = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == median || arr[i] == arr[n/2] )
                    count++;
            }
            output.append(median +" "+ count+" "+ (arr[n/2]-median+1)+"\n");
        }
        System.out.print(output.toString());
    }
}