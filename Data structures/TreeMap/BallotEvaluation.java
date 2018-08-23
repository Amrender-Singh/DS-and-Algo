import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

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
               return null;
            }
        }
        return st.nextToken();
    }
    int nextInt(){
        return Integer.parseInt(next());
    }
    Double nextDouble(){
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

public class BallotEvaluation{
    public static boolean isCorrect(String operator, int value1, int value2){
        boolean result = false;
        if(operator.equals("<=")){
            result = value1 <= value2;
        }
        if(operator.equals(">=")){
            result = value1 >= value2;
        }
        if(operator.equals("<")){
            result = value1 < value2;
        }
        if(operator.equals(">")){
            result = value1 > value2;
        }
        if(operator.equals("=")){
            result = (value1 == value2);
        }
        return result;
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        int p = sc.nextInt();
        int g = sc.nextInt();
        HashMap<String, Integer> list = new HashMap<>();
        while(p --> 0){
            list.put(sc.next().trim(), (int)Math.floor(sc.nextDouble()*10));
        }
        String guess;
        int total = 0;
        int val;
        int i =1;
        while(g --> 0){
            while(!(guess = sc.next()).equals("<=") && !guess.equals(">=") && !guess.equals("=") && !guess.equals("<") && !guess.equals(">")){
                if(!guess.equals("+"))
                    total += list.get(guess.trim());
            }
            val = sc.nextInt()*10;
            output.append("Guess #" + i + " was " + (isCorrect(guess, total, val) ? "correct" : "incorrect") +".\n");    
             total = 0;
             i++;
        }
        System.out.print(output.toString());
    }
}