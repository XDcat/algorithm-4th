package com.zlj.data.PriorityQueue;

import edu.princeton.cs.algs4.StdOut;

public class HeapMaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int n;
	
	public HeapMaxPQ(int caplity) {
		pq = (Key[]) new Comparable[caplity + 1];
		n = 0;
	}
	public boolean isEmpty() {
		return n == 0;
	}
	public int size() {
		return n;
	}
	public void insert(Key k) {
		pq[++n] = k;
		swim(n);
	}
	
	public Key delMax() {
		Key max = pq[1];
		exch(1, n--);
		pq[n + 1] = null;  // 去除垃圾
		sink(1);
		return max;
	}
	
	/* 上浮、下沉函数 */
	private void swim(int k) {
		while (k > 1 && less(k/2, k)) {
			exch(k/2, k);
			k = k/2;
		}
	}
	
	private void sink(int k) {
		int j;
		while (2 * k < n) {
			j = 2 * k;  // 子节点
			if (less(j, j + 1)) {
				j++;
			}
			if (!less(k, j)) {
				break;
			}
			exch(k,  j);
			k = j;
		}
	}
	/* 辅助函数 */
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	private void exch(int i, int j) {
		Key tKey = pq[i];
		pq[i] = pq[j] ; 
		pq[j] = tKey; 
	}
    public static void main(String[] args) {
        HeapMaxPQ<String> pq = new HeapMaxPQ<String>(10);
        pq.insert("this");
        pq.insert("is");
        pq.insert("a");
        pq.insert("test");
        while (!pq.isEmpty()) 
            StdOut.println(pq.delMax());
    }	
}
