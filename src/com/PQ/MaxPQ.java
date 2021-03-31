package com.PQ;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public MaxPQ(int maxSize) {
        N = 0;
        pq = (Key[]) new Comparable[maxSize + 1];
    }

    private void swim(int p) {
        while (p > 1 && less(pq[p / 2], pq[p])) {
            exch(p / 2, p);
            p = p / 2;
        }
    }

    private void sink(int p) {
        while (p * 2 <= N){
            int j = p * 2;
            if (j < N && less(pq[j], pq[j + 1])) j ++;
            if (less(pq[j], pq[p])) {
                exch(p, j);
                p = j;
            } else {
                break;
            }
        }
    }

    private void exch(int p, int q) {
        Key t = pq[p];
        pq[p] = pq[q];
        pq[q] = t;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key deleteMax() {
        Key max = pq[N];
        pq[N] = null;
        exch(1, N--);
        sink(1);
        return max;
    }
}
