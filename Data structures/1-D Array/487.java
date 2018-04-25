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

class DuplicateTelephoneNumbers{   
    static HashMap<Character, Integer> standard;
    public static String covertToStandardForm(String s){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if((s.charAt(i) >= 'A' && s.charAt(i) <='Z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                if(standard.containsKey(s.charAt(i)))
                    str.append(standard.get(s.charAt(i)));
                else
                    str.append(s.charAt(i));
                if(str.length() == 3)
                    str.append("-");
            }
        }
        return str.toString();
    }
	public static void main (String[] args) {
		Reader sc = new Reader();
		int n ;
		standard = new HashMap<>();
		standard.put('A',2);
		standard.put('B',2);
		standard.put('C',2);
		standard.put('D',3);
		standard.put('E',3);
		standard.put('F',3);
		standard.put('G',4);
		standard.put('H',4);
		standard.put('I',4);
		standard.put('J',5);
		standard.put('K',5);
		standard.put('L',5);
		standard.put('M',6);
		standard.put('N',6);
		standard.put('O',6);
		standard.put('P',7);
		standard.put('R',7);
		standard.put('S',7);
		standard.put('T',8);
		standard.put('U',8);
		standard.put('V',8);
		standard.put('W',9);
		standard.put('X',9);
		standard.put('Y',9);
		StringBuilder output = new StringBuilder();
		TreeMap<String, Integer> map = new TreeMap<>();
	    int noOfDataSets = sc.nextInt();
	    sc.nextLine();
		while(noOfDataSets -- > 0){
		    int noOfContacts = sc.nextInt();
		    while(noOfContacts -- >0){
		        String str = sc.nextLine();
		        str = covertToStandardForm(str);
		            if(map.containsKey(str)){
		                map.put(str, map.get(str) + 1);
		            }else{
		                map.put(str,1);
		            }
            }
            boolean flag = false;
            int value = 0;
		    for(Map.Entry<String,Integer> m:map.entrySet()){
		        value = m.getValue(); 
                if(value > 1){
                    output.append(m.getKey() +" "+ value +"\n");
                    flag = true;
                }
		    }   
             
            if(!flag) {
		        output.append("No duplicates.\n");
		    }
		    if(noOfDataSets != 0 )
		        output.append("\n");
		    sc.nextLine();
		    map = new TreeMap<>();
		}
		System.out.print(output.toString());
	}
}