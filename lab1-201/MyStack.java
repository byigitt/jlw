public class MyStack<T> {
    DLinkedList<T> list;

    public MyStack() {
        list = new DLinkedList<T>();
    };

    public void push(T item) {
        list.addFirst(item);
    };

    public DLinkedList.Node<T> pop() {
        DLinkedList.Node<T> returning = list.removeLast();
        return returning;
    };
}
