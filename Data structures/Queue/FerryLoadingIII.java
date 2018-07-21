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
class Car{
    int time, index;
    public Car(int time, int index){
        this.time = time;
        this.index = index;
    }
}
 public class FerryLoadingIII {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases = sc.nextInt();
        final int LEFT = 0, RIGHT = 1;
        while(noOfTestCases --> 0){
            LinkedList [] queue = new LinkedList[2];
            for(int i = 0; i < queue.length; i++)
                queue[i] = new LinkedList<Car>();
            int n = sc.nextInt();
            int t = sc.nextInt();
            int m = sc.nextInt();
            int [] arrivalList = new int[m];
            for(int i = 0; i < m; i++){
                int time = sc.nextInt();
                String side = sc.next();
                if(side.charAt(0) == 'l')
                    queue[LEFT].addLast(new Car(time, i));
                if(side.charAt(0) == 'r')
                    queue[RIGHT].addLast(new Car(time, i));
            }
            int index = 0;
            int time = 0;
            while(!(queue[LEFT].isEmpty() && queue[RIGHT].isEmpty())){
                int dropTime = Integer.MAX_VALUE;
                if(!queue[LEFT].isEmpty())
                    dropTime = ((Car)queue[LEFT].peek()).time;
                if(!queue[RIGHT].isEmpty())
                    dropTime = Math.min(((Car)queue[RIGHT].peek()).time, dropTime);
                time = Math.max(dropTime, time);
                int load = 0;
                while(!queue[index].isEmpty() && ((Car) queue[index].peekFirst()).time <= time && load < n){
                    arrivalList[((Car)queue[index].peekFirst()).index] = time + t;
                    queue[index].removeFirst();
                    load++;
                }
                time += t;
                index ^= 1;
            }
            for(int i : arrivalList){
                output.append(i+"\n");
            }
            if(noOfTestCases != 0)
                output.append("\n");
        }
        System.out.print(output.toString());
    }
}