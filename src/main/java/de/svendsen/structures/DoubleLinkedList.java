package de.svendsen.structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<E> implements List<E> {

    private ListNode head;
    private ListNode tail;
    private int size;

    private class ListNode {
       
        private ListNode next;
        private ListNode prev;
        private E data;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public void add(int index, E element) {
        if (!(index > size() || index < 0)) {
            if (index == 0) {
                ListNode node = new ListNode();
                node.data = element;
                node.next = head;
                head.prev = node;
                head = node;

            } else if(index == size() - 1) {
                ListNode node = new ListNode();
                node.data = element;
                node.prev = tail;
                tail.next = node;
                tail = node;

            } else {
                ListNode node = getNode(index);
                ListNode temp = new ListNode();
                node.data = temp.data;
                temp.prev = node;
                temp.next = node.next;
                node.next = temp;
                node.data = element;
                getNode(index + 1).prev = temp;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }

        size++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void remove(int index) {
        // TODO Auto-generated method stub
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    public ListNode getNode(int index) {
        if (index < 0) 
            return null;
        if (index <= size() / 2) {
            ListNode node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            ListNode node = tail;
            for (int i = size()-1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            
            ListNode node = head;
            
            public boolean hasNext() {
                return node != null;
            }

            public E next() {
                if (node == null) throw new NoSuchElementException();
                E data = node.data;
                node = node.next;
                return data;
            }
        };
    }
    
}
