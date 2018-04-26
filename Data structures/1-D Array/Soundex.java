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

class Soundex
{   
	public static void main (String[] args) throws java.lang.Exception
	{
	    Reader sc = new Reader();
	    StringBuilder output = new StringBuilder();
	    String str;
	    HashMap<Character, Integer> standard = new HashMap<>();
		standard.put('B',1);
		standard.put('C',2);
		standard.put('D',3);
		standard.put('F',1);
		standard.put('G',2);
		standard.put('J',2);
		standard.put('K',2);
		standard.put('L',4);
		standard.put('M',5);
		standard.put('N',5);
		standard.put('P',1);
		standard.put('Q',2);
		standard.put('R',6);
		standard.put('S',2);
		standard.put('T',3);
		standard.put('V',1);
		standard.put('X',2);
		standard.put('Z',2);
	    while((str = sc.nextLine())!= null){
	        for(int i = 0; i < str.length(); i++){
	            if(i != 0 && standard.get(str.charAt(i)) == standard.get(str.charAt(i-1)))
	                continue;
	            if(standard.containsKey(str.charAt(i))){
	                int key = standard.get(str.charAt(i));
	                output.append(key);
	            }
	        }
	        output.append("\n");
	    }
		
		System.out.print(output.toString());
	}
}