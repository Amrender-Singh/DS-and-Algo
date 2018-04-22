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
 * WhatsTheCard
 */
public class WhatsTheCard {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        int noOfTestCases = sc.nextInt();
        int testNo = 0;
        HashMap<Character, Integer> map =  new HashMap<>();
        map.put('2',2);
        map.put('3',3);
        map.put('4',4);
        map.put('5',5);
        map.put('6',6);
        map.put('7',7);
        map.put('8',8);
        map.put('9',9);
        map.put('T',10);
        map.put('J',10);
        map.put('Q',10);
        map.put('K',10);
        map.put('A',10);
        while(testNo ++ < noOfTestCases){
            LinkedList<String> pile1 = new LinkedList<>();
            String card = "";
            for(int i = 0; i < 52; i++){
                
                pile1.add(sc.next());
            }
            int y  = 0;
            for(int i = 0; i < 3; i++){
                card  = pile1.poll();
                int x = map.get(card.charAt(0));
                y += x;
                int j = 10 -x;
                while(j > 0 ){
                    pile1.poll();
                    j--;
                }
            }          
             card = pile1.get(y-1);
            
            System.out.println("Case "+testNo+": "+ card);
        }    
    }    
}