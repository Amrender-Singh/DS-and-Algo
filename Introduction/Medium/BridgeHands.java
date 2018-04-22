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
class BridgeHands {
    static HashMap<Character,Integer> rank = new HashMap<>();
    static HashMap<Character,Integer> rank2 = new HashMap<>();
    static int sortRowWise(String m[][])
    {
        for (int i = 0; i < m.length; i++)
            Arrays.sort(m[i],new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(rank2.get(o1.charAt(0)) != rank2.get(o2.charAt(0)))
                        return rank2.get(o1.charAt(0)) - rank2.get(o2.charAt(0));
                    else 
                        return rank.get(o1.charAt(1)) - rank.get(o2.charAt(1));
                }    
            });
        return 0;
    }
    public static void print(Character s, String arr[]){
        System.out.print(s+":");
        for(int i =0 ; i < 13; i++){
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        String str;
        HashMap<Character,Integer> direction =  new HashMap<>();
        direction.put('N', 0);
        direction.put('E', 1);
        direction.put('S', 2);
        direction.put('W', 3);

        
        rank2.put('C',0);
        rank2.put('D',1);
        rank2.put('S',2);
        rank2.put('H',3);
    
        
        rank.put('2',0);
        rank.put('3',1);
        rank.put('4',2);
        rank.put('5',3);
        rank.put('6',4);
        rank.put('7',5);
        rank.put('8',6);
        rank.put('9',7);
        rank.put('T',8);
        rank.put('J',9);
        rank.put('Q',10);
        rank.put('K',11);
        rank.put('A',12);
        while((str = sc.nextLine()) !=null && !str.equals("#") && str.length() > 0 ){
            StringBuilder sb = new StringBuilder(sc.nextLine());
            sb.append(sc.nextLine());
            String s = sb.toString();
            int startIndex  =direction.get(str.charAt(0));
            if(startIndex == 3)
                startIndex = -1;    
            startIndex++;
            String arr[][] = new String[4][13];
            int idx = 0;
            int count =0;
            for(int i = 0; i < s.length(); i+=2){
                arr[startIndex++][idx] = ""+s.charAt(i)+ s.charAt(i+1);
                count++;
                if(count == 4){
                    idx++;
                    count = 0;
                }
                
                if(startIndex == 4)
                    startIndex = 0;
            }
            sortRowWise(arr);
            print('S', arr[2]);
            print('W', arr[3]);
            print('N',arr[0]);
            print('E', arr[1]);
        }
    }
}