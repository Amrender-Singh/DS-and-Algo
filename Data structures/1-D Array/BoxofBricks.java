import java.util.*;
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
class BoxofBricks
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Reader sc = new Reader();
		int n ;
		int arr[];
		StringBuilder output = new StringBuilder();
		int set  = 1;
	
		while((n = sc.nextInt()) != 0){
		
			arr = new int[n];
			int sum = 0;
			for(int i = 0 ; i < n; i++){
				 arr[i] = sc.nextInt();
				 sum += arr[i];
			}
			int targetHeight = sum/n;
			int moves = 0;
		    for(int i : arr){
		       if(i < targetHeight)
		        moves += (targetHeight - i);
		    }
			output.append("Set #"+set+"\n");
			output.append("The minimum number of moves is "+moves+".\n\n");
			
			set++;
		}
		System.out.print(output.toString());
	}
}