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
    int length;
    public Car(int length){
        this.length = length;
    }
}
 public class FerryLoadingIv {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases = sc.nextInt();
        final int LEFT = 0, RIGHT = 1;
        while(noOfTestCases --> 0){
            LinkedList [] queue = new LinkedList[2];
            for(int i = 0; i < queue.length; i++)
                queue[i] = new LinkedList<Car>();
            int l = sc.nextInt();
            int m = sc.nextInt();
            int [] arrivalList = new int[m];
            for(int i = 0; i < m; i++){
                int length = sc.nextInt();
                String side = sc.next();
                if(side.charAt(0) == 'l')
                    queue[LEFT].addLast(new Car(length));
                if(side.charAt(0) == 'r')
                    queue[RIGHT].addLast(new Car(length));
            }
            int rounds = 0, currentLen = 0, index = 0;
            while(!(queue[LEFT].isEmpty() && queue[RIGHT].isEmpty())){
                while(!queue[index].isEmpty() && ((Car) queue[index].peekFirst()).length + currentLen <= l*100){
                    currentLen += ((Car) queue[index].peekFirst()).length;
                    queue[index].removeFirst();
                }
                index ^= 1;
                rounds++;
                currentLen = 0;
            }
            output.append(rounds+"\n");
        }
        System.out.print(output.toString());
    }
}