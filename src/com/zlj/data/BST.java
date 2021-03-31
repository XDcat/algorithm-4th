package com.zlj.data;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node{
       private Key key;  // 键
       private Value value;  // 值
       private Node left, right;
       private int N;  // 以该节点为根节点的数目

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
        } else {
            return root.N;
        }
    }
    
    public Value get(Key key){
        return get(root, key);
    }

    private Value get(Node root, Key key) {
         if (root == null){
             return null;
         } else {
             int cmp = key.compareTo(root.key);
             if (cmp < 0){
                 return get(root.left, key);
             } else if (cmp == 0) {
                 return root.value;
             } else {
                 return get(root.right, key);
             }
         }
    }
    
    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    private Node put(Node root, Key key, Value value) {
        /*
        使用递归的作用：
        1. 找到节点所在位置，创建或者更新
        2. 更新路径上的所有节点
         */
        // 创建新的节点
        if (root == null){
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0){
            root.left = put(root.left, key, value);
        } else if (cmp > 0){
            root.right = put(root.right, key, value);
        } else{
            // 更新节点
            root.value = value;
        }

        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }

    public Key min(){
        return min(root).key;
    }

    private Node min(Node root) {
        if (root.left == null){
            return root;
        } else {
            return min(root.left);
        }
    }

    public Key floor(Key key){
        Node x = floor(root, key);
        if (x == null){
            return null;
        } else{
            return x.key;
        }
    }

    private Node floor(Node root, Key key) {
        if (root == null) {
            return null;
        } else{
            int cmp = key.compareTo(root.key);
            if (cmp == 0){
                return root;
            } else if(cmp < 0){
                return floor(root.left, key);
            } else {
                Node t = floor(root.right, key);
                if (t != null){
                    return t;
                } else {
                    return root;
                }
            }
        }
    }

    public Key select(int k){
        return select(root, k).key;
    }

    private Node select(Node root, int k) {
        if (root == null){
            return null;
        }

        int t = size(root.left);
        if (t < k){
            return select(root.left, k);
        } else if (t == k){
            return root;
        } else{
            return select(root.right, k - t - 1);
        }
    }

    public int rank(Key key){
        return rank(root, key);
    }

    private int rank(Node root, Key key) {
        if (root == null) {
            return 0;
        } else {
            int cmp = key.compareTo(root.key);
            if (cmp < 0){
                return rank(root.left, key);
            } else if (cmp == 0){
                return size(root.left);
            } else{
                return size(root.left) + 1 + rank(root.right, key);
            }
        }
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node root) {
        if (root.left == null) {
            return root.right;
        }

        root.left = deleteMin(root);
        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }

    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node root, Key key) {
        if (root == null) {
            return null;
        } else{
            int cmp = key.compareTo(root.key);
            if (cmp < 0) {
                root.left = delete(root.left, key);
            } else if (cmp > 0){
                root.right = delete(root.right, key);
            } else {
                if (root.right == null){
                    return root.left;
                } else if (root.left == null){
                    return root.right;
                } else{
                    Node t = root;
                    root = min(root.right);
                    root.right = deleteMin(t.right);
                    root.left = t.left;
                }
            }
            root.N = size(root.left) + size(root.right) + 1;
            return root;
        }


    }
}
