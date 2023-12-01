public class MyQueue<T> {
    DLinkedList<T> list;

    public MyQueue() {
        list = new DLinkedList<T>();
    };

    public void enqueue(T item) {
        list.addLast(item);
    };

    public DLinkedList.Node<T> dequeue() {
        DLinkedList.Node<T> returning = list.removeFirst();
        return returning;
    };
}