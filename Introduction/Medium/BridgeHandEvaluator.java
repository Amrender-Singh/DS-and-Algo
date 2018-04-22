/**
 * BridgeHandEvaluator
 */
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
class cardDetails{
    int nonFaceCount;
    int totalCount;
    boolean conatinsAce;
    boolean conatinsKing;
    boolean containsQueen;
    boolean conatinsJack;
    boolean isStopped;
}
public class BridgeHandEvaluator {
    public static int increaseCount(cardDetails obj, int count){
        if(obj.totalCount == 2)
            return count + 1;
        else if(obj.totalCount == 1 || obj.totalCount == 0)
            return count+2;
        return count;
    }
    public static boolean checkMax(cardDetails obj1, cardDetails obj2, cardDetails obj3, cardDetails obj4){
        return obj1.totalCount >= obj2.totalCount && obj1.totalCount >= obj3.totalCount && obj1.totalCount >= obj4.totalCount;
    }
    public static int substract(cardDetails S, int count){
        if((S.conatinsKing && S.totalCount-1 ==0))
            count =  count-1;
        if((S.containsQueen && S.totalCount-1 <= 1))
            count =  count-1;
        if((S.conatinsJack && S.totalCount-1 <= 2))
            count =  count -1;
        return count;
    }
    public static void isStopped(cardDetails obj){
        if(obj.conatinsAce)
            obj.isStopped = true;
        else if(obj.totalCount-1 >= 1 && obj.conatinsKing)
            obj.isStopped = true;
        else if(obj.totalCount-1 >= 2 && obj.containsQueen)
            obj.isStopped = true;
    }
    public static void main(String args[]){
        Reader sc = new Reader();
        String str = "";
        HashMap<String,Integer> rank = new HashMap<>();
        rank.put("A", 4);
        rank.put("K", 3);
        rank.put("Q", 2);
        rank.put("J", 1);

        while((str = sc.nextLine()) != null && str.length() > 0){
            HashMap<String,cardDetails> suit = new HashMap<>();
        suit.put("S", new cardDetails());
        suit.put("H", new cardDetails());
        suit.put("D", new cardDetails());
        suit.put("C", new cardDetails());
            String s[] = str.split("\\s+");
            int count = 0;
            for(int i =0; i < s.length; i++){
                    cardDetails obj =  suit.get(s[i].charAt(1)+"");
                    if(rank.containsKey(s[i].charAt(0)+"")){
                        int r = rank.get(s[i].charAt(0)+"");
                        count  += r;
                        if(r == 4){
                            obj.conatinsAce = true;
                        } else if(r == 3) {
                            obj.conatinsKing = true;
                        } else if(r == 2) {
                            obj.containsQueen = true;
                        } else {
                            obj.conatinsJack = true;
                        }
                    } else{
                        obj.nonFaceCount += 1;
                    }
                    obj.totalCount += 1;
                    suit.put(s[i].charAt(1)+"", obj);
            }
            cardDetails S = suit.get("S");
            cardDetails d = suit.get("D");
            cardDetails h = suit.get("H");
            cardDetails c = suit.get("C");
            isStopped(S);
            isStopped(d);
            isStopped(h);
            isStopped(c);
            count = substract(S, count);
            count =substract(d, count);
            count = substract(h, count);
            count = substract(c, count);
            if(S.isStopped && h.isStopped && d.isStopped && c.isStopped && count >= 16){
                System.out.println("BID NO-TRUMP");
            } else {
                count = increaseCount(S, count);
                count =increaseCount(d, count);
                count = increaseCount(h, count);
                count = increaseCount(c, count);
                if(count < 14)
                    System.out.println("PASS");
                else {
                    if(checkMax(S,c,d,h)){
                        System.out.println("BID S");
                    } else if(checkMax(h,c,d,S)){
                        System.out.println("BID H");
                    }
                    else if(checkMax(d,c,S,h)){
                        System.out.println("BID D");
                    } else if(checkMax(c,S,d,h)){
                        System.out.println("BID C");
                    } 
                }
            }
        }
    }
}