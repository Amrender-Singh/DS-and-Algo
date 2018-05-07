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

 public class TheBlocksProblem {
           
@SuppressWarnings("unchecked")
        static Stack<Integer> [] blocks = (Stack<Integer>[])new Stack[26];
    static int[] record;
    public static void moveOnto(int a, int b){
        while(blocks[record[a]].peek() != a){
            int top = blocks[record[a]].pop();
            record[top] = top;
            blocks[top].push(top);
        }
        while(blocks[record[b]].peek() != b){
            int top = blocks[record[b]].pop();
            record[top] = top;
            blocks[top].push(top);
        }
        blocks[record[b]].push(a);
        blocks[record[a]].pop();
        record[a] = record[b];
    }
    public static void moveOver(int a, int b){
       while(blocks[record[a]].peek() != a){
            int top = blocks[record[a]].pop();
            record[top] = top;
            blocks[top].push(top);
        }
        blocks[record[b]].push(a);
        blocks[record[a]].pop();
        record[a] = record[b];
    }
    public static void pileOnto(int a, int b){
       while(blocks[record[b]].peek() != b){
            int top = blocks[record[b]].pop();
            record[top] = top;
            blocks[top].push(top);
        }
        Stack<Integer> temp = new Stack<>();
        while(blocks[record[a]].peek() != a){
            temp.push(blocks[record[a]].pop());
        }
        blocks[record[b]].push(a);
        while(!temp.isEmpty()){
            record[temp.peek()] = record[b];
            blocks[record[b]].push(temp.pop());
        }
        blocks[record[a]].pop();
        record[a] = record[b];
    }

    public static void pileOver(int a, int b){
     Stack<Integer> temp = new Stack<>();
        while(blocks[record[a]].peek() != a){
            temp.push(blocks[record[a]].pop());
        }
        blocks[record[b]].push(a);
        while(!temp.isEmpty()){
            record[temp.peek()] = record[b];
            blocks[record[b]].push(temp.pop());
        }
        blocks[record[a]].pop();
        record[a] = record[b];   
    }
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int n = sc.nextInt();
        record = new int[n];
        for(int i =0; i < n; i++){
            blocks[i] = new Stack<Integer>();
        }
        for(int i = 0; i < n; i++){
            blocks[i].push(i);
            record[i] = i;
        }
        String command, operation;
        int a, b;
        while((command = sc.next())!= null && !command.equals("quit")){
            a = sc.nextInt();
            operation = sc.next();
            b = sc.nextInt();
            if(record[a] == record[b]){
                continue;
            }
            if(command.equals("move") && operation.equals("onto")){
                moveOnto(a, b);
            } else if(command.equals("move") && operation.equals("over")){
                moveOver(a, b);
            } else if(command.equals("pile") && operation.equals("onto")){
                pileOnto(a, b);
            } else if(command.equals("pile") && operation.equals("over")){
                pileOver(a, b);
            }
        }   
        Stack<Integer> temp  = new Stack<>();
        for(int i = 0; i < n; i++){
            output.append(i+":");
            while(!blocks[i].isEmpty()){
                temp.push(blocks[i].pop());
            }
            while(!temp.isEmpty()){
                output.append(" "+temp.pop());
            }
            output.append("\n");
        }
        System.out.print(output.toString());
    }
}