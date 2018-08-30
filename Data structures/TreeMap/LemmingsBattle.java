import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

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

public class LemmingsBattle{
    public static void readInput(Reader sc, int n, PriorityQueue<Integer> pq){
        while(n --> 0){
            pq.add(sc.nextInt());
        }
    }
    public static void startBattle(int B, PriorityQueue<Integer> gpq, PriorityQueue<Integer> bpq){
        ArrayList<Integer> gwin, bwin;
        int n;
        while(!gpq.isEmpty() && !bpq.isEmpty()){
            gwin = new ArrayList<>();
            bwin = new ArrayList<>();
            n = B;
            while(n --> 0 && !gpq.isEmpty() && !bpq.isEmpty()){
                int a = gpq.poll(), b = bpq.poll();
                if(a > b)
                    gwin.add((a - b));
                else if(a < b)
                    bwin.add((b - a));
            }
            for(Integer i : gwin){
                gpq.add(i);
            }
            for(Integer i : bwin){
                bpq.add(i);
            }
        }
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases = sc.nextInt();
        PriorityQueue<Integer> gpq, bpq;
        while(noOfTestCases --> 0){
            int B = sc.nextInt();
            int SG = sc.nextInt();
            int SB = sc.nextInt();
            gpq = new PriorityQueue<>(Collections.reverseOrder());
            bpq = new PriorityQueue<>(Collections.reverseOrder());
            readInput(sc, SG, gpq);
            readInput(sc, SB, bpq);
            startBattle(B, gpq, bpq);
            if(!gpq.isEmpty() && bpq.isEmpty()){
                output.append("green wins\n");
                while(!gpq.isEmpty()){
                    output.append(gpq.poll()+"\n");
                }
            } else if(gpq.isEmpty() && !bpq.isEmpty()){
                output.append("blue wins\n");
                while(!bpq.isEmpty()){
                    output.append(bpq.poll()+"\n");
                }
            } else{
                output.append("green and blue died\n");
            }
            if(noOfTestCases != 0)
                output.append("\n");
        }
        System.out.print(output.toString());
    }
}