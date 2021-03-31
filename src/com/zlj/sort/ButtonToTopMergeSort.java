package com.zlj.sort;

import edu.princeton.cs.algs4.In;

public class ButtonToTopMergeSort {
	public static Comparable[] aux;
    public static void sort(Comparable[] a){
    	aux = new Comparable[a.length];
    	int N = a.length;
    	for (int i = 1; i < N; i = 2 * i) {
    		for (int j = 0; j < N - i; j += i * 2) {
    			merge(a, j, j + i - 1, Math.min(j + 2 * i - 1, N - 1));
    		}
    	}
    }
    // 比较大小
    public static boolean less(Comparable v, Comparable w){
//    	System.out.println("" + v + " " + w);
        return v.compareTo(w) < 0;
    }
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
    	int i = lo, j = mid + 1;
    	for (int k = lo; k <=hi; k++)
    	{
    		aux[k] = a[k];
    	}
    	for (int k = lo; k <= hi; k++) {
    		if (i > mid) {
    			a[k] = aux[j++];
    		} else if (j > hi) {
    			a[k] = aux[i++];
    		} else if (less(aux[i], aux[j])){
    			a[k] = aux[i++];
    		} else {
    			a[k] = aux[j++];
    		}
    	}
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
