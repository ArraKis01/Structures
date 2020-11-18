package de.svendsen.structures;

public class LinkedList<E> implements List<E> {

    private ListNode head;

    private class ListNode {
        private ListNode next;
        private E data;

    }

    @Override
    public void add(E element) {
        if (isEmpty()) {
            head = new ListNode();
            head.data = element;
        } else {
            ListNode node = head;
            while (node.next != null) {
                node = node.next;
            }
            ListNode last = new ListNode();
            last.data = element;
            node.next = last;
        }
    }
    /**
     * TO DO
     */
    @Override
    public void add(int index, E element) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            ListNode node = head;
            for (int i = 0; i < index-1; i++) {
                node = node.next;
            }
            ListNode temp = new ListNode();
            temp.data = element;
            temp.next = node.next;
            node.next = temp;
        }
    }

    @Override
    public E get(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            ListNode node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node.data;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     *  TO DO
     */

    @Override
    public void remove(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            ListNode node = head;
            for (int i = 0; i < index-1; i++) {
                node = node.next;
            }
            
        }

    }

    @Override
    public int size() {
        ListNode node = head;
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }

    /**
     * TO DO
     */

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
