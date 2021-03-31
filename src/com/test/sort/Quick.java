package com.test.sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class Quick {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }
    public static void sort(Comparable[] a, int lo, int hi){
        if (lo >= hi){
            return;
        }
        int j = partition(a, lo, hi);  // 切分，并返回切分点
        // 递归解决其余的
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }
    public static int partition(Comparable[] a, int lo, int hi){
        /*
        i 和 j 要求每一次都是在当前位置，
        通过 ++i 和 --j 实现，所以在这
        里初始化大{小}一位.
         */

        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while(true){
            while (less(a[++i], v)){
                if (i == hi){
                    break;
                }
            }
            while (less(v, a[--j])){
                if (j == lo){
                    break;
                }
            }
            if (i >= j){
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
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
