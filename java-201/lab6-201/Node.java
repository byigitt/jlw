public class Node<Type extends Comparable<Type>> {
  Type data;
  Node<Type> left, right;

  public Node(Type data) {
    this.data = data;
    this.left = this.right = null;
  }

  public Type getData() {
    return data;
  }

  public void setData(Type data) {
    this.data = data;
  }

  public Node<Type> getLeft() {
    return left;
  }

  public void setLeft(Node<Type> left) {
    this.left = left;
  }

  public Node<Type> getRight() {
    return right;
  }

  public void setRight(Node<Type> right) {
    this.right = right;
  }
}
