import java.io.*;
import java.util.*;

 public class LunchInGridCity {
     public static ArrayList<Integer> readInts(String line){
        String[] arr =  line.split(" ");
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : arr) {
            if(!s.isEmpty()) res.add(Integer.parseInt(s));
        }
        return res;
    }
    public static String nextLine(BufferedReader in) throws IOException {
        if(!in.ready()) return null;
        String line = in.readLine();
        while(line.isEmpty()) {
            if(!in.ready())
                break;
            line = in.readLine();
        }
        return line;
    }
    public static void main(String[] args) throws Exception {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder output = new StringBuilder();
            int testCases = readInts(nextLine(in)).get(0);
            while(testCases -- > 0){
                int noOfFriends = readInts(nextLine(in)).get(2);
                ArrayList<Integer> streets = new ArrayList<>();
                ArrayList<Integer> avenues = new ArrayList<>();
                while(noOfFriends -- > 0){
                    ArrayList<Integer> l = readInts(nextLine(in));
                    streets.add(l.get(0));
                    avenues.add(l.get(1));
                }
                Collections.sort(streets);
                Collections.sort(avenues);
                int x = streets.size() > 0 ? streets.get((int)Math.floor((streets.size()-1)/2)) : 0;
                int y = avenues.size() > 0 ? avenues.get((int)Math.floor((avenues.size()-1)/2)) : 0;
                output.append("(Street: "+ x +", Avenue: "+ y +")\n");
            }
            System.out.print(output.toString());
        }
}