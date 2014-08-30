package org.exor.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeMap;

public class SparseArray<E> implements List<E> {
    private final TreeMap<Integer, E> map = new TreeMap<Integer, E>();

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, E element) {
        map.put(Integer.valueOf(index), element);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsValue(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return map.values().containsAll(c);
    }

    @Override
    public E get(int index) {
        return map.get(Integer.valueOf(index));
    }

    @Override
    public int indexOf(Object o) {
        for(Integer index: map.keySet())
            if(map.get(index).equals(o))
                return index;
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return map.size() > 0;
    }

    @Override
    public Iterator<E> iterator() {
        return map.values().iterator();
    }

    @Override
    public int lastIndexOf(Object o) {
        for(Integer index: map.descendingKeySet())
            if(map.get(index).equals(o))
                return index;
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E remove(int index) {
        return map.remove(Integer.valueOf(index));
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E set(int index, E element) {
        return map.put(Integer.valueOf(index), element);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }
}
