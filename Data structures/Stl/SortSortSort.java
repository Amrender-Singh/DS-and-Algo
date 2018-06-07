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

 public class SortSortSort {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int N;
        ArrayList<Integer> list;
        while((N = sc.nextInt()) != 0){
            int M  =  sc.nextInt();
            list = new ArrayList<>();
            for(int i = 0; i < N; i++){
                list.add(Integer.parseInt(sc.nextLine()));
            }
            Collections.sort(list, (a,b)->{
               int  mod1 = a%M;
               int mod2 = b%M;
               if(mod1 != mod2)
                return mod1 < mod2 ? -1 : 1;
                else {
                    if(a%2 ==0){
                        return b%2 == 0 ? ((a <  b) ? -1 : 1) : 1;
                    } else {
                        return b % 2 != 0 ? ((a > b) ? -1 : 1) : -1; 
                    }
                }
            });
            output.append(N +" "+ M +"\n");
            for(int i : list){
                output.append(i+"\n");
            }
        }
        output.append("0 0\n");
        System.out.print(output.toString());
    }
}