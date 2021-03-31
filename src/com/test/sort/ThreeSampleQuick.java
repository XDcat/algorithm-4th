package com.test.sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class ThreeSampleQuick {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }
    public static void sort(Comparable[] a, int lo, int hi){
        if (lo >= hi){
            return;
        }
        // 使用三采样切分
        int lt = lo, gt = hi, i = lo + 1;
        Comparable v = a[lo];
        while (i <= gt){
            int cmp = v.compareTo(a[i]);
            if (cmp < 0){
                exch(a, gt--, i);
            } else if (cmp > 0){
                exch(a, i++, lt++);
            } else{
                i++;
            }
        }
        // 递归解决其余的
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
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
