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

class BuildingDesigning
{   
    public static int getMaxHeight(Integer arr[], int n, boolean color){
        int max = 0;
        color = !color;
        for(int i = 0; i < n;  i++){
            if(!color && arr[i] < 0){
                max++;
                color = !color;
            } else if(color && arr[i] > 0) {
                max++;
                color = !color;
            }
        }
        return max;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	   Reader sc = new Reader();
	    int noOfTestCases = sc.nextInt();
	    StringBuilder output = new StringBuilder();
	    HashSet<Integer> set;
		while(noOfTestCases -- > 0){
		    set = new HashSet<>();
            int n = sc.nextInt();
            Integer arr[] = new Integer[n];
            int i = 0;
            while(i < n){
                arr[i] = sc.nextInt();
                i++;
            }
            Arrays.sort(arr,new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    return Math.abs(o1) - Math.abs(o2);
                }
            });
            output.append(Math.max(getMaxHeight(arr, n, false), getMaxHeight(arr, n, true))+"\n");
        }
		System.out.print(output.toString());
	}
}