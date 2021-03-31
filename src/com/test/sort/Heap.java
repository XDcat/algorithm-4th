package com.test.sort;

import edu.princeton.cs.algs4.In;

public class Heap {
    public static void sort(Comparable[] a){
        int N = a.length;
        // 建堆
        for (int i = N / 2; i >= 1 ; i--) {
            sink(a, i, N);
        }

        // 排序
        while (N > 0){
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }
    public static void sink(Comparable[] a, int k, int N){
        int j;
        while(k * 2 < N){
            j = 2 *k;
            if (less(a, j, j +1)){
                j++;
            }
            if (!less(a, k, j)){
                break;
            }

            exch(a, j, k);
            k = j;
        }
    }

    // 比较大小
    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
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
