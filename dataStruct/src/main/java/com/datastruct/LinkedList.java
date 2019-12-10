package com.datastruct;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<E> implements List<E> {
    private class Node{
        private E data;
        private Node next;  //指向下一个节点
        public Node(E data,Node next){
            this.data = data;
            this.next = next;
        }
        public Node(E data){
            this(data,null);
        }
    }
    private Node head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node p = head;
        while (p != null){
            if (p.data.equals(o)){
                return true;
            }
            p = p.next;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
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
        Node p = head;
        for (int i = 0; i < index; i++){
            p = p.next;
        }
        return p.data;
    }

    @Override
    public E set(int index, E element) {
        if (index >= size || index < 0){
            throw new IllegalArgumentException("数组下标越界");
        }
        Node p = head;
        for (int i = 0; i < index; i++){
            p = p.next;
        }
        p.data = element;
        return p.data;
    }

    @Override
    public void add(int index, E element) {
        if (index > size || index < 0){
            throw new IllegalArgumentException("数组下标越界");
        }
        if(index == 0){
            addFirst(element);
        }else if(index == size){
            addLast(element);
        }else{
            Node p = head;
            for (int i = 0; i < index; i++){    //i < index-1
                p = p.next;
            }
            Node after = p.next;
            Node newnode = new Node(element,after);
            p.next = newnode;
            size++;
        }
    }

    private void addFirst(E e){
        Node node = new Node(e,head);
        head = node;
        size++;
    }

    private void addLast(E e){
        //处理空列表
        Node node = new Node(e);
        if(head == null){
            head = node;
        }else{
            Node p = head;
            while(p.next != null){
                p = p.next;
            }
            // for (int i = 0; i < size; i++){
            //     p = p.next;
            // }
            p.next = node;
        }
        size++;
    }



    @Override
    public E remove(int index) {
        if (index > size || index < 0){
            throw new IllegalArgumentException("数组下标越界");
        }
        E data = null;
        if(index == 0){
            data = removeFirst(index);
        }else if(index == size){
            data = removeLast(index);
        }else{
            if(head == null){
                return null;
            }else{
                Node p = head;
                for(int i = 0;i < index -1; i++){
                    p = p.next; 
                }
                // Node after = p.next.next;
                // data = p.next.data;
                // p.next = after;
                Node tmp = p.next;
                p.next = tmp.next;
                data = tmp.data;
                size--;
            }
        }
        return data;
    }

    private E removeFirst(int index){
        if(head == null){
            return null;
        }else{
            Node data = head;
            head = head.next;
            size--;
            return data.data;
        }
    }

    private E removeLast(int index){
        if(head == null){
            return null;
        }else{
            Node p = head;
            // for(int i = 0;i < size -1; i++){
            //     p = p.next; 
            // }
            while(p.next.next != null){
                p = p.next;
            }
            Node data = p.next;
            p.next = null;
            size--;
            return data.data;
        }
    }

    @Override
    public int indexOf(Object o) {
        Node p = head;
        int result = -1;
        int i = 0;
        while (p != null){
            if (p.data.equals(o)){
                result = i;
                break;
            }
            i++;
            p = p.next;
        }
        return result;
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

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
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
