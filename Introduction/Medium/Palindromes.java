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
public class Palindromes {
    public static boolean isPalindrome(String str){
        int len = str.length();
        for(int i = 0; i < len/2; i++){
            if(str.charAt(i) != str.charAt(len - i-1)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Reader sc =  new Reader();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('A','A');
        map.put('E','3');
        map.put('H','H');
        map.put('I','I');
        map.put('J','L');
        map.put('L','J');
        map.put('M','M');
        map.put('O','O');
        map.put('S','2');
        map.put('T','T');
        map.put('U','U');
        map.put('V','V');
        map.put('W','W');
        map.put('X','X');
        map.put('Y','Y');
        map.put('Z','5');
        map.put('1','1');
        map.put('2','S');
        map.put('3','E');
        map.put('5','Z');
        map.put('8','8');
        String str;
        while((str =  sc.nextLine()) != null && str.length() > 0){
            boolean palindrome = isPalindrome(str);
            boolean isMirrored = true;
            char[] s = str.toCharArray();

            for(int i = 0; i < str.length(); i++){
                if(map.containsKey(s[i])){
                    s[i] =  map.get(s[i]);
                }else{
                    isMirrored = false;
                    break;
                }
            }
            if(isMirrored){
                StringBuilder sb = new StringBuilder();
                for(int i = s.length-1; i >=0; i--){
                    sb.append(s[i]);
                }
                isMirrored = (sb.toString()).equals(str);
            }
            if(!palindrome && !isMirrored){
                System.out.println(str +" -- is not a palindrome.");
            } else if(palindrome && !isMirrored){
                System.out.println(str +" -- is a regular palindrome.");
            } else if(! palindrome && isMirrored){
                System.out.println(str +" -- is a mirrored string.");
            } else{
                System.out.println(str +" -- is a mirrored palindrome.");
            }
            System.out.println();
        }
    }
}