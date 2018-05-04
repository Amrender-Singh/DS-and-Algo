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

class MusicalLoop
{   
    /*
        An element is peak element if and only if :
        - It is greater than both its neighbour
        - It is smaller than both its neighbour
    */ 
	public static void main (String[] args) 
	{
	    Reader sc = new Reader();
	    int n;
        StringBuilder output = new StringBuilder();
		while((n = sc.nextInt()) != 0){
            int arr[] = new int[n];
           for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
           }
           
           int peak = 0;
           if((arr[0] < arr[1] && arr[0] < arr[n-1]) || (arr[0] > arr[1] && arr[0] > arr[n-1]) ){ // check for n-1 is require since the loop is circular
               peak++;
           }

           for(int i = 1; i < n-1; i++){
                if((arr[i] >= arr[i-1] && arr[i] >= arr[i+1])  || (arr[i] <= arr[i-1] && arr[i] <= arr[i+1])){
                        peak++;
                }
            }

            if((arr[n-1] < arr[n-2] && arr[n-1] < arr[0]) || (arr[n-1] > arr[n-2] && arr[n-1] > arr[0])){
                peak++;
            }
           output.append(peak+"\n");
		}
		System.out.print(output.toString());
	}
}