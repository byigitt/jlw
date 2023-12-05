public class Main {
  private static class Node {
    int data;
    Node next;

    public Node(int n) {
      this.data = n;
      this.next = null;
    }
  }

  public static void main(String[] args) {
    // Example 1
    Node head = new Node(9);
    head.next = new Node(9);
    head.next.next = new Node(9);

    head = add(head, 4);
    printList(head);

    // Example 2
    Node head2 = new Node(1);
    head2.next = new Node(0);

    head2 = add(head2, 4);
    printList(head2);

    // Example 3
    Node head3 = new Node(1);
    head3.next = new Node(9);
    head3.next.next = new Node(9);

    head3 = add(head3, 9);
    printList(head3);
  }

  public static void printList(Node node) {
    while (node != null) {
      System.out.print(node.data);

      if (node.next != null)
        System.out.print("->");

      node = node.next;
    }

    System.out.println();
  }

  private static Node add(Node head, int k) {
    int carry = carrier(head, k);

    if (carry > 0) {
      Node newHead = new Node(carry);
      newHead.next = head;

      return newHead;
    }

    return head;
  }

  private static int carrier(Node node, int k) {
    if (node == null)
      return k;

    int sum = node.data + carrier(node.next, k);
    node.data = sum % 10;

    return sum / 10;
  }
}