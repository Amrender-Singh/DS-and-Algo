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

 public class Multitasking {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int n, m;
        String line;
        while((line = sc.nextLine())!=null && !line.equals("0 0") ){
            String[] ts = line.split(" +");
			 n = Integer.parseInt(ts[0]);
		     m = Integer.parseInt(ts[1]);
             if(n==0 && m ==0)
                break;
             boolean arr[] = new boolean[1000001];
             int i = 0;
             boolean result = true;
             while(i < n){
                line = sc.nextLine();
				ts = line.split(" +");
                int startTime = Integer.parseInt(ts[0]);
                int endTime = Integer.parseInt(ts[1]);
                while(result && startTime < endTime){
                    if(arr[startTime]){
                        result = false;
                        break;
                    }
                    arr[startTime++] = true;
                }
                i++;
            }
            i = 0;
            while(i < m){
                line = sc.nextLine();
				ts = line.split(" +");
                int startTime = Integer.parseInt(ts[0]);
                int endTime = Integer.parseInt(ts[1]);
                int interval = Integer.parseInt(ts[2]);
                while(result && startTime <= 1000000){
                    int k = startTime;
                    while(k < endTime){
                        if(arr[k]){
                            result = false;
                            break;
                        }
                        arr[k++] = true;
                    }
                    startTime += interval;
                    endTime =Math.min(endTime+interval, 1000000);
                }
                i++;
            }
            if(result)
                output.append("NO CONFLICT\n");
            else 
                output.append("CONFLICT\n");
        }
        System.out.print(output.toString());
    }
}