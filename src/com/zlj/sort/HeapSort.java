package com.zlj.sort;


import java.nio.channels.Pipe.SinkChannel;

import edu.princeton.cs.algs4.In;

public class HeapSort {
    public static void sort(Comparable[] a){
    	int N = a.length;
    	// 建堆
    	for (int k = N / 2; k >=1; k--) {
    		sink(a, k, N);
    	}
    	// 排序
    	while (N > 1) {
    		exch(a, 1, N--);
    		sink(a, 1, N);
    	}
    }

    // 比较大小
    public static boolean less(Comparable[] a, int i, int j) {
    	i--; j--;
    	return a[i].compareTo(a[j]) < 0;
    }
    // 交换
    public static void exch(Comparable[] a, int i, int j){
    	i--; j--;
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
            if (less(a, i, i -1)){
                return false;
            }
        }
        return true;
    }
    public static void sink(Comparable[] a, int k, int N) {
    	int j;
    	while (2 * k < N) {
    		j = 2 * k;
    		if (j < N && less(a, j, j + 1)) {
    			j++;
    		}
    		if (!less(a, k, j)) {
    			break;
    		}
    		exch(a, j, k);
    		k = j;
    	}
    }

    public static void main(String[] args) {
        String path = "D:\\Box\\IDEA workplace\\算法 第四版\\data\\words3.txt";
        In in = new In(path);
        String[] a = in.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
