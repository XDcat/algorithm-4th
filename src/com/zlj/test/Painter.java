package com.zlj.test;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;

import java.util.Scanner;

public class Painter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double xlo = scanner.nextDouble();
        double xhi = scanner.nextDouble();
        double ylo = scanner.nextDouble();
        double yhi = scanner.nextDouble();
        int T = scanner.nextInt();

        Interval1D xinterval = new Interval1D(xlo, xhi);
        Interval1D yinterval = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(xinterval, yinterval);
        box.draw();

        Counter c = new Counter("hits");
        for (int i = 0; i < T; i++) {
            double x = Math.random();
            double y = Math.random();
            Point2D p = new Point2D(x, y);
            if (box.contains(p)) c.increment();
            else p.draw();
        }
        System.out.println(c);
        System.out.println(box.area());
    }
}
