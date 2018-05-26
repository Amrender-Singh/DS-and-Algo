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
class Submissions {
    int team;
    String prb,status;
    int time;
}
class Team {
    int teamNo;
    int problemSolved;
    int time;
}
 public class HeadJudgeHeadAche {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        String s;
        int test = sc.nextInt();
        sc.nextLine();
        while(test --> 0){
            int max = 0;
            ArrayList<Submissions> submissions = new ArrayList<>();
            while((s = sc.nextLine()) != null && !s.equals("")){
                String info[] = s.split(" ");
                int teamNo = Integer.parseInt(info[0]);
                Submissions submit = new Submissions();
                submit.team = teamNo;
                submit.prb = info[1];
                int index = info[2].indexOf(":");
                submit.time += (60*Integer.parseInt(info[2].substring(0,index))) + Integer.parseInt(info[2].substring(index+1));
                submit.status =  info[info.length-1];
                if(max < teamNo)
                    max = teamNo;
                submissions.add(submit);
            }
        
            HashSet<String> accepted  = new HashSet<>();
            HashMap<String, Integer> wrong  = new HashMap<>();
            Team list[] =  new Team[max+1];
            for(int i = 0; i <= max; i++){
                list[i] = new Team();
                list[i].teamNo = i;
                list[i].problemSolved = 0;
                list[i].time = 0;
            }
            list[0].teamNo = 0;
            list[0].problemSolved = -1;
            list[0].time = -1;
            Collections.sort(submissions, (a,b) ->{
                if(a.time != b.time)
                    return a.time - b.time;
                return a.status.compareTo(b.status);
            });
            for(int i = 0; i < submissions.size(); i++){
                Submissions sub = submissions.get(i);
                String teamPrb = sub.team + sub.prb;
                if(accepted.contains(teamPrb))
                    continue;
                if(sub.status.equals("Y")){
                    if(wrong.containsKey(teamPrb)){
                        list[sub.team].time += wrong.get(teamPrb) * 20;
                    }
                    list[sub.team].time += sub.time;
                    list[sub.team].problemSolved += 1;
                    accepted.add(teamPrb);
                } else {
                    wrong.put(teamPrb, wrong.containsKey(teamPrb)? wrong.get(teamPrb)+1 : 1);
                }
            }
            Arrays.sort(list,(a,b) -> {
                if(a.problemSolved != b.problemSolved)
                    return b.problemSolved - a.problemSolved;
                else if(a.time != b.time)
                    return a.time - b.time;
                else    
                    return a.teamNo - b.teamNo;
            });
            int j = 0;
            System.out.println("RANK"+" TEAM"+" PRO/SOLVED"+" TIME");
            for(int i = 0; i <max; i++){
                if(i == 0 ||(list[i].problemSolved != list[i-1].problemSolved || list[i].time != list[i-1].time)){
                    j = i+1;
                }
                 System.out.printf("%4d %4d",j,list[i].teamNo);
                    
                if(list[i].problemSolved != 0)
                    System.out.printf("%5d %10d",list[i].problemSolved, list[i].time);
                System.out.println();
            }
            if(test != 0)
                System.out.println();
        }
    }
            
}