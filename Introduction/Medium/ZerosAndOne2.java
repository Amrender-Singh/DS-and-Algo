//Better solution with Time complexity O(m+n). Using prefix sum technique or counter both are mentioned.
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
    void counterTechnique(){
        Reader sc = new Reader();
        String str;
         int test = 1;
        while((str = sc.nextLine())!=null && str!="\n" && str.length() > 0 ){
            int data[] = new int[str.length()];
            int counter = 0;
            int index  = -1;
            char c = str.charAt(0);
            for(int i = 0; i < str.length(); i++){
                if(c != str.charAt(i)){
                    c = str.charAt(i);
                    counter++;
                }
                data[++index] = counter;
            }
            
            int noOfQueries = sc.nextInt();
           
            System.out.println("Case "+test+":");
            while(noOfQueries -->0){
                int i = sc.nextInt();
                int j = sc.nextInt();
                if(data[j] == prefixSum[i])
                    System.out.println("Yes");
                else
                    System.out.println("No");
                    
            }
            test++;
        }
    }
    public static void main(String args[]){
        Reader sc = new Reader();
        String str;
         int test = 1;
         //Technique 2 prefix sum
         while((str = sc.nextLine())!=null && str!="\n" && str.length() > 0 ){
            int prefixSum[] = new int[str.length()];
            prefixSum[0] = Integer.parseInt(String.valueOf(str.charAt(0)));
            for(int i = 1; i < str.length(); i++){
                prefixSum[i] = prefixSum[i-1] + Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            
            int noOfQueries = sc.nextInt();
           
            System.out.println("Case "+test+":");
            while(noOfQueries -->0){
                int i = sc.nextInt();
                int j = sc.nextInt();
                int min = Math.min(i,j);
                int max = Math.max(i,j);
                if(min == 0)
                    min++;
                if(prefixSum[max] == prefixSum[min-1] || prefixSum[max] - prefixSum[min-1] == max-min+1)
                    System.out.println("Yes");
                else
                    System.out.println("No");
                    
            }
            test++;
        }
    }
}