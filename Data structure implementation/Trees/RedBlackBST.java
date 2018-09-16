import java.util.*;
/**
 * RedBlackBST
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED   = true;
    private static final boolean BLACK = false;
    private Node root;
    private class Node{
        private Key key;
        private Value val;
        private boolean color;
        private int size;
        private Node left, right;
        public Node(Key key, Value val, boolean color, int size){
            this.key = key;
            this.val = val;
            this.color = color;
            this.size = size;
        }
   }
   /**
    * Initializes empty symbol table
    */
   public RedBlackBST() {
    }
    public int size(){
       return size(root);
    }
    private int size(Node x){
       if(x == null) return 0;
       return x.size;
    }
    private boolean isRed(Node x){
        if (x == null) return false; // null node is always black
        return x.color == RED;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public Value get(Key key){
       if(key == null) throw new IllegalArgumentException("Passing null key to get() function");
       return get(root, key);
    }
    private Value get(Node x, Key key){
       while(x != null){
           int cmp = key.compareTo(x.key);
           if(cmp < 0) return get(x.left, key);
           else if(cmp > 0) return get(x.right, key);
           return x.val;
       }
       return null;
    }
    public boolean contains(Key key){
        return get(key) != null;
    }
    public void put(Key key, Value val){
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        root = put(root, key, val);
        root.color = BLACK;
    }
    private Node put(Node x, Key key, Value val){
        if(x == null) return new Node(key, val, RED, 1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = put(x.left, key, val);
        if(cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;

        if(isRed(x.right) && !isRed(x.left)) x = rotateLeft(x);
        if(isRed(x.left) && isRed(x.left.left)) x = rotateRight(x);
        if(isRed(x.left) && isRed(x.right)) flipColors(x);

        x.size = size(x.left) + size(x.left) + 1;
        return x;
    }
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root).key;
    } 

    private Node max(Node x) { 
        if (x.right == null) return x; 
        else                 return max(x.right); 
    } 

    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("calls floor() with empty symbol table");
        Node x = floor(root, key);
        if (x == null) return null;
        else           return x.key;
    }    

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0)  return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t; 
        else           return x;
    }

    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        if (isEmpty()) throw new NoSuchElementException("calls ceiling() with empty symbol table");
        Node x = ceiling(root, key);
        if (x == null) return null;
        else           return x.key;  
    }

    private Node ceiling(Node x, Key key) {  
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0)  return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if (t != null) return t; 
        else           return x;
    }

    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + k);
        }
        Node x = select(root, k);
        return x.key;
    }

    private Node select(Node x, int k) {
        int t = size(x.left); 
        if      (t > k) return select(x.left,  k); 
        else if (t < k) return select(x.right, k-t-1); 
        else            return x; 
    } 

    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
    } 

    private int rank(Key key, Node x) {
        if (x == null) return 0; 
        int cmp = key.compareTo(x.key); 
        if      (cmp < 0) return rank(key, x.left); 
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); 
        else              return size(x.left); 
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

    /*****************Helper Function********************** */
    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }
    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }
    private void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    public static void main(String[] args) {
        RedBlackBST<Integer, Integer> st = new RedBlackBST<Integer, Integer>();
        int arr[] = {100,664,1,4,67,34,21,90,68};
        int j = 1;
        for (Integer i : arr) {
            st.put(i, j++);
        }

        for (Integer s : st.levelOrder())
            System.out.println(s + " " + st.get(s));
        
    }
}