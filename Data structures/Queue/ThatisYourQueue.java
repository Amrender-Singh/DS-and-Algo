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

 public class ThatisYourQueue {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int testCase = 1;
        while(true){
            int n, commands;
            n = sc.nextInt();
            commands = sc.nextInt();
            if(commands == 0 && n == 0){
                break;
            }
            n = n <= 1000 ? n : 1000; 
            LinkedList<Integer> queue = new LinkedList<>();
            for(int i = 1; i <= n; i++){
                queue.addLast(i);
            }
            char command;
            output.append("Case "+testCase+":\n");
            while(commands -- > 0){
                command = sc.next().charAt(0);
                if(command == 'N'){
                    output.append(queue.peek() + "\n");
                    queue.addLast(queue.removeFirst());
                } else{
                    Integer patientNo = sc.nextInt();
                    queue.remove(patientNo);
                    queue.addFirst(patientNo);
                }
            }
            testCase++;
        }
        System.out.print(output.toString());
    }
}