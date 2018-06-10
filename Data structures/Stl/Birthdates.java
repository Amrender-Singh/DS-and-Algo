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
class Person {
    String name;
    int month, day, year;
}
 public class Birthdates {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int testCase = sc.nextInt();
        ArrayList<Person> list = new ArrayList<>();
        String s[];
        while(testCase -- > 0){
            s = sc.nextLine().split(" ");
            Person p = new Person();
            p.name = s[0];
            p.day = Integer.parseInt(s[1]);
            p.month = Integer.parseInt(s[2]);
            p.year = Integer.parseInt(s[3]);
            list.add(p);
        }
        Collections.sort(list, (a,b) ->{ 
            if(b.year != a.year)
                return  b.year - a.year;
            else if(a.month !=  b.month)
                return b.month - a.month;
            else
                return b.day - a.day;
        });
        System.out.println(list.get(0).name);
        System.out.println(list.get(list.size()-1).name);
    }
}