package com.test.UF;

public class QuickFindUF {
    private int[] id;
    private int count;

    public int find(int index) {
        return id[index];
    }

    public void union(int p, int q) {
            int pid = find(p);
            int qid = find(q);
            if (pid != qid){
                for (int i = 0; i < id.length; i++) {
                    if (id[i] == pid){
                        id[i] = qid;
                    }
                }
            }
    }
}
