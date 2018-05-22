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

 public class IDCodes {
     public static String nextPermutation(String s){
         char arr[] = s.toCharArray();
         int index1 = -1, index2 = -1;
         String result = "No Successor";
         for(int i = 0; i < arr.length-1; i++){
             if(arr[i] < arr[i+1]){
                index1 = i;
             }
         }
         if(index1 == -1)
            return result;
         for(int i = index1; i < arr.length; i++){
            if(arr[i] > arr[index1]){
                index2 = i;
            }
         }
        char temp = arr[index1];
        arr[index1] =  arr[index2];
        arr[index2] = temp;
        index1++;
        int j = arr.length-1;
        while(index1 < j){
            temp = arr[index1];
            arr[index1] =  arr[j];
            arr[j] = temp;
            j--;
            index1++;
        }
         String res = new String(arr);
        return res;
     }
    public static void main(String[] args) {
            Reader sc =  new Reader();
            StringBuilder output = new StringBuilder();
            String s;
            while((s = sc.nextLine()) != null && !s.equals("#")){
                output.append(nextPermutation(s)+"\n");
            }
            System.out.print(output.toString());
        }
}