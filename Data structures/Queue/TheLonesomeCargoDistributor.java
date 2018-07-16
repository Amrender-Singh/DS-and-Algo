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

 public class TheLonesomeCargoDistributor {
     public static int simulate(LinkedList[] list, Stack<Integer> stack , int maxCapacity, int noOfStations, int maxQueueCapacity, int totalCargoes){
        int time  = 0, cargoesPlaced = 0;
        int i = 0;
        while(cargoesPlaced < totalCargoes){
            while((stack.size() > 0) && ((list[i].size() < maxQueueCapacity) || stack.peek() == i)){
                int cargo = stack.pop();
                if(i == cargo){
                    cargoesPlaced++;
                }
                else{
                    list[i].addLast(cargo);
                }
                 time += 1;
            }
            while(stack.size() < maxCapacity  && list[i].size() > 0){
                Integer cargo = (Integer)list[i].removeFirst();
                stack.push(cargo);
                time += 1;
            }
            i++;
            if(cargoesPlaced != totalCargoes)
                time += 2;
            if(i == noOfStations)
                i = 0;
        }
        return time;
     }
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int noOfSets = sc.nextInt();
        while(noOfSets -- > 0){
            int noOfStations = sc.nextInt();
            int maxCapacity = sc.nextInt();
            int maxQueueCapacity = sc.nextInt();
            LinkedList list [] = new LinkedList[noOfStations];
            Stack<Integer> stack = new Stack();
            int totalCargoes = 0;
            for(int i = 0; i < noOfStations; i++){
                list[i] = new LinkedList<Integer>();
                int Qi = sc.nextInt();
                totalCargoes += Qi;
                for(int j = 0; j < Qi; j++){
                    list[i].addLast(sc.nextInt()-1);
                }
            }
            output.append(simulate(list, stack, maxCapacity, noOfStations, maxQueueCapacity, totalCargoes) + "\n");
        }
        System.out.print(output.toString());
    }
}