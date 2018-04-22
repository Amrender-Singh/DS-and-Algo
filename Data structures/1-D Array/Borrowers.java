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
class Books{
    String author;
    String title;
    boolean isBorrowerd;
    Books(){}
    Books(String author, String title){
        this.author = author;
        this.title = title;
        this.isBorrowerd = false;
    }
}
/**
 * Borrowers
 *
 */
public class Borrowers {
   static  Reader sc = new Reader();
    public static void ReadInBOoks(ArrayList<Books> list){
        String str;
        String title = "", author = "";
        int i = 0;
        while((str = sc.nextLine()) != null && !str.equals("END")){
            title = str.trim().substring(1,str.lastIndexOf('"'));
            author = str.substring(str.indexOf("by")+2, str.length()-1).trim();
            Books book =  new Books(author, title);
            list.add(book);
        }
    }
    public static void shelveBook(ArrayList<Books> list, HashMap<String, Integer> idx){
        String str, title = "";
        TreeSet<Integer> borowed =  new TreeSet<>();
        TreeSet<Integer> returned =  new TreeSet<>();
        while((str = sc.nextLine()) != null && !str.equals("END")){
            if(str.charAt(0) == 'B'){
                title = str.substring(str.indexOf(" ")+2, str.length()-1).trim();
                borowed.add(idx.get(title));
            } else if(str.charAt(0) == 'R'){
                title = str.substring(str.indexOf(" ")+2, str.length()-1).trim();
                if(borowed.contains(idx.get(title)))
                    borowed.remove(idx.get(title));
                returned.add(idx.get(title));
            } else{
                if(!returned.isEmpty()){
                    
                    for(int i :  returned){
                        int j  = i-1;
                        while(j >= 0){
                            if(!borowed.contains(j))
                                break;
                            j--;
                        }
                        if(j == -1){
                            System.out.println("Put "+ '"'+list.get(i).title+'"' + " first");
                        } else{
                            System.out.println("Put " +'"'+ list.get(i).title +'"'+ " after " + '"'+ list.get(j).title +'"');
                        }
                    }
                    returned.clear();
                }
                System.out.println("END");
                
            }
        }
    }
    public static void main(String args[]){
        ArrayList<Books> list = new ArrayList<Books>();
        ReadInBOoks(list);
        Collections.sort(list, new Comparator<Books>() {

            @Override
            public int compare(Books b1, Books b2) {
                if(!(b1.author.equals(b2.author)))
                    return b1.author.compareTo(b2.author);
                else
                return b1.title.compareTo(b2.title);
            }
         });
         HashMap<String, Integer> idx = new HashMap<>();
         for(int i = 0; i < list.size(); i++){
             idx.put(list.get(i).title, i);
         }
         shelveBook(list, idx);
    }
}