package com.zlj.data;

import java.util.Iterator;
import java.util.Objects;

public class ResizingArrayStack<Item> implements Iterable {
    private Item[] items;
    private int N;

    public ResizingArrayStack() {
        items = (Item[]) new Object[1];
        N = 0;
    }
    public int size(){return N;}
    public boolean isEmpty(){return N == 0;}
    private void resize(int max){
        Item[] newItem = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            newItem[i] = items[i];
        }
        items = newItem;
    }
    public void push(Item item){
        if (N == items.length){
            resize(items.length * 2);
        }
        items[N++] = item;
    }

    public Item pop() {
        Item res = items[--N];
        items[N] = null;
        if (N < items.length / 4)
        {
            resize(items.length / 2);
        }
        return res;
    }

    @Override
    public Iterator iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator{
        private int i;

        public ReverseArrayIterator() {
            i = N;
        }

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Object next() {
            return items[--i];
        }
    }
}
