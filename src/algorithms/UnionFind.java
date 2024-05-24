package algorithms;

/*
 * Union Find
 * Union Find is a data structure that keeps track of elements which are split into one or more disjoint sets.
 * It has two main operations: find and union.
 * 
 * find - returns the representative of the set that an element belongs to.
 * union - merges two sets.
 * 
 */

public class UnionFind {
    private int[] parent;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);    
    }
}
