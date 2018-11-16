import java.util.*;
import java.lang.*;
import java.io.*;
class Reader{
        BufferedReader br;
        StringTokenizer st;
 
        public Reader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
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

public class War {
   static  int rank[];
   static int parent[];
    static int n;
    public static void make_set(int x){
        n = x;
        parent = new int[20010];
        rank = new int[20010];
        for(int i = 0; i < 20010; i++){
            rank[i] = 1;
            parent[i] = i;
        }
    }

    public static int find(int p){
        if(parent[p] != p)
            parent[p] = find(parent[p]);
        return parent[p];
    }
    public static boolean isEnemy(int p, int q){
        return (find(p) == find(enemyId(q))) || (find(q) == find(enemyId(p)));
    }
    public static boolean isFriend(int p, int q){
        return find(p) == find(q) || (find(enemyId(p)) == find(enemyId(q)));
    }
    public static int enemyId(int x){
        return x + n;
    }
    public static int setFriend(int p, int q){
        int xp = find(p), yq = find(q);
        if(xp == yq)
            return 0;
        if(rank[xp] > rank[yq]){
            parent[yq] = xp; 
            rank[xp] += rank[yq];
        } else {
            parent[xp] = yq; 
            rank[yq] += rank[xp];
        }
        return 0;
    }

    public static int getSize(int p){
        return rank[parent[p]];
    }
    public static void main(String args[]){
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
       int n = sc.nextInt();
       make_set(n);
       while(true){
           int opt = sc.nextInt();
           int x = sc.nextInt();
           int y = sc.nextInt();
           if(x == 0 && y == 0 && opt == 0)
            break;
            switch(opt){
                case 1: if( isEnemy(x,y)){
                            
                            output.append(-1+"\n");
                        } else{
                            setFriend(x, y);
                            setFriend(enemyId(x), enemyId(y));
                        }
                        break;
                case 2 : if(isFriend(x,y)) output.append(-1+"\n");
                        else{
                            setFriend(x, enemyId(y));
                            setFriend(y, enemyId(x));
                        }
                         break;
                case 3 : output.append(isFriend(x,y) ? 1 : 0);
                         output.append("\n");
                         break;
                case 4 : output.append(isEnemy(x,y) ? 1 : 0); 
                         output.append("\n");
                         break;
            }
            
       }
        System.out.print(output.toString());
    }
} 