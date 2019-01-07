import java.util.Arrays;

/**
 * Boyer Moore substring search algorithm
 */
public class BoyerMoore {
    private final int R;
    private int[] right;
    private String pat;

    public BoyerMoore(String pat){
        R = 226;
        right = new int[R];
        this.pat = pat;
        Arrays.fill(right, -1);
        //preprocess pattern
        for(int i = 0; i < pat.length(); i++){
            right[pat.charAt(i)] = i;
        }
    }
    public int search(String text){
        int N = pat.length();
        int M = text.length();
        int skip = 0;
        for(int i  = 0; i <= M - N; i += skip){
            skip = 0;
            for(int j = N - 1; j >= 0; j--){
                if(pat.charAt(j) != text.charAt(i+j)){
                    skip = Math.max(1, j - right[text.charAt(i+j)]);
                    break;
                }
            }
            if(skip == 0) return i;
        }
        return -1;
    }
    
    public static void main(String args[]){
        BoyerMoore patternMatcher = new BoyerMoore("rab");
        System.out.print("Pattern found at index " + patternMatcher.search("abacadabrabracabracadabrabrabracad"));
    } 
}