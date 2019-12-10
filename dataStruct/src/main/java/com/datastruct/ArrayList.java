package com.datastruct;

import java.util.*;

public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private E[] data;
    private int size;

    public ArrayList(int capacity){
        if (capacity < 0){
            throw new IllegalArgumentException("数组容量补不能为空");
        }
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0,len = size; i < len; i++){
            if (data[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return this.listIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0){
            throw new IllegalArgumentException("数组下标越界");
        }
        return data[index];
    }

    @Override
    public E set(int index, E element) {
        if (index >= size || index < 0){
            throw new IllegalArgumentException("数组下标越界");
        }
        data[index] = element;
        return data[index];
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size){
            throw new IllegalArgumentException("数组下标越界");
        }
        if (size == data.length){
            grow(2*data.length);
        }
        //TODO when the size is full,copy in the grow method
        for (int i = size-1;i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = element;
        size++;
    }

    private void grow(int  capacity) {
        /*E[] newdata = (E[]) new Object[capacity];
        for (int i = 0;i < data.length;i++){
            newdata[i] = data[i];
        }
        data =  newdata;
        */
        data = Arrays.copyOf(data,capacity);
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("数组下标越界");
        }
        E val = data[index];
        for (int i = index + 1; i < size; i++){
            data[i-1] = data[i];
        }
        //缩容
        if (size < data.length/2){
            grow(data.length/2);
        }
        size--;
        data[size]=null;
        return val;
    }

    @Override
    public int indexOf(Object o) {
        for (int i =0; i < size;i++){
            if (data[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100;i++){
            list.add(i,i);
        }
        for (int i = 0;i < 100; i++){
            System.out.println(i + ":" + list.get(i));
        }
        for (int i =0;i < 10;i+=5){
            System.out.println(i);
            list.remove(i);
        }
        for (int i = 0;i < list.size(); i++){
            System.out.println(i + ":" + list.get(i));
        }
    }
}
