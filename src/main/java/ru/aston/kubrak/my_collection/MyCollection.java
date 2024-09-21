package ru.aston.kubrak.my_collection;

public interface MyCollection<T> {

    boolean add (T t);
    T get (int i);
    boolean remove (int i);
    boolean addAll(MyCollection<? extends T> collection);
    int size();
}
