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

 public class ColinAndRyan {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases = sc.nextInt();
        ArrayList<Integer> list;
        int caseNo  = 0;
        while(caseNo ++ < noOfTestCases){
            int C = sc.nextInt();
            int R = sc.nextInt();
           list = new ArrayList<>();
           int  q = C - R;
            int i = 1;
            output.append("Case #"+caseNo+":");
            while((q/i) > R && i <= Math.sqrt(q)){
                if(q % i == 0){
                    if(q/i == i && (i > R)){
                        output.append(" "+ i);
                    } else{
                        if(i > R)
                            output.append(" "+ i);
                        if((q/i) > R)
                            list.add(q/i);
                    }
                }
                i++;
            }
            for(i = list.size()-1; i >= 0; i--){
                output.append(" "+list.get(i));
            }
            
            if(C == R)
                output.append(" "+0);
            output.append("\n");
        }
        System.out.print(output.toString());
    }
}