package com.zlj.UF;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class WeightQuickUnionUF {
    private int[] id;
    private int[] sz;  // 权重
    private int count;

    public WeightQuickUnionUF(int N) {
        this.count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        String path = "D:\\Box\\IDEA_Project\\算法 第四版\\data\\largeUF.txt";
        In in = new In(path);
        int N = in.readInt();  // 触点个数
        WeightQuickUnionUF uf = new WeightQuickUnionUF(N);
        while (!in. isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
//            StdOut.println(p + " " + q);
        }
        System.out.println(uf.count() + "components");
        System.out.println("运行时长：" + stopwatch.elapsedTime());
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;

        if (sz[qRoot] > sz[pRoot]){
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        count--;
    }

    public int find(int p) {
        int link = id[p];
        if (link == p) {
            return p;
        } else {
            return find(link);
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}
