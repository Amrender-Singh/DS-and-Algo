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
            return null;
        }
        return str;
    }
}

 public class WhatIsTheMedian {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        String s;
        ArrayList<Long> list = new ArrayList<>();
        while((s = sc.nextLine()) != null && !s.equals("")){
            long num = Long.parseLong(s.trim());
            list.add(num);
            Collections.sort(list);
            int size = list.size() >> 1;
            output.append((list.size()%2 != 0 ? list.get(size) : (list.get(size) + list.get(size-1))/2) + "\n");
        }
        System.out.print(output.toString());
    }
}