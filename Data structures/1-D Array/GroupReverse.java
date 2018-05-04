/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
class Reader{
        BufferedReader br;
        StringTokenizer st;
 
        public Reader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
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

class GroupReverse
{   
	public static void main (String[] args) 
	{
	    Reader sc = new Reader();
	    int n;
        StringBuilder output = new StringBuilder();
        StringBuilder sentence = new StringBuilder();
		while((n = sc.nextInt()) != 0){
           String str = sc.next();
           int len = str.length() / n;
           for(int i = 0; i < str.length(); i+= len){
            int j = i+len-1;    
                while(j >= i){
                    sentence.append(str.charAt(j));
                    j--;
                }
           }
           output.append(sentence+"\n");
           sentence.setLength(0);
		}
		System.out.print(output.toString());
	}
}