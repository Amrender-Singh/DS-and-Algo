import java.util.LinkedList;

/**
 * R-way trie implementation
 */
public class TrieSt<Value> {
    private static final int R = 256;        // extended ASCII

    private Node root;      // root of trie
  
    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    public TrieSt(){
    }
    /*********public functions************/
    public void put(String key, Value val){
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        root = put(root, key, val, 0);
    }
    public Value get(String key){
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        Node x = get(root, key, 0);
        if(x == null) return null;
        else return (Value) x.val;
    }
    public boolean contains(String key){
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        return get(key) != null;
    }
    public Iterable<String> keys() {
        return keysWithPrefix("");
    }
    public Iterable<String> keysWithPrefix(String prefix) {
        LinkedList<String> results = new LinkedList<String>();
        Node x = get(root, prefix, 0);
        collect(x, new StringBuilder(prefix), results);
        return results;
    }
    public Iterable<String> keysThatMatch(String pattern) {
        LinkedList<String> results = new LinkedList<String>();
        collect(root, new StringBuilder(), pattern, results);
        return results;
    }

    /*********private functions************/
    private Node put(Node x, String key, Value val, int d){
        if(x == null) x = new Node();
        if(d == key.length()){
            x.val = val;
            return x;
        } 
        char ch = key.charAt(d);
        x.next[ch] = put(x.next[ch], key, val, d+1);
        return x;
    }
    private Node get(Node x, String key, int d){
        if(x == null) return null;
        if(d == key.length()) return x;
        char ch = key.charAt(d);
        return get(x.next[ch], key, d+1);
    }
    private void collect(Node x, StringBuilder prefix, LinkedList<String> queue){
        if(x == null) return;
        if(x.val != null) queue.add(prefix.toString());
        for (char i = 0; i < R; i++) {
            prefix.append(i);
            collect(x.next[i], prefix, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
    private void collect(Node x, StringBuilder prefix, String pattern, LinkedList<String> results) {
        if (x == null) return;
        int d = prefix.length();
        if (d == pattern.length() && x.val != null)
            results.add(prefix.toString());
        if (d == pattern.length())
            return;
        char c = pattern.charAt(d);
        if (c == '.') {
            for (char ch = 0; ch < R; ch++) {
                prefix.append(ch);
                collect(x.next[ch], prefix, pattern, results);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
        else {
            prefix.append(c);
            collect(x.next[c], prefix, pattern, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}