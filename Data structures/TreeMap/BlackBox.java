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

public class BlackBox{
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        int K = sc.nextInt();
        int M, N;
        LinkedList<Integer> ADD, GET;
        PriorityQueue<Integer> MinHeap, MaxHeap;
        while(K --> 0){
            sc.nextLine();
            M = sc.nextInt();
            N = sc.nextInt();
            ADD = new LinkedList<>();
            GET = new LinkedList<>();
            MinHeap = new PriorityQueue<>();
            MaxHeap = new PriorityQueue<>(Collections.reverseOrder());
            int i = 0;
            while(M --> 0){
                ADD.add(sc.nextInt());
            }
            while(N --> 0){
                GET.add(sc.nextInt());
            }
            while(!ADD.isEmpty()) {
                if(MaxHeap.isEmpty() || (!MinHeap.isEmpty()  && ADD.peek() > MaxHeap.peek()))
                    MinHeap.add(ADD.poll());
                else
                    MaxHeap.add(ADD.poll());
                
                while(!GET.isEmpty() && MaxHeap.size()+MinHeap.size() == GET.peek()) {
                    while(MaxHeap.size() != i) {
                        if(MaxHeap.size() < i) {
                            MaxHeap.add(MinHeap.poll());
                        } else if(MaxHeap.size() > i) {
                            MinHeap.add(MaxHeap.poll());
                        }
                    }
                    output.append(MinHeap.peek()+"\n");
                    i++;GET.poll();
                }
            }
            if(K != 0)
                output.append("\n");
        }    
        System.out.print(output.toString());
    }
}