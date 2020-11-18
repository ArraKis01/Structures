package de.svendsen.structures;

public interface List<E> {
    void add(E element);
    void add(int index, E element);
    E get(int index);
    boolean isEmpty();
    void remove(int index);
    int size();
    }
