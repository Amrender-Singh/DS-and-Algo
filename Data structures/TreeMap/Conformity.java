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
class Project{
    int count;
    String name;
    Project(String name, int count){
        this.name = name;
        this.count = count;
    }
}

public class Conformity{
    
    public static void readInputAndCreateMap(Reader sc, HashMap<String, Integer> map ,int noOfFrosh ){
        String s;
        StringBuilder key = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(noOfFrosh  --> 0){
            int i = 0;
            while(i < 5){
                pq.add(sc.nextInt());
                i++;
            }
            while(!pq.isEmpty()){
                key.append(pq.poll());
                if(pq.size() != 0)
                    key.append("_");
            }
            s = key.toString();
            Integer count = map.get(s);
            if(count == null)
                count = new Integer(0);
            map.put(s, count + 1);
            key.setLength(0);
        }
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        String s;
        while(!(s = sc.nextLine()).equals("0")){
            HashMap<String, Integer> map = new HashMap<>();
            readInputAndCreateMap(sc, map, Integer.parseInt(s));
            Integer maxValue = new Integer(-1);
            Integer total = new Integer(0);
            ArrayList<Integer> list = new ArrayList<Integer>(map.values());
            Collections.sort(list, Collections.reverseOrder());
            for(Integer val : list){
                if(maxValue != -1 && maxValue != val)
                    break;
                maxValue = val;
                total += val;
            }
            output.append(total + "\n");
        }
        System.out.print(output.toString());
    }
}