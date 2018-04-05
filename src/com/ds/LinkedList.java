package com.ds;

public interface LinkedList<X> {
    void add(X item);

    void insert(X item, int position);

    X remove();

    String toString();

    X get(int position);

    int find(X item);

    X removeAt(int position);

    int size();
}
