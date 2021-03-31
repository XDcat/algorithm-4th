package com.zlj.UF;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class QuickFindUF {
    private int[] id;
    private int count;

    public QuickFindUF(int N) {
        this.count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public static void main(String[] args) {
        String path = "D:\\Box\\IDEA_Project\\算法 第四版\\data\\tinyUF.txt";
        In in = new In(path);
        int N = in.readInt();  // 触点个数
        QuickFindUF uf = new QuickFindUF(N);
        while (! in.isEmpty()){
            int p = in.readInt();
            int q = in.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        System.out.println(uf.count() + "components");
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID)
            return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }

    public int find(int p) {
        return id[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    public int count(){
        return count;
    }
}
