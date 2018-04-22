import java.io.*;
import java.util.*;



class Reader{
    BufferedReader br;
    StringTokenizer st;
    Reader(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next(){
        if(st == null || !st.hasMoreElements()){
            try {
                st = new StringTokenizer(br.readLine());                
            } catch (Exception e) {
                e.printStackTrace();;
            }
        }
        return st.nextToken();
    }
    int nextInt(){
        return Integer.parseInt(next());
    }
    double nextDouble(){
        return Double.parseDouble(next());
    }
    long nextLong()
    {
        return Long.parseLong(next());
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
/**
 * Mapmaker
 */
public class Mapmaker {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        HashMap<String, ArrayList<Integer>> list = new HashMap<>();
        int noOfArrays = sc.nextInt();
        int noOfReferences = sc.nextInt();
        ArrayList<Integer> details;
        while(noOfArrays -- > 0){
            details = new ArrayList<>();
            String elements[] = sc.nextLine().split(" +");
          for(int i = 1; i < elements.length; i++){
              details.add(Integer.parseInt(elements[i]));
          }
            list.put(elements[0], details);
        }
        StringBuilder outString = new StringBuilder();
        while(noOfReferences -- > 0){
            String elements[] = sc.nextLine().split(" +");
            details = list.get(elements[0]);
            outString.append(elements[0] + "[" + Integer.parseInt(elements[1]));
            int d = details.get(2);
            int  C[] = new int[d*2];
            int sBytes = details.get(1);
            int bounds[][] = 
            {
                {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0},
                {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}
            };
            int j =0;
            for (int i = 0; i < details.get(2); ++i)
            {
                bounds[i][0] = details.get(3+j);
                bounds[i][1] = details.get(3+j+1);
                j+=2;
            }
            int a = 0;
            a += (C[d] = sBytes) * bounds[d - 1][0];
            while (--d > 0)
                a += (C[d] = C[1 + d] * (bounds[d][1] - bounds[d][0] + 1)) * bounds[d - 1][0];
            
            C[0] = details.get(0) - a;
            int value = Integer.parseInt(elements[1]) * C[1];
            for (int t = 2; t <= details.get(2); ++t)
            {
                int temp = Integer.parseInt(elements[t]);
                outString.append(", " + temp);
                value += temp * C[t];
            }
            outString.append("] = " + (value + C[0]) + "\n");
        }   
        System.out.print(outString.toString());
    }
}