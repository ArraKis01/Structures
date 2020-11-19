package de.svendsen.structures;

public class LinkedList<E> implements List<E> {

    private ListNode head;
    private int size;

    private class ListNode {
        private ListNode next;
        private E data;

    }

    @Override
    public void add(E element) {
        add(size(), element);
    }
    
    @Override
    public void add(int index, E element) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            ListNode node = new ListNode();
            node.data = element;
            node.next = head;
            head = node;
        } else {
            ListNode node = getNode(index-1);
            ListNode temp = new ListNode();
            temp.data = element;
            temp.next = node.next;
            node.next = temp;
        }
        size++;
    }

    @Override
    public E get(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            return getNode(index).data;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    // fix tail

    @Override
    public void remove(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        ListNode node = getNode(index - 1);

        if (node != null) {
            node.next = node.next.next;
        }

        if (index == 0) {
            head = head.next;
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("List: ");
        if (isEmpty()) {
            sb.append("[ ]");
        } else {
            for (int i = 0; i < size()-1; i++) {
                sb.append("[" + get(i) + "] ");
            }
            sb.append("[" + get(size()-1) + "]");
        }
        return sb.toString();
    }
    
    private ListNode getNode(int index) {
        ListNode node = head;
        if (index < 0) return null;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}
