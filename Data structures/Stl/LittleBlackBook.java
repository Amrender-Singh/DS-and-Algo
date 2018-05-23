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
class Details{
    String title, firstName, LastName, address,hphone, wphone, mail, dept;
}
 public class LittleBlackBook {
    public static void main(String[] args) {
            Reader sc =  new Reader();
            StringBuilder output = new StringBuilder();
            int n = sc.nextInt();
            ArrayList<Details> list = new ArrayList<>();
            while(n -- > 0){
                String department = sc.nextLine();
                String str;
                while((str = sc.nextLine())!= null && !str.equals("")){
                    String info[] = str.split(",");
                    Details detail  = new Details();
                    detail.title = info[0];
                    detail.firstName = info[1];
                    detail.LastName = info[2];
                    detail.address = info[3];
                    detail.hphone = info[4];
                    detail.wphone = info[5];
                    detail.mail = info[6];
                    detail.dept = department;
                    list.add(detail);
                }
            }
            Collections.sort(list, (a,b) -> a.LastName.compareTo(b.LastName));
            for(Details detail : list){
                System.out.println("----------------------------------------");
                System.out.println(detail.title + " " + detail.firstName + " " + detail.LastName);
                System.out.println(detail.address);
                System.out.println("Department: " +detail.dept);
                System.out.println("Home Phone: " +detail.hphone);
                System.out.println("Work Phone: " +detail.wphone);
                System.out.println("Campus Box: " +detail.mail);
            }
        }
}