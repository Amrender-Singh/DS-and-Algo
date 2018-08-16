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
class Record{
    String plate;
    String time;
    String status;
    int km;
    Record(String plate, String time, String status, int km){
        this.plate = plate;
        this.time = time;
        this.status = status;
        this.km = km;
    }
}

public class CDVII{
    public static void readInputAndResolve(Reader sc, TreeMap<String,  Integer> map){
        String s;
        int total = 0;
        int prices[] = new int[24];
        ArrayList<Record> records = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            prices[i] = sc.nextInt();
        }
        while((s = sc.nextLine()) != null && !s.isEmpty()){
            String arr[] = s.split(" ");
            Record record = new Record(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]));
            records.add(record);
        }
        Collections.sort(records, (a, b)->{
            if(a.plate.equals(b.plate))
                return a.time.compareTo(b.time);    
            return a.plate.compareTo(b.plate);
            
        });
        Record  prevRecord = records.get(0);
        for(int i = 1; i < records.size(); i++){
            Record currRecord = records.get(i);
           if(prevRecord.plate.equals(currRecord.plate) && (currRecord.status.equals("exit") && prevRecord.status.equals("enter"))){
                Integer tot = map.get(currRecord.plate);
                if(tot == null)
                    tot = new Integer(0);
                int distance = Math.abs(currRecord.km - prevRecord.km);
                int rate = prices[Integer.parseInt(prevRecord.time.split(":")[2])];
                tot += (distance*rate)  + 100;
                map.put(prevRecord.plate, tot);
            }
            prevRecord = currRecord;
        }
        
        
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        int noOfTestCases = sc.nextInt();
        StringBuilder output = new StringBuilder();
        sc.nextLine();
        while(noOfTestCases --> 0){
            TreeMap<String,  Integer>map = new TreeMap<>();
            readInputAndResolve(sc, map);
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                int fare = entry.getValue() + 200;
				int dollars = fare/100;
				int cents = fare%100;
				String centStr = String.format("%2d", cents).replace(" ", "0");
				output.append(String.format("%s $%d.%s\n", entry.getKey(), dollars, centStr));
            }
            if(noOfTestCases != 0)
                output.append("\n");
        }
        System.out.print(output.toString());
    }
}