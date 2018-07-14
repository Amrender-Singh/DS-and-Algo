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

public class TeamQueue {
    static int seq = 0;
    static Reader sc =  new Reader();
    static void mapElementsToTeam(HashMap<String, Integer> map, int teamNo){
        int noOfElements = sc.nextInt();
        while(noOfElements -- > 0){
            String element = sc.next();
            map.put(element, teamNo);
        }
    }
    static void solve(HashMap<String, Integer> map, StringBuilder output, int noOfTeams){
        boolean isTeamMemberPresent[] = new boolean[noOfTeams];
        String command, element;
        LinkedList<LinkedList<String>> teamQueue = new LinkedList<>();
        LinkedList<String> teams[] = new LinkedList[noOfTeams];
        for(int i = 0; i < noOfTeams; i++){
            teams[i] = new LinkedList<>();
        }
        output.append("Scenario #"+seq+"\n");
        while(!(command = sc.next()).equals("STOP")){
            if(command.equals("ENQUEUE")){
                element = sc.next();
                int teamNo = map.get(element);
                teams[teamNo].add(element);
                if(!isTeamMemberPresent[teamNo]){
                    teamQueue.add(teams[teamNo]);
                    isTeamMemberPresent[teamNo] = true;   
                }
            } else{
                output.append(teamQueue.peek().peek()+"\n");
                int teamNo = map.get(teamQueue.peek().removeFirst());
                if(teamQueue.peek().size() == 0){
                    teamQueue.removeFirst();
                    isTeamMemberPresent[teamNo] = false;
                }
            }
        }
        output.append("\n");
    }
    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();
        int noOfTeams;
        while((noOfTeams = sc.nextInt()) != 0){
            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0; i < noOfTeams; i++){
                mapElementsToTeam(map,i);
            }
            seq++;
            solve(map,output, noOfTeams);
        }
        System.out.print(output.toString());
    }
}