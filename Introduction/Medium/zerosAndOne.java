//This problem can be solved in a better way using prefix sum
//Check solution 2
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
                    e.printStackTrace();;
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
                e.printStackTrace();
            }
            return str;
        }
    }
class ZerosAndOnes{
    public static void main(String args[]){
        Reader sc = new Reader();
        String str;
         int test = 1;
        while((str = sc.nextLine())!=null && str!="\n" && str.length() > 0 ){
            char st[] = str.toCharArray();
            int noOfQueries = sc.nextInt();
           
            System.out.println("Case "+test+":");
            while(noOfQueries -->0){
                int i = sc.nextInt();
                int j = sc.nextInt();
                int min = Math.min(i,j);
                int max = Math.max(i,j);
                int k = 0;
                for(k  = min; k <= max; k++){
                    if(st[min] != st[k]){
                        System.out.println("No");
                        break;
                    }
                }
                if(k > max)
                    System.out.println("Yes");
            }
            test++;
        }
    }

}