package ru.aston.kubrak.my_collection;

public class MyArrayList<T> implements MyCollection<T> {
    
    private T[] array;
    private static final int INITIAL_VOLUME = 10;
    private int size;

    public MyArrayList() {

        array = (T[]) new Object[INITIAL_VOLUME];
        size = 0;
    }

    public MyArrayList(int volume) {

        array = (T[]) new Object[volume];
        size = 0;
    }
    public MyArrayList(MyCollection<? extends T> collection) {

        this(collection.size()+10);
        this.addAll(collection);
    }

    
    @Override
    public boolean add(T element) {

        checkFill();
        array[size++] = element;
        return true;
    }

    @Override
    public T get(int index) {

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        return array[index];
    }


    public boolean set(T t, int index) {

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        array[index] = t;
        return true;
    }

    @Override
    public boolean remove(int index) {

        T[] tempArray = (T[]) new Object[array.length-1];
        System.arraycopy(array, 0, tempArray, 0, index);
        System.arraycopy(array, index+1, tempArray, index, array.length-index-1);
        array = tempArray;
        size--;
        return true;
    }

    @Override
    public boolean addAll(MyCollection<? extends T> myCollection) {

        for (int i = 0; i < myCollection.size(); i++) {
            this.add(myCollection.get(i));
        }
        return true;
    }


    @Override
    public int size(){

        return size;
    }

    private void checkFill(){

        if(array.length - size < 10){

            T[] arrayTemp = array;
            array = (T[]) new Object[arrayTemp.length * 2];
            System.arraycopy(arrayTemp, 0, array, 0, arrayTemp.length);
        }
    }


    public static <T extends Comparable<? super T>> void bubbleSort(MyArrayList<T> list) {

        boolean sorted;
        for (int i = 0; i < list.size() - 1; i++) {
            sorted = true;
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(list.get(j + 1), j);
                    list.set(temp, j + 1);
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            sb.append(",");
        }

        return sb.toString();
    }
}



