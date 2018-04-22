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
 * BeggerMyNeighbour
 */
public class Main {
    private static boolean game = false;
    public static boolean isFaceCard(String s){
        return s.charAt(1) =='A' || s.charAt(1) =='K'|| s.charAt(1) =='Q' || s.charAt(1) =='J';
    }
    public static boolean simulate(LinkedList<String> heap, LinkedList<String> dealer, LinkedList<String> player, String s, boolean isPlayer){
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
            if(isPlayer && player.isEmpty()){
              //      game = true;
                    return !isPlayer; //simply return game over
                    
            }
            if(!isPlayer && dealer.isEmpty()){
            // game = true;
             return !isPlayer; //simply return game over   
            }
            if(isPlayer)
                s = player.poll();
            else
                s = dealer.poll();
            heap.add(s);
            
            if(isFaceCard(s)){
                return simulate(heap, dealer, player, s, isPlayer);
            }
        }

        while(!heap.isEmpty()){
            if(!isPlayer)
                player.add(heap.poll());
            else
                dealer.add(heap.poll());
        }   
        return isPlayer;
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        String st ;
        while((st =  sc.nextLine()) != null && !st.equals("#")){
            game = false;
            StringBuilder sb = new StringBuilder(st);
            for(int i = 1; i <= 3; i++){
                st = sc.nextLine();
                sb.append(" ");
                sb.append(st);
            }
            
            String str[] = sb.toString().split("\\s+");
            LinkedList<String> dealer = new LinkedList<>();
            LinkedList<String> player =  new LinkedList<>();
            for(int i = 0; i < 51; i+= 2){
                player.add(str[i]);
                dealer.add(str[i+1]);
            }
            Collections.reverse(player);
            Collections.reverse(dealer);
            LinkedList<String> heap = new LinkedList<>();
            boolean isPlayer = true;
            String card = "";
    
            while(true){
                if(isPlayer && player.isEmpty())
                    break;
                if(!isPlayer && dealer.isEmpty())
                    break;
                if(isPlayer)
                    card = player.poll();
                else
                    card = dealer.poll();
            
                heap.add(card);
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