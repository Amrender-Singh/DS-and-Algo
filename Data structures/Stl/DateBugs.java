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

 public class ClassName {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int n ;
        int caseNo = 1;
        while((n = sc.nextInt()) != 0){
            int a[] = new int[n];
            int b[] = new int[n];
            int y[] = new int[n];
            int diff[] = new int[n];
            int yMax = 0;
        
            for(int i = 0; i < n; i++){
                y[i] = sc.nextInt();
                a[i] = sc.nextInt();
                b[i] = sc.nextInt();
                diff[i] = b[i] - a[i];
                if(y[i] > yMax)
                    yMax = y[i];
            }
            int j = 0;
            for(;yMax < 10000; yMax++){
               
                for(j = 0; j < n; j++){
                    if( (yMax-y[j]) %diff[j] != 0)
                        break;
                }
                if(j == n){
                    break;
                }
                    
            }
            output.append("Case #"+ caseNo+":\n");
            if(yMax == 10000)
                output.append("Unknown bugs detected.\n\n");
            else
                output.append("The actual year is "+ yMax +".\n\n");
            caseNo++;
        }
        System.out.print(output.toString());
    }
}