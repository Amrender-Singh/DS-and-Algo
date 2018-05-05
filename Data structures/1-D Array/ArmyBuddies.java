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

class ArmyBuddies
{   
	public static void main (String[] args) 
	{
	    Reader sc = new Reader();
        int s;
        int left[];
        int right[];
        StringBuilder output = new StringBuilder();
		while((s = sc.nextInt()) != 0){
            int b = sc.nextInt();
            left = new int[s+1];
            right = new int[s+1];
            int l, r;
            for(int i = 1; i <=s; i++){
                left[i] = i-1;
                right[i] = i + 1;
            }
            left[1] = -1;
            right[s] = -1;
            for(int i = 0; i < b; i++){
                l = sc.nextInt();
                r = sc.nextInt();
                if(right[r] != -1)
                    left[right[r]]  = left[l];
                if(left[l] != -1)
                    right[left[l]] = right[r];
            
                output.append( left[l] != -1 ? left[l] : "*");
                output.append(" ");
                output.append( right[r] != -1 ? right[r] : "*");
                output.append("\n");
            }
           output.append("-\n");
		}
		System.out.print(output.toString());
	}
}