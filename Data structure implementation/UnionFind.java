/**
 * UnionFind data structure, The below implementation uses weighted quick union by size with path compression
 *  by halving.
 */
public class UnionFind {
    private int parent[];
    private int size[];
    UnionFind(int n){
        if (n < 0) throw new IllegalArgumentException();
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int p){
        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        if(size[pRoot] < size[qRoot]){
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else{
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }
    public static void main(String[] args) {
        UnionFind uf = new UnionFind(5);
        /* uf.union(1,2);
        uf.union(3,4);
        System.out.println(uf.connected(1,3));
        uf.union(2,4);
        System.out.println(uf.connected(1,3)); */
    }
}