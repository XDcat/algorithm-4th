package com.test.UF;

public class QuickUnion {
    private int[] id;
    private int count;

    public int find(int index){
        /* 找到根节点 */
        if (index == id[index]) {
            return index;
        } else{
            return find(id[index]);
        }
    }

    public void union(int p, int q){
        int pid = find(p);
        int qid = find(q);
        if (pid != qid){
            id[pid] = qid;  // 讲两个树连接在一起
        }
    }
}
