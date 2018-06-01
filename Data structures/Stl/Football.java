import java.io.*;
import java.util.*;

import javax.lang.model.util.ElementScanner6;

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
class  Team{
    String teamName;
    int points;
    int gamesPlayed;
    int wins, tie, lose;
    int goalScored, goalAgainst;
    Team(String Name){
        teamName = Name;
    }
}
public class FootBall{
     public static void main(String []args){
        Reader sc = new Reader();
        HashMap<String, Team> map;
        StringBuilder output = new StringBuilder();
        int N = sc.nextInt();
        while(N -- > 0){
            String leagueName = sc.nextLine();
            int noOfTeams = sc.nextInt();
            map = new HashMap<>();
            String teamName;
            for(int i = 0; i < noOfTeams; i++){
                teamName = sc.nextLine();
                map.put(teamName, new Team(teamName));
            }
            int noOfmatches = sc.nextInt();
            String info[];
            while(noOfmatches -- > 0){
                info = sc.nextLine().split("[#@]");
                String teamName1 = info[0];
                String teamName2 = info[info.length-1];
                int goalsScoredByTeam1 = Integer.parseInt(info[1]);
                int goalsScoredByTeam2 = Integer.parseInt(info[2]);
                Team team1 = map.get(teamName1);              
                Team team2 = map.get(teamName2);
                team1.gamesPlayed += 1;
                team2.gamesPlayed += 1;
                team1.goalScored  += goalsScoredByTeam1;
                team2.goalScored  += goalsScoredByTeam2;
                team1.goalAgainst += goalsScoredByTeam2;
                team2.goalAgainst += goalsScoredByTeam1;
                if(goalsScoredByTeam1 > goalsScoredByTeam2){
                    team1.wins += 1;
                    team2.lose += 1;
                    team1.points +=3;
                } else if(goalsScoredByTeam1 < goalsScoredByTeam2){
                    team2.wins += 1;
                    team1.lose += 1;
                    team2.points +=3;
                } else{
                    team1.tie +=1;
                    team2.tie += 1;
                    team1.points += 1;
                    team2.points +=1;
                }
                map.put(teamName1, team1);
                map.put(teamName2, team2);
            }
            ArrayList<Team> list = new ArrayList<>(map.values());
            Collections.sort(list, (a,b)->{
                if(a.points != b.points)
                    return b.points - a.points;
                else if(a.wins != b.wins)
                    return b.wins - a.wins;
                else if((a.goalScored - a.goalAgainst) != (b.goalScored - b.goalAgainst))
                    return (b.goalScored - b.goalAgainst) - (a.goalScored - a.goalAgainst);
                else if(a.goalScored != b.goalScored)
                    return b.goalScored - a.goalScored;
                else if(a.gamesPlayed != b.gamesPlayed)
                    return a.gamesPlayed - b.gamesPlayed;
                else 
                    return a.teamName.toLowerCase().compareTo(b.teamName.toLowerCase());
            });
            output.append(leagueName+"\n");
            for(int i = 0; i < list.size(); i++){
                Team a = list.get(i);
                output.append((i+1) +") "+ a.teamName +" "+a.points +"p, " + a.gamesPlayed + "g ("+a.wins + "-" + a.tie + "-" + a.lose + "), "+(a.goalScored - a.goalAgainst)+"gd ("+a.goalScored + "-" + a.goalAgainst  + ")\n");
            }
            //output.append("\n");
        }
        System.out.print(output.toString());
     }
}