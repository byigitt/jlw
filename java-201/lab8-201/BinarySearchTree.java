public class BinarySearchTree {
  public Node root;

  public class Node {
    String word;
    int count;
    Node left, right;

    public Node(String value) {
      this.word = value;
      this.count = 1;
      this.left = this.right = null;
    }
  }

  public void printFrequencies() {
    printFrequenciesRecursive(root);
  }

  private void printFrequenciesRecursive(Node root) {
    if (root != null) {
      printFrequenciesRecursive(root.left);
      System.out.println(root.word + ": " + root.count);
      printFrequenciesRecursive(root.right);
    }
  }

  public void insert(String word) {
    root = insertRecursive(root, word);
  }

  private Node insertRecursive(Node root, String word) {
    if (root == null) {
      return new Node(word);
    }

    int compare = word.compareTo(root.word);

    if (compare > 0) {
      root.right = insertRecursive(root.right, word);
    } else if (compare < 0) {
      root.left = insertRecursive(root.left, word);
    } else {
      root.count++;
    }

    return root;
  }
}
