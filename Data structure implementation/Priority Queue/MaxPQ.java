/**
 * MaxPQ
 */
import java.util.*;
public class MaxPQ<Key>{
    private Key[] pq;
    private int n;
    public MaxPQ(int capacity){
        pq = (Key[]) new Object[capacity + 1];
        n = 0;
    }
    /**
     * Initializes an empty priority queue.
     */
    public MaxPQ() {
        this(1);
    }
    public int size(){
        return n;
    }
    public boolean isEmpty() {
        return n == 0;
    }
    public Key min(){
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }
    public void insert(Key val){
        if (n == pq.length - 1) resizePQ(2 * pq.length);
        pq[++n] = val;
        swim(n);
    }
    public Key delMin(){
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key temp = pq[1];
        swap(1, n--);
        sink(1);
        pq[n+1] = null;     // to  help with garbage collection(i.e avoid loitering)
        if ((n > 0) && (n == (pq.length - 1) / 4)) resizePQ(pq.length / 2);
        return temp;
    }
    private void resizePQ(int capacity){
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
    private void sink(int k){
        while((k << 1) <= n){
            int j = (k << 1);
            if(j < n && less(j, j+1)) j++;
            if(less(j, k)) break;
            swap(k, j);
            k = j;
        }
    }
    private void swim(int k){
        while(k > 1 && less(k >> 1, k)){
            swap(k>>1, k);
            k = (k >> 1);
        }
    }
    private boolean less(int i, int j){
        return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
    }
    private void swap(int i, int j){
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}