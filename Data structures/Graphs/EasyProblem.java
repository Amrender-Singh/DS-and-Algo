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

public class EasyProblem {

    public static void main(String args[]){
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        String s;
        while((s = sc.nextLine())!= null && !s.equals("")){
            String input[] = s.split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            HashMap<Integer,ArrayList<Integer>> list = new HashMap<>();
            for(int i = 1; i <= n; i++){
                int j = sc.nextInt();
                if(list.containsKey(j))
                    list.get(j).add(i);
                else {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(i);
                    list.put(j, l);
                }
            }
            for(int i = 0; i < m; i++){
                int k = sc.nextInt();
                int v = sc.nextInt();
                ArrayList l = list.get(v);
                if(l == null || k > l.size())
                    output.append(0);
                else
                    output.append(l.get(k-1));
                output.append("\n");
            }
        }
        System.out.print(output.toString());
    }
}