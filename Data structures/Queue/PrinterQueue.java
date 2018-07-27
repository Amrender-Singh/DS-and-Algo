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
class Document{
    int priority;
    boolean ourDocument;
    Document(int priority, boolean ourDocument){
        this.priority = priority;
        this.ourDocument = ourDocument;
    }
}
 public class PrinterQueue {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases = sc.nextInt();
        while(noOfTestCases --> 0){
            LinkedList<Document> documentQueue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            int n = sc.nextInt();
            int m = sc.nextInt();
            int i = 0;
            boolean isOur = false;
            while(i < n){
                isOur = false;
                int priority = sc.nextInt();
                if(i == m){
                    isOur = true;
                }
                documentQueue.addLast(new Document(priority,isOur));
                priorityQueue.add(priority);
                i++;
            }
            int time = 0;
            while(true){
                if(documentQueue.peek().priority == priorityQueue.peek()){
                    time += 1;
                   if(documentQueue.peek().ourDocument)
                    break;
                   documentQueue.removeFirst();
                   priorityQueue.poll(); 
                } else{
                    documentQueue.addLast(documentQueue.removeFirst());
                }
            }
            output.append(time+"\n");
        }
        System.out.print(output.toString());
    }
}