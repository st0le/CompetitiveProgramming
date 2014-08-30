package org.exor.utils;

import java.util.Map;
import java.util.TreeMap;

public class Sparse2DArray<V> {
    private final Map<Integer, Map<Integer, V>> map = new TreeMap<Integer, Map<Integer, V>>();
    private V defaultValue = null;

    public void setDefault(V v) {
        this.defaultValue = v;
    }

    public V get(int x, int y) {
        V v = map.get(x).get(y);
        return v == null ? defaultValue : v;
    }

    public void put(int x, int y, V v) {
        Map<Integer, V> row = map.get(x);
        if(row == null)
            row = new TreeMap<Integer, V>();
        row.put(y, v);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(Integer x: map.keySet())
            for(Integer y: map.get(x).keySet())
                sb.append(String.format("[%d,%d,%s],", x, y, map.get(x).get(y)));
        sb.append(']');
        return sb.toString();
    }
}