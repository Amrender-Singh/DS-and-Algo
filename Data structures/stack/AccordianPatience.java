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
            
        }
        return str;
    }
}

 public class AccordianPatience {
     static boolean isMatch(String card1, String card2){
         return card1.charAt(0) == card2.charAt(0) || card1.charAt(1) == card2.charAt(1) ;
     }
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        ArrayList<Stack<String>> piles = new ArrayList<>(52);
        String s;
        while((s = sc.next()) != null && !s.equals("#")){
            piles.clear();
            for(int i = 0 ; i <= 51; i++){
                piles.add(new Stack<>());
            }
            piles.get(0).push(s);
            for(int i = 1; i < 52; i++){
                s = sc.next();
                piles.get(i).push(s);
            }
            for(int i = 0; i < piles.size(); i++){
                if(i >= 3 && isMatch(piles.get(i-3).peek(),piles.get(i).peek())){
                    piles.get(i-3).push(piles.get(i).pop());
                    if(piles.get(i).size() == 0)
                        piles.remove(i);
                    i = 0;
                }
                if(i >= 1 && isMatch(piles.get(i-1).peek(),piles.get(i).peek())){
                    piles.get(i-1).push(piles.get(i).pop());
                    if(piles.get(i).size() == 0)
                        piles.remove(i);
                    i = 0;
                }
            }
            output.append(piles.size() +" pile");
            if(piles.size() > 1)
                output.append("s");
            output.append(" remaining:");
            for(int i = 0; i < piles.size(); i++){
                output.append(" "+ piles.get(i).size());
            }
            output.append("\n");
        }
        System.out.print(output.toString());
    }
}