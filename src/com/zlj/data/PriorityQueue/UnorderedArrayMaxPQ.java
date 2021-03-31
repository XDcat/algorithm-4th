package com.zlj.data.PriorityQueue;

import edu.princeton.cs.algs4.StdOut;
import sun.nio.cs.ext.ISCII91;

public class UnorderedArrayMaxPQ<Key extends Comparable<Key>>{
	private Key[] pq;
	private int n;

	public UnorderedArrayMaxPQ(int capacity) {
		pq = (Key[]) new Comparable[capacity];
		n = 0;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public int size() {
		return n;
	}
	public void insert(Key x) {
		pq[n++] = x;
	}
	public Key delMax() {
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (less(max, i)) {
				max = i;
			}
		}
		exch(max, n-1);
		return pq[--n];
	}
	
	/*
	 * 辅助函数
	 */
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	private void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j]; 
		pq[j] = t; 
	}
	
    public static void main(String[] args) {
        UnorderedArrayMaxPQ<String> pq = new UnorderedArrayMaxPQ<String>(10);
        pq.insert("this");
        pq.insert("is");
        pq.insert("a");
        pq.insert("test");
        while (!pq.isEmpty()) 
            StdOut.println(pq.delMax());
    }	
}
