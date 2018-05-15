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

 public class SpiralTap {
    public static void getCoordinates(long size, long k, StringBuilder output){
        long i = 1;
        while((i*i) < k){
            i +=2;
        }
        if(i == 1){
            output.append("Line = "+ ((size/2)+1)+ ", column = " + ((size/2)+1) + ".");
            return;
        }
        long x = 0, y = 0;
        long lowerBond = (i - 2) * (i -2);
        long pad = (size - i)/2;
        if(k <= lowerBond + (i-1)){
            x = lowerBond + i - k + pad;
	        y = size - pad;
        } else if(lowerBond + i-1 < k && k <= lowerBond + 2*(i-1)) {
            x = pad + 1;
            y = lowerBond + (i-1) * 2+1 - k + pad;
        } else if(lowerBond + 2*(i-1) < k && k <= lowerBond + 3*(i-1)) {
            x = k-(lowerBond+ 2*(i-1)) + pad + 1;
            y = pad + 1;
        } else {
            x = size - pad;
            y = k - (lowerBond+3*(i-1))+pad+1;
        }
        output.append("Line = "+ y + ", column = " + x + ".");
    }
    public static void main(String[] args) {
            Reader sc =  new Reader();
            StringBuilder output = new StringBuilder();
            long N;
            while((N = sc.nextInt())!= 0){
                long k = sc.nextLong();
                getCoordinates(N, k, output);
                output.append("\n");
            }
            System.out.print(output.toString());
        }
}