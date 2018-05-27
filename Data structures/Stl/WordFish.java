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

 public class WordFish {
     public static void swap(char arr[], int i, int j){
         char ch = arr[i];
         arr[i] = arr[j];
         arr[j] = ch;
     }
     public static String nextPermutation(String s){
        char arr[] = s.toCharArray();
        int index1 = 0, index2 = 0;
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] < arr[i+1]){
                index1 = i;
            }
        }
        for(int i = index1; i < arr.length; i++){
            if(arr[i] > arr[index1]){
                index2 = i;
            }
         }
        swap(arr, index1, index2);
        index1++;
        index2 = arr.length - 1;
        while(index1 <= index2){
            swap(arr, index1, index2);
            index1++;index2--;
        }
        String res = new String(arr);
        return res;
     }
     public static String prevPermutation(String s){
        char arr[] = s.toCharArray();
        int index1 = 0, index2 = 0;
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                index1 = i;
            }
        }
        for(int i = index1; i < arr.length; i++){
            if(arr[i] < arr[index1]){
                index2 = i;
            }
         }
        swap(arr, index1, index2);
        index1++;
        index2 = arr.length - 1;
        while(index1 <= index2){
            swap(arr, index1, index2);
            index1++;index2--;
        }
        String res = new String(arr);
        return res;
     }
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        String s;
        while((s = sc.nextLine()) != null){
            String arr [] = new String[21];
            arr[10] = s;
            for(int i = 9; i >= 0; i--){ 
                arr[i] = prevPermutation(arr[i+1]);
            }
            for(int i = 11; i < 21; i++){
                arr[i] = nextPermutation(arr[i-1]);
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            String res = "";
            for(String str : arr){
                min = Integer.MAX_VALUE;
                for(int i = 0; i < str.length()-1; i++){
                    min = Math.min(min, Math.abs(str.charAt(i) - str.charAt(i+1)));
                }
                if(max < min){
                    max = min;
                    res = str;
                }
            }
            output.append(res+max+"\n");
        }
        System.out.print(output.toString());
    }
}