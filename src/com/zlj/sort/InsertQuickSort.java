package com.zlj.sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class InsertQuickSort {
	public static final int M = 5;
    public static void sort(Comparable[] a){
    	StdRandom.shuffle(a);
    	sort(a, 0, a.length - 1);
    }
    public static void sort(Comparable[] a, int lo, int hi) {
    	// 在较小的数组上使用插入排序提高性能
    	if (lo + M >= hi) {
    		InsertionSort.sort(a);
    		return;
    	}
    	int p = partition(a, lo, hi);
    	sort(a, lo, p -1);
    	sort(a, p + 1, hi);
    }
    // 切片
    private static int partition(Comparable[] a, int lo, int hi) {
    	Comparable flag = a[lo];
    	int i = lo, j = hi + 1;
    	// ++i 和 --j 是为了保证一直指向当前的值
    	while (true) {
    		while (less(a[++i], flag)) {
    			if (i == hi) {
    				break;
    			}
    		}
    		while (less(flag, a[--j])) {
    			if (j == lo) {
    				break;
    			}
    		}
    		if (i >= j) {
    			break;
    		}
    		exch(a, i, j);
    	}
    	// 最后的时候，i 和 j 在同一个位置，或者交换了相对位置，所以选用j
    	exch(a, lo, j);
    	return j;
    }
    // 比较大小
    public static boolean less(Comparable v, Comparable w){
//    	System.out.println("" + v + " " + w);
        return v.compareTo(w) < 0;
    }

    // 交换
    public static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static boolean isSorted(Comparable[] a)
    {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i -1 ])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String path = "D:\\Box\\IDEA_Project\\算法 第四版\\data\\words3.txt";
        In in = new In(path);
        String[] a = in.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
