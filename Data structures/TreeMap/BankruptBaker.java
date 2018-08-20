import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

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
               return null;
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
class RecipeMap{
    String recipeName;
    int cost;
    RecipeMap(String recipeName, int cost){
        this.recipeName = recipeName;
        this.cost = cost;
    }
}
public class BankruptBaker{
    
    public static void readInputAndCreateMap(Reader sc, int m, int n, int b, ArrayList<RecipeMap> recipesPriceMap){
        HashMap<String, Integer> ingredientPriceMap = new HashMap<>();
        while(m --> 0){
            ingredientPriceMap.put(sc.next().trim(), sc.nextInt());
        }
        while(n --> 0){
            String recipeName = sc.nextLine();
            int k = sc.nextInt();
            int cost = 0;
            while(k --> 0){
                Integer price = ingredientPriceMap.get(sc.next().trim());
                int units = sc.nextInt();
                if(price != null)
                    cost += (price*units);
            }
            if(cost <= b)
                recipesPriceMap.add(new RecipeMap(recipeName, cost));
        }
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestcases = sc.nextInt();
        while(noOfTestcases --> 0){
            ArrayList<RecipeMap> recipesPriceMap = new ArrayList<>();
            String binder = sc.nextLine();
            int m = sc.nextInt();
            int n = sc.nextInt();
            int b = sc.nextInt();
            output.append(binder.toUpperCase() + "\n");
            readInputAndCreateMap(sc, m, n, b, recipesPriceMap);
            if(recipesPriceMap.size() == 0){
                output.append("Too expensive!\n");
            } else{
                Collections.sort(recipesPriceMap, (x, y)->{
                    if(x.cost != y.cost)
                        return x.cost - y.cost;
                    return x.recipeName.compareTo(y.recipeName);
                });
                for(RecipeMap r : recipesPriceMap){
                    if(r.cost > b){
                        break;
                    } 
                    output.append(r.recipeName + "\n");
                }
            }
            
            output.append("\n");
        }
        System.out.print(output.toString());
    }
}