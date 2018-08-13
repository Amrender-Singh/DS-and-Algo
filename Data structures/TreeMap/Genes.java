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

 public class Genes {
     public static void readInput(Reader sc, int noOfTestCases, TreeMap<String, String> geneMap, HashMap<String, ArrayList<String>> parents){
        while(noOfTestCases --> 0){
            String s1 = sc.next(), s2 = sc.next();   
            if(s2.equals("non-existent") || s2.equals("recessive") ||  s2.equals("dominant")){
                geneMap.put(s1, s2);
            }else{           
                ArrayList<String> list = parents.get(s2);
                if(list == null){
                   list =  new ArrayList<>();
                   list.add(s1);
                } else{
                    list.add(s1);
                }
                parents.put(s2, list);
            }
        }
     }  
     public static void resolve(String child, TreeMap<String, String> geneMap, ArrayList<String> parents, HashMap<String, ArrayList<String>> allParents){
        if(geneMap.get(parents.get(0)) == null){
            resolve(parents.get(0), geneMap, allParents.get(parents.get(0)), allParents);
        }
        if(geneMap.get(parents.get(1)) == null){
            resolve(parents.get(1), geneMap, allParents.get(parents.get(1)), allParents);
        }
        String parent1Gene = geneMap.get(parents.get(0));
        String parent2Gene = geneMap.get(parents.get(1));
        boolean hasGene = false;
        if(!parent1Gene.equals("non-existent") && !parent2Gene.equals("non-existent")){
            hasGene = true;
        } else if(parent1Gene.equals("dominant") || parent2Gene.equals("dominant")){
            hasGene = true;
        }
         String childGene = "";
         if(hasGene){
            if (parent1Gene.equals("dominant")  && parent2Gene.equals("dominant")) {
               childGene = "dominant";
            } else if (parent1Gene.equals("dominant") && parent2Gene.equals("recessive")) {
               childGene = "dominant";
            } else if (parent2Gene.equals("dominant") && parent1Gene.equals("recessive")) {
               childGene = "dominant";
            } else {
               childGene = "recessive";
            }
        } else{
            childGene = "non-existent";
        }
        geneMap.put(child, childGene);
     }
    public static void main(String[] args) {
        Reader sc =  new Reader();
        StringBuilder output = new StringBuilder();
        int noOfTestCases = sc.nextInt();
        TreeMap<String, String> geneMap = new TreeMap<>();
        HashMap<String, ArrayList<String>> parents  = new HashMap<>();
        readInput(sc, noOfTestCases, geneMap, parents);
        for(Map.Entry<String, ArrayList<String>> entry :  parents.entrySet()){
            resolve(entry.getKey(), geneMap, entry.getValue(), parents);
        }
        for(Map.Entry<String,String> entry :  geneMap.entrySet()){
            output.append(entry.getKey() + " " + entry.getValue()+"\n");
        }
        System.out.print(output.toString());
    }
}