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

 public class UniqueFactorization {
     static LinkedList<Integer> q;
     static void solve(int n,int i, ArrayList<LinkedList> list){
        for(; i*i <= n; i++){
            if(n%i == 0){
                q.addLast(i);
                solve(n/i,i,list);
                q.removeLast();
            }
        }
        q.addLast(n);
        LinkedList<Integer> l = new LinkedList(q);
        list.add(l);
        q.removeLast();
     }
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int n;
        while((n = sc.nextInt()) != 0){
            ArrayList<LinkedList> result = new ArrayList<>();
            q = new LinkedList<>();
            solve(n,2,result);
            output.append(result.size()-1 + "\n");
            for(int i = 0; i < result.size()-1; i++){
                int count = 0;
                for(Object num : result.get(i)){
                    if(count > 0)
                        output.append(" ");
                    output.append(num);
                    count++;
                }
                output.append("\n");
            }
        }   
        System.out.print(output.toString());
    }
}