import java.io.*;
import java.util.*;
/**
 * RequesrForProposol
 */
class corporation{
    String name;
    float price;
    int req;
}
public class RequesrForProposol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test =0;
         while (true) {
             int noOfReq =  sc.nextInt();
             if(noOfReq == 0)
                break;
            int noOfpro = sc.nextInt();
            int i = 0;
            sc.nextLine();
            while (i < noOfReq) {
                sc.nextLine();
                i++;
            }
            i = 0;
             ArrayList<corporation> arr = new ArrayList<>() ;
            while (i < noOfpro) {
                corporation c = new corporation();
                c.name = sc.nextLine();
                c.price = sc.nextFloat();
                c.req = sc.nextInt();
                arr.add(c);
                int j = 0;
                sc.nextLine();
                while (j < c.req) {
                    sc.nextLine();
                    j++;
                }
                i++;
            }
            Collections.sort(arr,new Comparator<corporation>() {
                @Override
                public int compare(corporation o1, corporation o2) {
                    if(o1.req != o2.req)
                        return o1.req - o2.req;
                    else 
                        return o1.price < o2.price ? 1 : -1;
                }    
            });
            test++;
            if(test>1)
            System.out.println();
            System.out.println("RFP #"+test);
            System.out.println(arr.get(arr.size()-1).name);
        }
        sc.close();
    }
    
}  