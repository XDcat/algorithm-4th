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


}
