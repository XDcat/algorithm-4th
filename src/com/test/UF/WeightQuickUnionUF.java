package com.test.UF;

public class WeightQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int count;

    public int find(int index){
        if (index == id[index]){
            return index;
        } else{
            return find(id[index]);
        }
    }
    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot){
            if (sz[pRoot] > sz[qRoot]){
                id[qRoot] = pRoot;
                sz[pRoot] += sz[qRoot];
            } else {
                id[pRoot] = qRoot;
                sz[qRoot] = sz[pRoot];
            }
        }
        count --;
    }
}
