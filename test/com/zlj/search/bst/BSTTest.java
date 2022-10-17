package com.zlj.search.bst;

import com.zlj.ds.TreePrinter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BSTTest {
    BST<Character, Integer> tree;
    String str;

    @Before
    public void setUp() throws Exception {
        this.tree = new BST<Character, Integer>();
        str = "ILOVEYOU";
        for (int i = 0; i < str.length(); i++) {
            this.tree.put(str.charAt(i), i);
        }
    }

    @Test
    public void print(){
        System.out.println(tree);

        TreePrinter.print(tree.getRoot());
    }
    @Test
    public void size() {
        System.out.println(tree.size());
    }

    @Test
    public void get() {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            System.out.println("" + c + ": " + tree.get(c));
        }
    }

    @Test
    public void min() {
        System.out.println("min is " + tree.min());
    }

    @Test
    public void max() {
        System.out.println("max is " + tree.max());
    }

    @Test
    public void floor() {
    }

    @Test
    public void select() {
    }

    @Test
    public void rank() {
    }

    @Test
    public void deleteMin() {
        System.out.println(tree);
        tree.deleteMin();
        System.out.println(tree);
    }

    @Test
    public void delete() {
    }

    @Test
    public void keys() {
    }

    @Test
    public void testKeys() {
    }
}