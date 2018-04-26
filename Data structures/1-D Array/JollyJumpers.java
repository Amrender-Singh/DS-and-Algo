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

class JollyJumpers{   
	public static void main (String[] args) {
		Reader sc = new Reader();
		StringBuilder output = new StringBuilder();
		String str;
		while((str = sc.nextLine())!= null){
		    String num[] = str.split(" ");
		    int n = Integer.parseInt(num[0]);
            boolean arr[] = new boolean[n];
            int arr2[] = new int[n];
            for(int i = 1; i <= n; i++){
                arr2[i-1] = Integer.parseInt(num[i]);
            }
            int diff = 0;
            for(int i = 0; i < n-1; i++){
                diff = Math.abs(arr2[i] - arr2[i+1]);
                if(diff < n)
                    arr[diff] = true;
            }
            boolean isJolly = true;
            for(int i = 1; i < n; i++){
                if(arr[i] == false){
                    isJolly = false;
                    break;
                }
            }
            output.append(isJolly ? "Jolly\n" :"Not jolly\n");
		}
		System.out.print(output.toString());
	}
}