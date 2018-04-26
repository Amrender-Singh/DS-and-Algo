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

/* Name of the class has to be "Main" only if the class is public. */
class Hartal
{   
	public static void main (String[] args) throws java.lang.Exception
	{
	    Reader sc = new Reader();
	    int noOfTestCases = sc.nextInt();
	    StringBuilder output = new StringBuilder();
		while(noOfTestCases -- > 0){
		    int count = 0;
		    int days = sc.nextInt();
		    int parties = sc.nextInt();
		    int hartal;
		    boolean flag[] = new boolean[3651];
		    while(parties -- >0){
		        hartal = sc.nextInt();
		        int num = hartal;
		        while(hartal <= days){
		            flag[hartal] = true;
		            hartal += num;
		        }
		    }
		    for(int i = 1; i <= days; i++){
		        if(flag[i] && i % 7 != 6 && i % 7 != 0)
		            count++;
		    }
		    output.append(count+"\n");
		}
		System.out.print(output.toString());
	}
}