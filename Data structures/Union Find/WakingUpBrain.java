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

 public class WakingUpBrain {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        String s;
        while((s = sc.nextLine()) != null && !s.equals("")){
            HashMap<Character, Integer> charToInt = new HashMap<>();
            int idx = 0;
            int n = Integer.parseInt(s);
            int noOfConnections = sc.nextInt();
            String awaked = sc.nextLine();
            boolean visited[] = new boolean[26];
            for (int i = 0; i < 3; i++) {
                charToInt.put(awaked.charAt(i) ,idx);
                visited[idx] = true;
                idx++;
            }
            ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
            for(int i = 0; i < n; i++){
                adj[i] = new ArrayList<>();
            }
            String line;
            while(noOfConnections --> 0){
                line = sc.nextLine();
                if(!charToInt.containsKey(line.charAt(0))){
                    charToInt.put(line.charAt(0) ,idx);
                    idx++;
                }
                if(!charToInt.containsKey(line.charAt(1))){
                    charToInt.put(line.charAt(1) ,idx);
                    idx++;
                }
                adj[charToInt.get(line.charAt(0))].add(charToInt.get(line.charAt(1)));
                adj[charToInt.get(line.charAt(1))].add(charToInt.get(line.charAt(0)));
            }
            int count = 3;
            int res = 0;
            Stack<Integer> awake = new Stack<>();
            int cc = 0;
            while(count < n){
                for(int i = 0; i < n; i++){
                    if(visited[i]) continue;
                    cc = 0;
                    for(int j = 0; j < adj[i].size(); j++){
                        if(visited[adj[i].get(j)]) cc++;
                    }
                    if(cc >= 3){
                        awake.push(i);
                    }
                }
                if(awake.size() == 0){
                    output.append("THIS BRAIN NEVER WAKES UP");
                    break;
                }
                count += awake.size();
                res++;
                while(!awake.isEmpty())
                    visited[awake.pop()] = true;
            }   
            if(count == n)
                output.append("WAKE UP IN, "+res+", YEARS");
            output.append("\n");
            sc.nextLine();
        }
        System.out.print(output.toString());
    }
}