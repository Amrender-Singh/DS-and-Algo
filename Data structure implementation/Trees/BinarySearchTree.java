import java.io.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;
/**
 * BinarySearchTree
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node{
        private Key key;
        private Value value;
        Node left, right;
        int size;
        public Node(Key key, Value value, int size){
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }
    /**
     * Initializes an empty symbol table.
     */
    public BinarySearchTree() {
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public int size(){
        return size(root);
    }
    private int size(Node x){
        if(x == null) return 0;
        return x.size;
    }
    public void put(Key key, Value value){
        if(key == null) throw new IllegalArgumentException("Key cannot be null");
        root = put(root, key, value);
    }
    private Node put(Node x, Key key, Value val){
        if(x == null)
            return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0)  x.left = put(x.left, key, val);
        else if(cmp > 0) x.right = put(x.right, key, val);
        else x.value = val;
        x.size = size(x.right) + size(x.left) + 1;
        return x;
    }
    public void  deleteMin(){
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
    }
    private Node deleteMin(Node x){
        if(x.left == null) return x.right;
        x.left = deleteMax(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void  deleteMax(){
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
    }
    private Node deleteMax(Node x){
        if(x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void delete(Key key){
        if (key == null) throw new IllegalArgumentException("calls delete() wi1th a null key");
        root = delete(root, key);
    }
    private Node delete(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) root.left = delete(x.left, key);
        if(cmp > 0) root.right = delete(x.right, key);
        else{
            if(x.right == null) return x.left; 
            if(x.left == null) return x.right; 
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(x.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    private Node min(Node x){
        if(x.left == null) return x;
        return min(x.left);
    }
    public Node successor(Node x){
        if(x == null) throw new IllegalArgumentException("calls successor() wi1th a null");
        if(x.right != null) return min(x.right);
        Node succ = null,  r = root;
        while(r != null){
            if(r.key.compareTo(x.key) > 0){
                succ = r;
                r = r.left;
            } else if(r.key.compareTo(x.key) < 0)
                r = r.right;
            else 
                break;
        }
        return succ;
    }
    public Node floor(Key key){
        if (key == null) throw new IllegalArgumentException("calls floor() wi1th a null key");
        return floor(root, key);
    }
    private Node floor(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        if(cmp < 0) return floor(root.left, key);
        Node t = floor(root.right, key);
        if(t != null) return t;
        else return x;

    }
    public Node ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        return ceiling(root, key);
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) { 
            Node t = ceiling(x.left, key); 
            if (t != null) return t;
            else return x; 
        } 
        return ceiling(x.right, key); 
    } 
    public int rank(Key key){
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(root, key);
    }
    private int rank(Node x, Key key){
        if(x == null) return 0;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) return rank(x.left, key) ;
        else if(cmp > 0) return 1 + size(x.left) + rank(x.right, key);
        else return size(x.left);
    }
    public Node select(int k){
        if(k < 0 || k > size()) throw new IllegalArgumentException("Invalid arguement");
        return select(root, k);
    }
    private Node select(Node x, int k){
        if(x == null) return null; 
        int t = size(x.left); 
        if      (t > k) return select(x.left,  k); 
        else if (t < k) return select(x.right, k-t-1); 
        else            return x; 
    }
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.value;
    }
    public Iterable<Key> levelOrder() {
        LinkedList<Key> keys = new LinkedList<Key>();
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node x = queue.poll();
            if (x == null) continue;
            keys.add(x.key);
            queue.add(x.left);
            queue.add(x.right);
        }
        return keys;
    }
    public boolean isBst(){
        return isBst(root, null, null);
    }
    private boolean isBst(Node x, Key min, Key max){
        if(x == null)
            return true;
        if((min != null && x.key.compareTo(min) <= 0) || (max != null && x.key.compareTo(max) >= 0))
            return false;
        return isBst(x.left, min, x.key) && isBst(x.right, x.key, max);
    }
    public static void main(String[] args) {
        BinarySearchTree<Integer, Integer> st = new BinarySearchTree<Integer, Integer>();
        int arr[] = {100,664,1,4,67,34,21,90,68};
        int j = 1;
        for (Integer i : arr) {
            st.put(i, j++);
        }

        for (Integer s : st.levelOrder())
            System.out.println(s + " " + st.get(s));
        
    }
}