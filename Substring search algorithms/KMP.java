/**
 * KMP (Knuth Morris Pratt) Pattern Searching algorithm
 */
public class KMP {
    private  int lps[];
    private String pat;

    public KMP(String pat){
        this.pat = pat;
        //compute the lps array by preprocessing the pattern
        int j = 0;
        int i = 1;
        int M = pat.length();
        lps  = new int[M];
        while(i < M){
            if(pat.charAt(j) == pat.charAt(i)){
                lps[i] = j + 1;
                i++;
                j++;
            } else if(j != 0)
                j = lps[j-1];
            else{
                lps[i] = 0;
                i += 1;
            }
        }
    }
    public int search(String txt){
        int M = pat.length(); 
        int N = txt.length();
        int i = 0, j = 0;
        while(i < N){
            if(txt.charAt(i) == pat.charAt(j)){
                i++; j++;
            }
            if(j == M)
                return i - M;
            else if(i < N && txt.charAt(i) != pat.charAt(j)){
                if(j != 0)
                    j = lps[j-1];
                else    
                    i += 1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        KMP patternMatcher = new KMP("rab");
        System.out.print("Pattern found at index " + patternMatcher.search("abacadabrabracabracadabrabrabracad"));
    }
}