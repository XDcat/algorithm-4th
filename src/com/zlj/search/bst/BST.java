package com.zlj.search.bst;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

public class BST<Key extends Comparable<Key>, Value>{
    private Node root;
    private class Node{
        private Key key;
        private Value value;
        private int N;
        private Node left, right;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node root) {
        if (root == null){
            return 0;
        } else{
            return root.N;
        }
    }

    /**
     * Search
     */
    public Value get(Key key){
        return get(root, key);
    }

    private Value get(Node root, Key key) {
        if (root == null){
            return null;
        }

        int cmp = root.key.compareTo(key);
        if (cmp == 0){
            return root.value;
        } else if (cmp > 0){
            return get(root.left, key);
        } else{
            return get(root.right, key);
        }
    }

    /**
     * Update item if exit, else create a new node
     */
    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    private Node put(Node root, Key key, Value value) {
        if (root == null){
            return new Node(key, value, 1);
        }

        int cmp = root.key.compareTo(key);
        if (cmp == 0){
            root.value = value;
        } else if (cmp > 0){
            root.left = put(root.left, key, value);
        } else {
            root.right = put(root.right, key, value);
        }

        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }

    public Key min(){
        return min(root).key;
    }

    private Node min(Node root) {
        if (root.left == null) {
            return root;
        }
        return min(root.left);
    }

    public Key max(){
        return max(root).key;
    }

    private Node max(Node root) {
        if (root.right == null) {
            return root;
        }
        return max(root.right);
    }

    public Key floor(Key key){
        Node res = floor(root, key);
        if (res == null){
            return null;
        } else{
            return res.key;
        }
    }

    private Node floor(Node root, Key key) {
        if (root == null){
            return null;
        }

        int cmp = root.key.compareTo(key);
        if (cmp > 0){
            return floor(root.left, key);
        } else {
            Node tmp = floor(root.right, key);
            if (tmp == null){
                return root;
            } else {
                return tmp;
            }
        }
    }

    public Key select(int n){
       Node res = select(root, n);
       if (res == null){
           return null;
       } else {
           return res.key;
       }

    }

    private Node select(Node root, int n) {
        if (root == null){
            return null;
        }
        int cmp = size(root) - n;
        if (cmp == 0){
            return root;
        } else if(cmp > 0) {
            return select(root.left, n);
        } else {
            return select(root.right, size(root) - n - 1);
        }
    }

    public int rank(Key key){
        return rank(root, key);
    }

    private int rank(Node root, Key key) {
        if (root == null){
            return 0;
        }

        int cmp = root.key.compareTo(key);
        if (cmp == 0){
            return size(root.left);
        } else if (cmp < 0){
            return 1 + size(root.left) + rank(root.right, key);
        } else {
            return rank(root.left, key);
        }
    }

    public void deleteMin(){
        deleteMin(root);
    }

    private Node deleteMin(Node root) {
        if (root == null){
            return null;
        }
        if (root.left == null){
            return root.right;
        }

        root.left = deleteMin(root.left);
        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }

    public Node delete(Key key){
        return delete(root, key);
    }

    private Node delete(Node root, Key key) {
        if (root == null){
            return null;
        }

        int cmp = root.key.compareTo(key);

        if (cmp == 0){
            Node pre = root;
            if (pre.left == null){
                return pre.right;
            }
            if (pre.right == null){
                return pre.left;
            }
            root = min(pre.right);
            root.left = pre.left;
            root.right = deleteMin(root);
        } else if (cmp < 0){
            root.right = delete(root.right, key);
        } else {
            root.left = delete(root.left, key);
        }

        root.N = size(root.left ) + size(root.right) + 1;
        return root;
    }
}
