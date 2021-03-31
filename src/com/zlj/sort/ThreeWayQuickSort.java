package com.zlj.sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 三取样切分快速排序法
 * @author Lenovo
 *
 */
public class ThreeWayQuickSort {
    public static void sort(Comparable[] a){
    	StdRandom.shuffle(a);
    	sort(a, 0, a.length - 1);
    }
    public static void sort(Comparable[] a, int lo, int hi) {
    	if (lo >= hi) {
    		return;
    	}
    	int lt = lo, i = lo + 1, ht = hi;
    	Comparable v = a[lo];
    	while (i <= ht) {
    		int cmp = v.compareTo(a[i]);
    		if (cmp < 0) {
    			exch(a,  ht--, i);
    		} else if (cmp > 0) {
    			exch(a, lt++, i++);
    		} else{
    		    i++;
            }
    	}

    	sort(a, lo, lt -1);
    	sort(a, ht + 1, hi);
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
