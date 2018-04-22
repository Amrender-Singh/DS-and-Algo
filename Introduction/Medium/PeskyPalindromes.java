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
/**
 * PeskyPalindromes
 */
public class PeskyPalindromes {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        String str;
        while((str =  sc.nextLine()) != null && str.length() > 0){
            HashMap<Character, Integer> count = new HashMap<>();
            HashSet<String> palindromes = new HashSet<>();
            for(int i = 0; i < str.length(); i++){
                if(count.containsKey(str.charAt(i))){
                    count.put(str.charAt(i), count.get(str.charAt(i))+1);  
                } else{
                    count.put(str.charAt(i), 1);  
                }
            }
            int noOfPalindome = count.size();
            for(int i = 0; i < str.length(); i++){
                StringBuilder s = new StringBuilder(str.charAt(i)+"");
                for(int j =  i+1; j < str.length(); j++){
                    s.append(str.charAt(j));
                    StringBuilder s2 = new StringBuilder(s);
                     StringBuilder s3 = new StringBuilder(s);
                    s3.reverse();
                    if(s3.toString().equals(s2.toString())){
                        
                        if(!palindromes.contains(s2.toString())){
                            noOfPalindome++;   
                            palindromes.add(s2.toString());
                        }
                    }
                }
            }
            System.out.println("The string '"+str+"' contains "+noOfPalindome+" palindromes.");
        }
    }
}