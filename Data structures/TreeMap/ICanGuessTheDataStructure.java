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
public class ICanGuessTheDataStructure{
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        PriorityQueue<Integer> pq;
        Stack<Integer> st;
        LinkedList<Integer> list;
        String s;
        int commandType, val;
        while((s = sc.nextLine()) != null && !s.equals("")){
            int n = Integer.parseInt(s);
            if(n == 0){
                output.append("not sure\n");
                continue;
            }
            pq = new PriorityQueue<Integer>(Collections.reverseOrder());
            list = new LinkedList<>();
            st = new Stack<>();
            boolean result[] = new boolean[3];
            while(n --> 0){
                commandType = sc.nextInt();
                val = sc.nextInt();
                if(commandType == 1){
                    list.addLast(val);
                    pq.add(val);
                    st.push(val);
                } else{
                    if(list.isEmpty() || list.pollFirst() != val)
                        result[0] = true;
                    if(st.isEmpty() || st.pop() != val)
                        result[1] = true;
                    if(pq.isEmpty() || pq.poll() != val)
                        result[2] = true;
                }
            }
            int count = 0;
            for(boolean res : result){
                if(!res)
                    count++;
            }
            switch(count){
                case 0 : output.append("impossible\n"); break;
                case 1: if(!result[0]){
                            output.append("queue\n");
                        }else if(!result[1]){
                            output.append("stack\n");
                        } else{
                            output.append("priority queue\n");
                        }
                        break;
                default: output.append("not sure\n"); break;

            }
            
        }
        
        System.out.print(output.toString());
    }
}