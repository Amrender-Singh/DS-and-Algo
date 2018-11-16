/**
 * MatrixTranspose
 */
import java.util.*;
import java.io.*;
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
class Matrix{
    int col, value;
    public Matrix(int col, int value){
        this.col = col;
        this.value = value;
    }
}
public class MatrixTranspose {
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        String line;
        while((line = sc.nextLine()) != null && !line.equals("")){
            List[] adj = new ArrayList[1001];
            List[] tadj = new ArrayList[1001];
            String arr[] = line.split(" ");
            int m = Integer.parseInt(arr[0]);
            int n = Integer.parseInt(arr[1]);
            for(int i = 0; i < Math.max(m,n); i++){
                adj[i] = new ArrayList();
                tadj[i] = new ArrayList();
            }
            int p[] = new int[1001];
            int v[] = new int[1001];
            for(int i = 0; i < m; i++){
                int r = sc.nextInt();
                for(int j = 0; j < r; j++)
                    p[j] = sc.nextInt();
                for(int j = 0; j < r; j++)
                    v[j] = sc.nextInt();
                for(int j = 0; j < r; j++)
                    adj[i].add(new Matrix(p[j]-1, v[j]));
                if(r == 0)
                    sc.nextLine();
            }
            for(int i = 0; i < m; i++){
                for (int j = 0; j < adj[i].size(); j++) {
                    Matrix val = (Matrix)adj[i].get(j);
                    tadj[val.col].add(new Matrix(i, val.value));
                }
            }
            output.append(n+" "+m+"\n");
            for (int i = 0; i < n; i++) {
                output.append(tadj[i].size());
                for (int j = 0; j < (int) tadj[i].size(); j++) {
                    Matrix val = (Matrix)tadj[i].get(j);
                    output.append(" "+(val.col+ 1));
                }
                output.append("\n");
                for (int j = 0; j <  tadj[i].size(); j++) {
                    Matrix val = (Matrix)tadj[i].get(j);
                    output.append(val.value);
                    if (j < tadj[i].size() - 1)
                        output.append(" ");
                }
                output.append("\n");
            }
        }
        System.out.print(output.toString());
    }
}