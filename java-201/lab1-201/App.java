public class App {
    public static void main (String[] args) {
        DLinkedList<String> list = new DLinkedList<String>();

        list.addFirst("Hello!");
        list.addFirst("Test1");
        list.addFirst("Test2");
        list.addFirst("Test3");
        list.addFirst("Test4");
        list.printItems();
        System.out.println("\n");
        list.remove(3);
        list.printItems();
    };
}
