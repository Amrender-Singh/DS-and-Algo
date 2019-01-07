/**
 * Rabin Karp substring matching algorithm (las vegas version) 
 */
import java.util.*;
 import java.math.*;
public class RabinKarp {
    private long RM, patHash, q;
    private String pat;
    private int m, R;
    
    public RabinKarp(String pat){
        this.pat = pat;
        R = 256;
        m = pat.length();
        RM = 1;
        q = longRandomPrime();
        for(int i = 1; i <= m-1; i++){
            RM = (RM * R) % q;
        }
        patHash = hash(pat, m);
    }
    public int search(String txt){
        int n = txt.length();
        if (n < m) return n;
        long txtHash = hash(txt, m);
        if(txtHash == patHash && check(txt, 0)) 
            return 0;
        for (int i = m; i < n; i++){
            txtHash = (txtHash + q - RM*txt.charAt(i-m) % q) % q; 
            txtHash = (txtHash*R + txt.charAt(i)) % q; 
            int offset = i - m + 1;
            if(txtHash == patHash && check(txt, offset)) 
                return offset;
        }
        return n;
    }
    private boolean check(String txt, int i){
        for(int j = 0 ; j < m; j++){
            if(txt.charAt(i+j) != pat.charAt(j))
                return false;
        }
        return true;
    }
    private long hash(String pat, int m){
        long h = 0;
        for(int i = 0; i < m; i++){
            h = (R*h + pat.charAt(i)) % q;
        }
        return h;
    }
    // a random 31-bit prime
    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }
    public static void main(String args[]){
        RabinKarp patternMatcher = new RabinKarp("rab");
        System.out.print("Pattern found at index " + patternMatcher.search("abacadabrabracabracadabrabrabracad"));
    }
}