package com.zlj.sort;

import edu.princeton.cs.algs4.In;

public class InsertionSort {
    public static void sort(Comparable[] a){
//        int N = a.length;
//        for (int i = 1; i < N; i++) {
//            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
//                exch(a, j, j - 1);
//            }
//        }
        // 不适用交换的插入排序
        int N = a.length;
        Comparable t;
        for (int i = 0; i < N; i++) {
            t = a[i];
            int j;
            for (j = i; j > 0 && less(t, a[j - 1]); j--){
                a[j] = a[j - 1];
            }
            a[j] = t;
        }
    }

    // 比较大小
    public static boolean less(Comparable v, Comparable w){
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
