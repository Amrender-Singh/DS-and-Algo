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

class NewsPaper
{   
	public static void main (String[] args) 
	{
	    Reader sc = new Reader();
	    int noOfTestCases = sc.nextInt();
	    int testCase = 0;
	    HashMap<Character, Integer> priceMap;
		while(noOfTestCases -- > 0){
		    priceMap = new HashMap<>();
		    int noOfCharacters = sc.nextInt();
		    for(int i = 0 ; i < noOfCharacters; i++){
		        char character = sc.next().charAt(0);
		        int price = sc.nextInt();
		        priceMap.put(character, price) ;
		    }
		    int noOfLines = sc.nextInt();
		    double price = 0.0;
		    String line;
		    for(int  i = 0; i < noOfLines; i++){
		        line = sc.nextLine();
		        for(int j = 0; j < line.length(); j++){
		            if(priceMap.containsKey(line.charAt(j))){
		                price += priceMap.get(line.charAt(j));
		            }
		        }
		    }
		    System.out.format("%.2f$\n", price/100);
		}
		
	}
}