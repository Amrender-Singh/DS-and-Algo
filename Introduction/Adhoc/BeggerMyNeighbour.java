import java.io.*;
import java.util.*;

/***
 * This is wrong please refer another file.
 *  BeggerMyNeighbour2
 * this is kept just to compare why stack works wrong
 */

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
 * BeggerMyNeighbour
 */
public class BeggerMyNeighbour {
    public static boolean isFaceCard(String s){
        return s.charAt(1) =='A' || s.charAt(1) =='K'|| s.charAt(1) =='Q' || s.charAt(1) =='J';
    }
    public static boolean simulate(Stack<String> heap, Stack<String> dealer, Stack<String> player, String s, boolean isPlayer){
        int limit = 0;
        if(s.charAt(1) =='A')
            limit = 4;
        else if(s.charAt(1) =='K')
            limit = 3;
        else if(s.charAt(1) =='Q')
            limit = 2;
        else if(s.charAt(1) == 'J')
            limit = 1;

        isPlayer = !isPlayer;
        for(int i = 0; i < limit; i++){
            if(isPlayer && player.isEmpty())
                    return isPlayer; //simply return game over
            else if(!isPlayer && dealer.isEmpty())
                return isPlayer; //simply return game over
            if(isPlayer)
                s = player.pop();
            else
                s = dealer.pop();
            heap.push(s);
            if(isFaceCard(s)){
                return simulate(heap, dealer, player, s, isPlayer);
            }
        }
    
        while(!heap.isEmpty()){
            if(!isPlayer)
                player.push(heap.pop());
            else
                dealer.push(heap.pop());
        }   
        return isPlayer;
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        String st ;
        while((st =  sc.nextLine()) != null && !st.equals("#")){
            StringBuilder sb = new StringBuilder(st);
            for(int i = 1; i <= 3; i++){
                st = sc.nextLine();
                sb.append(" ");
                sb.append(st);
            }
            String str[] = sb.toString().split("\\s+");
            Stack<String> dealer = new Stack<>();
            Stack<String> player =  new Stack<>();
        
            for(int i = 0; i < 51; i+= 2){
                player.push(str[i]);
                dealer.push(str[i+1]);
            }
            Stack<String> heap = new Stack<>();
            boolean isPlayer = true;
            String card = "";
    
            while(true){
                if(isPlayer){
                    if(!player.isEmpty())
                    card = player.pop();
                else 
                    break;
                }
                else{
                if(!dealer.isEmpty())
                    card = dealer.pop();
                    else
                    break;
                }
                heap.push(card);
                if(isFaceCard(card)){
                    isPlayer = simulate(heap, dealer, player, card, isPlayer);
                }
                isPlayer = !isPlayer;
            }
            if(player.isEmpty())
                System.out.format("1%3d\n", dealer.size());
            else
                System.out.format("2%3d\n", player.size());
        }    
    }    
}