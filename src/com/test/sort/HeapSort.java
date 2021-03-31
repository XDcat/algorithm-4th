package com.test.sort;

import edu.princeton.cs.algs4.In;

public class HeapSort {
    public static void sort(Comparable[] a) {
        // 在排序和 sink 时，还是按照以 1 为开始的索引
        // 但是在实际比较和交换时，将其索引都 -1 ，就又变回去了
        int N = a.length;
        // 建堆
        for (int i = N / 2; i >= 1; i++) {
            sink(a, i);
        }

        while (N > 0) {
            exch(a, 1, N--);
            sink(a, 1);
        }
    }

    private static void sink(Comparable[] a, int p) {
        int N = a.length;
        while (p * 2 < N) {
            int j = p * 2;
            if (j < N && less(a[j - 1], a[j + 1 - 1])) j++;
            if (less(a[p - 1], a[j - 1])) {
                exch(a, p, j);
                p = j;
            } else {
                break;
            }
        }
    }


    // 比较大小
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // 交换
    public static void exch(Comparable[] a, int i, int j) {
        i--;
        j--;
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
