import sun.security.provider.VerificationProvider;

/**
 * LSDRadixSort
 */
public class LSDRadixSort {
    
    private LSDRadixSort(){}
    public static void sort(String[] a, int w){
        int n = a.length;
        int R = 256;
        String[] aux  = new String[n];
        for (int i = w-1; i >= 0; i--) {
            int count[] = new int[R+1];
            for(int j = 0; j < n; j++)
                count[a[j].charAt(i) + 1]++;
            for(int j = 0; j < R; j++)
            count[j+1] += count[j] ;
            for (int j = 0; j < n; j++)
                aux[count[a[j].charAt(i)]++] = a[j];

            for (int j = 0; j < n; j++)
                a[j] = aux[j];
        }
    }
	public static void main (String[] args) {
		String arr[] = {"xyz","def","cab","abc","eky","wxz","ctr"};
		System.out.println(Arrays.toString(arr));
		sort(arr,3);
		System.out.println(Arrays.toString(arr));
	}
}