public class DLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int size;
    
    public static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;
    };

    public void swapFirstSecond() {
        Node<T> first = head;
        Node<T> second = head.next;

        first.next = second.next;
        first.prev = second;

        second.prev = null;
        second.next = first;

        head = second;
    };

    public T remove(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++)
            current = head.next;
        
        Node<T> nextOfCurrent = current.next;
        Node<T> prevOfCurrent = current.prev;

        prevOfCurrent.next = nextOfCurrent;
        nextOfCurrent.prev = prevOfCurrent;

        size--;
        return current.data;
    };
    
    public Node<T> removeFirst() {
        Node<T> oldHead = head;
        head = head.next;
        head.prev = null;
        size--;
        return oldHead;
    };

    public Node<T> removeLast() {
        Node<T> oldTail = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        return oldTail;
    };

    public void duplicate(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++)
            current = head.next;

        Node<T> duplicate = new Node<T>();
        Node<T> nextOfCurrent = current.next;

        duplicate.next = nextOfCurrent;
        duplicate.prev = current;
        duplicate.data = current.data;
        current.next = duplicate;
        size++;
    };

    public void addFirst(T item) {
        Node<T> newItem = new Node<T>();
        newItem.data = item;

        if (head == null) {
            head = newItem;
        } else {
            newItem.next = head;
            head.prev = newItem;
            newItem.prev = null;
            head = newItem;
        };
        
        size++;
    };

    public void addLast(T item) {
        Node<T> newItem = new Node<T>();
        newItem.data = item;
        newItem.prev = tail;
        newItem.next = null;

        tail = newItem;
        size++;
    };

    public void printItems() {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}