package com.dustinredmond.fxcharts.utils;

public class Pair<K,V> {
    private K left;
    private V right;

    private Pair(K left, V right) {
        this.left = left;
        this.right = right;
    }

    public Pair<K,V> of(K left, V right) {
        return new Pair<>(left, right);
    }

    public K getLeft() {
        return left;
    }

    public void setLeft(K left) {
        this.left = left;
    }

    public V getRight() {
        return right;
    }

    public void setRight(V right) {
        this.right = right;
    }
}
