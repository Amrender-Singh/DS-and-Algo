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
 * FalseCoin
 */
public class FalseCoin {

    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases  = sc.nextInt();
        sc.nextLine();
        while(noOfTestCases -- > 0){
            int numberOfCoins = sc.nextInt();
            int numberOfComparisions = sc.nextInt();
            HashSet<Integer> set = new HashSet<>();
            for(int i = 1; i <= numberOfCoins; i++){
                set.add(i);
            }
            while(numberOfComparisions -- > 0){
                int coins = sc.nextInt();
                int arr[] = new int[coins*2];
                for(int i = 0; i < coins*2; i++){
                    arr[i] = sc.nextInt();
                }
                String str = sc.nextLine();
                if(str.equals("=")){
                    for(int i = 0; i < coins*2; i++){
                        if(set.contains(arr[i]))
                            set.remove(arr[i]);
                    }
                }
            }
            if(set.size() != 1){
		        output.append("0\n");
		    } else{
		         Iterator<Integer> I = set.iterator();
                while (I.hasNext())
                    output.append(I.next()+"\n");
            }
            if(noOfTestCases != 0)
                output.append("\n");
		    sc.nextLine();
        }
        System.out.print(output.toString());
    }
}