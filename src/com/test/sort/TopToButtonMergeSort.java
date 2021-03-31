package com.test.sort;

import edu.princeton.cs.algs4.In;

public class TopToButtonMergeSort {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int p, int q) {
        if (q <= p) return;
        int mid = (p + q) / 2;
        sort(a, 0, mid);
        sort(a, mid + 1, q);
        merge(a, p, mid, q);
    }

    public static void merge(Comparable[] a, int p,int mid, int q) {
        int i = p;
        int j = mid + 1;

        for (int k = p; k <= q; k++) {
            aux[k] = a[k];
        }

        for (int k = p; k <= q; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > q) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }

    // 比较大小
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // 交换
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
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
