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

class JustFinishItUp
{   
	public static void main (String[] args) 
	{
	    Reader sc = new Reader();
	    int noOfTestCases = sc.nextInt();
	    int testCase = 0;
	    StringBuilder output = new StringBuilder();
		while(testCase++ < noOfTestCases){
		    int n = sc.nextInt();
		    int arr1[] = new int[n];
		    int arr2[] = new int[n];
		    int sum = 0 ;
		    int min = Integer.MAX_VALUE;
		    for(int i  = 0; i < n; i++){
		        arr1[i] = sc.nextInt();
		    }
		    for(int i = 0; i < n; i++){
                arr2[i] = sc.nextInt();
                sum += arr1[i] - arr2[i];
                min = Math.min(min, sum);
            }
            int index = 0;
		    while (min < 0 && index < n) {
			    min -= arr1[index] - arr2[index++];
		    }
            if (index == n || sum < 0){ 
                output.append("Case "+testCase+":"+" Not possible");
            } else {
                output.append("Case "+testCase+":"+" Possible from station "+(index+1));
            }
		    output.append("\n");
		}
		System.out.print(output.toString());
	}
}