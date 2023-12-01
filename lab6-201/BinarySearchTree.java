public class BinarySearchTree<Type extends Comparable<Type>> {
  Node<Type> root;

  public BinarySearchTree() {
    this.root = null;
  }

  public void insert(Type data) {
    root = insertHelperRecursive(root, data);
  }

  private Node<Type> insertHelperRecursive(Node<Type> node, Type data) {
    if (node == null) {
      return new Node<>(data);
    }

    if (data.compareTo(node.getData()) < 0) {
      node.setLeft(insertHelperRecursive(node.getLeft(), data));
    } else if (data.compareTo(node.getData()) > 0) {
      node.setRight(insertHelperRecursive(node.getRight(), data));
    }

    return node;
  }

  public boolean search(Type data) {
    return searchHelperRecursive(root, data);
  }

  private boolean searchHelperRecursive(Node<Type> node, Type data) {
    if (node == null)
      return false;

    if (data.equals(node.getData())) {
      return true;
    } else if (data.compareTo(node.getData()) < 0) {
      return searchHelperRecursive(node.getLeft(), data);
    } else {
      return searchHelperRecursive(node.getRight(), data);
    }
  }

  public static <Type extends Comparable<Type>> boolean checkBST(BinarySearchTree<Type> tree) {
    return BSTHelperRecursive(tree.root, null, null);
  }

  private static <Type extends Comparable<Type>> boolean BSTHelperRecursive(Node<Type> node, Type min, Type max) {
    if (node == null) {
      return true;
    }

    if ((min != null && node.data.compareTo(min) <= 0) || (max != null && node.data.compareTo(max) >= 0)) {
      return false;
    }

    return BSTHelperRecursive(node.left, min, node.data) && BSTHelperRecursive(node.right, node.data, max);
  }

  public int countNodes() {
    return recursiveCountNodes(root);
  }

  private int recursiveCountNodes(Node<Type> node) {
    if (node == null) {
      return 0;
    }

    return 1 + recursiveCountNodes(node.getLeft()) + recursiveCountNodes(node.getRight());
  }
}
