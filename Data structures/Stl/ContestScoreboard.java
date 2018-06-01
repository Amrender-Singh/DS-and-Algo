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
            return null;
        }
        return str;
    }
}
class Team {
    int team, prbSolved, time;
}
 public class ContestScoreboard {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int N = sc.nextInt();
        sc.nextLine();
        while(N -- > 0){
            String str[];
            String s;
            int scoreboard[][] = new int[101][10];
            int accepted[][] = new int[101][10];
            int app[] = new int[101];
            while((s = sc.nextLine()) != null && !s.equals("")){
                str = s.split(" ");
                int team = Integer.parseInt(str[0]);
                int prob = Integer.parseInt(str[1]);
                app[team] = 1;
                if(str[3].charAt(0) == 'I'){
                    if(accepted[team][prob] == 1)   continue;
                    scoreboard[team][prob] += 20;
                } else if(str[3].charAt(0) == 'C'){
                    if(accepted[team][prob] == 1)   continue;
                    accepted[team][prob] = 1;
                    scoreboard[team][prob] += Integer.parseInt(str[2]);
                }
            }
            ArrayList<Team> list  = new ArrayList<>();
            for(int i = 1; i <= 100; i++){
                if(app[i] == 1){
                    Team team = new Team();
                    team.team = i;
                    for(int j = 0;  j < 10; j++){
                        if(accepted[i][j] == 1){
                            team.prbSolved++;
                            team.time += scoreboard[i][j]; 
                        }
                    }
                    list.add(team);
                }
            }
            Collections.sort(list, (a,b) -> {
                if(a.prbSolved != b.prbSolved)
                    return b.prbSolved - a.prbSolved;
                else if(a.time != b.time)
                    return a.time - b.time;
                return a.team - b.team;
            });
            for(Team team : list){
                output.append(team.team+" "+team.prbSolved+" "+team.time+"\n");
            }
            if(N > 0)
                output.append("\n");
        }
        System.out.print(output.toString());
    }
}