package cf.nebur.util;

import java.util.Iterator;

/**
 * @param <T>
 * @author Ruben O. Chiavone
 */
public class SinglyLinkedList<T> extends LinkedList<T> {

    private class Node {
        T data;
        Node next;
    }

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds item to the beginning of the list
     *
     * <ul>
     *     <li>Time complexity: O(1)</li>
     *     <li>Mutates structure: Yes</li>
     * </ul>
     *
     * @param item
     */
    @Override
    public void prepend(T item) {
        if (size == 0) {
            append(item);
        } else {
            Node node = new Node();
            node.data = item;
            node.next = null;

            Node oldHead = head;

            head = node;
            head.next = oldHead;

            size++;
        }
    }

    /**
     * Adds item to the end of the list
     *
     * <ul>
     *     <li>Time complexity: O(1)</li>
     *     <li>Mutates structure: Yes</li>
     * </ul>
     *
     * @param item
     */
    @Override
    public void append(T item) {
        Node node = new Node();
        node.data = item;
        node.next = null;

        if (size == 0) {
            head = node;
            tail = head;
        } else {
            Node oldTail = tail;
            oldTail.next = node;

            tail = node;
        }
        size++;
    }

    /**
     * Removes first instance of value from list
     *
     * <ul>
     *     <li>Time complexity: O(n)</li>
     *     <li>Mutates structure: Yes</li>
     * </ul>
     *
     * @param item
     */
    @Override
    public void delete(T item) {
        Node node = head;
        Node previous = null;
        while (true) {
            if (node.data.equals(item)) {
                if (node == head) {
                    head = head.next;
                    if (head == null) {
                        tail = null;
                    }
                } else if (previous != null) {
                    previous.next = node.next;
                    if (tail == node) {
                        tail = previous;
                    }
                }
                size--;
                return;
            } else if (node.next != null) {
                previous = node;
                node = node.next;
            } else {
                return;
            }
        }
    }

    /**
     * Returns the indexth node from the head, or {@code null}
     * if {@code index} is longer than the size of the list.
     *
     * @param index
     * @return the indexth node from the head, or {@code null}
     * if {@code index} is longer than the size of the list
     */
    private Node findNode(int index) {
        if (head == null) {
            return null;
        }
        Node node = head;
        int i = 0;
        while (i < index) {
            if (node.next != null) {
                node = node.next;
                i++;
            } else {
                return null;
            }
        }
        return node;
    }

    /**
     * Returns the first node with this value, or {@code null}
     * if {@code item} is not the list.
     *
     * @param item
     * @return the first node with this value, or {@code null}
     * if {@code item} is not the list.
     */
    private Node findNode(T item) {
        if (head == null) {
            return null;
        }
        Node node = head;
        while (true) {
            if (node.data.equals(item)) {
                return node;
            } else if (node.next != null) {
                node = node.next;
            } else {
                return null;
            }
        }
    }

    /**
     * Return the index of the item with the value of {@code item} otherwise
     * return {@code -1}
     *
     * <ul>
     *     <li>Time complexity: O(n)</li>
     *     <li>Mutates structure: No</li>
     * </ul>
     *
     * @param item
     * @return the index of the item with the value of {@code item} otherwise
     * return {@code -1}
     */
    @Override
    public int find(T item) {
        if (head == null) {
            return -1;
        }
        Node node = head;
        int i = 0;
        while (true) {
            if (node.data.equals(item)) {
                return i;
            } else if (node.next != null) {
                node = node.next;
                i++;
            } else {
                return -1;
            }
        }
    }

    /**
     * Returns the indexth value, or {@code null}
     * if {@code index} is longer than the size of the list.
     *
     * <ul>
     *     <li>Time complexity: O(index)</li>
     *     <li>Mutates structure: No</li>
     * </ul>
     *
     * @param index
     * @return the indexth value, or {@code null}
     * if {@code index} is longer than the size of the list
     */
    @Override
    public T get(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("index " + index + " but size is " + size);
        }
        Node node = findNode(index);
        return node == null ? null : node.data;
    }

    @Override
    public void set(T item, int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("index " + index + " but size is " + size);
        }
        Node node = findNode(index);
        if (node != null) {
            node.data = item;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                try {
                    return node.data;
                } finally {
                    node = node.next;
                }
            }
        };
    }
}
