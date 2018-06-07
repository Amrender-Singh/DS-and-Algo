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

 public class ImageCoding {
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases = sc.nextInt();
        int i = 0;
        ArrayList<Character> list;
        String input[];
        while(i++ < noOfTestCases){
            input = sc.nextLine().split(" ");
            String s;
            list = new ArrayList<>();
            for(int j = 0; j < Integer.parseInt(input[0]); j++){
                s = sc.nextLine().trim();
                for(int k = 0; k < s.length(); k++){
                    list.add(s.charAt(k));
                }
            }
            Collections.sort(list);
            int maxCount = 0, moreThanOne = 1, count  = 0;
            for(int j = 0; j < list.size()-1; j++){
                count++;
                if(list.get(j) != list.get(j+1)){
                    if(count > maxCount){
                         maxCount = count;
                         moreThanOne = 1;
                    } else if(count == maxCount){
                        moreThanOne++;
                    }
                    count = 0;
                } 
            }
            count += 1;
            if(count > maxCount){
                         maxCount = count;
                         moreThanOne = 1;
            } else if(count == maxCount){
                moreThanOne++;
            }
            output.append("Case "+i+": "+((maxCount*moreThanOne*Integer.parseInt(input[2])) + ((list.size()-(moreThanOne*maxCount))*Integer.parseInt(input[3])))+"\n");
        }
        System.out.print(output.toString());
    }
}