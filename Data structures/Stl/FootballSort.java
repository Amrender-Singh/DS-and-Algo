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
class Team{
    String team;
    int goalsScored, goalsAgainst, points, gamesPlayed;
    Team(String s){
        team = s;
        goalsScored = goalsAgainst = points = gamesPlayed = 0;
    }
}
 public class FootballSort {
    public static void getTeamName(HashMap<String,Team> map, int noOfTeams, Reader sc){
        for(int i = 0; i < noOfTeams; i++){
            String teamName = sc.nextLine();
            map.put(teamName, new Team(teamName));
        }
    }
    public static void getMatchResults(HashMap<String,Team> map, int noOfMatches, Reader sc){
        String info[];
        for(int i = 0;  i < noOfMatches; i++){
            info = sc.nextLine().split(" ");
            Team team1 = map.get(info[0]);
            Team team2 = map.get(info[info.length-1]);
            int score1 = Integer.parseInt(info[1]);
            int score2 = Integer.parseInt(info[3]);
            team1.gamesPlayed += 1;
            team2.gamesPlayed += 1;
            team1.goalsScored += score1;
            team1.goalsAgainst += score2;
            team2.goalsScored += score2;
            team2.goalsAgainst += score1;
            if(score1 != score2){
                team1.points += (score1 > score2 ? 3 : 0);
                team2.points += (score1 < score2 ? 3 : 0);
            }else{
                team1.points += 1;
                team2.points +=1;
            }
            map.put(info[0], team1);
            map.put(info[info.length-1],team2);
        }
    }
    public static void main(String[] args) {
        Reader sc =  new Reader();
        int noOfTeams;
        HashMap<String,Team> map;
        int n = 0;
        while((noOfTeams = sc.nextInt()) != 0){           
            int noOfMatches = sc.nextInt();
            map  = new HashMap<>();
            n++;
            getTeamName(map, noOfTeams, sc);
            getMatchResults(map, noOfMatches, sc);
            ArrayList<Team>  teams = new ArrayList<>(map.values()); 
            Collections.sort(teams, (a,b) ->{
                if(a.points !=  b.points)
                    return b.points - a.points;
                else if((a.goalsScored - a.goalsAgainst) != (b.goalsScored - b.goalsAgainst))
                    return (b.goalsScored - b.goalsAgainst) - (a.goalsScored - a.goalsAgainst);
                else if(a.goalsScored != b.goalsScored)
                    return b.goalsScored - a.goalsScored;
                else 
                    return a.team.toLowerCase().compareTo(b.team.toLowerCase());
            });
            int rank = 0;
            if(n > 1)
             System.out.println();
            for(int i = 0; i < teams.size(); i++){
                if (i == 0 || teams.get(i).points != teams.get(i-1).points || (teams.get(i).goalsScored - teams.get(i).goalsAgainst) != (teams.get(i-1).goalsScored - teams.get(i-1).goalsAgainst) || teams.get(i).goalsScored != teams.get(i-1).goalsScored) {
                    rank = i + 1;
                    System.out.printf("%2d. ", rank);
                }                
                else
                    System.out.printf("    ");
                System.out.printf("%15s %3d %3d %3d %3d %3d ", teams.get(i).team, teams.get(i).points, teams.get(i).gamesPlayed, teams.get(i).goalsScored, teams.get(i).goalsAgainst, (teams.get(i).goalsScored - teams.get(i).goalsAgainst));
                if (teams.get(i).gamesPlayed == 0) System.out.printf("%6s\n", "N/A");
                 else System.out.printf("%6.2f\n", teams.get(i).points * 100.0 / (3.0 * teams.get(i).gamesPlayed));
            }
        }
    }
}